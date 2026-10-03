/*
 * Decompiled with CFR 0.152.
 */
import java.io.DataInput;
import java.io.DataOutput;
import java.util.Arrays;

public class qoak
extends huhy {
    public int[] _c;

    public qoak(String string) {
        super(string);
    }

    public qoak(String string, int[] nArray) {
        super(string);
        this._c = nArray;
    }

    @Override
    public void _a(DataOutput dataOutput) {
        dataOutput.writeInt(this._c.length);
        for (int i = 0; i < this._c.length; ++i) {
            dataOutput.writeInt(this._c[i]);
        }
    }

    @Override
    public void _a(DataInput dataInput, int n) {
        int n2 = dataInput.readInt();
        this._c = new int[n2];
        for (int i = 0; i < n2; ++i) {
            this._c[i] = dataInput.readInt();
        }
    }

    @Override
    public byte _a() {
        return 11;
    }

    public String toString() {
        return "[" + this._c.length + " bytes]";
    }

    @Override
    public huhy _c() {
        int[] nArray = new int[this._c.length];
        System.arraycopy(this._c, 0, nArray, 0, this._c.length);
        return new qoak(this._b(), nArray);
    }

    @Override
    public boolean equals(Object object) {
        if (super.equals(object)) {
            qoak qoak2 = (qoak)object;
            return this._c == null && qoak2._c == null || this._c != null && Arrays.equals(this._c, qoak2._c);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return super.hashCode() ^ Arrays.hashCode(this._c);
    }
}

