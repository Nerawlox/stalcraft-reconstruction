/*
 * Decompiled with CFR 0.152.
 */
package com.bulletphysics.demos.applet;

import com.bulletphysics.demos.applet.Graphics3D;
import com.bulletphysics.demos.applet.Quadric;

public class Sphere
extends Quadric {
    public void draw(Graphics3D gl, float radius, int slices, int stacks) {
        boolean normals = this.normals != 8;
        float nsign = this.orientation == 4 ? -1.0f : 1.0f;
        float drho = (float)Math.PI / (float)stacks;
        float dtheta = (float)Math.PI * 2 / (float)slices;
        if (this.drawStyle == 1) {
            float s;
            float rho;
            int imax;
            int imin;
            float z;
            float y;
            float x;
            float theta;
            int j;
            if (!this.textureFlag) {
                gl.begin(2);
                gl.setNormal(0.0f, 0.0f, 1.0f);
                gl.addVertex(0.0f, 0.0f, nsign * radius);
                for (j = 0; j <= slices; ++j) {
                    theta = j == slices ? 0.0f : (float)j * dtheta;
                    x = -this.sin(theta) * this.sin(drho);
                    y = this.cos(theta) * this.sin(drho);
                    z = nsign * this.cos(drho);
                    if (normals) {
                        gl.setNormal(x * nsign, y * nsign, z * nsign);
                    }
                    gl.addVertex(x * radius, y * radius, z * radius);
                }
                gl.end();
            }
            float ds = 1.0f / (float)slices;
            float dt = 1.0f / (float)stacks;
            float t = 1.0f;
            if (this.textureFlag) {
                imin = 0;
                imax = stacks;
            } else {
                imin = 1;
                imax = stacks - 1;
            }
            for (int i = imin; i < imax; ++i) {
                rho = (float)i * drho;
                gl.begin(4);
                s = 0.0f;
                for (j = 0; j <= slices; ++j) {
                    theta = j == slices ? 0.0f : (float)j * dtheta;
                    x = -this.sin(theta) * this.sin(rho);
                    y = this.cos(theta) * this.sin(rho);
                    z = nsign * this.cos(rho);
                    if (normals) {
                        gl.setNormal(x * nsign, y * nsign, z * nsign);
                    }
                    this.TXTR_COORD(gl, s, t);
                    gl.addVertex(x * radius, y * radius, z * radius);
                    x = -this.sin(theta) * this.sin(rho + drho);
                    y = this.cos(theta) * this.sin(rho + drho);
                    z = nsign * this.cos(rho + drho);
                    if (normals) {
                        gl.setNormal(x * nsign, y * nsign, z * nsign);
                    }
                    this.TXTR_COORD(gl, s, t - dt);
                    s += ds;
                    gl.addVertex(x * radius, y * radius, z * radius);
                }
                gl.end();
                t -= dt;
            }
            if (!this.textureFlag) {
                gl.begin(2);
                gl.setNormal(0.0f, 0.0f, -1.0f);
                gl.addVertex(0.0f, 0.0f, -radius * nsign);
                rho = (float)Math.PI - drho;
                s = 1.0f;
                for (j = slices; j >= 0; --j) {
                    theta = j == slices ? 0.0f : (float)j * dtheta;
                    x = -this.sin(theta) * this.sin(rho);
                    y = this.cos(theta) * this.sin(rho);
                    z = nsign * this.cos(rho);
                    if (normals) {
                        gl.setNormal(x * nsign, y * nsign, z * nsign);
                    }
                    s -= ds;
                    gl.addVertex(x * radius, y * radius, z * radius);
                }
                gl.end();
            }
        }
    }
}

