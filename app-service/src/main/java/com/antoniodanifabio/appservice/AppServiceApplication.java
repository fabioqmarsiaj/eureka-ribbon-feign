package com.antoniodanifabio.appservice;

import com.netflix.loadbalancer.Server;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class AppServiceApplication {

	static List<Server> hosts = Arrays.asList(
			new Server("www.google.com", 80),
			new Server("localhost", 9000),
			new Server("www.linkedin.com", 80));

	public static void main(String[] args) {
		SpringApplication.run(AppServiceApplication.class, args);
	}

}
