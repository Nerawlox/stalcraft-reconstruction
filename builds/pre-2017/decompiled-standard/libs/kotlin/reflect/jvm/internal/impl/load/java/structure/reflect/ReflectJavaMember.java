/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.load.java.structure.reflect;

import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Member;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import kotlin.TypeCastException;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.Visibility;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaMember;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaValueParameter;
import kotlin.reflect.jvm.internal.impl.load.java.structure.reflect.Java8ParameterNamesLoader;
import kotlin.reflect.jvm.internal.impl.load.java.structure.reflect.ReflectJavaAnnotation;
import kotlin.reflect.jvm.internal.impl.load.java.structure.reflect.ReflectJavaAnnotationOwner;
import kotlin.reflect.jvm.internal.impl.load.java.structure.reflect.ReflectJavaClass;
import kotlin.reflect.jvm.internal.impl.load.java.structure.reflect.ReflectJavaElement;
import kotlin.reflect.jvm.internal.impl.load.java.structure.reflect.ReflectJavaModifierListOwner;
import kotlin.reflect.jvm.internal.impl.load.java.structure.reflect.ReflectJavaType;
import kotlin.reflect.jvm.internal.impl.load.java.structure.reflect.ReflectJavaValueParameter;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.name.SpecialNames;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public abstract class ReflectJavaMember
extends ReflectJavaElement
implements ReflectJavaAnnotationOwner,
ReflectJavaModifierListOwner,
JavaMember {
    @NotNull
    public abstract Member getMember();

    @Override
    @NotNull
    public AnnotatedElement getElement() {
        Member member = this.getMember();
        if (member == null) {
            throw new TypeCastException("null cannot be cast to non-null type java.lang.reflect.AnnotatedElement");
        }
        return (AnnotatedElement)((Object)member);
    }

    @Override
    public int getModifiers() {
        return this.getMember().getModifiers();
    }

    @Override
    @NotNull
    public Name getName() {
        String string;
        String it;
        Object object = this.getMember().getName();
        if (object == null || (object = Name.identifier(it = (string = object))) == null) {
            Name name2 = SpecialNames.NO_NAME_PROVIDED;
            object = name2;
            Intrinsics.checkExpressionValueIsNotNull(name2, "SpecialNames.NO_NAME_PROVIDED");
        }
        return object;
    }

    @Override
    @NotNull
    public ReflectJavaClass getContainingClass() {
        Class<?> clazz = this.getMember().getDeclaringClass();
        Intrinsics.checkExpressionValueIsNotNull(clazz, "member.declaringClass");
        return new ReflectJavaClass(clazz);
    }

    /*
     * WARNING - void declaration
     */
    @NotNull
    protected final List<JavaValueParameter> getValueParameters(@NotNull Type[] parameterTypes, @NotNull Annotation[][] parameterAnnotations, boolean isVararg) {
        Intrinsics.checkParameterIsNotNull(parameterTypes, "parameterTypes");
        Intrinsics.checkParameterIsNotNull(parameterAnnotations, "parameterAnnotations");
        ArrayList<ReflectJavaValueParameter> result2 = new ArrayList<ReflectJavaValueParameter>(((Object[])parameterTypes).length);
        List<String> names = Java8ParameterNamesLoader.INSTANCE.loadParameterNames(this.getMember());
        int n = 0;
        int n2 = parameterTypes.length - 1;
        if (n <= n2) {
            while (true) {
                String string;
                void i;
                ReflectJavaType type2 = ReflectJavaType.Factory.create(parameterTypes[i]);
                if (names != null) {
                    List<String> list;
                    List<String> $receiver = list;
                    string = $receiver.get((int)i);
                } else {
                    string = null;
                }
                String name2 = string;
                boolean isParamVararg = isVararg && i == ArraysKt.getLastIndex((Object[])parameterTypes);
                result2.add(new ReflectJavaValueParameter(type2, parameterAnnotations[i], name2, isParamVararg));
                if (i == n2) break;
                ++i;
            }
        }
        return result2;
    }

    public boolean equals(@Nullable Object other) {
        return other instanceof ReflectJavaMember && Intrinsics.areEqual(this.getMember(), ((ReflectJavaMember)other).getMember());
    }

    public int hashCode() {
        return this.getMember().hashCode();
    }

    @NotNull
    public String toString() {
        return this.getClass().getName() + ": " + this.getMember();
    }

    @Override
    @NotNull
    public List<ReflectJavaAnnotation> getAnnotations() {
        return ReflectJavaAnnotationOwner.DefaultImpls.getAnnotations(this);
    }

    @Override
    @Nullable
    public ReflectJavaAnnotation findAnnotation(@NotNull FqName fqName2) {
        Intrinsics.checkParameterIsNotNull(fqName2, "fqName");
        return ReflectJavaAnnotationOwner.DefaultImpls.findAnnotation(this, fqName2);
    }

    @Override
    public boolean isDeprecatedInJavaDoc() {
        return ReflectJavaAnnotationOwner.DefaultImpls.isDeprecatedInJavaDoc(this);
    }

    @Override
    public boolean isAbstract() {
        return ReflectJavaModifierListOwner.DefaultImpls.isAbstract(this);
    }

    @Override
    public boolean isStatic() {
        return ReflectJavaModifierListOwner.DefaultImpls.isStatic(this);
    }

    @Override
    public boolean isFinal() {
        return ReflectJavaModifierListOwner.DefaultImpls.isFinal(this);
    }

    @Override
    @NotNull
    public Visibility getVisibility() {
        return ReflectJavaModifierListOwner.DefaultImpls.getVisibility(this);
    }
}

