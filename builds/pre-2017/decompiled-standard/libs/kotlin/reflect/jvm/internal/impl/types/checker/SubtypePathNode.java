/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.types.checker;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

final class SubtypePathNode {
    @NotNull
    private final KotlinType type;
    @Nullable
    private final SubtypePathNode previous;

    @NotNull
    public final KotlinType getType() {
        return this.type;
    }

    @Nullable
    public final SubtypePathNode getPrevious() {
        return this.previous;
    }

    public SubtypePathNode(@NotNull KotlinType type2, @Nullable SubtypePathNode previous) {
        Intrinsics.checkParameterIsNotNull(type2, "type");
        this.type = type2;
        this.previous = previous;
    }
}

