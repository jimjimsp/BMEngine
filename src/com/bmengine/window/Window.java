package com.bmengine.window;

import java.awt.Dimension;
import javax.swing.JFrame;

/*
    Setup for the games window. The specific title,
    screen size etc is called in the game class' main method. /J
 */

public class Window {

    public Window(int width, int height, String title, Game game) {
        game.setPreferredSize(new Dimension(width,height));
        game.setMaximumSize(new Dimension(width,height));
        game.setMinimumSize(new Dimension(width,height));

        JFrame frame = new JFrame(title);
        frame.add(game);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        game.start();
    }
}
