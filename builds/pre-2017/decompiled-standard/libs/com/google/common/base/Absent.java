/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package com.google.common.base;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Function;
import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import com.google.common.base.Supplier;
import java.util.Collections;
import java.util.Set;
import javax.annotation.Nullable;

@GwtCompatible
final class Absent
extends Optional<Object> {
    static final Absent INSTANCE = new Absent();
    private static final long serialVersionUID = 0L;

    private Absent() {
    }

    @Override
    public boolean isPresent() {
        return false;
    }

    @Override
    public Object get() {
        throw new IllegalStateException("Optional.get() cannot be called on an absent value");
    }

    @Override
    public Object or(Object defaultValue) {
        return Preconditions.checkNotNull(defaultValue, "use Optional.orNull() instead of Optional.or(null)");
    }

    @Override
    public Optional<Object> or(Optional<?> secondChoice) {
        return Preconditions.checkNotNull(secondChoice);
    }

    @Override
    public Object or(Supplier<?> supplier) {
        return Preconditions.checkNotNull(supplier.get(), "use Optional.orNull() instead of a Supplier that returns null");
    }

    @Override
    @Nullable
    public Object orNull() {
        return null;
    }

    @Override
    public Set<Object> asSet() {
        return Collections.emptySet();
    }

    @Override
    public <V> Optional<V> transform(Function<Object, V> function) {
        Preconditions.checkNotNull(function);
        return Optional.absent();
    }

    @Override
    public boolean equals(@Nullable Object object) {
        return object == this;
    }

    @Override
    public int hashCode() {
        return 1502476572;
    }

    @Override
    public String toString() {
        return "Optional.absent()";
    }

    private Object readResolve() {
        return INSTANCE;
    }
}

