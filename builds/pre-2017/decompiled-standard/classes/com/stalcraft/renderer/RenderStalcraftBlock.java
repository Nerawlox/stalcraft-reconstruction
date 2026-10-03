/*
 * Decompiled with CFR 0.152.
 */
package com.stalcraft.renderer;

import org.lwjgl.util.vector.Matrix3f;

public class RenderStalcraftBlock
extends hsdi {
    private Matrix3f scaleMatrix;
    private Matrix3f rotation0;
    private Matrix3f rotation90;
    private Matrix3f rotation180;
    private Matrix3f rotation270;

    public RenderStalcraftBlock(String string, float f, float f2, float f3) {
        super(string);
        this.uFactor = 2.0f;
        this.rotation0 = this.scaleMatrix = jywc._b(f, f2, f3);
        this.rotation90 = Matrix3f.mul(jywc._a(90.0f, 0.0f, 1.0f, 0.0f), this.scaleMatrix, null);
        this.rotation180 = Matrix3f.mul(jywc._a(180.0f, 0.0f, 1.0f, 0.0f), this.scaleMatrix, null);
        this.rotation270 = Matrix3f.mul(jywc._a(270.0f, 0.0f, 1.0f, 0.0f), this.scaleMatrix, null);
    }

    @Override
    public boolean renderWorldBlock(sdrg sdrg2, int n, int n2, int n3, twgu twgu2, int n4, htvc htvc2) {
        int n5 = sdrg2.func_72805_g(n, n2, n3);
        htvf htvf2 = htvc2.__aF;
        htvf2.func_78372_c((float)n + 0.5f, n2, (float)n3 + 0.5f);
        htvf2.func_78380_c(twgu2.func_71874_e(sdrg2, n, n2, n3));
        this.performRender(twgu2, n5, htvf2);
        htvf2.func_78372_c((float)(-n) - 0.5f, -n2, (float)(-n3) - 0.5f);
        return true;
    }

    protected void performRender(twgu twgu2, int n, htvf htvf2) {
        if (n == 2) {
            this.renderWithTessellator(twgu2.func_71858_a(0, n), this.rotation0, htvf2);
        } else if (n == 3) {
            this.renderWithTessellator(twgu2.func_71858_a(0, n), this.rotation270, htvf2);
        } else if (n == 0) {
            this.renderWithTessellator(twgu2.func_71858_a(0, n), this.rotation180, htvf2);
        } else if (n == 1) {
            this.renderWithTessellator(twgu2.func_71858_a(0, n), this.rotation90, htvf2);
        }
    }
}

