/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.resolve.scopes;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptorWithTypeParameters;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.incremental.components.LookupLocation;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.DescriptorKindFilter;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.util.collectionUtils.ScopeUtilsKt;
import kotlin.reflect.jvm.internal.impl.utils.Printer;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class ChainedMemberScope
implements MemberScope {
    @NotNull
    private final String debugName;
    private final List<MemberScope> scopes;
    public static final Companion Companion = new Companion(null);

    @Override
    @Nullable
    public ClassifierDescriptor getContributedClassifier(@NotNull Name name2, @NotNull LookupLocation location) {
        ClassifierDescriptor classifierDescriptor;
        block2: {
            Intrinsics.checkParameterIsNotNull(name2, "name");
            Intrinsics.checkParameterIsNotNull(location, "location");
            List<MemberScope> scopes$iv = this.scopes;
            ClassifierDescriptor result$iv = null;
            for (MemberScope scope$iv : scopes$iv) {
                MemberScope it = scope$iv;
                ClassifierDescriptor newResult$iv = it.getContributedClassifier(name2, location);
                if (newResult$iv == null) continue;
                if (newResult$iv instanceof ClassifierDescriptorWithTypeParameters && ((ClassifierDescriptorWithTypeParameters)newResult$iv).isHeader()) {
                    if (result$iv != null) continue;
                    result$iv = newResult$iv;
                    continue;
                }
                classifierDescriptor = newResult$iv;
                break block2;
            }
            classifierDescriptor = result$iv;
        }
        return classifierDescriptor;
    }

    /*
     * WARNING - void declaration
     */
    @Override
    @NotNull
    public Collection<PropertyDescriptor> getContributedVariables(@NotNull Name name2, @NotNull LookupLocation location) {
        Collection collection;
        Intrinsics.checkParameterIsNotNull(name2, "name");
        Intrinsics.checkParameterIsNotNull(location, "location");
        List<MemberScope> scopes$iv = this.scopes;
        if (scopes$iv.isEmpty()) {
            collection = SetsKt.emptySet();
        } else {
            Collection result$iv = null;
            Iterator<MemberScope> iterator2 = scopes$iv.iterator();
            while (iterator2.hasNext()) {
                void it;
                MemberScope scope$iv;
                MemberScope memberScope2 = scope$iv = iterator2.next();
                Collection collection2 = result$iv;
                Collection<PropertyDescriptor> collection3 = it.getContributedVariables(name2, location);
                result$iv = ScopeUtilsKt.concat(collection2, collection3);
            }
            collection = result$iv;
            if (collection == null) {
                collection = SetsKt.emptySet();
            }
        }
        return collection;
    }

    /*
     * WARNING - void declaration
     */
    @Override
    @NotNull
    public Collection<SimpleFunctionDescriptor> getContributedFunctions(@NotNull Name name2, @NotNull LookupLocation location) {
        Collection collection;
        Intrinsics.checkParameterIsNotNull(name2, "name");
        Intrinsics.checkParameterIsNotNull(location, "location");
        List<MemberScope> scopes$iv = this.scopes;
        if (scopes$iv.isEmpty()) {
            collection = SetsKt.emptySet();
        } else {
            Collection result$iv = null;
            Iterator<MemberScope> iterator2 = scopes$iv.iterator();
            while (iterator2.hasNext()) {
                void it;
                MemberScope scope$iv;
                MemberScope memberScope2 = scope$iv = iterator2.next();
                Collection collection2 = result$iv;
                Collection<SimpleFunctionDescriptor> collection3 = it.getContributedFunctions(name2, location);
                result$iv = ScopeUtilsKt.concat(collection2, collection3);
            }
            collection = result$iv;
            if (collection == null) {
                collection = SetsKt.emptySet();
            }
        }
        return collection;
    }

    /*
     * WARNING - void declaration
     */
    @Override
    @NotNull
    public Collection<DeclarationDescriptor> getContributedDescriptors(@NotNull DescriptorKindFilter kindFilter, @NotNull Function1<? super Name, Boolean> nameFilter) {
        Collection collection;
        Intrinsics.checkParameterIsNotNull(kindFilter, "kindFilter");
        Intrinsics.checkParameterIsNotNull(nameFilter, "nameFilter");
        List<MemberScope> scopes$iv = this.scopes;
        if (scopes$iv.isEmpty()) {
            collection = SetsKt.emptySet();
        } else {
            Collection result$iv = null;
            Iterator<MemberScope> iterator2 = scopes$iv.iterator();
            while (iterator2.hasNext()) {
                void it;
                MemberScope scope$iv;
                MemberScope memberScope2 = scope$iv = iterator2.next();
                Collection collection2 = result$iv;
                Collection<DeclarationDescriptor> collection3 = it.getContributedDescriptors(kindFilter, nameFilter);
                result$iv = ScopeUtilsKt.concat(collection2, collection3);
            }
            collection = result$iv;
            if (collection == null) {
                collection = SetsKt.emptySet();
            }
        }
        return collection;
    }

    /*
     * WARNING - void declaration
     */
    @Override
    @NotNull
    public Set<Name> getFunctionNames() {
        void var2_2;
        void $receiver$iv;
        Iterable iterable = this.scopes;
        Collection destination$iv = new LinkedHashSet();
        for (Object element$iv : $receiver$iv) {
            MemberScope it = (MemberScope)element$iv;
            Iterable list$iv = it.getFunctionNames();
            CollectionsKt.addAll(destination$iv, list$iv);
        }
        return (Set)var2_2;
    }

    /*
     * WARNING - void declaration
     */
    @Override
    @NotNull
    public Set<Name> getVariableNames() {
        void var2_2;
        void $receiver$iv;
        Iterable iterable = this.scopes;
        Collection destination$iv = new LinkedHashSet();
        for (Object element$iv : $receiver$iv) {
            MemberScope it = (MemberScope)element$iv;
            Iterable list$iv = it.getVariableNames();
            CollectionsKt.addAll(destination$iv, list$iv);
        }
        return (Set)var2_2;
    }

    @NotNull
    public String toString() {
        return this.debugName;
    }

    @Override
    public void printScopeStructure(@NotNull Printer p) {
        Intrinsics.checkParameterIsNotNull(p, "p");
        p.println(this.getClass().getSimpleName(), ": ", this.debugName, " {");
        p.pushIndent();
        for (MemberScope scope : this.scopes) {
            scope.printScopeStructure(p);
        }
        p.popIndent();
        p.println("}");
    }

    @NotNull
    public final String getDebugName$kotlin_core() {
        return this.debugName;
    }

    public ChainedMemberScope(@NotNull String debugName, @NotNull List<? extends MemberScope> scopes) {
        Intrinsics.checkParameterIsNotNull(debugName, "debugName");
        Intrinsics.checkParameterIsNotNull(scopes, "scopes");
        this.debugName = debugName;
        this.scopes = scopes;
    }

    public static final class Companion {
        @NotNull
        public final MemberScope create(@NotNull String debugName, @NotNull List<? extends MemberScope> scopes) {
            MemberScope memberScope2;
            Intrinsics.checkParameterIsNotNull(debugName, "debugName");
            Intrinsics.checkParameterIsNotNull(scopes, "scopes");
            switch (scopes.size()) {
                case 0: {
                    memberScope2 = MemberScope.Empty.INSTANCE;
                    break;
                }
                case 1: {
                    memberScope2 = CollectionsKt.single(scopes);
                    break;
                }
                default: {
                    memberScope2 = new ChainedMemberScope(debugName, scopes);
                }
            }
            return memberScope2;
        }

        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }
}

