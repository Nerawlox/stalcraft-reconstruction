/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.resolve.constants;

import kotlin.Deprecated;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationArgumentVisitor;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue;
import kotlin.reflect.jvm.internal.impl.types.ErrorUtils;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import org.jetbrains.annotations.NotNull;

public abstract class ErrorValue
extends ConstantValue<Unit> {
    public static final Companion Companion = new Companion(null);

    @Deprecated(message="Should not be called, for this is not a real value, but a indication of an error")
    private static /* synthetic */ void value$annotations() {
    }

    @Override
    @NotNull
    public Unit getValue() {
        throw (Throwable)new UnsupportedOperationException();
    }

    @Override
    public <R, D> R accept(@NotNull AnnotationArgumentVisitor<R, D> visitor2, D data2) {
        Intrinsics.checkParameterIsNotNull(visitor2, "visitor");
        return visitor2.visitErrorValue(this, data2);
    }

    public ErrorValue() {
        super(Unit.INSTANCE);
    }

    public static final class ErrorValueWithMessage
    extends ErrorValue {
        @NotNull
        private final SimpleType type;
        @NotNull
        private final String message;

        @Override
        @NotNull
        public SimpleType getType() {
            return this.type;
        }

        @Override
        @NotNull
        public String toString() {
            return this.message;
        }

        @NotNull
        public final String getMessage() {
            return this.message;
        }

        public ErrorValueWithMessage(@NotNull String message) {
            Intrinsics.checkParameterIsNotNull(message, "message");
            this.message = message;
            this.type = ErrorUtils.createErrorType(this.message);
        }
    }

    public static final class Companion {
        @NotNull
        public final ErrorValue create(@NotNull String message) {
            Intrinsics.checkParameterIsNotNull(message, "message");
            return new ErrorValueWithMessage(message);
        }

        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }
}

