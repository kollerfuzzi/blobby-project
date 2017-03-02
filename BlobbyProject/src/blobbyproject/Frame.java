/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blobbyproject;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferStrategy;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author koller
 */
public class Frame extends JFrame implements KeyListener {

    private final Set<Integer> keys = new HashSet<>();
    private Game cont = null;
    private GraphicsContainer gc;

    public Frame() {
        init();
    }

    /**
     * inits the JFrame: size etc.
     */
    public final void init() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(800, 600);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.addKeyListener(this);
        cont = new Game(keys, this.getSize());
        gc = new GraphicsContainer(this.getSize());
        setVisible(true);
    }

    public void startFrameController() {
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
            try {
                Thread.sleep(100);
            } catch (InterruptedException ex) {
                Logger.getLogger(Frame.class.getName()).log(Level.SEVERE, null, ex);
            }
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
                    //System.out.println("ticks: " + ticks + " frames: " + frames);
                    frames = 0;
                    ticks = 0;
                }

            }
        });
        t.setName("ourMainThread");
        t.start();
    }

    private void tick() {
        cont.update();
    }

    private void render() {
        cont.draw(gc.getG2());

        BufferStrategy bs = this.getBufferStrategy();

        if (bs == null) {
            this.createBufferStrategy(3);
            //this.createBufferStrategy(3);
            System.out.println("create BS");
        } else {
            Graphics g = bs.getDrawGraphics();

            g.drawImage(gc.getImage(), 0, 0, this.getWidth(), this.getHeight(), null);
            g.dispose();
            bs.show();
        }
    }

}
