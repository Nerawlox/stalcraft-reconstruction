/*
 * Decompiled with CFR 0.152.
 */
package carpentersblocks.util;

import cpw.mods.fml.common.FMLLog;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ModLogger {
    private static Logger logger = Logger.getLogger("CarpentersBlocks");

    public static void init() {
        logger.setParent(FMLLog.getLogger());
    }

    public static void log(Level level, String string) {
        logger.log(level, string);
    }
}

