package com.bmengine.window;

import com.bmengine.primitives.Position;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Animation {

    private int speed, numFrames;
    private int index, count = 0;

    private BufferedImage[] images;
    private BufferedImage currentImg;

    public Animation(int speed, BufferedImage... args ){
        this.speed = speed;
        images = new BufferedImage[args.length];

        for (int i = 0; i<args.length; i++){
            images[i] = args[i];
        }

        numFrames = args.length;
    }

    public void runAnimation() {
        index++;
        if(index > speed){
            index = 0;
            nextFrame();
        }
    }

    private void nextFrame(){
        currentImg = images[count%numFrames];
        count++;
    }

    public void drawAnimation(Graphics g, Position position) {
        g.drawImage(currentImg, position.getX(), position.getY(), null);
    }

}
