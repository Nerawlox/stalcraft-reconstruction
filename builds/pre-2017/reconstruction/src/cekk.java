/*
 * Decompiled with CFR 0.152.
 */
public class cekk
extends RuntimeException {
    public Object[] _a;

    public cekk(String string, Object ... objectArray) {
        super(string);
        this._a = objectArray;
    }

    public Object[] _a() {
        return this._a;
    }
}

