/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.load.java.components;

import java.util.Collections;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaMethod;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public interface SignaturePropagator {
    public static final SignaturePropagator DO_NOTHING = new SignaturePropagator(){

        @Override
        @NotNull
        public PropagatedSignature resolvePropagatedSignature(@NotNull JavaMethod method, @NotNull ClassDescriptor owner, @NotNull KotlinType returnType, @Nullable KotlinType receiverType, @NotNull List<ValueParameterDescriptor> valueParameters, @NotNull List<TypeParameterDescriptor> typeParameters2) {
            if (method == null) {
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "method", "kotlin/reflect/jvm/internal/impl/load/java/components/SignaturePropagator$1", "resolvePropagatedSignature"));
            }
            if (owner == null) {
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "owner", "kotlin/reflect/jvm/internal/impl/load/java/components/SignaturePropagator$1", "resolvePropagatedSignature"));
            }
            if (returnType == null) {
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "returnType", "kotlin/reflect/jvm/internal/impl/load/java/components/SignaturePropagator$1", "resolvePropagatedSignature"));
            }
            if (valueParameters == null) {
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "valueParameters", "kotlin/reflect/jvm/internal/impl/load/java/components/SignaturePropagator$1", "resolvePropagatedSignature"));
            }
            if (typeParameters2 == null) {
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "typeParameters", "kotlin/reflect/jvm/internal/impl/load/java/components/SignaturePropagator$1", "resolvePropagatedSignature"));
            }
            PropagatedSignature propagatedSignature = new PropagatedSignature(returnType, receiverType, valueParameters, typeParameters2, Collections.<String>emptyList(), false);
            if (propagatedSignature == null) {
                throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/load/java/components/SignaturePropagator$1", "resolvePropagatedSignature"));
            }
            return propagatedSignature;
        }

        @Override
        public void reportSignatureErrors(@NotNull CallableMemberDescriptor descriptor2, @NotNull List<String> signatureErrors) {
            if (descriptor2 == null) {
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "descriptor", "kotlin/reflect/jvm/internal/impl/load/java/components/SignaturePropagator$1", "reportSignatureErrors"));
            }
            if (signatureErrors == null) {
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "signatureErrors", "kotlin/reflect/jvm/internal/impl/load/java/components/SignaturePropagator$1", "reportSignatureErrors"));
            }
            throw new UnsupportedOperationException("Should not be called");
        }
    };

    @NotNull
    public PropagatedSignature resolvePropagatedSignature(@NotNull JavaMethod var1, @NotNull ClassDescriptor var2, @NotNull KotlinType var3, @Nullable KotlinType var4, @NotNull List<ValueParameterDescriptor> var5, @NotNull List<TypeParameterDescriptor> var6);

    public void reportSignatureErrors(@NotNull CallableMemberDescriptor var1, @NotNull List<String> var2);

    public static class PropagatedSignature {
        private final KotlinType returnType;
        private final KotlinType receiverType;
        private final List<ValueParameterDescriptor> valueParameters;
        private final List<TypeParameterDescriptor> typeParameters;
        private final List<String> signatureErrors;
        private final boolean hasStableParameterNames;

        public PropagatedSignature(@NotNull KotlinType returnType, @Nullable KotlinType receiverType, @NotNull List<ValueParameterDescriptor> valueParameters, @NotNull List<TypeParameterDescriptor> typeParameters2, @NotNull List<String> signatureErrors, boolean hasStableParameterNames) {
            if (returnType == null) {
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "returnType", "kotlin/reflect/jvm/internal/impl/load/java/components/SignaturePropagator$PropagatedSignature", "<init>"));
            }
            if (valueParameters == null) {
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "valueParameters", "kotlin/reflect/jvm/internal/impl/load/java/components/SignaturePropagator$PropagatedSignature", "<init>"));
            }
            if (typeParameters2 == null) {
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "typeParameters", "kotlin/reflect/jvm/internal/impl/load/java/components/SignaturePropagator$PropagatedSignature", "<init>"));
            }
            if (signatureErrors == null) {
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "signatureErrors", "kotlin/reflect/jvm/internal/impl/load/java/components/SignaturePropagator$PropagatedSignature", "<init>"));
            }
            this.returnType = returnType;
            this.receiverType = receiverType;
            this.valueParameters = valueParameters;
            this.typeParameters = typeParameters2;
            this.signatureErrors = signatureErrors;
            this.hasStableParameterNames = hasStableParameterNames;
        }

        @NotNull
        public KotlinType getReturnType() {
            KotlinType kotlinType = this.returnType;
            if (kotlinType == null) {
                throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/load/java/components/SignaturePropagator$PropagatedSignature", "getReturnType"));
            }
            return kotlinType;
        }

        @Nullable
        public KotlinType getReceiverType() {
            return this.receiverType;
        }

        @NotNull
        public List<ValueParameterDescriptor> getValueParameters() {
            List<ValueParameterDescriptor> list = this.valueParameters;
            if (list == null) {
                throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/load/java/components/SignaturePropagator$PropagatedSignature", "getValueParameters"));
            }
            return list;
        }

        @NotNull
        public List<TypeParameterDescriptor> getTypeParameters() {
            List<TypeParameterDescriptor> list = this.typeParameters;
            if (list == null) {
                throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/load/java/components/SignaturePropagator$PropagatedSignature", "getTypeParameters"));
            }
            return list;
        }

        public boolean hasStableParameterNames() {
            return this.hasStableParameterNames;
        }

        @NotNull
        public List<String> getErrors() {
            List<String> list = this.signatureErrors;
            if (list == null) {
                throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/load/java/components/SignaturePropagator$PropagatedSignature", "getErrors"));
            }
            return list;
        }
    }
}

