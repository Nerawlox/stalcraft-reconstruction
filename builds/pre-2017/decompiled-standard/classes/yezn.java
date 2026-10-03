/*
 * Decompiled with CFR 0.152.
 */
import java.io.DataInput;
import java.io.DataOutput;

public class yezn
extends cezg {
    public int _a;
    public String _b;
    public String _c;
    public int _d;

    public yezn() {
    }

    public yezn(int n, String string, String string2, int n2) {
        this._a = n;
        this._b = string;
        this._c = string2;
        this._d = n2;
    }

    @Override
    public void func_73267_a(DataInput dataInput) {
        this._a = dataInput.readByte();
        this._b = yezn.func_73282_a(dataInput, 16);
        this._c = yezn.func_73282_a(dataInput, 255);
        this._d = dataInput.readInt();
    }

    @Override
    public void func_73273_a(DataOutput dataOutput) {
        dataOutput.writeByte(this._a);
        yezn.func_73271_a(this._b, dataOutput);
        yezn.func_73271_a(this._c, dataOutput);
        dataOutput.writeInt(this._d);
    }

    @Override
    public void func_73279_a(elai elai2) {
        elai2.func_72500_a(this);
    }

    @Override
    public int func_73284_a() {
        return 3 + 2 * this._b.length();
    }

    public int _a() {
        return this._a;
    }

    public String _b() {
        return this._b;
    }
}

