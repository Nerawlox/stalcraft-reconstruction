/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.crash;

import java.util.concurrent.Callable;
import net.minecraft.crash.CrashReport;
import net.minecraft.util.eidj;

public class ezey
implements Callable {
    public final /* synthetic */ CrashReport _a;

    public ezey(CrashReport crashReport) {
        this._a = crashReport;
    }

    public String _a() {
        int n = eidj._a()._c();
        int n2 = 56 * n;
        int n3 = n2 / 1024 / 1024;
        int n4 = eidj._a()._d();
        int n5 = 56 * n4;
        int n6 = n5 / 1024 / 1024;
        return n + " (" + n2 + " bytes; " + n3 + " MB) allocated, " + n4 + " (" + n5 + " bytes; " + n6 + " MB) used";
    }

    public /* synthetic */ Object call() {
        return this._a();
    }
}

