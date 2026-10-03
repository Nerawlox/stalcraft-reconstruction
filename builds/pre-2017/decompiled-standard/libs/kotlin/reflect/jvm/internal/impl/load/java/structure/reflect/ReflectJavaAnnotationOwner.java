/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.load.java.structure.reflect;

import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotationOwner;
import kotlin.reflect.jvm.internal.impl.load.java.structure.reflect.ReflectJavaAnnotation;
import kotlin.reflect.jvm.internal.impl.load.java.structure.reflect.ReflectJavaAnnotationOwnerKt;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public interface ReflectJavaAnnotationOwner
extends JavaAnnotationOwner {
    @Nullable
    public AnnotatedElement getElement();

    @NotNull
    public List<ReflectJavaAnnotation> getAnnotations();

    @Override
    @Nullable
    public ReflectJavaAnnotation findAnnotation(@NotNull FqName var1);

    @Override
    public boolean isDeprecatedInJavaDoc();

    public static final class DefaultImpls {
        @NotNull
        public static List<ReflectJavaAnnotation> getAnnotations(ReflectJavaAnnotationOwner $this) {
            Object object = $this.getElement();
            if (object == null || (object = object.getDeclaredAnnotations()) == null || (object = ReflectJavaAnnotationOwnerKt.getAnnotations(object)) == null) {
                object = CollectionsKt.emptyList();
            }
            return object;
        }

        @Nullable
        public static ReflectJavaAnnotation findAnnotation(@NotNull ReflectJavaAnnotationOwner $this, FqName fqName2) {
            Intrinsics.checkParameterIsNotNull(fqName2, "fqName");
            Annotation[] annotationArray = $this.getElement();
            return annotationArray != null && (annotationArray = annotationArray.getDeclaredAnnotations()) != null ? ReflectJavaAnnotationOwnerKt.findAnnotation(annotationArray, fqName2) : null;
        }

        public static boolean isDeprecatedInJavaDoc(ReflectJavaAnnotationOwner $this) {
            return false;
        }
    }
}

