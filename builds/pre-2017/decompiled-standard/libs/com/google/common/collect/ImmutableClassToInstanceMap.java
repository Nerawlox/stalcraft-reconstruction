/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package com.google.common.collect;

import com.google.common.base.Preconditions;
import com.google.common.collect.ClassToInstanceMap;
import com.google.common.collect.ForwardingMap;
import com.google.common.collect.ImmutableMap;
import com.google.common.primitives.Primitives;
import java.util.Map;
import javax.annotation.Nullable;

public final class ImmutableClassToInstanceMap<B>
extends ForwardingMap<Class<? extends B>, B>
implements ClassToInstanceMap<B> {
    private final ImmutableMap<Class<? extends B>, B> delegate;

    public static <B> Builder<B> builder() {
        return new Builder();
    }

    public static <B, S extends B> ImmutableClassToInstanceMap<B> copyOf(Map<? extends Class<? extends S>, ? extends S> map2) {
        if (map2 instanceof ImmutableClassToInstanceMap) {
            ImmutableClassToInstanceMap cast = (ImmutableClassToInstanceMap)map2;
            return cast;
        }
        return new Builder().putAll(map2).build();
    }

    private ImmutableClassToInstanceMap(ImmutableMap<Class<? extends B>, B> delegate) {
        this.delegate = delegate;
    }

    @Override
    protected Map<Class<? extends B>, B> delegate() {
        return this.delegate;
    }

    @Override
    @Nullable
    public <T extends B> T getInstance(Class<T> type2) {
        return (T)this.delegate.get(Preconditions.checkNotNull(type2));
    }

    @Override
    @Deprecated
    public <T extends B> T putInstance(Class<T> type2, T value) {
        throw new UnsupportedOperationException();
    }

    public static final class Builder<B> {
        private final ImmutableMap.Builder<Class<? extends B>, B> mapBuilder = ImmutableMap.builder();

        public <T extends B> Builder<B> put(Class<T> key, T value) {
            this.mapBuilder.put(key, value);
            return this;
        }

        public <T extends B> Builder<B> putAll(Map<? extends Class<? extends T>, ? extends T> map2) {
            for (Map.Entry<Class<T>, T> entry : map2.entrySet()) {
                Class<? extends T> type2 = entry.getKey();
                T value = entry.getValue();
                this.mapBuilder.put(type2, Builder.cast(type2, value));
            }
            return this;
        }

        private static <B, T extends B> T cast(Class<T> type2, B value) {
            return Primitives.wrap(type2).cast(value);
        }

        public ImmutableClassToInstanceMap<B> build() {
            return new ImmutableClassToInstanceMap(this.mapBuilder.build());
        }
    }
}

