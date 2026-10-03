/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.crash;

import java.util.concurrent.Callable;
import net.minecraft.crash.CrashReport;
import net.minecraft.world.gen.layer.IntCache;

public class zwat
implements Callable {
    public final /* synthetic */ CrashReport _a;

    public zwat(CrashReport crashReport) {
        this._a = crashReport;
    }

    public String _a() {
        return IntCache._b();
    }

    public /* synthetic */ Object call() {
        return this._a();
    }
}

