/*
 * Decompiled with CFR 0.152.
 */
package carpentersblocks.renderer.tileentity;

import carpentersblocks.data.Bed;
import carpentersblocks.renderer.helper.BedDesignHelper;
import carpentersblocks.tileentity.TECarpentersBlock;
import carpentersblocks.util.BlockProperties;
import carpentersblocks.util.handler.BedDesignHandler;
import carpentersblocks.util.handler.BlockHandler;
import net.minecraft.block.Block;
import net.minecraft.block.BlockBed;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.ForgeDirection;
import org.lwjgl.opengl.GL11;

public class TERendererCarpentersBlock
extends TileEntitySpecialRenderer {
    private BedDesignHelper bedDesignHelper = new BedDesignHelper();

    @Override
    public void renderTileEntityAt(TileEntity tileEntity, double d, double d2, double d3, float f) {
        if (tileEntity.getBlockType() == BlockHandler.blockCarpentersBed) {
            this.renderBedDesignAt(tileEntity, d, d2, d3, f);
        }
    }

    private void renderBedDesignAt(TileEntity tileEntity, double d, double d2, double d3, float f) {
        TECarpentersBlock tECarpentersBlock = (TECarpentersBlock)tileEntity;
        int n = BlockProperties.getData(tECarpentersBlock);
        int n2 = tECarpentersBlock.worldObj.getBlockMetadata(tECarpentersBlock.xCoord, tECarpentersBlock.yCoord, tECarpentersBlock.zCoord);
        boolean bl = BlockBed._a(n2);
        TECarpentersBlock tECarpentersBlock2 = Bed.getOppositeTE(tECarpentersBlock.worldObj, tECarpentersBlock.xCoord, tECarpentersBlock.yCoord, tECarpentersBlock.zCoord);
        boolean bl2 = Bed.isOccupied(tECarpentersBlock);
        int n3 = Bed.getDesign(n);
        if (n3 != 0 && BedDesignHandler.hasBlanket[n3]) {
            RenderBlocks renderBlocks = new RenderBlocks();
            this.bindTexture(BedDesignHandler.resource_blanket[n3]);
            Tessellator tessellator = renderBlocks.__aF;
            tessellator.setBrightness(Block.dirt.getMixedBrightnessForBlock(tECarpentersBlock.worldObj, tECarpentersBlock.xCoord, tECarpentersBlock.yCoord, tECarpentersBlock.zCoord));
            tessellator.startDrawingQuads();
            GL11.glDisable(2896);
            ForgeDirection forgeDirection = Bed.getDirection(n2 & 3);
            if (bl) {
                switch (NamelessClass893865827.$SwitchMap$net$minecraftforge$common$ForgeDirection[forgeDirection.ordinal()]) {
                    case 1: {
                        renderBlocks._a(0.0, bl2 ? 0.4375 : 0.3125, 0.0, 1.0, bl2 ? 0.875 : 0.625, 0.5);
                        this.bedDesignHelper.renderFaceXNeg(renderBlocks, 4, d, d2, d3);
                        this.bedDesignHelper.renderFaceXPos(renderBlocks, 0, d, d2, d3);
                        break;
                    }
                    case 2: {
                        renderBlocks._u = 2;
                        renderBlocks._a(0.0, bl2 ? 0.4375 : 0.3125, 0.5, 1.0, bl2 ? 0.875 : 0.625, 1.0);
                        this.bedDesignHelper.renderFaceXNeg(renderBlocks, 0, d, d2, d3);
                        this.bedDesignHelper.renderFaceXPos(renderBlocks, 4, d, d2, d3);
                        break;
                    }
                    case 3: {
                        renderBlocks._u = 3;
                        renderBlocks._a(0.0, bl2 ? 0.4375 : 0.3125, 0.0, 0.5, bl2 ? 0.875 : 0.625, 1.0);
                        this.bedDesignHelper.renderFaceZNeg(renderBlocks, 0, d, d2, d3);
                        this.bedDesignHelper.renderFaceZPos(renderBlocks, 4, d, d2, d3);
                        break;
                    }
                    default: {
                        renderBlocks._u = 1;
                        renderBlocks._a(0.5, bl2 ? 0.4375 : 0.3125, 0.0, 1.0, bl2 ? 0.875 : 0.625, 1.0);
                        this.bedDesignHelper.renderFaceZNeg(renderBlocks, 4, d, d2, d3);
                        this.bedDesignHelper.renderFaceZPos(renderBlocks, 0, d, d2, d3);
                    }
                }
                this.bedDesignHelper.renderFaceYPos(renderBlocks, 5, d, d2, d3);
                renderBlocks._u = 0;
            } else {
                switch (NamelessClass893865827.$SwitchMap$net$minecraftforge$common$ForgeDirection[forgeDirection.ordinal()]) {
                    case 1: {
                        renderBlocks._a(0.0, bl2 ? 0.4375 : 0.3125, 0.0, 1.0, bl2 ? 0.875 : 0.625, 1.0);
                        this.bedDesignHelper.renderFaceXNeg(renderBlocks, 3, d, d2, d3);
                        this.bedDesignHelper.renderFaceXPos(renderBlocks, 1, d, d2, d3);
                        this.bedDesignHelper.renderFaceZNeg(renderBlocks, 2, d, d2, d3);
                        break;
                    }
                    case 2: {
                        renderBlocks._u = 2;
                        renderBlocks._a(0.0, bl2 ? 0.4375 : 0.3125, 0.0, 1.0, bl2 ? 0.875 : 0.625, 1.0);
                        this.bedDesignHelper.renderFaceXNeg(renderBlocks, 1, d, d2, d3);
                        this.bedDesignHelper.renderFaceXPos(renderBlocks, 3, d, d2, d3);
                        this.bedDesignHelper.renderFaceZPos(renderBlocks, 2, d, d2, d3);
                        break;
                    }
                    case 3: {
                        renderBlocks._u = 3;
                        renderBlocks._a(0.0, bl2 ? 0.4375 : 0.3125, 0.0, 1.0, bl2 ? 0.875 : 0.625, 1.0);
                        this.bedDesignHelper.renderFaceZNeg(renderBlocks, 1, d, d2, d3);
                        this.bedDesignHelper.renderFaceZPos(renderBlocks, 3, d, d2, d3);
                        this.bedDesignHelper.renderFaceXNeg(renderBlocks, 2, d, d2, d3);
                        break;
                    }
                    default: {
                        renderBlocks._u = 1;
                        renderBlocks._a(0.0, bl2 ? 0.4375 : 0.3125, 0.0, 1.0, bl2 ? 0.875 : 0.625, 1.0);
                        this.bedDesignHelper.renderFaceZNeg(renderBlocks, 3, d, d2, d3);
                        this.bedDesignHelper.renderFaceZPos(renderBlocks, 1, d, d2, d3);
                        this.bedDesignHelper.renderFaceXPos(renderBlocks, 2, d, d2, d3);
                    }
                }
                this.bedDesignHelper.renderFaceYPos(renderBlocks, 6, d, d2, d3);
                renderBlocks._u = 0;
            }
            renderBlocks.__aF.draw();
            GL11.glEnable(2896);
            this.bindTexture(sctd._c);
        }
    }

    static class NamelessClass893865827 {
        static final int[] $SwitchMap$net$minecraftforge$common$ForgeDirection = new int[ForgeDirection.values().length];

        NamelessClass893865827() {
        }

        static {
            try {
                NamelessClass893865827.$SwitchMap$net$minecraftforge$common$ForgeDirection[ForgeDirection.NORTH.ordinal()] = 1;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            try {
                NamelessClass893865827.$SwitchMap$net$minecraftforge$common$ForgeDirection[ForgeDirection.SOUTH.ordinal()] = 2;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            try {
                NamelessClass893865827.$SwitchMap$net$minecraftforge$common$ForgeDirection[ForgeDirection.WEST.ordinal()] = 3;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
        }
    }
}

