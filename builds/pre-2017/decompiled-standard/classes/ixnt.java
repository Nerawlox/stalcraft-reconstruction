/*
 * Decompiled with CFR 0.152.
 */
import java.io.DataInput;
import java.io.DataOutput;

public class ixnt
extends huhy {
    public short _c;

    public ixnt(String string) {
        super(string);
    }

    public ixnt(String string, short s) {
        super(string);
        this._c = s;
    }

    @Override
    public void _a(DataOutput dataOutput) {
        dataOutput.writeShort(this._c);
    }

    @Override
    public void _a(DataInput dataInput, int n) {
        this._c = dataInput.readShort();
    }

    @Override
    public byte _a() {
        return 2;
    }

    public String toString() {
        return "" + this._c;
    }

    @Override
    public huhy _c() {
        return new ixnt(this._b(), this._c);
    }

    @Override
    public boolean equals(Object object) {
        if (super.equals(object)) {
            ixnt ixnt2 = (ixnt)object;
            return this._c == ixnt2._c;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return super.hashCode() ^ this._c;
    }
}

