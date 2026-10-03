/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.crash;

import java.util.concurrent.Callable;
import net.minecraft.crash.CrashReport;

public class qlgf
implements Callable {
    public final /* synthetic */ CrashReport _a;

    public qlgf(CrashReport crashReport) {
        this._a = crashReport;
    }

    public String _a() {
        Runtime runtime = Runtime.getRuntime();
        long l = runtime.maxMemory();
        long l2 = runtime.totalMemory();
        long l3 = runtime.freeMemory();
        long l4 = l / 1024L / 1024L;
        long l5 = l2 / 1024L / 1024L;
        long l6 = l3 / 1024L / 1024L;
        return l3 + " bytes (" + l6 + " MB) / " + l2 + " bytes (" + l5 + " MB) up to " + l + " bytes (" + l4 + " MB)";
    }

    public /* synthetic */ Object call() {
        return this._a();
    }
}

