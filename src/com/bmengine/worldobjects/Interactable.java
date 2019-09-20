package com.bmengine.worldobjects;

import com.bmengine.primitives.Interaction;
import com.bmengine.primitives.ObjectBounds;
import com.bmengine.primitives.Position;
import com.bmengine.window.Animation;
import com.bmengine.window.BufferedImageLoader;
import com.bmengine.window.Handler;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Interactable extends WorldObject {

    BufferedImageLoader imageLoader;
    Map<String, BufferedImage> animations = new HashMap<>();

    private String name;
    private String[] possibleStates;
    private Map<String, String> descriptions;
    private ArrayList<Interaction> interactions;

    private String currState;

    public Interactable(String name, String id, String[] states, Position position, int width, int height, Map<String, String> descriptions, ArrayList<Interaction> interactions, Handler handler) {
        super(position, id, handler, new ObjectBounds(width,height));

        this.name = name;
        this.interactions = interactions;
        this.descriptions = descriptions;
        this.possibleStates = new String[states.length];

        for (int i = 0; i<states.length; i++){ this.possibleStates[i] = states[i]; }

        this.currState = possibleStates[0];
    }

    public void render(Graphics g) {
        g.drawImage(animations.get(currState), (int) position.getX(), (int) position.getY(), null);
    }



    public void printInfo() {
        System.out.println("\nINTERACTABLE");
        System.out.println("__name : " + name);
        System.out.println("__id : " + id);
        System.out.println("__states : ");
        for (int i=0;i<possibleStates.length;i++){System.out.println("___state : " + possibleStates[i]);}
        System.out.println("__spawn position : (" + position.getX() + " , " + position.getY() + ")");
        System.out.println("__size : " + bounds.getHeight() + " x " + bounds.getWidth());
        System.out.println("__descriptions : " + descriptions);
        for (int i=0;i<interactions.size();i++) {
            interactions.get(i).printInfo();
        }

    }

}
