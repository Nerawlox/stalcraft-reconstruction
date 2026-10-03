/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.resolve;

import java.util.Collection;
import kotlin._Assertions;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Visibilities;
import org.jetbrains.annotations.NotNull;

public final class VisibilityUtilKt {
    @NotNull
    public static final CallableMemberDescriptor findMemberWithMaxVisibility(@NotNull Collection<? extends CallableMemberDescriptor> descriptors) {
        boolean bl;
        Intrinsics.checkParameterIsNotNull(descriptors, "descriptors");
        Collection<? extends CallableMemberDescriptor> collection = descriptors;
        boolean bl2 = bl = !collection.isEmpty();
        if (_Assertions.ENABLED && !bl) {
            String string = "Assertion failed";
            throw (Throwable)((Object)new AssertionError((Object)string));
        }
        CallableMemberDescriptor descriptor2 = null;
        for (CallableMemberDescriptor callableMemberDescriptor : descriptors) {
            if (descriptor2 == null) {
                descriptor2 = callableMemberDescriptor;
                continue;
            }
            Integer result2 = Visibilities.compare(descriptor2.getVisibility(), callableMemberDescriptor.getVisibility());
            if (result2 == null || Intrinsics.compare(result2, 0) >= 0) continue;
            descriptor2 = callableMemberDescriptor;
        }
        CallableMemberDescriptor callableMemberDescriptor = descriptor2;
        if (callableMemberDescriptor == null) {
            Intrinsics.throwNpe();
        }
        return callableMemberDescriptor;
    }
}

