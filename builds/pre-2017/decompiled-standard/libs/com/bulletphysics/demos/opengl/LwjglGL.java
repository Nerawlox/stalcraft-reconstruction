/*
 * Decompiled with CFR 0.152.
 */
package com.bulletphysics.demos.opengl;

import com.bulletphysics.demos.opengl.FontRender;
import com.bulletphysics.demos.opengl.IGL;
import java.io.IOException;
import java.nio.FloatBuffer;
import java.util.HashMap;
import java.util.Map;
import org.lwjgl.BufferUtils;
import org.lwjgl.opengl.GL11;
import org.lwjgl.util.glu.Cylinder;
import org.lwjgl.util.glu.Disk;
import org.lwjgl.util.glu.GLU;
import org.lwjgl.util.glu.Sphere;

public class LwjglGL
implements IGL {
    private static FloatBuffer floatBuf = BufferUtils.createFloatBuffer(16);
    private FontRender.GLFont font;
    private static final Cylinder cylinder = new Cylinder();
    private static final Disk disk = new Disk();
    private static final Sphere sphere = new Sphere();
    private static Map<SphereKey, Integer> sphereDisplayLists = new HashMap<SphereKey, Integer>();
    private static SphereKey sphereKey = new SphereKey();
    private static Map<CylinderKey, Integer> cylinderDisplayLists = new HashMap<CylinderKey, Integer>();
    private static CylinderKey cylinderKey = new CylinderKey();

    public void init() {
        try {
            this.font = new FontRender.GLFont(IGL.class.getResourceAsStream("DejaVu_Sans_11.fnt"));
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void glLight(int light, int pname, float[] params) {
        FloatBuffer buf = BufferUtils.createFloatBuffer(params.length);
        buf.put(params);
        buf.flip();
        GL11.glLight(light, pname, buf);
    }

    @Override
    public void glEnable(int cap) {
        GL11.glEnable(cap);
    }

    @Override
    public void glDisable(int cap) {
        GL11.glDisable(cap);
    }

    @Override
    public void glShadeModel(int mode) {
        GL11.glShadeModel(mode);
    }

    @Override
    public void glDepthFunc(int func) {
        GL11.glDepthFunc(func);
    }

    @Override
    public void glClearColor(float red, float green, float blue, float alpha) {
        GL11.glClearColor(red, green, blue, alpha);
    }

    @Override
    public void glMatrixMode(int mode) {
        GL11.glMatrixMode(mode);
    }

    @Override
    public void glLoadIdentity() {
        GL11.glLoadIdentity();
    }

    @Override
    public void glFrustum(double left, double right, double bottom, double top, double zNear, double zFar) {
        GL11.glFrustum(left, right, bottom, top, zNear, zFar);
    }

    @Override
    public void gluLookAt(float eyex, float eyey, float eyez, float centerx, float centery, float centerz, float upx, float upy, float upz) {
        GLU.gluLookAt(eyex, eyey, eyez, centerx, centery, centerz, upx, upy, upz);
    }

    @Override
    public void glViewport(int x, int y, int width, int height) {
        GL11.glViewport(x, y, width, height);
    }

    @Override
    public void glPushMatrix() {
        GL11.glPushMatrix();
    }

    @Override
    public void glPopMatrix() {
        GL11.glPopMatrix();
    }

    @Override
    public void gluOrtho2D(float left, float right, float bottom, float top) {
        GLU.gluOrtho2D(left, right, bottom, top);
    }

    @Override
    public void glScalef(float x, float y, float z) {
        GL11.glScalef(x, y, z);
    }

    @Override
    public void glTranslatef(float x, float y, float z) {
        GL11.glTranslatef(x, y, z);
    }

    @Override
    public void glColor3f(float red, float green, float blue) {
        GL11.glColor3f(red, green, blue);
    }

    @Override
    public void glClear(int mask) {
        GL11.glClear(mask);
    }

    @Override
    public void glBegin(int mode) {
        GL11.glBegin(mode);
    }

    @Override
    public void glEnd() {
        GL11.glEnd();
    }

    @Override
    public void glVertex3f(float x, float y, float z) {
        GL11.glVertex3f(x, y, z);
    }

    @Override
    public void glLineWidth(float width) {
        GL11.glLineWidth(width);
    }

    @Override
    public void glPointSize(float size) {
        GL11.glPointSize(size);
    }

    @Override
    public void glNormal3f(float nx, float ny, float nz) {
        GL11.glNormal3f(nx, ny, nz);
    }

    @Override
    public void glMultMatrix(float[] m) {
        floatBuf.clear();
        floatBuf.put(m).flip();
        GL11.glMultMatrix(floatBuf);
    }

    @Override
    public void drawCube(float extent) {
        GL11.glBegin(7);
        GL11.glNormal3f(1.0f, 0.0f, 0.0f);
        GL11.glVertex3f(extent *= 0.5f, -extent, extent);
        GL11.glVertex3f(extent, -extent, -extent);
        GL11.glVertex3f(extent, extent, -extent);
        GL11.glVertex3f(extent, extent, extent);
        GL11.glNormal3f(0.0f, 1.0f, 0.0f);
        GL11.glVertex3f(extent, extent, extent);
        GL11.glVertex3f(extent, extent, -extent);
        GL11.glVertex3f(-extent, extent, -extent);
        GL11.glVertex3f(-extent, extent, extent);
        GL11.glNormal3f(0.0f, 0.0f, 1.0f);
        GL11.glVertex3f(extent, extent, extent);
        GL11.glVertex3f(-extent, extent, extent);
        GL11.glVertex3f(-extent, -extent, extent);
        GL11.glVertex3f(extent, -extent, extent);
        GL11.glNormal3f(-1.0f, 0.0f, 0.0f);
        GL11.glVertex3f(-extent, -extent, extent);
        GL11.glVertex3f(-extent, extent, extent);
        GL11.glVertex3f(-extent, extent, -extent);
        GL11.glVertex3f(-extent, -extent, -extent);
        GL11.glNormal3f(0.0f, -1.0f, 0.0f);
        GL11.glVertex3f(-extent, -extent, extent);
        GL11.glVertex3f(-extent, -extent, -extent);
        GL11.glVertex3f(extent, -extent, -extent);
        GL11.glVertex3f(extent, -extent, extent);
        GL11.glNormal3f(0.0f, 0.0f, -1.0f);
        GL11.glVertex3f(-extent, -extent, -extent);
        GL11.glVertex3f(-extent, extent, -extent);
        GL11.glVertex3f(extent, extent, -extent);
        GL11.glVertex3f(extent, -extent, -extent);
        GL11.glEnd();
    }

    @Override
    public void drawSphere(float radius, int slices, int stacks) {
        LwjglGL.sphereKey.radius = radius;
        Integer glList = sphereDisplayLists.get(sphereKey);
        if (glList == null) {
            glList = GL11.glGenLists(1);
            GL11.glNewList(glList, 4864);
            sphere.draw(radius, 8, 8);
            GL11.glEndList();
            sphereDisplayLists.put(new SphereKey(sphereKey), glList);
        }
        GL11.glCallList(glList);
    }

    @Override
    public void drawCylinder(float radius, float halfHeight, int upAxis) {
        this.glPushMatrix();
        switch (upAxis) {
            case 0: {
                GL11.glRotatef(-90.0f, 0.0f, 1.0f, 0.0f);
                this.glTranslatef(0.0f, 0.0f, -halfHeight);
                break;
            }
            case 1: {
                GL11.glRotatef(-90.0f, 1.0f, 0.0f, 0.0f);
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
        cylinderKey.set(radius, halfHeight);
        Integer glList = cylinderDisplayLists.get(cylinderKey);
        if (glList == null) {
            glList = GL11.glGenLists(1);
            GL11.glNewList(glList, 4864);
            disk.setDrawStyle(100012);
            disk.setNormals(100000);
            disk.draw(0.0f, radius, 15, 10);
            cylinder.setDrawStyle(100012);
            cylinder.setNormals(100000);
            cylinder.draw(radius, radius, 2.0f * halfHeight, 15, 10);
            this.glTranslatef(0.0f, 0.0f, 2.0f * halfHeight);
            GL11.glRotatef(-180.0f, 0.0f, 1.0f, 0.0f);
            disk.draw(0.0f, radius, 15, 10);
            GL11.glEndList();
            cylinderDisplayLists.put(new CylinderKey(cylinderKey), glList);
        }
        GL11.glCallList(glList);
        this.glPopMatrix();
    }

    @Override
    public void drawString(CharSequence s, int x, int y, float red, float green, float blue) {
        if (this.font != null) {
            FontRender.drawString(this.font, s, x, y, red, green, blue);
        }
    }

    private static class CylinderKey {
        public float radius;
        public float halfHeight;

        public CylinderKey() {
        }

        public CylinderKey(CylinderKey key) {
            this.radius = key.radius;
            this.halfHeight = key.halfHeight;
        }

        public void set(float radius, float halfHeight) {
            this.radius = radius;
            this.halfHeight = halfHeight;
        }

        public boolean equals(Object obj) {
            if (obj == null || !(obj instanceof CylinderKey)) {
                return false;
            }
            CylinderKey other = (CylinderKey)obj;
            if (this.radius != other.radius) {
                return false;
            }
            return this.halfHeight == other.halfHeight;
        }

        public int hashCode() {
            int hash = 7;
            hash = 23 * hash + Float.floatToIntBits(this.radius);
            hash = 23 * hash + Float.floatToIntBits(this.halfHeight);
            return hash;
        }
    }

    private static class SphereKey {
        public float radius;

        public SphereKey() {
        }

        public SphereKey(SphereKey key) {
            this.radius = key.radius;
        }

        public boolean equals(Object obj) {
            if (obj == null || !(obj instanceof SphereKey)) {
                return false;
            }
            SphereKey other = (SphereKey)obj;
            return this.radius == other.radius;
        }

        public int hashCode() {
            return Float.floatToIntBits(this.radius);
        }
    }
}

