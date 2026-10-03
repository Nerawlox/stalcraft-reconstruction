/*
 * Decompiled with CFR 0.152.
 */
import java.io.DataInput;
import java.io.DataOutput;

public class yexp
extends cezg {
    public short _a;
    public short _b;
    public byte[] _c;

    public yexp() {
        this.field_73287_r = true;
    }

    public yexp(short s, short s2, byte[] byArray) {
        this.field_73287_r = true;
        this._a = s;
        this._b = s2;
        this._c = byArray;
    }

    @Override
    public void func_73267_a(DataInput dataInput) {
        this._a = dataInput.readShort();
        this._b = dataInput.readShort();
        this._c = new byte[dataInput.readUnsignedShort()];
        dataInput.readFully(this._c);
    }

    @Override
    public void func_73273_a(DataOutput dataOutput) {
        dataOutput.writeShort(this._a);
        dataOutput.writeShort(this._b);
        dataOutput.writeShort(this._c.length);
        dataOutput.write(this._c);
    }

    @Override
    public void func_73279_a(elai elai2) {
        elai2.func_72494_a(this);
    }

    @Override
    public int func_73284_a() {
        return 4 + this._c.length;
    }
}

