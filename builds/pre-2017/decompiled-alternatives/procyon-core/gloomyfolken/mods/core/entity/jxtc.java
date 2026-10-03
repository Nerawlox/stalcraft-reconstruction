// 
// Decompiled by Procyon v0.6.0
// 

package gloomyfolken.mods.core.entity;

import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.TypeCastException;
import gloomyfolken.bundle.common.core.InvokeSideOnly$InvokeFrontendOnly;
import net.minecraft.util.sajh;
import gloomyfolken.mods.ktcore.McExtensionsKt;
import net.minecraft.entity.Entity;
import net.minecraft.util.ofbx;
import gloomyfolken.bundle.common.core.eidj;
import gloomyfolken.bundle.common.core.ezey;
import gloomyfolken.mods.ktcore.VecExtensionsKt;
import gloomyfolken.mods.core.misc.ybzs;
import net.minecraft.entity.player.EntityPlayer;
import gloomyfolken.bundle.common.core.InvokeSideOnly;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.client.xpzm;
import gloomyfolken.bundle.common.core.InvokeSideOnly$InvokeClientOnly;
import net.minecraft.entity.EntityLivingBase;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import kotlin.Metadata;
import net.minecraftforge.common.IExtendedEntityProperties;

@Metadata(mv = { 1, 1, 7 }, bv = { 1, 0, 2 }, k = 1, d1 = { "\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 s2\u00020\u0001:\u0001sB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003?\u0006\u0002\u0010\u0004J\u000e\u0010C\u001a\u0002032\u0006\u0010D\u001a\u00020EJ\b\u0010F\u001a\u00020GH\u0002J\u0010\u0010H\u001a\u00020G2\u0006\u0010I\u001a\u00020JH\u0002J\u000e\u0010K\u001a\u00020L2\u0006\u0010M\u001a\u00020LJ\u000e\u0010N\u001a\u00020L2\u0006\u0010M\u001a\u00020LJ\u000e\u0010O\u001a\u00020J2\u0006\u0010P\u001a\u00020\u0014J\u0012\u0010Q\u001a\u0004\u0018\u00010J2\b\u0010P\u001a\u0004\u0018\u00010\u0014J\u000e\u0010R\u001a\u00020S2\u0006\u0010T\u001a\u00020LJ\"\u0010U\u001a\u00020S2\u0006\u0010T\u001a\u00020L2\b\b\u0002\u0010V\u001a\u00020L2\b\b\u0002\u0010W\u001a\u00020LJ\u001c\u0010X\u001a\u00020G2\b\u0010\u0002\u001a\u0004\u0018\u00010Y2\b\u0010Z\u001a\u0004\u0018\u00010[H\u0016J\u0012\u0010\\\u001a\u00020G2\b\u0010]\u001a\u0004\u0018\u00010^H\u0016J\u0018\u0010_\u001a\u00020G2\u0006\u0010P\u001a\u00020\u00142\b\b\u0002\u0010`\u001a\u00020\u0006J\"\u0010a\u001a\u00020G2\u0006\u0010P\u001a\u00020\u00142\u0006\u0010b\u001a\u00020\u00062\b\b\u0002\u0010`\u001a\u00020\u0006H\u0007J\u0006\u0010c\u001a\u00020GJ\u0006\u0010d\u001a\u00020GJ\u0012\u0010e\u001a\u00020G2\b\u0010]\u001a\u0004\u0018\u00010^H\u0016J$\u00107\u001a\u00020G2\u0006\u0010P\u001a\u00020\u00142\b\b\u0002\u0010`\u001a\u00020\u00062\b\b\u0002\u0010f\u001a\u00020\u0006H\u0002J\u0006\u0010g\u001a\u00020GJ\b\u0010h\u001a\u0004\u0018\u00010iJ$\u0010j\u001a\u0004\u0018\u00010i2\b\u0010P\u001a\u0004\u0018\u00010\u00142\u0006\u0010\r\u001a\u00020\u00062\b\b\u0002\u0010k\u001a\u000203J\u0006\u0010l\u001a\u00020GJ\u0010\u0010m\u001a\u00020G2\u0006\u0010n\u001a\u000203H\u0002J\u0010\u0010o\u001a\u00020G2\u0006\u0010n\u001a\u000203H\u0002J&\u0010p\u001a\u00020G2\u0006\u0010T\u001a\u00020L2\n\b\u0002\u0010I\u001a\u0004\u0018\u00010J2\b\b\u0002\u0010q\u001a\u00020LH\u0007J\b\u0010r\u001a\u00020GH\u0007R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082D?\u0006\u0002\n\u0000R$\u0010\b\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006@BX\u0086\u000e?\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u000e\u0010\r\u001a\u00020\u0006X\u0082\u000e?\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003?\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u0006X\u0086\u000e?\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\n\"\u0004\b\u0012\u0010\fR\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0086\u000e?\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001a\u0010\u0019\u001a\u00020\u0006X\u0086\u000e?\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\n\"\u0004\b\u001b\u0010\fR\u000e\u0010\u001c\u001a\u00020\u0006X\u0082\u000e?\u0006\u0002\n\u0000R$\u0010\u001d\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006@BX\u0086\u000e?\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\n\"\u0004\b\u001f\u0010\fR\u001a\u0010 \u001a\u00020\u0006X\u0086\u000e?\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\n\"\u0004\b\"\u0010\fR\u001a\u0010#\u001a\u00020\u0006X\u0086\u000e?\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\n\"\u0004\b%\u0010\fR\u0011\u0010&\u001a\u00020'?\u0006\b\n\u0000\u001a\u0004\b(\u0010)R\u001a\u0010*\u001a\u00020+X\u0086\u000e?\u0006\u000e\n\u0000\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R$\u00100\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006@BX\u0086\u000e?\u0006\u000e\n\u0000\u001a\u0004\b1\u0010\n\"\u0004\b2\u0010\fR$\u00104\u001a\u0002032\u0006\u0010\u0007\u001a\u000203@BX\u0086\u000e?\u0006\u000e\n\u0000\u001a\u0004\b5\u00106\"\u0004\b7\u00108R$\u00109\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006@BX\u0086\u000e?\u0006\u000e\n\u0000\u001a\u0004\b:\u0010\n\"\u0004\b;\u0010\fR(\u0010<\u001a\u0004\u0018\u00010\u00142\b\u0010\u0007\u001a\u0004\u0018\u00010\u0014@BX\u0086\u000e?\u0006\u000e\n\u0000\u001a\u0004\b=\u0010\u0016\"\u0004\b>\u0010\u0018R\u001a\u0010?\u001a\u00020\u0006X\u0086\u000e?\u0006\u000e\n\u0000\u001a\u0004\b@\u0010\n\"\u0004\bA\u0010\fR\u000e\u0010B\u001a\u000203X\u0082\u000e?\u0006\u0002\n\u0000?\u0006t" }, d2 = { "Lgloomyfolken/mods/core/entity/WeaponUser;", "Lnet/minecraftforge/common/IExtendedEntityProperties;", "entity", "Lnet/minecraft/entity/EntityLivingBase;", "(Lnet/minecraft/entity/EntityLivingBase;)V", "THROW_HINT_TIME_TICKS", "", "<set-?>", "autothrowTicksLeft", "getAutothrowTicksLeft", "()I", "setAutothrowTicksLeft", "(I)V", "chargeTime", "getEntity", "()Lnet/minecraft/entity/EntityLivingBase;", "lastSwingType", "getLastSwingType", "setLastSwingType", "lastSwungStack", "Lnet/minecraft/item/ItemStack;", "getLastSwungStack", "()Lnet/minecraft/item/ItemStack;", "setLastSwungStack", "(Lnet/minecraft/item/ItemStack;)V", "nextAttackTime", "getNextAttackTime", "setNextAttackTime", "prevChargeTime", "subtractedChargeTime", "getSubtractedChargeTime", "setSubtractedChargeTime", "throwDisableUpdateHintTicks", "getThrowDisableUpdateHintTicks", "setThrowDisableUpdateHintTicks", "throwHintTicksLeft", "getThrowHintTicksLeft", "setThrowHintTicksLeft", "throwSimParams", "Lgloomyfolken/mods/core/entity/ThrowSimulationParams;", "getThrowSimParams", "()Lgloomyfolken/mods/core/entity/ThrowSimulationParams;", "throwStartMs", "", "getThrowStartMs", "()J", "setThrowStartMs", "(J)V", "throwTimeStart", "getThrowTimeStart", "setThrowTimeStart", "", "throwing", "getThrowing", "()Z", "setThrowing", "(Z)V", "throwingSlot", "getThrowingSlot", "setThrowingSlot", "throwingStack", "getThrowingStack", "setThrowingStack", "ticksBeforeHit", "getTicksBeforeHit", "setTicksBeforeHit", "wantThrow", "checkThrowingItemInInventory", "inventoryPlayer", "Lnet/minecraft/entity/player/InventoryPlayer;", "doMeleeHit", "", "doTickThrowable", "throwable", "Lgloomyfolken/mods/core/misc/ItemThrowable;", "getChargedProgress", "", "frame", "getOverchargedProgress", "getThrowableItem", "itemStack", "getThrowableItemOrNull", "getThrowableSpawnPos", "Lnet/minecraft/util/Vec3;", "partialTime", "getThrowableStartVelocity", "speedFactor", "additionalPitchDegrees", "init", "Lnet/minecraft/entity/Entity;", "world", "Lnet/minecraft/world/World;", "loadNBTData", "compound", "Lnet/minecraft/nbt/NBTTagCompound;", "prepareThrowItem", "autoThrowTimeout", "prepareThrowItemFromSlot", "slotId", "resetMeleeStats", "resetThrowStats", "saveNBTData", "overrideSlotId", "setWantThrow", "throwActiveThrowingItem", "Lgloomyfolken/mods/core/entity/EntityAdvancedThrowable;", "throwItem", "force", "tick", "tickMelee", "reset", "tickThrowable", "updateThrowSimParams", "overridePower", "updateThrownHint", "Companion", "minecraft" })
public final class jxtc implements IExtendedEntityProperties
{
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
    public static final kjui _a;
    
    public final int _a() {
        return this._b;
    }
    
    public final void _a(final int b) {
        this._b = b;
    }
    
    public final int _b() {
        return this._c;
    }
    
    public final void _b(final int c) {
        this._c = c;
    }
    
    @Nullable
    public final cvzo _c() {
        return this._d;
    }
    
    public final void _a(@Nullable final cvzo d) {
        this._d = d;
    }
    
    public final int _d() {
        return this._e;
    }
    
    public final void _c(final int e) {
        this._e = e;
    }
    
    public final int _e() {
        return this._f;
    }
    
    private final void _f(final int f) {
        this._f = f;
    }
    
    public final int _f() {
        return this._g;
    }
    
    private final void _g(final int g) {
        this._g = g;
    }
    
    public final int _g() {
        return this._j;
    }
    
    private final void _h(final int j) {
        this._j = j;
    }
    
    public final boolean _h() {
        return this._k;
    }
    
    private final void _a(final boolean k) {
        this._k = k;
    }
    
    @Nullable
    public final cvzo _i() {
        return this._l;
    }
    
    private final void _d(final cvzo l) {
        this._l = l;
    }
    
    public final int _j() {
        return this._m;
    }
    
    private final void _i(final int m) {
        this._m = m;
    }
    
    public final long _k() {
        return this._n;
    }
    
    public final void _a(final long n) {
        this._n = n;
    }
    
    @NotNull
    public final qlgf _l() {
        return this._o;
    }
    
    public final int _m() {
        return this._q;
    }
    
    public final void _d(final int q) {
        this._q = q;
    }
    
    public final int _n() {
        return this._r;
    }
    
    public final void _e(final int r) {
        this._r = r;
    }
    
    public final void _o() {
        this._l = null;
        this._f = -1;
        this._g = ((Entity)this._t).field_70173_aa;
        this._i = -1;
        this._h = -1;
        this._k = false;
        this._s = false;
        InvokeSideOnly.client((InvokeSideOnly$InvokeClientOnly)new InvokeSideOnly$InvokeClientOnly() {
            final /* synthetic */ jxtc _a;
            
            public final void run() {
                if (((Entity)this._a._u()).field_70170_p.field_72995_K && Intrinsics.areEqual((Object)this._a._u(), (Object)xpzm._E()._t)) {
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
        boolean b = false;
        if (!this._t.func_70089_S()) {
            b = true;
        }
        this._b(b);
        this._c(b);
        this._q--;
        this._r--;
    }
    
    private final void _b(final boolean b) {
        boolean b2 = b;
        if (this._t instanceof EntityPlayer) {
            final cvzo func_71045_bC = ((EntityPlayer)this._t).func_71045_bC();
            if (func_71045_bC == null || !(func_71045_bC._a() instanceof cdse) || (this._d != null && (Intrinsics.areEqual((Object)func_71045_bC, (Object)this._d) ^ true))) {
                b2 = true;
            }
        }
        if (b2) {
            this._p();
        }
        else if (this._b >= 0) {
            --this._b;
            if (this._b == -1) {
                this._x();
            }
        }
    }
    
    private final void _c(final boolean b) {
        boolean b2 = b;
        if (this._t instanceof EntityPlayer) {
            final cvzo func_71045_bC = ((EntityPlayer)this._t).func_71045_bC();
            if (func_71045_bC == null || !(func_71045_bC._a() instanceof ybzs) || (this._l != null && (Intrinsics.areEqual((Object)func_71045_bC, (Object)this._l) ^ true))) {
                b2 = true;
            }
        }
        if (b2) {
            this._o();
        }
        else {
            final ybzs b3 = this._b(this._l);
            if (this._k && b3 != null) {
                this._a(b3);
            }
            else {
                this._k = false;
                this._i = -1;
                this._h = -1;
            }
        }
    }
    
    private final void _a(final ybzs ybzs) {
        this._h = owkq._c(this._i, 0);
        this._i = ybzs._b(this, false);
        if (this._h == 0 && this._i == 1) {
            ybzs._a(this);
        }
        final cvzo l = this._l;
        if (l == null) {
            Intrinsics.throwNpe();
        }
        if (ybzs._b(l, this, this._i)) {
            this._o();
            return;
        }
        boolean b = false;
        Label_0100: {
            if (this._f >= 0) {
                --this._f;
                if (this._f == -1) {
                    b = true;
                    break Label_0100;
                }
            }
            b = false;
        }
        if ((b || this._s) && this._i > 0) {
            this._t();
        }
    }
    
    @ezey(_a = { eidj.CLIENT })
    public final void _a(final float n, @Nullable final ybzs ybzs, final float n2) {
        if (this._r <= 0) {
            final cvzo l = this._l;
            Object o = (l != null) ? l._a() : null;
            if (!(o instanceof ybzs)) {
                o = null;
            }
            ybzs ybzs3;
            ybzs ybzs2;
            if ((ybzs2 = (ybzs3 = (ybzs)o)) == null) {
                ybzs3 = ybzs;
                ybzs2 = ybzs;
            }
            if (ybzs2 == null) {
                return;
            }
            final ybzs ybzs4 = ybzs3;
            float c = n2;
            if (ybzs == null) {
                c = ybzs4._c(owkq._c(n, owkq._n(this._h), owkq._n(this._i)));
            }
            VecExtensionsKt.set(this._o._c(), this._a(n));
            VecExtensionsKt.set(this._o._b(), this._a(n, ybzs4._i() * c, ybzs4._l()));
            this._q = 2;
        }
    }
    
    @NotNull
    public final ofbx _a(final float n) {
        final ofbx vec3 = VecExtensionsKt.vec3();
        VecExtensionsKt.set(vec3, VecExtensionsKt.lerp(n, McExtensionsKt.getPrevPos((Entity)this._t), McExtensionsKt.getPos((Entity)this._t)));
        VecExtensionsKt.addl(vec3, 0.0, (double)this._t.func_70047_e(), 0.0);
        final float n2 = 0.017453294f;
        final ofbx ofbx = vec3;
        ofbx._d -= 0.15;
        if (!((Entity)this._t).field_70170_p.field_72995_K) {
            final ofbx ofbx2 = vec3;
            ofbx2._d += 0.12;
        }
        final ofbx ofbx3 = vec3;
        ofbx3._c -= sajh._b(((Entity)this._t).field_70177_z * n2) * 0.2;
        final ofbx ofbx4 = vec3;
        ofbx4._e -= sajh._a(((Entity)this._t).field_70177_z * n2) * 0.2;
        final ofbx ofbx5 = vec3;
        ofbx5._c -= sajh._a(((Entity)this._t).field_70177_z * n2) * 0.25 * sajh._b(((Entity)this._t).field_70125_A * n2);
        final ofbx ofbx6 = vec3;
        ofbx6._e += sajh._b(((Entity)this._t).field_70177_z * n2) * 0.25 * sajh._b(((Entity)this._t).field_70125_A * n2);
        final ofbx ofbx7 = vec3;
        Intrinsics.checkExpressionValueIsNotNull((Object)ofbx7, "pos");
        return ofbx7;
    }
    
    @NotNull
    public final ofbx _a(final float n, final float n2, final float n3) {
        final ofbx vec3 = VecExtensionsKt.vec3();
        final float max = Math.max(owkq._c(n, ((Entity)this._t).field_70127_C, ((Entity)this._t).field_70125_A) + n3, -90.0f);
        final float c = owkq._c(n, this._t.field_70758_at, this._t.field_70759_as);
        vec3._c = -sajh._a(c / 180.0f * (float)3.141592653589793) * sajh._b(max / 180.0f * (float)3.141592653589793) * n2;
        vec3._e = sajh._b(c / 180.0f * (float)3.141592653589793) * sajh._b(max / 180.0f * (float)3.141592653589793) * n2;
        vec3._d = -sajh._a(max / 180.0f * (float)3.141592653589793) * n2;
        final ofbx ofbx = vec3;
        Intrinsics.checkExpressionValueIsNotNull((Object)ofbx, "vel");
        return ofbx;
    }
    
    private final void _x() {
        InvokeSideOnly.frontend(!((Entity)this._t).field_70170_p.field_72995_K, (InvokeSideOnly$InvokeFrontendOnly)new InvokeSideOnly$InvokeFrontendOnly() {
            public final void run() {
            }
        });
    }
    
    public final void _a(@NotNull final cvzo cvzo, final int n) {
        Intrinsics.checkParameterIsNotNull((Object)cvzo, "itemStack");
        if (!this._k) {
            _b(this, cvzo, n, 0, 4, (Object)null);
        }
    }
    
    @ezey(_a = { eidj.CLIENT })
    public final void _a(@NotNull final cvzo cvzo, final int n, final int n2) {
        Intrinsics.checkParameterIsNotNull((Object)cvzo, "itemStack");
        if (!this._k) {
            this._b(cvzo, n2, n);
        }
    }
    
    private final void _b(final cvzo l, final int n, final int n2) {
        if (!(l._a() instanceof ybzs)) {
            throw new IllegalArgumentException("Item to throw must be an instance of ItemThrowable. " + l._a() + " isn't!");
        }
        if (l._a() instanceof yurw) {
            final tgdv a = l._a();
            if (a == null) {
                throw new TypeCastException("null cannot be cast to non-null type gloomyfolken.mods.weapon.item.ItemGrenade");
            }
            if (!((yurw)a)._m) {
                return;
            }
        }
        this._l = l;
        this._k = true;
        this._g = ((Entity)this._t).field_70173_aa;
        this._f = -1;
        if (n > 0) {
            this._f = n + this._j;
        }
        this._c(l)._a(false, this._t);
        this._j = this._c(l)._m();
        InvokeSideOnly.client(((Entity)this._t).field_70170_p.field_72995_K, (InvokeSideOnly$InvokeClientOnly)new InvokeSideOnly$InvokeClientOnly() {
            public final void run() {
                new ivlc(n2).sendToServer();
            }
        });
    }
    
    public final void _r() {
        this._s = true;
    }
    
    @ezey(_a = { eidj.CLIENT })
    public final void _s() {
        this._r = 0;
        _a(this, 1.0f, (ybzs)null, 0.0f, 6, (Object)null);
        this._r = this._p;
        this._q = this._p;
    }
    
    public final boolean _a(@NotNull final net.minecraft.entity.player.eidj eidj) {
        Intrinsics.checkParameterIsNotNull((Object)eidj, "inventoryPlayer");
        return eidj._e(this._l);
    }
    
    @Nullable
    public final EntityAdvancedThrowable _t() {
        this._s = false;
        if (this._l == null) {
            this._o();
            return null;
        }
        final cvzo l = this._l;
        if (l == null) {
            Intrinsics.throwNpe();
        }
        return _a(this, l, this._i, false, 4, (Object)null);
    }
    
    @Nullable
    public final EntityAdvancedThrowable _a(@Nullable final cvzo cvzo, final int n, final boolean b) {
        if ((this._k || b) && cvzo != null) {
            InvokeSideOnly.client(((Entity)this._t).field_70170_p.field_72995_K, (InvokeSideOnly$InvokeClientOnly)new InvokeSideOnly$InvokeClientOnly() {
                final /* synthetic */ jxtc _a;
                
                public final void run() {
                    this._a._s();
                }
            });
            this._k = false;
            this._f = -1;
            this._l = null;
            final ybzs c = this._c(cvzo);
            c._a(true, this._t);
            final EntityAdvancedThrowable a;
            final EntityAdvancedThrowable entityAdvancedThrowable = a = c._a(cvzo, this, owkq._b(n, c._n()));
            InvokeSideOnly.client(((Entity)this._t).field_70170_p.field_72995_K, (InvokeSideOnly$InvokeClientOnly)new InvokeSideOnly$InvokeClientOnly() {
                final /* synthetic */ jxtc _a;
                final /* synthetic */ int _c = (a != null) ? a.fakeEntityId : -1;
                
                public final void run() {
                    new ncxe(c._b(this._a, true), this._c).sendToServer();
                }
            });
            return entityAdvancedThrowable;
        }
        return null;
    }
    
    public final float _b(final float n) {
        final cvzo l = this._l;
        if (l == null) {
            return 0.0f;
        }
        final int n2 = this._c(l)._n();
        if (n2 <= 0) {
            return 0.0f;
        }
        return owkq._c(n, owkq._n(this._h), owkq._n(this._i)) / owkq._n(n2);
    }
    
    public final float _c(final float n) {
        final cvzo l = this._l;
        if (l != null) {
            return this._c(l)._a(this, n);
        }
        return 0.0f;
    }
    
    @Nullable
    public final ybzs _b(@Nullable final cvzo cvzo) {
        tgdv tgdv = (cvzo != null) ? cvzo._a() : null;
        if (!(tgdv instanceof ybzs)) {
            tgdv = null;
        }
        return (ybzs)tgdv;
    }
    
    @NotNull
    public final ybzs _c(@NotNull final cvzo cvzo) {
        Intrinsics.checkParameterIsNotNull((Object)cvzo, "itemStack");
        Object a;
        if (!((a = cvzo._a()) instanceof ybzs)) {
            a = null;
        }
        final ybzs ybzs = (ybzs)a;
        if (ybzs != null) {
            return ybzs;
        }
        throw new IllegalArgumentException("Passed itemStack is not an ItemThrowable! You can't throw an item that is not a sub-type of ItemThrowable.");
    }
    
    public void saveNBTData(@Nullable final qoac qoac) {
    }
    
    public void loadNBTData(@Nullable final qoac qoac) {
    }
    
    public void init(@Nullable final Entity entity, @Nullable final ozlu ozlu) {
    }
    
    @NotNull
    public final EntityLivingBase _u() {
        return this._t;
    }
    
    public jxtc(@NotNull final EntityLivingBase t) {
        Intrinsics.checkParameterIsNotNull((Object)t, "entity");
        this._t = t;
        this._b = -1;
        this._f = -1;
        this._h = -1;
        this._i = -1;
        this._j = 10;
        this._m = -1;
        this._o = new qlgf();
        this._q = this._p;
    }
    
    static {
        _a = new kjui(null);
    }
    
    @NotNull
    public static final /* synthetic */ String _v() {
        return jxtc._u;
    }
    
    @NotNull
    public static final String _w() {
        return jxtc._a._b();
    }
    
    @JvmStatic
    @Nullable
    public static final jxtc _a(@NotNull final EntityPlayer entityPlayer) {
        Intrinsics.checkParameterIsNotNull((Object)entityPlayer, "player");
        return jxtc._a._a(entityPlayer);
    }
    
    @Metadata(mv = { 1, 1, 7 }, bv = { 1, 0, 2 }, k = 1, d1 = { "\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002?\u0006\u0002\u0010\u0002J\u0012\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u000bH\u0007R\u001c\u0010\u0003\u001a\u00020\u00048\u0006X\u0087D?\u0006\u000e\n\u0000\u0012\u0004\b\u0005\u0010\u0002\u001a\u0004\b\u0006\u0010\u0007?\u0006\f" }, d2 = { "Lgloomyfolken/mods/core/entity/WeaponUser$Companion;", "", "()V", "ATTRIB", "", "ATTRIB$annotations", "getATTRIB", "()Ljava/lang/String;", "getHandler", "Lgloomyfolken/mods/core/entity/WeaponUser;", "player", "Lnet/minecraft/entity/player/EntityPlayer;", "minecraft" })
    public static final class kjui
    {
        @NotNull
        public final String _b() {
            return jxtc._v();
        }
        
        @JvmStatic
        @Nullable
        public final jxtc _a(@NotNull final EntityPlayer entityPlayer) {
            Intrinsics.checkParameterIsNotNull((Object)entityPlayer, "player");
            IExtendedEntityProperties extendedProperties;
            if (!((extendedProperties = entityPlayer.getExtendedProperties(this._b())) instanceof jxtc)) {
                extendedProperties = null;
            }
            return (jxtc)extendedProperties;
        }
        
        private kjui() {
        }
    }
}
