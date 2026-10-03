/*
 * Decompiled with CFR 0.152.
 */
package com.bulletphysics.demos.opengl;

import com.bulletphysics.demos.opengl.IGL;
import com.bulletphysics.linearmath.IDebugDraw;
import javax.vecmath.Vector3f;

public class GLDebugDrawer
extends IDebugDraw {
    private static final boolean DEBUG_NORMALS = false;
    private IGL gl;
    private int debugMode;
    private final Vector3f tmpVec = new Vector3f();

    public GLDebugDrawer(IGL gl) {
        this.gl = gl;
    }

    @Override
    public void drawLine(Vector3f from, Vector3f to, Vector3f color) {
        if (this.debugMode > 0) {
            this.gl.glBegin(1);
            this.gl.glColor3f(color.x, color.y, color.z);
            this.gl.glVertex3f(from.x, from.y, from.z);
            this.gl.glVertex3f(to.x, to.y, to.z);
            this.gl.glEnd();
        }
    }

    @Override
    public void setDebugMode(int debugMode) {
        this.debugMode = debugMode;
    }

    @Override
    public void draw3dText(Vector3f location, String textString) {
    }

    @Override
    public void reportErrorWarning(String warningString) {
        System.err.println(warningString);
    }

    @Override
    public void drawContactPoint(Vector3f pointOnB, Vector3f normalOnB, float distance, int lifeTime, Vector3f color) {
        if ((this.debugMode & 8) != 0) {
            Vector3f to = this.tmpVec;
            to.scaleAdd(distance * 100.0f, normalOnB, pointOnB);
            Vector3f from = pointOnB;
            this.gl.glBegin(1);
            this.gl.glColor3f(color.x, color.y, color.z);
            this.gl.glVertex3f(from.x, from.y, from.z);
            this.gl.glVertex3f(to.x, to.y, to.z);
            this.gl.glEnd();
        }
    }

    @Override
    public int getDebugMode() {
        return this.debugMode;
    }
}

