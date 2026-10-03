/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.bundle.common.core.qlgf;
import gloomyfolken.bundle.common.core.zwat;
import gloomyfolken.mods.core.misc.sajz;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import net.minecraft.entity.player.EntityPlayer;

public class ntyw
extends zwat {
    public qoac _a;
    public int _b;
    public int _c;
    public int _d;
    public boolean _e;

    public ntyw() {
    }

    public ntyw(hurg hurg2, boolean bl) {
        this._b = hurg2.field_70329_l;
        this._c = hurg2.field_70330_m;
        this._d = hurg2.field_70327_n;
        this._e = bl;
        if (!bl) {
            this._a = new qoac();
            hurg2.func_70310_b(this._a);
        }
    }

    protected <T extends hurg> void _a(T t, EntityPlayer entityPlayer) {
        ((sajz)((Object)t)).applyEdit(this._a, entityPlayer);
        t.func_70296_d();
        entityPlayer.field_70170_p.func_72845_h(this._b, this._c, this._d);
    }

    @Override
    public void read(DataInput dataInput) throws IOException {
        this._a = qlgf.readNBTTagCompound(dataInput);
        this._b = dataInput.readInt();
        this._c = dataInput.readInt();
        this._d = dataInput.readInt();
        this._e = dataInput.readBoolean();
    }

    @Override
    public void write(DataOutput dataOutput) throws IOException {
        qlgf.writeNBTTagCompound(this._a, dataOutput);
        dataOutput.writeInt(this._b);
        dataOutput.writeInt(this._c);
        dataOutput.writeInt(this._d);
        dataOutput.writeBoolean(this._e);
    }
}

