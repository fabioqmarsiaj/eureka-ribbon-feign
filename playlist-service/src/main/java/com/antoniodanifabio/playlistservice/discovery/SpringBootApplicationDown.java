package com.antoniodanifabio.playlistservice.discovery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextClosedEvent;
import org.springframework.stereotype.Component;

@Component
public class SpringBootApplicationDown implements ApplicationListener<ContextClosedEvent> {

    @Autowired
    private EurekaOperations eurekaOperations;

    @Override
    public void onApplicationEvent(ContextClosedEvent event) {
        eurekaOperations.delete();
    }
}
