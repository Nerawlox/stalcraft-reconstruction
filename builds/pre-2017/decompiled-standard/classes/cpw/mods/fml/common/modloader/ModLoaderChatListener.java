/*
 * Decompiled with CFR 0.152.
 */
package cpw.mods.fml.common.modloader;

import cpw.mods.fml.common.modloader.BaseModProxy;
import cpw.mods.fml.common.network.IChatListener;

public class ModLoaderChatListener
implements IChatListener {
    private BaseModProxy mod;

    public ModLoaderChatListener(BaseModProxy baseModProxy) {
        this.mod = baseModProxy;
    }

    @Override
    public cwaz serverChat(elai elai2, cwaz cwaz2) {
        this.mod.serverChat((xbvu)elai2, cwaz2._a);
        return cwaz2;
    }

    @Override
    public cwaz clientChat(elai elai2, cwaz cwaz2) {
        this.mod.clientChat(cwaz2._a);
        return cwaz2;
    }
}

