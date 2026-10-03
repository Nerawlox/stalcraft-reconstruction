/*
 * Decompiled with CFR 0.152.
 */
package net.smart.utilities;

import java.io.PrintStream;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.smart.utilities.Install;

public class Assert {
    public static final String messageBorder = "========================================";
    public static final String messageSeparator = "----------------------------------------";
    private static Set singles = new HashSet();

    public static boolean singleton(Class clazz, String string, Logger logger) {
        boolean bl;
        boolean bl2 = bl = !singles.contains(clazz);
        if (bl) {
            singles.add(clazz);
        } else {
            Assert.warn(logger, Assert.getSingleMessage(string));
        }
        return bl;
    }

    public static void client(Logger logger) {
        if (!Install.hasClient) {
            throw new RuntimeException(Assert.error(logger, Assert.getSideMessage(true)));
        }
    }

    public static void server(Logger logger) {
        if (!(!Install.hasClient || Install.hasBukkit && Install.hasMinecraftForge)) {
            throw new RuntimeException(Assert.error(logger, Assert.getSideMessage(false)));
        }
    }

    public static void clientPlayerAPI(Logger logger) {
        if (!Install.hasClientPlayerAPI) {
            throw new RuntimeException(Assert.error(logger, Assert.getPlayerAPIMessage(true)));
        }
    }

    public static void serverPlayerAPI(Logger logger) {
        if (!Install.hasServerPlayerAPI) {
            throw new RuntimeException(Assert.error(logger, Assert.getPlayerAPIMessage(false)));
        }
    }

    private static String[] getSideMessage(boolean bl) {
        return Assert.getMessage("Smart Moving could" + (bl ? " not" : "") + " find client classes!", "Don't use this Smart Moving " + (bl ? "Client" : "Server") + " installation package on a" + (bl ? " dedicate" : "") + " Minecraft " + (bl ? "server" : "client") + ".", "That's what Smart Moving " + (bl ? "Server" : "Client") + " installation packages are good for.");
    }

    private static String[] getPlayerAPIMessage(boolean bl) {
        return Assert.getMessage("Smart Moving could not find the required API \"" + Assert.getPlayerAPIPrefix(bl) + " Player\"!", "Download Player API " + Assert.getPlayerAPIProductPostfix() + " from:", "\thttp://www.minecraftforum.net/topic/738498-/", "and install it on your system to fix this specific problem.");
    }

    private static String[] getSingleMessage(String string) {
        return Assert.getMessage(string + " has been created more than once!", "That is usually being caused by multiple installations of the " + string + " mod at different locations.", "Clean up your \"mods\" folder and/or your \"minecraft" + (Install.hasClient ? "" : "_server") + ".jar\"");
    }

    private static String[] getMessage(String string, String ... stringArray) {
        String[] stringArray2 = new String[stringArray.length + 4];
        int n = 0;
        int n2 = n + 1;
        stringArray2[n] = messageBorder;
        stringArray2[n2++] = string;
        stringArray2[n2++] = messageSeparator;
        for (int i = 0; i < stringArray.length; ++i) {
            stringArray2[n2++] = stringArray[i];
        }
        stringArray2[n2] = messageBorder;
        return stringArray2;
    }

    private static String getPlayerAPIPrefix(boolean bl) {
        return bl ? "Client" : "Server";
    }

    private static String getPlayerAPIProductPostfix() {
        return Install.hasBukkit ? (Install.hasMinecraftForge ? "MCPC+" : "bukkit") : (Install.hasMinecraftForge ? "forge" : "vanilla");
    }

    public static String error(Logger logger, String ... stringArray) {
        return Assert.log(logger, Level.SEVERE, System.err, stringArray);
    }

    public static String warn(Logger logger, String ... stringArray) {
        return Assert.log(logger, Level.WARNING, System.err, stringArray);
    }

    private static String log(Logger logger, Level level, PrintStream printStream, String ... stringArray) {
        String string = "\n";
        for (int i = 0; i < stringArray.length; ++i) {
            String string2 = stringArray[i];
            printStream.println(string2);
            string = string + "\n\t" + string2;
        }
        string = string + "\n";
        if (logger != null) {
            logger.log(level, string);
        }
        return string;
    }
}

