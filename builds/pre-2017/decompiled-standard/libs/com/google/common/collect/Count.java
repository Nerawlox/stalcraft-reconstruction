/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import java.io.Serializable;
import javax.annotation.Nullable;

@GwtCompatible
final class Count
implements Serializable {
    private int value;

    Count(int value) {
        this.value = value;
    }

    public int get() {
        return this.value;
    }

    public int getAndAdd(int delta) {
        int result2 = this.value;
        this.value = result2 + delta;
        return result2;
    }

    public int addAndGet(int delta) {
        return this.value += delta;
    }

    public void set(int newValue) {
        this.value = newValue;
    }

    public int getAndSet(int newValue) {
        int result2 = this.value;
        this.value = newValue;
        return result2;
    }

    public int hashCode() {
        return this.value;
    }

    public boolean equals(@Nullable Object obj) {
        return obj instanceof Count && ((Count)obj).value == this.value;
    }

    public String toString() {
        return Integer.toString(this.value);
    }
}

