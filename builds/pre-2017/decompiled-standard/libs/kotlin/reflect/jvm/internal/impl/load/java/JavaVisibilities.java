/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.load.java;

import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorWithVisibility;
import kotlin.reflect.jvm.internal.impl.descriptors.EffectiveVisibility;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Visibilities;
import kotlin.reflect.jvm.internal.impl.descriptors.Visibility;
import kotlin.reflect.jvm.internal.impl.resolve.DescriptorUtils;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.receivers.ReceiverValue;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class JavaVisibilities {
    @NotNull
    public static final Visibility PACKAGE_VISIBILITY = new Visibility("package", false){

        @Override
        public boolean isVisible(@Nullable ReceiverValue receiver, @NotNull DeclarationDescriptorWithVisibility what, @NotNull DeclarationDescriptor from) {
            if (what == null) {
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "what", "kotlin/reflect/jvm/internal/impl/load/java/JavaVisibilities$1", "isVisible"));
            }
            if (from == null) {
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "from", "kotlin/reflect/jvm/internal/impl/load/java/JavaVisibilities$1", "isVisible"));
            }
            return JavaVisibilities.areInSamePackage(what, from);
        }

        @Override
        public boolean mustCheckInImports() {
            return true;
        }

        @Override
        protected Integer compareTo(@NotNull Visibility visibility) {
            if (visibility == null) {
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "visibility", "kotlin/reflect/jvm/internal/impl/load/java/JavaVisibilities$1", "compareTo"));
            }
            if (this == visibility) {
                return 0;
            }
            if (Visibilities.isPrivate(visibility)) {
                return 1;
            }
            return -1;
        }

        @Override
        @NotNull
        public String getDisplayName() {
            if ("public/*package*/" == null) {
                throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/load/java/JavaVisibilities$1", "getDisplayName"));
            }
            return "public/*package*/";
        }

        @Override
        @NotNull
        public Visibility normalize() {
            Visibility visibility = Visibilities.PROTECTED;
            if (visibility == null) {
                throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/load/java/JavaVisibilities$1", "normalize"));
            }
            return visibility;
        }

        @Override
        @NotNull
        public EffectiveVisibility effectiveVisibility(@NotNull DeclarationDescriptor classDescriptor, boolean checkPublishedApi) {
            if (classDescriptor == null) {
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "classDescriptor", "kotlin/reflect/jvm/internal/impl/load/java/JavaVisibilities$1", "effectiveVisibility"));
            }
            EffectiveVisibility.PackagePrivate packagePrivate = EffectiveVisibility.PackagePrivate.INSTANCE;
            if (packagePrivate == null) {
                throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/load/java/JavaVisibilities$1", "effectiveVisibility"));
            }
            return packagePrivate;
        }
    };
    @NotNull
    public static final Visibility PROTECTED_STATIC_VISIBILITY = new Visibility("protected_static", true){

        @Override
        public boolean isVisible(@Nullable ReceiverValue receiver, @NotNull DeclarationDescriptorWithVisibility what, @NotNull DeclarationDescriptor from) {
            if (what == null) {
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "what", "kotlin/reflect/jvm/internal/impl/load/java/JavaVisibilities$2", "isVisible"));
            }
            if (from == null) {
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "from", "kotlin/reflect/jvm/internal/impl/load/java/JavaVisibilities$2", "isVisible"));
            }
            return JavaVisibilities.isVisibleForProtectedAndPackage(receiver, what, from);
        }

        @Override
        public boolean mustCheckInImports() {
            return false;
        }

        @Override
        @NotNull
        public String getDisplayName() {
            if ("protected/*protected static*/" == null) {
                throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/load/java/JavaVisibilities$2", "getDisplayName"));
            }
            return "protected/*protected static*/";
        }

        @Override
        @NotNull
        public Visibility normalize() {
            Visibility visibility = Visibilities.PROTECTED;
            if (visibility == null) {
                throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/load/java/JavaVisibilities$2", "normalize"));
            }
            return visibility;
        }
    };
    @NotNull
    public static final Visibility PROTECTED_AND_PACKAGE = new Visibility("protected_and_package", true){

        @Override
        public boolean isVisible(@Nullable ReceiverValue receiver, @NotNull DeclarationDescriptorWithVisibility what, @NotNull DeclarationDescriptor from) {
            if (what == null) {
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "what", "kotlin/reflect/jvm/internal/impl/load/java/JavaVisibilities$3", "isVisible"));
            }
            if (from == null) {
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "from", "kotlin/reflect/jvm/internal/impl/load/java/JavaVisibilities$3", "isVisible"));
            }
            return JavaVisibilities.isVisibleForProtectedAndPackage(receiver, what, from);
        }

        @Override
        public boolean mustCheckInImports() {
            return false;
        }

        @Override
        protected Integer compareTo(@NotNull Visibility visibility) {
            if (visibility == null) {
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "visibility", "kotlin/reflect/jvm/internal/impl/load/java/JavaVisibilities$3", "compareTo"));
            }
            if (this == visibility) {
                return 0;
            }
            if (visibility == Visibilities.INTERNAL) {
                return null;
            }
            if (Visibilities.isPrivate(visibility)) {
                return 1;
            }
            return -1;
        }

        @Override
        @NotNull
        public String getDisplayName() {
            if ("protected/*protected and package*/" == null) {
                throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/load/java/JavaVisibilities$3", "getDisplayName"));
            }
            return "protected/*protected and package*/";
        }

        @Override
        @NotNull
        public Visibility normalize() {
            Visibility visibility = Visibilities.PROTECTED;
            if (visibility == null) {
                throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/load/java/JavaVisibilities$3", "normalize"));
            }
            return visibility;
        }
    };

    private JavaVisibilities() {
    }

    private static boolean isVisibleForProtectedAndPackage(@Nullable ReceiverValue receiver, @NotNull DeclarationDescriptorWithVisibility what, @NotNull DeclarationDescriptor from) {
        if (what == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "what", "kotlin/reflect/jvm/internal/impl/load/java/JavaVisibilities", "isVisibleForProtectedAndPackage"));
        }
        if (from == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "from", "kotlin/reflect/jvm/internal/impl/load/java/JavaVisibilities", "isVisibleForProtectedAndPackage"));
        }
        if (JavaVisibilities.areInSamePackage(DescriptorUtils.unwrapFakeOverrideToAnyDeclaration(what), from)) {
            return true;
        }
        return Visibilities.PROTECTED.isVisible(receiver, what, from);
    }

    private static boolean areInSamePackage(@NotNull DeclarationDescriptor first, @NotNull DeclarationDescriptor second) {
        if (first == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "first", "kotlin/reflect/jvm/internal/impl/load/java/JavaVisibilities", "areInSamePackage"));
        }
        if (second == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "second", "kotlin/reflect/jvm/internal/impl/load/java/JavaVisibilities", "areInSamePackage"));
        }
        PackageFragmentDescriptor whatPackage = DescriptorUtils.getParentOfType(first, PackageFragmentDescriptor.class, false);
        PackageFragmentDescriptor fromPackage = DescriptorUtils.getParentOfType(second, PackageFragmentDescriptor.class, false);
        return fromPackage != null && whatPackage != null && whatPackage.getFqName().equals(fromPackage.getFqName());
    }
}

