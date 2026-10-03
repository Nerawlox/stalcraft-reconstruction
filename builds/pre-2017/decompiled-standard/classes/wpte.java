/*
 * Decompiled with CFR 0.152.
 */
import java.io.DataInput;
import java.io.DataOutput;

public class wpte
extends cezg {
    public int _a;
    public int _b;
    public int _c;
    public int _d;
    public qoac _e;

    public wpte() {
        this.field_73287_r = true;
    }

    public wpte(int n, int n2, int n3, int n4, qoac qoac2) {
        this.field_73287_r = true;
        this._a = n;
        this._b = n2;
        this._c = n3;
        this._d = n4;
        this._e = qoac2;
    }

    @Override
    public void func_73267_a(DataInput dataInput) {
        this._a = dataInput.readInt();
        this._b = dataInput.readShort();
        this._c = dataInput.readInt();
        this._d = dataInput.readByte();
        this._e = wpte.func_73283_d(dataInput);
    }

    @Override
    public void func_73273_a(DataOutput dataOutput) {
        dataOutput.writeInt(this._a);
        dataOutput.writeShort(this._b);
        dataOutput.writeInt(this._c);
        dataOutput.writeByte((byte)this._d);
        wpte.func_73275_a(this._e, dataOutput);
    }

    @Override
    public void func_73279_a(elai elai2) {
        elai2.func_72468_a(this);
    }

    @Override
    public int func_73284_a() {
        return 25;
    }
}

