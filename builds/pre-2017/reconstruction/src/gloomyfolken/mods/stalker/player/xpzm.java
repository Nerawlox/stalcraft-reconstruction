/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.stalker.player;

import gloomyfolken.hooklib.minecraft.HookLoader;
import gloomyfolken.mods.asm.MicroTransformer;

public class xpzm
extends MicroTransformer {
    public static final String _a = "gloomyfolken/mods/stalker/player/SkeletalSteveHooks";

    @Override
    public void registerHooks() {
        HookLoader.registerHookContainer(_a);
    }
}

