/*
 * Decompiled with CFR 0.152.
 */
package mcoptifine;

import java.lang.reflect.Method;
import mcoptifine.Config;
import mcoptifine.Reflector;
import mcoptifine.ReflectorClass;

public class ReflectorMethod {
    private ReflectorClass reflectorClass = null;
    private String targetMethodName = null;
    private Class[] targetMethodParameterTypes = null;
    private boolean checked = false;
    private Method targetMethod = null;

    public ReflectorMethod(ReflectorClass reflectorClass, String string) {
        this(reflectorClass, string, null);
    }

    public ReflectorMethod(ReflectorClass reflectorClass, String string, Class[] classArray) {
        this.reflectorClass = reflectorClass;
        this.targetMethodName = string;
        this.targetMethodParameterTypes = classArray;
        Method method = this.getTargetMethod();
    }

    public Method getTargetMethod() {
        Method method;
        if (this.checked) {
            return this.targetMethod;
        }
        this.checked = true;
        Class clazz = this.reflectorClass.getTargetClass();
        if (clazz == null) {
            return null;
        }
        Method[] methodArray = clazz.getMethods();
        int n = 0;
        while (true) {
            Class[] classArray;
            if (n >= methodArray.length) {
                Config.log("(Reflector) Method not pesent: " + clazz.getName() + "." + this.targetMethodName);
                return null;
            }
            method = methodArray[n];
            if (method.getName().equals(this.targetMethodName) && (this.targetMethodParameterTypes == null || Reflector.matchesTypes(this.targetMethodParameterTypes, classArray = method.getParameterTypes()))) break;
            ++n;
        }
        this.targetMethod = method;
        return this.targetMethod;
    }

    public boolean exists() {
        return this.checked ? this.targetMethod != null : this.getTargetMethod() != null;
    }

    public Class getReturnType() {
        Method method = this.getTargetMethod();
        return method == null ? null : method.getReturnType();
    }

    public void deactivate() {
        this.checked = true;
        this.targetMethod = null;
    }
}

