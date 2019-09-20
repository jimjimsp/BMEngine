package com.bmengine.framework;

import com.bmengine.primitives.Position;
import com.bmengine.window.Handler;
import com.bmengine.worldobjects.Player;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MouseInput extends MouseAdapter {

    private Handler handler;

    public MouseInput(Handler handler) {
        this.handler = handler;
    }

    public void mousePressed(MouseEvent e){

    }
    public void mouseClicked(MouseEvent e) {
        Position mousePosition = new Position(e.getX(), e.getY());
        //Get object at mousePosition
        int mouseButton = e.getButton();
        switch(mouseButton) {
            //Right click
            case 1:
                //Interact with object
                handler.mouseClicked(mousePosition); // temp method.
                break;
            //Left click
            case 3:
                //Inspect object
                handler.mouseClicked(mousePosition); // temp method.
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
