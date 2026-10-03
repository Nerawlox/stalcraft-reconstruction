/*
 * Decompiled with CFR 0.152.
 */
import java.io.DataInput;
import java.io.DataOutput;

public class bbyg
extends cezg {
    public int _a;
    public int _b;

    public bbyg() {
    }

    public bbyg(int n, int n2) {
        this._a = n;
        this._b = n2;
    }

    @Override
    public void func_73267_a(DataInput dataInput) {
        this._a = dataInput.readInt();
        this._b = dataInput.readInt();
    }

    @Override
    public void func_73273_a(DataOutput dataOutput) {
        dataOutput.writeInt(this._a);
        dataOutput.writeInt(this._b);
    }

    @Override
    public void func_73279_a(elai elai2) {
        elai2.func_72475_a(this);
    }

    @Override
    public int func_73284_a() {
        return 8;
    }
}

