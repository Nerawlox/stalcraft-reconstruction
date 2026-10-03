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
import net.minecraft.block.Block;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityTrackerEntry;
import net.minecraft.entity.ai.EntityMoveHelper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EntityDamageSource;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Vec3;
import net.minecraft.util.Vec3Pool;
import net.minecraft.util.sajh;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.lwjgl.util.vector.Vector3f;

@Metadata(mv={1, 1, 7}, bv={1, 0, 2}, k=2, d1={"\u0000\u00ba\u0001\n\u0000\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0010\u0004\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u000e\u0010\u0013\u001a\n \u0015*\u0004\u0018\u00010\u00140\u0014\u001a\u0016\u0010\u0013\u001a\n \u0015*\u0004\u0018\u00010\u00140\u00142\u0006\u0010\u0016\u001a\u00020\u000b\u001a\u000e\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a\u001a\u000e\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u0016\u001a\u00020\u000b\u001a0\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020 2\u0006\u0010\"\u001a\u00020 2\u0006\u0010#\u001a\u00020 2\b\b\u0002\u0010$\u001a\u00020 \u001a0\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020%2\u0006\u0010!\u001a\u00020%2\u0006\u0010\"\u001a\u00020%2\u0006\u0010#\u001a\u00020%2\b\b\u0002\u0010$\u001a\u00020 \u001a\u0010\u0010&\u001a\u0004\u0018\u00010'2\u0006\u0010(\u001a\u00020)\u001a\u0016\u0010*\u001a\n \u0015*\u0004\u0018\u00010\u000b0\u000b2\u0006\u0010+\u001a\u00020\u001c\u001a\"\u0010,\u001a\u00020\u001e*\u00020\u00142\u0006\u0010\"\u001a\u00020-2\u0006\u0010#\u001a\u00020-2\u0006\u0010.\u001a\u00020-\u001a\n\u0010/\u001a\u00020-*\u00020-\u001a\n\u0010/\u001a\u00020 *\u00020 \u001a\"\u00100\u001a\u00020%*\u0002012\u0006\u0010\u001f\u001a\u00020%2\u0006\u0010!\u001a\u00020%2\u0006\u00102\u001a\u00020%\u001a\n\u00103\u001a\u00020%*\u00020-\u001a\n\u00103\u001a\u00020%*\u00020 \u001a\n\u00104\u001a\u00020-*\u00020-\u001a\n\u00104\u001a\u00020 *\u00020 \u001a\n\u00105\u001a\u00020 *\u00020-\u001a\"\u00106\u001a\u00020%*\u0002012\u0006\u0010\u001f\u001a\u00020-2\u0006\u0010!\u001a\u00020-2\u0006\u00102\u001a\u00020-\u001a\u0012\u00106\u001a\u00020%*\u0002012\u0006\u0010\u0016\u001a\u00020\u000b\u001a\u0012\u00107\u001a\u00020-*\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u000b\u001a\n\u00108\u001a\u00020\u000b*\u00020\u0003\u001a*\u00109\u001a\n \u0015*\u0004\u0018\u00010\u000b0\u000b*\u00020:2\u0006\u0010\u001f\u001a\u00020%2\u0006\u0010!\u001a\u00020%2\u0006\u00102\u001a\u00020%\u001a\"\u0010;\u001a\u00020<*\u0002012\u0006\u0010\u001f\u001a\u00020%2\u0006\u0010!\u001a\u00020%2\u0006\u00102\u001a\u00020%\u001a\u0014\u0010=\u001a\u00020<*\u00020>2\u0006\u0010?\u001a\u00020\u0003H\u0007\u001a\n\u0010@\u001a\u00020<*\u00020A\u001a\u0012\u0010B\u001a\u00020\u001e*\u00020C2\u0006\u0010D\u001a\u00020\u000b\u001a\u001a\u0010B\u001a\u00020\u001e*\u00020E2\u0006\u0010F\u001a\u00020'2\u0006\u0010D\u001a\u00020\u000b\u001a\u0012\u0010G\u001a\u00020\u001e*\u00020C2\u0006\u0010D\u001a\u00020\u000b\u001a\u001a\u0010G\u001a\u00020\u001e*\u00020E2\u0006\u0010F\u001a\u00020'2\u0006\u0010D\u001a\u00020\u000b\u001a\u0012\u0010H\u001a\u00020\u001e*\u00020\u00032\u0006\u0010\n\u001a\u00020\u000b\u001a\u0012\u0010I\u001a\u00020\u001e*\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u000b\u001a\u0012\u0010I\u001a\u00020\u001e*\u00020\u00142\u0006\u0010\u0016\u001a\u00020J\u001a\u0012\u0010K\u001a\u00020\u001e*\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u000b\u001a\u0012\u0010K\u001a\u00020\u001e*\u00020\u00142\u0006\u0010\u0016\u001a\u00020J\u001a\u001a\u0010L\u001a\u00020\u001e*\u00020M2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010N\u001a\u00020-\u001a\u0012\u0010O\u001a\u00020\u001e*\u00020\u00032\u0006\u0010\n\u001a\u00020\u000b\u001a\u0012\u0010P\u001a\u00020\u001e*\u00020\u00032\u0006\u0010\n\u001a\u00020\u000b\u001a\n\u0010Q\u001a\u00020-*\u00020-\u001a\n\u0010Q\u001a\u00020 *\u00020 \u001a*\u0010*\u001a\n \u0015*\u0004\u0018\u00010\u000b0\u000b*\u0002012\u0006\u0010\u001f\u001a\u00020-2\u0006\u0010!\u001a\u00020-2\u0006\u00102\u001a\u00020-\u001a*\u0010*\u001a\n \u0015*\u0004\u0018\u00010\u000b0\u000b*\u0002012\u0006\u0010\u001f\u001a\u00020%2\u0006\u0010!\u001a\u00020%2\u0006\u00102\u001a\u00020%\u001a2\u0010R\u001a\u0002HS\"\u0004\b\u0000\u0010S*\b\u0012\u0004\u0012\u0002HS0\u00012\u0012\u0010T\u001a\u000e\u0012\u0004\u0012\u0002HS\u0012\u0004\u0012\u00020V0UH\u0086\b\u00a2\u0006\u0002\u0010W\u001a\u0012\u0010X\u001a\u00020\u001e*\u00020Y2\u0006\u0010Z\u001a\u00020\u000b\u001a\u001a\u0010X\u001a\u00020\u001e*\u00020E2\u0006\u0010F\u001a\u00020'2\u0006\u0010Z\u001a\u00020\u000b\u001a\u0012\u0010[\u001a\u00020\u001e*\u00020Y2\u0006\u0010Z\u001a\u00020\u000b\u001a\u001a\u0010[\u001a\u00020\u001e*\u00020E2\u0006\u0010F\u001a\u00020'2\u0006\u0010Z\u001a\u00020\u000b\"\u001b\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u00038F\u00a2\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005\"$\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u00068FX\u0087\u0004\u00a2\u0006\f\u0012\u0004\b\u0007\u0010\b\u001a\u0004\b\u0004\u0010\t\"\u0015\u0010\n\u001a\u00020\u000b*\u00020\u00038F\u00a2\u0006\u0006\u001a\u0004\b\f\u0010\r\"\u0015\u0010\u000e\u001a\u00020\u000b*\u00020\u00038F\u00a2\u0006\u0006\u001a\u0004\b\u000f\u0010\r\"\u0015\u0010\u0010\u001a\u00020\u0006*\u00020\u00038F\u00a2\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012\u00a8\u0006\\"}, d2={"ktTrackingPlayers", "", "Lnet/minecraft/entity/player/EntityPlayerMP;", "Lnet/minecraft/entity/Entity;", "getKtTrackingPlayers", "(Lnet/minecraft/entity/Entity;)Ljava/util/Collection;", "Lnet/minecraft/entity/EntityTrackerEntry;", "ktTrackingPlayers$annotations", "(Lnet/minecraft/entity/EntityTrackerEntry;)V", "(Lnet/minecraft/entity/EntityTrackerEntry;)Ljava/util/Collection;", "pos", "Lnet/minecraft/util/Vec3;", "getPos", "(Lnet/minecraft/entity/Entity;)Lnet/minecraft/util/Vec3;", "prevPos", "getPrevPos", "tracker", "getTracker", "(Lnet/minecraft/entity/Entity;)Lnet/minecraft/entity/EntityTrackerEntry;", "AxisAlignedBB", "Lnet/minecraft/util/AxisAlignedBB;", "kotlin.jvm.PlatformType", "v", "CustomExplosionDamageSource", "Lnet/minecraft/util/DamageSource;", "explosion", "Lgloomyfolken/mods/core/misc/CustomExplosion;", "PathPoint", "Lnet/minecraft/pathfinding/PathPoint;", "drawScaledQuad", "", "x", "", "y", "width", "height", "scale", "", "fileAsString", "", "resourceLocation", "Lnet/minecraft/util/ResourceLocation;", "vec3", "pathPoint", "clampLocal", "", "depth", "cos", "firstSolidBlockUnderY", "Lnet/minecraft/world/World;", "z", "floor_double", "frac", "fracf", "getBlockId", "getDistanceToVector", "getNearestPathableBlock", "getVecFromPool", "Lnet/minecraft/util/Vec3Pool;", "isBlockSolid", "", "isMutantAgroEnabledAt", "Lmods/regions/server/RegionManager;", "entity", "isOpped", "Lnet/minecraft/entity/player/EntityPlayer;", "readVec3", "Lcom/google/common/io/ByteArrayDataInput;", "dest", "Lnet/minecraft/nbt/NBTTagCompound;", "key", "readVec3f", "setLastTickPos", "setMax", "Lorg/lwjgl/util/vector/Vector3f;", "setMin", "setMoveTo", "Lnet/minecraft/entity/ai/EntityMoveHelper;", "speed", "setPos", "setPrevPos", "sin", "weightedRandomElement", "T", "selector", "Lkotlin/Function1;", "", "(Ljava/util/Collection;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "writeVec3", "Lcom/google/common/io/ByteArrayDataOutput;", "src", "writeVec3f", "minecraft"})
public final class McExtensionsKt {
    public static /* synthetic */ void ktTrackingPlayers$annotations(EntityTrackerEntry entityTrackerEntry) {
    }

    @NotNull
    public static final Collection<EntityPlayerMP> getKtTrackingPlayers(@NotNull EntityTrackerEntry entityTrackerEntry) {
        Intrinsics.checkParameterIsNotNull(entityTrackerEntry, "$receiver");
        Set set = entityTrackerEntry._w;
        if (set == null) {
            throw new TypeCastException("null cannot be cast to non-null type kotlin.collections.Collection<net.minecraft.entity.player.EntityPlayerMP>");
        }
        return set;
    }

    @NotNull
    public static final EntityTrackerEntry getTracker(@NotNull Entity entity) {
        Intrinsics.checkParameterIsNotNull(entity, "$receiver");
        World world = entity.worldObj;
        if (world == null) {
            throw new TypeCastException("null cannot be cast to non-null type net.minecraft.world.WorldServer");
        }
        Object object = ((WorldServer)world).getEntityTracker()._c._b(entity.entityId);
        if (object == null) {
            throw new TypeCastException("null cannot be cast to non-null type net.minecraft.entity.EntityTrackerEntry");
        }
        return (EntityTrackerEntry)object;
    }

    @NotNull
    public static final Collection<EntityPlayerMP> getKtTrackingPlayers(@NotNull Entity entity) {
        Intrinsics.checkParameterIsNotNull(entity, "$receiver");
        return McExtensionsKt.getKtTrackingPlayers(McExtensionsKt.getTracker(entity));
    }

    public static final boolean isOpped(@NotNull EntityPlayer entityPlayer) {
        Intrinsics.checkParameterIsNotNull(entityPlayer, "$receiver");
        return entityPlayer.worldObj.isRemote ? true : MinecraftServer._I().__ag()._g(entityPlayer.username);
    }

    @NotNull
    public static final Vec3 getPos(@NotNull Entity entity) {
        Intrinsics.checkParameterIsNotNull(entity, "$receiver");
        Vec3 vec3 = Vec3._a(entity.posX, entity.posY, entity.posZ);
        Intrinsics.checkExpressionValueIsNotNull(vec3, "Vec3.createVectorHelper(posX, posY, posZ)");
        return vec3;
    }

    @NotNull
    public static final Vec3 getPrevPos(@NotNull Entity entity) {
        Intrinsics.checkParameterIsNotNull(entity, "$receiver");
        Vec3 vec3 = Vec3._a(entity.prevPosX, entity.prevPosY, entity.prevPosZ);
        Intrinsics.checkExpressionValueIsNotNull(vec3, "Vec3.createVectorHelper(\u2026PosX, prevPosY, prevPosZ)");
        return vec3;
    }

    public static final void setMoveTo(@NotNull EntityMoveHelper entityMoveHelper, @NotNull Vec3 vec3, double d) {
        Intrinsics.checkParameterIsNotNull(entityMoveHelper, "$receiver");
        Intrinsics.checkParameterIsNotNull(vec3, "pos");
        entityMoveHelper._a(VecExtensionsKt.getX(vec3), VecExtensionsKt.getY(vec3), VecExtensionsKt.getZ(vec3), d);
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

    public static final AxisAlignedBB AxisAlignedBB(@NotNull Vec3 vec3) {
        Intrinsics.checkParameterIsNotNull(vec3, "v");
        return AxisAlignedBB._a(VecExtensionsKt.getX(vec3), VecExtensionsKt.getY(vec3), VecExtensionsKt.getZ(vec3), VecExtensionsKt.getX(vec3), VecExtensionsKt.getY(vec3), VecExtensionsKt.getZ(vec3));
    }

    public static final AxisAlignedBB AxisAlignedBB() {
        return AxisAlignedBB._a(0.0, 0.0, 0.0, 0.0, 0.0, 0.0);
    }

    public static final void setMin(@NotNull AxisAlignedBB axisAlignedBB, @NotNull Vec3 vec3) {
        Intrinsics.checkParameterIsNotNull(axisAlignedBB, "$receiver");
        Intrinsics.checkParameterIsNotNull(vec3, "v");
        axisAlignedBB._b = VecExtensionsKt.getX(vec3);
        axisAlignedBB._c = VecExtensionsKt.getY(vec3);
        axisAlignedBB._d = VecExtensionsKt.getZ(vec3);
    }

    public static final void setMax(@NotNull AxisAlignedBB axisAlignedBB, @NotNull Vec3 vec3) {
        Intrinsics.checkParameterIsNotNull(axisAlignedBB, "$receiver");
        Intrinsics.checkParameterIsNotNull(vec3, "v");
        axisAlignedBB._e = VecExtensionsKt.getX(vec3);
        axisAlignedBB._f = VecExtensionsKt.getY(vec3);
        axisAlignedBB._g = VecExtensionsKt.getZ(vec3);
    }

    public static final void setMin(@NotNull AxisAlignedBB axisAlignedBB, @NotNull Vector3f vector3f) {
        Intrinsics.checkParameterIsNotNull(axisAlignedBB, "$receiver");
        Intrinsics.checkParameterIsNotNull(vector3f, "v");
        axisAlignedBB._b = vector3f.x;
        axisAlignedBB._c = vector3f.y;
        axisAlignedBB._d = vector3f.z;
    }

    public static final void setMax(@NotNull AxisAlignedBB axisAlignedBB, @NotNull Vector3f vector3f) {
        Intrinsics.checkParameterIsNotNull(axisAlignedBB, "$receiver");
        Intrinsics.checkParameterIsNotNull(vector3f, "v");
        axisAlignedBB._e = vector3f.x;
        axisAlignedBB._f = vector3f.y;
        axisAlignedBB._g = vector3f.z;
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
        Tessellator tessellator = Tessellator.instance;
        tessellator.startDrawingQuads();
        tessellator.addVertexWithUV(f * f5, (f2 + f4) * f5, -90.0, 0.0, 0.0);
        tessellator.addVertexWithUV((f + f3) * f5, (f2 + f4) * f5, -90.0, 1.0, 0.0);
        tessellator.addVertexWithUV((f + f3) * f5, f2 * f5, -90.0, 1.0, 1.0);
        tessellator.addVertexWithUV(f * f5, f2 * f5, -90.0, 0.0, 1.0);
        tessellator.draw();
    }

    public static /* synthetic */ void drawScaledQuad$default(float f, float f2, float f3, float f4, float f5, int n, Object object) {
        if ((n & 0x10) != 0) {
            f5 = 1.0f;
        }
        McExtensionsKt.drawScaledQuad(f, f2, f3, f4, f5);
    }

    public static final Vec3 vec3(@NotNull elhc elhc2) {
        Intrinsics.checkParameterIsNotNull(elhc2, "pathPoint");
        return Vec3._a((double)elhc2._a + 0.5, elhc2._b, (double)elhc2._c + 0.5);
    }

    @NotNull
    public static final elhc PathPoint(@NotNull Vec3 vec3) {
        Intrinsics.checkParameterIsNotNull(vec3, "v");
        Vec3 vec32 = VecExtensionsKt.floor_double(vec3);
        return new elhc((int)vec32._c, (int)vec32._d, (int)vec32._e);
    }

    @NotNull
    public static final DamageSource CustomExplosionDamageSource(@NotNull zwat zwat2) {
        DamageSource damageSource;
        Intrinsics.checkParameterIsNotNull(zwat2, "explosion");
        if (zwat2._f() != null) {
            DamageSource damageSource2 = new EntityDamageSource("explosion.player", zwat2._f()).setExplosion();
            damageSource = damageSource2;
            Intrinsics.checkExpressionValueIsNotNull(damageSource2, "EntityDamageSource(\"expl\u2026ionAuthor).setExplosion()");
        } else {
            DamageSource damageSource3 = DamageSource.setExplosionSource(null);
            damageSource = damageSource3;
            Intrinsics.checkExpressionValueIsNotNull(damageSource3, "DamageSource.setExplosionSource(null)");
        }
        return damageSource;
    }

    public static final void clampLocal(@NotNull AxisAlignedBB axisAlignedBB, double d, double d2, double d3) {
        Intrinsics.checkParameterIsNotNull(axisAlignedBB, "$receiver");
        double d4 = (axisAlignedBB._e - axisAlignedBB._b) / 2.0;
        double d5 = (axisAlignedBB._f - axisAlignedBB._c) / 2.0;
        double d6 = (axisAlignedBB._g - axisAlignedBB._d) / 2.0;
        AxisAlignedBB axisAlignedBB2 = axisAlignedBB._e(d4, d5, d6);
        AxisAlignedBB axisAlignedBB3 = axisAlignedBB2._b(owkq._c(d4, d / 2.0), owkq._c(d5, d2 / 2.0), owkq._c(d6, d3 / 2.0));
        axisAlignedBB._c(axisAlignedBB3);
    }

    @NotNull
    public static final Vec3 getNearestPathableBlock(@NotNull Entity entity) {
        int n;
        int n2;
        int n3;
        Intrinsics.checkParameterIsNotNull(entity, "$receiver");
        int n4 = (int)Math.round(entity.posX) - 1;
        int n5 = (int)Math.round(entity.posZ) - 1;
        int n6 = n4 + 1;
        int n7 = n5 + 1;
        int n8 = owkq._k((float)(entity.posY - 0.05));
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
                        if (entity.onGround) {
                            double d2;
                            double d3;
                            double d4;
                            if (McExtensionsKt.isBlockSolid(entity.worldObj, n12, n8 - 1, n3) && (d4 = (d3 = entity.posX - (double)n12) * d3 + (d2 = entity.posZ - (double)n3) * d2) < d) {
                                d = d4;
                                n9 = n12;
                                n10 = n8 - 1;
                                n11 = n3;
                                bl = true;
                            }
                        } else {
                            n = McExtensionsKt.firstSolidBlockUnderY(entity.worldObj, n12, n8, n3);
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
                        if ((n = McExtensionsKt.firstSolidBlockUnderY(entity.worldObj, n12, n8, n3)) > n10) {
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
        Vec3 vec3 = McExtensionsKt.vec3(entity.worldObj, n9, n10, n11);
        Intrinsics.checkExpressionValueIsNotNull(vec3, "worldObj.vec3(bestX, bestY, bestZ)");
        return vec3;
    }

    public static final void setPrevPos(@NotNull Entity entity, @NotNull Vec3 vec3) {
        Intrinsics.checkParameterIsNotNull(entity, "$receiver");
        Intrinsics.checkParameterIsNotNull(vec3, "pos");
        entity.prevPosX = VecExtensionsKt.getX(vec3);
        entity.prevPosY = VecExtensionsKt.getY(vec3);
        entity.prevPosZ = VecExtensionsKt.getZ(vec3);
    }

    public static final void setLastTickPos(@NotNull Entity entity, @NotNull Vec3 vec3) {
        Intrinsics.checkParameterIsNotNull(entity, "$receiver");
        Intrinsics.checkParameterIsNotNull(vec3, "pos");
        entity.lastTickPosX = VecExtensionsKt.getX(vec3);
        entity.lastTickPosY = VecExtensionsKt.getY(vec3);
        entity.lastTickPosZ = VecExtensionsKt.getZ(vec3);
    }

    public static final void setPos(@NotNull Entity entity, @NotNull Vec3 vec3) {
        Intrinsics.checkParameterIsNotNull(entity, "$receiver");
        Intrinsics.checkParameterIsNotNull(vec3, "pos");
        entity.posX = VecExtensionsKt.getX(vec3);
        entity.posY = VecExtensionsKt.getY(vec3);
        entity.posZ = VecExtensionsKt.getZ(vec3);
    }

    public static final double getDistanceToVector(@NotNull Entity entity, @NotNull Vec3 vec3) {
        Intrinsics.checkParameterIsNotNull(entity, "$receiver");
        Intrinsics.checkParameterIsNotNull(vec3, "v");
        double d = vec3._c - entity.posX;
        double d2 = vec3._d - entity.posY;
        double d3 = vec3._e - entity.posZ;
        return owkq._d(d3 * d3 + d2 * d2 + d * d);
    }

    public static final Vec3 vec3(@NotNull World world, double d, double d2, double d3) {
        Intrinsics.checkParameterIsNotNull(world, "$receiver");
        return world.getWorldVec3Pool()._a(d, d2, d3);
    }

    public static final Vec3 vec3(@NotNull World world, int n, int n2, int n3) {
        Intrinsics.checkParameterIsNotNull(world, "$receiver");
        return world.getWorldVec3Pool()._a(owkq._o(n), owkq._o(n2), owkq._o(n3));
    }

    public static final boolean isBlockSolid(@NotNull World world, int n, int n2, int n3) {
        Intrinsics.checkParameterIsNotNull(world, "$receiver");
        int n4 = world.getBlockId(n, n2, n3);
        return n4 != 0 && Block.blocksList[n4].blockMaterial._c();
    }

    public static final int firstSolidBlockUnderY(@NotNull World world, int n, int n2, int n3) {
        Intrinsics.checkParameterIsNotNull(world, "$receiver");
        int n4 = n2;
        while (--n4 > 0 && !McExtensionsKt.isBlockSolid(world, n, n4, n3)) {
        }
        return n4;
    }

    public static final void writeVec3(@NotNull ByteArrayDataOutput byteArrayDataOutput, @NotNull Vec3 vec3) {
        Intrinsics.checkParameterIsNotNull(byteArrayDataOutput, "$receiver");
        Intrinsics.checkParameterIsNotNull(vec3, "src");
        byteArrayDataOutput.writeDouble(vec3._c);
        byteArrayDataOutput.writeDouble(vec3._d);
        byteArrayDataOutput.writeDouble(vec3._e);
    }

    public static final void writeVec3f(@NotNull ByteArrayDataOutput byteArrayDataOutput, @NotNull Vec3 vec3) {
        Intrinsics.checkParameterIsNotNull(byteArrayDataOutput, "$receiver");
        Intrinsics.checkParameterIsNotNull(vec3, "src");
        byteArrayDataOutput.writeFloat((float)vec3._c);
        byteArrayDataOutput.writeFloat((float)vec3._d);
        byteArrayDataOutput.writeFloat((float)vec3._e);
    }

    public static final void readVec3(@NotNull ByteArrayDataInput byteArrayDataInput, @NotNull Vec3 vec3) {
        Intrinsics.checkParameterIsNotNull(byteArrayDataInput, "$receiver");
        Intrinsics.checkParameterIsNotNull(vec3, "dest");
        VecExtensionsKt.set(vec3, byteArrayDataInput.readDouble(), byteArrayDataInput.readDouble(), byteArrayDataInput.readDouble());
    }

    public static final void readVec3f(@NotNull ByteArrayDataInput byteArrayDataInput, @NotNull Vec3 vec3) {
        Intrinsics.checkParameterIsNotNull(byteArrayDataInput, "$receiver");
        Intrinsics.checkParameterIsNotNull(vec3, "dest");
        VecExtensionsKt.set(vec3, byteArrayDataInput.readFloat(), byteArrayDataInput.readFloat(), byteArrayDataInput.readFloat());
    }

    public static final void writeVec3(@NotNull NBTTagCompound nBTTagCompound, @NotNull String string, @NotNull Vec3 vec3) {
        Intrinsics.checkParameterIsNotNull(nBTTagCompound, "$receiver");
        Intrinsics.checkParameterIsNotNull(string, "key");
        Intrinsics.checkParameterIsNotNull(vec3, "src");
        nBTTagCompound._a("" + string + 'X', vec3._c);
        nBTTagCompound._a("" + string + 'Y', vec3._d);
        nBTTagCompound._a("" + string + 'Z', vec3._e);
    }

    public static final void writeVec3f(@NotNull NBTTagCompound nBTTagCompound, @NotNull String string, @NotNull Vec3 vec3) {
        Intrinsics.checkParameterIsNotNull(nBTTagCompound, "$receiver");
        Intrinsics.checkParameterIsNotNull(string, "key");
        Intrinsics.checkParameterIsNotNull(vec3, "src");
        nBTTagCompound._a("" + string + 'X', (float)vec3._c);
        nBTTagCompound._a("" + string + 'Y', (float)vec3._d);
        nBTTagCompound._a("" + string + 'Z', (float)vec3._e);
    }

    public static final void readVec3(@NotNull NBTTagCompound nBTTagCompound, @NotNull String string, @NotNull Vec3 vec3) {
        Intrinsics.checkParameterIsNotNull(nBTTagCompound, "$receiver");
        Intrinsics.checkParameterIsNotNull(string, "key");
        Intrinsics.checkParameterIsNotNull(vec3, "dest");
        VecExtensionsKt.set(vec3, nBTTagCompound._i("" + string + 'X'), nBTTagCompound._i("" + string + 'Y'), nBTTagCompound._i("" + string + 'Z'));
    }

    public static final void readVec3f(@NotNull NBTTagCompound nBTTagCompound, @NotNull String string, @NotNull Vec3 vec3) {
        Intrinsics.checkParameterIsNotNull(nBTTagCompound, "$receiver");
        Intrinsics.checkParameterIsNotNull(string, "key");
        Intrinsics.checkParameterIsNotNull(vec3, "dest");
        VecExtensionsKt.set(vec3, nBTTagCompound._h("" + string + 'X'), nBTTagCompound._h("" + string + 'Y'), nBTTagCompound._h("" + string + 'Z'));
    }

    public static final Vec3 getVecFromPool(@NotNull Vec3Pool vec3Pool, int n, int n2, int n3) {
        Intrinsics.checkParameterIsNotNull(vec3Pool, "$receiver");
        return vec3Pool._a(owkq._o(n), owkq._o(n2), owkq._o(n3));
    }

    public static final int getBlockId(@NotNull World world, double d, double d2, double d3) {
        Intrinsics.checkParameterIsNotNull(world, "$receiver");
        return world.getBlockId(sajh._c(d), sajh._c(d2), sajh._c(d3));
    }

    public static final int getBlockId(@NotNull World world, @NotNull Vec3 vec3) {
        Intrinsics.checkParameterIsNotNull(world, "$receiver");
        Intrinsics.checkParameterIsNotNull(vec3, "v");
        return McExtensionsKt.getBlockId(world, VecExtensionsKt.getX(vec3), VecExtensionsKt.getY(vec3), VecExtensionsKt.getZ(vec3));
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
        String string = "/assets/" + resourceLocation.getResourceDomain() + "/" + resourceLocation.getResourcePath();
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

