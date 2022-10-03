package ui;
import java.util.Scanner;
import model.VideoGameController;

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
    public static void selectResolution(){

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

        } while (exit==false);
        System.out.println("The process of selection of resolution finished");

    }
    /**
     * Descrption: This allows create the ten level of game, question the score for pass to the next level.
     */
    public static void createLevels() {
        System.out.println("\nCreation of Levels:");
        boolean first = true;
        for (int id = 0; id < vGameController.getLevels().length; id++) {
            
            boolean exit = false;
            int nextLevel = 0;
            do {
                System.out.println("Enter the value for pass the level " + id + ":");
                nextLevel = input.nextInt();
                if (first) {
                    if (nextLevel>10) {
                        vGameController.registerLevel(id, nextLevel);
                        first = false;
                        exit = true;
                    } else {
                        System.out.println("\nValue incorrect!!!  It must be greater than ten-----------");
                    }
                    
                } else {
                    if (nextLevel>vGameController.getNextLevel(id-1)) {
                        vGameController.registerLevel(id, nextLevel);
                        exit = true;
                    } else {
                        System.out.println("\nValue incorrect!!!  It must be greater than "+(vGameController.getNextLevel(id-1)) + "-----------");
                    }
                }
            } while (exit==false);
        } 
        System.out.println("\nThe process of creation of levels finished!");;
    }

    /**
     * Descrption: This is the main Menu, for the options of user.
     */
    public static void mainMenu(){
        int optionMenu = 0;
        boolean exit = false;
        do {
            System.out.println("\n----------\nMain Menu\n---------- Choose a option:\n 0) Exit of program\n 1) Register a Player"
            + "\n 2) Register a Enemy\n 3) Associate Enemy to Level\n 4) Register a Treasure\n 5) Associate Treasure to Level"
            + "\n 6) Modify the score of a player\n 7) Increase the level to a player");
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
                    break; /*
                case 9:
                    System.out.println(vGameController.showEnemy());
                    break;
                case 10:
                    System.out.println(vGameController.showTreasure());
                    break;
                case 11:
                    System.out.println(vGameController.getLevels()[0].toString());
                    break;
                case 12:
                    System.out.println(vGameController.showPlayer());
                    break;*/
                default:
                    System.out.println("------------------\nValue incorrect!!!");
                    break;
            }
        } while (exit==false); 
    }


    /**
     * Descrption: This allows register a player to game.
     */
    public static void registerPlayer(){
        if (vGameController.itsFullPlayers()) {
            System.out.println("There is not more space for register...");
        } else {
            boolean exit = false;
            input.nextLine();
            String nickName = "";
            do {
                System.out.println("Player:\n Enter the nickName: ");
                nickName = input.nextLine();
                if (vGameController.searchNickNamePlayer(nickName)!=-1) {
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
     * Descrption: This allows register a enemy to game.
     */
    public static void registerEnemy(){
        if (vGameController.itsFullEnemies()) {
            System.out.println("There is not more space for register...");
        } else {
            boolean exit = false;
            input.nextLine();
            String nameId = "";
            do {
                System.out.println("Enemy: \nEnter the nameId: ");
                nameId = input.nextLine();
                if (vGameController.searchNameIdEnemy(nameId)!=-1) {
                    System.out.println("This nameId already exists, please enter another: ");
                } else {
                    exit = true;
                }
            } while (exit == false);
            exit = false;
            int typeEnemy = 0;
            System.out.println(vGameController.toStringEnemy()); 
            do {
                System.out.println("Enter the number of type of enemy: ");
                typeEnemy = input.nextInt();
                if (typeEnemy<0 || typeEnemy>3) {
                    System.out.println("There isn't this type of enemy, please enter another: ");
                } else {
                    exit = true;
                }
            } while (exit == false);
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
     * Descrption: This allows register a treasure to game.
     */
    public static void registerTreasure(){
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
    public static void associateEnemyToLevel(){
        if (vGameController.showEnemy().equals("")) {
            System.out.println("First must register a Enemy!!!");
        } else {
            int levelNumber = 0;
            boolean exit = false;
            do {
                System.out.println("Enter el id of level (0 between 9)");
                levelNumber = input.nextInt();
                if (levelNumber<0 || levelNumber>9) {
                    System.out.println("\nThere isn't this level. Please enter other-----------");
                } else {
                    if (vGameController.fullEnemiesInLevel(levelNumber)) {
                        System.out.println("This Level can't register more Enemies");
                    } else {
                        exit = true;
                    }
                }
            } while (exit == false);
            System.out.println(vGameController.showEnemy());
            int enemyNumber = selectEnemy(levelNumber);
            if (enemyNumber == -1) {
                System.out.println("The process was canceled---------");
            } else {
                if (vGameController.associateEnemyToLevel(levelNumber, enemyNumber)) {
                    System.out.println("The process was correct---------");
                } else {
                    System.out.println("Can't add a new Enemy!!!---------");
                }
            } 
        }
    }
    /**
     * Descrption: This allows asociate treasures to a level.
     */
    public static void associateTreasureToLevel(){
        if (vGameController.showTreasure().equals("")) {
            System.out.println("First must register a Treasure!!!");
        } else {
            int levelNumber = 0;
            boolean exit = false;
            do {
                System.out.println("Enter el id of level (0 between 9)");
                levelNumber = input.nextInt();
                if (levelNumber<0 || levelNumber>9) {
                    System.out.println("\nThere isn't this level. Please enter other-----------");
                } else {
                    if (vGameController.fullTreasuresInLevel(levelNumber)) {
                        System.out.println("This Level can't register more Treasures (Daimonds)------------");
                    } else {
                        exit = true;
                    }
                }
            } while (exit == false);
            System.out.println(vGameController.showTreasure());
            int treasureNumber = selectTreasure(levelNumber);
            if (treasureNumber == -1) {
                System.out.println("The process was canceled---------");
            } else {
                System.out.println("How many diamonds you want to add: (Max 5) ");
                int timesDiamonds = input.nextInt();
                if (vGameController.associateTreasureToLevel(levelNumber, treasureNumber, timesDiamonds)) {
                    System.out.println("The process was correct---------");
                } else {
                    System.out.println("Can't add a new Diamond to the Level!!!---------");
                }
            }
        }
    }

    /**
     * Descrption: This allows select a enemy for then asociate to the level selected.
     * @param levelNumber This is the level selected
     * @return int This is the position of enemy in the list
     */
    public static int selectEnemy(int levelNumber){
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
                    repeat = vGameController.itsRepeatTypeOfEnemy(enemyNumber, levelNumber);
                }
                if (enemyNumber == - 1 || repeat == true) {
                    System.out.println("This nameId don't exist, or before this type of enemy was registered, please enter another: \n (You can't register the same enemy or the same type of enemy for the same nivel)");
                } else {
                    exit = true;
                }
            }
        } while (exit == false);
        return enemyNumber;
    }
    /**
     * Descrption: This allows select a treasure for then asociate to the level selected.
     * @param levelNumber This is the level selected
     * @return int This is the position of treasure in the list
     */
    public static int selectTreasure(int levelNumber){
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
     * Descrption: This allows modify the score of a player selected.
     */
    public static void modifyScorePlayer(){
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
                } else if (vGameController.searchNickNamePlayer(nickName)!=-1) {
                    
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
    public static void increaseLevelPlayer(){
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
                } else if (vGameController.searchNickNamePlayer(nickName)!=-1) {
                    
                    nickNumber = vGameController.searchNickNamePlayer(nickName);
                    exit = true;
                } else {
                    System.out.println("This nickname doesn't exist, please enter another: ");
                }
            } while (exit == false);
            if (nickName.equals("cancel")) {
                System.out.println("The process was canceled---------");
            } else {
                int scorePlayer = vGameController.getPlayers()[nickNumber].getScore();
                int idLevelInit = vGameController.getPlayers()[nickNumber].getLevel().getId();

                for (int i = 0; i < vGameController.getLevels().length; i++) {
                    
                    if (scorePlayer < vGameController.getLevels()[idLevelInit + i].getNextLevel()) {
                        vGameController.getPlayers()[nickNumber].setLevel(vGameController.getLevels()[idLevelInit + i]);
                        
                    }
                }
                if (scorePlayer < vGameController.getLevels()[idLevelInit].getNextLevel()) {
                    System.out.println("Can't increase the level, The player need " + vGameController.getLevels()[vGameController.getPlayers()[nickNumber].getLevel().getId()].getNextLevel() + " points for pass to the next level---------"); 
                } else{
                    System.out.println("The process was correct, The player increased your level---------"); 
                    System.out.println("Now the player need " + vGameController.getPlayers()[nickNumber].getLevel().getNextLevel() + " points for pass to the next level---------");
                 
                }
                       

                /*                 
                if (scorePlayer > vGameController.getLevels()[vGameController.getPlayers()[nickNumber].getLevel().getId()].getNextLevel()) {
                    vGameController.getPlayers()[nickNumber].setLevel(vGameController.getLevels()[vGameController.getPlayers()[nickNumber].getLevel().getId()+1]);
                    System.out.println("The process was correct, The player increased your level---------"); 
                    System.out.println("Now the player need " + vGameController.getLevels()[vGameController.getPlayers()[nickNumber].getLevel().getId()].getNextLevel() + " points for pass to the next level---------");
                }else{
                    System.out.println("Can't increase the level, The player need " + vGameController.getLevels()[vGameController.getPlayers()[nickNumber].getLevel().getId()].getNextLevel() + " points for pass to the next level---------"); 
                }
                */         
            }
        }
    }
}