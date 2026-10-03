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
import net.minecraftforge.common.ForgeDirection;
import org.lwjgl.opengl.GL11;

public class TERendererCarpentersBlock
extends htys {
    private BedDesignHelper bedDesignHelper = new BedDesignHelper();

    @Override
    public void func_76894_a(hurg hurg2, double d, double d2, double d3, float f) {
        if (hurg2.func_70311_o() == BlockHandler.blockCarpentersBed) {
            this.renderBedDesignAt(hurg2, d, d2, d3, f);
        }
    }

    private void renderBedDesignAt(hurg hurg2, double d, double d2, double d3, float f) {
        TECarpentersBlock tECarpentersBlock = (TECarpentersBlock)hurg2;
        int n = BlockProperties.getData(tECarpentersBlock);
        int n2 = tECarpentersBlock.field_70331_k.func_72805_g(tECarpentersBlock.field_70329_l, tECarpentersBlock.field_70330_m, tECarpentersBlock.field_70327_n);
        boolean bl = gqbt._a(n2);
        TECarpentersBlock tECarpentersBlock2 = Bed.getOppositeTE(tECarpentersBlock.field_70331_k, tECarpentersBlock.field_70329_l, tECarpentersBlock.field_70330_m, tECarpentersBlock.field_70327_n);
        boolean bl2 = Bed.isOccupied(tECarpentersBlock);
        int n3 = Bed.getDesign(n);
        if (n3 != 0 && BedDesignHandler.hasBlanket[n3]) {
            htvc htvc2 = new htvc();
            this.func_110628_a(BedDesignHandler.resource_blanket[n3]);
            htvf htvf2 = htvc2.__aF;
            htvf2.func_78380_c(twgu.field_71979_v.func_71874_e(tECarpentersBlock.field_70331_k, tECarpentersBlock.field_70329_l, tECarpentersBlock.field_70330_m, tECarpentersBlock.field_70327_n));
            htvf2.func_78382_b();
            GL11.glDisable(2896);
            ForgeDirection forgeDirection = Bed.getDirection(n2 & 3);
            if (bl) {
                switch (NamelessClass893865827.$SwitchMap$net$minecraftforge$common$ForgeDirection[forgeDirection.ordinal()]) {
                    case 1: {
                        htvc2._a(0.0, bl2 ? 0.4375 : 0.3125, 0.0, 1.0, bl2 ? 0.875 : 0.625, 0.5);
                        this.bedDesignHelper.renderFaceXNeg(htvc2, 4, d, d2, d3);
                        this.bedDesignHelper.renderFaceXPos(htvc2, 0, d, d2, d3);
                        break;
                    }
                    case 2: {
                        htvc2._u = 2;
                        htvc2._a(0.0, bl2 ? 0.4375 : 0.3125, 0.5, 1.0, bl2 ? 0.875 : 0.625, 1.0);
                        this.bedDesignHelper.renderFaceXNeg(htvc2, 0, d, d2, d3);
                        this.bedDesignHelper.renderFaceXPos(htvc2, 4, d, d2, d3);
                        break;
                    }
                    case 3: {
                        htvc2._u = 3;
                        htvc2._a(0.0, bl2 ? 0.4375 : 0.3125, 0.0, 0.5, bl2 ? 0.875 : 0.625, 1.0);
                        this.bedDesignHelper.renderFaceZNeg(htvc2, 0, d, d2, d3);
                        this.bedDesignHelper.renderFaceZPos(htvc2, 4, d, d2, d3);
                        break;
                    }
                    default: {
                        htvc2._u = 1;
                        htvc2._a(0.5, bl2 ? 0.4375 : 0.3125, 0.0, 1.0, bl2 ? 0.875 : 0.625, 1.0);
                        this.bedDesignHelper.renderFaceZNeg(htvc2, 4, d, d2, d3);
                        this.bedDesignHelper.renderFaceZPos(htvc2, 0, d, d2, d3);
                    }
                }
                this.bedDesignHelper.renderFaceYPos(htvc2, 5, d, d2, d3);
                htvc2._u = 0;
            } else {
                switch (NamelessClass893865827.$SwitchMap$net$minecraftforge$common$ForgeDirection[forgeDirection.ordinal()]) {
                    case 1: {
                        htvc2._a(0.0, bl2 ? 0.4375 : 0.3125, 0.0, 1.0, bl2 ? 0.875 : 0.625, 1.0);
                        this.bedDesignHelper.renderFaceXNeg(htvc2, 3, d, d2, d3);
                        this.bedDesignHelper.renderFaceXPos(htvc2, 1, d, d2, d3);
                        this.bedDesignHelper.renderFaceZNeg(htvc2, 2, d, d2, d3);
                        break;
                    }
                    case 2: {
                        htvc2._u = 2;
                        htvc2._a(0.0, bl2 ? 0.4375 : 0.3125, 0.0, 1.0, bl2 ? 0.875 : 0.625, 1.0);
                        this.bedDesignHelper.renderFaceXNeg(htvc2, 1, d, d2, d3);
                        this.bedDesignHelper.renderFaceXPos(htvc2, 3, d, d2, d3);
                        this.bedDesignHelper.renderFaceZPos(htvc2, 2, d, d2, d3);
                        break;
                    }
                    case 3: {
                        htvc2._u = 3;
                        htvc2._a(0.0, bl2 ? 0.4375 : 0.3125, 0.0, 1.0, bl2 ? 0.875 : 0.625, 1.0);
                        this.bedDesignHelper.renderFaceZNeg(htvc2, 1, d, d2, d3);
                        this.bedDesignHelper.renderFaceZPos(htvc2, 3, d, d2, d3);
                        this.bedDesignHelper.renderFaceXNeg(htvc2, 2, d, d2, d3);
                        break;
                    }
                    default: {
                        htvc2._u = 1;
                        htvc2._a(0.0, bl2 ? 0.4375 : 0.3125, 0.0, 1.0, bl2 ? 0.875 : 0.625, 1.0);
                        this.bedDesignHelper.renderFaceZNeg(htvc2, 3, d, d2, d3);
                        this.bedDesignHelper.renderFaceZPos(htvc2, 1, d, d2, d3);
                        this.bedDesignHelper.renderFaceXPos(htvc2, 2, d, d2, d3);
                    }
                }
                this.bedDesignHelper.renderFaceYPos(htvc2, 6, d, d2, d3);
                htvc2._u = 0;
            }
            htvc2.__aF.func_78381_a();
            GL11.glEnable(2896);
            this.func_110628_a(sctd._c);
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

