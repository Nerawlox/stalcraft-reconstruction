/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cpw.mods.fml.common.FMLCommonHandler
 */
package ru.stalcraft.proxy;

import cpw.mods.fml.common.FMLCommonHandler;
import ru.stalcraft.proxy.IProxy;

public final class ProxyInstance {
    private final IProxy proxyInstance;

    public ProxyInstance(String clientSide, String serverSide) {
        IProxy proxy = null;
        try {
            proxy = FMLCommonHandler.instance().getSide().isClient() ? (IProxy)this.getClass().getClassLoader().loadClass(clientSide).newInstance() : (IProxy)this.getClass().getClassLoader().loadClass(serverSide).newInstance();
        }
        catch (Exception e2) {
            e2.printStackTrace();
        }
        this.proxyInstance = proxy;
    }

    public IProxy getProxy() {
        return this.proxyInstance;
    }
}

