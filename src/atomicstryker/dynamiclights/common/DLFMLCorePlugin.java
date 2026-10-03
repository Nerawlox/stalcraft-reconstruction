/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cpw.mods.fml.relauncher.IFMLLoadingPlugin
 */
package atomicstryker.dynamiclights.common;

import cpw.mods.fml.relauncher.IFMLLoadingPlugin;
import java.util.Map;

public class DLFMLCorePlugin
implements IFMLLoadingPlugin {
    public String[] getLibraryRequestClass() {
        return null;
    }

    public String[] getASMTransformerClass() {
        return new String[]{"atomicstryker.dynamiclights.common.DLTransformer"};
    }

    public String getModContainerClass() {
        return null;
    }

    public String getSetupClass() {
        return null;
    }

    public void injectData(Map data) {
    }
}

