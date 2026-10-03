/*
 * Decompiled with CFR 0.152.
 */
package com.bulletphysics.demos.applet;

import com.bulletphysics.demos.applet.Cylinder;
import com.bulletphysics.demos.applet.Disk;
import com.bulletphysics.demos.applet.Graphics3D;
import com.bulletphysics.demos.applet.Light;
import com.bulletphysics.demos.applet.Sphere;
import com.bulletphysics.demos.applet.Utils;
import com.bulletphysics.demos.opengl.IGL;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;
import javax.vecmath.Matrix4f;

public class SoftwareGL
implements IGL {
    private Graphics3D gl;
    private int matrixMode = 5888;
    private Matrix4f tmpMat = new Matrix4f();
    private Graphics g;
    private Sphere sphere = new Sphere();
    private Cylinder cylinder = new Cylinder();
    private Disk disk = new Disk();

    public SoftwareGL() {
        this.gl = new Graphics3D();
    }

    public void init(BufferedImage img) {
        this.gl.init(((DataBufferInt)img.getRaster().getDataBuffer()).getData(), img.getWidth(), img.getHeight());
        this.g = img.getGraphics();
        this.g.setFont(new Font("Dialog", 0, 10));
        this.g.setColor(Color.BLACK);
        Graphics2D g2 = (Graphics2D)this.g;
        g2.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_OFF);
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_OFF);
    }

    @Override
    public void glViewport(int x, int y, int width, int height) {
    }

    @Override
    public void glLight(int light, int pname, float[] params) {
        Light l = this.gl.getLight(light - 16384);
        switch (pname) {
            case 4608: {
                l.ambient.set(params);
                break;
            }
            case 4609: {
                l.diffuse.set(params);
                break;
            }
            case 4610: {
                l.specular.set(params);
                break;
            }
            case 4611: {
                l.position.set(params);
                if (l.position.w != 0.0f) break;
                float invlen = 1.0f / (float)Math.sqrt(l.position.x * l.position.x + l.position.y * l.position.y + l.position.z * l.position.z);
                l.position.x *= invlen;
                l.position.y *= invlen;
                l.position.z *= invlen;
            }
        }
    }

    @Override
    public void glEnable(int cap) {
        if (cap >= 16384 && cap <= 16385) {
            this.gl.getLight((int)(cap - 16384)).enabled = true;
            return;
        }
        switch (cap) {
            case 2896: {
                this.gl.setLightingEnabled(true);
            }
        }
    }

    @Override
    public void glDisable(int cap) {
        if (cap >= 16384 && cap <= 16385) {
            this.gl.getLight((int)(cap - 16384)).enabled = false;
            return;
        }
        switch (cap) {
            case 2896: {
                this.gl.setLightingEnabled(false);
            }
        }
    }

    @Override
    public void glShadeModel(int mode) {
    }

    @Override
    public void glDepthFunc(int func) {
    }

    @Override
    public void glClearColor(float red, float green, float blue, float alpha) {
        this.gl.setClearColor(red, red, blue);
    }

    @Override
    public void glMatrixMode(int mode) {
        this.matrixMode = mode;
    }

    private void setMatrix(Matrix4f mat) {
        switch (this.matrixMode) {
            case 5888: {
                this.gl.setViewMatrix(mat);
                break;
            }
            case 5889: {
                this.gl.setProjMatrix(mat);
                break;
            }
            default: {
                throw new IllegalStateException();
            }
        }
    }

    private void mulMatrix(Matrix4f mat) {
        switch (this.matrixMode) {
            case 5888: {
                this.gl.mulViewMatrix(mat);
                break;
            }
            case 5889: {
                this.gl.mulProjMatrix(mat);
                break;
            }
            default: {
                throw new IllegalStateException();
            }
        }
    }

    @Override
    public void glLoadIdentity() {
        this.tmpMat.setIdentity();
        this.setMatrix(this.tmpMat);
    }

    @Override
    public void glFrustum(double left, double right, double bottom, double top, double zNear, double zFar) {
        Utils.setFrustum(this.tmpMat, (float)left, (float)right, (float)bottom, (float)top, (float)zNear, (float)zFar);
        this.mulMatrix(this.tmpMat);
    }

    @Override
    public void gluLookAt(float eyex, float eyey, float eyez, float centerx, float centery, float centerz, float upx, float upy, float upz) {
        Utils.setLookAt(this.tmpMat, eyex, eyey, eyez, centerx, centery, centerz, upx, upy, upz);
        this.mulMatrix(this.tmpMat);
    }

    @Override
    public void glPushMatrix() {
        if (this.matrixMode == 5888) {
            this.gl.pushViewMatrix();
        }
    }

    @Override
    public void glPopMatrix() {
        if (this.matrixMode == 5888) {
            this.gl.popViewMatrix();
        }
    }

    @Override
    public void gluOrtho2D(float left, float right, float bottom, float top) {
    }

    @Override
    public void glScalef(float x, float y, float z) {
        this.tmpMat.setIdentity();
        this.tmpMat.m00 = x;
        this.tmpMat.m11 = y;
        this.tmpMat.m22 = z;
        this.mulMatrix(this.tmpMat);
    }

    @Override
    public void glTranslatef(float x, float y, float z) {
        this.tmpMat.setIdentity();
        this.tmpMat.m03 = x;
        this.tmpMat.m13 = y;
        this.tmpMat.m23 = z;
        this.mulMatrix(this.tmpMat);
    }

    @Override
    public void glColor3f(float red, float green, float blue) {
        this.gl.setColor(red, green, blue);
    }

    @Override
    public void glClear(int glMask) {
        int mask = 0;
        if ((glMask & 0x4000) != 0) {
            mask |= 1;
        }
        if ((glMask & 0x100) != 0) {
            mask |= 2;
        }
        this.gl.clear(mask);
    }

    @Override
    public void glBegin(int mode) {
        switch (mode) {
            case 1: {
                this.gl.begin(5);
                break;
            }
            case 4: {
                this.gl.begin(1);
                break;
            }
            case 7: {
                this.gl.begin(3);
                break;
            }
            default: {
                throw new IllegalArgumentException();
            }
        }
    }

    @Override
    public void glEnd() {
        this.gl.end();
    }

    @Override
    public void glVertex3f(float x, float y, float z) {
        this.gl.addVertex(x, y, z);
    }

    @Override
    public void glLineWidth(float width) {
    }

    @Override
    public void glPointSize(float size) {
    }

    @Override
    public void glNormal3f(float nx, float ny, float nz) {
        this.gl.setNormal(nx, ny, nz);
    }

    @Override
    public void glMultMatrix(float[] m) {
        this.tmpMat.m00 = m[0];
        this.tmpMat.m10 = m[1];
        this.tmpMat.m20 = m[2];
        this.tmpMat.m30 = m[3];
        this.tmpMat.m01 = m[4];
        this.tmpMat.m11 = m[5];
        this.tmpMat.m21 = m[6];
        this.tmpMat.m31 = m[7];
        this.tmpMat.m02 = m[8];
        this.tmpMat.m12 = m[9];
        this.tmpMat.m22 = m[10];
        this.tmpMat.m32 = m[11];
        this.tmpMat.m03 = m[12];
        this.tmpMat.m13 = m[13];
        this.tmpMat.m23 = m[14];
        this.tmpMat.m33 = m[15];
        this.mulMatrix(this.tmpMat);
    }

    @Override
    public void drawCube(float extent) {
        this.glBegin(7);
        this.glNormal3f(1.0f, 0.0f, 0.0f);
        this.glVertex3f(extent *= 0.5f, -extent, extent);
        this.glVertex3f(extent, -extent, -extent);
        this.glVertex3f(extent, extent, -extent);
        this.glVertex3f(extent, extent, extent);
        this.glNormal3f(0.0f, 1.0f, 0.0f);
        this.glVertex3f(extent, extent, extent);
        this.glVertex3f(extent, extent, -extent);
        this.glVertex3f(-extent, extent, -extent);
        this.glVertex3f(-extent, extent, extent);
        this.glNormal3f(0.0f, 0.0f, 1.0f);
        this.glVertex3f(extent, extent, extent);
        this.glVertex3f(-extent, extent, extent);
        this.glVertex3f(-extent, -extent, extent);
        this.glVertex3f(extent, -extent, extent);
        this.glNormal3f(-1.0f, 0.0f, 0.0f);
        this.glVertex3f(-extent, -extent, extent);
        this.glVertex3f(-extent, extent, extent);
        this.glVertex3f(-extent, extent, -extent);
        this.glVertex3f(-extent, -extent, -extent);
        this.glNormal3f(0.0f, -1.0f, 0.0f);
        this.glVertex3f(-extent, -extent, extent);
        this.glVertex3f(-extent, -extent, -extent);
        this.glVertex3f(extent, -extent, -extent);
        this.glVertex3f(extent, -extent, extent);
        this.glNormal3f(0.0f, 0.0f, -1.0f);
        this.glVertex3f(-extent, -extent, -extent);
        this.glVertex3f(-extent, extent, -extent);
        this.glVertex3f(extent, extent, -extent);
        this.glVertex3f(extent, -extent, -extent);
        this.glEnd();
    }

    @Override
    public void drawSphere(float radius, int slices, int stacks) {
        this.sphere.draw(this.gl, radius, 6, 6);
    }

    @Override
    public void drawCylinder(float radius, float halfHeight, int upAxis) {
        this.glPushMatrix();
        Matrix4f mat = new Matrix4f();
        switch (upAxis) {
            case 0: {
                mat.rotY(-1.5707964f);
                this.mulMatrix(mat);
                this.glTranslatef(0.0f, 0.0f, -halfHeight);
                break;
            }
            case 1: {
                mat.rotX(-1.5707964f);
                this.mulMatrix(mat);
                this.glTranslatef(0.0f, 0.0f, -halfHeight);
                break;
            }
            case 2: {
                this.glTranslatef(0.0f, 0.0f, -halfHeight);
                break;
            }
            default: {
                assert (false);
                break;
            }
        }
        this.disk.setDrawStyle(1);
        this.disk.setNormals(3);
        this.disk.draw(this.gl, 0.0f, radius, 8, 1);
        this.cylinder.setDrawStyle(1);
        this.cylinder.setNormals(3);
        this.cylinder.draw(this.gl, radius, radius, 2.0f * halfHeight, 8, 1);
        this.glTranslatef(0.0f, 0.0f, 2.0f * halfHeight);
        mat.rotY((float)(-Math.PI));
        this.mulMatrix(mat);
        this.disk.draw(this.gl, 0.0f, radius, 8, 1);
        this.glPopMatrix();
    }

    @Override
    public void drawString(CharSequence s, int x, int y, float red, float green, float blue) {
        this.g.setColor(new Color(red, green, blue));
        this.g.drawString(s.toString(), x, y);
    }
}

