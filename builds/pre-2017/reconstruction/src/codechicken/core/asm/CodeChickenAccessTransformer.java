/*
 * Decompiled with CFR 0.152.
 */
package codechicken.core.asm;

import codechicken.core.asm.CodeChickenCoreModContainer;
import codechicken.lib.asm.ObfMapping;
import com.google.common.collect.ImmutableBiMap;
import cpw.mods.fml.common.asm.transformers.AccessTransformer;
import cpw.mods.fml.common.asm.transformers.deobf.FMLDeobfuscatingRemapper;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.LinkedList;
import java.util.List;

public class CodeChickenAccessTransformer
extends AccessTransformer {
    private static CodeChickenAccessTransformer instance;
    private static List<String> mapFileList;
    private static boolean makeAllPublic;
    private static Field f_classNameBiMap;
    private static Object emptyMap;

    public CodeChickenAccessTransformer() throws IOException {
        instance = this;
        for (String string : mapFileList) {
            this.readMapFile(string);
        }
        mapFileList = null;
        this.loadPublicConfig();
    }

    private void loadPublicConfig() {
        if (ObfMapping.obfuscated) {
            return;
        }
        makeAllPublic = CodeChickenCoreModContainer.config.getTag("dev.runtimePublic").setComment("Enabling this setting will make all minecraft classes public at runtime in MCP just as they are in modloader.\nYou should ONLY use this when you are testing with a mod that relies on runtime publicity and doesn't include access transformers.\nSuch mods are doing the wrong thing and should be fixed.").getBooleanValue(false);
        if (!makeAllPublic) {
            return;
        }
        try {
            f_classNameBiMap = FMLDeobfuscatingRemapper.class.getDeclaredField("classNameBiMap");
            f_classNameBiMap.setAccessible(true);
        }
        catch (Exception exception) {
            throw new RuntimeException(exception);
        }
    }

    public static void addTransformerMap(String string) {
        if (instance == null) {
            mapFileList.add(string);
        } else {
            instance.readMapFile(string);
        }
    }

    private void readMapFile(String string) {
        System.out.println("Adding Accesstransformer map: " + string);
        try {
            Method method = AccessTransformer.class.getDeclaredMethod("readMapFile", String.class);
            method.setAccessible(true);
            method.invoke(this, string);
        }
        catch (Exception exception) {
            throw new RuntimeException(exception);
        }
    }

    @Override
    public byte[] transform(String string, String string2, byte[] byArray) {
        boolean bl;
        boolean bl2 = bl = makeAllPublic && string.startsWith("net.minecraft.");
        if (bl) {
            this.setClassMap(string);
        }
        byArray = super.transform(string, string2, byArray);
        if (bl) {
            this.restoreClassMap();
        }
        return byArray;
    }

    private void restoreClassMap() {
        try {
            f_classNameBiMap.set(FMLDeobfuscatingRemapper.INSTANCE, emptyMap);
        }
        catch (Exception exception) {
            throw new RuntimeException(exception);
        }
    }

    private void setClassMap(String string) {
        try {
            f_classNameBiMap.set(FMLDeobfuscatingRemapper.INSTANCE, ImmutableBiMap.of(string.replace('.', '/'), ""));
        }
        catch (Exception exception) {
            throw new RuntimeException(exception);
        }
    }

    static {
        mapFileList = new LinkedList<String>();
        emptyMap = ImmutableBiMap.of();
    }
}

