package com.antoniodanifabio.appservice.configuration;

import com.netflix.loadbalancer.BaseLoadBalancer;
import com.netflix.loadbalancer.LoadBalancerBuilder;
import com.netflix.loadbalancer.Server;
import com.netflix.ribbon.ClientOptions;
import com.netflix.ribbon.Ribbon;
import com.netflix.ribbon.http.HttpRequestTemplate;
import com.netflix.ribbon.http.HttpResourceGroup;
import io.netty.buffer.ByteBuf;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;


@Configuration
public class AppConfiguration {

    private final static String LIST_OF_HOSTS = "localhost:8083, localhost:8084";

    @SuppressWarnings("unchecked")
    @Bean
    @Scope("singleton")
    public void ribbon(){



    }


}
