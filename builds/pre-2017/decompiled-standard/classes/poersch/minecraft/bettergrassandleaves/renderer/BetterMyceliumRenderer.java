/*
 * Decompiled with CFR 0.152.
 */
package poersch.minecraft.bettergrassandleaves.renderer;

import net.minecraft.entity.Entity;
import net.minecraft.util.dwan;
import poersch.minecraft.bettergrassandleaves.BetterGrassAndLeavesMod;
import poersch.minecraft.bettergrassandleaves.entity.EntityMovingGrassFancyFX;
import poersch.minecraft.bettergrassandleaves.entity.EntityMovingGrassFastFX;
import poersch.minecraft.bettergrassandleaves.interfaces.IBetterMycelium;
import poersch.minecraft.bettergrassandleaves.renderer.BetterGrassRenderer;
import poersch.minecraft.bettergrassandleaves.renderer.BlockRenderer;

public class BetterMyceliumRenderer
extends BlockRenderer
implements IBetterMycelium {
    public static dwan[] iconBetterMycelium;
    public static dwan[] iconBetterMyceliumSide;
    public static dwan[] iconBetterMyceliumSnowed;

    @Override
    public void onRegisterIcons(nege nege2) {
        iconBetterMycelium = BetterMyceliumRenderer.registerBlockIcons("better_mycel");
        iconBetterMyceliumSide = BetterMyceliumRenderer.registerBlockIcons("better_mycel_side");
        iconBetterMyceliumSnowed = BetterMyceliumRenderer.registerBlockIcons("better_mycel_snowed");
    }

    @Override
    public boolean onRenderBlock(twgu twgu2, sdrg sdrg2, int n, int n2, int n3, htvc htvc2) {
        if (!((Boolean)BetterGrassAndLeavesMod.renderBetterGrass.value).booleanValue()) {
            return false;
        }
        int n4 = sdrg2.func_72798_a(n, n2 + 1, n3);
        if (n4 != twgu.field_72037_aS.field_71990_ca) {
            long l;
            IBetterMycelium iBetterMycelium = twgu2 instanceof IBetterMycelium ? (IBetterMycelium)((Object)twgu2) : this;
            dwan dwan2 = ((IBetterMycelium)iBetterMycelium).getIconBetterMycelium(0, (float)((l = BetterMyceliumRenderer.getRandomOffsetForPosition(n, n2, n3)) >> 12 & 0xFL) / 15.0f);
            if (dwan2 == null) {
                return false;
            }
            BlockRenderer.tessellator.get().func_78380_c(twgu2.func_71874_e(sdrg2, n, n2 + 1, n3));
            BlockRenderer.tessellator.get().func_78386_a(1.0f, 1.0f, 1.0f);
            if (!sdrg2.func_72804_r(n, n2 + 1, n3) && (Integer)BetterGrassAndLeavesMod.renderGrassSides.value > 0) {
                if ((Integer)BetterGrassAndLeavesMod.renderGrassSides.value == 1) {
                    dwan dwan3 = ((IBetterMycelium)iBetterMycelium).getIconBetterMyceliumSide(sdrg2.func_72805_g(n, n2, n3), (float)(l >> 4 & 0xFL) / 15.0f);
                    if (dwan3 != null) {
                        BetterGrassRenderer.renderBetterGrassSidesFast(twgu2, sdrg2, n, n2, n3, htvc2, dwan3);
                    }
                } else {
                    BetterGrassRenderer.renderBetterGrassSidesFancy(twgu2, sdrg2, n, n2, n3, dwan2);
                }
            }
            if (((Boolean[])BetterGrassAndLeavesMod.allowBetterGrass.value)[n4].booleanValue()) {
                double d = (double)n + 0.5 + ((double)((float)(l >> 16 & 0xFL) / 15.0f) - 0.5) * 0.3;
                double d2 = (double)n2 + 1.707 - (double)((float)(l >> 20 & 0xFL) / 15.0f) * 0.16;
                double d3 = (double)n3 + 0.5 + ((double)((float)(l >> 24 & 0xFL) / 15.0f) - 0.5) * 0.3;
                boolean bl = (float)(l >> 8 & 0xFL) / 15.0f < 0.5f;
                BetterMyceliumRenderer.setRotationalOffsetMap(BlockRenderer.offsetMap24px, n, n2, n3);
                this.renderCrossedQuadsY(dwan2, d, d2, d3, bl, false);
            }
        } else if (((Boolean)BetterGrassAndLeavesMod.renderSnowedGrass.value).booleanValue()) {
            long l;
            IBetterMycelium iBetterMycelium = twgu2 instanceof IBetterMycelium ? (IBetterMycelium)((Object)twgu2) : this;
            dwan dwan4 = ((IBetterMycelium)iBetterMycelium).getIconBetterMyceliumSnowed(0, (float)((l = BetterMyceliumRenderer.getRandomOffsetForPosition(n, n2, n3)) >> 12 & 0xFL) / 15.0f);
            if (dwan4 == null) {
                return false;
            }
            BlockRenderer.tessellator.get().func_78380_c(twgu2.func_71874_e(sdrg2, n, n2 + 1, n3));
            BlockRenderer.tessellator.get().func_78386_a(1.0f, 1.0f, 1.0f);
            double d = (double)n + 0.5 + ((double)((float)(l >> 16 & 0xFL) / 15.0f) - 0.5) * 0.3;
            double d4 = (double)n2 + 1.707 - (double)((float)(l >> 20 & 0xFL) / 15.0f) * 0.16;
            double d5 = (double)n3 + 0.5 + ((double)((float)(l >> 24 & 0xFL) / 15.0f) - 0.5) * 0.3;
            boolean bl = (float)(l >> 8 & 0xFL) / 15.0f < 0.5f;
            BetterMyceliumRenderer.setRotationalOffsetMap(BlockRenderer.offsetMap24px, n, n2, n3);
            this.renderCrossedQuadsY(dwan4, d, d4, d5, bl, false);
        }
        return false;
    }

    @Override
    public boolean onEntityWalking(twgu twgu2, ozlu ozlu2, int n, int n2, int n3, Entity entity) {
        if ((Integer)BetterGrassAndLeavesMod.renderGrassFX.value == 0) {
            return false;
        }
        if (ozlu2.func_72799_c(n, n2 + 1, n3)) {
            boolean bl;
            long l;
            IBetterMycelium iBetterMycelium = twgu2 instanceof IBetterMycelium ? (IBetterMycelium)((Object)twgu2) : this;
            dwan dwan2 = iBetterMycelium.getIconBetterMycelium(0, (float)((l = BetterMyceliumRenderer.getRandomOffsetForPosition(n, n2, n3)) >> 12 & 0xFL) / 15.0f);
            if (dwan2 == null) {
                return false;
            }
            double d = (double)n + 0.5 + ((double)((float)(l >> 16 & 0xFL) / 15.0f) - 0.5) * 0.3;
            double d2 = (double)n2 + 1.707 - (double)((float)(l >> 20 & 0xFL) / 15.0f) * 0.16;
            double d3 = (double)n3 + 0.5 + ((double)((float)(l >> 24 & 0xFL) / 15.0f) - 0.5) * 0.3;
            boolean bl2 = bl = (float)(l >> 8 & 0xFL) / 15.0f < 0.5f;
            if ((Integer)BetterGrassAndLeavesMod.renderGrassFX.value == 1) {
                this.minecraft._w._a(new EntityMovingGrassFastFX(ozlu2, d, d2, d3, 0.46f, Math.abs(n & 1 + (n3 & 1) * 2 + (n2 & 1) * 4), twgu2.func_71874_e(ozlu2, n, n2 + 1, n3), ((Float)BetterGrassAndLeavesMod.betterGrassBrightness.value).floatValue(), twgu2.func_71920_b(ozlu2, n, n2, n3), dwan2, bl));
            } else {
                this.minecraft._w._a(new EntityMovingGrassFancyFX(ozlu2, entity.field_70165_t, d2, entity.field_70161_v, 0.46f, Math.abs(n & 1 + (n3 & 1) * 2 + (n2 & 1) * 4), twgu2.func_71874_e(ozlu2, n, n2 + 1, n3), ((Float)BetterGrassAndLeavesMod.betterGrassBrightness.value).floatValue(), twgu2.func_71920_b(ozlu2, n, n2, n3), dwan2, bl, entity, twgu2.field_71990_ca));
            }
        }
        return false;
    }

    @Override
    public dwan getIconBetterMyceliumSide(int n, float f) {
        return iconBetterMyceliumSide == null ? null : iconBetterMyceliumSide[(int)(f * (float)(iconBetterMyceliumSide.length - 1) + 0.5f)];
    }

    @Override
    public dwan getIconBetterMycelium(int n, float f) {
        return iconBetterMycelium == null ? null : iconBetterMycelium[(int)(f * (float)(iconBetterMycelium.length - 1) + 0.5f)];
    }

    @Override
    public dwan getIconBetterMyceliumSnowed(int n, float f) {
        return iconBetterMyceliumSnowed == null ? null : iconBetterMyceliumSnowed[(int)(f * (float)(iconBetterMyceliumSnowed.length - 1) + 0.5f)];
    }
}

