/*
 * Decompiled with CFR 0.152.
 */
package obf.gloomyfolken.asm;

import cpw.mods.fml.common.ModClassLoader;
import cpw.mods.fml.common.modloader.BaseModProxy;
import cpw.mods.fml.common.registry.ItemData;
import java.lang.reflect.Field;

public class ObfHooks {
    private static boolean loading;

    public static void fixItemType(ItemData itemData) {
        Class<?> clazz = itemData.getClass();
        try {
            Field field = clazz.getDeclaredField("itemType");
            field.setAccessible(true);
            Field field2 = clazz.getDeclaredField("itemId");
            field2.setAccessible(true);
            int n = field2.getInt(itemData);
            field.set(itemData, "heil" + n);
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    public static Class<? extends BaseModProxy> loadBaseModClass(ModClassLoader modClassLoader, String string) throws Exception {
        if (loading) {
            return null;
        }
        loading = true;
        Class<BaseModProxy> clazz = null;
        Exception exception = null;
        try {
            clazz = modClassLoader.loadBaseModClass(string);
        }
        catch (Exception exception2) {
            try {
                clazz = Class.forName(string, true, modClassLoader);
            }
            catch (Exception exception3) {
                exception = exception3;
            }
        }
        loading = false;
        if (clazz == null) {
            throw exception;
        }
        return clazz;
    }
}

