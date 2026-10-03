/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.core.client.gui.engine;

import com.google.common.collect.Maps;
import gloomyfolken.mods.core.client.gui.engine.Property;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.Iterator;

public class ComponentPropertiesParser<T> {
    private T parsedComponent;
    private HashMap<String, Object> componentProperties = Maps.newHashMap();

    public void parse(T t) {
        try {
            this.parseProperties(t);
        }
        catch (IllegalAccessException illegalAccessException) {
            illegalAccessException.printStackTrace();
        }
    }

    private void parseProperties(T t) throws IllegalAccessException {
        this.parsedComponent = t;
        this.componentProperties.clear();
        for (Field field : t.getClass().getDeclaredFields()) {
            if (field.getAnnotation(Property.class) == null) continue;
            if (!field.isAccessible()) {
                field.setAccessible(true);
            }
            this.componentProperties.put(field.getName(), field.get(t));
        }
    }

    public boolean setProperty(String string, Object object) {
        if (this.componentProperties.containsKey(string)) {
            this.componentProperties.put(string, object);
            return true;
        }
        return false;
    }

    public Object getProperty(String string) {
        return this.componentProperties.get(string);
    }

    public Iterator<String> getIterator() {
        return this.componentProperties.keySet().iterator();
    }

    public void apply() {
        try {
            this.applyProperties();
        }
        catch (IllegalAccessException illegalAccessException) {
            illegalAccessException.printStackTrace();
        }
    }

    private void applyProperties() throws IllegalAccessException {
        for (Field field : this.parsedComponent.getClass().getDeclaredFields()) {
            if (field.getAnnotation(Property.class) == null) continue;
            Object object = this.componentProperties.get(field.getName());
            if (!this.componentProperties.containsKey(field.getName())) continue;
            field.setAccessible(true);
            if (Modifier.isFinal(field.getModifiers())) continue;
            field.set(this.parsedComponent, object);
        }
    }
}

