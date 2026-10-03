/*
 * Decompiled with CFR 0.152.
 */
package com.bulletphysics.dynamics.constraintsolver;

import com.bulletphysics.$Stack;
import com.bulletphysics.dynamics.RigidBody;
import com.bulletphysics.dynamics.constraintsolver.JacobianEntry;
import com.bulletphysics.dynamics.constraintsolver.TypedConstraint;
import com.bulletphysics.dynamics.constraintsolver.TypedConstraintType;
import com.bulletphysics.linearmath.Transform;
import com.bulletphysics.linearmath.VectorUtil;
import javax.vecmath.Matrix3f;
import javax.vecmath.Tuple3f;
import javax.vecmath.Vector3f;

public class Point2PointConstraint
extends TypedConstraint {
    private final JacobianEntry[] jac;
    private final Vector3f pivotInA;
    private final Vector3f pivotInB;
    public ConstraintSetting setting;

    public Point2PointConstraint() {
        super(TypedConstraintType.POINT2POINT_CONSTRAINT_TYPE);
        this.jac = new JacobianEntry[]{new JacobianEntry(), new JacobianEntry(), new JacobianEntry()};
        this.pivotInA = new Vector3f();
        this.pivotInB = new Vector3f();
        this.setting = new ConstraintSetting();
    }

    public Point2PointConstraint(RigidBody rbA, RigidBody rbB, Vector3f pivotInA, Vector3f pivotInB) {
        super(TypedConstraintType.POINT2POINT_CONSTRAINT_TYPE, rbA, rbB);
        this.jac = new JacobianEntry[]{new JacobianEntry(), new JacobianEntry(), new JacobianEntry()};
        this.pivotInA = new Vector3f();
        this.pivotInB = new Vector3f();
        this.setting = new ConstraintSetting();
        this.pivotInA.set(pivotInA);
        this.pivotInB.set(pivotInB);
    }

    /*
     * WARNING - void declaration
     */
    public Point2PointConstraint(RigidBody rigidBody, Vector3f vector3f) {
        $Stack $Stack = $Stack.get();
        try {
            void pivotInA;
            void rbA;
            $Stack.push$com$bulletphysics$linearmath$Transform();
            super(TypedConstraintType.POINT2POINT_CONSTRAINT_TYPE, (RigidBody)rbA);
            this.jac = new JacobianEntry[]{new JacobianEntry(), new JacobianEntry(), new JacobianEntry()};
            this.pivotInA = new Vector3f();
            this.pivotInB = new Vector3f();
            this.setting = new ConstraintSetting();
            this.pivotInA.set((Tuple3f)pivotInA);
            this.pivotInB.set((Tuple3f)pivotInA);
            rbA.getCenterOfMassTransform($Stack.get$com$bulletphysics$linearmath$Transform()).transform(this.pivotInB);
            $Stack.pop$com$bulletphysics$linearmath$Transform();
            return;
        }
        catch (Throwable throwable) {
            $Stack.pop$com$bulletphysics$linearmath$Transform();
            throw throwable;
        }
    }

    @Override
    public void buildJacobian() {
        $Stack $Stack = $Stack.get();
        try {
            $Stack $Stack2 = $Stack;
            $Stack2.push$com$bulletphysics$linearmath$Transform();
            $Stack2.push$javax$vecmath$Vector3f();
            $Stack2.push$javax$vecmath$Matrix3f();
            this.appliedImpulse = 0.0f;
            Vector3f normal = $Stack.get$javax$vecmath$Vector3f();
            normal.set(0.0f, 0.0f, 0.0f);
            Matrix3f tmpMat1 = $Stack.get$javax$vecmath$Matrix3f();
            Matrix3f tmpMat2 = $Stack.get$javax$vecmath$Matrix3f();
            Vector3f tmp1 = $Stack.get$javax$vecmath$Vector3f();
            Vector3f tmp2 = $Stack.get$javax$vecmath$Vector3f();
            Vector3f tmpVec = $Stack.get$javax$vecmath$Vector3f();
            Transform centerOfMassA = this.rbA.getCenterOfMassTransform($Stack.get$com$bulletphysics$linearmath$Transform());
            Transform centerOfMassB = this.rbB.getCenterOfMassTransform($Stack.get$com$bulletphysics$linearmath$Transform());
            for (int i = 0; i < 3; ++i) {
                VectorUtil.setCoord(normal, i, 1.0f);
                tmpMat1.transpose(centerOfMassA.basis);
                tmpMat2.transpose(centerOfMassB.basis);
                tmp1.set(this.pivotInA);
                centerOfMassA.transform(tmp1);
                tmp1.sub(this.rbA.getCenterOfMassPosition(tmpVec));
                tmp2.set(this.pivotInB);
                centerOfMassB.transform(tmp2);
                tmp2.sub(this.rbB.getCenterOfMassPosition(tmpVec));
                this.jac[i].init(tmpMat1, tmpMat2, tmp1, tmp2, normal, this.rbA.getInvInertiaDiagLocal($Stack.get$javax$vecmath$Vector3f()), this.rbA.getInvMass(), this.rbB.getInvInertiaDiagLocal($Stack.get$javax$vecmath$Vector3f()), this.rbB.getInvMass());
                VectorUtil.setCoord(normal, i, 0.0f);
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

    /*
     * WARNING - void declaration
     */
    @Override
    public void solveConstraint(float f) {
        $Stack $Stack = $Stack.get();
        try {
            $Stack $Stack2 = $Stack;
            $Stack2.push$com$bulletphysics$linearmath$Transform();
            $Stack2.push$javax$vecmath$Vector3f();
            Vector3f tmp = $Stack.get$javax$vecmath$Vector3f();
            Vector3f tmp2 = $Stack.get$javax$vecmath$Vector3f();
            Vector3f tmpVec = $Stack.get$javax$vecmath$Vector3f();
            Transform centerOfMassA = this.rbA.getCenterOfMassTransform($Stack.get$com$bulletphysics$linearmath$Transform());
            Transform centerOfMassB = this.rbB.getCenterOfMassTransform($Stack.get$com$bulletphysics$linearmath$Transform());
            Vector3f pivotAInW = $Stack.get$javax$vecmath$Vector3f(this.pivotInA);
            centerOfMassA.transform(pivotAInW);
            Vector3f pivotBInW = $Stack.get$javax$vecmath$Vector3f(this.pivotInB);
            centerOfMassB.transform(pivotBInW);
            Vector3f normal = $Stack.get$javax$vecmath$Vector3f();
            normal.set(0.0f, 0.0f, 0.0f);
            for (int i = 0; i < 3; ++i) {
                void timeStep;
                VectorUtil.setCoord(normal, i, 1.0f);
                float jacDiagABInv = 1.0f / this.jac[i].getDiagonal();
                Vector3f rel_pos1 = $Stack.get$javax$vecmath$Vector3f();
                rel_pos1.sub(pivotAInW, this.rbA.getCenterOfMassPosition(tmpVec));
                Vector3f rel_pos2 = $Stack.get$javax$vecmath$Vector3f();
                rel_pos2.sub(pivotBInW, this.rbB.getCenterOfMassPosition(tmpVec));
                Vector3f vel1 = this.rbA.getVelocityInLocalPoint(rel_pos1, $Stack.get$javax$vecmath$Vector3f());
                Vector3f vel2 = this.rbB.getVelocityInLocalPoint(rel_pos2, $Stack.get$javax$vecmath$Vector3f());
                Vector3f vel = $Stack.get$javax$vecmath$Vector3f();
                vel.sub(vel1, vel2);
                float rel_vel = normal.dot(vel);
                tmp.sub(pivotAInW, pivotBInW);
                float depth = -tmp.dot(normal);
                float impulse = depth * this.setting.tau / timeStep * jacDiagABInv - this.setting.damping * rel_vel * jacDiagABInv;
                float impulseClamp = this.setting.impulseClamp;
                if (impulseClamp > 0.0f) {
                    if (impulse < -impulseClamp) {
                        impulse = -impulseClamp;
                    }
                    if (impulse > impulseClamp) {
                        impulse = impulseClamp;
                    }
                }
                this.appliedImpulse += impulse;
                Vector3f impulse_vector = $Stack.get$javax$vecmath$Vector3f();
                impulse_vector.scale(impulse, normal);
                tmp.sub(pivotAInW, this.rbA.getCenterOfMassPosition(tmpVec));
                this.rbA.applyImpulse(impulse_vector, tmp);
                tmp.negate(impulse_vector);
                tmp2.sub(pivotBInW, this.rbB.getCenterOfMassPosition(tmpVec));
                this.rbB.applyImpulse(tmp, tmp2);
                VectorUtil.setCoord(normal, i, 0.0f);
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

    public void updateRHS(float timeStep) {
    }

    public void setPivotA(Vector3f pivotA) {
        this.pivotInA.set(pivotA);
    }

    public void setPivotB(Vector3f pivotB) {
        this.pivotInB.set(pivotB);
    }

    public Vector3f getPivotInA(Vector3f out) {
        out.set(this.pivotInA);
        return out;
    }

    public Vector3f getPivotInB(Vector3f out) {
        out.set(this.pivotInB);
        return out;
    }

    public static class ConstraintSetting {
        public float tau = 0.3f;
        public float damping = 1.0f;
        public float impulseClamp = 0.0f;
    }
}

