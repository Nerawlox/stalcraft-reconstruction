/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.crash;

import java.util.concurrent.Callable;
import net.minecraft.crash.CrashReport;

public class tupg
implements Callable {
    public final /* synthetic */ CrashReport _a;

    public tupg(CrashReport crashReport) {
        this._a = crashReport;
    }

    public String _a() {
        return System.getProperty("java.vm.name") + " (" + System.getProperty("java.vm.info") + "), " + System.getProperty("java.vm.vendor");
    }

    public /* synthetic */ Object call() {
        return this._a();
    }
}

