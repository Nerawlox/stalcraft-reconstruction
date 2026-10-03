/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.incremental.components;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.incremental.components.Position;
import kotlin.reflect.jvm.internal.impl.incremental.components.ScopeKind;
import org.jetbrains.annotations.NotNull;

public interface LookupTracker {
    public static final Companion Companion = new Companion(null);

    public boolean getRequiresPosition();

    public void record(@NotNull String var1, @NotNull Position var2, @NotNull String var3, @NotNull ScopeKind var4, @NotNull String var5);

    public static final class Companion {
        @NotNull
        private static final LookupTracker DO_NOTHING;

        @NotNull
        public final LookupTracker getDO_NOTHING() {
            return DO_NOTHING;
        }

        private Companion() {
            DO_NOTHING = new LookupTracker(){

                public boolean getRequiresPosition() {
                    return false;
                }

                public void record(@NotNull String filePath, @NotNull Position position, @NotNull String scopeFqName, @NotNull ScopeKind scopeKind, @NotNull String name2) {
                    Intrinsics.checkParameterIsNotNull(filePath, "filePath");
                    Intrinsics.checkParameterIsNotNull(position, "position");
                    Intrinsics.checkParameterIsNotNull(scopeFqName, "scopeFqName");
                    Intrinsics.checkParameterIsNotNull((Object)((Object)scopeKind), "scopeKind");
                    Intrinsics.checkParameterIsNotNull(name2, "name");
                }
            };
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }
}

