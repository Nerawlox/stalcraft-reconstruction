/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.Result;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import org.jetbrains.annotations.NotNull;

final class SimpleResult
extends Result {
    @NotNull
    private final SimpleType type;

    @Override
    @NotNull
    public SimpleType getType() {
        return this.type;
    }

    public SimpleResult(@NotNull SimpleType type2, int subtreeSize, boolean wereChanges) {
        Intrinsics.checkParameterIsNotNull(type2, "type");
        super(type2, subtreeSize, wereChanges);
        this.type = type2;
    }
}

