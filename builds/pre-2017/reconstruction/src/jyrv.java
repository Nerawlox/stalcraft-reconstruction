/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.mods.ktcore.McExtensionsKt;
import gloomyfolken.mods.ktcore.VecExtensionsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityClientPlayerMP;
import net.minecraft.util.Vec3;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={1, 1, 7}, bv={1, 0, 2}, k=1, d1={"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0014J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0010\u001a\u00020\u0011H\u0014J\u0010\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0014R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u000e\u0010\u000b\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0015"}, d2={"Lgloomyfolken/mods/effects/client/postprocess/effect/DualityEffect;", "Lgloomyfolken/mods/effects/client/postprocess/effect/GameEffect;", "pos", "Lnet/minecraft/util/Vec3;", "effectRange", "", "modPower", "", "(Lnet/minecraft/util/Vec3;DF)V", "getPos", "()Lnet/minecraft/util/Vec3;", "power", "ticksLeft", "", "execute", "", "manager", "Lgloomyfolken/mods/effects/client/postprocess/effect/GameEffectManager;", "shouldEffectStop", "", "update", "minecraft"})
public final class jyrv
extends bqzs {
    private int _a;
    private final double _b;
    @NotNull
    private final Vec3 _c;

    @Override
    protected void execute(@NotNull jysc jysc2) {
        Intrinsics.checkParameterIsNotNull(jysc2, "manager");
    }

    @Override
    protected void update(@NotNull jysc jysc2) {
        Intrinsics.checkParameterIsNotNull(jysc2, "manager");
        double d = (double)this._a / 60.0;
        Vec3 vec3 = jysc._a(jysc2, 0.0, 1, null);
        if (this._b > 0.0) {
            jysc jysc3 = jysc2;
            jysc3._h(owkq._d(jysc3._h(), 0.35 * this._b));
            jysc jysc4 = jysc3;
            jysc4._c(jysc4._c() - 256.0 * this._b * VecExtensionsKt.getX(vec3) * d);
            jysc jysc5 = jysc3;
            jysc5._b(jysc5._b() - 256.0 * this._b * VecExtensionsKt.getY(vec3) * d);
            jysc3._d(owkq._d(jysc3._d(), 1.5 * this._b));
        }
        int n = this._a;
        this._a = n + -1;
    }

    @Override
    protected boolean shouldEffectStop(@NotNull jysc jysc2) {
        Intrinsics.checkParameterIsNotNull(jysc2, "manager");
        return this._a <= 0 || this._b <= 0.0;
    }

    @NotNull
    public final Vec3 _a() {
        return this._c;
    }

    public jyrv(@NotNull Vec3 vec3, double d, float f) {
        Intrinsics.checkParameterIsNotNull(vec3, "pos");
        super(null, 1, null);
        this._c = vec3;
        this._a = 60;
        EntityClientPlayerMP entityClientPlayerMP = Minecraft._E()._t;
        this._b = owkq._e(1.0, (entityClientPlayerMP != null ? McExtensionsKt.getDistanceToVector(entityClientPlayerMP, this._c) : 0.0) / d) * (double)f;
    }

    public /* synthetic */ jyrv(Vec3 vec3, double d, float f, int n, DefaultConstructorMarker defaultConstructorMarker) {
        if ((n & 4) != 0) {
            f = 1.0f;
        }
        this(vec3, d, f);
    }
}

