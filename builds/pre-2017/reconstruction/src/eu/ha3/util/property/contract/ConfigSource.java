/*
 * Decompiled with CFR 0.152.
 */
package eu.ha3.util.property.contract;

public interface ConfigSource {
    public void setSource(String var1);

    public boolean load();

    public boolean save();
}

