package com.bmengine.framework;

import com.bmengine.window.Handler;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/*

Creates a key listener. As of now, I don't really know
what control scheme we're going to use. :-) /J

 */


public class KeyInput extends KeyAdapter {

    Handler handler;

    public KeyInput(Handler handler){
        this.handler = handler;
    }

    public void keyPressed(KeyEvent e){
        int key = e.getKeyCode();

        // Add key input actions here. /J
    }
}
