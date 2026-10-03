/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.anticheat;

import gloomyfolken.hooklib.asm.AsmHook;
import gloomyfolken.hooklib.minecraft.HookLoader;
import gloomyfolken.mods.asm.MicroTransformer;

public class eidj
extends MicroTransformer {
    private static final String _a = "gloomyfolken.mods.anticheat.AnticheatHooks";

    @Override
    public void registerHooks() {
        HookLoader.registerHook(AsmHook.newBuilder().setTargetClass("net.minecraft.network.NetServerHandler").setTargetMethod("teleport").addTargetMethodParameters("org.bukkit.Location").setHookClass(_a).setHookMethod("onBukkitTeleport").addThisToHookMethodParameters().setInjectorFactory(AsmHook.ON_EXIT_FACTORY).build());
        HookLoader.registerHook(AsmHook.newBuilder().setTargetClass("net.minecraft.network.NetServerHandler").setTargetMethod("teleport").addTargetMethodParameters("org.bukkit.Location").setHookClass(_a).setHookMethod("beforeBukkitTeleport").addThisToHookMethodParameters().build());
        HookLoader.registerHookContainer(_a);
    }
}

