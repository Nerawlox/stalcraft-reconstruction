/*
 * Decompiled with CFR 0.152.
 */
package carpentersblocks.renderer;

import carpentersblocks.block.BlockCarpentersHatch;
import carpentersblocks.data.Hatch;
import carpentersblocks.renderer.HingedBase;
import carpentersblocks.tileentity.TECarpentersBlock;
import carpentersblocks.util.BlockProperties;
import carpentersblocks.util.handler.BlockHandler;
import carpentersblocks.util.handler.IconHandler;
import net.minecraft.util.dwan;
import org.lwjgl.opengl.GL11;

public class BlockHandlerCarpentersHatch
extends HingedBase {
    @Override
    public void renderInventoryBlock(twgu twgu2, int n, int n2, htvc htvc2) {
        htvf htvf2 = htvc2.__aF;
        GL11.glRotatef(90.0f, 0.0f, 1.0f, 0.0f);
        GL11.glTranslatef(-0.5f, -0.5f, -0.5f);
        for (int i = 0; i < 4; ++i) {
            switch (i) {
                case 0: {
                    htvc2._a(0.0, 0.2, 0.0, 1.0, 0.3875, 1.0);
                    break;
                }
                case 1: {
                    twgu2 = twgu.field_71981_t;
                    htvc2._a(0.125, 0.3875, 0.375, 0.1875, 0.45, 0.4375);
                    break;
                }
                case 2: {
                    htvc2._a(0.5625, 0.3875, 0.125, 0.625, 0.45, 0.1875);
                    break;
                }
                case 3: {
                    htvc2._a(0.375, 0.45, 0.125, 0.625, 0.5125, 0.1875);
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
        int n6 = Hatch.getType(n5);
        switch (n6) {
            case 0: {
                this.renderHiddenHatch(tECarpentersBlock, htvc2, twgu3, twgu2, n, n2, n3, n4);
                break;
            }
            case 1: {
                this.renderHollowHatch(tECarpentersBlock, htvc2, twgu3, twgu2, n, n2, n3, n4);
                break;
            }
            case 2: {
                this.renderHollowHatch(tECarpentersBlock, htvc2, twgu3, twgu2, n, n2, n3, n4);
                break;
            }
            case 3: {
                this.renderFrenchWindowHatch(tECarpentersBlock, htvc2, twgu3, twgu2, n, n2, n3, n4);
                break;
            }
            case 4: {
                this.renderPanelHatch(tECarpentersBlock, htvc2, twgu3, twgu2, n, n2, n3, n4);
            }
        }
        return this.shouldRenderBlock(tECarpentersBlock, htvc2, twgu3, twgu2, n);
    }

    public boolean renderHiddenHatch(TECarpentersBlock tECarpentersBlock, htvc htvc2, twgu twgu2, twgu twgu3, int n, int n2, int n3, int n4) {
        if (this.shouldRenderFrame(tECarpentersBlock, htvc2, twgu2, n)) {
            BlockCarpentersHatch blockCarpentersHatch = (BlockCarpentersHatch)BlockHandler.blockCarpentersHatch;
            blockCarpentersHatch.func_71902_a(htvc2._a, n2, n3, n4);
            this.renderStandardBlock(tECarpentersBlock, htvc2, twgu2, twgu3, n2, n3, n4);
        }
        if (this.shouldRenderPieces(tECarpentersBlock, htvc2, twgu2, n)) {
            this.renderHandle(tECarpentersBlock, htvc2, twgu.field_72083_ai, n2, n3, n4, true, false);
        }
        return true;
    }

    public boolean renderHollowHatch(TECarpentersBlock tECarpentersBlock, htvc htvc2, twgu twgu2, twgu twgu3, int n, int n2, int n3, int n4) {
        htvc2._d = true;
        int n5 = BlockProperties.getData(tECarpentersBlock);
        int n6 = Hatch.getDir(n5);
        int n7 = Hatch.getPos(n5);
        int n8 = Hatch.getState(n5);
        boolean bl = false;
        boolean bl2 = false;
        float f = 0.0f;
        float f2 = 0.0f;
        float f3 = 0.0f;
        float f4 = 0.0f;
        float f5 = 1.0f;
        float f6 = 1.0f;
        float f7 = 1.0f;
        if (n8 == 0) {
            bl2 = true;
            if (n7 == 0) {
                f6 = 0.1875f;
                f = 0.09375f;
            } else {
                f3 = 0.8125f;
                f = 0.90625f;
            }
        } else {
            switch (n6) {
                case 0: {
                    f4 = 0.8125f;
                    bl = true;
                    f = 0.09375f;
                    break;
                }
                case 1: {
                    f7 = 0.1875f;
                    bl = true;
                    f = 0.90625f;
                    break;
                }
                case 2: {
                    f2 = 0.8125f;
                    f = 0.09375f;
                    break;
                }
                case 3: {
                    f5 = 0.1875f;
                    f = 0.90625f;
                }
            }
        }
        if (this.shouldRenderFrame(tECarpentersBlock, htvc2, twgu2, n)) {
            if (bl) {
                htvc2._a(0.0, f3, (double)f4, 0.1875, (double)f6, (double)f7);
                this.renderStandardBlock(tECarpentersBlock, htvc2, twgu2, twgu3, n2, n3, n4);
                htvc2._a(0.8125, f3, (double)f4, 1.0, (double)f6, (double)f7);
                this.renderStandardBlock(tECarpentersBlock, htvc2, twgu2, twgu3, n2, n3, n4);
                htvc2._a(0.1875, 0.0, (double)f4, 0.8125, 0.1875, (double)f7);
                this.renderStandardBlock(tECarpentersBlock, htvc2, twgu2, twgu3, n2, n3, n4);
                htvc2._a(0.1875, 0.8125, (double)f4, 0.8125, 1.0, (double)f7);
                this.renderStandardBlock(tECarpentersBlock, htvc2, twgu2, twgu3, n2, n3, n4);
            } else if (bl2) {
                htvc2._a(0.0, f3, (double)f4, 0.1875, (double)f6, (double)f7);
                this.renderStandardBlock(tECarpentersBlock, htvc2, twgu2, twgu3, n2, n3, n4);
                htvc2._a(0.8125, f3, (double)f4, 1.0, (double)f6, (double)f7);
                this.renderStandardBlock(tECarpentersBlock, htvc2, twgu2, twgu3, n2, n3, n4);
                htvc2._a(0.1875, f3, 0.0, 0.8125, (double)f6, 0.1875);
                this.renderStandardBlock(tECarpentersBlock, htvc2, twgu2, twgu3, n2, n3, n4);
                htvc2._a(0.1875, f3, 0.8125, 0.8125, (double)f6, 1.0);
                this.renderStandardBlock(tECarpentersBlock, htvc2, twgu2, twgu3, n2, n3, n4);
            } else {
                htvc2._a(f2, f3, 0.0, (double)f5, (double)f6, 0.1875);
                this.renderStandardBlock(tECarpentersBlock, htvc2, twgu2, twgu3, n2, n3, n4);
                htvc2._a(f2, f3, 0.8125, (double)f5, (double)f6, 1.0);
                this.renderStandardBlock(tECarpentersBlock, htvc2, twgu2, twgu3, n2, n3, n4);
                htvc2._a(f2, 0.0, 0.1875, (double)f5, 0.1875, 0.8125);
                this.renderStandardBlock(tECarpentersBlock, htvc2, twgu2, twgu3, n2, n3, n4);
                htvc2._a(f2, 0.8125, 0.1875, (double)f5, 1.0, 0.8125);
                this.renderStandardBlock(tECarpentersBlock, htvc2, twgu2, twgu3, n2, n3, n4);
            }
        }
        if (this.shouldRenderPieces(tECarpentersBlock, htvc2, twgu2, n)) {
            dwan dwan2 = Hatch.getType(n5) == 2 ? IconHandler.icon_hatch_screen : IconHandler.icon_hatch_glass;
            htvc2.__aF.func_78380_c(twgu.field_71946_M.func_71874_e(htvc2._a, n2, n3, n4));
            if (bl) {
                htvc2.__aE.setOffset(-(1.0f - f));
                htvc2.__aF.func_78386_a(0.8f, 0.8f, 0.8f);
                htvc2._a(0.1875, 0.1875, 0.0, 0.8125, 0.8125, 1.0);
                this.renderHelper.renderFaceZNeg(htvc2, n2, n3, n4, dwan2);
                htvc2.__aE.setOffset(-f);
                this.renderHelper.renderFaceZPos(htvc2, n2, n3, n4, dwan2);
            } else if (bl2) {
                htvc2.__aE.setOffset(-f);
                htvc2.__aF.func_78386_a(0.5f, 0.5f, 0.5f);
                htvc2._a(0.1875, 0.0, 0.1875, 0.8125, 1.0, 0.8125);
                this.renderHelper.renderFaceYNeg(htvc2, n2, n3, n4, dwan2);
                htvc2.__aE.setOffset(-(1.0f - f));
                htvc2.__aF.func_78386_a(1.0f, 1.0f, 1.0f);
                this.renderHelper.renderFaceYPos(htvc2, n2, n3, n4, dwan2);
            } else {
                htvc2.__aE.setOffset(-(1.0f - f));
                htvc2.__aF.func_78386_a(0.6f, 0.6f, 0.6f);
                htvc2._a(0.0, 0.1875, 0.1875, 1.0, 0.8125, 0.8125);
                this.renderHelper.renderFaceXNeg(htvc2, n2, n3, n4, dwan2);
                htvc2.__aE.setOffset(-f);
                this.renderHelper.renderFaceXPos(htvc2, n2, n3, n4, dwan2);
            }
            htvc2.__aE.clearOffset();
            this.renderHandle(tECarpentersBlock, htvc2, twgu.field_72083_ai, n2, n3, n4, true, true);
        }
        return true;
    }

    public boolean renderFrenchWindowHatch(TECarpentersBlock tECarpentersBlock, htvc htvc2, twgu twgu2, twgu twgu3, int n, int n2, int n3, int n4) {
        htvc2._d = true;
        int n5 = BlockProperties.getData(tECarpentersBlock);
        int n6 = Hatch.getDir(n5);
        int n7 = Hatch.getPos(n5);
        int n8 = Hatch.getState(n5);
        boolean bl = false;
        boolean bl2 = false;
        float f = 0.0f;
        float f2 = 0.0f;
        float f3 = 0.0f;
        float f4 = 0.0f;
        float f5 = 1.0f;
        float f6 = 1.0f;
        float f7 = 1.0f;
        if (n8 == 0) {
            bl2 = true;
            if (n7 == 0) {
                f6 = 0.1875f;
                f = 0.09375f;
            } else {
                f3 = 0.8125f;
                f = 0.90625f;
            }
        } else {
            switch (n6) {
                case 0: {
                    f4 = 0.8125f;
                    bl = true;
                    f = 0.09375f;
                    break;
                }
                case 1: {
                    f7 = 0.1875f;
                    bl = true;
                    f = 0.90625f;
                    break;
                }
                case 2: {
                    f2 = 0.8125f;
                    f = 0.09375f;
                    break;
                }
                case 3: {
                    f5 = 0.1875f;
                    f = 0.90625f;
                }
            }
        }
        if (this.shouldRenderFrame(tECarpentersBlock, htvc2, twgu2, n)) {
            if (bl) {
                htvc2._a(0.0, f3, (double)f4, 0.1875, (double)f6, (double)f7);
                this.renderStandardBlock(tECarpentersBlock, htvc2, twgu2, twgu3, n2, n3, n4);
                htvc2._a(0.8125, f3, (double)f4, 1.0, (double)f6, (double)f7);
                this.renderStandardBlock(tECarpentersBlock, htvc2, twgu2, twgu3, n2, n3, n4);
                htvc2._a(0.1875, 0.0, (double)f4, 0.8125, 0.1875, (double)f7);
                this.renderStandardBlock(tECarpentersBlock, htvc2, twgu2, twgu3, n2, n3, n4);
                htvc2._a(0.1875, 0.8125, (double)f4, 0.8125, 1.0, (double)f7);
                this.renderStandardBlock(tECarpentersBlock, htvc2, twgu2, twgu3, n2, n3, n4);
            } else if (bl2) {
                htvc2._a(0.0, f3, (double)f4, 0.1875, (double)f6, (double)f7);
                this.renderStandardBlock(tECarpentersBlock, htvc2, twgu2, twgu3, n2, n3, n4);
                htvc2._a(0.8125, f3, (double)f4, 1.0, (double)f6, (double)f7);
                this.renderStandardBlock(tECarpentersBlock, htvc2, twgu2, twgu3, n2, n3, n4);
                htvc2._a(0.1875, f3, 0.0, 0.8125, (double)f6, 0.1875);
                this.renderStandardBlock(tECarpentersBlock, htvc2, twgu2, twgu3, n2, n3, n4);
                htvc2._a(0.1875, f3, 0.8125, 0.8125, (double)f6, 1.0);
                this.renderStandardBlock(tECarpentersBlock, htvc2, twgu2, twgu3, n2, n3, n4);
            } else {
                htvc2._a(f2, f3, 0.0, (double)f5, (double)f6, 0.1875);
                this.renderStandardBlock(tECarpentersBlock, htvc2, twgu2, twgu3, n2, n3, n4);
                htvc2._a(f2, f3, 0.8125, (double)f5, (double)f6, 1.0);
                this.renderStandardBlock(tECarpentersBlock, htvc2, twgu2, twgu3, n2, n3, n4);
                htvc2._a(f2, 0.0, 0.1875, (double)f5, 0.1875, 0.8125);
                this.renderStandardBlock(tECarpentersBlock, htvc2, twgu2, twgu3, n2, n3, n4);
                htvc2._a(f2, 0.8125, 0.1875, (double)f5, 1.0, 0.8125);
                this.renderStandardBlock(tECarpentersBlock, htvc2, twgu2, twgu3, n2, n3, n4);
            }
            this.setLightnessOffset(-0.05f);
            if (bl) {
                float f8 = f4 + 0.0625f;
                float f9 = f7 - 0.0625f;
                htvc2._a(0.1875, 0.4375, (double)f8, 0.8125, 0.5625, (double)f9);
                this.renderStandardBlock(tECarpentersBlock, htvc2, twgu2, twgu3, n2, n3, n4);
                htvc2._a(0.4375, 0.1875, (double)f8, 0.5625, 0.4375, (double)f9);
                this.renderStandardBlock(tECarpentersBlock, htvc2, twgu2, twgu3, n2, n3, n4);
                htvc2._a(0.4375, 0.5625, (double)f8, 0.5625, 0.8125, (double)f9);
                this.renderStandardBlock(tECarpentersBlock, htvc2, twgu2, twgu3, n2, n3, n4);
            } else if (bl2) {
                float f10 = f3 + 0.0625f;
                float f11 = f6 - 0.0625f;
                htvc2._a(0.1875, f10, 0.4375, 0.8125, (double)f11, 0.5625);
                this.renderStandardBlock(tECarpentersBlock, htvc2, twgu2, twgu3, n2, n3, n4);
                htvc2._a(0.4375, f10, 0.1875, 0.5625, (double)f11, 0.4375);
                this.renderStandardBlock(tECarpentersBlock, htvc2, twgu2, twgu3, n2, n3, n4);
                htvc2._a(0.4375, f10, 0.5625, 0.5625, (double)f11, 0.8125);
                this.renderStandardBlock(tECarpentersBlock, htvc2, twgu2, twgu3, n2, n3, n4);
            } else {
                float f12 = f2 + 0.0625f;
                float f13 = f5 - 0.0625f;
                htvc2._a(f12, 0.4375, 0.1875, (double)f13, 0.5625, 0.8125);
                this.renderStandardBlock(tECarpentersBlock, htvc2, twgu2, twgu3, n2, n3, n4);
                htvc2._a(f12, 0.1875, 0.4375, (double)f13, 0.4375, 0.5625);
                this.renderStandardBlock(tECarpentersBlock, htvc2, twgu2, twgu3, n2, n3, n4);
                htvc2._a(f12, 0.5625, 0.4375, (double)f13, 0.8125, 0.5625);
                this.renderStandardBlock(tECarpentersBlock, htvc2, twgu2, twgu3, n2, n3, n4);
            }
            this.clearLightnessOffset();
        }
        if (this.shouldRenderPieces(tECarpentersBlock, htvc2, twgu2, n)) {
            htvc2.__aF.func_78380_c(twgu.field_71946_M.func_71874_e(htvc2._a, n2, n3, n4));
            if (bl) {
                htvc2.__aE.setOffset(-(1.0f - f));
                htvc2.__aF.func_78386_a(0.8f, 0.8f, 0.8f);
                htvc2._a(0.1875, 0.1875, 0.0, 0.8125, 0.8125, 1.0);
                this.renderHelper.renderFaceZNeg(htvc2, n2, n3, n4, IconHandler.icon_hatch_french_glass);
                htvc2.__aE.setOffset(-f);
                this.renderHelper.renderFaceZPos(htvc2, n2, n3, n4, IconHandler.icon_hatch_french_glass);
            } else if (bl2) {
                htvc2.__aE.setOffset(-f);
                htvc2.__aF.func_78386_a(0.5f, 0.5f, 0.5f);
                htvc2._a(0.1875, 0.0, 0.1875, 0.8125, 1.0, 0.8125);
                this.renderHelper.renderFaceYNeg(htvc2, n2, n3, n4, IconHandler.icon_hatch_french_glass);
                htvc2.__aE.setOffset(-(1.0f - f));
                htvc2.__aF.func_78386_a(1.0f, 1.0f, 1.0f);
                this.renderHelper.renderFaceYPos(htvc2, n2, n3, n4, IconHandler.icon_hatch_french_glass);
            } else {
                htvc2.__aE.setOffset(-(1.0f - f));
                htvc2.__aF.func_78386_a(0.6f, 0.6f, 0.6f);
                htvc2._a(0.0, 0.1875, 0.1875, 1.0, 0.8125, 0.8125);
                this.renderHelper.renderFaceXNeg(htvc2, n2, n3, n4, IconHandler.icon_hatch_french_glass);
                htvc2.__aE.setOffset(-f);
                this.renderHelper.renderFaceXPos(htvc2, n2, n3, n4, IconHandler.icon_hatch_french_glass);
            }
            htvc2.__aE.clearOffset();
            this.renderHandle(tECarpentersBlock, htvc2, twgu.field_72083_ai, n2, n3, n4, true, true);
        }
        return true;
    }

    public boolean renderPanelHatch(TECarpentersBlock tECarpentersBlock, htvc htvc2, twgu twgu2, twgu twgu3, int n, int n2, int n3, int n4) {
        htvc2._d = true;
        int n5 = BlockProperties.getData(tECarpentersBlock);
        int n6 = Hatch.getDir(n5);
        int n7 = Hatch.getPos(n5);
        int n8 = Hatch.getState(n5);
        boolean bl = false;
        boolean bl2 = false;
        float f = 0.0f;
        float f2 = 0.0f;
        float f3 = 0.0f;
        float f4 = 1.0f;
        float f5 = 1.0f;
        float f6 = 1.0f;
        if (n8 == 0) {
            bl2 = true;
            if (n7 == 0) {
                f5 = 0.1875f;
            } else {
                f2 = 0.8125f;
            }
        } else {
            switch (n6) {
                case 0: {
                    f3 = 0.8125f;
                    bl = true;
                    break;
                }
                case 1: {
                    f6 = 0.1875f;
                    bl = true;
                    break;
                }
                case 2: {
                    f = 0.8125f;
                    break;
                }
                case 3: {
                    f4 = 0.1875f;
                }
            }
        }
        if (this.shouldRenderFrame(tECarpentersBlock, htvc2, twgu2, n)) {
            float f7;
            float f8;
            float f9;
            float f10;
            float f11;
            float f12;
            if (bl) {
                htvc2._a(0.0, f2, (double)f3, 0.1875, (double)f5, (double)f6);
                this.renderStandardBlock(tECarpentersBlock, htvc2, twgu2, twgu3, n2, n3, n4);
                htvc2._a(0.8125, f2, (double)f3, 1.0, (double)f5, (double)f6);
                this.renderStandardBlock(tECarpentersBlock, htvc2, twgu2, twgu3, n2, n3, n4);
                htvc2._a(0.1875, 0.0, (double)f3, 0.8125, 0.1875, (double)f6);
                this.renderStandardBlock(tECarpentersBlock, htvc2, twgu2, twgu3, n2, n3, n4);
                htvc2._a(0.1875, 0.8125, (double)f3, 0.8125, 1.0, (double)f6);
                this.renderStandardBlock(tECarpentersBlock, htvc2, twgu2, twgu3, n2, n3, n4);
            } else if (bl2) {
                htvc2._a(0.0, f2, (double)f3, 0.1875, (double)f5, (double)f6);
                this.renderStandardBlock(tECarpentersBlock, htvc2, twgu2, twgu3, n2, n3, n4);
                htvc2._a(0.8125, f2, (double)f3, 1.0, (double)f5, (double)f6);
                this.renderStandardBlock(tECarpentersBlock, htvc2, twgu2, twgu3, n2, n3, n4);
                htvc2._a(0.1875, f2, 0.0, 0.8125, (double)f5, 0.1875);
                this.renderStandardBlock(tECarpentersBlock, htvc2, twgu2, twgu3, n2, n3, n4);
                htvc2._a(0.1875, f2, 0.8125, 0.8125, (double)f5, 1.0);
                this.renderStandardBlock(tECarpentersBlock, htvc2, twgu2, twgu3, n2, n3, n4);
            } else {
                htvc2._a(f, f2, 0.0, (double)f4, (double)f5, 0.1875);
                this.renderStandardBlock(tECarpentersBlock, htvc2, twgu2, twgu3, n2, n3, n4);
                htvc2._a(f, f2, 0.8125, (double)f4, (double)f5, 1.0);
                this.renderStandardBlock(tECarpentersBlock, htvc2, twgu2, twgu3, n2, n3, n4);
                htvc2._a(f, 0.0, 0.1875, (double)f4, 0.1875, 0.8125);
                this.renderStandardBlock(tECarpentersBlock, htvc2, twgu2, twgu3, n2, n3, n4);
                htvc2._a(f, 0.8125, 0.1875, (double)f4, 1.0, 0.8125);
                this.renderStandardBlock(tECarpentersBlock, htvc2, twgu2, twgu3, n2, n3, n4);
            }
            if (bl) {
                f12 = 0.1875f;
                f11 = 0.8125f;
                f10 = 0.1875f;
                f9 = 0.8125f;
                f8 = f3 + 0.0625f;
                f7 = f6 - 0.0625f;
            } else if (bl2) {
                f12 = 0.1875f;
                f11 = 0.8125f;
                f10 = f2 + 0.0625f;
                f9 = f5 - 0.0625f;
                f8 = 0.1875f;
                f7 = 0.8125f;
            } else {
                f12 = f + 0.0625f;
                f11 = f4 - 0.0625f;
                f10 = 0.1875f;
                f9 = 0.8125f;
                f8 = 0.1875f;
                f7 = 0.8125f;
            }
            this.setLightnessOffset(-0.05f);
            htvc2._a(f12, f10, (double)f8, (double)f11, (double)f9, (double)f7);
            this.renderStandardBlock(tECarpentersBlock, htvc2, twgu2, twgu3, n2, n3, n4);
            this.clearLightnessOffset();
            f12 = f;
            f11 = f4;
            f10 = f2;
            f9 = f5;
            f8 = f3;
            f7 = f6;
            if (bl) {
                f12 = 0.3125f;
                f11 = 0.6875f;
                f10 = 0.3125f;
                f9 = 0.6875f;
            } else if (bl2) {
                f12 = 0.3125f;
                f11 = 0.6875f;
                f8 = 0.3125f;
                f7 = 0.6875f;
            } else {
                f10 = 0.3125f;
                f9 = 0.6875f;
                f8 = 0.3125f;
                f7 = 0.6875f;
            }
            htvc2._a(f12, f10, (double)f8, (double)f11, (double)f9, (double)f7);
            this.renderStandardBlock(tECarpentersBlock, htvc2, twgu2, twgu3, n2, n3, n4);
        }
        if (this.shouldRenderPieces(tECarpentersBlock, htvc2, twgu2, n)) {
            this.renderHandle(tECarpentersBlock, htvc2, twgu.field_72083_ai, n2, n3, n4, true, true);
        }
        return true;
    }

    public boolean renderHandle(TECarpentersBlock tECarpentersBlock, htvc htvc2, twgu twgu2, int n, int n2, int n3, boolean bl, boolean bl2) {
        if (!bl && !bl2) {
            return false;
        }
        htvc2._d = true;
        int n4 = BlockProperties.getData(tECarpentersBlock);
        int n5 = Hatch.getDir(n4);
        int n6 = Hatch.getPos(n4);
        int n7 = Hatch.getState(n4);
        if (n6 == 0) {
            if (n7 == 0) {
                switch (n5) {
                    case 0: {
                        if (bl) {
                            htvc2._a(0.375, 0.1875, 0.0625, 0.4375, 0.25, 0.125);
                            htvc2._q(twgu2, n, n2, n3);
                            htvc2._a(0.5625, 0.1875, 0.0625, 0.625, 0.25, 0.125);
                            htvc2._q(twgu2, n, n2, n3);
                            htvc2._a(0.375, 0.25, 0.0625, 0.625, 0.3125, 0.125);
                            htvc2._q(twgu2, n, n2, n3);
                        }
                        if (!bl2) break;
                        htvc2._a(0.375, 0.9375, 0.0625, 0.4375, 1.0, 0.125);
                        this.renderStandardBlock(tECarpentersBlock, htvc2, twgu2, twgu2, n, n2 - 1, n3);
                        htvc2._a(0.5625, 0.9375, 0.0625, 0.625, 1.0, 0.125);
                        this.renderStandardBlock(tECarpentersBlock, htvc2, twgu2, twgu2, n, n2 - 1, n3);
                        htvc2._a(0.375, 0.875, 0.0625, 0.625, 0.9375, 0.125);
                        this.renderStandardBlock(tECarpentersBlock, htvc2, twgu2, twgu2, n, n2 - 1, n3);
                        break;
                    }
                    case 1: {
                        if (bl) {
                            htvc2._a(0.375, 0.1875, 0.875, 0.4375, 0.25, 0.9375);
                            htvc2._q(twgu2, n, n2, n3);
                            htvc2._a(0.5625, 0.1875, 0.875, 0.625, 0.25, 0.9375);
                            htvc2._q(twgu2, n, n2, n3);
                            htvc2._a(0.375, 0.25, 0.875, 0.625, 0.3125, 0.9375);
                            htvc2._q(twgu2, n, n2, n3);
                        }
                        if (!bl2) break;
                        htvc2._a(0.375, 0.9375, 0.875, 0.4375, 1.0, 0.9375);
                        this.renderStandardBlock(tECarpentersBlock, htvc2, twgu2, twgu2, n, n2 - 1, n3);
                        htvc2._a(0.5625, 0.9375, 0.875, 0.625, 1.0, 0.9375);
                        this.renderStandardBlock(tECarpentersBlock, htvc2, twgu2, twgu2, n, n2 - 1, n3);
                        htvc2._a(0.375, 0.875, 0.875, 0.625, 0.9375, 0.9375);
                        this.renderStandardBlock(tECarpentersBlock, htvc2, twgu2, twgu2, n, n2 - 1, n3);
                        break;
                    }
                    case 2: {
                        if (bl) {
                            htvc2._a(0.0625, 0.1875, 0.375, 0.125, 0.25, 0.4375);
                            htvc2._q(twgu2, n, n2, n3);
                            htvc2._a(0.0625, 0.1875, 0.5625, 0.125, 0.25, 0.625);
                            htvc2._q(twgu2, n, n2, n3);
                            htvc2._a(0.0625, 0.25, 0.375, 0.125, 0.3125, 0.625);
                            htvc2._q(twgu2, n, n2, n3);
                        }
                        if (!bl2) break;
                        htvc2._a(0.0625, 0.9375, 0.375, 0.125, 1.0, 0.4375);
                        this.renderStandardBlock(tECarpentersBlock, htvc2, twgu2, twgu2, n, n2 - 1, n3);
                        htvc2._a(0.0625, 0.9375, 0.5625, 0.125, 1.0, 0.625);
                        this.renderStandardBlock(tECarpentersBlock, htvc2, twgu2, twgu2, n, n2 - 1, n3);
                        htvc2._a(0.0625, 0.875, 0.375, 0.125, 0.9375, 0.625);
                        this.renderStandardBlock(tECarpentersBlock, htvc2, twgu2, twgu2, n, n2 - 1, n3);
                        break;
                    }
                    case 3: {
                        if (bl) {
                            htvc2._a(0.875, 0.1875, 0.375, 0.9375, 0.25, 0.4375);
                            htvc2._q(twgu2, n, n2, n3);
                            htvc2._a(0.875, 0.1875, 0.5625, 0.9375, 0.25, 0.625);
                            htvc2._q(twgu2, n, n2, n3);
                            htvc2._a(0.875, 0.25, 0.375, 0.9375, 0.3125, 0.625);
                            htvc2._q(twgu2, n, n2, n3);
                        }
                        if (!bl2) break;
                        htvc2._a(0.875, 0.9375, 0.375, 0.9375, 1.0, 0.4375);
                        this.renderStandardBlock(tECarpentersBlock, htvc2, twgu2, twgu2, n, n2 - 1, n3);
                        htvc2._a(0.875, 0.9375, 0.5625, 0.9375, 1.0, 0.625);
                        this.renderStandardBlock(tECarpentersBlock, htvc2, twgu2, twgu2, n, n2 - 1, n3);
                        htvc2._a(0.875, 0.875, 0.375, 0.9375, 0.9375, 0.625);
                        this.renderStandardBlock(tECarpentersBlock, htvc2, twgu2, twgu2, n, n2 - 1, n3);
                    }
                }
            } else {
                switch (n5) {
                    case 0: {
                        if (bl) {
                            htvc2._a(0.375, 0.875, 0.0, 0.4375, 0.9375, 0.0625);
                            this.renderStandardBlock(tECarpentersBlock, htvc2, twgu2, twgu2, n, n2, n3 + 1);
                            htvc2._a(0.5625, 0.875, 0.0, 0.625, 0.9375, 0.0625);
                            this.renderStandardBlock(tECarpentersBlock, htvc2, twgu2, twgu2, n, n2, n3 + 1);
                            htvc2._a(0.375, 0.875, 0.0625, 0.625, 0.9375, 0.125);
                            this.renderStandardBlock(tECarpentersBlock, htvc2, twgu2, twgu2, n, n2, n3 + 1);
                        }
                        if (!bl2) break;
                        htvc2._a(0.375, 0.875, 0.75, 0.4375, 0.9375, 0.8125);
                        htvc2._q(twgu2, n, n2, n3);
                        htvc2._a(0.5625, 0.875, 0.75, 0.625, 0.9375, 0.8125);
                        htvc2._q(twgu2, n, n2, n3);
                        htvc2._a(0.375, 0.875, 0.6875, 0.625, 0.9375, 0.75);
                        htvc2._q(twgu2, n, n2, n3);
                        break;
                    }
                    case 1: {
                        if (bl) {
                            htvc2._a(0.375, 0.875, 0.9375, 0.4375, 0.9375, 1.0);
                            this.renderStandardBlock(tECarpentersBlock, htvc2, twgu2, twgu2, n, n2, n3 - 1);
                            htvc2._a(0.5625, 0.875, 0.9375, 0.625, 0.9375, 1.0);
                            this.renderStandardBlock(tECarpentersBlock, htvc2, twgu2, twgu2, n, n2, n3 - 1);
                            htvc2._a(0.375, 0.875, 0.875, 0.625, 0.9375, 0.9375);
                            this.renderStandardBlock(tECarpentersBlock, htvc2, twgu2, twgu2, n, n2, n3 - 1);
                        }
                        if (!bl2) break;
                        htvc2._a(0.375, 0.875, 0.1875, 0.4375, 0.9375, 0.25);
                        htvc2._q(twgu2, n, n2, n3);
                        htvc2._a(0.5625, 0.875, 0.1875, 0.625, 0.9375, 0.25);
                        htvc2._q(twgu2, n, n2, n3);
                        htvc2._a(0.375, 0.875, 0.25, 0.625, 0.9375, 0.3125);
                        htvc2._q(twgu2, n, n2, n3);
                        break;
                    }
                    case 2: {
                        if (bl) {
                            htvc2._a(0.0, 0.875, 0.375, 0.0625, 0.9375, 0.4375);
                            this.renderStandardBlock(tECarpentersBlock, htvc2, twgu2, twgu2, n + 1, n2, n3);
                            htvc2._a(0.0, 0.875, 0.5625, 0.0625, 0.9375, 0.625);
                            this.renderStandardBlock(tECarpentersBlock, htvc2, twgu2, twgu2, n + 1, n2, n3);
                            htvc2._a(0.0625, 0.875, 0.375, 0.125, 0.9375, 0.625);
                            this.renderStandardBlock(tECarpentersBlock, htvc2, twgu2, twgu2, n + 1, n2, n3);
                        }
                        if (!bl2) break;
                        htvc2._a(0.75, 0.875, 0.375, 0.8125, 0.9375, 0.4375);
                        htvc2._q(twgu2, n, n2, n3);
                        htvc2._a(0.75, 0.875, 0.5625, 0.8125, 0.9375, 0.625);
                        htvc2._q(twgu2, n, n2, n3);
                        htvc2._a(0.6875, 0.875, 0.375, 0.75, 0.9375, 0.625);
                        htvc2._q(twgu2, n, n2, n3);
                        break;
                    }
                    case 3: {
                        if (bl) {
                            htvc2._a(0.9375, 0.875, 0.375, 1.0, 0.9375, 0.4375);
                            this.renderStandardBlock(tECarpentersBlock, htvc2, twgu2, twgu2, n - 1, n2, n3);
                            htvc2._a(0.9375, 0.875, 0.5625, 1.0, 0.9375, 0.625);
                            this.renderStandardBlock(tECarpentersBlock, htvc2, twgu2, twgu2, n - 1, n2, n3);
                            htvc2._a(0.875, 0.875, 0.375, 0.9375, 0.9375, 0.625);
                            this.renderStandardBlock(tECarpentersBlock, htvc2, twgu2, twgu2, n - 1, n2, n3);
                        }
                        if (!bl2) break;
                        htvc2._a(0.1875, 0.875, 0.375, 0.25, 0.9375, 0.4375);
                        htvc2._q(twgu2, n, n2, n3);
                        htvc2._a(0.1875, 0.875, 0.5625, 0.25, 0.9375, 0.625);
                        htvc2._q(twgu2, n, n2, n3);
                        htvc2._a(0.25, 0.875, 0.375, 0.3125, 0.9375, 0.625);
                        htvc2._q(twgu2, n, n2, n3);
                    }
                }
            }
        } else if (n7 == 0) {
            switch (n5) {
                case 0: {
                    if (bl) {
                        htvc2._a(0.375, 0.75, 0.0625, 0.4375, 0.8125, 0.125);
                        htvc2._q(twgu2, n, n2, n3);
                        htvc2._a(0.5625, 0.75, 0.0625, 0.625, 0.8125, 0.125);
                        htvc2._q(twgu2, n, n2, n3);
                        htvc2._a(0.375, 0.6875, 0.0625, 0.625, 0.75, 0.125);
                        htvc2._q(twgu2, n, n2, n3);
                    }
                    if (!bl2) break;
                    htvc2._a(0.375, 0.0, 0.0625, 0.4375, 0.0625, 0.125);
                    this.renderStandardBlock(tECarpentersBlock, htvc2, twgu2, twgu2, n, n2 + 1, n3);
                    htvc2._a(0.5625, 0.0, 0.0625, 0.625, 0.0625, 0.125);
                    this.renderStandardBlock(tECarpentersBlock, htvc2, twgu2, twgu2, n, n2 + 1, n3);
                    htvc2._a(0.375, 0.0625, 0.0625, 0.625, 0.125, 0.125);
                    this.renderStandardBlock(tECarpentersBlock, htvc2, twgu2, twgu2, n, n2 + 1, n3);
                    break;
                }
                case 1: {
                    if (bl) {
                        htvc2._a(0.375, 0.75, 0.875, 0.4375, 0.8125, 0.9375);
                        htvc2._q(twgu2, n, n2, n3);
                        htvc2._a(0.5625, 0.75, 0.875, 0.625, 0.8125, 0.9375);
                        htvc2._q(twgu2, n, n2, n3);
                        htvc2._a(0.375, 0.6875, 0.875, 0.625, 0.75, 0.9375);
                        htvc2._q(twgu2, n, n2, n3);
                    }
                    if (!bl2) break;
                    htvc2._a(0.375, 0.0, 0.875, 0.4375, 0.0625, 0.9375);
                    this.renderStandardBlock(tECarpentersBlock, htvc2, twgu2, twgu2, n, n2 + 1, n3);
                    htvc2._a(0.5625, 0.0, 0.875, 0.625, 0.0625, 0.9375);
                    this.renderStandardBlock(tECarpentersBlock, htvc2, twgu2, twgu2, n, n2 + 1, n3);
                    htvc2._a(0.375, 0.0625, 0.875, 0.625, 0.125, 0.9375);
                    this.renderStandardBlock(tECarpentersBlock, htvc2, twgu2, twgu2, n, n2 + 1, n3);
                    break;
                }
                case 2: {
                    if (bl) {
                        htvc2._a(0.0625, 0.75, 0.375, 0.125, 0.8125, 0.4375);
                        htvc2._q(twgu2, n, n2, n3);
                        htvc2._a(0.0625, 0.75, 0.5625, 0.125, 0.8125, 0.625);
                        htvc2._q(twgu2, n, n2, n3);
                        htvc2._a(0.0625, 0.6875, 0.375, 0.125, 0.75, 0.625);
                        htvc2._q(twgu2, n, n2, n3);
                    }
                    if (!bl2) break;
                    htvc2._a(0.0625, 0.0, 0.375, 0.125, 0.0625, 0.4375);
                    this.renderStandardBlock(tECarpentersBlock, htvc2, twgu2, twgu2, n, n2 + 1, n3);
                    htvc2._a(0.0625, 0.0, 0.5625, 0.125, 0.0625, 0.625);
                    this.renderStandardBlock(tECarpentersBlock, htvc2, twgu2, twgu2, n, n2 + 1, n3);
                    htvc2._a(0.0625, 0.0625, 0.375, 0.125, 0.125, 0.625);
                    this.renderStandardBlock(tECarpentersBlock, htvc2, twgu2, twgu2, n, n2 + 1, n3);
                    break;
                }
                case 3: {
                    if (bl) {
                        htvc2._a(0.875, 0.75, 0.375, 0.9375, 0.8125, 0.4375);
                        htvc2._q(twgu2, n, n2, n3);
                        htvc2._a(0.875, 0.75, 0.5625, 0.9375, 0.8125, 0.625);
                        htvc2._q(twgu2, n, n2, n3);
                        htvc2._a(0.875, 0.6875, 0.375, 0.9375, 0.75, 0.625);
                        htvc2._q(twgu2, n, n2, n3);
                    }
                    if (!bl2) break;
                    htvc2._a(0.875, 0.0, 0.375, 0.9375, 0.0625, 0.4375);
                    this.renderStandardBlock(tECarpentersBlock, htvc2, twgu2, twgu2, n, n2 + 1, n3);
                    htvc2._a(0.875, 0.0, 0.5625, 0.9375, 0.0625, 0.625);
                    this.renderStandardBlock(tECarpentersBlock, htvc2, twgu2, twgu2, n, n2 + 1, n3);
                    htvc2._a(0.875, 0.0625, 0.375, 0.9375, 0.125, 0.625);
                    this.renderStandardBlock(tECarpentersBlock, htvc2, twgu2, twgu2, n, n2 + 1, n3);
                }
            }
        } else {
            switch (n5) {
                case 0: {
                    if (bl) {
                        htvc2._a(0.375, 0.0625, 0.0, 0.4375, 0.125, 0.0625);
                        this.renderStandardBlock(tECarpentersBlock, htvc2, twgu2, twgu2, n, n2, n3 + 1);
                        htvc2._a(0.5625, 0.0625, 0.0, 0.625, 0.125, 0.0625);
                        this.renderStandardBlock(tECarpentersBlock, htvc2, twgu2, twgu2, n, n2, n3 + 1);
                        htvc2._a(0.375, 0.0625, 0.0625, 0.625, 0.125, 0.125);
                        this.renderStandardBlock(tECarpentersBlock, htvc2, twgu2, twgu2, n, n2, n3 + 1);
                    }
                    if (!bl2) break;
                    htvc2._a(0.375, 0.0625, 0.75, 0.4375, 0.125, 0.8125);
                    htvc2._q(twgu2, n, n2, n3);
                    htvc2._a(0.5625, 0.0625, 0.75, 0.625, 0.125, 0.8125);
                    htvc2._q(twgu2, n, n2, n3);
                    htvc2._a(0.375, 0.0625, 0.6875, 0.625, 0.125, 0.75);
                    htvc2._q(twgu2, n, n2, n3);
                    break;
                }
                case 1: {
                    if (bl) {
                        htvc2._a(0.375, 0.0625, 0.9375, 0.4375, 0.125, 1.0);
                        this.renderStandardBlock(tECarpentersBlock, htvc2, twgu2, twgu2, n, n2, n3 - 1);
                        htvc2._a(0.5625, 0.0625, 0.9375, 0.625, 0.125, 1.0);
                        this.renderStandardBlock(tECarpentersBlock, htvc2, twgu2, twgu2, n, n2, n3 - 1);
                        htvc2._a(0.375, 0.0625, 0.875, 0.625, 0.125, 0.9375);
                        this.renderStandardBlock(tECarpentersBlock, htvc2, twgu2, twgu2, n, n2, n3 - 1);
                    }
                    if (!bl2) break;
                    htvc2._a(0.375, 0.0625, 0.1875, 0.4375, 0.125, 0.25);
                    htvc2._q(twgu2, n, n2, n3);
                    htvc2._a(0.5625, 0.0625, 0.1875, 0.625, 0.125, 0.25);
                    htvc2._q(twgu2, n, n2, n3);
                    htvc2._a(0.375, 0.0625, 0.25, 0.625, 0.125, 0.3125);
                    htvc2._q(twgu2, n, n2, n3);
                    break;
                }
                case 2: {
                    if (bl) {
                        htvc2._a(0.0, 0.0625, 0.375, 0.0625, 0.125, 0.4375);
                        this.renderStandardBlock(tECarpentersBlock, htvc2, twgu2, twgu2, n + 1, n2, n3);
                        htvc2._a(0.0, 0.0625, 0.5625, 0.0625, 0.125, 0.625);
                        this.renderStandardBlock(tECarpentersBlock, htvc2, twgu2, twgu2, n + 1, n2, n3);
                        htvc2._a(0.0625, 0.0625, 0.375, 0.125, 0.125, 0.625);
                        this.renderStandardBlock(tECarpentersBlock, htvc2, twgu2, twgu2, n + 1, n2, n3);
                    }
                    if (!bl2) break;
                    htvc2._a(0.75, 0.0625, 0.375, 0.8125, 0.125, 0.4375);
                    htvc2._q(twgu2, n, n2, n3);
                    htvc2._a(0.75, 0.0625, 0.5625, 0.8125, 0.125, 0.625);
                    htvc2._q(twgu2, n, n2, n3);
                    htvc2._a(0.6875, 0.0625, 0.375, 0.75, 0.125, 0.625);
                    htvc2._q(twgu2, n, n2, n3);
                    break;
                }
                case 3: {
                    if (bl) {
                        htvc2._a(0.9375, 0.0625, 0.375, 1.0, 0.125, 0.4375);
                        this.renderStandardBlock(tECarpentersBlock, htvc2, twgu2, twgu2, n - 1, n2, n3);
                        htvc2._a(0.9375, 0.0625, 0.5625, 1.0, 0.125, 0.625);
                        this.renderStandardBlock(tECarpentersBlock, htvc2, twgu2, twgu2, n - 1, n2, n3);
                        htvc2._a(0.875, 0.0625, 0.375, 0.9375, 0.125, 0.625);
                        this.renderStandardBlock(tECarpentersBlock, htvc2, twgu2, twgu2, n - 1, n2, n3);
                    }
                    if (!bl2) break;
                    htvc2._a(0.1875, 0.0625, 0.375, 0.25, 0.125, 0.4375);
                    htvc2._q(twgu2, n, n2, n3);
                    htvc2._a(0.1875, 0.0625, 0.5625, 0.25, 0.125, 0.625);
                    htvc2._q(twgu2, n, n2, n3);
                    htvc2._a(0.25, 0.0625, 0.375, 0.3125, 0.125, 0.625);
                    htvc2._q(twgu2, n, n2, n3);
                }
            }
        }
        return true;
    }
}

