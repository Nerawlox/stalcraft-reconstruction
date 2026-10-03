/*
 * Decompiled with CFR 0.152.
 */
package cpw.mods.fml.common;

import cpw.mods.fml.common.FMLLog;
import cpw.mods.fml.common.asm.transformers.deobf.FMLDeobfuscatingRemapper;
import cpw.mods.fml.relauncher.ReflectionHelper;
import java.util.Arrays;
import java.util.logging.Level;

public class ObfuscationReflectionHelper {
    public static <T, E> T getPrivateValue(Class<? super E> clazz, E e, int n) {
        try {
            return ReflectionHelper.getPrivateValue(clazz, e, n);
        }
        catch (ReflectionHelper.UnableToAccessFieldException unableToAccessFieldException) {
            FMLLog.log(Level.SEVERE, unableToAccessFieldException, "There was a problem getting field index %d from %s", n, clazz.getName());
            throw unableToAccessFieldException;
        }
    }

    public static String[] remapFieldNames(String string, String ... stringArray) {
        String string2 = FMLDeobfuscatingRemapper.INSTANCE.unmap(string.replace('.', '/'));
        String[] stringArray2 = new String[stringArray.length];
        int n = 0;
        for (String string3 : stringArray) {
            stringArray2[n++] = FMLDeobfuscatingRemapper.INSTANCE.mapFieldName(string2, string3, null);
        }
        return stringArray2;
    }

    public static <T, E> T getPrivateValue(Class<? super E> clazz, E e, String ... stringArray) {
        try {
            return ReflectionHelper.getPrivateValue(clazz, e, ObfuscationReflectionHelper.remapFieldNames(clazz.getName(), stringArray));
        }
        catch (ReflectionHelper.UnableToFindFieldException unableToFindFieldException) {
            FMLLog.log(Level.SEVERE, unableToFindFieldException, "Unable to locate any field %s on type %s", Arrays.toString(stringArray), clazz.getName());
            throw unableToFindFieldException;
        }
        catch (ReflectionHelper.UnableToAccessFieldException unableToAccessFieldException) {
            FMLLog.log(Level.SEVERE, unableToAccessFieldException, "Unable to access any field %s on type %s", Arrays.toString(stringArray), clazz.getName());
            throw unableToAccessFieldException;
        }
    }

    @Deprecated
    public static <T, E> void setPrivateValue(Class<? super T> clazz, T t, int n, E e) {
        ObfuscationReflectionHelper.setPrivateValue(clazz, t, e, n);
    }

    public static <T, E> void setPrivateValue(Class<? super T> clazz, T t, E e, int n) {
        try {
            ReflectionHelper.setPrivateValue(clazz, t, e, n);
        }
        catch (ReflectionHelper.UnableToAccessFieldException unableToAccessFieldException) {
            FMLLog.log(Level.SEVERE, unableToAccessFieldException, "There was a problem setting field index %d on type %s", n, clazz.getName());
            throw unableToAccessFieldException;
        }
    }

    @Deprecated
    public static <T, E> void setPrivateValue(Class<? super T> clazz, T t, String string, E e) {
        ObfuscationReflectionHelper.setPrivateValue(clazz, t, e, string);
    }

    public static <T, E> void setPrivateValue(Class<? super T> clazz, T t, E e, String ... stringArray) {
        try {
            ReflectionHelper.setPrivateValue(clazz, t, e, ObfuscationReflectionHelper.remapFieldNames(clazz.getName(), stringArray));
        }
        catch (ReflectionHelper.UnableToFindFieldException unableToFindFieldException) {
            FMLLog.log(Level.SEVERE, unableToFindFieldException, "Unable to locate any field %s on type %s", Arrays.toString(stringArray), clazz.getName());
            throw unableToFindFieldException;
        }
        catch (ReflectionHelper.UnableToAccessFieldException unableToAccessFieldException) {
            FMLLog.log(Level.SEVERE, unableToAccessFieldException, "Unable to set any field %s on type %s", Arrays.toString(stringArray), clazz.getName());
            throw unableToAccessFieldException;
        }
    }
}

