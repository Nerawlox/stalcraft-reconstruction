/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.mods.asm.GloomyLoadingPlugin;
import gloomyfolken.mods.ejection.kjui;
import gloomyfolken.mods.ktcore.VecExtensionsKt;
import gloomyfolken.mods.stalker.misc.tupg;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.client.entity.EntityClientPlayerMP;
import net.minecraft.client.xpzm;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ofbx;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={1, 1, 7}, bv={1, 0, 2}, k=1, d1={"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"H\u0016J\u0010\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&H\u0014J\u0010\u0010'\u001a\u00020 2\u0006\u0010%\u001a\u00020&H\u0014J\u0010\u0010(\u001a\u00020 2\u0006\u0010)\u001a\u00020*H\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u000e\u0010\f\u001a\u00020\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0016\u0010\r\u001a\n \u000f*\u0004\u0018\u00010\u000e0\u000eX\u0082\u0004\u00a2\u0006\u0002\n\u0000R$\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u0004@BX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0006\"\u0004\b\u0013\u0010\bR\u000e\u0010\u0014\u001a\u00020\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0015\u001a\n \u000f*\u0004\u0018\u00010\u000e0\u000eX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0018\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0006\"\u0004\b\u001a\u0010\bR$\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u0004@BX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0006\"\u0004\b\u001d\u0010\bR\u0016\u0010\u001e\u001a\n \u000f*\u0004\u0018\u00010\u000e0\u000eX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006+"}, d2={"Lgloomyfolken/mods/stalker/misc/client/effect/NightVisionEffect;", "Lgloomyfolken/mods/effects/client/postprocess/effect/GameEffect;", "()V", "blur", "", "getBlur", "()D", "setBlur", "(D)V", "noise", "getNoise", "setNoise", "noiseToRemove", "nv_AddColor", "Lnet/minecraft/util/Vec3;", "kotlin.jvm.PlatformType", "<set-?>", "nv_DirtContrast", "getNv_DirtContrast", "setNv_DirtContrast", "nv_FogAmount", "nv_FogColor", "nv_FogEnd", "nv_FogStart", "nv_GlitchAmount", "getNv_GlitchAmount", "setNv_GlitchAmount", "nv_LensAmount", "getNv_LensAmount", "setNv_LensAmount", "nv_ScreenColor", "loadCustomEffectSettings", "", "settings", "Lgloomyfolken/mods/effects/client/postprocess/effect/CustomEffectSettings;", "shouldEffectStop", "", "manager", "Lgloomyfolken/mods/effects/client/postprocess/effect/GameEffectManager;", "update", "updateSettingsFromEquipment", "player", "Lnet/minecraft/entity/player/EntityPlayer;", "minecraft"})
public final class pjna
extends bqzs {
    private final ofbx _a = VecExtensionsKt.vec3(0.1);
    private double _b;
    private double _c;
    private double _d = 32.0;
    private double _e;
    private double _f = 1.75;
    private double _g;
    private double _h;
    private double _i;
    private final ofbx _j = VecExtensionsKt.vec3(0.025, 0.0875, 0.035);
    private final ofbx _k = VecExtensionsKt.vec3(0.44, 3.6, 0.72);
    private double _l;

    public final double _a() {
        return this._e;
    }

    private final void _d(double d) {
        this._e = d;
    }

    public final double _b() {
        return this._f;
    }

    private final void _e(double d) {
        this._f = d;
    }

    public final double _c() {
        return this._g;
    }

    public final void _a(double d) {
        this._g = d;
    }

    public final double _d() {
        return this._h;
    }

    public final void _b(double d) {
        this._h = d;
    }

    public final double _e() {
        return this._i;
    }

    public final void _c(double d) {
        this._i = d;
    }

    @Override
    public void loadCustomEffectSettings(@NotNull oxbc oxbc2) {
        double d;
        double d2;
        ofbx ofbx2;
        Intrinsics.checkParameterIsNotNull(oxbc2, "settings");
        ofbx ofbx3 = VecExtensionsKt.vec3(0.025, 0.0875, 0.035);
        Intrinsics.checkExpressionValueIsNotNull(ofbx3, "vec3(0.025, 0.0875, 0.035)");
        ofbx ofbx4 = ofbx2 = oxbc2._a("nv_add_color", ofbx3);
        VecExtensionsKt.set(this._j, ofbx4);
        ofbx ofbx5 = VecExtensionsKt.vec3(0.44, 3.6, 0.72);
        Intrinsics.checkExpressionValueIsNotNull(ofbx5, "vec3(0.44, 3.6, 0.72)");
        ofbx4 = ofbx2 = oxbc2._a("nv_screen_color", ofbx5);
        VecExtensionsKt.set(this._k, ofbx4);
        this._h = d2 = (d = oxbc2._a("noise", 0.0));
        this._i = d2 = (d = oxbc2._a("blur", 0.0));
        this._e = d2 = (d = oxbc2._a("nv_lens_amount", 1.0));
        this._g = d2 = (d = oxbc2._a("nv_glitch_amount", 0.0));
        ofbx ofbx6 = VecExtensionsKt.vec3(0.0);
        Intrinsics.checkExpressionValueIsNotNull(ofbx6, "vec3(0.0)");
        ofbx4 = ofbx2 = oxbc2._a("nv_fog_color", ofbx6);
        VecExtensionsKt.set(this._a, ofbx4);
        this._b = d2 = (d = oxbc2._a("nv_fog_amount", 0.0));
        this._c = d2 = (d = oxbc2._a("nv_fog_start", 0.0));
        this._d = d2 = (d = oxbc2._a("nv_fog_end", 32.0));
        this._f = d2 = (d = oxbc2._a("nv_dirt_constrast", 0.0));
    }

    private final void _a(EntityPlayer entityPlayer) {
        Object v2;
        block3: {
            Iterable iterable = CollectionsKt.filterNotNull((Iterable)CollectionsKt.listOf(new cvzo[]{entityPlayer.func_82169_q(3), entityPlayer.func_82169_q(2)}));
            for (Object t : iterable) {
                cvzo cvzo2 = (cvzo)t;
                tgdv tgdv2 = cvzo2._a();
                if (!(tgdv2 instanceof dgmz)) {
                    tgdv2 = null;
                }
                dgmz dgmz2 = (dgmz)tgdv2;
                if (!(dgmz2 != null ? dgmz2._j : false)) continue;
                v2 = t;
                break block3;
            }
            v2 = null;
        }
        cvzo cvzo3 = v2;
        if (cvzo3 == null) {
            return;
        }
        cvzo cvzo4 = cvzo3;
        this.setCurrentEffectSettings(iefo._a._a(cvzo4._d));
    }

    @Override
    protected void update(@NotNull jysc jysc2) {
        Intrinsics.checkParameterIsNotNull(jysc2, "manager");
        EntityClientPlayerMP entityClientPlayerMP = xpzm._E()._t;
        if (entityClientPlayerMP == null) {
            return;
        }
        EntityClientPlayerMP entityClientPlayerMP2 = entityClientPlayerMP;
        tupg tupg2 = tupg._a(entityClientPlayerMP2);
        boolean bl = tupg2._l;
        if (bl) {
            this._a(entityClientPlayerMP2);
            float f = 0.0f;
            if (!GloomyLoadingPlugin._a) {
                f = kjui._a._d * 30.0f;
                float cfr_ignored_0 = (float)owkq._d(kjui._a._b != null) * 0.2f;
                f += tupg2._z * (float)40;
            }
            jysc2._i(jysc2._i() + 0.5);
            jysc2._j(this._e);
            ofbx ofbx2 = jysc2._j();
            ofbx ofbx3 = this._k;
            Intrinsics.checkExpressionValueIsNotNull(ofbx3, "nv_ScreenColor");
            VecExtensionsKt.set(ofbx2, ofbx3);
            ofbx ofbx4 = jysc2._k();
            ofbx ofbx5 = this._j;
            Intrinsics.checkExpressionValueIsNotNull(ofbx5, "nv_AddColor");
            VecExtensionsKt.set(ofbx4, ofbx5);
            jysc2._p(this._e);
            jysc2._k(owkq._b(this._g + (double)f, 0.0, 1.0));
            double d = this._h;
            double d2 = jysc2._o();
            jysc jysc3 = jysc2;
            double d3 = Math.max(d, d2);
            jysc3._m(d3);
            d = this._i;
            d2 = jysc2._p();
            jysc3 = jysc2;
            d3 = Math.max(d, d2);
            jysc3._n(d3);
            this._l = jysc2._o();
        } else {
            double d = 0.0;
            double d4 = jysc2._o() - this._l;
            jysc jysc4 = jysc2;
            double d5 = Math.max(d, d4);
            jysc4._m(d5);
            this._l = 0.0;
        }
    }

    @Override
    protected boolean shouldEffectStop(@NotNull jysc jysc2) {
        Intrinsics.checkParameterIsNotNull(jysc2, "manager");
        return false;
    }

    public pjna() {
        super("night_vision");
    }
}

