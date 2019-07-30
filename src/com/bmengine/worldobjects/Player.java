package com.bmengine.worldobjects;

import com.bmengine.framework.GameObject;
import com.bmengine.primitives.ObjectBounds;
import com.bmengine.primitives.Position;
import com.bmengine.window.Animation;
import com.bmengine.window.Game;
import com.bmengine.window.Handler;
import com.bmengine.window.Texture;

import java.awt.*;
import java.util.LinkedList;

public class Player extends WorldObject {

    private Position walkGoal = new Position(0,0);

    public Player(Position position, Handler handler, Texture texture) {
        super(position, "player", handler, new ObjectBounds(64,64));
    }

    public void tick(LinkedList<GameObject> objects){
        runAnimation();
        updateWalk();
        updateFacing();
        goalReached();
    }

    public void mouseClick(Position clickPosition) {

        walkGoal.setX(clickPosition.getY());
        walkGoal.setY(clickPosition.getY());

        double deltaX = clickPosition.getX()-position.getX();
        double deltaY = clickPosition.getY()-position.getY();
        double direction = Math.atan2(deltaY,deltaX);

        setVelDir(new Position(Math.cos(direction),  Math.sin(direction)));

    }

    private void goalReached() {
        if (Math.abs(position.getXDistance(walkGoal.getX())) < 20 && Math.abs(position.getYDistance(walkGoal.getY())) < 20) {
            setVelDir(new Position(0,0));
        }

    }
}
