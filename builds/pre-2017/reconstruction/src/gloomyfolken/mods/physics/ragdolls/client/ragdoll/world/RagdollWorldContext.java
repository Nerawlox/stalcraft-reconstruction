/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.physics.ragdolls.client.ragdoll.world;

import com.bulletphysics.collision.shapes.BvhTriangleMeshShape;
import com.bulletphysics.dynamics.RigidBody;
import com.bulletphysics.linearmath.Transform;
import gloomyfolken.mods.ktcore.VecExtensionsKt;
import gloomyfolken.mods.physics.core.client.PhysicsEntityContext;
import gloomyfolken.mods.physics.core.client.SkeletonBody;
import gloomyfolken.mods.physics.core.client.SkeletonSegment;
import gloomyfolken.mods.physics.core.client.world.DynamicsWorldRef;
import gloomyfolken.mods.physics.core.client.world.PhysicsWorldContext;
import gloomyfolken.mods.physics.core.client.world.PhysicsWorldRenderer;
import gloomyfolken.mods.physics.core.client.world.TerrainMeshBuilder;
import gloomyfolken.mods.physics.ragdolls.client.ragdoll.CorpseRagdollContext;
import gloomyfolken.mods.physics.ragdolls.client.ragdoll.RagdollCorpse;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.vecmath.Vector3f;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.World;
import org.jetbrains.annotations.NotNull;
import org.lwjgl.opengl.GL11;

@Metadata(mv={1, 1, 7}, bv={1, 0, 2}, k=1, d1={"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u0000 '2\u00020\u0001:\u0001'B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0006\u0010\u0013\u001a\u00020\u0014J\b\u0010\u0015\u001a\u00020\u0014H\u0002J8\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00172\u0006\u0010\u0018\u001a\u00020\u00192\n\u0010\u001a\u001a\u00060\bj\u0002`\t2\n\u0010\u001b\u001a\u00060\bj\u0002`\t2\n\u0010\u001c\u001a\u00060\bj\u0002`\tJ\u0010\u0010\u001d\u001a\u00020\u00062\u0006\u0010\u001e\u001a\u00020\u0006H\u0016J\b\u0010\u001f\u001a\u00020 H\u0016J\u0010\u0010!\u001a\u00020\u00142\u0006\u0010\"\u001a\u00020\u0006H\u0014J\b\u0010#\u001a\u00020$H\u0016J\u0010\u0010%\u001a\u00020\u00142\u0006\u0010&\u001a\u00020\u0006H\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0015\u0010\u0007\u001a\u00060\bj\u0002`\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0017\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0015\u0010\u0011\u001a\u00060\bj\u0002`\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000b\u00a8\u0006("}, d2={"Lgloomyfolken/mods/physics/ragdolls/client/ragdoll/world/RagdollWorldContext;", "Lgloomyfolken/mods/physics/core/client/world/PhysicsWorldContext;", "world", "Lgloomyfolken/mods/physics/core/client/world/DynamicsWorldRef;", "(Lgloomyfolken/mods/physics/core/client/world/DynamicsWorldRef;)V", "additionalTimesteps", "", "gravity", "Ljavax/vecmath/Vector3f;", "Lgloomyfolken/mods/physics/core/Vec3vm;", "getGravity", "()Ljavax/vecmath/Vector3f;", "groundBodies", "Ljava/util/ArrayList;", "Lcom/bulletphysics/dynamics/RigidBody;", "getGroundBodies", "()Ljava/util/ArrayList;", "groundOffset", "getGroundOffset", "clearGroundMesh", "", "computeSimulationSpeed", "generateChunkMeshes", "", "mcWorld", "Lnet/minecraft/world/World;", "deathPos", "offset", "range", "getDtTime", "dtRealTime", "priority", "", "render", "partialTickTime", "skipLagCheck", "", "updateContext", "dt", "Companion", "minecraft"})
public final class RagdollWorldContext
extends PhysicsWorldContext {
    @NotNull
    private final ArrayList<RigidBody> groundBodies;
    @NotNull
    private final Vector3f gravity;
    @NotNull
    private final Vector3f groundOffset;
    private float additionalTimesteps;
    public static final Companion Companion = new Companion(null);

    @NotNull
    public final ArrayList<RigidBody> getGroundBodies() {
        return this.groundBodies;
    }

    @NotNull
    public final Vector3f getGravity() {
        return this.gravity;
    }

    @NotNull
    public final Vector3f getGroundOffset() {
        return this.groundOffset;
    }

    public final void clearGroundMesh() {
        Object object = "cleared ground mesh";
        System.out.println(object);
        object = this.groundBodies;
        Iterator iterator2 = object.iterator();
        while (iterator2.hasNext()) {
            Object t = iterator2.next();
            RigidBody rigidBody = (RigidBody)t;
            this.getWorldRef().getDynamicsWorld().removeRigidBody(rigidBody);
        }
        this.groundBodies.clear();
    }

    @NotNull
    public final List<RigidBody> generateChunkMeshes(@NotNull World world, @NotNull Vector3f vector3f, @NotNull Vector3f vector3f2, @NotNull Vector3f vector3f3) {
        Intrinsics.checkParameterIsNotNull(world, "mcWorld");
        Intrinsics.checkParameterIsNotNull(vector3f, "deathPos");
        Intrinsics.checkParameterIsNotNull(vector3f2, "offset");
        Intrinsics.checkParameterIsNotNull(vector3f3, "range");
        this.getWorldAabbMin().set(VecExtensionsKt.plus(this.groundOffset, VecExtensionsKt.minus(vector3f2, vector3f3)));
        this.getWorldAabbMax().set(VecExtensionsKt.plus(this.groundOffset, VecExtensionsKt.plus(VecExtensionsKt.plus(vector3f2, vector3f3), 1.0f)));
        Transform transform = new Transform();
        BvhTriangleMeshShape bvhTriangleMeshShape = TerrainMeshBuilder.INSTANCE.buildBlocksRange(world, (int)(vector3f.x + vector3f2.x), (int)(vector3f.y + vector3f2.y), (int)(vector3f.z + vector3f2.z), (int)vector3f3.x, (int)vector3f3.y, (int)vector3f3.z);
        if (bvhTriangleMeshShape == null) {
            return CollectionsKt.emptyList();
        }
        BvhTriangleMeshShape bvhTriangleMeshShape2 = bvhTriangleMeshShape;
        bvhTriangleMeshShape2.setMargin(0.125f);
        transform.setIdentity();
        transform.origin.set(VecExtensionsKt.plus(vector3f2, this.groundOffset));
        Object object = this.groundBodies;
        RigidBody rigidBody = this.getBulletHelper().createRigidBody(this.getWorldRef().getDynamicsWorld(), 0.0f, transform, bvhTriangleMeshShape2);
        object.add(rigidBody);
        object = "created ground mesh";
        System.out.println(object);
        return this.groundBodies;
    }

    @Override
    public float getDtTime(float f) {
        if (this.skipLagCheck()) {
            return super.getDtTime(f) + this.additionalTimesteps * 0.016666668f;
        }
        return 0.016666668f * (float)this.getMaxSubsteps();
    }

    @Override
    public int priority() {
        PhysicsEntityContext physicsEntityContext = (PhysicsEntityContext)CollectionsKt.firstOrNull((Iterable)this.getUsers().values());
        return physicsEntityContext != null ? physicsEntityContext.priority() : 0;
    }

    @Override
    public void updateContext(float f) {
        super.updateContext(f);
        this.computeSimulationSpeed();
    }

    private final void computeSimulationSpeed() {
        Object object;
        Collection collection;
        Object object2;
        this.additionalTimesteps = 0.0f;
        Object t = CollectionsKt.firstOrNull((Iterable)this.getUsers().values());
        if (!(t instanceof CorpseRagdollContext)) {
            t = null;
        }
        CorpseRagdollContext corpseRagdollContext = (CorpseRagdollContext)t;
        if (corpseRagdollContext == null) {
            return;
        }
        CorpseRagdollContext corpseRagdollContext2 = corpseRagdollContext;
        RagdollCorpse ragdollCorpse = corpseRagdollContext2.getCorpse();
        if (ragdollCorpse == null) {
            return;
        }
        RagdollCorpse ragdollCorpse2 = ragdollCorpse;
        Iterable iterable = ragdollCorpse2.getSegments().values();
        Iterator iterator2 = iterable;
        Object object3 = new ArrayList();
        Object object4 = iterator2;
        Iterator<Object> iterator3 = object4.iterator();
        while (iterator3.hasNext()) {
            SkeletonBody skeletonBody;
            object2 = iterator3.next();
            Object object5 = object2;
            SkeletonSegment skeletonSegment = (SkeletonSegment)object5;
            if (skeletonSegment.getBody() == null) continue;
            SkeletonBody skeletonBody2 = skeletonBody;
            object3.add(skeletonBody2);
        }
        iterable = (List)object3;
        iterator2 = iterable;
        object3 = new ArrayList();
        object4 = iterator2.iterator();
        while (object4.hasNext()) {
            iterator3 = object4.next();
            object2 = (SkeletonBody)((Object)iterator3);
            if (!((SkeletonBody)object2).getClampVel()) continue;
            object3.add(iterator3);
        }
        iterable = (List)object3;
        iterator2 = iterable.iterator();
        if (!iterator2.hasNext()) {
            collection = null;
        } else {
            object3 = iterator2.next();
            object4 = (SkeletonBody)object3;
            float f = ((SkeletonBody)object4).getUnclampedVel().length();
            while (iterator2.hasNext()) {
                iterator3 = iterator2.next();
                SkeletonBody skeletonBody = (SkeletonBody)((Object)iterator3);
                float f2 = skeletonBody.getUnclampedVel().length();
                if (Float.compare(f, f2) >= 0) continue;
                object3 = iterator3;
                f = f2;
            }
            collection = object3;
        }
        float f = (object = (SkeletonBody)((Object)collection)) != null && (object = ((SkeletonBody)object).getUnclampedVel()) != null ? ((Vector3f)object).length() : 0.0f;
        float f3 = 59.999996f * Companion.getMAX_BODY_VEL();
        this.additionalTimesteps = owkq._b((f - Companion.getMAX_BODY_VEL()) / f3, 0.0f, 1.0f);
    }

    @Override
    public boolean skipLagCheck() {
        boolean bl;
        block1: {
            Map map;
            Map map2 = map = (Map)this.getUsers();
            for (Map.Entry entry : map2.entrySet()) {
                Map.Entry entry2 = entry;
                if (!((PhysicsEntityContext)entry2.getValue()).skipLagCheck()) continue;
                bl = true;
                break block1;
            }
            bl = false;
        }
        return bl;
    }

    @Override
    protected void render(float f) {
        PhysicsEntityContext physicsEntityContext;
        GL11.glPushMatrix();
        Iterable iterable = this.getUsers().values();
        for (Object t : iterable) {
            PhysicsEntityContext physicsEntityContext2 = physicsEntityContext = (PhysicsEntityContext)t;
            if (physicsEntityContext2 == null) {
                throw new TypeCastException("null cannot be cast to non-null type gloomyfolken.mods.physics.ragdolls.client.ragdoll.CorpseRagdollContext");
            }
            CorpseRagdollContext cfr_ignored_0 = (CorpseRagdollContext)physicsEntityContext2;
            GL11.glTranslated(((CorpseRagdollContext)physicsEntityContext).getState().getDeathPos()._c, ((CorpseRagdollContext)physicsEntityContext).getState().getDeathPos()._d, ((CorpseRagdollContext)physicsEntityContext).getState().getDeathPos()._e);
        }
        iterable = this.getUsers().values();
        for (Object t : iterable) {
            RagdollCorpse ragdollCorpse;
            physicsEntityContext = (PhysicsEntityContext)t;
            if (!(physicsEntityContext instanceof CorpseRagdollContext)) continue;
            if (((CorpseRagdollContext)physicsEntityContext).getCorpse() == null) {
                continue;
            }
            if (!this.shouldDoDebugRendering()) continue;
            AxisAlignedBB axisAlignedBB = ragdollCorpse.getAabbForCamera();
            Vector3f vector3f = new Vector3f(owkq._j(axisAlignedBB._e), owkq._j(axisAlignedBB._f), owkq._j(axisAlignedBB._g));
            Vector3f vector3f2 = new Vector3f(owkq._j(axisAlignedBB._b), owkq._j(axisAlignedBB._c), owkq._j(axisAlignedBB._d));
            PhysicsWorldRenderer.Companion.renderAabb(vector3f2, vector3f);
            PhysicsWorldRenderer.Companion.renderAabb(this.getWorldAabbMin(), this.getWorldAabbMax());
        }
        super.render(f);
        GL11.glPopMatrix();
    }

    public RagdollWorldContext(@NotNull DynamicsWorldRef dynamicsWorldRef) {
        Intrinsics.checkParameterIsNotNull(dynamicsWorldRef, "world");
        super(dynamicsWorldRef);
        RagdollWorldContext ragdollWorldContext = this;
        ArrayList arrayList = new ArrayList();
        ragdollWorldContext.groundBodies = arrayList;
        this.gravity = new Vector3f(0.0f, -10.0f, 0.0f);
        this.groundOffset = new Vector3f();
        this.getWorldRef().getDynamicsWorld().setGravity(this.gravity);
    }

    @Metadata(mv={1, 1, 7}, bv={1, 0, 2}, k=1, d1={"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u00048F\u00a2\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0007"}, d2={"Lgloomyfolken/mods/physics/ragdolls/client/ragdoll/world/RagdollWorldContext$Companion;", "", "()V", "MAX_BODY_VEL", "", "getMAX_BODY_VEL", "()F", "minecraft"})
    public static final class Companion {
        public final float getMAX_BODY_VEL() {
            return 10.25f;
        }

        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }
}

