package model;

import java.util.ArrayList;

public class Playlist {

    private String name;
    private String autoId;
    private ArrayList<Audio> audios;

    public Playlist(String name) {
        this.name = name;
        this.autoId = "";
        this.audios = new ArrayList<Audio>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAutoId() {
        return autoId;
    }

    public void setAutoId(String autoId) {
        this.autoId = autoId;
    }

    public ArrayList<Audio> getAudios() {
        return audios;
    }

    public void setAudios(ArrayList<Audio> audios) {
        this.audios = audios;
    }

    /**
     * Description: Add a new Audio to the Playlist
     * 
     * @param audio The new Audio
     * @return boolean
     */
    public boolean addAudio(Audio audio) {
        return audios.add(audio);
    }

    /**
     * Description: Delete an Audio of the Playlist
     * 
     * @param numberSong The index of the Audio for delete
     * @return boolean
     */
    public boolean deleteAudio(int numberSong) {
        audios.remove(numberSong);
        return true;
    }
}
