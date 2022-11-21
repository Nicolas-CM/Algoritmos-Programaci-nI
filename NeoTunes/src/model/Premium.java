package model;

import java.util.ArrayList;

public class Premium extends Consumer {

    private ArrayList<Playlist> playlist;
    private ArrayList<Invoice> invoices;

    public Premium(String nickName, String id) {
        super(nickName, id);
        this.playlist = new ArrayList<Playlist>();
        this.invoices = new ArrayList<Invoice>();
    }

    public ArrayList<Invoice> getInvoices() {
        return invoices;
    }

    public void setInvoices(ArrayList<Invoice> invoices) {
        this.invoices = invoices;
    }

    public ArrayList<Playlist> getPlaylist() {
        return playlist;
    }

    public void setPlaylist(ArrayList<Playlist> playlist) {
        this.playlist = playlist;
    }

    public boolean addInvoice(Invoice invoice){
        return this.invoices.add(invoice);
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
