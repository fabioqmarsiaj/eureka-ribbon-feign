package com.antoniodanifabio.appservice.discovery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class SpringBootApplicationStartup implements ApplicationListener<ApplicationReadyEvent> {

    @Autowired
    private EurekaOperations eurekaOperations;

    @Override
    public void onApplicationEvent(final ApplicationReadyEvent event) {
        eurekaOperations.register();
    }
    
}
