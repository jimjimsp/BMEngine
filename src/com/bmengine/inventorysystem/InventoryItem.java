package com.bmengine.inventorysystem;

import com.bmengine.framework.GameObject;
import com.bmengine.framework.ObjectID;
import com.bmengine.primitives.ObjectBounds;
import com.bmengine.primitives.Position;
import com.bmengine.window.Animation;
import com.bmengine.window.Handler;

import java.awt.*;
import java.util.ArrayList;
import java.util.LinkedList;

public class InventoryItem extends GameObject {
    //Attributes
    private String name;
    private String image;
    private String description;
    private ArrayList<ObjectID> combinations;

    //Constructor
    public InventoryItem(Position position, String id, Handler handler, ObjectBounds bounds, String name, String image, String description, ArrayList<ObjectID> combinations) {
        super(position, id, handler, bounds);
        this.name = name;
        this.image = image;
        this.description = description;
        this.combinations = combinations;
    }

    //Properties
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ArrayList<ObjectID> getCombinations() {
        return combinations;
    }

    public void setCombinations(ArrayList<ObjectID> combinations) {
        this.combinations = combinations;
    }


    //Methods
    @Override
    public void tick(LinkedList<GameObject> objects) {

    }

    @Override
    public void render(Graphics g) {

    }
}
