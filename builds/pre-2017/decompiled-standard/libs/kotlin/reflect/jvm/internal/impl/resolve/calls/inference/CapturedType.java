/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.resolve.calls.inference;

import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.resolve.calls.inference.CapturedTypeConstructor;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.types.ErrorUtils;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.SubtypingRepresentatives;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;
import org.jetbrains.annotations.NotNull;

public final class CapturedType
extends SimpleType
implements SubtypingRepresentatives {
    @NotNull
    private final TypeProjection typeProjection;
    @NotNull
    private final CapturedTypeConstructor constructor;
    private final boolean isMarkedNullable;
    @NotNull
    private final Annotations annotations;

    @Override
    @NotNull
    public List<TypeProjection> getArguments() {
        return CollectionsKt.emptyList();
    }

    @Override
    @NotNull
    public MemberScope getMemberScope() {
        MemberScope memberScope2 = ErrorUtils.createErrorScope("No member resolution should be done on captured type, it used only during constraint system resolution", true);
        Intrinsics.checkExpressionValueIsNotNull(memberScope2, "ErrorUtils.createErrorSc\u2026system resolution\", true)");
        return memberScope2;
    }

    @Override
    public boolean isError() {
        return false;
    }

    @Override
    @NotNull
    public KotlinType getSubTypeRepresentative() {
        SimpleType simpleType2 = TypeUtilsKt.getBuiltIns(this).getNullableAnyType();
        Intrinsics.checkExpressionValueIsNotNull(simpleType2, "builtIns.nullableAnyType");
        KotlinType kotlinType = this.representative(Variance.OUT_VARIANCE, simpleType2);
        Intrinsics.checkExpressionValueIsNotNull(kotlinType, "representative(OUT_VARIA\u2026builtIns.nullableAnyType)");
        return kotlinType;
    }

    @Override
    @NotNull
    public KotlinType getSuperTypeRepresentative() {
        SimpleType simpleType2 = TypeUtilsKt.getBuiltIns(this).getNothingType();
        Intrinsics.checkExpressionValueIsNotNull(simpleType2, "builtIns.nothingType");
        KotlinType kotlinType = this.representative(Variance.IN_VARIANCE, simpleType2);
        Intrinsics.checkExpressionValueIsNotNull(kotlinType, "representative(IN_VARIANCE, builtIns.nothingType)");
        return kotlinType;
    }

    private final KotlinType representative(Variance variance, KotlinType kotlinType) {
        return Intrinsics.areEqual((Object)this.typeProjection.getProjectionKind(), (Object)variance) ? this.typeProjection.getType() : kotlinType;
    }

    @Override
    public boolean sameTypeConstructor(@NotNull KotlinType type2) {
        Intrinsics.checkParameterIsNotNull(type2, "type");
        return this.getConstructor() == type2.getConstructor();
    }

    @Override
    @NotNull
    public String toString() {
        return "Captured(" + this.typeProjection + ")" + (this.isMarkedNullable() ? "?" : "");
    }

    @Override
    @NotNull
    public CapturedType makeNullableAsSpecified(boolean newNullability) {
        if (newNullability == this.isMarkedNullable()) {
            return this;
        }
        return new CapturedType(this.typeProjection, this.getConstructor(), newNullability, this.getAnnotations());
    }

    @Override
    @NotNull
    public CapturedType replaceAnnotations(@NotNull Annotations newAnnotations) {
        Intrinsics.checkParameterIsNotNull(newAnnotations, "newAnnotations");
        return new CapturedType(this.typeProjection, this.getConstructor(), this.isMarkedNullable(), newAnnotations);
    }

    @NotNull
    public final TypeProjection getTypeProjection() {
        return this.typeProjection;
    }

    @Override
    @NotNull
    public CapturedTypeConstructor getConstructor() {
        return this.constructor;
    }

    @Override
    public boolean isMarkedNullable() {
        return this.isMarkedNullable;
    }

    @Override
    @NotNull
    public Annotations getAnnotations() {
        return this.annotations;
    }

    public CapturedType(@NotNull TypeProjection typeProjection, @NotNull CapturedTypeConstructor constructor, boolean isMarkedNullable, @NotNull Annotations annotations2) {
        Intrinsics.checkParameterIsNotNull(typeProjection, "typeProjection");
        Intrinsics.checkParameterIsNotNull(constructor, "constructor");
        Intrinsics.checkParameterIsNotNull(annotations2, "annotations");
        this.typeProjection = typeProjection;
        this.constructor = constructor;
        this.isMarkedNullable = isMarkedNullable;
        this.annotations = annotations2;
    }

    public /* synthetic */ CapturedType(TypeProjection typeProjection, CapturedTypeConstructor capturedTypeConstructor, boolean bl, Annotations annotations2, int n, DefaultConstructorMarker defaultConstructorMarker) {
        if ((n & 2) != 0) {
            capturedTypeConstructor = new CapturedTypeConstructor(typeProjection);
        }
        if ((n & 4) != 0) {
            bl = false;
        }
        if ((n & 8) != 0) {
            annotations2 = Annotations.Companion.getEMPTY();
        }
        this(typeProjection, capturedTypeConstructor, bl, annotations2);
    }
}

