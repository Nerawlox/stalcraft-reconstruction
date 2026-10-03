/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.descriptors;

import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.Visibility;
import org.jetbrains.annotations.NotNull;

public interface SimpleFunctionDescriptor
extends FunctionDescriptor {
    @Override
    @NotNull
    public SimpleFunctionDescriptor copy(DeclarationDescriptor var1, Modality var2, Visibility var3, CallableMemberDescriptor.Kind var4, boolean var5);

    @Override
    @NotNull
    public SimpleFunctionDescriptor getOriginal();

    @NotNull
    public FunctionDescriptor.CopyBuilder<? extends SimpleFunctionDescriptor> newCopyBuilder();
}

