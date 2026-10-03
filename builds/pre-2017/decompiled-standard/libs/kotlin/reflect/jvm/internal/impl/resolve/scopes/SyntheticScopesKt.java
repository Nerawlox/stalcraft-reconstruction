/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.resolve.scopes;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.incremental.components.LookupLocation;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.SyntheticScope;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.SyntheticScopes;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import org.jetbrains.annotations.NotNull;

public final class SyntheticScopesKt {
    /*
     * WARNING - void declaration
     */
    @NotNull
    public static final List<PropertyDescriptor> collectSyntheticExtensionProperties(@NotNull SyntheticScopes $receiver, @NotNull Collection<? extends KotlinType> receiverTypes, @NotNull Name name2, @NotNull LookupLocation location) {
        void $receiver$iv$iv;
        Iterable $receiver$iv;
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        Intrinsics.checkParameterIsNotNull(receiverTypes, "receiverTypes");
        Intrinsics.checkParameterIsNotNull(name2, "name");
        Intrinsics.checkParameterIsNotNull(location, "location");
        Iterable iterable = $receiver$iv = (Iterable)$receiver.getScopes();
        Collection destination$iv$iv = new ArrayList();
        for (Object element$iv$iv : $receiver$iv$iv) {
            SyntheticScope it = (SyntheticScope)element$iv$iv;
            Iterable list$iv$iv = it.getSyntheticExtensionProperties(receiverTypes, name2, location);
            CollectionsKt.addAll(destination$iv$iv, list$iv$iv);
        }
        return (List)destination$iv$iv;
    }

    /*
     * WARNING - void declaration
     */
    @NotNull
    public static final List<FunctionDescriptor> collectSyntheticMemberFunctions(@NotNull SyntheticScopes $receiver, @NotNull Collection<? extends KotlinType> receiverTypes, @NotNull Name name2, @NotNull LookupLocation location) {
        void $receiver$iv$iv;
        Iterable $receiver$iv;
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        Intrinsics.checkParameterIsNotNull(receiverTypes, "receiverTypes");
        Intrinsics.checkParameterIsNotNull(name2, "name");
        Intrinsics.checkParameterIsNotNull(location, "location");
        Iterable iterable = $receiver$iv = (Iterable)$receiver.getScopes();
        Collection destination$iv$iv = new ArrayList();
        for (Object element$iv$iv : $receiver$iv$iv) {
            SyntheticScope it = (SyntheticScope)element$iv$iv;
            Iterable list$iv$iv = it.getSyntheticMemberFunctions(receiverTypes, name2, location);
            CollectionsKt.addAll(destination$iv$iv, list$iv$iv);
        }
        return (List)destination$iv$iv;
    }

    /*
     * WARNING - void declaration
     */
    @NotNull
    public static final List<PropertyDescriptor> collectSyntheticExtensionProperties(@NotNull SyntheticScopes $receiver, @NotNull Collection<? extends KotlinType> receiverTypes) {
        void $receiver$iv$iv;
        Iterable $receiver$iv;
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        Intrinsics.checkParameterIsNotNull(receiverTypes, "receiverTypes");
        Iterable iterable = $receiver$iv = (Iterable)$receiver.getScopes();
        Collection destination$iv$iv = new ArrayList();
        for (Object element$iv$iv : $receiver$iv$iv) {
            SyntheticScope it = (SyntheticScope)element$iv$iv;
            Iterable list$iv$iv = it.getSyntheticExtensionProperties(receiverTypes);
            CollectionsKt.addAll(destination$iv$iv, list$iv$iv);
        }
        return (List)destination$iv$iv;
    }

    /*
     * WARNING - void declaration
     */
    @NotNull
    public static final List<FunctionDescriptor> collectSyntheticMemberFunctions(@NotNull SyntheticScopes $receiver, @NotNull Collection<? extends KotlinType> receiverTypes) {
        void $receiver$iv$iv;
        Iterable $receiver$iv;
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        Intrinsics.checkParameterIsNotNull(receiverTypes, "receiverTypes");
        Iterable iterable = $receiver$iv = (Iterable)$receiver.getScopes();
        Collection destination$iv$iv = new ArrayList();
        for (Object element$iv$iv : $receiver$iv$iv) {
            SyntheticScope it = (SyntheticScope)element$iv$iv;
            Iterable list$iv$iv = it.getSyntheticMemberFunctions(receiverTypes);
            CollectionsKt.addAll(destination$iv$iv, list$iv$iv);
        }
        return (List)destination$iv$iv;
    }
}

