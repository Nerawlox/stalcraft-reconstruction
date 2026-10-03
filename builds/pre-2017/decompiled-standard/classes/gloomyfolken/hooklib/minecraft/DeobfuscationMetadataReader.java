/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.hooklib.minecraft;

import cpw.mods.fml.common.asm.transformers.deobf.FMLDeobfuscatingRemapper;
import gloomyfolken.hooklib.asm.ClassMetadataReader;
import gloomyfolken.hooklib.minecraft.HookLibPlugin;
import gloomyfolken.hooklib.minecraft.HookLoader;
import gloomyfolken.hooklib.minecraft.MinecraftClassTransformer;
import java.io.IOException;
import java.lang.reflect.Method;
import net.minecraft.launchwrapper.Launch;
import net.minecraft.launchwrapper.LaunchClassLoader;
import org.objectweb.asm.ClassVisitor;

public class DeobfuscationMetadataReader
extends ClassMetadataReader {
    private static Method runTransformers;

    @Override
    public byte[] getClassData(String string) throws IOException {
        byte[] byArray = super.getClassData(DeobfuscationMetadataReader.unmap(string));
        return DeobfuscationMetadataReader.deobfuscateClass(string, byArray);
    }

    @Override
    protected boolean checkSameMethod(String string, String string2, String string3, String string4) {
        return DeobfuscationMetadataReader.checkSameMethod(string, string3) && string2.equals(string4);
    }

    @Override
    protected ClassMetadataReader.MethodReference getMethodReferenceASM(String string, String string2, String string3) throws IOException {
        try {
            ClassMetadataReader.FindMethodClassVisitor findMethodClassVisitor = new ClassMetadataReader.FindMethodClassVisitor(string2, string3);
            byte[] byArray = DeobfuscationMetadataReader.getTransformedBytes(string);
            this.acceptVisitor(byArray, (ClassVisitor)findMethodClassVisitor);
            System.out.println("Checking " + string + "/" + DeobfuscationMetadataReader.unmap(string) + ", contains " + string2 + " " + string3 + ": " + findMethodClassVisitor.found + ", reference: " + findMethodClassVisitor.targetName);
            return findMethodClassVisitor.found ? new ClassMetadataReader.MethodReference(string, findMethodClassVisitor.targetName, findMethodClassVisitor.targetDesc) : null;
        }
        catch (Exception exception) {
            exception.printStackTrace();
            throw exception;
        }
    }

    static byte[] deobfuscateClass(String string, byte[] byArray) {
        if (HookLoader.deobfuscationTransformer != null) {
            byArray = HookLoader.deobfuscationTransformer.transform(string, string, byArray);
        }
        return byArray;
    }

    private static byte[] getTransformedBytes(String string) throws IOException {
        String string2 = DeobfuscationMetadataReader.unmap(string);
        byte[] byArray = Launch.classLoader.getClassBytes(string2);
        if (byArray == null) {
            System.out.println("Bytes for " + string2 + " not found");
            throw new RuntimeException();
        }
        try {
            byArray = (byte[])runTransformers.invoke(Launch.classLoader, string2, string, byArray);
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
        return byArray;
    }

    private static String unmap(String string) {
        return FMLDeobfuscatingRemapper.INSTANCE.unmap(string);
    }

    private static boolean checkSameMethod(String string, String string2) {
        if (HookLibPlugin.getObfuscated() && MinecraftClassTransformer.instance != null) {
            int n = MinecraftClassTransformer.getMethodId(string);
            String string3 = MinecraftClassTransformer.instance.getMethodNames().get(n);
            if (string3 != null && string3.equals(string2)) {
                return true;
            }
        }
        return string.equals(string2);
    }

    static {
        try {
            runTransformers = LaunchClassLoader.class.getDeclaredMethod("runTransformers", String.class, String.class, byte[].class);
            runTransformers.setAccessible(true);
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
    }
}

