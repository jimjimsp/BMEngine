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

/*

Stand/default animation -> animations[0]
Walk right       -> animations[1]
Walk left      -> animations[2]

*/

public class WorldObject extends GameObject{

    private Position velDir = new Position(0,0);
    private char facing = 'r';
    private String actionState = "default";

    private Animation[] animations;

    public WorldObject(Position position, String id, Handler handler, ObjectBounds bounds) {
        super(position, id, handler, bounds);

    }

    public void tick(LinkedList<GameObject> objects){
        runAnimation();
        updateWalk();
        updateFacing();

    }

    public void render(Graphics g) {
    }

    public void updateFacing(){

        if (velDir.getX() < 0){
            facing = 'l';
        }
        else if(velDir.getX() > 0){
            facing = 'r';
        }
    }

    public void updateWalk(){
        position.setX(position.getX() + velDir.getX());
        position.setY(position.getY() + velDir.getY());
    }

    public void runAnimation(){
    }

    public Position getVelDir() {
        return velDir;
    }

    public void setVelDir(Position velDir) {
        this.velDir = velDir;
    }

    public char getFacing() {
        return facing;
    }

    public void setFacing(char facing) {
        this.facing = facing;
    }

    public String getActionState() {
        return actionState;
    }

    public void setActionState(String actionState) {
        this.actionState = actionState;
    }

    public Animation[] getAnimations() {
        return animations;
    }

    public void setAnimations(Animation[] animations) {
        this.animations = animations;
    }
}

