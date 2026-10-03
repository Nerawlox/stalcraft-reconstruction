/*
 * Decompiled with CFR 0.152.
 */
package com.bulletphysics.demos.applet;

import com.bulletphysics.demos.applet.Graphics3D;
import com.bulletphysics.demos.applet.Quadric;

public class Disk
extends Quadric {
    public void draw(Graphics3D gl, float innerRadius, float outerRadius, int slices, int loops) {
        if (this.normals != 8) {
            if (this.orientation == 2) {
                gl.setNormal(0.0f, 0.0f, 1.0f);
            } else {
                gl.setNormal(0.0f, 0.0f, -1.0f);
            }
        }
        float da = (float)Math.PI * 2 / (float)slices;
        float dr = (outerRadius - innerRadius) / (float)loops;
        switch (this.drawStyle) {
            case 1: {
                float dtc = 2.0f * outerRadius;
                float r1 = innerRadius;
                for (int l = 0; l < loops; ++l) {
                    float ca;
                    float sa;
                    float a;
                    int s;
                    float r2 = r1 + dr;
                    if (this.orientation == 2) {
                        gl.begin(4);
                        for (s = 0; s <= slices; ++s) {
                            a = s == slices ? 0.0f : (float)s * da;
                            sa = this.sin(a);
                            ca = this.cos(a);
                            this.TXTR_COORD(gl, 0.5f + sa * r2 / dtc, 0.5f + ca * r2 / dtc);
                            gl.addVertex(r2 * sa, r2 * ca, 0.0f);
                            this.TXTR_COORD(gl, 0.5f + sa * r1 / dtc, 0.5f + ca * r1 / dtc);
                            gl.addVertex(r1 * sa, r1 * ca, 0.0f);
                        }
                        gl.end();
                    } else {
                        gl.begin(4);
                        for (s = slices; s >= 0; --s) {
                            a = s == slices ? 0.0f : (float)s * da;
                            sa = this.sin(a);
                            ca = this.cos(a);
                            this.TXTR_COORD(gl, 0.5f - sa * r2 / dtc, 0.5f + ca * r2 / dtc);
                            gl.addVertex(r2 * sa, r2 * ca, 0.0f);
                            this.TXTR_COORD(gl, 0.5f - sa * r1 / dtc, 0.5f + ca * r1 / dtc);
                            gl.addVertex(r1 * sa, r1 * ca, 0.0f);
                        }
                        gl.end();
                    }
                    r1 = r2;
                }
                break;
            }
            case 6: {
                break;
            }
            case 5: {
                break;
            }
            case 7: {
                break;
            }
            default: {
                return;
            }
        }
    }
}

