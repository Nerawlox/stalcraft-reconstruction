/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.core.misc;

import gloomyfolken.bundle.common.core.InvokeSideOnly;
import gloomyfolken.bundle.common.core.eidj;
import gloomyfolken.bundle.common.core.ezey;
import gloomyfolken.mods.asm.Logger;
import gloomyfolken.mods.core.entity.EntityAdvancedThrowable;
import gloomyfolken.mods.core.entity.jxtc;
import gloomyfolken.mods.core.main.GloomyCore;
import gloomyfolken.mods.core.misc.kjwj;
import gloomyfolken.mods.core.misc.owak;
import gloomyfolken.mods.core.misc.pibk;
import gloomyfolken.mods.core.misc.ugqx;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityClientPlayerMP;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.model.AdvancedModelLoader;
import net.minecraftforge.client.model.IModelCustom;
import net.minecraftforge.common.IExtendedEntityProperties;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={1, 1, 7}, bv={1, 0, 2}, k=1, d1={"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\b\u0016\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003BC\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00070\n\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\u0007\u0012\u0006\u0010\u000e\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u000fJ\t\u0010#\u001a\u00020$H\u0096\u0001J\u0016\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020*J\u0018\u0010+\u001a\u00020\u00052\u0006\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020$H\u0016J\t\u0010/\u001a\u00020\u0011H\u0096\u0001J\u0018\u00100\u001a\u00020\u00112\u0006\u0010,\u001a\u00020-2\u0006\u00101\u001a\u00020\u0011H\u0016J\u0006\u00102\u001a\u00020\u0005J\u0006\u00103\u001a\u00020\u0005J\t\u00104\u001a\u00020\u0007H\u0096\u0001J\u000b\u00105\u001a\u0004\u0018\u00010\u0007H\u0096\u0001J\t\u00106\u001a\u00020\u0007H\u0096\u0001J\u0010\u00107\u001a\u00020\u00112\u0006\u00108\u001a\u00020\u0011H\u0016J\u0018\u00109\u001a\u00020\u00052\u0006\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020$H\u0016J\u0012\u0010:\u001a\u0004\u0018\u00010-2\u0006\u0010;\u001a\u00020<H\u0002J\t\u0010=\u001a\u00020$H\u0096\u0001J \u0010>\u001a\u00020$2\u0006\u0010)\u001a\u00020*2\u0006\u0010,\u001a\u00020-2\u0006\u00108\u001a\u00020\u0005H\u0016J\u0018\u0010?\u001a\u00020&2\u0006\u0010@\u001a\u00020\u00052\u0006\u0010A\u001a\u00020BH\u0017J\u0010\u0010C\u001a\u00020&2\u0006\u0010,\u001a\u00020-H\u0016J\u0016\u0010D\u001a\u00020&2\u0006\u0010E\u001a\u00020$2\u0006\u0010F\u001a\u00020<J\u0010\u0010G\u001a\u00020&2\u0006\u0010H\u001a\u00020\u0007H\u0017J\"\u0010I\u001a\u0004\u0018\u00010J2\u0006\u0010)\u001a\u00020*2\u0006\u0010,\u001a\u00020-2\u0006\u00108\u001a\u00020\u0005H\u0016R\u001a\u0010\u0010\u001a\u00020\u0011X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0016\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001a\u0010\u001b\u001a\u00020\u0011X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0013\"\u0004\b\u001d\u0010\u0015R\u001a\u0010\u001e\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0018\"\u0004\b \u0010\u001aR\u0011\u0010\r\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b!\u0010\"\u00a8\u0006K"}, d2={"Lgloomyfolken/mods/core/misc/ItemThrowable;", "Lgloomyfolken/mods/core/misc/ModItem;", "Lgloomyfolken/mods/core/misc/IMouseHandlerItem;", "Lgloomyfolken/mods/core/misc/IAnimatedItem;", "id", "", "name", "", "icon", "description", "", "fpSettings", "Lgloomyfolken/mods/core/misc/ItemFpSettings;", "thrownModelName", "stackSize", "(ILjava/lang/String;Ljava/lang/String;Ljava/util/List;Lgloomyfolken/mods/core/misc/ItemFpSettings;Ljava/lang/String;I)V", "maxStartSpeed", "", "getMaxStartSpeed", "()F", "setMaxStartSpeed", "(F)V", "preparePeriod", "getPreparePeriod", "()I", "setPreparePeriod", "(I)V", "throwDegreeOffset", "getThrowDegreeOffset", "setThrowDegreeOffset", "throwPeriod", "getThrowPeriod", "setThrowPeriod", "getThrownModelName", "()Ljava/lang/String;", "animateOnGround", "", "consumeItem", "", "player", "Lnet/minecraft/entity/player/EntityPlayer;", "itemStack", "Lnet/minecraft/item/ItemStack;", "getChargedTicks", "user", "Lgloomyfolken/mods/core/entity/WeaponUser;", "clamp", "getFov", "getIgnitionProgress", "frame", "getMaxChargeTime", "getPrepareTime", "getRenderConfigName", "getRenderMaterialName", "getRenderModelName", "getThrowPower", "chargeTime", "getThrowingTicks", "getWeaponInfo", "entity", "Lnet/minecraft/entity/EntityLivingBase;", "hasDistortions", "onChargeTick", "onMouseButton", "button", "state", "Lgloomyfolken/mods/core/event/client/MouseButtonEvent$State;", "onStartedCharging", "playAnimation", "initiateThrow", "thrower", "registerThrownModel", "modelName", "spawnThrownEntity", "Lgloomyfolken/mods/core/entity/EntityAdvancedThrowable;", "minecraft"})
public class ybzs
extends kjwj
implements owak,
ugqx {
    private float _b;
    private int _c;
    private int _d;
    private float _e;
    @NotNull
    private final String _f;
    private final /* synthetic */ pibk _g;

    public final float _i() {
        return this._b;
    }

    public final void _a(float f) {
        this._b = f;
    }

    public final int _j() {
        return this._c;
    }

    public final void _a(int n) {
        this._c = n;
    }

    public final int _k() {
        return this._d;
    }

    public final void _b(int n) {
        this._d = n;
    }

    public final float _l() {
        return this._e;
    }

    public final void _b(float f) {
        this._e = f;
    }

    private final jxtc _a(EntityLivingBase entityLivingBase) {
        IExtendedEntityProperties iExtendedEntityProperties = entityLivingBase.getExtendedProperties(jxtc._a._b());
        if (!(iExtendedEntityProperties instanceof jxtc)) {
            iExtendedEntityProperties = null;
        }
        return (jxtc)iExtendedEntityProperties;
    }

    @Override
    @ezey(_a={eidj.CLIENT})
    public void _a(int n, @NotNull anrz.pidb pidb2) {
        Intrinsics.checkParameterIsNotNull((Object)pidb2, "state");
        Minecraft minecraft = Minecraft._E();
        EntityClientPlayerMP entityClientPlayerMP = minecraft._t;
        Intrinsics.checkExpressionValueIsNotNull(entityClientPlayerMP, "mc.thePlayer");
        jxtc jxtc2 = this._a(entityClientPlayerMP);
        if (jxtc2 == null) {
            return;
        }
        jxtc jxtc3 = jxtc2;
        if (minecraft._t.getCurrentEquippedItem() != null) {
            if (Intrinsics.areEqual((Object)pidb2, (Object)anrz.pidb._a) && !jxtc3._h()) {
                ItemStack itemStack = minecraft._t.getCurrentEquippedItem();
                if (itemStack == null) {
                    Intrinsics.throwNpe();
                }
                Intrinsics.checkExpressionValueIsNotNull(itemStack, "mc.thePlayer.currentEquippedItem!!");
                jxtc3._a(itemStack, n == 0 ? (int)((double)this._n() * 0.75) : -1);
            } else if (Intrinsics.areEqual((Object)pidb2, (Object)anrz.pidb._c) && n == 1 && jxtc3._h() && jxtc3._e() < 0) {
                jxtc3._r();
            }
        }
    }

    @ezey(_a={eidj.CLIENT})
    public void _a(@NotNull String string) {
        Intrinsics.checkParameterIsNotNull(string, "modelName");
        try {
            IModelCustom iModelCustom = AdvancedModelLoader.loadModel("/assets/" + this._f);
            ssdo._a.put(string, iModelCustom);
        }
        catch (Exception exception) {
            Logger.warning("Failed to load throwable item model for item ID: " + this.itemID, new Object[0]);
            exception.printStackTrace();
        }
    }

    public int _a(@NotNull jxtc jxtc2, boolean bl) {
        Intrinsics.checkParameterIsNotNull(jxtc2, "user");
        int n = bl ? this._n() + jxtc2._g() : Integer.MAX_VALUE;
        return owkq._a(jxtc2._u().ticksExisted - jxtc2._f(), 0, n);
    }

    public int _b(@NotNull jxtc jxtc2, boolean bl) {
        Intrinsics.checkParameterIsNotNull(jxtc2, "user");
        int n = bl ? this._n() : Integer.MAX_VALUE;
        return owkq._a(jxtc2._u().ticksExisted - jxtc2._f() - jxtc2._g(), 0, n);
    }

    public void _a(@NotNull jxtc jxtc2) {
        Intrinsics.checkParameterIsNotNull(jxtc2, "user");
    }

    public float _a(@NotNull jxtc jxtc2, float f) {
        Intrinsics.checkParameterIsNotNull(jxtc2, "user");
        return 0.0f;
    }

    public final int _m() {
        return this._d;
    }

    public final int _n() {
        return this._c;
    }

    @Nullable
    public EntityAdvancedThrowable _a(@NotNull ItemStack itemStack, @NotNull jxtc jxtc2, int n) {
        Intrinsics.checkParameterIsNotNull(itemStack, "itemStack");
        Intrinsics.checkParameterIsNotNull(jxtc2, "user");
        return null;
    }

    public float _c(float f) {
        return 0.25f + 0.75f * (Math.min(f, (float)this._n()) / (float)this._n());
    }

    public boolean _b(@NotNull ItemStack itemStack, @NotNull jxtc jxtc2, int n) {
        Intrinsics.checkParameterIsNotNull(itemStack, "itemStack");
        Intrinsics.checkParameterIsNotNull(jxtc2, "user");
        return false;
    }

    public final void _a(final boolean bl, final @NotNull EntityLivingBase entityLivingBase) {
        Intrinsics.checkParameterIsNotNull(entityLivingBase, "thrower");
        InvokeSideOnly.client(new InvokeSideOnly.InvokeClientOnly(){

            @Override
            public final void run() {
                if (entityLivingBase.worldObj.isRemote && Intrinsics.areEqual(entityLivingBase, Minecraft._E()._t)) {
                    if (bl) {
                        zfvg._f._a()._h();
                    } else {
                        zfvg._f._a()._g();
                    }
                }
            }
        });
        if (bl) {
            entityLivingBase.swingItem();
        }
    }

    public final void _a(@NotNull EntityPlayer entityPlayer, @NotNull ItemStack itemStack) {
        Intrinsics.checkParameterIsNotNull(entityPlayer, "player");
        Intrinsics.checkParameterIsNotNull(itemStack, "itemStack");
        if (!entityPlayer.capabilities._d) {
            if (itemStack._b == 1) {
                int n = entityPlayer.inventory._a.length;
                for (int i = 0; i < n; ++i) {
                    if (!Intrinsics.areEqual(entityPlayer.inventory._a[i], itemStack)) continue;
                    entityPlayer.inventory._a[i] = null;
                    return;
                }
            } else {
                int n = itemStack._b;
                itemStack._b = n + -1;
            }
        }
    }

    @NotNull
    public final String _o() {
        return this._f;
    }

    public ybzs(int n, @NotNull String string, @NotNull String string2, @NotNull List<String> list, @NotNull pibk pibk2, @NotNull String string3, int n2) {
        Intrinsics.checkParameterIsNotNull(string, "name");
        Intrinsics.checkParameterIsNotNull(string2, "icon");
        Intrinsics.checkParameterIsNotNull(list, "description");
        Intrinsics.checkParameterIsNotNull(pibk2, "fpSettings");
        Intrinsics.checkParameterIsNotNull(string3, "thrownModelName");
        super(n, string, string2, list, n2);
        this._g = pibk2;
        this._f = string3;
        this._b = 1.0f;
        this._c = 20;
        this._d = 10;
        this._e = -10.0f;
        if (GloomyCore.side.isClient()) {
            InvokeSideOnly.client(new InvokeSideOnly.InvokeClientOnly(){

                @Override
                public final void run() {
                    this._a(this._o());
                }
            });
        }
    }

    @Override
    public boolean _d() {
        return this._g._d();
    }

    @Override
    public float _f() {
        return this._g._f();
    }

    @Override
    @NotNull
    public String _c() {
        return this._g._c();
    }

    @Override
    @Nullable
    public String _b() {
        return this._g._b();
    }

    @Override
    @NotNull
    public String _a() {
        return this._g._a();
    }

    @Override
    public boolean _e() {
        return this._g._e();
    }
}

