/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cpw.mods.fml.relauncher.Side
 *  cpw.mods.fml.relauncher.SideOnly
 *  n
 *  o
 *  p
 *  q
 */
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

public class m {
    private final b a;
    private final String b;
    private final List c = new ArrayList();
    private StackTraceElement[] d = new StackTraceElement[0];

    public m(b par1CrashReport, String par2Str) {
        this.a = par1CrashReport;
        this.b = par2Str;
    }

    @SideOnly(value=Side.CLIENT)
    public static String a(double par0, double par2, double par4) {
        return String.format("%.2f,%.2f,%.2f - %s", par0, par2, par4, m.a(ls.c(par0), ls.c(par2), ls.c(par4)));
    }

    public static String a(int par0, int par1, int par2) {
        int l2;
        int k2;
        int j2;
        int i2;
        int l1;
        int k1;
        int j1;
        int i1;
        StringBuilder stringbuilder = new StringBuilder();
        try {
            stringbuilder.append(String.format("World: (%d,%d,%d)", par0, par1, par2));
        }
        catch (Throwable throwable) {
            stringbuilder.append("(Error finding world loc)");
        }
        stringbuilder.append(", ");
        try {
            int l3 = par0 >> 4;
            i1 = par2 >> 4;
            j1 = par0 & 0xF;
            k1 = par1 >> 4;
            l1 = par2 & 0xF;
            i2 = l3 << 4;
            j2 = i1 << 4;
            k2 = (l3 + 1 << 4) - 1;
            l2 = (i1 + 1 << 4) - 1;
            stringbuilder.append(String.format("Chunk: (at %d,%d,%d in %d,%d; contains blocks %d,0,%d to %d,255,%d)", j1, k1, l1, l3, i1, i2, j2, k2, l2));
        }
        catch (Throwable throwable1) {
            stringbuilder.append("(Error finding chunk loc)");
        }
        stringbuilder.append(", ");
        try {
            int l4 = par0 >> 9;
            i1 = par2 >> 9;
            j1 = l4 << 5;
            k1 = i1 << 5;
            l1 = (l4 + 1 << 5) - 1;
            i2 = (i1 + 1 << 5) - 1;
            j2 = l4 << 9;
            k2 = i1 << 9;
            l2 = (l4 + 1 << 9) - 1;
            int i3 = (i1 + 1 << 9) - 1;
            stringbuilder.append(String.format("Region: (%d,%d; contains chunks %d,%d to %d,%d, blocks %d,0,%d to %d,255,%d)", l4, i1, j1, k1, l1, i2, j2, k2, l2, i3));
        }
        catch (Throwable throwable2) {
            stringbuilder.append("(Error finding world loc)");
        }
        return stringbuilder.toString();
    }

    public void a(String par1Str, Callable par2Callable) {
        try {
            this.a(par1Str, par2Callable.call());
        }
        catch (Throwable throwable) {
            this.a(par1Str, throwable);
        }
    }

    public void a(String par1Str, Object par2Obj) {
        this.c.add(new q(par1Str, par2Obj));
    }

    public void a(String par1Str, Throwable par2Throwable) {
        this.a(par1Str, (Object)par2Throwable);
    }

    public int a(int par1) {
        StackTraceElement[] astacktraceelement = Thread.currentThread().getStackTrace();
        int len = astacktraceelement.length - 3 - par1;
        if (len <= 0) {
            len = astacktraceelement.length;
        }
        this.d = new StackTraceElement[len];
        System.arraycopy(astacktraceelement, astacktraceelement.length - len, this.d, 0, this.d.length);
        return this.d.length;
    }

    public boolean a(StackTraceElement par1StackTraceElement, StackTraceElement par2StackTraceElement) {
        if (this.d.length != 0 && par1StackTraceElement != null) {
            StackTraceElement stacktraceelement2 = this.d[0];
            if (stacktraceelement2.isNativeMethod() == par1StackTraceElement.isNativeMethod() && stacktraceelement2.getClassName().equals(par1StackTraceElement.getClassName()) && stacktraceelement2.getFileName().equals(par1StackTraceElement.getFileName()) && stacktraceelement2.getMethodName().equals(par1StackTraceElement.getMethodName())) {
                if (par2StackTraceElement != null != this.d.length > 1) {
                    return false;
                }
                if (par2StackTraceElement != null && !this.d[1].equals(par2StackTraceElement)) {
                    return false;
                }
                this.d[0] = par1StackTraceElement;
                return true;
            }
            return false;
        }
        return false;
    }

    public void b(int par1) {
        StackTraceElement[] astacktraceelement = new StackTraceElement[this.d.length - par1];
        System.arraycopy(this.d, 0, astacktraceelement, 0, astacktraceelement.length);
        this.d = astacktraceelement;
    }

    public void a(StringBuilder par1StringBuilder) {
        par1StringBuilder.append("-- ").append(this.b).append(" --\n");
        par1StringBuilder.append("Details:");
        for (q crashreportcategoryentry : this.c) {
            par1StringBuilder.append("\n\t");
            par1StringBuilder.append(crashreportcategoryentry.a());
            par1StringBuilder.append(": ");
            par1StringBuilder.append(crashreportcategoryentry.b());
        }
        if (this.d != null && this.d.length > 0) {
            par1StringBuilder.append("\nStacktrace:");
            for (StackTraceElement stacktraceelement : this.d) {
                par1StringBuilder.append("\n\tat ");
                par1StringBuilder.append(stacktraceelement.toString());
            }
        }
    }

    public static void a(m par0CrashReportCategory, int par1, int par2, int par3, int par4, int par5) {
        par0CrashReportCategory.a("Block type", (Callable)new n(par4));
        par0CrashReportCategory.a("Block data value", (Callable)new o(par5));
        par0CrashReportCategory.a("Block location", (Callable)new p(par1, par2, par3));
    }
}

