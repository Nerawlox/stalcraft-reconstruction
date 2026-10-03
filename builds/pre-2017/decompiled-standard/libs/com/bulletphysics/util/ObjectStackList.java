/*
 * Decompiled with CFR 0.152.
 */
package com.bulletphysics.util;

import com.bulletphysics.util.StackList;

public class ObjectStackList<T>
extends StackList<T> {
    private Class<T> cls;

    public ObjectStackList(Class<T> cls) {
        super(false);
        this.cls = cls;
    }

    @Override
    protected T create() {
        try {
            return this.cls.newInstance();
        }
        catch (InstantiationException e) {
            throw new IllegalStateException(e);
        }
        catch (IllegalAccessException e) {
            throw new IllegalStateException(e);
        }
    }

    @Override
    protected void copy(T dest, T src) {
        throw new UnsupportedOperationException();
    }
}

