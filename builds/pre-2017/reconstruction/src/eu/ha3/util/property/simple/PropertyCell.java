/*
 * Decompiled with CFR 0.152.
 */
package eu.ha3.util.property.simple;

import eu.ha3.util.property.contract.PropertyHolder;
import eu.ha3.util.property.simple.PropertyMissingException;
import eu.ha3.util.property.simple.PropertyTypeException;
import java.util.HashMap;
import java.util.Map;

public class PropertyCell
implements PropertyHolder {
    private Map<String, String> properties = new HashMap<String, String>();

    @Override
    public String getString(String string) {
        if (!this.properties.containsKey(string)) {
            throw new PropertyMissingException();
        }
        return this.properties.get(string);
    }

    @Override
    public boolean getBoolean(String string) {
        if (!this.properties.containsKey(string)) {
            throw new PropertyMissingException();
        }
        try {
            return Boolean.parseBoolean(this.properties.get(string));
        }
        catch (NumberFormatException numberFormatException) {
            throw new PropertyTypeException();
        }
    }

    @Override
    public int getInteger(String string) {
        if (!this.properties.containsKey(string)) {
            throw new PropertyMissingException();
        }
        try {
            return Integer.parseInt(this.properties.get(string));
        }
        catch (NumberFormatException numberFormatException) {
            throw new PropertyTypeException();
        }
    }

    @Override
    public float getFloat(String string) {
        if (!this.properties.containsKey(string)) {
            throw new PropertyMissingException();
        }
        try {
            return Float.parseFloat(this.properties.get(string));
        }
        catch (NumberFormatException numberFormatException) {
            throw new PropertyTypeException();
        }
    }

    @Override
    public long getLong(String string) {
        if (!this.properties.containsKey(string)) {
            throw new PropertyMissingException();
        }
        try {
            return Long.parseLong(this.properties.get(string));
        }
        catch (NumberFormatException numberFormatException) {
            throw new PropertyTypeException();
        }
    }

    @Override
    public double getDouble(String string) {
        if (!this.properties.containsKey(string)) {
            throw new PropertyMissingException();
        }
        try {
            return Double.parseDouble(this.properties.get(string));
        }
        catch (NumberFormatException numberFormatException) {
            throw new PropertyTypeException();
        }
    }

    @Override
    public void setProperty(String string, Object object) {
        this.properties.put(string, object.toString());
    }

    @Override
    public Map<String, String> getAllProperties() {
        return this.properties;
    }
}

