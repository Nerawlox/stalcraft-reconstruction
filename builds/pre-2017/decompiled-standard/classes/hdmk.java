/*
 * Decompiled with CFR 0.152.
 */
import java.io.DataInput;
import java.io.DataOutput;

public class hdmk
extends cezg {
    public int _a;
    public int _b;
    public int _c;
    public xtby _d;
    public nwix _e;

    public hdmk() {
    }

    public hdmk(int n, byte by, nwix nwix2, int n2, xtby xtby2) {
        this._a = n;
        this._b = by;
        this._c = n2;
        this._d = xtby2;
        this._e = nwix2;
    }

    @Override
    public void func_73279_a(elai elai2) {
        elai2.func_72483_a(this);
    }

    @Override
    public void func_73267_a(DataInput dataInput) {
        this._a = dataInput.readInt();
        this._b = dataInput.readByte();
        this._d = xtby._a(dataInput.readByte());
        this._c = dataInput.readShort();
        String string = hdmk.func_73282_a(dataInput, 16);
        this._e = nwix._a(string);
        if (this._e == null) {
            this._e = nwix._d;
        }
    }

    @Override
    public void func_73273_a(DataOutput dataOutput) {
        dataOutput.writeInt(this._a);
        dataOutput.writeByte(this._b);
        dataOutput.writeByte(this._d._a());
        dataOutput.writeShort(this._c);
        hdmk.func_73271_a(this._e._a(), dataOutput);
    }

    @Override
    public int func_73284_a() {
        return 8 + (this._e == null ? 0 : this._e._a().length());
    }
}

