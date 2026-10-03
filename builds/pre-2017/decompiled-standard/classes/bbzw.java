/*
 * Decompiled with CFR 0.152.
 */
import java.io.DataInput;
import java.io.DataOutput;

public class bbzw
extends cezg {
    public String _a;
    public boolean _b;
    public int _c;

    public bbzw() {
    }

    public bbzw(String string, boolean bl, int n) {
        this._a = string;
        this._b = bl;
        this._c = n;
    }

    @Override
    public void func_73267_a(DataInput dataInput) {
        this._a = bbzw.func_73282_a(dataInput, 16);
        this._b = dataInput.readByte() != 0;
        this._c = dataInput.readShort();
    }

    @Override
    public void func_73273_a(DataOutput dataOutput) {
        bbzw.func_73271_a(this._a, dataOutput);
        dataOutput.writeByte(this._b ? 1 : 0);
        dataOutput.writeShort(this._c);
    }

    @Override
    public void func_73279_a(elai elai2) {
        elai2.func_72480_a(this);
    }

    @Override
    public int func_73284_a() {
        return this._a.length() + 2 + 1 + 2;
    }
}

