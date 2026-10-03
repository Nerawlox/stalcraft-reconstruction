/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.resolve.constants;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import org.jetbrains.annotations.NotNull;

public interface CompileTimeConstant<T> {
    public boolean isError();

    @NotNull
    public Parameters getParameters();

    @NotNull
    public ConstantValue<T> toConstantValue(@NotNull KotlinType var1);

    public T getValue(@NotNull KotlinType var1);

    public boolean getCanBeUsedInAnnotations();

    public boolean getUsesVariableAsConstant();

    public boolean getUsesNonConstValAsConstant();

    public boolean isPure();

    public static final class Parameters {
        private final boolean canBeUsedInAnnotation;
        private final boolean isPure;
        private final boolean usesVariableAsConstant;
        private final boolean usesNonConstValAsConstant;

        public final boolean getCanBeUsedInAnnotation() {
            return this.canBeUsedInAnnotation;
        }

        public final boolean isPure() {
            return this.isPure;
        }

        public final boolean getUsesVariableAsConstant() {
            return this.usesVariableAsConstant;
        }

        public final boolean getUsesNonConstValAsConstant() {
            return this.usesNonConstValAsConstant;
        }

        public Parameters(boolean canBeUsedInAnnotation, boolean isPure, boolean usesVariableAsConstant, boolean usesNonConstValAsConstant) {
            this.canBeUsedInAnnotation = canBeUsedInAnnotation;
            this.isPure = isPure;
            this.usesVariableAsConstant = usesVariableAsConstant;
            this.usesNonConstValAsConstant = usesNonConstValAsConstant;
        }
    }

    public static final class DefaultImpls {
        public static <T> boolean isError(CompileTimeConstant<? extends T> $this) {
            return false;
        }

        public static <T> T getValue(@NotNull CompileTimeConstant<? extends T> $this, KotlinType expectedType) {
            Intrinsics.checkParameterIsNotNull(expectedType, "expectedType");
            return $this.toConstantValue(expectedType).getValue();
        }

        public static <T> boolean getCanBeUsedInAnnotations(CompileTimeConstant<? extends T> $this) {
            return $this.getParameters().getCanBeUsedInAnnotation();
        }

        public static <T> boolean getUsesVariableAsConstant(CompileTimeConstant<? extends T> $this) {
            return $this.getParameters().getUsesVariableAsConstant();
        }

        public static <T> boolean getUsesNonConstValAsConstant(CompileTimeConstant<? extends T> $this) {
            return $this.getParameters().getUsesNonConstValAsConstant();
        }

        public static <T> boolean isPure(CompileTimeConstant<? extends T> $this) {
            return $this.getParameters().isPure();
        }
    }
}

