package model;

public class Player {
    
    private String nickName;
    private String name;
    private int score;
    private int lifeNumber;
    private Level level;

    public Player(String nickName, String name, Level level) {
        this.nickName = nickName;
        this.name = name;
        this.score = 10;
        this.lifeNumber = 5;
        this.level = level;
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
    public Level getLevel() {
        return level;
    }
    public void setLevel(Level level) {
        this.level = level;
    }

    @Override
    public String toString() {
        return "\n      Player info: "
        + "\n       NickName: " + this.nickName
        + "\n       Name: " + this.name
        + "\n       score : " + this.score
        + "\n       Life Number : " + this.lifeNumber
        + "\n       Level: " + this.level.getId();
    }
    

    

    
}
