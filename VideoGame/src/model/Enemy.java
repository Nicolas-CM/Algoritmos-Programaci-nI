package model;

public class Enemy {
    
    private String nameId;
    private TypeEnemy typeEnemy;
    private int decreasingPoints;
    private int increasinPoints;
    private int positionX;
    private int positionY;

    public Enemy(String nameId, TypeEnemy typeEnemy, int decreasingPoints, int increasinPoints, int positionX, int positionY) {
        this.nameId = nameId;
        this.typeEnemy = typeEnemy;
        this.decreasingPoints
 = decreasingPoints
;
        this.increasinPoints = increasinPoints;
        this.positionX = positionX;
        this.positionY = positionY;
    }

    public String getNameId() {
        return nameId;
    }

    public void setNameId(String nameId) {
        this.nameId = nameId;
    }

    public TypeEnemy getTypeEnemy() {
        return typeEnemy;
    }

    public void setTypeEnemy(TypeEnemy typeEnemy) {
        this.typeEnemy = typeEnemy;
    }

    public int getdecreasingPoints() {
        return decreasingPoints
;
    }

    public void setdecreasingPoints(int decreasingPoints) {
        this.decreasingPoints
 = decreasingPoints
;
    }

    public int getincreasinPoints() {
        return increasinPoints;
    }

    public void setincreasinPoints(int increasinPoints) {
        this.increasinPoints = increasinPoints;
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

    
}
