/*
 * Decompiled with CFR 0.152.
 */
package org.lwjgl.opengl;

import java.awt.Canvas;
import java.awt.Graphics;

final class MacOSXGLCanvas
extends Canvas {
    private static final long serialVersionUID = 6916664741667434870L;
    private boolean canvas_painted;
    private boolean dirty;

    MacOSXGLCanvas() {
    }

    public void update(Graphics g) {
        this.paint(g);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void paint(Graphics g) {
        MacOSXGLCanvas macOSXGLCanvas = this;
        synchronized (macOSXGLCanvas) {
            this.dirty = true;
            this.canvas_painted = true;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public boolean syncCanvasPainted() {
        boolean result2;
        MacOSXGLCanvas macOSXGLCanvas = this;
        synchronized (macOSXGLCanvas) {
            result2 = this.canvas_painted;
            this.canvas_painted = false;
        }
        return result2;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public boolean syncIsDirty() {
        boolean result2;
        MacOSXGLCanvas macOSXGLCanvas = this;
        synchronized (macOSXGLCanvas) {
            result2 = this.dirty;
            this.dirty = false;
        }
        return result2;
    }
}

