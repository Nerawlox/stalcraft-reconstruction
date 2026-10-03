/*
 * Decompiled with CFR 0.152.
 */
package net.sf.kdgcommons.bean;

import java.beans.Introspector;
import java.lang.reflect.Method;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import net.sf.kdgcommons.bean.IntrospectionException;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
public class Introspection {
    private Set<String> _propNames = new HashSet<String>();
    private Set<String> _propNamesPublic = Collections.unmodifiableSet(this._propNames);
    private Map<String, Method> _getters = new HashMap<String, Method>();
    private Map<String, Method> _setters = new HashMap<String, Method>();

    public Introspection(Class<?> clazz) {
        this.introspect(clazz);
    }

    public Set<String> propertyNames() {
        return this._propNamesPublic;
    }

    public Method getter(String string) {
        return this._getters.get(string.toLowerCase());
    }

    public Method setter(String string) {
        return this._setters.get(string.toLowerCase());
    }

    public Class<?> type(String string) {
        Method method = this.getter(string);
        return method == null ? null : method.getReturnType();
    }

    private void introspect(Class<?> clazz) {
        try {
            for (Method method : clazz.getMethods()) {
                String string;
                if (method.getDeclaringClass() == Object.class) continue;
                String string2 = method.getName();
                int n = method.getParameterTypes().length;
                if (string2.startsWith("get") && n == 0) {
                    string = this.extractAndSavePropName(string2, 3);
                    this.saveGetter(string, method);
                    continue;
                }
                if (string2.startsWith("is") && n == 0) {
                    string = this.extractAndSavePropName(string2, 2);
                    this.saveGetter(string, method);
                    continue;
                }
                if (!string2.startsWith("set") || n != 1) continue;
                string = this.extractAndSavePropName(string2, 3);
                this.saveSetter(string, method);
            }
        }
        catch (Exception exception) {
            throw new IntrospectionException("unable to introspect", exception);
        }
    }

    private String extractAndSavePropName(String string, int n) {
        String string2 = string.substring(n);
        this._propNames.add(Introspector.decapitalize(string2));
        return string2.toLowerCase();
    }

    private void saveGetter(String string, Method method) {
        Method method2 = this._getters.get(string);
        if (method2 == null) {
            this._getters.put(string, method);
            return;
        }
        Class<?> clazz = method.getReturnType();
        Class<?> clazz2 = method2.getReturnType();
        if (clazz2.isAssignableFrom(clazz)) {
            this._getters.put(string, method);
            return;
        }
    }

    private void saveSetter(String string, Method method) {
        Method method2 = this._setters.get(string);
        if (method2 == null) {
            this._setters.put(string, method);
            return;
        }
        Class<?> clazz = method.getDeclaringClass();
        Class<?> clazz2 = method2.getDeclaringClass();
        if (!clazz2.isAssignableFrom(clazz)) {
            return;
        }
        if (clazz != clazz2) {
            this._setters.put(string, method);
            return;
        }
        if (Introspection.setterRank(method) < Introspection.setterRank(method2)) {
            this._setters.put(string, method);
            return;
        }
    }

    private static int setterRank(Method method) {
        Class<?> clazz = method.getParameterTypes()[0];
        if (clazz.isPrimitive()) {
            return 1;
        }
        if (Number.class.isAssignableFrom(clazz)) {
            return 2;
        }
        if (String.class.isAssignableFrom(clazz)) {
            return 3;
        }
        return 4;
    }
}

