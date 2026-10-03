/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.weapon;

import gloomyfolken.bundle.common.core.eidj;
import gloomyfolken.bundle.common.core.ezey;
import gloomyfolken.hooklib.asm.Hook;
import gloomyfolken.hooklib.asm.HookPriority;
import gloomyfolken.mods.weapon.ugqx;
import net.minecraft.client.entity.EntityClientPlayerMP;

public class xpzm {
    @Hook(priority=HookPriority.HIGHEST)
    @ezey(_a={eidj.CLIENT})
    public static void _a(EntityClientPlayerMP entityClientPlayerMP) {
        ugqx._a(entityClientPlayerMP)._b();
    }
}

