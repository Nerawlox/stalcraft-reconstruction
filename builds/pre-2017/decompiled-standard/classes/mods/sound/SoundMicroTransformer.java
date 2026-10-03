/*
 * Decompiled with CFR 0.152.
 */
package mods.sound;

import gloomyfolken.hooklib.minecraft.HookLoader;
import gloomyfolken.mods.asm.MicroTransformer;

public class SoundMicroTransformer
extends MicroTransformer {
    @Override
    public void registerHooks() {
        HookLoader.registerHookContainer("mods.sound.SoundHooks");
    }
}

