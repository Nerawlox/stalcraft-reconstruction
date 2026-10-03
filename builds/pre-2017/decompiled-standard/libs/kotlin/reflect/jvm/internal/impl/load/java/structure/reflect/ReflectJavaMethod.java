/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.load.java.structure.reflect;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaMethod;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaValueParameter;
import kotlin.reflect.jvm.internal.impl.load.java.structure.reflect.ReflectJavaMember;
import kotlin.reflect.jvm.internal.impl.load.java.structure.reflect.ReflectJavaType;
import kotlin.reflect.jvm.internal.impl.load.java.structure.reflect.ReflectJavaTypeParameter;
import org.jetbrains.annotations.NotNull;

public final class ReflectJavaMethod
extends ReflectJavaMember
implements JavaMethod {
    @NotNull
    private final Method member;

    @Override
    @NotNull
    public List<JavaValueParameter> getValueParameters() {
        Type[] typeArray = this.getMember().getGenericParameterTypes();
        Intrinsics.checkExpressionValueIsNotNull(typeArray, "member.genericParameterTypes");
        Annotation[][] annotationArray = this.getMember().getParameterAnnotations();
        Intrinsics.checkExpressionValueIsNotNull(annotationArray, "member.parameterAnnotations");
        return this.getValueParameters(typeArray, annotationArray, this.getMember().isVarArgs());
    }

    @Override
    @NotNull
    public ReflectJavaType getReturnType() {
        Type type2 = this.getMember().getGenericReturnType();
        Intrinsics.checkExpressionValueIsNotNull(type2, "member.genericReturnType");
        return ReflectJavaType.Factory.create(type2);
    }

    @Override
    public boolean getHasAnnotationParameterDefaultValue() {
        return this.getMember().getDefaultValue() != null;
    }

    /*
     * WARNING - void declaration
     */
    @NotNull
    public List<ReflectJavaTypeParameter> getTypeParameters() {
        void var3_3;
        void $receiver$iv$iv;
        Object[] $receiver$iv;
        Object[] objectArray = $receiver$iv = (Object[])this.getMember().getTypeParameters();
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
    public Method getMember() {
        return this.member;
    }

    public ReflectJavaMethod(@NotNull Method member) {
        Intrinsics.checkParameterIsNotNull(member, "member");
        this.member = member;
    }
}

