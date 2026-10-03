/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.descriptors;

import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorVisitor;
import kotlin.reflect.jvm.internal.impl.descriptors.Named;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotated;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public interface DeclarationDescriptor
extends Annotated,
Named {
    @NotNull
    public DeclarationDescriptor getOriginal();

    @Nullable
    public DeclarationDescriptor getContainingDeclaration();

    @Nullable
    public DeclarationDescriptor substitute(@NotNull TypeSubstitutor var1);

    public <R, D> R accept(DeclarationDescriptorVisitor<R, D> var1, D var2);

    public void acceptVoid(DeclarationDescriptorVisitor<Void, Void> var1);
}

