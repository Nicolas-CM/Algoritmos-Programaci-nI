package model;

import java.util.Random;

public class VideoGameController {

    static Random random = new Random();
    private Player[] players;
    private Level[] levels;
    private Treasure[] treasures;
    private Enemy[] enemies;
    private int maxX;
    private int maxY;

    public VideoGameController() {

        this.players = new Player[20];
        this.levels = new Level[10];
        this.treasures = new Treasure[500];
        this.enemies = new Enemy[250];
        this.maxX = 100;
        this.maxY = 100;
    }

    public Player[] getPlayers() {
        return players;
    }

    public void setPlayers(Player[] players) {
        this.players = players;
    }

    public Level[]  getLevels() {
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

    // Function--------------------------------------------------------------------

    /**
     * Description: This allows get the score for pass to the next level of a level
     * select
     * 
     * @param id This is the id of level selected
     * @return int This is the score
     */
    public int getNextLevel(int id) {
        return levels[id].getNextLevel();
    }

    /**
     * Description: This allows get the name of type Enemy with a int
     * @param typeEnemy This int is the id of the list of the class
     * @return typeEnemy This is the name
     */
    public TypeEnemy getTypeEnemy(int typeEnemy) {
        return TypeEnemy.values()[typeEnemy];
    }

    /**
     * Description: This allows show the type of enemies
     * 
     * @return String of a list
     */
    public String toStringEnemy() {
        TypeEnemy typenemies[] = TypeEnemy.values();
        String msg = "Type of enemies: ";
        for (int i = 0; i < typenemies.length; i++) {
            msg += "\n " + i + ") " + typenemies[i];
        }
        return msg;
    }

    /**
     * Description: This allows generate a position random X
     * 
     * @return the value de X
     */
    public int generatePositionX() {
        return random.nextInt(this.maxX);
    }

    /**
     * Description: This allows generate a position random Y
     * 
     * @return the value de Y
     */
    public int generatePositionY() {
        return random.nextInt(this.maxY);
    }

    /**
     * Description: This allows know if there is space
     * 
     * @return boolean true (full), false (there is space)
     */
    public boolean itsFullPlayers() {
        if (players[players.length - 1] == null) {
            return false;
        } else {
            return true;
        }
    }

    /**
     * Description: This allows know if there is space
     * 
     * @return boolean true (full), false (there is space)
     */
    public boolean itsFullTreasures() {
        if (treasures[treasures.length - 1] == null) {
            return false;
        } else {
            return true;
        }
    }

    /**
     * Description: This allows know if there is space
     * 
     * @return boolean true (full), false (there is space)
     */
    public boolean itsFullEnemies() {
        if (enemies[enemies.length - 1] == null) {
            return false;
        } else {
            return true;
        }
    }

    /**
     * Description: This allows know if there is space in a level
     * 
     * @param levelNumber This is the id
     * @return boolean true (full), false (there is space)
     */
    public boolean fullEnemiesInLevel(int levelNumber) {
        return levels[levelNumber].reviewFullEnemies();
    }

    /**
     * Description: This allows know if there is space in a level
     * 
     * @param levelNumber This is the id of level
     * @return boolean true (full), false (there is space)
     */
    public boolean fullTreasuresInLevel(int levelNumber) {
        return levels[levelNumber].reviewFullTreasures();
    }

    /**
     * Description: This allows register a level
     * 
     * @param id        of level
     * @param nextLevel score for pass to the next level
     * @return boolean
     */
    public boolean registerLevel(int id, int nextLevel) {
        Level newLevel = new Level(id, nextLevel);
        if (levels[id] == null) {
            levels[id] = newLevel;
            return true;
        }
        return false;
    }

    /**
     * Description: This allows register a Player
     * 
     * @param nickName of player
     * @param name     of player
     * @return boolean
     */
    public boolean addPlayer(String nickName, String name) {
        Player newPlayer = new Player(nickName, name, levels[0]);
        for (int i = 0; i < players.length; i++) {

            if (players[i] == null) {

                players[i] = newPlayer;
                i = players.length;
                return true;
            }
        }
        return false;
    }

    /**
     * Description: This allows register a enemy
     * 
     * @param nameId           of enemy
     * @param typeEnemy        of the enumeration TypeEnemy
     * @param decreasingPoints of enemy
     * @param increasingPoints of enemy
     * @return boolean
     */
    public boolean addEnemy(String nameId, int typeEnemy, int decreasingPoints, int increasingPoints) {
        Enemy newEnemy = new Enemy(nameId, typeEnemy, decreasingPoints, increasingPoints, generatePositionX(),
                generatePositionY());
        for (int i = 0; i < enemies.length; i++) {
            if (enemies[i] == null) {
                enemies[i] = newEnemy;
                i = enemies.length;
                return true;
            }
        }
        return false;
    }

    /**
     * Description: This allows register a treasure
     * 
     * @param name   of treasure
     * @param url    of treasure
     * @param points of treasure
     * @return boolean
     */
    public boolean addTreasure(String name, String url, int points) {

        Treasure newTreasure = new Treasure(name, url, points, generatePositionX(), generatePositionY());
        for (int i = 0; i < treasures.length; i++) {
            if (treasures[i] == null) {
                treasures[i] = newTreasure;
                i = treasures.length;
                return true;
            }
        }
        return false;
    }

    /**
     * Description: This allows know the id of a player
     * 
     * @param nickName of player to search
     * @return int this the id of player in the list
     */
    public int searchNickNamePlayer(String nickName) {
        for (int i = 0; i < players.length; i++) {
            if (players[i] != null) {
                if (players[i].getNickName().equals(nickName)) {
                    return i;
                }
            }
        }
        return -1;
    }

    /**
     * Description: This allows know the id of a enemy
     * 
     * @param nameId of enemy to search
     * @return int This is the id of enemy in the list
     */
    public int searchNameIdEnemy(String nameId) {
        for (int i = 0; i < enemies.length; i++) {
            if (enemies[i] != null) {
                if (enemies[i].getNameId().equals(nameId)) {
                    return i;
                }
            }
        }
        return -1;
    }

    /**
     * Description: This allows know the id of a treasure
     * 
     * @param treasureName of treasure to search
     * @return int This is the id of treasure in the list
     */
    public int searchNameTreasure(String treasureName) {
        for (int i = 0; i < treasures.length; i++) {
            if (treasures[i] != null) {
                if (treasures[i].getName().equals(treasureName)) {
                    return i;
                }
            }
        }
        return -1;
    }

    /**
     * Description: This allows know if there is a enemy repeated in a level
     * 
     * @param enemyNumber This is the id of enemy
     * @param levelNumber This is the id of level
     * @return boolean
     */
    public boolean itsRepeatTheEnemy(int enemyNumber, int levelNumber) {
        for (int i = 0; i < levels[levelNumber].getEnemiesList().length; i++) {
            if (levels[levelNumber].getEnemiesList()[i] != null) {
                if (levels[levelNumber].getEnemiesList()[i].getNameId().equals(enemies[enemyNumber].getNameId())) {
                    i = enemies.length;
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Description: This allows associate a enemy to a level
     * 
     * @param enemyNumber This is the id of enemy
     * @param levelNumber This is the id of level
     * @return boolean
     */
    public boolean associateEnemyToLevel(int levelNumber, int enemyNumber) {
        if (levels[levelNumber].addEnemy(enemies[enemyNumber])) {
            return true;
        }
        return false;
    }

    /**
     * Description: This allows associate a treasure to a level
     * 
     * @param levelNumber    This is the id of level
     * @param treasureNumber This is the id of treasure
     * @param timesDiamonds  This are the times of diamonds
     * @return boolean
     */
    public boolean associateTreasureToLevel(int levelNumber, int treasureNumber, int timesDiamonds) {
        boolean allCompleted = false;
        Treasure tmp = treasures[treasureNumber];
        for (int i = 0; i < timesDiamonds; i++) {
            Treasure copyTreasure = new Treasure(tmp.getName(), tmp.getUrl(), tmp.getPoints(), generatePositionX(),
                    generatePositionY());
            if (levels[levelNumber].addTreasure(copyTreasure)) {

                allCompleted = true;
            } else {
                allCompleted = false;
                i = timesDiamonds;
            }
        }
        return allCompleted;
    }

    /**
     * Description: This allows show the enemies registered
     * 
     * @return enemies
     */
    public String showEnemy() {
        String registeredEnemies = "";
        for (int i = 0; i < enemies.length; i++) {
            if (enemies[i] != null) {
                registeredEnemies += "\n" + enemies[i].toString();
            }
        }
        return registeredEnemies;
    }

    /**
     * Description: This allows show the treasures registered
     * 
     * @return treasures
     */
    public String showTreasure() {
        String registeredTreasures = "";
        for (int i = 0; i < treasures.length; i++) {
            if (treasures[i] != null) {
                registeredTreasures += "\n" + treasures[i].toString();
            }
        }
        return registeredTreasures;
    }

    /**
     * Description: This allows show the players registered
     * 
     * @return players
     */
    public String showPlayer() {
        String registeredPlayers = "";
        for (int i = 0; i < players.length; i++) {
            if (players[i] != null) {
                registeredPlayers += "\n" + players[i].toString();
            }
        }
        return registeredPlayers;
    }

    /**
     * Description: This allows show the Top 5 of the best players
     * 
     * @param players This is the list of the players of game registered
     * @return String with the Top 5
     */
    public String ordePlayers(Player[] players) {
        Player max;
        for (int i = 0; i < players.length; i++) {
            if (players[i] != null) {
                for (int j = i; j < players.length - 1; j++) {
                    if (players[j + 1] != null) {
                        if (players[i].getScore() < players[j + 1].getScore()) {
                            max = players[j + 1];
                            players[j + 1] = players[i];
                            players[i] = max;
                        }
                    }
                }
            }
        }
        String msg = "This is the Top 5";
        String fail = "";
        for (int i = 0; i < 5; i++) {
            if (players[i] != null) {
                fail += "\n" + (i + 1) + ") : " + players[i].getNickName() + " with " + players[i].getScore() + " points.";
            }
        }
        if (fail.equals("")) {
            msg = "There is/are not Players registered";
        } else {
            msg += fail;
        }
        return msg;
    }
}
