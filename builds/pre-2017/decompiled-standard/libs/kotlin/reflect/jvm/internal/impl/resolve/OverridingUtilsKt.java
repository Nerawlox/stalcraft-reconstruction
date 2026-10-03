/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.resolve;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;
import kotlin.reflect.jvm.internal.impl.resolve.OverridingUtil;
import kotlin.reflect.jvm.internal.impl.resolve.OverridingUtilsKt;
import kotlin.reflect.jvm.internal.impl.utils.DFS;
import kotlin.reflect.jvm.internal.impl.utils.SmartSet;
import org.jetbrains.annotations.NotNull;

public final class OverridingUtilsKt {
    @NotNull
    public static final <D extends CallableDescriptor> List<D> findTopMostOverriddenDescriptors(@NotNull D $receiver) {
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        Object r = DFS.dfs((Collection)CollectionsKt.listOf($receiver), findTopMostOverriddenDescriptors.1.INSTANCE, new DFS.CollectingNodeHandler<CallableDescriptor, CallableDescriptor, ArrayList<D>>(new ArrayList()){

            public void afterChildren(@NotNull CallableDescriptor current) {
                Intrinsics.checkParameterIsNotNull(current, "current");
                if (current.getOverriddenDescriptors().isEmpty()) {
                    CallableDescriptor callableDescriptor = current;
                    if (callableDescriptor == null) {
                        throw new TypeCastException("null cannot be cast to non-null type D");
                    }
                    ((ArrayList)this.result).add(callableDescriptor);
                }
            }
        });
        Intrinsics.checkExpressionValueIsNotNull(r, "DFS.dfs(\n            lis\u2026         }\n            })");
        return (List)r;
    }

    /*
     * WARNING - void declaration
     */
    @NotNull
    public static final <D extends CallableDescriptor> Set<D> findOriginalTopMostOverriddenDescriptors(@NotNull D $receiver) {
        void var2_2;
        void $receiver$iv;
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        Iterable iterable = OverridingUtilsKt.findTopMostOverriddenDescriptors($receiver);
        Collection destination$iv = new LinkedHashSet();
        for (Object item$iv : $receiver$iv) {
            CallableDescriptor callableDescriptor;
            void it;
            CallableDescriptor callableDescriptor2 = (CallableDescriptor)item$iv;
            Collection collection = destination$iv;
            if (it.getOriginal() == null) {
                throw new TypeCastException("null cannot be cast to non-null type D");
            }
            collection.add(callableDescriptor);
        }
        return (Set)var2_2;
    }

    @NotNull
    public static final <H> Collection<H> selectMostSpecificInEachOverridableGroup(@NotNull Collection<? extends H> $receiver, @NotNull Function1<? super H, ? extends CallableDescriptor> descriptorByHandle) {
        Collection collection;
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        Intrinsics.checkParameterIsNotNull(descriptorByHandle, "descriptorByHandle");
        if ($receiver.size() <= 1) {
            return $receiver;
        }
        LinkedList<? extends H> queue = new LinkedList<H>($receiver);
        SmartSet<Object> result2 = SmartSet.Companion.create();
        while (!(collection = (Collection)queue).isEmpty()) {
            SmartSet conflictedHandles;
            Object nextHandle = CollectionsKt.first((List)queue);
            Collection<H> overridableGroup2 = OverridingUtil.extractMembersOverridableInBothWays(nextHandle, (Collection)queue, descriptorByHandle, new Function1<H, Unit>(conflictedHandles = SmartSet.Companion.create()){
                final /* synthetic */ SmartSet $conflictedHandles;

                public final void invoke(H it) {
                    H h = it;
                    Intrinsics.checkExpressionValueIsNotNull(h, "it");
                    this.$conflictedHandles.add(h);
                }
                {
                    this.$conflictedHandles = smartSet;
                    super(1);
                }
            });
            if (overridableGroup2.size() == 1 && conflictedHandles.isEmpty()) {
                Object t = CollectionsKt.single((Iterable)overridableGroup2);
                Intrinsics.checkExpressionValueIsNotNull(t, "overridableGroup.single()");
                result2.add(t);
                continue;
            }
            H mostSpecific = OverridingUtil.selectMostSpecificMember(overridableGroup2, descriptorByHandle);
            CallableDescriptor mostSpecificDescriptor = descriptorByHandle.invoke(mostSpecific);
            Iterable $receiver$iv = overridableGroup2;
            for (Object element$iv : $receiver$iv) {
                Object it = element$iv;
                if (OverridingUtil.isMoreSpecific(mostSpecificDescriptor, descriptorByHandle.invoke(it))) continue;
                ((Collection)conflictedHandles).add(element$iv);
            }
            Collection collection2 = conflictedHandles;
            if (!collection2.isEmpty()) {
                result2.addAll(conflictedHandles);
            }
            H h = mostSpecific;
            Intrinsics.checkExpressionValueIsNotNull(h, "mostSpecific");
            result2.add(h);
        }
        return result2;
    }
}

