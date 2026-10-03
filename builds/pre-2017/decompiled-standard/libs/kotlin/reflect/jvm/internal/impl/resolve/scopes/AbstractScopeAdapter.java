/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.resolve.scopes;

import java.util.Collection;
import java.util.Set;
import kotlin.TypeCastException;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.incremental.components.LookupLocation;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.DescriptorKindFilter;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.utils.Printer;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public abstract class AbstractScopeAdapter
implements MemberScope {
    @NotNull
    protected abstract MemberScope getWorkerScope();

    @NotNull
    public final MemberScope getActualScope() {
        MemberScope memberScope2;
        if (this.getWorkerScope() instanceof AbstractScopeAdapter) {
            MemberScope memberScope3 = this.getWorkerScope();
            if (memberScope3 == null) {
                throw new TypeCastException("null cannot be cast to non-null type org.jetbrains.kotlin.resolve.scopes.AbstractScopeAdapter");
            }
            memberScope2 = ((AbstractScopeAdapter)memberScope3).getActualScope();
        } else {
            memberScope2 = this.getWorkerScope();
        }
        return memberScope2;
    }

    @Override
    @NotNull
    public Collection<SimpleFunctionDescriptor> getContributedFunctions(@NotNull Name name2, @NotNull LookupLocation location) {
        Intrinsics.checkParameterIsNotNull(name2, "name");
        Intrinsics.checkParameterIsNotNull(location, "location");
        return this.getWorkerScope().getContributedFunctions(name2, location);
    }

    @Override
    @Nullable
    public ClassifierDescriptor getContributedClassifier(@NotNull Name name2, @NotNull LookupLocation location) {
        Intrinsics.checkParameterIsNotNull(name2, "name");
        Intrinsics.checkParameterIsNotNull(location, "location");
        return this.getWorkerScope().getContributedClassifier(name2, location);
    }

    @Override
    @NotNull
    public Collection<PropertyDescriptor> getContributedVariables(@NotNull Name name2, @NotNull LookupLocation location) {
        Intrinsics.checkParameterIsNotNull(name2, "name");
        Intrinsics.checkParameterIsNotNull(location, "location");
        return this.getWorkerScope().getContributedVariables(name2, location);
    }

    @Override
    @NotNull
    public Collection<DeclarationDescriptor> getContributedDescriptors(@NotNull DescriptorKindFilter kindFilter, @NotNull Function1<? super Name, Boolean> nameFilter) {
        Intrinsics.checkParameterIsNotNull(kindFilter, "kindFilter");
        Intrinsics.checkParameterIsNotNull(nameFilter, "nameFilter");
        return this.getWorkerScope().getContributedDescriptors(kindFilter, nameFilter);
    }

    @Override
    @NotNull
    public Set<Name> getFunctionNames() {
        return this.getWorkerScope().getFunctionNames();
    }

    @Override
    @NotNull
    public Set<Name> getVariableNames() {
        return this.getWorkerScope().getVariableNames();
    }

    @Override
    public void printScopeStructure(@NotNull Printer p) {
        Intrinsics.checkParameterIsNotNull(p, "p");
        p.println(this.getClass().getSimpleName(), " {");
        p.pushIndent();
        p.print("worker =");
        MemberScope memberScope2 = this.getWorkerScope();
        Printer printer = p.withholdIndentOnce();
        Intrinsics.checkExpressionValueIsNotNull(printer, "p.withholdIndentOnce()");
        memberScope2.printScopeStructure(printer);
        p.popIndent();
        p.println("}");
    }
}

