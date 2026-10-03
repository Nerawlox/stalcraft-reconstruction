/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.money;

public interface kjui {
    public long _a();

    public void _a(long var1);

    public void _b(long var1);

    public void _c(long var1);

    public boolean _d(long var1);

    default public void _a(long l, kjui kjui2) {
        this._c(l);
        kjui2._b(l);
    }
}

