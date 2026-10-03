/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.core.entity;

import gloomyfolken.bundle.common.core.InvokeSideOnly;
import gloomyfolken.bundle.common.core.eidj;
import gloomyfolken.bundle.common.core.ezey;
import gloomyfolken.mods.core.entity.EntityAdvancedThrowable;
import gloomyfolken.mods.core.entity.qlgf;
import gloomyfolken.mods.core.misc.ybzs;
import gloomyfolken.mods.ktcore.McExtensionsKt;
import gloomyfolken.mods.ktcore.VecExtensionsKt;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.client.xpzm;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ofbx;
import net.minecraft.util.sajh;
import net.minecraftforge.common.IExtendedEntityProperties;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={1, 1, 7}, bv={1, 0, 2}, k=1, d1={"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 s2\u00020\u0001:\u0001sB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010C\u001a\u0002032\u0006\u0010D\u001a\u00020EJ\b\u0010F\u001a\u00020GH\u0002J\u0010\u0010H\u001a\u00020G2\u0006\u0010I\u001a\u00020JH\u0002J\u000e\u0010K\u001a\u00020L2\u0006\u0010M\u001a\u00020LJ\u000e\u0010N\u001a\u00020L2\u0006\u0010M\u001a\u00020LJ\u000e\u0010O\u001a\u00020J2\u0006\u0010P\u001a\u00020\u0014J\u0012\u0010Q\u001a\u0004\u0018\u00010J2\b\u0010P\u001a\u0004\u0018\u00010\u0014J\u000e\u0010R\u001a\u00020S2\u0006\u0010T\u001a\u00020LJ\"\u0010U\u001a\u00020S2\u0006\u0010T\u001a\u00020L2\b\b\u0002\u0010V\u001a\u00020L2\b\b\u0002\u0010W\u001a\u00020LJ\u001c\u0010X\u001a\u00020G2\b\u0010\u0002\u001a\u0004\u0018\u00010Y2\b\u0010Z\u001a\u0004\u0018\u00010[H\u0016J\u0012\u0010\\\u001a\u00020G2\b\u0010]\u001a\u0004\u0018\u00010^H\u0016J\u0018\u0010_\u001a\u00020G2\u0006\u0010P\u001a\u00020\u00142\b\b\u0002\u0010`\u001a\u00020\u0006J\"\u0010a\u001a\u00020G2\u0006\u0010P\u001a\u00020\u00142\u0006\u0010b\u001a\u00020\u00062\b\b\u0002\u0010`\u001a\u00020\u0006H\u0007J\u0006\u0010c\u001a\u00020GJ\u0006\u0010d\u001a\u00020GJ\u0012\u0010e\u001a\u00020G2\b\u0010]\u001a\u0004\u0018\u00010^H\u0016J$\u00107\u001a\u00020G2\u0006\u0010P\u001a\u00020\u00142\b\b\u0002\u0010`\u001a\u00020\u00062\b\b\u0002\u0010f\u001a\u00020\u0006H\u0002J\u0006\u0010g\u001a\u00020GJ\b\u0010h\u001a\u0004\u0018\u00010iJ$\u0010j\u001a\u0004\u0018\u00010i2\b\u0010P\u001a\u0004\u0018\u00010\u00142\u0006\u0010\r\u001a\u00020\u00062\b\b\u0002\u0010k\u001a\u000203J\u0006\u0010l\u001a\u00020GJ\u0010\u0010m\u001a\u00020G2\u0006\u0010n\u001a\u000203H\u0002J\u0010\u0010o\u001a\u00020G2\u0006\u0010n\u001a\u000203H\u0002J&\u0010p\u001a\u00020G2\u0006\u0010T\u001a\u00020L2\n\b\u0002\u0010I\u001a\u0004\u0018\u00010J2\b\b\u0002\u0010q\u001a\u00020LH\u0007J\b\u0010r\u001a\u00020GH\u0007R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082D\u00a2\u0006\u0002\n\u0000R$\u0010\b\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006@BX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u000e\u0010\r\u001a\u00020\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\n\"\u0004\b\u0012\u0010\fR\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001a\u0010\u0019\u001a\u00020\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\n\"\u0004\b\u001b\u0010\fR\u000e\u0010\u001c\u001a\u00020\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R$\u0010\u001d\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006@BX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\n\"\u0004\b\u001f\u0010\fR\u001a\u0010 \u001a\u00020\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\n\"\u0004\b\"\u0010\fR\u001a\u0010#\u001a\u00020\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\n\"\u0004\b%\u0010\fR\u0011\u0010&\u001a\u00020'\u00a2\u0006\b\n\u0000\u001a\u0004\b(\u0010)R\u001a\u0010*\u001a\u00020+X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R$\u00100\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006@BX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b1\u0010\n\"\u0004\b2\u0010\fR$\u00104\u001a\u0002032\u0006\u0010\u0007\u001a\u000203@BX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b5\u00106\"\u0004\b7\u00108R$\u00109\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006@BX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b:\u0010\n\"\u0004\b;\u0010\fR(\u0010<\u001a\u0004\u0018\u00010\u00142\b\u0010\u0007\u001a\u0004\u0018\u00010\u0014@BX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b=\u0010\u0016\"\u0004\b>\u0010\u0018R\u001a\u0010?\u001a\u00020\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b@\u0010\n\"\u0004\bA\u0010\fR\u000e\u0010B\u001a\u000203X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006t"}, d2={"Lgloomyfolken/mods/core/entity/WeaponUser;", "Lnet/minecraftforge/common/IExtendedEntityProperties;", "entity", "Lnet/minecraft/entity/EntityLivingBase;", "(Lnet/minecraft/entity/EntityLivingBase;)V", "THROW_HINT_TIME_TICKS", "", "<set-?>", "autothrowTicksLeft", "getAutothrowTicksLeft", "()I", "setAutothrowTicksLeft", "(I)V", "chargeTime", "getEntity", "()Lnet/minecraft/entity/EntityLivingBase;", "lastSwingType", "getLastSwingType", "setLastSwingType", "lastSwungStack", "Lnet/minecraft/item/ItemStack;", "getLastSwungStack", "()Lnet/minecraft/item/ItemStack;", "setLastSwungStack", "(Lnet/minecraft/item/ItemStack;)V", "nextAttackTime", "getNextAttackTime", "setNextAttackTime", "prevChargeTime", "subtractedChargeTime", "getSubtractedChargeTime", "setSubtractedChargeTime", "throwDisableUpdateHintTicks", "getThrowDisableUpdateHintTicks", "setThrowDisableUpdateHintTicks", "throwHintTicksLeft", "getThrowHintTicksLeft", "setThrowHintTicksLeft", "throwSimParams", "Lgloomyfolken/mods/core/entity/ThrowSimulationParams;", "getThrowSimParams", "()Lgloomyfolken/mods/core/entity/ThrowSimulationParams;", "throwStartMs", "", "getThrowStartMs", "()J", "setThrowStartMs", "(J)V", "throwTimeStart", "getThrowTimeStart", "setThrowTimeStart", "", "throwing", "getThrowing", "()Z", "setThrowing", "(Z)V", "throwingSlot", "getThrowingSlot", "setThrowingSlot", "throwingStack", "getThrowingStack", "setThrowingStack", "ticksBeforeHit", "getTicksBeforeHit", "setTicksBeforeHit", "wantThrow", "checkThrowingItemInInventory", "inventoryPlayer", "Lnet/minecraft/entity/player/InventoryPlayer;", "doMeleeHit", "", "doTickThrowable", "throwable", "Lgloomyfolken/mods/core/misc/ItemThrowable;", "getChargedProgress", "", "frame", "getOverchargedProgress", "getThrowableItem", "itemStack", "getThrowableItemOrNull", "getThrowableSpawnPos", "Lnet/minecraft/util/Vec3;", "partialTime", "getThrowableStartVelocity", "speedFactor", "additionalPitchDegrees", "init", "Lnet/minecraft/entity/Entity;", "world", "Lnet/minecraft/world/World;", "loadNBTData", "compound", "Lnet/minecraft/nbt/NBTTagCompound;", "prepareThrowItem", "autoThrowTimeout", "prepareThrowItemFromSlot", "slotId", "resetMeleeStats", "resetThrowStats", "saveNBTData", "overrideSlotId", "setWantThrow", "throwActiveThrowingItem", "Lgloomyfolken/mods/core/entity/EntityAdvancedThrowable;", "throwItem", "force", "tick", "tickMelee", "reset", "tickThrowable", "updateThrowSimParams", "overridePower", "updateThrownHint", "Companion", "minecraft"})
public final class jxtc
implements IExtendedEntityProperties {
    private int _b;
    private int _c;
    @Nullable
    private cvzo _d;
    private int _e;
    private int _f;
    private int _g;
    private int _h;
    private int _i;
    private int _j;
    private boolean _k;
    @Nullable
    private cvzo _l;
    private int _m;
    private long _n;
    @NotNull
    private final qlgf _o;
    private final int _p = 20;
    private int _q;
    private int _r;
    private boolean _s;
    @NotNull
    private final EntityLivingBase _t;
    @NotNull
    private static final String _u = "abstract_weapon";
    public static final kjui _a = new kjui(null);

    public final int _a() {
        return this._b;
    }

    public final void _a(int n) {
        this._b = n;
    }

    public final int _b() {
        return this._c;
    }

    public final void _b(int n) {
        this._c = n;
    }

    @Nullable
    public final cvzo _c() {
        return this._d;
    }

    public final void _a(@Nullable cvzo cvzo2) {
        this._d = cvzo2;
    }

    public final int _d() {
        return this._e;
    }

    public final void _c(int n) {
        this._e = n;
    }

    public final int _e() {
        return this._f;
    }

    private final void _f(int n) {
        this._f = n;
    }

    public final int _f() {
        return this._g;
    }

    private final void _g(int n) {
        this._g = n;
    }

    public final int _g() {
        return this._j;
    }

    private final void _h(int n) {
        this._j = n;
    }

    public final boolean _h() {
        return this._k;
    }

    private final void _a(boolean bl) {
        this._k = bl;
    }

    @Nullable
    public final cvzo _i() {
        return this._l;
    }

    private final void _d(cvzo cvzo2) {
        this._l = cvzo2;
    }

    public final int _j() {
        return this._m;
    }

    private final void _i(int n) {
        this._m = n;
    }

    public final long _k() {
        return this._n;
    }

    public final void _a(long l) {
        this._n = l;
    }

    @NotNull
    public final qlgf _l() {
        return this._o;
    }

    public final int _m() {
        return this._q;
    }

    public final void _d(int n) {
        this._q = n;
    }

    public final int _n() {
        return this._r;
    }

    public final void _e(int n) {
        this._r = n;
    }

    public final void _o() {
        this._l = null;
        this._f = -1;
        this._g = this._t.field_70173_aa;
        this._i = -1;
        this._h = -1;
        this._k = false;
        this._s = false;
        InvokeSideOnly.client(new InvokeSideOnly.InvokeClientOnly(){

            @Override
            public final void run() {
                if (this._u().field_70170_p.field_72995_K && Intrinsics.areEqual(this._u(), xpzm._E()._t)) {
                    zfvg._f._a()._a(false);
                }
            }
        });
    }

    public final void _p() {
        this._b = -1;
        this._d = null;
    }

    public final void _q() {
        boolean bl = false;
        if (!this._t.func_70089_S()) {
            bl = true;
        }
        this._b(bl);
        this._c(bl);
        int n = this._q;
        this._q = n + -1;
        n = this._r;
        this._r = n + -1;
    }

    private final void _b(boolean bl) {
        cvzo cvzo2;
        boolean bl2 = bl;
        if (this._t instanceof EntityPlayer && ((cvzo2 = ((EntityPlayer)this._t).func_71045_bC()) == null || !(cvzo2._a() instanceof cdse) || this._d != null && Intrinsics.areEqual(cvzo2, this._d) ^ true)) {
            bl2 = true;
        }
        if (bl2) {
            this._p();
        } else if (this._b >= 0) {
            jxtc jxtc2 = this;
            jxtc2._b += -1;
            if (jxtc2._b == -1) {
                this._x();
            }
        }
    }

    private final void _c(boolean bl) {
        Object object;
        boolean bl2 = bl;
        if (this._t instanceof EntityPlayer && ((object = ((EntityPlayer)this._t).func_71045_bC()) == null || !(((cvzo)object)._a() instanceof ybzs) || this._l != null && Intrinsics.areEqual(object, this._l) ^ true)) {
            bl2 = true;
        }
        if (bl2) {
            this._o();
        } else {
            object = this._b(this._l);
            if (this._k && object != null) {
                this._a((ybzs)object);
            } else {
                this._k = false;
                this._i = -1;
                this._h = -1;
            }
        }
    }

    /*
     * Unable to fully structure code
     */
    private final void _a(ybzs var1_1) {
        this._h = owkq._c(this._i, 0);
        this._i = var1_1._b(this, false);
        if (this._h == 0 && this._i == 1) {
            var1_1._a(this);
        }
        v0 = this._l;
        if (v0 == null) {
            Intrinsics.throwNpe();
        }
        if (var1_1._b(v0, this, this._i)) {
            this._o();
            return;
        }
        if (this._f < 0) ** GOTO lbl-1000
        v1 = this;
        v1._f += -1;
        if (v1._f == -1) {
            v2 = true;
        } else lbl-1000:
        // 2 sources

        {
            v2 = var2_2 = false;
        }
        if ((var2_2 || this._s) && this._i > 0) {
            this._t();
        }
    }

    @ezey(_a={eidj.CLIENT})
    public final void _a(float f, @Nullable ybzs ybzs2, float f2) {
        if (this._r <= 0) {
            ybzs ybzs3;
            cvzo cvzo2 = this._l;
            tgdv tgdv2 = cvzo2 != null ? cvzo2._a() : null;
            if (!(tgdv2 instanceof ybzs)) {
                tgdv2 = null;
            }
            if ((ybzs3 = (ybzs)tgdv2) == null) {
                ybzs3 = ybzs2;
            }
            if (ybzs3 == null) {
                return;
            }
            ybzs ybzs4 = ybzs3;
            float f3 = f2;
            if (ybzs2 == null) {
                f3 = ybzs4._c(owkq._c(f, owkq._n(this._h), owkq._n(this._i)));
            }
            VecExtensionsKt.set(this._o._c(), this._a(f));
            VecExtensionsKt.set(this._o._b(), this._a(f, ybzs4._i() * f3, ybzs4._l()));
            this._q = 2;
        }
    }

    @ezey(_a={eidj.CLIENT})
    public static /* bridge */ /* synthetic */ void _a(jxtc jxtc2, float f, ybzs ybzs2, float f2, int n, Object object) {
        if ((n & 2) != 0) {
            ybzs2 = null;
        }
        if ((n & 4) != 0) {
            f2 = 1.0f;
        }
        jxtc2._a(f, ybzs2, f2);
    }

    @NotNull
    public final ofbx _a(float f) {
        ofbx ofbx2 = VecExtensionsKt.vec3();
        VecExtensionsKt.set(ofbx2, VecExtensionsKt.lerp(f, McExtensionsKt.getPrevPos(this._t), McExtensionsKt.getPos(this._t)));
        VecExtensionsKt.addl(ofbx2, 0.0, (double)this._t.func_70047_e(), 0.0);
        float f2 = 0.017453294f;
        ofbx2._d -= 0.15;
        if (!this._t.field_70170_p.field_72995_K) {
            ofbx2._d += 0.12;
        }
        ofbx2._c -= (double)sajh._b(this._t.field_70177_z * f2) * 0.2;
        ofbx2._e -= (double)sajh._a(this._t.field_70177_z * f2) * 0.2;
        ofbx2._c -= (double)sajh._a(this._t.field_70177_z * f2) * 0.25 * (double)sajh._b(this._t.field_70125_A * f2);
        ofbx2._e += (double)sajh._b(this._t.field_70177_z * f2) * 0.25 * (double)sajh._b(this._t.field_70125_A * f2);
        ofbx ofbx3 = ofbx2;
        Intrinsics.checkExpressionValueIsNotNull(ofbx3, "pos");
        return ofbx3;
    }

    @NotNull
    public final ofbx _a(float f, float f2, float f3) {
        ofbx ofbx2 = VecExtensionsKt.vec3();
        float f4 = f2;
        float f5 = Math.max(owkq._c(f, this._t.field_70127_C, this._t.field_70125_A) + f3, -90.0f);
        float f6 = owkq._c(f, this._t.field_70758_at, this._t.field_70759_as);
        ofbx2._c = -sajh._a(f6 / 180.0f * (float)Math.PI) * sajh._b(f5 / 180.0f * (float)Math.PI) * f4;
        ofbx2._e = sajh._b(f6 / 180.0f * (float)Math.PI) * sajh._b(f5 / 180.0f * (float)Math.PI) * f4;
        ofbx2._d = -sajh._a(f5 / 180.0f * (float)Math.PI) * f4;
        ofbx ofbx3 = ofbx2;
        Intrinsics.checkExpressionValueIsNotNull(ofbx3, "vel");
        return ofbx3;
    }

    @NotNull
    public static /* bridge */ /* synthetic */ ofbx _a(jxtc jxtc2, float f, float f2, float f3, int n, Object object) {
        if ((n & 2) != 0) {
            f2 = 1.0f;
        }
        if ((n & 4) != 0) {
            f3 = 0.0f;
        }
        return jxtc2._a(f, f2, f3);
    }

    private final void _x() {
        InvokeSideOnly.frontend(!this._t.field_70170_p.field_72995_K, new InvokeSideOnly.InvokeFrontendOnly(){

            @Override
            public final void run() {
            }
        });
    }

    public final void _a(@NotNull cvzo cvzo2, int n) {
        Intrinsics.checkParameterIsNotNull(cvzo2, "itemStack");
        if (!this._k) {
            jxtc._b(this, cvzo2, n, 0, 4, null);
        }
    }

    public static /* bridge */ /* synthetic */ void _a(jxtc jxtc2, cvzo cvzo2, int n, int n2, Object object) {
        if ((n2 & 2) != 0) {
            n = -1;
        }
        jxtc2._a(cvzo2, n);
    }

    @ezey(_a={eidj.CLIENT})
    public final void _a(@NotNull cvzo cvzo2, int n, int n2) {
        Intrinsics.checkParameterIsNotNull(cvzo2, "itemStack");
        if (!this._k) {
            this._b(cvzo2, n2, n);
        }
    }

    @ezey(_a={eidj.CLIENT})
    public static /* bridge */ /* synthetic */ void _a(jxtc jxtc2, cvzo cvzo2, int n, int n2, int n3, Object object) {
        if ((n3 & 4) != 0) {
            n2 = -1;
        }
        jxtc2._a(cvzo2, n, n2);
    }

    private final void _b(cvzo cvzo2, int n, final int n2) {
        if (!(cvzo2._a() instanceof ybzs)) {
            throw (Throwable)new IllegalArgumentException("Item to throw must be an instance of ItemThrowable. " + cvzo2._a() + " isn't!");
        }
        if (cvzo2._a() instanceof yurw) {
            tgdv tgdv2 = cvzo2._a();
            if (tgdv2 == null) {
                throw new TypeCastException("null cannot be cast to non-null type gloomyfolken.mods.weapon.item.ItemGrenade");
            }
            if (!((yurw)tgdv2)._m) {
                return;
            }
        }
        this._l = cvzo2;
        this._k = true;
        this._g = this._t.field_70173_aa;
        this._f = -1;
        if (n > 0) {
            this._f = n + this._j;
        }
        this._c(cvzo2)._a(false, this._t);
        this._j = this._c(cvzo2)._m();
        InvokeSideOnly.client(this._t.field_70170_p.field_72995_K, new InvokeSideOnly.InvokeClientOnly(){

            @Override
            public final void run() {
                new ivlc(n2).sendToServer();
            }
        });
    }

    static /* bridge */ /* synthetic */ void _b(jxtc jxtc2, cvzo cvzo2, int n, int n2, int n3, Object object) {
        if ((n3 & 2) != 0) {
            n = -1;
        }
        if ((n3 & 4) != 0) {
            n2 = -1;
        }
        jxtc2._b(cvzo2, n, n2);
    }

    public final void _r() {
        this._s = true;
    }

    @ezey(_a={eidj.CLIENT})
    public final void _s() {
        this._r = 0;
        jxtc._a(this, 1.0f, null, 0.0f, 6, null);
        this._r = this._p;
        this._q = this._p;
    }

    public final boolean _a(@NotNull net.minecraft.entity.player.eidj eidj2) {
        Intrinsics.checkParameterIsNotNull(eidj2, "inventoryPlayer");
        return eidj2._e(this._l);
    }

    @Nullable
    public final EntityAdvancedThrowable _t() {
        this._s = false;
        if (this._l == null) {
            this._o();
            return null;
        }
        cvzo cvzo2 = this._l;
        if (cvzo2 == null) {
            Intrinsics.throwNpe();
        }
        return jxtc._a(this, cvzo2, this._i, false, 4, null);
    }

    @Nullable
    public final EntityAdvancedThrowable _a(@Nullable cvzo cvzo2, int n, boolean bl) {
        if ((this._k || bl) && cvzo2 != null) {
            EntityAdvancedThrowable entityAdvancedThrowable;
            InvokeSideOnly.client(this._t.field_70170_p.field_72995_K, new InvokeSideOnly.InvokeClientOnly(){

                @Override
                public final void run() {
                    this._s();
                }
            });
            this._k = false;
            this._f = -1;
            this._l = null;
            final ybzs ybzs2 = this._c(cvzo2);
            ybzs2._a(true, this._t);
            EntityAdvancedThrowable entityAdvancedThrowable2 = entityAdvancedThrowable = ybzs2._a(cvzo2, this, owkq._b(n, ybzs2._n()));
            final int n2 = entityAdvancedThrowable2 != null ? entityAdvancedThrowable2.fakeEntityId : -1;
            InvokeSideOnly.client(this._t.field_70170_p.field_72995_K, new InvokeSideOnly.InvokeClientOnly(){

                @Override
                public final void run() {
                    new ncxe(ybzs2._b(this, true), n2).sendToServer();
                }
            });
            return entityAdvancedThrowable;
        }
        return null;
    }

    @Nullable
    public static /* bridge */ /* synthetic */ EntityAdvancedThrowable _a(jxtc jxtc2, cvzo cvzo2, int n, boolean bl, int n2, Object object) {
        if ((n2 & 4) != 0) {
            bl = false;
        }
        return jxtc2._a(cvzo2, n, bl);
    }

    public final float _b(float f) {
        cvzo cvzo2 = this._l;
        if (cvzo2 == null) {
            return 0.0f;
        }
        cvzo cvzo3 = cvzo2;
        int n = this._c(cvzo3)._n();
        if (n <= 0) {
            return 0.0f;
        }
        return owkq._c(f, owkq._n(this._h), owkq._n(this._i)) / owkq._n(n);
    }

    public final float _c(float f) {
        cvzo cvzo2 = this._l;
        if (cvzo2 == null) {
            return 0.0f;
        }
        cvzo cvzo3 = cvzo2;
        return this._c(cvzo3)._a(this, f);
    }

    @Nullable
    public final ybzs _b(@Nullable cvzo cvzo2) {
        cvzo cvzo3 = cvzo2;
        tgdv tgdv2 = cvzo3 != null ? cvzo3._a() : null;
        if (!(tgdv2 instanceof ybzs)) {
            tgdv2 = null;
        }
        return (ybzs)tgdv2;
    }

    @NotNull
    public final ybzs _c(@NotNull cvzo cvzo2) {
        Intrinsics.checkParameterIsNotNull(cvzo2, "itemStack");
        tgdv tgdv2 = cvzo2._a();
        if (!(tgdv2 instanceof ybzs)) {
            tgdv2 = null;
        }
        ybzs ybzs2 = (ybzs)tgdv2;
        if (ybzs2 == null) {
            throw (Throwable)new IllegalArgumentException("Passed itemStack is not an ItemThrowable! You can't throw an item that is not a sub-type of ItemThrowable.");
        }
        return ybzs2;
    }

    @Override
    public void saveNBTData(@Nullable qoac qoac2) {
    }

    @Override
    public void loadNBTData(@Nullable qoac qoac2) {
    }

    @Override
    public void init(@Nullable Entity entity, @Nullable ozlu ozlu2) {
    }

    @NotNull
    public final EntityLivingBase _u() {
        return this._t;
    }

    public jxtc(@NotNull EntityLivingBase entityLivingBase) {
        Intrinsics.checkParameterIsNotNull(entityLivingBase, "entity");
        this._t = entityLivingBase;
        this._b = -1;
        this._f = -1;
        this._h = -1;
        this._i = -1;
        this._j = 10;
        this._m = -1;
        this._o = new qlgf();
        this._q = this._p = 20;
    }

    static {
        _u = _u;
    }

    @NotNull
    public static final String _w() {
        return _a._b();
    }

    @JvmStatic
    @Nullable
    public static final jxtc _a(@NotNull EntityPlayer entityPlayer) {
        Intrinsics.checkParameterIsNotNull(entityPlayer, "player");
        return _a._a(entityPlayer);
    }

    @Metadata(mv={1, 1, 7}, bv={1, 0, 2}, k=1, d1={"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0012\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u000bH\u0007R\u001c\u0010\u0003\u001a\u00020\u00048\u0006X\u0087D\u00a2\u0006\u000e\n\u0000\u0012\u0004\b\u0005\u0010\u0002\u001a\u0004\b\u0006\u0010\u0007\u00a8\u0006\f"}, d2={"Lgloomyfolken/mods/core/entity/WeaponUser$Companion;", "", "()V", "ATTRIB", "", "ATTRIB$annotations", "getATTRIB", "()Ljava/lang/String;", "getHandler", "Lgloomyfolken/mods/core/entity/WeaponUser;", "player", "Lnet/minecraft/entity/player/EntityPlayer;", "minecraft"})
    public static final class kjui {
        @JvmStatic
        public static /* synthetic */ void _a() {
        }

        @NotNull
        public final String _b() {
            return _u;
        }

        @JvmStatic
        @Nullable
        public final jxtc _a(@NotNull EntityPlayer entityPlayer) {
            Intrinsics.checkParameterIsNotNull(entityPlayer, "player");
            IExtendedEntityProperties iExtendedEntityProperties = entityPlayer.getExtendedProperties(this._b());
            if (!(iExtendedEntityProperties instanceof jxtc)) {
                iExtendedEntityProperties = null;
            }
            return (jxtc)iExtendedEntityProperties;
        }

        private kjui() {
        }

        public /* synthetic */ kjui(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }
}

