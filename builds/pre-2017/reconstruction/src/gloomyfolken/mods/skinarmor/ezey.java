/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.skinarmor;

import gloomyfolken.hooklib.minecraft.HookLoader;
import gloomyfolken.mods.asm.MicroTransformer;

public class ezey
extends MicroTransformer {
    @Override
    public void registerHooks() {
        HookLoader.registerHookContainer("gloomyfolken.mods.skinarmor.SkinArmorHooks");
    }
}

