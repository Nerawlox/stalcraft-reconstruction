/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement;

import java.util.Arrays;
import java.util.Map;
import kotlin.Pair;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.JavaTypeQualifiers;
import org.jetbrains.annotations.NotNull;

public final class TypeEnhancementInfo {
    @NotNull
    private final Map<Integer, JavaTypeQualifiers> map;

    @NotNull
    public final Map<Integer, JavaTypeQualifiers> getMap() {
        return this.map;
    }

    public TypeEnhancementInfo(@NotNull Map<Integer, JavaTypeQualifiers> map2) {
        Intrinsics.checkParameterIsNotNull(map2, "map");
        this.map = map2;
    }

    public TypeEnhancementInfo(Pair<Integer, JavaTypeQualifiers> ... pairs) {
        Intrinsics.checkParameterIsNotNull(pairs, "pairs");
        this(MapsKt.mapOf(Arrays.copyOf(pairs, pairs.length)));
    }
}

