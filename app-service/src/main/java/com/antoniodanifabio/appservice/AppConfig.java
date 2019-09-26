package com.antoniodanifabio.appservice;

import java.net.URL;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.netflix.loadbalancer.BaseLoadBalancer;
import com.netflix.loadbalancer.LoadBalancerBuilder;
import com.netflix.loadbalancer.Server;
import com.netflix.loadbalancer.reactive.LoadBalancerCommand;
import com.netflix.loadbalancer.reactive.ServerOperation;

import rx.Observable;

@Configuration
public class AppConfig {
	
	@Bean
	public String baseLoadBalancer(@Value("${host.name}") String hostName,
			@Value("${instance1.song}") Integer portInstanceSong1,
			@Value("${instance2.song}") Integer portInstanceSong2) {
		List<Server> hosts = Arrays.asList(
	            new Server(hostName, portInstanceSong1),
	            new Server(hostName, portInstanceSong2));
		BaseLoadBalancer baseLoadBalancer = LoadBalancerBuilder.newBuilder()
	            .buildFixedServerListLoadBalancer(hosts);
        return LoadBalancerCommand.<String>builder()
                .withLoadBalancer(baseLoadBalancer)
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
