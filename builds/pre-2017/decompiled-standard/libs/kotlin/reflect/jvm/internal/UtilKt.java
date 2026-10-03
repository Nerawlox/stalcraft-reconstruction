/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal;

import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.FunctionReference;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference;
import kotlin.reflect.KCallable;
import kotlin.reflect.KVisibility;
import kotlin.reflect.full.IllegalCallableAccessException;
import kotlin.reflect.jvm.internal.KCallableImpl;
import kotlin.reflect.jvm.internal.KFunctionImpl;
import kotlin.reflect.jvm.internal.KPropertyImpl;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.Visibilities;
import kotlin.reflect.jvm.internal.impl.descriptors.Visibility;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotated;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.components.RuntimeSourceElementFactory;
import kotlin.reflect.jvm.internal.impl.load.java.reflect.ReflectJavaClassFinderKt;
import kotlin.reflect.jvm.internal.impl.load.java.structure.reflect.ReflectClassUtilKt;
import kotlin.reflect.jvm.internal.impl.load.java.structure.reflect.ReflectJavaAnnotation;
import kotlin.reflect.jvm.internal.impl.load.java.structure.reflect.ReflectJavaClass;
import kotlin.reflect.jvm.internal.impl.load.java.structure.reflect.ReflectJavaElement;
import kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass;
import kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinarySourceElement;
import kotlin.reflect.jvm.internal.impl.load.kotlin.reflect.ReflectAnnotationSource;
import kotlin.reflect.jvm.internal.impl.load.kotlin.reflect.ReflectKotlinClass;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.platform.JavaToKotlinClassMap;
import kotlin.reflect.jvm.internal.impl.resolve.DescriptorUtils;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={1, 1, 5}, bv={1, 0, 1}, k=2, d1={"\u0000Z\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u001b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a&\u0010\u0004\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tH\u0000\u001a\"\u0010\u000b\u001a\u0002H\f\"\u0004\b\u0000\u0010\f2\f\u0010\r\u001a\b\u0012\u0004\u0012\u0002H\f0\u000eH\u0080\b\u00a2\u0006\u0002\u0010\u000f\u001a\u0014\u0010\u0010\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0011*\u0004\u0018\u00010\u0012H\u0000\u001a\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014*\u0004\u0018\u00010\u0012H\u0000\u001a\u0014\u0010\u0015\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0016*\u0004\u0018\u00010\u0012H\u0000\u001a\u0012\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00190\u0018*\u00020\u001aH\u0000\u001a\u0012\u0010\u001b\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0005*\u00020\u001cH\u0000\u001a\u000e\u0010\u001d\u001a\u0004\u0018\u00010\u001e*\u00020\u001fH\u0000\"\u0014\u0010\u0000\u001a\u00020\u0001X\u0080\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0003\u00a8\u0006 "}, d2={"JVM_STATIC", "Lorg/jetbrains/kotlin/name/FqName;", "getJVM_STATIC", "()Lorg/jetbrains/kotlin/name/FqName;", "loadClass", "Ljava/lang/Class;", "classLoader", "Ljava/lang/ClassLoader;", "packageName", "", "className", "reflectionCall", "R", "block", "Lkotlin/Function0;", "(Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "asKCallableImpl", "Lkotlin/reflect/jvm/internal/KCallableImpl;", "", "asKFunctionImpl", "Lkotlin/reflect/jvm/internal/KFunctionImpl;", "asKPropertyImpl", "Lkotlin/reflect/jvm/internal/KPropertyImpl;", "computeAnnotations", "", "", "Lorg/jetbrains/kotlin/descriptors/annotations/Annotated;", "toJavaClass", "Lorg/jetbrains/kotlin/descriptors/ClassDescriptor;", "toKVisibility", "Lkotlin/reflect/KVisibility;", "Lorg/jetbrains/kotlin/descriptors/Visibility;", "kotlin-reflection"})
public final class UtilKt {
    @NotNull
    private static final FqName JVM_STATIC = new FqName("kotlin.jvm.JvmStatic");

    @NotNull
    public static final FqName getJVM_STATIC() {
        return JVM_STATIC;
    }

    @Nullable
    public static final Class<?> toJavaClass(@NotNull ClassDescriptor $receiver) {
        AnnotatedElement annotatedElement;
        SourceElement source;
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        SourceElement sourceElement = source = $receiver.getSource();
        if (sourceElement instanceof KotlinJvmBinarySourceElement) {
            KotlinJvmBinaryClass kotlinJvmBinaryClass = ((KotlinJvmBinarySourceElement)source).getBinaryClass();
            if (kotlinJvmBinaryClass == null) {
                throw new TypeCastException("null cannot be cast to non-null type org.jetbrains.kotlin.load.kotlin.reflect.ReflectKotlinClass");
            }
            annotatedElement = ((ReflectKotlinClass)kotlinJvmBinaryClass).getKlass();
        } else if (sourceElement instanceof RuntimeSourceElementFactory.RuntimeSourceElement) {
            ReflectJavaElement reflectJavaElement = ((RuntimeSourceElementFactory.RuntimeSourceElement)source).getJavaElement();
            if (reflectJavaElement == null) {
                throw new TypeCastException("null cannot be cast to non-null type org.jetbrains.kotlin.load.java.structure.reflect.ReflectJavaClass");
            }
            annotatedElement = ((ReflectJavaClass)reflectJavaElement).getElement();
        } else {
            ClassId classId = JavaToKotlinClassMap.INSTANCE.mapKotlinToJava(DescriptorUtils.getFqName($receiver));
            if (classId == null && (classId = DescriptorUtilsKt.getClassId($receiver)) == null) {
                Intrinsics.throwNpe();
            }
            ClassId classId2 = classId;
            String packageName = classId2.getPackageFqName().asString();
            String className = classId2.getRelativeClassName().asString();
            ClassLoader classLoader = ReflectClassUtilKt.getSafeClassLoader($receiver.getClass());
            String string = packageName;
            Intrinsics.checkExpressionValueIsNotNull(string, "packageName");
            String string2 = className;
            Intrinsics.checkExpressionValueIsNotNull(string2, "className");
            annotatedElement = UtilKt.loadClass(classLoader, string, string2);
        }
        return annotatedElement;
    }

    @Nullable
    public static final Class<?> loadClass(@NotNull ClassLoader classLoader, @NotNull String packageName, @NotNull String className) {
        Intrinsics.checkParameterIsNotNull(classLoader, "classLoader");
        Intrinsics.checkParameterIsNotNull(packageName, "packageName");
        Intrinsics.checkParameterIsNotNull(className, "className");
        if (Intrinsics.areEqual(packageName, "kotlin")) {
            switch (className) {
                case "Array": {
                    return Object[].class;
                }
                case "BooleanArray": {
                    return boolean[].class;
                }
                case "ByteArray": {
                    return byte[].class;
                }
                case "CharArray": {
                    return char[].class;
                }
                case "DoubleArray": {
                    return double[].class;
                }
                case "FloatArray": {
                    return float[].class;
                }
                case "IntArray": {
                    return int[].class;
                }
                case "LongArray": {
                    return long[].class;
                }
                case "ShortArray": {
                    return short[].class;
                }
            }
        }
        return ReflectJavaClassFinderKt.tryLoadClass(classLoader, packageName + "." + StringsKt.replace$default(className, '.', '$', false, 4, null));
    }

    @Nullable
    public static final KVisibility toKVisibility(@NotNull Visibility $receiver) {
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        Visibility visibility = $receiver;
        return Intrinsics.areEqual(visibility, Visibilities.PUBLIC) ? KVisibility.PUBLIC : (Intrinsics.areEqual(visibility, Visibilities.PROTECTED) ? KVisibility.PROTECTED : (Intrinsics.areEqual(visibility, Visibilities.INTERNAL) ? KVisibility.INTERNAL : (Intrinsics.areEqual(visibility, Visibilities.PRIVATE) || Intrinsics.areEqual(visibility, Visibilities.PRIVATE_TO_THIS) ? KVisibility.PRIVATE : null)));
    }

    /*
     * WARNING - void declaration
     */
    @NotNull
    public static final List<Annotation> computeAnnotations(@NotNull Annotated $receiver) {
        void var3_3;
        void $receiver$iv$iv;
        Iterable $receiver$iv;
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        Iterable iterable = $receiver$iv = (Iterable)$receiver.getAnnotations();
        Collection destination$iv$iv = new ArrayList();
        void $receiver$iv$iv$iv = $receiver$iv$iv;
        for (Object element$iv$iv$iv : $receiver$iv$iv$iv) {
            Annotation annotation;
            Annotation annotation2;
            Object element$iv$iv = element$iv$iv$iv;
            AnnotationDescriptor it = (AnnotationDescriptor)element$iv$iv;
            SourceElement source = it.getSource();
            SourceElement sourceElement = source;
            if (sourceElement instanceof ReflectAnnotationSource) {
                annotation2 = ((ReflectAnnotationSource)source).getAnnotation();
            } else if (sourceElement instanceof RuntimeSourceElementFactory.RuntimeSourceElement) {
                ReflectJavaElement reflectJavaElement = ((RuntimeSourceElementFactory.RuntimeSourceElement)source).getJavaElement();
                if (!(reflectJavaElement instanceof ReflectJavaAnnotation)) {
                    reflectJavaElement = null;
                }
                ReflectJavaAnnotation reflectJavaAnnotation = (ReflectJavaAnnotation)reflectJavaElement;
                annotation2 = reflectJavaAnnotation != null ? reflectJavaAnnotation.getAnnotation() : null;
            } else {
                annotation2 = null;
            }
            if (annotation2 == null) continue;
            Annotation it$iv$iv = annotation = annotation2;
            destination$iv$iv.add(it$iv$iv);
        }
        return (List)var3_3;
    }

    public static final <R> R reflectionCall(@NotNull Function0<? extends R> block) {
        R r;
        Intrinsics.checkParameterIsNotNull(block, "block");
        try {
            r = block.invoke();
        }
        catch (IllegalAccessException e) {
            throw (Throwable)new IllegalCallableAccessException(e);
        }
        return r;
    }

    @Nullable
    public static final KFunctionImpl asKFunctionImpl(@Nullable Object $receiver) {
        KFunctionImpl kFunctionImpl;
        Object object = $receiver;
        if (!(object instanceof KFunctionImpl)) {
            object = null;
        }
        if ((kFunctionImpl = (KFunctionImpl)object) == null) {
            Object object2 = $receiver;
            if (!(object2 instanceof FunctionReference)) {
                object2 = null;
            }
            FunctionReference functionReference = (FunctionReference)object2;
            KCallable kCallable = functionReference != null ? functionReference.compute() : null;
            if (!(kCallable instanceof KFunctionImpl)) {
                kCallable = null;
            }
            kFunctionImpl = (KFunctionImpl)kCallable;
        }
        return kFunctionImpl;
    }

    @Nullable
    public static final KPropertyImpl<?> asKPropertyImpl(@Nullable Object $receiver) {
        KPropertyImpl kPropertyImpl;
        Object object = $receiver;
        if (!(object instanceof KPropertyImpl)) {
            object = null;
        }
        if ((kPropertyImpl = (KPropertyImpl)object) == null) {
            Object object2 = $receiver;
            if (!(object2 instanceof PropertyReference)) {
                object2 = null;
            }
            PropertyReference propertyReference = (PropertyReference)object2;
            KCallable kCallable = propertyReference != null ? propertyReference.compute() : null;
            if (!(kCallable instanceof KPropertyImpl)) {
                kCallable = null;
            }
            kPropertyImpl = (KPropertyImpl)kCallable;
        }
        return kPropertyImpl;
    }

    @Nullable
    public static final KCallableImpl<?> asKCallableImpl(@Nullable Object $receiver) {
        KCallableImpl kCallableImpl;
        KCallableImpl kCallableImpl2;
        Object object = $receiver;
        if (!(object instanceof KCallableImpl)) {
            object = null;
        }
        if ((kCallableImpl2 = (KCallableImpl)object) == null) {
            kCallableImpl2 = kCallableImpl = (KCallableImpl)UtilKt.asKFunctionImpl($receiver);
        }
        if (kCallableImpl2 == null) {
            kCallableImpl = UtilKt.asKPropertyImpl($receiver);
        }
        return kCallableImpl;
    }
}

