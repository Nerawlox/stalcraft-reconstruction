/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.bundle.common.core.InvokeSideOnly;
import gloomyfolken.bundle.common.core.eidj;
import gloomyfolken.bundle.common.core.ezey;
import gloomyfolken.mods.core.entity.jxtc;
import gloomyfolken.mods.core.misc.jgro;
import gloomyfolken.mods.core.misc.kjwj;
import gloomyfolken.mods.core.misc.owak;
import gloomyfolken.mods.core.misc.pibk;
import gloomyfolken.mods.core.misc.tdmn;
import gloomyfolken.mods.core.misc.ugqx;
import gloomyfolken.mods.core.misc.vjta;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mods.sound.client.environment.EnvironmentProcessor;
import net.minecraft.client.entity.EntityClientPlayerMP;
import net.minecraft.client.xpzm;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.common.IExtendedEntityProperties;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={1, 1, 7}, bv={1, 0, 2}, k=1, d1={"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u0007\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u0005B\u008d\u0001\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\t\u0012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\t0\f\u0012\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e\u0012\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00070\u000e\u0012\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00070\u000e\u0012\u0006\u0010\u0012\u001a\u00020\u000f\u0012\u0006\u0010\u0013\u001a\u00020\u000f\u0012\u0006\u0010\u0014\u001a\u00020\u000f\u0012\u0006\u0010\u0015\u001a\u00020\t\u0012\u0006\u0010\u0016\u001a\u00020\t\u0012\u0006\u0010\u0017\u001a\u00020\u000f\u0012\u0006\u0010\u0018\u001a\u00020\u0019\u00a2\u0006\u0002\u0010\u001aJ,\u0010*\u001a\u00020+2\b\u0010,\u001a\u0004\u0018\u00010-2\b\u0010.\u001a\u0004\u0018\u00010/2\u000e\u00100\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u000101H\u0016J\t\u00102\u001a\u000203H\u0096\u0001J\t\u00104\u001a\u00020\u000fH\u0096\u0001J\t\u00105\u001a\u00020\tH\u0096\u0001J\u000b\u00106\u001a\u0004\u0018\u00010\tH\u0096\u0001J\t\u00107\u001a\u00020\tH\u0096\u0001J\t\u00108\u001a\u000203H\u0096\u0001J\b\u00109\u001a\u000203H\u0017J\u0018\u0010:\u001a\u00020+2\u0006\u0010;\u001a\u00020\u00072\u0006\u0010<\u001a\u00020=H\u0017J \u0010>\u001a\u00020+2\u0006\u0010?\u001a\u00020-2\u0006\u0010@\u001a\u00020A2\u0006\u0010B\u001a\u00020\u0007H\u0007J\u001e\u0010C\u001a\u00020+2\u0006\u0010?\u001a\u00020-2\u0006\u0010@\u001a\u00020A2\u0006\u0010B\u001a\u00020\u0007J\u0018\u0010D\u001a\u00020+2\u0006\u0010@\u001a\u00020A2\u0006\u0010E\u001a\u00020\u0007H\u0002R\u0011\u0010\u0014\u001a\u00020\u000f\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0019\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00070\u000e\u00a2\u0006\n\n\u0002\u0010\u001f\u001a\u0004\b\u001d\u0010\u001eR\u0011\u0010\u0013\u001a\u00020\u000f\u00a2\u0006\b\n\u0000\u001a\u0004\b \u0010\u001cR\u0011\u0010\u0012\u001a\u00020\u000f\u00a2\u0006\b\n\u0000\u001a\u0004\b!\u0010\u001cR\u0019\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e\u00a2\u0006\n\n\u0002\u0010$\u001a\u0004\b\"\u0010#R\u0019\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00070\u000e\u00a2\u0006\n\n\u0002\u0010\u001f\u001a\u0004\b%\u0010\u001eR\u0011\u0010\u0017\u001a\u00020\u000f\u00a2\u0006\b\n\u0000\u001a\u0004\b&\u0010\u001cR\u0011\u0010\u0015\u001a\u00020\t\u00a2\u0006\b\n\u0000\u001a\u0004\b'\u0010(R\u0011\u0010\u0016\u001a\u00020\t\u00a2\u0006\b\n\u0000\u001a\u0004\b)\u0010(\u00a8\u0006F"}, d2={"Lgloomyfolken/mods/weapon/item/ItemMeleeWeapon;", "Lgloomyfolken/mods/core/misc/ModItem;", "Lgloomyfolken/mods/core/misc/INonDropItem;", "Lgloomyfolken/mods/core/misc/ICustomMaterialItem;", "Lgloomyfolken/mods/core/misc/IMouseHandlerItem;", "Lgloomyfolken/mods/core/misc/IAnimatedItem;", "id", "", "name", "", "icon", "lore", "", "damages", "", "", "delays", "cooldowns", "damageSpread", "criticalHitMod", "bloodlustChance", "swingSoundName", "swingStrongSoundName", "reach", "fpSettings", "Lgloomyfolken/mods/core/misc/ItemFpSettings;", "(ILjava/lang/String;Ljava/lang/String;Ljava/util/List;[Ljava/lang/Float;[Ljava/lang/Integer;[Ljava/lang/Integer;FFFLjava/lang/String;Ljava/lang/String;FLgloomyfolken/mods/core/misc/ItemFpSettings;)V", "getBloodlustChance", "()F", "getCooldowns", "()[Ljava/lang/Integer;", "[Ljava/lang/Integer;", "getCriticalHitMod", "getDamageSpread", "getDamages", "()[Ljava/lang/Float;", "[Ljava/lang/Float;", "getDelays", "getReach", "getSwingSoundName", "()Ljava/lang/String;", "getSwingStrongSoundName", "addStats", "", "stack", "Lnet/minecraft/item/ItemStack;", "player", "Lnet/minecraft/entity/player/EntityPlayer;", "list", "", "animateOnGround", "", "getFov", "getRenderConfigName", "getRenderMaterialName", "getRenderModelName", "hasDistortions", "isFull3D", "onMouseButton", "button", "state", "Lgloomyfolken/mods/core/event/client/MouseButtonEvent$State;", "performAttackHit", "itemStack", "entity", "Lnet/minecraft/entity/EntityLivingBase;", "attackAtype", "performAttackSwing", "playAnimation", "actionType", "minecraft"})
public final class cdse
extends kjwj
implements owak,
tdmn,
ugqx,
vjta {
    @NotNull
    private final Float[] _b;
    @NotNull
    private final Integer[] _c;
    @NotNull
    private final Integer[] _d;
    private final float _e;
    private final float _f;
    private final float _g;
    @NotNull
    private final String _h;
    @NotNull
    private final String _i;
    private final float _j;
    private final /* synthetic */ pibk _k;

    @Override
    @ezey(_a={eidj.CLIENT})
    public boolean func_77662_d() {
        return true;
    }

    @Override
    @ezey(_a={eidj.CLIENT})
    public void _a(int n, @NotNull anrz.pidb pidb2) {
        Intrinsics.checkParameterIsNotNull((Object)pidb2, "state");
        if (Intrinsics.areEqual((Object)pidb2, (Object)anrz.pidb._a)) {
            EntityClientPlayerMP entityClientPlayerMP = xpzm._E()._t;
            cvzo cvzo2 = entityClientPlayerMP.func_71045_bC();
            if (cvzo2 == null) {
                return;
            }
            EntityClientPlayerMP entityClientPlayerMP2 = entityClientPlayerMP;
            Intrinsics.checkExpressionValueIsNotNull(entityClientPlayerMP2, "player");
            this._a(cvzo2, (EntityLivingBase)entityClientPlayerMP2, n);
        }
    }

    @Override
    public void _a(@Nullable cvzo cvzo2, @Nullable EntityPlayer entityPlayer, @Nullable List<String> list2) {
        float f = this._b[0].floatValue() - this._e * this._b[0].floatValue();
        float f2 = this._b[0].floatValue() + this._e * this._b[0].floatValue();
        float f3 = this._b[1].floatValue() - this._e * this._b[1].floatValue();
        float f4 = this._b[1].floatValue() + this._e * this._b[1].floatValue();
        this._c(list2, "\u0423\u0440\u043e\u043d (\u0431\u044b\u0441\u0442\u0440\u044b\u0439 \u0443\u0434\u0430\u0440): " + jgro._f(f) + '-' + jgro._f(f2) + " \u0435\u0434.");
        this._c(list2, "\u0423\u0440\u043e\u043d (\u0441\u0438\u043b\u044c\u043d\u044b\u0439 \u0443\u0434\u0430\u0440): " + jgro._f(f3) + '-' + jgro._f(f4) + " \u0435\u0434.");
        this._c(list2, "\u0414\u043e\u0441\u044f\u0433\u0430\u0435\u043c\u043e\u0441\u0442\u044c: " + jgro._h(this._j - 1.0f) + " \u043c.");
    }

    public final void _a(final @NotNull cvzo cvzo2, final @NotNull EntityLivingBase entityLivingBase, final int n) {
        Intrinsics.checkParameterIsNotNull(cvzo2, "itemStack");
        Intrinsics.checkParameterIsNotNull(entityLivingBase, "entity");
        IExtendedEntityProperties iExtendedEntityProperties = entityLivingBase.getExtendedProperties(jxtc._a._b());
        if (!(iExtendedEntityProperties instanceof jxtc)) {
            iExtendedEntityProperties = null;
        }
        jxtc jxtc2 = (jxtc)iExtendedEntityProperties;
        if (jxtc2 == null) {
            return;
        }
        jxtc jxtc3 = jxtc2;
        if (entityLivingBase.field_70173_aa > jxtc3._b()) {
            jxtc3._a(this._c[n]);
            jxtc3._b(entityLivingBase.field_70173_aa + this._d[n]);
            jxtc3._c(n);
            jxtc3._a(cvzo2);
            this._a(entityLivingBase, n);
            if (entityLivingBase.field_70170_p.field_72995_K) {
                InvokeSideOnly.client(new InvokeSideOnly.InvokeClientOnly(){

                    @Override
                    public final void run() {
                        new htbr(n == 1).sendToServer();
                    }
                });
            }
            if (jxtc3._a() == 0 && !entityLivingBase.field_70170_p.field_72995_K) {
                jxtc3._a(-1);
                InvokeSideOnly.frontend(new InvokeSideOnly.InvokeFrontendOnly(){

                    @Override
                    public final void run() {
                    }
                });
            }
        }
    }

    private final void _a(final EntityLivingBase entityLivingBase, final int n) {
        if (entityLivingBase.field_70170_p.field_72995_K) {
            InvokeSideOnly.client(new InvokeSideOnly.InvokeClientOnly(){

                @Override
                public final void run() {
                    xpzm xpzm2 = xpzm._E();
                    boolean bl = Intrinsics.areEqual(entityLivingBase, xpzm2._t);
                    if (bl) {
                        ndlw._f._a()._a(n);
                    }
                    String string = n == 0 ? this._o() : this._p();
                    EnvironmentProcessor.instance.playSoundRelatively("weapons:" + string, (float)entityLivingBase.field_70165_t, (float)entityLivingBase.field_70163_u, (float)entityLivingBase.field_70161_v, 1.0f, 1.0f, bl, false);
                }
            });
        } else {
            InvokeSideOnly.frontend(new InvokeSideOnly.InvokeFrontendOnly(){

                @Override
                public final void run() {
                }
            });
        }
        entityLivingBase.func_71038_i();
    }

    @NotNull
    public final Float[] _i() {
        return this._b;
    }

    @NotNull
    public final Integer[] _j() {
        return this._c;
    }

    @NotNull
    public final Integer[] _k() {
        return this._d;
    }

    public final float _l() {
        return this._e;
    }

    public final float _m() {
        return this._f;
    }

    public final float _n() {
        return this._g;
    }

    @NotNull
    public final String _o() {
        return this._h;
    }

    @NotNull
    public final String _p() {
        return this._i;
    }

    public final float _q() {
        return this._j;
    }

    public cdse(int n, @NotNull String string, @NotNull String string2, @NotNull List<String> list2, @NotNull Float[] floatArray, @NotNull Integer[] integerArray, @NotNull Integer[] integerArray2, float f, float f2, float f3, @NotNull String string3, @NotNull String string4, float f4, @NotNull pibk pibk2) {
        Intrinsics.checkParameterIsNotNull(string, "name");
        Intrinsics.checkParameterIsNotNull(string2, "icon");
        Intrinsics.checkParameterIsNotNull(list2, "lore");
        Intrinsics.checkParameterIsNotNull(floatArray, "damages");
        Intrinsics.checkParameterIsNotNull(integerArray, "delays");
        Intrinsics.checkParameterIsNotNull(integerArray2, "cooldowns");
        Intrinsics.checkParameterIsNotNull(string3, "swingSoundName");
        Intrinsics.checkParameterIsNotNull(string4, "swingStrongSoundName");
        Intrinsics.checkParameterIsNotNull(pibk2, "fpSettings");
        super(n, string, string2, list2, 1);
        this._k = pibk2;
        this._b = floatArray;
        this._c = integerArray;
        this._d = integerArray2;
        this._e = f;
        this._f = f2;
        this._g = f3;
        this._h = string3;
        this._i = string4;
        this._j = f4;
    }

    @Override
    public boolean _d() {
        return this._k._d();
    }

    @Override
    public float _f() {
        return this._k._f();
    }

    @Override
    @NotNull
    public String _c() {
        return this._k._c();
    }

    @Override
    @Nullable
    public String _b() {
        return this._k._b();
    }

    @Override
    @NotNull
    public String _a() {
        return this._k._a();
    }

    @Override
    public boolean _e() {
        return this._k._e();
    }
}

