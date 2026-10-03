/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.types;

import java.util.List;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeAliasDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.types.ErrorUtils;
import kotlin.reflect.jvm.internal.impl.types.FlexibleTypeImpl;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.SimpleTypeImpl;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructorSubstitution;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import kotlin.reflect.jvm.internal.impl.types.UnwrappedType;
import org.jetbrains.annotations.NotNull;

public final class KotlinTypeFactory {
    public static final KotlinTypeFactory INSTANCE;

    private final MemberScope computeMemberScope(TypeConstructor constructor, List<? extends TypeProjection> arguments2) {
        MemberScope memberScope2;
        ClassifierDescriptor descriptor2 = constructor.getDeclarationDescriptor();
        ClassifierDescriptor classifierDescriptor = descriptor2;
        if (classifierDescriptor instanceof TypeParameterDescriptor) {
            memberScope2 = descriptor2.getDefaultType().getMemberScope();
        } else if (classifierDescriptor instanceof ClassDescriptor) {
            MemberScope memberScope3 = ((ClassDescriptor)descriptor2).getMemberScope(TypeConstructorSubstitution.Companion.create(constructor, arguments2));
            memberScope2 = memberScope3;
            Intrinsics.checkExpressionValueIsNotNull(memberScope3, "descriptor.getMemberScop\u2026(constructor, arguments))");
        } else if (classifierDescriptor instanceof TypeAliasDescriptor) {
            MemberScope memberScope4 = ErrorUtils.createErrorScope("Scope for abbreviation: " + ((TypeAliasDescriptor)descriptor2).getName(), true);
            memberScope2 = memberScope4;
            Intrinsics.checkExpressionValueIsNotNull(memberScope4, "ErrorUtils.createErrorSc\u2026{descriptor.name}\", true)");
        } else {
            throw (Throwable)new IllegalStateException("Unsupported classifier: " + descriptor2 + " for constructor: " + constructor);
        }
        return memberScope2;
    }

    @JvmStatic
    @NotNull
    public static final SimpleType simpleType(@NotNull Annotations annotations2, @NotNull TypeConstructor constructor, @NotNull List<? extends TypeProjection> arguments2, boolean nullable, @NotNull MemberScope memberScope2) {
        Intrinsics.checkParameterIsNotNull(annotations2, "annotations");
        Intrinsics.checkParameterIsNotNull(constructor, "constructor");
        Intrinsics.checkParameterIsNotNull(arguments2, "arguments");
        Intrinsics.checkParameterIsNotNull(memberScope2, "memberScope");
        return new SimpleTypeImpl(annotations2, constructor, arguments2, nullable, memberScope2);
    }

    @JvmStatic
    @NotNull
    public static /* bridge */ /* synthetic */ SimpleType simpleType$default(Annotations annotations2, TypeConstructor typeConstructor2, List list, boolean bl, MemberScope memberScope2, int n, Object object) {
        if ((n & 0x10) != 0) {
            memberScope2 = INSTANCE.computeMemberScope(typeConstructor2, list);
        }
        return KotlinTypeFactory.simpleType(annotations2, typeConstructor2, list, bl, memberScope2);
    }

    @JvmStatic
    @NotNull
    public static final SimpleType simpleNotNullType(@NotNull Annotations annotations2, @NotNull ClassDescriptor descriptor2, @NotNull List<? extends TypeProjection> arguments2) {
        Intrinsics.checkParameterIsNotNull(annotations2, "annotations");
        Intrinsics.checkParameterIsNotNull(descriptor2, "descriptor");
        Intrinsics.checkParameterIsNotNull(arguments2, "arguments");
        TypeConstructor typeConstructor2 = descriptor2.getTypeConstructor();
        Intrinsics.checkExpressionValueIsNotNull(typeConstructor2, "descriptor.typeConstructor");
        MemberScope memberScope2 = descriptor2.getMemberScope(arguments2);
        Intrinsics.checkExpressionValueIsNotNull(memberScope2, "descriptor.getMemberScope(arguments)");
        return new SimpleTypeImpl(annotations2, typeConstructor2, arguments2, false, memberScope2);
    }

    @JvmStatic
    @NotNull
    public static final SimpleType simpleType(@NotNull SimpleType baseType, @NotNull Annotations annotations2, @NotNull TypeConstructor constructor, @NotNull List<? extends TypeProjection> arguments2, boolean nullable, @NotNull MemberScope memberScope2) {
        Intrinsics.checkParameterIsNotNull(baseType, "baseType");
        Intrinsics.checkParameterIsNotNull(annotations2, "annotations");
        Intrinsics.checkParameterIsNotNull(constructor, "constructor");
        Intrinsics.checkParameterIsNotNull(arguments2, "arguments");
        Intrinsics.checkParameterIsNotNull(memberScope2, "memberScope");
        return KotlinTypeFactory.simpleType(annotations2, constructor, arguments2, nullable, memberScope2);
    }

    @JvmStatic
    @NotNull
    public static /* bridge */ /* synthetic */ SimpleType simpleType$default(SimpleType simpleType2, Annotations annotations2, TypeConstructor typeConstructor2, List list, boolean bl, MemberScope memberScope2, int n, Object object) {
        if ((n & 2) != 0) {
            annotations2 = simpleType2.getAnnotations();
        }
        if ((n & 4) != 0) {
            typeConstructor2 = simpleType2.getConstructor();
        }
        if ((n & 8) != 0) {
            list = simpleType2.getArguments();
        }
        if ((n & 0x10) != 0) {
            bl = simpleType2.isMarkedNullable();
        }
        if ((n & 0x20) != 0) {
            memberScope2 = simpleType2.getMemberScope();
        }
        return KotlinTypeFactory.simpleType(simpleType2, annotations2, typeConstructor2, list, bl, memberScope2);
    }

    @JvmStatic
    @NotNull
    public static final UnwrappedType flexibleType(@NotNull SimpleType lowerBound, @NotNull SimpleType upperBound) {
        Intrinsics.checkParameterIsNotNull(lowerBound, "lowerBound");
        Intrinsics.checkParameterIsNotNull(upperBound, "upperBound");
        if (Intrinsics.areEqual(lowerBound, upperBound)) {
            return lowerBound;
        }
        return new FlexibleTypeImpl(lowerBound, upperBound);
    }

    private KotlinTypeFactory() {
        INSTANCE = this;
    }

    static {
        new KotlinTypeFactory();
    }
}

