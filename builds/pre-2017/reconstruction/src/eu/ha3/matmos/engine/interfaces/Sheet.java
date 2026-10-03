/*
 * Decompiled with CFR 0.152.
 */
package eu.ha3.matmos.engine.interfaces;

public interface Sheet<T> {
    public T get(int var1);

    public void set(int var1, T var2);

    public int getSize();

    public int getVersionOf(int var1);
}

