/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.hooklib.asm.AsmHook;
import gloomyfolken.hooklib.asm.ReturnCondition;
import gloomyfolken.hooklib.minecraft.HookLoader;
import gloomyfolken.mods.asm.MicroTransformer;
import java.util.List;
import org.objectweb.asm.Type;

public class dxer
extends MicroTransformer {
    @Override
    public void registerHooks() {
        HookLoader.registerHookContainer("gloomyfolken.mods.prestitch.PrestitchHooks");
        HookLoader.registerHook(AsmHook.newBuilder().setTargetClass("net.minecraft.client.renderer.texture.TextureMap").setTargetMethod("loadTextureAtlas").addTargetMethodParameters("net.minecraft.client.resources.ResourceManager").setHookClass("gloomyfolken.mods.prestitch.PrestitchHooks").setHookMethod("loadTextureMap").addThisToHookMethodParameters().addHookMethodParameter("net.minecraft.client.resources.ResourceManager", 1).setReturnCondition(ReturnCondition.ON_TRUE).build());
        HookLoader.registerHook(AsmHook.newBuilder().setTargetClass("net.minecraft.client.renderer.texture.TextureMap").setTargetMethod("loadTextureAtlas").addTargetMethodParameters("net.minecraft.client.resources.ResourceManager").setHookClass("gloomyfolken.mods.prestitch.PrestitchHooks").setHookMethod("dumpTextureMap").addThisToHookMethodParameters().setInjectorFactory(AsmHook.ON_EXIT_FACTORY).build());
        HookLoader.registerHook(AsmHook.newBuilder().setTargetClass("net.minecraft.client.resources.SimpleReloadableResourceManager").setTargetMethod("reloadResources").addTargetMethodParameters(Type.getType(List.class)).setHookClass("gloomyfolken.mods.prestitch.PrestitchHooks").setHookMethod("onReloadResources").addThisToHookMethodParameters().addHookMethodParameter(Type.getType(List.class), 1).setReturnCondition(ReturnCondition.ON_TRUE).build());
        HookLoader.registerHook(AsmHook.newBuilder().setTargetClass("cpw.mods.fml.client.FMLClientHandler").setTargetMethod("onInitializationComplete").setHookClass("gloomyfolken.mods.prestitch.PrestitchHooks").setHookMethod("onInitializationComplete").setInjectorFactory(AsmHook.ON_EXIT_FACTORY).build());
    }
}

