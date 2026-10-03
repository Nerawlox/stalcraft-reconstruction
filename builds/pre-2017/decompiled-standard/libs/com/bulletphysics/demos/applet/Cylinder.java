/*
 * Decompiled with CFR 0.152.
 */
package com.bulletphysics.demos.applet;

import com.bulletphysics.demos.applet.Graphics3D;
import com.bulletphysics.demos.applet.Quadric;

public class Cylinder
extends Quadric {
    public void draw(Graphics3D gl, float baseRadius, float topRadius, float height, int slices, int stacks) {
        float nsign = this.orientation == 4 ? -1.0f : 1.0f;
        float da = (float)Math.PI * 2 / (float)slices;
        float dr = (topRadius - baseRadius) / (float)stacks;
        float dz = height / (float)stacks;
        float nz = (baseRadius - topRadius) / height;
        if (this.drawStyle != 5 && this.drawStyle != 6 && this.drawStyle != 7 && this.drawStyle == 1) {
            float ds = 1.0f / (float)slices;
            float dt = 1.0f / (float)stacks;
            float t = 0.0f;
            float z = 0.0f;
            float r = baseRadius;
            for (int j = 0; j < stacks; ++j) {
                float s = 0.0f;
                gl.begin(4);
                for (int i = 0; i <= slices; ++i) {
                    float y;
                    float x;
                    if (i == slices) {
                        x = this.sin(0.0f);
                        y = this.cos(0.0f);
                    } else {
                        x = this.sin((float)i * da);
                        y = this.cos((float)i * da);
                    }
                    if (nsign == 1.0f) {
                        this.normal3f(gl, x * nsign, y * nsign, nz * nsign);
                        this.TXTR_COORD(gl, s, t);
                        gl.addVertex(x * r, y * r, z);
                        this.normal3f(gl, x * nsign, y * nsign, nz * nsign);
                        this.TXTR_COORD(gl, s, t + dt);
                        gl.addVertex(x * (r + dr), y * (r + dr), z + dz);
                    } else {
                        this.normal3f(gl, x * nsign, y * nsign, nz * nsign);
                        this.TXTR_COORD(gl, s, t);
                        gl.addVertex(x * r, y * r, z);
                        this.normal3f(gl, x * nsign, y * nsign, nz * nsign);
                        this.TXTR_COORD(gl, s, t + dt);
                        gl.addVertex(x * (r + dr), y * (r + dr), z + dz);
                    }
                    s += ds;
                }
                gl.end();
                r += dr;
                t += dt;
                z += dz;
            }
        }
    }
}

