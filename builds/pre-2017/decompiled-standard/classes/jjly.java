/*
 * Decompiled with CFR 0.152.
 */
import java.io.DataInput;
import java.io.DataOutput;

public class jjly
extends huhy {
    public float _c;

    public jjly(String string) {
        super(string);
    }

    public jjly(String string, float f) {
        super(string);
        this._c = f;
    }

    @Override
    public void _a(DataOutput dataOutput) {
        dataOutput.writeFloat(this._c);
    }

    @Override
    public void _a(DataInput dataInput, int n) {
        this._c = dataInput.readFloat();
    }

    @Override
    public byte _a() {
        return 5;
    }

    public String toString() {
        return "" + this._c;
    }

    @Override
    public huhy _c() {
        return new jjly(this._b(), this._c);
    }

    @Override
    public boolean equals(Object object) {
        if (super.equals(object)) {
            jjly jjly2 = (jjly)object;
            return this._c == jjly2._c;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return super.hashCode() ^ Float.floatToIntBits(this._c);
    }
}

