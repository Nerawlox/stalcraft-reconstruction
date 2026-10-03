/*
 * Decompiled with CFR 0.152.
 */
package com.bulletphysics.demos.applet;

import com.bulletphysics.demos.applet.Graphics3D;

public class Quadric {
    public static final int GLU_FILL = 1;
    public static final int GLU_OUTSIDE = 2;
    public static final int GLU_SMOOTH = 3;
    public static final int GLU_INSIDE = 4;
    public static final int GLU_POINT = 5;
    public static final int GLU_LINE = 6;
    public static final int GLU_SILHOUETTE = 7;
    public static final int GLU_NONE = 8;
    protected int drawStyle = 1;
    protected int orientation = 2;
    protected boolean textureFlag = false;
    protected int normals = 3;

    protected void normal3f(Graphics3D gl, float x, float y, float z) {
        float mag = (float)Math.sqrt(x * x + y * y + z * z);
        if (mag > 1.0E-5f) {
            x /= mag;
            y /= mag;
            z /= mag;
        }
        gl.setNormal(x, y, z);
    }

    public void setDrawStyle(int drawStyle) {
        this.drawStyle = drawStyle;
    }

    public void setNormals(int normals) {
        this.normals = normals;
    }

    public void setOrientation(int orientation) {
        this.orientation = orientation;
    }

    public void setTextureFlag(boolean textureFlag) {
        this.textureFlag = textureFlag;
    }

    public int getDrawStyle() {
        return this.drawStyle;
    }

    public int getNormals() {
        return this.normals;
    }

    public int getOrientation() {
        return this.orientation;
    }

    public boolean getTextureFlag() {
        return this.textureFlag;
    }

    protected void TXTR_COORD(Graphics3D gl, float x, float y) {
    }

    protected float sin(float r) {
        return (float)Math.sin(r);
    }

    protected float cos(float r) {
        return (float)Math.cos(r);
    }
}

