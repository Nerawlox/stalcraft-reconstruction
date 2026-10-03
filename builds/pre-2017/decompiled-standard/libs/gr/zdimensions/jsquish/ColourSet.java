/*
 * Decompiled with CFR 0.152.
 */
package gr.zdimensions.jsquish;

import gr.zdimensions.jsquish.Squish;
import gr.zdimensions.jsquish.Vec;

final class ColourSet {
    private int count;
    private final Vec[] points = new Vec[16];
    private final float[] weights = new float[16];
    private final int[] remap = new int[16];
    private boolean transparent;

    ColourSet() {
        int i = 0;
        while (i < this.points.length) {
            this.points[i] = new Vec();
            ++i;
        }
    }

    void init(byte[] rgba, int mask, Squish.CompressionType type2, boolean weightAlpha) {
        boolean isDXT1 = type2 == Squish.CompressionType.DXT1;
        this.count = 0;
        this.transparent = false;
        int i = 0;
        while (i < 16) {
            int bit = 1 << i;
            if ((mask & bit) == 0) {
                this.remap[i] = -1;
            } else if (isDXT1 && (rgba[4 * i + 3] & 0xFF) < 128) {
                this.remap[i] = -1;
                this.transparent = true;
            } else {
                int j = 0;
                while (true) {
                    boolean match;
                    if (j == i) {
                        float r = (float)(rgba[4 * i] & 0xFF) / 255.0f;
                        float g = (float)(rgba[4 * i + 1] & 0xFF) / 255.0f;
                        float b = (float)(rgba[4 * i + 2] & 0xFF) / 255.0f;
                        this.points[this.count].set(r, g, b);
                        this.weights[this.count] = weightAlpha ? (float)((rgba[4 * i + 3] & 0xFF) + 1) / 256.0f : 1.0f;
                        ++this.count;
                        break;
                    }
                    int oldbit = 1 << j;
                    boolean bl = match = (mask & oldbit) != 0 && rgba[4 * i] == rgba[4 * j] && rgba[4 * i + 1] == rgba[4 * j + 1] && rgba[4 * i + 2] == rgba[4 * j + 2] && (rgba[4 * j + 3] != 0 || !isDXT1);
                    if (match) {
                        int index;
                        int n = index = this.remap[j];
                        this.weights[n] = this.weights[n] + (weightAlpha ? (float)((rgba[4 * i + 3] & 0xFF) + 1) / 256.0f : 1.0f);
                        this.remap[i] = index;
                        break;
                    }
                    ++j;
                }
            }
            ++i;
        }
    }

    int getCount() {
        return this.count;
    }

    Vec[] getPoints() {
        return this.points;
    }

    float[] getWeights() {
        return this.weights;
    }

    boolean isTransparent() {
        return this.transparent;
    }

    void remapIndices(int[] source, int[] target) {
        int i = 0;
        while (i < 16) {
            int j = this.remap[i];
            target[i] = j == -1 ? 3 : source[j];
            ++i;
        }
    }
}

