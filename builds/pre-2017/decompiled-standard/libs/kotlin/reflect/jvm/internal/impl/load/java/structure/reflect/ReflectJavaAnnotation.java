/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.load.java.structure.reflect;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotation;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotationArgument;
import kotlin.reflect.jvm.internal.impl.load.java.structure.reflect.ReflectClassUtilKt;
import kotlin.reflect.jvm.internal.impl.load.java.structure.reflect.ReflectJavaAnnotationArgument;
import kotlin.reflect.jvm.internal.impl.load.java.structure.reflect.ReflectJavaClass;
import kotlin.reflect.jvm.internal.impl.load.java.structure.reflect.ReflectJavaElement;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.Name;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class ReflectJavaAnnotation
extends ReflectJavaElement
implements JavaAnnotation {
    @NotNull
    private final Annotation annotation;

    /*
     * WARNING - void declaration
     */
    @Override
    @NotNull
    public Collection<JavaAnnotationArgument> getArguments() {
        void var3_3;
        void $receiver$iv$iv;
        Object[] $receiver$iv;
        Object[] objectArray = $receiver$iv = (Object[])JvmClassMappingKt.getJavaClass(JvmClassMappingKt.getAnnotationClass(this.annotation)).getDeclaredMethods();
        Collection destination$iv$iv = new ArrayList($receiver$iv.length);
        for (int i = 0; i < ((void)$receiver$iv$iv).length; ++i) {
            void method;
            void item$iv$iv = $receiver$iv$iv[i];
            Method method2 = (Method)item$iv$iv;
            Collection collection = destination$iv$iv;
            Object object = method.invoke(this.annotation, new Object[0]);
            Intrinsics.checkExpressionValueIsNotNull(object, "method.invoke(annotation)");
            ReflectJavaAnnotationArgument reflectJavaAnnotationArgument = ReflectJavaAnnotationArgument.Factory.create(object, Name.identifier(method.getName()));
            collection.add(reflectJavaAnnotationArgument);
        }
        return (List)var3_3;
    }

    @Override
    @NotNull
    public ClassId getClassId() {
        return ReflectClassUtilKt.getClassId(JvmClassMappingKt.getJavaClass(JvmClassMappingKt.getAnnotationClass(this.annotation)));
    }

    @Override
    @NotNull
    public ReflectJavaClass resolve() {
        return new ReflectJavaClass(JvmClassMappingKt.getJavaClass(JvmClassMappingKt.getAnnotationClass(this.annotation)));
    }

    public boolean equals(@Nullable Object other) {
        return other instanceof ReflectJavaAnnotation && Intrinsics.areEqual(this.annotation, ((ReflectJavaAnnotation)other).annotation);
    }

    public int hashCode() {
        return ((Object)this.annotation).hashCode();
    }

    @NotNull
    public String toString() {
        return this.getClass().getName() + ": " + this.annotation;
    }

    @NotNull
    public final Annotation getAnnotation() {
        return this.annotation;
    }

    public ReflectJavaAnnotation(@NotNull Annotation annotation) {
        Intrinsics.checkParameterIsNotNull(annotation, "annotation");
        this.annotation = annotation;
    }
}

