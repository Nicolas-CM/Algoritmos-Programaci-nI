package model;

public class VideoGameController {

    private Player[] players;
    private Level[] levels;
    private Treasure[] treasures;
    private Enemy[] enemies;
    private int maxX;
    private int maxY;

    public VideoGameController() {

        this.players = new Player[20];
        this.levels = new Level[10];
        this.treasures = new Treasure[50];
        this.enemies = new Enemy[25];
    }

    public Player[] getPlayers() {
        return players;
    }

    public void setPlayers(Player[] players) {
        this.players = players;
    }

    public Level[] getLevels() {
        return levels;
    }

    public void setLevels(Level[] levels) {
        this.levels = levels;
    }

    public Treasure[] getTreasures() {
        return treasures;
    }

    public void setTreasures(Treasure[] treasures) {
        this.treasures = treasures;
    }

    public Enemy[] getEnemies() {
        return enemies;
    }

    public void setEnemies(Enemy[] enemies) {
        this.enemies = enemies;
    }

    public int getMaxX() {
        return maxX;
    }

    public void setMaxX(int maxX) {
        this.maxX = maxX;
    }

    public int getMaxY() {
        return maxY;
    }

    public void setMaxY(int maxY) {
        this.maxY = maxY;
    }

    //Function--------------------------------------------------------------------


    public String toStringLevel(){
        Difficult difficult[] = Difficult.values();
        String msg="";
        for (int i = 0; i < difficult.length; i++) {
            msg+=difficult[i];
        } 
        return msg;
    }

    public boolean registerLevel(int id, int nextLevel){
        Level newLevel = new Level(id, nextLevel);
        if (levels[id] == null) {
            levels[id] = newLevel;
            return true;
        }
        return false;
    }

    public int getNextLevel(int id){
        return levels[id].getNextLevel();
    }

}
