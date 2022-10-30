package model;

import java.time.LocalTime;

public abstract class Audio {
    
    private String name;
    private String url;
    private LocalTime duration;
    private int numberReproduction;

    public Audio(String name, String url, LocalTime duration) {
        this.name = name;
        this.url = url;
        this.duration = duration;
        this.numberReproduction = 0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public LocalTime getDuration() {
        return duration;
    }

    public void setDuration(LocalTime duration) {
        this.duration = duration;
    }

    public int getNumberReproduction() {
        return numberReproduction;
    }

    public void setNumberReproduction(int numberReproduction) {
        this.numberReproduction = numberReproduction;
    }
}
