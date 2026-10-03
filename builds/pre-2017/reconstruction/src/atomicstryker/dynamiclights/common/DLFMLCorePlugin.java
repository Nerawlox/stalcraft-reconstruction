/*
 * Decompiled with CFR 0.152.
 */
package atomicstryker.dynamiclights.common;

import cpw.mods.fml.relauncher.IFMLLoadingPlugin;
import java.util.Map;

public class DLFMLCorePlugin
implements IFMLLoadingPlugin {
    @Override
    public String[] getASMTransformerClass() {
        return new String[]{"atomicstryker.dynamiclights.common.DLTransformer"};
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
    }

    @Override
    public String[] getLibraryRequestClass() {
        return null;
    }
}

