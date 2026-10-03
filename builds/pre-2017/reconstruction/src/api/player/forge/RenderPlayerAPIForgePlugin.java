/*
 * Decompiled with CFR 0.152.
 */
package api.player.forge;

import cpw.mods.fml.relauncher.IFMLLoadingPlugin;
import java.io.File;
import java.util.Map;

@IFMLLoadingPlugin.MCVersion(value="1.6.4")
@IFMLLoadingPlugin.TransformerExclusions(value={"api.player.forge"})
public class RenderPlayerAPIForgePlugin
implements IFMLLoadingPlugin {
    public static File location;

    @Override
    @Deprecated
    public String[] getLibraryRequestClass() {
        return null;
    }

    @Override
    public String[] getASMTransformerClass() {
        return new String[]{"api.player.forge.RenderPlayerAPIForgeTransformer"};
    }

    @Override
    public String getModContainerClass() {
        return "api.player.forge.RenderPlayerAPIForgeContainer";
    }

    @Override
    public String getSetupClass() {
        return null;
    }

    @Override
    public void injectData(Map<String, Object> map) {
        Object object = map.get("coremodLocation");
        if (object instanceof File) {
            location = (File)object;
        }
    }
}

