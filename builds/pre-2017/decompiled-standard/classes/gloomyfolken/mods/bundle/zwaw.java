/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.bundle;

import cpw.mods.fml.common.network.FMLNetworkHandler;
import gloomyfolken.bundle.common.core.eidj;
import gloomyfolken.bundle.common.core.ezey;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import net.minecraft.client.xpzm;
import net.minecraft.entity.player.EntityPlayer;

public class zwaw
extends ytyx {
    @Override
    @ezey(_a={eidj.CLIENT})
    protected void processClient(EntityPlayer entityPlayer) {
        xpzm xpzm2 = xpzm._E();
        xpzm2._z()._d()._a("Reconnecting", "Reconnecting");
        xpzm2._z()._a = true;
        FMLNetworkHandler.onConnectionClosed(xpzm2._z()._d(), entityPlayer);
        xpzm2._a((pkix)null);
        xpzm2._a(new ivbz(new fngq(), true));
    }

    @Override
    public void read(DataInput dataInput) throws IOException {
    }

    @Override
    public void write(DataOutput dataOutput) throws IOException {
    }
}

