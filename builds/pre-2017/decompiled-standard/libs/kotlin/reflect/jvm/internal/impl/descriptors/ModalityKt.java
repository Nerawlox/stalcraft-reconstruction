/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.descriptors;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassKind;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.resolve.DescriptorUtils;
import org.jetbrains.annotations.NotNull;

public final class ModalityKt {
    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static final boolean isOverridable(@NotNull CallableMemberDescriptor $receiver) {
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        if (!(Intrinsics.areEqual((Object)$receiver.getModality(), (Object)Modality.FINAL) ^ true)) return false;
        DeclarationDescriptor declarationDescriptor = $receiver.getContainingDeclaration();
        if (!(declarationDescriptor instanceof ClassDescriptor)) {
            declarationDescriptor = null;
        }
        ClassDescriptor classDescriptor = (ClassDescriptor)declarationDescriptor;
        if (!(Intrinsics.areEqual(classDescriptor != null ? Boolean.valueOf(ModalityKt.isFinalClass(classDescriptor)) : null, true) ^ true)) return false;
        return true;
    }

    public static final boolean isOverridableOrOverrides(@NotNull CallableMemberDescriptor $receiver) {
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        return ModalityKt.isOverridable($receiver) || DescriptorUtils.isOverride($receiver);
    }

    public static final boolean isFinalClass(@NotNull ClassDescriptor $receiver) {
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        return Intrinsics.areEqual((Object)$receiver.getModality(), (Object)Modality.FINAL) && Intrinsics.areEqual((Object)$receiver.getKind(), (Object)ClassKind.ENUM_CLASS) ^ true;
    }

    public static final boolean isFinalOrEnum(@NotNull ClassDescriptor $receiver) {
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        return Intrinsics.areEqual((Object)$receiver.getModality(), (Object)Modality.FINAL);
    }
}

