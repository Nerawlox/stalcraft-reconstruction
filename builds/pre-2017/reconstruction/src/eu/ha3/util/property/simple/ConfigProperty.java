/*
 * Decompiled with CFR 0.152.
 */
package eu.ha3.util.property.simple;

import eu.ha3.util.property.contract.ConfigSource;
import eu.ha3.util.property.contract.PropertyHolder;
import eu.ha3.util.property.contract.Versionnable;
import eu.ha3.util.property.simple.VersionnableProperty;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Collections;
import java.util.Enumeration;
import java.util.Map;
import java.util.Properties;
import java.util.TreeSet;

public class ConfigProperty
implements ConfigSource,
PropertyHolder,
Versionnable {
    private VersionnableProperty mixed = new VersionnableProperty();
    private String path;

    @Override
    public void setSource(String string) {
        this.path = string;
    }

    @Override
    public boolean load() {
        File file = new File(this.path);
        if (file.exists()) {
            try {
                FileReader fileReader = new FileReader(file);
                Properties properties = new Properties();
                properties.load(fileReader);
                for (Map.Entry<Object, Object> entry : properties.entrySet()) {
                    this.mixed.setProperty(entry.getKey().toString(), entry.getValue().toString());
                }
                this.mixed.commit();
            }
            catch (FileNotFoundException fileNotFoundException) {
                fileNotFoundException.printStackTrace();
                this.mixed.revert();
                return false;
            }
            catch (IOException iOException) {
                iOException.printStackTrace();
                this.mixed.revert();
                return false;
            }
        } else {
            return false;
        }
        return true;
    }

    @Override
    public boolean save() {
        try {
            File file = new File(this.path);
            Properties properties = new Properties(){

                @Override
                public synchronized Enumeration<Object> keys() {
                    return Collections.enumeration(new TreeSet<Object>(super.keySet()));
                }
            };
            for (Map.Entry<String, String> entry : this.mixed.getAllProperties().entrySet()) {
                properties.setProperty(entry.getKey(), entry.getValue());
            }
            properties.store(new FileWriter(file), "");
        }
        catch (IOException iOException) {
            iOException.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public boolean commit() {
        return this.mixed.commit();
    }

    @Override
    public void revert() {
        this.mixed.revert();
    }

    @Override
    public String getString(String string) {
        return this.mixed.getString(string);
    }

    @Override
    public boolean getBoolean(String string) {
        return this.mixed.getBoolean(string);
    }

    @Override
    public int getInteger(String string) {
        return this.mixed.getInteger(string);
    }

    @Override
    public float getFloat(String string) {
        return this.mixed.getFloat(string);
    }

    @Override
    public long getLong(String string) {
        return this.mixed.getLong(string);
    }

    @Override
    public double getDouble(String string) {
        return this.mixed.getDouble(string);
    }

    @Override
    public void setProperty(String string, Object object) {
        this.mixed.setProperty(string, object);
    }

    @Override
    public Map<String, String> getAllProperties() {
        return this.mixed.getAllProperties();
    }
}

