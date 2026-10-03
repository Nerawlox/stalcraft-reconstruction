/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.load.java.structure.reflect;

import java.lang.reflect.Type;
import java.lang.reflect.WildcardType;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaWildcardType;
import kotlin.reflect.jvm.internal.impl.load.java.structure.reflect.ReflectJavaType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class ReflectJavaWildcardType
extends ReflectJavaType
implements JavaWildcardType {
    @NotNull
    private final WildcardType reflectType;

    @Override
    @Nullable
    public ReflectJavaType getBound() {
        ReflectJavaType reflectJavaType;
        Type[] upperBounds2 = this.getReflectType().getUpperBounds();
        Type[] lowerBounds = this.getReflectType().getLowerBounds();
        if (((Object[])upperBounds2).length > 1 || ((Object[])lowerBounds).length > 1) {
            throw (Throwable)new UnsupportedOperationException("Wildcard types with many bounds are not yet supported: " + this.getReflectType());
        }
        if (((Object[])lowerBounds).length == 1) {
            Object object = ArraysKt.single((Object[])lowerBounds);
            Intrinsics.checkExpressionValueIsNotNull(object, "lowerBounds.single()");
            reflectJavaType = ReflectJavaType.Factory.create((Type)object);
        } else if (((Object[])upperBounds2).length == 1) {
            ReflectJavaType reflectJavaType2;
            Object object = ArraysKt.single((Object[])upperBounds2);
            Type ub = (Type)object;
            if (Intrinsics.areEqual(ub, Object.class) ^ true) {
                Type type2 = ub;
                Intrinsics.checkExpressionValueIsNotNull(type2, "ub");
                reflectJavaType2 = ReflectJavaType.Factory.create(type2);
            } else {
                reflectJavaType2 = null;
            }
            reflectJavaType = reflectJavaType2;
        } else {
            reflectJavaType = null;
        }
        return reflectJavaType;
    }

    @Override
    public boolean isExtends() {
        return Intrinsics.areEqual((Type)ArraysKt.firstOrNull((Object[])this.getReflectType().getUpperBounds()), Object.class) ^ true;
    }

    @Override
    @NotNull
    protected WildcardType getReflectType() {
        return this.reflectType;
    }

    public ReflectJavaWildcardType(@NotNull WildcardType reflectType) {
        Intrinsics.checkParameterIsNotNull(reflectType, "reflectType");
        this.reflectType = reflectType;
    }
}

