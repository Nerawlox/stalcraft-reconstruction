/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.bundle.common.core;

import java.util.logging.Level;
import java.util.logging.Logger;

public class pidb {
    public static Logger _a = Logger.getGlobal();

    public static void _a(Logger logger) {
        _a = logger;
    }

    public static void _a(String string, String ... stringArray) {
        _a.info(String.format(string, stringArray));
    }

    public static void _b(String string, String ... stringArray) {
        _a.severe(String.format(string, stringArray));
    }

    public static void _c(String string, String ... stringArray) {
        _a.warning(String.format(string, stringArray));
    }

    public static void _d(String string, String ... stringArray) {
        _a.fine(String.format(string, stringArray));
    }

    public static void _e(String string, String ... stringArray) {
        _a.finer(String.format(string, stringArray));
    }

    public static void _f(String string, String ... stringArray) {
        _a.finest(String.format(string, stringArray));
    }

    public static void _a(String string, Throwable throwable, String ... stringArray) {
        _a.log(Level.SEVERE, String.format(string, stringArray), throwable);
    }

    public static void _b(String string, Throwable throwable, String ... stringArray) {
        _a.log(Level.WARNING, String.format(string, stringArray), throwable);
    }
}

