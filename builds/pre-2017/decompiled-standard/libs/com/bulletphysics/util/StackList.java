/*
 * Decompiled with CFR 0.152.
 */
package com.bulletphysics.util;

import com.bulletphysics.util.ObjectArrayList;

public abstract class StackList<T> {
    private final ObjectArrayList<T> list = new ObjectArrayList();
    private T returnObj;
    private int[] stack = new int[512];
    private int stackCount = 0;
    private int pos = 0;

    public StackList() {
        this.returnObj = this.create();
    }

    protected StackList(boolean unused) {
    }

    public final void push() {
        this.stack[this.stackCount++] = this.pos;
    }

    public final void pop() {
        this.pos = this.stack[--this.stackCount];
    }

    public T get() {
        if (this.pos == this.list.size()) {
            this.expand();
        }
        return this.list.getQuick(this.pos++);
    }

    public final T returning(T obj) {
        this.copy(this.returnObj, obj);
        return this.returnObj;
    }

    protected abstract T create();

    protected abstract void copy(T var1, T var2);

    private void expand() {
        this.list.add(this.create());
    }
}

