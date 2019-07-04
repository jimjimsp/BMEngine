package com.bmengine.framework;

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

    protected float x,y;
    protected ObjectID id;

    public GameObject(float x, float y, ObjectID id){
        this.x = x;
        this.y = y;
        this.id = id;
    }

    public abstract void tick(LinkedList<GameObject> object);
    public abstract void render(Graphics g);

    public float getX(){
        return x;
    }

    public float getY(){
        return y;
    }

    public void setX(float x){
        this.x = x;
    }

    public void setY(float y){
        this.y = y;
    }

}
