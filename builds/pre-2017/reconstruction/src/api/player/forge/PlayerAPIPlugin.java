/*
 * Decompiled with CFR 0.152.
 */
package api.player.forge;

import cpw.mods.fml.relauncher.IFMLLoadingPlugin;
import java.util.Map;

@IFMLLoadingPlugin.MCVersion(value="1.6.4")
@IFMLLoadingPlugin.TransformerExclusions(value={"api.player.forge"})
public class PlayerAPIPlugin
implements IFMLLoadingPlugin {
    public static boolean isObfuscated;

    @Override
    @Deprecated
    public String[] getLibraryRequestClass() {
        return null;
    }

    @Override
    public String[] getASMTransformerClass() {
        return new String[]{"api.player.forge.PlayerAPITransformer"};
    }

    @Override
    public String getModContainerClass() {
        return "api.player.forge.PlayerAPIContainer";
    }

    @Override
    public String getSetupClass() {
        return null;
    }

    @Override
    public void injectData(Map<String, Object> map) {
        isObfuscated = (Boolean)map.get("runtimeDeobfuscationEnabled");
    }
}

