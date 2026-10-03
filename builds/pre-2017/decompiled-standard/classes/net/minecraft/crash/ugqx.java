/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.crash;

import java.util.concurrent.Callable;
import net.minecraft.crash.CrashReport;

public class ugqx
implements Callable {
    public final /* synthetic */ CrashReport _a;

    public ugqx(CrashReport crashReport) {
        this._a = crashReport;
    }

    public String _a() {
        return System.getProperty("os.name") + " (" + System.getProperty("os.arch") + ") version " + System.getProperty("os.version");
    }

    public /* synthetic */ Object call() {
        return this._a();
    }
}

