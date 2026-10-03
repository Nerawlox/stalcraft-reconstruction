/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.types;

import java.util.Collection;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jetbrains.annotations.ReadOnly;

public interface TypeConstructor {
    @NotNull
    @ReadOnly
    public List<TypeParameterDescriptor> getParameters();

    @NotNull
    @ReadOnly
    public Collection<KotlinType> getSupertypes();

    public boolean isFinal();

    public boolean isDenotable();

    @Nullable
    public ClassifierDescriptor getDeclarationDescriptor();

    @NotNull
    public KotlinBuiltIns getBuiltIns();
}

