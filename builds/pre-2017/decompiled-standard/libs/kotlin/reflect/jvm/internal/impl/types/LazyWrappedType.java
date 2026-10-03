/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.types;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.WrappedType;
import org.jetbrains.annotations.NotNull;

public final class LazyWrappedType
extends WrappedType {
    private final NotNullLazyValue<KotlinType> lazyValue;

    @Override
    @NotNull
    protected KotlinType getDelegate() {
        return (KotlinType)this.lazyValue.invoke();
    }

    @Override
    public boolean isComputed() {
        return this.lazyValue.isComputed();
    }

    public LazyWrappedType(@NotNull StorageManager storageManager, @NotNull Function0<? extends KotlinType> computation) {
        Intrinsics.checkParameterIsNotNull(storageManager, "storageManager");
        Intrinsics.checkParameterIsNotNull(computation, "computation");
        this.lazyValue = storageManager.createLazyValue(computation);
    }
}

