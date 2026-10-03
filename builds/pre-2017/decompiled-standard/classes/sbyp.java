/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.bundle.common.core.zwat;
import gloomyfolken.mods.stalker.misc.StalkerMiscMod;
import gloomyfolken.mods.stalker.misc.zwaw;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.util.Map;

public class sbyp
extends zwat {
    private int _a;
    private float _b;
    private float _c;
    private boolean _d;

    public sbyp(int n, float f, float f2, boolean bl) {
        this._a = n;
        this._b = f;
        this._c = f2;
        this._d = bl;
    }

    @Override
    public void processClient(boolean bl) {
        Map<Integer, zwaw> map = StalkerMiscMod._Y._d;
        zwaw zwaw2 = map.get(this._a);
        if (zwaw2 == null) {
            zwaw2 = new zwaw(this._a, 0, this._b, this._c, System.currentTimeMillis(), this._d);
            map.put(this._a, zwaw2);
        } else {
            zwaw2._a(this._b);
            zwaw2._b(this._c);
            zwaw2._a(System.currentTimeMillis());
        }
    }

    public sbyp() {
    }

    @Override
    public void read(DataInput dataInput) throws IOException {
        this._a = dataInput.readInt();
        this._b = dataInput.readFloat();
        this._c = dataInput.readFloat();
        this._d = dataInput.readBoolean();
    }

    @Override
    public void write(DataOutput dataOutput) throws IOException {
        dataOutput.writeInt(this._a);
        dataOutput.writeFloat(this._b);
        dataOutput.writeFloat(this._c);
        dataOutput.writeBoolean(this._d);
    }
}

