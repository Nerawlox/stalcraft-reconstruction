/*
 * Decompiled with CFR 0.152.
 */
package carpentersblocks.renderer;

import carpentersblocks.block.BlockCarpentersDoor;
import carpentersblocks.data.Door;
import carpentersblocks.renderer.HingedBase;
import carpentersblocks.tileentity.TECarpentersBlock;
import carpentersblocks.util.BlockProperties;
import carpentersblocks.util.handler.BlockHandler;
import carpentersblocks.util.handler.IconHandler;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.util.Icon;

public class BlockHandlerCarpentersDoor
extends HingedBase {
    @Override
    public boolean shouldRender3DInInventory() {
        return false;
    }

    @Override
    public boolean renderCarpentersBlock(TECarpentersBlock tECarpentersBlock, RenderBlocks renderBlocks, Block block, int n, int n2, int n3, int n4) {
        Block block2 = this.isSideCover ? BlockProperties.getCoverBlock(tECarpentersBlock, this.coverRendering) : BlockProperties.getCoverBlock(tECarpentersBlock, 6);
        renderBlocks._d = true;
        int n5 = BlockProperties.getData(tECarpentersBlock);
        int n6 = Door.getType(n5);
        switch (n6) {
            case 0: {
                this.renderGlassTopDoor(tECarpentersBlock, renderBlocks, block2, block, n, n2, n3, n4);
                break;
            }
            case 1: {
                this.renderTallDoor(tECarpentersBlock, renderBlocks, block2, block, n, n2, n3, n4);
                break;
            }
            case 2: {
                this.renderPanelsDoor(tECarpentersBlock, renderBlocks, block2, block, n, n2, n3, n4);
                break;
            }
            case 3: {
                this.renderTallDoor(tECarpentersBlock, renderBlocks, block2, block, n, n2, n3, n4);
                break;
            }
            case 4: {
                this.renderFrenchGlassDoor(tECarpentersBlock, renderBlocks, block2, block, n, n2, n3, n4);
                break;
            }
            case 5: {
                this.renderHiddenDoor(tECarpentersBlock, renderBlocks, block2, block, n, n2, n3, n4);
            }
        }
        renderBlocks._d = false;
        return this.shouldRenderBlock(tECarpentersBlock, renderBlocks, block2, block, n);
    }

    public boolean renderFrenchGlassDoor(TECarpentersBlock tECarpentersBlock, RenderBlocks renderBlocks, Block block, Block block2, int n, int n2, int n3, int n4) {
        int n5 = BlockProperties.getData(tECarpentersBlock);
        int n6 = Door.getHinge(n5);
        int n7 = Door.getFacing(n5);
        boolean bl = Door.getState(n5) == 1;
        boolean bl2 = Door.getPiece(n5) == 0;
        boolean bl3 = false;
        float f = 0.0f;
        float f2 = 0.0f;
        float f3 = 0.0f;
        float f4 = 0.0f;
        float f5 = 1.0f;
        float f6 = 1.0f;
        float f7 = 1.0f;
        float f8 = 0.0f;
        float f9 = 0.0f;
        float f10 = 1.0f;
        float f11 = 1.0f;
        switch (n7) {
            case 0: {
                if (!bl) {
                    f10 = f5 = 0.1875f;
                    f11 = 0.1875f;
                    f9 = 0.8125f;
                    f = 0.90625f;
                    bl3 = true;
                    break;
                }
                if (n6 == 1) {
                    f9 = f4 = 0.8125f;
                    f10 = 0.1875f;
                    f8 = 0.8125f;
                    f = 0.09375f;
                    break;
                }
                f11 = f7 = 0.1875f;
                f10 = 0.1875f;
                f8 = 0.8125f;
                f = 0.90625f;
                break;
            }
            case 1: {
                if (!bl) {
                    f11 = f7 = 0.1875f;
                    f10 = 0.1875f;
                    f8 = 0.8125f;
                    f = 0.90625f;
                    break;
                }
                if (n6 == 1) {
                    f10 = f5 = 0.1875f;
                    f11 = 0.1875f;
                    f9 = 0.8125f;
                    f = 0.90625f;
                    bl3 = true;
                    break;
                }
                f8 = f2 = 0.8125f;
                f11 = 0.1875f;
                f9 = 0.8125f;
                f = 0.09375f;
                bl3 = true;
                break;
            }
            case 2: {
                if (!bl) {
                    f8 = f2 = 0.8125f;
                    f11 = 0.1875f;
                    f9 = 0.8125f;
                    f = 0.09375f;
                    bl3 = true;
                    break;
                }
                if (n6 == 1) {
                    f11 = f7 = 0.1875f;
                    f10 = 0.1875f;
                    f8 = 0.8125f;
                    f = 0.90625f;
                    break;
                }
                f9 = f4 = 0.8125f;
                f10 = 0.1875f;
                f8 = 0.8125f;
                f = 0.09375f;
                break;
            }
            case 3: {
                if (!bl) {
                    f9 = f4 = 0.8125f;
                    f10 = 0.1875f;
                    f8 = 0.8125f;
                    f = 0.09375f;
                    break;
                }
                if (n6 == 1) {
                    f8 = f2 = 0.8125f;
                    f11 = 0.1875f;
                    f9 = 0.8125f;
                    f = 0.09375f;
                    bl3 = true;
                    break;
                }
                f10 = f5 = 0.1875f;
                f11 = 0.1875f;
                f9 = 0.8125f;
                f = 0.90625f;
                bl3 = true;
            }
        }
        if (this.shouldRenderFrame(tECarpentersBlock, renderBlocks, block, n)) {
            float f12;
            float f13;
            float f14;
            float f15;
            renderBlocks._a(f2, f3, (double)f4, (double)f10, (double)f6, (double)f11);
            this.renderStandardBlock(tECarpentersBlock, renderBlocks, block, block2, n2, n3, n4);
            renderBlocks._a(f8, f3, (double)f9, (double)f5, (double)f6, (double)f7);
            this.renderStandardBlock(tECarpentersBlock, renderBlocks, block, block2, n2, n3, n4);
            if (bl3) {
                f15 = f2 + 0.0625f;
                f14 = f5 - 0.0625f;
                f13 = 0.4375f;
                f12 = 0.5625f;
            } else {
                f13 = f4 + 0.0625f;
                f12 = f7 - 0.0625f;
                f15 = 0.4375f;
                f14 = 0.5625f;
            }
            this.setLightnessOffset(-0.05f);
            if (bl2) {
                renderBlocks._a(f15, 0.1875, (double)f13, (double)f14, 0.5, (double)f12);
                this.renderStandardBlock(tECarpentersBlock, renderBlocks, block, block2, n2, n3, n4);
                renderBlocks._a(f15, 0.625, (double)f13, (double)f14, 0.9375, (double)f12);
                this.renderStandardBlock(tECarpentersBlock, renderBlocks, block, block2, n2, n3, n4);
            } else {
                renderBlocks._a(f15, 0.0625, (double)f13, (double)f14, 0.375, (double)f12);
                this.renderStandardBlock(tECarpentersBlock, renderBlocks, block, block2, n2, n3, n4);
                renderBlocks._a(f15, 0.5, (double)f13, (double)f14, 0.8125, (double)f12);
                this.renderStandardBlock(tECarpentersBlock, renderBlocks, block, block2, n2, n3, n4);
            }
            this.clearLightnessOffset();
            f15 = f2;
            f14 = f5;
            f13 = f4;
            f12 = f7;
            if (bl3) {
                f13 = 0.1875f;
                f12 = 0.8125f;
            } else {
                f15 = 0.1875f;
                f14 = 0.8125f;
            }
            if (bl2) {
                renderBlocks._a(f15, 0.0, (double)f13, (double)f14, 0.1875, (double)f12);
                this.renderStandardBlock(tECarpentersBlock, renderBlocks, block, block2, n2, n3, n4);
                if (bl3) {
                    f15 += 0.0625f;
                    f14 -= 0.0625f;
                } else {
                    f13 += 0.0625f;
                    f12 -= 0.0625f;
                }
                this.setLightnessOffset(-0.05f);
                renderBlocks._a(f15, 0.5, (double)f13, (double)f14, 0.625, (double)f12);
                this.renderStandardBlock(tECarpentersBlock, renderBlocks, block, block2, n2, n3, n4);
                renderBlocks._a(f15, 0.9375, (double)f13, (double)f14, 1.0, (double)f12);
                this.renderStandardBlock(tECarpentersBlock, renderBlocks, block, block2, n2, n3, n4);
                this.clearLightnessOffset();
            } else {
                renderBlocks._a(f15, 0.8125, (double)f13, (double)f14, 1.0, (double)f12);
                this.renderStandardBlock(tECarpentersBlock, renderBlocks, block, block2, n2, n3, n4);
                if (bl3) {
                    f15 += 0.0625f;
                    f14 -= 0.0625f;
                } else {
                    f13 += 0.0625f;
                    f12 -= 0.0625f;
                }
                this.setLightnessOffset(-0.05f);
                renderBlocks._a(f15, 0.0, (double)f13, (double)f14, 0.0625, (double)f12);
                this.renderStandardBlock(tECarpentersBlock, renderBlocks, block, block2, n2, n3, n4);
                renderBlocks._a(f15, 0.375, (double)f13, (double)f14, 0.5, (double)f12);
                this.renderStandardBlock(tECarpentersBlock, renderBlocks, block, block2, n2, n3, n4);
                this.clearLightnessOffset();
            }
        }
        if (this.shouldRenderPieces(tECarpentersBlock, renderBlocks, block, n)) {
            Icon icon = bl2 ? IconHandler.icon_door_french_glass_bottom : IconHandler.icon_door_french_glass_top;
            renderBlocks.__aE.setOffset(-(1.0f - f));
            renderBlocks.__aF.setBrightness(Block.glass.getMixedBrightnessForBlock(renderBlocks._a, n2, n3, n4));
            if (bl3) {
                renderBlocks.__aF.setColorOpaque_F(0.6f, 0.6f, 0.6f);
                renderBlocks._a(0.0, bl2 ? 0.1875 : 0.0, 0.1875, 1.0, bl2 ? 1.0 : 0.8125, 0.8125);
                this.renderHelper.renderFaceXNeg(renderBlocks, n2, n3, n4, icon);
                renderBlocks.__aE.setOffset(-f);
                this.renderHelper.renderFaceXPos(renderBlocks, n2, n3, n4, icon);
            } else {
                renderBlocks.__aF.setColorOpaque_F(0.8f, 0.8f, 0.8f);
                renderBlocks._a(0.1875, bl2 ? 0.1875 : 0.0, 0.0, 0.8125, bl2 ? 1.0 : 0.8125, 1.0);
                this.renderHelper.renderFaceZNeg(renderBlocks, n2, n3, n4, icon);
                renderBlocks.__aE.setOffset(-f);
                this.renderHelper.renderFaceZPos(renderBlocks, n2, n3, n4, icon);
            }
            renderBlocks.__aE.clearOffset();
            this.renderHandle(tECarpentersBlock, renderBlocks, Block.blockIron, n2, n3, n4, true, true);
        }
        return true;
    }

    public boolean renderGlassTopDoor(TECarpentersBlock tECarpentersBlock, RenderBlocks renderBlocks, Block block, Block block2, int n, int n2, int n3, int n4) {
        int n5 = BlockProperties.getData(tECarpentersBlock);
        int n6 = Door.getHinge(n5);
        boolean bl = Door.getState(n5) == 1;
        boolean bl2 = Door.getPiece(n5) == 0;
        boolean bl3 = false;
        float f = 0.0f;
        float f2 = 0.0f;
        float f3 = 0.0f;
        float f4 = 0.0f;
        float f5 = 1.0f;
        float f6 = 1.0f;
        float f7 = 1.0f;
        float f8 = 0.0f;
        float f9 = 0.0f;
        float f10 = 1.0f;
        float f11 = 1.0f;
        switch (Door.getFacing(n5)) {
            case 0: {
                if (!bl) {
                    f10 = f5 = 0.1875f;
                    f11 = 0.1875f;
                    f9 = 0.8125f;
                    f = 0.90625f;
                    bl3 = true;
                    break;
                }
                if (n6 == 1) {
                    f9 = f4 = 0.8125f;
                    f10 = 0.1875f;
                    f8 = 0.8125f;
                    f = 0.09375f;
                    break;
                }
                f11 = f7 = 0.1875f;
                f10 = 0.1875f;
                f8 = 0.8125f;
                f = 0.90625f;
                break;
            }
            case 1: {
                if (!bl) {
                    f11 = f7 = 0.1875f;
                    f10 = 0.1875f;
                    f8 = 0.8125f;
                    f = 0.90625f;
                    break;
                }
                if (n6 == 1) {
                    f10 = f5 = 0.1875f;
                    f11 = 0.1875f;
                    f9 = 0.8125f;
                    f = 0.90625f;
                    bl3 = true;
                    break;
                }
                f8 = f2 = 0.8125f;
                f11 = 0.1875f;
                f9 = 0.8125f;
                f = 0.09375f;
                bl3 = true;
                break;
            }
            case 2: {
                if (!bl) {
                    f8 = f2 = 0.8125f;
                    f11 = 0.1875f;
                    f9 = 0.8125f;
                    f = 0.09375f;
                    bl3 = true;
                    break;
                }
                if (n6 == 1) {
                    f11 = f7 = 0.1875f;
                    f10 = 0.1875f;
                    f8 = 0.8125f;
                    f = 0.90625f;
                    break;
                }
                f9 = f4 = 0.8125f;
                f10 = 0.1875f;
                f8 = 0.8125f;
                f = 0.09375f;
                break;
            }
            case 3: {
                if (!bl) {
                    f9 = f4 = 0.8125f;
                    f10 = 0.1875f;
                    f8 = 0.8125f;
                    f = 0.09375f;
                    break;
                }
                if (n6 == 1) {
                    f8 = f2 = 0.8125f;
                    f11 = 0.1875f;
                    f9 = 0.8125f;
                    f = 0.09375f;
                    bl3 = true;
                    break;
                }
                f10 = f5 = 0.1875f;
                f11 = 0.1875f;
                f9 = 0.8125f;
                f = 0.90625f;
                bl3 = true;
            }
        }
        if (this.shouldRenderFrame(tECarpentersBlock, renderBlocks, block, n)) {
            renderBlocks._a(f2, f3, (double)f4, (double)f10, (double)f6, (double)f11);
            this.renderStandardBlock(tECarpentersBlock, renderBlocks, block, block2, n2, n3, n4);
            renderBlocks._a(f8, f3, (double)f9, (double)f5, (double)f6, (double)f7);
            this.renderStandardBlock(tECarpentersBlock, renderBlocks, block, block2, n2, n3, n4);
            float f12 = f2;
            float f13 = f5;
            float f14 = f4;
            float f15 = f7;
            if (bl2) {
                if (bl3) {
                    f12 = f2 + 0.0625f;
                    f13 = f5 - 0.0625f;
                    f14 = 0.1875f;
                    f15 = 0.8125f;
                } else {
                    f14 = f4 + 0.0625f;
                    f15 = f7 - 0.0625f;
                    f12 = 0.1875f;
                    f13 = 0.8125f;
                }
                this.setLightnessOffset(-0.05f);
                renderBlocks._a(f12, 0.1875, (double)f14, (double)f13, 1.0, (double)f15);
                this.renderStandardBlock(tECarpentersBlock, renderBlocks, block, block2, n2, n3, n4);
                this.clearLightnessOffset();
                f12 = f2;
                f13 = f5;
                f14 = f4;
                f15 = f7;
            }
            if (bl3) {
                f14 = 0.1875f;
                f15 = 0.8125f;
            } else {
                f12 = 0.1875f;
                f13 = 0.8125f;
            }
            if (bl2) {
                renderBlocks._a(f12, 0.0, (double)f14, (double)f13, 0.1875, (double)f15);
                this.renderStandardBlock(tECarpentersBlock, renderBlocks, block, block2, n2, n3, n4);
            } else {
                renderBlocks._a(f12, 0.8125, (double)f14, (double)f13, 1.0, (double)f15);
                this.renderStandardBlock(tECarpentersBlock, renderBlocks, block, block2, n2, n3, n4);
                renderBlocks._a(f12, 0.0, (double)f14, (double)f13, 0.1875, (double)f15);
                this.renderStandardBlock(tECarpentersBlock, renderBlocks, block, block2, n2, n3, n4);
            }
            f12 = f2;
            f13 = f5;
            f14 = f4;
            f15 = f7;
            if (bl2) {
                if (bl3) {
                    f14 = 0.3125f;
                    f15 = 0.6875f;
                } else {
                    f12 = 0.3125f;
                    f13 = 0.6875f;
                }
                renderBlocks._a(f12, 0.3125, (double)f14, (double)f13, 0.875, (double)f15);
                this.renderStandardBlock(tECarpentersBlock, renderBlocks, block, block2, n2, n3, n4);
            }
        }
        if (this.shouldRenderPieces(tECarpentersBlock, renderBlocks, block, n)) {
            if (!bl2) {
                renderBlocks.__aE.setOffset(-(1.0f - f));
                renderBlocks.__aF.setBrightness(Block.glass.getMixedBrightnessForBlock(renderBlocks._a, n2, n3, n4));
                if (bl3) {
                    renderBlocks.__aF.setColorOpaque_F(0.6f, 0.6f, 0.6f);
                    renderBlocks._a(0.0, 0.1875, 0.1875, 1.0, 0.8125, 0.8125);
                    this.renderHelper.renderFaceXNeg(renderBlocks, n2, n3, n4, IconHandler.icon_door_glass_top);
                    renderBlocks.__aE.setOffset(-f);
                    this.renderHelper.renderFaceXPos(renderBlocks, n2, n3, n4, IconHandler.icon_door_glass_top);
                } else {
                    renderBlocks.__aF.setColorOpaque_F(0.8f, 0.8f, 0.8f);
                    renderBlocks._a(0.1875, 0.1875, 0.0, 0.8125, 0.8125, 1.0);
                    this.renderHelper.renderFaceZNeg(renderBlocks, n2, n3, n4, IconHandler.icon_door_glass_top);
                    renderBlocks.__aE.setOffset(-f);
                    this.renderHelper.renderFaceZPos(renderBlocks, n2, n3, n4, IconHandler.icon_door_glass_top);
                }
                renderBlocks.__aE.clearOffset();
            }
            this.renderHandle(tECarpentersBlock, renderBlocks, Block.blockIron, n2, n3, n4, true, true);
        }
        return true;
    }

    public boolean renderPanelsDoor(TECarpentersBlock tECarpentersBlock, RenderBlocks renderBlocks, Block block, Block block2, int n, int n2, int n3, int n4) {
        int n5 = BlockProperties.getData(tECarpentersBlock);
        int n6 = Door.getHinge(n5);
        boolean bl = Door.getState(n5) == 1;
        boolean bl2 = Door.getPiece(n5) == 0;
        boolean bl3 = false;
        float f = 0.0f;
        float f2 = 0.0f;
        float f3 = 0.0f;
        float f4 = 1.0f;
        float f5 = 1.0f;
        float f6 = 1.0f;
        float f7 = 0.0f;
        float f8 = 0.0f;
        float f9 = 1.0f;
        float f10 = 1.0f;
        switch (Door.getFacing(n5)) {
            case 0: {
                if (!bl) {
                    f9 = f4 = 0.1875f;
                    f10 = 0.1875f;
                    f8 = 0.8125f;
                    bl3 = true;
                    break;
                }
                if (n6 == 1) {
                    f8 = f3 = 0.8125f;
                    f9 = 0.1875f;
                    f7 = 0.8125f;
                    break;
                }
                f10 = f6 = 0.1875f;
                f9 = 0.1875f;
                f7 = 0.8125f;
                break;
            }
            case 1: {
                if (!bl) {
                    f10 = f6 = 0.1875f;
                    f9 = 0.1875f;
                    f7 = 0.8125f;
                    break;
                }
                if (n6 == 1) {
                    f9 = f4 = 0.1875f;
                    f10 = 0.1875f;
                    f8 = 0.8125f;
                    bl3 = true;
                    break;
                }
                f7 = f = 0.8125f;
                f10 = 0.1875f;
                f8 = 0.8125f;
                bl3 = true;
                break;
            }
            case 2: {
                if (!bl) {
                    f7 = f = 0.8125f;
                    f10 = 0.1875f;
                    f8 = 0.8125f;
                    bl3 = true;
                    break;
                }
                if (n6 == 1) {
                    f10 = f6 = 0.1875f;
                    f9 = 0.1875f;
                    f7 = 0.8125f;
                    break;
                }
                f8 = f3 = 0.8125f;
                f9 = 0.1875f;
                f7 = 0.8125f;
                break;
            }
            case 3: {
                if (!bl) {
                    f8 = f3 = 0.8125f;
                    f9 = 0.1875f;
                    f7 = 0.8125f;
                    break;
                }
                if (n6 == 1) {
                    f7 = f = 0.8125f;
                    f10 = 0.1875f;
                    f8 = 0.8125f;
                    bl3 = true;
                    break;
                }
                f9 = f4 = 0.1875f;
                f10 = 0.1875f;
                f8 = 0.8125f;
                bl3 = true;
            }
        }
        if (this.shouldRenderFrame(tECarpentersBlock, renderBlocks, block, n)) {
            float f11;
            float f12;
            float f13;
            float f14;
            renderBlocks._a(f, f2, (double)f3, (double)f9, (double)f5, (double)f10);
            this.renderStandardBlock(tECarpentersBlock, renderBlocks, block, block2, n2, n3, n4);
            renderBlocks._a(f7, f2, (double)f8, (double)f4, (double)f5, (double)f6);
            this.renderStandardBlock(tECarpentersBlock, renderBlocks, block, block2, n2, n3, n4);
            if (bl3) {
                f14 = f + 0.0625f;
                f13 = f4 - 0.0625f;
                f12 = 0.1875f;
                f11 = 0.8125f;
            } else {
                f12 = f3 + 0.0625f;
                f11 = f6 - 0.0625f;
                f14 = 0.1875f;
                f13 = 0.8125f;
            }
            this.setLightnessOffset(-0.05f);
            if (bl2) {
                renderBlocks._a(f14, 0.1875, (double)f12, (double)f13, 1.0, (double)f11);
                this.renderStandardBlock(tECarpentersBlock, renderBlocks, block, block2, n2, n3, n4);
            } else {
                renderBlocks._a(f14, 0.0, (double)f12, (double)f13, 0.8125, (double)f11);
                this.renderStandardBlock(tECarpentersBlock, renderBlocks, block, block2, n2, n3, n4);
            }
            this.clearLightnessOffset();
            f14 = f;
            f13 = f4;
            f12 = f3;
            f11 = f6;
            if (bl3) {
                f12 = 0.1875f;
                f11 = 0.8125f;
            } else {
                f14 = 0.1875f;
                f13 = 0.8125f;
            }
            if (bl2) {
                renderBlocks._a(f14, f2, (double)f12, (double)f13, 0.1875, (double)f11);
                this.renderStandardBlock(tECarpentersBlock, renderBlocks, block, block2, n2, n3, n4);
            } else {
                renderBlocks._a(f14, 0.8125, (double)f12, (double)f13, (double)f5, (double)f11);
                this.renderStandardBlock(tECarpentersBlock, renderBlocks, block, block2, n2, n3, n4);
                renderBlocks._a(f14, 0.0625, (double)f12, (double)f13, 0.25, (double)f11);
                this.renderStandardBlock(tECarpentersBlock, renderBlocks, block, block2, n2, n3, n4);
            }
            f14 = f;
            f13 = f4;
            f12 = f3;
            f11 = f6;
            if (bl3) {
                f12 = 0.3125f;
                f11 = 0.6875f;
            } else {
                f14 = 0.3125f;
                f13 = 0.6875f;
            }
            if (bl2) {
                renderBlocks._a(f14, 0.3125, (double)f12, (double)f13, 0.9375, (double)f11);
                this.renderStandardBlock(tECarpentersBlock, renderBlocks, block, block2, n2, n3, n4);
            } else {
                renderBlocks._a(f14, 0.375, (double)f12, (double)f13, 0.6875, (double)f11);
                this.renderStandardBlock(tECarpentersBlock, renderBlocks, block, block2, n2, n3, n4);
            }
        }
        if (this.shouldRenderPieces(tECarpentersBlock, renderBlocks, block, n)) {
            this.renderHandle(tECarpentersBlock, renderBlocks, Block.blockIron, n2, n3, n4, true, true);
        }
        return true;
    }

    public boolean renderTallDoor(TECarpentersBlock tECarpentersBlock, RenderBlocks renderBlocks, Block block, Block block2, int n, int n2, int n3, int n4) {
        int n5 = BlockProperties.getData(tECarpentersBlock);
        int n6 = Door.getHinge(n5);
        boolean bl = Door.getState(n5) == 1;
        boolean bl2 = Door.getPiece(n5) == 0;
        boolean bl3 = false;
        float f = 0.0f;
        float f2 = 0.0f;
        float f3 = 0.0f;
        float f4 = 0.0f;
        float f5 = 1.0f;
        float f6 = 1.0f;
        float f7 = 1.0f;
        float f8 = 0.0f;
        float f9 = 0.0f;
        float f10 = 1.0f;
        float f11 = 1.0f;
        switch (Door.getFacing(n5)) {
            case 0: {
                if (!bl) {
                    f10 = f5 = 0.1875f;
                    f11 = 0.1875f;
                    f9 = 0.8125f;
                    f = 0.90625f;
                    bl3 = true;
                    break;
                }
                if (n6 == 1) {
                    f9 = f4 = 0.8125f;
                    f10 = 0.1875f;
                    f8 = 0.8125f;
                    f = 0.09375f;
                    break;
                }
                f11 = f7 = 0.1875f;
                f10 = 0.1875f;
                f8 = 0.8125f;
                f = 0.90625f;
                break;
            }
            case 1: {
                if (!bl) {
                    f11 = f7 = 0.1875f;
                    f10 = 0.1875f;
                    f8 = 0.8125f;
                    f = 0.90625f;
                    break;
                }
                if (n6 == 1) {
                    f10 = f5 = 0.1875f;
                    f11 = 0.1875f;
                    f9 = 0.8125f;
                    f = 0.90625f;
                    bl3 = true;
                    break;
                }
                f8 = f2 = 0.8125f;
                f11 = 0.1875f;
                f9 = 0.8125f;
                f = 0.09375f;
                bl3 = true;
                break;
            }
            case 2: {
                if (!bl) {
                    f8 = f2 = 0.8125f;
                    f11 = 0.1875f;
                    f9 = 0.8125f;
                    f = 0.09375f;
                    bl3 = true;
                    break;
                }
                if (n6 == 1) {
                    f11 = f7 = 0.1875f;
                    f10 = 0.1875f;
                    f8 = 0.8125f;
                    f = 0.90625f;
                    break;
                }
                f9 = f4 = 0.8125f;
                f10 = 0.1875f;
                f8 = 0.8125f;
                f = 0.09375f;
                break;
            }
            case 3: {
                if (!bl) {
                    f9 = f4 = 0.8125f;
                    f10 = 0.1875f;
                    f8 = 0.8125f;
                    f = 0.09375f;
                    break;
                }
                if (n6 == 1) {
                    f8 = f2 = 0.8125f;
                    f11 = 0.1875f;
                    f9 = 0.8125f;
                    f = 0.09375f;
                    bl3 = true;
                    break;
                }
                f10 = f5 = 0.1875f;
                f11 = 0.1875f;
                f9 = 0.8125f;
                f = 0.90625f;
                bl3 = true;
            }
        }
        if (this.shouldRenderFrame(tECarpentersBlock, renderBlocks, block, n)) {
            renderBlocks._a(f2, f3, (double)f4, (double)f10, (double)f6, (double)f11);
            this.renderStandardBlock(tECarpentersBlock, renderBlocks, block, block2, n2, n3, n4);
            renderBlocks._a(f8, f3, (double)f9, (double)f5, (double)f6, (double)f7);
            this.renderStandardBlock(tECarpentersBlock, renderBlocks, block, block2, n2, n3, n4);
            if (bl3) {
                f4 = 0.1875f;
                f7 = 0.8125f;
            } else {
                f2 = 0.1875f;
                f5 = 0.8125f;
            }
            if (bl2) {
                renderBlocks._a(f2, f3, (double)f4, (double)f5, 0.1875, (double)f7);
                this.renderStandardBlock(tECarpentersBlock, renderBlocks, block, block2, n2, n3, n4);
            } else {
                renderBlocks._a(f2, 0.8125, (double)f4, (double)f5, (double)f6, (double)f7);
                this.renderStandardBlock(tECarpentersBlock, renderBlocks, block, block2, n2, n3, n4);
            }
        }
        if (this.shouldRenderPieces(tECarpentersBlock, renderBlocks, block, n)) {
            int n7 = Door.getType(n5);
            Icon icon = bl2 ? (n7 == 3 ? IconHandler.icon_door_screen_tall : IconHandler.icon_door_glass_tall_bottom) : (n7 == 3 ? IconHandler.icon_door_screen_tall : IconHandler.icon_door_glass_tall_top);
            renderBlocks.__aE.setOffset(-(1.0f - f));
            renderBlocks.__aF.setBrightness(Block.glass.getMixedBrightnessForBlock(renderBlocks._a, n2, n3, n4));
            if (bl3) {
                renderBlocks.__aF.setColorOpaque_F(0.6f, 0.6f, 0.6f);
                renderBlocks._a(0.0, bl2 ? 0.1875 : 0.0, 0.1875, 1.0, bl2 ? 1.0 : 0.8125, 0.8125);
                this.renderHelper.renderFaceXNeg(renderBlocks, n2, n3, n4, icon);
                renderBlocks.__aE.setOffset(-f);
                this.renderHelper.renderFaceXPos(renderBlocks, n2, n3, n4, icon);
            } else {
                renderBlocks.__aF.setColorOpaque_F(0.8f, 0.8f, 0.8f);
                renderBlocks._a(0.1875, bl2 ? 0.1875 : 0.0, 0.0, 0.8125, bl2 ? 1.0 : 0.8125, 1.0);
                this.renderHelper.renderFaceZNeg(renderBlocks, n2, n3, n4, icon);
                renderBlocks.__aE.setOffset(-f);
                this.renderHelper.renderFaceZPos(renderBlocks, n2, n3, n4, icon);
            }
            renderBlocks.__aE.clearOffset();
            this.renderHandle(tECarpentersBlock, renderBlocks, Block.blockIron, n2, n3, n4, true, true);
        }
        return true;
    }

    public boolean renderHiddenDoor(TECarpentersBlock tECarpentersBlock, RenderBlocks renderBlocks, Block block, Block block2, int n, int n2, int n3, int n4) {
        if (this.shouldRenderFrame(tECarpentersBlock, renderBlocks, block, n)) {
            BlockCarpentersDoor blockCarpentersDoor = (BlockCarpentersDoor)BlockHandler.blockCarpentersDoor;
            blockCarpentersDoor.setBlockBoundsBasedOnState(renderBlocks._a, n2, n3, n4);
            this.renderStandardBlock(tECarpentersBlock, renderBlocks, block, block2, n2, n3, n4);
        }
        if (this.shouldRenderPieces(tECarpentersBlock, renderBlocks, block, n)) {
            this.renderHandle(tECarpentersBlock, renderBlocks, Block.blockIron, n2, n3, n4, true, false);
        }
        return true;
    }

    public boolean renderHandle(TECarpentersBlock tECarpentersBlock, RenderBlocks renderBlocks, Block block, int n, int n2, int n3, boolean bl, boolean bl2) {
        if (!bl && !bl2) {
            return false;
        }
        int n4 = BlockProperties.getData(tECarpentersBlock);
        int n5 = Door.getHinge(n4);
        boolean bl3 = Door.getState(n4) == 1;
        boolean bl4 = Door.getPiece(n4) == 0;
        float f = 0.0f;
        float f2 = bl4 ? 0.875f : 0.0625f;
        float f3 = 0.0f;
        float f4 = bl4 ? 0.9375f : 0.125f;
        float f5 = bl4 ? 0.875f : 0.0f;
        float f6 = bl4 ? 1.0f : 0.125f;
        switch (Door.getFacing(n4)) {
            case 0: {
                if (!bl3) {
                    float f7 = f3 = n5 == 1 ? 0.0625f : 0.875f;
                    if (bl) {
                        renderBlocks._a(0.1875, f2, (double)f3, 0.25, (double)f4, (double)(f3 + 0.0625f));
                        renderBlocks._q(block, n, n2, n3);
                        renderBlocks._a(0.25, f5, (double)f3, 0.3125, (double)f6, (double)(f3 + 0.0625f));
                        renderBlocks._q(block, n, n2, n3);
                    }
                    if (!bl2) break;
                    renderBlocks._a(0.9375, f2, (double)f3, 1.0, (double)f4, (double)(f3 + 0.0625f));
                    renderBlocks._q(block, n - 1, n2, n3);
                    renderBlocks._a(0.875, f5, (double)f3, 0.9375, (double)f6, (double)(f3 + 0.0625f));
                    renderBlocks._q(block, n - 1, n2, n3);
                    break;
                }
                if (n5 == 1) {
                    if (bl2) {
                        renderBlocks._a(0.875, f2, 0.75, 0.9375, (double)f4, 0.8125);
                        renderBlocks._q(block, n, n2, n3);
                        renderBlocks._a(0.875, f5, 0.6875, 0.9375, (double)f6, 0.75);
                        renderBlocks._q(block, n, n2, n3);
                    }
                    if (!bl) break;
                    renderBlocks._a(0.875, f2, 0.0, 0.9375, (double)f4, 0.0625);
                    renderBlocks._q(block, n, n2, n3 + 1);
                    renderBlocks._a(0.875, f5, 0.0625, 0.9375, (double)f6, 0.125);
                    renderBlocks._q(block, n, n2, n3 + 1);
                    break;
                }
                if (bl2) {
                    renderBlocks._a(0.875, f2, 0.1875, 0.9375, (double)f4, 0.25);
                    renderBlocks._q(block, n, n2, n3);
                    renderBlocks._a(0.875, f5, 0.25, 0.9375, (double)f6, 0.3125);
                    renderBlocks._q(block, n, n2, n3);
                }
                if (!bl) break;
                renderBlocks._a(0.875, f2, 0.9375, 0.9375, (double)f4, 1.0);
                renderBlocks._q(block, n, n2, n3 - 1);
                renderBlocks._a(0.875, f5, 0.875, 0.9375, (double)f6, 0.9375);
                renderBlocks._q(block, n, n2, n3 - 1);
                break;
            }
            case 1: {
                if (!bl3) {
                    float f8 = f = n5 == 1 ? 0.875f : 0.0625f;
                    if (bl) {
                        renderBlocks._a(f, f2, 0.1875, (double)(f + 0.0625f), (double)f4, 0.25);
                        renderBlocks._q(block, n, n2, n3);
                        renderBlocks._a(f, f5, 0.25, (double)(f + 0.0625f), (double)f6, 0.3125);
                        renderBlocks._q(block, n, n2, n3);
                    }
                    if (!bl2) break;
                    renderBlocks._a(f, f2, 0.9375, (double)(f + 0.0625f), (double)f4, 1.0);
                    renderBlocks._q(block, n, n2, n3 - 1);
                    renderBlocks._a(f, f5, 0.875, (double)(f + 0.0625f), (double)f6, 0.9375);
                    renderBlocks._q(block, n, n2, n3 - 1);
                    break;
                }
                if (n5 == 1) {
                    if (bl2) {
                        renderBlocks._a(0.1875, f2, 0.875, 0.25, (double)f4, 0.9375);
                        renderBlocks._q(block, n, n2, n3);
                        renderBlocks._a(0.25, f5, 0.875, 0.3125, (double)f6, 0.9375);
                        renderBlocks._q(block, n, n2, n3);
                    }
                    if (!bl) break;
                    renderBlocks._a(0.9375, f2, 0.875, 1.0, (double)f4, 0.9375);
                    renderBlocks._q(block, n - 1, n2, n3);
                    renderBlocks._a(0.875, f5, 0.875, 0.9375, (double)f6, 0.9375);
                    renderBlocks._q(block, n - 1, n2, n3);
                    break;
                }
                if (bl2) {
                    renderBlocks._a(0.75, f2, 0.875, 0.8125, (double)f4, 0.9375);
                    renderBlocks._q(block, n, n2, n3);
                    renderBlocks._a(0.6875, f5, 0.875, 0.75, (double)f6, 0.9375);
                    renderBlocks._q(block, n, n2, n3);
                }
                if (!bl) break;
                renderBlocks._a(0.0, f2, 0.875, 0.0625, (double)f4, 0.9375);
                renderBlocks._q(block, n + 1, n2, n3);
                renderBlocks._a(0.0625, f5, 0.875, 0.125, (double)f6, 0.9375);
                renderBlocks._q(block, n + 1, n2, n3);
                break;
            }
            case 2: {
                if (!bl3) {
                    float f9 = f3 = n5 == 1 ? 0.875f : 0.0625f;
                    if (bl) {
                        renderBlocks._a(0.75, f2, (double)f3, 0.8125, (double)f4, (double)(f3 + 0.0625f));
                        renderBlocks._q(block, n, n2, n3);
                        renderBlocks._a(0.6875, f5, (double)f3, 0.75, (double)f6, (double)(f3 + 0.0625f));
                        renderBlocks._q(block, n, n2, n3);
                    }
                    if (!bl2) break;
                    renderBlocks._a(0.0, f2, (double)f3, 0.0625, (double)f4, (double)(f3 + 0.0625f));
                    renderBlocks._q(block, n + 1, n2, n3);
                    renderBlocks._a(0.0625, f5, (double)f3, 0.125, (double)f6, (double)(f3 + 0.0625f));
                    renderBlocks._q(block, n + 1, n2, n3);
                    break;
                }
                if (n5 == 1) {
                    if (bl2) {
                        renderBlocks._a(0.0625, f2, 0.1875, 0.125, (double)f4, 0.25);
                        renderBlocks._q(block, n, n2, n3);
                        renderBlocks._a(0.0625, f5, 0.25, 0.125, (double)f6, 0.3125);
                        renderBlocks._q(block, n, n2, n3);
                    }
                    if (!bl) break;
                    renderBlocks._a(0.0625, f2, 0.9375, 0.125, (double)f4, 1.0);
                    renderBlocks._q(block, n, n2, n3 - 1);
                    renderBlocks._a(0.0625, f5, 0.875, 0.125, (double)f6, 0.9375);
                    renderBlocks._q(block, n, n2, n3 - 1);
                    break;
                }
                if (bl2) {
                    renderBlocks._a(0.0625, f2, 0.75, 0.125, (double)f4, 0.8125);
                    renderBlocks._q(block, n, n2, n3);
                    renderBlocks._a(0.0625, f5, 0.6875, 0.125, (double)f6, 0.75);
                    renderBlocks._q(block, n, n2, n3);
                }
                if (!bl) break;
                renderBlocks._a(0.0625, f2, 0.0, 0.125, (double)f4, 0.0625);
                renderBlocks._q(block, n, n2, n3 + 1);
                renderBlocks._a(0.0625, f5, 0.0625, 0.125, (double)f6, 0.125);
                renderBlocks._q(block, n, n2, n3 + 1);
                break;
            }
            case 3: {
                if (!bl3) {
                    float f10 = f = n5 == 1 ? 0.0625f : 0.875f;
                    if (bl) {
                        renderBlocks._a(f, f2, 0.75, (double)(f + 0.0625f), (double)f4, 0.8125);
                        renderBlocks._q(block, n, n2, n3);
                        renderBlocks._a(f, f5, 0.6875, (double)(f + 0.0625f), (double)f6, 0.75);
                        renderBlocks._q(block, n, n2, n3);
                    }
                    if (!bl2) break;
                    renderBlocks._a(f, f2, 0.0, (double)(f + 0.0625f), (double)f4, 0.0625);
                    renderBlocks._q(block, n, n2, n3 + 1);
                    renderBlocks._a(f, f5, 0.0625, (double)(f + 0.0625f), (double)f6, 0.125);
                    renderBlocks._q(block, n, n2, n3 + 1);
                    break;
                }
                if (n5 == 1) {
                    if (bl2) {
                        renderBlocks._a(0.75, f2, 0.0625, 0.8125, (double)f4, 0.125);
                        renderBlocks._q(block, n, n2, n3);
                        renderBlocks._a(0.6875, f5, 0.0625, 0.75, (double)f6, 0.125);
                        renderBlocks._q(block, n, n2, n3);
                    }
                    if (!bl) break;
                    renderBlocks._a(0.0, f2, 0.0625, 0.0625, (double)f4, 0.125);
                    renderBlocks._q(block, n + 1, n2, n3);
                    renderBlocks._a(0.0625, f5, 0.0625, 0.125, (double)f6, 0.125);
                    renderBlocks._q(block, n + 1, n2, n3);
                    break;
                }
                if (bl2) {
                    renderBlocks._a(0.1875, f2, 0.0625, 0.25, (double)f4, 0.125);
                    renderBlocks._q(block, n, n2, n3);
                    renderBlocks._a(0.25, f5, 0.0625, 0.3125, (double)f6, 0.125);
                    renderBlocks._q(block, n, n2, n3);
                }
                if (!bl) break;
                renderBlocks._a(0.9375, f2, 0.0625, 1.0, (double)f4, 0.125);
                renderBlocks._q(block, n - 1, n2, n3);
                renderBlocks._a(0.875, f5, 0.0625, 0.9375, (double)f6, 0.125);
                renderBlocks._q(block, n - 1, n2, n3);
            }
        }
        return true;
    }
}

