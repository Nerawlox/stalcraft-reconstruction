/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.resolve.scopes;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.DescriptorKindFilter;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScopeKt;
import org.jetbrains.annotations.NotNull;

public final class MemberScopeKt {
    /*
     * Unable to fully structure code
     */
    @NotNull
    public static final Collection<DeclarationDescriptor> getDescriptorsFiltered(@NotNull MemberScope $receiver, @NotNull DescriptorKindFilter kindFilter, @NotNull Function1<? super Name, Boolean> nameFilter) {
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        Intrinsics.checkParameterIsNotNull(kindFilter, "kindFilter");
        Intrinsics.checkParameterIsNotNull(nameFilter, "nameFilter");
        if (kindFilter.getKindMask() == 0) {
            return CollectionsKt.emptyList();
        }
        var4_4 = $receiver$iv = (Iterable)$receiver.getContributedDescriptors(kindFilter, nameFilter);
        destination$iv$iv = new ArrayList<E>();
        for (T element$iv$iv : $receiver$iv$iv) {
            it = (DeclarationDescriptor)element$iv$iv;
            if (!kindFilter.accepts(it)) ** GOTO lbl-1000
            v0 = it.getName();
            Intrinsics.checkExpressionValueIsNotNull(v0, "it.name");
            if (nameFilter.invoke(v0).booleanValue()) {
                v1 = true;
            } else lbl-1000:
            // 2 sources

            {
                v1 = false;
            }
            if (!v1) continue;
            destination$iv$iv.add(element$iv$iv);
        }
        return (List)destination$iv$iv;
    }

    @NotNull
    public static /* bridge */ /* synthetic */ Collection getDescriptorsFiltered$default(MemberScope memberScope2, DescriptorKindFilter descriptorKindFilter, Function1 function1, int n, Object object) {
        if ((n & 1) != 0) {
            descriptorKindFilter = DescriptorKindFilter.ALL;
        }
        if ((n & 2) != 0) {
            function1 = getDescriptorsFiltered.1.INSTANCE;
        }
        return MemberScopeKt.getDescriptorsFiltered(memberScope2, descriptorKindFilter, function1);
    }
}

