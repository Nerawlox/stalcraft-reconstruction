/*
 * Decompiled with CFR 0.152.
 */
package com.bulletphysics.demos.applet;

import com.bulletphysics.BulletStats;
import com.bulletphysics.demos.applet.SoftwareGL;
import com.bulletphysics.demos.opengl.DemoApplication;
import com.bulletphysics.demos.opengl.GLDebugDrawer;
import com.bulletphysics.demos.opengl.IGL;
import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Composite;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import javax.swing.JPanel;
import javax.swing.Timer;

public class DemoPanel
extends JPanel {
    private DemoApplication demoApp;
    private boolean inited = false;
    private BufferedImage img;
    private SoftwareGL sgl;
    private Timer timer;
    private Font font = new Font("DialogInput", 0, 10);
    private AlphaComposite overlayComposite = AlphaComposite.getInstance(3, 0.5f);
    private Color overlayColor = new Color(0.6f, 0.6f, 0.6f, 1.0f);

    public DemoPanel() {
        this.sgl = new SoftwareGL();
        this.img = new BufferedImage(320, 240, 1);
        this.sgl.init(this.img);
        this.setFocusable(true);
        this.requestFocusInWindow();
        MouseHandler mh = new MouseHandler();
        this.addMouseListener(mh);
        this.addMouseMotionListener(mh);
        this.addKeyListener(new KeyListener(){

            @Override
            public void keyTyped(KeyEvent e) {
                if (e.getKeyChar() != '\uffff' && DemoPanel.this.demoApp != null) {
                    DemoPanel.this.demoApp.keyboardCallback(e.getKeyChar(), 0, 0, e.getModifiersEx());
                }
                DemoPanel.this.repaint();
            }

            @Override
            public void keyPressed(KeyEvent e) {
                if (DemoPanel.this.demoApp != null) {
                    DemoPanel.this.demoApp.specialKeyboard(this.convertKey(e.getKeyCode()), 0, 0, e.getModifiersEx());
                }
                DemoPanel.this.repaint();
            }

            @Override
            public void keyReleased(KeyEvent e) {
                if (DemoPanel.this.demoApp != null) {
                    DemoPanel.this.demoApp.specialKeyboardUp(this.convertKey(e.getKeyCode()), 0, 0, e.getModifiersEx());
                }
                DemoPanel.this.repaint();
            }

            private int convertKey(int code) {
                int key = 0;
                switch (code) {
                    case 37: {
                        key = 203;
                        break;
                    }
                    case 39: {
                        key = 205;
                        break;
                    }
                    case 38: {
                        key = 200;
                        break;
                    }
                    case 40: {
                        key = 208;
                        break;
                    }
                    case 116: {
                        key = 63;
                    }
                }
                return key;
            }
        });
        this.addComponentListener(new ComponentListener(){

            @Override
            public void componentResized(ComponentEvent e) {
                if (DemoPanel.this.img != null) {
                    DemoPanel.this.img.flush();
                }
                DemoPanel.this.img = new BufferedImage(DemoPanel.this.getWidth(), DemoPanel.this.getHeight(), 1);
                DemoPanel.this.sgl.init(DemoPanel.this.img);
                if (DemoPanel.this.demoApp != null) {
                    DemoPanel.this.demoApp.reshape(DemoPanel.this.getWidth(), DemoPanel.this.getHeight());
                }
                DemoPanel.this.repaint();
            }

            @Override
            public void componentMoved(ComponentEvent e) {
            }

            @Override
            public void componentShown(ComponentEvent e) {
            }

            @Override
            public void componentHidden(ComponentEvent e) {
            }
        });
        this.timer = new Timer(20, new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                DemoPanel.this.repaint();
            }
        });
    }

    public IGL getGL() {
        return this.sgl;
    }

    public void runDemo(DemoApplication app) {
        if (this.demoApp != null) {
            this.demoApp.destroy();
        }
        if (app == null) {
            this.timer.stop();
        }
        this.demoApp = app;
        this.demoApp.getDynamicsWorld().setDebugDrawer(new GLDebugDrawer(this.sgl));
        this.inited = false;
        this.timer.start();
    }

    @Override
    public void paint(Graphics g) {
        Graphics2D g2 = (Graphics2D)g;
        g2.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_OFF);
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_OFF);
        long t0 = System.nanoTime();
        if (this.demoApp != null) {
            if (!this.inited) {
                this.demoApp.myinit();
                this.demoApp.reshape(this.img.getWidth(), this.img.getHeight());
            }
            this.inited = true;
            BulletStats.updateTime = 0L;
            this.demoApp.clientMoveAndDisplay();
        }
        g.drawImage(this.img, 0, 0, null);
        if (this.demoApp != null) {
            long time = (System.nanoTime() - t0) / 1000000L;
            long physicsTime = BulletStats.stepSimulationTime;
            long updateTime = BulletStats.updateTime;
            long renderTime = time - physicsTime - updateTime;
            Composite comp = g2.getComposite();
            g2.setComposite(this.overlayComposite);
            g.setColor(this.overlayColor);
            g.fillRect(this.getWidth() - 135, this.getHeight() - 53, 130, 50);
            g2.setComposite(comp);
            g.setFont(this.font);
            g.setColor(Color.BLACK);
            g.drawString(" Render time: " + renderTime + " ms", this.getWidth() - 130, this.getHeight() - 40);
            g.drawString("Physics time: " + physicsTime + " ms", this.getWidth() - 130, this.getHeight() - 25);
            g.drawString(" Update time: " + updateTime + " ms", this.getWidth() - 130, this.getHeight() - 10);
        }
    }

    private class MouseHandler
    implements MouseListener,
    MouseMotionListener {
        private MouseHandler() {
        }

        @Override
        public void mouseClicked(MouseEvent e) {
        }

        @Override
        public void mouseEntered(MouseEvent e) {
        }

        @Override
        public void mouseExited(MouseEvent e) {
        }

        @Override
        public void mousePressed(MouseEvent e) {
            if (DemoPanel.this.demoApp != null) {
                DemoPanel.this.demoApp.mouseFunc(e.getButton() - 1, 0, e.getX(), e.getY());
            }
            DemoPanel.this.repaint();
            if (!DemoPanel.this.hasFocus()) {
                DemoPanel.this.requestFocusInWindow();
            }
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            if (DemoPanel.this.demoApp != null) {
                DemoPanel.this.demoApp.mouseFunc(e.getButton() - 1, 1, e.getX(), e.getY());
            }
            DemoPanel.this.repaint();
        }

        @Override
        public void mouseDragged(MouseEvent e) {
            if (DemoPanel.this.demoApp != null) {
                DemoPanel.this.demoApp.mouseMotionFunc(e.getX(), e.getY());
            }
            DemoPanel.this.repaint();
        }

        @Override
        public void mouseMoved(MouseEvent e) {
        }
    }
}

