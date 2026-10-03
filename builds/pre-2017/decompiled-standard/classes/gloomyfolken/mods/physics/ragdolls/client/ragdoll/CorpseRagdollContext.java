/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.physics.ragdolls.client.ragdoll;

import gloomyfolken.mods.ktcore.VecExtensionsKt;
import gloomyfolken.mods.physics.core.PhysicsImpulse;
import gloomyfolken.mods.physics.core.client.PhysicsEntityContext;
import gloomyfolken.mods.physics.core.client.SkeletonBody;
import gloomyfolken.mods.physics.core.client.SkeletonSegment;
import gloomyfolken.mods.physics.ragdolls.client.ragdoll.CorpseConstructionInfo;
import gloomyfolken.mods.physics.ragdolls.client.ragdoll.CorpseRagdollContext$WhenMappings;
import gloomyfolken.mods.physics.ragdolls.client.ragdoll.RagdollCorpse;
import gloomyfolken.mods.physics.ragdolls.client.ragdoll.SkeletonPreset;
import gloomyfolken.mods.physics.ragdolls.client.ragdoll.world.RagdollWorldContext;
import gloomyfolken.mods.physics.ragdolls.entity.CorpseRagdollState;
import gloomyfolken.mods.physics.ragdolls.entity.EntityRagdollCorpse;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import net.minecraft.client.entity.EntityClientPlayerMP;
import net.minecraft.client.xpzm;
import net.minecraft.util.eidj;
import net.minecraft.util.ofbx;
import net.minecraft.util.sajh;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.lwjgl.util.vector.Quaternion;
import org.lwjgl.util.vector.Vector3f;

@Metadata(mv={1, 1, 7}, bv={1, 0, 2}, k=1, d1={"\u0000\u0086\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\b\u0016\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0010\u00108\u001a\u0002092\u0006\u0010:\u001a\u00020-H\u0016J\b\u0010;\u001a\u000209H\u0002J\u0010\u0010<\u001a\u00020=2\u0006\u0010>\u001a\u00020\rH\u0002J\u0006\u0010?\u001a\u000206J\b\u0010@\u001a\u00020\u0003H\u0016J\b\u0010A\u001a\u00020BH\u0016J\n\u0010C\u001a\u0004\u0018\u00010DH\u0016J\u0010\u0010E\u001a\u0002092\u0006\u0010F\u001a\u00020-H\u0002J\b\u0010G\u001a\u00020\rH\u0016J\b\u0010H\u001a\u00020&H\u0016J\u0006\u0010I\u001a\u000209J\b\u0010J\u001a\u000209H\u0016J\b\u0010K\u001a\u00020&H\u0016J\b\u0010L\u001a\u00020&H\u0016J\u0010\u0010M\u001a\u0002092\u0006\u0010N\u001a\u00020\u0006H\u0016J\b\u0010O\u001a\u000209H\u0016J\b\u0010P\u001a\u000209H\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0082D\u00a2\u0006\u0002\n\u0000R\u0011\u0010\b\u001a\u00020\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\f\u001a\u00020\r\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0010\u001a\u00020\r\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000fR\u0011\u0010\u0012\u001a\u00020\r\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000fR\u000e\u0010\u0014\u001a\u00020\rX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001c\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u0011\u0010!\u001a\u00020\"\u00a2\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u0011\u0010%\u001a\u00020&\u00a2\u0006\b\n\u0000\u001a\u0004\b'\u0010(R\u000e\u0010)\u001a\u00020*X\u0082\u000e\u00a2\u0006\u0002\n\u0000R!\u0010+\u001a\u0012\u0012\u0004\u0012\u00020-0,j\b\u0012\u0004\u0012\u00020-`.\u00a2\u0006\b\n\u0000\u001a\u0004\b/\u00100R\u000e\u00101\u001a\u00020\rX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b2\u00103R\u000e\u00104\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u00105\u001a\u000206X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u00107\u001a\u000206X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006Q"}, d2={"Lgloomyfolken/mods/physics/ragdolls/client/ragdoll/CorpseRagdollContext;", "Lgloomyfolken/mods/physics/core/client/PhysicsEntityContext;", "state", "Lgloomyfolken/mods/physics/ragdolls/entity/CorpseRagdollState;", "(Lgloomyfolken/mods/physics/ragdolls/entity/CorpseRagdollState;)V", "IMPULSE_SCALE_POW", "", "MAX_WORLD_RADIUS", "blockOrigin", "Ljavax/vecmath/Vector3f;", "getBlockOrigin", "()Ljavax/vecmath/Vector3f;", "blockX", "", "getBlockX", "()I", "blockY", "getBlockY", "blockZ", "getBlockZ", "cachedPriorityInfo", "corpse", "Lgloomyfolken/mods/physics/ragdolls/client/ragdoll/RagdollCorpse;", "getCorpse", "()Lgloomyfolken/mods/physics/ragdolls/client/ragdoll/RagdollCorpse;", "setCorpse", "(Lgloomyfolken/mods/physics/ragdolls/client/ragdoll/RagdollCorpse;)V", "corpseConstructionInfo", "Lgloomyfolken/mods/physics/ragdolls/client/ragdoll/CorpseConstructionInfo;", "getCorpseConstructionInfo", "()Lgloomyfolken/mods/physics/ragdolls/client/ragdoll/CorpseConstructionInfo;", "setCorpseConstructionInfo", "(Lgloomyfolken/mods/physics/ragdolls/client/ragdoll/CorpseConstructionInfo;)V", "corpseEntity", "Lgloomyfolken/mods/physics/ragdolls/entity/EntityRagdollCorpse;", "getCorpseEntity", "()Lgloomyfolken/mods/physics/ragdolls/entity/EntityRagdollCorpse;", "initialDeath", "", "getInitialDeath", "()Z", "lastPriorityCheck", "", "pendingImpulses", "Ljava/util/ArrayList;", "Lgloomyfolken/mods/physics/core/PhysicsImpulse;", "Lkotlin/collections/ArrayList;", "getPendingImpulses", "()Ljava/util/ArrayList;", "startWorldSize", "getState", "()Lgloomyfolken/mods/physics/ragdolls/entity/CorpseRagdollState;", "tmp1", "v", "Lorg/lwjgl/util/vector/Vector3f;", "v1", "applyImpulse", "", "physicsImpulse", "calculateComplexPriorityInfo", "getBone", "Lgloomyfolken/mods/effects/common/mcsa/data/McsaSkeleton$McsaBone;", "idx", "getCorpseWorldPosition", "getPhysicsState", "getSkeletonPreset", "Lgloomyfolken/mods/physics/ragdolls/client/ragdoll/SkeletonPreset;", "getWorldContext", "Lgloomyfolken/mods/physics/ragdolls/client/ragdoll/world/RagdollWorldContext;", "physicsApplyImpulse", "impulse", "priority", "readyForSetup", "rebuildGroundIfNeeded", "release", "setup", "skipLagCheck", "updateContext", "dt", "updateEntityState", "updateOwnerPosBounds", "minecraft"})
public class CorpseRagdollContext
extends PhysicsEntityContext {
    private final float MAX_WORLD_RADIUS = 8.0f;
    private final float IMPULSE_SCALE_POW = 60.0f;
    @NotNull
    private final EntityRagdollCorpse corpseEntity;
    @NotNull
    private final ArrayList<PhysicsImpulse> pendingImpulses;
    @Nullable
    private CorpseConstructionInfo corpseConstructionInfo;
    @Nullable
    private RagdollCorpse corpse;
    private final int blockX;
    private final int blockY;
    private final int blockZ;
    @NotNull
    private final javax.vecmath.Vector3f blockOrigin;
    private final boolean initialDeath;
    private final int startWorldSize;
    private final javax.vecmath.Vector3f tmp1;
    private final Vector3f v;
    private final Vector3f v1;
    private int cachedPriorityInfo;
    private long lastPriorityCheck;
    @NotNull
    private final CorpseRagdollState state;

    @NotNull
    public final EntityRagdollCorpse getCorpseEntity() {
        return this.corpseEntity;
    }

    @NotNull
    public final ArrayList<PhysicsImpulse> getPendingImpulses() {
        return this.pendingImpulses;
    }

    @Nullable
    public final CorpseConstructionInfo getCorpseConstructionInfo() {
        return this.corpseConstructionInfo;
    }

    public final void setCorpseConstructionInfo(@Nullable CorpseConstructionInfo corpseConstructionInfo) {
        this.corpseConstructionInfo = corpseConstructionInfo;
    }

    @Nullable
    public final RagdollCorpse getCorpse() {
        return this.corpse;
    }

    public final void setCorpse(@Nullable RagdollCorpse ragdollCorpse) {
        this.corpse = ragdollCorpse;
    }

    public final int getBlockX() {
        return this.blockX;
    }

    public final int getBlockY() {
        return this.blockY;
    }

    public final int getBlockZ() {
        return this.blockZ;
    }

    @NotNull
    public final javax.vecmath.Vector3f getBlockOrigin() {
        return this.blockOrigin;
    }

    public final boolean getInitialDeath() {
        return this.initialDeath;
    }

    @Override
    @NotNull
    public CorpseRagdollState getPhysicsState() {
        return this.state;
    }

    @Override
    @Nullable
    public RagdollWorldContext getWorldContext() {
        return (RagdollWorldContext)this.get_physCtx();
    }

    private final void calculateComplexPriorityInfo() {
        EntityClientPlayerMP entityClientPlayerMP = xpzm._E()._t;
        if (entityClientPlayerMP == null) {
            return;
        }
        EntityClientPlayerMP entityClientPlayerMP2 = entityClientPlayerMP;
        double d = Math.hypot((double)this.blockX - entityClientPlayerMP2.field_70165_t, (double)this.blockZ - entityClientPlayerMP2.field_70161_v);
        this.cachedPriorityInfo = owkq._k(d * d * (double)1000);
    }

    @Override
    public boolean skipLagCheck() {
        return this.state.getOwnerEntity().getInitialDeath();
    }

    @Override
    public int priority() {
        long l = System.currentTimeMillis();
        if (l - this.lastPriorityCheck > (long)250) {
            this.lastPriorityCheck = l;
            this.calculateComplexPriorityInfo();
        }
        int n = 0;
        if (this.getWorldContext() != null) {
            RagdollWorldContext ragdollWorldContext = this.getWorldContext();
            if (ragdollWorldContext == null) {
                Intrinsics.throwNpe();
            }
            n = (int)(l - ragdollWorldContext.getWorldRef().getLastPhysicsUpdated());
        }
        n = !this.state.getOwnerEntity().getInitialDeath() ? (n += 10000000) : (n *= -1);
        return n + this.cachedPriorityInfo;
    }

    @Override
    public boolean setup() {
        Object object;
        List<Object> list2 = CollectionsKt.emptyList();
        RagdollWorldContext ragdollWorldContext = this.getWorldContext();
        if (ragdollWorldContext == null) {
            Intrinsics.throwNpe();
        }
        Object object2 = object = ragdollWorldContext;
        ((RagdollWorldContext)object2).clearGroundMesh();
        ((RagdollWorldContext)object2).getGroundOffset().set(VecExtensionsKt.minus(this.blockOrigin, VecExtensionsKt.toVm(this.state.getDeathPos())));
        ozlu ozlu2 = this.corpseEntity.field_70170_p;
        Intrinsics.checkExpressionValueIsNotNull(ozlu2, "corpseEntity.worldObj");
        list2 = ((RagdollWorldContext)object2).generateChunkMeshes(ozlu2, this.blockOrigin, new javax.vecmath.Vector3f(), new javax.vecmath.Vector3f(owkq._n(this.startWorldSize), owkq._n(this.startWorldSize), owkq._n(this.startWorldSize)));
        object = new ivtm(this.state.getOwnerEntity().getCollisionModel().getSkeleton()._e);
        CorpseConstructionInfo corpseConstructionInfo = this.corpseConstructionInfo;
        if (corpseConstructionInfo == null) {
            Intrinsics.throwNpe();
        }
        if (corpseConstructionInfo.get_state() == null) {
            CorpseConstructionInfo corpseConstructionInfo2 = this.corpseConstructionInfo;
            if (corpseConstructionInfo2 == null) {
                Intrinsics.throwNpe();
            }
            corpseConstructionInfo2.set_state((ivtm)object);
        } else {
            CorpseConstructionInfo corpseConstructionInfo3 = this.corpseConstructionInfo;
            if (corpseConstructionInfo3 == null) {
                Intrinsics.throwNpe();
            }
            CorpseConstructionInfo corpseConstructionInfo4 = this.corpseConstructionInfo;
            if (corpseConstructionInfo4 == null) {
                Intrinsics.throwNpe();
            }
            corpseConstructionInfo3.set_state(new ivtm(corpseConstructionInfo4.get_state()));
        }
        SkeletonPreset skeletonPreset = this.getSkeletonPreset();
        CorpseConstructionInfo corpseConstructionInfo5 = this.corpseConstructionInfo;
        if (corpseConstructionInfo5 == null) {
            Intrinsics.throwNpe();
        }
        this.corpse = object2 = skeletonPreset.createCorpse(this, corpseConstructionInfo5, new ivtm((ivtm)object), list2);
        Random random = this.corpseEntity.field_70146_Z;
        ((RagdollCorpse)object2).updateWorldTransform(true);
        ((RagdollCorpse)object2).updateWorldTransform(true);
        return super.setup();
    }

    public final void rebuildGroundIfNeeded() {
        RagdollCorpse ragdollCorpse = this.corpse;
        if (ragdollCorpse == null) {
            return;
        }
        RagdollCorpse ragdollCorpse2 = ragdollCorpse;
        javax.vecmath.Vector3f vector3f = ragdollCorpse2.getAabbMax();
        javax.vecmath.Vector3f vector3f2 = ragdollCorpse2.getAabbMin();
        RagdollWorldContext ragdollWorldContext = this.getWorldContext();
        if (ragdollWorldContext == null) {
            Intrinsics.throwNpe();
        }
        javax.vecmath.Vector3f vector3f3 = ragdollWorldContext.getWorldAabbMax();
        RagdollWorldContext ragdollWorldContext2 = this.getWorldContext();
        if (ragdollWorldContext2 == null) {
            Intrinsics.throwNpe();
        }
        javax.vecmath.Vector3f vector3f4 = ragdollWorldContext2.getWorldAabbMin();
        javax.vecmath.Vector3f vector3f5 = VecExtensionsKt.clampMax(VecExtensionsKt.offseted(VecExtensionsKt.div(VecExtensionsKt.minus(vector3f, vector3f2), 2.0f), 1.5f), this.MAX_WORLD_RADIUS, this.MAX_WORLD_RADIUS, this.MAX_WORLD_RADIUS);
        javax.vecmath.Vector3f vector3f6 = VecExtensionsKt.plus(vector3f2, VecExtensionsKt.div(VecExtensionsKt.minus(vector3f, vector3f2), 2.0f));
        if (vector3f2.x < vector3f4.x || vector3f2.y < vector3f4.y || vector3f2.z < vector3f4.z || vector3f.x > vector3f3.x || vector3f.y > vector3f3.y || vector3f.z > vector3f3.z) {
            RagdollWorldContext ragdollWorldContext3 = this.getWorldContext();
            if (ragdollWorldContext3 == null) {
                Intrinsics.throwNpe();
            }
            ragdollWorldContext3.clearGroundMesh();
            RagdollWorldContext ragdollWorldContext4 = this.getWorldContext();
            if (ragdollWorldContext4 == null) {
                Intrinsics.throwNpe();
            }
            ozlu ozlu2 = this.corpseEntity.field_70170_p;
            Intrinsics.checkExpressionValueIsNotNull(ozlu2, "corpseEntity.worldObj");
            ragdollWorldContext4.generateChunkMeshes(ozlu2, this.blockOrigin, VecExtensionsKt.floor_double(vector3f6), VecExtensionsKt.floor_double(vector3f5));
        }
    }

    @Override
    public void release() {
        super.release();
        this.corpse = null;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void applyImpulse(@NotNull PhysicsImpulse physicsImpulse) {
        Intrinsics.checkParameterIsNotNull(physicsImpulse, "physicsImpulse");
        ArrayList<PhysicsImpulse> arrayList = this.pendingImpulses;
        synchronized (arrayList) {
            Collection collection = this.pendingImpulses;
            Object object = physicsImpulse;
            collection.add(object);
            object = Unit.INSTANCE;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void updateContext(float f) {
        super.updateContext(f);
        if (this.corpse != null) {
            RagdollCorpse ragdollCorpse = this.corpse;
            if (ragdollCorpse == null) {
                Intrinsics.throwNpe();
            }
            ragdollCorpse.update(f);
            ArrayList<PhysicsImpulse> arrayList = this.pendingImpulses;
            synchronized (arrayList) {
                Iterable iterable = this.pendingImpulses;
                for (Object t : iterable) {
                    PhysicsImpulse physicsImpulse = (PhysicsImpulse)t;
                    this.physicsApplyImpulse(physicsImpulse);
                }
                this.pendingImpulses.clear();
                Unit unit = Unit.INSTANCE;
            }
            this.rebuildGroundIfNeeded();
        }
    }

    private final jywl.kjui getBone(int n) {
        jywl.kjui kjui2 = this.state.getOwnerEntity().getCollisionModel().getSkeleton()._a(n);
        Intrinsics.checkExpressionValueIsNotNull(kjui2, "state.getOwnerEntity().g\u2026l().skeleton.getBone(idx)");
        return kjui2;
    }

    private final void physicsApplyImpulse(PhysicsImpulse physicsImpulse) {
        block11: {
            List list2;
            List list3;
            Object object;
            Object object2;
            Object object3;
            Object object4;
            PhysicsImpulse physicsImpulse2 = physicsImpulse;
            this.tmp1.set(physicsImpulse2.getDirX(), physicsImpulse2.getDirY(), physicsImpulse2.getDirZ());
            this.tmp1.scale(this.IMPULSE_SCALE_POW);
            this.v.set(physicsImpulse2.getX(), physicsImpulse2.getY(), physicsImpulse2.getZ());
            VecExtensionsKt.subl(this.v, VecExtensionsKt.toGl(this.state.getDeathPos()));
            RagdollCorpse ragdollCorpse = this.corpse;
            if (ragdollCorpse == null) {
                Intrinsics.throwNpe();
            }
            List list4 = (List)ragdollCorpse.getSegments().values();
            Object object5 = list4;
            Iterator iterator2 = new ArrayList();
            Object object6 = object5;
            Object object7 = object6.iterator();
            while (object7.hasNext()) {
                object4 = object7.next();
                object3 = object4;
                object2 = (SkeletonSegment)object3;
                if (((SkeletonSegment)object2).getBody() == null) continue;
                SkeletonBody skeletonBody = object;
                iterator2.add(skeletonBody);
            }
            List list5 = (List)((Object)iterator2);
            switch (CorpseRagdollContext$WhenMappings.$EnumSwitchMapping$0[physicsImpulse2.getApplyType().ordinal()]) {
                case 1: {
                    Object object8;
                    object5 = list5;
                    iterator2 = object5.iterator();
                    if (!iterator2.hasNext()) {
                        object8 = null;
                    } else {
                        object6 = iterator2.next();
                        object7 = (SkeletonBody)object6;
                        float f = Vector3f.sub(this.v, ((SkeletonBody)object7).getPos(), this.v1).lengthSquared();
                        while (iterator2.hasNext()) {
                            object4 = iterator2.next();
                            SkeletonBody skeletonBody = (SkeletonBody)object4;
                            float f2 = Vector3f.sub(this.v, skeletonBody.getPos(), this.v1).lengthSquared();
                            if (Float.compare(f, f2) <= 0) continue;
                            object6 = object4;
                            f = f2;
                        }
                        object8 = object6;
                    }
                    list3 = CollectionsKt.listOf(object8);
                    break;
                }
                default: {
                    object5 = physicsImpulse2.getApplyType().getRegex();
                    if (object5 != null) {
                        iterator2 = list5;
                        object6 = iterator2;
                        object7 = new ArrayList();
                        object4 = object6.iterator();
                        while (object4.hasNext()) {
                            object3 = object4.next();
                            object2 = (SkeletonBody)object3;
                            object = object5;
                            CharSequence charSequence = this.getBone((int)((SkeletonBody)object2).getBoneIdx())._d;
                            if (!((Regex)object).containsMatchIn(charSequence)) continue;
                            object7.add(object3);
                        }
                        list3 = (List)object7;
                        break;
                    }
                    list3 = null;
                }
            }
            if ((list2 = (list4 = list3)) == null || (list2 = CollectionsKt.filterNotNull(list2)) == null) break block11;
            object5 = list2;
            iterator2 = object5.iterator();
            while (iterator2.hasNext()) {
                object6 = iterator2.next();
                object7 = (SkeletonBody)object6;
                ((SkeletonBody)object7).getBltBody().activate();
                ((SkeletonBody)object7).getBltBody().applyCentralImpulse(this.tmp1);
            }
        }
    }

    @NotNull
    public final Vector3f getCorpseWorldPosition() {
        VecExtensionsKt.resetl(this.v);
        RagdollCorpse ragdollCorpse = this.corpse;
        if (ragdollCorpse == null) {
            return this.v;
        }
        RagdollCorpse ragdollCorpse2 = ragdollCorpse;
        SkeletonBody skeletonBody = ragdollCorpse2.getRootBody();
        if (skeletonBody == null) {
            Intrinsics.throwNpe();
        }
        Quaternion quaternion = skeletonBody.getWorldRotation();
        SkeletonSegment skeletonSegment = ragdollCorpse2.getRoot();
        if (skeletonSegment == null) {
            Intrinsics.throwNpe();
        }
        this.v1.set(skeletonSegment.getHeadTranslation());
        jywc._a(quaternion, this.v1, this.v1);
        ofbx ofbx2 = this.state.getDeathPos();
        Intrinsics.checkExpressionValueIsNotNull(ofbx2, "state.deathPos");
        VecExtensionsKt.set(this.v, ofbx2);
        SkeletonBody skeletonBody2 = ragdollCorpse2.getRootBody();
        if (skeletonBody2 == null) {
            Intrinsics.throwNpe();
        }
        Vector3f.add(skeletonBody2.getPos(), this.v, this.v);
        Vector3f.add(this.v1, this.v, this.v);
        return this.v;
    }

    @Override
    public void updateEntityState() {
        RagdollCorpse ragdollCorpse = this.corpse;
        if (ragdollCorpse != null) {
            RagdollCorpse.updateWorldTransform$default(ragdollCorpse, false, 1, null);
        }
        super.updateEntityState();
    }

    @Override
    public void updateOwnerPosBounds() {
        CorpseRagdollState corpseRagdollState;
        RagdollCorpse ragdollCorpse = this.corpse;
        if (ragdollCorpse == null) {
            return;
        }
        RagdollCorpse ragdollCorpse2 = ragdollCorpse;
        CorpseRagdollState corpseRagdollState2 = corpseRagdollState = this.state;
        Vector3f vector3f = this.getCorpseWorldPosition();
        VecExtensionsKt.set(corpseRagdollState2.getOwnerEntity().getPhysCorpseWorldPos(), vector3f);
        eidj eidj2 = ragdollCorpse2.getAabbForCamera();
        corpseRagdollState2.getEntity().field_70121_D._b(corpseRagdollState2.getDeathPos()._c + eidj2._b, corpseRagdollState2.getDeathPos()._d + eidj2._c, corpseRagdollState2.getDeathPos()._e + eidj2._d, corpseRagdollState2.getDeathPos()._c + eidj2._e, corpseRagdollState2.getDeathPos()._d + eidj2._f, corpseRagdollState2.getDeathPos()._e + eidj2._g);
        corpseRagdollState2.getEntity().field_70130_N = (float)owkq._d(eidj2._g - eidj2._d, eidj2._e - eidj2._b);
        corpseRagdollState2.getEntity().field_70131_O = (float)(eidj2._f - eidj2._c);
    }

    @Override
    public boolean readyForSetup() {
        return this.getWorldContext() != null && this.corpseConstructionInfo != null;
    }

    @NotNull
    public SkeletonPreset getSkeletonPreset() {
        return this.state.getOwnerEntity().getSkeletonPreset();
    }

    @NotNull
    public final CorpseRagdollState getState() {
        return this.state;
    }

    public CorpseRagdollContext(@NotNull CorpseRagdollState corpseRagdollState) {
        Intrinsics.checkParameterIsNotNull(corpseRagdollState, "state");
        super(corpseRagdollState);
        this.state = corpseRagdollState;
        this.MAX_WORLD_RADIUS = 8.0f;
        this.IMPULSE_SCALE_POW = 60.0f;
        this.corpseEntity = this.state.getOwnerEntity();
        CorpseRagdollContext corpseRagdollContext = this;
        ArrayList arrayList = new ArrayList();
        corpseRagdollContext.pendingImpulses = arrayList;
        this.blockX = sajh._c(this.state.getDeathPos()._c);
        this.blockY = sajh._c(this.state.getDeathPos()._d);
        this.blockZ = sajh._c(this.state.getDeathPos()._e);
        this.blockOrigin = new javax.vecmath.Vector3f(owkq._n(this.blockX), owkq._n(this.blockY), owkq._n(this.blockZ));
        this.initialDeath = this.state.getOwnerEntity().getInitialDeath();
        this.startWorldSize = owkq._k(Math.ceil(2.15 + 2.5 * (double)(this.state.getDeathScale() / (float)2)));
        this.tmp1 = new javax.vecmath.Vector3f();
        this.v = new Vector3f();
        this.v1 = new Vector3f();
        this.lastPriorityCheck = -10000L;
    }
}

