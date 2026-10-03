/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.load.java.lazy.types;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.load.java.components.TypeUsage;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.types.JavaTypeAttributes;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.types.JavaTypeResolverKt;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.types.RawSubstitution$WhenMappings;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.types.RawTypeImpl;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.types.ErrorUtils;
import kotlin.reflect.jvm.internal.impl.types.FlexibleTypesKt;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import kotlin.reflect.jvm.internal.impl.types.TypeProjectionImpl;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitution;
import kotlin.reflect.jvm.internal.impl.types.UnwrappedType;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import org.jetbrains.annotations.NotNull;

public final class RawSubstitution
extends TypeSubstitution {
    private static final JavaTypeAttributes lowerTypeAttr;
    private static final JavaTypeAttributes upperTypeAttr;
    public static final RawSubstitution INSTANCE;

    @Override
    @NotNull
    public TypeProjectionImpl get(@NotNull KotlinType key) {
        Intrinsics.checkParameterIsNotNull(key, "key");
        return new TypeProjectionImpl(this.eraseType(key));
    }

    /*
     * WARNING - void declaration
     */
    @NotNull
    public final KotlinType eraseType(@NotNull KotlinType type2) {
        KotlinType kotlinType;
        ClassifierDescriptor declaration;
        Intrinsics.checkParameterIsNotNull(type2, "type");
        ClassifierDescriptor classifierDescriptor = declaration = type2.getConstructor().getDeclarationDescriptor();
        if (classifierDescriptor instanceof TypeParameterDescriptor) {
            kotlinType = this.eraseType(JavaTypeResolverKt.getErasedUpperBound$default((TypeParameterDescriptor)declaration, null, null, 3, null));
        } else if (classifierDescriptor instanceof ClassDescriptor) {
            void upper;
            void lower;
            void isRawU;
            void isRawL;
            Object object = this.eraseInflexibleBasedOnClassDescriptor(FlexibleTypesKt.lowerIfFlexible(type2), (ClassDescriptor)declaration, lowerTypeAttr);
            SimpleType simpleType2 = ((Pair)object).component1();
            boolean bl = ((Pair)object).component2();
            object = null;
            Pair<SimpleType, Boolean> pair = this.eraseInflexibleBasedOnClassDescriptor(FlexibleTypesKt.upperIfFlexible(type2), (ClassDescriptor)declaration, upperTypeAttr);
            object = pair.component1();
            boolean bl2 = pair.component2();
            pair = null;
            kotlinType = isRawL != false || isRawU != false ? (UnwrappedType)new RawTypeImpl((SimpleType)lower, (SimpleType)upper) : KotlinTypeFactory.flexibleType((SimpleType)lower, (SimpleType)upper);
        } else {
            String string = "Unexpected declaration kind: " + declaration;
            throw (Throwable)new IllegalStateException(string.toString());
        }
        return kotlinType;
    }

    /*
     * WARNING - void declaration
     */
    private final Pair<SimpleType, Boolean> eraseInflexibleBasedOnClassDescriptor(SimpleType type2, ClassDescriptor declaration, JavaTypeAttributes attr) {
        Collection<TypeProjection> collection;
        void $receiver$iv$iv;
        void $receiver$iv;
        if (type2.getConstructor().getParameters().isEmpty()) {
            return TuplesKt.to(type2, false);
        }
        if (KotlinBuiltIns.isArray(type2)) {
            TypeProjection componentTypeProjection = type2.getArguments().get(0);
            Variance variance = componentTypeProjection.getProjectionKind();
            KotlinType kotlinType = componentTypeProjection.getType();
            Intrinsics.checkExpressionValueIsNotNull(kotlinType, "componentTypeProjection.type");
            List<TypeProjectionImpl> arguments2 = CollectionsKt.listOf(new TypeProjectionImpl(variance, this.eraseType(kotlinType)));
            return TuplesKt.to(KotlinTypeFactory.simpleType$default(type2.getAnnotations(), type2.getConstructor(), arguments2, type2.isMarkedNullable(), null, 16, null), false);
        }
        if (type2.isError()) {
            return TuplesKt.to(ErrorUtils.createErrorType("Raw error type: " + type2.getConstructor()), false);
        }
        Iterable componentTypeProjection = type2.getConstructor().getParameters();
        TypeConstructor typeConstructor2 = type2.getConstructor();
        Annotations annotations2 = type2.getAnnotations();
        void arguments2 = $receiver$iv;
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($receiver$iv, 10));
        for (Object item$iv$iv : $receiver$iv$iv) {
            void parameter;
            TypeParameterDescriptor typeParameterDescriptor = (TypeParameterDescriptor)item$iv$iv;
            collection = destination$iv$iv;
            void v2 = parameter;
            Intrinsics.checkExpressionValueIsNotNull(v2, "parameter");
            TypeProjection typeProjection = RawSubstitution.computeProjection$default(INSTANCE, (TypeParameterDescriptor)v2, attr, null, 4, null);
            collection.add(typeProjection);
        }
        collection = (List)destination$iv$iv;
        boolean bl = type2.isMarkedNullable();
        MemberScope memberScope2 = declaration.getMemberScope(INSTANCE);
        Intrinsics.checkExpressionValueIsNotNull(memberScope2, "declaration.getMemberScope(RawSubstitution)");
        return TuplesKt.to(KotlinTypeFactory.simpleType(annotations2, typeConstructor2, (List<? extends TypeProjection>)collection, bl, memberScope2), true);
    }

    @NotNull
    public final TypeProjection computeProjection(@NotNull TypeParameterDescriptor parameter, @NotNull JavaTypeAttributes attr, @NotNull KotlinType erasedUpperBound) {
        TypeProjection typeProjection;
        Intrinsics.checkParameterIsNotNull(parameter, "parameter");
        Intrinsics.checkParameterIsNotNull(attr, "attr");
        Intrinsics.checkParameterIsNotNull(erasedUpperBound, "erasedUpperBound");
        switch (RawSubstitution$WhenMappings.$EnumSwitchMapping$0[attr.getRawBound().ordinal()]) {
            case 1: {
                typeProjection = new TypeProjectionImpl(Variance.INVARIANT, erasedUpperBound);
                break;
            }
            case 2: 
            case 3: {
                if (!parameter.getVariance().getAllowsOutPosition()) {
                    typeProjection = new TypeProjectionImpl(Variance.INVARIANT, DescriptorUtilsKt.getBuiltIns(parameter).getNothingType());
                    break;
                }
                Collection collection = erasedUpperBound.getConstructor().getParameters();
                if (!collection.isEmpty()) {
                    typeProjection = new TypeProjectionImpl(Variance.OUT_VARIANCE, erasedUpperBound);
                    break;
                }
                typeProjection = JavaTypeResolverKt.makeStarProjection(parameter, attr);
                break;
            }
            default: {
                throw new NoWhenBranchMatchedException();
            }
        }
        return typeProjection;
    }

    @NotNull
    public static /* bridge */ /* synthetic */ TypeProjection computeProjection$default(RawSubstitution rawSubstitution, TypeParameterDescriptor typeParameterDescriptor, JavaTypeAttributes javaTypeAttributes, KotlinType kotlinType, int n, Object object) {
        if ((n & 4) != 0) {
            kotlinType = JavaTypeResolverKt.getErasedUpperBound$default(typeParameterDescriptor, null, null, 3, null);
        }
        return rawSubstitution.computeProjection(typeParameterDescriptor, javaTypeAttributes, kotlinType);
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    private RawSubstitution() {
        INSTANCE = this;
        lowerTypeAttr = JavaTypeResolverKt.computeAttributes(JavaTypeResolverKt.toAttributes$default(TypeUsage.MEMBER_SIGNATURE_INVARIANT, false, false, null, 7, null), false, true, true);
        upperTypeAttr = JavaTypeResolverKt.computeAttributes(JavaTypeResolverKt.toAttributes$default(TypeUsage.MEMBER_SIGNATURE_INVARIANT, false, false, null, 7, null), false, true, false);
    }

    static {
        new RawSubstitution();
    }
}

