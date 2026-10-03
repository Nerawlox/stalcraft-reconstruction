/*
 * Decompiled with CFR 0.152.
 */
package eu.ha3.matmos.conv;

public class MAtmosConvLogger {
    private static final String modName = "MAtmos";
    public static final int SEVERE = 3;
    public static final int WARNING = 2;
    public static final int INFO = 1;
    public static final int FINE = 0;
    private static int refinedness = 1;

    public static void setRefinedness(int n) {
        refinedness = n;
    }

    public static void fine(String string) {
        MAtmosConvLogger.print(string, "FINE", 0);
    }

    public static void info(String string) {
        MAtmosConvLogger.print(string, "INFO", 1);
    }

    public static void warning(String string) {
        MAtmosConvLogger.print(string, "WARNING", 2);
    }

    public static void severe(String string) {
        MAtmosConvLogger.print(string, "SEVERE", 3);
    }

    private static void print(String string, String string2, int n) {
        if (n >= refinedness) {
            System.out.println("(MAtmos: " + string2 + ") " + string);
        }
    }
}

