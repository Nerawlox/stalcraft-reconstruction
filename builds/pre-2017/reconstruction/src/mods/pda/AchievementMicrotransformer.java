/*
 * Decompiled with CFR 0.152.
 */
package mods.pda;

import gloomyfolken.hooklib.minecraft.HookLoader;
import gloomyfolken.mods.asm.MicroTransformer;

public class AchievementMicrotransformer
extends MicroTransformer {
    @Override
    public void registerHooks() {
        HookLoader.registerHookContainer("mods.pda.AchievementHooks");
    }
}

