/*
 * Decompiled with CFR 0.152.
 */
package carpentersblocks.renderer;

import carpentersblocks.data.Bed;
import carpentersblocks.renderer.BlockHandlerBase;
import carpentersblocks.tileentity.TECarpentersBlock;
import carpentersblocks.util.BlockProperties;
import carpentersblocks.util.handler.BedDesignHandler;
import carpentersblocks.util.handler.IconHandler;
import net.minecraft.block.Block;
import net.minecraft.block.BlockBed;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.util.Icon;
import net.minecraftforge.common.ForgeDirection;

public class BlockHandlerCarpentersBed
extends BlockHandlerBase {
    @Override
    public boolean renderCarpentersBlock(TECarpentersBlock tECarpentersBlock, RenderBlocks renderBlocks, Block block, int n, int n2, int n3, int n4) {
        Block block2 = BlockProperties.getCoverBlock(tECarpentersBlock, 6);
        this.renderNormalBed(tECarpentersBlock, renderBlocks, block2, block, n2, n3, n4);
        return this.shouldRenderBlock(tECarpentersBlock, renderBlocks, block2, block, n);
    }

    public boolean renderNormalBed(TECarpentersBlock tECarpentersBlock, RenderBlocks renderBlocks, Block block, Block block2, int n, int n2, int n3) {
        int n4;
        int n5 = BlockProperties.getData(tECarpentersBlock);
        int n6 = renderBlocks._a.getBlockMetadata(n, n2, n3);
        this.disableAO = true;
        boolean bl = BlockBed._a(n6);
        ForgeDirection forgeDirection = Bed.getDirection(n6 & 3);
        TECarpentersBlock tECarpentersBlock2 = Bed.getOppositeTE(renderBlocks._a, n, n2, n3);
        boolean bl2 = Bed.isOccupied(tECarpentersBlock);
        int n7 = 0;
        int n8 = 0;
        if (tECarpentersBlock2 != null) {
            bl2 |= Bed.isOccupied(tECarpentersBlock2);
            n7 = BlockProperties.getDyeColor(bl ? tECarpentersBlock2 : tECarpentersBlock, 6);
            n8 = BlockProperties.getDyeColor(bl ? tECarpentersBlock : tECarpentersBlock2, 6);
        }
        boolean bl3 = (n4 = Bed.getDesign(n5)) > 0 && BedDesignHandler.hasBlanket[n4];
        Icon icon = bl3 && BedDesignHandler.hasPillow[n4] ? IconHandler.icon_bed_pillow_custom[n4] : IconHandler.icon_bed_pillow;
        boolean bl4 = false;
        boolean bl5 = false;
        if (!forgeDirection.equals((Object)ForgeDirection.NORTH) && !forgeDirection.equals((Object)ForgeDirection.SOUTH)) {
            if (renderBlocks._a.getBlockId(n, n2, n3 + 1) == block2.blockID) {
                boolean bl6 = bl4 = (n6 & 0xFFFFFFFB) == (renderBlocks._a.getBlockMetadata(n, n2, n3 + 1) & 0xFFFFFFFB);
            }
            if (renderBlocks._a.getBlockId(n, n2, n3 - 1) == block2.blockID) {
                bl5 = (n6 & 0xFFFFFFFB) == (renderBlocks._a.getBlockMetadata(n, n2, n3 - 1) & 0xFFFFFFFB);
            }
        } else {
            if (renderBlocks._a.getBlockId(n + 1, n2, n3) == block2.blockID) {
                boolean bl7 = bl4 = (n6 & 0xFFFFFFFB) == (renderBlocks._a.getBlockMetadata(n + 1, n2, n3) & 0xFFFFFFFB);
            }
            if (renderBlocks._a.getBlockId(n - 1, n2, n3) == block2.blockID) {
                bl5 = (n6 & 0xFFFFFFFB) == (renderBlocks._a.getBlockMetadata(n - 1, n2, n3) & 0xFFFFFFFB);
            }
        }
        switch (NamelessClass766008257.$SwitchMap$net$minecraftforge$common$ForgeDirection[forgeDirection.ordinal()]) {
            case 1: {
                if (bl) {
                    this.setMetadataOverride(BlockProperties.getCoverMetadata(tECarpentersBlock, 6));
                    renderBlocks._a(0.125, 0.1875, 0.875, 0.875, 0.875, 1.0);
                    this.renderStandardBlock(tECarpentersBlock, renderBlocks, block, block2, n, n2, n3);
                    renderBlocks._a(0.0, bl5 ? 0.1875 : 0.0, 0.875, 0.125, bl5 ? 0.875 : 1.0, 1.0);
                    this.renderStandardBlock(tECarpentersBlock, renderBlocks, block, block2, n, n2, n3);
                    renderBlocks._a(0.875, bl4 ? 0.1875 : 0.0, 0.875, 1.0, bl4 ? 0.875 : 1.0, 1.0);
                    this.renderStandardBlock(tECarpentersBlock, renderBlocks, block, block2, n, n2, n3);
                    renderBlocks._a(0.0, 0.1875, 0.0, 1.0, 0.3125, 0.875);
                    this.renderStandardBlock(tECarpentersBlock, renderBlocks, block, block2, n, n2, n3);
                    this.clearMetadataOverride();
                    this.suppressDyeColor = true;
                    this.suppressOverlay = true;
                    this.suppressPattern = true;
                    this.setMetadataOverride(0);
                    renderBlocks._a(bl5 ? 0.0 : 0.0625, 0.3125, 0.0, bl4 ? 1.0 : 0.9375, 0.5625, 0.875);
                    this.renderStandardBlock(tECarpentersBlock, renderBlocks, Block.cloth, block2, n, n2, n3);
                    this.clearMetadataOverride();
                    renderBlocks._u = 2;
                    this.setIconOverride(6, icon);
                    renderBlocks._a(0.125, 0.5625, 0.4375, 0.875, 0.6875, 0.8125);
                    this.renderStandardBlock(tECarpentersBlock, renderBlocks, Block.cloth, block2, n, n2, n3);
                    this.clearIconOverride(6);
                    renderBlocks._u = 0;
                    if (!bl3) {
                        this.setMetadataOverride(n7);
                        renderBlocks._a(0.0, bl2 ? 0.4375 : 0.3125, 0.0, 0.0625, bl2 ? 0.8125 : 0.5625, 0.5);
                        this.renderStandardBlock(tECarpentersBlock, renderBlocks, Block.cloth, block2, n, n2, n3);
                        renderBlocks._a(0.0, bl2 ? 0.8125 : 0.5625, 0.0, 1.0, bl2 ? 0.875 : 0.625, 0.5);
                        this.renderStandardBlock(tECarpentersBlock, renderBlocks, Block.cloth, block2, n, n2, n3);
                        renderBlocks._a(0.9375, bl2 ? 0.4375 : 0.3125, 0.0, 1.0, bl2 ? 0.8125 : 0.5625, 0.5);
                        this.renderStandardBlock(tECarpentersBlock, renderBlocks, Block.cloth, block2, n, n2, n3);
                        this.clearMetadataOverride();
                    }
                    this.suppressDyeColor = false;
                    this.suppressOverlay = false;
                    this.suppressPattern = false;
                    break;
                }
                this.setDyeColorOverride(n8);
                this.setMetadataOverride(BlockProperties.getCoverMetadata(tECarpentersBlock, 6));
                if (!bl5) {
                    renderBlocks._a(0.0, 0.0, 0.0, 0.125, 0.1875, 0.125);
                    this.renderStandardBlock(tECarpentersBlock, renderBlocks, block, block2, n, n2, n3);
                }
                if (!bl4) {
                    renderBlocks._a(0.875, 0.0, 0.0, 1.0, 0.1875, 0.125);
                    this.renderStandardBlock(tECarpentersBlock, renderBlocks, block, block2, n, n2, n3);
                }
                renderBlocks._a(0.0, 0.1875, 0.0, 1.0, 0.3125, 1.0);
                this.renderStandardBlock(tECarpentersBlock, renderBlocks, block, block2, n, n2, n3);
                this.clearMetadataOverride();
                this.clearDyeColorOverride();
                this.suppressDyeColor = true;
                this.suppressOverlay = true;
                this.suppressPattern = true;
                this.setMetadataOverride(0);
                renderBlocks._a(bl5 ? 0.0 : 0.0625, 0.3125, 0.0625, bl4 ? 1.0 : 0.9375, 0.5625, 1.0);
                this.renderStandardBlock(tECarpentersBlock, renderBlocks, Block.cloth, block2, n, n2, n3);
                this.clearMetadataOverride();
                if (!bl3) {
                    this.setMetadataOverride(n7);
                    renderBlocks._a(0.0, bl2 ? 0.4375 : 0.3125, 0.0, 0.0625, bl2 ? 0.8125 : 0.5625, 1.0);
                    this.renderStandardBlock(tECarpentersBlock, renderBlocks, Block.cloth, block2, n, n2, n3);
                    renderBlocks._a(0.0, bl2 ? 0.8125 : 0.5625, 0.0, 1.0, bl2 ? 0.875 : 0.625, 1.0);
                    this.renderStandardBlock(tECarpentersBlock, renderBlocks, Block.cloth, block2, n, n2, n3);
                    renderBlocks._a(0.9375, bl2 ? 0.4375 : 0.3125, 0.0, 1.0, bl2 ? 0.8125 : 0.5625, 1.0);
                    this.renderStandardBlock(tECarpentersBlock, renderBlocks, Block.cloth, block2, n, n2, n3);
                    renderBlocks._a(0.0625, bl2 ? 0.4375 : 0.3125, 0.0, 0.9375, bl2 ? 0.8125 : 0.5625, 0.0625);
                    this.renderStandardBlock(tECarpentersBlock, renderBlocks, Block.cloth, block2, n, n2, n3);
                    this.clearMetadataOverride();
                }
                this.suppressDyeColor = false;
                this.suppressOverlay = false;
                this.suppressPattern = false;
                break;
            }
            case 2: {
                if (bl) {
                    this.setMetadataOverride(BlockProperties.getCoverMetadata(tECarpentersBlock, 6));
                    renderBlocks._a(0.125, 0.1875, 0.0, 0.875, 0.875, 0.125);
                    this.renderStandardBlock(tECarpentersBlock, renderBlocks, block, block2, n, n2, n3);
                    renderBlocks._a(0.0, bl5 ? 0.1875 : 0.0, 0.0, 0.125, bl5 ? 0.875 : 1.0, 0.125);
                    this.renderStandardBlock(tECarpentersBlock, renderBlocks, block, block2, n, n2, n3);
                    renderBlocks._a(0.875, bl4 ? 0.1875 : 0.0, 0.0, 1.0, bl4 ? 0.875 : 1.0, 0.125);
                    this.renderStandardBlock(tECarpentersBlock, renderBlocks, block, block2, n, n2, n3);
                    renderBlocks._a(0.0, 0.1875, 0.125, 1.0, 0.3125, 1.0);
                    this.renderStandardBlock(tECarpentersBlock, renderBlocks, block, block2, n, n2, n3);
                    this.clearMetadataOverride();
                    this.suppressDyeColor = true;
                    this.suppressOverlay = true;
                    this.suppressPattern = true;
                    this.setMetadataOverride(0);
                    renderBlocks._a(bl5 ? 0.0 : 0.0625, 0.3125, 0.125, bl4 ? 1.0 : 0.9375, 0.5625, 1.0);
                    this.renderStandardBlock(tECarpentersBlock, renderBlocks, Block.cloth, block2, n, n2, n3);
                    this.clearMetadataOverride();
                    this.setIconOverride(6, icon);
                    renderBlocks._a(0.125, 0.5625, 0.1875, 0.875, 0.6875, 0.5625);
                    this.renderStandardBlock(tECarpentersBlock, renderBlocks, Block.cloth, block2, n, n2, n3);
                    this.clearIconOverride(6);
                    renderBlocks._u = 0;
                    if (!bl3) {
                        this.setMetadataOverride(n7);
                        renderBlocks._a(0.0, bl2 ? 0.4375 : 0.3125, 0.5, 0.0625, bl2 ? 0.8125 : 0.5625, 1.0);
                        this.renderStandardBlock(tECarpentersBlock, renderBlocks, Block.cloth, block2, n, n2, n3);
                        renderBlocks._a(0.0, bl2 ? 0.8125 : 0.5625, 0.5, 1.0, bl2 ? 0.875 : 0.625, 1.0);
                        this.renderStandardBlock(tECarpentersBlock, renderBlocks, Block.cloth, block2, n, n2, n3);
                        renderBlocks._a(0.9375, bl2 ? 0.4375 : 0.3125, 0.5, 1.0, bl2 ? 0.8125 : 0.5625, 1.0);
                        this.renderStandardBlock(tECarpentersBlock, renderBlocks, Block.cloth, block2, n, n2, n3);
                        this.clearMetadataOverride();
                    }
                    this.suppressDyeColor = false;
                    this.suppressOverlay = false;
                    this.suppressPattern = false;
                    break;
                }
                this.setDyeColorOverride(n8);
                this.setMetadataOverride(BlockProperties.getCoverMetadata(tECarpentersBlock, 6));
                if (!bl5) {
                    renderBlocks._a(0.0, 0.0, 0.875, 0.125, 0.1875, 1.0);
                    this.renderStandardBlock(tECarpentersBlock, renderBlocks, block, block2, n, n2, n3);
                }
                if (!bl4) {
                    renderBlocks._a(0.875, 0.0, 0.875, 1.0, 0.1875, 1.0);
                    this.renderStandardBlock(tECarpentersBlock, renderBlocks, block, block2, n, n2, n3);
                }
                renderBlocks._a(0.0, 0.1875, 0.0, 1.0, 0.3125, 1.0);
                this.renderStandardBlock(tECarpentersBlock, renderBlocks, block, block2, n, n2, n3);
                this.clearMetadataOverride();
                this.clearDyeColorOverride();
                this.suppressDyeColor = true;
                this.suppressOverlay = true;
                this.suppressPattern = true;
                this.setMetadataOverride(0);
                renderBlocks._a(bl5 ? 0.0 : 0.0625, 0.3125, 0.0, bl4 ? 1.0 : 0.9375, 0.5625, 0.9375);
                this.renderStandardBlock(tECarpentersBlock, renderBlocks, Block.cloth, block2, n, n2, n3);
                this.clearMetadataOverride();
                if (!bl3) {
                    this.setMetadataOverride(n7);
                    renderBlocks._a(0.0, bl2 ? 0.4375 : 0.3125, 0.0, 0.0625, bl2 ? 0.8125 : 0.5625, 1.0);
                    this.renderStandardBlock(tECarpentersBlock, renderBlocks, Block.cloth, block2, n, n2, n3);
                    renderBlocks._a(0.0, bl2 ? 0.8125 : 0.5625, 0.0, 1.0, bl2 ? 0.875 : 0.625, 1.0);
                    this.renderStandardBlock(tECarpentersBlock, renderBlocks, Block.cloth, block2, n, n2, n3);
                    renderBlocks._a(0.9375, bl2 ? 0.4375 : 0.3125, 0.0, 1.0, bl2 ? 0.8125 : 0.5625, 1.0);
                    this.renderStandardBlock(tECarpentersBlock, renderBlocks, Block.cloth, block2, n, n2, n3);
                    renderBlocks._a(0.0625, bl2 ? 0.4375 : 0.3125, 0.9375, 0.9375, bl2 ? 0.8125 : 0.5625, 1.0);
                    this.renderStandardBlock(tECarpentersBlock, renderBlocks, Block.cloth, block2, n, n2, n3);
                    this.clearMetadataOverride();
                }
                this.suppressDyeColor = false;
                this.suppressOverlay = false;
                this.suppressPattern = false;
                break;
            }
            case 3: {
                if (bl) {
                    this.setMetadataOverride(BlockProperties.getCoverMetadata(tECarpentersBlock, 6));
                    renderBlocks._a(0.875, 0.1875, 0.125, 1.0, 0.875, 0.875);
                    this.renderStandardBlock(tECarpentersBlock, renderBlocks, block, block2, n, n2, n3);
                    renderBlocks._a(0.875, bl5 ? 0.1875 : 0.0, 0.0, 1.0, bl5 ? 0.875 : 1.0, 0.125);
                    this.renderStandardBlock(tECarpentersBlock, renderBlocks, block, block2, n, n2, n3);
                    renderBlocks._a(0.875, bl4 ? 0.1875 : 0.0, 0.875, 1.0, bl4 ? 0.875 : 1.0, 1.0);
                    this.renderStandardBlock(tECarpentersBlock, renderBlocks, block, block2, n, n2, n3);
                    renderBlocks._a(0.0, 0.1875, 0.0, 0.875, 0.3125, 1.0);
                    this.renderStandardBlock(tECarpentersBlock, renderBlocks, block, block2, n, n2, n3);
                    this.clearMetadataOverride();
                    this.suppressDyeColor = true;
                    this.suppressOverlay = true;
                    this.suppressPattern = true;
                    this.setMetadataOverride(0);
                    renderBlocks._a(0.0, 0.3125, bl5 ? 0.0 : 0.0625, 0.875, 0.5625, bl4 ? 1.0 : 0.9375);
                    this.renderStandardBlock(tECarpentersBlock, renderBlocks, Block.cloth, block2, n, n2, n3);
                    this.clearMetadataOverride();
                    renderBlocks._u = 1;
                    this.setIconOverride(6, icon);
                    renderBlocks._a(0.4375, 0.5625, 0.125, 0.8125, 0.6875, 0.875);
                    this.renderStandardBlock(tECarpentersBlock, renderBlocks, Block.cloth, block2, n, n2, n3);
                    this.clearIconOverride(6);
                    renderBlocks._u = 0;
                    if (!bl3) {
                        this.setMetadataOverride(n7);
                        renderBlocks._a(0.0, bl2 ? 0.4375 : 0.3125, 0.0, 0.5, bl2 ? 0.8125 : 0.5625, 0.0625);
                        this.renderStandardBlock(tECarpentersBlock, renderBlocks, Block.cloth, block2, n, n2, n3);
                        renderBlocks._a(0.0, bl2 ? 0.8125 : 0.5625, 0.0, 0.5, bl2 ? 0.875 : 0.625, 1.0);
                        this.renderStandardBlock(tECarpentersBlock, renderBlocks, Block.cloth, block2, n, n2, n3);
                        renderBlocks._a(0.0, bl2 ? 0.4375 : 0.3125, 0.9375, 0.5, bl2 ? 0.8125 : 0.5625, 1.0);
                        this.renderStandardBlock(tECarpentersBlock, renderBlocks, Block.cloth, block2, n, n2, n3);
                        this.clearMetadataOverride();
                    }
                    this.suppressDyeColor = false;
                    this.suppressOverlay = false;
                    this.suppressPattern = false;
                    break;
                }
                this.setDyeColorOverride(n8);
                this.setMetadataOverride(BlockProperties.getCoverMetadata(tECarpentersBlock, 6));
                if (!bl5) {
                    renderBlocks._a(0.0, 0.0, 0.0, 0.125, 0.1875, 0.125);
                    this.renderStandardBlock(tECarpentersBlock, renderBlocks, block, block2, n, n2, n3);
                }
                if (!bl4) {
                    renderBlocks._a(0.0, 0.0, 0.875, 0.125, 0.1875, 1.0);
                    this.renderStandardBlock(tECarpentersBlock, renderBlocks, block, block2, n, n2, n3);
                }
                renderBlocks._a(0.0, 0.1875, 0.0, 1.0, 0.3125, 1.0);
                this.renderStandardBlock(tECarpentersBlock, renderBlocks, block, block2, n, n2, n3);
                this.clearMetadataOverride();
                this.clearDyeColorOverride();
                this.suppressDyeColor = true;
                this.suppressOverlay = true;
                this.suppressPattern = true;
                this.setMetadataOverride(0);
                renderBlocks._a(0.0625, 0.3125, bl5 ? 0.0 : 0.0625, 1.0, 0.5625, bl4 ? 1.0 : 0.9375);
                this.renderStandardBlock(tECarpentersBlock, renderBlocks, Block.cloth, block2, n, n2, n3);
                this.clearMetadataOverride();
                if (!bl3) {
                    this.setMetadataOverride(n7);
                    renderBlocks._a(0.0, bl2 ? 0.4375 : 0.3125, 0.0, 1.0, bl2 ? 0.8125 : 0.5625, 0.0625);
                    this.renderStandardBlock(tECarpentersBlock, renderBlocks, Block.cloth, block2, n, n2, n3);
                    renderBlocks._a(0.0, bl2 ? 0.8125 : 0.5625, 0.0, 1.0, bl2 ? 0.875 : 0.625, 1.0);
                    this.renderStandardBlock(tECarpentersBlock, renderBlocks, Block.cloth, block2, n, n2, n3);
                    renderBlocks._a(0.0, bl2 ? 0.4375 : 0.3125, 0.9375, 1.0, bl2 ? 0.8125 : 0.5625, 1.0);
                    this.renderStandardBlock(tECarpentersBlock, renderBlocks, Block.cloth, block2, n, n2, n3);
                    renderBlocks._a(0.0, bl2 ? 0.4375 : 0.3125, 0.0625, 0.0625, bl2 ? 0.8125 : 0.5625, 0.9375);
                    this.renderStandardBlock(tECarpentersBlock, renderBlocks, Block.cloth, block2, n, n2, n3);
                    this.clearMetadataOverride();
                }
                this.suppressDyeColor = false;
                this.suppressOverlay = false;
                this.suppressPattern = false;
                break;
            }
            default: {
                if (bl) {
                    this.setMetadataOverride(BlockProperties.getCoverMetadata(tECarpentersBlock, 6));
                    renderBlocks._a(0.0, 0.1875, 0.125, 0.125, 0.875, 0.875);
                    this.renderStandardBlock(tECarpentersBlock, renderBlocks, block, block2, n, n2, n3);
                    renderBlocks._a(0.0, bl5 ? 0.1875 : 0.0, 0.0, 0.125, bl5 ? 0.875 : 1.0, 0.125);
                    this.renderStandardBlock(tECarpentersBlock, renderBlocks, block, block2, n, n2, n3);
                    renderBlocks._a(0.0, bl4 ? 0.1875 : 0.0, 0.875, 0.125, bl4 ? 0.875 : 1.0, 1.0);
                    this.renderStandardBlock(tECarpentersBlock, renderBlocks, block, block2, n, n2, n3);
                    renderBlocks._a(0.125, 0.1875, 0.0, 1.0, 0.3125, 1.0);
                    this.renderStandardBlock(tECarpentersBlock, renderBlocks, block, block2, n, n2, n3);
                    this.clearMetadataOverride();
                    this.suppressDyeColor = true;
                    this.suppressOverlay = true;
                    this.suppressPattern = true;
                    this.setMetadataOverride(0);
                    renderBlocks._a(0.125, 0.3125, bl5 ? 0.0 : 0.0625, 1.0, 0.5625, bl4 ? 1.0 : 0.9375);
                    this.renderStandardBlock(tECarpentersBlock, renderBlocks, Block.cloth, block2, n, n2, n3);
                    this.clearMetadataOverride();
                    renderBlocks._u = 3;
                    this.setIconOverride(6, icon);
                    renderBlocks._a(0.1875, 0.5625, 0.125, 0.5625, 0.6875, 0.875);
                    this.renderStandardBlock(tECarpentersBlock, renderBlocks, Block.cloth, block2, n, n2, n3);
                    this.clearIconOverride(6);
                    renderBlocks._u = 0;
                    if (!bl3) {
                        this.setMetadataOverride(n7);
                        renderBlocks._a(0.5, bl2 ? 0.4375 : 0.3125, 0.0, 1.0, bl2 ? 0.8125 : 0.5625, 0.0625);
                        this.renderStandardBlock(tECarpentersBlock, renderBlocks, Block.cloth, block2, n, n2, n3);
                        renderBlocks._a(0.5, bl2 ? 0.8125 : 0.5625, 0.0, 1.0, bl2 ? 0.875 : 0.625, 1.0);
                        this.renderStandardBlock(tECarpentersBlock, renderBlocks, Block.cloth, block2, n, n2, n3);
                        renderBlocks._a(0.5, bl2 ? 0.4375 : 0.3125, 0.9375, 1.0, bl2 ? 0.8125 : 0.5625, 1.0);
                        this.renderStandardBlock(tECarpentersBlock, renderBlocks, Block.cloth, block2, n, n2, n3);
                        this.clearMetadataOverride();
                    }
                    this.suppressDyeColor = false;
                    this.suppressOverlay = false;
                    this.suppressPattern = false;
                    break;
                }
                this.setDyeColorOverride(n8);
                this.setMetadataOverride(BlockProperties.getCoverMetadata(tECarpentersBlock, 6));
                if (!bl5) {
                    renderBlocks._a(0.875, 0.0, 0.0, 1.0, 0.1875, 0.125);
                    this.renderStandardBlock(tECarpentersBlock, renderBlocks, block, block2, n, n2, n3);
                }
                if (!bl4) {
                    renderBlocks._a(0.875, 0.0, 0.875, 1.0, 0.1875, 1.0);
                    this.renderStandardBlock(tECarpentersBlock, renderBlocks, block, block2, n, n2, n3);
                }
                renderBlocks._a(0.0, 0.1875, 0.0, 1.0, 0.3125, 1.0);
                this.renderStandardBlock(tECarpentersBlock, renderBlocks, block, block2, n, n2, n3);
                this.clearMetadataOverride();
                this.clearDyeColorOverride();
                this.suppressDyeColor = true;
                this.suppressOverlay = true;
                this.suppressPattern = true;
                this.setMetadataOverride(0);
                renderBlocks._a(0.0, 0.3125, bl5 ? 0.0 : 0.0625, 0.9375, 0.5625, bl4 ? 1.0 : 0.9375);
                this.renderStandardBlock(tECarpentersBlock, renderBlocks, Block.cloth, block2, n, n2, n3);
                this.clearMetadataOverride();
                if (!bl3) {
                    this.setMetadataOverride(n7);
                    renderBlocks._a(0.0, bl2 ? 0.4375 : 0.3125, 0.0, 1.0, bl2 ? 0.8125 : 0.5625, 0.0625);
                    this.renderStandardBlock(tECarpentersBlock, renderBlocks, Block.cloth, block2, n, n2, n3);
                    renderBlocks._a(0.0, bl2 ? 0.8125 : 0.5625, 0.0, 1.0, bl2 ? 0.875 : 0.625, 1.0);
                    this.renderStandardBlock(tECarpentersBlock, renderBlocks, Block.cloth, block2, n, n2, n3);
                    renderBlocks._a(0.0, bl2 ? 0.4375 : 0.3125, 0.9375, 1.0, bl2 ? 0.8125 : 0.5625, 1.0);
                    this.renderStandardBlock(tECarpentersBlock, renderBlocks, Block.cloth, block2, n, n2, n3);
                    renderBlocks._a(0.9375, bl2 ? 0.4375 : 0.3125, 0.0625, 1.0, bl2 ? 0.8125 : 0.5625, 0.9375);
                    this.renderStandardBlock(tECarpentersBlock, renderBlocks, Block.cloth, block2, n, n2, n3);
                    this.clearMetadataOverride();
                }
                this.suppressDyeColor = false;
                this.suppressOverlay = false;
                this.suppressPattern = false;
            }
        }
        if (bl3) {
            this.setMetadataOverride(n7);
            this.suppressDyeColor = true;
            this.suppressOverlay = true;
            this.suppressPattern = true;
            if (bl) {
                switch (NamelessClass766008257.$SwitchMap$net$minecraftforge$common$ForgeDirection[forgeDirection.ordinal()]) {
                    case 1: {
                        renderBlocks._a(0.0, bl2 ? 0.4375 : 0.3125, 0.0, 1.0, bl2 ? 0.875 : 0.625, 0.5);
                        this.prepareRender(tECarpentersBlock, renderBlocks, Block.cloth, block2, 3, n, n2, n3, 0.8f);
                        break;
                    }
                    case 2: {
                        renderBlocks._a(0.0, bl2 ? 0.4375 : 0.3125, 0.5, 1.0, bl2 ? 0.875 : 0.625, 1.0);
                        this.prepareRender(tECarpentersBlock, renderBlocks, Block.cloth, block2, 2, n, n2, n3, 0.8f);
                        break;
                    }
                    case 3: {
                        renderBlocks._a(0.0, bl2 ? 0.4375 : 0.3125, 0.0, 0.5, bl2 ? 0.875 : 0.625, 1.0);
                        this.prepareRender(tECarpentersBlock, renderBlocks, Block.cloth, block2, 5, n, n2, n3, 0.6f);
                        break;
                    }
                    default: {
                        renderBlocks._a(0.5, bl2 ? 0.4375 : 0.3125, 0.0, 1.0, bl2 ? 0.875 : 0.625, 1.0);
                        this.prepareRender(tECarpentersBlock, renderBlocks, Block.cloth, block2, 4, n, n2, n3, 0.6f);
                    }
                }
                this.prepareRender(tECarpentersBlock, renderBlocks, Block.cloth, block2, 0, n, n2, n3, 0.5f);
            } else {
                this.prepareRender(tECarpentersBlock, renderBlocks, Block.cloth, block2, 0, n, n2, n3, 0.5f);
            }
            this.suppressDyeColor = false;
            this.suppressOverlay = false;
            this.suppressPattern = false;
            this.clearMetadataOverride();
        }
        this.disableAO = false;
        return true;
    }

    static class NamelessClass766008257 {
        static final int[] $SwitchMap$net$minecraftforge$common$ForgeDirection = new int[ForgeDirection.values().length];

        NamelessClass766008257() {
        }

        static {
            try {
                NamelessClass766008257.$SwitchMap$net$minecraftforge$common$ForgeDirection[ForgeDirection.NORTH.ordinal()] = 1;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            try {
                NamelessClass766008257.$SwitchMap$net$minecraftforge$common$ForgeDirection[ForgeDirection.SOUTH.ordinal()] = 2;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            try {
                NamelessClass766008257.$SwitchMap$net$minecraftforge$common$ForgeDirection[ForgeDirection.WEST.ordinal()] = 3;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
        }
    }
}

