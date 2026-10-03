/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.resolve.scopes;

import java.util.Collection;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.incremental.components.LookupLocation;
import org.jetbrains.annotations.NotNull;

public interface SyntheticConstructorsProvider {
    @NotNull
    public Collection<FunctionDescriptor> getSyntheticConstructors(@NotNull ClassifierDescriptor var1, @NotNull LookupLocation var2);

    public static final class Empty
    implements SyntheticConstructorsProvider {
        public static final Empty INSTANCE;

        @Override
        @NotNull
        public Collection<FunctionDescriptor> getSyntheticConstructors(@NotNull ClassifierDescriptor classifier2, @NotNull LookupLocation location) {
            Intrinsics.checkParameterIsNotNull(classifier2, "classifier");
            Intrinsics.checkParameterIsNotNull(location, "location");
            return CollectionsKt.emptyList();
        }

        private Empty() {
            INSTANCE = this;
        }

        static {
            new Empty();
        }
    }
}

