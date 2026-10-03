/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import java.util.ArrayList;
import java.util.Collection;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageViewDescriptor;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.DescriptorKindExclude;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.DescriptorKindFilter;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScopeImpl;
import kotlin.reflect.jvm.internal.impl.utils.CollectionsKt;
import kotlin.reflect.jvm.internal.impl.utils.Printer;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class SubpackagesScope
extends MemberScopeImpl {
    private final ModuleDescriptor moduleDescriptor;
    private final FqName fqName;

    @Nullable
    protected final PackageViewDescriptor getPackage(@NotNull Name name2) {
        Intrinsics.checkParameterIsNotNull(name2, "name");
        if (name2.isSpecial()) {
            return null;
        }
        FqName fqName2 = this.fqName.child(name2);
        Intrinsics.checkExpressionValueIsNotNull(fqName2, "fqName.child(name)");
        PackageViewDescriptor packageViewDescriptor = this.moduleDescriptor.getPackage(fqName2);
        if (packageViewDescriptor.isEmpty()) {
            return null;
        }
        return packageViewDescriptor;
    }

    @Override
    @NotNull
    public Collection<DeclarationDescriptor> getContributedDescriptors(@NotNull DescriptorKindFilter kindFilter, @NotNull Function1<? super Name, Boolean> nameFilter) {
        Intrinsics.checkParameterIsNotNull(kindFilter, "kindFilter");
        Intrinsics.checkParameterIsNotNull(nameFilter, "nameFilter");
        if (!kindFilter.acceptsKinds(DescriptorKindFilter.Companion.getPACKAGES_MASK())) {
            return kotlin.collections.CollectionsKt.emptyList();
        }
        if (this.fqName.isRoot() && kindFilter.getExcludes().contains(DescriptorKindExclude.TopLevelPackages.INSTANCE)) {
            return kotlin.collections.CollectionsKt.emptyList();
        }
        Collection<FqName> subFqNames = this.moduleDescriptor.getSubPackagesOf(this.fqName, nameFilter);
        ArrayList result2 = new ArrayList(subFqNames.size());
        for (FqName subFqName : subFqNames) {
            Name shortName;
            Name name2 = shortName = subFqName.shortName();
            Intrinsics.checkExpressionValueIsNotNull(name2, "shortName");
            if (!nameFilter.invoke(name2).booleanValue()) continue;
            Collection collection = result2;
            Name name3 = shortName;
            Intrinsics.checkExpressionValueIsNotNull(name3, "shortName");
            CollectionsKt.addIfNotNull(collection, this.getPackage(name3));
        }
        return result2;
    }

    @Override
    public void printScopeStructure(@NotNull Printer p) {
        Intrinsics.checkParameterIsNotNull(p, "p");
        p.println(this.getClass().getSimpleName(), " {");
        p.pushIndent();
        p.popIndent();
        p.println("}");
    }

    public SubpackagesScope(@NotNull ModuleDescriptor moduleDescriptor, @NotNull FqName fqName2) {
        Intrinsics.checkParameterIsNotNull(moduleDescriptor, "moduleDescriptor");
        Intrinsics.checkParameterIsNotNull(fqName2, "fqName");
        this.moduleDescriptor = moduleDescriptor;
        this.fqName = fqName2;
    }
}

