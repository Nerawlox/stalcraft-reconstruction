/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.resolve.scopes.receivers;

import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.receivers.AbstractReceiverValue;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.receivers.ImplicitReceiver;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import org.jetbrains.annotations.NotNull;

public class ExtensionReceiver
extends AbstractReceiverValue
implements ImplicitReceiver {
    private final CallableDescriptor descriptor;

    public ExtensionReceiver(@NotNull CallableDescriptor callableDescriptor, @NotNull KotlinType receiverType) {
        if (callableDescriptor == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "callableDescriptor", "kotlin/reflect/jvm/internal/impl/resolve/scopes/receivers/ExtensionReceiver", "<init>"));
        }
        if (receiverType == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "receiverType", "kotlin/reflect/jvm/internal/impl/resolve/scopes/receivers/ExtensionReceiver", "<init>"));
        }
        super(receiverType);
        this.descriptor = callableDescriptor;
    }

    @Override
    @NotNull
    public CallableDescriptor getDeclarationDescriptor() {
        CallableDescriptor callableDescriptor = this.descriptor;
        if (callableDescriptor == null) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/resolve/scopes/receivers/ExtensionReceiver", "getDeclarationDescriptor"));
        }
        return callableDescriptor;
    }

    public String toString() {
        return this.getType() + ": Ext {" + this.descriptor + "}";
    }
}

