/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.crash;

import java.util.concurrent.Callable;
import net.minecraft.crash.CrashReport;

public class jxtc
implements Callable {
    public final /* synthetic */ CrashReport _a;

    public jxtc(CrashReport crashReport) {
        this._a = crashReport;
    }

    public String _a() {
        return "1.6.4";
    }

    public /* synthetic */ Object call() {
        return this._a();
    }
}

