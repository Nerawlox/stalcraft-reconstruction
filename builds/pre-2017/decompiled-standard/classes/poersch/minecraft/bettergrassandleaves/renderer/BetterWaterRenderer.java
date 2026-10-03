/*
 * Decompiled with CFR 0.152.
 */
package poersch.minecraft.bettergrassandleaves.renderer;

import net.minecraft.entity.Entity;
import net.minecraft.util.dwan;
import poersch.minecraft.bettergrassandleaves.BetterGrassAndLeavesMod;
import poersch.minecraft.bettergrassandleaves.entity.EntityWaterSuspendFX;
import poersch.minecraft.bettergrassandleaves.renderer.BlockRenderer;

public class BetterWaterRenderer
extends BlockRenderer {
    public static dwan[] iconWaterSpray;
    public static dwan[] iconWaterSuspended;

    @Override
    public void onRegisterIcons(nege nege2) {
        iconWaterSpray = BetterWaterRenderer.registerBlockIcons("water_spray");
        iconWaterSuspended = BetterWaterRenderer.registerBlockIcons("water_suspended");
    }

    @Override
    public boolean onSpawnParticle(String string, ozlu ozlu2, double d, double d2, double d3, double d4, double d5, double d6, Entity entity) {
        if ((Integer)BetterGrassAndLeavesMod.waterSuspendedFX.value != 2) {
            return (Integer)BetterGrassAndLeavesMod.waterSuspendedFX.value == 0;
        }
        if (ozlu2.func_72803_f((int)d, (int)d2 + 1, (int)d3) == tflj._h) {
            dwan dwan2 = this.getIconWaterSuspended(0, (float)Math.random());
            if (dwan2 == null) {
                return true;
            }
            this.minecraft._w._a(new EntityWaterSuspendFX(ozlu2, d + Math.random(), d2 + Math.random(), d3 + Math.random(), dwan2));
        }
        return true;
    }

    protected boolean nearShore(sdrg sdrg2, int n, int n2, int n3) {
        if (sdrg2.func_72803_f(n - 1, n2, n3) != tflj._h) {
            return true;
        }
        if (sdrg2.func_72803_f(n + 1, n2, n3) != tflj._h) {
            return true;
        }
        if (sdrg2.func_72803_f(n, n2, n3 - 1) != tflj._h) {
            return true;
        }
        return sdrg2.func_72803_f(n, n2, n3 + 1) != tflj._h;
    }

    public dwan getIconWaterSpray(int n, float f) {
        return iconWaterSpray == null ? null : iconWaterSpray[(int)(f * (float)(iconWaterSpray.length - 1) + 0.5f)];
    }

    public dwan getIconWaterSuspended(int n, float f) {
        return iconWaterSuspended == null ? null : iconWaterSuspended[(int)(f * (float)(iconWaterSuspended.length - 1) + 0.5f)];
    }
}

