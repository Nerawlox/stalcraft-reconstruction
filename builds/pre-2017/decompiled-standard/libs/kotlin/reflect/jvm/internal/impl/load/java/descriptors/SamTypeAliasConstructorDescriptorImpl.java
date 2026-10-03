/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.load.java.descriptors;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeAliasDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.SimpleFunctionDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.load.java.descriptors.JavaClassDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.descriptors.SamConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.descriptors.SamTypeAliasConstructorDescriptor;
import org.jetbrains.annotations.NotNull;

public final class SamTypeAliasConstructorDescriptorImpl
extends SimpleFunctionDescriptorImpl
implements SamTypeAliasConstructorDescriptor {
    @NotNull
    private final TypeAliasDescriptor typeAliasDescriptor;
    private final SamConstructorDescriptor samInterfaceConstructorDescriptor;

    @Override
    @NotNull
    public JavaClassDescriptor getBaseDescriptorForSynthetic() {
        return (JavaClassDescriptor)this.samInterfaceConstructorDescriptor.getBaseDescriptorForSynthetic();
    }

    @Override
    @NotNull
    public TypeAliasDescriptor getTypeAliasDescriptor() {
        return this.typeAliasDescriptor;
    }

    public SamTypeAliasConstructorDescriptorImpl(@NotNull TypeAliasDescriptor typeAliasDescriptor, @NotNull SamConstructorDescriptor samInterfaceConstructorDescriptor) {
        Intrinsics.checkParameterIsNotNull(typeAliasDescriptor, "typeAliasDescriptor");
        Intrinsics.checkParameterIsNotNull(samInterfaceConstructorDescriptor, "samInterfaceConstructorDescriptor");
        super(typeAliasDescriptor.getContainingDeclaration(), null, ((JavaClassDescriptor)samInterfaceConstructorDescriptor.getBaseDescriptorForSynthetic()).getAnnotations(), typeAliasDescriptor.getName(), CallableMemberDescriptor.Kind.SYNTHESIZED, typeAliasDescriptor.getSource());
        this.typeAliasDescriptor = typeAliasDescriptor;
        this.samInterfaceConstructorDescriptor = samInterfaceConstructorDescriptor;
    }
}

