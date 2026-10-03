/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.stalker.mobs;

import gloomyfolken.hooklib.minecraft.HookLoader;
import gloomyfolken.mods.asm.MicroTransformer;

public class StalkerMobsMicroTransformer
extends MicroTransformer {
    @Override
    public void registerHooks() {
        HookLoader.registerHookContainer("gloomyfolken.mods.stalker.mobs.StalkerMobsHooks");
    }
}

