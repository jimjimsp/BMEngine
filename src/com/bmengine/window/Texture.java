package com.bmengine.window;

import java.awt.image.BufferedImage;

public class Texture {

    SpriteSheet player_spritesheet;
    private BufferedImage player_spritesheet_image;

    public BufferedImage[] player = new BufferedImage[23];

    public Texture() {

        BufferedImageLoader imageLoader = new BufferedImageLoader();

        try {
            player_spritesheet_image = imageLoader.loadImage("/images/player_spritesheet.png");
        } catch (Exception e) {
            System.out.println("!!! Failed to load buffered image in textures.");
            e.printStackTrace();
        }

        player_spritesheet = new SpriteSheet(player_spritesheet_image);

        getTextures();
    }

    private void getTextures(){
        // Walk left
        player[0] = player_spritesheet.grabImage(1,2, 62,120);
        player[1] = player_spritesheet.grabImage(2,2, 62,120);
        player[2] = player_spritesheet.grabImage(3,2, 62,120);
        player[3] = player_spritesheet.grabImage(4,2, 62,120);
        player[4] = player_spritesheet.grabImage(5,2, 62,120);
        player[5] = player_spritesheet.grabImage(6,2, 62,120);
        player[6] = player_spritesheet.grabImage(7,2, 62,120);
        player[7] = player_spritesheet.grabImage(8,2, 62,120);

        // Walk right
        player[8] = player_spritesheet.grabImage(1,1, 62,120);
        player[9] = player_spritesheet.grabImage(2,1, 62,120);
        player[10] = player_spritesheet.grabImage(3,1, 62,120);
        player[11] = player_spritesheet.grabImage(4,1, 62,120);
        player[12] = player_spritesheet.grabImage(5,1, 62,120);
        player[13] = player_spritesheet.grabImage(6,1, 62,120);
        player[14] = player_spritesheet.grabImage(7,1, 62,120);
        player[15] = player_spritesheet.grabImage(8,1, 62,120);

        //Still
        player[16] = player_spritesheet.grabImage(1,3, 62,120);
        player[17] = player_spritesheet.grabImage(2,3, 62,120);
        player[18] = player_spritesheet.grabImage(3,3, 62,120);
        player[19] = player_spritesheet.grabImage(4,3, 62,120);
        player[20] = player_spritesheet.grabImage(5,3, 62,120);
        player[21] = player_spritesheet.grabImage(6,3, 62,120);
        player[22] = player_spritesheet.grabImage(7,3, 62,120);
        player[22] = player_spritesheet.grabImage(8,3, 62,120);
    }
}
