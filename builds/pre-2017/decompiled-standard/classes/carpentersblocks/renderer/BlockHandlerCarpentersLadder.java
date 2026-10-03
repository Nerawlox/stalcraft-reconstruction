/*
 * Decompiled with CFR 0.152.
 */
package carpentersblocks.renderer;

import carpentersblocks.renderer.BlockHandlerBase;
import carpentersblocks.tileentity.TECarpentersBlock;
import carpentersblocks.util.BlockProperties;
import org.lwjgl.opengl.GL11;

public class BlockHandlerCarpentersLadder
extends BlockHandlerBase {
    @Override
    public void renderInventoryBlock(twgu twgu2, int n, int n2, htvc htvc2) {
        htvf htvf2 = htvc2.__aF;
        GL11.glRotatef(90.0f, 0.0f, 1.0f, 0.0f);
        GL11.glTranslatef(-0.5f, -0.5f, -0.5f);
        for (int i = 0; i < 6; ++i) {
            switch (i) {
                case 0: {
                    htvc2._a(0.0, 0.0, 0.375, 0.125, 1.0, 0.625);
                    break;
                }
                case 1: {
                    htvc2._a(0.875, 0.0, 0.375, 1.0, 1.0, 0.625);
                    break;
                }
                case 2: {
                    htvc2._a(0.125, 0.125, 0.4375, 0.875, 0.1875, 0.5625);
                    break;
                }
                case 3: {
                    htvc2._a(0.125, 0.375, 0.4375, 0.875, 0.4375, 0.5625);
                    break;
                }
                case 4: {
                    htvc2._a(0.125, 0.625, 0.4375, 0.875, 0.6875, 0.5625);
                    break;
                }
                case 5: {
                    htvc2._a(0.125, 0.875, 0.4375, 0.875, 0.9375, 0.5625);
                }
            }
            htvf2.func_78382_b();
            htvf2.func_78375_b(0.0f, -1.0f, 0.0f);
            htvc2._a(twgu2, 0.0, 0.0, 0.0, twgu2.func_71851_a(0));
            htvf2.func_78381_a();
            htvf2.func_78382_b();
            htvf2.func_78375_b(0.0f, 1.0f, 0.0f);
            htvc2._b(twgu2, 0.0, 0.0, 0.0, twgu2.func_71851_a(1));
            htvf2.func_78381_a();
            htvf2.func_78382_b();
            htvf2.func_78375_b(0.0f, 0.0f, -1.0f);
            htvc2._c(twgu2, 0.0, 0.0, 0.0, twgu2.func_71851_a(2));
            htvf2.func_78381_a();
            htvf2.func_78382_b();
            htvf2.func_78375_b(0.0f, 0.0f, 1.0f);
            htvc2._d(twgu2, 0.0, 0.0, 0.0, twgu2.func_71851_a(3));
            htvf2.func_78381_a();
            htvf2.func_78382_b();
            htvf2.func_78375_b(-1.0f, 0.0f, 0.0f);
            htvc2._e(twgu2, 0.0, 0.0, 0.0, twgu2.func_71851_a(4));
            htvf2.func_78381_a();
            htvf2.func_78382_b();
            htvf2.func_78375_b(1.0f, 0.0f, 0.0f);
            htvc2._f(twgu2, 0.0, 0.0, 0.0, twgu2.func_71851_a(5));
            htvf2.func_78381_a();
        }
        GL11.glTranslatef(0.5f, 0.5f, 0.5f);
    }

    @Override
    public boolean renderCarpentersBlock(TECarpentersBlock tECarpentersBlock, htvc htvc2, twgu twgu2, int n, int n2, int n3, int n4) {
        this.disableAO = true;
        int n5 = htvc2._a.func_72805_g(n2, n3, n4);
        twgu twgu3 = BlockProperties.getCoverBlock(tECarpentersBlock, 6);
        double d = 0.0;
        double d2 = 1.0;
        double d3 = 0.0;
        double d4 = 1.0;
        boolean bl = tECarpentersBlock.field_70331_k.func_72798_a(n2 - 1, n3, n4) == twgu2.field_71990_ca && tECarpentersBlock.field_70331_k.func_72805_g(n2 - 1, n3, n4) == n5;
        boolean bl2 = tECarpentersBlock.field_70331_k.func_72798_a(n2 + 1, n3, n4) == twgu2.field_71990_ca && tECarpentersBlock.field_70331_k.func_72805_g(n2 + 1, n3, n4) == n5;
        boolean bl3 = tECarpentersBlock.field_70331_k.func_72798_a(n2, n3, n4 - 1) == twgu2.field_71990_ca && tECarpentersBlock.field_70331_k.func_72805_g(n2, n3, n4 - 1) == n5;
        boolean bl4 = tECarpentersBlock.field_70331_k.func_72798_a(n2, n3, n4 + 1) == twgu2.field_71990_ca && tECarpentersBlock.field_70331_k.func_72805_g(n2, n3, n4 + 1) == n5;
        switch (n5) {
            case 0: {
                if (!bl) {
                    htvc2._a(0.0, 0.0, 0.375, 0.125, 1.0, 0.625);
                    this.renderStandardBlock(tECarpentersBlock, htvc2, twgu3, twgu2, n2, n3, n4);
                }
                if (!bl2) {
                    htvc2._a(0.875, 0.0, 0.375, 1.0, 1.0, 0.625);
                    this.renderStandardBlock(tECarpentersBlock, htvc2, twgu3, twgu2, n2, n3, n4);
                }
                d = bl ? 0.0 : 0.125;
                d2 = bl2 ? 1.0 : 0.875;
                htvc2._a(d, 0.125, 0.4375, d2, 0.1875, 0.5625);
                this.renderStandardBlock(tECarpentersBlock, htvc2, twgu3, twgu2, n2, n3, n4);
                htvc2._a(d, 0.375, 0.4375, d2, 0.4375, 0.5625);
                this.renderStandardBlock(tECarpentersBlock, htvc2, twgu3, twgu2, n2, n3, n4);
                htvc2._a(d, 0.625, 0.4375, d2, 0.6875, 0.5625);
                this.renderStandardBlock(tECarpentersBlock, htvc2, twgu3, twgu2, n2, n3, n4);
                htvc2._a(d, 0.875, 0.4375, d2, 0.9375, 0.5625);
                this.renderStandardBlock(tECarpentersBlock, htvc2, twgu3, twgu2, n2, n3, n4);
                break;
            }
            case 1: {
                if (!bl3) {
                    htvc2._a(0.375, 0.0, 0.0, 0.625, 1.0, 0.125);
                    this.renderStandardBlock(tECarpentersBlock, htvc2, twgu3, twgu2, n2, n3, n4);
                }
                if (!bl4) {
                    htvc2._a(0.375, 0.0, 0.875, 0.625, 1.0, 1.0);
                    this.renderStandardBlock(tECarpentersBlock, htvc2, twgu3, twgu2, n2, n3, n4);
                }
                d3 = bl3 ? 0.0 : 0.125;
                d4 = bl4 ? 1.0 : 0.875;
                htvc2._a(0.4375, 0.125, d3, 0.5625, 0.1875, d4);
                this.renderStandardBlock(tECarpentersBlock, htvc2, twgu3, twgu2, n2, n3, n4);
                htvc2._a(0.4375, 0.375, d3, 0.5625, 0.4375, d4);
                this.renderStandardBlock(tECarpentersBlock, htvc2, twgu3, twgu2, n2, n3, n4);
                htvc2._a(0.4375, 0.625, d3, 0.5625, 0.6875, d4);
                this.renderStandardBlock(tECarpentersBlock, htvc2, twgu3, twgu2, n2, n3, n4);
                htvc2._a(0.4375, 0.875, d3, 0.5625, 0.9375, d4);
                this.renderStandardBlock(tECarpentersBlock, htvc2, twgu3, twgu2, n2, n3, n4);
                break;
            }
            case 2: {
                if (!bl) {
                    htvc2._a(0.0, 0.0, 0.8125, 0.125, 1.0, 1.0);
                    this.renderStandardBlock(tECarpentersBlock, htvc2, twgu3, twgu2, n2, n3, n4);
                }
                if (!bl2) {
                    htvc2._a(0.875, 0.0, 0.8125, 1.0, 1.0, 1.0);
                    this.renderStandardBlock(tECarpentersBlock, htvc2, twgu3, twgu2, n2, n3, n4);
                }
                d = bl ? 0.0 : 0.125;
                d2 = bl2 ? 1.0 : 0.875;
                htvc2._a(d, 0.125, 0.875, d2, 0.1875, 1.0);
                this.renderStandardBlock(tECarpentersBlock, htvc2, twgu3, twgu2, n2, n3, n4);
                htvc2._a(d, 0.375, 0.875, d2, 0.4375, 1.0);
                this.renderStandardBlock(tECarpentersBlock, htvc2, twgu3, twgu2, n2, n3, n4);
                htvc2._a(d, 0.625, 0.875, d2, 0.6875, 1.0);
                this.renderStandardBlock(tECarpentersBlock, htvc2, twgu3, twgu2, n2, n3, n4);
                htvc2._a(d, 0.875, 0.875, d2, 0.9375, 1.0);
                this.renderStandardBlock(tECarpentersBlock, htvc2, twgu3, twgu2, n2, n3, n4);
                break;
            }
            case 3: {
                if (!bl) {
                    htvc2._a(0.0, 0.0, 0.0, 0.125, 1.0, 0.1875);
                    this.renderStandardBlock(tECarpentersBlock, htvc2, twgu3, twgu2, n2, n3, n4);
                }
                if (!bl2) {
                    htvc2._a(0.875, 0.0, 0.0, 1.0, 1.0, 0.1875);
                    this.renderStandardBlock(tECarpentersBlock, htvc2, twgu3, twgu2, n2, n3, n4);
                }
                d = bl ? 0.0 : 0.125;
                d2 = bl2 ? 1.0 : 0.875;
                htvc2._a(d, 0.125, 0.0, d2, 0.1875, 0.1875);
                this.renderStandardBlock(tECarpentersBlock, htvc2, twgu3, twgu2, n2, n3, n4);
                htvc2._a(d, 0.375, 0.0, d2, 0.4375, 0.1875);
                this.renderStandardBlock(tECarpentersBlock, htvc2, twgu3, twgu2, n2, n3, n4);
                htvc2._a(d, 0.625, 0.0, d2, 0.6875, 0.1875);
                this.renderStandardBlock(tECarpentersBlock, htvc2, twgu3, twgu2, n2, n3, n4);
                htvc2._a(d, 0.875, 0.0, d2, 0.9375, 0.1875);
                this.renderStandardBlock(tECarpentersBlock, htvc2, twgu3, twgu2, n2, n3, n4);
                break;
            }
            case 4: {
                if (!bl3) {
                    htvc2._a(0.8125, 0.0, 0.0, 1.0, 1.0, 0.125);
                    this.renderStandardBlock(tECarpentersBlock, htvc2, twgu3, twgu2, n2, n3, n4);
                }
                if (!bl4) {
                    htvc2._a(0.8125, 0.0, 0.875, 1.0, 1.0, 1.0);
                    this.renderStandardBlock(tECarpentersBlock, htvc2, twgu3, twgu2, n2, n3, n4);
                }
                d3 = bl3 ? 0.0 : 0.125;
                d4 = bl4 ? 1.0 : 0.875;
                htvc2._a(0.875, 0.125, d3, 1.0, 0.1875, d4);
                this.renderStandardBlock(tECarpentersBlock, htvc2, twgu3, twgu2, n2, n3, n4);
                htvc2._a(0.875, 0.375, d3, 1.0, 0.4375, d4);
                this.renderStandardBlock(tECarpentersBlock, htvc2, twgu3, twgu2, n2, n3, n4);
                htvc2._a(0.875, 0.625, d3, 1.0, 0.6875, d4);
                this.renderStandardBlock(tECarpentersBlock, htvc2, twgu3, twgu2, n2, n3, n4);
                htvc2._a(0.875, 0.875, d3, 1.0, 0.9375, d4);
                this.renderStandardBlock(tECarpentersBlock, htvc2, twgu3, twgu2, n2, n3, n4);
                break;
            }
            case 5: {
                if (!bl3) {
                    htvc2._a(0.0, 0.0, 0.0, 0.1875, 1.0, 0.125);
                    this.renderStandardBlock(tECarpentersBlock, htvc2, twgu3, twgu2, n2, n3, n4);
                }
                if (!bl4) {
                    htvc2._a(0.0, 0.0, 0.875, 0.1875, 1.0, 1.0);
                    this.renderStandardBlock(tECarpentersBlock, htvc2, twgu3, twgu2, n2, n3, n4);
                }
                d3 = bl3 ? 0.0 : 0.125;
                d4 = bl4 ? 1.0 : 0.875;
                htvc2._a(0.0, 0.125, d3, 0.1875, 0.1875, d4);
                this.renderStandardBlock(tECarpentersBlock, htvc2, twgu3, twgu2, n2, n3, n4);
                htvc2._a(0.0, 0.375, d3, 0.1875, 0.4375, d4);
                this.renderStandardBlock(tECarpentersBlock, htvc2, twgu3, twgu2, n2, n3, n4);
                htvc2._a(0.0, 0.625, d3, 0.1875, 0.6875, d4);
                this.renderStandardBlock(tECarpentersBlock, htvc2, twgu3, twgu2, n2, n3, n4);
                htvc2._a(0.0, 0.875, d3, 0.1875, 0.9375, d4);
                this.renderStandardBlock(tECarpentersBlock, htvc2, twgu3, twgu2, n2, n3, n4);
            }
        }
        this.disableAO = false;
        return this.shouldRenderBlock(tECarpentersBlock, htvc2, twgu3, twgu2, n);
    }
}

