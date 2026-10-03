/*
 * Decompiled with CFR 0.152.
 */
package eu.ha3.mc.haddon.implem;

import eu.ha3.mc.haddon.PrivateAccessException;

public interface PrivateEntry {
    public String getName();

    public Class getTarget();

    public int getZero();

    public String[] getFieldNames();

    public Object get(Object var1) throws PrivateAccessException;

    public void set(Object var1, Object var2) throws PrivateAccessException;
}

