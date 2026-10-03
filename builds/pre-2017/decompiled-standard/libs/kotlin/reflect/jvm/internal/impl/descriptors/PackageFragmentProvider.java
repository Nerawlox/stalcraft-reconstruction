/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.descriptors;

import java.util.Collection;
import java.util.List;
import java.util.Set;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.Name;
import org.jetbrains.annotations.NotNull;

public interface PackageFragmentProvider {
    @NotNull
    public List<PackageFragmentDescriptor> getPackageFragments(@NotNull FqName var1);

    @NotNull
    public Collection<FqName> getSubPackagesOf(@NotNull FqName var1, @NotNull Function1<? super Name, Boolean> var2);

    public static final class Empty
    implements PackageFragmentProvider {
        public static final Empty INSTANCE;

        @Override
        @NotNull
        public List<PackageFragmentDescriptor> getPackageFragments(@NotNull FqName fqName2) {
            Intrinsics.checkParameterIsNotNull(fqName2, "fqName");
            return CollectionsKt.emptyList();
        }

        @NotNull
        public Set<FqName> getSubPackagesOf(@NotNull FqName fqName2, @NotNull Function1<? super Name, Boolean> nameFilter) {
            Intrinsics.checkParameterIsNotNull(fqName2, "fqName");
            Intrinsics.checkParameterIsNotNull(nameFilter, "nameFilter");
            return SetsKt.emptySet();
        }

        private Empty() {
            INSTANCE = this;
        }

        static {
            new Empty();
        }
    }
}

