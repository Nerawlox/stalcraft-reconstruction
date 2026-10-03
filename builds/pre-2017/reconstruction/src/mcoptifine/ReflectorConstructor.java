/*
 * Decompiled with CFR 0.152.
 */
package mcoptifine;

import java.lang.reflect.Constructor;
import mcoptifine.Config;
import mcoptifine.Reflector;
import mcoptifine.ReflectorClass;

public class ReflectorConstructor {
    private ReflectorClass reflectorClass = null;
    private Class[] parameterTypes = null;
    private boolean checked = false;
    private Constructor targetConstructor = null;

    public ReflectorConstructor(ReflectorClass reflectorClass, Class[] classArray) {
        this.reflectorClass = reflectorClass;
        this.parameterTypes = classArray;
        Constructor constructor = this.getTargetConstructor();
    }

    public Constructor getTargetConstructor() {
        if (this.checked) {
            return this.targetConstructor;
        }
        this.checked = true;
        Class clazz = this.reflectorClass.getTargetClass();
        if (clazz == null) {
            return null;
        }
        this.targetConstructor = ReflectorConstructor.findConstructor(clazz, this.parameterTypes);
        if (this.targetConstructor == null) {
            Config.dbg("(Reflector) Constructor not present: " + clazz.getName() + ", params: " + Config.arrayToString(this.parameterTypes));
        }
        return this.targetConstructor;
    }

    private static Constructor findConstructor(Class clazz, Class[] classArray) {
        Constructor<?>[] constructorArray = clazz.getConstructors();
        for (int i = 0; i < constructorArray.length; ++i) {
            Constructor<?> constructor = constructorArray[i];
            Class[] classArray2 = constructor.getParameterTypes();
            if (!Reflector.matchesTypes(classArray, classArray2)) continue;
            return constructor;
        }
        return null;
    }
}

