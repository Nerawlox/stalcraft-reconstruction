/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.bundle.common.core.eidj;
import gloomyfolken.bundle.common.core.ezey;
import gloomyfolken.bundle.common.core.zwat;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import znw.mods.stalkerguide.pidb;

public class loij
extends zwat {
    public String _a;
    public int _b;
    public int _c;
    public int _d;
    public int _e;

    @ezey(_a={eidj.CLIENT})
    public loij(int n, int n2, int n3) {
        boolean bl = pidb._b(this, n, n2, n3);
        if (bl) {
            boolean bl2 = bl;
            return;
        }
        this._b = n;
        this._c = n2;
        this._d = n3;
        this._a = "";
        pidb._a(this, n, n2, n3);
    }

    public loij() {
    }

    @Override
    public void read(DataInput dataInput) throws IOException {
        this._a = dataInput.readUTF();
        this._b = dataInput.readInt();
        this._c = dataInput.readInt();
        this._d = dataInput.readInt();
        this._e = dataInput.readInt();
    }

    @Override
    public void write(DataOutput dataOutput) throws IOException {
        dataOutput.writeUTF(this._a);
        dataOutput.writeInt(this._b);
        dataOutput.writeInt(this._c);
        dataOutput.writeInt(this._d);
        dataOutput.writeInt(this._e);
    }
}

