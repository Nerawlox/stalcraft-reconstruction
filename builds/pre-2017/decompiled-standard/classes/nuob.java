/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.bundle.common.core.eidj;
import gloomyfolken.bundle.common.core.ezey;
import gloomyfolken.mods.trade.pidb;
import gloomyfolken.mods.trade.qlgf;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import net.minecraft.client.xpzm;
import net.minecraft.entity.player.EntityPlayer;

public class nuob
extends ytyx {
    private qlgf _a;
    private qlgf _b;

    public nuob(qlgf qlgf2, qlgf qlgf3) {
        this._a = qlgf2;
        this._b = qlgf3;
    }

    @Override
    @ezey(_a={eidj.CLIENT})
    public void processClient(EntityPlayer entityPlayer) {
        xpzm xpzm2 = xpzm._E();
        if (xpzm2._B instanceof pidb) {
            ((pidb)xpzm2._B)._c = this._a;
            ((pidb)xpzm2._B)._d = this._b;
        }
    }

    public nuob() {
    }

    @Override
    public void read(DataInput dataInput) throws IOException {
        this._a = qlgf.values()[dataInput.readInt()];
        this._b = qlgf.values()[dataInput.readInt()];
    }

    @Override
    public void write(DataOutput dataOutput) throws IOException {
        dataOutput.writeInt(this._a.ordinal());
        dataOutput.writeInt(this._b.ordinal());
    }
}

