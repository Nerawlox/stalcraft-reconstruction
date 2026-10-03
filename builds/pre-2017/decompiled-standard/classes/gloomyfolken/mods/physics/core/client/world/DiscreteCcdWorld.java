/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.physics.core.client.world;

import com.bulletphysics.BulletStats;
import com.bulletphysics.collision.broadphase.BroadphaseInterface;
import com.bulletphysics.collision.broadphase.BroadphasePair;
import com.bulletphysics.collision.broadphase.BroadphaseProxy;
import com.bulletphysics.collision.broadphase.Dispatcher;
import com.bulletphysics.collision.broadphase.OverlappingPairCache;
import com.bulletphysics.collision.dispatch.CollisionConfiguration;
import com.bulletphysics.collision.dispatch.CollisionObject;
import com.bulletphysics.collision.dispatch.CollisionWorld;
import com.bulletphysics.collision.narrowphase.PersistentManifold;
import com.bulletphysics.collision.shapes.SphereShape;
import com.bulletphysics.dynamics.DiscreteDynamicsWorld;
import com.bulletphysics.dynamics.RigidBody;
import com.bulletphysics.dynamics.constraintsolver.ConstraintSolver;
import com.bulletphysics.linearmath.Transform;
import com.bulletphysics.util.ObjectArrayList;
import gloomyfolken.mods.physics.core.client.SkeletonBody;
import java.util.Collection;
import javax.vecmath.Vector3f;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={1, 1, 7}, bv={1, 0, 2}, k=1, d1={"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u000fB-\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u00a2\u0006\u0002\u0010\nJ\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0014\u00a8\u0006\u0010"}, d2={"Lgloomyfolken/mods/physics/core/client/world/DiscreteCcdWorld;", "Lcom/bulletphysics/dynamics/DiscreteDynamicsWorld;", "dispatcher", "Lcom/bulletphysics/collision/broadphase/Dispatcher;", "pairCache", "Lcom/bulletphysics/collision/broadphase/BroadphaseInterface;", "constraintSolver", "Lcom/bulletphysics/dynamics/constraintsolver/ConstraintSolver;", "collisionConfiguration", "Lcom/bulletphysics/collision/dispatch/CollisionConfiguration;", "(Lcom/bulletphysics/collision/broadphase/Dispatcher;Lcom/bulletphysics/collision/broadphase/BroadphaseInterface;Lcom/bulletphysics/dynamics/constraintsolver/ConstraintSolver;Lcom/bulletphysics/collision/dispatch/CollisionConfiguration;)V", "integrateTransforms", "", "timeStep", "", "ClosestNotMeConvexResultCallback", "minecraft"})
public final class DiscreteCcdWorld
extends DiscreteDynamicsWorld {
    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    protected void integrateTransforms(float f) {
        BulletStats.pushProfile("integrateTransforms");
        try {
            Vector3f vector3f = new Vector3f();
            Transform transform = new Transform();
            Transform transform2 = new Transform();
            int n = ((Collection)this.collisionObjects).size();
            for (int i = 0; i < n; ++i) {
                RigidBody rigidBody = RigidBody.upcast((CollisionObject)this.collisionObjects.getQuick(i));
                if (rigidBody == null) continue;
                rigidBody.setHitFraction(1.0f);
                if (!rigidBody.isActive() || rigidBody.isStaticOrKinematicObject()) continue;
                rigidBody.predictIntegratedTransform(f, transform2);
                vector3f.sub(transform2.origin, rigidBody.getWorldTransform((Transform)transform).origin);
                float f2 = vector3f.lengthSquared();
                if (rigidBody.getCcdSquareMotionThreshold() != 0.0f && rigidBody.getCcdSquareMotionThreshold() < f2) {
                    BulletStats.pushProfile("CCD motion clamping");
                    try {
                        if (rigidBody.getCollisionShape().isConvex()) {
                            ++BulletStats.gNumClampedCcdMotions;
                            CollisionObject collisionObject = rigidBody;
                            Vector3f vector3f2 = rigidBody.getWorldTransform((Transform)transform).origin;
                            Intrinsics.checkExpressionValueIsNotNull(vector3f2, "body.getWorldTransform(tmpTrans).origin");
                            Vector3f vector3f3 = transform2.origin;
                            Intrinsics.checkExpressionValueIsNotNull(vector3f3, "predictedTrans.origin");
                            OverlappingPairCache overlappingPairCache = this.getBroadphase().getOverlappingPairCache();
                            Intrinsics.checkExpressionValueIsNotNull(overlappingPairCache, "this.broadphase.overlappingPairCache");
                            Dispatcher dispatcher = this.getDispatcher();
                            Intrinsics.checkExpressionValueIsNotNull(dispatcher, "this.dispatcher");
                            ClosestNotMeConvexResultCallback closestNotMeConvexResultCallback = new ClosestNotMeConvexResultCallback(collisionObject, vector3f2, vector3f3, overlappingPairCache, dispatcher);
                            SphereShape sphereShape = new SphereShape(rigidBody.getCcdSweptSphereRadius());
                            closestNotMeConvexResultCallback.collisionFilterGroup = rigidBody.getBroadphaseProxy().collisionFilterGroup;
                            closestNotMeConvexResultCallback.collisionFilterMask = rigidBody.getBroadphaseProxy().collisionFilterMask;
                            this.convexSweepTest(sphereShape, rigidBody.getWorldTransform(transform), transform2, closestNotMeConvexResultCallback);
                            if (closestNotMeConvexResultCallback.hasHit() && closestNotMeConvexResultCallback.closestHitFraction > 1.0E-4f) {
                                rigidBody.setHitFraction(closestNotMeConvexResultCallback.closestHitFraction);
                                rigidBody.predictIntegratedTransform(f * rigidBody.getHitFraction(), transform2);
                                if (rigidBody.getHitFraction() < 1.0f) {
                                    // empty if block
                                }
                                rigidBody.setHitFraction(0.0f);
                            }
                        }
                    }
                    finally {
                        BulletStats.popProfile();
                    }
                }
                rigidBody.proceedToTransform(transform2);
            }
        }
        finally {
            BulletStats.popProfile();
        }
    }

    public DiscreteCcdWorld(@Nullable Dispatcher dispatcher, @Nullable BroadphaseInterface broadphaseInterface, @Nullable ConstraintSolver constraintSolver, @Nullable CollisionConfiguration collisionConfiguration) {
        super(dispatcher, broadphaseInterface, constraintSolver, collisionConfiguration);
    }

    @Metadata(mv={1, 1, 7}, bv={1, 0, 2}, k=1, d1={"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u00a2\u0006\u0002\u0010\u000bJ\u0018\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u0010\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u0015H\u0016R\u000e\u0010\f\u001a\u00020\rX\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0016"}, d2={"Lgloomyfolken/mods/physics/core/client/world/DiscreteCcdWorld$ClosestNotMeConvexResultCallback;", "Lcom/bulletphysics/collision/dispatch/CollisionWorld$ClosestConvexResultCallback;", "me", "Lcom/bulletphysics/collision/dispatch/CollisionObject;", "fromA", "Ljavax/vecmath/Vector3f;", "toA", "pairCache", "Lcom/bulletphysics/collision/broadphase/OverlappingPairCache;", "dispatcher", "Lcom/bulletphysics/collision/broadphase/Dispatcher;", "(Lcom/bulletphysics/collision/dispatch/CollisionObject;Ljavax/vecmath/Vector3f;Ljavax/vecmath/Vector3f;Lcom/bulletphysics/collision/broadphase/OverlappingPairCache;Lcom/bulletphysics/collision/broadphase/Dispatcher;)V", "allowedPenetration", "", "addSingleResult", "convexResult", "Lcom/bulletphysics/collision/dispatch/CollisionWorld$LocalConvexResult;", "normalInWorldSpace", "", "needsCollision", "proxy0", "Lcom/bulletphysics/collision/broadphase/BroadphaseProxy;", "minecraft"})
    private static final class ClosestNotMeConvexResultCallback
    extends CollisionWorld.ClosestConvexResultCallback {
        private final float allowedPenetration = 0.0f;
        private final CollisionObject me;
        private final OverlappingPairCache pairCache;
        private final Dispatcher dispatcher;

        @Override
        public float addSingleResult(@NotNull CollisionWorld.LocalConvexResult localConvexResult, boolean bl) {
            Intrinsics.checkParameterIsNotNull(localConvexResult, "convexResult");
            if (localConvexResult.hitCollisionObject == this.me) {
                return 1.0f;
            }
            Vector3f vector3f = new Vector3f();
            Vector3f vector3f2 = new Vector3f();
            vector3f.sub(this.convexToWorld, this.convexFromWorld);
            vector3f2.set(0.0f, 0.0f, 0.0f);
            Vector3f vector3f3 = new Vector3f();
            vector3f3.sub(vector3f, vector3f2);
            if (localConvexResult.hitNormalLocal.dot(vector3f3) >= -this.allowedPenetration) {
                return 1.0f;
            }
            float f = super.addSingleResult(localConvexResult, bl);
            return f;
        }

        @Override
        public boolean needsCollision(@NotNull BroadphaseProxy broadphaseProxy) {
            Intrinsics.checkParameterIsNotNull(broadphaseProxy, "proxy0");
            if (broadphaseProxy.clientObject == this.me) {
                return false;
            }
            if (!super.needsCollision(broadphaseProxy)) {
                return false;
            }
            Object object = broadphaseProxy.clientObject;
            if (object == null) {
                throw new TypeCastException("null cannot be cast to non-null type com.bulletphysics.collision.dispatch.CollisionObject");
            }
            CollisionObject collisionObject = (CollisionObject)object;
            if (collisionObject.getUserPointer() instanceof SkeletonBody) {
                return false;
            }
            if (this.dispatcher.needsResponse(this.me, collisionObject)) {
                ObjectArrayList<PersistentManifold> objectArrayList = new ObjectArrayList<PersistentManifold>();
                BroadphasePair broadphasePair = this.pairCache.findPair(this.me.getBroadphaseHandle(), broadphaseProxy);
                if (broadphasePair != null && broadphasePair.algorithm != null) {
                    broadphasePair.algorithm.getAllContactManifolds(objectArrayList);
                    int n = ((Collection)objectArrayList).size();
                    for (int i = 0; i < n; ++i) {
                        if (objectArrayList.getQuick(i).getNumContacts() <= 0) continue;
                        return false;
                    }
                }
            }
            return true;
        }

        public ClosestNotMeConvexResultCallback(@NotNull CollisionObject collisionObject, @NotNull Vector3f vector3f, @NotNull Vector3f vector3f2, @NotNull OverlappingPairCache overlappingPairCache, @NotNull Dispatcher dispatcher) {
            Intrinsics.checkParameterIsNotNull(collisionObject, "me");
            Intrinsics.checkParameterIsNotNull(vector3f, "fromA");
            Intrinsics.checkParameterIsNotNull(vector3f2, "toA");
            Intrinsics.checkParameterIsNotNull(overlappingPairCache, "pairCache");
            Intrinsics.checkParameterIsNotNull(dispatcher, "dispatcher");
            super(vector3f, vector3f2);
            this.me = collisionObject;
            this.pairCache = overlappingPairCache;
            this.dispatcher = dispatcher;
        }
    }
}

