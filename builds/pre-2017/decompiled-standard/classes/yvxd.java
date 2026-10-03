/*
 * Decompiled with CFR 0.152.
 */
import java.io.DataInput;
import java.io.DataOutput;
import java.util.Arrays;

public class yvxd
extends huhy {
    public byte[] _c;

    public yvxd(String string) {
        super(string);
    }

    public yvxd(String string, byte[] byArray) {
        super(string);
        this._c = byArray;
    }

    @Override
    public void _a(DataOutput dataOutput) {
        dataOutput.writeInt(this._c.length);
        dataOutput.write(this._c);
    }

    @Override
    public void _a(DataInput dataInput, int n) {
        int n2 = dataInput.readInt();
        this._c = new byte[n2];
        dataInput.readFully(this._c);
    }

    @Override
    public byte _a() {
        return 7;
    }

    public String toString() {
        return "[" + this._c.length + " bytes]";
    }

    @Override
    public huhy _c() {
        byte[] byArray = new byte[this._c.length];
        System.arraycopy(this._c, 0, byArray, 0, this._c.length);
        return new yvxd(this._b(), byArray);
    }

    @Override
    public boolean equals(Object object) {
        if (super.equals(object)) {
            return Arrays.equals(this._c, ((yvxd)object)._c);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return super.hashCode() ^ Arrays.hashCode(this._c);
    }
}

