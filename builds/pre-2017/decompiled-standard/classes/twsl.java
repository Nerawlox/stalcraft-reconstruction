/*
 * Decompiled with CFR 0.152.
 */
public class twsl
extends Exception {
    public final int _a;
    public final String _b;
    public final int _c;

    public twsl(int n, String string, int n2) {
        super(string);
        this._a = n;
        this._b = string;
        this._c = n2;
    }

    @Override
    public String toString() {
        if (this._c != -1) {
            return "Realms ( ErrorCode: " + this._c + " )";
        }
        return "Realms: " + this._b;
    }
}

