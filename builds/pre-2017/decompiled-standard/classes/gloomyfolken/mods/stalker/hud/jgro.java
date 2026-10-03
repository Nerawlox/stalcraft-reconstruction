/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.stalker.hud;

import gloomyfolken.mods.stalker.hud.zwat;
import net.minecraft.client.xpzm;
import net.minecraft.entity.player.EntityPlayer;
import net.smart.moving.SmartMovingContext;
import net.smart.moving.SmartMovingFactory;
import net.smart.moving.SmartMovingSelf;

public class jgro
implements zwat {
    @Override
    public void _a() {
        SmartMovingContext.Options._displayExhaustionBar.value = Boolean.FALSE;
        SmartMovingContext.Options._displayJumpChargeBar.value = Boolean.FALSE;
    }

    @Override
    public float _b() {
        SmartMovingSelf smartMovingSelf = (SmartMovingSelf)SmartMovingFactory.getInstance(xpzm._E()._t);
        if (smartMovingSelf != null && SmartMovingContext.Config.enabled) {
            float f;
            float f2;
            float f3 = ((Float)SmartMovingContext.Config._jumpChargeMaximum.value).floatValue();
            float f4 = Math.min(smartMovingSelf.jumpCharge, f3);
            float f5 = f4 > (f2 = Math.min(smartMovingSelf.headJumpCharge, f = ((Float)SmartMovingContext.Config._headJumpChargeMaximum.value).floatValue())) ? f3 : f;
            float f6 = Math.max(f4, f2);
            return f6 / f5;
        }
        return 0.0f;
    }

    @Override
    public float _c() {
        SmartMovingSelf smartMovingSelf = (SmartMovingSelf)SmartMovingFactory.getInstance(xpzm._E()._t);
        if (smartMovingSelf != null && SmartMovingContext.Config.enabled) {
            float f = SmartMovingContext.Client.getMaximumExhaustion();
            float f2 = Math.min(smartMovingSelf.exhaustion, f);
            return f2 / f;
        }
        return 0.0f;
    }

    @Override
    public float _d() {
        return ((SmartMovingSelf)SmartMovingFactory.getInstance((EntityPlayer)xpzm._E()._t)).anticheat.__aT;
    }

    @Override
    public long _e() {
        return ((SmartMovingSelf)SmartMovingFactory.getInstance((EntityPlayer)xpzm._E()._t)).anticheat.__aS;
    }
}

