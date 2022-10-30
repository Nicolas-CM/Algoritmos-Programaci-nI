package model;

import java.time.LocalTime;

public abstract class Consumer extends User{
    
    private LocalTime reproductionTime;
    private int[] mostListenedGenre;
    private int[] mostListenedArtist;
    private int[] mostListenedCreator;

    public Consumer(String nickName, String id) {
        super(nickName, id);
        this.reproductionTime = LocalTime.of(0, 0, 0);
        this.mostListenedGenre = new int[4];
        this.mostListenedArtist = new int[15];
        this.mostListenedCreator = new int[15];
    }

    public LocalTime getReproductionTime() {
        return reproductionTime;
    }

    public void setReproductionTime(LocalTime reproductionTime) {
        this.reproductionTime = reproductionTime;
    }

    public int[] getMostListenedGenre() {
        return mostListenedGenre;
    }

    public void setMostListenedGenre(int[] mostListenedGenre) {
        this.mostListenedGenre = mostListenedGenre;
    }

    public int[] getMostListenedArtist() {
        return mostListenedArtist;
    }

    public void setMostListenedArtist(int[] mostListenedArtist) {
        this.mostListenedArtist = mostListenedArtist;
    }

    public int[] getMostListenedCreator() {
        return mostListenedCreator;
    }

    public void setMostListenedCreator(int[] mostListenedCreator) {
        this.mostListenedCreator = mostListenedCreator;
    }

}
