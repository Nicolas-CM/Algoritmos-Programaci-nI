package model;

public class Level {

    private int id;
    private int nextLevel;
    private Difficult difficult;
    private Enemy[] enemiesList;
    private Treasure[] treasuresList;

    public Level(int id, int nextLevel) {
        this.id = id;
        this.nextLevel = nextLevel;
        this.difficult = Difficult.values()[0];
        this.enemiesList = new Enemy[25];
        this.treasuresList = new Treasure[50];
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

    public void setDifficult(int difficult) {
        this.difficult = Difficult.values()[difficult];
    }

    
    public Enemy[] getEnemiesList() {
        return enemiesList;
    }

    public void setEnemiesList(Enemy[] enemiesList) {
        this.enemiesList = enemiesList;
    }
    
    public Treasure[] getTrasuresList() {
        return treasuresList;
    }

    public void setTrasuresList(Treasure[] trasuresList) {
        this.treasuresList = trasuresList;
    }

    @Override
    public String toString() {
        String enemiesRegistered = "";
        for (int i = 0; i < enemiesList.length; i++) {
            if (enemiesList[i] != null) {
                enemiesRegistered += enemiesList[i].toString() + ",";
            }
        }
        String treasuresRegistered = "";
        for (int i = 0; i < treasuresList.length; i++) {
            if (treasuresList[i] != null) {
                treasuresRegistered += treasuresList[i].toString() + ",";
            }
        }
        return "\nLevel info: "
        + "\n    Id: " + this.id
        + "\n    NextLevel: " + this.nextLevel
        + "\n    Difficult: " + this.difficult
        + "\n\n    Enemies: --------------------\n" + enemiesRegistered
        + "\n\n    Treasures: --------------------\n" + treasuresRegistered;
    }

    /**
     * Description: This allows add a enemy
     * @param newEnemy The new Enemy
     * @return boolean
     */
    public boolean addEnemy(Enemy newEnemy){
        for (int i = 0; i < enemiesList.length; i++) {
            if (enemiesList[i]==null) {
                enemiesList[i] = newEnemy;
                i = enemiesList.length;
                return true;
            } 
        }
        return false;
    }
    /**
     * Description: This allows add a treasure
     * @param newTreasure The new Treasure
     * @return boolean
     */
    public boolean addTreasure(Treasure newTreasure){
        
        for (int i = 0; i < treasuresList.length; i++) {
            if (treasuresList[i]==null) {
                treasuresList[i] = newTreasure;
                i = treasuresList.length;
                return true;
            } 
        }
        return false;
    }
    /**
     * Description: This allows review if is full the list of enemies
     * @return boolean
     */
    public boolean reviewFullEnemies(){
        if (enemiesList[enemiesList.length-1]==null) {
            return false;
        } else {
            return true;
        }
    }
    /**
     * Description: This allows review if is full the list of treasures
     * @return boolean
     */
    public boolean reviewFullTreasures(){
        if (treasuresList[treasuresList.length-1]==null) {
            return false;
        } else {
            return true;
        }
    }

    /**
     * Description: This allows get the total points of all the enemies of level
     * @return int This is the total of points
     */
    public int totalPointsEnemies(){
        int totalPointsEnemies = 0;
        for (int i = 0; i < enemiesList.length; i++) {
            if (enemiesList[i]!=null) {
                totalPointsEnemies += enemiesList[i].getincreasingPoints();
            }
        }
        return totalPointsEnemies;
    }

    /**
     * Description: This allows get the total points of all the diamonds of level
     * @return int This is the total of points
     */
    public int totalPointsTreasures(){
        int totalPointsTreasures = 0;
        for (int i = 0; i < treasuresList.length; i++) {
            if (treasuresList[i]!=null) {
                totalPointsTreasures += treasuresList[i].getPoints();
            }
        }
        return totalPointsTreasures;
    }
}
