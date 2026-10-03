/*
 * Decompiled with CFR 0.152.
 */
import java.io.DataInput;
import java.io.DataOutput;

public class rrld
extends cezg {
    public long _a;
    public long _b;

    public rrld() {
    }

    public rrld(long l, long l2, boolean bl) {
        this._a = l;
        this._b = l2;
        if (!bl) {
            this._b = -this._b;
            if (this._b == 0L) {
                this._b = -1L;
            }
        }
    }

    @Override
    public void func_73267_a(DataInput dataInput) {
        this._a = dataInput.readLong();
        this._b = dataInput.readLong();
    }

    @Override
    public void func_73273_a(DataOutput dataOutput) {
        dataOutput.writeLong(this._a);
        dataOutput.writeLong(this._b);
    }

    @Override
    public void func_73279_a(elai elai2) {
        elai2.func_72497_a(this);
    }

    @Override
    public int func_73284_a() {
        return 16;
    }

    @Override
    public boolean func_73278_e() {
        return true;
    }

    @Override
    public boolean func_73268_a(cezg cezg2) {
        return true;
    }

    @Override
    public boolean func_73277_a_() {
        return true;
    }
}

