/*
 * Decompiled with CFR 0.152.
 */
package net.minecraftforge.client;

import net.minecraft.client.settings.EnumOptions;
import net.minecraft.item.EnumRarity;
import net.minecraft.util.EnumOS;
import net.minecraft.world.EnumGameType;
import net.minecraftforge.common.EnumHelper;

public class EnumHelperClient
extends EnumHelper {
    private static Class[][] clentTypes = new Class[][]{{EnumGameType.class, Integer.TYPE, String.class}, {EnumOptions.class, String.class, Boolean.TYPE, Boolean.TYPE}, {EnumOS.class}, {EnumRarity.class, Integer.TYPE, String.class}};

    public static EnumGameType addGameType(String string, int n, String string2) {
        return EnumHelperClient.addEnum(EnumGameType.class, string, n, string2);
    }

    public static EnumOptions addOptions(String string, String string2, boolean bl, boolean bl2) {
        return EnumHelperClient.addEnum(EnumOptions.class, string, string2, bl, bl2);
    }

    public static EnumOS addOS2(String string) {
        return EnumHelperClient.addEnum(EnumOS.class, string, new Object[0]);
    }

    public static EnumRarity addRarity(String string, int n, String string2) {
        return EnumHelperClient.addEnum(EnumRarity.class, string, n, string2);
    }

    public static <T extends Enum<?>> T addEnum(Class<T> clazz, String string, Object ... objectArray) {
        return EnumHelperClient.addEnum(clentTypes, clazz, string, objectArray);
    }
}

