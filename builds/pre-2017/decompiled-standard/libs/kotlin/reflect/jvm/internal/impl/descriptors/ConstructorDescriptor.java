/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.descriptors;

import java.util.List;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptorWithTypeParameters;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Visibility;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public interface ConstructorDescriptor
extends FunctionDescriptor {
    @Override
    @NotNull
    public List<TypeParameterDescriptor> getTypeParameters();

    @Override
    @NotNull
    public KotlinType getReturnType();

    @Override
    @NotNull
    public ClassifierDescriptorWithTypeParameters getContainingDeclaration();

    @NotNull
    public ClassDescriptor getConstructedClass();

    @Override
    @NotNull
    public ConstructorDescriptor getOriginal();

    @Override
    @Nullable
    public ConstructorDescriptor substitute(@NotNull TypeSubstitutor var1);

    @Override
    @NotNull
    public Name getName();

    @Override
    @NotNull
    public ConstructorDescriptor copy(DeclarationDescriptor var1, Modality var2, Visibility var3, CallableMemberDescriptor.Kind var4, boolean var5);

    public boolean isPrimary();
}

