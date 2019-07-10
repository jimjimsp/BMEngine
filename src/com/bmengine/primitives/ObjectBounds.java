package com.bmengine.primitives;

import java.awt.*;

public class ObjectBounds {

    private int width, height;

    public ObjectBounds(int width, int height){
        this.width = width;
        this.height = height;
    }

    public Rectangle getBounds(Position position) {
        return new Rectangle(height, width, position.getX(), position.getY());
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}
