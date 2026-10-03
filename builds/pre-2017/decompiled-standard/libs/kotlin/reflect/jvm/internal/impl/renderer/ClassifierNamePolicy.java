/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.renderer;

import java.util.ArrayList;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.name.FqNameUnsafe;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.renderer.DescriptorRenderer;
import kotlin.reflect.jvm.internal.impl.renderer.RenderingUtilsKt;
import kotlin.reflect.jvm.internal.impl.resolve.DescriptorUtils;
import org.jetbrains.annotations.NotNull;

public interface ClassifierNamePolicy {
    @NotNull
    public String renderClassifier(@NotNull ClassifierDescriptor var1, @NotNull DescriptorRenderer var2);

    public static final class SHORT
    implements ClassifierNamePolicy {
        public static final SHORT INSTANCE;

        @Override
        @NotNull
        public String renderClassifier(@NotNull ClassifierDescriptor classifier2, @NotNull DescriptorRenderer renderer) {
            Intrinsics.checkParameterIsNotNull(classifier2, "classifier");
            Intrinsics.checkParameterIsNotNull(renderer, "renderer");
            if (classifier2 instanceof TypeParameterDescriptor) {
                Name name2 = ((TypeParameterDescriptor)classifier2).getName();
                Intrinsics.checkExpressionValueIsNotNull(name2, "classifier.name");
                return renderer.renderName(name2);
            }
            ArrayList<Name> qualifiedNameElements = new ArrayList<Name>();
            DeclarationDescriptor current = classifier2;
            do {
                DeclarationDescriptor declarationDescriptor = current;
                if (declarationDescriptor == null) {
                    Intrinsics.throwNpe();
                }
                qualifiedNameElements.add(declarationDescriptor.getName());
            } while ((current = current.getContainingDeclaration()) instanceof ClassDescriptor);
            return RenderingUtilsKt.renderFqName(CollectionsKt.asReversedMutable((List)qualifiedNameElements));
        }

        private SHORT() {
            INSTANCE = this;
        }

        static {
            new SHORT();
        }
    }

    public static final class FULLY_QUALIFIED
    implements ClassifierNamePolicy {
        public static final FULLY_QUALIFIED INSTANCE;

        @Override
        @NotNull
        public String renderClassifier(@NotNull ClassifierDescriptor classifier2, @NotNull DescriptorRenderer renderer) {
            Intrinsics.checkParameterIsNotNull(classifier2, "classifier");
            Intrinsics.checkParameterIsNotNull(renderer, "renderer");
            if (classifier2 instanceof TypeParameterDescriptor) {
                Name name2 = ((TypeParameterDescriptor)classifier2).getName();
                Intrinsics.checkExpressionValueIsNotNull(name2, "classifier.name");
                return renderer.renderName(name2);
            }
            FqNameUnsafe fqNameUnsafe = DescriptorUtils.getFqName(classifier2);
            Intrinsics.checkExpressionValueIsNotNull(fqNameUnsafe, "DescriptorUtils.getFqName(classifier)");
            return renderer.renderFqName(fqNameUnsafe);
        }

        private FULLY_QUALIFIED() {
            INSTANCE = this;
        }

        static {
            new FULLY_QUALIFIED();
        }
    }

    public static final class SOURCE_CODE_QUALIFIED
    implements ClassifierNamePolicy {
        public static final SOURCE_CODE_QUALIFIED INSTANCE;

        @Override
        @NotNull
        public String renderClassifier(@NotNull ClassifierDescriptor classifier2, @NotNull DescriptorRenderer renderer) {
            Intrinsics.checkParameterIsNotNull(classifier2, "classifier");
            Intrinsics.checkParameterIsNotNull(renderer, "renderer");
            return this.qualifiedNameForSourceCode(classifier2);
        }

        @NotNull
        public final String qualifiedNameForSourceCode(@NotNull ClassifierDescriptor descriptor2) {
            Intrinsics.checkParameterIsNotNull(descriptor2, "descriptor");
            String nameString = RenderingUtilsKt.render(descriptor2.getName());
            if (descriptor2 instanceof TypeParameterDescriptor) {
                return nameString;
            }
            DeclarationDescriptor declarationDescriptor = descriptor2.getContainingDeclaration();
            Intrinsics.checkExpressionValueIsNotNull(declarationDescriptor, "descriptor.containingDeclaration");
            String qualifier = this.qualifierName(declarationDescriptor);
            return qualifier != null && Intrinsics.areEqual(qualifier, "") ^ true ? qualifier + "." + nameString : nameString;
        }

        private final String qualifierName(DeclarationDescriptor descriptor2) {
            DeclarationDescriptor declarationDescriptor = descriptor2;
            return declarationDescriptor instanceof ClassDescriptor ? this.qualifiedNameForSourceCode((ClassifierDescriptor)descriptor2) : (declarationDescriptor instanceof PackageFragmentDescriptor ? RenderingUtilsKt.render(((PackageFragmentDescriptor)descriptor2).getFqName().toUnsafe()) : null);
        }

        private SOURCE_CODE_QUALIFIED() {
            INSTANCE = this;
        }

        static {
            new SOURCE_CODE_QUALIFIED();
        }
    }
}

