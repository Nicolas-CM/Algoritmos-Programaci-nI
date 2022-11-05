package model;

import java.util.ArrayList;

public class Creator extends Producer {

    private ArrayList<Podcast> podcasts;

    public Creator(String nickName, String id, String name, String url) {
        super(nickName, id, name, url);
        this.podcasts = new ArrayList<Podcast>();
    }

    /**
     * Description: Add a new Podcast a the User
     * 
     * @param podcast The new Podcast
     * @return boolean
     */
    public boolean addPodcast(Podcast podcast) {
        return podcasts.add(podcast);
    }

}
