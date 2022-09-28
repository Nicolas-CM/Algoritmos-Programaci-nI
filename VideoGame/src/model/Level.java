package model;

public class Level {

    private int id;
    private int nextLevel;
    private String difficult;

    public Level(int id, int nextLevel, String difficult) {
        this.id = id;
        this.nextLevel = nextLevel;
        this.difficult = difficult;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNextLevel() {
        return nextLevel;
    }

    public void setNextLevel(int nextLevel) {
        this.nextLevel = nextLevel;
    }

    public String getDifficult() {
        return difficult;
    }

    public void setDifficult(String difficult) {
        this.difficult = difficult;
    }

    
    
}
