/*
 * Decompiled with CFR 0.152.
 */
import java.io.DataInput;
import java.io.DataOutput;

public class bszz
extends cezg {
    public int _a;
    public byte _b;

    public bszz() {
    }

    public bszz(int n, byte by) {
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
        elai2.func_72485_a(this);
    }

    @Override
    public int func_73284_a() {
        return 5;
    }
}

