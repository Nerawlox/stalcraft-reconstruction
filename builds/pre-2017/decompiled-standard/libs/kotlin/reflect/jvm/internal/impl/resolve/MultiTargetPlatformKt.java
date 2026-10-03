/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.resolve;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.MemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.resolve.MultiTargetPlatform;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class MultiTargetPlatformKt {
    @Nullable
    public static final MultiTargetPlatform getMultiTargetPlatform(@NotNull ModuleDescriptor $receiver) {
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        return DescriptorUtilsKt.getModule($receiver).getCapability(MultiTargetPlatform.CAPABILITY);
    }

    @Nullable
    public static final String getMultiTargetPlatform(@NotNull MemberDescriptor $receiver) {
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        MultiTargetPlatform multiTargetPlatform = MultiTargetPlatformKt.getMultiTargetPlatform(DescriptorUtilsKt.getModule($receiver));
        if (!(multiTargetPlatform instanceof MultiTargetPlatform.Specific)) {
            multiTargetPlatform = null;
        }
        MultiTargetPlatform.Specific specific = (MultiTargetPlatform.Specific)multiTargetPlatform;
        return specific != null ? specific.getPlatform() : null;
    }
}

