/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.ktcore;

import com.google.common.io.ByteArrayDataInput;
import com.google.common.io.ByteArrayDataOutput;
import gloomyfolken.mods.core.main.GloomyCore;
import gloomyfolken.mods.core.misc.zwat;
import gloomyfolken.mods.ktcore.VecExtensionsKt;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import java.util.function.Consumer;
import java.util.stream.Stream;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import net.minecraft.entity.Entity;
import net.minecraft.entity.ai.lmyh;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.entity.xpzm;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.eidj;
import net.minecraft.util.iurn;
import net.minecraft.util.jxtc;
import net.minecraft.util.ofbx;
import net.minecraft.util.sajh;
import net.minecraft.util.vjta;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.lwjgl.util.vector.Vector3f;

@Metadata(mv={1, 1, 7}, bv={1, 0, 2}, k=2, d1={"\u0000\u00ba\u0001\n\u0000\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0010\u0004\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u000e\u0010\u0013\u001a\n \u0015*\u0004\u0018\u00010\u00140\u0014\u001a\u0016\u0010\u0013\u001a\n \u0015*\u0004\u0018\u00010\u00140\u00142\u0006\u0010\u0016\u001a\u00020\u000b\u001a\u000e\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a\u001a\u000e\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u0016\u001a\u00020\u000b\u001a0\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020 2\u0006\u0010\"\u001a\u00020 2\u0006\u0010#\u001a\u00020 2\b\b\u0002\u0010$\u001a\u00020 \u001a0\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020%2\u0006\u0010!\u001a\u00020%2\u0006\u0010\"\u001a\u00020%2\u0006\u0010#\u001a\u00020%2\b\b\u0002\u0010$\u001a\u00020 \u001a\u0010\u0010&\u001a\u0004\u0018\u00010'2\u0006\u0010(\u001a\u00020)\u001a\u0016\u0010*\u001a\n \u0015*\u0004\u0018\u00010\u000b0\u000b2\u0006\u0010+\u001a\u00020\u001c\u001a\"\u0010,\u001a\u00020\u001e*\u00020\u00142\u0006\u0010\"\u001a\u00020-2\u0006\u0010#\u001a\u00020-2\u0006\u0010.\u001a\u00020-\u001a\n\u0010/\u001a\u00020-*\u00020-\u001a\n\u0010/\u001a\u00020 *\u00020 \u001a\"\u00100\u001a\u00020%*\u0002012\u0006\u0010\u001f\u001a\u00020%2\u0006\u0010!\u001a\u00020%2\u0006\u00102\u001a\u00020%\u001a\n\u00103\u001a\u00020%*\u00020-\u001a\n\u00103\u001a\u00020%*\u00020 \u001a\n\u00104\u001a\u00020-*\u00020-\u001a\n\u00104\u001a\u00020 *\u00020 \u001a\n\u00105\u001a\u00020 *\u00020-\u001a\"\u00106\u001a\u00020%*\u0002012\u0006\u0010\u001f\u001a\u00020-2\u0006\u0010!\u001a\u00020-2\u0006\u00102\u001a\u00020-\u001a\u0012\u00106\u001a\u00020%*\u0002012\u0006\u0010\u0016\u001a\u00020\u000b\u001a\u0012\u00107\u001a\u00020-*\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u000b\u001a\n\u00108\u001a\u00020\u000b*\u00020\u0003\u001a*\u00109\u001a\n \u0015*\u0004\u0018\u00010\u000b0\u000b*\u00020:2\u0006\u0010\u001f\u001a\u00020%2\u0006\u0010!\u001a\u00020%2\u0006\u00102\u001a\u00020%\u001a\"\u0010;\u001a\u00020<*\u0002012\u0006\u0010\u001f\u001a\u00020%2\u0006\u0010!\u001a\u00020%2\u0006\u00102\u001a\u00020%\u001a\u0014\u0010=\u001a\u00020<*\u00020>2\u0006\u0010?\u001a\u00020\u0003H\u0007\u001a\n\u0010@\u001a\u00020<*\u00020A\u001a\u0012\u0010B\u001a\u00020\u001e*\u00020C2\u0006\u0010D\u001a\u00020\u000b\u001a\u001a\u0010B\u001a\u00020\u001e*\u00020E2\u0006\u0010F\u001a\u00020'2\u0006\u0010D\u001a\u00020\u000b\u001a\u0012\u0010G\u001a\u00020\u001e*\u00020C2\u0006\u0010D\u001a\u00020\u000b\u001a\u001a\u0010G\u001a\u00020\u001e*\u00020E2\u0006\u0010F\u001a\u00020'2\u0006\u0010D\u001a\u00020\u000b\u001a\u0012\u0010H\u001a\u00020\u001e*\u00020\u00032\u0006\u0010\n\u001a\u00020\u000b\u001a\u0012\u0010I\u001a\u00020\u001e*\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u000b\u001a\u0012\u0010I\u001a\u00020\u001e*\u00020\u00142\u0006\u0010\u0016\u001a\u00020J\u001a\u0012\u0010K\u001a\u00020\u001e*\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u000b\u001a\u0012\u0010K\u001a\u00020\u001e*\u00020\u00142\u0006\u0010\u0016\u001a\u00020J\u001a\u001a\u0010L\u001a\u00020\u001e*\u00020M2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010N\u001a\u00020-\u001a\u0012\u0010O\u001a\u00020\u001e*\u00020\u00032\u0006\u0010\n\u001a\u00020\u000b\u001a\u0012\u0010P\u001a\u00020\u001e*\u00020\u00032\u0006\u0010\n\u001a\u00020\u000b\u001a\n\u0010Q\u001a\u00020-*\u00020-\u001a\n\u0010Q\u001a\u00020 *\u00020 \u001a*\u0010*\u001a\n \u0015*\u0004\u0018\u00010\u000b0\u000b*\u0002012\u0006\u0010\u001f\u001a\u00020-2\u0006\u0010!\u001a\u00020-2\u0006\u00102\u001a\u00020-\u001a*\u0010*\u001a\n \u0015*\u0004\u0018\u00010\u000b0\u000b*\u0002012\u0006\u0010\u001f\u001a\u00020%2\u0006\u0010!\u001a\u00020%2\u0006\u00102\u001a\u00020%\u001a2\u0010R\u001a\u0002HS\"\u0004\b\u0000\u0010S*\b\u0012\u0004\u0012\u0002HS0\u00012\u0012\u0010T\u001a\u000e\u0012\u0004\u0012\u0002HS\u0012\u0004\u0012\u00020V0UH\u0086\b\u00a2\u0006\u0002\u0010W\u001a\u0012\u0010X\u001a\u00020\u001e*\u00020Y2\u0006\u0010Z\u001a\u00020\u000b\u001a\u001a\u0010X\u001a\u00020\u001e*\u00020E2\u0006\u0010F\u001a\u00020'2\u0006\u0010Z\u001a\u00020\u000b\u001a\u0012\u0010[\u001a\u00020\u001e*\u00020Y2\u0006\u0010Z\u001a\u00020\u000b\u001a\u001a\u0010[\u001a\u00020\u001e*\u00020E2\u0006\u0010F\u001a\u00020'2\u0006\u0010Z\u001a\u00020\u000b\"\u001b\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u00038F\u00a2\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005\"$\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u00068FX\u0087\u0004\u00a2\u0006\f\u0012\u0004\b\u0007\u0010\b\u001a\u0004\b\u0004\u0010\t\"\u0015\u0010\n\u001a\u00020\u000b*\u00020\u00038F\u00a2\u0006\u0006\u001a\u0004\b\f\u0010\r\"\u0015\u0010\u000e\u001a\u00020\u000b*\u00020\u00038F\u00a2\u0006\u0006\u001a\u0004\b\u000f\u0010\r\"\u0015\u0010\u0010\u001a\u00020\u0006*\u00020\u00038F\u00a2\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012\u00a8\u0006\\"}, d2={"ktTrackingPlayers", "", "Lnet/minecraft/entity/player/EntityPlayerMP;", "Lnet/minecraft/entity/Entity;", "getKtTrackingPlayers", "(Lnet/minecraft/entity/Entity;)Ljava/util/Collection;", "Lnet/minecraft/entity/EntityTrackerEntry;", "ktTrackingPlayers$annotations", "(Lnet/minecraft/entity/EntityTrackerEntry;)V", "(Lnet/minecraft/entity/EntityTrackerEntry;)Ljava/util/Collection;", "pos", "Lnet/minecraft/util/Vec3;", "getPos", "(Lnet/minecraft/entity/Entity;)Lnet/minecraft/util/Vec3;", "prevPos", "getPrevPos", "tracker", "getTracker", "(Lnet/minecraft/entity/Entity;)Lnet/minecraft/entity/EntityTrackerEntry;", "AxisAlignedBB", "Lnet/minecraft/util/AxisAlignedBB;", "kotlin.jvm.PlatformType", "v", "CustomExplosionDamageSource", "Lnet/minecraft/util/DamageSource;", "explosion", "Lgloomyfolken/mods/core/misc/CustomExplosion;", "PathPoint", "Lnet/minecraft/pathfinding/PathPoint;", "drawScaledQuad", "", "x", "", "y", "width", "height", "scale", "", "fileAsString", "", "resourceLocation", "Lnet/minecraft/util/ResourceLocation;", "vec3", "pathPoint", "clampLocal", "", "depth", "cos", "firstSolidBlockUnderY", "Lnet/minecraft/world/World;", "z", "floor_double", "frac", "fracf", "getBlockId", "getDistanceToVector", "getNearestPathableBlock", "getVecFromPool", "Lnet/minecraft/util/Vec3Pool;", "isBlockSolid", "", "isMutantAgroEnabledAt", "Lmods/regions/server/RegionManager;", "entity", "isOpped", "Lnet/minecraft/entity/player/EntityPlayer;", "readVec3", "Lcom/google/common/io/ByteArrayDataInput;", "dest", "Lnet/minecraft/nbt/NBTTagCompound;", "key", "readVec3f", "setLastTickPos", "setMax", "Lorg/lwjgl/util/vector/Vector3f;", "setMin", "setMoveTo", "Lnet/minecraft/entity/ai/EntityMoveHelper;", "speed", "setPos", "setPrevPos", "sin", "weightedRandomElement", "T", "selector", "Lkotlin/Function1;", "", "(Ljava/util/Collection;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "writeVec3", "Lcom/google/common/io/ByteArrayDataOutput;", "src", "writeVec3f", "minecraft"})
public final class McExtensionsKt {
    public static /* synthetic */ void ktTrackingPlayers$annotations(xpzm xpzm2) {
    }

    @NotNull
    public static final Collection<EntityPlayerMP> getKtTrackingPlayers(@NotNull xpzm xpzm2) {
        Intrinsics.checkParameterIsNotNull(xpzm2, "$receiver");
        Set set = xpzm2._w;
        if (set == null) {
            throw new TypeCastException("null cannot be cast to non-null type kotlin.collections.Collection<net.minecraft.entity.player.EntityPlayerMP>");
        }
        return set;
    }

    @NotNull
    public static final xpzm getTracker(@NotNull Entity entity) {
        Intrinsics.checkParameterIsNotNull(entity, "$receiver");
        ozlu ozlu2 = entity.field_70170_p;
        if (ozlu2 == null) {
            throw new TypeCastException("null cannot be cast to non-null type net.minecraft.world.WorldServer");
        }
        Object object = ((yfgy)ozlu2).func_73039_n()._c._b(entity.field_70157_k);
        if (object == null) {
            throw new TypeCastException("null cannot be cast to non-null type net.minecraft.entity.EntityTrackerEntry");
        }
        return (xpzm)object;
    }

    @NotNull
    public static final Collection<EntityPlayerMP> getKtTrackingPlayers(@NotNull Entity entity) {
        Intrinsics.checkParameterIsNotNull(entity, "$receiver");
        return McExtensionsKt.getKtTrackingPlayers(McExtensionsKt.getTracker(entity));
    }

    public static final boolean isOpped(@NotNull EntityPlayer entityPlayer) {
        Intrinsics.checkParameterIsNotNull(entityPlayer, "$receiver");
        return entityPlayer.field_70170_p.field_72995_K ? true : dzfd._I().__ag()._g(entityPlayer.field_71092_bJ);
    }

    @NotNull
    public static final ofbx getPos(@NotNull Entity entity) {
        Intrinsics.checkParameterIsNotNull(entity, "$receiver");
        ofbx ofbx2 = ofbx._a(entity.field_70165_t, entity.field_70163_u, entity.field_70161_v);
        Intrinsics.checkExpressionValueIsNotNull(ofbx2, "Vec3.createVectorHelper(posX, posY, posZ)");
        return ofbx2;
    }

    @NotNull
    public static final ofbx getPrevPos(@NotNull Entity entity) {
        Intrinsics.checkParameterIsNotNull(entity, "$receiver");
        ofbx ofbx2 = ofbx._a(entity.field_70169_q, entity.field_70167_r, entity.field_70166_s);
        Intrinsics.checkExpressionValueIsNotNull(ofbx2, "Vec3.createVectorHelper(\u2026PosX, prevPosY, prevPosZ)");
        return ofbx2;
    }

    public static final void setMoveTo(@NotNull lmyh lmyh2, @NotNull ofbx ofbx2, double d) {
        Intrinsics.checkParameterIsNotNull(lmyh2, "$receiver");
        Intrinsics.checkParameterIsNotNull(ofbx2, "pos");
        lmyh2._a(VecExtensionsKt.getX(ofbx2), VecExtensionsKt.getY(ofbx2), VecExtensionsKt.getZ(ofbx2), d);
    }

    public static final int floor_double(float f) {
        return sajh._c(owkq._r(f));
    }

    public static final float frac(float f) {
        return f - (float)((int)f);
    }

    public static final int floor_double(double d) {
        return sajh._c(d);
    }

    public static final float fracf(double d) {
        return owkq._j(d - (double)((int)d));
    }

    public static final double frac(double d) {
        return d - (double)((int)d);
    }

    public static final eidj AxisAlignedBB(@NotNull ofbx ofbx2) {
        Intrinsics.checkParameterIsNotNull(ofbx2, "v");
        return eidj._a(VecExtensionsKt.getX(ofbx2), VecExtensionsKt.getY(ofbx2), VecExtensionsKt.getZ(ofbx2), VecExtensionsKt.getX(ofbx2), VecExtensionsKt.getY(ofbx2), VecExtensionsKt.getZ(ofbx2));
    }

    public static final eidj AxisAlignedBB() {
        return eidj._a(0.0, 0.0, 0.0, 0.0, 0.0, 0.0);
    }

    public static final void setMin(@NotNull eidj eidj2, @NotNull ofbx ofbx2) {
        Intrinsics.checkParameterIsNotNull(eidj2, "$receiver");
        Intrinsics.checkParameterIsNotNull(ofbx2, "v");
        eidj2._b = VecExtensionsKt.getX(ofbx2);
        eidj2._c = VecExtensionsKt.getY(ofbx2);
        eidj2._d = VecExtensionsKt.getZ(ofbx2);
    }

    public static final void setMax(@NotNull eidj eidj2, @NotNull ofbx ofbx2) {
        Intrinsics.checkParameterIsNotNull(eidj2, "$receiver");
        Intrinsics.checkParameterIsNotNull(ofbx2, "v");
        eidj2._e = VecExtensionsKt.getX(ofbx2);
        eidj2._f = VecExtensionsKt.getY(ofbx2);
        eidj2._g = VecExtensionsKt.getZ(ofbx2);
    }

    public static final void setMin(@NotNull eidj eidj2, @NotNull Vector3f vector3f) {
        Intrinsics.checkParameterIsNotNull(eidj2, "$receiver");
        Intrinsics.checkParameterIsNotNull(vector3f, "v");
        eidj2._b = vector3f.x;
        eidj2._c = vector3f.y;
        eidj2._d = vector3f.z;
    }

    public static final void setMax(@NotNull eidj eidj2, @NotNull Vector3f vector3f) {
        Intrinsics.checkParameterIsNotNull(eidj2, "$receiver");
        Intrinsics.checkParameterIsNotNull(vector3f, "v");
        eidj2._e = vector3f.x;
        eidj2._f = vector3f.y;
        eidj2._g = vector3f.z;
    }

    public static final void drawScaledQuad(int n, int n2, int n3, int n4, float f) {
        McExtensionsKt.drawScaledQuad((float)n, (float)n2, (float)n3, (float)n4, f);
    }

    public static /* synthetic */ void drawScaledQuad$default(int n, int n2, int n3, int n4, float f, int n5, Object object) {
        if ((n5 & 0x10) != 0) {
            f = 1.0f;
        }
        McExtensionsKt.drawScaledQuad(n, n2, n3, n4, f);
    }

    public static final void drawScaledQuad(float f, float f2, float f3, float f4, float f5) {
        htvf htvf2 = htvf.field_78398_a;
        htvf2.func_78382_b();
        htvf2.func_78374_a(f * f5, (f2 + f4) * f5, -90.0, 0.0, 0.0);
        htvf2.func_78374_a((f + f3) * f5, (f2 + f4) * f5, -90.0, 1.0, 0.0);
        htvf2.func_78374_a((f + f3) * f5, f2 * f5, -90.0, 1.0, 1.0);
        htvf2.func_78374_a(f * f5, f2 * f5, -90.0, 0.0, 1.0);
        htvf2.func_78381_a();
    }

    public static /* synthetic */ void drawScaledQuad$default(float f, float f2, float f3, float f4, float f5, int n, Object object) {
        if ((n & 0x10) != 0) {
            f5 = 1.0f;
        }
        McExtensionsKt.drawScaledQuad(f, f2, f3, f4, f5);
    }

    public static final ofbx vec3(@NotNull elhc elhc2) {
        Intrinsics.checkParameterIsNotNull(elhc2, "pathPoint");
        return ofbx._a((double)elhc2._a + 0.5, elhc2._b, (double)elhc2._c + 0.5);
    }

    @NotNull
    public static final elhc PathPoint(@NotNull ofbx ofbx2) {
        Intrinsics.checkParameterIsNotNull(ofbx2, "v");
        ofbx ofbx3 = VecExtensionsKt.floor_double(ofbx2);
        return new elhc((int)ofbx3._c, (int)ofbx3._d, (int)ofbx3._e);
    }

    @NotNull
    public static final jxtc CustomExplosionDamageSource(@NotNull zwat zwat2) {
        jxtc jxtc2;
        Intrinsics.checkParameterIsNotNull(zwat2, "explosion");
        if (zwat2._f() != null) {
            jxtc jxtc3 = new vjta("explosion.player", zwat2._f()).func_94540_d();
            jxtc2 = jxtc3;
            Intrinsics.checkExpressionValueIsNotNull(jxtc3, "EntityDamageSource(\"expl\u2026ionAuthor).setExplosion()");
        } else {
            jxtc jxtc4 = jxtc.func_94539_a(null);
            jxtc2 = jxtc4;
            Intrinsics.checkExpressionValueIsNotNull(jxtc4, "DamageSource.setExplosionSource(null)");
        }
        return jxtc2;
    }

    public static final void clampLocal(@NotNull eidj eidj2, double d, double d2, double d3) {
        Intrinsics.checkParameterIsNotNull(eidj2, "$receiver");
        double d4 = (eidj2._e - eidj2._b) / 2.0;
        double d5 = (eidj2._f - eidj2._c) / 2.0;
        double d6 = (eidj2._g - eidj2._d) / 2.0;
        eidj eidj3 = eidj2._e(d4, d5, d6);
        eidj eidj4 = eidj3._b(owkq._c(d4, d / 2.0), owkq._c(d5, d2 / 2.0), owkq._c(d6, d3 / 2.0));
        eidj2._c(eidj4);
    }

    @NotNull
    public static final ofbx getNearestPathableBlock(@NotNull Entity entity) {
        int n;
        int n2;
        int n3;
        Intrinsics.checkParameterIsNotNull(entity, "$receiver");
        int n4 = (int)Math.round(entity.field_70165_t) - 1;
        int n5 = (int)Math.round(entity.field_70161_v) - 1;
        int n6 = n4 + 1;
        int n7 = n5 + 1;
        int n8 = owkq._k((float)(entity.field_70163_u - 0.05));
        boolean bl = false;
        int n9 = 0;
        int n10 = 0;
        int n11 = 0;
        double d = 9999999.0;
        int n12 = n4;
        int n13 = n6;
        if (n12 <= n13) {
            while (true) {
                if ((n3 = n5) <= (n2 = n7)) {
                    while (true) {
                        if (entity.field_70122_E) {
                            double d2;
                            double d3;
                            double d4;
                            if (McExtensionsKt.isBlockSolid(entity.field_70170_p, n12, n8 - 1, n3) && (d4 = (d3 = entity.field_70165_t - (double)n12) * d3 + (d2 = entity.field_70161_v - (double)n3) * d2) < d) {
                                d = d4;
                                n9 = n12;
                                n10 = n8 - 1;
                                n11 = n3;
                                bl = true;
                            }
                        } else {
                            n = McExtensionsKt.firstSolidBlockUnderY(entity.field_70170_p, n12, n8, n3);
                            if (n > n10) {
                                n9 = n12;
                                n10 = n;
                                n11 = n3;
                                bl = true;
                            }
                        }
                        if (n3 == n2) break;
                        ++n3;
                    }
                }
                if (n12 == n13) break;
                ++n12;
            }
        }
        if (!bl && (n12 = n4) <= (n13 = n6)) {
            while (true) {
                if ((n3 = n5) <= (n2 = n7)) {
                    while (true) {
                        if ((n = McExtensionsKt.firstSolidBlockUnderY(entity.field_70170_p, n12, n8, n3)) > n10) {
                            n9 = n12;
                            n10 = n;
                            n11 = n3;
                        }
                        if (n3 == n2) break;
                        ++n3;
                    }
                }
                if (n12 == n13) break;
                ++n12;
            }
        }
        ofbx ofbx2 = McExtensionsKt.vec3(entity.field_70170_p, n9, n10, n11);
        Intrinsics.checkExpressionValueIsNotNull(ofbx2, "worldObj.vec3(bestX, bestY, bestZ)");
        return ofbx2;
    }

    public static final void setPrevPos(@NotNull Entity entity, @NotNull ofbx ofbx2) {
        Intrinsics.checkParameterIsNotNull(entity, "$receiver");
        Intrinsics.checkParameterIsNotNull(ofbx2, "pos");
        entity.field_70169_q = VecExtensionsKt.getX(ofbx2);
        entity.field_70167_r = VecExtensionsKt.getY(ofbx2);
        entity.field_70166_s = VecExtensionsKt.getZ(ofbx2);
    }

    public static final void setLastTickPos(@NotNull Entity entity, @NotNull ofbx ofbx2) {
        Intrinsics.checkParameterIsNotNull(entity, "$receiver");
        Intrinsics.checkParameterIsNotNull(ofbx2, "pos");
        entity.field_70142_S = VecExtensionsKt.getX(ofbx2);
        entity.field_70137_T = VecExtensionsKt.getY(ofbx2);
        entity.field_70136_U = VecExtensionsKt.getZ(ofbx2);
    }

    public static final void setPos(@NotNull Entity entity, @NotNull ofbx ofbx2) {
        Intrinsics.checkParameterIsNotNull(entity, "$receiver");
        Intrinsics.checkParameterIsNotNull(ofbx2, "pos");
        entity.field_70165_t = VecExtensionsKt.getX(ofbx2);
        entity.field_70163_u = VecExtensionsKt.getY(ofbx2);
        entity.field_70161_v = VecExtensionsKt.getZ(ofbx2);
    }

    public static final double getDistanceToVector(@NotNull Entity entity, @NotNull ofbx ofbx2) {
        Intrinsics.checkParameterIsNotNull(entity, "$receiver");
        Intrinsics.checkParameterIsNotNull(ofbx2, "v");
        double d = ofbx2._c - entity.field_70165_t;
        double d2 = ofbx2._d - entity.field_70163_u;
        double d3 = ofbx2._e - entity.field_70161_v;
        return owkq._d(d3 * d3 + d2 * d2 + d * d);
    }

    public static final ofbx vec3(@NotNull ozlu ozlu2, double d, double d2, double d3) {
        Intrinsics.checkParameterIsNotNull(ozlu2, "$receiver");
        return ozlu2.func_82732_R()._a(d, d2, d3);
    }

    public static final ofbx vec3(@NotNull ozlu ozlu2, int n, int n2, int n3) {
        Intrinsics.checkParameterIsNotNull(ozlu2, "$receiver");
        return ozlu2.func_82732_R()._a(owkq._o(n), owkq._o(n2), owkq._o(n3));
    }

    public static final boolean isBlockSolid(@NotNull ozlu ozlu2, int n, int n2, int n3) {
        Intrinsics.checkParameterIsNotNull(ozlu2, "$receiver");
        int n4 = ozlu2.func_72798_a(n, n2, n3);
        return n4 != 0 && twgu.field_71973_m[n4].field_72018_cp._c();
    }

    public static final int firstSolidBlockUnderY(@NotNull ozlu ozlu2, int n, int n2, int n3) {
        Intrinsics.checkParameterIsNotNull(ozlu2, "$receiver");
        int n4 = n2;
        while (--n4 > 0 && !McExtensionsKt.isBlockSolid(ozlu2, n, n4, n3)) {
        }
        return n4;
    }

    public static final void writeVec3(@NotNull ByteArrayDataOutput byteArrayDataOutput, @NotNull ofbx ofbx2) {
        Intrinsics.checkParameterIsNotNull(byteArrayDataOutput, "$receiver");
        Intrinsics.checkParameterIsNotNull(ofbx2, "src");
        byteArrayDataOutput.writeDouble(ofbx2._c);
        byteArrayDataOutput.writeDouble(ofbx2._d);
        byteArrayDataOutput.writeDouble(ofbx2._e);
    }

    public static final void writeVec3f(@NotNull ByteArrayDataOutput byteArrayDataOutput, @NotNull ofbx ofbx2) {
        Intrinsics.checkParameterIsNotNull(byteArrayDataOutput, "$receiver");
        Intrinsics.checkParameterIsNotNull(ofbx2, "src");
        byteArrayDataOutput.writeFloat((float)ofbx2._c);
        byteArrayDataOutput.writeFloat((float)ofbx2._d);
        byteArrayDataOutput.writeFloat((float)ofbx2._e);
    }

    public static final void readVec3(@NotNull ByteArrayDataInput byteArrayDataInput, @NotNull ofbx ofbx2) {
        Intrinsics.checkParameterIsNotNull(byteArrayDataInput, "$receiver");
        Intrinsics.checkParameterIsNotNull(ofbx2, "dest");
        VecExtensionsKt.set(ofbx2, byteArrayDataInput.readDouble(), byteArrayDataInput.readDouble(), byteArrayDataInput.readDouble());
    }

    public static final void readVec3f(@NotNull ByteArrayDataInput byteArrayDataInput, @NotNull ofbx ofbx2) {
        Intrinsics.checkParameterIsNotNull(byteArrayDataInput, "$receiver");
        Intrinsics.checkParameterIsNotNull(ofbx2, "dest");
        VecExtensionsKt.set(ofbx2, byteArrayDataInput.readFloat(), byteArrayDataInput.readFloat(), byteArrayDataInput.readFloat());
    }

    public static final void writeVec3(@NotNull qoac qoac2, @NotNull String string, @NotNull ofbx ofbx2) {
        Intrinsics.checkParameterIsNotNull(qoac2, "$receiver");
        Intrinsics.checkParameterIsNotNull(string, "key");
        Intrinsics.checkParameterIsNotNull(ofbx2, "src");
        qoac2._a("" + string + 'X', ofbx2._c);
        qoac2._a("" + string + 'Y', ofbx2._d);
        qoac2._a("" + string + 'Z', ofbx2._e);
    }

    public static final void writeVec3f(@NotNull qoac qoac2, @NotNull String string, @NotNull ofbx ofbx2) {
        Intrinsics.checkParameterIsNotNull(qoac2, "$receiver");
        Intrinsics.checkParameterIsNotNull(string, "key");
        Intrinsics.checkParameterIsNotNull(ofbx2, "src");
        qoac2._a("" + string + 'X', (float)ofbx2._c);
        qoac2._a("" + string + 'Y', (float)ofbx2._d);
        qoac2._a("" + string + 'Z', (float)ofbx2._e);
    }

    public static final void readVec3(@NotNull qoac qoac2, @NotNull String string, @NotNull ofbx ofbx2) {
        Intrinsics.checkParameterIsNotNull(qoac2, "$receiver");
        Intrinsics.checkParameterIsNotNull(string, "key");
        Intrinsics.checkParameterIsNotNull(ofbx2, "dest");
        VecExtensionsKt.set(ofbx2, qoac2._i("" + string + 'X'), qoac2._i("" + string + 'Y'), qoac2._i("" + string + 'Z'));
    }

    public static final void readVec3f(@NotNull qoac qoac2, @NotNull String string, @NotNull ofbx ofbx2) {
        Intrinsics.checkParameterIsNotNull(qoac2, "$receiver");
        Intrinsics.checkParameterIsNotNull(string, "key");
        Intrinsics.checkParameterIsNotNull(ofbx2, "dest");
        VecExtensionsKt.set(ofbx2, qoac2._h("" + string + 'X'), qoac2._h("" + string + 'Y'), qoac2._h("" + string + 'Z'));
    }

    public static final ofbx getVecFromPool(@NotNull iurn iurn2, int n, int n2, int n3) {
        Intrinsics.checkParameterIsNotNull(iurn2, "$receiver");
        return iurn2._a(owkq._o(n), owkq._o(n2), owkq._o(n3));
    }

    public static final int getBlockId(@NotNull ozlu ozlu2, double d, double d2, double d3) {
        Intrinsics.checkParameterIsNotNull(ozlu2, "$receiver");
        return ozlu2.func_72798_a(sajh._c(d), sajh._c(d2), sajh._c(d3));
    }

    public static final int getBlockId(@NotNull ozlu ozlu2, @NotNull ofbx ofbx2) {
        Intrinsics.checkParameterIsNotNull(ozlu2, "$receiver");
        Intrinsics.checkParameterIsNotNull(ofbx2, "v");
        return McExtensionsKt.getBlockId(ozlu2, VecExtensionsKt.getX(ofbx2), VecExtensionsKt.getY(ofbx2), VecExtensionsKt.getZ(ofbx2));
    }

    public static final float sin(float f) {
        return sajh._a(f);
    }

    public static final float cos(float f) {
        return sajh._a(owkq._b() - f);
    }

    public static final double sin(double d) {
        return owkq._r(sajh._a(owkq._j(d)));
    }

    public static final double cos(double d) {
        return owkq._r(sajh._a(owkq._b() - owkq._j(d)));
    }

    @Nullable
    public static final String fileAsString(@NotNull ResourceLocation resourceLocation) {
        BufferedReader bufferedReader;
        Intrinsics.checkParameterIsNotNull(resourceLocation, "resourceLocation");
        String string = "/assets/" + resourceLocation.func_110624_b() + "/" + resourceLocation.func_110623_a();
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(GloomyCore.class.getResourceAsStream(string), "UTF-8"));
        }
        catch (Exception exception) {
            exception.printStackTrace();
            return null;
        }
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        objectRef.element = "";
        Stream<String> stream = bufferedReader.lines();
        stream.forEach(new Consumer<String>(objectRef){
            final /* synthetic */ Ref.ObjectRef $result;

            public final void accept(String string) {
                this.$result.element = (String)this.$result.element + string + "\n";
            }
            {
                this.$result = objectRef;
            }
        });
        stream.close();
        bufferedReader.close();
        return (String)objectRef.element;
    }

    public static final <T> T weightedRandomElement(@NotNull Collection<? extends T> collection, @NotNull Function1<? super T, ? extends Number> function1) {
        Intrinsics.checkParameterIsNotNull(collection, "$receiver");
        Intrinsics.checkParameterIsNotNull(function1, "selector");
        int n = -1;
        double d = 0.0;
        double d2 = Math.random();
        Iterable iterable = collection;
        double d3 = 0.0;
        Iterator iterator2 = iterable.iterator();
        while (iterator2.hasNext()) {
            Object t;
            Object t2 = t = iterator2.next();
            double d4 = d3;
            double d5 = function1.invoke(t2).doubleValue();
            d3 = d4 + d5;
        }
        double d6 = d3;
        while (d2 >= d && ++n < collection.size()) {
            d += function1.invoke(CollectionsKt.elementAt((Iterable)collection, n)).doubleValue() / d6;
        }
        return CollectionsKt.elementAt((Iterable)collection, n);
    }
}

