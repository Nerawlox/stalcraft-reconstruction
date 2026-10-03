/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.types;

import kotlin.NoWhenBranchMatchedException;
import kotlin._Assertions;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.renderer.DescriptorRenderer;
import kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererOptions;
import kotlin.reflect.jvm.internal.impl.types.CustomTypeVariable;
import kotlin.reflect.jvm.internal.impl.types.FlexibleType;
import kotlin.reflect.jvm.internal.impl.types.FlexibleTypesKt;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.UnwrappedType;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeChecker;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;
import org.jetbrains.annotations.NotNull;

public final class FlexibleTypeImpl
extends FlexibleType
implements CustomTypeVariable {
    private boolean assertionsDone;
    @JvmField
    public static boolean RUN_SLOW_ASSERTIONS;
    public static final Companion Companion;

    private final void runAssertions() {
        boolean bl;
        if (!RUN_SLOW_ASSERTIONS || this.assertionsDone) {
            return;
        }
        this.assertionsDone = true;
        boolean bl2 = bl = !FlexibleTypesKt.isFlexible(this.getLowerBound());
        if (_Assertions.ENABLED && !bl) {
            String string = "Lower bound of a flexible type can not be flexible: " + this.getLowerBound();
            throw (Throwable)((Object)new AssertionError((Object)string));
        }
        boolean bl3 = bl = !FlexibleTypesKt.isFlexible(this.getUpperBound());
        if (_Assertions.ENABLED && !bl) {
            String string = "Upper bound of a flexible type can not be flexible: " + this.getUpperBound();
            throw (Throwable)((Object)new AssertionError((Object)string));
        }
        bl = Intrinsics.areEqual(this.getLowerBound(), this.getUpperBound()) ^ true;
        if (_Assertions.ENABLED && !bl) {
            String string = "Lower and upper bounds are equal: " + this.getLowerBound() + " == " + this.getUpperBound();
            throw (Throwable)((Object)new AssertionError((Object)string));
        }
        bl = KotlinTypeChecker.DEFAULT.isSubtypeOf(this.getLowerBound(), this.getUpperBound());
        if (_Assertions.ENABLED && !bl) {
            String string = "Lower bound " + this.getLowerBound() + " of a flexible type must be a subtype of the upper bound " + this.getUpperBound();
            throw (Throwable)((Object)new AssertionError((Object)string));
        }
    }

    @Override
    @NotNull
    public SimpleType getDelegate() {
        this.runAssertions();
        return this.getLowerBound();
    }

    @Override
    public boolean isTypeVariable() {
        return this.getLowerBound().getConstructor().getDeclarationDescriptor() instanceof TypeParameterDescriptor && Intrinsics.areEqual(this.getLowerBound().getConstructor(), this.getUpperBound().getConstructor());
    }

    @Override
    @NotNull
    public KotlinType substitutionResult(@NotNull KotlinType replacement) {
        KotlinType kotlinType;
        UnwrappedType unwrapped;
        Intrinsics.checkParameterIsNotNull(replacement, "replacement");
        UnwrappedType unwrappedType = unwrapped = replacement.unwrap();
        if (unwrappedType instanceof FlexibleType) {
            kotlinType = unwrapped;
        } else if (unwrappedType instanceof SimpleType) {
            kotlinType = KotlinTypeFactory.flexibleType((SimpleType)unwrapped, ((SimpleType)unwrapped).makeNullableAsSpecified(true));
        } else {
            throw new NoWhenBranchMatchedException();
        }
        return kotlinType;
    }

    @Override
    @NotNull
    public UnwrappedType replaceAnnotations(@NotNull Annotations newAnnotations) {
        Intrinsics.checkParameterIsNotNull(newAnnotations, "newAnnotations");
        return KotlinTypeFactory.flexibleType(this.getLowerBound().replaceAnnotations(newAnnotations), this.getUpperBound().replaceAnnotations(newAnnotations));
    }

    @Override
    @NotNull
    public String render(@NotNull DescriptorRenderer renderer, @NotNull DescriptorRendererOptions options) {
        Intrinsics.checkParameterIsNotNull(renderer, "renderer");
        Intrinsics.checkParameterIsNotNull(options, "options");
        if (options.getDebugMode()) {
            return "(" + renderer.renderType(this.getLowerBound()) + ".." + renderer.renderType(this.getUpperBound()) + ")";
        }
        return renderer.renderFlexibleType(renderer.renderType(this.getLowerBound()), renderer.renderType(this.getUpperBound()), TypeUtilsKt.getBuiltIns(this));
    }

    @Override
    @NotNull
    public UnwrappedType makeNullableAsSpecified(boolean newNullability) {
        return KotlinTypeFactory.flexibleType(this.getLowerBound().makeNullableAsSpecified(newNullability), this.getUpperBound().makeNullableAsSpecified(newNullability));
    }

    public FlexibleTypeImpl(@NotNull SimpleType lowerBound, @NotNull SimpleType upperBound) {
        Intrinsics.checkParameterIsNotNull(lowerBound, "lowerBound");
        Intrinsics.checkParameterIsNotNull(upperBound, "upperBound");
        super(lowerBound, upperBound);
    }

    static {
        Companion = new Companion(null);
    }

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }
}

