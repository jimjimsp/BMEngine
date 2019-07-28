package com.bmengine.inventorysystem;

import com.bmengine.primitives.ObjectBounds;
import com.bmengine.primitives.Position;

import java.util.ArrayList;

public class Inventory {

    private ArrayList<InventoryItem> items;
    private ArrayList<Position> inventorySlotPositions;
    private ObjectBounds inventorySize;

    /**
     * Creates an inventory with set slot positions
     *
     * @param inventorySize - Size of inventory
     * @param itemSize - Size of individual items
     */
    public Inventory(ObjectBounds inventorySize, ObjectBounds itemSize){
        items = new ArrayList<>();
        this.inventorySize = inventorySize;
        setInventorySlotPositions(itemSize);
    }

    /**
     * Adds item to items list and repositions all items
     *
     * @param item - Item to be added
     */
    public void addItem(InventoryItem item){
        items.add(item);
        positionItems();
    }

    /**
     * Removes item from items list and repositions all items
     *
     * @param item - Item to be removed
     */
    public void removeItem(InventoryItem item){

        String id = item.getId();
        for(int i = 0; i < items.size(); i++) {
            if (id.equals(items.get(i).getId())) {
                items.remove(i);
                positionItems();
                return;
            }
        }
    }

    /**
     * Sets position of all items
     */
    private void positionItems(){
        for (int i = 0; i < items.size(); i++) {
            items.get(i).setPosition(inventorySlotPositions.get(i));
        }
    }

    /**
     * Sets inventory slot positions depending on size of inventory and individual items
     *
     * @param itemSize - Size of individual items
     */
    private void setInventorySlotPositions(ObjectBounds itemSize){

        inventorySlotPositions = new ArrayList<>();

        float inventorySlotsRows = (float)inventorySize.getHeight()/itemSize.getHeight();
        float inventorySlotsColumns = (float)inventorySize.getWidth()/itemSize.getWidth();
        for(int i = 0; i < inventorySlotsRows; i++){
            for(int j = 0; j < inventorySlotsColumns; j++){
                int column = j*itemSize.getWidth();
                int row = i*itemSize.getHeight();
                inventorySlotPositions.add(new Position(column, row));
            }
        }
    }
}
