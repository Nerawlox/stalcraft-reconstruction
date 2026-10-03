/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.hooklib.minecraft;

import cpw.mods.fml.common.asm.transformers.deobf.FMLDeobfuscatingRemapper;
import gloomyfolken.hooklib.asm.AsmHook;
import gloomyfolken.hooklib.asm.HookClassTransformer;
import gloomyfolken.hooklib.asm.HookInjectorClassVisitor;
import gloomyfolken.hooklib.minecraft.HookLibPlugin;
import gloomyfolken.hooklib.minecraft.HookLoader;
import gloomyfolken.hooklib.minecraft.SecondaryTransformerHook;
import java.util.HashMap;
import java.util.List;
import net.minecraft.launchwrapper.IClassTransformer;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.Type;

public class PrimaryClassTransformer
extends HookClassTransformer
implements IClassTransformer {
    static PrimaryClassTransformer instance = new PrimaryClassTransformer();
    boolean registeredSecondTransformer;

    public PrimaryClassTransformer() {
        this.classMetadataReader = HookLoader.getDeobfuscationMetadataReader();
        if (instance != null) {
            this.hooksMap.putAll(instance.getHooksMap());
            instance.getHooksMap().clear();
        } else {
            this.registerHookContainer(SecondaryTransformerHook.class.getName());
        }
        instance = this;
    }

    @Override
    public byte[] transform(String string, String string2, byte[] byArray) {
        return this.transform(string2, byArray);
    }

    @Override
    protected HookInjectorClassVisitor createInjectorClassVisitor(ClassWriter classWriter, List<AsmHook> list) {
        return new HookInjectorClassVisitor(this, classWriter, list){

            @Override
            protected boolean isTargetMethod(AsmHook asmHook, String string, String string2) {
                return super.isTargetMethod(asmHook, string, PrimaryClassTransformer.mapDesc(string2));
            }
        };
    }

    HashMap<String, List<AsmHook>> getHooksMap() {
        return this.hooksMap;
    }

    static String mapDesc(String string) {
        if (!HookLibPlugin.getObfuscated()) {
            return string;
        }
        Type type = Type.getMethodType(string);
        Type type2 = PrimaryClassTransformer.map(type.getReturnType());
        Type[] typeArray = type.getArgumentTypes();
        Type[] typeArray2 = new Type[typeArray.length];
        for (int i = 0; i < typeArray2.length; ++i) {
            typeArray2[i] = PrimaryClassTransformer.map(typeArray[i]);
        }
        return Type.getMethodDescriptor(type2, typeArray2);
    }

    static Type map(Type type) {
        if (!HookLibPlugin.getObfuscated()) {
            return type;
        }
        if (type.getSort() < 9) {
            return type;
        }
        if (type.getSort() == 9) {
            int n;
            StringBuilder stringBuilder = new StringBuilder();
            for (n = 0; n < type.getDimensions(); ++n) {
                stringBuilder.append("[");
            }
            int n2 = n = type.getSort() < 9 ? 1 : 0;
            if (n == 0) {
                stringBuilder.append("L");
            }
            stringBuilder.append(PrimaryClassTransformer.map(type.getElementType()).getInternalName());
            if (n == 0) {
                stringBuilder.append(";");
            }
            return Type.getType(stringBuilder.toString());
        }
        if (type.getSort() == 10) {
            String string = FMLDeobfuscatingRemapper.INSTANCE.map(type.getInternalName());
            return Type.getType("L" + string + ";");
        }
        throw new IllegalArgumentException("Can not map method type!");
    }
}

