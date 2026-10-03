/*
 * Decompiled with CFR 0.152.
 */
package cpw.mods.fml.common;

import cpw.mods.fml.relauncher.FMLRelaunchLog;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FMLLog {
    private static FMLRelaunchLog coreLog = FMLRelaunchLog.log;

    public static void log(String string, Level level, String string2, Object ... objectArray) {
        FMLRelaunchLog.log(string, level, string2, objectArray);
    }

    public static void log(Level level, String string, Object ... objectArray) {
        FMLRelaunchLog.log(level, string, objectArray);
    }

    public static void log(String string, Level level, Throwable throwable, String string2, Object ... objectArray) {
        FMLRelaunchLog.log(string, level, throwable, string2, objectArray);
    }

    public static void log(Level level, Throwable throwable, String string, Object ... objectArray) {
        FMLRelaunchLog.log(level, throwable, string, objectArray);
    }

    public static void severe(String string, Object ... objectArray) {
        FMLLog.log(Level.SEVERE, string, objectArray);
    }

    public static void warning(String string, Object ... objectArray) {
        FMLLog.log(Level.WARNING, string, objectArray);
    }

    public static void info(String string, Object ... objectArray) {
        FMLLog.log(Level.INFO, string, objectArray);
    }

    public static void fine(String string, Object ... objectArray) {
        FMLLog.log(Level.FINE, string, objectArray);
    }

    public static void finer(String string, Object ... objectArray) {
        FMLLog.log(Level.FINER, string, objectArray);
    }

    public static void finest(String string, Object ... objectArray) {
        FMLLog.log(Level.FINEST, string, objectArray);
    }

    public static Logger getLogger() {
        return coreLog.getLogger();
    }

    public static void makeLog(String string) {
        FMLRelaunchLog.makeLog(string);
    }
}

