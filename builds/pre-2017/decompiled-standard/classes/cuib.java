/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.mods.ktcore.McExtensionsKt;
import gloomyfolken.mods.ktcore.VecExtensionsKt;
import java.util.HashMap;
import java.util.Random;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.util.ofbx;
import org.jetbrains.annotations.NotNull;
import org.lwjgl.util.vector.Vector3f;

@Metadata(mv={1, 1, 7}, bv={1, 0, 2}, k=1, d1={"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u0006\u0010\u001c\u001a\u00020\u0011J\b\u0010\u001d\u001a\u00020\bH\u0016J\b\u0010\u001e\u001a\u00020\bH\u0016J\u0010\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u001aH\u0002J\b\u0010\"\u001a\u00020 H\u0016J\u0006\u0010#\u001a\u00020 R$\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\b@BX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0010\u001a\n \u0012*\u0004\u0018\u00010\u00110\u0011X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0015\u001a\n \u0012*\u0004\u0018\u00010\u00110\u0011X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0016\u0010\u0018\u001a\n \u0012*\u0004\u0018\u00010\u00110\u0011X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u001b\u001a\n \u0012*\u0004\u0018\u00010\u00110\u0011X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006$"}, d2={"Lgloomyfolken/mods/stalker/misc/client/particle/artefacts/ParticleEmitterArtefakt;", "Lgloomyfolken/mods/effects/client/particle/ParticleEmitter;", "system", "Lgloomyfolken/mods/stalker/misc/client/particle/artefacts/ArtefaktEffectSystem;", "settings", "Lgloomyfolken/mods/stalker/misc/client/particle/artefacts/ArtefaktEmitterSettings;", "(Lgloomyfolken/mods/stalker/misc/client/particle/artefacts/ArtefaktEffectSystem;Lgloomyfolken/mods/stalker/misc/client/particle/artefacts/ArtefaktEmitterSettings;)V", "<set-?>", "", "active", "getActive", "()Z", "setActive", "(Z)V", "newParticlesFrac", "", "prevSpawnPos", "Lnet/minecraft/util/Vec3;", "kotlin.jvm.PlatformType", "getSettings", "()Lgloomyfolken/mods/stalker/misc/client/particle/artefacts/ArtefaktEmitterSettings;", "spawnPos", "getSystem", "()Lgloomyfolken/mods/stalker/misc/client/particle/artefacts/ArtefaktEffectSystem;", "temp", "totalSpawnedParticles", "", "v", "getBoundBonePosition", "ignoreFrustrumTickCheck", "isValid", "spawnParticles", "", "newParticles", "tick", "updatePos", "minecraft"})
public final class cuib
extends iekw {
    private float _a;
    private final ofbx _b;
    private final ofbx _c;
    private final ofbx _d;
    private final ofbx _e;
    private int _f;
    private boolean _g;
    @NotNull
    private final oxkw _h;
    @NotNull
    private final ogjh _i;

    public final boolean _a() {
        return this._g;
    }

    private final void _a(boolean bl) {
        this._g = bl;
    }

    public final void _b() {
        ofbx ofbx2 = this._c;
        Intrinsics.checkExpressionValueIsNotNull(ofbx2, "spawnPos");
        VecExtensionsKt.set(this._b, ofbx2);
        VecExtensionsKt.set(this._c, this._c());
        this.setCenter(this._c._c, this._c._d, this._c._e);
        this.setSize(3.0, 5.0, 3.0);
    }

    @NotNull
    public final ofbx _c() {
        VecExtensionsKt.set(this._e, McExtensionsKt.getPos(this._h._c()));
        VecExtensionsKt.subl(this._e, 0.0, 0.1, 0.0);
        Object object = xqrn._a(this._h._c());
        if (object != null && (object = ((xqrn)object)._b) != null) {
            Object object2 = object;
            Object object3 = object2;
            Object object4 = ((ogej)object3)._a();
            if (object4 == null || (object4 = ((jhuw)object4).getSkeleton()) == null || (object4 = ((jywl)object4)._a()) == null || (object4 = ((HashMap)object4).get(this._i._c()._b())) == null) {
            } else {
                Object object5 = object4;
                ivtm ivtm2 = ((ogej)object3)._a(0.0f);
                if (ivtm2 == null) {
                } else {
                    ivtm ivtm3 = ivtm2;
                    Vector3f vector3f = ivtm3._a[((jywl.kjui)object5)._c];
                    Intrinsics.checkExpressionValueIsNotNull(vector3f, "skeleton.translations[bone.index]");
                    VecExtensionsKt.set(this._d, vector3f);
                    ofbx ofbx2 = this._d;
                    Intrinsics.checkExpressionValueIsNotNull(ofbx2, "v");
                    VecExtensionsKt.addl(this._e, ofbx2);
                }
            }
        }
        ofbx ofbx3 = this._e;
        Intrinsics.checkExpressionValueIsNotNull(ofbx3, "temp");
        return ofbx3;
    }

    @Override
    public void tick() {
        ogjh.ezey ezey2;
        super.tick();
        this._b();
        if (!this._i._a() || !this._g) {
            return;
        }
        ogjh.ezey ezey3 = ezey2 = this._i._c();
        this._a += ezey3._d() * this._i._d()._c();
        int n = (int)owkq._i(this._a);
        this._a -= (float)n;
        int n2 = Math.min(n, ezey3._c() - this.particles.size());
        this._a(n2);
    }

    private final void _a(int n) {
        this._f += n;
        Random random = this.world.field_73012_v;
        int n2 = 0;
        int n3 = n - 1;
        if (n2 <= n3) {
            while (true) {
                ogjh.ezey ezey2;
                ogjb ogjb2 = new ogjb(this, this._i);
                ogjh.ezey ezey3 = ezey2 = this._i._c();
                ogjb2.setPosition(this.centerX + (double)ezey3._e() + random.nextGaussian() * (double)ezey3._f(), this.centerY + (double)ezey3._g() + random.nextGaussian() * (double)ezey3._h(), this.centerZ + (double)ezey3._i() + random.nextGaussian() * (double)ezey3._j());
                Random random2 = random;
                Intrinsics.checkExpressionValueIsNotNull(random2, "r");
                ogjb2._a(random2);
                this.particles.add(ogjb2);
                if (n2 == n3) break;
                ++n2;
            }
        }
        if (this._i._c()._a() && this._f >= this._i._c()._c()) {
            this._g = false;
        }
    }

    @Override
    public boolean isValid() {
        return this._h.isValid();
    }

    @Override
    public boolean ignoreFrustrumTickCheck() {
        return true;
    }

    @NotNull
    public final oxkw _d() {
        return this._h;
    }

    @NotNull
    public final ogjh _e() {
        return this._i;
    }

    public cuib(@NotNull oxkw oxkw2, @NotNull ogjh ogjh2) {
        Intrinsics.checkParameterIsNotNull(oxkw2, "system");
        Intrinsics.checkParameterIsNotNull(ogjh2, "settings");
        super(oxkw2.world, null);
        this._h = oxkw2;
        this._i = ogjh2;
        this._b = VecExtensionsKt.vec3();
        this._c = VecExtensionsKt.vec3();
        this._d = VecExtensionsKt.vec3();
        this._e = VecExtensionsKt.vec3();
        this._g = true;
        this._b();
    }
}

