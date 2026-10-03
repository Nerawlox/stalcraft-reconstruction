/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.resolve.scopes.receivers;

import kotlin.reflect.jvm.internal.impl.resolve.scopes.receivers.ReceiverValue;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import org.jetbrains.annotations.NotNull;

public abstract class AbstractReceiverValue
implements ReceiverValue {
    protected final KotlinType receiverType;

    public AbstractReceiverValue(@NotNull KotlinType receiverType) {
        if (receiverType == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "receiverType", "kotlin/reflect/jvm/internal/impl/resolve/scopes/receivers/AbstractReceiverValue", "<init>"));
        }
        this.receiverType = receiverType;
    }

    @Override
    @NotNull
    public KotlinType getType() {
        KotlinType kotlinType = this.receiverType;
        if (kotlinType == null) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/resolve/scopes/receivers/AbstractReceiverValue", "getType"));
        }
        return kotlinType;
    }
}

