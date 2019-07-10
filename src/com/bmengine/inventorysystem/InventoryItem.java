package com.bmengine.inventorysystem;

import com.bmengine.framework.GameObject;
import com.bmengine.primitives.ObjectBounds;
import com.bmengine.primitives.Position;
import com.bmengine.window.Handler;

import java.awt.*;
import java.util.LinkedList;

public class InventoryItem extends GameObject {

    public InventoryItem(Position position, String id, Handler handler, ObjectBounds objectBounds) {
        super(position, id, handler, objectBounds);


    }

    @Override
    public void tick(LinkedList<GameObject> objects) {

    }

    @Override
    public void render(Graphics g) {

    }
}
