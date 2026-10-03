/*
 * Decompiled with CFR 0.152.
 */
package com.bulletphysics.demos.opengl;

public interface IGL {
    public static final int GL_LIGHT0 = 16384;
    public static final int GL_LIGHT1 = 16385;
    public static final int GL_AMBIENT = 4608;
    public static final int GL_DIFFUSE = 4609;
    public static final int GL_SPECULAR = 4610;
    public static final int GL_POSITION = 4611;
    public static final int GL_LIGHTING = 2896;
    public static final int GL_SMOOTH = 7425;
    public static final int GL_DEPTH_TEST = 2929;
    public static final int GL_LESS = 513;
    public static final int GL_MODELVIEW = 5888;
    public static final int GL_PROJECTION = 5889;
    public static final int GL_COLOR_BUFFER_BIT = 16384;
    public static final int GL_DEPTH_BUFFER_BIT = 256;
    public static final int GL_POINTS = 0;
    public static final int GL_LINES = 1;
    public static final int GL_TRIANGLES = 4;
    public static final int GL_COLOR_MATERIAL = 2903;
    public static final int GL_QUADS = 7;

    public void glLight(int var1, int var2, float[] var3);

    public void glEnable(int var1);

    public void glDisable(int var1);

    public void glShadeModel(int var1);

    public void glDepthFunc(int var1);

    public void glClearColor(float var1, float var2, float var3, float var4);

    public void glMatrixMode(int var1);

    public void glLoadIdentity();

    public void glFrustum(double var1, double var3, double var5, double var7, double var9, double var11);

    public void gluLookAt(float var1, float var2, float var3, float var4, float var5, float var6, float var7, float var8, float var9);

    public void glViewport(int var1, int var2, int var3, int var4);

    public void glPushMatrix();

    public void glPopMatrix();

    public void gluOrtho2D(float var1, float var2, float var3, float var4);

    public void glScalef(float var1, float var2, float var3);

    public void glTranslatef(float var1, float var2, float var3);

    public void glColor3f(float var1, float var2, float var3);

    public void glClear(int var1);

    public void glBegin(int var1);

    public void glEnd();

    public void glVertex3f(float var1, float var2, float var3);

    public void glLineWidth(float var1);

    public void glPointSize(float var1);

    public void glNormal3f(float var1, float var2, float var3);

    public void glMultMatrix(float[] var1);

    public void drawCube(float var1);

    public void drawSphere(float var1, int var2, int var3);

    public void drawCylinder(float var1, float var2, int var3);

    public void drawString(CharSequence var1, int var2, int var3, float var4, float var5, float var6);
}

