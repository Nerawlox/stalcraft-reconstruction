/*
 * Decompiled with CFR 0.152.
 */
package net.minecraftforge.common.network;

import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.network.NetworkModHandler;
import net.minecraftforge.common.ForgeDummyContainer;

public class ForgeNetworkHandler
extends NetworkModHandler {
    public ForgeNetworkHandler(ForgeDummyContainer forgeDummyContainer) {
        super(forgeDummyContainer, forgeDummyContainer.getClass().getAnnotation(NetworkMod.class));
        this.configureNetworkMod(forgeDummyContainer);
    }

    @Override
    public boolean acceptVersion(String string) {
        return true;
    }
}

