/*
 * Decompiled with CFR 0.152.
 */
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={1, 1, 7}, bv={1, 0, 2}, k=1, d1={"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0014J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0006H\u0014\u00a8\u0006\t"}, d2={"Lgloomyfolken/mods/weapon/client/effect/ThermalVisionEffect;", "Lgloomyfolken/mods/effects/client/postprocess/effect/GameEffect;", "()V", "shouldEffectStop", "", "manager", "Lgloomyfolken/mods/effects/client/postprocess/effect/GameEffectManager;", "update", "", "minecraft"})
public final class yuqm
extends bqzs {
    @Override
    protected void update(@NotNull jysc jysc2) {
        Intrinsics.checkParameterIsNotNull(jysc2, "manager");
        jysc jysc3 = jysc2;
        jysc3._h(1.0);
        jysc3._d(1.5);
    }

    @Override
    protected boolean shouldEffectStop(@NotNull jysc jysc2) {
        Intrinsics.checkParameterIsNotNull(jysc2, "manager");
        return false;
    }

    public yuqm() {
        super("thermalVision");
    }
}

