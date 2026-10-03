/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.descriptors;

import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorNonRoot;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorWithVisibility;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.Visibility;
import org.jetbrains.annotations.NotNull;

public interface MemberDescriptor
extends DeclarationDescriptorNonRoot,
DeclarationDescriptorWithVisibility {
    @NotNull
    public Modality getModality();

    @Override
    @NotNull
    public Visibility getVisibility();

    public boolean isHeader();

    public boolean isImpl();

    public boolean isExternal();
}

