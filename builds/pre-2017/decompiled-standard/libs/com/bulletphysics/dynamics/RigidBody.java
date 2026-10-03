/*
 * Decompiled with CFR 0.152.
 */
package com.bulletphysics.dynamics;

import com.bulletphysics.$Stack;
import com.bulletphysics.BulletGlobals;
import com.bulletphysics.collision.broadphase.BroadphaseProxy;
import com.bulletphysics.collision.dispatch.CollisionObject;
import com.bulletphysics.collision.dispatch.CollisionObjectType;
import com.bulletphysics.collision.shapes.CollisionShape;
import com.bulletphysics.dynamics.RigidBodyConstructionInfo;
import com.bulletphysics.dynamics.constraintsolver.TypedConstraint;
import com.bulletphysics.linearmath.MatrixUtil;
import com.bulletphysics.linearmath.MiscUtil;
import com.bulletphysics.linearmath.MotionState;
import com.bulletphysics.linearmath.Transform;
import com.bulletphysics.linearmath.TransformUtil;
import com.bulletphysics.util.ObjectArrayList;
import javax.vecmath.Matrix3f;
import javax.vecmath.Quat4f;
import javax.vecmath.Tuple3f;
import javax.vecmath.Vector3f;

public class RigidBody
extends CollisionObject {
    private static final float MAX_ANGVEL = 1.5707964f;
    private final Matrix3f invInertiaTensorWorld = new Matrix3f();
    private final Vector3f linearVelocity = new Vector3f();
    private final Vector3f angularVelocity = new Vector3f();
    private float inverseMass;
    private float angularFactor;
    private final Vector3f gravity = new Vector3f();
    private final Vector3f invInertiaLocal = new Vector3f();
    private final Vector3f totalForce = new Vector3f();
    private final Vector3f totalTorque = new Vector3f();
    private float linearDamping;
    private float angularDamping;
    private boolean additionalDamping;
    private float additionalDampingFactor;
    private float additionalLinearDampingThresholdSqr;
    private float additionalAngularDampingThresholdSqr;
    private float additionalAngularDampingFactor;
    private float linearSleepingThreshold;
    private float angularSleepingThreshold;
    private MotionState optionalMotionState;
    private final ObjectArrayList<TypedConstraint> constraintRefs = new ObjectArrayList();
    public int contactSolverType;
    public int frictionSolverType;
    private static int uniqueId = 0;
    public int debugBodyId;

    public RigidBody(RigidBodyConstructionInfo constructionInfo) {
        this.setupRigidBody(constructionInfo);
    }

    public RigidBody(float mass, MotionState motionState, CollisionShape collisionShape) {
        this(mass, motionState, collisionShape, new Vector3f(0.0f, 0.0f, 0.0f));
    }

    public RigidBody(float mass, MotionState motionState, CollisionShape collisionShape, Vector3f localInertia) {
        RigidBodyConstructionInfo cinfo = new RigidBodyConstructionInfo(mass, motionState, collisionShape, localInertia);
        this.setupRigidBody(cinfo);
    }

    private void setupRigidBody(RigidBodyConstructionInfo constructionInfo) {
        this.internalType = CollisionObjectType.RIGID_BODY;
        this.linearVelocity.set(0.0f, 0.0f, 0.0f);
        this.angularVelocity.set(0.0f, 0.0f, 0.0f);
        this.angularFactor = 1.0f;
        this.gravity.set(0.0f, 0.0f, 0.0f);
        this.totalForce.set(0.0f, 0.0f, 0.0f);
        this.totalTorque.set(0.0f, 0.0f, 0.0f);
        this.linearDamping = 0.0f;
        this.angularDamping = 0.5f;
        this.linearSleepingThreshold = constructionInfo.linearSleepingThreshold;
        this.angularSleepingThreshold = constructionInfo.angularSleepingThreshold;
        this.optionalMotionState = constructionInfo.motionState;
        this.contactSolverType = 0;
        this.frictionSolverType = 0;
        this.additionalDamping = constructionInfo.additionalDamping;
        this.additionalDampingFactor = constructionInfo.additionalDampingFactor;
        this.additionalLinearDampingThresholdSqr = constructionInfo.additionalLinearDampingThresholdSqr;
        this.additionalAngularDampingThresholdSqr = constructionInfo.additionalAngularDampingThresholdSqr;
        this.additionalAngularDampingFactor = constructionInfo.additionalAngularDampingFactor;
        if (this.optionalMotionState != null) {
            this.optionalMotionState.getWorldTransform(this.worldTransform);
        } else {
            this.worldTransform.set(constructionInfo.startWorldTransform);
        }
        this.interpolationWorldTransform.set(this.worldTransform);
        this.interpolationLinearVelocity.set(0.0f, 0.0f, 0.0f);
        this.interpolationAngularVelocity.set(0.0f, 0.0f, 0.0f);
        this.friction = constructionInfo.friction;
        this.restitution = constructionInfo.restitution;
        this.setCollisionShape(constructionInfo.collisionShape);
        this.debugBodyId = uniqueId++;
        this.setMassProps(constructionInfo.mass, constructionInfo.localInertia);
        this.setDamping(constructionInfo.linearDamping, constructionInfo.angularDamping);
        this.updateInertiaTensor();
    }

    public void destroy() {
        assert (this.constraintRefs.size() == 0);
    }

    public void proceedToTransform(Transform newTrans) {
        this.setCenterOfMassTransform(newTrans);
    }

    public static RigidBody upcast(CollisionObject colObj) {
        if (colObj.getInternalType() == CollisionObjectType.RIGID_BODY) {
            return (RigidBody)colObj;
        }
        return null;
    }

    public void predictIntegratedTransform(float timeStep, Transform predictedTransform) {
        TransformUtil.integrateTransform(this.worldTransform, this.linearVelocity, this.angularVelocity, timeStep, predictedTransform);
    }

    public void saveKinematicState(float timeStep) {
        if (timeStep != 0.0f) {
            if (this.getMotionState() != null) {
                this.getMotionState().getWorldTransform(this.worldTransform);
            }
            TransformUtil.calculateVelocity(this.interpolationWorldTransform, this.worldTransform, timeStep, this.linearVelocity, this.angularVelocity);
            this.interpolationLinearVelocity.set(this.linearVelocity);
            this.interpolationAngularVelocity.set(this.angularVelocity);
            this.interpolationWorldTransform.set(this.worldTransform);
        }
    }

    public void applyGravity() {
        if (this.isStaticOrKinematicObject()) {
            return;
        }
        this.applyCentralForce(this.gravity);
    }

    public void setGravity(Vector3f acceleration) {
        if (this.inverseMass != 0.0f) {
            this.gravity.scale(1.0f / this.inverseMass, acceleration);
        }
    }

    public Vector3f getGravity(Vector3f out) {
        out.set(this.gravity);
        return out;
    }

    public void setDamping(float lin_damping, float ang_damping) {
        this.linearDamping = MiscUtil.GEN_clamped(lin_damping, 0.0f, 1.0f);
        this.angularDamping = MiscUtil.GEN_clamped(ang_damping, 0.0f, 1.0f);
    }

    public float getLinearDamping() {
        return this.linearDamping;
    }

    public float getAngularDamping() {
        return this.angularDamping;
    }

    public float getLinearSleepingThreshold() {
        return this.linearSleepingThreshold;
    }

    public float getAngularSleepingThreshold() {
        return this.angularSleepingThreshold;
    }

    /*
     * WARNING - void declaration
     */
    public void applyDamping(float f) {
        $Stack $Stack = $Stack.get();
        try {
            void timeStep;
            $Stack.push$javax$vecmath$Vector3f();
            this.linearVelocity.scale((float)Math.pow(1.0f - this.linearDamping, (double)timeStep));
            this.angularVelocity.scale((float)Math.pow(1.0f - this.angularDamping, (double)timeStep));
            if (this.additionalDamping) {
                float angSpeed;
                float speed;
                if (this.angularVelocity.lengthSquared() < this.additionalAngularDampingThresholdSqr && this.linearVelocity.lengthSquared() < this.additionalLinearDampingThresholdSqr) {
                    this.angularVelocity.scale(this.additionalDampingFactor);
                    this.linearVelocity.scale(this.additionalDampingFactor);
                }
                if ((speed = this.linearVelocity.length()) < this.linearDamping) {
                    float dampVel = 0.005f;
                    if (speed > dampVel) {
                        Vector3f dir = $Stack.get$javax$vecmath$Vector3f(this.linearVelocity);
                        dir.normalize();
                        dir.scale(dampVel);
                        this.linearVelocity.sub(dir);
                    } else {
                        this.linearVelocity.set(0.0f, 0.0f, 0.0f);
                    }
                }
                if ((angSpeed = this.angularVelocity.length()) < this.angularDamping) {
                    float angDampVel = 0.005f;
                    if (angSpeed > angDampVel) {
                        Vector3f dir = $Stack.get$javax$vecmath$Vector3f(this.angularVelocity);
                        dir.normalize();
                        dir.scale(angDampVel);
                        this.angularVelocity.sub(dir);
                    } else {
                        this.angularVelocity.set(0.0f, 0.0f, 0.0f);
                    }
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

    public void setMassProps(float mass, Vector3f inertia) {
        if (mass == 0.0f) {
            this.collisionFlags |= 1;
            this.inverseMass = 0.0f;
        } else {
            this.collisionFlags &= 0xFFFFFFFE;
            this.inverseMass = 1.0f / mass;
        }
        this.invInertiaLocal.set(inertia.x != 0.0f ? 1.0f / inertia.x : 0.0f, inertia.y != 0.0f ? 1.0f / inertia.y : 0.0f, inertia.z != 0.0f ? 1.0f / inertia.z : 0.0f);
    }

    public float getInvMass() {
        return this.inverseMass;
    }

    public Matrix3f getInvInertiaTensorWorld(Matrix3f out) {
        out.set(this.invInertiaTensorWorld);
        return out;
    }

    /*
     * WARNING - void declaration
     */
    public void integrateVelocities(float f) {
        $Stack $Stack = $Stack.get();
        try {
            void step;
            $Stack.push$javax$vecmath$Vector3f();
            if (this.isStaticOrKinematicObject()) {
                $Stack.pop$javax$vecmath$Vector3f();
                return;
            }
            this.linearVelocity.scaleAdd(this.inverseMass * step, this.totalForce, this.linearVelocity);
            Vector3f tmp = $Stack.get$javax$vecmath$Vector3f(this.totalTorque);
            this.invInertiaTensorWorld.transform(tmp);
            this.angularVelocity.scaleAdd((float)step, tmp, this.angularVelocity);
            float angvel = this.angularVelocity.length();
            if (angvel * step > 1.5707964f) {
                this.angularVelocity.scale(1.5707964f / step / angvel);
            }
            $Stack.pop$javax$vecmath$Vector3f();
            return;
        }
        catch (Throwable throwable) {
            $Stack.pop$javax$vecmath$Vector3f();
            throw throwable;
        }
    }

    public void setCenterOfMassTransform(Transform xform) {
        if (this.isStaticOrKinematicObject()) {
            this.interpolationWorldTransform.set(this.worldTransform);
        } else {
            this.interpolationWorldTransform.set(xform);
        }
        this.getLinearVelocity(this.interpolationLinearVelocity);
        this.getAngularVelocity(this.interpolationAngularVelocity);
        this.worldTransform.set(xform);
        this.updateInertiaTensor();
    }

    public void applyCentralForce(Vector3f force) {
        this.totalForce.add(force);
    }

    public Vector3f getInvInertiaDiagLocal(Vector3f out) {
        out.set(this.invInertiaLocal);
        return out;
    }

    public void setInvInertiaDiagLocal(Vector3f diagInvInertia) {
        this.invInertiaLocal.set(diagInvInertia);
    }

    public void setSleepingThresholds(float linear, float angular) {
        this.linearSleepingThreshold = linear;
        this.angularSleepingThreshold = angular;
    }

    public void applyTorque(Vector3f torque) {
        this.totalTorque.add(torque);
    }

    /*
     * WARNING - void declaration
     */
    public void applyForce(Vector3f vector3f, Vector3f vector3f2) {
        $Stack $Stack = $Stack.get();
        try {
            void rel_pos;
            void force;
            $Stack.push$javax$vecmath$Vector3f();
            this.applyCentralForce((Vector3f)force);
            Vector3f tmp = $Stack.get$javax$vecmath$Vector3f();
            tmp.cross((Vector3f)rel_pos, (Vector3f)force);
            tmp.scale(this.angularFactor);
            this.applyTorque(tmp);
            $Stack.pop$javax$vecmath$Vector3f();
            return;
        }
        catch (Throwable throwable) {
            $Stack.pop$javax$vecmath$Vector3f();
            throw throwable;
        }
    }

    public void applyCentralImpulse(Vector3f impulse) {
        this.linearVelocity.scaleAdd(this.inverseMass, impulse, this.linearVelocity);
    }

    /*
     * WARNING - void declaration
     */
    public void applyTorqueImpulse(Vector3f vector3f) {
        $Stack $Stack = $Stack.get();
        try {
            void torque;
            $Stack.push$javax$vecmath$Vector3f();
            Vector3f tmp = $Stack.get$javax$vecmath$Vector3f((Vector3f)torque);
            this.invInertiaTensorWorld.transform(tmp);
            this.angularVelocity.add(tmp);
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
    public void applyImpulse(Vector3f vector3f, Vector3f vector3f2) {
        $Stack $Stack = $Stack.get();
        try {
            $Stack.push$javax$vecmath$Vector3f();
            if (this.inverseMass != 0.0f) {
                void impulse;
                this.applyCentralImpulse((Vector3f)impulse);
                if (this.angularFactor != 0.0f) {
                    void rel_pos;
                    Vector3f tmp = $Stack.get$javax$vecmath$Vector3f();
                    tmp.cross((Vector3f)rel_pos, (Vector3f)impulse);
                    tmp.scale(this.angularFactor);
                    this.applyTorqueImpulse(tmp);
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

    public void internalApplyImpulse(Vector3f linearComponent, Vector3f angularComponent, float impulseMagnitude) {
        if (this.inverseMass != 0.0f) {
            this.linearVelocity.scaleAdd(impulseMagnitude, linearComponent, this.linearVelocity);
            if (this.angularFactor != 0.0f) {
                this.angularVelocity.scaleAdd(impulseMagnitude * this.angularFactor, angularComponent, this.angularVelocity);
            }
        }
    }

    public void clearForces() {
        this.totalForce.set(0.0f, 0.0f, 0.0f);
        this.totalTorque.set(0.0f, 0.0f, 0.0f);
    }

    public void updateInertiaTensor() {
        $Stack $Stack = $Stack.get();
        try {
            $Stack.push$javax$vecmath$Matrix3f();
            Matrix3f mat1 = $Stack.get$javax$vecmath$Matrix3f();
            MatrixUtil.scale(mat1, this.worldTransform.basis, this.invInertiaLocal);
            Matrix3f mat2 = $Stack.get$javax$vecmath$Matrix3f(this.worldTransform.basis);
            mat2.transpose();
            this.invInertiaTensorWorld.mul(mat1, mat2);
            $Stack.pop$javax$vecmath$Matrix3f();
            return;
        }
        catch (Throwable throwable) {
            $Stack.pop$javax$vecmath$Matrix3f();
            throw throwable;
        }
    }

    public Vector3f getCenterOfMassPosition(Vector3f out) {
        out.set(this.worldTransform.origin);
        return out;
    }

    public Quat4f getOrientation(Quat4f out) {
        MatrixUtil.getRotation(this.worldTransform.basis, out);
        return out;
    }

    public Transform getCenterOfMassTransform(Transform out) {
        out.set(this.worldTransform);
        return out;
    }

    public Vector3f getLinearVelocity(Vector3f out) {
        out.set(this.linearVelocity);
        return out;
    }

    public Vector3f getAngularVelocity(Vector3f out) {
        out.set(this.angularVelocity);
        return out;
    }

    public void setLinearVelocity(Vector3f lin_vel) {
        assert (this.collisionFlags != 1);
        this.linearVelocity.set(lin_vel);
    }

    public void setAngularVelocity(Vector3f ang_vel) {
        assert (this.collisionFlags != 1);
        this.angularVelocity.set(ang_vel);
    }

    public Vector3f getVelocityInLocalPoint(Vector3f rel_pos, Vector3f out) {
        Vector3f vec = out;
        vec.cross(this.angularVelocity, rel_pos);
        vec.add(this.linearVelocity);
        return out;
    }

    public void translate(Vector3f v) {
        this.worldTransform.origin.add(v);
    }

    public void getAabb(Vector3f aabbMin, Vector3f aabbMax) {
        this.getCollisionShape().getAabb(this.worldTransform, aabbMin, aabbMax);
    }

    /*
     * WARNING - void declaration
     */
    public float computeImpulseDenominator(Vector3f vector3f, Vector3f vector3f2) {
        $Stack $Stack = $Stack.get();
        try {
            void normal;
            void pos;
            $Stack $Stack2 = $Stack;
            $Stack2.push$javax$vecmath$Vector3f();
            $Stack2.push$javax$vecmath$Matrix3f();
            Vector3f r0 = $Stack.get$javax$vecmath$Vector3f();
            r0.sub((Tuple3f)pos, this.getCenterOfMassPosition($Stack.get$javax$vecmath$Vector3f()));
            Vector3f c0 = $Stack.get$javax$vecmath$Vector3f();
            c0.cross(r0, (Vector3f)normal);
            Vector3f tmp = $Stack.get$javax$vecmath$Vector3f();
            MatrixUtil.transposeTransform(tmp, c0, this.getInvInertiaTensorWorld($Stack.get$javax$vecmath$Matrix3f()));
            Vector3f vec = $Stack.get$javax$vecmath$Vector3f();
            vec.cross(tmp, r0);
            float f = this.inverseMass + normal.dot(vec);
            $Stack $Stack3 = $Stack;
            $Stack3.pop$javax$vecmath$Vector3f();
            $Stack3.pop$javax$vecmath$Matrix3f();
            return f;
        }
        catch (Throwable throwable) {
            $Stack $Stack4 = $Stack;
            $Stack4.pop$javax$vecmath$Vector3f();
            $Stack4.pop$javax$vecmath$Matrix3f();
            throw throwable;
        }
    }

    /*
     * WARNING - void declaration
     */
    public float computeAngularImpulseDenominator(Vector3f vector3f) {
        $Stack $Stack = $Stack.get();
        try {
            void axis;
            $Stack $Stack2 = $Stack;
            $Stack2.push$javax$vecmath$Vector3f();
            $Stack2.push$javax$vecmath$Matrix3f();
            Vector3f vec = $Stack.get$javax$vecmath$Vector3f();
            MatrixUtil.transposeTransform(vec, (Vector3f)axis, this.getInvInertiaTensorWorld($Stack.get$javax$vecmath$Matrix3f()));
            float f = axis.dot(vec);
            $Stack $Stack3 = $Stack;
            $Stack3.pop$javax$vecmath$Vector3f();
            $Stack3.pop$javax$vecmath$Matrix3f();
            return f;
        }
        catch (Throwable throwable) {
            $Stack $Stack4 = $Stack;
            $Stack4.pop$javax$vecmath$Vector3f();
            $Stack4.pop$javax$vecmath$Matrix3f();
            throw throwable;
        }
    }

    /*
     * WARNING - void declaration
     */
    public void updateDeactivation(float f) {
        $Stack $Stack = $Stack.get();
        try {
            $Stack.push$javax$vecmath$Vector3f();
            if (this.getActivationState() == 2 || this.getActivationState() == 4) {
                $Stack.pop$javax$vecmath$Vector3f();
                return;
            }
            if (this.getLinearVelocity($Stack.get$javax$vecmath$Vector3f()).lengthSquared() < this.linearSleepingThreshold * this.linearSleepingThreshold && this.getAngularVelocity($Stack.get$javax$vecmath$Vector3f()).lengthSquared() < this.angularSleepingThreshold * this.angularSleepingThreshold) {
                void timeStep;
                this.deactivationTime += timeStep;
            } else {
                this.deactivationTime = 0.0f;
                this.setActivationState(0);
            }
            $Stack.pop$javax$vecmath$Vector3f();
            return;
        }
        catch (Throwable throwable) {
            $Stack.pop$javax$vecmath$Vector3f();
            throw throwable;
        }
    }

    public boolean wantsSleeping() {
        if (this.getActivationState() == 4) {
            return false;
        }
        if (BulletGlobals.isDeactivationDisabled() || BulletGlobals.getDeactivationTime() == 0.0f) {
            return false;
        }
        if (this.getActivationState() == 2 || this.getActivationState() == 3) {
            return true;
        }
        return this.deactivationTime > BulletGlobals.getDeactivationTime();
    }

    public BroadphaseProxy getBroadphaseProxy() {
        return this.broadphaseHandle;
    }

    public void setNewBroadphaseProxy(BroadphaseProxy broadphaseProxy) {
        this.broadphaseHandle = broadphaseProxy;
    }

    public MotionState getMotionState() {
        return this.optionalMotionState;
    }

    public void setMotionState(MotionState motionState) {
        this.optionalMotionState = motionState;
        if (this.optionalMotionState != null) {
            motionState.getWorldTransform(this.worldTransform);
        }
    }

    public void setAngularFactor(float angFac) {
        this.angularFactor = angFac;
    }

    public float getAngularFactor() {
        return this.angularFactor;
    }

    public boolean isInWorld() {
        return this.getBroadphaseProxy() != null;
    }

    @Override
    public boolean checkCollideWithOverride(CollisionObject co) {
        RigidBody otherRb = RigidBody.upcast(co);
        if (otherRb == null) {
            return true;
        }
        for (int i = 0; i < this.constraintRefs.size(); ++i) {
            TypedConstraint c = this.constraintRefs.getQuick(i);
            if (c.getRigidBodyA() != otherRb && c.getRigidBodyB() != otherRb) continue;
            return false;
        }
        return true;
    }

    public void addConstraintRef(TypedConstraint c) {
        int index = this.constraintRefs.indexOf(c);
        if (index == -1) {
            this.constraintRefs.add(c);
        }
        this.checkCollideWith = true;
    }

    public void removeConstraintRef(TypedConstraint c) {
        this.constraintRefs.remove(c);
        this.checkCollideWith = this.constraintRefs.size() > 0;
    }

    public TypedConstraint getConstraintRef(int index) {
        return this.constraintRefs.getQuick(index);
    }

    public int getNumConstraintRefs() {
        return this.constraintRefs.size();
    }
}

