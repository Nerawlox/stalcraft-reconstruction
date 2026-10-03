/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorVisitor;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageViewDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyGetterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertySetterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ScriptDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeAliasDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.VariableDescriptor;

public class DeclarationDescriptorVisitorEmptyBodies<R, D>
implements DeclarationDescriptorVisitor<R, D> {
    public R visitDeclarationDescriptor(DeclarationDescriptor descriptor2, D data2) {
        return null;
    }

    @Override
    public R visitVariableDescriptor(VariableDescriptor descriptor2, D data2) {
        return this.visitDeclarationDescriptor(descriptor2, data2);
    }

    @Override
    public R visitFunctionDescriptor(FunctionDescriptor descriptor2, D data2) {
        return this.visitDeclarationDescriptor(descriptor2, data2);
    }

    @Override
    public R visitTypeParameterDescriptor(TypeParameterDescriptor descriptor2, D data2) {
        return this.visitDeclarationDescriptor(descriptor2, data2);
    }

    @Override
    public R visitPackageFragmentDescriptor(PackageFragmentDescriptor descriptor2, D data2) {
        return this.visitDeclarationDescriptor(descriptor2, data2);
    }

    @Override
    public R visitPackageViewDescriptor(PackageViewDescriptor descriptor2, D data2) {
        return this.visitDeclarationDescriptor(descriptor2, data2);
    }

    @Override
    public R visitClassDescriptor(ClassDescriptor descriptor2, D data2) {
        return this.visitDeclarationDescriptor(descriptor2, data2);
    }

    @Override
    public R visitTypeAliasDescriptor(TypeAliasDescriptor descriptor2, D data2) {
        return this.visitDeclarationDescriptor(descriptor2, data2);
    }

    @Override
    public R visitModuleDeclaration(ModuleDescriptor descriptor2, D data2) {
        return this.visitDeclarationDescriptor(descriptor2, data2);
    }

    @Override
    public R visitConstructorDescriptor(ConstructorDescriptor constructorDescriptor, D data2) {
        return this.visitFunctionDescriptor(constructorDescriptor, data2);
    }

    @Override
    public R visitScriptDescriptor(ScriptDescriptor scriptDescriptor, D data2) {
        return this.visitClassDescriptor(scriptDescriptor, data2);
    }

    @Override
    public R visitPropertyDescriptor(PropertyDescriptor descriptor2, D data2) {
        return this.visitVariableDescriptor(descriptor2, data2);
    }

    @Override
    public R visitValueParameterDescriptor(ValueParameterDescriptor descriptor2, D data2) {
        return this.visitVariableDescriptor(descriptor2, data2);
    }

    @Override
    public R visitPropertyGetterDescriptor(PropertyGetterDescriptor descriptor2, D data2) {
        return this.visitFunctionDescriptor(descriptor2, data2);
    }

    @Override
    public R visitPropertySetterDescriptor(PropertySetterDescriptor descriptor2, D data2) {
        return this.visitFunctionDescriptor(descriptor2, data2);
    }

    @Override
    public R visitReceiverParameterDescriptor(ReceiverParameterDescriptor descriptor2, D data2) {
        return this.visitDeclarationDescriptor(descriptor2, data2);
    }
}

