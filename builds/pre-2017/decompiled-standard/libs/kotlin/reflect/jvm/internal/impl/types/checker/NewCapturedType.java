/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.types.checker;

import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.types.ErrorUtils;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import kotlin.reflect.jvm.internal.impl.types.UnwrappedType;
import kotlin.reflect.jvm.internal.impl.types.checker.CaptureStatus;
import kotlin.reflect.jvm.internal.impl.types.checker.NewCapturedTypeConstructor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class NewCapturedType
extends SimpleType {
    @NotNull
    private final CaptureStatus captureStatus;
    @NotNull
    private final NewCapturedTypeConstructor constructor;
    @Nullable
    private final UnwrappedType lowerType;
    @NotNull
    private final Annotations annotations;
    private final boolean isMarkedNullable;

    @Override
    @NotNull
    public List<TypeProjection> getArguments() {
        return CollectionsKt.emptyList();
    }

    @Override
    @NotNull
    public MemberScope getMemberScope() {
        MemberScope memberScope2 = ErrorUtils.createErrorScope("No member resolution should be done on captured type!", true);
        Intrinsics.checkExpressionValueIsNotNull(memberScope2, "ErrorUtils.createErrorSc\u2026on captured type!\", true)");
        return memberScope2;
    }

    @Override
    public boolean isError() {
        return false;
    }

    @Override
    @NotNull
    public NewCapturedType replaceAnnotations(@NotNull Annotations newAnnotations) {
        Intrinsics.checkParameterIsNotNull(newAnnotations, "newAnnotations");
        return new NewCapturedType(this.captureStatus, this.getConstructor(), this.lowerType, newAnnotations, this.isMarkedNullable());
    }

    @Override
    @NotNull
    public NewCapturedType makeNullableAsSpecified(boolean newNullability) {
        return new NewCapturedType(this.captureStatus, this.getConstructor(), this.lowerType, this.getAnnotations(), newNullability);
    }

    @NotNull
    public final CaptureStatus getCaptureStatus() {
        return this.captureStatus;
    }

    @Override
    @NotNull
    public NewCapturedTypeConstructor getConstructor() {
        return this.constructor;
    }

    @Nullable
    public final UnwrappedType getLowerType() {
        return this.lowerType;
    }

    @Override
    @NotNull
    public Annotations getAnnotations() {
        return this.annotations;
    }

    @Override
    public boolean isMarkedNullable() {
        return this.isMarkedNullable;
    }

    public NewCapturedType(@NotNull CaptureStatus captureStatus, @NotNull NewCapturedTypeConstructor constructor, @Nullable UnwrappedType lowerType2, @NotNull Annotations annotations2, boolean isMarkedNullable) {
        Intrinsics.checkParameterIsNotNull((Object)captureStatus, "captureStatus");
        Intrinsics.checkParameterIsNotNull(constructor, "constructor");
        Intrinsics.checkParameterIsNotNull(annotations2, "annotations");
        this.captureStatus = captureStatus;
        this.constructor = constructor;
        this.lowerType = lowerType2;
        this.annotations = annotations2;
        this.isMarkedNullable = isMarkedNullable;
    }

    public /* synthetic */ NewCapturedType(CaptureStatus captureStatus, NewCapturedTypeConstructor newCapturedTypeConstructor, UnwrappedType unwrappedType, Annotations annotations2, boolean bl, int n, DefaultConstructorMarker defaultConstructorMarker) {
        if ((n & 8) != 0) {
            annotations2 = Annotations.Companion.getEMPTY();
        }
        if ((n & 0x10) != 0) {
            bl = false;
        }
        this(captureStatus, newCapturedTypeConstructor, unwrappedType, annotations2, bl);
    }

    public NewCapturedType(@NotNull CaptureStatus captureStatus, @Nullable UnwrappedType lowerType2, @NotNull TypeProjection projection) {
        Intrinsics.checkParameterIsNotNull((Object)captureStatus, "captureStatus");
        Intrinsics.checkParameterIsNotNull(projection, "projection");
        this(captureStatus, new NewCapturedTypeConstructor(projection, null, 2, null), lowerType2, null, false, 24, null);
    }
}

