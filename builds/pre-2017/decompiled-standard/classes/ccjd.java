/*
 * Decompiled with CFR 0.152.
 */
public abstract class ccjd {
    private srxg _a;

    protected void _a(srxg srxg2) {
        if (this._a != null) {
            throw new IllegalStateException("Command already registered!");
        }
        this._a = srxg2;
    }

    public srxg _b() {
        if (this._a == null) {
            throw new IllegalStateException("Command not registered");
        }
        return this._a;
    }

    public abstract void _a(String[] var1);

    public abstract String _a();

    public String _c() {
        return "";
    }
}

