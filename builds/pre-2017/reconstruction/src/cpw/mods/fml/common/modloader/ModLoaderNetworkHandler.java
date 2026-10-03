/*
 * Decompiled with CFR 0.152.
 */
package cpw.mods.fml.common.modloader;

import cpw.mods.fml.common.modloader.BaseModProxy;
import cpw.mods.fml.common.modloader.ModLoaderModContainer;
import cpw.mods.fml.common.network.NetworkModHandler;

public class ModLoaderNetworkHandler
extends NetworkModHandler {
    private BaseModProxy baseMod;

    public ModLoaderNetworkHandler(ModLoaderModContainer modLoaderModContainer) {
        super(modLoaderModContainer, null);
    }

    public void setBaseMod(BaseModProxy baseModProxy) {
        this.baseMod = baseModProxy;
    }

    @Override
    public boolean requiresClientSide() {
        return false;
    }

    @Override
    public boolean requiresServerSide() {
        return false;
    }

    @Override
    public boolean acceptVersion(String string) {
        return this.baseMod.getVersion().equals(string);
    }

    @Override
    public boolean isNetworkMod() {
        return true;
    }
}

