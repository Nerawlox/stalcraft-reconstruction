/*
 * Decompiled with CFR 0.152.
 */
public class zydl
extends klxf {
    public zydl(String string, int n, int n2) {
        super(string, n, n2);
    }

    public zydl _h() {
        try {
            this._a.setDoOutput(true);
            this._a.setRequestMethod("DELETE");
            this._a.connect();
            return this;
        }
        catch (Exception exception) {
            throw new htpz("Failed URL: " + this._c, exception);
        }
    }

    @Override
    public /* synthetic */ klxf _f() {
        return this._h();
    }
}

