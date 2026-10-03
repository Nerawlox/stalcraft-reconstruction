/*
 * Decompiled with CFR 0.152.
 */
package mods.regions;

import gloomyfolken.hooklib.minecraft.HookLoader;
import gloomyfolken.mods.asm.MicroTransformer;

public class RegionsMicroTransformer
extends MicroTransformer {
    @Override
    public void registerHooks() {
        HookLoader.registerHookContainer("mods.regions.RegionsHooks");
    }
}

