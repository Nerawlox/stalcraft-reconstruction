/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.load.java.lazy.types;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.FilteredAnnotations;
import kotlin.reflect.jvm.internal.impl.load.java.JvmAnnotationNames;
import kotlin.reflect.jvm.internal.impl.load.java.components.TypeUsage;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.types.JavaTypeAttributes;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.types.JavaTypeFlexibility;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.types.JavaTypeResolverKt;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.types.LazyJavaTypeAttributes;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.types.RawBound;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class LazyJavaTypeAttributes
implements JavaTypeAttributes {
    @NotNull
    private final FilteredAnnotations typeAnnotations;
    @NotNull
    private final TypeUsage howThisTypeIsUsed;
    private final boolean allowFlexible;
    private final boolean isForAnnotationParameter;

    @Override
    @NotNull
    public FilteredAnnotations getTypeAnnotations() {
        return this.typeAnnotations;
    }

    /*
     * Enabled aggressive block sorting
     */
    @Override
    @NotNull
    public TypeUsage getHowThisTypeIsUsedAccordingToAnnotations() {
        TypeUsage typeUsage;
        FqName fqName2 = JvmAnnotationNames.JETBRAINS_READONLY_ANNOTATION;
        Intrinsics.checkExpressionValueIsNotNull(fqName2, "JETBRAINS_READONLY_ANNOTATION");
        if (this.hasAnnotation(fqName2)) {
            FqName fqName3 = JvmAnnotationNames.JETBRAINS_MUTABLE_ANNOTATION;
            Intrinsics.checkExpressionValueIsNotNull(fqName3, "JETBRAINS_MUTABLE_ANNOTATION");
            if (!this.hasAnnotation(fqName3)) {
                typeUsage = TypeUsage.MEMBER_SIGNATURE_CONTRAVARIANT;
                return typeUsage;
            }
        }
        typeUsage = TypeUsage.MEMBER_SIGNATURE_COVARIANT;
        return typeUsage;
    }

    @Override
    public boolean isMarkedNotNull() {
        return JavaTypeResolverKt.isMarkedNotNull(this.getTypeAnnotations());
    }

    private final boolean hasAnnotation(FqName fqName2) {
        return this.getTypeAnnotations().findAnnotation(fqName2) != null;
    }

    @Override
    @NotNull
    public TypeUsage getHowThisTypeIsUsed() {
        return this.howThisTypeIsUsed;
    }

    @Override
    public boolean getAllowFlexible() {
        return this.allowFlexible;
    }

    @Override
    public boolean isForAnnotationParameter() {
        return this.isForAnnotationParameter;
    }

    public LazyJavaTypeAttributes(@NotNull TypeUsage howThisTypeIsUsed, @NotNull Annotations annotations2, boolean allowFlexible, boolean isForAnnotationParameter) {
        Intrinsics.checkParameterIsNotNull((Object)howThisTypeIsUsed, "howThisTypeIsUsed");
        Intrinsics.checkParameterIsNotNull(annotations2, "annotations");
        this.howThisTypeIsUsed = howThisTypeIsUsed;
        this.allowFlexible = allowFlexible;
        this.isForAnnotationParameter = isForAnnotationParameter;
        this.typeAnnotations = new FilteredAnnotations(annotations2, typeAnnotations.1.INSTANCE);
    }

    public /* synthetic */ LazyJavaTypeAttributes(TypeUsage typeUsage, Annotations annotations2, boolean bl, boolean bl2, int n, DefaultConstructorMarker defaultConstructorMarker) {
        if ((n & 4) != 0) {
            bl = true;
        }
        if ((n & 8) != 0) {
            bl2 = false;
        }
        this(typeUsage, annotations2, bl, bl2);
    }

    @Override
    @NotNull
    public JavaTypeFlexibility getFlexibility() {
        return JavaTypeAttributes.DefaultImpls.getFlexibility(this);
    }

    @Override
    @Nullable
    public TypeParameterDescriptor getUpperBoundOfTypeParameter() {
        return JavaTypeAttributes.DefaultImpls.getUpperBoundOfTypeParameter(this);
    }

    @Override
    @NotNull
    public RawBound getRawBound() {
        return JavaTypeAttributes.DefaultImpls.getRawBound(this);
    }
}

