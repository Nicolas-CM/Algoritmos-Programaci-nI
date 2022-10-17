package ui;

import java.util.Scanner;

import model.VideoGameController;

/*
 * Description: This program allows the user manage a VideoGame, it allows register levels, players, enemies and treasures.
 * This program has a menu that allows interaction with the information of game.
 */

public class VideoGameManager {

    public static Scanner input = new Scanner(System.in);
    public static VideoGameController vGameController = new VideoGameController();

    public static void main(String[] args) {

        System.out.println("\nWelcome to VideoGame...");
        createLevels();
        selectResolution();
        mainMenu();
        System.out.println("\n Exiting of the program... Thanks for use me  ");
    }

    /**
     * Descrption: This allows select the resolution of the screen, where will play.
     */
    public static void selectResolution() {

        int optionMenu = 0;
        boolean exit = false;
        do {
            System.out.println("\n----------\nPlease select the resolution\n---------- Choose a option:\n 1) SD"
                    + "\n 2) QHD\n 3) HD \n 4) FHD \n 5) QHD2 \n 6) UHD \n 7) UHD 8K");
            optionMenu = input.nextInt();
            switch (optionMenu) {
                case 1:
                    vGameController.setMaxX(640);
                    vGameController.setMaxY(480);
                    exit = true;
                    break;
                case 2:
                    vGameController.setMaxX(960);
                    vGameController.setMaxY(540);
                    exit = true;
                    break;
                case 3:
                    vGameController.setMaxX(1280);
                    vGameController.setMaxY(720);
                    exit = true;
                    break;
                case 4:
                    vGameController.setMaxX(1920);
                    vGameController.setMaxY(1080);
                    exit = true;
                    break;
                case 5:
                    vGameController.setMaxX(2560);
                    vGameController.setMaxY(1440);
                    exit = true;
                    break;
                case 6:
                    vGameController.setMaxX(3840);
                    vGameController.setMaxY(2160);
                    exit = true;
                    break;
                case 7:
                    vGameController.setMaxX(7680);
                    vGameController.setMaxY(4320);
                    exit = true;
                    break;
                default:
                    System.out.println("------------------\nValue incorrect!!!");
                    break;
            }

        } while (exit == false);
        System.out.println("The process of selection of resolution finished");

    }

    /**
     * Descrption: This allows create the ten level of game.
     */
    public static void createLevels() {
        System.out.println("\nCreation of Levels:");
        for (int id = 0; id < vGameController.getLevels().length; id++) {
            vGameController.registerLevel(id, (id + 1) * 100);
        }
        System.out.println("\nThe process of creation of levels finished!---------");
        ;
    }

    /**
     * Descrption: This is the main Menu, for the options of user.
     */
    public static void mainMenu() {
        int optionMenu = 0;
        boolean exit = false;
        do {
            System.out.println(
                    "\n----------\nMain Menu\n---------- Choose a option:\n 0) Exit of program\n 1) Register a Player"
                            + "\n 2) Register a Enemy\n 3) Associate Enemy to Level\n 4) Register a Treasure\n 5) Associate Treasure to Level"
                            + "\n 6) Modify the score of a Player\n 7) Increase the Level to a Player\n 8) Show the Enemies and Ereasures of a Level"
                            + "\n 9) Show the quantity of diamonds of a Treasure\n 10) Show the quantity of enemies of a type of Enemy"
                            + "\n 11) Show the most repeated treasure\n 12) Show the highest scoring enemy"
                            + "\n 13) Show the quantity of consonants in the names of the enemies"
                            + "\n 14) Show the Top 5 of players"); // With effort teacher :)
            optionMenu = input.nextInt();
            switch (optionMenu) {
                case 0:
                    exit = true;
                    break;
                case 1:
                    registerPlayer();
                    break;
                case 2:
                    registerEnemy();
                    break;
                case 3:
                    associateEnemyToLevel();
                    break;
                case 4:
                    registerTreasure();
                    break;
                case 5:
                    associateTreasureToLevel();
                    break;
                case 6:
                    modifyScorePlayer();
                    break;
                case 7:
                    increaseLevelPlayer();
                    break;
                case 8:
                    showLevelInfo();
                    break;
                case 9:
                    showQuantityDiamonds();
                    break;
                case 10:
                    showQuantityEnemies();
                    break;
                case 11:
                    showMostRepeatedTreasure();
                    break;
                case 12:
                    showHighestEnemy();
                    break;
                case 13:
                    showQuantityConsonantsEnemies();
                    break;
                case 14:
                    showTop5True();
                    break;
                default:
                    System.out.println("------------------\nValue incorrect!!!");
                    break;
            }
        } while (exit == false);
    }

    /**
     * Description: This allows show the Top 5 of the best players
     */
    private static void showTop5True() {
        System.out.println(vGameController.ordePlayers(vGameController.getPlayers()));
    }

    /**
     * Descrption: This allows show the quantity of consonants in the names of all
     * the enemies.
     */
    private static void showQuantityConsonantsEnemies() {
        if (vGameController.showEnemy().equals("")) {
            System.out.println("First must register a Enemy!!!");
        } else {
            String name = "";
            String[] consonants = { "b", "c", "d", "f", "g", "h", "j", "k", "l", "m", "n", "ñ", "p", "q", "r", "s", "t",
                    "v", "x", "z", "w", "y" };
            int quantityConsonants = 0;
            for (int i = 0; i < vGameController.getEnemies().length; i++) {
                if (vGameController.getEnemies()[i] != null) {
                    name = vGameController.getEnemies()[i].getNameId(); // ReplaceAll
                    name = name.toLowerCase();
                    for (int j = 0; j < name.length(); j++) {
                        String letter = name.substring(j, j + 1);
                        for (int k = 0; k < consonants.length; k++) {
                            if (letter.equals(consonants[k])) {
                                quantityConsonants += 1;
                                k = consonants.length;
                            }
                        }
                    }
                }
            }
            System.out.println("There is/are " + quantityConsonants + " consonants in the names of all the enemies");
        }
    }

    /**
     * Descrption: This allows show the highest increasing points enemy and show his
     * level associate.
     */
    private static void showHighestEnemy() {
        if (vGameController.showEnemy().equals("")) {
            System.out.println("First must register a Enemy!!!");
        } else {
            int bigger = 0;
            // For find the most big
            if (vGameController.getEnemies()[1] != null) {
                for (int i = 0; i < vGameController.getEnemies().length; i++) {
                    if (vGameController.getEnemies()[i] != null) {
                        if (vGameController.getEnemies()[bigger].getincreasingPoints() < vGameController.getEnemies()[i]
                                .getincreasingPoints()) {
                            bigger = i;
                        }
                    }
                }
            }
            // For find his level
            int level = -1;
            String msg = "this enemy don't have a level associated";
            for (int i = 0; i < vGameController.getLevels().length; i++) {
                if (vGameController.itsRepeatTheEnemy(bigger, i)) {
                    level = i;
                    msg = "is in the level " + level;
                }
            }
            System.out.println(
                    "The Highest scoring Enemy is " + vGameController.getEnemies()[bigger].getNameId() + " with " +
                            vGameController.getEnemies()[bigger].getincreasingPoints() + " points, and " + msg);
        }
    }

    /**
     * Descrption: This allows show the Treasure most repeated.
     */
    private static void showMostRepeatedTreasure() {
        if (vGameController.showTreasure().equals("")) {
            System.out.println("First must register a Treasure!!!");
        } else {
            int bigger = 0;
            if (vGameController.getTreasures()[1] != null) {
                for (int i = 0; i < vGameController.getTreasures().length; i++) {
                    if (vGameController.getTreasures()[i] != null) {
                        if (quantityDiamonds(bigger) < quantityDiamonds(i)) {
                            bigger = i;
                        }
                    }
                }
            }
            System.out.println("The Treasure most repeated is " + vGameController.getTreasures()[bigger].getName());
        }
    }

    /**
     * Descrption: This allows show the quantity of enemies of a type of Enemy.
     */
    private static void showQuantityEnemies() {
        if (vGameController.showEnemy().equals("")) {
            System.out.println("First must register a Enemy!!!");
        } else {
            int typeEnemy = selectTypeEnemy();
            int quantityEnemies = 0;
            for (int i = 0; i < vGameController.getEnemies().length; i++) {
                if (vGameController.getEnemies()[i] != null) {
                    if (vGameController.getEnemies()[i].getTypeEnemy()
                            .equals(vGameController.getTypeEnemy(typeEnemy))) {
                        quantityEnemies += 1;
                    }
                }
            }
            System.out.println("There is/are " + quantityEnemies + " Enemies of type "
                    + vGameController.getTypeEnemy(typeEnemy) + " in all the Levels");
        }
    }

    /**
     * Descrption: This allows show the quantity of diamondos of a treasure
     * selected.
     */
    public static void showQuantityDiamonds() {
        if (vGameController.showTreasure().equals("")) {
            System.out.println("First must register a Treasure!!!");
        } else {
            System.out.println("\n Select a Treasure: ");
            int treasureNumber = selectTreasure();
            if (treasureNumber == -1) {
                System.out.println("The process was canceled---------");
            } else {
                int quantityDiamonds = quantityDiamonds(treasureNumber);
                System.out.println("There is/are " + quantityDiamonds + " Diamonds in all the Levels");
            }
        }
    }

    /**
     * Descrption: This allows calculate the quantity of diamonds, of a position of
     * a treasure.
     * 
     * @param treasureNumber This is the position of the treasure
     * @return int This is the number of times it repeats
     */
    public static int quantityDiamonds(int treasureNumber) {

        String treasureName = vGameController.getTreasures()[treasureNumber].getName();
        int quantityDiamonds = 0;
        for (int i = 0; i < vGameController.getLevels().length; i++) {
            for (int j = 0; j < vGameController.getLevels()[i].getTrasuresList().length; j++) {
                if (vGameController.getLevels()[i].getTrasuresList()[j] != null) {
                    if (vGameController.getLevels()[i].getTrasuresList()[j].getName().equals(treasureName)) {
                        quantityDiamonds += 1;
                    }
                }
            }
        }
        return quantityDiamonds;
    }

    /**
     * Descrption: This sets the complexity of a level (LOW, MEDIUM, HIGH).
     * 
     * @param levelNumber This is the id of level
     */
    public static void complexityLevel(int levelNumber) {
        int totalPointsEnemies = vGameController.getLevels()[levelNumber].totalPointsEnemies();
        int totalPointsTreasures = vGameController.getLevels()[levelNumber].totalPointsTreasures();
        if (totalPointsTreasures > totalPointsEnemies) {
            vGameController.getLevels()[levelNumber].setDifficult(0);
        } else if (totalPointsTreasures == totalPointsEnemies) {
            vGameController.getLevels()[levelNumber].setDifficult(1);
        } else {
            vGameController.getLevels()[levelNumber].setDifficult(2);
        }
    }

    /**
     * Descrption: This allows show the info of a level selected.
     */
    public static void showLevelInfo() {
        int levelNumber = selectLevel();
        System.out.println(vGameController.getLevels()[levelNumber].toString());
    }

    /**
     * Descrption: This allows register a player to the game.
     */
    public static void registerPlayer() {
        if (vGameController.itsFullPlayers()) {
            System.out.println("There is not more space for register...");
        } else {
            boolean exit = false;
            input.nextLine();
            String nickName = "";
            do {
                System.out.println("Player:\n Enter the nickName: ");
                nickName = input.nextLine();
                if (vGameController.searchNickNamePlayer(nickName) != -1) {
                    System.out.println("This nickname already exists, please enter another: ");
                } else {
                    exit = true;
                }
            } while (exit == false);
            System.out.println("Enter the name: ");
            String name = input.nextLine();
            if (vGameController.addPlayer(nickName, name)) {
                System.out.println("The process was correct----------");
            } else {
                System.out.println("The process can't be finished----------");
            }
        }
    }

    /**
     * Descrption: This allows register a enemy to the game.
     */
    public static void registerEnemy() {
        if (vGameController.itsFullEnemies()) {
            System.out.println("There is not more space for register...");
        } else {
            boolean exit = false;
            input.nextLine();
            String nameId = "";
            do {
                System.out.println("Enemy: \nEnter the nameId: ");
                nameId = input.nextLine();
                if (vGameController.searchNameIdEnemy(nameId) != -1) {
                    System.out.println("This nameId already exists, please enter another: ");
                } else {
                    exit = true;
                }
            } while (exit == false);
            int typeEnemy = selectTypeEnemy();
            System.out.println("Enter the score remaining in case the enemy beat the player: ");
            int decreasingPoints = input.nextInt();
            System.out.println("Enter the score increasing in case the player beat the enemy: ");
            int increasingPoints = input.nextInt();
            if (vGameController.addEnemy(nameId, typeEnemy, decreasingPoints, increasingPoints)) {
                System.out.println("The process was correct----------");
            } else {
                System.out.println("The process can't be finished----------");
            }
        }
    }

    /**
     * Descrption: This allows register a treasure to the game.
     */
    public static void registerTreasure() {
        if (vGameController.itsFullTreasures()) {
            System.out.println("There is not more space for register...");
        } else {
            input.nextLine();
            System.out.println("\nTreasure: \n Enter the name: ");
            String name = input.nextLine();
            System.out.println("Enter the url: ");
            String url = input.nextLine();
            System.out.println("The points: ");
            int points = input.nextInt();
            if (vGameController.addTreasure(name, url, points)) {
                System.out.println("The process was correct----------");
            } else {
                System.out.println("The process can't be finished----------");
            }
        }
    }

    /**
     * Descrption: This allows asociate a enemy to a level.
     */
    public static void associateEnemyToLevel() {
        if (vGameController.showEnemy().equals("")) {
            System.out.println("First must register a Enemy!!!");
        } else {

            int levelNumber = selectLevel();
            if (vGameController.fullEnemiesInLevel(levelNumber)) {
                System.out.println("This Level can't register more Enemies");
            } else {

                int enemyNumber = selectEnemy(levelNumber);
                if (enemyNumber == -1) {
                    System.out.println("The process was canceled---------");
                } else {
                    if (vGameController.associateEnemyToLevel(levelNumber, enemyNumber)) {
                        System.out.println("The process was correct---------");
                        complexityLevel(levelNumber);
                    } else {
                        System.out.println("Can't add a new Enemy!!!---------");
                    }
                }
            }
        }
    }

    /**
     * Descrption: This allows asociate treasures to a level.
     */
    public static void  associateTreasureToLevel() {
        if (vGameController.showTreasure().equals("")) {
            System.out.println("First must register a Treasure!!!");
        } else {

            int levelNumber = selectLevel();
            if (vGameController.fullTreasuresInLevel(levelNumber)) {
                System.out.println("This Level can't register more Treasures (Daimonds)------------");
            } else {
                int treasureNumber = selectTreasure();
                if (treasureNumber == -1) {
                    System.out.println("The process was canceled---------");
                } else {
                    System.out.println("How many diamonds you want to add: (Max 50) ");
                    int timesDiamonds = input.nextInt();
                    if (vGameController.associateTreasureToLevel(levelNumber, treasureNumber, timesDiamonds)) {
                        System.out.println("The process was correct---------");
                        complexityLevel(levelNumber);
                    } else {
                        System.out.println("Can't add a new Diamond to the Level!!!---------");
                    }
                }
            }
        }
    }

    /**
     * Descrption: This allows selected a level (0 between 9)
     * 
     * @return int This is the level selected
     */
    public static int selectLevel() {
        int levelNumber = 0;
        boolean exit = false;
        do {
            System.out.println("Enter el id of level (0 between 9)");
            levelNumber = input.nextInt();
            if (levelNumber < 0 || levelNumber > 9) {
                System.out.println("\nThere isn't this level. Please enter other-----------");
            } else {
                exit = true;
            }
        } while (exit == false);
        return levelNumber;
    }

    /**
     * Descrption: This allows select a enemy for then asociate to the level
     * selected.
     * 
     * @param levelNumber This is the level selected
     * @return int This is the position of enemy in the list
     */
    public static int selectEnemy(int levelNumber) {

        System.out.println(vGameController.showEnemy());
        int enemyNumber = 0;
        boolean repeat = false;
        boolean exit = false;
        input.nextLine();
        String nameId = "";
        do {
            System.out.println("\nPlease, Enter the nameId: (Enter cancel for cancel) ");
            nameId = input.nextLine();
            if (nameId.equals("cancel")) {
                enemyNumber = -1;
                exit = true;
            } else {
                enemyNumber = vGameController.searchNameIdEnemy(nameId);
                if (enemyNumber != -1) {
                    repeat = vGameController.itsRepeatTheEnemy(enemyNumber, levelNumber);
                }
                if (enemyNumber == -1 || repeat == true) {
                    System.out.println(
                            "This nameId don't exist, or before this enemy was registered, please enter another: \n (You can't register the same enemy for the same nivel)");
                } else {
                    exit = true;
                }
            }
        } while (exit == false);
        return enemyNumber;
    }

    /**
     * Descrption: This allows select the type of enemy.
     * 
     * @return int This is the id of type of enemy in the class TypeEnemy
     */
    public static int selectTypeEnemy() {

        boolean exit = false;
        int typeEnemy = 0;
        System.out.println(vGameController.toStringEnemy());
        do {
            System.out.println("Enter the number of type of enemy: ");
            typeEnemy = input.nextInt();
            if (typeEnemy < 0 || typeEnemy > 3) {
                System.out.println("There isn't this type of enemy, please enter another: ");
            } else {
                exit = true;
            }
        } while (exit == false);
        return typeEnemy;
    }

    /**
     * Descrption: This allows select a treasure for then asociate to the level
     * selected.
     * 
     * @return int This is the position of treasure in the list
     */
    public static int selectTreasure() {
        System.out.println(vGameController.showTreasure());
        int treasureNumber = 0;
        boolean exit = false;
        input.nextLine();
        String treasureName = "";
        do {
            System.out.println("\nPlease, Enter the name: (Enter cancel for cancel) ");
            treasureName = input.nextLine();
            if (treasureName.equals("cancel")) {
                treasureNumber = -1;
                exit = true;
            } else {
                treasureNumber = vGameController.searchNameTreasure(treasureName);
                if (treasureNumber == -1) {
                    System.out.println("Entered a name incorrect -----------");
                } else {
                    exit = true;
                }
            }
        } while (exit == false);

        return treasureNumber;
    }

    /**
     * Descrption: This allows select a player and get your id in the list.
     * 
     * @return int This is the position of player in the list
     */
    public static int selectPlayer() {

        boolean exit = false;
        input.nextLine();
        String nickName = "";
        int nickNumber = 0;
        System.out.println(vGameController.showPlayer());
        do {
            System.out.println("\nEnter the nickName of player: (Enter cancel for cancel)");
            nickName = input.nextLine();
            if (nickName.equals("cancel")) {
                System.out.println("The process was canceled---------");
                nickNumber = -1;
                exit = true;
            } else if (vGameController.searchNickNamePlayer(nickName) != -1) {
                nickNumber = vGameController.searchNickNamePlayer(nickName);
                exit = true;
            } else {
                System.out.println("This nickname doesn't exist, please enter another: ");
            }
        } while (exit == false);

        return nickNumber;
    }

    /**
     * Descrption: This allows modify the score of a player selected.
     */
    public static void modifyScorePlayer() {
        if (vGameController.showPlayer().equals("")) {
            System.out.println("First must register a Player!!!");
        } else {
            boolean exit = false;
            input.nextLine();
            String nickName = "";
            int nickNumber = 0;
            System.out.println(vGameController.showPlayer());
            do {
                System.out.println("\nEnter the nickName of player: (Enter cancel for cancel)");
                nickName = input.nextLine();
                if (nickName.equals("cancel")) {
                    exit = true;
                } else if (vGameController.searchNickNamePlayer(nickName) != -1) {

                    nickNumber = vGameController.searchNickNamePlayer(nickName);
                    exit = true;
                } else {
                    System.out.println("This nickname doesn't exist, please enter another: ");
                }
            } while (exit == false);
            if (nickName.equals("cancel")) {
                System.out.println("The process was canceled---------");
            } else {
                System.out.println("Enter the new score of the player: ");
                int newScore = input.nextInt();
                vGameController.getPlayers()[nickNumber].setScore(newScore);
                System.out.println("The process was correct---------");
            }
        }
    }

    /**
     * Descrption: This allows increase the level of a player selected.
     */
    public static void increaseLevelPlayer() {
        if (vGameController.showPlayer().equals("")) {
            System.out.println("First must register a Player!!!");
        } else {

            int nickNumber = selectPlayer();
            if (nickNumber == -1) {
                // The fuction was canceled
            } else {

                int scorePlayer = vGameController.getPlayers()[nickNumber].getScore();
                int idLevelInit = vGameController.getPlayers()[nickNumber].getLevel().getId();
                for (int i = 0; i < vGameController.getLevels().length; i++) {
                    if (scorePlayer > vGameController.getLevels()[i].getNextLevel()) {
                        vGameController.getPlayers()[nickNumber].setLevel(vGameController.getLevels()[i + 1]);
                    }
                }
                if (scorePlayer < vGameController.getLevels()[idLevelInit].getNextLevel()) {
                    System.out.println("Can't increase the level---------");
                } else {
                    System.out.println("The process was correct, The player increased your level---------");
                }
                System.out
                        .println("The player need " + vGameController.getPlayers()[nickNumber].getLevel().getNextLevel()
                                + " points for pass to the next level---------");
            }
        }
    }

}