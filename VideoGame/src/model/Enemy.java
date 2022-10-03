package model;

public class Enemy {
    
    private String nameId;
    private TypeEnemy typeEnemy;
    private int decreasingPoints;
    private int increasingPoints;
    private int positionX;
    private int positionY;

    public Enemy(String nameId, int typeEnemy, int decreasingPoints, int increasingPoints, int positionX, int positionY) {
        this.nameId = nameId;
        this.typeEnemy = TypeEnemy.values()[typeEnemy];
        this.decreasingPoints = decreasingPoints;
        this.increasingPoints = increasingPoints;
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

    public int getincreasingPoints() {
        return increasingPoints;
    }

    public void setincreasingPoints(int increasingPoints) {
        this.increasingPoints = increasingPoints;
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
        return "\n      Enemy info: "
        + "\n       NameId: " + this.nameId
        + "\n       Type of Enemy: " + this.typeEnemy
        + "\n       Decreasing Points: " + this.decreasingPoints 
        + "\n       Increasing Points: " + this.increasingPoints
        + "\n       Position in X : " + this.positionX
        + "\n       Position in Y: " + this.positionY;
    }
}
