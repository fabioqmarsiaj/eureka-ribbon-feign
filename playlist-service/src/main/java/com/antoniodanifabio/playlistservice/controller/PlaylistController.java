package com.antoniodanifabio.playlistservice.controller;

import com.antoniodanifabio.playlistservice.commands.FindAllCommand;
import com.antoniodanifabio.playlistservice.commands.FindByIdCommand;
import com.antoniodanifabio.playlistservice.commands.SavePlaylistCommand;
import com.antoniodanifabio.playlistservice.commands.SaveSongCommand;
import com.antoniodanifabio.playlistservice.domain.Playlist;
import com.antoniodanifabio.playlistservice.repository.PlaylistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
public class PlaylistController{

    @Autowired
    private PlaylistRepository repository;

    @PostMapping("/playlists")
    public ResponseEntity<Playlist> insertPlaylist(@RequestBody Playlist newPlaylist) {
        String aaa = "{\n" +
                "   \"instance\":{\n" +
                "      \"hostName\":\"app-service\",\n" +
                "      \"app\":\"app-service\",\n" +
                "      \"vipAddress\":\"com.localhost\",\n" +
                "      \"secureVipAddress\":\"com.localhost\",\n" +
                "      \"ipAddr\":\"localhost\",\n" +
                "      \"status\":\"STARTING\",\n" +
                "      \"port\":{\n" +
                "         \"$\":\"8081\",\n" +
                "         \"@enabled\":\"true\"\n" +
                "      },\n" +
                "      \"securePort\":{\n" +
                "         \"$\":\"8431\",\n" +
                "         \"@enabled\":\"true\"\n" +
                "      },\n" +
                "      \"healthCheckUrl\":\"http://localhost:8081/healthcheck\",\n" +
                "      \"statusPageUrl\":\"http://localhost:8081/status\",\n" +
                "      \"homePageUrl\":\"http://localhost:8081\",\n" +
                "      \"dataCenterInfo\":{\n" +
                "         \"@class\":\"com.netflix.appinfo.InstanceInfo$DefaultDataCenterInfo\",\n" +
                "         \"name\":\"MyOwn\"\n" +
                "      }\n" +
                "   }\n" +
                "}";
        return ResponseEntity.status(HttpStatus.OK).body(new SavePlaylistCommand(repository, newPlaylist).execute());
    }

    @RequestMapping(value = "/playlists", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<List<Playlist>> getPlaylists(){
        return ResponseEntity.status(HttpStatus.OK).body(new FindAllCommand(repository).execute());
    }

    @PostMapping("/playlists/{playlistId}")
    public ResponseEntity<Playlist> insertSong(@RequestBody String songId, @PathVariable String playlistId){
        return ResponseEntity.status(HttpStatus.OK).body(new SaveSongCommand(repository, songId, playlistId).execute());
    }

    @GetMapping("/playlists/{playlistId}")
    public ResponseEntity<Optional<Playlist>> findPlaylistById(@PathVariable String playlistId){
        return ResponseEntity.status(HttpStatus.OK).body(new FindByIdCommand(repository, playlistId).execute());
    }
}

