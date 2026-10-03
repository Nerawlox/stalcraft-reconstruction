/*
 * Decompiled with CFR 0.152.
 */
package obf.gloomyfolken.modlist;

import cpw.mods.fml.relauncher.IFMLLoadingPlugin;
import gloomyfolken.hooklib.asm.AsmHook;
import gloomyfolken.hooklib.minecraft.HookLoader;
import java.io.File;
import java.util.Map;
import net.minecraft.launchwrapper.Launch;
import org.objectweb.asm.Type;

public class ModListLoadingPlugin
implements IFMLLoadingPlugin {
    public ModListLoadingPlugin() {
        System.out.println("Registering ModListTransformer");
        Launch.classLoader.registerTransformer("obf.gloomyfolken.modlist.ModListTransformer");
    }

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
        HookLoader.registerHook(AsmHook.newBuilder().setTargetClass("cpw.mods.fml.common.ModContainerFactory").setTargetMethod("build").addTargetMethodParameters("cpw.mods.fml.common.discovery.asm.ASMModParser").addTargetMethodParameters(Type.getType(File.class)).addTargetMethodParameters("cpw.mods.fml.common.discovery.ModCandidate").setTargetMethodReturnType("cpw.mods.fml.common.ModContainer").setHookClass("obf.gloomyfolken.modlist.ModListHooks").setHookMethod("onModBuild").addHookMethodParameter("cpw.mods.fml.common.discovery.asm.ASMModParser", 1).addReturnValueToHookMethodParameters().setInjectorFactory(AsmHook.ON_EXIT_FACTORY).build());
        HookLoader.registerHook(AsmHook.newBuilder().setTargetClass("cpw.mods.fml.common.Loader").setTargetMethod("identifyMods").setTargetMethodReturnType("cpw.mods.fml.common.discovery.ModDiscoverer").setHookClass("obf.gloomyfolken.modlist.ModListHooks").setHookMethod("afterModsLoaded").setInjectorFactory(AsmHook.ON_EXIT_FACTORY).build());
    }
}

