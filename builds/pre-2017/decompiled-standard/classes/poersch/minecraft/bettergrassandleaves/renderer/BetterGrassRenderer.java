/*
 * Decompiled with CFR 0.152.
 */
package poersch.minecraft.bettergrassandleaves.renderer;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import net.minecraft.entity.Entity;
import net.minecraft.util.dwan;
import net.minecraft.util.sajh;
import poersch.minecraft.bettergrassandleaves.BetterGrassAndLeavesMod;
import poersch.minecraft.bettergrassandleaves.entity.EntityMovingGrassFancyFX;
import poersch.minecraft.bettergrassandleaves.entity.EntityMovingGrassFastFX;
import poersch.minecraft.bettergrassandleaves.entity.EntityMovingTallGrassFancyFX;
import poersch.minecraft.bettergrassandleaves.entity.EntityMovingTallGrassFastFX;
import poersch.minecraft.bettergrassandleaves.interfaces.IBetterGrass;
import poersch.minecraft.bettergrassandleaves.interfaces.IBetterGrassBiome;
import poersch.minecraft.bettergrassandleaves.renderer.BlockRenderer;
import poersch.minecraft.util.texture.ITextureLoadingCallback;

public class BetterGrassRenderer
extends BlockRenderer
implements IBetterGrass,
ITextureLoadingCallback {
    public static dwan[] iconBetterGrass;
    public static dwan[] iconBetterGrassSide;
    public static dwan[] iconBetterGrassSnowed;
    private static final boolean USE_GRASS_MODEL = true;
    private hsdi[] models;
    private static final int MIN_INSTANCES = 1;
    private static final int MAX_INSTANCES = 3;

    @Override
    public void onRegisterIcons(nege nege2) {
        iconBetterGrass = BetterGrassRenderer.registerBlockIcons("better_grass");
        iconBetterGrassSnowed = BetterGrassRenderer.registerBlockIcons("better_grass_snowed");
        iconBetterGrassSide = BetterGrassRenderer.registerBlockIcons("better_grass_side");
        this.models = new hsdi[iconBetterGrass.length];
        for (int i = 0; i < this.models.length; ++i) {
            try {
                this.models[i] = new hsdi("/assets/bettergrassandleaves/models/grass_" + i + ".obj", true, true, 0.4f, 0.8f, 1.3f, 1, 1, new float[]{0.8f, 0.8f, 0.8f}, new float[]{0.2f, 0.2f, 0.2f});
                continue;
            }
            catch (Exception exception) {
                exception.printStackTrace();
            }
        }
    }

    @Override
    public boolean onRenderBlock(twgu twgu2, sdrg sdrg2, int n, int n2, int n3, htvc htvc2) {
        if (!((Boolean)BetterGrassAndLeavesMod.renderBetterGrass.value).booleanValue()) {
            return false;
        }
        int n4 = sdrg2.func_72798_a(n, n2 + 1, n3);
        if (n4 != twgu.field_72037_aS.field_71990_ca) {
            long l = BetterGrassRenderer.getRandomOffsetForPosition(n, n2, n3);
            int n5 = twgu2.func_71920_b(sdrg2, n, n2, n3);
            float f = (float)(n5 >> 16 & 0xFF) * 0.00392f * ((Float)BetterGrassAndLeavesMod.betterGrassBrightness.value).floatValue();
            float f2 = (float)(n5 >> 8 & 0xFF) * 0.00392f * ((Float)BetterGrassAndLeavesMod.betterGrassBrightness.value).floatValue();
            float f3 = (float)(n5 & 0xFF) * 0.00392f * ((Float)BetterGrassAndLeavesMod.betterGrassBrightness.value).floatValue();
            int n6 = twgu2.func_71874_e(sdrg2, n, n2 + 1, n3);
            if (((Boolean[])BetterGrassAndLeavesMod.allowBetterGrass.value)[n4].booleanValue()) {
                int n7 = 1 + ((int)l >> 16 & 2);
                for (int i = 0; i < n7; ++i) {
                    int n8 = (int)(l >> i * 4 & 0xFL) % iconBetterGrass.length;
                    hsdi hsdi2 = this.models[n8];
                    dwan dwan2 = iconBetterGrass[n8];
                    if (hsdi2 == null || dwan2 == null) continue;
                    hsdi2.setColor(f, f2, f3);
                    int n9 = n * 31 + n2 * 23 + n3 * 37 + n8 * 49;
                    hsdi2.renderBlock(n, n2 + 1, n3, n9, n6, 0, iconBetterGrass[n8], htvc2);
                }
            }
        } else if (((Boolean)BetterGrassAndLeavesMod.renderSnowedGrass.value).booleanValue()) {
            long l;
            IBetterGrass iBetterGrass = twgu2 instanceof IBetterGrass ? (IBetterGrass)((Object)twgu2) : this;
            dwan dwan3 = ((IBetterGrass)iBetterGrass).getIconBetterGrassSnowed(0, (float)((l = BetterGrassRenderer.getRandomOffsetForPosition(n, n2, n3)) >> 12 & 0xFL) / 15.0f);
            if (dwan3 == null) {
                return false;
            }
            BlockRenderer.tessellator.get().func_78380_c(twgu2.func_71874_e(sdrg2, n, n2 + 1, n3));
            BlockRenderer.tessellator.get().func_78386_a(1.0f, 1.0f, 1.0f);
            double d = (double)n + 0.5 + ((double)((float)(l >> 16 & 0xFL) / 15.0f) - 0.5) * 0.3;
            double d2 = (double)n2 + 1.707 - (double)((float)(l >> 20 & 0xFL) / 15.0f) * 0.16;
            double d3 = (double)n3 + 0.5 + ((double)((float)(l >> 24 & 0xFL) / 15.0f) - 0.5) * 0.3;
            boolean bl = (float)(l >> 8 & 0xFL) / 15.0f < 0.5f;
            BetterGrassRenderer.setRotationalOffsetMap(BlockRenderer.offsetMap24px, n, n2, n3);
            this.renderCrossedQuadsY(dwan3, d, d2, d3, bl, false);
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
            foqh foqh2;
            float f;
            long l;
            IBetterGrass iBetterGrass = twgu2 instanceof IBetterGrass ? (IBetterGrass)((Object)twgu2) : this;
            dwan dwan2 = iBetterGrass.getIconBetterGrass((float)((l = BetterGrassRenderer.getRandomOffsetForPosition(n, n2, n3)) >> 4 & 0xFL) / 15.0f > (f = BetterGrassRenderer.combineSpawnRates((foqh2 = ozlu2.func_72807_a(n, n3)) instanceof IBetterGrassBiome ? ((IBetterGrassBiome)((Object)foqh2)).getHeightBetterGrass() : foqh2._G * 0.9f + 0.05f, ((Float)BetterGrassAndLeavesMod.averageGrassHeight.value).floatValue())) ? 0 : 1, (float)(l >> 12 & 0xFL) / 15.0f);
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
        } else if (ozlu2.func_72798_a(n, n2 + 1, n3) == twgu.field_71962_X.field_71990_ca) {
            long l = BetterGrassRenderer.getRandomOffsetForPosition(n, n2 + 1, n3);
            dwan dwan3 = twgu.field_71962_X.func_71858_a(0, ozlu2.func_72805_g(n, n2 + 1, n3));
            double d = (double)n + 0.5 + ((double)((float)(l >> 16 & 0xFL) / 15.0f) - 0.5) * 0.5;
            double d4 = (double)n2 + 1.5 + ((double)((float)(l >> 20 & 0xFL) / 15.0f) - 1.0) * 0.2;
            double d5 = (double)n3 + 0.5 + ((double)((float)(l >> 24 & 0xFL) / 15.0f) - 0.5) * 0.5;
            if ((Integer)BetterGrassAndLeavesMod.renderGrassFX.value == 1) {
                this.minecraft._w._a(new EntityMovingTallGrassFastFX(ozlu2, d, d4, d5, -0.4f, twgu.field_71962_X.func_71874_e(ozlu2, n, n2 + 1, n3), twgu2.func_71920_b(ozlu2, n, n2 + 1, n3), dwan3));
            } else {
                this.minecraft._w._a(new EntityMovingTallGrassFancyFX(ozlu2, entity.field_70165_t, d4, entity.field_70161_v, -0.4f, twgu.field_71962_X.func_71874_e(ozlu2, n, n2 + 1, n3), twgu.field_71962_X.func_71920_b(ozlu2, n, n2 + 1, n3), dwan3, entity, twgu2.field_71990_ca));
            }
        }
        return false;
    }

    public static void renderBetterGrassSidesFast(twgu twgu2, sdrg sdrg2, int n, int n2, int n3, htvc htvc2, dwan dwan2) {
        float f = (float)Math.abs((n & 1) + (n3 & 1) * 2) * 0.08f;
        if (twgu.field_71971_o[sdrg2.func_72798_a(n, n2, n3 - 1)] == 0 && sdrg2.func_72798_a(n, n2 - 1, n3 - 1) == twgu2.field_71990_ca) {
            BetterGrassRenderer.renderOvergrowthZNeg(dwan2, (double)n + 0.5, (double)n2 + 1.0, n3, 0.5, f - 3.1f, false, true);
        }
        if (twgu.field_71971_o[sdrg2.func_72798_a(n, n2, n3 + 1)] == 0 && sdrg2.func_72798_a(n, n2 - 1, n3 + 1) == twgu2.field_71990_ca) {
            BetterGrassRenderer.renderOvergrowthZPos(dwan2, (double)n + 0.5, (double)n2 + 1.0, (double)n3 + 1.0, 0.5, f - 3.1f, false, true);
        }
        if (twgu.field_71971_o[sdrg2.func_72798_a(n - 1, n2, n3)] == 0 && sdrg2.func_72798_a(n - 1, n2 - 1, n3) == twgu2.field_71990_ca) {
            BetterGrassRenderer.renderOvergrowthXNeg(dwan2, n, (double)n2 + 1.0, (double)n3 + 0.5, 0.5, f - 3.1f, false, true);
        }
        if (twgu.field_71971_o[sdrg2.func_72798_a(n + 1, n2, n3)] == 0 && sdrg2.func_72798_a(n + 1, n2 - 1, n3) == twgu2.field_71990_ca) {
            BetterGrassRenderer.renderOvergrowthXPos(dwan2, (double)n + 1.0, (double)n2 + 1.0, (double)n3 + 0.5, 0.5, f - 3.1f, false, true);
        }
    }

    public static void renderBetterGrassSidesFancy(twgu twgu2, sdrg sdrg2, int n, int n2, int n3, dwan dwan2) {
        float f = (float)Math.abs((n & 1) + (n3 & 1) * 2) * 0.2f;
        int n4 = sdrg2.func_72798_a(n, n2, n3 - 1);
        if (n4 != twgu2.field_71990_ca && !twgu.field_71970_n[sdrg2.func_72798_a(n, n2 + 1, n3 - 1)]) {
            BetterGrassRenderer.renderOvergrowthZNeg(dwan2, (double)n + 0.5, (double)n2 + 1.0, n3, 0.707, f - 0.8f, false, false);
            if (!twgu.field_71970_n[n4]) {
                BetterGrassRenderer.renderOvergrowthZNeg(dwan2, (double)n + 0.5, (double)n2 + 1.0, n3, 0.707, f - 2.8f, true, false);
            }
        }
        if ((n4 = sdrg2.func_72798_a(n, n2, n3 + 1)) != twgu2.field_71990_ca && !twgu.field_71970_n[sdrg2.func_72798_a(n, n2 + 1, n3 + 1)]) {
            BetterGrassRenderer.renderOvergrowthZPos(dwan2, (double)n + 0.5, (double)n2 + 1.0, (double)n3 + 1.0, 0.707, f - 0.8f, false, false);
            if (!twgu.field_71970_n[n4]) {
                BetterGrassRenderer.renderOvergrowthZPos(dwan2, (double)n + 0.5, (double)n2 + 1.0, (double)n3 + 1.0, 0.707, f - 2.8f, true, false);
            }
        }
        if ((n4 = sdrg2.func_72798_a(n - 1, n2, n3)) != twgu2.field_71990_ca && !twgu.field_71970_n[sdrg2.func_72798_a(n - 1, n2 + 1, n3)]) {
            BetterGrassRenderer.renderOvergrowthXNeg(dwan2, n, (double)n2 + 1.0, (double)n3 + 0.5, 0.707, f - 0.8f, false, false);
            if (!twgu.field_71970_n[n4]) {
                BetterGrassRenderer.renderOvergrowthXNeg(dwan2, n, (double)n2 + 1.0, (double)n3 + 0.5, 0.707, f - 2.8f, true, false);
            }
        }
        if ((n4 = sdrg2.func_72798_a(n + 1, n2, n3)) != twgu2.field_71990_ca && !twgu.field_71970_n[sdrg2.func_72798_a(n + 1, n2 + 1, n3)]) {
            BetterGrassRenderer.renderOvergrowthXPos(dwan2, (double)n + 1.0, (double)n2 + 1.0, (double)n3 + 0.5, 0.707, f - 0.8f, false, false);
            if (!twgu.field_71970_n[n4]) {
                BetterGrassRenderer.renderOvergrowthXPos(dwan2, (double)n + 1.0, (double)n2 + 1.0, (double)n3 + 0.5, 0.707, f - 2.8f, true, false);
            }
        }
    }

    public static void renderOvergrowthXNeg(dwan dwan2, double d, double d2, double d3, double d4, float f, boolean bl, boolean bl2) {
        double d5;
        double d6;
        double d7;
        double d8;
        if (!bl) {
            d8 = dwan2.func_94209_e();
            d7 = dwan2.func_94212_f();
        } else {
            d8 = dwan2.func_94212_f();
            d7 = dwan2.func_94209_e();
        }
        if (!bl2) {
            d6 = dwan2.func_94206_g();
            d5 = dwan2.func_94210_h();
        } else {
            d6 = dwan2.func_94210_h();
            d5 = dwan2.func_94206_g();
        }
        double d9 = d + (double)sajh._a(f) * d4 * 2.0;
        double d10 = d2 + (double)sajh._b(f) * d4 * 2.0;
        double d11 = d3 - d4;
        double d12 = d3 + d4;
        BlockRenderer.tessellator.get().func_78374_a(d9, d10, d12, d7, d6);
        BlockRenderer.tessellator.get().func_78374_a(d, d2, d12, d7, d5);
        BlockRenderer.tessellator.get().func_78374_a(d, d2, d11, d8, d5);
        BlockRenderer.tessellator.get().func_78374_a(d9, d10, d11, d8, d6);
        BlockRenderer.tessellator.get().func_78374_a(d9, d10, d11, d8, d6);
        BlockRenderer.tessellator.get().func_78374_a(d, d2, d11, d8, d5);
        BlockRenderer.tessellator.get().func_78374_a(d, d2, d12, d7, d5);
        BlockRenderer.tessellator.get().func_78374_a(d9, d10, d12, d7, d6);
    }

    public static void renderOvergrowthXPos(dwan dwan2, double d, double d2, double d3, double d4, float f, boolean bl, boolean bl2) {
        double d5;
        double d6;
        double d7;
        double d8;
        if (!bl) {
            d8 = dwan2.func_94209_e();
            d7 = dwan2.func_94212_f();
        } else {
            d8 = dwan2.func_94212_f();
            d7 = dwan2.func_94209_e();
        }
        if (!bl2) {
            d6 = dwan2.func_94206_g();
            d5 = dwan2.func_94210_h();
        } else {
            d6 = dwan2.func_94210_h();
            d5 = dwan2.func_94206_g();
        }
        double d9 = d - (double)sajh._a(f) * d4 * 2.0;
        double d10 = d2 + (double)sajh._b(f) * d4 * 2.0;
        double d11 = d3 - d4;
        double d12 = d3 + d4;
        BlockRenderer.tessellator.get().func_78374_a(d9, d10, d12, d7, d6);
        BlockRenderer.tessellator.get().func_78374_a(d, d2, d12, d7, d5);
        BlockRenderer.tessellator.get().func_78374_a(d, d2, d11, d8, d5);
        BlockRenderer.tessellator.get().func_78374_a(d9, d10, d11, d8, d6);
        BlockRenderer.tessellator.get().func_78374_a(d9, d10, d11, d8, d6);
        BlockRenderer.tessellator.get().func_78374_a(d, d2, d11, d8, d5);
        BlockRenderer.tessellator.get().func_78374_a(d, d2, d12, d7, d5);
        BlockRenderer.tessellator.get().func_78374_a(d9, d10, d12, d7, d6);
    }

    public static void renderOvergrowthZNeg(dwan dwan2, double d, double d2, double d3, double d4, float f, boolean bl, boolean bl2) {
        double d5;
        double d6;
        double d7;
        double d8;
        if (!bl) {
            d8 = dwan2.func_94209_e();
            d7 = dwan2.func_94212_f();
        } else {
            d8 = dwan2.func_94212_f();
            d7 = dwan2.func_94209_e();
        }
        if (!bl2) {
            d6 = dwan2.func_94206_g();
            d5 = dwan2.func_94210_h();
        } else {
            d6 = dwan2.func_94210_h();
            d5 = dwan2.func_94206_g();
        }
        double d9 = d - d4;
        double d10 = d + d4;
        double d11 = d2 + (double)sajh._b(f) * d4 * 2.0;
        double d12 = d3 + (double)sajh._a(f) * d4 * 2.0;
        BlockRenderer.tessellator.get().func_78374_a(d10, d11, d12, d7, d6);
        BlockRenderer.tessellator.get().func_78374_a(d10, d2, d3, d7, d5);
        BlockRenderer.tessellator.get().func_78374_a(d9, d2, d3, d8, d5);
        BlockRenderer.tessellator.get().func_78374_a(d9, d11, d12, d8, d6);
        BlockRenderer.tessellator.get().func_78374_a(d9, d11, d12, d8, d6);
        BlockRenderer.tessellator.get().func_78374_a(d9, d2, d3, d8, d5);
        BlockRenderer.tessellator.get().func_78374_a(d10, d2, d3, d7, d5);
        BlockRenderer.tessellator.get().func_78374_a(d10, d11, d12, d7, d6);
    }

    public static void renderOvergrowthZPos(dwan dwan2, double d, double d2, double d3, double d4, float f, boolean bl, boolean bl2) {
        double d5;
        double d6;
        double d7;
        double d8;
        if (!bl) {
            d8 = dwan2.func_94209_e();
            d7 = dwan2.func_94212_f();
        } else {
            d8 = dwan2.func_94212_f();
            d7 = dwan2.func_94209_e();
        }
        if (!bl2) {
            d6 = dwan2.func_94206_g();
            d5 = dwan2.func_94210_h();
        } else {
            d6 = dwan2.func_94210_h();
            d5 = dwan2.func_94206_g();
        }
        double d9 = d - d4;
        double d10 = d + d4;
        double d11 = d2 + (double)sajh._b(f) * d4 * 2.0;
        double d12 = d3 - (double)sajh._a(f) * d4 * 2.0;
        BlockRenderer.tessellator.get().func_78374_a(d10, d11, d12, d7, d6);
        BlockRenderer.tessellator.get().func_78374_a(d10, d2, d3, d7, d5);
        BlockRenderer.tessellator.get().func_78374_a(d9, d2, d3, d8, d5);
        BlockRenderer.tessellator.get().func_78374_a(d9, d11, d12, d8, d6);
        BlockRenderer.tessellator.get().func_78374_a(d9, d11, d12, d8, d6);
        BlockRenderer.tessellator.get().func_78374_a(d9, d2, d3, d8, d5);
        BlockRenderer.tessellator.get().func_78374_a(d10, d2, d3, d7, d5);
        BlockRenderer.tessellator.get().func_78374_a(d10, d11, d12, d7, d6);
    }

    protected int getTextureHeight(BufferedImage bufferedImage) {
        int n = bufferedImage.getWidth();
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                if (bufferedImage.getRGB(j, i) >> 24 == 0) continue;
                return n - i;
            }
        }
        return 0;
    }

    @Override
    public BufferedImage onTextureLoading(dhji dhji2, BufferedImage bufferedImage) {
        int n = bufferedImage.getWidth();
        BufferedImage bufferedImage2 = new BufferedImage(n, n, 2);
        Graphics2D graphics2D = bufferedImage2.createGraphics();
        graphics2D.drawImage(bufferedImage, null, 0, (int)((float)this.getTextureHeight(bufferedImage) * (dhji2.func_94215_i().endsWith("_short") ? 0.7f : 0.5f)));
        graphics2D.dispose();
        return bufferedImage2;
    }

    @Override
    public dwan getIconBetterGrass(int n, float f) {
        return iconBetterGrass != null ? iconBetterGrass[(int)(f * (float)(iconBetterGrass.length - 1) + 0.5f)] : null;
    }

    @Override
    public dwan getIconBetterGrassSnowed(int n, float f) {
        return iconBetterGrassSnowed == null ? null : iconBetterGrassSnowed[(int)(f * (float)(iconBetterGrassSnowed.length - 1) + 0.5f)];
    }

    @Override
    public dwan getIconBetterGrassSide(int n, float f) {
        return iconBetterGrassSide == null ? null : iconBetterGrassSide[(int)(f * (float)(iconBetterGrassSide.length - 1) + 0.5f)];
    }
}

