/*
 * Decompiled with CFR 0.152.
 */
import java.io.DataInput;
import java.io.DataOutput;

public class lpvs
extends cezg {
    public float _a;
    public float _b;
    public boolean _c;
    public boolean _d;

    public lpvs() {
    }

    public lpvs(float f, float f2, boolean bl, boolean bl2) {
        this._a = f;
        this._b = f2;
        this._c = bl;
        this._d = bl2;
    }

    @Override
    public void func_73267_a(DataInput dataInput) {
        this._a = dataInput.readFloat();
        this._b = dataInput.readFloat();
        this._c = dataInput.readBoolean();
        this._d = dataInput.readBoolean();
    }

    @Override
    public void func_73273_a(DataOutput dataOutput) {
        dataOutput.writeFloat(this._a);
        dataOutput.writeFloat(this._b);
        dataOutput.writeBoolean(this._c);
        dataOutput.writeBoolean(this._d);
    }

    @Override
    public void func_73279_a(elai elai2) {
        elai2.func_110774_a(this);
    }

    @Override
    public int func_73284_a() {
        return 10;
    }

    public float _a() {
        return this._a;
    }

    public float _b() {
        return this._b;
    }

    public boolean _c() {
        return this._c;
    }

    public boolean _d() {
        return this._d;
    }
}

