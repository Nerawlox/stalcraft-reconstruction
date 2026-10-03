/*
 * Decompiled with CFR 0.152.
 */
package argo.jdom;

interface Functor<T, V> {
    public boolean matchesNode(T var1);

    public V applyTo(T var1);

    public String shortForm();
}

