/*
 * Decompiled with CFR 0.152.
 */
import java.io.DataInput;
import java.io.DataOutput;

public class plcv
extends cezg {
    public String _a = "";
    public String _b = "";
    public int _c;
    public int _d;

    public plcv() {
    }

    public plcv(cwdc cwdc2, int n) {
        this._a = cwdc2._d();
        this._b = cwdc2._c()._b();
        this._c = cwdc2._b();
        this._d = n;
    }

    public plcv(String string) {
        this._a = string;
        this._b = "";
        this._c = 0;
        this._d = 1;
    }

    @Override
    public void func_73267_a(DataInput dataInput) {
        this._a = plcv.func_73282_a(dataInput, 16);
        this._d = dataInput.readByte();
        if (this._d != 1) {
            this._b = plcv.func_73282_a(dataInput, 16);
            this._c = dataInput.readInt();
        }
    }

    @Override
    public void func_73273_a(DataOutput dataOutput) {
        plcv.func_73271_a(this._a, dataOutput);
        dataOutput.writeByte(this._d);
        if (this._d != 1) {
            plcv.func_73271_a(this._b, dataOutput);
            dataOutput.writeInt(this._c);
        }
    }

    @Override
    public void func_73279_a(elai elai2) {
        elai2.func_96437_a(this);
    }

    @Override
    public int func_73284_a() {
        return 2 + (this._a == null ? 0 : this._a.length()) + 2 + (this._b == null ? 0 : this._b.length()) + 4 + 1;
    }
}

