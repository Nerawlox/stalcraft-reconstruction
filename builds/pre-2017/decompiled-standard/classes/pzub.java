/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.bundle.common.core.zwat;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import net.minecraft.client.xpzm;

public class pzub
extends zwat {
    public int _a;
    public int _b;
    public int _c;
    public boolean _d;

    public pzub(jydd jydd2, boolean bl) {
        this._a = jydd2.field_70329_l;
        this._b = jydd2.field_70330_m;
        this._c = jydd2.field_70327_n;
        this._d = bl;
    }

    @Override
    public void processClient(boolean bl) {
        hurg hurg2 = xpzm._E()._t.field_70170_p.func_72796_p(this._a, this._b, this._c);
        if (hurg2 instanceof jydd) {
            ((jydd)hurg2)._a(this._d);
        }
    }

    public pzub() {
    }

    @Override
    public void read(DataInput dataInput) throws IOException {
        this._a = dataInput.readInt();
        this._b = dataInput.readInt();
        this._c = dataInput.readInt();
        this._d = dataInput.readBoolean();
    }

    @Override
    public void write(DataOutput dataOutput) throws IOException {
        dataOutput.writeInt(this._a);
        dataOutput.writeInt(this._b);
        dataOutput.writeInt(this._c);
        dataOutput.writeBoolean(this._d);
    }
}

