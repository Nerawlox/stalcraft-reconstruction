/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.descriptors;

import java.util.Collection;
import java.util.List;
import java.util.Set;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorVisitor;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageViewDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceKind;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public interface ModuleDescriptor
extends DeclarationDescriptor {
    @Override
    @Nullable
    public DeclarationDescriptor getContainingDeclaration();

    @NotNull
    public KotlinBuiltIns getBuiltIns();

    @NotNull
    public SourceKind getSourceKind();

    public boolean shouldSeeInternalsOf(@NotNull ModuleDescriptor var1);

    @Override
    @NotNull
    public ModuleDescriptor substitute(@NotNull TypeSubstitutor var1);

    @Override
    public <R, D> R accept(@NotNull DeclarationDescriptorVisitor<R, D> var1, D var2);

    @NotNull
    public PackageViewDescriptor getPackage(@NotNull FqName var1);

    @NotNull
    public Collection<FqName> getSubPackagesOf(@NotNull FqName var1, @NotNull Function1<? super Name, Boolean> var2);

    @NotNull
    public List<ModuleDescriptor> getAllDependencyModules();

    @NotNull
    public Set<ModuleDescriptor> getAllImplementingModules();

    @Nullable
    public <T> T getCapability(@NotNull Capability<T> var1);

    public static final class Capability<T> {
        @NotNull
        private final String name;

        @NotNull
        public String toString() {
            return this.name;
        }

        @NotNull
        public final String getName() {
            return this.name;
        }

        public Capability(@NotNull String name2) {
            Intrinsics.checkParameterIsNotNull(name2, "name");
            this.name = name2;
        }
    }

    public static final class DefaultImpls {
        @Nullable
        public static DeclarationDescriptor getContainingDeclaration(ModuleDescriptor $this) {
            return null;
        }

        @NotNull
        public static ModuleDescriptor substitute(@NotNull ModuleDescriptor $this, TypeSubstitutor substitutor) {
            Intrinsics.checkParameterIsNotNull(substitutor, "substitutor");
            return $this;
        }

        public static <R, D> R accept(@NotNull ModuleDescriptor $this, DeclarationDescriptorVisitor<R, D> visitor2, D data2) {
            Intrinsics.checkParameterIsNotNull(visitor2, "visitor");
            return visitor2.visitModuleDeclaration($this, data2);
        }
    }
}

