package com.antoniodanifabio.appservice.discovery;

import java.net.URL;
import java.util.Arrays;
import java.util.List;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import com.antoniodanifabio.appservice.operation.SongOperation;
import com.netflix.loadbalancer.BaseLoadBalancer;
import com.netflix.loadbalancer.LoadBalancerBuilder;
import com.netflix.loadbalancer.Server;
import com.netflix.loadbalancer.reactive.LoadBalancerCommand;
import com.netflix.loadbalancer.reactive.ServerOperation;
import feign.Feign;
import feign.gson.GsonDecoder;
import rx.Observable;

@Component
public class SongFeign {
	
	@Value("${host.name}")
    private String hostName;
	@Value("${instance1.song}")
    private Integer portInstanceSong1;
	@Value("${instance2.song}")
    private Integer portInstanceSong2;
	
	 private List<Server> hosts = Arrays.asList(
	            new Server(hostName, portInstanceSong1),
	            new Server(hostName, portInstanceSong1));

    private BaseLoadBalancer loadBalancer = LoadBalancerBuilder.newBuilder()
            .buildFixedServerListLoadBalancer(hosts);
	
	public SongOperation getFeignBuilder() {
		return Feign.builder()
	            .decoder(new GsonDecoder())
	            .target(SongOperation.class, callFeign(loadBalancer));
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
