/*
 * Decompiled with CFR 0.152.
 */
package cpw.mods.fml.common.modloader;

import cpw.mods.fml.common.IFuelHandler;
import cpw.mods.fml.common.modloader.BaseModProxy;

public class ModLoaderFuelHelper
implements IFuelHandler {
    private BaseModProxy mod;

    public ModLoaderFuelHelper(BaseModProxy baseModProxy) {
        this.mod = baseModProxy;
    }

    @Override
    public int getBurnTime(cvzo cvzo2) {
        return this.mod.addFuel(cvzo2._d, cvzo2._j());
    }
}

