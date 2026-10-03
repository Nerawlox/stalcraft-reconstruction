/*
 * Decompiled with CFR 0.152.
 */
package poersch.minecraft.bettergrassandleaves.renderer;

import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.image.BufferedImage;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import net.minecraft.client.xpzm;
import net.minecraft.util.dwan;
import poersch.minecraft.bettergrassandleaves.BetterGrassAndLeavesMod;
import poersch.minecraft.bettergrassandleaves.entity.EntityFallingLeavesFancyFX;
import poersch.minecraft.bettergrassandleaves.entity.EntityFallingLeavesFastFX;
import poersch.minecraft.bettergrassandleaves.interfaces.IBetterLeaves;
import poersch.minecraft.bettergrassandleaves.renderer.BlockRenderer;
import poersch.minecraft.util.ResourceHelper;
import poersch.minecraft.util.StringHelper;
import poersch.minecraft.util.texture.ITextureLoadingCallback;

public class BetterLeavesRenderer
extends BlockRenderer
implements IBetterLeaves,
ITextureLoadingCallback {
    public static dwan[][] iconBetterLeaves;
    public static dwan[] iconFallingLeaves;
    public static dwan[] iconBetterLeavesSnowed;
    public static dwan[] iconRoundedLeaves;
    protected static Map<String, dwan[]> iconMap;
    public static HashSet<twgu> leafBlocks;

    @Override
    public void onRegisterIcons(nege nege2) {
        marn marn2 = twgu.field_71952_K;
        iconRoundedLeaves = new dwan[marn._a.length];
        int n = 0;
        while (true) {
            marn marn3 = twgu.field_71952_K;
            if (n >= marn._a.length) {
                marn2 = twgu.field_71952_K;
                iconFallingLeaves = new dwan[marn._a.length];
                n = 0;
                while (true) {
                    marn marn4;
                    StringBuilder stringBuilder;
                    marn3 = twgu.field_71952_K;
                    if (n >= marn._a.length) {
                        marn2 = twgu.field_71952_K;
                        iconBetterLeaves = new dwan[marn._a.length][];
                        for (n = 0; n < iconBetterLeaves.length; ++n) {
                            dwan[][] dwanArray = iconBetterLeaves;
                            stringBuilder = new StringBuilder().append("better_leaves_");
                            marn4 = twgu.field_71952_K;
                            String string = stringBuilder.append(marn._a[n]).toString();
                            StringBuilder stringBuilder2 = new StringBuilder().append("leaves_");
                            marn marn5 = twgu.field_71952_K;
                            dwanArray[n] = BetterLeavesRenderer.registerBlockIconsOrCallbackIfAllowed(string, stringBuilder2.append(marn._a[n]).toString(), this);
                            if (dwanArray[n] != null) continue;
                            BetterLeavesRenderer.iconBetterLeaves[n] = new dwan[]{null};
                        }
                        iconBetterLeavesSnowed = BetterLeavesRenderer.registerBlockIcons("better_leaves_snowed");
                        for (twgu twgu2 : leafBlocks) {
                            BlockRenderer.leavesRenderer.assignToBlockID(twgu2.field_71990_ca);
                        }
                        return;
                    }
                    dwan[] dwanArray = iconFallingLeaves;
                    stringBuilder = new StringBuilder().append("falling_leaves_");
                    marn4 = twgu.field_71952_K;
                    dwanArray[n] = BetterLeavesRenderer.registerBlockIcon(stringBuilder.append(marn._a[n]).toString());
                    ++n;
                }
            }
            ++n;
        }
    }

    public static void resetBetterLeavesLinkage() {
        iconMap.clear();
    }

    public static void linkBetterLeavesTo(nege nege2, String string) {
        List<String> list2 = StringHelper.splitTrimToList(string, ':');
        dwan[] dwanArray = null;
        if (list2.size() > 1 && (dwanArray = ResourceHelper.registerIconsOrCallback(nege2, list2.get(0), "textures/blocks/", "better_" + list2.get(1), "textures/blocks/", list2.get(1), (ITextureLoadingCallback)BlockRenderer.leavesRenderer.get(0))) != null) {
            iconMap.put(list2.get(0).equals("minecraft") ? list2.get(1).toLowerCase() : (list2.get(0) + ":" + list2.get(1)).toLowerCase(), dwanArray);
        }
    }

    protected static dwan getIconFromMap(String string, float f) {
        dwan[] dwanArray = iconMap.get(string.toLowerCase());
        return dwanArray != null ? dwanArray[(int)(f * (float)(dwanArray.length - 1) + 0.5f)] : null;
    }

    @Override
    public boolean onRenderBlock(twgu twgu2, sdrg sdrg2, int n, int n2, int n3, htvc htvc2) {
        if (!((Boolean)BetterGrassAndLeavesMod.renderBetterLeaves.value).booleanValue()) {
            return false;
        }
        twgu2.func_71902_a(sdrg2, n, n2, n3);
        htvc2._a(twgu2);
        htvc2._q(twgu2, n, n2, n3);
        int n4 = BetterLeavesRenderer.blockHasVisibleSide(twgu2, sdrg2, n, n2, n3);
        if (n4 > -1) {
            IBetterLeaves iBetterLeaves = twgu2 instanceof IBetterLeaves ? (IBetterLeaves)((Object)twgu2) : this;
            long l = BetterLeavesRenderer.getRandomOffsetForPosition(n, n2, n3);
            int n5 = sdrg2.func_72805_g(n, n2, n3);
            float f = (float)(l >> 12 & 0xFL) / 15.0f;
            dwan dwan2 = iBetterLeaves.getIconBetterLeaves(n5, f);
            if (dwan2 == null && (dwan2 = BetterLeavesRenderer.getIconFromMap(twgu2.func_71858_a(0, n5).func_94215_i(), f)) == null) {
                dwan2 = twgu2.func_71858_a(0, n5);
            }
            double d = (double)n + 0.5 + ((double)((float)(l >> 16 & 0xFL) / 15.0f) - 0.5) * 0.45;
            double d2 = (double)n2 + 0.5 + ((double)((float)(l >> 20 & 0xFL) / 15.0f) - 0.5) * 0.3;
            double d3 = (double)n3 + 0.5 + ((double)((float)(l >> 24 & 0xFL) / 15.0f) - 0.5) * 0.45;
            int n6 = twgu2.func_71920_b(sdrg2, n, n2, n3);
            float f2 = (float)(n6 >> 16 & 0xFF) * 0.00392f * ((Float)BetterGrassAndLeavesMod.betterLeavesBrightness.value).floatValue();
            float f3 = (float)(n6 >> 8 & 0xFF) * 0.00392f * ((Float)BetterGrassAndLeavesMod.betterLeavesBrightness.value).floatValue();
            float f4 = (float)(n6 & 0xFF) * 0.00392f * ((Float)BetterGrassAndLeavesMod.betterLeavesBrightness.value).floatValue();
            boolean bl = (float)(l >> 8 & 0xFL) / 15.0f < 0.5f;
            boolean bl2 = (float)(l >> 4 & 0xFL) / 15.0f < 0.5f;
            BetterLeavesRenderer.setRotationalOffsetMap(BlockRenderer.offsetMap32px, n, n2, n3);
            if (!twgu2.func_71926_d()) {
                BlockRenderer.tessellator.get().func_78380_c(twgu2.func_71874_e(sdrg2, n, n2, n3));
            } else {
                BlockRenderer.tessellator.get().func_78380_c(n4);
            }
            xpzm xpzm2 = this.minecraft;
            if (xpzm._C()) {
                this.renderCrossedQuadsShadedY(dwan2, d, d2, d3, bl, bl2, f2, f3, f4, f2 * 0.58f, f3 * 0.58f, f4 * 0.58f);
            } else {
                BlockRenderer.tessellator.get().func_78386_a(f2 * 0.78f, f3 * 0.78f, f4 * 0.78f);
                this.renderCrossedQuadsY(dwan2, d, d2, d3, bl, bl2);
            }
            if (((Boolean)BetterGrassAndLeavesMod.renderSnowedLeaves.value).booleanValue() && sdrg2.func_72798_a(n, n2 + 1, n3) == twgu.field_72037_aS.field_71990_ca) {
                dwan2 = iBetterLeaves.getIconBetterLeavesSnowed(0, (float)(l >> 12 & 0xFL) / 15.0f);
                if (dwan2 == null) {
                    return false;
                }
                BlockRenderer.tessellator.get().func_78386_a(1.0f, 1.0f, 1.0f);
                xpzm2 = this.minecraft;
                if (xpzm._C()) {
                    this.renderCrossedQuadsShadedY(dwan2, d, d2, d3, bl, false, 1.0f, 1.0f, 1.0f, 0.58f, 0.58f, 0.58f);
                } else {
                    BlockRenderer.tessellator.get().func_78386_a(0.78f, 0.78f, 0.78f);
                    this.renderCrossedQuadsY(dwan2, d, d2, d3, bl, false);
                }
            }
            return true;
        }
        return (Boolean)BetterGrassAndLeavesMod.renderOnlyOuterLeaves.value;
    }

    @Override
    public boolean onRandomDisplayTick(twgu twgu2, ozlu ozlu2, int n, int n2, int n3, Random random) {
        if ((Integer)BetterGrassAndLeavesMod.renderLeavesFX.value == 0) {
            return false;
        }
        if (ozlu2.func_72799_c(n, n2 - 1, n3)) {
            IBetterLeaves iBetterLeaves = twgu2 instanceof IBetterLeaves ? (IBetterLeaves)((Object)twgu2) : this;
            int n4 = ozlu2.func_72805_g(n, n2, n3);
            if (random.nextFloat() > 1.0f - BetterLeavesRenderer.combineSpawnRates(iBetterLeaves.getSpawnChanceFallingLeaves(n4), ((Float)BetterGrassAndLeavesMod.leavesFXSpawnRate.value).floatValue())) {
                dwan dwan2 = iBetterLeaves.getIconFallingLeaves(n4);
                if (dwan2 == null && (dwan2 = twgu2.func_71858_a(0, n4)) == null) {
                    return false;
                }
                double d = (double)n + 0.1 + random.nextDouble() * 0.8;
                double d2 = (double)n2 + 0.16;
                double d3 = (double)n3 + 0.1 + random.nextDouble() * 0.8;
                float f = (float)dwan2.func_94211_a() / (float)twgu2.func_71858_a(0, n4).func_94211_a();
                if ((Integer)BetterGrassAndLeavesMod.renderLeavesFX.value == 1) {
                    this.minecraft._w._a(new EntityFallingLeavesFastFX(ozlu2, d, d2, d3, f, ((Float)BetterGrassAndLeavesMod.betterLeavesBrightness.value).floatValue(), twgu2.func_71920_b(ozlu2, n, n2, n3), dwan2));
                } else {
                    this.minecraft._w._a(new EntityFallingLeavesFancyFX(ozlu2, d, d2, d3, f, ((Float)BetterGrassAndLeavesMod.betterLeavesBrightness.value).floatValue(), twgu2.func_71920_b(ozlu2, n, n2, n3), dwan2));
                }
            }
        }
        return false;
    }

    public static int blockHasVisibleSide(twgu twgu2, sdrg sdrg2, int n, int n2, int n3) {
        int n4 = sdrg2.func_72798_a(n, n2 + 1, n3);
        if (n4 != twgu2.field_71990_ca && !twgu.field_71970_n[n4]) {
            return twgu2.func_71874_e(sdrg2, n, n2 + 1, n3);
        }
        n4 = sdrg2.func_72798_a(n + 1, n2, n3);
        if (n4 != twgu2.field_71990_ca && !twgu.field_71970_n[n4]) {
            return twgu2.func_71874_e(sdrg2, n + 1, n2, n3);
        }
        n4 = sdrg2.func_72798_a(n - 1, n2, n3);
        if (n4 != twgu2.field_71990_ca && !twgu.field_71970_n[n4]) {
            return twgu2.func_71874_e(sdrg2, n - 1, n2, n3);
        }
        n4 = sdrg2.func_72798_a(n, n2, n3 + 1);
        if (n4 != twgu2.field_71990_ca && !twgu.field_71970_n[n4]) {
            return twgu2.func_71874_e(sdrg2, n, n2, n3 + 1);
        }
        n4 = sdrg2.func_72798_a(n, n2, n3 - 1);
        if (n4 != twgu2.field_71990_ca && !twgu.field_71970_n[n4]) {
            return twgu2.func_71874_e(sdrg2, n, n2, n3 - 1);
        }
        n4 = sdrg2.func_72798_a(n, n2 - 1, n3);
        return n4 != twgu2.field_71990_ca && !twgu.field_71970_n[n4] ? twgu2.func_71874_e(sdrg2, n, n2 - 1, n3) : -1;
    }

    @Override
    public BufferedImage onTextureLoading(dhji dhji2, BufferedImage bufferedImage) {
        int n = bufferedImage.getWidth();
        int n2 = dhji2.func_94215_i().startsWith("better_") ? n * 2 : n;
        BufferedImage bufferedImage2 = new BufferedImage(n2, n2, 2);
        Graphics2D graphics2D = bufferedImage2.createGraphics();
        graphics2D.setClip(new Ellipse2D.Double(0.0, 0.0, n2, n2));
        for (int i = 0; i < n2; i += n) {
            for (int j = 0; j < n2; j += n) {
                graphics2D.drawImage(bufferedImage, null, j, i);
            }
        }
        graphics2D.dispose();
        return bufferedImage2;
    }

    @Override
    public dwan getIconBetterLeaves(int n, float f) {
        return null;
    }

    @Override
    public dwan getIconBetterLeavesSnowed(int n, float f) {
        return iconBetterLeavesSnowed == null ? null : iconBetterLeavesSnowed[(int)(f * (float)(iconBetterLeavesSnowed.length - 1) + 0.5f)];
    }

    @Override
    public dwan getIconFallingLeaves(int n) {
        return null;
    }

    @Override
    public float getSpawnChanceFallingLeaves(int n) {
        return 0.008f;
    }

    static {
        iconMap = new HashMap<String, dwan[]>();
        leafBlocks = new HashSet();
    }
}

