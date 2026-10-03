/*
 * Decompiled with CFR 0.152.
 */
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.client.Minecraft;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={1, 1, 7}, bv={1, 0, 2}, k=1, d1={"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u00a2\u0006\u0002\u0010\u0007J\u0010\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u000eH\u0016J\b\u0010\u0012\u001a\u00020\u0013H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0019\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u00a2\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000bR\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u000eX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0014"}, d2={"Lgloomyfolken/mods/stalker/misc/client/particle/explosion/ExplosionParticleDirt;", "Lgloomyfolken/mods/effects/client/particle/Particle;", "flash", "Lgloomyfolken/mods/stalker/misc/client/particle/explosion/ExplosionStageFlash;", "icons", "", "Lgloomyfolken/mods/effects/client/texture/EffectIcon;", "(Lgloomyfolken/mods/stalker/misc/client/particle/explosion/ExplosionStageFlash;[Lgloomyfolken/mods/effects/client/texture/EffectIcon;)V", "getFlash", "()Lgloomyfolken/mods/stalker/misc/client/particle/explosion/ExplosionStageFlash;", "getIcons", "()[Lgloomyfolken/mods/effects/client/texture/EffectIcon;", "[Lgloomyfolken/mods/effects/client/texture/EffectIcon;", "prevTicksExisted", "", "ticksLeft", "getIcon", "renderPass", "tick", "", "minecraft"})
public final class wobi
extends ncyh {
    private int _a;
    private int _b;
    @NotNull
    private final cdhe _c;
    @NotNull
    private final ejcz[] _d;

    @Override
    public void tick() {
        this._a = this.ticksExisted;
        super.tick();
        wobi wobi2 = this;
        wobi2._b += -1;
        if (wobi2._b < 0) {
            this.isDead = true;
        }
        this.alpha *= this.alpha * 0.96f;
    }

    @Override
    @NotNull
    public ejcz getIcon(int n) {
        float f = owkq._c(Minecraft._E()._p._d, (float)this._a * this._c._a()._a(), (float)this.ticksExisted * this._c._a()._a());
        return this._d[Math.min((int)f, ((Object[])this._d).length - 1)];
    }

    @NotNull
    public final cdhe _a() {
        return this._c;
    }

    @NotNull
    public final ejcz[] _b() {
        return this._d;
    }

    public wobi(@NotNull cdhe cdhe2, @NotNull ejcz[] ejczArray) {
        Intrinsics.checkParameterIsNotNull(cdhe2, "flash");
        Intrinsics.checkParameterIsNotNull(ejczArray, "icons");
        super(cdhe2, 0.3f, 0.9f, ejczArray[0]);
        this._c = cdhe2;
        this._d = ejczArray;
        this._b = (int)((float)((Object[])this._d).length / this._c._a()._a());
        this.setPosition(this._c.centerX, this._c.centerY, this._c.centerZ);
        this.burn = 1.0f;
        this.prevBurn = 1.0f;
    }
}

