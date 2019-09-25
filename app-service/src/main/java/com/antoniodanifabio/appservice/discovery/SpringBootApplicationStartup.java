package com.antoniodanifabio.appservice.discovery;

import java.io.IOException;

import org.codehaus.jettison.json.JSONException;
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
        try {
			eurekaOperations.register();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
}
