/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentProvider;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.serialization.ClassDataWithSource;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.ClassDataFinder;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializedPackageFragment;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class DeserializedClassDataFinder
implements ClassDataFinder {
    private final PackageFragmentProvider packageFragmentProvider;

    @Override
    @Nullable
    public ClassDataWithSource findClassData(@NotNull ClassId classId) {
        Intrinsics.checkParameterIsNotNull(classId, "classId");
        FqName fqName2 = classId.getPackageFqName();
        Intrinsics.checkExpressionValueIsNotNull(fqName2, "classId.packageFqName");
        PackageFragmentDescriptor packageFragmentDescriptor = CollectionsKt.singleOrNull(this.packageFragmentProvider.getPackageFragments(fqName2));
        if (!(packageFragmentDescriptor instanceof DeserializedPackageFragment)) {
            packageFragmentDescriptor = null;
        }
        DeserializedPackageFragment deserializedPackageFragment = (DeserializedPackageFragment)packageFragmentDescriptor;
        if (deserializedPackageFragment == null) {
            return null;
        }
        DeserializedPackageFragment packageFragment = deserializedPackageFragment;
        return packageFragment.getClassDataFinder().findClassData(classId);
    }

    public DeserializedClassDataFinder(@NotNull PackageFragmentProvider packageFragmentProvider) {
        Intrinsics.checkParameterIsNotNull(packageFragmentProvider, "packageFragmentProvider");
        this.packageFragmentProvider = packageFragmentProvider;
    }
}

