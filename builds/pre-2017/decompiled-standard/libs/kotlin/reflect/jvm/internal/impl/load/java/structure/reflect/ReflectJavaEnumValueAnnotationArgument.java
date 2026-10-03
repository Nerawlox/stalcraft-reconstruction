/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.load.java.structure.reflect;

import java.lang.reflect.Field;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaEnumValueAnnotationArgument;
import kotlin.reflect.jvm.internal.impl.load.java.structure.reflect.ReflectJavaAnnotationArgument;
import kotlin.reflect.jvm.internal.impl.load.java.structure.reflect.ReflectJavaField;
import kotlin.reflect.jvm.internal.impl.name.Name;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class ReflectJavaEnumValueAnnotationArgument
extends ReflectJavaAnnotationArgument
implements JavaEnumValueAnnotationArgument {
    private final Enum<?> value;

    @Override
    @NotNull
    public ReflectJavaField resolve() {
        Class<?> clazz = this.value.getClass();
        Class<?> enumClass = clazz.isEnum() ? clazz : clazz.getEnclosingClass();
        Field field = enumClass.getDeclaredField(this.value.name());
        Intrinsics.checkExpressionValueIsNotNull(field, "enumClass.getDeclaredField(value.name)");
        return new ReflectJavaField(field);
    }

    public ReflectJavaEnumValueAnnotationArgument(@Nullable Name name2, @NotNull Enum<?> value) {
        Intrinsics.checkParameterIsNotNull(value, "value");
        super(name2);
        this.value = value;
    }
}

