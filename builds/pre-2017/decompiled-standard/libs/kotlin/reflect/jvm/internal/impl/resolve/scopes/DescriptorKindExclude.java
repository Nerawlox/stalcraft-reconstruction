/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.resolve.scopes;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassKind;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageViewDescriptor;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.DescriptorKindFilter;
import org.jetbrains.annotations.NotNull;

public abstract class DescriptorKindExclude {
    public abstract boolean excludes(@NotNull DeclarationDescriptor var1);

    public abstract int getFullyExcludedDescriptorKinds();

    public String toString() {
        return this.getClass().getSimpleName();
    }

    public static final class Extensions
    extends DescriptorKindExclude {
        public static final Extensions INSTANCE;

        @Override
        public boolean excludes(@NotNull DeclarationDescriptor descriptor2) {
            Intrinsics.checkParameterIsNotNull(descriptor2, "descriptor");
            return descriptor2 instanceof CallableDescriptor && ((CallableDescriptor)descriptor2).getExtensionReceiverParameter() != null;
        }

        @Override
        public int getFullyExcludedDescriptorKinds() {
            return 0;
        }

        private Extensions() {
            INSTANCE = this;
        }

        static {
            new Extensions();
        }
    }

    public static final class NonExtensions
    extends DescriptorKindExclude {
        private static final int fullyExcludedDescriptorKinds;
        public static final NonExtensions INSTANCE;

        @Override
        public boolean excludes(@NotNull DeclarationDescriptor descriptor2) {
            Intrinsics.checkParameterIsNotNull(descriptor2, "descriptor");
            return !(descriptor2 instanceof CallableDescriptor) || ((CallableDescriptor)descriptor2).getExtensionReceiverParameter() == null;
        }

        @Override
        public int getFullyExcludedDescriptorKinds() {
            return fullyExcludedDescriptorKinds;
        }

        private NonExtensions() {
            INSTANCE = this;
            fullyExcludedDescriptorKinds = DescriptorKindFilter.Companion.getALL_KINDS_MASK() & ~(DescriptorKindFilter.Companion.getFUNCTIONS_MASK() | DescriptorKindFilter.Companion.getVARIABLES_MASK());
        }

        static {
            new NonExtensions();
        }
    }

    public static final class EnumEntry
    extends DescriptorKindExclude {
        public static final EnumEntry INSTANCE;

        @Override
        public boolean excludes(@NotNull DeclarationDescriptor descriptor2) {
            Intrinsics.checkParameterIsNotNull(descriptor2, "descriptor");
            return descriptor2 instanceof ClassDescriptor && Intrinsics.areEqual((Object)((ClassDescriptor)descriptor2).getKind(), (Object)ClassKind.ENUM_ENTRY);
        }

        @Override
        public int getFullyExcludedDescriptorKinds() {
            return 0;
        }

        private EnumEntry() {
            INSTANCE = this;
        }

        static {
            new EnumEntry();
        }
    }

    public static final class TopLevelPackages
    extends DescriptorKindExclude {
        public static final TopLevelPackages INSTANCE;

        @Override
        public boolean excludes(@NotNull DeclarationDescriptor descriptor2) {
            FqName fqName2;
            Intrinsics.checkParameterIsNotNull(descriptor2, "descriptor");
            DeclarationDescriptor declarationDescriptor = descriptor2;
            if (declarationDescriptor instanceof PackageFragmentDescriptor) {
                fqName2 = ((PackageFragmentDescriptor)descriptor2).getFqName();
            } else if (declarationDescriptor instanceof PackageViewDescriptor) {
                fqName2 = ((PackageViewDescriptor)descriptor2).getFqName();
            } else {
                return false;
            }
            FqName fqName3 = fqName2;
            return fqName3.parent().isRoot();
        }

        @Override
        public int getFullyExcludedDescriptorKinds() {
            return 0;
        }

        private TopLevelPackages() {
            INSTANCE = this;
        }

        static {
            new TopLevelPackages();
        }
    }
}

