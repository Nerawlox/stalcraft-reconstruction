/*
 * Decompiled with CFR 0.152.
 */
package poersch.minecraft.bettergrassandleaves.renderer;

import java.util.Random;
import net.minecraft.util.dwan;
import poersch.minecraft.bettergrassandleaves.BetterGrassAndLeavesMod;
import poersch.minecraft.bettergrassandleaves.entity.EntityRisingSoulFX;
import poersch.minecraft.bettergrassandleaves.interfaces.IBetterSoulsand;
import poersch.minecraft.bettergrassandleaves.renderer.BlockRenderer;

public class BetterSoulsandRenderer
extends BlockRenderer
implements IBetterSoulsand {
    public static dwan[] iconRisingSoul;
    public static dwan[] iconSoulTrack;

    @Override
    public void onRegisterIcons(nege nege2) {
        iconRisingSoul = BetterSoulsandRenderer.registerBlockIcons("rising_soul");
        iconSoulTrack = BetterSoulsandRenderer.registerBlockIcons("soul_track");
    }

    @Override
    public boolean onRandomDisplayTick(twgu twgu2, ozlu ozlu2, int n, int n2, int n3, Random random) {
        if (ozlu2.field_73011_w._i == -1 && ozlu2.func_72799_c(n, n2 + 1, n3)) {
            int n4 = ozlu2.func_72805_g(n, n2, n3);
            if (random.nextFloat() > 1.0f - 0.06f * ((Float)BetterGrassAndLeavesMod.soulsFXSpawnRate.value).floatValue()) {
                IBetterSoulsand iBetterSoulsand = twgu2 instanceof IBetterSoulsand ? (IBetterSoulsand)((Object)twgu2) : this;
                dwan dwan2 = iBetterSoulsand.getIconRisingSoul(n4, random.nextFloat());
                if (dwan2 == null) {
                    return false;
                }
                double d = (double)n + 0.5;
                double d2 = (double)n2 + 0.5;
                double d3 = (double)n3 + 0.5;
                this.minecraft._w._a(new EntityRisingSoulFX(ozlu2, d, d2, d3, dwan2, iBetterSoulsand.getIconsSoulTrack(n4)));
            }
        }
        return false;
    }

    @Override
    public dwan getIconRisingSoul(int n, float f) {
        return iconRisingSoul == null ? null : iconRisingSoul[(int)(f * (float)(iconRisingSoul.length - 1) + 0.5f)];
    }

    @Override
    public dwan[] getIconsSoulTrack(int n) {
        return iconSoulTrack;
    }
}

