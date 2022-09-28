package model;

public class Enemy {
    
    private String nameId;
    private TypeEnemy typeEnemy;
    private int remainigPoints;
    private int plusPoints;
    private int positionX;
    private int positionY;

    public Enemy(String nameId, TypeEnemy typeEnemy, int remainigPoints, int plusPoints, int positionX, int positionY) {
        this.nameId = nameId;
        this.typeEnemy = typeEnemy;
        this.remainigPoints = remainigPoints;
        this.plusPoints = plusPoints;
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

    public int getRemainigPoints() {
        return remainigPoints;
    }

    public void setRemainigPoints(int remainigPoints) {
        this.remainigPoints = remainigPoints;
    }

    public int getPlusPoints() {
        return plusPoints;
    }

    public void setPlusPoints(int plusPoints) {
        this.plusPoints = plusPoints;
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
