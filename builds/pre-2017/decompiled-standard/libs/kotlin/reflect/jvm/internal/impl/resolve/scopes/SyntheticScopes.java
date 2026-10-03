/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.resolve.scopes;

import java.util.Collection;
import kotlin.collections.CollectionsKt;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.SyntheticScope;
import org.jetbrains.annotations.NotNull;

public interface SyntheticScopes {
    @NotNull
    public Collection<SyntheticScope> getScopes();

    public static final class Empty
    implements SyntheticScopes {
        @NotNull
        private static final Collection<SyntheticScope> scopes;
        public static final Empty INSTANCE;

        @Override
        @NotNull
        public Collection<SyntheticScope> getScopes() {
            return scopes;
        }

        private Empty() {
            INSTANCE = this;
            scopes = CollectionsKt.emptyList();
        }

        static {
            new Empty();
        }
    }
}

