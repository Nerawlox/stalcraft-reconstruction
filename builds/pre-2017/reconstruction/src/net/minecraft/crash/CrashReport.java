/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.crash;

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
import net.minecraft.crash.CrashReportCategory;
import net.minecraft.crash.ezey;
import net.minecraft.crash.jgro;
import net.minecraft.crash.jxtc;
import net.minecraft.crash.qlgf;
import net.minecraft.crash.tupg;
import net.minecraft.crash.ugqx;
import net.minecraft.crash.xpzm;
import net.minecraft.crash.zwat;
import net.minecraft.crash.zwaw;
import net.minecraft.logging.ILogAgent;
import net.minecraft.util.turb;

public class CrashReport {
    public final String description;
    public final Throwable cause;
    public final CrashReportCategory field_85061_c = new CrashReportCategory(this, "System Details");
    public final List crashReportSections = new ArrayList();
    public File crashReportFile;
    public boolean field_85059_f = true;
    public StackTraceElement[] field_85060_g = new StackTraceElement[0];

    public CrashReport(String string, Throwable throwable) {
        this.description = string;
        this.cause = throwable;
        this.populateEnvironment();
    }

    public void populateEnvironment() {
        this.field_85061_c._a("Minecraft Version", new jxtc(this));
        this.field_85061_c._a("Operating System", new ugqx(this));
        this.field_85061_c._a("Java Version", new jgro(this));
        this.field_85061_c._a("Java VM Version", new tupg(this));
        this.field_85061_c._a("Memory", new qlgf(this));
        this.field_85061_c._a("JVM Flags", new zwaw(this));
        this.field_85061_c._a("AABB Pool Size", new ezey(this));
        this.field_85061_c._a("Suspicious classes", new xpzm(this));
        this.field_85061_c._a("IntCache", new zwat(this));
        FMLCommonHandler.instance().enhanceCrashReport(this, this.field_85061_c);
    }

    public String getDescription() {
        return this.description;
    }

    public Throwable getCrashCause() {
        return this.cause;
    }

    public void getSectionsInStringBuilder(StringBuilder stringBuilder) {
        if (this.field_85060_g != null && this.field_85060_g.length > 0) {
            stringBuilder.append("-- Head --\n");
            stringBuilder.append("Stacktrace:\n");
            for (StackTraceElement stackTraceElement : this.field_85060_g) {
                stringBuilder.append("\t").append("at ").append(stackTraceElement.toString());
                stringBuilder.append("\n");
            }
            stringBuilder.append("\n");
        }
        for (CrashReportCategory crashReportCategory : this.crashReportSections) {
            crashReportCategory._a(stringBuilder);
            stringBuilder.append("\n\n");
        }
        this.field_85061_c._a(stringBuilder);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public String getCauseStackTraceOrString() {
        StringWriter stringWriter = null;
        PrintWriter printWriter = null;
        String string = this.cause.toString();
        try {
            stringWriter = new StringWriter();
            printWriter = new PrintWriter(stringWriter);
            this.cause.printStackTrace(printWriter);
            string = stringWriter.toString();
        }
        finally {
            try {
                if (stringWriter != null) {
                    stringWriter.close();
                }
                if (printWriter != null) {
                    printWriter.close();
                }
            }
            catch (IOException iOException) {}
        }
        return string;
    }

    public String getCompleteReport() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("---- Minecraft Crash Report ----\n");
        stringBuilder.append("// ");
        stringBuilder.append(CrashReport.getWittyComment());
        stringBuilder.append("\n\n");
        stringBuilder.append("Time: ");
        stringBuilder.append(new SimpleDateFormat().format(new Date()));
        stringBuilder.append("\n");
        stringBuilder.append("Description: ");
        stringBuilder.append(this.description);
        stringBuilder.append("\n\n");
        stringBuilder.append(this.getCauseStackTraceOrString());
        stringBuilder.append("\n\nA detailed walkthrough of the error, its code path and all known details is as follows:\n");
        for (int i = 0; i < 87; ++i) {
            stringBuilder.append("-");
        }
        stringBuilder.append("\n\n");
        this.getSectionsInStringBuilder(stringBuilder);
        return stringBuilder.toString();
    }

    @SideOnly(value=Side.CLIENT)
    public File getFile() {
        return this.crashReportFile;
    }

    public boolean saveToFile(File file, ILogAgent iLogAgent) {
        if (this.crashReportFile != null) {
            return false;
        }
        if (file.getParentFile() != null) {
            file.getParentFile().mkdirs();
        }
        try {
            FileWriter fileWriter = new FileWriter(file);
            fileWriter.write(this.getCompleteReport());
            fileWriter.close();
            this.crashReportFile = file;
            return true;
        }
        catch (Throwable throwable) {
            iLogAgent._b("Could not save crash report to " + file, throwable);
            return false;
        }
    }

    public CrashReportCategory getCategory() {
        return this.field_85061_c;
    }

    public CrashReportCategory makeCategory(String string) {
        return this.makeCategoryDepth(string, 1);
    }

    public CrashReportCategory makeCategoryDepth(String string, int n) {
        CrashReportCategory crashReportCategory = new CrashReportCategory(this, string);
        if (this.field_85059_f) {
            int n2 = crashReportCategory._a(n);
            StackTraceElement[] stackTraceElementArray = this.cause.getStackTrace();
            StackTraceElement stackTraceElement = null;
            StackTraceElement stackTraceElement2 = null;
            int n3 = stackTraceElementArray.length - n2;
            if (stackTraceElementArray != null && n3 < stackTraceElementArray.length && n3 >= 0) {
                stackTraceElement = stackTraceElementArray[stackTraceElementArray.length - n2];
                if (stackTraceElementArray.length + 1 - n2 < stackTraceElementArray.length) {
                    stackTraceElement2 = stackTraceElementArray[stackTraceElementArray.length + 1 - n2];
                }
            }
            this.field_85059_f = crashReportCategory._a(stackTraceElement, stackTraceElement2);
            if (n2 > 0 && !this.crashReportSections.isEmpty()) {
                CrashReportCategory crashReportCategory2 = (CrashReportCategory)this.crashReportSections.get(this.crashReportSections.size() - 1);
                crashReportCategory2._b(n2);
            } else if (stackTraceElementArray != null && stackTraceElementArray.length >= n2) {
                this.field_85060_g = new StackTraceElement[stackTraceElementArray.length - n2];
                System.arraycopy(stackTraceElementArray, 0, this.field_85060_g, 0, this.field_85060_g.length);
            } else {
                this.field_85059_f = false;
            }
        }
        this.crashReportSections.add(crashReportCategory);
        return crashReportCategory;
    }

    public static String getWittyComment() {
        String[] stringArray = new String[]{"Who set us up the TNT?", "Everything's going to plan. No, really, that was supposed to happen.", "Uh... Did I do that?", "Oops.", "Why did you do that?", "I feel sad now :(", "My bad.", "I'm sorry, Dave.", "I let you down. Sorry :(", "On the bright side, I bought you a teddy bear!", "Daisy, daisy...", "Oh - I know what I did wrong!", "Hey, that tickles! Hehehe!", "I blame Dinnerbone.", "You should try our sister game, Minceraft!", "Don't be sad. I'll do better next time, I promise!", "Don't be sad, have a hug! <3", "I just don't know what went wrong :(", "Shall we play a game?", "Quite honestly, I wouldn't worry myself about that.", "I bet Cylons wouldn't have this problem.", "Sorry :(", "Surprise! Haha. Well, this is awkward.", "Would you like a cupcake?", "Hi. I'm Minecraft, and I'm a crashaholic.", "Ooh. Shiny.", "This doesn't make any sense!", "Why is it breaking :(", "Don't do that.", "Ouch. That hurt :(", "You're mean.", "This is a token for 1 free hug. Redeem at your nearest Mojangsta: [~~HUG~~]", "There are four lights!"};
        try {
            return stringArray[(int)(System.nanoTime() % (long)stringArray.length)];
        }
        catch (Throwable throwable) {
            return "Witty comment unavailable :(";
        }
    }

    public static CrashReport makeCrashReport(Throwable throwable, String string) {
        CrashReport crashReport = throwable instanceof turb ? ((turb)throwable)._a() : new CrashReport(string, throwable);
        return crashReport;
    }
}

