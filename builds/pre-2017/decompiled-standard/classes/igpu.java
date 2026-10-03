/*
 * Decompiled with CFR 0.152.
 */
import java.io.DataInput;
import java.io.DataOutput;

public class igpu
extends cezg {
    public int _a;
    public int _b;
    public int _c;
    public int _d;
    public int _e;

    public igpu() {
    }

    public igpu(int n, int n2, int n3, int n4, int n5) {
        this._a = n;
        this._b = n2;
        this._c = n3;
        this._d = n4;
        this._e = n5;
    }

    @Override
    public void func_73267_a(DataInput dataInput) {
        this._a = dataInput.readInt();
        this._b = dataInput.readInt();
        this._c = dataInput.readInt();
        this._d = dataInput.readInt();
        this._e = dataInput.readUnsignedByte();
    }

    @Override
    public void func_73273_a(DataOutput dataOutput) {
        dataOutput.writeInt(this._a);
        dataOutput.writeInt(this._b);
        dataOutput.writeInt(this._c);
        dataOutput.writeInt(this._d);
        dataOutput.write(this._e);
    }

    @Override
    public void func_73279_a(elai elai2) {
        elai2.func_72465_a(this);
    }

    @Override
    public int func_73284_a() {
        return 13;
    }

    public int _a() {
        return this._a;
    }

    public int _b() {
        return this._b;
    }

    public int _c() {
        return this._c;
    }

    public int _d() {
        return this._d;
    }

    public int _e() {
        return this._e;
    }

    @Override
    public boolean func_73278_e() {
        return true;
    }

    @Override
    public boolean func_73268_a(cezg cezg2) {
        igpu igpu2 = (igpu)cezg2;
        return igpu2._a == this._a;
    }
}

