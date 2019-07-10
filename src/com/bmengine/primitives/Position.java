package com.bmengine.primitives;

public class Position {

    private int x, y;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getXDistance(int xPosition) {
        return this.x - xPosition;
    }

    public int getYDistance(int yPosition) {
        return this.y - yPosition;
    }
}
