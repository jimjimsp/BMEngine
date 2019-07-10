package com.bmengine.window;

import java.awt.image.BufferedImage;

public class Texture {

    SpriteSheet player_spritesheet;
    private BufferedImage player_spritesheet_image;

    public BufferedImage[] player = new BufferedImage[7];

    public Texture() {

        BufferedImageLoader imageLoader = new BufferedImageLoader();

        try {
            player_spritesheet_image = imageLoader.loadImage("/temp_player_spreadsheet.png");
        } catch (Exception e) {
            System.out.println("!!! Failed to load buffered image in textures.");
            e.printStackTrace();
        }

        player_spritesheet = new SpriteSheet(player_spritesheet_image);

        getTextures();
    }

    private void getTextures(){
        // Walk left
        player[0] = player_spritesheet.grabImage(1,2, 64,64);
        player[1] = player_spritesheet.grabImage(2,2, 64,64);
        player[2] = player_spritesheet.grabImage(3,2, 64,64);

        // Walk right
        player[3] = player_spritesheet.grabImage(1,4, 64,64);
        player[4] = player_spritesheet.grabImage(2,4, 64,64);
        player[5] = player_spritesheet.grabImage(3,4, 64,64);

        //Still
        player[6] = player_spritesheet.grabImage(1,3, 64,64);
    }
}
