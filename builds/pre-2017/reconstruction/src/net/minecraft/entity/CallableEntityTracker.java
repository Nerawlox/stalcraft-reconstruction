/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.entity;

import java.util.concurrent.Callable;
import net.minecraft.entity.EntityTracker;

public class CallableEntityTracker
implements Callable {
    public final /* synthetic */ int _a;
    public final /* synthetic */ EntityTracker _b;

    public CallableEntityTracker(EntityTracker entityTracker, int n) {
        this._b = entityTracker;
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

