/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.load.kotlin.reflect;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import kotlin.TypeCastException;
import kotlin.collections.ArraysKt;
import kotlin.collections.IndexedValue;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import kotlin.reflect.jvm.internal.impl.load.java.structure.reflect.ReflectClassUtilKt;
import kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass;
import kotlin.reflect.jvm.internal.impl.load.kotlin.reflect.ReflectAnnotationSource;
import kotlin.reflect.jvm.internal.impl.load.kotlin.reflect.ReflectKotlinClassKt;
import kotlin.reflect.jvm.internal.impl.load.kotlin.reflect.SignatureSerializer;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.Name;
import org.jetbrains.annotations.NotNull;

final class ReflectClassStructure {
    public static final ReflectClassStructure INSTANCE;

    public final void loadClassAnnotations(@NotNull Class<?> klass, @NotNull KotlinJvmBinaryClass.AnnotationVisitor visitor2) {
        Intrinsics.checkParameterIsNotNull(klass, "klass");
        Intrinsics.checkParameterIsNotNull(visitor2, "visitor");
        Annotation[] annotationArray = klass.getDeclaredAnnotations();
        for (int i = 0; i < annotationArray.length; ++i) {
            Annotation annotation;
            Annotation annotation2 = annotation = annotationArray[i];
            Intrinsics.checkExpressionValueIsNotNull(annotation2, "annotation");
            this.processAnnotation(visitor2, annotation2);
        }
        visitor2.visitEnd();
    }

    public final void visitMembers(@NotNull Class<?> klass, @NotNull KotlinJvmBinaryClass.MemberVisitor memberVisitor) {
        Intrinsics.checkParameterIsNotNull(klass, "klass");
        Intrinsics.checkParameterIsNotNull(memberVisitor, "memberVisitor");
        this.loadMethodAnnotations(klass, memberVisitor);
        this.loadConstructorAnnotations(klass, memberVisitor);
        this.loadFieldAnnotations(klass, memberVisitor);
    }

    private final void loadMethodAnnotations(Class<?> klass, KotlinJvmBinaryClass.MemberVisitor memberVisitor) {
        Method[] methodArray = klass.getDeclaredMethods();
        for (int i = 0; i < methodArray.length; ++i) {
            KotlinJvmBinaryClass.MethodAnnotationVisitor visitor2;
            Method method = methodArray[i];
            Name name2 = Name.identifier(method.getName());
            Intrinsics.checkExpressionValueIsNotNull(name2, "Name.identifier(method.name)");
            Method method2 = method;
            Intrinsics.checkExpressionValueIsNotNull(method2, "method");
            if (memberVisitor.visitMethod(name2, SignatureSerializer.INSTANCE.methodDesc(method2)) == null) {
                continue;
            }
            Annotation[] annotationArray = method.getDeclaredAnnotations();
            for (int j = 0; j < annotationArray.length; ++j) {
                Annotation annotation = annotationArray[j];
                KotlinJvmBinaryClass.AnnotationVisitor annotationVisitor = visitor2;
                Annotation annotation2 = annotation;
                Intrinsics.checkExpressionValueIsNotNull(annotation2, "annotation");
                this.processAnnotation(annotationVisitor, annotation2);
            }
            for (IndexedValue<Object> indexedValue : ArraysKt.withIndex((Object[])method.getParameterAnnotations())) {
                int parameterIndex = indexedValue.component1();
                Annotation[] annotations2 = (Annotation[])indexedValue.component2();
                for (int j = 0; j < annotations2.length; ++j) {
                    KotlinJvmBinaryClass.AnnotationArgumentVisitor annotationArgumentVisitor;
                    Annotation annotation = annotations2[j];
                    Class<KClass<Annotation>> annotationType = JvmClassMappingKt.getJavaClass(JvmClassMappingKt.getAnnotationClass(annotation));
                    ClassId classId = ReflectClassUtilKt.getClassId(annotationType);
                    Annotation annotation3 = annotation;
                    Intrinsics.checkExpressionValueIsNotNull(annotation3, "annotation");
                    if (visitor2.visitParameterAnnotation(parameterIndex, classId, new ReflectAnnotationSource(annotation3)) == null) continue;
                    KotlinJvmBinaryClass.AnnotationArgumentVisitor it = annotationArgumentVisitor;
                    Annotation annotation4 = annotation;
                    Intrinsics.checkExpressionValueIsNotNull(annotation4, "annotation");
                    INSTANCE.processAnnotationArguments(it, annotation4, annotationType);
                }
            }
            visitor2.visitEnd();
        }
    }

    private final void loadConstructorAnnotations(Class<?> klass, KotlinJvmBinaryClass.MemberVisitor memberVisitor) {
        Constructor<?>[] constructorArray = klass.getDeclaredConstructors();
        for (int i = 0; i < constructorArray.length; ++i) {
            KotlinJvmBinaryClass.MethodAnnotationVisitor visitor2;
            Constructor<?> constructor = constructorArray[i];
            Name name2 = Name.special("<init>");
            Intrinsics.checkExpressionValueIsNotNull(name2, "Name.special(\"<init>\")");
            Constructor<?> constructor2 = constructor;
            Intrinsics.checkExpressionValueIsNotNull(constructor2, "constructor");
            if (memberVisitor.visitMethod(name2, SignatureSerializer.INSTANCE.constructorDesc(constructor2)) == null) {
                continue;
            }
            Annotation[] annotationArray = constructor.getDeclaredAnnotations();
            for (int j = 0; j < annotationArray.length; ++j) {
                Annotation annotation = annotationArray[j];
                KotlinJvmBinaryClass.AnnotationVisitor annotationVisitor = visitor2;
                Annotation annotation2 = annotation;
                Intrinsics.checkExpressionValueIsNotNull(annotation2, "annotation");
                this.processAnnotation(annotationVisitor, annotation2);
            }
            Annotation[][] parameterAnnotations = constructor.getParameterAnnotations();
            Object[] objectArray = (Object[])parameterAnnotations;
            Object[] objectArray2 = objectArray;
            if (!(objectArray2.length == 0)) {
                int shift = ((Object[])constructor.getParameterTypes()).length - ((Object[])parameterAnnotations).length;
                for (IndexedValue<Object> indexedValue : ArraysKt.withIndex((Object[])parameterAnnotations)) {
                    int parameterIndex = indexedValue.component1();
                    Annotation[] annotations2 = (Annotation[])indexedValue.component2();
                    for (int j = 0; j < annotations2.length; ++j) {
                        KotlinJvmBinaryClass.AnnotationArgumentVisitor annotationArgumentVisitor;
                        Annotation annotation = annotations2[j];
                        Class<KClass<Annotation>> annotationType = JvmClassMappingKt.getJavaClass(JvmClassMappingKt.getAnnotationClass(annotation));
                        ClassId classId = ReflectClassUtilKt.getClassId(annotationType);
                        Annotation annotation3 = annotation;
                        Intrinsics.checkExpressionValueIsNotNull(annotation3, "annotation");
                        if (visitor2.visitParameterAnnotation(parameterIndex + shift, classId, new ReflectAnnotationSource(annotation3)) == null) continue;
                        KotlinJvmBinaryClass.AnnotationArgumentVisitor it = annotationArgumentVisitor;
                        Annotation annotation4 = annotation;
                        Intrinsics.checkExpressionValueIsNotNull(annotation4, "annotation");
                        INSTANCE.processAnnotationArguments(it, annotation4, annotationType);
                    }
                }
            }
            visitor2.visitEnd();
        }
    }

    private final void loadFieldAnnotations(Class<?> klass, KotlinJvmBinaryClass.MemberVisitor memberVisitor) {
        Field[] fieldArray = klass.getDeclaredFields();
        for (int i = 0; i < fieldArray.length; ++i) {
            KotlinJvmBinaryClass.AnnotationVisitor visitor2;
            Field field = fieldArray[i];
            Name name2 = Name.identifier(field.getName());
            Intrinsics.checkExpressionValueIsNotNull(name2, "Name.identifier(field.name)");
            Field field2 = field;
            Intrinsics.checkExpressionValueIsNotNull(field2, "field");
            if (memberVisitor.visitField(name2, SignatureSerializer.INSTANCE.fieldDesc(field2), null) == null) {
                continue;
            }
            Annotation[] annotationArray = field.getDeclaredAnnotations();
            for (int j = 0; j < annotationArray.length; ++j) {
                Annotation annotation;
                Annotation annotation2 = annotation = annotationArray[j];
                Intrinsics.checkExpressionValueIsNotNull(annotation2, "annotation");
                this.processAnnotation(visitor2, annotation2);
            }
            visitor2.visitEnd();
        }
    }

    private final void processAnnotation(KotlinJvmBinaryClass.AnnotationVisitor visitor2, Annotation annotation) {
        block0: {
            KotlinJvmBinaryClass.AnnotationArgumentVisitor annotationArgumentVisitor;
            Class<KClass<Annotation>> annotationType = JvmClassMappingKt.getJavaClass(JvmClassMappingKt.getAnnotationClass(annotation));
            KotlinJvmBinaryClass.AnnotationArgumentVisitor annotationArgumentVisitor2 = visitor2.visitAnnotation(ReflectClassUtilKt.getClassId(annotationType), new ReflectAnnotationSource(annotation));
            if (annotationArgumentVisitor2 == null) break block0;
            KotlinJvmBinaryClass.AnnotationArgumentVisitor it = annotationArgumentVisitor = annotationArgumentVisitor2;
            INSTANCE.processAnnotationArguments(it, annotation, annotationType);
        }
    }

    private final void processAnnotationArguments(KotlinJvmBinaryClass.AnnotationArgumentVisitor visitor2, Annotation annotation, Class<?> annotationType) {
        Method[] methodArray = annotationType.getDeclaredMethods();
        for (int i = 0; i < methodArray.length; ++i) {
            Method method = methodArray[i];
            Name name2 = Name.identifier(method.getName());
            Intrinsics.checkExpressionValueIsNotNull(name2, "Name.identifier(method.name)");
            Object object = method.invoke(annotation, new Object[0]);
            if (object == null) {
                Intrinsics.throwNpe();
            }
            this.processAnnotationArgumentValue(visitor2, name2, object);
        }
        visitor2.visitEnd();
    }

    private final void processAnnotationArgumentValue(KotlinJvmBinaryClass.AnnotationArgumentVisitor visitor2, Name name2, Object value) {
        Class<?> clazz = value.getClass();
        if (ReflectKotlinClassKt.access$getTYPES_ELIGIBLE_FOR_SIMPLE_VISIT$p().contains(clazz)) {
            visitor2.visit(name2, value);
        } else if (ReflectClassUtilKt.isEnumClassOrSpecializedEnumEntryClass(clazz)) {
            ClassId classId = ReflectClassUtilKt.getClassId(clazz.isEnum() ? clazz : clazz.getEnclosingClass());
            Object object = value;
            if (object == null) {
                throw new TypeCastException("null cannot be cast to non-null type kotlin.Enum<*>");
            }
            Name name3 = Name.identifier(((Enum)object).name());
            Intrinsics.checkExpressionValueIsNotNull(name3, "Name.identifier((value as Enum<*>).name)");
            visitor2.visitEnum(name2, classId, name3);
        } else if (Annotation.class.isAssignableFrom(clazz)) {
            Class annotationClass = (Class)ArraysKt.single((Object[])clazz.getInterfaces());
            KotlinJvmBinaryClass.AnnotationArgumentVisitor annotationArgumentVisitor = visitor2.visitAnnotation(name2, ReflectClassUtilKt.getClassId(annotationClass));
            if (annotationArgumentVisitor == null) {
                return;
            }
            KotlinJvmBinaryClass.AnnotationArgumentVisitor v = annotationArgumentVisitor;
            Object object = value;
            if (object == null) {
                throw new TypeCastException("null cannot be cast to non-null type kotlin.Annotation");
            }
            Annotation annotation = (Annotation)object;
            Class clazz2 = annotationClass;
            Intrinsics.checkExpressionValueIsNotNull(clazz2, "annotationClass");
            this.processAnnotationArguments(v, annotation, clazz2);
        } else if (clazz.isArray()) {
            KotlinJvmBinaryClass.AnnotationArrayArgumentVisitor annotationArrayArgumentVisitor = visitor2.visitArray(name2);
            if (annotationArrayArgumentVisitor == null) {
                return;
            }
            KotlinJvmBinaryClass.AnnotationArrayArgumentVisitor v = annotationArrayArgumentVisitor;
            Class<?> componentType = clazz.getComponentType();
            if (componentType.isEnum()) {
                ClassId enumClassId = ReflectClassUtilKt.getClassId(componentType);
                Object object = value;
                if (object == null) {
                    throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<*>");
                }
                Object[] objectArray = (Object[])object;
                for (int i = 0; i < objectArray.length; ++i) {
                    Object element;
                    Object object2 = element = objectArray[i];
                    if (object2 == null) {
                        throw new TypeCastException("null cannot be cast to non-null type kotlin.Enum<*>");
                    }
                    Name name4 = Name.identifier(((Enum)object2).name());
                    Intrinsics.checkExpressionValueIsNotNull(name4, "Name.identifier((element as Enum<*>).name)");
                    v.visitEnum(enumClassId, name4);
                }
            } else {
                Object object = value;
                if (object == null) {
                    throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<*>");
                }
                Object[] objectArray = (Object[])object;
                for (int i = 0; i < objectArray.length; ++i) {
                    Object element = objectArray[i];
                    v.visit(element);
                }
            }
            v.visitEnd();
        } else {
            throw (Throwable)new UnsupportedOperationException("Unsupported annotation argument value (" + clazz + "): " + value);
        }
    }

    private ReflectClassStructure() {
        INSTANCE = this;
    }

    static {
        new ReflectClassStructure();
    }
}

