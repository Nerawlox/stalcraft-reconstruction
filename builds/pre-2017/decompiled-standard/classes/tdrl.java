/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.bundle.common.core.zwat;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import net.minecraft.client.xpzm;

public class tdrl
extends zwat {
    int _a;
    int _b;
    int _c;
    String _d;
    String _e;
    int _f;
    int _g;
    int _h;
    int _i;
    int _j;
    int _k;
    boolean _l;

    public tdrl(int n, int n2, int n3, String string, String string2, int n4, int n5, int n6, int n7, int n8, int n9, boolean bl) {
        this._a = n;
        this._b = n2;
        this._c = n3;
        this._d = string;
        this._e = string2;
        this._f = n4;
        this._g = n5;
        this._h = n6;
        this._i = n7;
        this._j = n8;
        this._k = n9;
        this._l = bl;
    }

    @Override
    public void processClient(boolean bl) {
        fmle fmle2 = (fmle)xpzm._E()._r.func_72796_p(this._a, this._b, this._c);
        fmle2._a(this._d, this._e, this._f, this._g, this._h, this._i, this._j, this._k, this._l);
    }

    public tdrl() {
    }

    @Override
    public void read(DataInput dataInput) throws IOException {
        this._a = dataInput.readInt();
        this._b = dataInput.readInt();
        this._c = dataInput.readInt();
        this._d = dataInput.readUTF();
        this._e = dataInput.readUTF();
        this._f = dataInput.readInt();
        this._g = dataInput.readInt();
        this._h = dataInput.readInt();
        this._i = dataInput.readInt();
        this._j = dataInput.readInt();
        this._k = dataInput.readInt();
        this._l = dataInput.readBoolean();
    }

    @Override
    public void write(DataOutput dataOutput) throws IOException {
        dataOutput.writeInt(this._a);
        dataOutput.writeInt(this._b);
        dataOutput.writeInt(this._c);
        dataOutput.writeUTF(this._d);
        dataOutput.writeUTF(this._e);
        dataOutput.writeInt(this._f);
        dataOutput.writeInt(this._g);
        dataOutput.writeInt(this._h);
        dataOutput.writeInt(this._i);
        dataOutput.writeInt(this._j);
        dataOutput.writeInt(this._k);
        dataOutput.writeBoolean(this._l);
    }
}

