/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.load.java.structure.reflect;

import java.lang.annotation.Annotation;
import kotlin.TypeCastException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotationArgument;
import kotlin.reflect.jvm.internal.impl.load.java.structure.reflect.ReflectClassUtilKt;
import kotlin.reflect.jvm.internal.impl.load.java.structure.reflect.ReflectJavaAnnotationAsAnnotationArgument;
import kotlin.reflect.jvm.internal.impl.load.java.structure.reflect.ReflectJavaArrayAnnotationArgument;
import kotlin.reflect.jvm.internal.impl.load.java.structure.reflect.ReflectJavaClassObjectAnnotationArgument;
import kotlin.reflect.jvm.internal.impl.load.java.structure.reflect.ReflectJavaEnumValueAnnotationArgument;
import kotlin.reflect.jvm.internal.impl.load.java.structure.reflect.ReflectJavaLiteralAnnotationArgument;
import kotlin.reflect.jvm.internal.impl.name.Name;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public abstract class ReflectJavaAnnotationArgument
implements JavaAnnotationArgument {
    @Nullable
    private final Name name;
    public static final Factory Factory = new Factory(null);

    @Override
    @Nullable
    public Name getName() {
        return this.name;
    }

    public ReflectJavaAnnotationArgument(@Nullable Name name2) {
        this.name = name2;
    }

    public static final class Factory {
        @NotNull
        public final ReflectJavaAnnotationArgument create(@NotNull Object value, @Nullable Name name2) {
            ReflectJavaAnnotationArgument reflectJavaAnnotationArgument;
            Intrinsics.checkParameterIsNotNull(value, "value");
            if (ReflectClassUtilKt.isEnumClassOrSpecializedEnumEntryClass(value.getClass())) {
                Object object = value;
                if (object == null) {
                    throw new TypeCastException("null cannot be cast to non-null type kotlin.Enum<*>");
                }
                reflectJavaAnnotationArgument = new ReflectJavaEnumValueAnnotationArgument(name2, (Enum)object);
            } else {
                reflectJavaAnnotationArgument = value instanceof Annotation ? (ReflectJavaAnnotationArgument)new ReflectJavaAnnotationAsAnnotationArgument(name2, (Annotation)value) : (value instanceof Object[] ? (ReflectJavaAnnotationArgument)new ReflectJavaArrayAnnotationArgument(name2, (Object[])value) : (value instanceof Class ? (ReflectJavaAnnotationArgument)new ReflectJavaClassObjectAnnotationArgument(name2, (Class)value) : (ReflectJavaAnnotationArgument)new ReflectJavaLiteralAnnotationArgument(name2, value)));
            }
            return reflectJavaAnnotationArgument;
        }

        private Factory() {
        }

        public /* synthetic */ Factory(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }
}

