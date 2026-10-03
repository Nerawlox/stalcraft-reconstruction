/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import java.util.List;
import java.util.Set;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.ModuleDependencies;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.ModuleDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import org.jetbrains.annotations.NotNull;

public final class LazyModuleDependencies
implements ModuleDependencies {
    private final NotNullLazyValue<List<ModuleDescriptorImpl>> dependencies;
    private final NotNullLazyValue<Set<ModuleDescriptorImpl>> visibleInternals;

    @Override
    @NotNull
    public List<ModuleDescriptorImpl> getAllDependencies() {
        return (List)this.dependencies.invoke();
    }

    @Override
    @NotNull
    public Set<ModuleDescriptorImpl> getModulesWhoseInternalsAreVisible() {
        return (Set)this.visibleInternals.invoke();
    }

    public LazyModuleDependencies(@NotNull StorageManager storageManager, @NotNull Function0<? extends List<ModuleDescriptorImpl>> computeDependencies, @NotNull Function0<? extends Set<ModuleDescriptorImpl>> computeModulesWhoseInternalsAreVisible) {
        Intrinsics.checkParameterIsNotNull(storageManager, "storageManager");
        Intrinsics.checkParameterIsNotNull(computeDependencies, "computeDependencies");
        Intrinsics.checkParameterIsNotNull(computeModulesWhoseInternalsAreVisible, "computeModulesWhoseInternalsAreVisible");
        this.dependencies = storageManager.createLazyValue(computeDependencies);
        this.visibleInternals = storageManager.createLazyValue(computeModulesWhoseInternalsAreVisible);
    }
}

