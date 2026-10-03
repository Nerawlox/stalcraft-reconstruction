/*
 * Decompiled with CFR 0.152.
 */
package com.bulletphysics.demos.applet;

import com.bulletphysics.demos.applet.Light;
import com.bulletphysics.demos.applet.Rasterizer;
import javax.vecmath.Color3f;
import javax.vecmath.Matrix4f;
import javax.vecmath.Tuple3f;
import javax.vecmath.Vector3f;
import javax.vecmath.Vector4f;

public class Graphics3D {
    public static final int COLOR_BUFFER = 1;
    public static final int DEPTH_BUFFER = 2;
    public static final int TRIANGLES = 1;
    public static final int TRIANGLE_FAN = 2;
    public static final int QUADS = 3;
    public static final int QUAD_STRIP = 4;
    public static final int LINES = 5;
    private Rasterizer rasterizer = new Rasterizer();
    private Vector4f[] vertices = new Vector4f[64];
    private Vector3f[] normals = new Vector3f[64];
    private Color3f[] colors = new Color3f[64];
    private int clippedCount;
    private Vector4f[] clippedVertices = new Vector4f[64];
    private Color3f[] clippedColors = new Color3f[64];
    private int primitiveType;
    private int primitivePos;
    private Vector3f currentNormal = new Vector3f();
    private Color3f currentColor = new Color3f();
    private Matrix4f projMatrix = new Matrix4f();
    private Matrix4f viewMatrix = new Matrix4f();
    private Matrix4f mergedMatrix = new Matrix4f();
    private boolean matrixDirty = false;
    private Color3f clearColor = new Color3f();
    private Matrix4f[] viewMatStack = new Matrix4f[16];
    private int viewMatStackTop = 0;
    private boolean lightingEnabled = false;
    private Light[] lights = new Light[4];
    private Vector3f origColor = new Vector3f();
    private Vector3f tmpVec3 = new Vector3f();
    private Vector3f[] lightResult = new Vector3f[this.lights.length];

    public Graphics3D() {
        int i;
        for (i = 0; i < this.vertices.length; ++i) {
            this.vertices[i] = new Vector4f();
        }
        for (i = 0; i < this.normals.length; ++i) {
            this.normals[i] = new Vector3f();
        }
        for (i = 0; i < this.colors.length; ++i) {
            this.colors[i] = new Color3f();
        }
        for (i = 0; i < this.clippedVertices.length; ++i) {
            this.clippedVertices[i] = new Vector4f();
        }
        for (i = 0; i < this.clippedColors.length; ++i) {
            this.clippedColors[i] = new Color3f();
        }
        this.viewMatrix.setIdentity();
        for (i = 0; i < this.viewMatStack.length; ++i) {
            this.viewMatStack[i] = new Matrix4f();
        }
        for (i = 0; i < this.lights.length; ++i) {
            this.lights[i] = new Light();
        }
        for (i = 0; i < this.lightResult.length; ++i) {
            this.lightResult[i] = new Vector3f();
        }
    }

    public void init(int[] pixels, int width, int height) {
        this.rasterizer.init(pixels, width, height);
    }

    public void setClearColor(float r, float g, float b) {
        this.clearColor.set(r, g, b);
    }

    public void clear(int bufferMask) {
        this.rasterizer.clear(bufferMask, this.clearColor);
    }

    public void begin(int type2) {
        if (this.primitiveType != 0) {
            throw new IllegalStateException();
        }
        this.primitiveType = type2;
        this.primitivePos = 0;
    }

    public void end() {
        switch (this.primitiveType) {
            case 2: {
                this.transform(0, this.primitivePos);
                this.drawPolygon(this.primitivePos);
            }
        }
        this.primitiveType = 0;
    }

    public void setNormal(float x, float y, float z) {
        this.currentNormal.set(x, y, z);
    }

    public void setColor(float r, float g, float b) {
        this.currentColor.set(r, g, b);
    }

    public void addVertex(float x, float y, float z) {
        this.colors[this.primitivePos].set(this.currentColor);
        this.normals[this.primitivePos].set(this.currentNormal);
        this.vertices[this.primitivePos].set(x, y, z, 1.0f);
        ++this.primitivePos;
        switch (this.primitiveType) {
            case 1: {
                if (this.primitivePos != 3) break;
                this.transform(0, 3);
                this.drawPolygon(3);
                this.primitivePos = 0;
                break;
            }
            case 3: {
                if (this.primitivePos != 4) break;
                this.transform(0, 4);
                this.drawPolygon(4);
                this.primitivePos = 0;
                break;
            }
            case 4: {
                if (this.primitivePos == 2) {
                    this.transform(0, 2);
                }
                if (this.primitivePos != 3) break;
                this.transform(2, 3);
                this.drawPolygon(3);
                this.shift(1, 3, 1);
                this.primitivePos = 2;
                break;
            }
            case 5: {
                if (this.primitivePos != 2) break;
                this.transform(0, 2);
                this.drawLine();
                this.primitivePos = 0;
            }
        }
    }

    private void shift(int start, int count, int amount) {
        for (int i = start; i < count; ++i) {
            this.vertices[i - amount].set(this.vertices[i]);
            this.normals[i - amount].set(this.normals[i]);
            this.colors[i - amount].set(this.colors[i]);
        }
    }

    public void setProjMatrix(Matrix4f mat) {
        this.projMatrix.set(mat);
        this.matrixDirty = true;
    }

    public void mulProjMatrix(Matrix4f mat) {
        this.projMatrix.mul(mat);
        this.matrixDirty = true;
    }

    public void setViewMatrix(Matrix4f mat) {
        this.viewMatrix.set(mat);
        this.matrixDirty = true;
    }

    public void mulViewMatrix(Matrix4f mat) {
        this.viewMatrix.mul(mat);
        this.matrixDirty = true;
    }

    public void pushViewMatrix() {
        this.viewMatStack[this.viewMatStackTop++].set(this.viewMatrix);
    }

    public void pushViewMatrix(Matrix4f mat, boolean multiply) {
        this.viewMatStack[this.viewMatStackTop++].set(this.viewMatrix);
        if (multiply) {
            this.viewMatrix.mul(mat);
        } else {
            this.viewMatrix.set(mat);
        }
        this.matrixDirty = true;
    }

    public void popViewMatrix() {
        this.viewMatrix.set(this.viewMatStack[--this.viewMatStackTop]);
        this.matrixDirty = true;
    }

    public void flush() {
    }

    public void setLightingEnabled(boolean b) {
        this.lightingEnabled = b;
    }

    public Light getLight(int num) {
        return this.lights[num];
    }

    private void updateMatrix() {
        this.mergedMatrix.mul(this.projMatrix, this.viewMatrix);
        this.matrixDirty = false;
    }

    private void transform(int start, int num) {
        if (this.matrixDirty) {
            this.updateMatrix();
        }
        for (int i = start; i < num; ++i) {
            int j;
            this.mergedMatrix.transform(this.vertices[i]);
            this.mergedMatrix.transform(this.normals[i]);
            this.normals[i].normalize();
            if (!this.lightingEnabled || this.primitiveType == 5) continue;
            for (j = 0; j < this.lights.length; ++j) {
                Light l = this.lights[j];
                if (!l.enabled) continue;
                this.lightResult[j].set(l.ambient.x, l.ambient.y, l.ambient.z);
                this.tmpVec3.set(l.position.x, l.position.y, l.position.z);
                float dot = this.normals[i].dot(this.tmpVec3);
                if (dot < 0.0f) {
                    dot = 0.0f;
                }
                this.tmpVec3.set(l.diffuse.x, l.diffuse.y, l.diffuse.z);
                this.lightResult[j].scaleAdd(dot, this.tmpVec3, this.lightResult[j]);
                this.lightResult[j].x *= this.colors[i].x;
                this.lightResult[j].y *= this.colors[i].y;
                this.lightResult[j].z *= this.colors[i].z;
            }
            this.colors[i].set(0.0f, 0.0f, 0.0f);
            for (j = 0; j < this.lights.length; ++j) {
                if (!this.lights[j].enabled) continue;
                this.colors[i].add(this.lightResult[j]);
            }
            this.clamp(this.colors[i], 0.0f, 1.0f);
        }
    }

    private void clamp(Tuple3f t, float min, float max) {
        t.x = Math.min(Math.max(min, t.x), max);
        t.y = Math.min(Math.max(min, t.y), max);
        t.z = Math.min(Math.max(min, t.z), max);
    }

    private void drawPolygon(int num) {
        Boolean needsClip = this.clip(num);
        if (needsClip == null) {
            return;
        }
        this.rasterizer.drawPolygon(this.clippedCount, this.clippedVertices, needsClip != false ? this.clippedColors : this.colors);
    }

    private void drawLine() {
        Boolean needsClip = this.clip(2);
        if (needsClip == null) {
            return;
        }
        this.rasterizer.drawLine(this.clippedVertices, needsClip != false ? this.clippedColors : this.colors);
    }

    private Boolean clip(int num) {
        int i;
        boolean needsClip = false;
        boolean visible = false;
        for (i = 0; i < num; ++i) {
            if (this.vertices[i].z < 0.0f) {
                needsClip = true;
                continue;
            }
            visible = true;
        }
        if (!visible) {
            return null;
        }
        if (needsClip) {
            this.clippedCount = 0;
            for (i = 0; i < num; ++i) {
                this.clipEdge(i, (i + 1) % num);
            }
        } else {
            this.clippedCount = num;
            for (i = 0; i < num; ++i) {
                this.clippedVertices[i].set(this.vertices[i]);
            }
        }
        for (i = 0; i < this.clippedCount; ++i) {
            this.clippedVertices[i].scale(1.0f / this.clippedVertices[i].w);
            this.clippedVertices[i].x = (this.clippedVertices[i].x + 1.0f) * (float)this.rasterizer.getWidth() * 0.5f;
            this.clippedVertices[i].y = (float)(this.rasterizer.getHeight() - 1) - (this.clippedVertices[i].y + 1.0f) * (float)this.rasterizer.getHeight() * 0.5f;
        }
        return needsClip;
    }

    private void clipEdge(int v1, int v2) {
        Vector4f vtx1 = this.vertices[v1];
        Vector4f vtx2 = this.vertices[v2];
        Color3f c1 = this.colors[v1];
        Color3f c2 = this.colors[v2];
        float minZ = 0.0f;
        float m = 1.0f;
        float dold = vtx2.z - vtx1.z;
        float dnew = minZ - vtx1.z;
        if (dold != 0.0f) {
            m = dnew / dold;
        }
        if (vtx1.z >= minZ && vtx2.z >= minZ) {
            this.clippedVertices[this.clippedCount].set(vtx2);
            this.clippedColors[this.clippedCount].set(c2);
            ++this.clippedCount;
        } else if (vtx1.z >= minZ && vtx2.z < minZ) {
            this.clippedVertices[this.clippedCount].x = vtx1.x + (vtx2.x - vtx1.x) * m;
            this.clippedVertices[this.clippedCount].y = vtx1.y + (vtx2.y - vtx1.y) * m;
            this.clippedVertices[this.clippedCount].z = vtx1.z + (vtx2.z - vtx1.z) * m;
            this.clippedVertices[this.clippedCount].w = vtx1.w + (vtx2.w - vtx1.w) * m;
            this.clippedColors[this.clippedCount].x = c1.x + (c2.x - c1.x) * m;
            this.clippedColors[this.clippedCount].y = c1.y + (c2.y - c1.y) * m;
            this.clippedColors[this.clippedCount].z = c1.z + (c2.z - c1.z) * m;
            ++this.clippedCount;
        } else if (vtx1.z < minZ && vtx2.z >= minZ) {
            this.clippedVertices[this.clippedCount].x = vtx1.x + (vtx2.x - vtx1.x) * m;
            this.clippedVertices[this.clippedCount].y = vtx1.y + (vtx2.y - vtx1.y) * m;
            this.clippedVertices[this.clippedCount].z = vtx1.z + (vtx2.z - vtx1.z) * m;
            this.clippedVertices[this.clippedCount].w = vtx1.w + (vtx2.w - vtx1.w) * m;
            this.clippedColors[this.clippedCount].x = c1.x + (c2.x - c1.x) * m;
            this.clippedColors[this.clippedCount].y = c1.y + (c2.y - c1.y) * m;
            this.clippedColors[this.clippedCount].z = c1.z + (c2.z - c1.z) * m;
            ++this.clippedCount;
            this.clippedVertices[this.clippedCount].set(vtx2);
            this.clippedColors[this.clippedCount].set(c2);
            ++this.clippedCount;
        }
    }
}

