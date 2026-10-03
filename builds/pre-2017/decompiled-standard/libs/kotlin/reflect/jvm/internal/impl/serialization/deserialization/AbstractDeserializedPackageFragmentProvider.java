/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import java.util.Collection;
import java.util.List;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentProvider;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationComponents;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializedPackageFragment;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.KotlinMetadataFinder;
import kotlin.reflect.jvm.internal.impl.storage.MemoizedFunctionToNullable;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import kotlin.reflect.jvm.internal.impl.utils.CollectionsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public abstract class AbstractDeserializedPackageFragmentProvider
implements PackageFragmentProvider {
    @NotNull
    protected DeserializationComponents components;
    private final MemoizedFunctionToNullable<FqName, PackageFragmentDescriptor> fragments;
    @NotNull
    private final StorageManager storageManager;
    @NotNull
    private final KotlinMetadataFinder finder;
    @NotNull
    private final ModuleDescriptor moduleDescriptor;

    @NotNull
    protected final DeserializationComponents getComponents() {
        DeserializationComponents deserializationComponents = this.components;
        if (deserializationComponents == null) {
            Intrinsics.throwUninitializedPropertyAccessException("components");
        }
        return deserializationComponents;
    }

    protected final void setComponents(@NotNull DeserializationComponents deserializationComponents) {
        Intrinsics.checkParameterIsNotNull(deserializationComponents, "<set-?>");
        this.components = deserializationComponents;
    }

    @Nullable
    protected abstract DeserializedPackageFragment findPackage(@NotNull FqName var1);

    @Override
    @NotNull
    public List<PackageFragmentDescriptor> getPackageFragments(@NotNull FqName fqName2) {
        Intrinsics.checkParameterIsNotNull(fqName2, "fqName");
        return CollectionsKt.singletonOrEmptyList(this.fragments.invoke(fqName2));
    }

    @Override
    @NotNull
    public Collection<FqName> getSubPackagesOf(@NotNull FqName fqName2, @NotNull Function1<? super Name, Boolean> nameFilter) {
        Intrinsics.checkParameterIsNotNull(fqName2, "fqName");
        Intrinsics.checkParameterIsNotNull(nameFilter, "nameFilter");
        return SetsKt.emptySet();
    }

    @NotNull
    protected final StorageManager getStorageManager() {
        return this.storageManager;
    }

    @NotNull
    protected final KotlinMetadataFinder getFinder() {
        return this.finder;
    }

    @NotNull
    protected final ModuleDescriptor getModuleDescriptor() {
        return this.moduleDescriptor;
    }

    public AbstractDeserializedPackageFragmentProvider(@NotNull StorageManager storageManager, @NotNull KotlinMetadataFinder finder, @NotNull ModuleDescriptor moduleDescriptor) {
        Intrinsics.checkParameterIsNotNull(storageManager, "storageManager");
        Intrinsics.checkParameterIsNotNull(finder, "finder");
        Intrinsics.checkParameterIsNotNull(moduleDescriptor, "moduleDescriptor");
        this.storageManager = storageManager;
        this.finder = finder;
        this.moduleDescriptor = moduleDescriptor;
        this.fragments = this.storageManager.createMemoizedFunctionWithNullableValues((Function1)new Function1<FqName, DeserializedPackageFragment>(this){
            final /* synthetic */ AbstractDeserializedPackageFragmentProvider this$0;

            @Nullable
            public final DeserializedPackageFragment invoke(@NotNull FqName fqName2) {
                DeserializedPackageFragment deserializedPackageFragment;
                Intrinsics.checkParameterIsNotNull(fqName2, "fqName");
                DeserializedPackageFragment deserializedPackageFragment2 = this.this$0.findPackage(fqName2);
                if (deserializedPackageFragment2 != null) {
                    DeserializedPackageFragment deserializedPackageFragment3;
                    DeserializedPackageFragment $receiver = deserializedPackageFragment3 = deserializedPackageFragment2;
                    $receiver.setComponents(this.this$0.getComponents());
                    deserializedPackageFragment = deserializedPackageFragment3;
                } else {
                    deserializedPackageFragment = null;
                }
                return deserializedPackageFragment;
            }
            {
                this.this$0 = abstractDeserializedPackageFragmentProvider;
                super(1);
            }
        });
    }
}

