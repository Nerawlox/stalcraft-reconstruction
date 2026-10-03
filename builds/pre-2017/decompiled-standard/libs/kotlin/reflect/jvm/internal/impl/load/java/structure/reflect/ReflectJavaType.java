/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.load.java.structure.reflect;

import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Type;
import java.lang.reflect.WildcardType;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaType;
import kotlin.reflect.jvm.internal.impl.load.java.structure.reflect.ReflectJavaArrayType;
import kotlin.reflect.jvm.internal.impl.load.java.structure.reflect.ReflectJavaClassifierType;
import kotlin.reflect.jvm.internal.impl.load.java.structure.reflect.ReflectJavaPrimitiveType;
import kotlin.reflect.jvm.internal.impl.load.java.structure.reflect.ReflectJavaWildcardType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public abstract class ReflectJavaType
implements JavaType {
    public static final Factory Factory = new Factory(null);

    @NotNull
    protected abstract Type getReflectType();

    public boolean equals(@Nullable Object other) {
        return other instanceof ReflectJavaType && Intrinsics.areEqual(this.getReflectType(), ((ReflectJavaType)other).getReflectType());
    }

    public int hashCode() {
        return this.getReflectType().hashCode();
    }

    @NotNull
    public String toString() {
        return this.getClass().getName() + ": " + this.getReflectType();
    }

    public static final class Factory {
        @NotNull
        public final ReflectJavaType create(@NotNull Type type2) {
            Intrinsics.checkParameterIsNotNull(type2, "type");
            return type2 instanceof Class && ((Class)type2).isPrimitive() ? (ReflectJavaType)new ReflectJavaPrimitiveType((Class)type2) : (type2 instanceof GenericArrayType || type2 instanceof Class && ((Class)type2).isArray() ? (ReflectJavaType)new ReflectJavaArrayType(type2) : (type2 instanceof WildcardType ? (ReflectJavaType)new ReflectJavaWildcardType((WildcardType)type2) : (ReflectJavaType)new ReflectJavaClassifierType(type2)));
        }

        private Factory() {
        }

        public /* synthetic */ Factory(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }
}

