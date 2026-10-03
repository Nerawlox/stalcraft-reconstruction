/*
 * Decompiled with CFR 0.152.
 */
import java.io.DataInput;
import java.io.DataOutput;

public class lptv
extends cezg {
    public int _a;
    public int _b;

    public lptv() {
    }

    public lptv(int n, int n2) {
        this._a = n;
        this._b = n2;
    }

    @Override
    public void func_73279_a(elai elai2) {
        elai2.func_72479_a(this);
    }

    @Override
    public void func_73267_a(DataInput dataInput) {
        this._a = dataInput.readByte();
        this._b = dataInput.readByte();
    }

    @Override
    public void func_73273_a(DataOutput dataOutput) {
        dataOutput.writeByte(this._a);
        dataOutput.writeByte(this._b);
    }

    @Override
    public int func_73284_a() {
        return 2;
    }
}

