/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.descriptors;

import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

public interface PackagePartProvider {
    @NotNull
    public List<String> findPackageParts(@NotNull String var1);

    @NotNull
    public List<String> findMetadataPackageParts(@NotNull String var1);

    public static final class Empty
    implements PackagePartProvider {
        public static final Empty INSTANCE;

        @Override
        @NotNull
        public List<String> findPackageParts(@NotNull String packageFqName) {
            Intrinsics.checkParameterIsNotNull(packageFqName, "packageFqName");
            return CollectionsKt.emptyList();
        }

        @Override
        @NotNull
        public List<String> findMetadataPackageParts(@NotNull String packageFqName) {
            Intrinsics.checkParameterIsNotNull(packageFqName, "packageFqName");
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

