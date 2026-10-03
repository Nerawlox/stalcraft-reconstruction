/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.hooklib.minecraft;

import gloomyfolken.hooklib.asm.AsmHook;
import gloomyfolken.hooklib.asm.HookClassTransformer;
import gloomyfolken.hooklib.asm.HookInjectorClassVisitor;
import gloomyfolken.hooklib.minecraft.HookLibPlugin;
import gloomyfolken.hooklib.minecraft.HookLoader;
import gloomyfolken.hooklib.minecraft.PrimaryClassTransformer;
import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import net.minecraft.launchwrapper.IClassTransformer;
import org.objectweb.asm.ClassWriter;

public class MinecraftClassTransformer
extends HookClassTransformer
implements IClassTransformer {
    static MinecraftClassTransformer instance;
    private Map<Integer, String> methodNames;
    private static List<IClassTransformer> postTransformers;

    public MinecraftClassTransformer() {
        instance = this;
        if (HookLibPlugin.getObfuscated()) {
            try {
                long l = System.currentTimeMillis();
                this.methodNames = this.loadMethodNames();
                long l2 = System.currentTimeMillis() - l;
                this.logger.debug("Methods dictionary loaded in " + l2 + " ms");
            }
            catch (IOException iOException) {
                this.logger.severe("Can not load obfuscated method names", iOException);
            }
        }
        this.classMetadataReader = HookLoader.getDeobfuscationMetadataReader();
        this.hooksMap.putAll(PrimaryClassTransformer.instance.getHooksMap());
        PrimaryClassTransformer.instance.getHooksMap().clear();
        PrimaryClassTransformer.instance.registeredSecondTransformer = true;
    }

    private HashMap<Integer, String> loadMethodNames() throws IOException {
        InputStream inputStream = this.getClass().getResourceAsStream("/methods.bin");
        if (inputStream == null) {
            throw new IOException("Methods dictionary not found");
        }
        DataInputStream dataInputStream = new DataInputStream(new BufferedInputStream(inputStream));
        int n = dataInputStream.readInt();
        HashMap<Integer, String> hashMap = new HashMap<Integer, String>(n);
        for (int i = 0; i < n; ++i) {
            hashMap.put(dataInputStream.readInt(), dataInputStream.readUTF());
        }
        dataInputStream.close();
        return hashMap;
    }

    @Override
    public byte[] transform(String string, String string2, byte[] byArray) {
        byArray = this.transform(string2, byArray);
        for (int i = 0; i < postTransformers.size(); ++i) {
            byArray = postTransformers.get(i).transform(string, string2, byArray);
        }
        return byArray;
    }

    @Override
    protected HookInjectorClassVisitor createInjectorClassVisitor(ClassWriter classWriter, List<AsmHook> list2) {
        return new HookInjectorClassVisitor(this, classWriter, list2){

            @Override
            protected boolean isTargetMethod(AsmHook asmHook, String string, String string2) {
                String string3;
                if (HookLibPlugin.getObfuscated() && (string3 = (String)MinecraftClassTransformer.this.methodNames.get(MinecraftClassTransformer.getMethodId(string))) != null && super.isTargetMethod(asmHook, string3, string2)) {
                    return true;
                }
                return super.isTargetMethod(asmHook, string, string2);
            }
        };
    }

    public Map<Integer, String> getMethodNames() {
        return this.methodNames;
    }

    public static int getMethodId(String string) {
        if (string.startsWith("func_")) {
            int n = string.indexOf(95);
            int n2 = string.indexOf(95, n + 1);
            return Integer.valueOf(string.substring(n + 1, n2));
        }
        return -1;
    }

    public static void registerPostTransformer(IClassTransformer iClassTransformer) {
        postTransformers.add(iClassTransformer);
    }

    static {
        postTransformers = new ArrayList<IClassTransformer>();
    }
}

