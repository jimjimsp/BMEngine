package com.bmengine.inventorysystem;

import com.bmengine.framework.GameObject;
import com.bmengine.primitives.ObjectBounds;
import com.bmengine.primitives.Position;
import com.bmengine.window.Handler;

import java.awt.*;
import java.util.LinkedList;

public class InventoryItem extends GameObject {

    private String id;

    public InventoryItem(Position position, String id, Handler handler, ObjectBounds objectBounds) {
        super(position, id, handler, objectBounds);
        this.id = id;

    }

    public String getId() {
        return id;
    }

    @Override
    public void tick(LinkedList<GameObject> objects) {

    }

    @Override
    public void render(Graphics g) {

    }
}
