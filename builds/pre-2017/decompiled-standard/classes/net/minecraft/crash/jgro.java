/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.crash;

import java.util.concurrent.Callable;
import net.minecraft.crash.CrashReport;

public class jgro
implements Callable {
    public final /* synthetic */ CrashReport _a;

    public jgro(CrashReport crashReport) {
        this._a = crashReport;
    }

    public String _a() {
        return System.getProperty("java.version") + ", " + System.getProperty("java.vendor");
    }

    public /* synthetic */ Object call() {
        return this._a();
    }
}

