/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.core.misc;

import gloomyfolken.bundle.common.core.InvokeSideOnly;
import gloomyfolken.bundle.common.core.eidj;
import gloomyfolken.bundle.common.core.ezey;
import gloomyfolken.mods.core.misc.zwaw;
import gloomyfolken.mods.effects.client.main.pidb;
import gloomyfolken.mods.ktcore.McExtensionsKt;
import gloomyfolken.mods.ktcore.VecExtensionsKt;
import gloomyfolken.mods.physics.core.ImpulseApplyType;
import gloomyfolken.mods.physics.core.PhysicsImpulse;
import gloomyfolken.mods.physics.ragdolls.client.ragdoll.CorpseRagdollContext;
import gloomyfolken.mods.physics.ragdolls.entity.CorpseRagdollState;
import gloomyfolken.mods.physics.ragdolls.entity.EntityRagdollCorpse;
import gloomyfolken.mods.stalker.misc.StalkerMiscMod;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityClientPlayerMP;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.EnumMovingObjectType;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;
import net.minecraft.util.sajh;
import net.minecraft.world.World;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={1, 1, 7}, bv={1, 0, 2}, k=1, d1={"\u0000\u008c\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\n\u0018\u00002\u00020\u0001:\u0001]B/\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\tJ \u00106\u001a\u00020\u00162\u0006\u00107\u001a\u00020\u00052\u0006\u00108\u001a\u00020\u00052\u0006\u00109\u001a\u00020\u0005H\u0007J\b\u0010:\u001a\u00020;H\u0002J(\u0010<\u001a\u00020;2\u0006\u0010=\u001a\u00020\u00102\u0006\u0010>\u001a\u00020?2\u0006\u0010@\u001a\u00020A2\u0006\u0010B\u001a\u00020\u0005H\u0003J\u0010\u0010C\u001a\u00020;2\u0006\u0010>\u001a\u00020?H\u0007J\b\u0010D\u001a\u00020;H\u0007J\u0018\u0010E\u001a\u00020?2\u0006\u0010F\u001a\u00020A2\u0006\u0010G\u001a\u00020HH\u0002J\u000e\u0010I\u001a\b\u0012\u0004\u0012\u00020\u00100JH\u0002J \u0010K\u001a\u00020?2\u0006\u0010=\u001a\u00020L2\u0006\u0010M\u001a\u00020A2\u0006\u0010N\u001a\u00020AH\u0002J\n\u0010O\u001a\u0004\u0018\u00010PH\u0002J\u0018\u0010Q\u001a\u00020;2\u0006\u0010R\u001a\u00020A2\u0006\u0010S\u001a\u00020TH\u0003J\b\u0010U\u001a\u00020;H\u0002J\u0018\u0010V\u001a\u00020;2\u0006\u0010R\u001a\u00020A2\u0006\u0010W\u001a\u00020+H\u0003J\u0010\u0010X\u001a\u00020\u00002\b\u0010=\u001a\u0004\u0018\u00010\u0010J\u000e\u0010Y\u001a\u00020\u00002\u0006\u0010$\u001a\u00020%J\u000e\u0010Z\u001a\u00020\u00002\u0006\u0010*\u001a\u00020+J\u0010\u0010[\u001a\u00020\r2\u0006\u0010\\\u001a\u00020\fH\u0002R*\u0010\n\u001a\u001e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000bj\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r`\u000eX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0015\u001a\u00020\u0016X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u0011\u0010\u001b\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0011\u0010\u001e\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u001dR\u0011\u0010 \u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b!\u0010\u001dR\u0011\u0010\"\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b#\u0010\u001dR\u001a\u0010$\u001a\u00020%X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\u001a\u0010*\u001a\u00020+X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R\u0016\u00100\u001a\n 2*\u0004\u0018\u00010101X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0011\u00103\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b4\u00105\u00a8\u0006^"}, d2={"Lgloomyfolken/mods/core/misc/CustomExplosion;", "", "world", "Lnet/minecraft/world/World;", "posX", "", "posY", "posZ", "size", "(Lnet/minecraft/world/World;DDDD)V", "affectedPlayerInfo", "Ljava/util/HashMap;", "Lnet/minecraft/entity/player/EntityPlayer;", "Lgloomyfolken/mods/core/misc/CustomExplosion$PlayerExplosionInfo;", "Lkotlin/collections/HashMap;", "explosionAuthor", "Lnet/minecraft/entity/Entity;", "getExplosionAuthor", "()Lnet/minecraft/entity/Entity;", "setExplosionAuthor", "(Lnet/minecraft/entity/Entity;)V", "explosionCancelled", "", "getExplosionCancelled", "()Z", "setExplosionCancelled", "(Z)V", "explosionSize", "getExplosionSize", "()D", "explosionX", "getExplosionX", "explosionY", "getExplosionY", "explosionZ", "getExplosionZ", "grenadeItemId", "", "getGrenadeItemId", "()I", "setGrenadeItemId", "(I)V", "grenadeType", "Lgloomyfolken/mods/weapon/item/GrenadeType;", "getGrenadeType", "()Lgloomyfolken/mods/weapon/item/GrenadeType;", "setGrenadeType", "(Lgloomyfolken/mods/weapon/item/GrenadeType;)V", "mc", "Lnet/minecraft/client/Minecraft;", "kotlin.jvm.PlatformType", "worldObj", "getWorldObj", "()Lnet/minecraft/world/World;", "canDoExplosionAt", "x", "y", "z", "damageEntities", "", "damageEntity", "entity", "damage", "", "dt", "Lnet/minecraft/util/Vec3;", "explosionPower", "doClientExplosion", "doExplosion", "getBlockDensity", "par1Vec3", "par2AxisAlignedBB", "Lnet/minecraft/util/AxisAlignedBB;", "getExplosionAffectedEntities", "", "getFlashAmountForEntity", "Lnet/minecraft/entity/EntityLivingBase;", "entityEyePos", "lookVec", "getGrenadeItem", "Lgloomyfolken/mods/weapon/item/ItemGrenade;", "playExplosionSound", "pos", "soundName", "", "sendExplosionPacket", "spawnBaseExplosionEffect", "type", "withExplosionAuthor", "withGrenadeId", "withGrenadeType", "withInfo", "player", "PlayerExplosionInfo", "minecraft"})
public final class zwat {
    private final Minecraft _a;
    @NotNull
    private final World _b;
    private final double _c;
    private final double _d;
    private final double _e;
    private final double _f;
    @Nullable
    private Entity _g;
    private boolean _h;
    @NotNull
    private scai _i;
    private int _j;
    private final HashMap<EntityPlayer, kjui> _k;

    @NotNull
    public final World _a() {
        return this._b;
    }

    public final double _b() {
        return this._c;
    }

    public final double _c() {
        return this._d;
    }

    public final double _d() {
        return this._e;
    }

    public final double _e() {
        return this._f;
    }

    @Nullable
    public final Entity _f() {
        return this._g;
    }

    public final void _a(@Nullable Entity entity) {
        this._g = entity;
    }

    public final boolean _g() {
        return this._h;
    }

    public final void _a(boolean bl) {
        this._h = bl;
    }

    @NotNull
    public final scai _h() {
        return this._i;
    }

    public final void _a(@NotNull scai scai2) {
        Intrinsics.checkParameterIsNotNull((Object)scai2, "<set-?>");
        this._i = scai2;
    }

    public final int _i() {
        return this._j;
    }

    public final void _a(int n) {
        this._j = n;
    }

    @NotNull
    public final zwat _b(@NotNull scai scai2) {
        Intrinsics.checkParameterIsNotNull((Object)scai2, "grenadeType");
        this._i = scai2;
        return this;
    }

    @NotNull
    public final zwat _b(int n) {
        this._j = n;
        return this;
    }

    @NotNull
    public final zwat _b(@Nullable Entity entity) {
        this._g = entity;
        return this;
    }

    @ezey(_a={eidj.CLIENT})
    public final void _a(float f) {
        Vec3 vec3;
        Vec3 vec32 = vec3 = this._b.getWorldVec3Pool()._a(this._c, this._d, this._e);
        Intrinsics.checkExpressionValueIsNotNull(vec32, "pos");
        StringBuilder stringBuilder = new StringBuilder().append("weapons:");
        Object object = this._j();
        if (object == null || (object = ((yurw)object)._k) == null) {
            object = "grenade.explosion_default";
        }
        this._a(vec32, stringBuilder.append(object).toString());
        this._a(vec3, this._i);
        if (this._a._t.getDistanceSq(this._c, this._d, this._e) > (double)4096.0f) {
            return;
        }
        if (this._h) {
            return;
        }
        switch (zwaw._a[this._i.ordinal()]) {
            case 1: {
                float f2 = 20.0f;
                float f3 = 0.0f;
                if ((double)f > 0.0) {
                    f3 = f / f2;
                }
                jysc._b._a(new jhqd(vec3, this._f, 1.0f + f3));
                for (Entity entity : this._k()) {
                    double d;
                    if (!(entity instanceof EntityRagdollCorpse) || ((EntityRagdollCorpse)entity).isLeftovers() || !((d = entity.getDistance(vec3._c, vec3._d, vec3._e)) / this._f < 1.0)) continue;
                    double d2 = entity.posX - vec3._c;
                    double d3 = entity.posY + 1.5 - vec3._d;
                    double d4 = entity.posZ - vec3._e;
                    d2 /= d;
                    d3 /= d;
                    d4 /= d;
                    CorpseRagdollState corpseRagdollState = ((EntityRagdollCorpse)entity).getPhysicsState();
                    CorpseRagdollContext corpseRagdollContext = corpseRagdollState != null ? corpseRagdollState.getClientPhysicsContext() : null;
                    if (corpseRagdollContext == null) continue;
                    PhysicsImpulse physicsImpulse = new PhysicsImpulse(0.0f, 0.0f, 0.0f, (float)d2 * 10.0f, (float)d3 * 10.0f, (float)d4 * 10.0f);
                    physicsImpulse.setApplyType(ImpulseApplyType.BODY);
                    corpseRagdollContext.applyImpulse(physicsImpulse);
                }
                break;
            }
            case 2: {
                yurw yurw2 = this._j();
                if (yurw2 == null) {
                    return;
                }
                yurw yurw3 = yurw2;
                EntityClientPlayerMP entityClientPlayerMP = this._a._t;
                Intrinsics.checkExpressionValueIsNotNull(entityClientPlayerMP, "mc.thePlayer");
                EntityLivingBase entityLivingBase = entityClientPlayerMP;
                Vec3 vec33 = McExtensionsKt.getPos(this._a._t);
                Vec3 vec34 = this._a._t.getLookVec();
                if (vec34 == null) {
                    Intrinsics.throwNpe();
                }
                Intrinsics.checkExpressionValueIsNotNull(vec34, "mc.thePlayer.lookVec!!");
                float f4 = this._a(entityLivingBase, vec33, vec34);
                jysc._b._a(new jhqd(vec3, this._f, f));
                if (!(f4 > 0.0f)) break;
                jysc._b._a(new uygf((int)((float)yurw3._i * f4), f4));
            }
        }
    }

    @ezey(_a={eidj.CLIENT})
    private final void _a(Vec3 vec3, String string) {
        dwwh._a._a(0.0f, vec3._c, vec3._d, vec3._e, string, this._i._d ? 3.5f : 1.5f, 1.2f, false);
    }

    @ezey(_a={eidj.CLIENT})
    private final void _a(Vec3 vec3, scai scai2) {
        switch (zwaw._b[scai2.ordinal()]) {
            case 1: {
                Vec3 vec32 = this._b.getWorldVec3Pool()._a(this._c, this._d + 0.25, this._e);
                Intrinsics.checkExpressionValueIsNotNull(vec32, "worldObj.worldVec3Pool.g\u2026sionY + 0.25, explosionZ)");
                pidb._a(new ogjo(this._b, vec32));
                break;
            }
            case 2: {
                EntityItem entityItem = new EntityItem(this._b);
                entityItem.setPosition(VecExtensionsKt.getX(vec3), VecExtensionsKt.getY(vec3), VecExtensionsKt.getZ(vec3));
                fmsn fmsn2 = new fmsn(entityItem);
                zgiu zgiu2 = StalkerMiscMod.instance.__av.get("flash");
                if (zgiu2 == null) {
                    Intrinsics.throwNpe();
                }
                Intrinsics.checkExpressionValueIsNotNull(zgiu2, "StalkerMiscMod.instance.effectPresets[\"flash\"]!!");
                fmsn2._a(zgiu2);
                pidb._a(new ntvl(this));
            }
        }
    }

    private final float _a(final EntityLivingBase entityLivingBase, Vec3 vec3, Vec3 vec32) {
        Vec3 vec33 = VecExtensionsKt.sub(vec3, this._c, this._d, this._e);
        double d = 0.0;
        double d2 = -vec32._b(VecExtensionsKt.normalized(vec33));
        double d3 = owkq._a(Math.max(d, d2), 0.25);
        d3 *= owkq._b(1.5 - owkq._c(vec33._b() / 24.0), 0.0, 1.0);
        d = 1.0;
        d3 = Math.min(d, d3);
        if (vec33._b() < 3.0) {
            d3 = 1.0;
        }
        final Ref.DoubleRef doubleRef = new Ref.DoubleRef();
        doubleRef.element = 0.0;
        Vec3 vec34 = VecExtensionsKt.vec3(vec3);
        Intrinsics.checkExpressionValueIsNotNull(vec34, "vec3(entityEyePos)");
        Vec3 vec35 = VecExtensionsKt.vec3(this._c, this._d, this._e);
        Intrinsics.checkExpressionValueIsNotNull(vec35, "vec3(explosionX, explosionY, explosionZ)");
        gloomyfolken.mods.weapon.trace.pidb._a._a(this._b, vec34, vec35, false, true, (Function1<? super MovingObjectPosition, Boolean>)new Function1<MovingObjectPosition, Boolean>(){

            @Override
            public /* synthetic */ Object invoke(Object object) {
                return this._a((MovingObjectPosition)object);
            }

            public final boolean _a(@NotNull MovingObjectPosition movingObjectPosition) {
                Block block;
                int n;
                Intrinsics.checkParameterIsNotNull(movingObjectPosition, "it");
                if (Intrinsics.areEqual((Object)movingObjectPosition._c, (Object)EnumMovingObjectType._a) && (n = entityLivingBase.worldObj.getBlockId(movingObjectPosition._d, movingObjectPosition._e, movingObjectPosition._f)) > 0 && (block = Block.blocksList[n]) != null) {
                    doubleRef.element += (double)block.getLightOpacity(this._a(), movingObjectPosition._d, movingObjectPosition._e, movingObjectPosition._f) / 255.0;
                }
                return doubleRef.element >= (double)1.0f;
            }
        });
        double d4 = 1.0;
        double d5 = doubleRef.element;
        double d6 = 1.0;
        double d7 = d3;
        double d8 = Math.min(d4, d5);
        d3 = d7 * (d6 - d8);
        return (float)d3;
    }

    private final yurw _j() {
        if (this._j > 0) {
            Item item = Item.itemsList[this._j];
            if (!(item instanceof yurw)) {
                item = null;
            }
            return (yurw)item;
        }
        return null;
    }

    private final List<Entity> _k() {
        List list2;
        int n = sajh._c(this._c - this._f - 1.0);
        int n2 = sajh._c(this._c + this._f + 1.0);
        int n3 = sajh._c(this._d - this._f - 1.0);
        int n4 = sajh._c(this._d + this._f + 1.0);
        int n5 = sajh._c(this._e - this._f - 1.0);
        int n6 = sajh._c(this._e + this._f + 1.0);
        List list3 = list2 = this._b.getEntitiesWithinAABB(Entity.class, AxisAlignedBB._a()._a(n, n3, n5, n2, n4, n6));
        if (list3 == null) {
            throw new TypeCastException("null cannot be cast to non-null type kotlin.collections.List<net.minecraft.entity.Entity>");
        }
        return list3;
    }

    private final float _a(Vec3 vec3, AxisAlignedBB axisAlignedBB) {
        double d = 1.0 / ((axisAlignedBB._e - axisAlignedBB._b) * 2.0 + 1.0);
        double d2 = 1.0 / ((axisAlignedBB._f - axisAlignedBB._c) * 2.0 + 1.0);
        double d3 = 1.0 / ((axisAlignedBB._g - axisAlignedBB._d) * 2.0 + 1.0);
        int n = 0;
        int n2 = 0;
        float f = 0.0f;
        while (f <= 1.0f) {
            float f2 = 0.0f;
            while (f2 <= 1.0f) {
                float f3 = 0.0f;
                while (f3 <= 1.0f) {
                    double d4 = axisAlignedBB._b + (axisAlignedBB._e - axisAlignedBB._b) * (double)f;
                    double d5 = axisAlignedBB._c + (axisAlignedBB._f - axisAlignedBB._c) * (double)f2;
                    double d6 = axisAlignedBB._d + (axisAlignedBB._g - axisAlignedBB._d) * (double)f3;
                    if (this._b.func_72831_a(this._b.getWorldVec3Pool()._a(d4, d5, d6), vec3, false, true) == null) {
                        ++n;
                    }
                    ++n2;
                    f3 = (float)((double)f3 + d3);
                }
                f2 = (float)((double)f2 + d2);
            }
            f = (float)((double)f + d);
        }
        return (float)n / (float)n2;
    }

    private final kjui _a(EntityPlayer entityPlayer) {
        kjui kjui2 = this._k.get(entityPlayer);
        if (kjui2 == null) {
            kjui2 = new kjui();
        }
        kjui kjui3 = kjui2;
        this._k.putIfAbsent(entityPlayer, kjui3);
        kjui kjui4 = kjui3;
        Intrinsics.checkExpressionValueIsNotNull(kjui4, "info");
        return kjui4;
    }

    private final void _l() {
        InvokeSideOnly.frontend(new InvokeSideOnly.InvokeFrontendOnly(){

            @Override
            public final void run() {
            }
        });
    }

    private final void _m() {
        InvokeSideOnly.frontend(new InvokeSideOnly.InvokeFrontendOnly(){

            @Override
            public final void run() {
            }
        });
    }

    public zwat(@NotNull World world, double d, double d2, double d3, double d4) {
        Intrinsics.checkParameterIsNotNull(world, "world");
        this._a = Minecraft._E();
        this._i = scai._a;
        this._j = -1;
        zwat zwat2 = this;
        HashMap hashMap = new HashMap();
        zwat2._k = hashMap;
        this._b = world;
        this._f = d4;
        this._c = d;
        this._d = d2;
        this._e = d3;
    }

    @NotNull
    public static final /* synthetic */ List _a(zwat zwat2) {
        return zwat2._k();
    }

    public static final /* synthetic */ float _a(zwat zwat2, @NotNull Vec3 vec3, @NotNull AxisAlignedBB axisAlignedBB) {
        return zwat2._a(vec3, axisAlignedBB);
    }

    @NotNull
    public static final /* synthetic */ HashMap _b(zwat zwat2) {
        return zwat2._k;
    }

    @Metadata(mv={1, 1, 7}, bv={1, 0, 2}, k=1, d1={"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e\u00a8\u0006\u000f"}, d2={"Lgloomyfolken/mods/core/misc/CustomExplosion$PlayerExplosionInfo;", "", "()V", "damage", "", "getDamage", "()F", "setDamage", "(F)V", "velocity", "Lnet/minecraft/util/Vec3;", "getVelocity", "()Lnet/minecraft/util/Vec3;", "setVelocity", "(Lnet/minecraft/util/Vec3;)V", "minecraft"})
    public static final class kjui {
        @Nullable
        private Vec3 _a;
        private float _b;

        @Nullable
        public final Vec3 _a() {
            return this._a;
        }

        public final void _a(@Nullable Vec3 vec3) {
            this._a = vec3;
        }

        public final float _b() {
            return this._b;
        }

        public final void _a(float f) {
            this._b = f;
        }
    }
}

