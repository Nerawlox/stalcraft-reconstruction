/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.descriptors;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorWithVisibility;
import kotlin.reflect.jvm.internal.impl.descriptors.DescriptorWithRelation;
import kotlin.reflect.jvm.internal.impl.descriptors.EffectiveVisibility;
import kotlin.reflect.jvm.internal.impl.descriptors.EffectiveVisibilityKt$WhenMappings;
import kotlin.reflect.jvm.internal.impl.descriptors.RelationToType;
import kotlin.reflect.jvm.internal.impl.descriptors.Visibilities;
import kotlin.reflect.jvm.internal.impl.descriptors.Visibility;
import kotlin.reflect.jvm.internal.impl.resolve.DescriptorUtils;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class EffectiveVisibilityKt {
    @NotNull
    public static final EffectiveVisibility.Permissiveness containerRelation(@Nullable ClassDescriptor first, @Nullable ClassDescriptor second) {
        return first == null || second == null ? EffectiveVisibility.Permissiveness.UNKNOWN : (Intrinsics.areEqual(first, second) ? EffectiveVisibility.Permissiveness.SAME : (DescriptorUtils.isSubclass(first, second) ? EffectiveVisibility.Permissiveness.LESS : (DescriptorUtils.isSubclass(second, first) ? EffectiveVisibility.Permissiveness.MORE : EffectiveVisibility.Permissiveness.UNKNOWN)));
    }

    private static final EffectiveVisibility lowerBound(EffectiveVisibility first, EffectiveVisibility second) {
        return first.lowerBound$kotlin_core(second);
    }

    /*
     * WARNING - void declaration
     */
    private static final EffectiveVisibility lowerBound(EffectiveVisibility first, List<? extends EffectiveVisibility> args) {
        void var3_3;
        Iterable $receiver$iv = args;
        EffectiveVisibility accumulator$iv = first;
        for (Object element$iv : $receiver$iv) {
            void y;
            EffectiveVisibility effectiveVisibility = (EffectiveVisibility)element$iv;
            EffectiveVisibility x = accumulator$iv;
            accumulator$iv = x.lowerBound$kotlin_core((EffectiveVisibility)y);
        }
        return (EffectiveVisibility)var3_3;
    }

    private static final EffectiveVisibility lowerBound(List<? extends EffectiveVisibility> args) {
        return args.isEmpty() ? (EffectiveVisibility)EffectiveVisibility.Public.INSTANCE : EffectiveVisibilityKt.lowerBound(CollectionsKt.first(args), args.subList(1, args.size()));
    }

    private static final EffectiveVisibility forVisibility(@NotNull Visibility $receiver, DeclarationDescriptor descriptor2, boolean checkPublishedApi) {
        EffectiveVisibility effectiveVisibility;
        Visibility visibility = $receiver;
        if (Intrinsics.areEqual(visibility, Visibilities.PRIVATE) || Intrinsics.areEqual(visibility, Visibilities.PRIVATE_TO_THIS) || Intrinsics.areEqual(visibility, Visibilities.INVISIBLE_FAKE)) {
            effectiveVisibility = EffectiveVisibility.Private.INSTANCE;
        } else if (Intrinsics.areEqual(visibility, Visibilities.PROTECTED)) {
            DeclarationDescriptor declarationDescriptor = descriptor2.getContainingDeclaration();
            if (!(declarationDescriptor instanceof ClassDescriptor)) {
                declarationDescriptor = null;
            }
            effectiveVisibility = new EffectiveVisibility.Protected((ClassDescriptor)declarationDescriptor);
        } else if (Intrinsics.areEqual(visibility, Visibilities.INTERNAL)) {
            effectiveVisibility = !checkPublishedApi || !DescriptorUtilsKt.isPublishedApi(descriptor2) ? (EffectiveVisibility)EffectiveVisibility.Internal.INSTANCE : (EffectiveVisibility)EffectiveVisibility.Public.INSTANCE;
        } else if (Intrinsics.areEqual(visibility, Visibilities.PUBLIC)) {
            effectiveVisibility = EffectiveVisibility.Public.INSTANCE;
        } else if (Intrinsics.areEqual(visibility, Visibilities.LOCAL)) {
            effectiveVisibility = EffectiveVisibility.Local.INSTANCE;
        } else {
            throw (Throwable)((Object)new AssertionError((Object)("Visibility " + $receiver.getName() + " is not allowed in forVisibility")));
        }
        return effectiveVisibility;
    }

    static /* bridge */ /* synthetic */ EffectiveVisibility forVisibility$default(Visibility visibility, DeclarationDescriptor declarationDescriptor, boolean bl, int n, Object object) {
        if ((n & 2) != 0) {
            bl = false;
        }
        return EffectiveVisibilityKt.forVisibility(visibility, declarationDescriptor, bl);
    }

    @NotNull
    public static final EffectiveVisibility effectiveVisibility(@NotNull Visibility visibility, @NotNull DeclarationDescriptor descriptor2, boolean checkPublishedApi) {
        Intrinsics.checkParameterIsNotNull(visibility, "visibility");
        Intrinsics.checkParameterIsNotNull(descriptor2, "descriptor");
        return EffectiveVisibilityKt.forVisibility(visibility, descriptor2, checkPublishedApi);
    }

    @NotNull
    public static /* bridge */ /* synthetic */ EffectiveVisibility effectiveVisibility$default(Visibility visibility, DeclarationDescriptor declarationDescriptor, boolean bl, int n, Object object) {
        if ((n & 4) != 0) {
            bl = false;
        }
        return EffectiveVisibilityKt.effectiveVisibility(visibility, declarationDescriptor, bl);
    }

    private static final Set<DescriptorWithRelation> dependentDescriptors(@NotNull ClassifierDescriptor $receiver, RelationToType ownRelation) {
        Object object;
        Set<DescriptorWithRelation> set = SetsKt.setOf(new DescriptorWithRelation($receiver, ownRelation));
        DeclarationDescriptor declarationDescriptor = $receiver.getContainingDeclaration();
        if (!(declarationDescriptor instanceof ClassifierDescriptor)) {
            declarationDescriptor = null;
        }
        return SetsKt.plus(set, (object = (ClassifierDescriptor)declarationDescriptor) != null && (object = EffectiveVisibilityKt.dependentDescriptors((ClassifierDescriptor)object, ownRelation.containerRelation())) != null ? (Iterable)object : (Iterable)SetsKt.emptySet());
    }

    @NotNull
    public static final EffectiveVisibility effectiveVisibility(@NotNull ClassDescriptor $receiver, boolean checkPublishedApi) {
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        return EffectiveVisibilityKt.effectiveVisibility($receiver, SetsKt.emptySet(), checkPublishedApi);
    }

    @NotNull
    public static /* bridge */ /* synthetic */ EffectiveVisibility effectiveVisibility$default(ClassDescriptor classDescriptor, boolean bl, int n, Object object) {
        if ((n & 1) != 0) {
            bl = false;
        }
        return EffectiveVisibilityKt.effectiveVisibility(classDescriptor, bl);
    }

    private static final EffectiveVisibility effectiveVisibility(@NotNull ClassDescriptor $receiver, Set<? extends ClassDescriptor> classes2, boolean checkPublishedApi) {
        EffectiveVisibility effectiveVisibility;
        if (classes2.contains($receiver)) {
            effectiveVisibility = EffectiveVisibility.Public.INSTANCE;
        } else {
            ClassDescriptor classDescriptor;
            DeclarationDescriptor declarationDescriptor = $receiver.getContainingDeclaration();
            if (!(declarationDescriptor instanceof ClassDescriptor)) {
                declarationDescriptor = null;
            }
            ClassDescriptor $receiver2 = classDescriptor = (ClassDescriptor)declarationDescriptor;
            EffectiveVisibility effectiveVisibility2 = $receiver.getVisibility().effectiveVisibility($receiver, checkPublishedApi);
            Object object = $receiver2;
            if (object == null || (object = EffectiveVisibilityKt.effectiveVisibility((ClassDescriptor)object, SetsKt.plus(classes2, $receiver), checkPublishedApi)) == null) {
                object = EffectiveVisibility.Public.INSTANCE;
            }
            effectiveVisibility = EffectiveVisibilityKt.lowerBound(effectiveVisibility2, (EffectiveVisibility)object);
        }
        return effectiveVisibility;
    }

    private static final Set<DescriptorWithRelation> dependentDescriptors(@NotNull KotlinType $receiver) {
        return EffectiveVisibilityKt.dependentDescriptors($receiver, SetsKt.emptySet(), RelationToType.CONSTRUCTOR);
    }

    /*
     * WARNING - void declaration
     */
    private static final Set<DescriptorWithRelation> dependentDescriptors(@NotNull KotlinType $receiver, Set<? extends KotlinType> types, RelationToType ownRelation) {
        void $receiver$iv$iv;
        Iterable $receiver$iv;
        if (types.contains($receiver)) {
            return SetsKt.emptySet();
        }
        Object object = $receiver.getConstructor().getDeclarationDescriptor();
        if (object == null || (object = EffectiveVisibilityKt.dependentDescriptors((ClassifierDescriptor)object, ownRelation)) == null) {
            object = SetsKt.emptySet();
        }
        Set<DescriptorWithRelation> ownDependent = object;
        Iterable iterable = $receiver$iv = (Iterable)$receiver.getArguments();
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($receiver$iv, 10));
        for (Object item$iv$iv : $receiver$iv$iv) {
            void it;
            TypeProjection typeProjection = (TypeProjection)item$iv$iv;
            Collection collection = destination$iv$iv;
            Set<DescriptorWithRelation> set = EffectiveVisibilityKt.dependentDescriptors(it.getType(), SetsKt.plus(types, $receiver), RelationToType.ARGUMENT);
            collection.add(set);
        }
        List argumentDependent = CollectionsKt.flatten((List)destination$iv$iv);
        return SetsKt.plus(ownDependent, argumentDependent);
    }

    private static final DescriptorWithRelation leastPermissive(@NotNull Set<DescriptorWithRelation> $receiver, EffectiveVisibility base) {
        for (DescriptorWithRelation descriptorWithRelation : $receiver) {
            EffectiveVisibility currentVisibility = descriptorWithRelation.effectiveVisibility();
            switch (EffectiveVisibilityKt$WhenMappings.$EnumSwitchMapping$0[currentVisibility.relation(base).ordinal()]) {
                case 1: 
                case 2: {
                    return descriptorWithRelation;
                }
            }
        }
        return null;
    }

    @Nullable
    public static final DescriptorWithRelation leastPermissiveDescriptor(@NotNull KotlinType $receiver, @NotNull EffectiveVisibility base) {
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        Intrinsics.checkParameterIsNotNull(base, "base");
        return EffectiveVisibilityKt.leastPermissive(EffectiveVisibilityKt.dependentDescriptors($receiver), base);
    }

    @NotNull
    public static final EffectiveVisibility effectiveVisibility(@NotNull DeclarationDescriptorWithVisibility $receiver, @NotNull Visibility visibility, boolean checkPublishedApi) {
        Object object;
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        Intrinsics.checkParameterIsNotNull(visibility, "visibility");
        EffectiveVisibility effectiveVisibility = visibility.effectiveVisibility($receiver, checkPublishedApi);
        DeclarationDescriptor declarationDescriptor = $receiver.getContainingDeclaration();
        if (!(declarationDescriptor instanceof ClassDescriptor)) {
            declarationDescriptor = null;
        }
        if ((object = (ClassDescriptor)declarationDescriptor) == null || (object = EffectiveVisibilityKt.effectiveVisibility((ClassDescriptor)object, checkPublishedApi)) == null) {
            object = EffectiveVisibility.Public.INSTANCE;
        }
        return EffectiveVisibilityKt.lowerBound(effectiveVisibility, (EffectiveVisibility)object);
    }

    @NotNull
    public static /* bridge */ /* synthetic */ EffectiveVisibility effectiveVisibility$default(DeclarationDescriptorWithVisibility declarationDescriptorWithVisibility, Visibility visibility, boolean bl, int n, Object object) {
        if ((n & 1) != 0) {
            Visibility visibility2 = declarationDescriptorWithVisibility.getVisibility();
            Intrinsics.checkExpressionValueIsNotNull(visibility2, "this.visibility");
            visibility = visibility2;
        }
        if ((n & 2) != 0) {
            bl = false;
        }
        return EffectiveVisibilityKt.effectiveVisibility(declarationDescriptorWithVisibility, visibility, bl);
    }
}

