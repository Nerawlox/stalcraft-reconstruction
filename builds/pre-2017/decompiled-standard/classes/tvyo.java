/*
 * Decompiled with CFR 0.152.
 */
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={1, 1, 7}, bv={1, 0, 2}, k=1, d1={"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\b\u0016\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\b\u0010\t\u001a\u00020\nH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b\u00a8\u0006\u000b"}, d2={"Lgloomyfolken/mods/stalker/misc/client/particle/explosion/ExplosionParticleGlow;", "Lgloomyfolken/mods/effects/client/particle/Particle;", "flash", "Lgloomyfolken/mods/stalker/misc/client/particle/explosion/ExplosionStageFlash;", "icon", "Lgloomyfolken/mods/effects/client/texture/EffectIcon;", "(Lgloomyfolken/mods/stalker/misc/client/particle/explosion/ExplosionStageFlash;Lgloomyfolken/mods/effects/client/texture/EffectIcon;)V", "getFlash", "()Lgloomyfolken/mods/stalker/misc/client/particle/explosion/ExplosionStageFlash;", "tick", "", "minecraft"})
public class tvyo
extends ncyh {
    @NotNull
    private final cdhe _a;

    @Override
    public void tick() {
        super.tick();
        this.textureSize *= 1.1f;
        this.alpha *= this.alpha * 0.8f;
        if ((double)this.alpha < 0.01) {
            this.isDead = true;
        }
    }

    @NotNull
    public final cdhe _a() {
        return this._a;
    }

    public tvyo(@NotNull cdhe cdhe2, @NotNull ejcz ejcz2) {
        Intrinsics.checkParameterIsNotNull(cdhe2, "flash");
        Intrinsics.checkParameterIsNotNull(ejcz2, "icon");
        super(cdhe2, 0.3f, 0.9f, ejcz2);
        this._a = cdhe2;
        this.setPosition(this._a.centerX, this._a.centerY, this._a.centerZ);
        this.burn = 1.0f;
        this.prevBurn = 1.0f;
    }
}

