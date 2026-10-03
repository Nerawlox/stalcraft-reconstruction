/*
 * Decompiled with CFR 0.152.
 */
import java.util.concurrent.ThreadLocalRandom;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.client.xpzm;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={1, 1, 7}, bv={1, 0, 2}, k=1, d1={"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u00a2\u0006\u0002\u0010\u0007J\u0010\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0014H\u0016J\b\u0010\u0018\u001a\u00020\u0019H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u0019\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u00a2\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0010\u0010\u0011R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0014X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001a"}, d2={"Lgloomyfolken/mods/stalker/misc/client/particle/explosion/ExplosionParticleFlash;", "Lgloomyfolken/mods/effects/client/particle/Particle;", "flash", "Lgloomyfolken/mods/stalker/misc/client/particle/explosion/ExplosionStageFlash;", "icons", "", "Lgloomyfolken/mods/effects/client/texture/EffectIcon;", "(Lgloomyfolken/mods/stalker/misc/client/particle/explosion/ExplosionStageFlash;[Lgloomyfolken/mods/effects/client/texture/EffectIcon;)V", "getFlash", "()Lgloomyfolken/mods/stalker/misc/client/particle/explosion/ExplosionStageFlash;", "flashScale", "", "getFlashScale", "()F", "setFlashScale", "(F)V", "getIcons", "()[Lgloomyfolken/mods/effects/client/texture/EffectIcon;", "[Lgloomyfolken/mods/effects/client/texture/EffectIcon;", "prevTicksExisted", "", "ticksLeft", "getIcon", "renderPass", "tick", "", "minecraft"})
public final class dxky
extends ncyh {
    private int _a;
    private int _b;
    private float _c;
    @NotNull
    private final cdhe _d;
    @NotNull
    private final ejcz[] _e;

    public final float _a() {
        return this._c;
    }

    public final void _a(float f) {
        this._c = f;
    }

    @Override
    public void tick() {
        this._a = this.ticksExisted;
        super.tick();
        dxky dxky2 = this;
        dxky2._b += -1;
        if (dxky2._b < 0) {
            this.isDead = true;
        }
        this.textureSize *= 1.01f;
        this.alpha *= this.alpha * 0.96f;
    }

    @Override
    @NotNull
    public ejcz getIcon(int n) {
        float f = owkq._c(xpzm._E()._p._d, (float)this._a * this._d._a()._a(), (float)this.ticksExisted * this._d._a()._a());
        return this._e[Math.min((int)f, ((Object[])this._e).length - 1)];
    }

    @NotNull
    public final cdhe _b() {
        return this._d;
    }

    @NotNull
    public final ejcz[] _c() {
        return this._e;
    }

    public dxky(@NotNull cdhe cdhe2, @NotNull ejcz[] ejczArray) {
        Intrinsics.checkParameterIsNotNull(cdhe2, "flash");
        Intrinsics.checkParameterIsNotNull(ejczArray, "icons");
        super(cdhe2, 0.3f, 1.5f, ejczArray[0]);
        this._d = cdhe2;
        this._e = ejczArray;
        this._b = (int)((float)((Object[])this._e).length / this._d._a()._a());
        ThreadLocalRandom threadLocalRandom = ThreadLocalRandom.current();
        this.setPosition(this._d.centerX, this._d.centerY, this._d.centerZ);
        this.burn = 1.0f;
        this.prevBurn = 1.0f;
        this.rotation = (float)(threadLocalRandom.nextGaussian() * (double)360);
    }
}

