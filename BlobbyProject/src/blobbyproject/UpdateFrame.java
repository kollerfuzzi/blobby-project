/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blobbyproject;

import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import javax.swing.JFrame;

/**
 *
 * @author alex
 */
public class UpdateFrame {

    BufferStrategy bstr;

    public UpdateFrame(BufferStrategy bstr) {
        this.bstr = bstr;
    }

    

    private void framesControlled() {

        Thread t;
        t = new Thread(() -> {

            long lastTime = System.nanoTime();
            double nsPerTick = 10E8 / 60D;
            int ticks = 0;
            int frames = 0;
            boolean shouldRender = true;
            long lastTimer = System.currentTimeMillis();
            double delta = 0;

            while (true) {
                long now = System.nanoTime();
                delta += (now - lastTime) / nsPerTick;
                lastTime = now;
                shouldRender = false;

                while (delta >= 1) {
                    ticks++;
                    tick();
                    //System.out.println(Thread.currentThread().getName());

                    delta -= 1;
                    shouldRender = true;
                }

                if (shouldRender) {
                    frames++;
                    render();
                }

                if (System.currentTimeMillis() - lastTimer >= 1000) {
                    lastTimer += 1000;
                    System.out.println("ticks: " + ticks + " frames: " + frames);
                    frames = 0;
                    ticks = 0;
                }

            }
        });
        t.setName("snake1234");
        t.start();
    }

    private void tick() {
        //do tick 
    }

    private void render() {
        //render image
    }
}
