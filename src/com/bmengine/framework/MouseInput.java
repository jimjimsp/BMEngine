package com.bmengine.framework;

import com.bmengine.primitives.Position;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MouseInput extends MouseAdapter {

    public void mousePressed(MouseEvent e){

    }
    public void mouseClicked(MouseEvent e) {
        Position mousePosition = new Position(e.getX(), e.getY());
        //Get object at mousePosition
        int mouseButton = e.getButton();
        switch(mouseButton) {
            case 1:
                //Interact with object
                break;

            case 2:
                //Inspect object
                break;
        }
    }

    public void mouseEntered(MouseEvent e) {

    }
    public void mouseExited(MouseEvent e) {

    }
    public void mouseReleased(MouseEvent e) {

    }
}
