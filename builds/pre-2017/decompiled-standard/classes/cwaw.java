/*
 * Decompiled with CFR 0.152.
 */
import java.io.DataInput;
import java.io.DataOutput;

public class cwaw
extends cezg {
    public int _a;
    public byte _b;
    public byte _c;
    public short _d;

    public cwaw() {
    }

    public cwaw(int n, supr supr2) {
        this._a = n;
        this._b = (byte)(supr2._a() & 0xFF);
        this._c = (byte)(supr2._c() & 0xFF);
        this._d = supr2._b() > Short.MAX_VALUE ? (short)Short.MAX_VALUE : (short)supr2._b();
    }

    @Override
    public void func_73267_a(DataInput dataInput) {
        this._a = dataInput.readInt();
        this._b = dataInput.readByte();
        this._c = dataInput.readByte();
        this._d = dataInput.readShort();
    }

    @Override
    public void func_73273_a(DataOutput dataOutput) {
        dataOutput.writeInt(this._a);
        dataOutput.writeByte(this._b);
        dataOutput.writeByte(this._c);
        dataOutput.writeShort(this._d);
    }

    public boolean _a() {
        return this._d == Short.MAX_VALUE;
    }

    @Override
    public void func_73279_a(elai elai2) {
        elai2.func_72503_a(this);
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
        cwaw cwaw2 = (cwaw)cezg2;
        return cwaw2._a == this._a && cwaw2._b == this._b;
    }
}

