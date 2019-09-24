package com.antoniodanifabio.appservice.command.song;

import com.antoniodanifabio.appservice.domain.Song;
import com.antoniodanifabio.appservice.operation.SongOperation;
import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import com.netflix.loadbalancer.BaseLoadBalancer;
import com.netflix.loadbalancer.LoadBalancerBuilder;
import com.netflix.loadbalancer.Server;
import com.netflix.loadbalancer.reactive.LoadBalancerCommand;
import com.netflix.loadbalancer.reactive.ServerOperation;
import feign.Feign;
import feign.gson.GsonDecoder;
import rx.Observable;
import java.net.URL;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;

public class GetSongDetailCommand extends HystrixCommand<Song> {

	@Value("${host.name}")
    private String hostName;
	
	@Value("${song1.port}")
    private Integer portInstanceSong1;
	
	@Value("${song2.port}")
    private Integer portInstanceSong2;
	
    private List<Server> hosts = Arrays.asList(
            new Server(hostName, portInstanceSong1),
            new Server(hostName, portInstanceSong1));

    private BaseLoadBalancer loadBalancer = LoadBalancerBuilder.newBuilder()
            .buildFixedServerListLoadBalancer(hosts);

    private SongOperation songOperation = Feign.builder()
            .decoder(new GsonDecoder())
            .target(SongOperation.class, callFeign(loadBalancer));

    private String songId;

    public GetSongDetailCommand(String songId) {
        super(HystrixCommandGroupKey.Factory.asKey("GetSongDetail"));
        this.songId = songId;
    }

    @Override
    protected Song run() throws Exception {
        return songOperation.searchById(songId);
    }

    @Override
    protected Song getFallback() {
        return new Song(null, "Default");
    }

    private String callFeign(BaseLoadBalancer loadBalancer) {
        return LoadBalancerCommand.<String>builder()
                .withLoadBalancer(loadBalancer)
                .build()
                .submit(
                        new ServerOperation<String>() {
                            @Override
                            public Observable<String> call(Server server) {
                                URL url;
                                try {
                                    url = new URL("http://" + server.getHost() + ":" + server.getPort());
                                    return Observable.just(url.toString());
                                } catch (Exception e) {
                                    return Observable.error(e);
                                }
                            }
                        }
                )
                .toBlocking()
                .first();
    }
}
