/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.mods.ktcore.VecExtensionsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.client.Minecraft;
import net.minecraft.util.Vec3;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={1, 1, 7}, bv={1, 0, 2}, k=1, d1={"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u0018\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\f\u001a\u00020\rH\u0014J\u0010\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0014R\u000e\u0010\u0007\u001a\u00020\u0003X\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0003X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0013"}, d2={"Lgloomyfolken/mods/core/client/effects/FlashEffect;", "Lgloomyfolken/mods/effects/client/postprocess/effect/GameEffect;", "duration", "", "power", "", "(IF)V", "FLASH_FADE_IN_TICKS", "FLASH_FADE_OUT_TIME", "ticksActive", "renderUpdate", "", "manager", "Lgloomyfolken/mods/effects/client/postprocess/effect/GameEffectManager;", "immediateRenderParams", "Lgloomyfolken/mods/effects/client/postprocess/effect/GameEffectManager$ImmediateRenderParams;", "shouldEffectStop", "", "update", "minecraft"})
public final class uygf
extends bqzs {
    private int _a;
    private final int _b = 3;
    private final float _c = 0.325f;
    private final int _d;
    private final float _e;

    @Override
    protected void update(@NotNull jysc jysc2) {
        Intrinsics.checkParameterIsNotNull(jysc2, "manager");
        super.update(jysc2);
        jysc2._a(true);
        int n = this._a;
        this._a = n + 1;
    }

    @Override
    public void renderUpdate(@NotNull jysc jysc2, @NotNull jysc.eidj eidj2) {
        Intrinsics.checkParameterIsNotNull(jysc2, "manager");
        Intrinsics.checkParameterIsNotNull(eidj2, "immediateRenderParams");
        super.renderUpdate(jysc2, eidj2);
        double d = 0.0;
        double d2 = (double)this._a - 1.0 + (double)Minecraft._E()._p._d;
        double d3 = Math.max(d, d2);
        d2 = 1.0;
        double d4 = d3 / (double)this._b;
        d = Math.min(d2, d4);
        d4 = 1.0;
        double d5 = (d3 - (1.0 - (double)this._c) * (double)this._d) / (double)(this._c * (float)this._d);
        d2 = Math.min(d4, d5);
        d5 = 0.0;
        double d6 = 0.0;
        double d7 = d;
        double d8 = Math.max(d6, d2);
        d6 = d7 - d8;
        d4 = Math.max(d5, d6);
        Vec3 vec3 = eidj2._c();
        Vec3 vec32 = VecExtensionsKt.vec3(d4 * (double)this._e);
        Intrinsics.checkExpressionValueIsNotNull(vec32, "vec3(effectPower * power)");
        VecExtensionsKt.setMax(vec3, vec32);
    }

    @Override
    protected boolean shouldEffectStop(@NotNull jysc jysc2) {
        Intrinsics.checkParameterIsNotNull(jysc2, "manager");
        return this._a >= this._d;
    }

    public uygf(int n, float f) {
        super(null, 1, null);
        this._d = n;
        this._e = f;
        this._b = 3;
        this._c = 0.325f;
    }
}

