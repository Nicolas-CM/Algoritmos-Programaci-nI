package model;

import java.util.ArrayList;

public class Standard extends Consumer {

    private ArrayList<Playlist> playlists;

    public Standard(String nickName, String id) {
        super(nickName, id);
        this.playlists = new ArrayList<Playlist>();
    }

    public ArrayList<Playlist> getPlaylists() {
        return playlists;
    }

    public void setPlaylists(ArrayList<Playlist> playlists) {
        this.playlists = playlists;
    }

    /**
     * Description: Add a new Playlist a the User
     * 
     * @param playlist The new Playlist
     * @return boolean
     */
    public boolean addPlaylist(Playlist playlist) {
        return this.playlists.add(playlist);
    }

}
