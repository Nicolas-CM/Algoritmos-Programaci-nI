package model;

import java.util.ArrayList;

public class NeoTunesController {

    private ArrayList<User> users;

    public NeoTunesController() {
        this.users = new ArrayList<User>();
    }

    public ArrayList<User> getUsers() {
        return users;
    }

    public void setUsers(ArrayList<User> users) {
        this.users = users;
    }
    
    
}
