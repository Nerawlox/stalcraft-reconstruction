/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.load.java.components;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.components.JavaAnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.components.JavaDeprecatedAnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.components.JavaRetentionAnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.components.JavaTargetAnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaAnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotation;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotationOwner;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.Name;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class JavaAnnotationMapper {
    private static final FqName JAVA_TARGET_FQ_NAME;
    private static final FqName JAVA_RETENTION_FQ_NAME;
    private static final FqName JAVA_DEPRECATED_FQ_NAME;
    private static final FqName JAVA_DOCUMENTED_FQ_NAME;
    private static final FqName JAVA_REPEATABLE_FQ_NAME;
    @NotNull
    private static final Name DEPRECATED_ANNOTATION_MESSAGE;
    @NotNull
    private static final Name TARGET_ANNOTATION_ALLOWED_TARGETS;
    private static final Map<FqName, FqName> kotlinToJavaNameMap;
    @NotNull
    private static final Map<FqName, FqName> javaToKotlinNameMap;
    public static final JavaAnnotationMapper INSTANCE;

    @NotNull
    public final Name getDEPRECATED_ANNOTATION_MESSAGE$kotlin_core() {
        return DEPRECATED_ANNOTATION_MESSAGE;
    }

    @NotNull
    public final Name getTARGET_ANNOTATION_ALLOWED_TARGETS$kotlin_core() {
        return TARGET_ANNOTATION_ALLOWED_TARGETS;
    }

    @Nullable
    public final AnnotationDescriptor mapOrResolveJavaAnnotation(@NotNull JavaAnnotation annotation, @NotNull LazyJavaResolverContext c) {
        AnnotationDescriptor annotationDescriptor;
        Intrinsics.checkParameterIsNotNull(annotation, "annotation");
        Intrinsics.checkParameterIsNotNull(c, "c");
        ClassId classId = annotation.getClassId();
        if (Intrinsics.areEqual(classId, ClassId.topLevel(JAVA_TARGET_FQ_NAME))) {
            annotationDescriptor = new JavaTargetAnnotationDescriptor(annotation, c);
        } else if (Intrinsics.areEqual(classId, ClassId.topLevel(JAVA_RETENTION_FQ_NAME))) {
            annotationDescriptor = new JavaRetentionAnnotationDescriptor(annotation, c);
        } else if (Intrinsics.areEqual(classId, ClassId.topLevel(JAVA_REPEATABLE_FQ_NAME))) {
            ClassDescriptor classDescriptor = c.getModule().getBuiltIns().getRepeatableAnnotation();
            Intrinsics.checkExpressionValueIsNotNull(classDescriptor, "c.module.builtIns.repeatableAnnotation");
            annotationDescriptor = new JavaAnnotationDescriptor(c, annotation, classDescriptor);
        } else if (Intrinsics.areEqual(classId, ClassId.topLevel(JAVA_DOCUMENTED_FQ_NAME))) {
            ClassDescriptor classDescriptor = c.getModule().getBuiltIns().getMustBeDocumentedAnnotation();
            Intrinsics.checkExpressionValueIsNotNull(classDescriptor, "c.module.builtIns.mustBeDocumentedAnnotation");
            annotationDescriptor = new JavaAnnotationDescriptor(c, annotation, classDescriptor);
        } else {
            annotationDescriptor = Intrinsics.areEqual(classId, ClassId.topLevel(JAVA_DEPRECATED_FQ_NAME)) ? null : (AnnotationDescriptor)new LazyJavaAnnotationDescriptor(c, annotation);
        }
        return annotationDescriptor;
    }

    @Nullable
    public final AnnotationDescriptor findMappedJavaAnnotation(@NotNull FqName kotlinName, @NotNull JavaAnnotationOwner annotationOwner, @NotNull LazyJavaResolverContext c) {
        AnnotationDescriptor annotationDescriptor;
        JavaAnnotation javaAnnotation;
        Intrinsics.checkParameterIsNotNull(kotlinName, "kotlinName");
        Intrinsics.checkParameterIsNotNull(annotationOwner, "annotationOwner");
        Intrinsics.checkParameterIsNotNull(c, "c");
        if (Intrinsics.areEqual(kotlinName, KotlinBuiltIns.FQ_NAMES.deprecated) && ((javaAnnotation = annotationOwner.findAnnotation(JAVA_DEPRECATED_FQ_NAME)) != null || annotationOwner.isDeprecatedInJavaDoc())) {
            return new JavaDeprecatedAnnotationDescriptor(javaAnnotation, c);
        }
        FqName fqName2 = kotlinToJavaNameMap.get(kotlinName);
        if (fqName2 != null) {
            AnnotationDescriptor annotationDescriptor2;
            FqName fqName3;
            FqName it = fqName3 = fqName2;
            JavaAnnotation javaAnnotation2 = annotationOwner.findAnnotation(it);
            if (javaAnnotation2 != null) {
                JavaAnnotation javaAnnotation3;
                JavaAnnotation it2 = javaAnnotation3 = javaAnnotation2;
                annotationDescriptor2 = INSTANCE.mapOrResolveJavaAnnotation(it2, c);
            } else {
                annotationDescriptor2 = null;
            }
            annotationDescriptor = annotationDescriptor2;
        } else {
            annotationDescriptor = null;
        }
        return annotationDescriptor;
    }

    @NotNull
    public final Map<FqName, FqName> getJavaToKotlinNameMap() {
        return javaToKotlinNameMap;
    }

    private JavaAnnotationMapper() {
        INSTANCE = this;
        JAVA_TARGET_FQ_NAME = new FqName(Target.class.getCanonicalName());
        JAVA_RETENTION_FQ_NAME = new FqName(Retention.class.getCanonicalName());
        JAVA_DEPRECATED_FQ_NAME = new FqName(Deprecated.class.getCanonicalName());
        JAVA_DOCUMENTED_FQ_NAME = new FqName(Documented.class.getCanonicalName());
        JAVA_REPEATABLE_FQ_NAME = new FqName("java.lang.annotation.Repeatable");
        DEPRECATED_ANNOTATION_MESSAGE = Name.identifier("message");
        TARGET_ANNOTATION_ALLOWED_TARGETS = Name.identifier("allowedTargets");
        kotlinToJavaNameMap = MapsKt.mapOf(TuplesKt.to(KotlinBuiltIns.FQ_NAMES.target, JAVA_TARGET_FQ_NAME), TuplesKt.to(KotlinBuiltIns.FQ_NAMES.retention, JAVA_RETENTION_FQ_NAME), TuplesKt.to(KotlinBuiltIns.FQ_NAMES.repeatable, JAVA_REPEATABLE_FQ_NAME), TuplesKt.to(KotlinBuiltIns.FQ_NAMES.mustBeDocumented, JAVA_DOCUMENTED_FQ_NAME));
        javaToKotlinNameMap = MapsKt.mapOf(TuplesKt.to(JAVA_TARGET_FQ_NAME, KotlinBuiltIns.FQ_NAMES.target), TuplesKt.to(JAVA_RETENTION_FQ_NAME, KotlinBuiltIns.FQ_NAMES.retention), TuplesKt.to(JAVA_DEPRECATED_FQ_NAME, KotlinBuiltIns.FQ_NAMES.deprecated), TuplesKt.to(JAVA_REPEATABLE_FQ_NAME, KotlinBuiltIns.FQ_NAMES.repeatable), TuplesKt.to(JAVA_DOCUMENTED_FQ_NAME, KotlinBuiltIns.FQ_NAMES.mustBeDocumented));
    }

    static {
        new JavaAnnotationMapper();
    }
}

