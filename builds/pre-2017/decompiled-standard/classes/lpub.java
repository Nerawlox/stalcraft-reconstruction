/*
 * Decompiled with CFR 0.152.
 */
import java.io.DataInput;
import java.io.DataOutput;

public class lpub
extends cezg {
    public int _a;
    public int _b;
    public String _c;
    public int _d;
    public boolean _e;
    public int _f;

    public lpub() {
    }

    public lpub(int n, int n2, String string, int n3, boolean bl) {
        this._a = n;
        this._b = n2;
        this._c = string;
        this._d = n3;
        this._e = bl;
    }

    public lpub(int n, int n2, String string, int n3, boolean bl, int n4) {
        this(n, n2, string, n3, bl);
        this._f = n4;
    }

    @Override
    public void func_73279_a(elai elai2) {
        elai2.func_72516_a(this);
    }

    @Override
    public void func_73267_a(DataInput dataInput) {
        this._a = dataInput.readByte() & 0xFF;
        this._b = dataInput.readByte() & 0xFF;
        this._c = lpub.func_73282_a(dataInput, 32);
        this._d = dataInput.readByte() & 0xFF;
        this._e = dataInput.readBoolean();
        if (this._b == 11) {
            this._f = dataInput.readInt();
        }
    }

    @Override
    public void func_73273_a(DataOutput dataOutput) {
        dataOutput.writeByte(this._a & 0xFF);
        dataOutput.writeByte(this._b & 0xFF);
        lpub.func_73271_a(this._c, dataOutput);
        dataOutput.writeByte(this._d & 0xFF);
        dataOutput.writeBoolean(this._e);
        if (this._b == 11) {
            dataOutput.writeInt(this._f);
        }
    }

    @Override
    public int func_73284_a() {
        if (this._b == 11) {
            return 8 + this._c.length();
        }
        return 4 + this._c.length();
    }
}

