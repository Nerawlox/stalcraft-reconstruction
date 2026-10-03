/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.resolve.scopes.receivers;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.receivers.ImplicitReceiver;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.receivers.ThisClassReceiver;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class ImplicitClassReceiver
implements ThisClassReceiver,
ImplicitReceiver {
    @NotNull
    private final ClassDescriptor declarationDescriptor;
    @NotNull
    private final ClassDescriptor classDescriptor;

    @Override
    @NotNull
    public SimpleType getType() {
        return this.classDescriptor.getDefaultType();
    }

    @Override
    @NotNull
    public ClassDescriptor getDeclarationDescriptor() {
        return this.declarationDescriptor;
    }

    public boolean equals(@Nullable Object other) {
        Object object = other;
        if (!(object instanceof ImplicitClassReceiver)) {
            object = null;
        }
        ImplicitClassReceiver implicitClassReceiver = (ImplicitClassReceiver)object;
        return Intrinsics.areEqual(this.classDescriptor, implicitClassReceiver != null ? implicitClassReceiver.classDescriptor : null);
    }

    public int hashCode() {
        return this.classDescriptor.hashCode();
    }

    @NotNull
    public String toString() {
        return "Class{" + this.getType() + "}";
    }

    @Override
    @NotNull
    public final ClassDescriptor getClassDescriptor() {
        return this.classDescriptor;
    }

    public ImplicitClassReceiver(@NotNull ClassDescriptor classDescriptor) {
        Intrinsics.checkParameterIsNotNull(classDescriptor, "classDescriptor");
        this.declarationDescriptor = this.classDescriptor = classDescriptor;
    }
}

