/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.descriptors;

import java.util.Collection;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.VariableAccessorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.VariableDescriptorWithAccessors;
import kotlin.reflect.jvm.internal.impl.utils.CollectionsKt;
import org.jetbrains.annotations.NotNull;

public final class VariableDescriptorWithAccessorsKt {
    @NotNull
    public static final List<VariableAccessorDescriptor> getAccessors(@NotNull VariableDescriptorWithAccessors $receiver) {
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        return kotlin.collections.CollectionsKt.plus((Collection)CollectionsKt.singletonOrEmptyList($receiver.getGetter()), (Iterable)CollectionsKt.singletonOrEmptyList($receiver.getSetter()));
    }
}

