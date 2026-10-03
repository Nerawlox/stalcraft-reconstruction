/*
 * Decompiled with CFR 0.152.
 */
package carpentersblocks.renderer;

import carpentersblocks.data.Gate;
import carpentersblocks.renderer.BlockHandlerBase;
import carpentersblocks.tileentity.TECarpentersBlock;
import carpentersblocks.util.BlockProperties;
import cpw.mods.fml.client.registry.ISimpleBlockRenderingHandler;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.Tessellator;
import net.minecraftforge.common.ForgeDirection;
import org.lwjgl.opengl.GL11;

public class BlockHandlerCarpentersGate
extends BlockHandlerBase
implements ISimpleBlockRenderingHandler {
    @Override
    public void renderInventoryBlock(Block block, int n, int n2, RenderBlocks renderBlocks) {
        Tessellator tessellator = renderBlocks.__aF;
        GL11.glRotatef(90.0f, 0.0f, 1.0f, 0.0f);
        GL11.glTranslatef(-0.5f, -0.5f, -0.5f);
        for (int i = 0; i < 3; ++i) {
            switch (i) {
                case 0: {
                    renderBlocks._a(0.0, 0.3125, 0.4375, 0.125, 1.0, 0.5625);
                    break;
                }
                case 1: {
                    renderBlocks._a(0.125, 0.5, 0.4375, 0.875, 0.9375, 0.5625);
                    break;
                }
                case 2: {
                    renderBlocks._a(0.875, 0.3125, 0.4375, 1.0, 1.0, 0.5625);
                }
            }
            tessellator.startDrawingQuads();
            tessellator.setNormal(0.0f, -1.0f, 0.0f);
            renderBlocks._a(block, 0.0, 0.0, 0.0, block.getBlockTextureFromSide(0));
            tessellator.draw();
            tessellator.startDrawingQuads();
            tessellator.setNormal(0.0f, 1.0f, 0.0f);
            renderBlocks._b(block, 0.0, 0.0, 0.0, block.getBlockTextureFromSide(1));
            tessellator.draw();
            tessellator.startDrawingQuads();
            tessellator.setNormal(0.0f, 0.0f, -1.0f);
            renderBlocks._c(block, 0.0, 0.0, 0.0, block.getBlockTextureFromSide(2));
            tessellator.draw();
            tessellator.startDrawingQuads();
            tessellator.setNormal(0.0f, 0.0f, 1.0f);
            renderBlocks._d(block, 0.0, 0.0, 0.0, block.getBlockTextureFromSide(3));
            tessellator.draw();
            tessellator.startDrawingQuads();
            tessellator.setNormal(-1.0f, 0.0f, 0.0f);
            renderBlocks._e(block, 0.0, 0.0, 0.0, block.getBlockTextureFromSide(4));
            tessellator.draw();
            tessellator.startDrawingQuads();
            tessellator.setNormal(1.0f, 0.0f, 0.0f);
            renderBlocks._f(block, 0.0, 0.0, 0.0, block.getBlockTextureFromSide(5));
            tessellator.draw();
        }
        GL11.glTranslatef(0.5f, 0.5f, 0.5f);
    }

    @Override
    public boolean renderCarpentersBlock(TECarpentersBlock tECarpentersBlock, RenderBlocks renderBlocks, Block block, int n, int n2, int n3, int n4) {
        Block block2 = this.isSideCover ? BlockProperties.getCoverBlock(tECarpentersBlock, this.coverRendering) : BlockProperties.getCoverBlock(tECarpentersBlock, 6);
        int n5 = BlockProperties.getData(tECarpentersBlock);
        int n6 = Gate.getType(n5);
        switch (n6) {
            case 4: {
                this.renderPicketGate(tECarpentersBlock, renderBlocks, block2, block, n2, n3, n4);
                break;
            }
            case 5: {
                this.renderVerticalPlankGate(tECarpentersBlock, renderBlocks, block2, block, n2, n3, n4);
                break;
            }
            case 6: {
                this.renderWallGate(tECarpentersBlock, renderBlocks, block2, block, n2, n3, n4);
                break;
            }
            default: {
                this.renderVanillaGate(tECarpentersBlock, renderBlocks, block2, block, n2, n3, n4);
            }
        }
        return this.shouldRenderBlock(tECarpentersBlock, renderBlocks, block2, block, n);
    }

    private void renderVanillaGate(TECarpentersBlock tECarpentersBlock, RenderBlocks renderBlocks, Block block, Block block2, int n, int n2, int n3) {
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
        boolean bl2 = renderBlocks._a.getBlockId(n, n2 + 1, n3) == block2.blockID;
        boolean bl3 = renderBlocks._a.getBlockId(n, n2 - 1, n3) == block2.blockID;
        boolean bl4 = Gate.getType(n4) == 3;
        renderBlocks._d = true;
        if (n6 == 0) {
            renderBlocks._a(0.0, bl3 ? 0.0 : (double)(f5 - f7), 0.4375, 0.125, bl2 ? 1.0 : (double)f6, 0.5625);
            this.renderStandardBlock(tECarpentersBlock, renderBlocks, block, block2, n, n2, n3);
            renderBlocks._a(0.875, bl3 ? 0.0 : (double)(f5 - f7), 0.4375, 1.0, bl2 ? 1.0 : (double)f6, 0.5625);
            this.renderStandardBlock(tECarpentersBlock, renderBlocks, block, block2, n, n2, n3);
        } else {
            renderBlocks._a(0.4375, bl3 ? 0.0 : (double)(f5 - f7), 0.0, 0.5625, bl2 ? 1.0 : (double)f6, 0.125);
            this.renderStandardBlock(tECarpentersBlock, renderBlocks, block, block2, n, n2, n3);
            renderBlocks._a(0.4375, bl3 ? 0.0 : (double)(f5 - f7), 0.875, 0.5625, bl2 ? 1.0 : (double)f6, 1.0);
            this.renderStandardBlock(tECarpentersBlock, renderBlocks, block, block2, n, n2, n3);
        }
        if (bl) {
            if (n6 == 1) {
                if (n5 == 0) {
                    if (!bl4) {
                        renderBlocks._a(0.8125, bl3 ? 0.0 : (double)(f - f7), 0.0, 0.9375, bl2 ? 1.0 : (double)f4, 0.125);
                        this.renderStandardBlock(tECarpentersBlock, renderBlocks, block, block2, n, n2, n3);
                        renderBlocks._a(0.8125, bl3 ? 0.0 : (double)(f - f7), 0.875, 0.9375, bl2 ? 1.0 : (double)f4, 1.0);
                        this.renderStandardBlock(tECarpentersBlock, renderBlocks, block, block2, n, n2, n3);
                        renderBlocks._a(0.5625, f - f7, 0.0, 0.8125, (double)f2, 0.125);
                        this.renderStandardBlock(tECarpentersBlock, renderBlocks, block, block2, n, n2, n3);
                        renderBlocks._a(0.5625, f - f7, 0.875, 0.8125, (double)f2, 1.0);
                        this.renderStandardBlock(tECarpentersBlock, renderBlocks, block, block2, n, n2, n3);
                        renderBlocks._a(0.5625, f3 - f7, 0.0, 0.8125, (double)f4, 0.125);
                        this.renderStandardBlock(tECarpentersBlock, renderBlocks, block, block2, n, n2, n3);
                        renderBlocks._a(0.5625, f3 - f7, 0.875, 0.8125, (double)f4, 1.0);
                        this.renderStandardBlock(tECarpentersBlock, renderBlocks, block, block2, n, n2, n3);
                    } else {
                        renderBlocks._a(0.5625, bl3 ? 0.0 : 0.1875, 0.0, 0.9375, bl2 ? 1.0 : (double)f4, 0.125);
                        this.renderStandardBlock(tECarpentersBlock, renderBlocks, block, block2, n, n2, n3);
                        renderBlocks._a(0.5625, bl3 ? 0.0 : 0.1875, 0.875, 0.9375, bl2 ? 1.0 : (double)f4, 1.0);
                        this.renderStandardBlock(tECarpentersBlock, renderBlocks, block, block2, n, n2, n3);
                    }
                } else if (!bl4) {
                    renderBlocks._a(0.0625, bl3 ? 0.0 : (double)(f - f7), 0.0, 0.1875, bl2 ? 1.0 : (double)f4, 0.125);
                    this.renderStandardBlock(tECarpentersBlock, renderBlocks, block, block2, n, n2, n3);
                    renderBlocks._a(0.0625, bl3 ? 0.0 : (double)(f - f7), 0.875, 0.1875, bl2 ? 1.0 : (double)f4, 1.0);
                    this.renderStandardBlock(tECarpentersBlock, renderBlocks, block, block2, n, n2, n3);
                    renderBlocks._a(0.1875, f - f7, 0.0, 0.4375, (double)f2, 0.125);
                    this.renderStandardBlock(tECarpentersBlock, renderBlocks, block, block2, n, n2, n3);
                    renderBlocks._a(0.1875, f - f7, 0.875, 0.4375, (double)f2, 1.0);
                    this.renderStandardBlock(tECarpentersBlock, renderBlocks, block, block2, n, n2, n3);
                    renderBlocks._a(0.1875, f3 - f7, 0.0, 0.4375, (double)f4, 0.125);
                    this.renderStandardBlock(tECarpentersBlock, renderBlocks, block, block2, n, n2, n3);
                    renderBlocks._a(0.1875, f3 - f7, 0.875, 0.4375, (double)f4, 1.0);
                    this.renderStandardBlock(tECarpentersBlock, renderBlocks, block, block2, n, n2, n3);
                } else {
                    renderBlocks._a(0.0625, bl3 ? 0.0 : (double)(f - f7), 0.0, 0.4375, bl2 ? 1.0 : (double)f4, 0.125);
                    this.renderStandardBlock(tECarpentersBlock, renderBlocks, block, block2, n, n2, n3);
                    renderBlocks._a(0.0625, bl3 ? 0.0 : (double)(f - f7), 0.875, 0.4375, bl2 ? 1.0 : (double)f4, 1.0);
                    this.renderStandardBlock(tECarpentersBlock, renderBlocks, block, block2, n, n2, n3);
                }
            } else if (n5 == 0) {
                if (!bl4) {
                    renderBlocks._a(0.0, bl3 ? 0.0 : (double)(f - f7), 0.8125, 0.125, bl2 ? 1.0 : (double)f4, 0.9375);
                    this.renderStandardBlock(tECarpentersBlock, renderBlocks, block, block2, n, n2, n3);
                    renderBlocks._a(0.875, bl3 ? 0.0 : (double)(f - f7), 0.8125, 1.0, bl2 ? 1.0 : (double)f4, 0.9375);
                    this.renderStandardBlock(tECarpentersBlock, renderBlocks, block, block2, n, n2, n3);
                    renderBlocks._a(0.0, f - f7, 0.5625, 0.125, (double)f2, 0.8125);
                    this.renderStandardBlock(tECarpentersBlock, renderBlocks, block, block2, n, n2, n3);
                    renderBlocks._a(0.875, f - f7, 0.5625, 1.0, (double)f2, 0.8125);
                    this.renderStandardBlock(tECarpentersBlock, renderBlocks, block, block2, n, n2, n3);
                    renderBlocks._a(0.0, f3 - f7, 0.5625, 0.125, (double)f4, 0.8125);
                    this.renderStandardBlock(tECarpentersBlock, renderBlocks, block, block2, n, n2, n3);
                    renderBlocks._a(0.875, f3 - f7, 0.5625, 1.0, (double)f4, 0.8125);
                    this.renderStandardBlock(tECarpentersBlock, renderBlocks, block, block2, n, n2, n3);
                } else {
                    renderBlocks._a(0.875, bl3 ? 0.0 : (double)(f - f7), 0.5625, 1.0, bl2 ? 1.0 : (double)f4, 0.9375);
                    this.renderStandardBlock(tECarpentersBlock, renderBlocks, block, block2, n, n2, n3);
                    renderBlocks._a(0.0, bl3 ? 0.0 : (double)(f - f7), 0.5625, 0.125, bl2 ? 1.0 : (double)f4, 0.9375);
                    this.renderStandardBlock(tECarpentersBlock, renderBlocks, block, block2, n, n2, n3);
                }
            } else if (!bl4) {
                renderBlocks._a(0.0, bl3 ? 0.0 : (double)(f - f7), 0.0625, 0.125, bl2 ? 1.0 : (double)f4, 0.1875);
                this.renderStandardBlock(tECarpentersBlock, renderBlocks, block, block2, n, n2, n3);
                renderBlocks._a(0.875, bl3 ? 0.0 : (double)(f - f7), 0.0625, 1.0, bl2 ? 1.0 : (double)f4, 0.1875);
                this.renderStandardBlock(tECarpentersBlock, renderBlocks, block, block2, n, n2, n3);
                renderBlocks._a(0.0, f - f7, 0.1875, 0.125, (double)f2, 0.4375);
                this.renderStandardBlock(tECarpentersBlock, renderBlocks, block, block2, n, n2, n3);
                renderBlocks._a(0.875, f - f7, 0.1875, 1.0, (double)f2, 0.4375);
                this.renderStandardBlock(tECarpentersBlock, renderBlocks, block, block2, n, n2, n3);
                renderBlocks._a(0.0, f3 - f7, 0.1875, 0.125, (double)f4, 0.4375);
                this.renderStandardBlock(tECarpentersBlock, renderBlocks, block, block2, n, n2, n3);
                renderBlocks._a(0.875, f3 - f7, 0.1875, 1.0, (double)f4, 0.4375);
                this.renderStandardBlock(tECarpentersBlock, renderBlocks, block, block2, n, n2, n3);
            } else {
                renderBlocks._a(0.875, bl3 ? 0.0 : (double)(f - f7), 0.0625, 1.0, bl2 ? 1.0 : (double)f4, 0.4375);
                this.renderStandardBlock(tECarpentersBlock, renderBlocks, block, block2, n, n2, n3);
                renderBlocks._a(0.0, bl3 ? 0.0 : (double)(f - f7), 0.0625, 0.125, bl2 ? 1.0 : (double)f4, 0.4375);
                this.renderStandardBlock(tECarpentersBlock, renderBlocks, block, block2, n, n2, n3);
            }
        } else if (n6 == 0) {
            if (!bl4) {
                renderBlocks._a(0.375, bl3 ? 0.0 : (double)(f - f7), 0.4375, 0.5, bl2 ? 1.0 : (double)f4, 0.5625);
                this.renderStandardBlock(tECarpentersBlock, renderBlocks, block, block2, n, n2, n3);
                renderBlocks._a(0.5, bl3 ? 0.0 : (double)(f - f7), 0.4375, 0.625, bl2 ? 1.0 : (double)f4, 0.5625);
                this.renderStandardBlock(tECarpentersBlock, renderBlocks, block, block2, n, n2, n3);
                renderBlocks._a(0.625, f - f7, 0.4375, 0.875, (double)f2, 0.5625);
                this.renderStandardBlock(tECarpentersBlock, renderBlocks, block, block2, n, n2, n3);
                renderBlocks._a(0.625, f3 - f7, 0.4375, 0.875, (double)f4, 0.5625);
                this.renderStandardBlock(tECarpentersBlock, renderBlocks, block, block2, n, n2, n3);
                renderBlocks._a(0.125, f - f7, 0.4375, 0.375, (double)f2, 0.5625);
                this.renderStandardBlock(tECarpentersBlock, renderBlocks, block, block2, n, n2, n3);
                renderBlocks._a(0.125, f3 - f7, 0.4375, 0.375, (double)f4, 0.5625);
                this.renderStandardBlock(tECarpentersBlock, renderBlocks, block, block2, n, n2, n3);
            } else {
                renderBlocks._a(0.125, bl3 ? 0.0 : (double)(f - f7), 0.4375, 0.875, bl2 ? 1.0 : (double)f4, 0.5625);
                this.renderStandardBlock(tECarpentersBlock, renderBlocks, block, block2, n, n2, n3);
            }
        } else if (!bl4) {
            renderBlocks._a(0.4375, bl3 ? 0.0 : (double)(f - f7), 0.375, 0.5625, bl2 ? 1.0 : (double)f4, 0.5);
            this.renderStandardBlock(tECarpentersBlock, renderBlocks, block, block2, n, n2, n3);
            renderBlocks._a(0.4375, bl3 ? 0.0 : (double)(f - f7), 0.5, 0.5625, bl2 ? 1.0 : (double)f4, 0.625);
            this.renderStandardBlock(tECarpentersBlock, renderBlocks, block, block2, n, n2, n3);
            renderBlocks._a(0.4375, f - f7, 0.625, 0.5625, (double)f2, 0.875);
            this.renderStandardBlock(tECarpentersBlock, renderBlocks, block, block2, n, n2, n3);
            renderBlocks._a(0.4375, f3 - f7, 0.625, 0.5625, (double)f4, 0.875);
            this.renderStandardBlock(tECarpentersBlock, renderBlocks, block, block2, n, n2, n3);
            renderBlocks._a(0.4375, f - f7, 0.125, 0.5625, (double)f2, 0.375);
            this.renderStandardBlock(tECarpentersBlock, renderBlocks, block, block2, n, n2, n3);
            renderBlocks._a(0.4375, f3 - f7, 0.125, 0.5625, (double)f4, 0.375);
            this.renderStandardBlock(tECarpentersBlock, renderBlocks, block, block2, n, n2, n3);
        } else {
            renderBlocks._a(0.4375, bl3 ? 0.0 : (double)(f - f7), 0.125, 0.5625, bl2 ? 1.0 : (double)f4, 0.875);
            this.renderStandardBlock(tECarpentersBlock, renderBlocks, block, block2, n, n2, n3);
        }
        renderBlocks._d = false;
        renderBlocks._a(0.0, 0.0, 0.0, 1.0, 1.0, 1.0);
    }

    private void renderPicketGate(TECarpentersBlock tECarpentersBlock, RenderBlocks renderBlocks, Block block, Block block2, int n, int n2, int n3) {
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
        boolean bl2 = renderBlocks._a.getBlockId(n, n2 + 1, n3) == block2.blockID;
        boolean bl3 = renderBlocks._a.getBlockId(n, n2 - 1, n3) == block2.blockID;
        renderBlocks._d = true;
        if (bl) {
            if (n6 == 1) {
                if (n5 == 0) {
                    f = 0.5f;
                    f5 = 0.0625f;
                    f6 = 0.1875f;
                    if (!bl2) {
                        f3 = 0.625f;
                        f4 = 0.6875f;
                        renderBlocks._a(f, f3, (double)f5, (double)f2, (double)f4, (double)f6);
                        this.renderStandardBlock(tECarpentersBlock, renderBlocks, block, block2, n, n2, n3);
                        f5 = 0.8125f;
                        f6 = 0.9375f;
                        renderBlocks._a(f, f3, (double)f5, (double)f2, (double)f4, (double)f6);
                        this.renderStandardBlock(tECarpentersBlock, renderBlocks, block, block2, n, n2, n3);
                    }
                    if (!bl3) {
                        f3 = 0.1875f;
                        f4 = 0.25f;
                        f5 = 0.0625f;
                        f6 = 0.1875f;
                        renderBlocks._a(f, f3, (double)f5, (double)f2, (double)f4, (double)f6);
                        this.renderStandardBlock(tECarpentersBlock, renderBlocks, block, block2, n, n2, n3);
                        f5 = 0.8125f;
                        f6 = 0.9375f;
                        renderBlocks._a(f, f3, (double)f5, (double)f2, (double)f4, (double)f6);
                        this.renderStandardBlock(tECarpentersBlock, renderBlocks, block, block2, n, n2, n3);
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
                        renderBlocks._a(f, f3, (double)f5, (double)f2, (double)f4, (double)f6);
                        this.renderStandardBlock(tECarpentersBlock, renderBlocks, block, block2, n, n2, n3);
                        renderBlocks._a(f, f3, (double)(f5 += 0.1875f), (double)f2, (double)f4, (double)(f6 += 0.1875f));
                        this.renderStandardBlock(tECarpentersBlock, renderBlocks, block, block2, n, n2, n3);
                        f5 = 0.75f;
                        f6 = 0.8125f;
                        renderBlocks._a(f, f3, (double)f5, (double)f2, (double)f4, (double)f6);
                        this.renderStandardBlock(tECarpentersBlock, renderBlocks, block, block2, n, n2, n3);
                        renderBlocks._a(f, f3, (double)(f5 += 0.1875f), (double)f2, (double)f4, (double)(f6 += 0.1875f));
                        this.renderStandardBlock(tECarpentersBlock, renderBlocks, block, block2, n, n2, n3);
                    }
                } else {
                    f2 = 0.5f;
                    f5 = 0.0625f;
                    f6 = 0.1875f;
                    if (!bl2) {
                        f3 = 0.625f;
                        f4 = 0.6875f;
                        renderBlocks._a(f, f3, (double)f5, (double)f2, (double)f4, (double)f6);
                        this.renderStandardBlock(tECarpentersBlock, renderBlocks, block, block2, n, n2, n3);
                        f5 = 0.8125f;
                        f6 = 0.9375f;
                        renderBlocks._a(f, f3, (double)f5, (double)f2, (double)f4, (double)f6);
                        this.renderStandardBlock(tECarpentersBlock, renderBlocks, block, block2, n, n2, n3);
                    }
                    if (!bl3) {
                        f3 = 0.1875f;
                        f4 = 0.25f;
                        f5 = 0.0625f;
                        f6 = 0.1875f;
                        renderBlocks._a(f, f3, (double)f5, (double)f2, (double)f4, (double)f6);
                        this.renderStandardBlock(tECarpentersBlock, renderBlocks, block, block2, n, n2, n3);
                        f5 = 0.8125f;
                        f6 = 0.9375f;
                        renderBlocks._a(f, f3, (double)f5, (double)f2, (double)f4, (double)f6);
                        this.renderStandardBlock(tECarpentersBlock, renderBlocks, block, block2, n, n2, n3);
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
                        renderBlocks._a(f, f3, (double)f5, (double)f2, (double)f4, (double)f6);
                        this.renderStandardBlock(tECarpentersBlock, renderBlocks, block, block2, n, n2, n3);
                        renderBlocks._a(f, f3, (double)(f5 += 0.1875f), (double)f2, (double)f4, (double)(f6 += 0.1875f));
                        this.renderStandardBlock(tECarpentersBlock, renderBlocks, block, block2, n, n2, n3);
                        f5 = 0.75f;
                        f6 = 0.8125f;
                        renderBlocks._a(f, f3, (double)f5, (double)f2, (double)f4, (double)f6);
                        this.renderStandardBlock(tECarpentersBlock, renderBlocks, block, block2, n, n2, n3);
                        renderBlocks._a(f, f3, (double)(f5 += 0.1875f), (double)f2, (double)f4, (double)(f6 += 0.1875f));
                        this.renderStandardBlock(tECarpentersBlock, renderBlocks, block, block2, n, n2, n3);
                    }
                }
            } else if (n5 == 0) {
                f = 0.0625f;
                f2 = 0.1875f;
                f5 = 0.5f;
                if (!bl2) {
                    f3 = 0.625f;
                    f4 = 0.6875f;
                    renderBlocks._a(f, f3, (double)f5, (double)f2, (double)f4, (double)f6);
                    this.renderStandardBlock(tECarpentersBlock, renderBlocks, block, block2, n, n2, n3);
                    f = 0.8125f;
                    f2 = 0.9375f;
                    renderBlocks._a(f, f3, (double)f5, (double)f2, (double)f4, (double)f6);
                    this.renderStandardBlock(tECarpentersBlock, renderBlocks, block, block2, n, n2, n3);
                }
                if (!bl3) {
                    f = 0.0625f;
                    f2 = 0.1875f;
                    f3 = 0.1875f;
                    f4 = 0.25f;
                    renderBlocks._a(f, f3, (double)f5, (double)f2, (double)f4, (double)f6);
                    this.renderStandardBlock(tECarpentersBlock, renderBlocks, block, block2, n, n2, n3);
                    f = 0.8125f;
                    f2 = 0.9375f;
                    renderBlocks._a(f, f3, (double)f5, (double)f2, (double)f4, (double)f6);
                    this.renderStandardBlock(tECarpentersBlock, renderBlocks, block, block2, n, n2, n3);
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
                    renderBlocks._a(f, f3, (double)f5, (double)f2, (double)f4, (double)f6);
                    this.renderStandardBlock(tECarpentersBlock, renderBlocks, block, block2, n, n2, n3);
                    renderBlocks._a(f += 0.1875f, f3, (double)f5, (double)(f2 += 0.1875f), (double)f4, (double)f6);
                    this.renderStandardBlock(tECarpentersBlock, renderBlocks, block, block2, n, n2, n3);
                    f = 0.75f;
                    f2 = 0.8125f;
                    renderBlocks._a(f, f3, (double)f5, (double)f2, (double)f4, (double)f6);
                    this.renderStandardBlock(tECarpentersBlock, renderBlocks, block, block2, n, n2, n3);
                    renderBlocks._a(f += 0.1875f, f3, (double)f5, (double)(f2 += 0.1875f), (double)f4, (double)f6);
                    this.renderStandardBlock(tECarpentersBlock, renderBlocks, block, block2, n, n2, n3);
                }
            } else {
                f = 0.0625f;
                f2 = 0.1875f;
                f6 = 0.5f;
                if (!bl2) {
                    f3 = 0.625f;
                    f4 = 0.6875f;
                    renderBlocks._a(f, f3, (double)f5, (double)f2, (double)f4, (double)f6);
                    this.renderStandardBlock(tECarpentersBlock, renderBlocks, block, block2, n, n2, n3);
                    f = 0.8125f;
                    f2 = 0.9375f;
                    renderBlocks._a(f, f3, (double)f5, (double)f2, (double)f4, (double)f6);
                    this.renderStandardBlock(tECarpentersBlock, renderBlocks, block, block2, n, n2, n3);
                }
                if (!bl3) {
                    f = 0.0625f;
                    f2 = 0.1875f;
                    f3 = 0.1875f;
                    f4 = 0.25f;
                    renderBlocks._a(f, f3, (double)f5, (double)f2, (double)f4, (double)f6);
                    this.renderStandardBlock(tECarpentersBlock, renderBlocks, block, block2, n, n2, n3);
                    f = 0.8125f;
                    f2 = 0.9375f;
                    renderBlocks._a(f, f3, (double)f5, (double)f2, (double)f4, (double)f6);
                    this.renderStandardBlock(tECarpentersBlock, renderBlocks, block, block2, n, n2, n3);
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
                    renderBlocks._a(f, f3, (double)f5, (double)f2, (double)f4, (double)f6);
                    this.renderStandardBlock(tECarpentersBlock, renderBlocks, block, block2, n, n2, n3);
                    renderBlocks._a(f += 0.1875f, f3, (double)f5, (double)(f2 += 0.1875f), (double)f4, (double)f6);
                    this.renderStandardBlock(tECarpentersBlock, renderBlocks, block, block2, n, n2, n3);
                    f = 0.75f;
                    f2 = 0.8125f;
                    renderBlocks._a(f, f3, (double)f5, (double)f2, (double)f4, (double)f6);
                    this.renderStandardBlock(tECarpentersBlock, renderBlocks, block, block2, n, n2, n3);
                    renderBlocks._a(f += 0.1875f, f3, (double)f5, (double)(f2 += 0.1875f), (double)f4, (double)f6);
                    this.renderStandardBlock(tECarpentersBlock, renderBlocks, block, block2, n, n2, n3);
                }
            }
        } else if (n6 == 0) {
            f5 = 0.4375f;
            f6 = 0.5625f;
            if (!bl2) {
                f3 = 0.625f;
                f4 = 0.6875f;
                renderBlocks._a(f, f3, (double)f5, (double)f2, (double)f4, (double)f6);
                this.renderStandardBlock(tECarpentersBlock, renderBlocks, block, block2, n, n2, n3);
            }
            if (!bl3) {
                f3 = 0.1875f;
                f4 = 0.25f;
                renderBlocks._a(f, f3, (double)f5, (double)f2, (double)f4, (double)f6);
                this.renderStandardBlock(tECarpentersBlock, renderBlocks, block, block2, n, n2, n3);
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
                renderBlocks._a(f, f3, (double)f5, (double)f2, (double)f4, (double)f6);
                this.renderStandardBlock(tECarpentersBlock, renderBlocks, block, block2, n, n2, n3);
                renderBlocks._a(f, f3, (double)(f5 -= 0.1875f), (double)f2, (double)f4, (double)(f6 -= 0.1875f));
                this.renderStandardBlock(tECarpentersBlock, renderBlocks, block, block2, n, n2, n3);
            }
        } else {
            f = 0.4375f;
            f2 = 0.5625f;
            if (!bl2) {
                f3 = 0.625f;
                f4 = 0.6875f;
                renderBlocks._a(f, f3, (double)f5, (double)f2, (double)f4, (double)f6);
                this.renderStandardBlock(tECarpentersBlock, renderBlocks, block, block2, n, n2, n3);
            }
            if (!bl3) {
                f3 = 0.1875f;
                f4 = 0.25f;
                renderBlocks._a(f, f3, (double)f5, (double)f2, (double)f4, (double)f6);
                this.renderStandardBlock(tECarpentersBlock, renderBlocks, block, block2, n, n2, n3);
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
                renderBlocks._a(f, f3, (double)f5, (double)f2, (double)f4, (double)f6);
                this.renderStandardBlock(tECarpentersBlock, renderBlocks, block, block2, n, n2, n3);
                renderBlocks._a(f -= 0.1875f, f3, (double)f5, (double)(f2 -= 0.1875f), (double)f4, (double)f6);
                this.renderStandardBlock(tECarpentersBlock, renderBlocks, block, block2, n, n2, n3);
            }
        }
        renderBlocks._d = false;
        renderBlocks._a(0.0, 0.0, 0.0, 1.0, 1.0, 1.0);
    }

    private void renderVerticalPlankGate(TECarpentersBlock tECarpentersBlock, RenderBlocks renderBlocks, Block block, Block block2, int n, int n2, int n3) {
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
        boolean bl2 = renderBlocks._a.getBlockId(n, n2 + 1, n3) == block2.blockID;
        boolean bl3 = renderBlocks._a.getBlockId(n, n2 - 1, n3) == block2.blockID;
        renderBlocks._d = true;
        if (bl) {
            if (n6 == 1) {
                if (n5 == 0) {
                    f = 0.5f;
                    f5 = 0.0625f;
                    f6 = 0.1875f;
                    if (!bl2) {
                        f3 = 0.75f;
                        f4 = 0.875f;
                        renderBlocks._a(f, f3, (double)f5, (double)f2, (double)f4, (double)f6);
                        this.renderStandardBlock(tECarpentersBlock, renderBlocks, block, block2, n, n2, n3);
                        f5 = 0.8125f;
                        f6 = 0.9375f;
                        renderBlocks._a(f, f3, (double)f5, (double)f2, (double)f4, (double)f6);
                        this.renderStandardBlock(tECarpentersBlock, renderBlocks, block, block2, n, n2, n3);
                    }
                    if (!bl3) {
                        f3 = 0.125f;
                        f4 = 0.25f;
                        f5 = 0.0625f;
                        f6 = 0.1875f;
                        renderBlocks._a(f, f3, (double)f5, (double)f2, (double)f4, (double)f6);
                        this.renderStandardBlock(tECarpentersBlock, renderBlocks, block, block2, n, n2, n3);
                        f5 = 0.8125f;
                        f6 = 0.9375f;
                        renderBlocks._a(f, f3, (double)f5, (double)f2, (double)f4, (double)f6);
                        this.renderStandardBlock(tECarpentersBlock, renderBlocks, block, block2, n, n2, n3);
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
                        renderBlocks._a(f, f3, (double)f5, (double)f2, (double)f4, (double)f6);
                        this.renderStandardBlock(tECarpentersBlock, renderBlocks, block, block2, n, n2, n3);
                        renderBlocks._a(f, f3, (double)(f5 += 0.1875f), (double)f2, (double)f4, (double)(f6 += 0.1875f));
                        this.renderStandardBlock(tECarpentersBlock, renderBlocks, block, block2, n, n2, n3);
                        f5 = 0.75f;
                        f6 = 0.8125f;
                        renderBlocks._a(f, f3, (double)f5, (double)f2, (double)f4, (double)f6);
                        this.renderStandardBlock(tECarpentersBlock, renderBlocks, block, block2, n, n2, n3);
                        renderBlocks._a(f, f3, (double)(f5 += 0.1875f), (double)f2, (double)f4, (double)(f6 += 0.1875f));
                        this.renderStandardBlock(tECarpentersBlock, renderBlocks, block, block2, n, n2, n3);
                    }
                } else {
                    f2 = 0.5f;
                    f5 = 0.0625f;
                    f6 = 0.1875f;
                    if (!bl2) {
                        f3 = 0.75f;
                        f4 = 0.875f;
                        renderBlocks._a(f, f3, (double)f5, (double)f2, (double)f4, (double)f6);
                        this.renderStandardBlock(tECarpentersBlock, renderBlocks, block, block2, n, n2, n3);
                        f5 = 0.8125f;
                        f6 = 0.9375f;
                        renderBlocks._a(f, f3, (double)f5, (double)f2, (double)f4, (double)f6);
                        this.renderStandardBlock(tECarpentersBlock, renderBlocks, block, block2, n, n2, n3);
                    }
                    if (!bl3) {
                        f3 = 0.125f;
                        f4 = 0.25f;
                        f5 = 0.0625f;
                        f6 = 0.1875f;
                        renderBlocks._a(f, f3, (double)f5, (double)f2, (double)f4, (double)f6);
                        this.renderStandardBlock(tECarpentersBlock, renderBlocks, block, block2, n, n2, n3);
                        f5 = 0.8125f;
                        f6 = 0.9375f;
                        renderBlocks._a(f, f3, (double)f5, (double)f2, (double)f4, (double)f6);
                        this.renderStandardBlock(tECarpentersBlock, renderBlocks, block, block2, n, n2, n3);
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
                        renderBlocks._a(f, f3, (double)f5, (double)f2, (double)f4, (double)f6);
                        this.renderStandardBlock(tECarpentersBlock, renderBlocks, block, block2, n, n2, n3);
                        renderBlocks._a(f, f3, (double)(f5 += 0.1875f), (double)f2, (double)f4, (double)(f6 += 0.1875f));
                        this.renderStandardBlock(tECarpentersBlock, renderBlocks, block, block2, n, n2, n3);
                        f5 = 0.75f;
                        f6 = 0.8125f;
                        renderBlocks._a(f, f3, (double)f5, (double)f2, (double)f4, (double)f6);
                        this.renderStandardBlock(tECarpentersBlock, renderBlocks, block, block2, n, n2, n3);
                        renderBlocks._a(f, f3, (double)(f5 += 0.1875f), (double)f2, (double)f4, (double)(f6 += 0.1875f));
                        this.renderStandardBlock(tECarpentersBlock, renderBlocks, block, block2, n, n2, n3);
                    }
                }
            } else if (n5 == 0) {
                f = 0.0625f;
                f2 = 0.1875f;
                f5 = 0.5f;
                if (!bl2) {
                    f3 = 0.75f;
                    f4 = 0.875f;
                    renderBlocks._a(f, f3, (double)f5, (double)f2, (double)f4, (double)f6);
                    this.renderStandardBlock(tECarpentersBlock, renderBlocks, block, block2, n, n2, n3);
                    f = 0.8125f;
                    f2 = 0.9375f;
                    renderBlocks._a(f, f3, (double)f5, (double)f2, (double)f4, (double)f6);
                    this.renderStandardBlock(tECarpentersBlock, renderBlocks, block, block2, n, n2, n3);
                }
                if (!bl3) {
                    f = 0.0625f;
                    f2 = 0.1875f;
                    f3 = 0.125f;
                    f4 = 0.25f;
                    renderBlocks._a(f, f3, (double)f5, (double)f2, (double)f4, (double)f6);
                    this.renderStandardBlock(tECarpentersBlock, renderBlocks, block, block2, n, n2, n3);
                    f = 0.8125f;
                    f2 = 0.9375f;
                    renderBlocks._a(f, f3, (double)f5, (double)f2, (double)f4, (double)f6);
                    this.renderStandardBlock(tECarpentersBlock, renderBlocks, block, block2, n, n2, n3);
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
                    renderBlocks._a(f, f3, (double)f5, (double)f2, (double)f4, (double)f6);
                    this.renderStandardBlock(tECarpentersBlock, renderBlocks, block, block2, n, n2, n3);
                    renderBlocks._a(f += 0.1875f, f3, (double)f5, (double)(f2 += 0.1875f), (double)f4, (double)f6);
                    this.renderStandardBlock(tECarpentersBlock, renderBlocks, block, block2, n, n2, n3);
                    f = 0.75f;
                    f2 = 0.8125f;
                    renderBlocks._a(f, f3, (double)f5, (double)f2, (double)f4, (double)f6);
                    this.renderStandardBlock(tECarpentersBlock, renderBlocks, block, block2, n, n2, n3);
                    renderBlocks._a(f += 0.1875f, f3, (double)f5, (double)(f2 += 0.1875f), (double)f4, (double)f6);
                    this.renderStandardBlock(tECarpentersBlock, renderBlocks, block, block2, n, n2, n3);
                }
            } else {
                f = 0.0625f;
                f2 = 0.1875f;
                f6 = 0.5f;
                if (!bl2) {
                    f3 = 0.75f;
                    f4 = 0.875f;
                    renderBlocks._a(f, f3, (double)f5, (double)f2, (double)f4, (double)f6);
                    this.renderStandardBlock(tECarpentersBlock, renderBlocks, block, block2, n, n2, n3);
                    f = 0.8125f;
                    f2 = 0.9375f;
                    renderBlocks._a(f, f3, (double)f5, (double)f2, (double)f4, (double)f6);
                    this.renderStandardBlock(tECarpentersBlock, renderBlocks, block, block2, n, n2, n3);
                }
                if (!bl3) {
                    f = 0.0625f;
                    f2 = 0.1875f;
                    f3 = 0.125f;
                    f4 = 0.25f;
                    renderBlocks._a(f, f3, (double)f5, (double)f2, (double)f4, (double)f6);
                    this.renderStandardBlock(tECarpentersBlock, renderBlocks, block, block2, n, n2, n3);
                    f = 0.8125f;
                    f2 = 0.9375f;
                    renderBlocks._a(f, f3, (double)f5, (double)f2, (double)f4, (double)f6);
                    this.renderStandardBlock(tECarpentersBlock, renderBlocks, block, block2, n, n2, n3);
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
                    renderBlocks._a(f, f3, (double)f5, (double)f2, (double)f4, (double)f6);
                    this.renderStandardBlock(tECarpentersBlock, renderBlocks, block, block2, n, n2, n3);
                    renderBlocks._a(f += 0.1875f, f3, (double)f5, (double)(f2 += 0.1875f), (double)f4, (double)f6);
                    this.renderStandardBlock(tECarpentersBlock, renderBlocks, block, block2, n, n2, n3);
                    f = 0.75f;
                    f2 = 0.8125f;
                    renderBlocks._a(f, f3, (double)f5, (double)f2, (double)f4, (double)f6);
                    this.renderStandardBlock(tECarpentersBlock, renderBlocks, block, block2, n, n2, n3);
                    renderBlocks._a(f += 0.1875f, f3, (double)f5, (double)(f2 += 0.1875f), (double)f4, (double)f6);
                    this.renderStandardBlock(tECarpentersBlock, renderBlocks, block, block2, n, n2, n3);
                }
            }
        } else if (n6 == 0) {
            f5 = 0.4375f;
            f6 = 0.5625f;
            if (!bl2) {
                f3 = 0.75f;
                f4 = 0.875f;
                renderBlocks._a(f, f3, (double)f5, (double)f2, (double)f4, (double)f6);
                this.renderStandardBlock(tECarpentersBlock, renderBlocks, block, block2, n, n2, n3);
            }
            if (!bl3) {
                f3 = 0.125f;
                f4 = 0.25f;
                renderBlocks._a(f, f3, (double)f5, (double)f2, (double)f4, (double)f6);
                this.renderStandardBlock(tECarpentersBlock, renderBlocks, block, block2, n, n2, n3);
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
                renderBlocks._a(f, f3, (double)f5, (double)f2, (double)f4, (double)f6);
                this.renderStandardBlock(tECarpentersBlock, renderBlocks, block, block2, n, n2, n3);
                renderBlocks._a(f, f3, (double)(f5 -= 0.1875f), (double)f2, (double)f4, (double)(f6 -= 0.1875f));
                this.renderStandardBlock(tECarpentersBlock, renderBlocks, block, block2, n, n2, n3);
            }
        } else {
            f = 0.4375f;
            f2 = 0.5625f;
            if (!bl2) {
                f3 = 0.75f;
                f4 = 0.875f;
                renderBlocks._a(f, f3, (double)f5, (double)f2, (double)f4, (double)f6);
                this.renderStandardBlock(tECarpentersBlock, renderBlocks, block, block2, n, n2, n3);
            }
            if (!bl3) {
                f3 = 0.125f;
                f4 = 0.25f;
                renderBlocks._a(f, f3, (double)f5, (double)f2, (double)f4, (double)f6);
                this.renderStandardBlock(tECarpentersBlock, renderBlocks, block, block2, n, n2, n3);
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
                renderBlocks._a(f, f3, (double)f5, (double)f2, (double)f4, (double)f6);
                this.renderStandardBlock(tECarpentersBlock, renderBlocks, block, block2, n, n2, n3);
                renderBlocks._a(f -= 0.1875f, f3, (double)f5, (double)(f2 -= 0.1875f), (double)f4, (double)f6);
                this.renderStandardBlock(tECarpentersBlock, renderBlocks, block, block2, n, n2, n3);
            }
        }
        renderBlocks._d = false;
        renderBlocks._a(0.0, 0.0, 0.0, 1.0, 1.0, 1.0);
    }

    private void renderWallGate(TECarpentersBlock tECarpentersBlock, RenderBlocks renderBlocks, Block block, Block block2, int n, int n2, int n3) {
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
        boolean bl2 = renderBlocks._a.getBlockId(n, n2 + 1, n3) == block2.blockID;
        f4 = !bl2 && !renderBlocks._a.isBlockSolidOnSide(n, n2 + 1, n3, ForgeDirection.DOWN, true) ? 0.8125f : 1.0f;
        renderBlocks._d = true;
        if (bl) {
            if (n6 == 1) {
                if (n5 == 0) {
                    f = 0.5f;
                    f6 = 0.125f;
                    renderBlocks._a(f, f3, (double)f5, (double)f2, (double)f4, (double)f6);
                    this.renderStandardBlock(tECarpentersBlock, renderBlocks, block, block2, n, n2, n3);
                    f5 = 0.875f;
                    f6 = 1.0f;
                    renderBlocks._a(f, f3, (double)f5, (double)f2, (double)f4, (double)f6);
                    this.renderStandardBlock(tECarpentersBlock, renderBlocks, block, block2, n, n2, n3);
                } else {
                    f2 = 0.5f;
                    f6 = 0.125f;
                    renderBlocks._a(f, f3, (double)f5, (double)f2, (double)f4, (double)f6);
                    this.renderStandardBlock(tECarpentersBlock, renderBlocks, block, block2, n, n2, n3);
                    f5 = 0.875f;
                    f6 = 1.0f;
                    renderBlocks._a(f, f3, (double)f5, (double)f2, (double)f4, (double)f6);
                    this.renderStandardBlock(tECarpentersBlock, renderBlocks, block, block2, n, n2, n3);
                }
            } else if (n5 == 0) {
                f2 = 0.125f;
                f5 = 0.5f;
                renderBlocks._a(f, f3, (double)f5, (double)f2, (double)f4, (double)f6);
                this.renderStandardBlock(tECarpentersBlock, renderBlocks, block, block2, n, n2, n3);
                f = 0.875f;
                f2 = 1.0f;
                renderBlocks._a(f, f3, (double)f5, (double)f2, (double)f4, (double)f6);
                this.renderStandardBlock(tECarpentersBlock, renderBlocks, block, block2, n, n2, n3);
            } else {
                f2 = 0.125f;
                f6 = 0.5f;
                renderBlocks._a(f, f3, (double)f5, (double)f2, (double)f4, (double)f6);
                this.renderStandardBlock(tECarpentersBlock, renderBlocks, block, block2, n, n2, n3);
                f = 0.875f;
                f2 = 1.0f;
                renderBlocks._a(f, f3, (double)f5, (double)f2, (double)f4, (double)f6);
                this.renderStandardBlock(tECarpentersBlock, renderBlocks, block, block2, n, n2, n3);
            }
        } else if (n6 == 0) {
            f5 = 0.4375f;
            f6 = 0.5625f;
            renderBlocks._a(f, f3, (double)f5, (double)f2, (double)f4, (double)f6);
            this.renderStandardBlock(tECarpentersBlock, renderBlocks, block, block2, n, n2, n3);
        } else {
            f = 0.4375f;
            f2 = 0.5625f;
            renderBlocks._a(f, f3, (double)f5, (double)f2, (double)f4, (double)f6);
            this.renderStandardBlock(tECarpentersBlock, renderBlocks, block, block2, n, n2, n3);
        }
        renderBlocks._d = false;
        renderBlocks._a(0.0, 0.0, 0.0, 1.0, 1.0, 1.0);
    }
}

