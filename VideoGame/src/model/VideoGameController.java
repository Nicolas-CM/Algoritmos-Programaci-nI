package model;

public class VideoGameController {

    private Player[] players;
    private Level[] levels;
    private Treasure[] treasures;
    private Enemy[] enemies;

    public VideoGameController() {

        this.players = new Player[20];
        this.levels = new Level[10];
        this.treasures = new Treasure[50];
        this.enemies = new Enemy[25];
    }

    
    
}
