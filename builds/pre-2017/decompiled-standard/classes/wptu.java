/*
 * Decompiled with CFR 0.152.
 */
import java.io.DataInput;
import java.io.DataOutput;
import java.util.List;

public class wptu
extends cezg {
    public int _a;
    public cvzo[] _b;

    public wptu() {
    }

    public wptu(int n, List list2) {
        this._a = n;
        this._b = new cvzo[list2.size()];
        for (int i = 0; i < this._b.length; ++i) {
            cvzo cvzo2 = (cvzo)list2.get(i);
            this._b[i] = cvzo2 == null ? null : cvzo2._l();
        }
    }

    @Override
    public void func_73267_a(DataInput dataInput) {
        this._a = dataInput.readByte();
        int n = dataInput.readShort();
        this._b = new cvzo[n];
        for (int i = 0; i < n; ++i) {
            this._b[i] = wptu.func_73276_c(dataInput);
        }
    }

    @Override
    public void func_73273_a(DataOutput dataOutput) {
        dataOutput.writeByte(this._a);
        dataOutput.writeShort(this._b.length);
        for (int i = 0; i < this._b.length; ++i) {
            wptu.func_73270_a(this._b[i], dataOutput);
        }
    }

    @Override
    public void func_73279_a(elai elai2) {
        elai2.func_72486_a(this);
    }

    @Override
    public int func_73284_a() {
        return 3 + this._b.length * 5;
    }
}

