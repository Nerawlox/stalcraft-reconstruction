/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.crash;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import net.minecraft.crash.CrashReport;
import net.minecraft.crash.CrashReportCategoryEntry;
import net.minecraft.crash.eidj;
import net.minecraft.crash.kjui;
import net.minecraft.crash.pidb;
import net.minecraft.util.sajh;

public class CrashReportCategory {
    public final CrashReport _a;
    public final String _b;
    public final List _c = new ArrayList();
    public StackTraceElement[] _d = new StackTraceElement[0];

    public CrashReportCategory(CrashReport crashReport, String string) {
        this._a = crashReport;
        this._b = string;
    }

    @SideOnly(value=Side.CLIENT)
    public static String _a(double d, double d2, double d3) {
        return String.format("%.2f,%.2f,%.2f - %s", d, d2, d3, CrashReportCategory._a(sajh._c(d), sajh._c(d2), sajh._c(d3)));
    }

    public static String _a(int n, int n2, int n3) {
        int n4;
        int n5;
        int n6;
        int n7;
        int n8;
        int n9;
        int n10;
        int n11;
        StringBuilder stringBuilder = new StringBuilder();
        try {
            stringBuilder.append(String.format("World: (%d,%d,%d)", n, n2, n3));
        }
        catch (Throwable throwable) {
            stringBuilder.append("(Error finding world loc)");
        }
        stringBuilder.append(", ");
        try {
            int n12 = n >> 4;
            n11 = n3 >> 4;
            n10 = n & 0xF;
            n9 = n2 >> 4;
            n8 = n3 & 0xF;
            n7 = n12 << 4;
            n6 = n11 << 4;
            n5 = (n12 + 1 << 4) - 1;
            n4 = (n11 + 1 << 4) - 1;
            stringBuilder.append(String.format("Chunk: (at %d,%d,%d in %d,%d; contains blocks %d,0,%d to %d,255,%d)", n10, n9, n8, n12, n11, n7, n6, n5, n4));
        }
        catch (Throwable throwable) {
            stringBuilder.append("(Error finding chunk loc)");
        }
        stringBuilder.append(", ");
        try {
            int n13 = n >> 9;
            n11 = n3 >> 9;
            n10 = n13 << 5;
            n9 = n11 << 5;
            n8 = (n13 + 1 << 5) - 1;
            n7 = (n11 + 1 << 5) - 1;
            n6 = n13 << 9;
            n5 = n11 << 9;
            n4 = (n13 + 1 << 9) - 1;
            int n14 = (n11 + 1 << 9) - 1;
            stringBuilder.append(String.format("Region: (%d,%d; contains chunks %d,%d to %d,%d, blocks %d,0,%d to %d,255,%d)", n13, n11, n10, n9, n8, n7, n6, n5, n4, n14));
        }
        catch (Throwable throwable) {
            stringBuilder.append("(Error finding world loc)");
        }
        return stringBuilder.toString();
    }

    public void _a(String string, Callable callable) {
        try {
            this._a(string, callable.call());
        }
        catch (Throwable throwable) {
            this._a(string, throwable);
        }
    }

    public void _a(String string, Object object) {
        this._c.add(new CrashReportCategoryEntry(string, object));
    }

    public void _a(String string, Throwable throwable) {
        this._a(string, (Object)throwable);
    }

    public int _a(int n) {
        StackTraceElement[] stackTraceElementArray = Thread.currentThread().getStackTrace();
        int n2 = stackTraceElementArray.length - 3 - n;
        if (n2 <= 0) {
            n2 = stackTraceElementArray.length;
        }
        this._d = new StackTraceElement[n2];
        System.arraycopy(stackTraceElementArray, stackTraceElementArray.length - n2, this._d, 0, this._d.length);
        return this._d.length;
    }

    public boolean _a(StackTraceElement stackTraceElement, StackTraceElement stackTraceElement2) {
        if (this._d.length != 0 && stackTraceElement != null) {
            StackTraceElement stackTraceElement3 = this._d[0];
            if (stackTraceElement3.isNativeMethod() == stackTraceElement.isNativeMethod() && stackTraceElement3.getClassName().equals(stackTraceElement.getClassName()) && stackTraceElement3.getFileName().equals(stackTraceElement.getFileName()) && stackTraceElement3.getMethodName().equals(stackTraceElement.getMethodName())) {
                if (stackTraceElement2 != null != this._d.length > 1) {
                    return false;
                }
                if (stackTraceElement2 != null && !this._d[1].equals(stackTraceElement2)) {
                    return false;
                }
                this._d[0] = stackTraceElement;
                return true;
            }
            return false;
        }
        return false;
    }

    public void _b(int n) {
        StackTraceElement[] stackTraceElementArray = new StackTraceElement[this._d.length - n];
        System.arraycopy(this._d, 0, stackTraceElementArray, 0, stackTraceElementArray.length);
        this._d = stackTraceElementArray;
    }

    public void _a(StringBuilder stringBuilder) {
        stringBuilder.append("-- ").append(this._b).append(" --\n");
        stringBuilder.append("Details:");
        for (StackTraceElement[] stackTraceElementArray : this._c) {
            stringBuilder.append("\n\t");
            stringBuilder.append(stackTraceElementArray._a());
            stringBuilder.append(": ");
            stringBuilder.append(stackTraceElementArray._b());
        }
        if (this._d != null && this._d.length > 0) {
            stringBuilder.append("\nStacktrace:");
            for (StackTraceElement stackTraceElement : this._d) {
                stringBuilder.append("\n\tat ");
                stringBuilder.append(stackTraceElement.toString());
            }
        }
    }

    public static void _a(CrashReportCategory crashReportCategory, int n, int n2, int n3, int n4, int n5) {
        crashReportCategory._a("Block type", new eidj(n4));
        crashReportCategory._a("Block data value", new kjui(n5));
        crashReportCategory._a("Block location", new pidb(n, n2, n3));
    }
}

