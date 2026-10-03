/*
 * Decompiled with CFR 0.152.
 */
import cpw.mods.fml.relauncher.FMLRelaunchLog;
import java.util.logging.Level;

public class gpmu {
    public static boolean _a;

    public static void _a(String string, Object ... objectArray) {
        gpmu._a(Level.INFO, string, objectArray);
    }

    public static void _b(String string, Object ... objectArray) {
        gpmu._a(Level.WARNING, string, objectArray);
    }

    public static void _c(String string, Object ... objectArray) {
        gpmu._a(Level.SEVERE, string, objectArray);
    }

    public static void _d(String string, Object ... objectArray) {
        gpmu._a(Level.FINE, string, objectArray);
    }

    public static void _e(String string, Object ... objectArray) {
        gpmu._a(Level.FINER, string, objectArray);
    }

    public static void _f(String string, Object ... objectArray) {
        gpmu._a(Level.FINEST, string, objectArray);
    }

    private static void _a(Level level, String string, Object ... objectArray) {
        if (!_a) {
            if (FMLRelaunchLog.log.getLogger() != null) {
                FMLRelaunchLog.log("EffectsAPI", level, string, objectArray);
            } else {
                System.err.println(String.format(string, objectArray));
            }
        }
    }
}

