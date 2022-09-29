package ui;
import java.util.Scanner;
import model.VideoGameController;

public class VideoGameManager {
    
    public static Scanner input = new Scanner(System.in);
    public static VideoGameController vGameController = new VideoGameController();


    public static void main(String[] args) {
        
        System.out.println("\nWelcome to VideoGame...");
        createLevels();
        System.out.println(vGameController.toStringLevel()); // Delete-------------------------------------------------
        selectResolution();
        mainMenu();
    }
    
    //Complete
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

    }
    //Complete
    public static void createLevels() {
        System.out.println("\nCreation of Levels:");
        boolean first = true;
        for (int i = 0; i < vGameController.getLevels().length; i++) {
            
            boolean exit = false;
            int nextLevel = 0;
            do {
                System.out.println("Enter the value for pass the level " + i + ":");
                nextLevel = input.nextInt();
                if (first) {
                    if (nextLevel>0) {
                        vGameController.registerLevel(i, nextLevel);
                        first = false;
                        exit = true;
                    } else {
                        System.out.println("\nValue incorrect!!!  It must be greater than zero-----------");
                    }
                    
                } else {
                    if (nextLevel>vGameController.getNextLevel(i-1)) {
                        vGameController.registerLevel(i, nextLevel);
                        exit = true;
                    } else {
                        System.out.println("\nValue incorrect!!!  It must be greater than "+(vGameController.getNextLevel(i-1))+ "-----------");
                    }
                }
            } while (exit==false);
        } 
        System.out.println("\nThe process of creation of levels finished!");;
    }
    
    public static void mainMenu(){

    }


}