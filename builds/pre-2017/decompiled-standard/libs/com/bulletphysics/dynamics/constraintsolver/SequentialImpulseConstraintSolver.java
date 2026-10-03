/*
 * Decompiled with CFR 0.152.
 */
package com.bulletphysics.dynamics.constraintsolver;

import com.bulletphysics.$Stack;
import com.bulletphysics.BulletGlobals;
import com.bulletphysics.BulletStats;
import com.bulletphysics.ContactDestroyedCallback;
import com.bulletphysics.collision.broadphase.Dispatcher;
import com.bulletphysics.collision.dispatch.CollisionObject;
import com.bulletphysics.collision.narrowphase.ManifoldPoint;
import com.bulletphysics.collision.narrowphase.PersistentManifold;
import com.bulletphysics.dynamics.RigidBody;
import com.bulletphysics.dynamics.constraintsolver.ConstraintPersistentData;
import com.bulletphysics.dynamics.constraintsolver.ConstraintSolver;
import com.bulletphysics.dynamics.constraintsolver.ContactConstraint;
import com.bulletphysics.dynamics.constraintsolver.ContactConstraintEnum;
import com.bulletphysics.dynamics.constraintsolver.ContactSolverFunc;
import com.bulletphysics.dynamics.constraintsolver.ContactSolverInfo;
import com.bulletphysics.dynamics.constraintsolver.JacobianEntry;
import com.bulletphysics.dynamics.constraintsolver.SolverBody;
import com.bulletphysics.dynamics.constraintsolver.SolverConstraint;
import com.bulletphysics.dynamics.constraintsolver.SolverConstraintType;
import com.bulletphysics.dynamics.constraintsolver.TypedConstraint;
import com.bulletphysics.linearmath.IDebugDraw;
import com.bulletphysics.linearmath.MiscUtil;
import com.bulletphysics.linearmath.Transform;
import com.bulletphysics.linearmath.TransformUtil;
import com.bulletphysics.util.IntArrayList;
import com.bulletphysics.util.ObjectArrayList;
import com.bulletphysics.util.ObjectPool;
import javax.vecmath.Matrix3f;
import javax.vecmath.Tuple3f;
import javax.vecmath.Vector3f;

public class SequentialImpulseConstraintSolver
extends ConstraintSolver {
    private static final int MAX_CONTACT_SOLVER_TYPES = ContactConstraintEnum.MAX_CONTACT_SOLVER_TYPES.ordinal();
    private static final int SEQUENTIAL_IMPULSE_MAX_SOLVER_POINTS = 16384;
    private OrderIndex[] gOrder = new OrderIndex[16384];
    private int totalCpd = 0;
    private final ObjectPool<SolverBody> bodiesPool;
    private final ObjectPool<SolverConstraint> constraintsPool;
    private final ObjectPool<JacobianEntry> jacobiansPool;
    private final ObjectArrayList<SolverBody> tmpSolverBodyPool;
    private final ObjectArrayList<SolverConstraint> tmpSolverConstraintPool;
    private final ObjectArrayList<SolverConstraint> tmpSolverFrictionConstraintPool;
    private final IntArrayList orderTmpConstraintPool;
    private final IntArrayList orderFrictionConstraintPool;
    protected final ContactSolverFunc[][] contactDispatch;
    protected final ContactSolverFunc[][] frictionDispatch;
    protected long btSeed2;

    public SequentialImpulseConstraintSolver() {
        int i;
        for (i = 0; i < this.gOrder.length; ++i) {
            this.gOrder[i] = new OrderIndex();
        }
        this.bodiesPool = ObjectPool.get(SolverBody.class);
        this.constraintsPool = ObjectPool.get(SolverConstraint.class);
        this.jacobiansPool = ObjectPool.get(JacobianEntry.class);
        this.tmpSolverBodyPool = new ObjectArrayList();
        this.tmpSolverConstraintPool = new ObjectArrayList();
        this.tmpSolverFrictionConstraintPool = new ObjectArrayList();
        this.orderTmpConstraintPool = new IntArrayList();
        this.orderFrictionConstraintPool = new IntArrayList();
        this.contactDispatch = new ContactSolverFunc[MAX_CONTACT_SOLVER_TYPES][MAX_CONTACT_SOLVER_TYPES];
        this.frictionDispatch = new ContactSolverFunc[MAX_CONTACT_SOLVER_TYPES][MAX_CONTACT_SOLVER_TYPES];
        this.btSeed2 = 0L;
        BulletGlobals.setContactDestroyedCallback(new ContactDestroyedCallback(){

            @Override
            public boolean contactDestroyed(Object userPersistentData) {
                assert (userPersistentData != null);
                ConstraintPersistentData cpd = (ConstraintPersistentData)userPersistentData;
                SequentialImpulseConstraintSolver.this.totalCpd--;
                return true;
            }
        });
        for (i = 0; i < MAX_CONTACT_SOLVER_TYPES; ++i) {
            for (int j = 0; j < MAX_CONTACT_SOLVER_TYPES; ++j) {
                this.contactDispatch[i][j] = ContactConstraint.resolveSingleCollision;
                this.frictionDispatch[i][j] = ContactConstraint.resolveSingleFriction;
            }
        }
    }

    public long rand2() {
        this.btSeed2 = 1664525L * this.btSeed2 + 1013904223L & 0xFFFFFFFFFFFFFFFFL;
        return this.btSeed2;
    }

    public int randInt2(int n) {
        long un = n;
        long r = this.rand2();
        if (un <= 65536L) {
            r ^= r >>> 16;
            if (un <= 256L) {
                r ^= r >>> 8;
                if (un <= 16L) {
                    r ^= r >>> 4;
                    if (un <= 4L) {
                        r ^= r >>> 2;
                        if (un <= 2L) {
                            r ^= r >>> 1;
                        }
                    }
                }
            }
        }
        return (int)Math.abs(r % un);
    }

    /*
     * WARNING - void declaration
     */
    private void initSolverBody(SolverBody solverBody, CollisionObject collisionObject) {
        $Stack $Stack = $Stack.get();
        try {
            void solverBody2;
            void collisionObject2;
            $Stack.push$com$bulletphysics$linearmath$Transform();
            RigidBody rb = RigidBody.upcast((CollisionObject)collisionObject2);
            if (rb != null) {
                rb.getAngularVelocity(solverBody2.angularVelocity);
                solverBody2.centerOfMassPosition.set(collisionObject2.getWorldTransform((Transform)$Stack.get$com$bulletphysics$linearmath$Transform()).origin);
                solverBody2.friction = collisionObject2.getFriction();
                solverBody2.invMass = rb.getInvMass();
                rb.getLinearVelocity(solverBody2.linearVelocity);
                solverBody2.originalBody = rb;
                solverBody2.angularFactor = rb.getAngularFactor();
            } else {
                solverBody2.angularVelocity.set(0.0f, 0.0f, 0.0f);
                solverBody2.centerOfMassPosition.set(collisionObject2.getWorldTransform((Transform)$Stack.get$com$bulletphysics$linearmath$Transform()).origin);
                solverBody2.friction = collisionObject2.getFriction();
                solverBody2.invMass = 0.0f;
                solverBody2.linearVelocity.set(0.0f, 0.0f, 0.0f);
                solverBody2.originalBody = null;
                solverBody2.angularFactor = 1.0f;
            }
            solverBody2.pushVelocity.set(0.0f, 0.0f, 0.0f);
            solverBody2.turnVelocity.set(0.0f, 0.0f, 0.0f);
            $Stack.pop$com$bulletphysics$linearmath$Transform();
            return;
        }
        catch (Throwable throwable) {
            $Stack.pop$com$bulletphysics$linearmath$Transform();
            throw throwable;
        }
    }

    private float restitutionCurve(float rel_vel, float restitution) {
        float rest = restitution * -rel_vel;
        return rest;
    }

    /*
     * WARNING - void declaration
     */
    private void resolveSplitPenetrationImpulseCacheFriendly(SolverBody solverBody, SolverBody solverBody2, SolverConstraint solverConstraint, ContactSolverInfo contactSolverInfo) {
        $Stack $Stack = $Stack.get();
        try {
            void solverInfo;
            void contactConstraint;
            $Stack.push$javax$vecmath$Vector3f();
            if (contactConstraint.penetration < solverInfo.splitImpulsePenetrationThreshold) {
                void body2;
                float vel2Dotn;
                void body1;
                ++BulletStats.gNumSplitImpulseRecoveries;
                float oldNormalImpulse = contactConstraint.appliedPushImpulse;
                float positionalError = -contactConstraint.penetration * solverInfo.erp2 / solverInfo.timeStep;
                float penetrationImpulse = positionalError * contactConstraint.jacDiagABInv;
                float vel1Dotn = contactConstraint.contactNormal.dot(body1.pushVelocity) + contactConstraint.relpos1CrossNormal.dot(body1.turnVelocity);
                float rel_vel = vel1Dotn - (vel2Dotn = contactConstraint.contactNormal.dot(body2.pushVelocity) + contactConstraint.relpos2CrossNormal.dot(body2.turnVelocity));
                float velocityError = contactConstraint.restitution - rel_vel;
                float velocityImpulse = velocityError * contactConstraint.jacDiagABInv;
                float normalImpulse = penetrationImpulse + velocityImpulse;
                float sum = oldNormalImpulse + normalImpulse;
                contactConstraint.appliedPushImpulse = 0.0f > sum ? 0.0f : sum;
                normalImpulse = contactConstraint.appliedPushImpulse - oldNormalImpulse;
                Vector3f tmp = $Stack.get$javax$vecmath$Vector3f();
                tmp.scale(body1.invMass, contactConstraint.contactNormal);
                body1.internalApplyPushImpulse(tmp, contactConstraint.angularComponentA, normalImpulse);
                tmp.scale(body2.invMass, contactConstraint.contactNormal);
                body2.internalApplyPushImpulse(tmp, contactConstraint.angularComponentB, -normalImpulse);
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
    private float resolveSingleCollisionCombinedCacheFriendly(SolverBody solverBody, SolverBody solverBody2, SolverConstraint solverConstraint, ContactSolverInfo contactSolverInfo) {
        $Stack $Stack = $Stack.get();
        try {
            float velocityError;
            float velocityImpulse;
            float penetrationImpulse;
            float normalImpulse;
            float oldNormalImpulse;
            float sum;
            void solverInfo;
            void body2;
            void body1;
            void contactConstraint;
            $Stack.push$javax$vecmath$Vector3f();
            float vel1Dotn = contactConstraint.contactNormal.dot(body1.linearVelocity) + contactConstraint.relpos1CrossNormal.dot(body1.angularVelocity);
            float vel2Dotn = contactConstraint.contactNormal.dot(body2.linearVelocity) + contactConstraint.relpos2CrossNormal.dot(body2.angularVelocity);
            float rel_vel = vel1Dotn - vel2Dotn;
            float positionalError = 0.0f;
            if (!solverInfo.splitImpulse || contactConstraint.penetration > solverInfo.splitImpulsePenetrationThreshold) {
                positionalError = -contactConstraint.penetration * solverInfo.erp / solverInfo.timeStep;
            }
            contactConstraint.appliedImpulse = 0.0f > (sum = (oldNormalImpulse = contactConstraint.appliedImpulse) + (normalImpulse = (penetrationImpulse = positionalError * contactConstraint.jacDiagABInv) + (velocityImpulse = (velocityError = contactConstraint.restitution - rel_vel) * contactConstraint.jacDiagABInv))) ? 0.0f : sum;
            normalImpulse = contactConstraint.appliedImpulse - oldNormalImpulse;
            Vector3f tmp = $Stack.get$javax$vecmath$Vector3f();
            tmp.scale(body1.invMass, contactConstraint.contactNormal);
            body1.internalApplyImpulse(tmp, contactConstraint.angularComponentA, normalImpulse);
            tmp.scale(body2.invMass, contactConstraint.contactNormal);
            body2.internalApplyImpulse(tmp, contactConstraint.angularComponentB, -normalImpulse);
            $Stack.pop$javax$vecmath$Vector3f();
            return normalImpulse;
        }
        catch (Throwable throwable) {
            $Stack.pop$javax$vecmath$Vector3f();
            throw throwable;
        }
    }

    /*
     * WARNING - void declaration
     */
    private float resolveSingleFrictionCacheFriendly(SolverBody solverBody, SolverBody solverBody2, SolverConstraint solverConstraint, ContactSolverInfo contactSolverInfo, float f) {
        $Stack $Stack = $Stack.get();
        try {
            void appliedNormalImpulse;
            void contactConstraint;
            $Stack.push$javax$vecmath$Vector3f();
            float combinedFriction = contactConstraint.friction;
            void limit = appliedNormalImpulse * combinedFriction;
            if (appliedNormalImpulse > 0.0f) {
                void body2;
                void body1;
                float vel1Dotn = contactConstraint.contactNormal.dot(body1.linearVelocity) + contactConstraint.relpos1CrossNormal.dot(body1.angularVelocity);
                float vel2Dotn = contactConstraint.contactNormal.dot(body2.linearVelocity) + contactConstraint.relpos2CrossNormal.dot(body2.angularVelocity);
                float rel_vel = vel1Dotn - vel2Dotn;
                float j1 = -rel_vel * contactConstraint.jacDiagABInv;
                float oldTangentImpulse = contactConstraint.appliedImpulse;
                contactConstraint.appliedImpulse = oldTangentImpulse + j1;
                if (limit < contactConstraint.appliedImpulse) {
                    contactConstraint.appliedImpulse = limit;
                } else if (contactConstraint.appliedImpulse < -limit) {
                    contactConstraint.appliedImpulse = -limit;
                }
                j1 = contactConstraint.appliedImpulse - oldTangentImpulse;
                Vector3f tmp = $Stack.get$javax$vecmath$Vector3f();
                tmp.scale(body1.invMass, contactConstraint.contactNormal);
                body1.internalApplyImpulse(tmp, contactConstraint.angularComponentA, j1);
                tmp.scale(body2.invMass, contactConstraint.contactNormal);
                body2.internalApplyImpulse(tmp, contactConstraint.angularComponentB, -j1);
            }
            $Stack.pop$javax$vecmath$Vector3f();
            return 0.0f;
        }
        catch (Throwable throwable) {
            $Stack.pop$javax$vecmath$Vector3f();
            throw throwable;
        }
    }

    /*
     * WARNING - void declaration
     */
    protected void addFrictionConstraint(Vector3f vector3f, int n, int n2, int n3, ManifoldPoint manifoldPoint, Vector3f vector3f2, Vector3f vector3f3, CollisionObject collisionObject, CollisionObject collisionObject2, float f) {
        $Stack $Stack = $Stack.get();
        try {
            void relaxation;
            void rel_pos2;
            void rel_pos1;
            void cp;
            void frictionIndex;
            void solverBodyIdB;
            void solverBodyIdA;
            void normalAxis;
            void colObj1;
            void colObj0;
            $Stack $Stack2 = $Stack;
            $Stack2.push$javax$vecmath$Vector3f();
            $Stack2.push$javax$vecmath$Matrix3f();
            RigidBody body0 = RigidBody.upcast((CollisionObject)colObj0);
            RigidBody body1 = RigidBody.upcast((CollisionObject)colObj1);
            SolverConstraint solverConstraint = this.constraintsPool.get();
            this.tmpSolverFrictionConstraintPool.add(solverConstraint);
            solverConstraint.contactNormal.set((Tuple3f)normalAxis);
            solverConstraint.solverBodyIdA = solverBodyIdA;
            solverConstraint.solverBodyIdB = solverBodyIdB;
            solverConstraint.constraintType = SolverConstraintType.SOLVER_FRICTION_1D;
            solverConstraint.frictionIndex = frictionIndex;
            solverConstraint.friction = cp.combinedFriction;
            solverConstraint.originalContactPoint = null;
            solverConstraint.appliedImpulse = 0.0f;
            solverConstraint.appliedPushImpulse = 0.0f;
            solverConstraint.penetration = 0.0f;
            Vector3f ftorqueAxis1 = $Stack.get$javax$vecmath$Vector3f();
            Matrix3f tmpMat = $Stack.get$javax$vecmath$Matrix3f();
            ftorqueAxis1.cross((Vector3f)rel_pos1, solverConstraint.contactNormal);
            solverConstraint.relpos1CrossNormal.set(ftorqueAxis1);
            if (body0 != null) {
                solverConstraint.angularComponentA.set(ftorqueAxis1);
                body0.getInvInertiaTensorWorld(tmpMat).transform(solverConstraint.angularComponentA);
            } else {
                solverConstraint.angularComponentA.set(0.0f, 0.0f, 0.0f);
            }
            ftorqueAxis1.cross((Vector3f)rel_pos2, solverConstraint.contactNormal);
            solverConstraint.relpos2CrossNormal.set(ftorqueAxis1);
            if (body1 != null) {
                solverConstraint.angularComponentB.set(ftorqueAxis1);
                body1.getInvInertiaTensorWorld(tmpMat).transform(solverConstraint.angularComponentB);
            } else {
                solverConstraint.angularComponentB.set(0.0f, 0.0f, 0.0f);
            }
            Vector3f vec = $Stack.get$javax$vecmath$Vector3f();
            float denom0 = 0.0f;
            float denom1 = 0.0f;
            if (body0 != null) {
                vec.cross(solverConstraint.angularComponentA, (Vector3f)rel_pos1);
                denom0 = body0.getInvMass() + normalAxis.dot(vec);
            }
            if (body1 != null) {
                vec.cross(solverConstraint.angularComponentB, (Vector3f)rel_pos2);
                denom1 = body1.getInvMass() + normalAxis.dot(vec);
            }
            void denom = relaxation / (denom0 + denom1);
            solverConstraint.jacDiagABInv = denom;
            $Stack $Stack3 = $Stack;
            $Stack3.pop$javax$vecmath$Vector3f();
            $Stack3.pop$javax$vecmath$Matrix3f();
            return;
        }
        catch (Throwable throwable) {
            $Stack $Stack4 = $Stack;
            $Stack4.pop$javax$vecmath$Vector3f();
            $Stack4.pop$javax$vecmath$Matrix3f();
            throw throwable;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     * WARNING - void declaration
     */
    public float solveGroupCacheFriendlySetup(ObjectArrayList<CollisionObject> objectArrayList, int n, ObjectArrayList<PersistentManifold> objectArrayList2, int n2, int n3, ObjectArrayList<TypedConstraint> objectArrayList3, int n4, int n5, ContactSolverInfo contactSolverInfo, IDebugDraw iDebugDraw) {
        $Stack $Stack = $Stack.get();
        try {
            int i;
            int numManifolds;
            int numConstraints;
            $Stack $Stack2 = $Stack;
            $Stack2.push$com$bulletphysics$linearmath$Transform();
            $Stack2.push$javax$vecmath$Vector3f();
            $Stack2.push$javax$vecmath$Matrix3f();
            BulletStats.pushProfile("solveGroupCacheFriendlySetup");
            if (numConstraints + numManifolds == false) {
                float f = 0.0f;
                $Stack $Stack3 = $Stack;
                $Stack3.pop$com$bulletphysics$linearmath$Transform();
                $Stack3.pop$javax$vecmath$Vector3f();
                $Stack3.pop$javax$vecmath$Matrix3f();
                return f;
            }
            PersistentManifold manifold = null;
            CollisionObject colObj0 = null;
            CollisionObject colObj1 = null;
            Transform tmpTrans = $Stack.get$com$bulletphysics$linearmath$Transform();
            Vector3f rel_pos1 = $Stack.get$javax$vecmath$Vector3f();
            Vector3f rel_pos2 = $Stack.get$javax$vecmath$Vector3f();
            Vector3f pos1 = $Stack.get$javax$vecmath$Vector3f();
            Vector3f pos2 = $Stack.get$javax$vecmath$Vector3f();
            Vector3f vel = $Stack.get$javax$vecmath$Vector3f();
            Vector3f torqueAxis0 = $Stack.get$javax$vecmath$Vector3f();
            Vector3f torqueAxis1 = $Stack.get$javax$vecmath$Vector3f();
            Vector3f vel1 = $Stack.get$javax$vecmath$Vector3f();
            Vector3f vel2 = $Stack.get$javax$vecmath$Vector3f();
            Vector3f frictionDir1 = $Stack.get$javax$vecmath$Vector3f();
            Vector3f frictionDir2 = $Stack.get$javax$vecmath$Vector3f();
            Vector3f vec = $Stack.get$javax$vecmath$Vector3f();
            Matrix3f tmpMat = $Stack.get$javax$vecmath$Matrix3f();
            for (int i2 = 0; i2 < numManifolds; ++i2) {
                void manifold_offset;
                void manifoldPtr;
                manifold = (PersistentManifold)manifoldPtr.getQuick((int)(manifold_offset + i2));
                colObj0 = (CollisionObject)manifold.getBody0();
                colObj1 = (CollisionObject)manifold.getBody1();
                int solverBodyIdA = -1;
                int solverBodyIdB = -1;
                if (manifold.getNumContacts() != 0) {
                    SolverBody solverBody;
                    if (colObj0.getIslandTag() >= 0) {
                        if (colObj0.getCompanionId() >= 0) {
                            solverBodyIdA = colObj0.getCompanionId();
                        } else {
                            solverBodyIdA = this.tmpSolverBodyPool.size();
                            solverBody = this.bodiesPool.get();
                            this.tmpSolverBodyPool.add(solverBody);
                            this.initSolverBody(solverBody, colObj0);
                            colObj0.setCompanionId(solverBodyIdA);
                        }
                    } else {
                        solverBodyIdA = this.tmpSolverBodyPool.size();
                        solverBody = this.bodiesPool.get();
                        this.tmpSolverBodyPool.add(solverBody);
                        this.initSolverBody(solverBody, colObj0);
                    }
                    if (colObj1.getIslandTag() >= 0) {
                        if (colObj1.getCompanionId() >= 0) {
                            solverBodyIdB = colObj1.getCompanionId();
                        } else {
                            solverBodyIdB = this.tmpSolverBodyPool.size();
                            solverBody = this.bodiesPool.get();
                            this.tmpSolverBodyPool.add(solverBody);
                            this.initSolverBody(solverBody, colObj1);
                            colObj1.setCompanionId(solverBodyIdB);
                        }
                    } else {
                        solverBodyIdB = this.tmpSolverBodyPool.size();
                        solverBody = this.bodiesPool.get();
                        this.tmpSolverBodyPool.add(solverBody);
                        this.initSolverBody(solverBody, colObj1);
                    }
                }
                for (int j = 0; j < manifold.getNumContacts(); ++j) {
                    float penVel;
                    void infoGlobal;
                    float denom;
                    ManifoldPoint cp = manifold.getContactPoint(j);
                    if (!(cp.getDistance() <= 0.0f)) continue;
                    cp.getPositionWorldOnA(pos1);
                    cp.getPositionWorldOnB(pos2);
                    rel_pos1.sub(pos1, colObj0.getWorldTransform((Transform)tmpTrans).origin);
                    rel_pos2.sub(pos2, colObj1.getWorldTransform((Transform)tmpTrans).origin);
                    float relaxation = 1.0f;
                    int frictionIndex = this.tmpSolverConstraintPool.size();
                    SolverConstraint solverConstraint = this.constraintsPool.get();
                    this.tmpSolverConstraintPool.add(solverConstraint);
                    RigidBody rb0 = RigidBody.upcast(colObj0);
                    RigidBody rb1 = RigidBody.upcast(colObj1);
                    solverConstraint.solverBodyIdA = solverBodyIdA;
                    solverConstraint.solverBodyIdB = solverBodyIdB;
                    solverConstraint.constraintType = SolverConstraintType.SOLVER_CONTACT_1D;
                    solverConstraint.originalContactPoint = cp;
                    torqueAxis0.cross(rel_pos1, cp.normalWorldOnB);
                    if (rb0 != null) {
                        solverConstraint.angularComponentA.set(torqueAxis0);
                        rb0.getInvInertiaTensorWorld(tmpMat).transform(solverConstraint.angularComponentA);
                    } else {
                        solverConstraint.angularComponentA.set(0.0f, 0.0f, 0.0f);
                    }
                    torqueAxis1.cross(rel_pos2, cp.normalWorldOnB);
                    if (rb1 != null) {
                        solverConstraint.angularComponentB.set(torqueAxis1);
                        rb1.getInvInertiaTensorWorld(tmpMat).transform(solverConstraint.angularComponentB);
                    } else {
                        solverConstraint.angularComponentB.set(0.0f, 0.0f, 0.0f);
                    }
                    float denom0 = 0.0f;
                    float denom1 = 0.0f;
                    if (rb0 != null) {
                        vec.cross(solverConstraint.angularComponentA, rel_pos1);
                        denom0 = rb0.getInvMass() + cp.normalWorldOnB.dot(vec);
                    }
                    if (rb1 != null) {
                        vec.cross(solverConstraint.angularComponentB, rel_pos2);
                        denom1 = rb1.getInvMass() + cp.normalWorldOnB.dot(vec);
                    }
                    solverConstraint.jacDiagABInv = denom = relaxation / (denom0 + denom1);
                    solverConstraint.contactNormal.set(cp.normalWorldOnB);
                    solverConstraint.relpos1CrossNormal.cross(rel_pos1, cp.normalWorldOnB);
                    solverConstraint.relpos2CrossNormal.cross(rel_pos2, cp.normalWorldOnB);
                    if (rb0 != null) {
                        rb0.getVelocityInLocalPoint(rel_pos1, vel1);
                    } else {
                        vel1.set(0.0f, 0.0f, 0.0f);
                    }
                    if (rb1 != null) {
                        rb1.getVelocityInLocalPoint(rel_pos2, vel2);
                    } else {
                        vel2.set(0.0f, 0.0f, 0.0f);
                    }
                    vel.sub(vel1, vel2);
                    float rel_vel = cp.normalWorldOnB.dot(vel);
                    solverConstraint.penetration = Math.min(cp.getDistance() + infoGlobal.linearSlop, 0.0f);
                    solverConstraint.friction = cp.combinedFriction;
                    solverConstraint.restitution = this.restitutionCurve(rel_vel, cp.combinedRestitution);
                    if (solverConstraint.restitution <= 0.0f) {
                        solverConstraint.restitution = 0.0f;
                    }
                    if (solverConstraint.restitution > (penVel = -solverConstraint.penetration / infoGlobal.timeStep)) {
                        solverConstraint.penetration = 0.0f;
                    }
                    Vector3f tmp = $Stack.get$javax$vecmath$Vector3f();
                    if ((infoGlobal.solverMode & 4) != 0) {
                        solverConstraint.appliedImpulse = cp.appliedImpulse * infoGlobal.warmstartingFactor;
                        if (rb0 != null) {
                            tmp.scale(rb0.getInvMass(), solverConstraint.contactNormal);
                            this.tmpSolverBodyPool.getQuick(solverConstraint.solverBodyIdA).internalApplyImpulse(tmp, solverConstraint.angularComponentA, solverConstraint.appliedImpulse);
                        }
                        if (rb1 != null) {
                            tmp.scale(rb1.getInvMass(), solverConstraint.contactNormal);
                            this.tmpSolverBodyPool.getQuick(solverConstraint.solverBodyIdB).internalApplyImpulse(tmp, solverConstraint.angularComponentB, -solverConstraint.appliedImpulse);
                        }
                    } else {
                        solverConstraint.appliedImpulse = 0.0f;
                    }
                    solverConstraint.appliedPushImpulse = 0.0f;
                    solverConstraint.frictionIndex = this.tmpSolverFrictionConstraintPool.size();
                    if (!cp.lateralFrictionInitialized) {
                        cp.lateralFrictionDir1.scale(rel_vel, cp.normalWorldOnB);
                        cp.lateralFrictionDir1.sub(vel, cp.lateralFrictionDir1);
                        float lat_rel_vel = cp.lateralFrictionDir1.lengthSquared();
                        if (lat_rel_vel > 1.1920929E-7f) {
                            cp.lateralFrictionDir1.scale(1.0f / (float)Math.sqrt(lat_rel_vel));
                            this.addFrictionConstraint(cp.lateralFrictionDir1, solverBodyIdA, solverBodyIdB, frictionIndex, cp, rel_pos1, rel_pos2, colObj0, colObj1, relaxation);
                            cp.lateralFrictionDir2.cross(cp.lateralFrictionDir1, cp.normalWorldOnB);
                            cp.lateralFrictionDir2.normalize();
                            this.addFrictionConstraint(cp.lateralFrictionDir2, solverBodyIdA, solverBodyIdB, frictionIndex, cp, rel_pos1, rel_pos2, colObj0, colObj1, relaxation);
                        } else {
                            TransformUtil.planeSpace1(cp.normalWorldOnB, cp.lateralFrictionDir1, cp.lateralFrictionDir2);
                            this.addFrictionConstraint(cp.lateralFrictionDir1, solverBodyIdA, solverBodyIdB, frictionIndex, cp, rel_pos1, rel_pos2, colObj0, colObj1, relaxation);
                            this.addFrictionConstraint(cp.lateralFrictionDir2, solverBodyIdA, solverBodyIdB, frictionIndex, cp, rel_pos1, rel_pos2, colObj0, colObj1, relaxation);
                        }
                        cp.lateralFrictionInitialized = true;
                    } else {
                        this.addFrictionConstraint(cp.lateralFrictionDir1, solverBodyIdA, solverBodyIdB, frictionIndex, cp, rel_pos1, rel_pos2, colObj0, colObj1, relaxation);
                        this.addFrictionConstraint(cp.lateralFrictionDir2, solverBodyIdA, solverBodyIdB, frictionIndex, cp, rel_pos1, rel_pos2, colObj0, colObj1, relaxation);
                    }
                    SolverConstraint frictionConstraint1 = this.tmpSolverFrictionConstraintPool.getQuick(solverConstraint.frictionIndex);
                    if ((infoGlobal.solverMode & 4) != 0) {
                        frictionConstraint1.appliedImpulse = cp.appliedImpulseLateral1 * infoGlobal.warmstartingFactor;
                        if (rb0 != null) {
                            tmp.scale(rb0.getInvMass(), frictionConstraint1.contactNormal);
                            this.tmpSolverBodyPool.getQuick(solverConstraint.solverBodyIdA).internalApplyImpulse(tmp, frictionConstraint1.angularComponentA, frictionConstraint1.appliedImpulse);
                        }
                        if (rb1 != null) {
                            tmp.scale(rb1.getInvMass(), frictionConstraint1.contactNormal);
                            this.tmpSolverBodyPool.getQuick(solverConstraint.solverBodyIdB).internalApplyImpulse(tmp, frictionConstraint1.angularComponentB, -frictionConstraint1.appliedImpulse);
                        }
                    } else {
                        frictionConstraint1.appliedImpulse = 0.0f;
                    }
                    SolverConstraint frictionConstraint2 = this.tmpSolverFrictionConstraintPool.getQuick(solverConstraint.frictionIndex + 1);
                    if ((infoGlobal.solverMode & 4) != 0) {
                        frictionConstraint2.appliedImpulse = cp.appliedImpulseLateral2 * infoGlobal.warmstartingFactor;
                        if (rb0 != null) {
                            tmp.scale(rb0.getInvMass(), frictionConstraint2.contactNormal);
                            this.tmpSolverBodyPool.getQuick(solverConstraint.solverBodyIdA).internalApplyImpulse(tmp, frictionConstraint2.angularComponentA, frictionConstraint2.appliedImpulse);
                        }
                        if (rb1 == null) continue;
                        tmp.scale(rb1.getInvMass(), frictionConstraint2.contactNormal);
                        this.tmpSolverBodyPool.getQuick(solverConstraint.solverBodyIdB).internalApplyImpulse(tmp, frictionConstraint2.angularComponentB, -frictionConstraint2.appliedImpulse);
                        continue;
                    }
                    frictionConstraint2.appliedImpulse = 0.0f;
                }
            }
            for (int j = 0; j < numConstraints; ++j) {
                void constraints_offset;
                void constraints;
                TypedConstraint constraint = (TypedConstraint)constraints.getQuick((int)(constraints_offset + j));
                constraint.buildJacobian();
            }
            int numConstraintPool = this.tmpSolverConstraintPool.size();
            int numFrictionPool = this.tmpSolverFrictionConstraintPool.size();
            MiscUtil.resize(this.orderTmpConstraintPool, numConstraintPool, 0);
            MiscUtil.resize(this.orderFrictionConstraintPool, numFrictionPool, 0);
            for (i = 0; i < numConstraintPool; ++i) {
                this.orderTmpConstraintPool.set(i, i);
            }
            for (i = 0; i < numFrictionPool; ++i) {
                this.orderFrictionConstraintPool.set(i, i);
            }
            float f = 0.0f;
            $Stack $Stack4 = $Stack;
            $Stack4.pop$com$bulletphysics$linearmath$Transform();
            $Stack4.pop$javax$vecmath$Vector3f();
            $Stack4.pop$javax$vecmath$Matrix3f();
            return f;
            finally {
                BulletStats.popProfile();
            }
        }
        catch (Throwable throwable) {
            $Stack $Stack5 = $Stack;
            $Stack5.pop$com$bulletphysics$linearmath$Transform();
            $Stack5.pop$javax$vecmath$Vector3f();
            $Stack5.pop$javax$vecmath$Matrix3f();
            throw throwable;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public float solveGroupCacheFriendlyIterations(ObjectArrayList<CollisionObject> bodies, int numBodies, ObjectArrayList<PersistentManifold> manifoldPtr, int manifold_offset, int numManifolds, ObjectArrayList<TypedConstraint> constraints, int constraints_offset, int numConstraints, ContactSolverInfo infoGlobal, IDebugDraw debugDrawer) {
        BulletStats.pushProfile("solveGroupCacheFriendlyIterations");
        try {
            int iteration;
            int numConstraintPool = this.tmpSolverConstraintPool.size();
            int numFrictionPool = this.tmpSolverFrictionConstraintPool.size();
            for (iteration = 0; iteration < infoGlobal.numIterations; ++iteration) {
                int j;
                if ((infoGlobal.solverMode & 1) != 0 && (iteration & 7) == 0) {
                    int swapi;
                    int tmp;
                    for (j = 0; j < numConstraintPool; ++j) {
                        tmp = this.orderTmpConstraintPool.get(j);
                        swapi = this.randInt2(j + 1);
                        this.orderTmpConstraintPool.set(j, this.orderTmpConstraintPool.get(swapi));
                        this.orderTmpConstraintPool.set(swapi, tmp);
                    }
                    for (j = 0; j < numFrictionPool; ++j) {
                        tmp = this.orderFrictionConstraintPool.get(j);
                        swapi = this.randInt2(j + 1);
                        this.orderFrictionConstraintPool.set(j, this.orderFrictionConstraintPool.get(swapi));
                        this.orderFrictionConstraintPool.set(swapi, tmp);
                    }
                }
                for (j = 0; j < numConstraints; ++j) {
                    TypedConstraint constraint = constraints.getQuick(constraints_offset + j);
                    if (constraint.getRigidBodyA().getIslandTag() >= 0 && constraint.getRigidBodyA().getCompanionId() >= 0) {
                        this.tmpSolverBodyPool.getQuick(constraint.getRigidBodyA().getCompanionId()).writebackVelocity();
                    }
                    if (constraint.getRigidBodyB().getIslandTag() >= 0 && constraint.getRigidBodyB().getCompanionId() >= 0) {
                        this.tmpSolverBodyPool.getQuick(constraint.getRigidBodyB().getCompanionId()).writebackVelocity();
                    }
                    constraint.solveConstraint(infoGlobal.timeStep);
                    if (constraint.getRigidBodyA().getIslandTag() >= 0 && constraint.getRigidBodyA().getCompanionId() >= 0) {
                        this.tmpSolverBodyPool.getQuick(constraint.getRigidBodyA().getCompanionId()).readVelocity();
                    }
                    if (constraint.getRigidBodyB().getIslandTag() < 0 || constraint.getRigidBodyB().getCompanionId() < 0) continue;
                    this.tmpSolverBodyPool.getQuick(constraint.getRigidBodyB().getCompanionId()).readVelocity();
                }
                int numPoolConstraints = this.tmpSolverConstraintPool.size();
                for (j = 0; j < numPoolConstraints; ++j) {
                    SolverConstraint solveManifold = this.tmpSolverConstraintPool.getQuick(this.orderTmpConstraintPool.get(j));
                    this.resolveSingleCollisionCombinedCacheFriendly(this.tmpSolverBodyPool.getQuick(solveManifold.solverBodyIdA), this.tmpSolverBodyPool.getQuick(solveManifold.solverBodyIdB), solveManifold, infoGlobal);
                }
                int numFrictionPoolConstraints = this.tmpSolverFrictionConstraintPool.size();
                for (j = 0; j < numFrictionPoolConstraints; ++j) {
                    SolverConstraint solveManifold = this.tmpSolverFrictionConstraintPool.getQuick(this.orderFrictionConstraintPool.get(j));
                    float totalImpulse = this.tmpSolverConstraintPool.getQuick((int)solveManifold.frictionIndex).appliedImpulse + this.tmpSolverConstraintPool.getQuick((int)solveManifold.frictionIndex).appliedPushImpulse;
                    this.resolveSingleFrictionCacheFriendly(this.tmpSolverBodyPool.getQuick(solveManifold.solverBodyIdA), this.tmpSolverBodyPool.getQuick(solveManifold.solverBodyIdB), solveManifold, infoGlobal, totalImpulse);
                }
            }
            if (infoGlobal.splitImpulse) {
                for (iteration = 0; iteration < infoGlobal.numIterations; ++iteration) {
                    int numPoolConstraints = this.tmpSolverConstraintPool.size();
                    for (int j = 0; j < numPoolConstraints; ++j) {
                        SolverConstraint solveManifold = this.tmpSolverConstraintPool.getQuick(this.orderTmpConstraintPool.get(j));
                        this.resolveSplitPenetrationImpulseCacheFriendly(this.tmpSolverBodyPool.getQuick(solveManifold.solverBodyIdA), this.tmpSolverBodyPool.getQuick(solveManifold.solverBodyIdB), solveManifold, infoGlobal);
                    }
                }
            }
            float f = 0.0f;
            return f;
        }
        finally {
            BulletStats.popProfile();
        }
    }

    public float solveGroupCacheFriendly(ObjectArrayList<CollisionObject> bodies, int numBodies, ObjectArrayList<PersistentManifold> manifoldPtr, int manifold_offset, int numManifolds, ObjectArrayList<TypedConstraint> constraints, int constraints_offset, int numConstraints, ContactSolverInfo infoGlobal, IDebugDraw debugDrawer) {
        int i;
        this.solveGroupCacheFriendlySetup(bodies, numBodies, manifoldPtr, manifold_offset, numManifolds, constraints, constraints_offset, numConstraints, infoGlobal, debugDrawer);
        this.solveGroupCacheFriendlyIterations(bodies, numBodies, manifoldPtr, manifold_offset, numManifolds, constraints, constraints_offset, numConstraints, infoGlobal, debugDrawer);
        int numPoolConstraints = this.tmpSolverConstraintPool.size();
        for (int j = 0; j < numPoolConstraints; ++j) {
            SolverConstraint solveManifold = this.tmpSolverConstraintPool.getQuick(j);
            ManifoldPoint pt = (ManifoldPoint)solveManifold.originalContactPoint;
            assert (pt != null);
            pt.appliedImpulse = solveManifold.appliedImpulse;
            pt.appliedImpulseLateral1 = this.tmpSolverFrictionConstraintPool.getQuick((int)solveManifold.frictionIndex).appliedImpulse;
            pt.appliedImpulseLateral1 = this.tmpSolverFrictionConstraintPool.getQuick((int)(solveManifold.frictionIndex + 1)).appliedImpulse;
        }
        if (infoGlobal.splitImpulse) {
            for (i = 0; i < this.tmpSolverBodyPool.size(); ++i) {
                this.tmpSolverBodyPool.getQuick(i).writebackVelocity(infoGlobal.timeStep);
                this.bodiesPool.release(this.tmpSolverBodyPool.getQuick(i));
            }
        } else {
            for (i = 0; i < this.tmpSolverBodyPool.size(); ++i) {
                this.tmpSolverBodyPool.getQuick(i).writebackVelocity();
                this.bodiesPool.release(this.tmpSolverBodyPool.getQuick(i));
            }
        }
        this.tmpSolverBodyPool.clear();
        for (i = 0; i < this.tmpSolverConstraintPool.size(); ++i) {
            this.constraintsPool.release(this.tmpSolverConstraintPool.getQuick(i));
        }
        this.tmpSolverConstraintPool.clear();
        for (i = 0; i < this.tmpSolverFrictionConstraintPool.size(); ++i) {
            this.constraintsPool.release(this.tmpSolverFrictionConstraintPool.getQuick(i));
        }
        this.tmpSolverFrictionConstraintPool.clear();
        return 0.0f;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public float solveGroup(ObjectArrayList<CollisionObject> bodies, int numBodies, ObjectArrayList<PersistentManifold> manifoldPtr, int manifold_offset, int numManifolds, ObjectArrayList<TypedConstraint> constraints, int constraints_offset, int numConstraints, ContactSolverInfo infoGlobal, IDebugDraw debugDrawer, Dispatcher dispatcher) {
        BulletStats.pushProfile("solveGroup");
        try {
            int j;
            if ((infoGlobal.solverMode & 8) != 0) {
                float value;
                assert (bodies != null);
                assert (numBodies != 0);
                float f = value = this.solveGroupCacheFriendly(bodies, numBodies, manifoldPtr, manifold_offset, numManifolds, constraints, constraints_offset, numConstraints, infoGlobal, debugDrawer);
                return f;
            }
            ContactSolverInfo info = new ContactSolverInfo(infoGlobal);
            int numiter = infoGlobal.numIterations;
            int totalPoints = 0;
            for (j = 0; j < numManifolds; j = (int)((short)(j + 1))) {
                PersistentManifold manifold = manifoldPtr.getQuick(manifold_offset + j);
                this.prepareConstraints(manifold, info, debugDrawer);
                for (int p = 0; p < manifoldPtr.getQuick(manifold_offset + j).getNumContacts(); p = (int)((short)(p + 1))) {
                    this.gOrder[totalPoints].manifoldIndex = j;
                    this.gOrder[totalPoints].pointIndex = p;
                    ++totalPoints;
                }
            }
            for (j = 0; j < numConstraints; ++j) {
                TypedConstraint constraint = constraints.getQuick(constraints_offset + j);
                constraint.buildJacobian();
            }
            for (int iteration = 0; iteration < numiter; ++iteration) {
                PersistentManifold manifold;
                int j2;
                if ((infoGlobal.solverMode & 1) != 0 && (iteration & 7) == 0) {
                    for (j2 = 0; j2 < totalPoints; ++j2) {
                        OrderIndex tmp = this.gOrder[j2];
                        int swapi = this.randInt2(j2 + 1);
                        this.gOrder[j2] = this.gOrder[swapi];
                        this.gOrder[swapi] = tmp;
                    }
                }
                for (j2 = 0; j2 < numConstraints; ++j2) {
                    TypedConstraint constraint = constraints.getQuick(constraints_offset + j2);
                    constraint.solveConstraint(info.timeStep);
                }
                for (j2 = 0; j2 < totalPoints; ++j2) {
                    manifold = manifoldPtr.getQuick(manifold_offset + this.gOrder[j2].manifoldIndex);
                    this.solve((RigidBody)manifold.getBody0(), (RigidBody)manifold.getBody1(), manifold.getContactPoint(this.gOrder[j2].pointIndex), info, iteration, debugDrawer);
                }
                for (j2 = 0; j2 < totalPoints; ++j2) {
                    manifold = manifoldPtr.getQuick(manifold_offset + this.gOrder[j2].manifoldIndex);
                    this.solveFriction((RigidBody)manifold.getBody0(), (RigidBody)manifold.getBody1(), manifold.getContactPoint(this.gOrder[j2].pointIndex), info, iteration, debugDrawer);
                }
            }
            float f = 0.0f;
            return f;
        }
        finally {
            BulletStats.popProfile();
        }
    }

    /*
     * WARNING - void declaration
     */
    protected void prepareConstraints(PersistentManifold persistentManifold, ContactSolverInfo contactSolverInfo, IDebugDraw iDebugDraw) {
        $Stack $Stack = $Stack.get();
        try {
            void manifoldPtr;
            $Stack $Stack2 = $Stack;
            $Stack2.push$com$bulletphysics$linearmath$Transform();
            $Stack2.push$javax$vecmath$Vector3f();
            $Stack2.push$javax$vecmath$Matrix3f();
            RigidBody body0 = (RigidBody)manifoldPtr.getBody0();
            RigidBody body1 = (RigidBody)manifoldPtr.getBody1();
            int numpoints = manifoldPtr.getNumContacts();
            BulletStats.gTotalContactPoints += numpoints;
            Vector3f tmpVec = $Stack.get$javax$vecmath$Vector3f();
            Matrix3f tmpMat3 = $Stack.get$javax$vecmath$Matrix3f();
            Vector3f pos1 = $Stack.get$javax$vecmath$Vector3f();
            Vector3f pos2 = $Stack.get$javax$vecmath$Vector3f();
            Vector3f rel_pos1 = $Stack.get$javax$vecmath$Vector3f();
            Vector3f rel_pos2 = $Stack.get$javax$vecmath$Vector3f();
            Vector3f vel1 = $Stack.get$javax$vecmath$Vector3f();
            Vector3f vel2 = $Stack.get$javax$vecmath$Vector3f();
            Vector3f vel = $Stack.get$javax$vecmath$Vector3f();
            Vector3f totalImpulse = $Stack.get$javax$vecmath$Vector3f();
            Vector3f torqueAxis0 = $Stack.get$javax$vecmath$Vector3f();
            Vector3f torqueAxis1 = $Stack.get$javax$vecmath$Vector3f();
            Vector3f ftorqueAxis0 = $Stack.get$javax$vecmath$Vector3f();
            Vector3f ftorqueAxis1 = $Stack.get$javax$vecmath$Vector3f();
            for (int i = 0; i < numpoints; ++i) {
                float denom;
                void info;
                float penVel;
                ManifoldPoint cp = manifoldPtr.getContactPoint(i);
                if (!(cp.getDistance() <= 0.0f)) continue;
                cp.getPositionWorldOnA(pos1);
                cp.getPositionWorldOnB(pos2);
                rel_pos1.sub(pos1, body0.getCenterOfMassPosition(tmpVec));
                rel_pos2.sub(pos2, body1.getCenterOfMassPosition(tmpVec));
                Matrix3f mat1 = body0.getCenterOfMassTransform((Transform)$Stack.get$com$bulletphysics$linearmath$Transform()).basis;
                mat1.transpose();
                Matrix3f mat2 = body1.getCenterOfMassTransform((Transform)$Stack.get$com$bulletphysics$linearmath$Transform()).basis;
                mat2.transpose();
                JacobianEntry jac = this.jacobiansPool.get();
                jac.init(mat1, mat2, rel_pos1, rel_pos2, cp.normalWorldOnB, body0.getInvInertiaDiagLocal($Stack.get$javax$vecmath$Vector3f()), body0.getInvMass(), body1.getInvInertiaDiagLocal($Stack.get$javax$vecmath$Vector3f()), body1.getInvMass());
                float jacDiagAB = jac.getDiagonal();
                this.jacobiansPool.release(jac);
                ConstraintPersistentData cpd = (ConstraintPersistentData)cp.userPersistentData;
                if (cpd != null) {
                    ++cpd.persistentLifeTime;
                    if (cpd.persistentLifeTime != cp.getLifeTime()) {
                        cpd.reset();
                        cpd.persistentLifeTime = cp.getLifeTime();
                    }
                } else {
                    cpd = new ConstraintPersistentData();
                    ++this.totalCpd;
                    cp.userPersistentData = cpd;
                    cpd.persistentLifeTime = cp.getLifeTime();
                }
                assert (cpd != null);
                cpd.jacDiagABInv = 1.0f / jacDiagAB;
                cpd.frictionSolverFunc = this.frictionDispatch[body0.frictionSolverType][body1.frictionSolverType];
                cpd.contactSolverFunc = this.contactDispatch[body0.contactSolverType][body1.contactSolverType];
                body0.getVelocityInLocalPoint(rel_pos1, vel1);
                body1.getVelocityInLocalPoint(rel_pos2, vel2);
                vel.sub(vel1, vel2);
                float rel_vel = cp.normalWorldOnB.dot(vel);
                float combinedRestitution = cp.combinedRestitution;
                cpd.penetration = cp.getDistance();
                cpd.friction = cp.combinedFriction;
                cpd.restitution = this.restitutionCurve(rel_vel, combinedRestitution);
                if (cpd.restitution <= 0.0f) {
                    cpd.restitution = 0.0f;
                }
                if (cpd.restitution > (penVel = -cpd.penetration / info.timeStep)) {
                    cpd.penetration = 0.0f;
                }
                float relaxation = info.damping;
                cpd.appliedImpulse = (info.solverMode & 4) != 0 ? (cpd.appliedImpulse *= relaxation) : 0.0f;
                cpd.prevAppliedImpulse = cpd.appliedImpulse;
                TransformUtil.planeSpace1(cp.normalWorldOnB, cpd.frictionWorldTangential0, cpd.frictionWorldTangential1);
                cpd.accumulatedTangentImpulse0 = 0.0f;
                cpd.accumulatedTangentImpulse1 = 0.0f;
                float denom0 = body0.computeImpulseDenominator(pos1, cpd.frictionWorldTangential0);
                float denom1 = body1.computeImpulseDenominator(pos2, cpd.frictionWorldTangential0);
                cpd.jacDiagABInvTangent0 = denom = relaxation / (denom0 + denom1);
                denom0 = body0.computeImpulseDenominator(pos1, cpd.frictionWorldTangential1);
                denom1 = body1.computeImpulseDenominator(pos2, cpd.frictionWorldTangential1);
                cpd.jacDiagABInvTangent1 = denom = relaxation / (denom0 + denom1);
                totalImpulse.scale(cpd.appliedImpulse, cp.normalWorldOnB);
                torqueAxis0.cross(rel_pos1, cp.normalWorldOnB);
                cpd.angularComponentA.set(torqueAxis0);
                body0.getInvInertiaTensorWorld(tmpMat3).transform(cpd.angularComponentA);
                torqueAxis1.cross(rel_pos2, cp.normalWorldOnB);
                cpd.angularComponentB.set(torqueAxis1);
                body1.getInvInertiaTensorWorld(tmpMat3).transform(cpd.angularComponentB);
                ftorqueAxis0.cross(rel_pos1, cpd.frictionWorldTangential0);
                cpd.frictionAngularComponent0A.set(ftorqueAxis0);
                body0.getInvInertiaTensorWorld(tmpMat3).transform(cpd.frictionAngularComponent0A);
                ftorqueAxis1.cross(rel_pos1, cpd.frictionWorldTangential1);
                cpd.frictionAngularComponent1A.set(ftorqueAxis1);
                body0.getInvInertiaTensorWorld(tmpMat3).transform(cpd.frictionAngularComponent1A);
                ftorqueAxis0.cross(rel_pos2, cpd.frictionWorldTangential0);
                cpd.frictionAngularComponent0B.set(ftorqueAxis0);
                body1.getInvInertiaTensorWorld(tmpMat3).transform(cpd.frictionAngularComponent0B);
                ftorqueAxis1.cross(rel_pos2, cpd.frictionWorldTangential1);
                cpd.frictionAngularComponent1B.set(ftorqueAxis1);
                body1.getInvInertiaTensorWorld(tmpMat3).transform(cpd.frictionAngularComponent1B);
                body0.applyImpulse(totalImpulse, rel_pos1);
                tmpVec.negate(totalImpulse);
                body1.applyImpulse(tmpVec, rel_pos2);
            }
            $Stack $Stack3 = $Stack;
            $Stack3.pop$com$bulletphysics$linearmath$Transform();
            $Stack3.pop$javax$vecmath$Vector3f();
            $Stack3.pop$javax$vecmath$Matrix3f();
            return;
        }
        catch (Throwable throwable) {
            $Stack $Stack4 = $Stack;
            $Stack4.pop$com$bulletphysics$linearmath$Transform();
            $Stack4.pop$javax$vecmath$Vector3f();
            $Stack4.pop$javax$vecmath$Matrix3f();
            throw throwable;
        }
    }

    public float solveCombinedContactFriction(RigidBody body0, RigidBody body1, ManifoldPoint cp, ContactSolverInfo info, int iter, IDebugDraw debugDrawer) {
        float impulse;
        float maxImpulse = 0.0f;
        if (cp.getDistance() <= 0.0f && maxImpulse < (impulse = ContactConstraint.resolveSingleCollisionCombined(body0, body1, cp, info))) {
            maxImpulse = impulse;
        }
        return maxImpulse;
    }

    protected float solve(RigidBody body0, RigidBody body1, ManifoldPoint cp, ContactSolverInfo info, int iter, IDebugDraw debugDrawer) {
        float maxImpulse = 0.0f;
        if (cp.getDistance() <= 0.0f) {
            ConstraintPersistentData cpd = (ConstraintPersistentData)cp.userPersistentData;
            float impulse = cpd.contactSolverFunc.resolveContact(body0, body1, cp, info);
            if (maxImpulse < impulse) {
                maxImpulse = impulse;
            }
        }
        return maxImpulse;
    }

    protected float solveFriction(RigidBody body0, RigidBody body1, ManifoldPoint cp, ContactSolverInfo info, int iter, IDebugDraw debugDrawer) {
        if (cp.getDistance() <= 0.0f) {
            ConstraintPersistentData cpd = (ConstraintPersistentData)cp.userPersistentData;
            cpd.frictionSolverFunc.resolveContact(body0, body1, cp, info);
        }
        return 0.0f;
    }

    @Override
    public void reset() {
        this.btSeed2 = 0L;
    }

    public void setContactSolverFunc(ContactSolverFunc func, int type0, int type1) {
        this.contactDispatch[type0][type1] = func;
    }

    public void setFrictionSolverFunc(ContactSolverFunc func, int type0, int type1) {
        this.frictionDispatch[type0][type1] = func;
    }

    public void setRandSeed(long seed) {
        this.btSeed2 = seed;
    }

    public long getRandSeed() {
        return this.btSeed2;
    }

    private static class OrderIndex {
        public int manifoldIndex;
        public int pointIndex;

        private OrderIndex() {
        }
    }
}

