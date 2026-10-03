/*
 * Decompiled with CFR 0.152.
 */
public class tdpx
extends turb<hank> {
    public tdpx(String string, String string2, String string3, String string4, int n) {
        super(string, string2, string3, string4, n);
    }

    public tdpx(String string, String string2, int n) {
        super(string, string2, n);
    }

    @Override
    public boolean _a(hank hank2) {
        return hank2._f();
    }

    public hank _g() {
        return new hank(this);
    }

    @Override
    public /* synthetic */ pzde _f() {
        return this._g();
    }
}

