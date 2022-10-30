package model;

import java.time.LocalDate;

public abstract class User {
    
    private String nickName;
    private String id;
    private LocalDate bondingDate;

    public User(String nickName, String id) {
        super();
        this.nickName = nickName;
        this.id = id;
        this.bondingDate = LocalDate.now();
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public LocalDate getBondingDate() {
        return bondingDate;
    }

    public void setBondingDate(LocalDate bondingDate) {
        this.bondingDate = bondingDate;
    }

    
}
