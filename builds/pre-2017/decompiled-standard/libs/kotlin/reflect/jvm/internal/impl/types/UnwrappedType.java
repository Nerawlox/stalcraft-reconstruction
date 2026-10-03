/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.types;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import org.jetbrains.annotations.NotNull;

public abstract class UnwrappedType
extends KotlinType {
    @NotNull
    public abstract UnwrappedType replaceAnnotations(@NotNull Annotations var1);

    @NotNull
    public abstract UnwrappedType makeNullableAsSpecified(boolean var1);

    @Override
    @NotNull
    public final UnwrappedType unwrap() {
        return this;
    }

    private UnwrappedType() {
        super(null);
    }

    public /* synthetic */ UnwrappedType(DefaultConstructorMarker $constructor_marker) {
        this();
    }
}

