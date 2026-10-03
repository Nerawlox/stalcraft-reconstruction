/*
 * Decompiled with CFR 0.152.
 */
import java.io.DataInput;
import java.io.DataOutput;

public class grje
extends cezg {
    public String _a;
    public int _b;
    public int _c;
    public boolean _d;
    public int _e;
    public boolean _f;

    public grje() {
    }

    public grje(String string, int n, int n2, boolean bl, int n3, boolean bl2) {
        this._a = string;
        this._b = n;
        this._c = n2;
        this._d = bl;
        this._e = n3;
        this._f = bl2;
    }

    @Override
    public void func_73267_a(DataInput dataInput) {
        this._a = grje.func_73282_a(dataInput, 7);
        this._b = dataInput.readByte();
        byte by = dataInput.readByte();
        this._c = by & 7;
        this._d = (by & 8) == 8;
        this._e = dataInput.readByte();
        this._f = dataInput.readBoolean();
    }

    @Override
    public void func_73273_a(DataOutput dataOutput) {
        grje.func_73271_a(this._a, dataOutput);
        dataOutput.writeByte(this._b);
        dataOutput.writeByte(this._c | (this._d ? 1 : 0) << 3);
        dataOutput.writeByte(this._e);
        dataOutput.writeBoolean(this._f);
    }

    @Override
    public void func_73279_a(elai elai2) {
        elai2.func_72504_a(this);
    }

    @Override
    public int func_73284_a() {
        return 7;
    }

    public String _a() {
        return this._a;
    }

    public int _b() {
        return this._b;
    }

    public int _c() {
        return this._c;
    }

    public boolean _d() {
        return this._d;
    }

    public int _e() {
        return this._e;
    }

    public boolean _f() {
        return this._f;
    }

    @Override
    public boolean func_73278_e() {
        return true;
    }

    @Override
    public boolean func_73268_a(cezg cezg2) {
        return true;
    }
}

