/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.client;

import java.util.concurrent.Callable;
import net.minecraft.client.xpzm;

public class ugqx
implements Callable {
    public final /* synthetic */ xpzm _a;

    public ugqx(xpzm xpzm2) {
        this._a = xpzm2;
    }

    public String _a() {
        return this._a._B.getClass().getCanonicalName();
    }

    public /* synthetic */ Object call() {
        return this._a();
    }
}

