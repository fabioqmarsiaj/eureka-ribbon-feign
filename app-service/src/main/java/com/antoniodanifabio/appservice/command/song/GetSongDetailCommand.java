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
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Arrays;
import java.util.List;


public class GetSongDetailCommand extends HystrixCommand<Song> {

    private static List<Server> hosts = Arrays.asList(
            new Server("localhost", 8083),
            new Server("localhost", 8084));

    private static BaseLoadBalancer loadBalancer = LoadBalancerBuilder.newBuilder()
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

    private static String callFeign(BaseLoadBalancer loadBalancer) {

        ServerOperation<String> submitToServer = server -> {
            URL url;
            try {
                url = new URL("http://" + server.getHost() + ":" + server.getPort() + "/");
                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                return Observable.just(conn.getResponseMessage());
            } catch (Exception e) {
                return Observable.error(e);
            }
        };

        return LoadBalancerCommand.<String>builder()
                .withLoadBalancer(loadBalancer)
                .build()
                .submit(submitToServer)
                .toBlocking()
                .first();
    }
}
