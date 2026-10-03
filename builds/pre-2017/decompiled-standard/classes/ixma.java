/*
 * Decompiled with CFR 0.152.
 */
import java.io.DataInput;
import java.io.DataOutput;

public class ixma
extends cezg {
    public int _a;
    public short _b;
    public boolean _c;

    public ixma() {
    }

    public ixma(int n, short s, boolean bl) {
        this._a = n;
        this._b = s;
        this._c = bl;
    }

    @Override
    public void func_73279_a(elai elai2) {
        elai2.func_72476_a(this);
    }

    @Override
    public void func_73267_a(DataInput dataInput) {
        this._a = dataInput.readByte();
        this._b = dataInput.readShort();
        this._c = dataInput.readByte() != 0;
    }

    @Override
    public void func_73273_a(DataOutput dataOutput) {
        dataOutput.writeByte(this._a);
        dataOutput.writeShort(this._b);
        dataOutput.writeByte(this._c ? 1 : 0);
    }

    @Override
    public int func_73284_a() {
        return 4;
    }
}

