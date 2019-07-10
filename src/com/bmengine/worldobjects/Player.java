package com.bmengine.worldobjects;

import com.bmengine.framework.GameObject;
import com.bmengine.primitives.Position;
import com.bmengine.window.Animation;
import com.bmengine.window.Game;
import com.bmengine.window.Handler;
import com.bmengine.window.Texture;

import java.awt.*;
import java.util.LinkedList;

public class Player extends GameObject {
    private float width, height = 64;

    private Handler handler;
    Texture texture = Game.getInstance();
    private Animation player_walk_left;
    private Animation player_walk_right;
    Position velDir;


    public Player(Position position, String name, Handler handler, Position velDir) {
        super(position, name);
        this.velDir = velDir;
        this.handler = handler;
        player_walk_right =  new Animation(5, texture.player[0],texture.player[1],texture.player[2]);
        player_walk_left =  new Animation(5, texture.player[3],texture.player[4],texture.player[5]);
    }

    public void tick(LinkedList<GameObject> objects){

        position.setX(position.getX() + velDir.getX());
        position.setY(position.getY() + velDir.getY());

        player_walk_right.runAnimation();
        player_walk_left.runAnimation();
    }

    public void render(Graphics g) {

            if(velDir.getX() != 0){
                if(velDir.getX() > 0){
                    player_walk_right.drawAnimation(g, position);
                    facing = 'l';
                }
                else if (velDir.getX() < 0){
                    player_walk_left.drawAnimation(g, position);
                    facing = 'r';
                }
            }
            else {
                if (facing == 'l'){
                    g.drawImage(texture.player[0], position.getX(),position.getX(),null);
                }
                else {
                    g.drawImage(texture.player[4], position.getX(),position.getX(),null);
                }
            }

    }
}
