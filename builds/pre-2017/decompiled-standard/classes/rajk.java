/*
 * Decompiled with CFR 0.152.
 */
import java.io.DataInput;
import java.io.DataOutput;

public class rajk
extends cezg {
    public float _a;
    public int _b;
    public int _c;

    public rajk() {
    }

    public rajk(float f, int n, int n2) {
        this._a = f;
        this._b = n;
        this._c = n2;
    }

    @Override
    public void func_73267_a(DataInput dataInput) {
        this._a = dataInput.readFloat();
        this._c = dataInput.readShort();
        this._b = dataInput.readShort();
    }

    @Override
    public void func_73273_a(DataOutput dataOutput) {
        dataOutput.writeFloat(this._a);
        dataOutput.writeShort(this._c);
        dataOutput.writeShort(this._b);
    }

    @Override
    public void func_73279_a(elai elai2) {
        elai2.func_72522_a(this);
    }

    @Override
    public int func_73284_a() {
        return 4;
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

