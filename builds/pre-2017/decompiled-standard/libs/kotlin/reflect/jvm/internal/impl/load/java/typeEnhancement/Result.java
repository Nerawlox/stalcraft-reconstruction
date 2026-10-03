/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.utils.addToStdlib.AddToStdlibKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

class Result {
    @NotNull
    private final KotlinType type;
    private final int subtreeSize;
    private final boolean wereChanges;

    @Nullable
    public final KotlinType getTypeIfChanged() {
        return AddToStdlibKt.check(this.getType(), (Function1)new Function1<KotlinType, Boolean>(this){
            final /* synthetic */ Result this$0;

            public final boolean invoke(@NotNull KotlinType it) {
                Intrinsics.checkParameterIsNotNull(it, "it");
                return this.this$0.getWereChanges();
            }
            {
                this.this$0 = result2;
                super(1);
            }
        });
    }

    @NotNull
    public KotlinType getType() {
        return this.type;
    }

    public final int getSubtreeSize() {
        return this.subtreeSize;
    }

    public final boolean getWereChanges() {
        return this.wereChanges;
    }

    public Result(@NotNull KotlinType type2, int subtreeSize, boolean wereChanges) {
        Intrinsics.checkParameterIsNotNull(type2, "type");
        this.type = type2;
        this.subtreeSize = subtreeSize;
        this.wereChanges = wereChanges;
    }
}

