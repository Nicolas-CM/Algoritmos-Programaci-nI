package model;

import java.time.LocalDate;

public class Invoice {
    
    private Song song;
    private LocalDate buyDate;

    public Invoice(Song song) {
        this.song = song;
        this.buyDate = LocalDate.now();
    }

    public Song getSong() {
        return song;
    }

    public void setSong(Song song) {
        this.song = song;
    }

    public LocalDate getBuyDate() {
        return buyDate;
    }

    public void setBuyDate(LocalDate buyDate) {
        this.buyDate = buyDate;
    }

    @Override
    public String toString() {
        return "Invoice [song=" + song.getName() + ", buyDate=" + buyDate + "]";
    }

    
}
