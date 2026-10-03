/*
 * Decompiled with CFR 0.152.
 */
package codechicken.lib.asm;

import codechicken.lib.asm.ASMHelper;
import codechicken.lib.asm.ObfMapping;
import cpw.mods.fml.common.asm.transformers.deobf.FMLDeobfuscatingRemapper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import net.minecraft.launchwrapper.IClassTransformer;
import net.minecraft.launchwrapper.Launch;
import net.minecraft.launchwrapper.LaunchClassLoader;
import org.objectweb.asm.tree.ClassNode;

public class ClassHeirachyManager
implements IClassTransformer {
    public static HashMap<String, SuperCache> superclasses = new HashMap();
    private static LaunchClassLoader cl = Launch.classLoader;

    public static String toKey(String string) {
        if (ObfMapping.obfuscated) {
            string = FMLDeobfuscatingRemapper.INSTANCE.map(string.replace('.', '/')).replace('/', '.');
        }
        return string;
    }

    public static String unKey(String string) {
        if (ObfMapping.obfuscated) {
            string = FMLDeobfuscatingRemapper.INSTANCE.unmap(string.replace('.', '/')).replace('/', '.');
        }
        return string;
    }

    public static boolean classExtends(String string, String string2) {
        if ((string = ClassHeirachyManager.toKey(string)).equals(string2 = ClassHeirachyManager.toKey(string2))) {
            return true;
        }
        SuperCache superCache = ClassHeirachyManager.declareClass(string);
        if (superCache == null) {
            return false;
        }
        superCache.flatten();
        return superCache.parents.contains(string2);
    }

    private static SuperCache declareClass(String string) {
        SuperCache superCache = superclasses.get(string = ClassHeirachyManager.toKey(string));
        if (superCache != null) {
            return superCache;
        }
        try {
            byte[] byArray = cl.getClassBytes(ClassHeirachyManager.unKey(string));
            if (byArray != null) {
                superCache = ClassHeirachyManager.declareASM(byArray);
            }
        }
        catch (Exception exception) {
            // empty catch block
        }
        if (superCache != null) {
            return superCache;
        }
        try {
            superCache = ClassHeirachyManager.declareReflection(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            // empty catch block
        }
        return superCache;
    }

    private static SuperCache declareReflection(String string) throws ClassNotFoundException {
        Class<?> clazz = Class.forName(string);
        SuperCache superCache = ClassHeirachyManager.getOrCreateCache(string);
        if (clazz.isInterface()) {
            superCache.superclass = "java.lang.Object";
        } else {
            if (string.equals("java.lang.Object")) {
                return superCache;
            }
            superCache.superclass = ClassHeirachyManager.toKey(clazz.getSuperclass().getName());
        }
        superCache.add(superCache.superclass);
        for (Class<?> clazz2 : clazz.getInterfaces()) {
            superCache.add(ClassHeirachyManager.toKey(clazz2.getName()));
        }
        return superCache;
    }

    private static SuperCache declareASM(byte[] byArray) {
        ClassNode classNode = ASMHelper.createClassNode(byArray);
        String string = ClassHeirachyManager.toKey(classNode.name);
        SuperCache superCache = ClassHeirachyManager.getOrCreateCache(string);
        superCache.superclass = ClassHeirachyManager.toKey(classNode.superName.replace('/', '.'));
        superCache.add(superCache.superclass);
        for (String string2 : classNode.interfaces) {
            superCache.add(ClassHeirachyManager.toKey(string2.replace('/', '.')));
        }
        return superCache;
    }

    @Override
    public byte[] transform(String string, String string2, byte[] byArray) {
        if (byArray == null) {
            return null;
        }
        if (!superclasses.containsKey(string2)) {
            ClassHeirachyManager.declareASM(byArray);
        }
        return byArray;
    }

    public static SuperCache getOrCreateCache(String string) {
        SuperCache superCache = superclasses.get(string);
        if (superCache == null) {
            superCache = new SuperCache();
            superclasses.put(string, superCache);
        }
        return superCache;
    }

    public static String getSuperClass(String string, boolean bl) {
        SuperCache superCache = ClassHeirachyManager.declareClass(string = ClassHeirachyManager.toKey(string));
        if (superCache == null) {
            return "java.lang.Object";
        }
        superCache.flatten();
        String string2 = superCache.superclass;
        if (!bl) {
            string2 = FMLDeobfuscatingRemapper.INSTANCE.unmap(string2);
        }
        return string2;
    }

    static {
        cl.addTransformerExclusion("codechicken.lib.asm");
    }

    public static class SuperCache {
        String superclass;
        public HashSet<String> parents = new HashSet();
        private boolean flattened;

        public void add(String string) {
            this.parents.add(string);
        }

        public void flatten() {
            if (this.flattened) {
                return;
            }
            for (String string : new ArrayList<String>(this.parents)) {
                SuperCache superCache = ClassHeirachyManager.declareClass(string);
                if (superCache == null) continue;
                superCache.flatten();
                this.parents.addAll(superCache.parents);
            }
            this.flattened = true;
        }
    }
}

