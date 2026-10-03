/*
 * Decompiled with CFR 0.152.
 */
package net.minecraftforge.client;

import net.minecraft.client.settings.kjui;
import net.minecraft.util.vjsq;
import net.minecraftforge.common.EnumHelper;

public class EnumHelperClient
extends EnumHelper {
    private static Class[][] clentTypes = new Class[][]{{xtby.class, Integer.TYPE, String.class}, {kjui.class, String.class, Boolean.TYPE, Boolean.TYPE}, {vjsq.class}, {zywl.class, Integer.TYPE, String.class}};

    public static xtby addGameType(String string, int n, String string2) {
        return EnumHelperClient.addEnum(xtby.class, string, n, string2);
    }

    public static kjui addOptions(String string, String string2, boolean bl, boolean bl2) {
        return EnumHelperClient.addEnum(kjui.class, string, string2, bl, bl2);
    }

    public static vjsq addOS2(String string) {
        return EnumHelperClient.addEnum(vjsq.class, string, new Object[0]);
    }

    public static zywl addRarity(String string, int n, String string2) {
        return EnumHelperClient.addEnum(zywl.class, string, n, string2);
    }

    public static <T extends Enum<?>> T addEnum(Class<T> clazz, String string, Object ... objectArray) {
        return EnumHelperClient.addEnum(clentTypes, clazz, string, objectArray);
    }
}

