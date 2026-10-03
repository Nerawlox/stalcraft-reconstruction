/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.hooklib.asm.AsmHook;
import gloomyfolken.hooklib.asm.ReturnCondition;
import gloomyfolken.hooklib.asm.ReturnValue;
import gloomyfolken.hooklib.minecraft.HookLoader;
import gloomyfolken.mods.asm.MicroTransformer;
import org.objectweb.asm.Type;

public class mqyc
extends MicroTransformer {
    private final String _a = "gloomyfolken/mods/effects/client/asm/EffectsHooks";

    @Override
    public void registerHooks() {
        HookLoader.registerHookContainer("gloomyfolken/mods/effects/client/asm/EffectsHooks".replace('/', '.'));
        HookLoader.registerHook(AsmHook.newBuilder().setTargetClass("net.minecraft.block.Block").setTargetMethod("shouldSideBeRendered").addTargetMethodParameters("net.minecraft.world.IBlockAccess").addTargetMethodParameters(Type.INT_TYPE, Type.INT_TYPE, Type.INT_TYPE, Type.INT_TYPE).setTargetMethodReturnType(Type.BOOLEAN_TYPE).setHookClass("gloomyfolken/mods/effects/client/asm/EffectsHooks").setHookMethod("shouldSideBeRendered").addHookMethodParameter(Type.INT_TYPE, 5).setReturnCondition(ReturnCondition.ON_TRUE).setReturnValue(ReturnValue.PRIMITIVE_CONSTANT).setPrimitiveConstant(false).build());
    }
}

