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
import net.minecraft.util.dwan;
import net.minecraftforge.common.ForgeDirection;

public class BlockHandlerCarpentersBed
extends BlockHandlerBase {
    @Override
    public boolean renderCarpentersBlock(TECarpentersBlock tECarpentersBlock, htvc htvc2, twgu twgu2, int n, int n2, int n3, int n4) {
        twgu twgu3 = BlockProperties.getCoverBlock(tECarpentersBlock, 6);
        this.renderNormalBed(tECarpentersBlock, htvc2, twgu3, twgu2, n2, n3, n4);
        return this.shouldRenderBlock(tECarpentersBlock, htvc2, twgu3, twgu2, n);
    }

    public boolean renderNormalBed(TECarpentersBlock tECarpentersBlock, htvc htvc2, twgu twgu2, twgu twgu3, int n, int n2, int n3) {
        int n4;
        int n5 = BlockProperties.getData(tECarpentersBlock);
        int n6 = htvc2._a.func_72805_g(n, n2, n3);
        this.disableAO = true;
        boolean bl = gqbt._a(n6);
        ForgeDirection forgeDirection = Bed.getDirection(n6 & 3);
        TECarpentersBlock tECarpentersBlock2 = Bed.getOppositeTE(htvc2._a, n, n2, n3);
        boolean bl2 = Bed.isOccupied(tECarpentersBlock);
        int n7 = 0;
        int n8 = 0;
        if (tECarpentersBlock2 != null) {
            bl2 |= Bed.isOccupied(tECarpentersBlock2);
            n7 = BlockProperties.getDyeColor(bl ? tECarpentersBlock2 : tECarpentersBlock, 6);
            n8 = BlockProperties.getDyeColor(bl ? tECarpentersBlock : tECarpentersBlock2, 6);
        }
        boolean bl3 = (n4 = Bed.getDesign(n5)) > 0 && BedDesignHandler.hasBlanket[n4];
        dwan dwan2 = bl3 && BedDesignHandler.hasPillow[n4] ? IconHandler.icon_bed_pillow_custom[n4] : IconHandler.icon_bed_pillow;
        boolean bl4 = false;
        boolean bl5 = false;
        if (!forgeDirection.equals((Object)ForgeDirection.NORTH) && !forgeDirection.equals((Object)ForgeDirection.SOUTH)) {
            if (htvc2._a.func_72798_a(n, n2, n3 + 1) == twgu3.field_71990_ca) {
                boolean bl6 = bl4 = (n6 & 0xFFFFFFFB) == (htvc2._a.func_72805_g(n, n2, n3 + 1) & 0xFFFFFFFB);
            }
            if (htvc2._a.func_72798_a(n, n2, n3 - 1) == twgu3.field_71990_ca) {
                bl5 = (n6 & 0xFFFFFFFB) == (htvc2._a.func_72805_g(n, n2, n3 - 1) & 0xFFFFFFFB);
            }
        } else {
            if (htvc2._a.func_72798_a(n + 1, n2, n3) == twgu3.field_71990_ca) {
                boolean bl7 = bl4 = (n6 & 0xFFFFFFFB) == (htvc2._a.func_72805_g(n + 1, n2, n3) & 0xFFFFFFFB);
            }
            if (htvc2._a.func_72798_a(n - 1, n2, n3) == twgu3.field_71990_ca) {
                bl5 = (n6 & 0xFFFFFFFB) == (htvc2._a.func_72805_g(n - 1, n2, n3) & 0xFFFFFFFB);
            }
        }
        switch (NamelessClass766008257.$SwitchMap$net$minecraftforge$common$ForgeDirection[forgeDirection.ordinal()]) {
            case 1: {
                if (bl) {
                    this.setMetadataOverride(BlockProperties.getCoverMetadata(tECarpentersBlock, 6));
                    htvc2._a(0.125, 0.1875, 0.875, 0.875, 0.875, 1.0);
                    this.renderStandardBlock(tECarpentersBlock, htvc2, twgu2, twgu3, n, n2, n3);
                    htvc2._a(0.0, bl5 ? 0.1875 : 0.0, 0.875, 0.125, bl5 ? 0.875 : 1.0, 1.0);
                    this.renderStandardBlock(tECarpentersBlock, htvc2, twgu2, twgu3, n, n2, n3);
                    htvc2._a(0.875, bl4 ? 0.1875 : 0.0, 0.875, 1.0, bl4 ? 0.875 : 1.0, 1.0);
                    this.renderStandardBlock(tECarpentersBlock, htvc2, twgu2, twgu3, n, n2, n3);
                    htvc2._a(0.0, 0.1875, 0.0, 1.0, 0.3125, 0.875);
                    this.renderStandardBlock(tECarpentersBlock, htvc2, twgu2, twgu3, n, n2, n3);
                    this.clearMetadataOverride();
                    this.suppressDyeColor = true;
                    this.suppressOverlay = true;
                    this.suppressPattern = true;
                    this.setMetadataOverride(0);
                    htvc2._a(bl5 ? 0.0 : 0.0625, 0.3125, 0.0, bl4 ? 1.0 : 0.9375, 0.5625, 0.875);
                    this.renderStandardBlock(tECarpentersBlock, htvc2, twgu.field_72101_ab, twgu3, n, n2, n3);
                    this.clearMetadataOverride();
                    htvc2._u = 2;
                    this.setIconOverride(6, dwan2);
                    htvc2._a(0.125, 0.5625, 0.4375, 0.875, 0.6875, 0.8125);
                    this.renderStandardBlock(tECarpentersBlock, htvc2, twgu.field_72101_ab, twgu3, n, n2, n3);
                    this.clearIconOverride(6);
                    htvc2._u = 0;
                    if (!bl3) {
                        this.setMetadataOverride(n7);
                        htvc2._a(0.0, bl2 ? 0.4375 : 0.3125, 0.0, 0.0625, bl2 ? 0.8125 : 0.5625, 0.5);
                        this.renderStandardBlock(tECarpentersBlock, htvc2, twgu.field_72101_ab, twgu3, n, n2, n3);
                        htvc2._a(0.0, bl2 ? 0.8125 : 0.5625, 0.0, 1.0, bl2 ? 0.875 : 0.625, 0.5);
                        this.renderStandardBlock(tECarpentersBlock, htvc2, twgu.field_72101_ab, twgu3, n, n2, n3);
                        htvc2._a(0.9375, bl2 ? 0.4375 : 0.3125, 0.0, 1.0, bl2 ? 0.8125 : 0.5625, 0.5);
                        this.renderStandardBlock(tECarpentersBlock, htvc2, twgu.field_72101_ab, twgu3, n, n2, n3);
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
                    htvc2._a(0.0, 0.0, 0.0, 0.125, 0.1875, 0.125);
                    this.renderStandardBlock(tECarpentersBlock, htvc2, twgu2, twgu3, n, n2, n3);
                }
                if (!bl4) {
                    htvc2._a(0.875, 0.0, 0.0, 1.0, 0.1875, 0.125);
                    this.renderStandardBlock(tECarpentersBlock, htvc2, twgu2, twgu3, n, n2, n3);
                }
                htvc2._a(0.0, 0.1875, 0.0, 1.0, 0.3125, 1.0);
                this.renderStandardBlock(tECarpentersBlock, htvc2, twgu2, twgu3, n, n2, n3);
                this.clearMetadataOverride();
                this.clearDyeColorOverride();
                this.suppressDyeColor = true;
                this.suppressOverlay = true;
                this.suppressPattern = true;
                this.setMetadataOverride(0);
                htvc2._a(bl5 ? 0.0 : 0.0625, 0.3125, 0.0625, bl4 ? 1.0 : 0.9375, 0.5625, 1.0);
                this.renderStandardBlock(tECarpentersBlock, htvc2, twgu.field_72101_ab, twgu3, n, n2, n3);
                this.clearMetadataOverride();
                if (!bl3) {
                    this.setMetadataOverride(n7);
                    htvc2._a(0.0, bl2 ? 0.4375 : 0.3125, 0.0, 0.0625, bl2 ? 0.8125 : 0.5625, 1.0);
                    this.renderStandardBlock(tECarpentersBlock, htvc2, twgu.field_72101_ab, twgu3, n, n2, n3);
                    htvc2._a(0.0, bl2 ? 0.8125 : 0.5625, 0.0, 1.0, bl2 ? 0.875 : 0.625, 1.0);
                    this.renderStandardBlock(tECarpentersBlock, htvc2, twgu.field_72101_ab, twgu3, n, n2, n3);
                    htvc2._a(0.9375, bl2 ? 0.4375 : 0.3125, 0.0, 1.0, bl2 ? 0.8125 : 0.5625, 1.0);
                    this.renderStandardBlock(tECarpentersBlock, htvc2, twgu.field_72101_ab, twgu3, n, n2, n3);
                    htvc2._a(0.0625, bl2 ? 0.4375 : 0.3125, 0.0, 0.9375, bl2 ? 0.8125 : 0.5625, 0.0625);
                    this.renderStandardBlock(tECarpentersBlock, htvc2, twgu.field_72101_ab, twgu3, n, n2, n3);
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
                    htvc2._a(0.125, 0.1875, 0.0, 0.875, 0.875, 0.125);
                    this.renderStandardBlock(tECarpentersBlock, htvc2, twgu2, twgu3, n, n2, n3);
                    htvc2._a(0.0, bl5 ? 0.1875 : 0.0, 0.0, 0.125, bl5 ? 0.875 : 1.0, 0.125);
                    this.renderStandardBlock(tECarpentersBlock, htvc2, twgu2, twgu3, n, n2, n3);
                    htvc2._a(0.875, bl4 ? 0.1875 : 0.0, 0.0, 1.0, bl4 ? 0.875 : 1.0, 0.125);
                    this.renderStandardBlock(tECarpentersBlock, htvc2, twgu2, twgu3, n, n2, n3);
                    htvc2._a(0.0, 0.1875, 0.125, 1.0, 0.3125, 1.0);
                    this.renderStandardBlock(tECarpentersBlock, htvc2, twgu2, twgu3, n, n2, n3);
                    this.clearMetadataOverride();
                    this.suppressDyeColor = true;
                    this.suppressOverlay = true;
                    this.suppressPattern = true;
                    this.setMetadataOverride(0);
                    htvc2._a(bl5 ? 0.0 : 0.0625, 0.3125, 0.125, bl4 ? 1.0 : 0.9375, 0.5625, 1.0);
                    this.renderStandardBlock(tECarpentersBlock, htvc2, twgu.field_72101_ab, twgu3, n, n2, n3);
                    this.clearMetadataOverride();
                    this.setIconOverride(6, dwan2);
                    htvc2._a(0.125, 0.5625, 0.1875, 0.875, 0.6875, 0.5625);
                    this.renderStandardBlock(tECarpentersBlock, htvc2, twgu.field_72101_ab, twgu3, n, n2, n3);
                    this.clearIconOverride(6);
                    htvc2._u = 0;
                    if (!bl3) {
                        this.setMetadataOverride(n7);
                        htvc2._a(0.0, bl2 ? 0.4375 : 0.3125, 0.5, 0.0625, bl2 ? 0.8125 : 0.5625, 1.0);
                        this.renderStandardBlock(tECarpentersBlock, htvc2, twgu.field_72101_ab, twgu3, n, n2, n3);
                        htvc2._a(0.0, bl2 ? 0.8125 : 0.5625, 0.5, 1.0, bl2 ? 0.875 : 0.625, 1.0);
                        this.renderStandardBlock(tECarpentersBlock, htvc2, twgu.field_72101_ab, twgu3, n, n2, n3);
                        htvc2._a(0.9375, bl2 ? 0.4375 : 0.3125, 0.5, 1.0, bl2 ? 0.8125 : 0.5625, 1.0);
                        this.renderStandardBlock(tECarpentersBlock, htvc2, twgu.field_72101_ab, twgu3, n, n2, n3);
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
                    htvc2._a(0.0, 0.0, 0.875, 0.125, 0.1875, 1.0);
                    this.renderStandardBlock(tECarpentersBlock, htvc2, twgu2, twgu3, n, n2, n3);
                }
                if (!bl4) {
                    htvc2._a(0.875, 0.0, 0.875, 1.0, 0.1875, 1.0);
                    this.renderStandardBlock(tECarpentersBlock, htvc2, twgu2, twgu3, n, n2, n3);
                }
                htvc2._a(0.0, 0.1875, 0.0, 1.0, 0.3125, 1.0);
                this.renderStandardBlock(tECarpentersBlock, htvc2, twgu2, twgu3, n, n2, n3);
                this.clearMetadataOverride();
                this.clearDyeColorOverride();
                this.suppressDyeColor = true;
                this.suppressOverlay = true;
                this.suppressPattern = true;
                this.setMetadataOverride(0);
                htvc2._a(bl5 ? 0.0 : 0.0625, 0.3125, 0.0, bl4 ? 1.0 : 0.9375, 0.5625, 0.9375);
                this.renderStandardBlock(tECarpentersBlock, htvc2, twgu.field_72101_ab, twgu3, n, n2, n3);
                this.clearMetadataOverride();
                if (!bl3) {
                    this.setMetadataOverride(n7);
                    htvc2._a(0.0, bl2 ? 0.4375 : 0.3125, 0.0, 0.0625, bl2 ? 0.8125 : 0.5625, 1.0);
                    this.renderStandardBlock(tECarpentersBlock, htvc2, twgu.field_72101_ab, twgu3, n, n2, n3);
                    htvc2._a(0.0, bl2 ? 0.8125 : 0.5625, 0.0, 1.0, bl2 ? 0.875 : 0.625, 1.0);
                    this.renderStandardBlock(tECarpentersBlock, htvc2, twgu.field_72101_ab, twgu3, n, n2, n3);
                    htvc2._a(0.9375, bl2 ? 0.4375 : 0.3125, 0.0, 1.0, bl2 ? 0.8125 : 0.5625, 1.0);
                    this.renderStandardBlock(tECarpentersBlock, htvc2, twgu.field_72101_ab, twgu3, n, n2, n3);
                    htvc2._a(0.0625, bl2 ? 0.4375 : 0.3125, 0.9375, 0.9375, bl2 ? 0.8125 : 0.5625, 1.0);
                    this.renderStandardBlock(tECarpentersBlock, htvc2, twgu.field_72101_ab, twgu3, n, n2, n3);
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
                    htvc2._a(0.875, 0.1875, 0.125, 1.0, 0.875, 0.875);
                    this.renderStandardBlock(tECarpentersBlock, htvc2, twgu2, twgu3, n, n2, n3);
                    htvc2._a(0.875, bl5 ? 0.1875 : 0.0, 0.0, 1.0, bl5 ? 0.875 : 1.0, 0.125);
                    this.renderStandardBlock(tECarpentersBlock, htvc2, twgu2, twgu3, n, n2, n3);
                    htvc2._a(0.875, bl4 ? 0.1875 : 0.0, 0.875, 1.0, bl4 ? 0.875 : 1.0, 1.0);
                    this.renderStandardBlock(tECarpentersBlock, htvc2, twgu2, twgu3, n, n2, n3);
                    htvc2._a(0.0, 0.1875, 0.0, 0.875, 0.3125, 1.0);
                    this.renderStandardBlock(tECarpentersBlock, htvc2, twgu2, twgu3, n, n2, n3);
                    this.clearMetadataOverride();
                    this.suppressDyeColor = true;
                    this.suppressOverlay = true;
                    this.suppressPattern = true;
                    this.setMetadataOverride(0);
                    htvc2._a(0.0, 0.3125, bl5 ? 0.0 : 0.0625, 0.875, 0.5625, bl4 ? 1.0 : 0.9375);
                    this.renderStandardBlock(tECarpentersBlock, htvc2, twgu.field_72101_ab, twgu3, n, n2, n3);
                    this.clearMetadataOverride();
                    htvc2._u = 1;
                    this.setIconOverride(6, dwan2);
                    htvc2._a(0.4375, 0.5625, 0.125, 0.8125, 0.6875, 0.875);
                    this.renderStandardBlock(tECarpentersBlock, htvc2, twgu.field_72101_ab, twgu3, n, n2, n3);
                    this.clearIconOverride(6);
                    htvc2._u = 0;
                    if (!bl3) {
                        this.setMetadataOverride(n7);
                        htvc2._a(0.0, bl2 ? 0.4375 : 0.3125, 0.0, 0.5, bl2 ? 0.8125 : 0.5625, 0.0625);
                        this.renderStandardBlock(tECarpentersBlock, htvc2, twgu.field_72101_ab, twgu3, n, n2, n3);
                        htvc2._a(0.0, bl2 ? 0.8125 : 0.5625, 0.0, 0.5, bl2 ? 0.875 : 0.625, 1.0);
                        this.renderStandardBlock(tECarpentersBlock, htvc2, twgu.field_72101_ab, twgu3, n, n2, n3);
                        htvc2._a(0.0, bl2 ? 0.4375 : 0.3125, 0.9375, 0.5, bl2 ? 0.8125 : 0.5625, 1.0);
                        this.renderStandardBlock(tECarpentersBlock, htvc2, twgu.field_72101_ab, twgu3, n, n2, n3);
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
                    htvc2._a(0.0, 0.0, 0.0, 0.125, 0.1875, 0.125);
                    this.renderStandardBlock(tECarpentersBlock, htvc2, twgu2, twgu3, n, n2, n3);
                }
                if (!bl4) {
                    htvc2._a(0.0, 0.0, 0.875, 0.125, 0.1875, 1.0);
                    this.renderStandardBlock(tECarpentersBlock, htvc2, twgu2, twgu3, n, n2, n3);
                }
                htvc2._a(0.0, 0.1875, 0.0, 1.0, 0.3125, 1.0);
                this.renderStandardBlock(tECarpentersBlock, htvc2, twgu2, twgu3, n, n2, n3);
                this.clearMetadataOverride();
                this.clearDyeColorOverride();
                this.suppressDyeColor = true;
                this.suppressOverlay = true;
                this.suppressPattern = true;
                this.setMetadataOverride(0);
                htvc2._a(0.0625, 0.3125, bl5 ? 0.0 : 0.0625, 1.0, 0.5625, bl4 ? 1.0 : 0.9375);
                this.renderStandardBlock(tECarpentersBlock, htvc2, twgu.field_72101_ab, twgu3, n, n2, n3);
                this.clearMetadataOverride();
                if (!bl3) {
                    this.setMetadataOverride(n7);
                    htvc2._a(0.0, bl2 ? 0.4375 : 0.3125, 0.0, 1.0, bl2 ? 0.8125 : 0.5625, 0.0625);
                    this.renderStandardBlock(tECarpentersBlock, htvc2, twgu.field_72101_ab, twgu3, n, n2, n3);
                    htvc2._a(0.0, bl2 ? 0.8125 : 0.5625, 0.0, 1.0, bl2 ? 0.875 : 0.625, 1.0);
                    this.renderStandardBlock(tECarpentersBlock, htvc2, twgu.field_72101_ab, twgu3, n, n2, n3);
                    htvc2._a(0.0, bl2 ? 0.4375 : 0.3125, 0.9375, 1.0, bl2 ? 0.8125 : 0.5625, 1.0);
                    this.renderStandardBlock(tECarpentersBlock, htvc2, twgu.field_72101_ab, twgu3, n, n2, n3);
                    htvc2._a(0.0, bl2 ? 0.4375 : 0.3125, 0.0625, 0.0625, bl2 ? 0.8125 : 0.5625, 0.9375);
                    this.renderStandardBlock(tECarpentersBlock, htvc2, twgu.field_72101_ab, twgu3, n, n2, n3);
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
                    htvc2._a(0.0, 0.1875, 0.125, 0.125, 0.875, 0.875);
                    this.renderStandardBlock(tECarpentersBlock, htvc2, twgu2, twgu3, n, n2, n3);
                    htvc2._a(0.0, bl5 ? 0.1875 : 0.0, 0.0, 0.125, bl5 ? 0.875 : 1.0, 0.125);
                    this.renderStandardBlock(tECarpentersBlock, htvc2, twgu2, twgu3, n, n2, n3);
                    htvc2._a(0.0, bl4 ? 0.1875 : 0.0, 0.875, 0.125, bl4 ? 0.875 : 1.0, 1.0);
                    this.renderStandardBlock(tECarpentersBlock, htvc2, twgu2, twgu3, n, n2, n3);
                    htvc2._a(0.125, 0.1875, 0.0, 1.0, 0.3125, 1.0);
                    this.renderStandardBlock(tECarpentersBlock, htvc2, twgu2, twgu3, n, n2, n3);
                    this.clearMetadataOverride();
                    this.suppressDyeColor = true;
                    this.suppressOverlay = true;
                    this.suppressPattern = true;
                    this.setMetadataOverride(0);
                    htvc2._a(0.125, 0.3125, bl5 ? 0.0 : 0.0625, 1.0, 0.5625, bl4 ? 1.0 : 0.9375);
                    this.renderStandardBlock(tECarpentersBlock, htvc2, twgu.field_72101_ab, twgu3, n, n2, n3);
                    this.clearMetadataOverride();
                    htvc2._u = 3;
                    this.setIconOverride(6, dwan2);
                    htvc2._a(0.1875, 0.5625, 0.125, 0.5625, 0.6875, 0.875);
                    this.renderStandardBlock(tECarpentersBlock, htvc2, twgu.field_72101_ab, twgu3, n, n2, n3);
                    this.clearIconOverride(6);
                    htvc2._u = 0;
                    if (!bl3) {
                        this.setMetadataOverride(n7);
                        htvc2._a(0.5, bl2 ? 0.4375 : 0.3125, 0.0, 1.0, bl2 ? 0.8125 : 0.5625, 0.0625);
                        this.renderStandardBlock(tECarpentersBlock, htvc2, twgu.field_72101_ab, twgu3, n, n2, n3);
                        htvc2._a(0.5, bl2 ? 0.8125 : 0.5625, 0.0, 1.0, bl2 ? 0.875 : 0.625, 1.0);
                        this.renderStandardBlock(tECarpentersBlock, htvc2, twgu.field_72101_ab, twgu3, n, n2, n3);
                        htvc2._a(0.5, bl2 ? 0.4375 : 0.3125, 0.9375, 1.0, bl2 ? 0.8125 : 0.5625, 1.0);
                        this.renderStandardBlock(tECarpentersBlock, htvc2, twgu.field_72101_ab, twgu3, n, n2, n3);
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
                    htvc2._a(0.875, 0.0, 0.0, 1.0, 0.1875, 0.125);
                    this.renderStandardBlock(tECarpentersBlock, htvc2, twgu2, twgu3, n, n2, n3);
                }
                if (!bl4) {
                    htvc2._a(0.875, 0.0, 0.875, 1.0, 0.1875, 1.0);
                    this.renderStandardBlock(tECarpentersBlock, htvc2, twgu2, twgu3, n, n2, n3);
                }
                htvc2._a(0.0, 0.1875, 0.0, 1.0, 0.3125, 1.0);
                this.renderStandardBlock(tECarpentersBlock, htvc2, twgu2, twgu3, n, n2, n3);
                this.clearMetadataOverride();
                this.clearDyeColorOverride();
                this.suppressDyeColor = true;
                this.suppressOverlay = true;
                this.suppressPattern = true;
                this.setMetadataOverride(0);
                htvc2._a(0.0, 0.3125, bl5 ? 0.0 : 0.0625, 0.9375, 0.5625, bl4 ? 1.0 : 0.9375);
                this.renderStandardBlock(tECarpentersBlock, htvc2, twgu.field_72101_ab, twgu3, n, n2, n3);
                this.clearMetadataOverride();
                if (!bl3) {
                    this.setMetadataOverride(n7);
                    htvc2._a(0.0, bl2 ? 0.4375 : 0.3125, 0.0, 1.0, bl2 ? 0.8125 : 0.5625, 0.0625);
                    this.renderStandardBlock(tECarpentersBlock, htvc2, twgu.field_72101_ab, twgu3, n, n2, n3);
                    htvc2._a(0.0, bl2 ? 0.8125 : 0.5625, 0.0, 1.0, bl2 ? 0.875 : 0.625, 1.0);
                    this.renderStandardBlock(tECarpentersBlock, htvc2, twgu.field_72101_ab, twgu3, n, n2, n3);
                    htvc2._a(0.0, bl2 ? 0.4375 : 0.3125, 0.9375, 1.0, bl2 ? 0.8125 : 0.5625, 1.0);
                    this.renderStandardBlock(tECarpentersBlock, htvc2, twgu.field_72101_ab, twgu3, n, n2, n3);
                    htvc2._a(0.9375, bl2 ? 0.4375 : 0.3125, 0.0625, 1.0, bl2 ? 0.8125 : 0.5625, 0.9375);
                    this.renderStandardBlock(tECarpentersBlock, htvc2, twgu.field_72101_ab, twgu3, n, n2, n3);
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
                        htvc2._a(0.0, bl2 ? 0.4375 : 0.3125, 0.0, 1.0, bl2 ? 0.875 : 0.625, 0.5);
                        this.prepareRender(tECarpentersBlock, htvc2, twgu.field_72101_ab, twgu3, 3, n, n2, n3, 0.8f);
                        break;
                    }
                    case 2: {
                        htvc2._a(0.0, bl2 ? 0.4375 : 0.3125, 0.5, 1.0, bl2 ? 0.875 : 0.625, 1.0);
                        this.prepareRender(tECarpentersBlock, htvc2, twgu.field_72101_ab, twgu3, 2, n, n2, n3, 0.8f);
                        break;
                    }
                    case 3: {
                        htvc2._a(0.0, bl2 ? 0.4375 : 0.3125, 0.0, 0.5, bl2 ? 0.875 : 0.625, 1.0);
                        this.prepareRender(tECarpentersBlock, htvc2, twgu.field_72101_ab, twgu3, 5, n, n2, n3, 0.6f);
                        break;
                    }
                    default: {
                        htvc2._a(0.5, bl2 ? 0.4375 : 0.3125, 0.0, 1.0, bl2 ? 0.875 : 0.625, 1.0);
                        this.prepareRender(tECarpentersBlock, htvc2, twgu.field_72101_ab, twgu3, 4, n, n2, n3, 0.6f);
                    }
                }
                this.prepareRender(tECarpentersBlock, htvc2, twgu.field_72101_ab, twgu3, 0, n, n2, n3, 0.5f);
            } else {
                this.prepareRender(tECarpentersBlock, htvc2, twgu.field_72101_ab, twgu3, 0, n, n2, n3, 0.5f);
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

