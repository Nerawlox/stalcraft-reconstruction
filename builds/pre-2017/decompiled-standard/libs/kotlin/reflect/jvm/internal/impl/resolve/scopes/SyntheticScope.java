/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.resolve.scopes;

import java.util.Collection;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.incremental.components.LookupLocation;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import org.jetbrains.annotations.NotNull;

public interface SyntheticScope {
    @NotNull
    public Collection<PropertyDescriptor> getSyntheticExtensionProperties(@NotNull Collection<? extends KotlinType> var1, @NotNull Name var2, @NotNull LookupLocation var3);

    @NotNull
    public Collection<FunctionDescriptor> getSyntheticMemberFunctions(@NotNull Collection<? extends KotlinType> var1, @NotNull Name var2, @NotNull LookupLocation var3);

    @NotNull
    public Collection<PropertyDescriptor> getSyntheticExtensionProperties(@NotNull Collection<? extends KotlinType> var1);

    @NotNull
    public Collection<FunctionDescriptor> getSyntheticMemberFunctions(@NotNull Collection<? extends KotlinType> var1);
}

