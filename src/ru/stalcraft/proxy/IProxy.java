/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cpw.mods.fml.common.event.FMLInitializationEvent
 *  cpw.mods.fml.common.event.FMLPostInitializationEvent
 *  cpw.mods.fml.common.event.FMLPreInitializationEvent
 */
package ru.stalcraft.proxy;

import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import java.io.File;
import ru.stalcraft.ejection.IEjectionManager;

public interface IProxy {
    public void preInit(FMLPreInitializationEvent var1);

    public void init(FMLInitializationEvent var1);

    public void postInit(FMLPostInitializationEvent var1);

    public File getMinecraftDir();

    public IEjectionManager getEjectionManager();

    public boolean isRemote();
}

