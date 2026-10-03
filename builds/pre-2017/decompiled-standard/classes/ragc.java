/*
 * Decompiled with CFR 0.152.
 */
import java.io.DataInput;
import java.io.DataOutput;

public class ragc
extends cezg {
    public int _a;
    public byte _b;

    public ragc() {
    }

    public ragc(int n, byte by) {
        this._a = n;
        this._b = by;
    }

    @Override
    public void func_73267_a(DataInput dataInput) {
        this._a = dataInput.readInt();
        this._b = dataInput.readByte();
    }

    @Override
    public void func_73273_a(DataOutput dataOutput) {
        dataOutput.writeInt(this._a);
        dataOutput.writeByte(this._b);
    }

    @Override
    public void func_73279_a(elai elai2) {
        elai2.func_72478_a(this);
    }

    @Override
    public int func_73284_a() {
        return 5;
    }

    @Override
    public boolean func_73278_e() {
        return true;
    }

    @Override
    public boolean func_73268_a(cezg cezg2) {
        ragc ragc2 = (ragc)cezg2;
        return ragc2._a == this._a;
    }

    @Override
    public boolean func_73277_a_() {
        return true;
    }
}

