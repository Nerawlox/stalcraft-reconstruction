/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

final class EnhancementResult<T> {
    private final T result;
    @Nullable
    private final Annotations enhancementAnnotations;

    public final T getResult() {
        return this.result;
    }

    @Nullable
    public final Annotations getEnhancementAnnotations() {
        return this.enhancementAnnotations;
    }

    public EnhancementResult(T result2, @Nullable Annotations enhancementAnnotations) {
        this.result = result2;
        this.enhancementAnnotations = enhancementAnnotations;
    }

    public final T component1() {
        return this.result;
    }

    @Nullable
    public final Annotations component2() {
        return this.enhancementAnnotations;
    }

    @NotNull
    public final EnhancementResult<T> copy(T result2, @Nullable Annotations enhancementAnnotations) {
        return new EnhancementResult<T>(result2, enhancementAnnotations);
    }

    @NotNull
    public static /* bridge */ /* synthetic */ EnhancementResult copy$default(EnhancementResult enhancementResult, Object object, Annotations annotations2, int n, Object object2) {
        if ((n & 1) != 0) {
            object = enhancementResult.result;
        }
        if ((n & 2) != 0) {
            annotations2 = enhancementResult.enhancementAnnotations;
        }
        return enhancementResult.copy(object, annotations2);
    }

    public String toString() {
        return "EnhancementResult(result=" + this.result + ", enhancementAnnotations=" + this.enhancementAnnotations + ")";
    }

    public int hashCode() {
        T t = this.result;
        Annotations annotations2 = this.enhancementAnnotations;
        return (t != null ? t.hashCode() : 0) * 31 + (annotations2 != null ? annotations2.hashCode() : 0);
    }

    public boolean equals(Object object) {
        block3: {
            block2: {
                if (this == object) break block2;
                if (!(object instanceof EnhancementResult)) break block3;
                EnhancementResult enhancementResult = (EnhancementResult)object;
                if (!Intrinsics.areEqual(this.result, enhancementResult.result) || !Intrinsics.areEqual(this.enhancementAnnotations, enhancementResult.enhancementAnnotations)) break block3;
            }
            return true;
        }
        return false;
    }
}

