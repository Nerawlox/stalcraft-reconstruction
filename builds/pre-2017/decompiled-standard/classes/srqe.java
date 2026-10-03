/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.bundle.common.core.zwat;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.util.EnumSet;

public class srqe
extends zwat {
    public String _a;
    public vjsq _b;
    public int _c;
    public EnumSet<amww> _d;

    @Override
    public void write(DataOutput dataOutput) throws IOException {
        dataOutput.writeUTF(this._a);
        dataOutput.writeByte(this._b == null ? -1 : this._b.ordinal());
        dataOutput.writeInt(this._c);
        dataOutput.writeByte(this._d.size());
        for (amww amww2 : this._d) {
            dataOutput.writeByte(amww2.ordinal());
        }
    }

    @Override
    public void read(DataInput dataInput) throws IOException {
        this._a = dataInput.readUTF();
        byte by = dataInput.readByte();
        this._b = by < 0 ? null : vjsq.values()[by];
        this._c = dataInput.readInt();
        this._d = EnumSet.noneOf(amww.class);
        int n = dataInput.readByte();
        for (int i = 0; i < n; ++i) {
            this._d.add(amww.values()[dataInput.readByte()]);
        }
    }

    @Override
    public void processClient(boolean bl) {
        kkzc kkzc2 = yuch._a;
        kkzc2._a = this._a;
        kkzc2._b = this._b;
        kkzc2._l = this._c;
        kkzc2._c.clear();
        kkzc2._c.addAll(this._d);
    }
}

