/*
 * Decompiled with CFR 0.152.
 */
package carpentersblocks;

import gloomyfolken.hooklib.minecraft.HookLoader;

public class CarpentersLoadingPlugin
extends HookLoader {
    @Override
    protected void registerHooks() {
        CarpentersLoadingPlugin.registerHookContainer("carpentersblocks.CarpentersHooks");
    }
}

