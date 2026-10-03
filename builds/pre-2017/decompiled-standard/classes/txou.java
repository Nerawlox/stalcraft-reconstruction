/*
 * Decompiled with CFR 0.152.
 */
import java.io.DataInput;
import java.io.DataOutput;

public class txou
extends cezg {
    public int _a;
    public String _b;

    public txou() {
    }

    public txou(int n, igri igri2) {
        this._a = n;
        this._b = igri2 == null ? "" : igri2._b();
    }

    @Override
    public void func_73267_a(DataInput dataInput) {
        this._a = dataInput.readByte();
        this._b = txou.func_73282_a(dataInput, 16);
    }

    @Override
    public void func_73273_a(DataOutput dataOutput) {
        dataOutput.writeByte(this._a);
        txou.func_73271_a(this._b, dataOutput);
    }

    @Override
    public void func_73279_a(elai elai2) {
        elai2.func_96438_a(this);
    }

    @Override
    public int func_73284_a() {
        return 3 + this._b.length();
    }
}

