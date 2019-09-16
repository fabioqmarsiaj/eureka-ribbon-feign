package com.antoniodanifabio.playlistservice.service;

import com.antoniodanifabio.playlistservice.domain.Playlist;
import com.antoniodanifabio.playlistservice.repository.PlaylistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PlaylistService {

    @Autowired
    private PlaylistRepository repository;

    public void insertPlaylist(String name){
        Playlist playlist = new Playlist(name);
        repository.insert(playlist);
    }

    public List<Playlist> getPlaylists(){
        return repository.findAll();
    }

    public void insertSong(String playlistId, String songId) {
        Playlist playlist = findPlaylist(playlistId);
        playlist.getSongIds().add(songId);
        repository.save(playlist);
    }

    public Playlist findPlaylist(String id) {
      return repository.findOne(id);
    }
}
