/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.load.java.lazy.types;

import kotlin.TypeCastException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.load.java.JvmAnnotationNames;
import kotlin.reflect.jvm.internal.impl.load.java.components.TypeUsage;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.types.JavaTypeAttributes;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.types.JavaTypeFlexibility;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.types.RawBound;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.types.ErrorUtils;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.StarProjectionImpl;
import kotlin.reflect.jvm.internal.impl.types.StarProjectionImplKt;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import kotlin.reflect.jvm.internal.impl.types.TypeProjectionImpl;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class JavaTypeResolverKt {
    private static final FqName JAVA_LANG_CLASS_FQ_NAME = new FqName("java.lang.Class");

    @NotNull
    public static final TypeProjection makeStarProjection(@NotNull TypeParameterDescriptor typeParameter, @NotNull JavaTypeAttributes attr) {
        Intrinsics.checkParameterIsNotNull(typeParameter, "typeParameter");
        Intrinsics.checkParameterIsNotNull(attr, "attr");
        return Intrinsics.areEqual((Object)attr.getHowThisTypeIsUsed(), (Object)TypeUsage.SUPERTYPE) ? (TypeProjection)new TypeProjectionImpl(StarProjectionImplKt.starProjectionType(typeParameter)) : (TypeProjection)new StarProjectionImpl(typeParameter);
    }

    public static final boolean isMarkedNotNull(@NotNull Annotations $receiver) {
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        FqName fqName2 = JvmAnnotationNames.JETBRAINS_NOT_NULL_ANNOTATION;
        Intrinsics.checkExpressionValueIsNotNull(fqName2, "JETBRAINS_NOT_NULL_ANNOTATION");
        return $receiver.findAnnotation(fqName2) != null;
    }

    public static final boolean isMarkedNullable(@NotNull Annotations $receiver) {
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        FqName fqName2 = JvmAnnotationNames.JETBRAINS_NULLABLE_ANNOTATION;
        Intrinsics.checkExpressionValueIsNotNull(fqName2, "JETBRAINS_NULLABLE_ANNOTATION");
        return $receiver.findAnnotation(fqName2) != null;
    }

    @NotNull
    public static final JavaTypeAttributes toAttributes(@NotNull TypeUsage $receiver, boolean allowFlexible, boolean isForAnnotationParameter, @Nullable TypeParameterDescriptor upperBoundForTypeParameter) {
        Intrinsics.checkParameterIsNotNull((Object)$receiver, "$receiver");
        return new JavaTypeAttributes($receiver, allowFlexible, isForAnnotationParameter, upperBoundForTypeParameter){
            @NotNull
            private final TypeUsage howThisTypeIsUsed;
            private final boolean isMarkedNotNull = false;
            private final boolean allowFlexible;
            @NotNull
            private final Annotations typeAnnotations;
            private final boolean isForAnnotationParameter;
            @Nullable
            private final TypeParameterDescriptor upperBoundOfTypeParameter;
            final /* synthetic */ TypeUsage receiver$0;
            final /* synthetic */ boolean $allowFlexible;
            final /* synthetic */ boolean $isForAnnotationParameter;
            final /* synthetic */ TypeParameterDescriptor $upperBoundForTypeParameter;

            @NotNull
            public TypeUsage getHowThisTypeIsUsed() {
                return this.howThisTypeIsUsed;
            }

            @NotNull
            public TypeUsage getHowThisTypeIsUsedAccordingToAnnotations() {
                return this.getHowThisTypeIsUsed();
            }

            public boolean isMarkedNotNull() {
                return this.isMarkedNotNull;
            }

            public boolean getAllowFlexible() {
                return this.allowFlexible;
            }

            @NotNull
            public Annotations getTypeAnnotations() {
                return this.typeAnnotations;
            }

            public boolean isForAnnotationParameter() {
                return this.isForAnnotationParameter;
            }

            @Nullable
            public TypeParameterDescriptor getUpperBoundOfTypeParameter() {
                return this.upperBoundOfTypeParameter;
            }
            {
                this.receiver$0 = $receiver;
                this.$allowFlexible = $captured_local_variable$1;
                this.$isForAnnotationParameter = $captured_local_variable$2;
                this.$upperBoundForTypeParameter = $captured_local_variable$3;
                this.howThisTypeIsUsed = this.receiver$0;
                this.allowFlexible = $captured_local_variable$1;
                this.typeAnnotations = Annotations.Companion.getEMPTY();
                this.isForAnnotationParameter = $captured_local_variable$2;
                this.upperBoundOfTypeParameter = $captured_local_variable$3;
            }

            @NotNull
            public JavaTypeFlexibility getFlexibility() {
                return JavaTypeAttributes.DefaultImpls.getFlexibility(this);
            }

            @NotNull
            public RawBound getRawBound() {
                return JavaTypeAttributes.DefaultImpls.getRawBound(this);
            }
        };
    }

    @NotNull
    public static /* bridge */ /* synthetic */ JavaTypeAttributes toAttributes$default(TypeUsage typeUsage, boolean bl, boolean bl2, TypeParameterDescriptor typeParameterDescriptor, int n, Object object) {
        if ((n & 1) != 0) {
            bl = true;
        }
        if ((n & 2) != 0) {
            bl2 = false;
        }
        if ((n & 4) != 0) {
            typeParameterDescriptor = null;
        }
        return JavaTypeResolverKt.toAttributes(typeUsage, bl, bl2, typeParameterDescriptor);
    }

    @NotNull
    public static final JavaTypeAttributes computeAttributes(@NotNull JavaTypeAttributes $receiver, boolean allowFlexible, boolean isRaw, boolean forLower) {
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        return new JavaTypeAttributes($receiver, allowFlexible, forLower, isRaw){
            @NotNull
            private final JavaTypeFlexibility flexibility;
            @NotNull
            private final RawBound rawBound;
            private final /* synthetic */ JavaTypeAttributes $$delegate_0;
            final /* synthetic */ JavaTypeAttributes receiver$0;
            final /* synthetic */ boolean $allowFlexible;
            final /* synthetic */ boolean $forLower;
            final /* synthetic */ boolean $isRaw;

            @NotNull
            public JavaTypeFlexibility getFlexibility() {
                return this.flexibility;
            }

            @NotNull
            public RawBound getRawBound() {
                return this.rawBound;
            }
            {
                this.receiver$0 = $receiver;
                this.$allowFlexible = $captured_local_variable$1;
                this.$forLower = $captured_local_variable$2;
                this.$isRaw = $captured_local_variable$3;
                this.$$delegate_0 = this.receiver$0;
                JavaTypeFlexibility javaTypeFlexibility = !$captured_local_variable$1 ? JavaTypeFlexibility.INFLEXIBLE : (this.flexibility = $captured_local_variable$2 ? JavaTypeFlexibility.FLEXIBLE_LOWER_BOUND : JavaTypeFlexibility.FLEXIBLE_UPPER_BOUND);
                this.rawBound = !$captured_local_variable$3 ? RawBound.NOT_RAW : ($captured_local_variable$2 ? RawBound.LOWER : RawBound.UPPER);
            }

            public boolean getAllowFlexible() {
                return this.$$delegate_0.getAllowFlexible();
            }

            @NotNull
            public TypeUsage getHowThisTypeIsUsed() {
                return this.$$delegate_0.getHowThisTypeIsUsed();
            }

            @NotNull
            public TypeUsage getHowThisTypeIsUsedAccordingToAnnotations() {
                return this.$$delegate_0.getHowThisTypeIsUsedAccordingToAnnotations();
            }

            public boolean isForAnnotationParameter() {
                return this.$$delegate_0.isForAnnotationParameter();
            }

            public boolean isMarkedNotNull() {
                return this.$$delegate_0.isMarkedNotNull();
            }

            @NotNull
            public Annotations getTypeAnnotations() {
                return this.$$delegate_0.getTypeAnnotations();
            }

            @Nullable
            public TypeParameterDescriptor getUpperBoundOfTypeParameter() {
                return this.$$delegate_0.getUpperBoundOfTypeParameter();
            }
        };
    }

    @NotNull
    public static final KotlinType getErasedUpperBound(@NotNull TypeParameterDescriptor $receiver, @Nullable TypeParameterDescriptor potentiallyRecursiveTypeParameter, @NotNull Function0<? extends KotlinType> defaultValue) {
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        Intrinsics.checkParameterIsNotNull(defaultValue, "defaultValue");
        if ($receiver == potentiallyRecursiveTypeParameter) {
            return defaultValue.invoke();
        }
        KotlinType firstUpperBound = CollectionsKt.first($receiver.getUpperBounds());
        if (firstUpperBound.getConstructor().getDeclarationDescriptor() instanceof ClassDescriptor) {
            return TypeUtilsKt.replaceArgumentsWithStarProjections(firstUpperBound);
        }
        TypeParameterDescriptor typeParameterDescriptor = potentiallyRecursiveTypeParameter;
        if (typeParameterDescriptor == null) {
            typeParameterDescriptor = $receiver;
        }
        TypeParameterDescriptor stopAt = typeParameterDescriptor;
        ClassifierDescriptor classifierDescriptor = firstUpperBound.getConstructor().getDeclarationDescriptor();
        if (classifierDescriptor == null) {
            throw new TypeCastException("null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.TypeParameterDescriptor");
        }
        TypeParameterDescriptor current = (TypeParameterDescriptor)classifierDescriptor;
        while (Intrinsics.areEqual(current, stopAt) ^ true) {
            KotlinType nextUpperBound = CollectionsKt.first(current.getUpperBounds());
            if (nextUpperBound.getConstructor().getDeclarationDescriptor() instanceof ClassDescriptor) {
                return TypeUtilsKt.replaceArgumentsWithStarProjections(nextUpperBound);
            }
            ClassifierDescriptor classifierDescriptor2 = nextUpperBound.getConstructor().getDeclarationDescriptor();
            if (classifierDescriptor2 == null) {
                throw new TypeCastException("null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.TypeParameterDescriptor");
            }
            current = (TypeParameterDescriptor)classifierDescriptor2;
        }
        return defaultValue.invoke();
    }

    @NotNull
    public static /* bridge */ /* synthetic */ KotlinType getErasedUpperBound$default(TypeParameterDescriptor typeParameterDescriptor, TypeParameterDescriptor typeParameterDescriptor2, Function0 function0, int n, Object object) {
        if ((n & 1) != 0) {
            typeParameterDescriptor2 = null;
        }
        if ((n & 2) != 0) {
            function0 = new Function0<SimpleType>(typeParameterDescriptor){
                final /* synthetic */ TypeParameterDescriptor receiver$0;

                @NotNull
                public final SimpleType invoke() {
                    SimpleType simpleType2 = ErrorUtils.createErrorType("Can't compute erased upper bound of type parameter `" + this.receiver$0 + "`");
                    Intrinsics.checkExpressionValueIsNotNull(simpleType2, "ErrorUtils.createErrorTy\u2026 type parameter `$this`\")");
                    return simpleType2;
                }
                {
                    this.receiver$0 = typeParameterDescriptor;
                    super(0);
                }
            };
        }
        return JavaTypeResolverKt.getErasedUpperBound(typeParameterDescriptor, typeParameterDescriptor2, function0);
    }

    @NotNull
    public static final /* synthetic */ FqName access$getJAVA_LANG_CLASS_FQ_NAME$p() {
        return JAVA_LANG_CLASS_FQ_NAME;
    }
}

