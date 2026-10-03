/*
 * Decompiled with CFR 0.152.
 */
package mcoptifine;

import mcoptifine.Config;

public class ReflectorClass {
    private String targetClassName = null;
    private boolean checked = false;
    private Class targetClass = null;

    public ReflectorClass(String string) {
        this.targetClassName = string;
        Class clazz = this.getTargetClass();
    }

    public ReflectorClass(Class clazz) {
        this.targetClass = clazz;
        this.targetClassName = clazz.getName();
        this.checked = true;
    }

    public Class getTargetClass() {
        if (this.checked) {
            return this.targetClass;
        }
        this.checked = true;
        try {
            this.targetClass = Class.forName(this.targetClassName);
        }
        catch (ClassNotFoundException classNotFoundException) {
            Config.log("(Reflector) Class not present: " + this.targetClassName);
        }
        catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        return this.targetClass;
    }

    public boolean exists() {
        return this.getTargetClass() != null;
    }

    public String getTargetClassName() {
        return this.targetClassName;
    }
}

