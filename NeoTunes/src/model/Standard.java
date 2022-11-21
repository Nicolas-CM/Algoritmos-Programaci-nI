package model;

import java.util.ArrayList;

public class Standard extends Consumer {

    private ArrayList<Playlist> playlists;
    private ArrayList<Invoice> invoices;

    public Standard(String nickName, String id) {
        super(nickName, id);
        this.playlists = new ArrayList<Playlist>();
        this.invoices = new ArrayList<Invoice>();
    }

    public ArrayList<Invoice> getInvoices() {
        return invoices;
    }

    public void setInvoices(ArrayList<Invoice> invoices) {
        this.invoices = invoices;
    }

    public ArrayList<Playlist> getPlaylists() {
        return playlists;
    }

    public void setPlaylists(ArrayList<Playlist> playlists) {
        this.playlists = playlists;
    }

    public boolean addInvoice(Invoice invoice){
        return this.invoices.add(invoice);
    }

    /**
     * Description: Add a new Playlist to the User
     * 
     * @param playlist The new Playlist
     * @return boolean
     */
    public boolean addPlaylist(Playlist playlist) {
        return this.playlists.add(playlist);
    }

}
