/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.physics.ragdolls;

import gloomyfolken.hooklib.minecraft.HookLoader;
import gloomyfolken.mods.asm.MicroTransformer;

public class RagdollsMicroTransformer
extends MicroTransformer {
    @Override
    public void registerHooks() {
        HookLoader.registerHookContainer("gloomyfolken.mods.physics.ragdolls.RagdollsHooks");
    }
}

