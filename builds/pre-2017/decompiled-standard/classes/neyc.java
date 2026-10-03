/*
 * Decompiled with CFR 0.152.
 */
import java.io.DataInput;
import java.io.DataOutput;

public class neyc
extends cezg {
    public int _a;
    public int _b;
    public int _c;

    public neyc() {
    }

    public neyc(int n, int n2, int n3) {
        this._a = n;
        this._b = n2;
        this._c = n3;
    }

    @Override
    public void func_73279_a(elai elai2) {
        elai2.func_72505_a(this);
    }

    @Override
    public void func_73267_a(DataInput dataInput) {
        this._a = dataInput.readByte();
        this._b = dataInput.readShort();
        this._c = dataInput.readShort();
    }

    @Override
    public void func_73273_a(DataOutput dataOutput) {
        dataOutput.writeByte(this._a);
        dataOutput.writeShort(this._b);
        dataOutput.writeShort(this._c);
    }

    @Override
    public int func_73284_a() {
        return 5;
    }
}

