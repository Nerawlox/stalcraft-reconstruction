/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.client;

import java.util.concurrent.Callable;
import net.minecraft.client.xpzm;

public class pidb
implements Callable {
    public final /* synthetic */ xpzm _a;

    public pidb(xpzm xpzm2) {
        this._a = xpzm2;
    }

    public String _a() {
        return this._a.__ah._c ? this._a.__ah._c() : "N/A (disabled)";
    }

    public /* synthetic */ Object call() {
        return this._a();
    }
}

