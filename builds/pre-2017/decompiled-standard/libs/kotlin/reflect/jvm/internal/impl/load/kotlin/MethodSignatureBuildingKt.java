/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.load.kotlin;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.load.kotlin.SignatureBuildingComponents;
import org.jetbrains.annotations.NotNull;

public final class MethodSignatureBuildingKt {
    public static final <T> T signatures(@NotNull Function1<? super SignatureBuildingComponents, ? extends T> block) {
        Intrinsics.checkParameterIsNotNull(block, "block");
        SignatureBuildingComponents signatureBuildingComponents = SignatureBuildingComponents.INSTANCE;
        return block.invoke(signatureBuildingComponents);
    }
}

