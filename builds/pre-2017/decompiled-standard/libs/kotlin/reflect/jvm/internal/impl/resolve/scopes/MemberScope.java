/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.resolve.scopes;

import java.util.Collection;
import java.util.Set;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.incremental.components.LookupLocation;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScopeImpl;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope;
import kotlin.reflect.jvm.internal.impl.utils.Printer;
import org.jetbrains.annotations.NotNull;

public interface MemberScope
extends ResolutionScope {
    public static final Companion Companion = new Companion(null);

    @NotNull
    public Collection<PropertyDescriptor> getContributedVariables(@NotNull Name var1, @NotNull LookupLocation var2);

    @NotNull
    public Collection<SimpleFunctionDescriptor> getContributedFunctions(@NotNull Name var1, @NotNull LookupLocation var2);

    @NotNull
    public Set<Name> getFunctionNames();

    @NotNull
    public Set<Name> getVariableNames();

    public void printScopeStructure(@NotNull Printer var1);

    public static final class Empty
    extends MemberScopeImpl {
        public static final Empty INSTANCE;

        @Override
        public void printScopeStructure(@NotNull Printer p) {
            Intrinsics.checkParameterIsNotNull(p, "p");
            p.println("Empty member scope");
        }

        @Override
        @NotNull
        public Set<Name> getFunctionNames() {
            return SetsKt.emptySet();
        }

        @Override
        @NotNull
        public Set<Name> getVariableNames() {
            return SetsKt.emptySet();
        }

        private Empty() {
            INSTANCE = this;
        }

        static {
            new Empty();
        }
    }

    public static final class Companion {
        @NotNull
        private static final Function1<Name, Boolean> ALL_NAME_FILTER;

        @NotNull
        public final Function1<Name, Boolean> getALL_NAME_FILTER() {
            return ALL_NAME_FILTER;
        }

        private Companion() {
            ALL_NAME_FILTER = ALL_NAME_FILTER.1.INSTANCE;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }
}

