/*
 * Decompiled with CFR 0.152.
 */
import java.io.DataInput;
import java.io.DataOutput;

public class cwan
extends cezg {
    public int _a;
    public int _b;
    public int _c;
    public int _d;
    public int _e;

    public cwan() {
        this.field_73287_r = true;
    }

    public cwan(int n, int n2, int n3, ozlu ozlu2) {
        this.field_73287_r = true;
        this._a = n;
        this._b = n2;
        this._c = n3;
        this._d = ozlu2.func_72798_a(n, n2, n3);
        this._e = ozlu2.func_72805_g(n, n2, n3);
    }

    @Override
    public void func_73267_a(DataInput dataInput) {
        this._a = dataInput.readInt();
        this._b = dataInput.readUnsignedByte();
        this._c = dataInput.readInt();
        this._d = dataInput.readShort();
        this._e = dataInput.readUnsignedByte();
    }

    @Override
    public void func_73273_a(DataOutput dataOutput) {
        dataOutput.writeInt(this._a);
        dataOutput.write(this._b);
        dataOutput.writeInt(this._c);
        dataOutput.writeShort(this._d);
        dataOutput.write(this._e);
    }

    @Override
    public void func_73279_a(elai elai2) {
        elai2.func_72456_a(this);
    }

    @Override
    public int func_73284_a() {
        return 11;
    }
}

