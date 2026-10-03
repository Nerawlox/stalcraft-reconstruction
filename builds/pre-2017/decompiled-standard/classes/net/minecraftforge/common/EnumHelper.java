/*
 * Decompiled with CFR 0.152.
 */
package net.minecraftforge.common;

import cpw.mods.fml.common.FMLLog;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import net.minecraft.entity.jxsn;
import net.minecraft.entity.player.pidb;
import net.minecraft.entity.vjta;
import net.minecraft.util.amww;
import net.minecraft.util.ugqi;
import net.minecraftforge.classloading.FMLForgePlugin;

public class EnumHelper {
    private static Object reflectionFactory = null;
    private static Method newConstructorAccessor = null;
    private static Method newInstance = null;
    private static Method newFieldAccessor = null;
    private static Method fieldAccessorSet = null;
    private static boolean isSetup = false;
    private static Class[][] commonTypes = new Class[][]{{bsre.class}, {yery.class, Integer.TYPE, int[].class, Integer.TYPE}, {ugqi.class, String.class, Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE}, {vjta.class}, {jxsn.class, Class.class, Integer.TYPE, tflj.class, Boolean.TYPE}, {nwns.class}, {nvsz.class}, {net.minecraft.entity.ugqi.class}, {ogzk.class}, {amww.class}, {rrqi.class, Integer.TYPE}, {pidb.class}, {txfz.class, Integer.TYPE, Integer.TYPE, Float.TYPE, Float.TYPE, Integer.TYPE}};

    public static bsre addAction(String string) {
        return EnumHelper.addEnum(bsre.class, string, new Object[0]);
    }

    public static yery addArmorMaterial(String string, int n, int[] nArray, int n2) {
        return EnumHelper.addEnum(yery.class, string, n, nArray, n2);
    }

    public static ugqi addArt(String string, String string2, int n, int n2, int n3, int n4) {
        return EnumHelper.addEnum(ugqi.class, string, string2, n, n2, n3, n4);
    }

    public static vjta addCreatureAttribute(String string) {
        return EnumHelper.addEnum(vjta.class, string, new Object[0]);
    }

    public static jxsn addCreatureType(String string, Class clazz, int n, tflj tflj2, boolean bl) {
        return EnumHelper.addEnum(jxsn.class, string, clazz, n, tflj2, bl);
    }

    public static nwns addDoor(String string) {
        return EnumHelper.addEnum(nwns.class, string, new Object[0]);
    }

    public static nvsz addEnchantmentType(String string) {
        return EnumHelper.addEnum(nvsz.class, string, new Object[0]);
    }

    public static net.minecraft.entity.ugqi addEntitySize(String string) {
        return EnumHelper.addEnum(net.minecraft.entity.ugqi.class, string, new Object[0]);
    }

    public static ogzk addMobType(String string) {
        return EnumHelper.addEnum(ogzk.class, string, new Object[0]);
    }

    public static amww addMovingObjectType(String string) {
        if (!isSetup) {
            EnumHelper.setup();
        }
        return EnumHelper.addEnum(amww.class, string, new Object[0]);
    }

    public static rrqi addSkyBlock(String string, int n) {
        return EnumHelper.addEnum(rrqi.class, string, n);
    }

    public static pidb addStatus(String string) {
        return EnumHelper.addEnum(pidb.class, string, new Object[0]);
    }

    public static txfz addToolMaterial(String string, int n, int n2, float f, float f2, int n3) {
        return EnumHelper.addEnum(txfz.class, string, n, n2, Float.valueOf(f), Float.valueOf(f2), n3);
    }

    private static void setup() {
        if (isSetup) {
            return;
        }
        try {
            Method method = Class.forName("sun.reflect.ReflectionFactory").getDeclaredMethod("getReflectionFactory", new Class[0]);
            reflectionFactory = method.invoke(null, new Object[0]);
            newConstructorAccessor = Class.forName("sun.reflect.ReflectionFactory").getDeclaredMethod("newConstructorAccessor", Constructor.class);
            newInstance = Class.forName("sun.reflect.ConstructorAccessor").getDeclaredMethod("newInstance", Object[].class);
            newFieldAccessor = Class.forName("sun.reflect.ReflectionFactory").getDeclaredMethod("newFieldAccessor", Field.class, Boolean.TYPE);
            fieldAccessorSet = Class.forName("sun.reflect.FieldAccessor").getDeclaredMethod("set", Object.class, Object.class);
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
        isSetup = true;
    }

    private static Object getConstructorAccessor(Class<?> clazz, Class<?>[] classArray) throws Exception {
        Class[] classArray2 = new Class[classArray.length + 2];
        classArray2[0] = String.class;
        classArray2[1] = Integer.TYPE;
        System.arraycopy(classArray, 0, classArray2, 2, classArray.length);
        return newConstructorAccessor.invoke(reflectionFactory, clazz.getDeclaredConstructor(classArray2));
    }

    private static <T extends Enum<?>> T makeEnum(Class<T> clazz, String string, int n, Class<?>[] classArray, Object[] objectArray) throws Exception {
        Object[] objectArray2 = new Object[objectArray.length + 2];
        objectArray2[0] = string;
        objectArray2[1] = n;
        System.arraycopy(objectArray, 0, objectArray2, 2, objectArray.length);
        return (T)((Enum)clazz.cast(newInstance.invoke(EnumHelper.getConstructorAccessor(clazz, classArray), new Object[]{objectArray2})));
    }

    public static void setFailsafeFieldValue(Field field, Object object, Object object2) throws Exception {
        field.setAccessible(true);
        Field field2 = Field.class.getDeclaredField("modifiers");
        field2.setAccessible(true);
        field2.setInt(field, field.getModifiers() & 0xFFFFFFEF);
        Object object3 = newFieldAccessor.invoke(reflectionFactory, field, false);
        fieldAccessorSet.invoke(object3, object, object2);
    }

    private static void blankField(Class<?> clazz, String string) throws Exception {
        for (Field field : Class.class.getDeclaredFields()) {
            if (!field.getName().contains(string)) continue;
            field.setAccessible(true);
            EnumHelper.setFailsafeFieldValue(field, clazz, null);
            break;
        }
    }

    private static void cleanEnumCache(Class<?> clazz) throws Exception {
        EnumHelper.blankField(clazz, "enumConstantDirectory");
        EnumHelper.blankField(clazz, "enumConstants");
    }

    public static <T extends Enum<?>> T addEnum(Class<T> clazz, String string, Object ... objectArray) {
        return EnumHelper.addEnum(commonTypes, clazz, string, objectArray);
    }

    public static <T extends Enum<?>> T addEnum(Class[][] classArray, Class<T> clazz, String string, Object ... objectArray) {
        for (Class[] classArray2 : classArray) {
            if (classArray2[0] != clazz) continue;
            Class[] classArray3 = new Class[classArray2.length - 1];
            if (classArray3.length > 0) {
                System.arraycopy(classArray2, 1, classArray3, 0, classArray3.length);
            }
            return EnumHelper.addEnum(clazz, string, classArray3, objectArray);
        }
        return null;
    }

    /*
     * WARNING - void declaration
     */
    public static <T extends Enum<?>> T addEnum(Class<T> clazz, String string, Class<?>[] classArray, Object[] objectArray) {
        Field[] fieldArray;
        if (!isSetup) {
            EnumHelper.setup();
        }
        Field field = null;
        for (Field field2 : fieldArray = clazz.getDeclaredFields()) {
            String object = field2.getName();
            if (!object.equals("$VALUES") && !object.equals("ENUM$VALUES")) continue;
            field = field2;
            break;
        }
        int n = (FMLForgePlugin.RUNTIME_DEOBF ? 1 : 2) | 8 | 0x10 | 0x1000;
        if (field == null) {
            void var10_21;
            String string2 = String.format("[L%s;", clazz.getName().replace('.', '/'));
            Field[] fieldArray2 = fieldArray;
            int n2 = fieldArray2.length;
            boolean bl = false;
            while (var10_21 < n2) {
                Field field2 = fieldArray2[var10_21];
                if ((field2.getModifiers() & n) == n && field2.getType().getName().replace('.', '/').equals(string2)) {
                    field = field2;
                    break;
                }
                ++var10_21;
            }
        }
        if (field == null) {
            FMLLog.severe("Could not find $VALUES field for enum: %s", clazz.getName());
            FMLLog.severe("Runtime Deobf: %s", FMLForgePlugin.RUNTIME_DEOBF);
            FMLLog.severe("Flags: %s", String.format("%16s", Integer.toBinaryString(n)).replace(' ', '0'));
            FMLLog.severe("Fields:", new Object[0]);
            for (Field field3 : fieldArray) {
                String string2 = String.format("%16s", Integer.toBinaryString(field3.getModifiers())).replace(' ', '0');
                FMLLog.severe("       %s %s: %s", string2, field3.getName(), field3.getType().getName());
            }
            return null;
        }
        field.setAccessible(true);
        try {
            Field field2;
            Enum[] enumArray = (Enum[])field.get(clazz);
            ArrayList<Enum> arrayList = new ArrayList<Enum>(Arrays.asList(enumArray));
            field2 = EnumHelper.makeEnum(clazz, string, arrayList.size(), classArray, objectArray);
            arrayList.add((Enum)((Object)field2));
            EnumHelper.setFailsafeFieldValue(field, null, arrayList.toArray((Enum[])Array.newInstance(clazz, 0)));
            EnumHelper.cleanEnumCache(clazz);
            return (T)field2;
        }
        catch (Exception exception) {
            exception.printStackTrace();
            throw new RuntimeException(exception.getMessage(), exception);
        }
    }

    static {
        if (!isSetup) {
            EnumHelper.setup();
        }
    }
}

