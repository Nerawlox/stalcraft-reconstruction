/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.stalker.player;

import gloomyfolken.bundle.common.core.eidj;
import gloomyfolken.bundle.common.core.ezey;
import gloomyfolken.hooklib.asm.Hook;
import gloomyfolken.hooklib.asm.ReturnCondition;
import gloomyfolken.mods.effects.client.mcsa.ezfa;
import gloomyfolken.mods.effects.client.mcsa.ezfc;
import net.minecraft.client.xpzm;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;

public class ugqx {
    @Hook(returnCondition=ReturnCondition.ALWAYS)
    @ezey(_a={eidj.CLIENT})
    public static void _a(xbdy xbdy2, EntityPlayer entityPlayer) {
        ezfc._a();
        hbcv._a(xpzm._E()._t, 1.0f, xpzm._E()._p._d);
        ezfc._a(0.095f, -0.061f, -0.294f);
        hbcv._a(40.0f);
        ivhj._a._c();
        ezfa._a._a();
        ezfc._b();
    }

    @Hook
    @ezey(_a={eidj.CLIENT})
    public static void _a(EntityLivingBase entityLivingBase) {
        if (entityLivingBase.field_70170_p.field_72995_K && entityLivingBase == xpzm._E()._t) {
            ivhj._a._d();
        }
    }
}

