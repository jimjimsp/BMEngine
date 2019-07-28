package com.bmengine.window;

/*

Creates the camera and dictates its tick behavior.
/J

 */


import com.bmengine.primitives.Position;

public class rCamera {

    private Position position;

    public Camera(Position position){
        this.position = position;

    }

    public void tick(){

        // Camera behavior here. /J

    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }
}
