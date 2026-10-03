/*
 * Decompiled with CFR 0.152.
 */
import java.io.DataInput;
import java.io.DataOutput;

public class sulv
extends cezg {
    public String _a;
    public String _b;
    public int _c;

    public sulv() {
    }

    public sulv(igri igri2, int n) {
        this._a = igri2._b();
        this._b = igri2._d();
        this._c = n;
    }

    @Override
    public void func_73267_a(DataInput dataInput) {
        this._a = sulv.func_73282_a(dataInput, 16);
        this._b = sulv.func_73282_a(dataInput, 32);
        this._c = dataInput.readByte();
    }

    @Override
    public void func_73273_a(DataOutput dataOutput) {
        sulv.func_73271_a(this._a, dataOutput);
        sulv.func_73271_a(this._b, dataOutput);
        dataOutput.writeByte(this._c);
    }

    @Override
    public void func_73279_a(elai elai2) {
        elai2.func_96436_a(this);
    }

    @Override
    public int func_73284_a() {
        return 2 + this._a.length() + 2 + this._b.length() + 1;
    }
}

