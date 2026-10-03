/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import org.jetbrains.annotations.NotNull;

final class PartEnhancementResult {
    @NotNull
    private final KotlinType type;
    private final boolean wereChanges;

    @NotNull
    public final KotlinType getType() {
        return this.type;
    }

    public final boolean getWereChanges() {
        return this.wereChanges;
    }

    public PartEnhancementResult(@NotNull KotlinType type2, boolean wereChanges) {
        Intrinsics.checkParameterIsNotNull(type2, "type");
        this.type = type2;
        this.wereChanges = wereChanges;
    }

    @NotNull
    public final KotlinType component1() {
        return this.type;
    }

    public final boolean component2() {
        return this.wereChanges;
    }

    @NotNull
    public final PartEnhancementResult copy(@NotNull KotlinType type2, boolean wereChanges) {
        Intrinsics.checkParameterIsNotNull(type2, "type");
        return new PartEnhancementResult(type2, wereChanges);
    }

    @NotNull
    public static /* bridge */ /* synthetic */ PartEnhancementResult copy$default(PartEnhancementResult partEnhancementResult, KotlinType kotlinType, boolean bl, int n, Object object) {
        if ((n & 1) != 0) {
            kotlinType = partEnhancementResult.type;
        }
        if ((n & 2) != 0) {
            bl = partEnhancementResult.wereChanges;
        }
        return partEnhancementResult.copy(kotlinType, bl);
    }

    public String toString() {
        return "PartEnhancementResult(type=" + this.type + ", wereChanges=" + this.wereChanges + ")";
    }

    public int hashCode() {
        KotlinType kotlinType = this.type;
        int n = (kotlinType != null ? ((Object)kotlinType).hashCode() : 0) * 31;
        int n2 = this.wereChanges ? 1 : 0;
        if (n2 != 0) {
            n2 = 1;
        }
        return n + n2;
    }

    public boolean equals(Object object) {
        block3: {
            block2: {
                if (this == object) break block2;
                if (!(object instanceof PartEnhancementResult)) break block3;
                PartEnhancementResult partEnhancementResult = (PartEnhancementResult)object;
                if (!Intrinsics.areEqual(this.type, partEnhancementResult.type) || !(this.wereChanges == partEnhancementResult.wereChanges)) break block3;
            }
            return true;
        }
        return false;
    }
}

