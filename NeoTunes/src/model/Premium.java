package model;

import java.util.ArrayList;

public class Premium extends Consumer {

    private ArrayList<Playlist> playlist;

    public Premium(String nickName, String id) {
        super(nickName, id);
        this.playlist = new ArrayList<Playlist>();
    }

    public ArrayList<Playlist> getPlaylist() {
        return playlist;
    }

    public void setPlaylist(ArrayList<Playlist> playlist) {
        this.playlist = playlist;
    }

    /**
     * Description: Add a new Playlist a the User
     * 
     * @param playlist The new Playlist
     * @return boolean
     */
    public boolean addPlaylist(Playlist playlist) {
        return this.playlist.add(playlist);
    }

}
