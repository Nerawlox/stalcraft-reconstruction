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
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptorWithTypeParameters;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeAliasDescriptor;
import kotlin.reflect.jvm.internal.impl.incremental.components.LookupLocation;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.DescriptorKindFilter;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScopeImpl;
import kotlin.reflect.jvm.internal.impl.utils.Printer;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class InnerClassesScopeWrapper
extends MemberScopeImpl {
    @NotNull
    private final MemberScope workerScope;

    @Override
    @Nullable
    public ClassifierDescriptor getContributedClassifier(@NotNull Name name2, @NotNull LookupLocation location) {
        ClassifierDescriptor classifierDescriptor;
        Intrinsics.checkParameterIsNotNull(name2, "name");
        Intrinsics.checkParameterIsNotNull(location, "location");
        ClassifierDescriptor classifierDescriptor2 = this.workerScope.getContributedClassifier(name2, location);
        if (classifierDescriptor2 != null) {
            ClassifierDescriptor classifierDescriptor3;
            ClassifierDescriptor classifierDescriptor4 = classifierDescriptor2;
            ClassifierDescriptor it = classifierDescriptor4;
            ClassifierDescriptor classifierDescriptor5 = it;
            if (!(classifierDescriptor5 instanceof ClassDescriptor)) {
                classifierDescriptor5 = null;
            }
            ClassDescriptor classDescriptor = (ClassDescriptor)classifierDescriptor5;
            if (classDescriptor != null) {
                classifierDescriptor3 = classDescriptor;
            } else {
                ClassifierDescriptor classifierDescriptor6 = it;
                if (!(classifierDescriptor6 instanceof TypeAliasDescriptor)) {
                    classifierDescriptor6 = null;
                }
                classifierDescriptor3 = (TypeAliasDescriptor)classifierDescriptor6;
            }
            classifierDescriptor = classifierDescriptor3;
        } else {
            classifierDescriptor = null;
        }
        return classifierDescriptor;
    }

    /*
     * WARNING - void declaration
     */
    @NotNull
    public List<ClassifierDescriptor> getContributedDescriptors(@NotNull DescriptorKindFilter kindFilter, @NotNull Function1<? super Name, Boolean> nameFilter) {
        void $receiver$iv$iv;
        Iterable $receiver$iv;
        Intrinsics.checkParameterIsNotNull(kindFilter, "kindFilter");
        Intrinsics.checkParameterIsNotNull(nameFilter, "nameFilter");
        DescriptorKindFilter descriptorKindFilter = kindFilter.restrictedToKindsOrNull(DescriptorKindFilter.Companion.getCLASSIFIERS_MASK());
        if (descriptorKindFilter == null) {
            return CollectionsKt.emptyList();
        }
        DescriptorKindFilter restrictedFilter = descriptorKindFilter;
        Iterable iterable = $receiver$iv = (Iterable)this.workerScope.getContributedDescriptors(restrictedFilter, nameFilter);
        Collection destination$iv$iv = new ArrayList();
        for (Object element$iv$iv : $receiver$iv$iv) {
            if (!(element$iv$iv instanceof ClassifierDescriptorWithTypeParameters)) continue;
            destination$iv$iv.add(element$iv$iv);
        }
        return (List)destination$iv$iv;
    }

    @Override
    public void printScopeStructure(@NotNull Printer p) {
        Intrinsics.checkParameterIsNotNull(p, "p");
        p.println("InnerClassesScopeWrapper for scope:");
        this.workerScope.printScopeStructure(p);
    }

    @NotNull
    public String toString() {
        return "Classes from " + this.workerScope;
    }

    @NotNull
    public final MemberScope getWorkerScope() {
        return this.workerScope;
    }

    public InnerClassesScopeWrapper(@NotNull MemberScope workerScope) {
        Intrinsics.checkParameterIsNotNull(workerScope, "workerScope");
        this.workerScope = workerScope;
    }
}

