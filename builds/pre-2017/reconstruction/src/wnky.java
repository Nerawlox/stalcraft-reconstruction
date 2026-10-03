/*
 * Decompiled with CFR 0.152.
 */
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={1, 1, 7}, bv={1, 0, 2}, k=1, d1={"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0014J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\u000bH\u0014J\u0010\u0010\u000e\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0014J\u000e\u0010\u000f\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u0006R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0003X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0010"}, d2={"Lgloomyfolken/mods/core/client/effects/DamageEffect;", "Lgloomyfolken/mods/effects/client/postprocess/effect/GameEffect;", "duration", "", "(I)V", "power", "", "ticksLeft", "execute", "", "manager", "Lgloomyfolken/mods/effects/client/postprocess/effect/GameEffectManager;", "shouldEffectStop", "", "update", "withPower", "minecraft"})
public final class wnky
extends bqzs {
    private int _a;
    private double _b;
    private final int _c;

    @NotNull
    public final wnky _a(double d) {
        this._b = d;
        return this;
    }

    @Override
    protected void execute(@NotNull jysc jysc2) {
        Intrinsics.checkParameterIsNotNull(jysc2, "manager");
        jysc jysc3 = jysc2;
        jysc3._c(jysc3._c() + this._b);
        jysc jysc4 = jysc2;
        jysc4._b(jysc4._b() + this._b);
        if (jysc2._n() < 0.65) {
            jysc jysc5 = jysc2;
            jysc5._l(jysc5._n() + 0.05);
        }
    }

    @Override
    protected void update(@NotNull jysc jysc2) {
        Intrinsics.checkParameterIsNotNull(jysc2, "manager");
        jysc jysc3 = jysc2;
        jysc3._c(jysc3._c() - this._b / (double)this._c);
        jysc jysc4 = jysc2;
        jysc4._b(jysc4._b() - this._b / (double)this._c);
        jysc jysc5 = jysc2;
        jysc5._l(jysc5._n() - 0.005 / (double)this._c);
        int n = this._a;
        this._a = n + -1;
    }

    @Override
    protected boolean shouldEffectStop(@NotNull jysc jysc2) {
        Intrinsics.checkParameterIsNotNull(jysc2, "manager");
        return this._a <= 0;
    }

    public wnky(int n) {
        super(null, 1, null);
        this._a = this._c = n;
        this._b = 2.25;
    }
}

