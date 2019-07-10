package com.bmengine.window;

import java.awt.image.BufferedImage;

public class Texture {

    SpriteSheet player_spritesheet;
    private BufferedImage player_spritesheet_image;

    public BufferedImage[] player = null;

    public Texture() {

        BufferedImageLoader imageLoader = new BufferedImageLoader();

        try {
            player_spritesheet_image = imageLoader.loadImage("/src/res/temp_player_spreadsheet.png");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("!!! Failed to load buffered image in textures.");
        }

        player_spritesheet = new SpriteSheet(player_spritesheet_image);

        getTextures();
    }

    private void getTextures(){
        player[0] = player_spritesheet.grabImage(0,2, 64,64);
        player[1] = player_spritesheet.grabImage(1,2, 64,64);
        player[2] = player_spritesheet.grabImage(2,2, 64,64);

        player[3] = player_spritesheet.grabImage(0,4, 64,64);
        player[4] = player_spritesheet.grabImage(1,4, 64,64);
        player[5] = player_spritesheet.grabImage(2,4, 64,64);

    }
}
