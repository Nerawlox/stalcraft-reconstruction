/*
 * Decompiled with CFR 0.152.
 */
package net.minecraftforge.classloading;

import cpw.mods.fml.relauncher.IFMLLoadingPlugin;
import java.io.File;
import java.util.Map;

public class FMLForgePlugin
implements IFMLLoadingPlugin {
    public static boolean RUNTIME_DEOBF = false;
    public static File forgeLocation;

    @Override
    public String[] getLibraryRequestClass() {
        return null;
    }

    @Override
    public String[] getASMTransformerClass() {
        return new String[]{"net.minecraftforge.transformers.ForgeAccessTransformer", "net.minecraftforge.transformers.EventTransformer"};
    }

    @Override
    public String getModContainerClass() {
        return "net.minecraftforge.common.ForgeDummyContainer";
    }

    @Override
    public String getSetupClass() {
        return null;
    }

    @Override
    public void injectData(Map<String, Object> map) {
        RUNTIME_DEOBF = (Boolean)map.get("runtimeDeobfuscationEnabled");
        forgeLocation = (File)map.get("coremodLocation");
    }
}

