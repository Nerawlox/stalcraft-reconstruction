/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.crash;

import java.lang.management.ManagementFactory;
import java.lang.management.RuntimeMXBean;
import java.util.List;
import java.util.concurrent.Callable;
import net.minecraft.crash.CrashReport;

public class zwaw
implements Callable {
    public final /* synthetic */ CrashReport _a;

    public zwaw(CrashReport crashReport) {
        this._a = crashReport;
    }

    public String _a() {
        RuntimeMXBean runtimeMXBean = ManagementFactory.getRuntimeMXBean();
        List<String> list = runtimeMXBean.getInputArguments();
        int n = 0;
        StringBuilder stringBuilder = new StringBuilder();
        for (String string : list) {
            if (!string.startsWith("-X")) continue;
            if (n++ > 0) {
                stringBuilder.append(" ");
            }
            stringBuilder.append(string);
        }
        return String.format("%d total; %s", n, stringBuilder.toString());
    }

    public /* synthetic */ Object call() {
        return this._a();
    }
}

