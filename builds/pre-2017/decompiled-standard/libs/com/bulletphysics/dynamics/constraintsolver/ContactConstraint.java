/*
 * Decompiled with CFR 0.152.
 */
package com.bulletphysics.dynamics.constraintsolver;

import com.bulletphysics.$Stack;
import com.bulletphysics.collision.narrowphase.ManifoldPoint;
import com.bulletphysics.dynamics.RigidBody;
import com.bulletphysics.dynamics.constraintsolver.ConstraintPersistentData;
import com.bulletphysics.dynamics.constraintsolver.ContactSolverFunc;
import com.bulletphysics.dynamics.constraintsolver.ContactSolverInfo;
import com.bulletphysics.dynamics.constraintsolver.JacobianEntry;
import com.bulletphysics.linearmath.Transform;
import com.bulletphysics.util.ObjectPool;
import javax.vecmath.Matrix3f;
import javax.vecmath.Tuple3f;
import javax.vecmath.Vector3f;

public class ContactConstraint {
    public static final ContactSolverFunc resolveSingleCollision = new ContactSolverFunc(){

        @Override
        public float resolveContact(RigidBody body1, RigidBody body2, ManifoldPoint contactPoint, ContactSolverInfo info) {
            return ContactConstraint.resolveSingleCollision(body1, body2, contactPoint, info);
        }
    };
    public static final ContactSolverFunc resolveSingleFriction = new ContactSolverFunc(){

        @Override
        public float resolveContact(RigidBody body1, RigidBody body2, ManifoldPoint contactPoint, ContactSolverInfo info) {
            return ContactConstraint.resolveSingleFriction(body1, body2, contactPoint, info);
        }
    };
    public static final ContactSolverFunc resolveSingleCollisionCombined = new ContactSolverFunc(){

        @Override
        public float resolveContact(RigidBody body1, RigidBody body2, ManifoldPoint contactPoint, ContactSolverInfo info) {
            return ContactConstraint.resolveSingleCollisionCombined(body1, body2, contactPoint, info);
        }
    };

    /*
     * WARNING - void declaration
     */
    public static void resolveSingleBilateral(RigidBody rigidBody, Vector3f vector3f, RigidBody rigidBody2, Vector3f vector3f2, float f, Vector3f vector3f3, float[] fArray, float f2) {
        $Stack $Stack = $Stack.get();
        try {
            float velocityImpulse;
            void body2;
            void pos2;
            RigidBody body1;
            void pos1;
            void normal;
            $Stack $Stack2 = $Stack;
            $Stack2.push$com$bulletphysics$linearmath$Transform();
            $Stack2.push$javax$vecmath$Vector3f();
            float normalLenSqr = normal.lengthSquared();
            assert (Math.abs(normalLenSqr) < 1.1f);
            if (normalLenSqr > 1.1f) {
                impulse[0] = 0.0f;
                $Stack $Stack3 = $Stack;
                $Stack3.pop$com$bulletphysics$linearmath$Transform();
                $Stack3.pop$javax$vecmath$Vector3f();
                return;
            }
            ObjectPool<JacobianEntry> jacobiansPool = ObjectPool.get(JacobianEntry.class);
            Vector3f tmp = $Stack.get$javax$vecmath$Vector3f();
            Vector3f rel_pos1 = $Stack.get$javax$vecmath$Vector3f();
            rel_pos1.sub((Tuple3f)pos1, body1.getCenterOfMassPosition(tmp));
            Vector3f rel_pos2 = $Stack.get$javax$vecmath$Vector3f();
            rel_pos2.sub((Tuple3f)pos2, body2.getCenterOfMassPosition(tmp));
            Vector3f vel1 = $Stack.get$javax$vecmath$Vector3f();
            body1.getVelocityInLocalPoint(rel_pos1, vel1);
            Vector3f vel2 = $Stack.get$javax$vecmath$Vector3f();
            body2.getVelocityInLocalPoint(rel_pos2, vel2);
            Vector3f vel = $Stack.get$javax$vecmath$Vector3f();
            vel.sub(vel1, vel2);
            Matrix3f mat1 = body1.getCenterOfMassTransform((Transform)$Stack.get$com$bulletphysics$linearmath$Transform()).basis;
            mat1.transpose();
            Matrix3f mat2 = body2.getCenterOfMassTransform((Transform)$Stack.get$com$bulletphysics$linearmath$Transform()).basis;
            mat2.transpose();
            JacobianEntry jac = jacobiansPool.get();
            jac.init(mat1, mat2, rel_pos1, rel_pos2, (Vector3f)normal, body1.getInvInertiaDiagLocal($Stack.get$javax$vecmath$Vector3f()), body1.getInvMass(), body2.getInvInertiaDiagLocal($Stack.get$javax$vecmath$Vector3f()), body2.getInvMass());
            float jacDiagAB = jac.getDiagonal();
            float jacDiagABInv = 1.0f / jacDiagAB;
            Vector3f tmp1 = body1.getAngularVelocity($Stack.get$javax$vecmath$Vector3f());
            mat1.transform(tmp1);
            Vector3f tmp2 = body2.getAngularVelocity($Stack.get$javax$vecmath$Vector3f());
            mat2.transform(tmp2);
            float rel_vel = jac.getRelativeVelocity(body1.getLinearVelocity($Stack.get$javax$vecmath$Vector3f()), tmp1, body2.getLinearVelocity($Stack.get$javax$vecmath$Vector3f()), tmp2);
            jacobiansPool.release(jac);
            float a = jacDiagABInv;
            rel_vel = normal.dot(vel);
            float contactDamping = 0.2f;
            impulse[0] = velocityImpulse = -contactDamping * rel_vel * jacDiagABInv;
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

    /*
     * WARNING - void declaration
     */
    public static float resolveSingleCollision(RigidBody rigidBody, RigidBody rigidBody2, ManifoldPoint manifoldPoint, ContactSolverInfo contactSolverInfo) {
        $Stack $Stack = $Stack.get();
        try {
            void solverInfo;
            void body2;
            RigidBody body1;
            void contactPoint;
            $Stack.push$javax$vecmath$Vector3f();
            Vector3f tmpVec = $Stack.get$javax$vecmath$Vector3f();
            Vector3f pos1_ = contactPoint.getPositionWorldOnA($Stack.get$javax$vecmath$Vector3f());
            Vector3f pos2_ = contactPoint.getPositionWorldOnB($Stack.get$javax$vecmath$Vector3f());
            Vector3f normal = contactPoint.normalWorldOnB;
            Vector3f rel_pos1 = $Stack.get$javax$vecmath$Vector3f();
            rel_pos1.sub(pos1_, body1.getCenterOfMassPosition(tmpVec));
            Vector3f rel_pos2 = $Stack.get$javax$vecmath$Vector3f();
            rel_pos2.sub(pos2_, body2.getCenterOfMassPosition(tmpVec));
            Vector3f vel1 = body1.getVelocityInLocalPoint(rel_pos1, $Stack.get$javax$vecmath$Vector3f());
            Vector3f vel2 = body2.getVelocityInLocalPoint(rel_pos2, $Stack.get$javax$vecmath$Vector3f());
            Vector3f vel = $Stack.get$javax$vecmath$Vector3f();
            vel.sub(vel1, vel2);
            float rel_vel = normal.dot(vel);
            float Kfps = 1.0f / solverInfo.timeStep;
            float Kerp = solverInfo.erp;
            float Kcor = Kerp * Kfps;
            ConstraintPersistentData cpd = (ConstraintPersistentData)contactPoint.userPersistentData;
            assert (cpd != null);
            float oldNormalImpulse = cpd.appliedImpulse;
            float distance = cpd.penetration;
            float positionalError = Kcor * -distance;
            float penetrationImpulse = positionalError * cpd.jacDiagABInv;
            float velocityError = cpd.restitution - rel_vel;
            float velocityImpulse = velocityError * cpd.jacDiagABInv;
            float normalImpulse = penetrationImpulse + velocityImpulse;
            float sum = oldNormalImpulse + normalImpulse;
            cpd.appliedImpulse = 0.0f > sum ? 0.0f : sum;
            normalImpulse = cpd.appliedImpulse - oldNormalImpulse;
            Vector3f tmp = $Stack.get$javax$vecmath$Vector3f();
            if (body1.getInvMass() != 0.0f) {
                tmp.scale(body1.getInvMass(), contactPoint.normalWorldOnB);
                body1.internalApplyImpulse(tmp, cpd.angularComponentA, normalImpulse);
            }
            if (body2.getInvMass() != 0.0f) {
                tmp.scale(body2.getInvMass(), contactPoint.normalWorldOnB);
                body2.internalApplyImpulse(tmp, cpd.angularComponentB, -normalImpulse);
            }
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
    public static float resolveSingleFriction(RigidBody rigidBody, RigidBody rigidBody2, ManifoldPoint manifoldPoint, ContactSolverInfo contactSolverInfo) {
        $Stack $Stack = $Stack.get();
        try {
            void body2;
            RigidBody body1;
            void contactPoint;
            $Stack.push$javax$vecmath$Vector3f();
            Vector3f tmpVec = $Stack.get$javax$vecmath$Vector3f();
            Vector3f pos1 = contactPoint.getPositionWorldOnA($Stack.get$javax$vecmath$Vector3f());
            Vector3f pos2 = contactPoint.getPositionWorldOnB($Stack.get$javax$vecmath$Vector3f());
            Vector3f rel_pos1 = $Stack.get$javax$vecmath$Vector3f();
            rel_pos1.sub(pos1, body1.getCenterOfMassPosition(tmpVec));
            Vector3f rel_pos2 = $Stack.get$javax$vecmath$Vector3f();
            rel_pos2.sub(pos2, body2.getCenterOfMassPosition(tmpVec));
            ConstraintPersistentData cpd = (ConstraintPersistentData)contactPoint.userPersistentData;
            assert (cpd != null);
            float combinedFriction = cpd.friction;
            float limit = cpd.appliedImpulse * combinedFriction;
            if (cpd.appliedImpulse > 0.0f) {
                Vector3f vel1 = $Stack.get$javax$vecmath$Vector3f();
                body1.getVelocityInLocalPoint(rel_pos1, vel1);
                Vector3f vel2 = $Stack.get$javax$vecmath$Vector3f();
                body2.getVelocityInLocalPoint(rel_pos2, vel2);
                Vector3f vel = $Stack.get$javax$vecmath$Vector3f();
                vel.sub(vel1, vel2);
                float vrel = cpd.frictionWorldTangential0.dot(vel);
                float j1 = -vrel * cpd.jacDiagABInvTangent0;
                float oldTangentImpulse = cpd.accumulatedTangentImpulse0;
                cpd.accumulatedTangentImpulse0 = oldTangentImpulse + j1;
                cpd.accumulatedTangentImpulse0 = Math.min(cpd.accumulatedTangentImpulse0, limit);
                cpd.accumulatedTangentImpulse0 = Math.max(cpd.accumulatedTangentImpulse0, -limit);
                j1 = cpd.accumulatedTangentImpulse0 - oldTangentImpulse;
                vrel = cpd.frictionWorldTangential1.dot(vel);
                float j2 = -vrel * cpd.jacDiagABInvTangent1;
                oldTangentImpulse = cpd.accumulatedTangentImpulse1;
                cpd.accumulatedTangentImpulse1 = oldTangentImpulse + j2;
                cpd.accumulatedTangentImpulse1 = Math.min(cpd.accumulatedTangentImpulse1, limit);
                cpd.accumulatedTangentImpulse1 = Math.max(cpd.accumulatedTangentImpulse1, -limit);
                j2 = cpd.accumulatedTangentImpulse1 - oldTangentImpulse;
                Vector3f tmp = $Stack.get$javax$vecmath$Vector3f();
                if (body1.getInvMass() != 0.0f) {
                    tmp.scale(body1.getInvMass(), cpd.frictionWorldTangential0);
                    body1.internalApplyImpulse(tmp, cpd.frictionAngularComponent0A, j1);
                    tmp.scale(body1.getInvMass(), cpd.frictionWorldTangential1);
                    body1.internalApplyImpulse(tmp, cpd.frictionAngularComponent1A, j2);
                }
                if (body2.getInvMass() != 0.0f) {
                    tmp.scale(body2.getInvMass(), cpd.frictionWorldTangential0);
                    body2.internalApplyImpulse(tmp, cpd.frictionAngularComponent0B, -j1);
                    tmp.scale(body2.getInvMass(), cpd.frictionWorldTangential1);
                    body2.internalApplyImpulse(tmp, cpd.frictionAngularComponent1B, -j2);
                }
            }
            float f = cpd.appliedImpulse;
            $Stack.pop$javax$vecmath$Vector3f();
            return f;
        }
        catch (Throwable throwable) {
            $Stack.pop$javax$vecmath$Vector3f();
            throw throwable;
        }
    }

    /*
     * WARNING - void declaration
     */
    public static float resolveSingleCollisionCombined(RigidBody rigidBody, RigidBody rigidBody2, ManifoldPoint manifoldPoint, ContactSolverInfo contactSolverInfo) {
        $Stack $Stack = $Stack.get();
        try {
            void solverInfo;
            void body2;
            RigidBody body1;
            void contactPoint;
            $Stack $Stack2 = $Stack;
            $Stack2.push$javax$vecmath$Vector3f();
            $Stack2.push$javax$vecmath$Matrix3f();
            Vector3f tmpVec = $Stack.get$javax$vecmath$Vector3f();
            Vector3f pos1 = contactPoint.getPositionWorldOnA($Stack.get$javax$vecmath$Vector3f());
            Vector3f pos2 = contactPoint.getPositionWorldOnB($Stack.get$javax$vecmath$Vector3f());
            Vector3f normal = contactPoint.normalWorldOnB;
            Vector3f rel_pos1 = $Stack.get$javax$vecmath$Vector3f();
            rel_pos1.sub(pos1, body1.getCenterOfMassPosition(tmpVec));
            Vector3f rel_pos2 = $Stack.get$javax$vecmath$Vector3f();
            rel_pos2.sub(pos2, body2.getCenterOfMassPosition(tmpVec));
            Vector3f vel1 = body1.getVelocityInLocalPoint(rel_pos1, $Stack.get$javax$vecmath$Vector3f());
            Vector3f vel2 = body2.getVelocityInLocalPoint(rel_pos2, $Stack.get$javax$vecmath$Vector3f());
            Vector3f vel = $Stack.get$javax$vecmath$Vector3f();
            vel.sub(vel1, vel2);
            float rel_vel = normal.dot(vel);
            float Kfps = 1.0f / solverInfo.timeStep;
            float Kerp = solverInfo.erp;
            float Kcor = Kerp * Kfps;
            ConstraintPersistentData cpd = (ConstraintPersistentData)contactPoint.userPersistentData;
            assert (cpd != null);
            float oldNormalImpulse = cpd.appliedImpulse;
            float distance = cpd.penetration;
            float positionalError = Kcor * -distance;
            float penetrationImpulse = positionalError * cpd.jacDiagABInv;
            float velocityError = cpd.restitution - rel_vel;
            float velocityImpulse = velocityError * cpd.jacDiagABInv;
            float normalImpulse = penetrationImpulse + velocityImpulse;
            float sum = oldNormalImpulse + normalImpulse;
            cpd.appliedImpulse = 0.0f > sum ? 0.0f : sum;
            normalImpulse = cpd.appliedImpulse - oldNormalImpulse;
            Vector3f tmp = $Stack.get$javax$vecmath$Vector3f();
            if (body1.getInvMass() != 0.0f) {
                tmp.scale(body1.getInvMass(), contactPoint.normalWorldOnB);
                body1.internalApplyImpulse(tmp, cpd.angularComponentA, normalImpulse);
            }
            if (body2.getInvMass() != 0.0f) {
                tmp.scale(body2.getInvMass(), contactPoint.normalWorldOnB);
                body2.internalApplyImpulse(tmp, cpd.angularComponentB, -normalImpulse);
            }
            body1.getVelocityInLocalPoint(rel_pos1, vel1);
            body2.getVelocityInLocalPoint(rel_pos2, vel2);
            vel.sub(vel1, vel2);
            rel_vel = normal.dot(vel);
            tmp.scale(rel_vel, normal);
            Vector3f lat_vel = $Stack.get$javax$vecmath$Vector3f();
            lat_vel.sub(vel, tmp);
            float lat_rel_vel = lat_vel.length();
            float combinedFriction = cpd.friction;
            if (cpd.appliedImpulse > 0.0f && lat_rel_vel > 1.1920929E-7f) {
                lat_vel.scale(1.0f / lat_rel_vel);
                Vector3f temp1 = $Stack.get$javax$vecmath$Vector3f();
                temp1.cross(rel_pos1, lat_vel);
                body1.getInvInertiaTensorWorld($Stack.get$javax$vecmath$Matrix3f()).transform(temp1);
                Vector3f temp2 = $Stack.get$javax$vecmath$Vector3f();
                temp2.cross(rel_pos2, lat_vel);
                body2.getInvInertiaTensorWorld($Stack.get$javax$vecmath$Matrix3f()).transform(temp2);
                Vector3f java_tmp1 = $Stack.get$javax$vecmath$Vector3f();
                java_tmp1.cross(temp1, rel_pos1);
                Vector3f java_tmp2 = $Stack.get$javax$vecmath$Vector3f();
                java_tmp2.cross(temp2, rel_pos2);
                tmp.add(java_tmp1, java_tmp2);
                float friction_impulse = lat_rel_vel / (body1.getInvMass() + body2.getInvMass() + lat_vel.dot(tmp));
                float normal_impulse = cpd.appliedImpulse * combinedFriction;
                friction_impulse = Math.min(friction_impulse, normal_impulse);
                friction_impulse = Math.max(friction_impulse, -normal_impulse);
                tmp.scale(-friction_impulse, lat_vel);
                body1.applyImpulse(tmp, rel_pos1);
                tmp.scale(friction_impulse, lat_vel);
                body2.applyImpulse(tmp, rel_pos2);
            }
            $Stack $Stack3 = $Stack;
            $Stack3.pop$javax$vecmath$Vector3f();
            $Stack3.pop$javax$vecmath$Matrix3f();
            return normalImpulse;
        }
        catch (Throwable throwable) {
            $Stack $Stack4 = $Stack;
            $Stack4.pop$javax$vecmath$Vector3f();
            $Stack4.pop$javax$vecmath$Matrix3f();
            throw throwable;
        }
    }

    public static float resolveSingleFrictionEmpty(RigidBody body1, RigidBody body2, ManifoldPoint contactPoint, ContactSolverInfo solverInfo) {
        return 0.0f;
    }
}

