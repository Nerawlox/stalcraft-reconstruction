/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.load.kotlin;

import kotlin.jvm.JvmField;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.load.kotlin.TypeMappingMode$WhenMappings;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class TypeMappingMode {
    private final boolean needPrimitiveBoxing;
    private final boolean isForAnnotationParameter;
    private final boolean skipDeclarationSiteWildcards;
    private final boolean skipDeclarationSiteWildcardsIfPossible;
    private final TypeMappingMode genericArgumentMode;
    private final TypeMappingMode genericContravariantArgumentMode;
    private final TypeMappingMode genericInvariantArgumentMode;
    @JvmField
    @NotNull
    public static final TypeMappingMode GENERIC_ARGUMENT;
    @JvmField
    @NotNull
    public static final TypeMappingMode DEFAULT;
    @JvmField
    @NotNull
    public static final TypeMappingMode SUPER_TYPE;
    @JvmField
    @NotNull
    public static final TypeMappingMode VALUE_FOR_ANNOTATION;
    public static final Companion Companion;

    @NotNull
    public final TypeMappingMode toGenericArgumentMode(@NotNull Variance effectiveVariance) {
        TypeMappingMode typeMappingMode;
        Intrinsics.checkParameterIsNotNull((Object)effectiveVariance, "effectiveVariance");
        switch (TypeMappingMode$WhenMappings.$EnumSwitchMapping$0[effectiveVariance.ordinal()]) {
            case 1: {
                typeMappingMode = this.genericContravariantArgumentMode;
                if (typeMappingMode != null) break;
                typeMappingMode = this;
                break;
            }
            case 2: {
                typeMappingMode = this.genericInvariantArgumentMode;
                if (typeMappingMode != null) break;
                typeMappingMode = this;
                break;
            }
            default: {
                typeMappingMode = this.genericArgumentMode;
                if (typeMappingMode != null) break;
                typeMappingMode = this;
            }
        }
        return typeMappingMode;
    }

    public final boolean getNeedPrimitiveBoxing() {
        return this.needPrimitiveBoxing;
    }

    public final boolean isForAnnotationParameter() {
        return this.isForAnnotationParameter;
    }

    public final boolean getSkipDeclarationSiteWildcards() {
        return this.skipDeclarationSiteWildcards;
    }

    public final boolean getSkipDeclarationSiteWildcardsIfPossible() {
        return this.skipDeclarationSiteWildcardsIfPossible;
    }

    private TypeMappingMode(boolean needPrimitiveBoxing, boolean isForAnnotationParameter, boolean skipDeclarationSiteWildcards, boolean skipDeclarationSiteWildcardsIfPossible, TypeMappingMode genericArgumentMode, TypeMappingMode genericContravariantArgumentMode, TypeMappingMode genericInvariantArgumentMode) {
        this.needPrimitiveBoxing = needPrimitiveBoxing;
        this.isForAnnotationParameter = isForAnnotationParameter;
        this.skipDeclarationSiteWildcards = skipDeclarationSiteWildcards;
        this.skipDeclarationSiteWildcardsIfPossible = skipDeclarationSiteWildcardsIfPossible;
        this.genericArgumentMode = genericArgumentMode;
        this.genericContravariantArgumentMode = genericContravariantArgumentMode;
        this.genericInvariantArgumentMode = genericInvariantArgumentMode;
    }

    /* synthetic */ TypeMappingMode(boolean bl, boolean bl2, boolean bl3, boolean bl4, TypeMappingMode typeMappingMode, TypeMappingMode typeMappingMode2, TypeMappingMode typeMappingMode3, int n, DefaultConstructorMarker defaultConstructorMarker) {
        if ((n & 1) != 0) {
            bl = true;
        }
        if ((n & 2) != 0) {
            bl2 = false;
        }
        if ((n & 4) != 0) {
            bl3 = false;
        }
        if ((n & 8) != 0) {
            bl4 = false;
        }
        if ((n & 0x10) != 0) {
            typeMappingMode = null;
        }
        if ((n & 0x20) != 0) {
            typeMappingMode2 = typeMappingMode;
        }
        if ((n & 0x40) != 0) {
            typeMappingMode3 = typeMappingMode;
        }
        this(bl, bl2, bl3, bl4, typeMappingMode, typeMappingMode2, typeMappingMode3);
    }

    static {
        Companion = new Companion(null);
        GENERIC_ARGUMENT = new TypeMappingMode(false, false, false, false, null, null, null, 127, null);
        TypeMappingMode typeMappingMode = null;
        TypeMappingMode typeMappingMode2 = null;
        boolean bl = false;
        boolean bl2 = false;
        boolean bl3 = false;
        boolean bl4 = false;
        TypeMappingMode typeMappingMode3 = GENERIC_ARGUMENT;
        DEFAULT = new TypeMappingMode(bl, bl4, bl3, bl2, typeMappingMode3, typeMappingMode2, typeMappingMode, 110, null);
        SUPER_TYPE = new TypeMappingMode(false, false, true, false, GENERIC_ARGUMENT, null, null, 107, null);
        typeMappingMode = null;
        typeMappingMode2 = null;
        TypeMappingMode typeMappingMode4 = new TypeMappingMode(false, true, false, false, GENERIC_ARGUMENT, null, null, 109, null);
        bl2 = false;
        bl3 = false;
        bl4 = false;
        boolean bl5 = true;
        VALUE_FOR_ANNOTATION = new TypeMappingMode(bl4, bl5, bl3, bl2, typeMappingMode4, typeMappingMode2, typeMappingMode, 108, null);
    }

    @JvmStatic
    @NotNull
    public static final TypeMappingMode getModeForReturnTypeNoGeneric(boolean isAnnotationMethod) {
        return Companion.getModeForReturnTypeNoGeneric(isAnnotationMethod);
    }

    @JvmStatic
    @NotNull
    public static final TypeMappingMode getOptimalModeForValueParameter(@NotNull KotlinType type2) {
        Intrinsics.checkParameterIsNotNull(type2, "type");
        return Companion.getOptimalModeForValueParameter(type2);
    }

    @JvmStatic
    @NotNull
    public static final TypeMappingMode getOptimalModeForReturnType(@NotNull KotlinType type2, boolean isAnnotationMethod) {
        Intrinsics.checkParameterIsNotNull(type2, "type");
        return Companion.getOptimalModeForReturnType(type2, isAnnotationMethod);
    }

    @JvmStatic
    @NotNull
    public static final TypeMappingMode createWithConstantDeclarationSiteWildcardsMode(boolean skipDeclarationSiteWildcards, boolean isForAnnotationParameter, @Nullable TypeMappingMode fallbackMode) {
        return Companion.createWithConstantDeclarationSiteWildcardsMode(skipDeclarationSiteWildcards, isForAnnotationParameter, fallbackMode);
    }

    public static final class Companion {
        @JvmStatic
        @NotNull
        public final TypeMappingMode getModeForReturnTypeNoGeneric(boolean isAnnotationMethod) {
            return isAnnotationMethod ? VALUE_FOR_ANNOTATION : DEFAULT;
        }

        @JvmStatic
        @NotNull
        public final TypeMappingMode getOptimalModeForValueParameter(@NotNull KotlinType type2) {
            Intrinsics.checkParameterIsNotNull(type2, "type");
            return this.getOptimalModeForSignaturePart(type2, false, true);
        }

        @JvmStatic
        @NotNull
        public final TypeMappingMode getOptimalModeForReturnType(@NotNull KotlinType type2, boolean isAnnotationMethod) {
            Intrinsics.checkParameterIsNotNull(type2, "type");
            return this.getOptimalModeForSignaturePart(type2, isAnnotationMethod, false);
        }

        private final TypeMappingMode getOptimalModeForSignaturePart(KotlinType type2, boolean isForAnnotationParameter, boolean canBeUsedInSupertypePosition) {
            if (type2.getArguments().isEmpty()) {
                return DEFAULT;
            }
            TypeMappingMode contravariantArgumentMode = !canBeUsedInSupertypePosition ? new TypeMappingMode(false, isForAnnotationParameter, false, true, null, null, null, 113, null) : null;
            TypeMappingMode invariantArgumentMode = canBeUsedInSupertypePosition ? this.getOptimalModeForSignaturePart(type2, isForAnnotationParameter, false) : null;
            return new TypeMappingMode(false, isForAnnotationParameter, !canBeUsedInSupertypePosition, true, null, contravariantArgumentMode, invariantArgumentMode, 17, null);
        }

        @JvmStatic
        @NotNull
        public final TypeMappingMode createWithConstantDeclarationSiteWildcardsMode(boolean skipDeclarationSiteWildcards, boolean isForAnnotationParameter, @Nullable TypeMappingMode fallbackMode) {
            return new TypeMappingMode(false, isForAnnotationParameter, skipDeclarationSiteWildcards, false, fallbackMode, null, null, 105, null);
        }

        @JvmStatic
        @NotNull
        public static /* bridge */ /* synthetic */ TypeMappingMode createWithConstantDeclarationSiteWildcardsMode$default(Companion companion, boolean bl, boolean bl2, TypeMappingMode typeMappingMode, int n, Object object) {
            if ((n & 4) != 0) {
                typeMappingMode = null;
            }
            return companion.createWithConstantDeclarationSiteWildcardsMode(bl, bl2, typeMappingMode);
        }

        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }
}

