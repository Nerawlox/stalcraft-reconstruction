/*
 * Decompiled with CFR 0.152.
 */
package com.bulletphysics.dynamics.character;

import com.bulletphysics.$Stack;
import com.bulletphysics.collision.broadphase.BroadphasePair;
import com.bulletphysics.collision.dispatch.CollisionObject;
import com.bulletphysics.collision.dispatch.CollisionWorld;
import com.bulletphysics.collision.dispatch.PairCachingGhostObject;
import com.bulletphysics.collision.narrowphase.ManifoldPoint;
import com.bulletphysics.collision.narrowphase.PersistentManifold;
import com.bulletphysics.collision.shapes.ConvexShape;
import com.bulletphysics.dynamics.ActionInterface;
import com.bulletphysics.linearmath.IDebugDraw;
import com.bulletphysics.linearmath.Transform;
import com.bulletphysics.util.ObjectArrayList;
import javax.vecmath.Tuple3f;
import javax.vecmath.Vector3f;

public class KinematicCharacterController
extends ActionInterface {
    private static Vector3f[] upAxisDirection = new Vector3f[]{new Vector3f(1.0f, 0.0f, 0.0f), new Vector3f(0.0f, 1.0f, 0.0f), new Vector3f(0.0f, 0.0f, 1.0f)};
    protected float halfHeight;
    protected PairCachingGhostObject ghostObject;
    protected ConvexShape convexShape;
    protected float verticalVelocity;
    protected float verticalOffset;
    protected float fallSpeed;
    protected float jumpSpeed;
    protected float maxJumpHeight;
    protected float maxSlopeRadians;
    protected float maxSlopeCosine;
    protected float gravity;
    protected float turnAngle;
    protected float stepHeight;
    protected float addedMargin;
    protected Vector3f walkDirection = new Vector3f();
    protected Vector3f normalizedDirection = new Vector3f();
    protected Vector3f currentPosition = new Vector3f();
    protected float currentStepOffset;
    protected Vector3f targetPosition = new Vector3f();
    ObjectArrayList<PersistentManifold> manifoldArray = new ObjectArrayList();
    protected boolean touchingContact;
    protected Vector3f touchingNormal = new Vector3f();
    protected boolean wasOnGround;
    protected boolean useGhostObjectSweepTest;
    protected boolean useWalkDirection;
    protected float velocityTimeInterval;
    protected int upAxis;
    protected CollisionObject me;

    public KinematicCharacterController(PairCachingGhostObject ghostObject, ConvexShape convexShape, float stepHeight) {
        this(ghostObject, convexShape, stepHeight, 1);
    }

    public KinematicCharacterController(PairCachingGhostObject ghostObject, ConvexShape convexShape, float stepHeight, int upAxis) {
        this.upAxis = upAxis;
        this.addedMargin = 0.02f;
        this.walkDirection.set(0.0f, 0.0f, 0.0f);
        this.useGhostObjectSweepTest = true;
        this.ghostObject = ghostObject;
        this.stepHeight = stepHeight;
        this.turnAngle = 0.0f;
        this.convexShape = convexShape;
        this.useWalkDirection = true;
        this.velocityTimeInterval = 0.0f;
        this.verticalVelocity = 0.0f;
        this.verticalOffset = 0.0f;
        this.gravity = 9.8f;
        this.fallSpeed = 55.0f;
        this.jumpSpeed = 10.0f;
        this.wasOnGround = false;
        this.setMaxSlope(0.8726647f);
    }

    private PairCachingGhostObject getGhostObject() {
        return this.ghostObject;
    }

    @Override
    public void updateAction(CollisionWorld collisionWorld, float deltaTime) {
        this.preStep(collisionWorld);
        this.playerStep(collisionWorld, deltaTime);
    }

    @Override
    public void debugDraw(IDebugDraw debugDrawer) {
    }

    public void setUpAxis(int axis) {
        if (axis < 0) {
            axis = 0;
        }
        if (axis > 2) {
            axis = 2;
        }
        this.upAxis = axis;
    }

    /*
     * WARNING - void declaration
     */
    public void setWalkDirection(Vector3f vector3f) {
        $Stack $Stack = $Stack.get();
        try {
            void walkDirection;
            $Stack.push$javax$vecmath$Vector3f();
            this.useWalkDirection = true;
            this.walkDirection.set((Tuple3f)walkDirection);
            this.normalizedDirection.set(KinematicCharacterController.getNormalizedVector((Vector3f)walkDirection, $Stack.get$javax$vecmath$Vector3f()));
            $Stack.pop$javax$vecmath$Vector3f();
            return;
        }
        catch (Throwable throwable) {
            $Stack.pop$javax$vecmath$Vector3f();
            throw throwable;
        }
    }

    /*
     * WARNING - void declaration
     */
    public void setVelocityForTimeInterval(Vector3f vector3f, float f) {
        $Stack $Stack = $Stack.get();
        try {
            void timeInterval;
            void velocity;
            $Stack.push$javax$vecmath$Vector3f();
            this.useWalkDirection = false;
            this.walkDirection.set((Tuple3f)velocity);
            this.normalizedDirection.set(KinematicCharacterController.getNormalizedVector(this.walkDirection, $Stack.get$javax$vecmath$Vector3f()));
            this.velocityTimeInterval = timeInterval;
            $Stack.pop$javax$vecmath$Vector3f();
            return;
        }
        catch (Throwable throwable) {
            $Stack.pop$javax$vecmath$Vector3f();
            throw throwable;
        }
    }

    public void reset() {
    }

    /*
     * WARNING - void declaration
     */
    public void warp(Vector3f vector3f) {
        $Stack $Stack = $Stack.get();
        try {
            void origin;
            $Stack.push$com$bulletphysics$linearmath$Transform();
            Transform xform = $Stack.get$com$bulletphysics$linearmath$Transform();
            xform.setIdentity();
            xform.origin.set((Tuple3f)origin);
            this.ghostObject.setWorldTransform(xform);
            $Stack.pop$com$bulletphysics$linearmath$Transform();
            return;
        }
        catch (Throwable throwable) {
            $Stack.pop$com$bulletphysics$linearmath$Transform();
            throw throwable;
        }
    }

    /*
     * WARNING - void declaration
     */
    public void preStep(CollisionWorld collisionWorld) {
        $Stack $Stack = $Stack.get();
        try {
            void collisionWorld2;
            $Stack.push$com$bulletphysics$linearmath$Transform();
            int numPenetrationLoops = 0;
            this.touchingContact = false;
            while (this.recoverFromPenetration((CollisionWorld)collisionWorld2)) {
                this.touchingContact = true;
                if (++numPenetrationLoops <= 4) continue;
            }
            this.currentPosition.set(this.ghostObject.getWorldTransform((Transform)$Stack.get$com$bulletphysics$linearmath$Transform()).origin);
            this.targetPosition.set(this.currentPosition);
            $Stack.pop$com$bulletphysics$linearmath$Transform();
            return;
        }
        catch (Throwable throwable) {
            $Stack.pop$com$bulletphysics$linearmath$Transform();
            throw throwable;
        }
    }

    /*
     * WARNING - void declaration
     */
    public void playerStep(CollisionWorld collisionWorld, float f) {
        $Stack $Stack = $Stack.get();
        try {
            void collisionWorld2;
            float dt;
            $Stack $Stack2 = $Stack;
            $Stack2.push$com$bulletphysics$linearmath$Transform();
            $Stack2.push$javax$vecmath$Vector3f();
            if (!this.useWalkDirection && this.velocityTimeInterval <= 0.0f) {
                $Stack $Stack3 = $Stack;
                $Stack3.pop$com$bulletphysics$linearmath$Transform();
                $Stack3.pop$javax$vecmath$Vector3f();
                return;
            }
            this.wasOnGround = this.onGround();
            this.verticalVelocity -= this.gravity * dt;
            if ((double)this.verticalVelocity > 0.0 && this.verticalVelocity > this.jumpSpeed) {
                this.verticalVelocity = this.jumpSpeed;
            }
            if ((double)this.verticalVelocity < 0.0 && Math.abs(this.verticalVelocity) > Math.abs(this.fallSpeed)) {
                this.verticalVelocity = -Math.abs(this.fallSpeed);
            }
            this.verticalOffset = this.verticalVelocity * dt;
            Transform xform = this.ghostObject.getWorldTransform($Stack.get$com$bulletphysics$linearmath$Transform());
            this.stepUp((CollisionWorld)collisionWorld2);
            if (this.useWalkDirection) {
                this.stepForwardAndStrafe((CollisionWorld)collisionWorld2, this.walkDirection);
            } else {
                System.out.println("playerStep 4");
                float dtMoving = dt < this.velocityTimeInterval ? dt : this.velocityTimeInterval;
                this.velocityTimeInterval -= dt;
                Vector3f move = $Stack.get$javax$vecmath$Vector3f();
                move.scale(dtMoving, this.walkDirection);
                this.stepForwardAndStrafe((CollisionWorld)collisionWorld2, move);
            }
            this.stepDown((CollisionWorld)collisionWorld2, dt);
            xform.origin.set(this.currentPosition);
            this.ghostObject.setWorldTransform(xform);
            $Stack $Stack4 = $Stack;
            $Stack4.pop$com$bulletphysics$linearmath$Transform();
            $Stack4.pop$javax$vecmath$Vector3f();
            return;
        }
        catch (Throwable throwable) {
            $Stack $Stack5 = $Stack;
            $Stack5.pop$com$bulletphysics$linearmath$Transform();
            $Stack5.pop$javax$vecmath$Vector3f();
            throw throwable;
        }
    }

    public void setFallSpeed(float fallSpeed) {
        this.fallSpeed = fallSpeed;
    }

    public void setJumpSpeed(float jumpSpeed) {
        this.jumpSpeed = jumpSpeed;
    }

    public void setMaxJumpHeight(float maxJumpHeight) {
        this.maxJumpHeight = maxJumpHeight;
    }

    public boolean canJump() {
        return this.onGround();
    }

    public void jump() {
        if (!this.canJump()) {
            return;
        }
        this.verticalVelocity = this.jumpSpeed;
    }

    public void setGravity(float gravity) {
        this.gravity = gravity;
    }

    public float getGravity() {
        return this.gravity;
    }

    public void setMaxSlope(float slopeRadians) {
        this.maxSlopeRadians = slopeRadians;
        this.maxSlopeCosine = (float)Math.cos(slopeRadians);
    }

    public float getMaxSlope() {
        return this.maxSlopeRadians;
    }

    public boolean onGround() {
        return this.verticalVelocity == 0.0f && this.verticalOffset == 0.0f;
    }

    private static Vector3f getNormalizedVector(Vector3f v, Vector3f out) {
        out.set(v);
        out.normalize();
        if (out.length() < 1.1920929E-7f) {
            out.set(0.0f, 0.0f, 0.0f);
        }
        return out;
    }

    protected Vector3f computeReflectionDirection(Vector3f direction, Vector3f normal, Vector3f out) {
        out.set(normal);
        out.scale(-2.0f * direction.dot(normal));
        out.add(direction);
        return out;
    }

    protected Vector3f parallelComponent(Vector3f direction, Vector3f normal, Vector3f out) {
        out.set(normal);
        out.scale(direction.dot(normal));
        return out;
    }

    protected Vector3f perpindicularComponent(Vector3f direction, Vector3f normal, Vector3f out) {
        Vector3f perpendicular = this.parallelComponent(direction, normal, out);
        perpendicular.scale(-1.0f);
        perpendicular.add(direction);
        return perpendicular;
    }

    /*
     * WARNING - void declaration
     */
    protected boolean recoverFromPenetration(CollisionWorld collisionWorld) {
        $Stack $Stack = $Stack.get();
        try {
            void collisionWorld2;
            $Stack.push$com$bulletphysics$linearmath$Transform();
            boolean penetration = false;
            collisionWorld2.getDispatcher().dispatchAllCollisionPairs(this.ghostObject.getOverlappingPairCache(), collisionWorld2.getDispatchInfo(), collisionWorld2.getDispatcher());
            this.currentPosition.set(this.ghostObject.getWorldTransform((Transform)$Stack.get$com$bulletphysics$linearmath$Transform()).origin);
            float maxPen = 0.0f;
            for (int i = 0; i < this.ghostObject.getOverlappingPairCache().getNumOverlappingPairs(); ++i) {
                this.manifoldArray.clear();
                BroadphasePair collisionPair = this.ghostObject.getOverlappingPairCache().getOverlappingPairArray().getQuick(i);
                if (collisionPair.algorithm != null) {
                    collisionPair.algorithm.getAllContactManifolds(this.manifoldArray);
                }
                for (int j = 0; j < this.manifoldArray.size(); ++j) {
                    PersistentManifold manifold = this.manifoldArray.getQuick(j);
                    float directionSign = manifold.getBody0() == this.ghostObject ? -1.0f : 1.0f;
                    for (int p = 0; p < manifold.getNumContacts(); ++p) {
                        ManifoldPoint pt = manifold.getContactPoint(p);
                        float dist = pt.getDistance();
                        if (!(dist < 0.0f)) continue;
                        if (dist < maxPen) {
                            maxPen = dist;
                            this.touchingNormal.set(pt.normalWorldOnB);
                            this.touchingNormal.scale(directionSign);
                        }
                        this.currentPosition.scaleAdd(directionSign * dist * 0.2f, pt.normalWorldOnB, this.currentPosition);
                        penetration = true;
                    }
                }
            }
            Transform newTrans = this.ghostObject.getWorldTransform($Stack.get$com$bulletphysics$linearmath$Transform());
            newTrans.origin.set(this.currentPosition);
            this.ghostObject.setWorldTransform(newTrans);
            $Stack.pop$com$bulletphysics$linearmath$Transform();
            return penetration;
        }
        catch (Throwable throwable) {
            $Stack.pop$com$bulletphysics$linearmath$Transform();
            throw throwable;
        }
    }

    /*
     * WARNING - void declaration
     */
    protected void stepUp(CollisionWorld collisionWorld) {
        $Stack $Stack = $Stack.get();
        try {
            void world;
            $Stack $Stack2 = $Stack;
            $Stack2.push$com$bulletphysics$linearmath$Transform();
            $Stack2.push$javax$vecmath$Vector3f();
            Transform start = $Stack.get$com$bulletphysics$linearmath$Transform();
            Transform end = $Stack.get$com$bulletphysics$linearmath$Transform();
            this.targetPosition.scaleAdd(this.stepHeight + ((double)this.verticalOffset > 0.0 ? this.verticalOffset : 0.0f), upAxisDirection[this.upAxis], this.currentPosition);
            start.setIdentity();
            end.setIdentity();
            start.origin.scaleAdd(this.convexShape.getMargin() + this.addedMargin, upAxisDirection[this.upAxis], this.currentPosition);
            end.origin.set(this.targetPosition);
            Vector3f up = $Stack.get$javax$vecmath$Vector3f();
            up.scale(-1.0f, upAxisDirection[this.upAxis]);
            KinematicClosestNotMeConvexResultCallback callback = new KinematicClosestNotMeConvexResultCallback(this.ghostObject, up, 0.0f);
            callback.collisionFilterGroup = this.getGhostObject().getBroadphaseHandle().collisionFilterGroup;
            callback.collisionFilterMask = this.getGhostObject().getBroadphaseHandle().collisionFilterMask;
            if (this.useGhostObjectSweepTest) {
                this.ghostObject.convexSweepTest(this.convexShape, start, end, callback, world.getDispatchInfo().allowedCcdPenetration);
            } else {
                world.convexSweepTest(this.convexShape, start, end, callback);
            }
            if (callback.hasHit()) {
                this.currentStepOffset = this.stepHeight * callback.closestHitFraction;
                this.currentPosition.interpolate(this.currentPosition, this.targetPosition, callback.closestHitFraction);
                this.verticalVelocity = 0.0f;
                this.verticalOffset = 0.0f;
            } else {
                this.currentStepOffset = this.stepHeight;
                this.currentPosition.set(this.targetPosition);
            }
            $Stack $Stack3 = $Stack;
            $Stack3.pop$com$bulletphysics$linearmath$Transform();
            $Stack3.pop$javax$vecmath$Vector3f();
            return;
        }
        catch (Throwable throwable) {
            $Stack $Stack4 = $Stack;
            $Stack4.pop$com$bulletphysics$linearmath$Transform();
            $Stack4.pop$javax$vecmath$Vector3f();
            throw throwable;
        }
    }

    protected void updateTargetPositionBasedOnCollision(Vector3f hitNormal) {
        this.updateTargetPositionBasedOnCollision(hitNormal, 0.0f, 1.0f);
    }

    /*
     * WARNING - void declaration
     */
    protected void updateTargetPositionBasedOnCollision(Vector3f vector3f, float f, float f2) {
        $Stack $Stack = $Stack.get();
        try {
            $Stack.push$javax$vecmath$Vector3f();
            Vector3f movementDirection = $Stack.get$javax$vecmath$Vector3f();
            movementDirection.sub(this.targetPosition, this.currentPosition);
            float movementLength = movementDirection.length();
            if (movementLength > 1.1920929E-7f) {
                void normalMag;
                void hitNormal;
                movementDirection.normalize();
                Vector3f reflectDir = this.computeReflectionDirection(movementDirection, (Vector3f)hitNormal, $Stack.get$javax$vecmath$Vector3f());
                reflectDir.normalize();
                Vector3f parallelDir = this.parallelComponent(reflectDir, (Vector3f)hitNormal, $Stack.get$javax$vecmath$Vector3f());
                Vector3f perpindicularDir = this.perpindicularComponent(reflectDir, (Vector3f)hitNormal, $Stack.get$javax$vecmath$Vector3f());
                this.targetPosition.set(this.currentPosition);
                if (normalMag != 0.0f) {
                    Vector3f perpComponent = $Stack.get$javax$vecmath$Vector3f();
                    perpComponent.scale((float)(normalMag * movementLength), perpindicularDir);
                    this.targetPosition.add(perpComponent);
                }
            }
            $Stack.pop$javax$vecmath$Vector3f();
            return;
        }
        catch (Throwable throwable) {
            $Stack.pop$javax$vecmath$Vector3f();
            throw throwable;
        }
    }

    /*
     * WARNING - void declaration
     */
    protected void stepForwardAndStrafe(CollisionWorld collisionWorld, Vector3f vector3f) {
        $Stack $Stack = $Stack.get();
        try {
            KinematicClosestNotMeConvexResultCallback callback;
            void walkMove;
            $Stack $Stack2 = $Stack;
            $Stack2.push$com$bulletphysics$linearmath$Transform();
            $Stack2.push$javax$vecmath$Vector3f();
            Transform start = $Stack.get$com$bulletphysics$linearmath$Transform();
            Transform end = $Stack.get$com$bulletphysics$linearmath$Transform();
            this.targetPosition.add(this.currentPosition, (Tuple3f)walkMove);
            start.setIdentity();
            end.setIdentity();
            Vector3f distance2Vec = $Stack.get$javax$vecmath$Vector3f();
            distance2Vec.sub(this.currentPosition, this.targetPosition);
            float distance2 = distance2Vec.lengthSquared();
            int maxIter = 10;
            for (float fraction = 1.0f; fraction > 0.01f && maxIter-- > 0; fraction -= callback.closestHitFraction) {
                void collisionWorld2;
                start.origin.set(this.currentPosition);
                end.origin.set(this.targetPosition);
                callback = new KinematicClosestNotMeConvexResultCallback(this.ghostObject, upAxisDirection[this.upAxis], -1.0f);
                callback.collisionFilterGroup = this.getGhostObject().getBroadphaseHandle().collisionFilterGroup;
                callback.collisionFilterMask = this.getGhostObject().getBroadphaseHandle().collisionFilterMask;
                float margin = this.convexShape.getMargin();
                this.convexShape.setMargin(margin + this.addedMargin);
                if (this.useGhostObjectSweepTest) {
                    this.ghostObject.convexSweepTest(this.convexShape, start, end, callback, collisionWorld2.getDispatchInfo().allowedCcdPenetration);
                } else {
                    collisionWorld2.convexSweepTest(this.convexShape, start, end, callback);
                }
                this.convexShape.setMargin(margin);
                if (callback.hasHit()) {
                    Vector3f hitDistanceVec = $Stack.get$javax$vecmath$Vector3f();
                    hitDistanceVec.sub(callback.hitPointWorld, this.currentPosition);
                    this.updateTargetPositionBasedOnCollision(callback.hitNormalWorld);
                    Vector3f currentDir = $Stack.get$javax$vecmath$Vector3f();
                    currentDir.sub(this.targetPosition, this.currentPosition);
                    distance2 = currentDir.lengthSquared();
                    if (!(distance2 > 1.1920929E-7f)) break;
                    currentDir.normalize();
                    if (!(currentDir.dot(this.normalizedDirection) <= 0.0f)) continue;
                    break;
                }
                this.currentPosition.set(this.targetPosition);
            }
            $Stack $Stack3 = $Stack;
            $Stack3.pop$com$bulletphysics$linearmath$Transform();
            $Stack3.pop$javax$vecmath$Vector3f();
            return;
        }
        catch (Throwable throwable) {
            $Stack $Stack4 = $Stack;
            $Stack4.pop$com$bulletphysics$linearmath$Transform();
            $Stack4.pop$javax$vecmath$Vector3f();
            throw throwable;
        }
    }

    /*
     * WARNING - void declaration
     */
    protected void stepDown(CollisionWorld collisionWorld, float f) {
        $Stack $Stack = $Stack.get();
        try {
            void collisionWorld2;
            void dt;
            $Stack $Stack2 = $Stack;
            $Stack2.push$com$bulletphysics$linearmath$Transform();
            $Stack2.push$javax$vecmath$Vector3f();
            Transform start = $Stack.get$com$bulletphysics$linearmath$Transform();
            Transform end = $Stack.get$com$bulletphysics$linearmath$Transform();
            float additionalDownStep = this.wasOnGround ? this.stepHeight : 0.0f;
            Vector3f step_drop = $Stack.get$javax$vecmath$Vector3f();
            step_drop.scale(this.currentStepOffset + additionalDownStep, upAxisDirection[this.upAxis]);
            float downVelocity = (additionalDownStep == 0.0f && this.verticalVelocity < 0.0f ? -this.verticalVelocity : 0.0f) * dt;
            Vector3f gravity_drop = $Stack.get$javax$vecmath$Vector3f();
            gravity_drop.scale(downVelocity, upAxisDirection[this.upAxis]);
            this.targetPosition.sub(step_drop);
            this.targetPosition.sub(gravity_drop);
            start.setIdentity();
            end.setIdentity();
            start.origin.set(this.currentPosition);
            end.origin.set(this.targetPosition);
            KinematicClosestNotMeConvexResultCallback callback = new KinematicClosestNotMeConvexResultCallback(this.ghostObject, upAxisDirection[this.upAxis], this.maxSlopeCosine);
            callback.collisionFilterGroup = this.getGhostObject().getBroadphaseHandle().collisionFilterGroup;
            callback.collisionFilterMask = this.getGhostObject().getBroadphaseHandle().collisionFilterMask;
            if (this.useGhostObjectSweepTest) {
                this.ghostObject.convexSweepTest(this.convexShape, start, end, callback, collisionWorld2.getDispatchInfo().allowedCcdPenetration);
            } else {
                collisionWorld2.convexSweepTest(this.convexShape, start, end, callback);
            }
            if (callback.hasHit()) {
                this.currentPosition.interpolate(this.currentPosition, this.targetPosition, callback.closestHitFraction);
                this.verticalVelocity = 0.0f;
                this.verticalOffset = 0.0f;
            } else {
                this.currentPosition.set(this.targetPosition);
            }
            $Stack $Stack3 = $Stack;
            $Stack3.pop$com$bulletphysics$linearmath$Transform();
            $Stack3.pop$javax$vecmath$Vector3f();
            return;
        }
        catch (Throwable throwable) {
            $Stack $Stack4 = $Stack;
            $Stack4.pop$com$bulletphysics$linearmath$Transform();
            $Stack4.pop$javax$vecmath$Vector3f();
            throw throwable;
        }
    }

    private static class KinematicClosestNotMeConvexResultCallback
    extends CollisionWorld.ClosestConvexResultCallback {
        protected CollisionObject me;
        protected final Vector3f up;
        protected float minSlopeDot;

        public KinematicClosestNotMeConvexResultCallback(CollisionObject me, Vector3f up, float minSlopeDot) {
            super(new Vector3f(), new Vector3f());
            this.me = me;
            this.up = up;
            this.minSlopeDot = minSlopeDot;
        }

        /*
         * WARNING - void declaration
         */
        @Override
        public float addSingleResult(CollisionWorld.LocalConvexResult localConvexResult, boolean bl) {
            $Stack $Stack = $Stack.get();
            try {
                Vector3f hitNormalWorld;
                void normalInWorldSpace;
                void convexResult;
                $Stack $Stack2 = $Stack;
                $Stack2.push$com$bulletphysics$linearmath$Transform();
                $Stack2.push$javax$vecmath$Vector3f();
                if (convexResult.hitCollisionObject == this.me) {
                    $Stack $Stack3 = $Stack;
                    $Stack3.pop$com$bulletphysics$linearmath$Transform();
                    $Stack3.pop$javax$vecmath$Vector3f();
                    return 1.0f;
                }
                if (normalInWorldSpace != false) {
                    hitNormalWorld = convexResult.hitNormalLocal;
                } else {
                    hitNormalWorld = $Stack.get$javax$vecmath$Vector3f();
                    this.hitCollisionObject.getWorldTransform((Transform)$Stack.get$com$bulletphysics$linearmath$Transform()).basis.transform(convexResult.hitNormalLocal, hitNormalWorld);
                }
                float dotUp = this.up.dot(hitNormalWorld);
                if (dotUp < this.minSlopeDot) {
                    $Stack $Stack4 = $Stack;
                    $Stack4.pop$com$bulletphysics$linearmath$Transform();
                    $Stack4.pop$javax$vecmath$Vector3f();
                    return 1.0f;
                }
                float f = super.addSingleResult((CollisionWorld.LocalConvexResult)convexResult, (boolean)normalInWorldSpace);
                $Stack $Stack5 = $Stack;
                $Stack5.pop$com$bulletphysics$linearmath$Transform();
                $Stack5.pop$javax$vecmath$Vector3f();
                return f;
            }
            catch (Throwable throwable) {
                $Stack $Stack6 = $Stack;
                $Stack6.pop$com$bulletphysics$linearmath$Transform();
                $Stack6.pop$javax$vecmath$Vector3f();
                throw throwable;
            }
        }
    }

    private static class KinematicClosestNotMeRayResultCallback
    extends CollisionWorld.ClosestRayResultCallback {
        protected CollisionObject me;

        public KinematicClosestNotMeRayResultCallback(CollisionObject me) {
            super(new Vector3f(), new Vector3f());
            this.me = me;
        }

        @Override
        public float addSingleResult(CollisionWorld.LocalRayResult rayResult, boolean normalInWorldSpace) {
            if (rayResult.collisionObject == this.me) {
                return 1.0f;
            }
            return super.addSingleResult(rayResult, normalInWorldSpace);
        }
    }
}

