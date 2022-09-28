package model;

public class Player {
    
    private String nickName;
    private String name;
    private int score;
    private int lifeNumber;

    public Player(String nickName, String name, int score, int lifeNumber) {
        this.nickName = nickName;
        this.name = name;
        this.score = score;
        this.lifeNumber = lifeNumber;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getLifeNumber() {
        return lifeNumber;
    }

    public void setLifeNumber(int lifeNumber) {
        this.lifeNumber = lifeNumber;
    }

    
}
