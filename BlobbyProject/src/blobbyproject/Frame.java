/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blobbyproject;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashSet;
import java.util.Set;


import javax.swing.JFrame;

/**
 *
 * @author koller
 */
public class Frame extends JFrame implements KeyListener {

    private final Set<Integer> keys = new HashSet<>();
    private DataContainer cont = null;
    private GraphicsContainer gc;

    public Frame() {
    }

    /**
     * inits the JFrame: size etc.
     */
    public void init() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(800, 600);
        this.setLocationRelativeTo(null);
        this.addKeyListener(this);
        cont = new DataContainer(keys, this.getSize());
        gc = new GraphicsContainer(this.getSize());

        framesControlled();

    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        keys.add(e.getKeyCode());
    }

    @Override
    public void keyReleased(KeyEvent e) {
        keys.remove(e.getKeyCode());
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
        cont.update();
    }

    private void render() {
        cont.draw(gc.getG2());
    }

}
