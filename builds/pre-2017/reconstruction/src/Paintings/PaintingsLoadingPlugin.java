/*
 * Decompiled with CFR 0.152.
 */
package Paintings;

import Paintings.PaintingsClassTransformer;
import cpw.mods.fml.relauncher.IFMLLoadingPlugin;
import java.util.Map;

public class PaintingsLoadingPlugin
implements IFMLLoadingPlugin {
    @Override
    public String[] getLibraryRequestClass() {
        return null;
    }

    @Override
    public String[] getASMTransformerClass() {
        return new String[]{PaintingsClassTransformer.class.getName()};
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
}

