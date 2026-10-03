/*
 * Decompiled with CFR 0.152.
 */
import java.io.DataInput;
import java.io.DataOutput;

public class gaet
extends cezg {
    public int _a;
    public int _b;
    public int _c;
    public String[] _d;

    public gaet() {
        this.field_73287_r = true;
    }

    public gaet(int n, int n2, int n3, String[] stringArray) {
        this.field_73287_r = true;
        this._a = n;
        this._b = n2;
        this._c = n3;
        this._d = new String[]{stringArray[0], stringArray[1], stringArray[2], stringArray[3]};
    }

    @Override
    public void func_73267_a(DataInput dataInput) {
        this._a = dataInput.readInt();
        this._b = dataInput.readShort();
        this._c = dataInput.readInt();
        this._d = new String[4];
        for (int i = 0; i < 4; ++i) {
            this._d[i] = gaet.func_73282_a(dataInput, 15);
        }
    }

    @Override
    public void func_73273_a(DataOutput dataOutput) {
        dataOutput.writeInt(this._a);
        dataOutput.writeShort(this._b);
        dataOutput.writeInt(this._c);
        for (int i = 0; i < 4; ++i) {
            gaet.func_73271_a(this._d[i], dataOutput);
        }
    }

    @Override
    public void func_73279_a(elai elai2) {
        elai2.func_72487_a(this);
    }

    @Override
    public int func_73284_a() {
        int n = 0;
        for (int i = 0; i < 4; ++i) {
            n += this._d[i].length();
        }
        return n;
    }
}

