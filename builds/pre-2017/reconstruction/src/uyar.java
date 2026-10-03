/*
 * Decompiled with CFR 0.152.
 */
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={1, 1, 7}, bv={1, 0, 2}, k=1, d1={"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0018\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\n\u001a\u00020\u000bH\u0014J\u0010\u0010\u0010\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0014R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u000e\u0010\u0007\u001a\u00020\u0003X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0011"}, d2={"Lgloomyfolken/mods/anomaly/client/effect/TeleportEffect;", "Lgloomyfolken/mods/effects/client/postprocess/effect/GameEffect;", "ticks", "", "(I)V", "getTicks", "()I", "ticksToGo", "renderUpdate", "", "manager", "Lgloomyfolken/mods/effects/client/postprocess/effect/GameEffectManager;", "immediateRenderParams", "Lgloomyfolken/mods/effects/client/postprocess/effect/GameEffectManager$ImmediateRenderParams;", "shouldEffectStop", "", "update", "minecraft"})
public final class uyar
extends bqzs {
    private int _a;
    private final int _b;

    @Override
    protected void update(@NotNull jysc jysc2) {
        Intrinsics.checkParameterIsNotNull(jysc2, "manager");
        super.update(jysc2);
        jysc2._a(true);
        int n = this._a;
        this._a = n + -1;
    }

    @Override
    protected boolean shouldEffectStop(@NotNull jysc jysc2) {
        Intrinsics.checkParameterIsNotNull(jysc2, "manager");
        return false;
    }

    @Override
    public void renderUpdate(@NotNull jysc jysc2, @NotNull jysc.eidj eidj2) {
        Intrinsics.checkParameterIsNotNull(jysc2, "manager");
        Intrinsics.checkParameterIsNotNull(eidj2, "immediateRenderParams");
        double d = owkq._b((double)(this._b - this._a) / (double)this._b, 0.0, 1.0);
        jysc2._u(owkq._d(jysc2._w(), d));
    }

    public final int _a() {
        return this._b;
    }

    public uyar(int n) {
        super("teleport");
        this._a = this._b = n;
    }
}

