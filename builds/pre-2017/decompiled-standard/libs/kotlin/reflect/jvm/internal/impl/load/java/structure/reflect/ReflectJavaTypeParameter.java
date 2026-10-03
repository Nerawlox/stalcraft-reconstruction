/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.load.java.structure.reflect;

import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaTypeParameter;
import kotlin.reflect.jvm.internal.impl.load.java.structure.reflect.ReflectJavaAnnotation;
import kotlin.reflect.jvm.internal.impl.load.java.structure.reflect.ReflectJavaAnnotationOwner;
import kotlin.reflect.jvm.internal.impl.load.java.structure.reflect.ReflectJavaClassifierType;
import kotlin.reflect.jvm.internal.impl.load.java.structure.reflect.ReflectJavaElement;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.Name;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class ReflectJavaTypeParameter
extends ReflectJavaElement
implements JavaTypeParameter,
ReflectJavaAnnotationOwner {
    @NotNull
    private final TypeVariable<?> typeVariable;

    /*
     * WARNING - void declaration
     */
    @NotNull
    public List<ReflectJavaClassifierType> getUpperBounds() {
        void var3_3;
        void $receiver$iv$iv;
        Object[] $receiver$iv;
        Object[] objectArray = $receiver$iv = (Object[])this.typeVariable.getBounds();
        Collection destination$iv$iv = new ArrayList($receiver$iv.length);
        for (int i = 0; i < ((void)$receiver$iv$iv).length; ++i) {
            void bound;
            void item$iv$iv = $receiver$iv$iv[i];
            Type type2 = (Type)item$iv$iv;
            Collection collection = destination$iv$iv;
            void v0 = bound;
            Intrinsics.checkExpressionValueIsNotNull(v0, "bound");
            ReflectJavaClassifierType reflectJavaClassifierType = new ReflectJavaClassifierType((Type)v0);
            collection.add(reflectJavaClassifierType);
        }
        List bounds = (List)var3_3;
        ReflectJavaClassifierType reflectJavaClassifierType = (ReflectJavaClassifierType)CollectionsKt.singleOrNull(bounds);
        if (Intrinsics.areEqual(reflectJavaClassifierType != null ? reflectJavaClassifierType.getReflectType() : null, Object.class)) {
            return CollectionsKt.emptyList();
        }
        return bounds;
    }

    @Override
    @Nullable
    public AnnotatedElement getElement() {
        TypeVariable<?> typeVariable = this.typeVariable;
        if (!(typeVariable instanceof AnnotatedElement)) {
            typeVariable = null;
        }
        return typeVariable;
    }

    @Override
    @NotNull
    public Name getName() {
        Name name2 = Name.identifier(this.typeVariable.getName());
        Intrinsics.checkExpressionValueIsNotNull(name2, "Name.identifier(typeVariable.name)");
        return name2;
    }

    public boolean equals(@Nullable Object other) {
        return other instanceof ReflectJavaTypeParameter && Intrinsics.areEqual(this.typeVariable, ((ReflectJavaTypeParameter)other).typeVariable);
    }

    public int hashCode() {
        return this.typeVariable.hashCode();
    }

    @NotNull
    public String toString() {
        return this.getClass().getName() + ": " + this.typeVariable;
    }

    @NotNull
    public final TypeVariable<?> getTypeVariable() {
        return this.typeVariable;
    }

    public ReflectJavaTypeParameter(@NotNull TypeVariable<?> typeVariable) {
        Intrinsics.checkParameterIsNotNull(typeVariable, "typeVariable");
        this.typeVariable = typeVariable;
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
}

