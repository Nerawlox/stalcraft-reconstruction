/*
 * Decompiled with CFR 0.152.
 */
package org.lwjgl.opengl;

import java.awt.Canvas;
import java.awt.Container;
import java.awt.Insets;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.nio.ByteBuffer;
import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.AWTSurfaceLock;
import org.lwjgl.opengl.ContextAttribs;
import org.lwjgl.opengl.MacOSXPeerInfo;
import org.lwjgl.opengl.PixelFormat;

abstract class MacOSXCanvasPeerInfo
extends MacOSXPeerInfo {
    private final AWTSurfaceLock awt_surface = new AWTSurfaceLock();
    public ByteBuffer window_handle;

    protected MacOSXCanvasPeerInfo(PixelFormat pixel_format, ContextAttribs attribs, boolean support_pbuffer) throws LWJGLException {
        super(pixel_format, attribs, true, true, support_pbuffer, true);
    }

    protected void initHandle(Canvas component) throws LWJGLException {
        Insets insets;
        boolean forceCALayer = true;
        String javaVersion = System.getProperty("java.version");
        if (javaVersion.startsWith("1.5") || javaVersion.startsWith("1.6")) {
            forceCALayer = false;
        }
        int top = (insets = this.getInsets(component)) != null ? insets.top : 0;
        int left = insets != null ? insets.left : 0;
        this.window_handle = MacOSXCanvasPeerInfo.nInitHandle(this.awt_surface.lockAndGetHandle(component), this.getHandle(), this.window_handle, forceCALayer, component.getX() - left, component.getY() - top);
        if (javaVersion.startsWith("1.7")) {
            this.addComponentListener(component);
        }
    }

    private void addComponentListener(final Canvas component) {
        ComponentListener[] components = component.getComponentListeners();
        for (int i = 0; i < components.length; ++i) {
            ComponentListener c = components[i];
            if (c.toString() != "CanvasPeerInfoListener") continue;
            return;
        }
        ComponentListener comp = new ComponentListener(){

            public void componentHidden(ComponentEvent e) {
            }

            public void componentMoved(ComponentEvent e) {
                Insets insets = MacOSXCanvasPeerInfo.this.getInsets(component);
                int top = insets != null ? insets.top : 0;
                int left = insets != null ? insets.left : 0;
                MacOSXCanvasPeerInfo.nSetLayerPosition(MacOSXCanvasPeerInfo.this.getHandle(), component.getX() - left, component.getY() - top);
            }

            public void componentResized(ComponentEvent e) {
                Insets insets = MacOSXCanvasPeerInfo.this.getInsets(component);
                int top = insets != null ? insets.top : 0;
                int left = insets != null ? insets.left : 0;
                MacOSXCanvasPeerInfo.nSetLayerPosition(MacOSXCanvasPeerInfo.this.getHandle(), component.getX() - left, component.getY() - top);
            }

            public void componentShown(ComponentEvent e) {
            }

            public String toString() {
                return "CanvasPeerInfoListener";
            }
        };
        component.addComponentListener(comp);
    }

    private static native ByteBuffer nInitHandle(ByteBuffer var0, ByteBuffer var1, ByteBuffer var2, boolean var3, int var4, int var5) throws LWJGLException;

    private static native void nSetLayerPosition(ByteBuffer var0, int var1, int var2);

    protected void doUnlock() throws LWJGLException {
        this.awt_surface.unlock();
    }

    private Insets getInsets(Canvas component) {
        for (Container parent = component.getParent(); parent != null; parent = parent.getParent()) {
            if (!(parent instanceof Container)) continue;
            return parent.getInsets();
        }
        return null;
    }
}

