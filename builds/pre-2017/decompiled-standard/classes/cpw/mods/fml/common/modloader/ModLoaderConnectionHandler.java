/*
 * Decompiled with CFR 0.152.
 */
package cpw.mods.fml.common.modloader;

import cpw.mods.fml.common.modloader.BaseModProxy;
import cpw.mods.fml.common.modloader.ModLoaderHelper;
import cpw.mods.fml.common.network.IConnectionHandler;
import cpw.mods.fml.common.network.Player;
import net.minecraft.entity.player.EntityPlayer;

public class ModLoaderConnectionHandler
implements IConnectionHandler {
    private BaseModProxy mod;

    public ModLoaderConnectionHandler(BaseModProxy baseModProxy) {
        this.mod = baseModProxy;
    }

    @Override
    public void playerLoggedIn(Player player, elai elai2, jjpj jjpj2) {
        this.mod.onClientLogin((EntityPlayer)player);
    }

    @Override
    public String connectionReceived(yezc yezc2, jjpj jjpj2) {
        return null;
    }

    @Override
    public void connectionOpened(elai elai2, String string, int n, jjpj jjpj2) {
        ModLoaderHelper.sidedHelper.clientConnectionOpened(elai2, jjpj2, this.mod);
    }

    @Override
    public void connectionClosed(jjpj jjpj2) {
        if (ModLoaderHelper.sidedHelper == null || !ModLoaderHelper.sidedHelper.clientConnectionClosed(jjpj2, this.mod)) {
            this.mod.serverDisconnect();
            this.mod.onClientLogout(jjpj2);
        }
    }

    @Override
    public void clientLoggedIn(elai elai2, jjpj jjpj2, txpf txpf2) {
        this.mod.serverConnect(elai2);
    }

    @Override
    public void connectionOpened(elai elai2, dzfd dzfd2, jjpj jjpj2) {
        ModLoaderHelper.sidedHelper.clientConnectionOpened(elai2, jjpj2, this.mod);
    }
}

