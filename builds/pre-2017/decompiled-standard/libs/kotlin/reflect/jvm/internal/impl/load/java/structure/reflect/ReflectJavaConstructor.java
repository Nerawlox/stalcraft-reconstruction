/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.load.java.structure.reflect;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaConstructor;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaValueParameter;
import kotlin.reflect.jvm.internal.impl.load.java.structure.reflect.ReflectJavaMember;
import kotlin.reflect.jvm.internal.impl.load.java.structure.reflect.ReflectJavaTypeParameter;
import org.jetbrains.annotations.NotNull;

public final class ReflectJavaConstructor
extends ReflectJavaMember
implements JavaConstructor {
    @NotNull
    private final Constructor<?> member;

    @Override
    @NotNull
    public List<JavaValueParameter> getValueParameters() {
        Annotation[][] annotationArray;
        Type[] typeArray;
        Type[] types = ((Constructor)this.getMember()).getGenericParameterTypes();
        Object[] objectArray = types;
        if (objectArray.length == 0) {
            return CollectionsKt.emptyList();
        }
        Class klass = ((Constructor)this.getMember()).getDeclaringClass();
        if (klass.getDeclaringClass() != null && !Modifier.isStatic(klass.getModifiers())) {
            Object[] objectArray2 = types;
            int n = 1;
            int n2 = ((Object[])types).length;
            Object[] objectArray3 = Arrays.copyOfRange(objectArray2, n, n2);
            Intrinsics.checkExpressionValueIsNotNull(objectArray3, "java.util.Arrays.copyOfR\u2026this, fromIndex, toIndex)");
            typeArray = (Type[])objectArray3;
        } else {
            typeArray = types;
        }
        Type[] realTypes = typeArray;
        Annotation[][] annotations2 = ((Constructor)this.getMember()).getParameterAnnotations();
        if (((Object[])annotations2).length < ((Object[])realTypes).length) {
            throw (Throwable)new IllegalStateException("Illegal generic signature: " + this.getMember());
        }
        if (((Object[])annotations2).length > ((Object[])realTypes).length) {
            Object[] objectArray4 = (Object[])annotations2;
            int n = ((Object[])annotations2).length - ((Object[])realTypes).length;
            int n3 = ((Object[])annotations2).length;
            Object[] objectArray5 = Arrays.copyOfRange(objectArray4, n, n3);
            Intrinsics.checkExpressionValueIsNotNull(objectArray5, "java.util.Arrays.copyOfR\u2026this, fromIndex, toIndex)");
            annotationArray = (Annotation[][])objectArray5;
        } else {
            annotationArray = annotations2;
        }
        Annotation[][] realAnnotations = annotationArray;
        Intrinsics.checkExpressionValueIsNotNull(realTypes, "realTypes");
        Intrinsics.checkExpressionValueIsNotNull(realAnnotations, "realAnnotations");
        return this.getValueParameters(realTypes, realAnnotations, ((Constructor)this.getMember()).isVarArgs());
    }

    /*
     * WARNING - void declaration
     */
    @NotNull
    public List<ReflectJavaTypeParameter> getTypeParameters() {
        void var3_3;
        void $receiver$iv$iv;
        Object[] $receiver$iv;
        Object[] objectArray = $receiver$iv = (Object[])((Constructor)this.getMember()).getTypeParameters();
        Collection destination$iv$iv = new ArrayList($receiver$iv.length);
        for (int i = 0; i < ((void)$receiver$iv$iv).length; ++i) {
            void it;
            void item$iv$iv = $receiver$iv$iv[i];
            TypeVariable typeVariable = (TypeVariable)item$iv$iv;
            Collection collection = destination$iv$iv;
            void v0 = it;
            Intrinsics.checkExpressionValueIsNotNull(v0, "it");
            ReflectJavaTypeParameter reflectJavaTypeParameter = new ReflectJavaTypeParameter((TypeVariable<?>)v0);
            collection.add(reflectJavaTypeParameter);
        }
        return (List)var3_3;
    }

    @Override
    @NotNull
    public Constructor<?> getMember() {
        return this.member;
    }

    public ReflectJavaConstructor(@NotNull Constructor<?> member) {
        Intrinsics.checkParameterIsNotNull(member, "member");
        this.member = member;
    }
}

