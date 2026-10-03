/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.descriptors;

import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ConstructorDescriptor;
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

public interface DeclarationDescriptorVisitor<R, D> {
    public R visitPackageFragmentDescriptor(PackageFragmentDescriptor var1, D var2);

    public R visitPackageViewDescriptor(PackageViewDescriptor var1, D var2);

    public R visitVariableDescriptor(VariableDescriptor var1, D var2);

    public R visitFunctionDescriptor(FunctionDescriptor var1, D var2);

    public R visitTypeParameterDescriptor(TypeParameterDescriptor var1, D var2);

    public R visitClassDescriptor(ClassDescriptor var1, D var2);

    public R visitTypeAliasDescriptor(TypeAliasDescriptor var1, D var2);

    public R visitModuleDeclaration(ModuleDescriptor var1, D var2);

    public R visitConstructorDescriptor(ConstructorDescriptor var1, D var2);

    public R visitScriptDescriptor(ScriptDescriptor var1, D var2);

    public R visitPropertyDescriptor(PropertyDescriptor var1, D var2);

    public R visitValueParameterDescriptor(ValueParameterDescriptor var1, D var2);

    public R visitPropertyGetterDescriptor(PropertyGetterDescriptor var1, D var2);

    public R visitPropertySetterDescriptor(PropertySetterDescriptor var1, D var2);

    public R visitReceiverParameterDescriptor(ReceiverParameterDescriptor var1, D var2);
}

