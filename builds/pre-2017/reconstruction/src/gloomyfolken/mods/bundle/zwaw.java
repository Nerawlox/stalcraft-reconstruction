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
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;

public class zwaw
extends ytyx {
    @Override
    @ezey(_a={eidj.CLIENT})
    protected void processClient(EntityPlayer entityPlayer) {
        Minecraft minecraft = Minecraft._E();
        minecraft._z()._d()._a("Reconnecting", "Reconnecting");
        minecraft._z()._a = true;
        FMLNetworkHandler.onConnectionClosed(minecraft._z()._d(), entityPlayer);
        minecraft._a((pkix)null);
        minecraft._a(new ivbz(new fngq(), true));
    }

    @Override
    public void read(DataInput dataInput) throws IOException {
    }

    @Override
    public void write(DataOutput dataOutput) throws IOException {
    }
}

