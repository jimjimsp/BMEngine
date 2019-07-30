package com.bmengine.window;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Map;

import com.bmengine.framework.GameObject;
import com.bmengine.framework.XMLParser;
import com.bmengine.primitives.Position;
import com.bmengine.worldobjects.Interactable;
import com.bmengine.worldobjects.Player;


/*

The handler collects all current game objects in a linked list.
When the tick and render methods of this class are called,
all of the game objects are iterated through and ticked/rendered.
/J

 */

public class Handler {

    public LinkedList<GameObject> objects = new LinkedList<GameObject>();

    private GameObject tempObject;
    private Camera camera;
    private Player player;
    private Map<String, Interactable> interactables;
    private XMLParser xmlParser;

    private BufferedImage tempImage = null;

    public Handler(Camera camera){
        this.camera = camera;

        BufferedImageLoader loader = new BufferedImageLoader();
    }


    // Iterates through and ticks all current game objects. /J
    public void tick(){
        for(int i = 0; i < objects.size(); i++){
            tempObject = objects.get(i);
            tempObject.tick(objects); //tempObject kanske e onödigt, bah ta objects.get(i).tick() - E
        }
    }


    // Iterates through and renders all current game objects. /J
    public void render(Graphics g){
        for(int i = 0; i < objects.size(); i++){
            tempObject = objects.get(i);
            tempObject.render(g);
        }
    }


    // Called when the game starts.
    // Should fetch all of the start screens image resources. /J
    public void startGame(){
        player = new Player(new Position(0,0), this, Game.getInstance());
        xmlParser = new XMLParser(this);
        interactables = xmlParser.parseInteractables("res/interactables.xml");
        addObject(player);

        interactables.forEach((key,value) -> interactables.get(key).printInfo());
    }

    public void mouseClicked(Position clickPosition) {
        player.mouseClick(clickPosition);
    }

    // Add a game object to the list of current game objects. /J
    public void addObject(GameObject object){
        this.objects.add(object);
    }


    // Removes a game object to the list of current game objects. /J
    public void removeObject(GameObject object){
        this.objects.remove(object);
    }
}
