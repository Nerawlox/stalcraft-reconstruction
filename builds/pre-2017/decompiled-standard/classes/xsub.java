/*
 * Decompiled with CFR 0.152.
 */
import java.io.DataInput;
import java.io.DataOutput;

public class xsub
extends huhy {
    public byte _c;

    public xsub(String string) {
        super(string);
    }

    public xsub(String string, byte by) {
        super(string);
        this._c = by;
    }

    @Override
    public void _a(DataOutput dataOutput) {
        dataOutput.writeByte(this._c);
    }

    @Override
    public void _a(DataInput dataInput, int n) {
        this._c = dataInput.readByte();
    }

    @Override
    public byte _a() {
        return 1;
    }

    public String toString() {
        return "" + this._c;
    }

    @Override
    public huhy _c() {
        return new xsub(this._b(), this._c);
    }

    @Override
    public boolean equals(Object object) {
        if (super.equals(object)) {
            xsub xsub2 = (xsub)object;
            return this._c == xsub2._c;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return super.hashCode() ^ this._c;
    }
}

