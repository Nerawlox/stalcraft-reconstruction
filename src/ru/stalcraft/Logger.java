/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cpw.mods.fml.common.FMLCommonHandler
 *  cpw.mods.fml.relauncher.Side
 */
package ru.stalcraft;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.relauncher.Side;
import ru.stalcraft.WarningType;

public class Logger {
    private static final boolean debug = true;

    public static void console(Object message) {
        String toConsole = "[STALKER]";
        Side side = FMLCommonHandler.instance().getEffectiveSide();
        toConsole = side == Side.CLIENT ? toConsole + " CLIENT SIDE: " : toConsole + " SERVER SIDE: ";
        System.out.println(toConsole + message);
    }

    public static void debug(Object str) {
        String toConsole = "[STALKER][DEBUG]";
        Side side = FMLCommonHandler.instance().getEffectiveSide();
        toConsole = side == Side.CLIENT ? toConsole + "[CLIENT] " : toConsole + "[SERVER] ";
        System.out.println(toConsole + str);
    }

    public static void warning(uf player, WarningType warningType, Object warning) {
        Logger.warning(player, warningType, warning, null);
    }

    public static void warning(uf player, WarningType warningType, Object warning, Object target) {
        String toConsole = "[STALKER][WARNING] ";
        System.out.println(toConsole + "Player " + player + " tries to do unallowed operation");
        System.out.println(toConsole + warningType.toString() + ": " + warning);
        if (target != null) {
            System.out.println(toConsole + "Target: " + target);
        }
    }
}

