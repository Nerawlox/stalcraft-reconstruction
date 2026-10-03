/*
 * Decompiled with CFR 0.152.
 */
import java.io.DataInput;
import java.io.DataOutput;
import java.util.ArrayList;
import java.util.Collection;

public class lpxb
extends cezg {
    public String _a = "";
    public String _b = "";
    public String _c = "";
    public String _d = "";
    public Collection _e = new ArrayList();
    public int _f;
    public int _g;

    public lpxb() {
    }

    public lpxb(dzew dzew2, int n) {
        this._a = dzew2._a();
        this._f = n;
        if (n == 0 || n == 2) {
            this._b = dzew2._b();
            this._c = dzew2._d();
            this._d = dzew2._e();
            this._g = dzew2._h();
        }
        if (n == 0) {
            this._e.addAll(dzew2._c());
        }
    }

    public lpxb(dzew dzew2, Collection collection, int n) {
        if (n != 3 && n != 4) {
            throw new IllegalArgumentException("Method must be join or leave for player constructor");
        }
        if (collection == null || collection.isEmpty()) {
            throw new IllegalArgumentException("Players cannot be null/empty");
        }
        this._f = n;
        this._a = dzew2._a();
        this._e.addAll(collection);
    }

    @Override
    public void func_73267_a(DataInput dataInput) {
        this._a = lpxb.func_73282_a(dataInput, 16);
        this._f = dataInput.readByte();
        if (this._f == 0 || this._f == 2) {
            this._b = lpxb.func_73282_a(dataInput, 32);
            this._c = lpxb.func_73282_a(dataInput, 16);
            this._d = lpxb.func_73282_a(dataInput, 16);
            this._g = dataInput.readByte();
        }
        if (this._f == 0 || this._f == 3 || this._f == 4) {
            int n = dataInput.readShort();
            for (int i = 0; i < n; ++i) {
                this._e.add(lpxb.func_73282_a(dataInput, 16));
            }
        }
    }

    @Override
    public void func_73273_a(DataOutput dataOutput) {
        lpxb.func_73271_a(this._a, dataOutput);
        dataOutput.writeByte(this._f);
        if (this._f == 0 || this._f == 2) {
            lpxb.func_73271_a(this._b, dataOutput);
            lpxb.func_73271_a(this._c, dataOutput);
            lpxb.func_73271_a(this._d, dataOutput);
            dataOutput.writeByte(this._g);
        }
        if (this._f == 0 || this._f == 3 || this._f == 4) {
            dataOutput.writeShort(this._e.size());
            for (String string : this._e) {
                lpxb.func_73271_a(string, dataOutput);
            }
        }
    }

    @Override
    public void func_73279_a(elai elai2) {
        elai2.func_96435_a(this);
    }

    @Override
    public int func_73284_a() {
        return 3 + this._a.length();
    }
}

