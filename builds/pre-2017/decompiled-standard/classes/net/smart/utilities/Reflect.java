/*
 * Decompiled with CFR 0.152.
 */
package net.smart.utilities;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import net.smart.utilities.Name;

public class Reflect {
    public static Object NewInstance(Class clazz, Name name) {
        try {
            return Reflect.LoadClass(clazz, name, true).getConstructor(new Class[0]).newInstance(new Object[0]);
        }
        catch (Exception exception) {
            throw new RuntimeException(name.deobfuscated, exception);
        }
    }

    public static boolean CheckClasses(Class clazz, Name ... nameArray) {
        for (int i = 0; i < nameArray.length; ++i) {
            if (Reflect.LoadClass(clazz, nameArray[i], false) != null) continue;
            return false;
        }
        return true;
    }

    public static Class LoadClass(Class clazz, Name name, boolean bl) {
        ClassLoader classLoader = clazz.getClassLoader();
        if (name.obfuscated != null) {
            try {
                return classLoader.loadClass(name.obfuscated);
            }
            catch (ClassNotFoundException classNotFoundException) {
                // empty catch block
            }
        }
        try {
            return classLoader.loadClass(name.deobfuscated);
        }
        catch (ClassNotFoundException classNotFoundException) {
            if (bl) {
                throw new RuntimeException(classNotFoundException);
            }
            return null;
        }
    }

    public static void copyFields(Class clazz, Object object, Object object2) {
        Field[] fieldArray = clazz.getDeclaredFields();
        for (int i = 0; i < fieldArray.length; ++i) {
            Field field = fieldArray[i];
            int n = field.getModifiers();
            if (Modifier.isStatic(n) || Modifier.isFinal(n)) continue;
            field.setAccessible(true);
            Reflect.SetField(field, object2, Reflect.GetField(field, object));
        }
    }

    public static void SetField(Field field, Object object, Object object2) {
        try {
            field.set(object, object2);
        }
        catch (IllegalAccessException illegalAccessException) {
            throw new RuntimeException(illegalAccessException);
        }
    }

    public static Object GetField(Field field, Object object) {
        try {
            return field.get(object);
        }
        catch (IllegalAccessException illegalAccessException) {
            throw new RuntimeException(illegalAccessException);
        }
    }

    public static void SetField(Class clazz, Object object, Name name, Object object2) {
        try {
            Reflect.GetField(clazz, name).set(object, object2);
        }
        catch (IllegalAccessException illegalAccessException) {
            throw new RuntimeException(illegalAccessException);
        }
    }

    public static Object GetField(Class clazz, Object object, Name name) {
        try {
            return Reflect.GetField(clazz, name).get(object);
        }
        catch (IllegalAccessException illegalAccessException) {
            throw new RuntimeException(illegalAccessException);
        }
    }

    public static Field GetField(Class clazz, Name name) {
        return Reflect.GetField(clazz, name, true);
    }

    public static Field GetField(Class clazz, Name name, boolean bl) {
        Field field;
        block3: {
            if (clazz == null && !bl) {
                return null;
            }
            field = null;
            try {
                field = Reflect.GetRawField(clazz, name);
                field.setAccessible(true);
            }
            catch (NoSuchFieldException noSuchFieldException) {
                if (!bl) break block3;
                throw new RuntimeException(Reflect.GetFieldMessage(clazz, name), noSuchFieldException);
            }
        }
        return field;
    }

    private static String GetFieldMessage(Class clazz, Name name) {
        Field[] fieldArray = clazz.getDeclaredFields();
        StringBuffer stringBuffer = Reflect.GetMessage(clazz, name, "field", "type");
        for (int i = 0; i < fieldArray.length; ++i) {
            Reflect.AppendElement(stringBuffer, fieldArray[i].getName(), fieldArray[i].getType());
        }
        return stringBuffer.toString();
    }

    private static Field GetRawField(Class clazz, Name name) throws NoSuchFieldException {
        if (name.obfuscated != null) {
            try {
                return clazz.getDeclaredField(name.obfuscated);
            }
            catch (NoSuchFieldException noSuchFieldException) {
                // empty catch block
            }
        }
        if (name.forgefuscated != null) {
            try {
                return clazz.getDeclaredField(name.forgefuscated);
            }
            catch (NoSuchFieldException noSuchFieldException) {
                // empty catch block
            }
        }
        return clazz.getDeclaredField(name.deobfuscated);
    }

    public static Method GetMethod(Class clazz, Name name, Class ... classArray) {
        return Reflect.GetMethod(clazz, name, true, classArray);
    }

    public static Method GetMethod(Class clazz, Name name, boolean bl, Class ... classArray) {
        Method method;
        block3: {
            if (clazz == null && !bl) {
                return null;
            }
            method = null;
            try {
                method = Reflect.GetRawMethod(clazz, name, classArray);
                method.setAccessible(true);
            }
            catch (NoSuchMethodException noSuchMethodException) {
                if (!bl) break block3;
                throw new RuntimeException(Reflect.GetMethodMessage(clazz, name), noSuchMethodException);
            }
        }
        return method;
    }

    private static String GetMethodMessage(Class clazz, Name name) {
        Method[] methodArray = clazz.getDeclaredMethods();
        StringBuffer stringBuffer = Reflect.GetMessage(clazz, name, "method", "return type");
        for (int i = 0; i < methodArray.length; ++i) {
            Reflect.AppendElement(stringBuffer, methodArray[i].getName(), methodArray[i].getReturnType());
        }
        return stringBuffer.toString();
    }

    private static Method GetRawMethod(Class clazz, Name name, Class ... classArray) throws NoSuchMethodException {
        if (name.obfuscated != null) {
            try {
                return clazz.getDeclaredMethod(name.obfuscated, classArray);
            }
            catch (NoSuchMethodException noSuchMethodException) {
                // empty catch block
            }
        }
        if (name.forgefuscated != null) {
            try {
                return clazz.getDeclaredMethod(name.forgefuscated, classArray);
            }
            catch (NoSuchMethodException noSuchMethodException) {
                // empty catch block
            }
        }
        return clazz.getDeclaredMethod(name.deobfuscated, classArray);
    }

    public static Object Invoke(Method method, Object object, Object ... objectArray) {
        try {
            return method.invoke(object, objectArray);
        }
        catch (Exception exception) {
            throw new RuntimeException(method.getName(), exception);
        }
    }

    private static StringBuffer GetMessage(Class clazz, Name name, String string, String string2) {
        StringBuffer stringBuffer = new StringBuffer().append("Can not find ").append(string).append(" \"").append(name.deobfuscated).append("\"");
        if (name.obfuscated != null) {
            stringBuffer.append(" (ofuscated \"").append(name.obfuscated).append("\")");
        }
        stringBuffer.append(" in class \"").append(clazz.getName()).append("\".\nExisting ").append(string).append("s (<name>, <").append(string2).append(">) are:");
        return stringBuffer;
    }

    private static StringBuffer AppendElement(StringBuffer stringBuffer, String string, Class clazz) {
        return stringBuffer.append("\n\t\t(").append(string).append(", ").append(clazz.getName()).append(")");
    }
}

