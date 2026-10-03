/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.hooklib.minecraft.HookLoader;
import gloomyfolken.mods.asm.MicroTransformer;

public class gppb
extends MicroTransformer {
    @Override
    public void registerHooks() {
        HookLoader.registerHookContainer("gloomyfolken.mods.smartfix.SmartfixHooks");
    }
}

