/*
 * Decompiled with CFR 0.152.
 */
package com.bulletphysics.demos.applet;

import com.bulletphysics.demos.applet.Span;
import javax.vecmath.Tuple3f;
import javax.vecmath.Tuple4f;

public class Rasterizer {
    public static final int COLOR_BUFFER = 1;
    public static final int DEPTH_BUFFER = 2;
    private int[] pixels;
    private float[] zbuffer;
    private int width;
    private int height;
    private int minY;
    private int maxY;
    private Span[] spans;
    private static final int EDGE_LEFT = 1;
    private static final int EDGE_RIGHT = 2;
    private static final int EDGE_TOP = 4;
    private static final int EDGE_BOTTOM = 8;

    public void init(int[] pixels, int width, int height) {
        this.pixels = pixels;
        this.width = width;
        this.height = height;
        this.spans = new Span[height];
        for (int i = 0; i < height; ++i) {
            this.spans[i] = new Span();
        }
        this.zbuffer = new float[width * height];
    }

    public int getWidth() {
        return this.width;
    }

    public int getHeight() {
        return this.height;
    }

    public void clear(int bufferMask, Tuple3f color) {
        if ((bufferMask & 1) != 0) {
            int r = (int)(color.x * 255.0f);
            int g = (int)(color.y * 255.0f);
            int b = (int)(color.z * 255.0f);
            int c = r << 16 | g << 8 | b;
            for (int i = 0; i < this.zbuffer.length; ++i) {
                this.pixels[i] = c;
            }
        }
        if ((bufferMask & 2) != 0) {
            for (int i = 0; i < this.zbuffer.length; ++i) {
                this.zbuffer[i] = Float.MAX_VALUE;
            }
        }
    }

    public void drawPolygon(int num, Tuple4f[] vertices, Tuple3f[] colors) {
        int i;
        this.minY = Short.MAX_VALUE;
        this.maxY = Short.MIN_VALUE;
        for (i = 0; i < this.height; ++i) {
            this.spans[i].x1 = Short.MAX_VALUE;
            this.spans[i].x2 = Short.MIN_VALUE;
        }
        for (i = 0; i < num; ++i) {
            int j = (i + 1) % num;
            this.scanEdge(vertices[i], vertices[j], colors[i], colors[j]);
        }
        for (i = this.minY; i < this.maxY; ++i) {
            float m;
            int x1 = this.spans[i].x1;
            int x2 = this.spans[i].x2;
            if (x1 >= this.width || x2 < 0) continue;
            if (x1 < 0) {
                m = (float)(-x1) / (float)(x2 - x1);
                this.spans[i].c1r = (short)((float)this.spans[i].c1r + (float)(this.spans[i].c2r - this.spans[i].c1r) * m);
                this.spans[i].c1g = (short)((float)this.spans[i].c1g + (float)(this.spans[i].c2g - this.spans[i].c1g) * m);
                this.spans[i].c1b = (short)((float)this.spans[i].c1b + (float)(this.spans[i].c2b - this.spans[i].c1b) * m);
                x1 = 0;
            }
            if (x2 >= this.width) {
                m = (float)(this.width - 1 - x1) / (float)(x2 - x1);
                this.spans[i].c2r = (short)((float)this.spans[i].c1r + (float)(this.spans[i].c2r - this.spans[i].c1r) * m);
                this.spans[i].c2g = (short)((float)this.spans[i].c1g + (float)(this.spans[i].c2g - this.spans[i].c1g) * m);
                this.spans[i].c2b = (short)((float)this.spans[i].c1b + (float)(this.spans[i].c2b - this.spans[i].c1b) * m);
                x2 = this.width - 1;
            }
            int pos = i * this.width;
            Span span = this.spans[i];
            float z1 = span.z1;
            float z2 = span.z2;
            float r1 = span.c1r;
            float g1 = span.c1g;
            float b1 = span.c1b;
            float r2 = span.c2r;
            float g2 = span.c2g;
            float b2 = span.c2b;
            for (int j = x1; j <= x2; ++j) {
                float a = (float)(j - x1) / (float)(x2 - x1 + 1);
                float z = z1 * (1.0f - a) + z2 * a;
                if (z > this.zbuffer[pos + j]) continue;
                this.zbuffer[pos + j] = z;
                float r = r1 * (1.0f - a) + r2 * a;
                float g = g1 * (1.0f - a) + g2 * a;
                float b = b1 * (1.0f - a) + b2 * a;
                int ir = (int)r & 0xFF;
                int ig = (int)g & 0xFF;
                int ib = (int)b & 0xFF;
                this.pixels[pos + j] = ir << 16 | ig << 8 | ib;
            }
        }
    }

    private void scanEdge(Tuple4f v1, Tuple4f v2, Tuple3f c1, Tuple3f c2) {
        Tuple3f clast;
        Tuple3f cfirst;
        Tuple4f last;
        Tuple4f first;
        if (v1.y < v2.y) {
            first = v1;
            last = v2;
            cfirst = c1;
            clast = c2;
        } else {
            first = v2;
            last = v1;
            cfirst = c2;
            clast = c1;
        }
        float y1 = (int)first.y;
        float y2 = (int)last.y;
        if (y1 >= (float)this.height) {
            return;
        }
        if (y2 < 0.0f) {
            return;
        }
        if (y2 >= (float)this.height) {
            y2 = this.height - 1;
        }
        float invSub = 1.0f / (last.y - first.y);
        float x = first.x;
        float slopeX = (last.x - first.x) * invSub;
        float z = first.z;
        float slopeZ = (last.z - first.z) * invSub;
        float cr = cfirst.x;
        float cg = cfirst.y;
        float cb = cfirst.z;
        float slopeCR = (clast.x - cfirst.x) * invSub;
        float slopeCG = (clast.y - cfirst.y) * invSub;
        float slopeCB = (clast.z - cfirst.z) * invSub;
        if (y1 < 0.0f) {
            x += slopeX * -y1;
            z += slopeZ * -y1;
            cr += slopeCR * -y1;
            cg += slopeCG * -y1;
            cb += slopeCB * -y1;
            y1 = 0.0f;
        }
        if (y1 < (float)this.minY) {
            this.minY = (int)y1;
        }
        if (y2 > (float)this.maxY) {
            this.maxY = (int)y2;
        }
        for (int i = (int)y1; i < (int)y2; ++i) {
            int sx = (int)x;
            int scr = (int)(cr * 255.0f);
            int scg = (int)(cg * 255.0f);
            int scb = (int)(cb * 255.0f);
            if (sx < this.spans[i].x1) {
                this.spans[i].x1 = sx;
                this.spans[i].z1 = z;
                this.spans[i].c1r = (short)scr;
                this.spans[i].c1g = (short)scg;
                this.spans[i].c1b = (short)scb;
            }
            if (sx > this.spans[i].x2) {
                this.spans[i].x2 = sx;
                this.spans[i].z2 = z;
                this.spans[i].c2r = (short)scr;
                this.spans[i].c2g = (short)scg;
                this.spans[i].c2b = (short)scb;
            }
            x += slopeX;
            z += slopeZ;
            cr += slopeCR;
            cg += slopeCG;
            cb += slopeCB;
        }
    }

    public void drawLine(Tuple4f[] vertices, Tuple3f[] colors) {
        float x1 = vertices[0].x + 0.5f;
        float y1 = vertices[0].y + 0.5f;
        float z1 = vertices[0].z;
        float x2 = vertices[1].x + 0.5f;
        float y2 = vertices[1].y + 0.5f;
        float z2 = vertices[1].z;
        while (true) {
            float z;
            float y;
            float x;
            float m;
            int outcode;
            int outcode1 = 0;
            if (x1 < 0.0f) {
                outcode1 |= 1;
            } else if (x1 >= (float)this.width) {
                outcode1 |= 2;
            }
            if (y1 < 0.0f) {
                outcode1 |= 4;
            } else if (y1 >= (float)this.height) {
                outcode1 |= 8;
            }
            int outcode2 = 0;
            if (x2 < 0.0f) {
                outcode2 |= 1;
            } else if (x2 >= (float)this.width) {
                outcode2 |= 2;
            }
            if (y2 < 0.0f) {
                outcode2 |= 4;
            } else if (y2 >= (float)this.height) {
                outcode2 |= 8;
            }
            if (outcode1 == 0 && outcode2 == 0) break;
            if ((outcode1 & outcode2) != 0) {
                return;
            }
            int n = outcode = outcode1 != 0 ? outcode1 : outcode2;
            if ((outcode & 1) != 0) {
                m = (0.0f - x1) / (x2 - x1);
                x = 0.0f;
                y = y1 + (y2 - y1) * m;
                z = z1 + (z2 - z1) * m;
            } else if ((outcode & 2) != 0) {
                m = ((float)(this.width - 1) - x1) / (x2 - x1);
                x = this.width - 1;
                y = y1 + (y2 - y1) * m;
                z = z1 + (z2 - z1) * m;
            } else if ((outcode & 4) != 0) {
                m = (0.0f - y1) / (y2 - y1);
                x = x1 + (x2 - x1) * m;
                y = 0.0f;
                z = z1 + (z2 - z1) * m;
            } else {
                m = ((float)(this.height - 1) - y1) / (y2 - y1);
                x = x1 + (x2 - x1) * m;
                y = this.height - 1;
                z = z1 + (z2 - z1) * m;
            }
            if (outcode == outcode1) {
                x1 = x;
                y1 = y;
                z1 = z;
                continue;
            }
            x2 = x;
            y2 = y;
            z2 = z;
        }
        int color = (int)(colors[0].x * 255.0f) << 16 | (int)(colors[0].y * 255.0f) << 8 | (int)(colors[0].z * 255.0f);
        this.lineBresenham((int)x1, (int)y1, (int)x2, (int)y2, z1, z2, color);
    }

    private void lineBresenham(int x0, int y0, int x1, int y1, float z1, float z2, int color) {
        int stepx;
        int stepy;
        int dy = y1 - y0;
        int dx = x1 - x0;
        if (dy < 0) {
            dy = -dy;
            stepy = -1;
        } else {
            stepy = 1;
        }
        if (dx < 0) {
            dx = -dx;
            stepx = -1;
        } else {
            stepx = 1;
        }
        dy <<= 1;
        dx <<= 1;
        int pos = y0 * this.width + x0;
        if (z1 <= this.zbuffer[pos]) {
            this.zbuffer[pos] = z1;
            this.pixels[pos] = color;
        }
        if (dx > dy) {
            int fraction = dy - (dx >> 1);
            float dz = (z2 - z1) / (float)dx;
            float z = z1 + dz;
            while (x0 != x1) {
                if (fraction >= 0) {
                    y0 += stepy;
                    fraction -= dx;
                }
                x0 += stepx;
                fraction += dy;
                pos = y0 * this.width + x0;
                if (z <= this.zbuffer[pos]) {
                    this.zbuffer[pos] = z;
                    this.pixels[pos] = color;
                }
                z += dz;
            }
        } else {
            int fraction = dx - (dy >> 1);
            float dz = (z2 - z1) / (float)dy;
            float z = z1 + dz;
            while (y0 != y1) {
                if (fraction >= 0) {
                    x0 += stepx;
                    fraction -= dy;
                }
                y0 += stepy;
                fraction += dx;
                pos = y0 * this.width + x0;
                if (z <= this.zbuffer[pos]) {
                    this.zbuffer[pos] = z;
                    this.pixels[pos] = color;
                }
                z += dz;
            }
        }
    }
}

