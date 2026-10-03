/*
 * Decompiled with CFR 0.152.
 */
package com.intellij.uiDesigner.lw;

public final class StringDescriptor {
    private final String myBundleName;
    private final String myKey;
    private final String myValue;
    private String myResolvedValue;
    private boolean myNoI18n;

    private StringDescriptor(String value) {
        if (value == null) {
            throw new IllegalArgumentException("value cannot be null");
        }
        this.myBundleName = null;
        this.myKey = null;
        this.myValue = value;
    }

    public StringDescriptor(String bundleName, String key) {
        if (bundleName == null) {
            throw new IllegalArgumentException("bundleName cannot be null");
        }
        if (key == null) {
            throw new IllegalArgumentException("key cannot be null");
        }
        this.myBundleName = bundleName.replace('.', '/');
        this.myKey = key;
        this.myValue = null;
    }

    public static StringDescriptor create(String value) {
        return value != null ? new StringDescriptor(value) : null;
    }

    public String getValue() {
        return this.myValue;
    }

    public String getBundleName() {
        return this.myBundleName;
    }

    public String getDottedBundleName() {
        return this.myBundleName == null ? null : this.myBundleName.replace('/', '.');
    }

    public String getKey() {
        return this.myKey;
    }

    public String getResolvedValue() {
        return this.myResolvedValue;
    }

    public void setResolvedValue(String resolvedValue) {
        this.myResolvedValue = resolvedValue;
    }

    public boolean isNoI18n() {
        return this.myNoI18n;
    }

    public void setNoI18n(boolean noI18n) {
        this.myNoI18n = noI18n;
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof StringDescriptor)) {
            return false;
        }
        StringDescriptor descriptor2 = (StringDescriptor)o;
        if (this.myBundleName != null ? !this.myBundleName.equals(descriptor2.myBundleName) : descriptor2.myBundleName != null) {
            return false;
        }
        if (this.myKey != null ? !this.myKey.equals(descriptor2.myKey) : descriptor2.myKey != null) {
            return false;
        }
        if (this.myValue != null ? !this.myValue.equals(descriptor2.myValue) : descriptor2.myValue != null) {
            return false;
        }
        return this.myNoI18n == descriptor2.myNoI18n;
    }

    public int hashCode() {
        int result2 = this.myBundleName != null ? this.myBundleName.hashCode() : 0;
        result2 = 29 * result2 + (this.myKey != null ? this.myKey.hashCode() : 0);
        result2 = 29 * result2 + (this.myValue != null ? this.myValue.hashCode() : 0);
        return result2;
    }

    public String toString() {
        if (this.myValue != null) {
            return "[StringDescriptor:" + this.myValue + "]";
        }
        return "[StringDescriptor" + this.myBundleName + ":" + this.myKey + "]";
    }
}

