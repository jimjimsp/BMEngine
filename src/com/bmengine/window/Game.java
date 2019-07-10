package com.bmengine.window;

import com.bmengine.framework.KeyInput;
import com.bmengine.primitives.Position;

import java.awt.*;
import java.awt.image.BufferStrategy;

/*

Handles most of the back end functionality, such as:
- Initialising game constants and objects (handler, camera, player etc)
- Start the game thread
- Start and run the game loop
- Creates a buffer strategy
- Call the tick and render methods of the handler
/J

 */

public class Game extends Canvas implements Runnable{

    private static final long serialVersionUID = 1L;
    public static int WIDTH, HEIGHT;

    private boolean running = false;
    private Thread thread;

    Handler handler;
    Camera camera;


    // Will initialise Game Objects such as Textures, Camera, Tick-handler etc. /J
    private void init(){
        WIDTH = getWidth();
        HEIGHT = getHeight();

        camera = new Camera(new Position(0,0));
        handler = new Handler(camera);
        handler.startGame();
        this.addKeyListener(new KeyInput(handler));
    }


    // Gets the thread going. /J
    public synchronized void start(){
        if(running)
            return;
        running = true;
        thread = new Thread(this);
        thread.start();
    }


    // This is the actual game loop.
    // It should tick approximately 60 times a sec /J
    public void run(){
        init();
        this.requestFocus();

        long last_update = System.nanoTime();
        double ticks_amount = 60.0;
        double nano_seconds = 1000000000 / ticks_amount;
        double delta = 0;
        long timer = System.currentTimeMillis();
        int updates = 0;
        int frames = 0;
        while(running){
            long now = System.nanoTime();
            delta += (now - last_update) / nano_seconds;
            last_update = now;
            while(delta >= 1){
                tick();
                updates++;
                delta--;
            }
            render();
            frames++;

            if(System.currentTimeMillis() - timer > 1000) {
                timer += 1000;
                System.out.println("FPS: " + frames + " TICKS: " + updates);
                frames = 0;
                updates = 0;
            }
        }
    }


    // This method calls the tick method of the handler,
    // which in turn (will) call all the game objects respective tick methods.
    private void tick(){

        handler.tick();

    }


    // Creates a buffer strategy, initialise the graphics,
    // and, as with the above tick method, calls the handlers render function.
    private void render(){

        BufferStrategy bufferStrategy = this.getBufferStrategy();

        if(bufferStrategy == null) {
            this.createBufferStrategy(2);
            return;
        }

        Graphics g = bufferStrategy.getDrawGraphics();
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, getWidth(), getHeight());

        Graphics2D g2d = (Graphics2D) g;

        g2d.setColor(Color.WHITE);

        // START CAMERA
        g2d.translate(camera.getPosition().getX(), camera.getPosition().getY());

            // Everything here will be rendered.
            // Though most things are handled by the handler. /J
            handler.render(g2d);

        // END CAMERA
        g2d.translate(-camera.getPosition().getX(), -camera.getPosition().getY());
        g.dispose();
        bufferStrategy.show();


    }


    // Set up window.
    public static void main(String args[]){
        new Window(800, 600, "Bad Moon Engine", new Game());
    }

}
