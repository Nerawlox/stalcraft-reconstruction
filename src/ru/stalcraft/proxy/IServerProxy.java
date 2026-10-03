/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cpw.mods.fml.common.event.FMLServerStartingEvent
 */
package ru.stalcraft.proxy;

import cpw.mods.fml.common.event.FMLServerStartingEvent;
import ru.stalcraft.clans.IClanManager;
import ru.stalcraft.clans.IFlagManager;
import ru.stalcraft.player.IAntiRelog;
import ru.stalcraft.proxy.IProxy;

public interface IServerProxy
extends IProxy {
    public void serverStart(FMLServerStartingEvent var1);

    public IFlagManager getFlagManager();

    public IClanManager getClanManager();

    public IAntiRelog getAntiRelog();
}

