/*
 * Decompiled with CFR 0.152.
 */
package eu.ha3.util.property.contract;

import java.util.Map;

public interface PropertyHolder {
    public String getString(String var1);

    public boolean getBoolean(String var1);

    public int getInteger(String var1);

    public float getFloat(String var1);

    public long getLong(String var1);

    public double getDouble(String var1);

    public void setProperty(String var1, Object var2);

    public Map<String, String> getAllProperties();
}

