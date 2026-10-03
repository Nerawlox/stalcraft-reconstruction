/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.hooklib.minecraft;

import cpw.mods.fml.common.asm.transformers.DeobfuscationTransformer;
import cpw.mods.fml.relauncher.IFMLLoadingPlugin;
import gloomyfolken.hooklib.asm.AsmHook;
import gloomyfolken.hooklib.asm.ClassMetadataReader;
import gloomyfolken.hooklib.asm.HookClassTransformer;
import gloomyfolken.hooklib.minecraft.DeobfuscationMetadataReader;
import gloomyfolken.hooklib.minecraft.HookLibPlugin;
import gloomyfolken.hooklib.minecraft.MinecraftClassTransformer;
import gloomyfolken.hooklib.minecraft.PrimaryClassTransformer;
import java.util.Map;

public abstract class HookLoader
implements IFMLLoadingPlugin {
    static DeobfuscationTransformer deobfuscationTransformer;
    private static ClassMetadataReader deobfuscationMetadataReader;

    private static HookClassTransformer getTransformer() {
        return PrimaryClassTransformer.instance.registeredSecondTransformer ? MinecraftClassTransformer.instance : PrimaryClassTransformer.instance;
    }

    public static void registerHook(AsmHook asmHook) {
        HookLoader.getTransformer().registerHook(asmHook);
    }

    public static void registerHookContainer(String string) {
        HookLoader.getTransformer().registerHookContainer(string);
    }

    public static ClassMetadataReader getDeobfuscationMetadataReader() {
        return deobfuscationMetadataReader;
    }

    @Override
    public String[] getLibraryRequestClass() {
        return null;
    }

    public String getAccessTransformerClass() {
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
        this.registerHooks();
    }

    protected abstract void registerHooks();

    static {
        if (HookLibPlugin.getObfuscated()) {
            deobfuscationTransformer = new DeobfuscationTransformer();
        }
        deobfuscationMetadataReader = new DeobfuscationMetadataReader();
    }
}

