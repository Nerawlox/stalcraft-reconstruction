/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.asm;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.FMLLog;
import cpw.mods.fml.relauncher.Side;
import java.util.logging.Level;
import net.minecraft.entity.player.EntityPlayer;

public class Logger {
    public static boolean _a = true;

    private static void log(Level level, String string, Object ... objectArray) {
        if (_a) {
            Side side = FMLCommonHandler.instance().getEffectiveSide();
            string = side == Side.CLIENT ? "[CLIENT] " + string : "[SERVER] " + string;
        }
        FMLLog.log("GloomyCore", level, string, objectArray);
    }

    public static void info(String string, Object ... objectArray) {
        Logger.log(Level.INFO, string, objectArray);
    }

    public static void warning(String string, Object ... objectArray) {
        Logger.log(Level.WARNING, string, objectArray);
    }

    public static void severe(String string, Object ... objectArray) {
        Logger.log(Level.SEVERE, string, objectArray);
    }

    public static void fine(String string, Object ... objectArray) {
        Logger.log(Level.FINE, string, objectArray);
    }

    public static void finer(String string, Object ... objectArray) {
        Logger.log(Level.FINER, string, objectArray);
    }

    public static void finest(String string, Object ... objectArray) {
        Logger.log(Level.FINEST, string, objectArray);
    }

    public static void warning(EntityPlayer entityPlayer, WarningType warningType, String string) {
        Logger.warning(entityPlayer, warningType, string, null);
    }

    public static void warning(EntityPlayer entityPlayer, WarningType warningType, String string, Object object) {
        Logger.warning("Player %s tries to do unallowed operation", entityPlayer);
        Logger.warning("%s: %s", new Object[]{warningType, string});
        if (object != null) {
            Logger.warning("Target: %s", object);
        }
    }

    public static enum WarningType {
        _a,
        _b,
        _c,
        _d;

    }
}

