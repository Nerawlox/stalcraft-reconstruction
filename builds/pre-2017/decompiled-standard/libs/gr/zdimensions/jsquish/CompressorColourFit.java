/*
 * Decompiled with CFR 0.152.
 */
package gr.zdimensions.jsquish;

import gr.zdimensions.jsquish.ColourSet;
import gr.zdimensions.jsquish.Matrix;
import gr.zdimensions.jsquish.Squish;
import gr.zdimensions.jsquish.Vec;

abstract class CompressorColourFit {
    protected static final Vec ONE_V = new Vec(1.0f);
    protected static final Vec ZERO_V = new Vec(0.0f);
    protected static final float GRID_X = 31.0f;
    protected static final float GRID_Y = 63.0f;
    protected static final float GRID_Z = 31.0f;
    protected static final float GRID_X_RCP = 0.032258064f;
    protected static final float GRID_Y_RCP = 0.015873017f;
    protected static final float GRID_Z_RCP = 0.032258064f;
    protected static final Matrix covariance = new Matrix();
    protected final ColourSet colours;
    protected final Squish.CompressionType type;

    protected CompressorColourFit(ColourSet colours, Squish.CompressionType type2) {
        this.colours = colours;
        this.type = type2;
    }

    final void compress(byte[] block, int offset) {
        if (this.type == Squish.CompressionType.DXT1) {
            this.compress3(block, offset);
            if (!this.colours.isTransparent()) {
                this.compress4(block, offset);
            }
        } else {
            this.compress4(block, offset);
        }
    }

    abstract void compress3(byte[] var1, int var2);

    abstract void compress4(byte[] var1, int var2);

    protected static float clamp(float v, float GRID, float GRID_RCP) {
        if (v <= 0.0f) {
            return 0.0f;
        }
        if (v >= 1.0f) {
            return 1.0f;
        }
        return (float)((int)(GRID * v + 0.5f)) * GRID_RCP;
    }
}

