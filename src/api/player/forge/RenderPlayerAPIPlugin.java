/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cpw.mods.fml.relauncher.IFMLLoadingPlugin
 *  cpw.mods.fml.relauncher.IFMLLoadingPlugin$MCVersion
 *  cpw.mods.fml.relauncher.IFMLLoadingPlugin$TransformerExclusions
 */
package api.player.forge;

import cpw.mods.fml.relauncher.IFMLLoadingPlugin;
import java.util.Map;

@IFMLLoadingPlugin.MCVersion(value="1.6.4")
@IFMLLoadingPlugin.TransformerExclusions(value={"api.player.forge"})
public class RenderPlayerAPIPlugin
implements IFMLLoadingPlugin {
    public static boolean isObfuscated;

    @Deprecated
    public String[] getLibraryRequestClass() {
        return null;
    }

    public String[] getASMTransformerClass() {
        return new String[]{"api.player.forge.RenderPlayerAPITransformer"};
    }

    public String getModContainerClass() {
        return "api.player.forge.RenderPlayerAPIContainer";
    }

    public String getSetupClass() {
        return null;
    }

    public void injectData(Map<String, Object> var1) {
        isObfuscated = (Boolean)var1.get("runtimeDeobfuscationEnabled");
    }
}

