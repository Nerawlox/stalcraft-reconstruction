/*
 * Decompiled with CFR 0.152.
 */
import java.io.DataInput;
import java.io.DataOutput;

public class sdlz
extends cezg {
    public float _a;
    public int _b;
    public float _c;

    public sdlz() {
    }

    public sdlz(float f, int n, float f2) {
        this._a = f;
        this._b = n;
        this._c = f2;
    }

    @Override
    public void func_73267_a(DataInput dataInput) {
        this._a = dataInput.readFloat();
        this._b = dataInput.readShort();
        this._c = dataInput.readFloat();
    }

    @Override
    public void func_73273_a(DataOutput dataOutput) {
        dataOutput.writeFloat(this._a);
        dataOutput.writeShort(this._b);
        dataOutput.writeFloat(this._c);
    }

    @Override
    public void func_73279_a(elai elai2) {
        elai2.func_72521_a(this);
    }

    @Override
    public int func_73284_a() {
        return 8;
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

