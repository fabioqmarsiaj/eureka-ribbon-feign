package com.antoniodanifabio.appservice.configuration;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.web.client.RestTemplate;

import com.antoniodanifabio.appservice.command.playlists.AllPlaylists;
import com.antoniodanifabio.appservice.command.playlists.InsertPlaylist;
import com.antoniodanifabio.appservice.command.playlists.InsertSongPlaylist;
import com.antoniodanifabio.appservice.command.playlists.PlayPlaylist;
import com.antoniodanifabio.appservice.discovery.EurekaServiceDiscovery;

@Configuration
@ComponentScan("com.antoniodanifabio.appservice")
public class AppConfig {
	
	@Autowired
	private Environment environment;
	
	@PostConstruct
	private void registerEureka() {
		eurekaServiceDiscovery().register("localhost", environment.getProperty("server.port"), environment.getProperty("spring.application.name"));
	}
	
	@PreDestroy
	private void excludeEureka() {
		eurekaServiceDiscovery().exclude("localhost", environment.getProperty("server.port"), environment.getProperty("spring.application.name"));
	}
	
	@Bean
	public EurekaServiceDiscovery eurekaServiceDiscovery() {
		return new EurekaServiceDiscovery();
	}
	
	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
	
	@Bean
	public PlayPlaylist playPlaylistCommand() {
		return new PlayPlaylist();
	}
	
	@Bean
	public AllPlaylists allPlaylistsCommand() {
		return new AllPlaylists();
	}
	
	@Bean
	public InsertPlaylist insertPlaylistCommand() {
		return new InsertPlaylist();
	}
	
	@Bean
	public InsertSongPlaylist insertSongPlaylistCommand() {
		return new InsertSongPlaylist();
	}
	
}
