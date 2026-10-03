/*
 * Decompiled with CFR 0.152.
 */
package eu.ha3.util.property.simple;

import eu.ha3.util.property.contract.PropertyHolder;
import eu.ha3.util.property.contract.Versionnable;
import eu.ha3.util.property.simple.PropertyCell;
import eu.ha3.util.property.simple.PropertyMissingException;
import eu.ha3.util.property.simple.PropertyTypeException;
import java.util.Map;

public class VersionnableProperty
implements PropertyHolder,
Versionnable {
    private PropertyHolder soft = new PropertyCell();
    private PropertyHolder hard = new PropertyCell();

    @Override
    public boolean commit() {
        if (this.soft.getAllProperties().size() == 0) {
            return false;
        }
        this.hard.getAllProperties().putAll(this.soft.getAllProperties());
        this.soft.getAllProperties().clear();
        return true;
    }

    @Override
    public void revert() {
        this.soft.getAllProperties().clear();
    }

    @Override
    public String getString(String string) {
        try {
            return this.soft.getString(string);
        }
        catch (PropertyMissingException propertyMissingException) {
            return this.hard.getString(string);
        }
    }

    @Override
    public boolean getBoolean(String string) {
        try {
            return this.soft.getBoolean(string);
        }
        catch (PropertyMissingException propertyMissingException) {
            return this.hard.getBoolean(string);
        }
        catch (PropertyTypeException propertyTypeException) {
            return this.hard.getBoolean(string);
        }
    }

    @Override
    public int getInteger(String string) {
        try {
            return this.soft.getInteger(string);
        }
        catch (PropertyMissingException propertyMissingException) {
            return this.hard.getInteger(string);
        }
        catch (PropertyTypeException propertyTypeException) {
            return this.hard.getInteger(string);
        }
    }

    @Override
    public float getFloat(String string) {
        try {
            return this.soft.getFloat(string);
        }
        catch (PropertyMissingException propertyMissingException) {
            return this.hard.getFloat(string);
        }
        catch (PropertyTypeException propertyTypeException) {
            return this.hard.getFloat(string);
        }
    }

    @Override
    public long getLong(String string) {
        try {
            return this.soft.getLong(string);
        }
        catch (PropertyMissingException propertyMissingException) {
            return this.hard.getLong(string);
        }
        catch (PropertyTypeException propertyTypeException) {
            return this.hard.getLong(string);
        }
    }

    @Override
    public double getDouble(String string) {
        try {
            return this.soft.getDouble(string);
        }
        catch (PropertyMissingException propertyMissingException) {
            return this.hard.getDouble(string);
        }
        catch (PropertyTypeException propertyTypeException) {
            return this.hard.getDouble(string);
        }
    }

    @Override
    public void setProperty(String string, Object object) {
        this.soft.setProperty(string, object);
    }

    @Override
    public Map<String, String> getAllProperties() {
        return this.hard.getAllProperties();
    }
}

