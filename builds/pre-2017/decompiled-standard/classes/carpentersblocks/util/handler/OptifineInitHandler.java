/*
 * Decompiled with CFR 0.152.
 */
package carpentersblocks.util.handler;

import carpentersblocks.util.ModLogger;
import java.util.logging.Level;

public class OptifineInitHandler {
    public static boolean init() {
        try {
            Class<?> clazz = Class.forName("mcoptifine.CustomColorizer");
            clazz.getMethod("getColorMultiplier", twgu.class, sdrg.class, Integer.TYPE, Integer.TYPE, Integer.TYPE);
            ModLogger.log(Level.INFO, "Optifine integration successful.");
            return true;
        }
        catch (Exception exception) {
            ModLogger.log(Level.WARNING, "Optifine integration failed.");
            return false;
        }
    }
}

