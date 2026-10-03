/*
 * Decompiled with CFR 0.152.
 */
package eu.ha3.mc.haddon.implem;

import eu.ha3.mc.haddon.PrivateAccessException;
import java.lang.reflect.Field;
import java.util.logging.Logger;

public class HaddonUtilitySingleton {
    public static final Logger LOGGER = Logger.getLogger("HaddonUtilitySingleton");
    private static final HaddonUtilitySingleton instance = new HaddonUtilitySingleton();
    private Field fieldMod;

    private HaddonUtilitySingleton() {
        try {
            this.fieldMod = Field.class.getDeclaredField("modifiers");
            this.fieldMod.setAccessible(true);
        }
        catch (SecurityException securityException) {
            throw new RuntimeException("haddonUtility critical failure: Security");
        }
        catch (NoSuchFieldException noSuchFieldException) {
            throw new RuntimeException("haddonUtility critical failure: NoSuchField");
        }
    }

    public static HaddonUtilitySingleton getInstance() {
        return instance;
    }

    public Field getFieldModifiers() {
        return this.fieldMod;
    }

    public Object getPrivateValue(Class clazz, Object object, int n) throws PrivateAccessException {
        try {
            Field field = clazz.getDeclaredFields()[n];
            field.setAccessible(true);
            return field.get(object);
        }
        catch (IllegalAccessException illegalAccessException) {
            throw new PrivateAccessException("getPrivateValue has failed: IllegalAccess");
        }
        catch (IllegalArgumentException illegalArgumentException) {
            throw new PrivateAccessException("getPrivateValue has failed: IllegalArgument");
        }
        catch (SecurityException securityException) {
            throw new PrivateAccessException("getPrivateValue has failed: Security");
        }
    }

    public void setPrivateValue(Class clazz, Object object, int n, Object object2) throws PrivateAccessException {
        try {
            Field field = clazz.getDeclaredFields()[n];
            field.setAccessible(true);
            int n2 = this.fieldMod.getInt(field);
            if ((n2 & 0x10) != 0) {
                this.fieldMod.setInt(field, n2 & 0xFFFFFFEF);
            }
            field.set(object, object2);
        }
        catch (IllegalAccessException illegalAccessException) {
            throw new PrivateAccessException("setPrivateValue has failed: IllegalAccess");
        }
        catch (IllegalArgumentException illegalArgumentException) {
            throw new PrivateAccessException("setPrivateValue has failed: IllegalArgument");
        }
        catch (SecurityException securityException) {
            throw new PrivateAccessException("setPrivateValue has failed: Security");
        }
    }

    public Object getPrivateValueViaName(Class clazz, Object object, String string) throws PrivateAccessException {
        try {
            Field field = clazz.getDeclaredField(string);
            field.setAccessible(true);
            return field.get(object);
        }
        catch (IllegalAccessException illegalAccessException) {
            throw new PrivateAccessException("getPrivateValue has failed: IllegalAccess");
        }
        catch (IllegalArgumentException illegalArgumentException) {
            throw new PrivateAccessException("getPrivateValue has failed: IllegalArgument");
        }
        catch (SecurityException securityException) {
            throw new PrivateAccessException("getPrivateValue has failed: Security");
        }
        catch (NoSuchFieldException noSuchFieldException) {
            throw new PrivateAccessException("getPrivateValue has failed: NoSuchField");
        }
    }

    public void setPrivateValueViaName(Class clazz, Object object, String string, Object object2) throws PrivateAccessException {
        try {
            Field field = clazz.getDeclaredField(string);
            field.setAccessible(true);
            int n = this.fieldMod.getInt(field);
            if ((n & 0x10) != 0) {
                this.fieldMod.setInt(field, n & 0xFFFFFFEF);
            }
            field.set(object, object2);
        }
        catch (IllegalAccessException illegalAccessException) {
            throw new PrivateAccessException("setPrivateValue has failed: IllegalAccess");
        }
        catch (IllegalArgumentException illegalArgumentException) {
            throw new PrivateAccessException("setPrivateValue has failed: IllegalArgument");
        }
        catch (SecurityException securityException) {
            throw new PrivateAccessException("setPrivateValue has failed: Security");
        }
        catch (NoSuchFieldException noSuchFieldException) {
            throw new PrivateAccessException("setPrivateValue has failed: NoSuchField");
        }
    }
}

