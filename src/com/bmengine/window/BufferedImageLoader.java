package com.bmengine.window;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;


/*

Here the image resources of the game is fetched
and returned as buffered images.
/J

 */

public class BufferedImageLoader {

    private BufferedImage image;

    public BufferedImage loadImage(String path){
        try {
            image = ImageIO.read(getClass().getResource(path));
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Coulnd not read image file. Check path.");
        }
        return image;
    }
}
