/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.bundle.common.core.eidj;
import gloomyfolken.bundle.common.core.ezey;
import gloomyfolken.mods.trade.pidb;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;

public class kleu
extends ytyx {
    private long _a;

    public kleu(long l) {
        this._a = l;
    }

    public kleu() {
    }

    @Override
    public void write(DataOutput dataOutput) throws IOException {
        dataOutput.writeLong(this._a);
    }

    @Override
    public void read(DataInput dataInput) throws IOException {
        this._a = dataInput.readLong();
    }

    @Override
    @ezey(_a={eidj.CLIENT})
    public void processClient(EntityPlayer entityPlayer) {
        Minecraft minecraft = Minecraft._E();
        if (minecraft._B instanceof pidb) {
            ((pidb)minecraft._B)._e = this._a;
        }
    }
}

