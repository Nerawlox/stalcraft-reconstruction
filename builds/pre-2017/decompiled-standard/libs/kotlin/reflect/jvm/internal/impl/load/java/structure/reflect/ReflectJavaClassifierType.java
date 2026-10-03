/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.load.java.structure.reflect;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.TypeCastException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotation;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClassifier;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClassifierType;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaType;
import kotlin.reflect.jvm.internal.impl.load.java.structure.reflect.ReflectClassUtilKt;
import kotlin.reflect.jvm.internal.impl.load.java.structure.reflect.ReflectJavaClass;
import kotlin.reflect.jvm.internal.impl.load.java.structure.reflect.ReflectJavaType;
import kotlin.reflect.jvm.internal.impl.load.java.structure.reflect.ReflectJavaTypeParameter;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class ReflectJavaClassifierType
extends ReflectJavaType
implements JavaClassifierType {
    @NotNull
    private final JavaClassifier classifier;
    @NotNull
    private final Type reflectType;

    @Override
    @NotNull
    public JavaClassifier getClassifier() {
        return this.classifier;
    }

    @Override
    @NotNull
    public String getCanonicalText() {
        throw (Throwable)new UnsupportedOperationException("Type not found: " + this.getReflectType());
    }

    @Override
    @NotNull
    public String getPresentableText() {
        return this.getReflectType().toString();
    }

    @Override
    public boolean isRaw() {
        Object[] objectArray;
        Object[] objectArray2;
        Type type2 = this.getReflectType();
        Type $receiver = type2;
        return $receiver instanceof Class && !((objectArray2 = (objectArray = (Object[])((Class)$receiver).getTypeParameters())).length == 0);
    }

    /*
     * WARNING - void declaration
     */
    @Override
    @NotNull
    public List<JavaType> getTypeArguments() {
        void $receiver$iv$iv;
        void $receiver$iv;
        Iterable iterable = ReflectClassUtilKt.getParameterizedTypeArguments(this.getReflectType());
        ReflectJavaType.Factory factory = ReflectJavaType.Factory;
        void var3_3 = $receiver$iv;
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($receiver$iv, 10));
        for (Object item$iv$iv : $receiver$iv$iv) {
            void p1;
            Type type2 = (Type)item$iv$iv;
            Collection collection = destination$iv$iv;
            ReflectJavaType reflectJavaType = factory.create((Type)p1);
            collection.add(reflectJavaType);
        }
        return (List)destination$iv$iv;
    }

    @Override
    @NotNull
    public Collection<JavaAnnotation> getAnnotations() {
        return CollectionsKt.emptyList();
    }

    @Override
    @Nullable
    public JavaAnnotation findAnnotation(@NotNull FqName fqName2) {
        Intrinsics.checkParameterIsNotNull(fqName2, "fqName");
        return null;
    }

    @Override
    public boolean isDeprecatedInJavaDoc() {
        return false;
    }

    @Override
    @NotNull
    public Type getReflectType() {
        return this.reflectType;
    }

    public ReflectJavaClassifierType(@NotNull Type reflectType) {
        JavaClassifier classifier2;
        JavaClassifier javaClassifier;
        JavaClassifier javaClassifier2;
        Type type2;
        Intrinsics.checkParameterIsNotNull(reflectType, "reflectType");
        this.reflectType = reflectType;
        ReflectJavaClassifierType reflectJavaClassifierType = this;
        ReflectJavaClassifierType reflectJavaClassifierType2 = this;
        ReflectJavaClassifierType $receiver = reflectJavaClassifierType;
        Type type3 = type2 = $receiver.getReflectType();
        if (type3 instanceof Class) {
            javaClassifier2 = new ReflectJavaClass((Class)type2);
        } else if (type3 instanceof TypeVariable) {
            javaClassifier2 = new ReflectJavaTypeParameter((TypeVariable)type2);
        } else if (type3 instanceof ParameterizedType) {
            Type type4 = ((ParameterizedType)type2).getRawType();
            if (type4 == null) {
                throw new TypeCastException("null cannot be cast to non-null type java.lang.Class<*>");
            }
            javaClassifier2 = new ReflectJavaClass((Class)type4);
        } else {
            throw (Throwable)new IllegalStateException("Not a classifier type (" + type2.getClass() + "): " + type2);
        }
        reflectJavaClassifierType2.classifier = javaClassifier = (classifier2 = javaClassifier2);
    }
}

