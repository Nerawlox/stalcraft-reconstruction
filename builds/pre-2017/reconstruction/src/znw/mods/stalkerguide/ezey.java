/*
 * Decompiled with CFR 0.152.
 */
package znw.mods.stalkerguide;

import gloomyfolken.hooklib.minecraft.HookLoader;
import gloomyfolken.mods.asm.MicroTransformer;

public class ezey
extends MicroTransformer {
    private static final String _a = "znw/mods/stalkerguide/StalkerguideHooks";

    @Override
    public void registerHooks() {
        HookLoader.registerHookContainer(_a);
    }
}

