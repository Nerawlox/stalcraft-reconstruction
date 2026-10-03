/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package com.google.common.reflect;

import com.google.common.annotations.Beta;
import com.google.common.collect.ForwardingMap;
import com.google.common.collect.Maps;
import com.google.common.reflect.TypeToInstanceMap;
import com.google.common.reflect.TypeToken;
import java.util.Map;
import javax.annotation.Nullable;

@Beta
public final class MutableTypeToInstanceMap<B>
extends ForwardingMap<TypeToken<? extends B>, B>
implements TypeToInstanceMap<B> {
    private final Map<TypeToken<? extends B>, B> backingMap = Maps.newHashMap();

    @Override
    @Nullable
    public <T extends B> T getInstance(Class<T> type2) {
        return this.trustedGet(TypeToken.of(type2));
    }

    @Override
    @Nullable
    public <T extends B> T putInstance(Class<T> type2, @Nullable T value) {
        return this.trustedPut(TypeToken.of(type2), value);
    }

    @Override
    @Nullable
    public <T extends B> T getInstance(TypeToken<T> type2) {
        return this.trustedGet(type2.rejectTypeVariables());
    }

    @Override
    @Nullable
    public <T extends B> T putInstance(TypeToken<T> type2, @Nullable T value) {
        return this.trustedPut(type2.rejectTypeVariables(), value);
    }

    @Override
    public B put(TypeToken<? extends B> key, B value) {
        throw new UnsupportedOperationException("Please use putInstance() instead.");
    }

    @Override
    public void putAll(Map<? extends TypeToken<? extends B>, ? extends B> map2) {
        throw new UnsupportedOperationException("Please use putInstance() instead.");
    }

    @Override
    protected Map<TypeToken<? extends B>, B> delegate() {
        return this.backingMap;
    }

    @Nullable
    private <T extends B> T trustedPut(TypeToken<T> type2, @Nullable T value) {
        return (T)this.backingMap.put(type2, value);
    }

    @Nullable
    private <T extends B> T trustedGet(TypeToken<T> type2) {
        return (T)this.backingMap.get(type2);
    }
}

