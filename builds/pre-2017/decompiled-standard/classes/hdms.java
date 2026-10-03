/*
 * Decompiled with CFR 0.152.
 */
import java.io.DataInput;
import java.io.DataOutput;

public class hdms
extends cezg {
    public int _a;
    public int _b;
    public cvzo _c;

    public hdms() {
    }

    public hdms(int n, int n2, cvzo cvzo2) {
        this._a = n;
        this._b = n2;
        this._c = cvzo2 == null ? null : cvzo2._l();
    }

    @Override
    public void func_73267_a(DataInput dataInput) {
        this._a = dataInput.readInt();
        this._b = dataInput.readShort();
        this._c = hdms.func_73276_c(dataInput);
    }

    @Override
    public void func_73273_a(DataOutput dataOutput) {
        dataOutput.writeInt(this._a);
        dataOutput.writeShort(this._b);
        hdms.func_73270_a(this._c, dataOutput);
    }

    @Override
    public void func_73279_a(elai elai2) {
        elai2.func_72506_a(this);
    }

    @Override
    public int func_73284_a() {
        return 8;
    }

    public cvzo _a() {
        return this._c;
    }

    @Override
    public boolean func_73278_e() {
        return true;
    }

    @Override
    public boolean func_73268_a(cezg cezg2) {
        hdms hdms2 = (hdms)cezg2;
        return hdms2._a == this._a && hdms2._b == this._b;
    }
}

