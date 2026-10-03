/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.resolve.scopes;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Pair;
import kotlin.TypeCastException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.incremental.components.LookupLocation;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.OverridingUtilsKt;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.AbstractScopeAdapter;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.ChainedMemberScope;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.DescriptorKindFilter;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.TypeIntersectionScope;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.utils.Printer;
import org.jetbrains.annotations.NotNull;

public final class TypeIntersectionScope
extends AbstractScopeAdapter {
    @NotNull
    private final ChainedMemberScope workerScope;
    public static final Companion Companion = new Companion(null);

    @Override
    @NotNull
    public Collection<SimpleFunctionDescriptor> getContributedFunctions(@NotNull Name name2, @NotNull LookupLocation location) {
        Intrinsics.checkParameterIsNotNull(name2, "name");
        Intrinsics.checkParameterIsNotNull(location, "location");
        return OverridingUtilsKt.selectMostSpecificInEachOverridableGroup(super.getContributedFunctions(name2, location), getContributedFunctions.1.INSTANCE);
    }

    @Override
    @NotNull
    public Collection<PropertyDescriptor> getContributedVariables(@NotNull Name name2, @NotNull LookupLocation location) {
        Intrinsics.checkParameterIsNotNull(name2, "name");
        Intrinsics.checkParameterIsNotNull(location, "location");
        return OverridingUtilsKt.selectMostSpecificInEachOverridableGroup(super.getContributedVariables(name2, location), getContributedVariables.1.INSTANCE);
    }

    /*
     * WARNING - void declaration
     */
    @Override
    @NotNull
    public Collection<DeclarationDescriptor> getContributedDescriptors(@NotNull DescriptorKindFilter kindFilter, @NotNull Function1<? super Name, Boolean> nameFilter) {
        void other;
        void callables;
        Intrinsics.checkParameterIsNotNull(kindFilter, "kindFilter");
        Intrinsics.checkParameterIsNotNull(nameFilter, "nameFilter");
        Iterable $receiver$iv = super.getContributedDescriptors(kindFilter, nameFilter);
        ArrayList first$iv = new ArrayList();
        ArrayList second$iv = new ArrayList();
        for (Object element$iv : $receiver$iv) {
            DeclarationDescriptor it = (DeclarationDescriptor)element$iv;
            if (it instanceof CallableDescriptor) {
                first$iv.add(element$iv);
                continue;
            }
            second$iv.add(element$iv);
        }
        Pair pair = new Pair(first$iv, second$iv);
        List list = pair.component1();
        List list2 = pair.component2();
        pair = null;
        void v0 = callables;
        if (v0 == null) {
            throw new TypeCastException("null cannot be cast to non-null type kotlin.collections.Collection<org.jetbrains.kotlin.descriptors.CallableDescriptor>");
        }
        return CollectionsKt.plus(OverridingUtilsKt.selectMostSpecificInEachOverridableGroup((Collection)v0, getContributedDescriptors.2.INSTANCE), (Iterable)other);
    }

    @Override
    public void printScopeStructure(@NotNull Printer p) {
        Intrinsics.checkParameterIsNotNull(p, "p");
        p.print("TypeIntersectionScope for: " + this.getWorkerScope().getDebugName$kotlin_core());
        super.printScopeStructure(p);
    }

    @Override
    @NotNull
    protected ChainedMemberScope getWorkerScope() {
        return this.workerScope;
    }

    private TypeIntersectionScope(ChainedMemberScope workerScope) {
        this.workerScope = workerScope;
    }

    public /* synthetic */ TypeIntersectionScope(@NotNull ChainedMemberScope workerScope, DefaultConstructorMarker $constructor_marker) {
        this(workerScope);
    }

    @JvmStatic
    @NotNull
    public static final MemberScope create(@NotNull String message, @NotNull Collection<? extends KotlinType> types) {
        Intrinsics.checkParameterIsNotNull(message, "message");
        Intrinsics.checkParameterIsNotNull(types, "types");
        return Companion.create(message, types);
    }

    public static final class Companion {
        /*
         * WARNING - void declaration
         */
        @JvmStatic
        @NotNull
        public final MemberScope create(@NotNull String message, @NotNull Collection<? extends KotlinType> types) {
            Collection<MemberScope> collection;
            void $receiver$iv$iv;
            void $receiver$iv;
            ChainedMemberScope chainedMemberScope;
            Intrinsics.checkParameterIsNotNull(message, "message");
            Intrinsics.checkParameterIsNotNull(types, "types");
            Iterable iterable = types;
            String string = message;
            ChainedMemberScope chainedMemberScope2 = chainedMemberScope;
            ChainedMemberScope chainedMemberScope3 = chainedMemberScope;
            void var7_7 = $receiver$iv;
            Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($receiver$iv, 10));
            for (Object item$iv$iv : $receiver$iv$iv) {
                void it;
                KotlinType kotlinType = (KotlinType)item$iv$iv;
                collection = destination$iv$iv;
                MemberScope memberScope2 = it.getMemberScope();
                collection.add(memberScope2);
            }
            collection = (List)destination$iv$iv;
            chainedMemberScope2(string, (List<? extends MemberScope>)collection);
            ChainedMemberScope chainedScope = chainedMemberScope3;
            if (types.size() <= 1) {
                return chainedScope;
            }
            return new TypeIntersectionScope(chainedScope, null);
        }

        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }
}

