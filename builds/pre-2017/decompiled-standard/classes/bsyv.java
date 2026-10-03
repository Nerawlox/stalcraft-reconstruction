/*
 * Decompiled with CFR 0.152.
 */
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class bsyv
extends huhy {
    public List _c = new ArrayList();
    public byte _d;

    public bsyv() {
        super("");
    }

    public bsyv(String string) {
        super(string);
    }

    @Override
    public void _a(DataOutput dataOutput) throws IOException {
        this._d = !this._c.isEmpty() ? ((huhy)this._c.get(0))._a() : (byte)1;
        dataOutput.writeByte(this._d);
        dataOutput.writeInt(this._c.size());
        for (int i = 0; i < this._c.size(); ++i) {
            ((huhy)this._c.get(i))._a(dataOutput);
        }
    }

    @Override
    public void _a(DataInput dataInput, int n) throws IOException {
        if (n > 512) {
            throw new RuntimeException("Tried to read NBT tag with too high complexity, depth > 512");
        }
        this._d = dataInput.readByte();
        int n2 = dataInput.readInt();
        this._c = new ArrayList();
        for (int i = 0; i < n2; ++i) {
            huhy huhy2 = huhy._a(this._d, (String)null);
            huhy2._a(dataInput, n + 1);
            this._c.add(huhy2);
        }
    }

    @Override
    public byte _a() {
        return 9;
    }

    public String toString() {
        return "" + this._c.size() + " entries of type " + huhy._a(this._d);
    }

    public void _a(huhy huhy2) {
        this._d = huhy2._a();
        this._c.add(huhy2);
    }

    public huhy _a(int n) {
        return (huhy)this._c.remove(n);
    }

    public huhy _b(int n) {
        return (huhy)this._c.get(n);
    }

    public int _d() {
        return this._c.size();
    }

    @Override
    public huhy _c() {
        bsyv bsyv2 = new bsyv(this._b());
        bsyv2._d = this._d;
        for (huhy huhy2 : this._c) {
            huhy huhy3 = huhy2._c();
            bsyv2._c.add(huhy3);
        }
        return bsyv2;
    }

    @Override
    public boolean equals(Object object) {
        if (super.equals(object)) {
            bsyv bsyv2 = (bsyv)object;
            if (this._d == bsyv2._d) {
                return this._c.equals(bsyv2._c);
            }
        }
        return false;
    }

    @Override
    public int hashCode() {
        return super.hashCode() ^ this._c.hashCode();
    }
}

