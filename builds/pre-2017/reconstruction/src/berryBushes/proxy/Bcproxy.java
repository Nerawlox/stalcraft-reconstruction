/*
 * Decompiled with CFR 0.152.
 */
package berryBushes.proxy;

import berryBushes.proxy.Bsproxy;
import berryBushes.te.BushTE;
import berryBushes.te.BushTESR;
import cpw.mods.fml.client.registry.ClientRegistry;

public class Bcproxy
extends Bsproxy {
    @Override
    public void init() {
        ClientRegistry.registerTileEntity(BushTE.class, "shrubbery", new BushTESR());
    }
}

