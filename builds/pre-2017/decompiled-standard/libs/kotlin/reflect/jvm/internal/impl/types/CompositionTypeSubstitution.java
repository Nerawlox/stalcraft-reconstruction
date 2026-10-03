/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.types;

import java.util.Map;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.types.DelegatedTypeSubstitution;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitution;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class CompositionTypeSubstitution
extends DelegatedTypeSubstitution {
    private final TypeSubstitution outer;
    private final Map<TypeParameterDescriptor, TypeParameterDescriptor> inner;

    @Override
    @Nullable
    public TypeProjection get(@NotNull KotlinType key) {
        Object object;
        block5: {
            block4: {
                Intrinsics.checkParameterIsNotNull(key, "key");
                Object object2 = this.inner;
                ClassifierDescriptor classifierDescriptor = key.getConstructor().getDeclarationDescriptor();
                Map<TypeParameterDescriptor, TypeParameterDescriptor> map2 = object2;
                if (map2 == null) {
                    throw new TypeCastException("null cannot be cast to non-null type kotlin.collections.Map<K, V>");
                }
                object = map2.get(classifierDescriptor);
                if (object == null) break block4;
                object2 = object;
                TypeParameterDescriptor it = (TypeParameterDescriptor)object2;
                SimpleType simpleType2 = it.getDefaultType();
                Intrinsics.checkExpressionValueIsNotNull(simpleType2, "it.defaultType");
                object = this.outer.get(simpleType2);
                if (object != null) break block5;
            }
            object = this.outer.get(key);
        }
        return object;
    }

    public CompositionTypeSubstitution(@NotNull TypeSubstitution outer, @NotNull Map<TypeParameterDescriptor, ? extends TypeParameterDescriptor> inner) {
        Intrinsics.checkParameterIsNotNull(outer, "outer");
        Intrinsics.checkParameterIsNotNull(inner, "inner");
        super(outer);
        this.outer = outer;
        this.inner = inner;
    }
}

