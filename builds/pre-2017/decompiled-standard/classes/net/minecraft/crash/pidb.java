/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.crash;

import java.util.concurrent.Callable;
import net.minecraft.crash.jxsn;

public final class pidb
implements Callable {
    public final /* synthetic */ int _a;
    public final /* synthetic */ int _b;
    public final /* synthetic */ int _c;

    public pidb(int n, int n2, int n3) {
        this._a = n;
        this._b = n2;
        this._c = n3;
    }

    public String _a() {
        return jxsn._a(this._a, this._b, this._c);
    }

    public /* synthetic */ Object call() {
        return this._a();
    }
}

