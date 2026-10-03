/*
 * Decompiled with CFR 0.152.
 */
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={1, 1, 7}, bv={1, 0, 2}, k=1, d1={"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\b\u0010\u0017\u001a\u00020\u0018H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\t\u001a\u00020\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u000b\u001a\u00020\fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u000e\"\u0004\b\u0013\u0010\u0010R\u001a\u0010\u0014\u001a\u00020\fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u000e\"\u0004\b\u0016\u0010\u0010\u00a8\u0006\u0019"}, d2={"Lgloomyfolken/mods/stalker/misc/client/particle/explosion/ExplosionParticleFlares;", "Lgloomyfolken/mods/effects/client/particle/Particle;", "flash", "Lgloomyfolken/mods/stalker/misc/client/particle/explosion/ExplosionStageFlash;", "icon", "Lgloomyfolken/mods/effects/client/texture/EffectIcon;", "(Lgloomyfolken/mods/stalker/misc/client/particle/explosion/ExplosionStageFlash;Lgloomyfolken/mods/effects/client/texture/EffectIcon;)V", "getFlash", "()Lgloomyfolken/mods/stalker/misc/client/particle/explosion/ExplosionStageFlash;", "prevTicksExisted", "", "stretchMotionX", "", "getStretchMotionX", "()F", "setStretchMotionX", "(F)V", "stretchMotionY", "getStretchMotionY", "setStretchMotionY", "stretchMotionZ", "getStretchMotionZ", "setStretchMotionZ", "tick", "", "minecraft"})
public final class rpss
extends ncyh {
    private int _a;
    private float _b;
    private float _c;
    private float _d;
    @NotNull
    private final cdhe _e;

    public final float _a() {
        return this._b;
    }

    public final void _a(float f) {
        this._b = f;
    }

    public final float _b() {
        return this._c;
    }

    public final void _b(float f) {
        this._c = f;
    }

    public final float _c() {
        return this._d;
    }

    public final void _c(float f) {
        this._d = f;
    }

    @Override
    public void tick() {
        super.tick();
        this.textureSize += this._c;
        this.motionY -= 0.1f;
        this.textureSize *= 1.1f;
        this.alpha *= 0.8f;
        this._c *= 0.85f;
        this.textureSize += this._c * 0.05f;
        if ((double)this.alpha < 0.075) {
            this.isDead = true;
        }
    }

    @NotNull
    public final cdhe _d() {
        return this._e;
    }

    public rpss(@NotNull cdhe cdhe2, @NotNull ejcz ejcz2) {
        Intrinsics.checkParameterIsNotNull(cdhe2, "flash");
        Intrinsics.checkParameterIsNotNull(ejcz2, "icon");
        super(cdhe2, 0.3f, 0.9f, ejcz2);
        this._e = cdhe2;
        this.setPosition(this._e.centerX, this._e.centerY, this._e.centerZ);
        this.motionY = 0.5f;
    }
}

