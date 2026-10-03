/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.util;

import net.minecraft.crash.CrashReport;

public class turb
extends RuntimeException {
    public final CrashReport _a;

    public turb(CrashReport crashReport) {
        this._a = crashReport;
    }

    public CrashReport _a() {
        return this._a;
    }

    @Override
    public Throwable getCause() {
        return this._a.func_71505_b();
    }

    @Override
    public String getMessage() {
        return this._a.func_71501_a();
    }
}

