/*
 * Decompiled with CFR 0.152.
 */
package com.bulletphysics.util;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.AbstractList;
import java.util.RandomAccess;

public final class ObjectArrayList<T>
extends AbstractList<T>
implements RandomAccess,
Externalizable {
    private T[] array;
    private int size;

    public ObjectArrayList() {
        this(16);
    }

    public ObjectArrayList(int initialCapacity) {
        this.array = new Object[initialCapacity];
    }

    @Override
    public boolean add(T value) {
        if (this.size == this.array.length) {
            this.expand();
        }
        this.array[this.size++] = value;
        return true;
    }

    @Override
    public void add(int index, T value) {
        int num;
        if (this.size == this.array.length) {
            this.expand();
        }
        if ((num = this.size - index) > 0) {
            System.arraycopy(this.array, index, this.array, index + 1, num);
        }
        this.array[index] = value;
        ++this.size;
    }

    @Override
    public T remove(int index) {
        if (index < 0 || index >= this.size) {
            throw new IndexOutOfBoundsException();
        }
        T prev = this.array[index];
        System.arraycopy(this.array, index + 1, this.array, index, this.size - index - 1);
        this.array[this.size - 1] = null;
        --this.size;
        return prev;
    }

    private void expand() {
        Object[] newArray = new Object[this.array.length << 1];
        System.arraycopy(this.array, 0, newArray, 0, this.array.length);
        this.array = newArray;
    }

    public void removeQuick(int index) {
        System.arraycopy(this.array, index + 1, this.array, index, this.size - index - 1);
        this.array[this.size - 1] = null;
        --this.size;
    }

    @Override
    public T get(int index) {
        if (index >= this.size) {
            throw new IndexOutOfBoundsException();
        }
        return this.array[index];
    }

    public T getQuick(int index) {
        return this.array[index];
    }

    @Override
    public T set(int index, T value) {
        if (index >= this.size) {
            throw new IndexOutOfBoundsException();
        }
        T old = this.array[index];
        this.array[index] = value;
        return old;
    }

    public void setQuick(int index, T value) {
        this.array[index] = value;
    }

    @Override
    public int size() {
        return this.size;
    }

    public int capacity() {
        return this.array.length;
    }

    @Override
    public void clear() {
        this.size = 0;
    }

    @Override
    public int indexOf(Object o) {
        int _size = this.size;
        T[] _array = this.array;
        for (int i = 0; i < _size; ++i) {
            if (!(o == null ? _array[i] == null : o.equals(_array[i]))) continue;
            return i;
        }
        return -1;
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeInt(this.size);
        for (int i = 0; i < this.size; ++i) {
            out.writeObject(this.array[i]);
        }
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        int cap;
        this.size = in.readInt();
        for (cap = 16; cap < this.size; cap <<= 1) {
        }
        this.array = new Object[cap];
        for (int i = 0; i < this.size; ++i) {
            this.array[i] = in.readObject();
        }
    }
}

