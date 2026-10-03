/*
 * Decompiled with CFR 0.152.
 */
import java.io.DataInput;
import java.io.DataOutput;

public class xsxy
extends huhy {
    public String _c;

    public xsxy(String string) {
        super(string);
    }

    public xsxy(String string, String string2) {
        super(string);
        this._c = string2;
        if (string2 == null) {
            throw new IllegalArgumentException("Empty string not allowed");
        }
    }

    @Override
    public void _a(DataOutput dataOutput) {
        dataOutput.writeUTF(this._c);
    }

    @Override
    public void _a(DataInput dataInput, int n) {
        this._c = dataInput.readUTF();
    }

    @Override
    public byte _a() {
        return 8;
    }

    public String toString() {
        return "" + this._c;
    }

    @Override
    public huhy _c() {
        return new xsxy(this._b(), this._c);
    }

    @Override
    public boolean equals(Object object) {
        if (super.equals(object)) {
            xsxy xsxy2 = (xsxy)object;
            return this._c == null && xsxy2._c == null || this._c != null && this._c.equals(xsxy2._c);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return super.hashCode() ^ this._c.hashCode();
    }
}

