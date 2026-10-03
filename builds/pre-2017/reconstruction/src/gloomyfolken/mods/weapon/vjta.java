/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.weapon;

import gloomyfolken.hooklib.minecraft.HookLoader;
import gloomyfolken.mods.asm.MicroTransformer;

public class vjta
extends MicroTransformer {
    @Override
    public void registerHooks() {
        HookLoader.registerHookContainer("gloomyfolken.mods.weapon.WeaponHooks");
    }
}

