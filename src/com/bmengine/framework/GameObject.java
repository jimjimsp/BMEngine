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

    private Position position;
    private ObjectID id;

    public GameObject(Position position, ObjectID id){
        this.position = position;
        this.id = id;
    }

    public abstract void tick(LinkedList<GameObject> objects);
    public abstract void render(Graphics g);

    public Position getPosition(){
        return position;
    }

    public void setPosition(Position position){
        this.position = position;
    }

}
