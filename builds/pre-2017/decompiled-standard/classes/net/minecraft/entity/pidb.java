/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.entity;

import java.util.concurrent.Callable;
import net.minecraft.entity.ugqx;

public class pidb
implements Callable {
    public final /* synthetic */ int _a;
    public final /* synthetic */ ugqx _b;

    public pidb(ugqx ugqx2, int n) {
        this._b = ugqx2;
        this._a = n;
    }

    public String _a() {
        String string = "Once per " + this._a + " ticks";
        if (this._a == Integer.MAX_VALUE) {
            string = "Maximum (" + string + ")";
        }
        return string;
    }

    public /* synthetic */ Object call() {
        return this._a();
    }
}

