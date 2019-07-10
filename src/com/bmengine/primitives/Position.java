package com.bmengine.primitives;

public class Position {

    private double x, y;

    public Position(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getXDistance(double xPosition) {
        return this.x - xPosition;
    }

    public double getYDistance(double yPosition) {
        return this.y - yPosition;
    }
}
