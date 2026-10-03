/*
 * Decompiled with CFR 0.152.
 */
package carpentersblocks.util.handler;

import carpentersblocks.util.ModLogger;
import java.util.logging.Level;
import net.minecraft.block.Block;
import net.minecraft.world.IBlockAccess;

public class OptifineInitHandler {
    public static boolean init() {
        try {
            Class<?> clazz = Class.forName("mcoptifine.CustomColorizer");
            clazz.getMethod("getColorMultiplier", Block.class, IBlockAccess.class, Integer.TYPE, Integer.TYPE, Integer.TYPE);
            ModLogger.log(Level.INFO, "Optifine integration successful.");
            return true;
        }
        catch (Exception exception) {
            ModLogger.log(Level.WARNING, "Optifine integration failed.");
            return false;
        }
    }
}

