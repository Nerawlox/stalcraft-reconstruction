/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.descriptors;

import java.util.List;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorWithVisibility;
import kotlin.reflect.jvm.internal.impl.descriptors.MemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.ReadOnly;

public interface ClassifierDescriptorWithTypeParameters
extends ClassifierDescriptor,
DeclarationDescriptorWithVisibility,
MemberDescriptor {
    public boolean isInner();

    @ReadOnly
    @NotNull
    public List<TypeParameterDescriptor> getDeclaredTypeParameters();
}

