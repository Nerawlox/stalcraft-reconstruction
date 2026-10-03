/*
 * Decompiled with CFR 0.152.
 */
package carpentersblocks.renderer;

import carpentersblocks.data.Gate;
import carpentersblocks.renderer.BlockHandlerBase;
import carpentersblocks.tileentity.TECarpentersBlock;
import carpentersblocks.util.BlockProperties;
import cpw.mods.fml.client.registry.ISimpleBlockRenderingHandler;
import net.minecraftforge.common.ForgeDirection;
import org.lwjgl.opengl.GL11;

public class BlockHandlerCarpentersGate
extends BlockHandlerBase
implements ISimpleBlockRenderingHandler {
    @Override
    public void renderInventoryBlock(twgu twgu2, int n, int n2, htvc htvc2) {
        htvf htvf2 = htvc2.__aF;
        GL11.glRotatef(90.0f, 0.0f, 1.0f, 0.0f);
        GL11.glTranslatef(-0.5f, -0.5f, -0.5f);
        for (int i = 0; i < 3; ++i) {
            switch (i) {
                case 0: {
                    htvc2._a(0.0, 0.3125, 0.4375, 0.125, 1.0, 0.5625);
                    break;
                }
                case 1: {
                    htvc2._a(0.125, 0.5, 0.4375, 0.875, 0.9375, 0.5625);
                    break;
                }
                case 2: {
                    htvc2._a(0.875, 0.3125, 0.4375, 1.0, 1.0, 0.5625);
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
        twgu twgu3 = this.isSideCover ? BlockProperties.getCoverBlock(tECarpentersBlock, this.coverRendering) : BlockProperties.getCoverBlock(tECarpentersBlock, 6);
        int n5 = BlockProperties.getData(tECarpentersBlock);
        int n6 = Gate.getType(n5);
        switch (n6) {
            case 4: {
                this.renderPicketGate(tECarpentersBlock, htvc2, twgu3, twgu2, n2, n3, n4);
                break;
            }
            case 5: {
                this.renderVerticalPlankGate(tECarpentersBlock, htvc2, twgu3, twgu2, n2, n3, n4);
                break;
            }
            case 6: {
                this.renderWallGate(tECarpentersBlock, htvc2, twgu3, twgu2, n2, n3, n4);
                break;
            }
            default: {
                this.renderVanillaGate(tECarpentersBlock, htvc2, twgu3, twgu2, n2, n3, n4);
            }
        }
        return this.shouldRenderBlock(tECarpentersBlock, htvc2, twgu3, twgu2, n);
    }

    private void renderVanillaGate(TECarpentersBlock tECarpentersBlock, htvc htvc2, twgu twgu2, twgu twgu3, int n, int n2, int n3) {
        int n4 = BlockProperties.getData(tECarpentersBlock);
        boolean bl = Gate.getState(n4) == 1;
        int n5 = Gate.getDirOpen(n4);
        int n6 = Gate.getFacing(n4);
        float f = 0.375f;
        float f2 = 0.5625f;
        float f3 = 0.75f;
        float f4 = 0.9375f;
        float f5 = 0.3125f;
        float f6 = 1.0f;
        float f7 = (float)Gate.getType(n4) * 0.0625f;
        boolean bl2 = htvc2._a.func_72798_a(n, n2 + 1, n3) == twgu3.field_71990_ca;
        boolean bl3 = htvc2._a.func_72798_a(n, n2 - 1, n3) == twgu3.field_71990_ca;
        boolean bl4 = Gate.getType(n4) == 3;
        htvc2._d = true;
        if (n6 == 0) {
            htvc2._a(0.0, bl3 ? 0.0 : (double)(f5 - f7), 0.4375, 0.125, bl2 ? 1.0 : (double)f6, 0.5625);
            this.renderStandardBlock(tECarpentersBlock, htvc2, twgu2, twgu3, n, n2, n3);
            htvc2._a(0.875, bl3 ? 0.0 : (double)(f5 - f7), 0.4375, 1.0, bl2 ? 1.0 : (double)f6, 0.5625);
            this.renderStandardBlock(tECarpentersBlock, htvc2, twgu2, twgu3, n, n2, n3);
        } else {
            htvc2._a(0.4375, bl3 ? 0.0 : (double)(f5 - f7), 0.0, 0.5625, bl2 ? 1.0 : (double)f6, 0.125);
            this.renderStandardBlock(tECarpentersBlock, htvc2, twgu2, twgu3, n, n2, n3);
            htvc2._a(0.4375, bl3 ? 0.0 : (double)(f5 - f7), 0.875, 0.5625, bl2 ? 1.0 : (double)f6, 1.0);
            this.renderStandardBlock(tECarpentersBlock, htvc2, twgu2, twgu3, n, n2, n3);
        }
        if (bl) {
            if (n6 == 1) {
                if (n5 == 0) {
                    if (!bl4) {
                        htvc2._a(0.8125, bl3 ? 0.0 : (double)(f - f7), 0.0, 0.9375, bl2 ? 1.0 : (double)f4, 0.125);
                        this.renderStandardBlock(tECarpentersBlock, htvc2, twgu2, twgu3, n, n2, n3);
                        htvc2._a(0.8125, bl3 ? 0.0 : (double)(f - f7), 0.875, 0.9375, bl2 ? 1.0 : (double)f4, 1.0);
                        this.renderStandardBlock(tECarpentersBlock, htvc2, twgu2, twgu3, n, n2, n3);
                        htvc2._a(0.5625, f - f7, 0.0, 0.8125, (double)f2, 0.125);
                        this.renderStandardBlock(tECarpentersBlock, htvc2, twgu2, twgu3, n, n2, n3);
                        htvc2._a(0.5625, f - f7, 0.875, 0.8125, (double)f2, 1.0);
                        this.renderStandardBlock(tECarpentersBlock, htvc2, twgu2, twgu3, n, n2, n3);
                        htvc2._a(0.5625, f3 - f7, 0.0, 0.8125, (double)f4, 0.125);
                        this.renderStandardBlock(tECarpentersBlock, htvc2, twgu2, twgu3, n, n2, n3);
                        htvc2._a(0.5625, f3 - f7, 0.875, 0.8125, (double)f4, 1.0);
                        this.renderStandardBlock(tECarpentersBlock, htvc2, twgu2, twgu3, n, n2, n3);
                    } else {
                        htvc2._a(0.5625, bl3 ? 0.0 : 0.1875, 0.0, 0.9375, bl2 ? 1.0 : (double)f4, 0.125);
                        this.renderStandardBlock(tECarpentersBlock, htvc2, twgu2, twgu3, n, n2, n3);
                        htvc2._a(0.5625, bl3 ? 0.0 : 0.1875, 0.875, 0.9375, bl2 ? 1.0 : (double)f4, 1.0);
                        this.renderStandardBlock(tECarpentersBlock, htvc2, twgu2, twgu3, n, n2, n3);
                    }
                } else if (!bl4) {
                    htvc2._a(0.0625, bl3 ? 0.0 : (double)(f - f7), 0.0, 0.1875, bl2 ? 1.0 : (double)f4, 0.125);
                    this.renderStandardBlock(tECarpentersBlock, htvc2, twgu2, twgu3, n, n2, n3);
                    htvc2._a(0.0625, bl3 ? 0.0 : (double)(f - f7), 0.875, 0.1875, bl2 ? 1.0 : (double)f4, 1.0);
                    this.renderStandardBlock(tECarpentersBlock, htvc2, twgu2, twgu3, n, n2, n3);
                    htvc2._a(0.1875, f - f7, 0.0, 0.4375, (double)f2, 0.125);
                    this.renderStandardBlock(tECarpentersBlock, htvc2, twgu2, twgu3, n, n2, n3);
                    htvc2._a(0.1875, f - f7, 0.875, 0.4375, (double)f2, 1.0);
                    this.renderStandardBlock(tECarpentersBlock, htvc2, twgu2, twgu3, n, n2, n3);
                    htvc2._a(0.1875, f3 - f7, 0.0, 0.4375, (double)f4, 0.125);
                    this.renderStandardBlock(tECarpentersBlock, htvc2, twgu2, twgu3, n, n2, n3);
                    htvc2._a(0.1875, f3 - f7, 0.875, 0.4375, (double)f4, 1.0);
                    this.renderStandardBlock(tECarpentersBlock, htvc2, twgu2, twgu3, n, n2, n3);
                } else {
                    htvc2._a(0.0625, bl3 ? 0.0 : (double)(f - f7), 0.0, 0.4375, bl2 ? 1.0 : (double)f4, 0.125);
                    this.renderStandardBlock(tECarpentersBlock, htvc2, twgu2, twgu3, n, n2, n3);
                    htvc2._a(0.0625, bl3 ? 0.0 : (double)(f - f7), 0.875, 0.4375, bl2 ? 1.0 : (double)f4, 1.0);
                    this.renderStandardBlock(tECarpentersBlock, htvc2, twgu2, twgu3, n, n2, n3);
                }
            } else if (n5 == 0) {
                if (!bl4) {
                    htvc2._a(0.0, bl3 ? 0.0 : (double)(f - f7), 0.8125, 0.125, bl2 ? 1.0 : (double)f4, 0.9375);
                    this.renderStandardBlock(tECarpentersBlock, htvc2, twgu2, twgu3, n, n2, n3);
                    htvc2._a(0.875, bl3 ? 0.0 : (double)(f - f7), 0.8125, 1.0, bl2 ? 1.0 : (double)f4, 0.9375);
                    this.renderStandardBlock(tECarpentersBlock, htvc2, twgu2, twgu3, n, n2, n3);
                    htvc2._a(0.0, f - f7, 0.5625, 0.125, (double)f2, 0.8125);
                    this.renderStandardBlock(tECarpentersBlock, htvc2, twgu2, twgu3, n, n2, n3);
                    htvc2._a(0.875, f - f7, 0.5625, 1.0, (double)f2, 0.8125);
                    this.renderStandardBlock(tECarpentersBlock, htvc2, twgu2, twgu3, n, n2, n3);
                    htvc2._a(0.0, f3 - f7, 0.5625, 0.125, (double)f4, 0.8125);
                    this.renderStandardBlock(tECarpentersBlock, htvc2, twgu2, twgu3, n, n2, n3);
                    htvc2._a(0.875, f3 - f7, 0.5625, 1.0, (double)f4, 0.8125);
                    this.renderStandardBlock(tECarpentersBlock, htvc2, twgu2, twgu3, n, n2, n3);
                } else {
                    htvc2._a(0.875, bl3 ? 0.0 : (double)(f - f7), 0.5625, 1.0, bl2 ? 1.0 : (double)f4, 0.9375);
                    this.renderStandardBlock(tECarpentersBlock, htvc2, twgu2, twgu3, n, n2, n3);
                    htvc2._a(0.0, bl3 ? 0.0 : (double)(f - f7), 0.5625, 0.125, bl2 ? 1.0 : (double)f4, 0.9375);
                    this.renderStandardBlock(tECarpentersBlock, htvc2, twgu2, twgu3, n, n2, n3);
                }
            } else if (!bl4) {
                htvc2._a(0.0, bl3 ? 0.0 : (double)(f - f7), 0.0625, 0.125, bl2 ? 1.0 : (double)f4, 0.1875);
                this.renderStandardBlock(tECarpentersBlock, htvc2, twgu2, twgu3, n, n2, n3);
                htvc2._a(0.875, bl3 ? 0.0 : (double)(f - f7), 0.0625, 1.0, bl2 ? 1.0 : (double)f4, 0.1875);
                this.renderStandardBlock(tECarpentersBlock, htvc2, twgu2, twgu3, n, n2, n3);
                htvc2._a(0.0, f - f7, 0.1875, 0.125, (double)f2, 0.4375);
                this.renderStandardBlock(tECarpentersBlock, htvc2, twgu2, twgu3, n, n2, n3);
                htvc2._a(0.875, f - f7, 0.1875, 1.0, (double)f2, 0.4375);
                this.renderStandardBlock(tECarpentersBlock, htvc2, twgu2, twgu3, n, n2, n3);
                htvc2._a(0.0, f3 - f7, 0.1875, 0.125, (double)f4, 0.4375);
                this.renderStandardBlock(tECarpentersBlock, htvc2, twgu2, twgu3, n, n2, n3);
                htvc2._a(0.875, f3 - f7, 0.1875, 1.0, (double)f4, 0.4375);
                this.renderStandardBlock(tECarpentersBlock, htvc2, twgu2, twgu3, n, n2, n3);
            } else {
                htvc2._a(0.875, bl3 ? 0.0 : (double)(f - f7), 0.0625, 1.0, bl2 ? 1.0 : (double)f4, 0.4375);
                this.renderStandardBlock(tECarpentersBlock, htvc2, twgu2, twgu3, n, n2, n3);
                htvc2._a(0.0, bl3 ? 0.0 : (double)(f - f7), 0.0625, 0.125, bl2 ? 1.0 : (double)f4, 0.4375);
                this.renderStandardBlock(tECarpentersBlock, htvc2, twgu2, twgu3, n, n2, n3);
            }
        } else if (n6 == 0) {
            if (!bl4) {
                htvc2._a(0.375, bl3 ? 0.0 : (double)(f - f7), 0.4375, 0.5, bl2 ? 1.0 : (double)f4, 0.5625);
                this.renderStandardBlock(tECarpentersBlock, htvc2, twgu2, twgu3, n, n2, n3);
                htvc2._a(0.5, bl3 ? 0.0 : (double)(f - f7), 0.4375, 0.625, bl2 ? 1.0 : (double)f4, 0.5625);
                this.renderStandardBlock(tECarpentersBlock, htvc2, twgu2, twgu3, n, n2, n3);
                htvc2._a(0.625, f - f7, 0.4375, 0.875, (double)f2, 0.5625);
                this.renderStandardBlock(tECarpentersBlock, htvc2, twgu2, twgu3, n, n2, n3);
                htvc2._a(0.625, f3 - f7, 0.4375, 0.875, (double)f4, 0.5625);
                this.renderStandardBlock(tECarpentersBlock, htvc2, twgu2, twgu3, n, n2, n3);
                htvc2._a(0.125, f - f7, 0.4375, 0.375, (double)f2, 0.5625);
                this.renderStandardBlock(tECarpentersBlock, htvc2, twgu2, twgu3, n, n2, n3);
                htvc2._a(0.125, f3 - f7, 0.4375, 0.375, (double)f4, 0.5625);
                this.renderStandardBlock(tECarpentersBlock, htvc2, twgu2, twgu3, n, n2, n3);
            } else {
                htvc2._a(0.125, bl3 ? 0.0 : (double)(f - f7), 0.4375, 0.875, bl2 ? 1.0 : (double)f4, 0.5625);
                this.renderStandardBlock(tECarpentersBlock, htvc2, twgu2, twgu3, n, n2, n3);
            }
        } else if (!bl4) {
            htvc2._a(0.4375, bl3 ? 0.0 : (double)(f - f7), 0.375, 0.5625, bl2 ? 1.0 : (double)f4, 0.5);
            this.renderStandardBlock(tECarpentersBlock, htvc2, twgu2, twgu3, n, n2, n3);
            htvc2._a(0.4375, bl3 ? 0.0 : (double)(f - f7), 0.5, 0.5625, bl2 ? 1.0 : (double)f4, 0.625);
            this.renderStandardBlock(tECarpentersBlock, htvc2, twgu2, twgu3, n, n2, n3);
            htvc2._a(0.4375, f - f7, 0.625, 0.5625, (double)f2, 0.875);
            this.renderStandardBlock(tECarpentersBlock, htvc2, twgu2, twgu3, n, n2, n3);
            htvc2._a(0.4375, f3 - f7, 0.625, 0.5625, (double)f4, 0.875);
            this.renderStandardBlock(tECarpentersBlock, htvc2, twgu2, twgu3, n, n2, n3);
            htvc2._a(0.4375, f - f7, 0.125, 0.5625, (double)f2, 0.375);
            this.renderStandardBlock(tECarpentersBlock, htvc2, twgu2, twgu3, n, n2, n3);
            htvc2._a(0.4375, f3 - f7, 0.125, 0.5625, (double)f4, 0.375);
            this.renderStandardBlock(tECarpentersBlock, htvc2, twgu2, twgu3, n, n2, n3);
        } else {
            htvc2._a(0.4375, bl3 ? 0.0 : (double)(f - f7), 0.125, 0.5625, bl2 ? 1.0 : (double)f4, 0.875);
            this.renderStandardBlock(tECarpentersBlock, htvc2, twgu2, twgu3, n, n2, n3);
        }
        htvc2._d = false;
        htvc2._a(0.0, 0.0, 0.0, 1.0, 1.0, 1.0);
    }

    private void renderPicketGate(TECarpentersBlock tECarpentersBlock, htvc htvc2, twgu twgu2, twgu twgu3, int n, int n2, int n3) {
        int n4 = BlockProperties.getData(tECarpentersBlock);
        boolean bl = Gate.getState(n4) == 1;
        int n5 = Gate.getDirOpen(n4);
        int n6 = Gate.getFacing(n4);
        float f = 0.0f;
        float f2 = 1.0f;
        float f3 = 0.0f;
        float f4 = 1.0f;
        float f5 = 0.0f;
        float f6 = 1.0f;
        boolean bl2 = htvc2._a.func_72798_a(n, n2 + 1, n3) == twgu3.field_71990_ca;
        boolean bl3 = htvc2._a.func_72798_a(n, n2 - 1, n3) == twgu3.field_71990_ca;
        htvc2._d = true;
        if (bl) {
            if (n6 == 1) {
                if (n5 == 0) {
                    f = 0.5f;
                    f5 = 0.0625f;
                    f6 = 0.1875f;
                    if (!bl2) {
                        f3 = 0.625f;
                        f4 = 0.6875f;
                        htvc2._a(f, f3, (double)f5, (double)f2, (double)f4, (double)f6);
                        this.renderStandardBlock(tECarpentersBlock, htvc2, twgu2, twgu3, n, n2, n3);
                        f5 = 0.8125f;
                        f6 = 0.9375f;
                        htvc2._a(f, f3, (double)f5, (double)f2, (double)f4, (double)f6);
                        this.renderStandardBlock(tECarpentersBlock, htvc2, twgu2, twgu3, n, n2, n3);
                    }
                    if (!bl3) {
                        f3 = 0.1875f;
                        f4 = 0.25f;
                        f5 = 0.0625f;
                        f6 = 0.1875f;
                        htvc2._a(f, f3, (double)f5, (double)f2, (double)f4, (double)f6);
                        this.renderStandardBlock(tECarpentersBlock, htvc2, twgu2, twgu3, n, n2, n3);
                        f5 = 0.8125f;
                        f6 = 0.9375f;
                        htvc2._a(f, f3, (double)f5, (double)f2, (double)f4, (double)f6);
                        this.renderStandardBlock(tECarpentersBlock, htvc2, twgu2, twgu3, n, n2, n3);
                    }
                    f3 = bl3 ? 0.0f : 0.0625f;
                    for (int i = 0; i < 3; ++i) {
                        switch (i) {
                            case 0: {
                                f2 = 0.5625f;
                                f4 = bl2 ? 1.0f : 0.8125f;
                                break;
                            }
                            case 1: {
                                f = 0.6875f;
                                f2 = 0.8125f;
                                f4 = bl2 ? 1.0f : 0.875f;
                                break;
                            }
                            case 2: {
                                f = 0.9375f;
                                f2 = 1.0f;
                                f4 = bl2 ? 1.0f : 0.875f;
                            }
                        }
                        f5 = 0.0f;
                        f6 = 0.0625f;
                        htvc2._a(f, f3, (double)f5, (double)f2, (double)f4, (double)f6);
                        this.renderStandardBlock(tECarpentersBlock, htvc2, twgu2, twgu3, n, n2, n3);
                        htvc2._a(f, f3, (double)(f5 += 0.1875f), (double)f2, (double)f4, (double)(f6 += 0.1875f));
                        this.renderStandardBlock(tECarpentersBlock, htvc2, twgu2, twgu3, n, n2, n3);
                        f5 = 0.75f;
                        f6 = 0.8125f;
                        htvc2._a(f, f3, (double)f5, (double)f2, (double)f4, (double)f6);
                        this.renderStandardBlock(tECarpentersBlock, htvc2, twgu2, twgu3, n, n2, n3);
                        htvc2._a(f, f3, (double)(f5 += 0.1875f), (double)f2, (double)f4, (double)(f6 += 0.1875f));
                        this.renderStandardBlock(tECarpentersBlock, htvc2, twgu2, twgu3, n, n2, n3);
                    }
                } else {
                    f2 = 0.5f;
                    f5 = 0.0625f;
                    f6 = 0.1875f;
                    if (!bl2) {
                        f3 = 0.625f;
                        f4 = 0.6875f;
                        htvc2._a(f, f3, (double)f5, (double)f2, (double)f4, (double)f6);
                        this.renderStandardBlock(tECarpentersBlock, htvc2, twgu2, twgu3, n, n2, n3);
                        f5 = 0.8125f;
                        f6 = 0.9375f;
                        htvc2._a(f, f3, (double)f5, (double)f2, (double)f4, (double)f6);
                        this.renderStandardBlock(tECarpentersBlock, htvc2, twgu2, twgu3, n, n2, n3);
                    }
                    if (!bl3) {
                        f3 = 0.1875f;
                        f4 = 0.25f;
                        f5 = 0.0625f;
                        f6 = 0.1875f;
                        htvc2._a(f, f3, (double)f5, (double)f2, (double)f4, (double)f6);
                        this.renderStandardBlock(tECarpentersBlock, htvc2, twgu2, twgu3, n, n2, n3);
                        f5 = 0.8125f;
                        f6 = 0.9375f;
                        htvc2._a(f, f3, (double)f5, (double)f2, (double)f4, (double)f6);
                        this.renderStandardBlock(tECarpentersBlock, htvc2, twgu2, twgu3, n, n2, n3);
                    }
                    f3 = bl3 ? 0.0f : 0.0625f;
                    for (int i = 0; i < 3; ++i) {
                        switch (i) {
                            case 0: {
                                f = 0.4375f;
                                f4 = bl2 ? 1.0f : 0.8125f;
                                break;
                            }
                            case 1: {
                                f = 0.1875f;
                                f2 = 0.3125f;
                                f4 = bl2 ? 1.0f : 0.875f;
                                break;
                            }
                            case 2: {
                                f = 0.0f;
                                f2 = 0.0625f;
                                f4 = bl2 ? 1.0f : 0.875f;
                            }
                        }
                        f5 = 0.0f;
                        f6 = 0.0625f;
                        htvc2._a(f, f3, (double)f5, (double)f2, (double)f4, (double)f6);
                        this.renderStandardBlock(tECarpentersBlock, htvc2, twgu2, twgu3, n, n2, n3);
                        htvc2._a(f, f3, (double)(f5 += 0.1875f), (double)f2, (double)f4, (double)(f6 += 0.1875f));
                        this.renderStandardBlock(tECarpentersBlock, htvc2, twgu2, twgu3, n, n2, n3);
                        f5 = 0.75f;
                        f6 = 0.8125f;
                        htvc2._a(f, f3, (double)f5, (double)f2, (double)f4, (double)f6);
                        this.renderStandardBlock(tECarpentersBlock, htvc2, twgu2, twgu3, n, n2, n3);
                        htvc2._a(f, f3, (double)(f5 += 0.1875f), (double)f2, (double)f4, (double)(f6 += 0.1875f));
                        this.renderStandardBlock(tECarpentersBlock, htvc2, twgu2, twgu3, n, n2, n3);
                    }
                }
            } else if (n5 == 0) {
                f = 0.0625f;
                f2 = 0.1875f;
                f5 = 0.5f;
                if (!bl2) {
                    f3 = 0.625f;
                    f4 = 0.6875f;
                    htvc2._a(f, f3, (double)f5, (double)f2, (double)f4, (double)f6);
                    this.renderStandardBlock(tECarpentersBlock, htvc2, twgu2, twgu3, n, n2, n3);
                    f = 0.8125f;
                    f2 = 0.9375f;
                    htvc2._a(f, f3, (double)f5, (double)f2, (double)f4, (double)f6);
                    this.renderStandardBlock(tECarpentersBlock, htvc2, twgu2, twgu3, n, n2, n3);
                }
                if (!bl3) {
                    f = 0.0625f;
                    f2 = 0.1875f;
                    f3 = 0.1875f;
                    f4 = 0.25f;
                    htvc2._a(f, f3, (double)f5, (double)f2, (double)f4, (double)f6);
                    this.renderStandardBlock(tECarpentersBlock, htvc2, twgu2, twgu3, n, n2, n3);
                    f = 0.8125f;
                    f2 = 0.9375f;
                    htvc2._a(f, f3, (double)f5, (double)f2, (double)f4, (double)f6);
                    this.renderStandardBlock(tECarpentersBlock, htvc2, twgu2, twgu3, n, n2, n3);
                }
                f3 = bl3 ? 0.0f : 0.0625f;
                for (int i = 0; i < 3; ++i) {
                    switch (i) {
                        case 0: {
                            f4 = bl2 ? 1.0f : 0.8125f;
                            f6 = 0.5625f;
                            break;
                        }
                        case 1: {
                            f4 = bl2 ? 1.0f : 0.875f;
                            f5 = 0.6875f;
                            f6 = 0.8125f;
                            break;
                        }
                        case 2: {
                            f4 = bl2 ? 1.0f : 0.875f;
                            f5 = 0.9375f;
                            f6 = 1.0f;
                        }
                    }
                    f = 0.0f;
                    f2 = 0.0625f;
                    htvc2._a(f, f3, (double)f5, (double)f2, (double)f4, (double)f6);
                    this.renderStandardBlock(tECarpentersBlock, htvc2, twgu2, twgu3, n, n2, n3);
                    htvc2._a(f += 0.1875f, f3, (double)f5, (double)(f2 += 0.1875f), (double)f4, (double)f6);
                    this.renderStandardBlock(tECarpentersBlock, htvc2, twgu2, twgu3, n, n2, n3);
                    f = 0.75f;
                    f2 = 0.8125f;
                    htvc2._a(f, f3, (double)f5, (double)f2, (double)f4, (double)f6);
                    this.renderStandardBlock(tECarpentersBlock, htvc2, twgu2, twgu3, n, n2, n3);
                    htvc2._a(f += 0.1875f, f3, (double)f5, (double)(f2 += 0.1875f), (double)f4, (double)f6);
                    this.renderStandardBlock(tECarpentersBlock, htvc2, twgu2, twgu3, n, n2, n3);
                }
            } else {
                f = 0.0625f;
                f2 = 0.1875f;
                f6 = 0.5f;
                if (!bl2) {
                    f3 = 0.625f;
                    f4 = 0.6875f;
                    htvc2._a(f, f3, (double)f5, (double)f2, (double)f4, (double)f6);
                    this.renderStandardBlock(tECarpentersBlock, htvc2, twgu2, twgu3, n, n2, n3);
                    f = 0.8125f;
                    f2 = 0.9375f;
                    htvc2._a(f, f3, (double)f5, (double)f2, (double)f4, (double)f6);
                    this.renderStandardBlock(tECarpentersBlock, htvc2, twgu2, twgu3, n, n2, n3);
                }
                if (!bl3) {
                    f = 0.0625f;
                    f2 = 0.1875f;
                    f3 = 0.1875f;
                    f4 = 0.25f;
                    htvc2._a(f, f3, (double)f5, (double)f2, (double)f4, (double)f6);
                    this.renderStandardBlock(tECarpentersBlock, htvc2, twgu2, twgu3, n, n2, n3);
                    f = 0.8125f;
                    f2 = 0.9375f;
                    htvc2._a(f, f3, (double)f5, (double)f2, (double)f4, (double)f6);
                    this.renderStandardBlock(tECarpentersBlock, htvc2, twgu2, twgu3, n, n2, n3);
                }
                f3 = bl3 ? 0.0f : 0.0625f;
                for (int i = 0; i < 3; ++i) {
                    switch (i) {
                        case 0: {
                            f4 = bl2 ? 1.0f : 0.8125f;
                            f5 = 0.4375f;
                            break;
                        }
                        case 1: {
                            f4 = bl2 ? 1.0f : 0.875f;
                            f5 = 0.1875f;
                            f6 = 0.3125f;
                            break;
                        }
                        case 2: {
                            f4 = bl2 ? 1.0f : 0.875f;
                            f5 = 0.0f;
                            f6 = 0.0625f;
                        }
                    }
                    f = 0.0f;
                    f2 = 0.0625f;
                    htvc2._a(f, f3, (double)f5, (double)f2, (double)f4, (double)f6);
                    this.renderStandardBlock(tECarpentersBlock, htvc2, twgu2, twgu3, n, n2, n3);
                    htvc2._a(f += 0.1875f, f3, (double)f5, (double)(f2 += 0.1875f), (double)f4, (double)f6);
                    this.renderStandardBlock(tECarpentersBlock, htvc2, twgu2, twgu3, n, n2, n3);
                    f = 0.75f;
                    f2 = 0.8125f;
                    htvc2._a(f, f3, (double)f5, (double)f2, (double)f4, (double)f6);
                    this.renderStandardBlock(tECarpentersBlock, htvc2, twgu2, twgu3, n, n2, n3);
                    htvc2._a(f += 0.1875f, f3, (double)f5, (double)(f2 += 0.1875f), (double)f4, (double)f6);
                    this.renderStandardBlock(tECarpentersBlock, htvc2, twgu2, twgu3, n, n2, n3);
                }
            }
        } else if (n6 == 0) {
            f5 = 0.4375f;
            f6 = 0.5625f;
            if (!bl2) {
                f3 = 0.625f;
                f4 = 0.6875f;
                htvc2._a(f, f3, (double)f5, (double)f2, (double)f4, (double)f6);
                this.renderStandardBlock(tECarpentersBlock, htvc2, twgu2, twgu3, n, n2, n3);
            }
            if (!bl3) {
                f3 = 0.1875f;
                f4 = 0.25f;
                htvc2._a(f, f3, (double)f5, (double)f2, (double)f4, (double)f6);
                this.renderStandardBlock(tECarpentersBlock, htvc2, twgu2, twgu3, n, n2, n3);
            }
            f3 = bl3 ? 0.0f : 0.0625f;
            for (int i = 0; i < 5; ++i) {
                switch (i) {
                    case 0: {
                        f = 0.0f;
                        f2 = 0.0625f;
                        f4 = bl2 ? 1.0f : 0.8125f;
                        break;
                    }
                    case 1: {
                        f = 0.1875f;
                        f2 = 0.3125f;
                        f4 = bl2 ? 1.0f : 0.875f;
                        break;
                    }
                    case 2: {
                        f = 0.4375f;
                        f2 = 0.5625f;
                        f4 = bl2 ? 1.0f : 0.875f;
                        break;
                    }
                    case 3: {
                        f = 0.6875f;
                        f2 = 0.8125f;
                        f4 = bl2 ? 1.0f : 0.875f;
                        break;
                    }
                    case 4: {
                        f = 0.9375f;
                        f2 = 1.0f;
                        f4 = bl2 ? 1.0f : 0.8125f;
                    }
                }
                f5 = 0.5625f;
                f6 = 0.625f;
                htvc2._a(f, f3, (double)f5, (double)f2, (double)f4, (double)f6);
                this.renderStandardBlock(tECarpentersBlock, htvc2, twgu2, twgu3, n, n2, n3);
                htvc2._a(f, f3, (double)(f5 -= 0.1875f), (double)f2, (double)f4, (double)(f6 -= 0.1875f));
                this.renderStandardBlock(tECarpentersBlock, htvc2, twgu2, twgu3, n, n2, n3);
            }
        } else {
            f = 0.4375f;
            f2 = 0.5625f;
            if (!bl2) {
                f3 = 0.625f;
                f4 = 0.6875f;
                htvc2._a(f, f3, (double)f5, (double)f2, (double)f4, (double)f6);
                this.renderStandardBlock(tECarpentersBlock, htvc2, twgu2, twgu3, n, n2, n3);
            }
            if (!bl3) {
                f3 = 0.1875f;
                f4 = 0.25f;
                htvc2._a(f, f3, (double)f5, (double)f2, (double)f4, (double)f6);
                this.renderStandardBlock(tECarpentersBlock, htvc2, twgu2, twgu3, n, n2, n3);
            }
            f3 = bl3 ? 0.0f : 0.0625f;
            for (int i = 0; i < 5; ++i) {
                switch (i) {
                    case 0: {
                        f4 = bl2 ? 1.0f : 0.8125f;
                        f5 = 0.0f;
                        f6 = 0.0625f;
                        break;
                    }
                    case 1: {
                        f4 = bl2 ? 1.0f : 0.875f;
                        f5 = 0.1875f;
                        f6 = 0.3125f;
                        break;
                    }
                    case 2: {
                        f4 = bl2 ? 1.0f : 0.875f;
                        f5 = 0.4375f;
                        f6 = 0.5625f;
                        break;
                    }
                    case 3: {
                        f4 = bl2 ? 1.0f : 0.875f;
                        f5 = 0.6875f;
                        f6 = 0.8125f;
                        break;
                    }
                    case 4: {
                        f4 = bl2 ? 1.0f : 0.8125f;
                        f5 = 0.9375f;
                        f6 = 1.0f;
                    }
                }
                f = 0.5625f;
                f2 = 0.625f;
                htvc2._a(f, f3, (double)f5, (double)f2, (double)f4, (double)f6);
                this.renderStandardBlock(tECarpentersBlock, htvc2, twgu2, twgu3, n, n2, n3);
                htvc2._a(f -= 0.1875f, f3, (double)f5, (double)(f2 -= 0.1875f), (double)f4, (double)f6);
                this.renderStandardBlock(tECarpentersBlock, htvc2, twgu2, twgu3, n, n2, n3);
            }
        }
        htvc2._d = false;
        htvc2._a(0.0, 0.0, 0.0, 1.0, 1.0, 1.0);
    }

    private void renderVerticalPlankGate(TECarpentersBlock tECarpentersBlock, htvc htvc2, twgu twgu2, twgu twgu3, int n, int n2, int n3) {
        int n4 = BlockProperties.getData(tECarpentersBlock);
        boolean bl = Gate.getState(n4) == 1;
        int n5 = Gate.getDirOpen(n4);
        int n6 = Gate.getFacing(n4);
        float f = 0.0f;
        float f2 = 1.0f;
        float f3 = 0.0f;
        float f4 = 1.0f;
        float f5 = 0.0f;
        float f6 = 1.0f;
        boolean bl2 = htvc2._a.func_72798_a(n, n2 + 1, n3) == twgu3.field_71990_ca;
        boolean bl3 = htvc2._a.func_72798_a(n, n2 - 1, n3) == twgu3.field_71990_ca;
        htvc2._d = true;
        if (bl) {
            if (n6 == 1) {
                if (n5 == 0) {
                    f = 0.5f;
                    f5 = 0.0625f;
                    f6 = 0.1875f;
                    if (!bl2) {
                        f3 = 0.75f;
                        f4 = 0.875f;
                        htvc2._a(f, f3, (double)f5, (double)f2, (double)f4, (double)f6);
                        this.renderStandardBlock(tECarpentersBlock, htvc2, twgu2, twgu3, n, n2, n3);
                        f5 = 0.8125f;
                        f6 = 0.9375f;
                        htvc2._a(f, f3, (double)f5, (double)f2, (double)f4, (double)f6);
                        this.renderStandardBlock(tECarpentersBlock, htvc2, twgu2, twgu3, n, n2, n3);
                    }
                    if (!bl3) {
                        f3 = 0.125f;
                        f4 = 0.25f;
                        f5 = 0.0625f;
                        f6 = 0.1875f;
                        htvc2._a(f, f3, (double)f5, (double)f2, (double)f4, (double)f6);
                        this.renderStandardBlock(tECarpentersBlock, htvc2, twgu2, twgu3, n, n2, n3);
                        f5 = 0.8125f;
                        f6 = 0.9375f;
                        htvc2._a(f, f3, (double)f5, (double)f2, (double)f4, (double)f6);
                        this.renderStandardBlock(tECarpentersBlock, htvc2, twgu2, twgu3, n, n2, n3);
                    }
                    f3 = 0.0f;
                    f4 = 1.0f;
                    f5 = 0.0f;
                    for (int i = 0; i < 2; ++i) {
                        switch (i) {
                            case 0: {
                                f2 = 0.6875f;
                                f6 = 0.0625f;
                                break;
                            }
                            case 1: {
                                f = 0.8125f;
                                f2 = 1.0f;
                                f5 = 0.0f;
                                f6 = 0.0625f;
                            }
                        }
                        htvc2._a(f, f3, (double)f5, (double)f2, (double)f4, (double)f6);
                        this.renderStandardBlock(tECarpentersBlock, htvc2, twgu2, twgu3, n, n2, n3);
                        htvc2._a(f, f3, (double)(f5 += 0.1875f), (double)f2, (double)f4, (double)(f6 += 0.1875f));
                        this.renderStandardBlock(tECarpentersBlock, htvc2, twgu2, twgu3, n, n2, n3);
                        f5 = 0.75f;
                        f6 = 0.8125f;
                        htvc2._a(f, f3, (double)f5, (double)f2, (double)f4, (double)f6);
                        this.renderStandardBlock(tECarpentersBlock, htvc2, twgu2, twgu3, n, n2, n3);
                        htvc2._a(f, f3, (double)(f5 += 0.1875f), (double)f2, (double)f4, (double)(f6 += 0.1875f));
                        this.renderStandardBlock(tECarpentersBlock, htvc2, twgu2, twgu3, n, n2, n3);
                    }
                } else {
                    f2 = 0.5f;
                    f5 = 0.0625f;
                    f6 = 0.1875f;
                    if (!bl2) {
                        f3 = 0.75f;
                        f4 = 0.875f;
                        htvc2._a(f, f3, (double)f5, (double)f2, (double)f4, (double)f6);
                        this.renderStandardBlock(tECarpentersBlock, htvc2, twgu2, twgu3, n, n2, n3);
                        f5 = 0.8125f;
                        f6 = 0.9375f;
                        htvc2._a(f, f3, (double)f5, (double)f2, (double)f4, (double)f6);
                        this.renderStandardBlock(tECarpentersBlock, htvc2, twgu2, twgu3, n, n2, n3);
                    }
                    if (!bl3) {
                        f3 = 0.125f;
                        f4 = 0.25f;
                        f5 = 0.0625f;
                        f6 = 0.1875f;
                        htvc2._a(f, f3, (double)f5, (double)f2, (double)f4, (double)f6);
                        this.renderStandardBlock(tECarpentersBlock, htvc2, twgu2, twgu3, n, n2, n3);
                        f5 = 0.8125f;
                        f6 = 0.9375f;
                        htvc2._a(f, f3, (double)f5, (double)f2, (double)f4, (double)f6);
                        this.renderStandardBlock(tECarpentersBlock, htvc2, twgu2, twgu3, n, n2, n3);
                    }
                    f3 = 0.0f;
                    f4 = 1.0f;
                    f5 = 0.0f;
                    for (int i = 0; i < 2; ++i) {
                        switch (i) {
                            case 0: {
                                f = 0.3125f;
                                f6 = 0.0625f;
                                break;
                            }
                            case 1: {
                                f = 0.0f;
                                f2 = 0.1875f;
                                f5 = 0.0f;
                                f6 = 0.0625f;
                            }
                        }
                        htvc2._a(f, f3, (double)f5, (double)f2, (double)f4, (double)f6);
                        this.renderStandardBlock(tECarpentersBlock, htvc2, twgu2, twgu3, n, n2, n3);
                        htvc2._a(f, f3, (double)(f5 += 0.1875f), (double)f2, (double)f4, (double)(f6 += 0.1875f));
                        this.renderStandardBlock(tECarpentersBlock, htvc2, twgu2, twgu3, n, n2, n3);
                        f5 = 0.75f;
                        f6 = 0.8125f;
                        htvc2._a(f, f3, (double)f5, (double)f2, (double)f4, (double)f6);
                        this.renderStandardBlock(tECarpentersBlock, htvc2, twgu2, twgu3, n, n2, n3);
                        htvc2._a(f, f3, (double)(f5 += 0.1875f), (double)f2, (double)f4, (double)(f6 += 0.1875f));
                        this.renderStandardBlock(tECarpentersBlock, htvc2, twgu2, twgu3, n, n2, n3);
                    }
                }
            } else if (n5 == 0) {
                f = 0.0625f;
                f2 = 0.1875f;
                f5 = 0.5f;
                if (!bl2) {
                    f3 = 0.75f;
                    f4 = 0.875f;
                    htvc2._a(f, f3, (double)f5, (double)f2, (double)f4, (double)f6);
                    this.renderStandardBlock(tECarpentersBlock, htvc2, twgu2, twgu3, n, n2, n3);
                    f = 0.8125f;
                    f2 = 0.9375f;
                    htvc2._a(f, f3, (double)f5, (double)f2, (double)f4, (double)f6);
                    this.renderStandardBlock(tECarpentersBlock, htvc2, twgu2, twgu3, n, n2, n3);
                }
                if (!bl3) {
                    f = 0.0625f;
                    f2 = 0.1875f;
                    f3 = 0.125f;
                    f4 = 0.25f;
                    htvc2._a(f, f3, (double)f5, (double)f2, (double)f4, (double)f6);
                    this.renderStandardBlock(tECarpentersBlock, htvc2, twgu2, twgu3, n, n2, n3);
                    f = 0.8125f;
                    f2 = 0.9375f;
                    htvc2._a(f, f3, (double)f5, (double)f2, (double)f4, (double)f6);
                    this.renderStandardBlock(tECarpentersBlock, htvc2, twgu2, twgu3, n, n2, n3);
                }
                f = 0.0f;
                f3 = 0.0f;
                f4 = 1.0f;
                for (int i = 0; i < 2; ++i) {
                    switch (i) {
                        case 0: {
                            f6 = 0.6875f;
                            f2 = 0.0625f;
                            break;
                        }
                        case 1: {
                            f = 0.0f;
                            f2 = 0.0625f;
                            f5 = 0.8125f;
                            f6 = 1.0f;
                        }
                    }
                    htvc2._a(f, f3, (double)f5, (double)f2, (double)f4, (double)f6);
                    this.renderStandardBlock(tECarpentersBlock, htvc2, twgu2, twgu3, n, n2, n3);
                    htvc2._a(f += 0.1875f, f3, (double)f5, (double)(f2 += 0.1875f), (double)f4, (double)f6);
                    this.renderStandardBlock(tECarpentersBlock, htvc2, twgu2, twgu3, n, n2, n3);
                    f = 0.75f;
                    f2 = 0.8125f;
                    htvc2._a(f, f3, (double)f5, (double)f2, (double)f4, (double)f6);
                    this.renderStandardBlock(tECarpentersBlock, htvc2, twgu2, twgu3, n, n2, n3);
                    htvc2._a(f += 0.1875f, f3, (double)f5, (double)(f2 += 0.1875f), (double)f4, (double)f6);
                    this.renderStandardBlock(tECarpentersBlock, htvc2, twgu2, twgu3, n, n2, n3);
                }
            } else {
                f = 0.0625f;
                f2 = 0.1875f;
                f6 = 0.5f;
                if (!bl2) {
                    f3 = 0.75f;
                    f4 = 0.875f;
                    htvc2._a(f, f3, (double)f5, (double)f2, (double)f4, (double)f6);
                    this.renderStandardBlock(tECarpentersBlock, htvc2, twgu2, twgu3, n, n2, n3);
                    f = 0.8125f;
                    f2 = 0.9375f;
                    htvc2._a(f, f3, (double)f5, (double)f2, (double)f4, (double)f6);
                    this.renderStandardBlock(tECarpentersBlock, htvc2, twgu2, twgu3, n, n2, n3);
                }
                if (!bl3) {
                    f = 0.0625f;
                    f2 = 0.1875f;
                    f3 = 0.125f;
                    f4 = 0.25f;
                    htvc2._a(f, f3, (double)f5, (double)f2, (double)f4, (double)f6);
                    this.renderStandardBlock(tECarpentersBlock, htvc2, twgu2, twgu3, n, n2, n3);
                    f = 0.8125f;
                    f2 = 0.9375f;
                    htvc2._a(f, f3, (double)f5, (double)f2, (double)f4, (double)f6);
                    this.renderStandardBlock(tECarpentersBlock, htvc2, twgu2, twgu3, n, n2, n3);
                }
                f = 0.0f;
                f3 = 0.0f;
                f4 = 1.0f;
                for (int i = 0; i < 2; ++i) {
                    switch (i) {
                        case 0: {
                            f2 = 0.0625f;
                            f5 = 0.3125f;
                            break;
                        }
                        case 1: {
                            f = 0.0f;
                            f2 = 0.0625f;
                            f5 = 0.0f;
                            f6 = 0.1875f;
                        }
                    }
                    htvc2._a(f, f3, (double)f5, (double)f2, (double)f4, (double)f6);
                    this.renderStandardBlock(tECarpentersBlock, htvc2, twgu2, twgu3, n, n2, n3);
                    htvc2._a(f += 0.1875f, f3, (double)f5, (double)(f2 += 0.1875f), (double)f4, (double)f6);
                    this.renderStandardBlock(tECarpentersBlock, htvc2, twgu2, twgu3, n, n2, n3);
                    f = 0.75f;
                    f2 = 0.8125f;
                    htvc2._a(f, f3, (double)f5, (double)f2, (double)f4, (double)f6);
                    this.renderStandardBlock(tECarpentersBlock, htvc2, twgu2, twgu3, n, n2, n3);
                    htvc2._a(f += 0.1875f, f3, (double)f5, (double)(f2 += 0.1875f), (double)f4, (double)f6);
                    this.renderStandardBlock(tECarpentersBlock, htvc2, twgu2, twgu3, n, n2, n3);
                }
            }
        } else if (n6 == 0) {
            f5 = 0.4375f;
            f6 = 0.5625f;
            if (!bl2) {
                f3 = 0.75f;
                f4 = 0.875f;
                htvc2._a(f, f3, (double)f5, (double)f2, (double)f4, (double)f6);
                this.renderStandardBlock(tECarpentersBlock, htvc2, twgu2, twgu3, n, n2, n3);
            }
            if (!bl3) {
                f3 = 0.125f;
                f4 = 0.25f;
                htvc2._a(f, f3, (double)f5, (double)f2, (double)f4, (double)f6);
                this.renderStandardBlock(tECarpentersBlock, htvc2, twgu2, twgu3, n, n2, n3);
            }
            f3 = 0.0f;
            f4 = 1.0f;
            for (int i = 0; i < 3; ++i) {
                switch (i) {
                    case 0: {
                        f = 0.0f;
                        f2 = 0.1875f;
                        break;
                    }
                    case 1: {
                        f = 0.3125f;
                        f2 = 0.6875f;
                        break;
                    }
                    case 2: {
                        f = 0.8125f;
                        f2 = 1.0f;
                    }
                }
                f5 = 0.5625f;
                f6 = 0.625f;
                htvc2._a(f, f3, (double)f5, (double)f2, (double)f4, (double)f6);
                this.renderStandardBlock(tECarpentersBlock, htvc2, twgu2, twgu3, n, n2, n3);
                htvc2._a(f, f3, (double)(f5 -= 0.1875f), (double)f2, (double)f4, (double)(f6 -= 0.1875f));
                this.renderStandardBlock(tECarpentersBlock, htvc2, twgu2, twgu3, n, n2, n3);
            }
        } else {
            f = 0.4375f;
            f2 = 0.5625f;
            if (!bl2) {
                f3 = 0.75f;
                f4 = 0.875f;
                htvc2._a(f, f3, (double)f5, (double)f2, (double)f4, (double)f6);
                this.renderStandardBlock(tECarpentersBlock, htvc2, twgu2, twgu3, n, n2, n3);
            }
            if (!bl3) {
                f3 = 0.125f;
                f4 = 0.25f;
                htvc2._a(f, f3, (double)f5, (double)f2, (double)f4, (double)f6);
                this.renderStandardBlock(tECarpentersBlock, htvc2, twgu2, twgu3, n, n2, n3);
            }
            f3 = 0.0f;
            f4 = 1.0f;
            for (int i = 0; i < 3; ++i) {
                switch (i) {
                    case 0: {
                        f5 = 0.0f;
                        f6 = 0.1875f;
                        break;
                    }
                    case 1: {
                        f5 = 0.3125f;
                        f6 = 0.6875f;
                        break;
                    }
                    case 2: {
                        f5 = 0.8125f;
                        f6 = 1.0f;
                    }
                }
                f = 0.5625f;
                f2 = 0.625f;
                htvc2._a(f, f3, (double)f5, (double)f2, (double)f4, (double)f6);
                this.renderStandardBlock(tECarpentersBlock, htvc2, twgu2, twgu3, n, n2, n3);
                htvc2._a(f -= 0.1875f, f3, (double)f5, (double)(f2 -= 0.1875f), (double)f4, (double)f6);
                this.renderStandardBlock(tECarpentersBlock, htvc2, twgu2, twgu3, n, n2, n3);
            }
        }
        htvc2._d = false;
        htvc2._a(0.0, 0.0, 0.0, 1.0, 1.0, 1.0);
    }

    private void renderWallGate(TECarpentersBlock tECarpentersBlock, htvc htvc2, twgu twgu2, twgu twgu3, int n, int n2, int n3) {
        int n4 = BlockProperties.getData(tECarpentersBlock);
        boolean bl = Gate.getState(n4) == 1;
        int n5 = Gate.getDirOpen(n4);
        int n6 = Gate.getFacing(n4);
        float f = 0.0f;
        float f2 = 1.0f;
        float f3 = 0.0f;
        float f4 = 1.0f;
        float f5 = 0.0f;
        float f6 = 1.0f;
        boolean bl2 = htvc2._a.func_72798_a(n, n2 + 1, n3) == twgu3.field_71990_ca;
        f4 = !bl2 && !htvc2._a.isBlockSolidOnSide(n, n2 + 1, n3, ForgeDirection.DOWN, true) ? 0.8125f : 1.0f;
        htvc2._d = true;
        if (bl) {
            if (n6 == 1) {
                if (n5 == 0) {
                    f = 0.5f;
                    f6 = 0.125f;
                    htvc2._a(f, f3, (double)f5, (double)f2, (double)f4, (double)f6);
                    this.renderStandardBlock(tECarpentersBlock, htvc2, twgu2, twgu3, n, n2, n3);
                    f5 = 0.875f;
                    f6 = 1.0f;
                    htvc2._a(f, f3, (double)f5, (double)f2, (double)f4, (double)f6);
                    this.renderStandardBlock(tECarpentersBlock, htvc2, twgu2, twgu3, n, n2, n3);
                } else {
                    f2 = 0.5f;
                    f6 = 0.125f;
                    htvc2._a(f, f3, (double)f5, (double)f2, (double)f4, (double)f6);
                    this.renderStandardBlock(tECarpentersBlock, htvc2, twgu2, twgu3, n, n2, n3);
                    f5 = 0.875f;
                    f6 = 1.0f;
                    htvc2._a(f, f3, (double)f5, (double)f2, (double)f4, (double)f6);
                    this.renderStandardBlock(tECarpentersBlock, htvc2, twgu2, twgu3, n, n2, n3);
                }
            } else if (n5 == 0) {
                f2 = 0.125f;
                f5 = 0.5f;
                htvc2._a(f, f3, (double)f5, (double)f2, (double)f4, (double)f6);
                this.renderStandardBlock(tECarpentersBlock, htvc2, twgu2, twgu3, n, n2, n3);
                f = 0.875f;
                f2 = 1.0f;
                htvc2._a(f, f3, (double)f5, (double)f2, (double)f4, (double)f6);
                this.renderStandardBlock(tECarpentersBlock, htvc2, twgu2, twgu3, n, n2, n3);
            } else {
                f2 = 0.125f;
                f6 = 0.5f;
                htvc2._a(f, f3, (double)f5, (double)f2, (double)f4, (double)f6);
                this.renderStandardBlock(tECarpentersBlock, htvc2, twgu2, twgu3, n, n2, n3);
                f = 0.875f;
                f2 = 1.0f;
                htvc2._a(f, f3, (double)f5, (double)f2, (double)f4, (double)f6);
                this.renderStandardBlock(tECarpentersBlock, htvc2, twgu2, twgu3, n, n2, n3);
            }
        } else if (n6 == 0) {
            f5 = 0.4375f;
            f6 = 0.5625f;
            htvc2._a(f, f3, (double)f5, (double)f2, (double)f4, (double)f6);
            this.renderStandardBlock(tECarpentersBlock, htvc2, twgu2, twgu3, n, n2, n3);
        } else {
            f = 0.4375f;
            f2 = 0.5625f;
            htvc2._a(f, f3, (double)f5, (double)f2, (double)f4, (double)f6);
            this.renderStandardBlock(tECarpentersBlock, htvc2, twgu2, twgu3, n, n2, n3);
        }
        htvc2._d = false;
        htvc2._a(0.0, 0.0, 0.0, 1.0, 1.0, 1.0);
    }
}

