package ui;

import java.util.Scanner;

import model.NeoTunesController;

/**
 * NeoTunesManager Description:
 */
public class NeoTunesManager {

    public Scanner input;
    public NeoTunesController controller;

    public static void main(String[] args) {
        NeoTunesManager neoTunes = new NeoTunesManager();
        neoTunes.hello();
        neoTunes.mainMenu();
        neoTunes.bye();
    }

    public NeoTunesManager() {
        input = new Scanner(System.in);
        controller = new NeoTunesController();
    }

    public void hello() {
        System.out.println("\nWelcome to VideoGame...");
    }

    public void bye() {
        System.out.println("\n Exiting of the program... Thanks for use me  ");
    }

    public void mainMenu() {
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
                            + "\n 14) Show the Top 5 of players");
            optionMenu = input.nextInt();
            switch (optionMenu) {
                case 0:
                    exit = true;
                    break;
                case 1:
                    //registerPlayer();
                    break;
                case 2:
                    //registerEnemy();
                    break;
                case 3:
                    //associateEnemyToLevel();
                    break;
                case 4:
                    //registerTreasure();
                    break;
                case 5:
                    //associateTreasureToLevel();
                    break;
                case 6:
                    //modifyScorePlayer();
                    break;
                case 7:
                    //increaseLevelPlayer();
                    break;
                case 8:
                    //showLevelInfo();
                    break;
                case 9:
                    //showQuantityDiamonds();
                    break;
                case 10:
                    //showQuantityEnemies();
                    break;
                case 11:
                    //showMostRepeatedTreasure();
                    break;
                case 12:
                    //showHighestEnemy();
                    break;
                case 13:
                    //showQuantityConsonantsEnemies();
                    break;
                case 14:
                    //showTop5True();
                    break;
                default:
                    System.out.println("------------------\nValue incorrect!!!");
                    break;
            }
        } while (exit == false);
    }

}