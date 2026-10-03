/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.load.java.descriptors;

import java.util.List;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public interface JavaCallableMemberDescriptor
extends CallableMemberDescriptor {
    @NotNull
    public JavaCallableMemberDescriptor enhance(@Nullable KotlinType var1, @NotNull List<KotlinType> var2, @NotNull KotlinType var3);
}

