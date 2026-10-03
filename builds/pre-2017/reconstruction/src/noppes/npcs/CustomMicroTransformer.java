/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs;

import gloomyfolken.hooklib.asm.AsmHook;
import gloomyfolken.hooklib.asm.ReturnCondition;
import gloomyfolken.hooklib.asm.ReturnValue;
import gloomyfolken.hooklib.minecraft.HookLoader;
import gloomyfolken.mods.asm.MicroTransformer;

public class CustomMicroTransformer
extends MicroTransformer {
    @Override
    public void registerHooks() {
        HookLoader.registerHookContainer("noppes.npcs.CustomHooks");
        HookLoader.registerHook(AsmHook.newBuilder().setTargetClass("poersch.minecraft.bettergrassandleaves.renderer.BlockRendererList").setTargetMethod("onSpawnParticleHook").addTargetMethodParameters("java.lang.String", "net.minecraft.world.World", "double", "double", "double", "double", "double", "double", "net.minecraft.entity.Entity").setHookClass("noppes.npcs.CustomHooks").setHookMethod("onSpawnParticle").addHookMethodParameter("java.lang.String", 1).addHookMethodParameter("net.minecraft.entity.Entity", 15).setReturnCondition(ReturnCondition.ON_TRUE).setReturnValue(ReturnValue.PRIMITIVE_CONSTANT).setPrimitiveConstant(false).build());
    }
}

