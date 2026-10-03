/*
 * Decompiled with CFR 0.152.
 */
package obf.gloomyfolken.asm;

import cpw.mods.fml.relauncher.IFMLLoadingPlugin;
import gloomyfolken.hooklib.asm.AsmHook;
import gloomyfolken.hooklib.asm.ReturnCondition;
import gloomyfolken.hooklib.asm.ReturnValue;
import gloomyfolken.hooklib.minecraft.HookLoader;
import java.util.Map;
import org.objectweb.asm.Type;

public class ObfLoadingPlugin
implements IFMLLoadingPlugin {
    @Override
    public String[] getLibraryRequestClass() {
        return null;
    }

    @Override
    public String[] getASMTransformerClass() {
        return null;
    }

    @Override
    public String getModContainerClass() {
        return null;
    }

    @Override
    public String getSetupClass() {
        return null;
    }

    @Override
    public void injectData(Map<String, Object> map) {
        HookLoader.registerHook(AsmHook.newBuilder().setTargetClass("cpw.mods.fml.common.ModClassLoader").setTargetMethod("addModAPITransformer").addTargetMethodParameters("cpw.mods.fml.common.discovery.ASMDataTable").setTargetMethodReturnType("cpw.mods.fml.common.asm.transformers.ModAPITransformer").setReturnCondition(ReturnCondition.ALWAYS).setReturnValue(ReturnValue.NULL).build());
        HookLoader.registerHook(AsmHook.newBuilder().setTargetClass("cpw.mods.fml.common.registry.ItemData").setTargetMethod("<init>").addTargetMethodParameters("net.minecraft.item.Item").addTargetMethodParameters("cpw.mods.fml.common.ModContainer").setHookClass("obf.gloomyfolken.asm.ObfHooks").setHookMethod("fixItemType").addThisToHookMethodParameters().setInjectorFactory(AsmHook.ON_EXIT_FACTORY).build());
        HookLoader.registerHook(AsmHook.newBuilder().setTargetClass("cpw.mods.fml.common.ModClassLoader").setTargetMethod("loadBaseModClass").addTargetMethodParameters(Type.getType(String.class)).setTargetMethodReturnType(Type.getType(Class.class)).setHookClass("obf.gloomyfolken.asm.ObfHooks").setHookMethod("loadBaseModClass").addThisToHookMethodParameters().addHookMethodParameter(Type.getType(String.class), 1).setReturnCondition(ReturnCondition.ON_NOT_NULL).setReturnValue(ReturnValue.HOOK_RETURN_VALUE).build());
    }
}

