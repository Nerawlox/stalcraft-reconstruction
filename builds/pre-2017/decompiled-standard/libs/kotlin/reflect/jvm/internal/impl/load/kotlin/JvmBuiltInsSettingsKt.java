/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.load.kotlin;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import org.jetbrains.annotations.NotNull;

public final class JvmBuiltInsSettingsKt {
    private static final boolean isAny(@NotNull ClassDescriptor $receiver) {
        return Intrinsics.areEqual(DescriptorUtilsKt.getFqNameUnsafe($receiver), KotlinBuiltIns.FQ_NAMES.any);
    }

    public static final /* synthetic */ boolean access$isAny$p(@NotNull ClassDescriptor $receiver) {
        return JvmBuiltInsSettingsKt.isAny($receiver);
    }
}

