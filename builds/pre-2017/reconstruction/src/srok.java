/*
 * Decompiled with CFR 0.152.
 */
public class srok
extends turb<kjwj> {
    public int _e;

    public srok(String string, String string2, String string3, String string4, int n, int n2) {
        super(string, string2, string3, string4, n);
        this._e = n2;
    }

    public srok(String string, String string2, int n) {
        super(string, string2, n);
    }

    @Override
    public boolean _a(kjwj kjwj2) {
        return kjwj2._f() >= this._e;
    }

    public kjwj _g() {
        return new kjwj(this);
    }

    @Override
    public /* synthetic */ pzde _f() {
        return this._g();
    }
}

