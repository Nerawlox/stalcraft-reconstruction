/*
 * Decompiled with CFR 0.152.
 */
package mcoptifine;

import java.lang.reflect.Field;
import mcoptifine.Config;
import mcoptifine.Reflector;
import mcoptifine.ReflectorClass;

public class ReflectorField {
    private ReflectorClass reflectorClass = null;
    private String targetFieldName = null;
    private boolean checked = false;
    private Field targetField = null;

    public ReflectorField(ReflectorClass reflectorClass, String string) {
        this.reflectorClass = reflectorClass;
        this.targetFieldName = string;
        Field field = this.getTargetField();
    }

    public Field getTargetField() {
        if (this.checked) {
            return this.targetField;
        }
        this.checked = true;
        Class clazz = this.reflectorClass.getTargetClass();
        if (clazz == null) {
            return null;
        }
        try {
            this.targetField = clazz.getDeclaredField(this.targetFieldName);
        }
        catch (SecurityException securityException) {
            securityException.printStackTrace();
        }
        catch (NoSuchFieldException noSuchFieldException) {
            Config.log("(Reflector) Field not present: " + clazz.getName() + "." + this.targetFieldName);
        }
        return this.targetField;
    }

    public Object getValue() {
        return Reflector.getFieldValue(null, this);
    }

    public void setValue(Object object) {
        Reflector.setFieldValue(null, this, object);
    }

    public boolean exists() {
        return this.checked ? this.targetField != null : this.getTargetField() != null;
    }
}

