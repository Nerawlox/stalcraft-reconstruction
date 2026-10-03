/*
 * Decompiled with CFR 0.152.
 */
import java.io.DataInput;
import java.io.DataOutput;

public class txlx
extends cezg {
    public int _a;

    public txlx() {
    }

    public txlx(int n) {
        this._a = n;
    }

    @Override
    public void func_73279_a(elai elai2) {
        elai2.func_72474_a(this);
    }

    @Override
    public void func_73267_a(DataInput dataInput) {
        this._a = dataInput.readByte();
    }

    @Override
    public void func_73273_a(DataOutput dataOutput) {
        dataOutput.writeByte(this._a);
    }

    @Override
    public int func_73284_a() {
        return 1;
    }
}

