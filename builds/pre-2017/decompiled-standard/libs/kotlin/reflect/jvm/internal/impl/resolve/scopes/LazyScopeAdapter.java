/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.resolve.scopes;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.AbstractScopeAdapter;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue;
import org.jetbrains.annotations.NotNull;

public final class LazyScopeAdapter
extends AbstractScopeAdapter {
    private final NotNullLazyValue<MemberScope> scope;

    @Override
    @NotNull
    protected MemberScope getWorkerScope() {
        return (MemberScope)this.scope.invoke();
    }

    public LazyScopeAdapter(@NotNull NotNullLazyValue<? extends MemberScope> scope) {
        Intrinsics.checkParameterIsNotNull(scope, "scope");
        this.scope = scope;
    }
}

