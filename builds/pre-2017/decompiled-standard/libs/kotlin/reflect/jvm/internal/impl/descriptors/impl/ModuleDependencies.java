/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import java.util.List;
import java.util.Set;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.ModuleDescriptorImpl;
import org.jetbrains.annotations.NotNull;

public interface ModuleDependencies {
    @NotNull
    public List<ModuleDescriptorImpl> getAllDependencies();

    @NotNull
    public Set<ModuleDescriptorImpl> getModulesWhoseInternalsAreVisible();
}

