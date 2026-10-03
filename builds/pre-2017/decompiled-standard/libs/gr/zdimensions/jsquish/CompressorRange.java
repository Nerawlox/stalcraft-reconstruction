/*
 * Decompiled with CFR 0.152.
 */
package gr.zdimensions.jsquish;

import gr.zdimensions.jsquish.ColourBlock;
import gr.zdimensions.jsquish.ColourSet;
import gr.zdimensions.jsquish.CompressorColourFit;
import gr.zdimensions.jsquish.Matrix;
import gr.zdimensions.jsquish.Squish;
import gr.zdimensions.jsquish.Vec;

final class CompressorRange
extends CompressorColourFit {
    private static final int[] closest = new int[16];
    private static final int[] indices = new int[16];
    private static final Vec[] codes = new Vec[4];
    private final Squish.CompressionMetric metric;
    private final Vec start = new Vec();
    private final Vec end = new Vec();
    private float bestError;

    static {
        int i = 0;
        while (i < codes.length) {
            CompressorRange.codes[i] = new Vec();
            ++i;
        }
    }

    CompressorRange(ColourSet colours, Squish.CompressionType type2, Squish.CompressionMetric metric) {
        super(colours, type2);
        this.metric = metric;
        this.bestError = Float.MAX_VALUE;
        int count = this.colours.getCount();
        Vec[] points = this.colours.getPoints();
        Matrix covariance = Matrix.computeWeightedCovariance(colours, CompressorColourFit.covariance);
        Vec principle = Matrix.computePrincipleComponent(covariance);
        if (count > 0) {
            float max;
            float bZ;
            float bY;
            float bX;
            float aX = bX = points[0].x();
            float aY = bY = points[0].y();
            float aZ = bZ = points[0].z();
            float min = max = points[0].dot(principle);
            int i = 1;
            while (i < count) {
                Vec p = points[i];
                float val = p.dot(principle);
                if (val < min) {
                    aX = p.x();
                    aY = p.y();
                    aZ = p.z();
                    min = val;
                } else if (val > max) {
                    bX = p.x();
                    bY = p.y();
                    bZ = p.z();
                    max = val;
                }
                ++i;
            }
            aX = CompressorRange.clamp(aX, 31.0f, 0.032258064f);
            aY = CompressorRange.clamp(aY, 63.0f, 0.015873017f);
            aZ = CompressorRange.clamp(aZ, 31.0f, 0.032258064f);
            this.start.set(aX, aY, aZ);
            bX = CompressorRange.clamp(bX, 31.0f, 0.032258064f);
            bY = CompressorRange.clamp(bY, 63.0f, 0.015873017f);
            bZ = CompressorRange.clamp(bZ, 31.0f, 0.032258064f);
            this.end.set(bX, bY, bZ);
        }
    }

    void compress3(byte[] block, int offset) {
        int count = this.colours.getCount();
        Vec[] points = this.colours.getPoints();
        Vec v = new Vec();
        Vec[] codes = CompressorRange.codes;
        codes[0].set(this.start);
        codes[1].set(this.end);
        codes[2].set(this.start).add(this.end).mul(0.5f);
        int[] closest = CompressorRange.closest;
        float error = 0.0f;
        int i = 0;
        while (i < count) {
            Vec p = points[i];
            float dist = Float.MAX_VALUE;
            int index = 0;
            int j = 0;
            while (j < 3) {
                Vec c = codes[j];
                v.set((p.x() - c.x()) * this.metric.r, (p.y() - c.y()) * this.metric.g, (p.z() - c.z()) * this.metric.b);
                float d = v.lengthSQ();
                if (d < dist) {
                    dist = d;
                    index = j;
                }
                ++j;
            }
            closest[i] = index;
            error += dist;
            ++i;
        }
        if (error < this.bestError) {
            this.colours.remapIndices(closest, indices);
            ColourBlock.writeColourBlock3(this.start, this.end, indices, block, offset);
            this.bestError = error;
        }
    }

    void compress4(byte[] block, int offset) {
        int count = this.colours.getCount();
        Vec[] points = this.colours.getPoints();
        Vec v = new Vec();
        Vec[] codes = CompressorRange.codes;
        codes[0].set(this.start);
        codes[1].set(this.end);
        codes[2].set(0.6666667f).mul(this.start).add(v.set(0.33333334f).mul(this.end));
        codes[3].set(0.33333334f).mul(this.start).add(v.set(0.6666667f).mul(this.end));
        int[] closest = CompressorRange.closest;
        float error = 0.0f;
        int i = 0;
        while (i < count) {
            Vec p = points[i];
            float dist = Float.MAX_VALUE;
            int index = 0;
            int j = 0;
            while (j < 4) {
                Vec c = codes[j];
                v.set((p.x() - c.x()) * this.metric.r, (p.y() - c.y()) * this.metric.g, (p.z() - c.z()) * this.metric.b);
                float d = v.lengthSQ();
                if (d < dist) {
                    dist = d;
                    index = j;
                }
                ++j;
            }
            closest[i] = index;
            error += dist;
            ++i;
        }
        if (error < this.bestError) {
            this.colours.remapIndices(closest, indices);
            ColourBlock.writeColourBlock4(this.start, this.end, indices, block, offset);
            this.bestError = error;
        }
    }
}

