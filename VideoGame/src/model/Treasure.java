package model;

public class Treasure {
 
    private String name;
    private String url;
    private int points;
    private int positionX;
    private int positionY;
    
    public Treasure(String name, String url, int points, int positionX, int positionY) {
        this.name = name;
        this.url = url;
        this.points = points;
        this.positionX = positionX;
        this.positionY = positionY;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public int getPositionX() {
        return positionX;
    }

    public void setPositionX(int positionX) {
        this.positionX = positionX;
    }

    public int getPositionY() {
        return positionY;
    }

    public void setPositionY(int positionY) {
        this.positionY = positionY;
    }

    public String toString() {
        return "\n      Treasure info: "
        + "\n       Name: " + this.name
        + "\n       Url: " + this.url
        + "\n       Increasing Points: " + this.points
        + "\n       Position in X : " + this.positionX
        + "\n       Position in Y: " + this.positionY;
    }
}
