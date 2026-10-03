/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  c
 *  cpw.mods.fml.common.FMLCommonHandler
 *  cpw.mods.fml.relauncher.Side
 *  cpw.mods.fml.relauncher.SideOnly
 *  d
 *  e
 *  f
 *  g
 *  h
 *  i
 *  l
 *  lp
 *  u
 */
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Callable;

public class b {
    private final String a;
    private final Throwable b;
    private final m c = new m(this, "System Details");
    private final List d = new ArrayList();
    private File e;
    private boolean f = true;
    private StackTraceElement[] g = new StackTraceElement[0];

    public b(String par1Str, Throwable par2Throwable) {
        this.a = par1Str;
        this.b = par2Throwable;
        this.h();
    }

    private void h() {
        this.c.a("Minecraft Version", (Callable)new c(this));
        this.c.a("Operating System", (Callable)new d(this));
        this.c.a("Java Version", (Callable)new e(this));
        this.c.a("Java VM Version", (Callable)new f(this));
        this.c.a("Memory", (Callable)new g(this));
        this.c.a("JVM Flags", (Callable)new h(this));
        this.c.a("AABB Pool Size", (Callable)new i(this));
        this.c.a("Suspicious classes", new j(this));
        this.c.a("IntCache", (Callable)new l(this));
        FMLCommonHandler.instance().enhanceCrashReport(this, this.c);
    }

    public String a() {
        return this.a;
    }

    public Throwable b() {
        return this.b;
    }

    public void a(StringBuilder par1StringBuilder) {
        if (this.g != null && this.g.length > 0) {
            par1StringBuilder.append("-- Head --\n");
            par1StringBuilder.append("Stacktrace:\n");
            for (StackTraceElement stacktraceelement : this.g) {
                par1StringBuilder.append("\t").append("at ").append(stacktraceelement.toString());
                par1StringBuilder.append("\n");
            }
            par1StringBuilder.append("\n");
        }
        for (m crashreportcategory : this.d) {
            crashreportcategory.a(par1StringBuilder);
            par1StringBuilder.append("\n\n");
        }
        this.c.a(par1StringBuilder);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public String d() {
        StringWriter stringwriter = null;
        PrintWriter printwriter = null;
        String s2 = this.b.toString();
        try {
            stringwriter = new StringWriter();
            printwriter = new PrintWriter(stringwriter);
            this.b.printStackTrace(printwriter);
            s2 = stringwriter.toString();
        }
        finally {
            try {
                if (stringwriter != null) {
                    stringwriter.close();
                }
                if (printwriter != null) {
                    printwriter.close();
                }
            }
            catch (IOException iOException) {}
        }
        return s2;
    }

    public String e() {
        StringBuilder stringbuilder = new StringBuilder();
        stringbuilder.append("---- Minecraft Crash Report ----\n");
        stringbuilder.append("// ");
        stringbuilder.append(b.i());
        stringbuilder.append("\n\n");
        stringbuilder.append("Time: ");
        stringbuilder.append(new SimpleDateFormat().format(new Date()));
        stringbuilder.append("\n");
        stringbuilder.append("Description: ");
        stringbuilder.append(this.a);
        stringbuilder.append("\n\n");
        stringbuilder.append(this.d());
        stringbuilder.append("\n\nA detailed walkthrough of the error, its code path and all known details is as follows:\n");
        for (int i2 = 0; i2 < 87; ++i2) {
            stringbuilder.append("-");
        }
        stringbuilder.append("\n\n");
        this.a(stringbuilder);
        return stringbuilder.toString();
    }

    @SideOnly(value=Side.CLIENT)
    public File f() {
        return this.e;
    }

    public boolean a(File par1File, lp par2ILogAgent) {
        if (this.e != null) {
            return false;
        }
        if (par1File.getParentFile() != null) {
            par1File.getParentFile().mkdirs();
        }
        try {
            FileWriter filewriter = new FileWriter(par1File);
            filewriter.write(this.e());
            filewriter.close();
            this.e = par1File;
            return true;
        }
        catch (Throwable throwable) {
            par2ILogAgent.c("Could not save crash report to " + par1File, throwable);
            return false;
        }
    }

    public m g() {
        return this.c;
    }

    public m a(String par1Str) {
        return this.a(par1Str, 1);
    }

    public m a(String par1Str, int par2) {
        m crashreportcategory = new m(this, par1Str);
        if (this.f) {
            int j2 = crashreportcategory.a(par2);
            StackTraceElement[] astacktraceelement = this.b.getStackTrace();
            StackTraceElement stacktraceelement = null;
            StackTraceElement stacktraceelement1 = null;
            int idx = astacktraceelement.length - j2;
            if (astacktraceelement != null && idx < astacktraceelement.length && idx >= 0) {
                stacktraceelement = astacktraceelement[astacktraceelement.length - j2];
                if (astacktraceelement.length + 1 - j2 < astacktraceelement.length) {
                    stacktraceelement1 = astacktraceelement[astacktraceelement.length + 1 - j2];
                }
            }
            this.f = crashreportcategory.a(stacktraceelement, stacktraceelement1);
            if (j2 > 0 && !this.d.isEmpty()) {
                m crashreportcategory1 = (m)this.d.get(this.d.size() - 1);
                crashreportcategory1.b(j2);
            } else if (astacktraceelement != null && astacktraceelement.length >= j2) {
                this.g = new StackTraceElement[astacktraceelement.length - j2];
                System.arraycopy(astacktraceelement, 0, this.g, 0, this.g.length);
            } else {
                this.f = false;
            }
        }
        this.d.add(crashreportcategory);
        return crashreportcategory;
    }

    private static String i() {
        String[] astring = new String[]{"Who set us up the TNT?", "Everything's going to plan. No, really, that was supposed to happen.", "Uh... Did I do that?", "Oops.", "Why did you do that?", "I feel sad now :(", "My bad.", "I'm sorry, Dave.", "I let you down. Sorry :(", "On the bright side, I bought you a teddy bear!", "Daisy, daisy...", "Oh - I know what I did wrong!", "Hey, that tickles! Hehehe!", "I blame Dinnerbone.", "You should try our sister game, Minceraft!", "Don't be sad. I'll do better next time, I promise!", "Don't be sad, have a hug! <3", "I just don't know what went wrong :(", "Shall we play a game?", "Quite honestly, I wouldn't worry myself about that.", "I bet Cylons wouldn't have this problem.", "Sorry :(", "Surprise! Haha. Well, this is awkward.", "Would you like a cupcake?", "Hi. I'm Minecraft, and I'm a crashaholic.", "Ooh. Shiny.", "This doesn't make any sense!", "Why is it breaking :(", "Don't do that.", "Ouch. That hurt :(", "You're mean.", "This is a token for 1 free hug. Redeem at your nearest Mojangsta: [~~HUG~~]", "There are four lights!"};
        try {
            return astring[(int)(System.nanoTime() % (long)astring.length)];
        }
        catch (Throwable throwable) {
            return "Witty comment unavailable :(";
        }
    }

    public static b a(Throwable par0Throwable, String par1Str) {
        b crashreport = par0Throwable instanceof u ? ((u)par0Throwable).a() : new b(par1Str, par0Throwable);
        return crashreport;
    }
}

