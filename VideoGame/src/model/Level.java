package model;

public class Level {

    private int id;
    private int nextLevel;
    private Difficult difficult;

    public Level(int id, int nextLevel) {
        this.id = id;
        this.nextLevel = nextLevel;
        this.difficult = Difficult.values()[0];
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

    public Difficult getDifficult() {
        return difficult;
    }

    public void setDifficult(Difficult difficult) {
        this.difficult = difficult;
    }

    
    
}
