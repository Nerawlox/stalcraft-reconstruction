/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.util;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import org.jetbrains.annotations.NotNull;

public interface ModuleVisibilityHelper {
    public boolean isInFriendModule(@NotNull DeclarationDescriptor var1, @NotNull DeclarationDescriptor var2);

    public static final class EMPTY
    implements ModuleVisibilityHelper {
        public static final EMPTY INSTANCE;

        @Override
        public boolean isInFriendModule(@NotNull DeclarationDescriptor what, @NotNull DeclarationDescriptor from) {
            Intrinsics.checkParameterIsNotNull(what, "what");
            Intrinsics.checkParameterIsNotNull(from, "from");
            return true;
        }

        private EMPTY() {
            INSTANCE = this;
        }

        static {
            new EMPTY();
        }
    }
}

