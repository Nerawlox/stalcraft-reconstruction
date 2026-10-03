/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.mods.ktcore.McExtensionsKt;
import gloomyfolken.mods.stalker.mobs.client.render.MutantsIconList;
import gloomyfolken.mods.stalker.mobs.client.render.particle.GenericDistortionParticle;
import java.util.Collection;
import java.util.concurrent.ThreadLocalRandom;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={1, 1, 7}, bv={1, 0, 2}, k=1, d1={"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\b\u0010\u0013\u001a\u00020\u0014H\u0016J\b\u0010\u0015\u001a\u00020\u0014H\u0016J\b\u0010\u0016\u001a\u00020\u0017H\u0016R\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u0011\u0010\r\u001a\u00020\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012\u00a8\u0006\u0018"}, d2={"Lgloomyfolken/mods/stalker/misc/client/particle/explosion/ExplosionStageFlash;", "Lgloomyfolken/mods/effects/client/particle/ParticleEmitter;", "world", "Lnet/minecraft/world/World;", "pos", "Lnet/minecraft/util/Vec3;", "(Lnet/minecraft/world/World;Lnet/minecraft/util/Vec3;)V", "emitterLifetime", "", "getEmitterLifetime", "()I", "setEmitterLifetime", "(I)V", "explosionPreset", "Lgloomyfolken/mods/stalker/misc/client/particle/explosion/ExplosionPreset;", "getExplosionPreset", "()Lgloomyfolken/mods/stalker/misc/client/particle/explosion/ExplosionPreset;", "getPos", "()Lnet/minecraft/util/Vec3;", "ignoreFrustrumTickCheck", "", "isValid", "tick", "", "minecraft"})
public final class cdhe
extends iekw {
    @NotNull
    private final badf _a;
    private int _b;
    @NotNull
    private final Vec3 _c;

    @NotNull
    public final badf _a() {
        return this._a;
    }

    public final int _b() {
        return this._b;
    }

    public final void _a(int n) {
        this._b = n;
    }

    @Override
    public void tick() {
        super.tick();
        int n = this._b;
        this._b = n + -1;
    }

    @Override
    public boolean isValid() {
        Collection collection;
        return this._b > 0 || !(collection = (Collection)this.particles).isEmpty();
    }

    @Override
    public boolean ignoreFrustrumTickCheck() {
        return true;
    }

    @NotNull
    public final Vec3 _c() {
        return this._c;
    }

    public cdhe(@NotNull World world, @NotNull Vec3 vec3) {
        ncyh ncyh2;
        int n;
        int n2;
        int n3;
        int n4;
        Object object;
        Intrinsics.checkParameterIsNotNull(world, "world");
        Intrinsics.checkParameterIsNotNull(vec3, "pos");
        super(world, null);
        this._c = vec3;
        this._a = badf._a._a();
        this._b = this._a._b();
        this.setCenter(this._c._c, this._c._d, this._c._e);
        this.setSize(2.0, 2.0, 2.0);
        float f = this._a._c();
        if (this._a._t()) {
            ejcz ejcz2 = cujo._f;
            Intrinsics.checkExpressionValueIsNotNull(ejcz2, "StalkerIconList.explosionGlowIcon");
            object = new tvyo(this, ejcz2);
            ((ncyh)object).textureSize *= f;
            ((ncyh)object).textureSize *= 1.2f;
            this.particles.add((ncyh)object);
            ejcz ejcz3 = cujo._f;
            Intrinsics.checkExpressionValueIsNotNull(ejcz3, "StalkerIconList.explosionGlowIcon");
            object = new tvyo(this, ejcz3);
            ((ncyh)object).textureSize *= f;
            ((ncyh)object).textureSize /= 1.25f;
            this.particles.add((ncyh)object);
            ejcz ejcz4 = cujo._f;
            Intrinsics.checkExpressionValueIsNotNull(ejcz4, "StalkerIconList.explosionGlowIcon");
            object = new tvyo(this, ejcz4);
            ((ncyh)object).textureSize *= f;
            ((ncyh)object).textureSize /= 1.5f;
            this.particles.add((ncyh)object);
        }
        object = ThreadLocalRandom.current();
        if (this._a._v()) {
            GenericDistortionParticle genericDistortionParticle = new GenericDistortionParticle(this, MutantsIconList.Companion.getFunnelDistortionIcon());
            genericDistortionParticle.setPosition(this._c._c, this._c._d, this._c._e);
            this.particles.add(genericDistortionParticle);
        }
        if ((n4 = 0) <= (n3 = (n2 = 0) - 1)) {
            while (true) {
                GenericDistortionParticle genericDistortionParticle = new GenericDistortionParticle(this, MutantsIconList.Companion.getFunnelDistortionIcon());
                genericDistortionParticle.rotation = (float)n4 * (360.0f / (float)n2);
                genericDistortionParticle.motionX = McExtensionsKt.cos(genericDistortionParticle.rotation);
                genericDistortionParticle.motionZ = McExtensionsKt.sin(genericDistortionParticle.rotation);
                genericDistortionParticle.setPosition(this._c._c, this._c._d, this._c._e);
                this.particles.add(genericDistortionParticle);
                if (n4 == n3) break;
                ++n4;
            }
        }
        if ((n3 = 0) <= (n = (n4 = 2) - 1)) {
            while (true) {
                ejcz ejcz5 = cujo._g;
                Intrinsics.checkExpressionValueIsNotNull(ejcz5, "StalkerIconList.explosionDirt");
                ncyh2 = new rpss(this, ejcz5);
                ncyh2.setPosition(this._c._c, this._c._d, this._c._e);
                ncyh2.textureSize *= this._a._s();
                ncyh2.textureSize *= f;
                ncyh2.rotation = ((ThreadLocalRandom)object).nextFloat() * this._a._r() - this._a._r() / 2.0f;
                ((rpss)ncyh2)._a(this._a._k() + ((ThreadLocalRandom)object).nextFloat() * this._a._n());
                ((rpss)ncyh2)._b(this._a._l() + ((ThreadLocalRandom)object).nextFloat() * this._a._o());
                ((rpss)ncyh2)._c(this._a._m() + ((ThreadLocalRandom)object).nextFloat() * this._a._p());
                this.particles.add(ncyh2);
                if (n3 == n) break;
                ++n3;
            }
        }
        n3 = 0;
        n = 89;
        while (true) {
            ssvn ssvn2;
            ejcz[] ejczArray = new ejcz[1];
            ejcz ejcz6 = cujo._a[1];
            Intrinsics.checkExpressionValueIsNotNull(ejcz6, "StalkerIconList.smokeIcons[1]");
            ejczArray[0] = ejcz6;
            Object[] objectArray = ejczArray;
            cdhe cdhe2 = this;
            ssvn ssvn3 = ssvn2;
            ssvn ssvn4 = ssvn2;
            Object[] objectArray2 = objectArray;
            ssvn3(cdhe2, (ejcz[])objectArray2);
            ncyh2 = ssvn4;
            ncyh2.textureSize *= f;
            ncyh2.motionX = McExtensionsKt.cos(ncyh2.rotation) * 0.0f + ((ThreadLocalRandom)object).nextFloat() * this._a._h() - this._a._h() / 2.0f;
            ncyh2.motionY = this._a._f() + ((ThreadLocalRandom)object).nextFloat() * this._a._i();
            ncyh2.motionZ = McExtensionsKt.sin(ncyh2.rotation) * 0.0f + ((ThreadLocalRandom)object).nextFloat() * this._a._j() - this._a._j() / 2.0f;
            this.particles.add(ncyh2);
            if (n3 == n) break;
            ++n3;
        }
    }
}

