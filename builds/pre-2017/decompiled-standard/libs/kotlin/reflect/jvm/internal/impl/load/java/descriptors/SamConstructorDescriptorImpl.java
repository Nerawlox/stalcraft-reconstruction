/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.load.java.descriptors;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.SimpleFunctionDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.load.java.descriptors.JavaClassDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.descriptors.SamConstructorDescriptor;
import org.jetbrains.annotations.NotNull;

public final class SamConstructorDescriptorImpl
extends SimpleFunctionDescriptorImpl
implements SamConstructorDescriptor {
    private final JavaClassDescriptor samInterface;

    @Override
    @NotNull
    public JavaClassDescriptor getBaseDescriptorForSynthetic() {
        return this.samInterface;
    }

    public SamConstructorDescriptorImpl(@NotNull DeclarationDescriptor containingDeclaration, @NotNull JavaClassDescriptor samInterface) {
        Intrinsics.checkParameterIsNotNull(containingDeclaration, "containingDeclaration");
        Intrinsics.checkParameterIsNotNull(samInterface, "samInterface");
        super(containingDeclaration, null, samInterface.getAnnotations(), samInterface.getName(), CallableMemberDescriptor.Kind.SYNTHESIZED, samInterface.getSource());
        this.samInterface = samInterface;
    }
}

