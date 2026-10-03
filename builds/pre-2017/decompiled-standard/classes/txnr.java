/*
 * Decompiled with CFR 0.152.
 */
import java.io.DataInput;
import java.io.DataOutput;
import net.minecraft.entity.Entity;
import net.minecraft.util.sajh;

public class txnr
extends cezg {
    public int _a;
    public int _b;
    public int _c;
    public int _d;
    public byte _e;
    public byte _f;

    public txnr() {
    }

    public txnr(Entity entity) {
        this._a = entity.field_70157_k;
        this._b = sajh._c(entity.field_70165_t * 32.0);
        this._c = sajh._c(entity.field_70163_u * 32.0);
        this._d = sajh._c(entity.field_70161_v * 32.0);
        this._e = (byte)(entity.field_70177_z * 256.0f / 360.0f);
        this._f = (byte)(entity.field_70125_A * 256.0f / 360.0f);
    }

    public txnr(int n, int n2, int n3, int n4, byte by, byte by2) {
        this._a = n;
        this._b = n2;
        this._c = n3;
        this._d = n4;
        this._e = by;
        this._f = by2;
    }

    @Override
    public void func_73267_a(DataInput dataInput) {
        this._a = dataInput.readInt();
        this._b = dataInput.readInt();
        this._c = dataInput.readInt();
        this._d = dataInput.readInt();
        this._e = dataInput.readByte();
        this._f = dataInput.readByte();
    }

    @Override
    public void func_73273_a(DataOutput dataOutput) {
        dataOutput.writeInt(this._a);
        dataOutput.writeInt(this._b);
        dataOutput.writeInt(this._c);
        dataOutput.writeInt(this._d);
        dataOutput.write(this._e);
        dataOutput.write(this._f);
    }

    @Override
    public void func_73279_a(elai elai2) {
        elai2.func_72512_a(this);
    }

    @Override
    public int func_73284_a() {
        return 34;
    }

    @Override
    public boolean func_73278_e() {
        return true;
    }

    @Override
    public boolean func_73268_a(cezg cezg2) {
        txnr txnr2 = (txnr)cezg2;
        return txnr2._a == this._a;
    }
}

