/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.bundle.common.core.eidj;
import gloomyfolken.bundle.common.core.ezey;
import gloomyfolken.bundle.common.core.qlgf;
import gloomyfolken.mods.stalker.misc.tupg;
import gloomyfolken.mods.stalker.misc.ugqx;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import net.minecraft.client.xpzm;
import net.minecraft.entity.player.EntityPlayer;

public class ydkq
extends ytyx {
    private int _a;
    private qoac _b;

    public ydkq(ugqx ugqx2) {
        this._a = ugqx2._c;
        this._b = new qoac();
        ugqx2._a(this._b);
    }

    @Override
    @ezey(_a={eidj.CLIENT})
    public void processClient(EntityPlayer entityPlayer) {
        tupg tupg2 = tupg._a(xpzm._E()._t);
        ugqx ugqx2 = new ugqx(tupg2.player);
        ugqx2._c = this._a;
        ugqx2._b(this._b);
        tupg2._a(ugqx2);
    }

    public ydkq() {
    }

    @Override
    public void read(DataInput dataInput) throws IOException {
        this._a = dataInput.readInt();
        this._b = qlgf.readNBTTagCompound(dataInput);
    }

    @Override
    public void write(DataOutput dataOutput) throws IOException {
        dataOutput.writeInt(this._a);
        qlgf.writeNBTTagCompound(this._b, dataOutput);
    }
}

