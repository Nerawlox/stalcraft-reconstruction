/*
 * Decompiled with CFR 0.152.
 */
package com.bulletphysics.demos.opengl;

import com.bulletphysics.demos.opengl.DemoApplication;
import com.bulletphysics.demos.opengl.IGL;
import com.bulletphysics.demos.opengl.LwjglGL;
import org.lwjgl.LWJGLException;
import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.opengl.PixelFormat;

public class LWJGL {
    private static boolean redisplay = false;
    private static LwjglGL gl = new LwjglGL();

    public static void postRedisplay() {
        redisplay = true;
    }

    public static IGL getGL() {
        return gl;
    }

    public static int main(String[] args, int width, int height, String title, DemoApplication demoApp) throws LWJGLException {
        Display.setDisplayMode(new DisplayMode(width, height));
        Display.setTitle(title);
        Display.create(new PixelFormat(0, 24, 0));
        Keyboard.create();
        Keyboard.enableRepeatEvents(true);
        Mouse.create();
        gl.init();
        demoApp.myinit();
        demoApp.reshape(width, height);
        boolean quit = false;
        long lastTime = System.currentTimeMillis();
        int frames = 0;
        while (!Display.isCloseRequested() && !quit) {
            demoApp.moveAndDisplay();
            Display.update();
            int modifiers = 0;
            if (Keyboard.isKeyDown(42) || Keyboard.isKeyDown(54)) {
                modifiers |= 0x40;
            }
            if (Keyboard.isKeyDown(29) || Keyboard.isKeyDown(157)) {
                modifiers |= 0x80;
            }
            if (Keyboard.isKeyDown(219) || Keyboard.isKeyDown(220)) {
                modifiers |= 0x200;
            }
            while (Keyboard.next()) {
                if (Keyboard.getEventCharacter() != '\u0000') {
                    demoApp.keyboardCallback(Keyboard.getEventCharacter(), Mouse.getX(), Mouse.getY(), modifiers);
                }
                if (Keyboard.getEventKeyState()) {
                    demoApp.specialKeyboard(Keyboard.getEventKey(), Mouse.getX(), Mouse.getY(), modifiers);
                } else {
                    demoApp.specialKeyboardUp(Keyboard.getEventKey(), Mouse.getX(), Mouse.getY(), modifiers);
                }
                if (Keyboard.getEventKey() == 1) {
                    quit = true;
                }
                if (Keyboard.getEventKey() != 16) continue;
                quit = true;
            }
            while (Mouse.next()) {
                if (Mouse.getEventButton() != -1) {
                    int btn = Mouse.getEventButton();
                    if (btn == 1) {
                        btn = 2;
                    } else if (btn == 2) {
                        btn = 1;
                    }
                    demoApp.mouseFunc(btn, Mouse.getEventButtonState() ? 0 : 1, Mouse.getEventX(), Display.getDisplayMode().getHeight() - 1 - Mouse.getEventY());
                }
                demoApp.mouseMotionFunc(Mouse.getEventX(), Display.getDisplayMode().getHeight() - 1 - Mouse.getEventY());
            }
            long time = System.currentTimeMillis();
            if (time - lastTime < 1000L) {
                ++frames;
                continue;
            }
            Display.setTitle(title + " | FPS: " + frames);
            lastTime = time;
            frames = 0;
        }
        System.exit(0);
        return 0;
    }
}

