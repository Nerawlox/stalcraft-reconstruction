/*
 * Decompiled with CFR 0.152.
 */
import java.io.DataInput;
import java.io.DataOutput;

public class hdkw
extends cezg {
    public int _a;

    public hdkw() {
    }

    public hdkw(int n) {
        this._a = n;
    }

    @Override
    public void func_73267_a(DataInput dataInput) {
        this._a = dataInput.readByte();
    }

    @Override
    public void func_73273_a(DataOutput dataOutput) {
        dataOutput.writeByte(this._a & 0xFF);
    }

    @Override
    public void func_73279_a(elai elai2) {
        elai2.func_72458_a(this);
    }

    @Override
    public int func_73284_a() {
        return 1;
    }
}

