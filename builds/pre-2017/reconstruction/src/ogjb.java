/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.mods.effects.client.main.eidj;
import gloomyfolken.mods.ktcore.VecExtensionsKt;
import java.util.Random;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.util.Vec3;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={1, 1, 7}, bv={1, 0, 2}, k=1, d1={"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u000e\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020)J\u0010\u0010*\u001a\u00020\b2\u0006\u0010+\u001a\u00020\bH\u0016J \u0010,\u001a\u00020\u000f2\u0006\u0010-\u001a\u00020\u000f2\u0006\u0010.\u001a\u00020\u000f2\u0006\u0010/\u001a\u00020\u000fH\u0016J\u0010\u00100\u001a\u00020\u00192\u0006\u00101\u001a\u00020\u000fH\u0016J\u0006\u00102\u001a\u00020\bJ\u000e\u00103\u001a\u00020'2\u0006\u00104\u001a\u000205J\b\u00106\u001a\u00020'H\u0002J\u0010\u00107\u001a\u0002082\u0006\u00101\u001a\u00020\u000fH\u0016J\b\u00109\u001a\u00020'H\u0016R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u000fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00190\u0018X\u0082\u000e\u00a2\u0006\u0004\n\u0002\u0010\u001aR\u000e\u0010\u001b\u001a\u00020\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u000fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u000e\u0010\"\u001a\u00020\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\u000fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006:"}, d2={"Lgloomyfolken/mods/stalker/misc/client/particle/artefacts/ParticleArtefakt;", "Lgloomyfolken/mods/effects/client/particle/Particle;", "emitter", "Lgloomyfolken/mods/stalker/misc/client/particle/artefacts/ParticleEmitterArtefakt;", "settings", "Lgloomyfolken/mods/stalker/misc/client/particle/artefacts/ArtefaktEmitterSettings;", "(Lgloomyfolken/mods/stalker/misc/client/particle/artefacts/ParticleEmitterArtefakt;Lgloomyfolken/mods/stalker/misc/client/particle/artefacts/ArtefaktEmitterSettings;)V", "alphaEnd", "", "alphaStart", "blueEnd", "blueStart", "getEmitter", "()Lgloomyfolken/mods/stalker/misc/client/particle/artefacts/ParticleEmitterArtefakt;", "endFrame", "", "endSize", "frameCount", "gravityX", "gravityY", "gravityZ", "greenEnd", "greenStart", "icons", "", "Lgloomyfolken/mods/effects/client/texture/EffectIcon;", "[Lgloomyfolken/mods/effects/client/texture/EffectIcon;", "lifespan", "redEnd", "redStart", "renderPassMask", "secondsExisted", "getSettings", "()Lgloomyfolken/mods/stalker/misc/client/particle/artefacts/ArtefaktEmitterSettings;", "spinEnd", "spinStart", "startFrame", "startSize", "addPos", "", "pos", "Lnet/minecraft/util/Vec3;", "getAlphaForRender", "frame", "getBrightness", "posX", "posY", "posZ", "getIcon", "renderPass", "getProgress", "init", "r", "Ljava/util/Random;", "progress", "shouldRenderInPass", "", "tick", "minecraft"})
public final class ogjb
extends ncyh {
    private float _a;
    private float _b;
    private float _c;
    private float _d;
    private float _e;
    private float _f;
    private float _g;
    private float _h;
    private float _i;
    private float _j;
    private float _k;
    private float _l;
    private float _m;
    private float _n;
    private float _o;
    private int _p;
    private int _q;
    private final int _r;
    private final int _s;
    private float _t;
    private float _u;
    private ejcz[] _v;
    @NotNull
    private final cuib _w;
    @NotNull
    private final ogjh _x;

    @Override
    @NotNull
    public ejcz getIcon(int n) {
        return this._v[(int)((double)((float)this._r * this._a()) * this._x._d()._s()) % this._r];
    }

    @Override
    public void tick() {
        this.prevAlpha = this.alpha;
        this.prevRed = this.red;
        this.prevGreen = this.green;
        this.prevBlue = this.blue;
        float f = this.motionX;
        float f2 = this.motionY;
        float f3 = this.motionZ;
        this.motionX *= this._x._d()._c();
        this.motionY *= this._x._d()._c();
        this.motionZ *= this._x._d()._c();
        super.tick();
        this.motionX = f * this._x._e()._b();
        this.motionY = f2 * this._x._e()._b();
        this.motionZ = f3 * this._x._e()._b();
        if (this._x._e()._a()) {
            Vec3 vec3 = this._w._c();
            this.posX = vec3._c;
            this.posY = vec3._d;
            this.posZ = vec3._e;
        }
        this._d();
        float f4 = 0.05f * this._x._d()._c();
        this._a += f4;
        this._a = owkq._b(this._a, 0.0f, this._b);
        if (this._a >= this._b) {
            this.isDead = true;
        }
    }

    public final void _a(@NotNull Vec3 vec3) {
        Intrinsics.checkParameterIsNotNull(vec3, "pos");
        this.posX += VecExtensionsKt.getX(vec3);
        this.posY += VecExtensionsKt.getY(vec3);
        this.posZ += VecExtensionsKt.getZ(vec3);
    }

    @Override
    public float getAlphaForRender(float f) {
        if ((this._s & 2) != 0) {
            float f2 = this.textureSize * this.textureSize;
            float f3 = 4096.0f / f2;
            float f4 = eidj._a(this.distanceSq, f3);
            float f5 = 30000.0f;
            float f6 = owkq._c(f4, f5);
            float f7 = owkq._c(owkq._b((float)Math.log10(owkq._d(owkq._d(f6))), 0.05f, 1.0f));
            return super.getAlphaForRender(f) * f7;
        }
        return super.getAlphaForRender(f);
    }

    @Override
    public boolean shouldRenderInPass(int n) {
        int n2 = owkq._c(n, 1);
        return (n2 & this._s) != 0;
    }

    @Override
    public int getBrightness(int n, int n2, int n3) {
        if ((this._s & 2) != 0) {
            return 0xF000F0;
        }
        return super.getBrightness(n, n2, n3);
    }

    private final void _d() {
        this.textureSize = owkq._c(this._a(), this._c, this._d);
        this.rotationSpeed = owkq._c(this._a(), this._t, this._u);
        this.red = owkq._c(this._a(), this._h, this._l);
        this.green = owkq._c(this._a(), this._i, this._m);
        this.blue = owkq._c(this._a(), this._j, this._n);
        this.alpha = owkq._c(this._a(), this._k, this._o);
        this._e = (float)owkq._a(this._a(), this._x._e()._i(), this._x._e()._l());
        this._f = (float)owkq._a(this._a(), this._x._e()._j(), this._x._e()._m());
        this._g = (float)owkq._a(this._a(), this._x._e()._k(), this._x._e()._n());
        this.motionX += this._e * this._x._d()._c();
        this.motionY += this._f * this._x._d()._c();
        this.motionZ += this._g * this._x._d()._c();
    }

    public final void _a(@NotNull Random random) {
        Intrinsics.checkParameterIsNotNull(random, "r");
        this._c = (float)((double)this._x._d()._f() + random.nextGaussian() * (double)this._x._d()._g());
        this._d = (float)((double)this._x._d()._h() + random.nextGaussian() * (double)this._x._d()._i());
        this._b = (float)((double)this._x._d()._d() + random.nextGaussian() * (double)this._x._d()._e());
        this._t = (float)((double)this._x._d()._m() + random.nextGaussian() * (double)this._x._d()._n());
        this._u = (float)((double)this._x._d()._o() + random.nextGaussian() * (double)this._x._d()._p());
        this.burn = (float)this._x._f()._a();
        if (this._c < 0.0f) {
            this._c = 0.0f;
        }
        if (this._d < 0.0f) {
            this._d = 0.0f;
        }
        this._h = (float)this._x._f()._c() / 255.0f;
        this._i = (float)this._x._f()._d() / 255.0f;
        this._j = (float)this._x._f()._e() / 255.0f;
        this._k = (float)this._x._f()._b() / 255.0f;
        this._l = (float)this._x._f()._g() / 255.0f;
        this._m = (float)this._x._f()._h() / 255.0f;
        this._n = (float)this._x._f()._i() / 255.0f;
        this._o = (float)this._x._f()._f() / 255.0f;
        this._p = this._x._d()._q();
        this._q = this._x._d()._r();
        if (this._p > this._q) {
            this._p = this._q;
        }
        if (this._p < 0) {
            this._p = 0;
        }
        this._d();
        this.prevRotation = this.rotation = this._x._d()._k() + (float)(random.nextGaussian() * (double)this._x._d()._l());
        this.prevBurn = this.burn;
        this.prevTextureSize = this.textureSize;
        this.prevAlpha = this.alpha;
        this.prevRed = this.red;
        this.prevGreen = this.green;
        this.prevBlue = this.blue;
        this.motionX = (float)(this._x._e()._c() + random.nextGaussian() * this._x._e()._d());
        this.motionY = (float)(this._x._e()._e() + random.nextGaussian() * this._x._e()._f());
        this.motionZ = (float)(this._x._e()._g() + random.nextGaussian() * this._x._e()._h());
    }

    public final float _a() {
        return this._a / this._b;
    }

    @NotNull
    public final cuib _b() {
        return this._w;
    }

    @NotNull
    public final ogjh _c() {
        return this._x;
    }

    public ogjb(@NotNull cuib cuib2, @NotNull ogjh ogjh2) {
        ejcz[] ejczArray;
        Intrinsics.checkParameterIsNotNull(cuib2, "emitter");
        Intrinsics.checkParameterIsNotNull(ogjh2, "settings");
        super(cuib2, 0.0f, 0.0f, null);
        this._w = cuib2;
        this._x = ogjh2;
        this._h = 1.0f;
        this._i = 1.0f;
        this._j = 1.0f;
        this._k = 1.0f;
        this._l = 1.0f;
        this._m = 1.0f;
        this._n = 1.0f;
        this._o = 1.0f;
        this._r = owkq._c(this._x._d()._r() - this._x._d()._q() + 1, 1);
        this._s = this._x._g();
        int n = this._r;
        ogjb ogjb2 = this;
        ejcz[] ejczArray2 = new ejcz[n];
        int n2 = 0;
        int n3 = n - 1;
        if (n2 <= n3) {
            do {
                ejcz ejcz2;
                int n4 = ++n2;
                int n5 = n2;
                ejczArray = ejczArray2;
                int n6 = n4 + this._x._d()._q();
                ejcz ejcz3 = this._r > 1 ? cujo._i.get("" + this._x._d()._j() + '_' + n6) : cujo._i.get(this._x._d()._j());
                if (ejcz3 == null) {
                    ejcz ejcz4 = cujo._h;
                    ejcz3 = ejcz4;
                    Intrinsics.checkExpressionValueIsNotNull(ejcz4, "StalkerIconList.missingIcon");
                }
                ejczArray[n5] = ejcz2 = ejcz3;
            } while (n2 != n3);
        }
        ejczArray = ejczArray2;
        ogjb2._v = ejczArray;
    }
}

