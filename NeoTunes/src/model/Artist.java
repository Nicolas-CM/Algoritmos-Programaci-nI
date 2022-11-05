package model;

import java.util.ArrayList;

public class Artist extends Producer {

    private ArrayList<Song> songs;

    public Artist(String nickName, String id, String name, String url) {
        super(nickName, id, name, url);
        this.songs = new ArrayList<Song>();
    }

    /**
     * Description: Add a new Song a the User
     * 
     * @param song The new Song
     * @return boolean
     */
    public boolean addSong(Song song) {
        return songs.add(song);
    }

}
