package com.bmengine.window;

/*

Creates the camera and dictates its tick behavior.
/J

 */


public class Camera {

    private int x,y;

    public Camera(int x, int y){
        this.x = x;
        this.y = y;

    }

    public void tick(){

        // Camera behavior here. /J

    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}
