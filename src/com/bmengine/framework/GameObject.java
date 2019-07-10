package com.bmengine.framework;

import com.bmengine.primitives.Position;

import java.util.LinkedList;
import java.awt.Graphics;

/*

An abstract for all variables and methods every game object
should have. Make sure that the specific game object classes
inherit this class. I have not specified anything other than
the objects position (x, y) and the type (ObjectID), and the
criterion that they must have a tick and render method. /J

 */

public abstract class GameObject {

    protected Position position;
    protected int Velocity = 0;
    protected String name;
    protected char facing = 'l';

    public GameObject(Position position, String name){
        this.position = position;
        this.name = name;
    }

    public abstract void tick(LinkedList<GameObject> objects);
    public abstract void render(Graphics g);

    public Position getPosition(){
        return position;
    }

    public int getVelocity() {
        return Velocity;
    }

    public void setVelocity(int velocity) {
        Velocity = velocity;
    }

    public void setPosition(Position position){
        this.position = position;
    }

}
