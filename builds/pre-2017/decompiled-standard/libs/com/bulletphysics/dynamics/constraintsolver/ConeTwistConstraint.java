/*
 * Decompiled with CFR 0.152.
 */
package com.bulletphysics.dynamics.constraintsolver;

import com.bulletphysics.$Stack;
import com.bulletphysics.dynamics.RigidBody;
import com.bulletphysics.dynamics.constraintsolver.JacobianEntry;
import com.bulletphysics.dynamics.constraintsolver.TypedConstraint;
import com.bulletphysics.dynamics.constraintsolver.TypedConstraintType;
import com.bulletphysics.linearmath.QuaternionUtil;
import com.bulletphysics.linearmath.ScalarUtil;
import com.bulletphysics.linearmath.Transform;
import com.bulletphysics.linearmath.TransformUtil;
import javax.vecmath.Matrix3f;
import javax.vecmath.Quat4f;
import javax.vecmath.Vector3f;

public class ConeTwistConstraint
extends TypedConstraint {
    private JacobianEntry[] jac = new JacobianEntry[]{new JacobianEntry(), new JacobianEntry(), new JacobianEntry()};
    private final Transform rbAFrame = new Transform();
    private final Transform rbBFrame = new Transform();
    private float limitSoftness;
    private float biasFactor;
    private float relaxationFactor;
    private float swingSpan1;
    private float swingSpan2;
    private float twistSpan;
    private final Vector3f swingAxis = new Vector3f();
    private final Vector3f twistAxis = new Vector3f();
    private float kSwing;
    private float kTwist;
    private float twistLimitSign;
    private float swingCorrection;
    private float twistCorrection;
    private float accSwingLimitImpulse;
    private float accTwistLimitImpulse;
    private boolean angularOnly = false;
    private boolean solveTwistLimit;
    private boolean solveSwingLimit;

    public ConeTwistConstraint() {
        super(TypedConstraintType.CONETWIST_CONSTRAINT_TYPE);
    }

    public ConeTwistConstraint(RigidBody rbA, RigidBody rbB, Transform rbAFrame, Transform rbBFrame) {
        super(TypedConstraintType.CONETWIST_CONSTRAINT_TYPE, rbA, rbB);
        this.rbAFrame.set(rbAFrame);
        this.rbBFrame.set(rbBFrame);
        this.swingSpan1 = 1.0E30f;
        this.swingSpan2 = 1.0E30f;
        this.twistSpan = 1.0E30f;
        this.biasFactor = 0.3f;
        this.relaxationFactor = 1.0f;
        this.solveTwistLimit = false;
        this.solveSwingLimit = false;
    }

    public ConeTwistConstraint(RigidBody rbA, Transform rbAFrame) {
        super(TypedConstraintType.CONETWIST_CONSTRAINT_TYPE, rbA);
        this.rbAFrame.set(rbAFrame);
        this.rbBFrame.set(this.rbAFrame);
        this.swingSpan1 = 1.0E30f;
        this.swingSpan2 = 1.0E30f;
        this.twistSpan = 1.0E30f;
        this.biasFactor = 0.3f;
        this.relaxationFactor = 1.0f;
        this.solveTwistLimit = false;
        this.solveSwingLimit = false;
    }

    @Override
    public void buildJacobian() {
        $Stack $Stack = $Stack.get();
        try {
            float fact;
            $Stack $Stack2 = $Stack;
            $Stack2.push$com$bulletphysics$linearmath$Transform();
            $Stack2.push$javax$vecmath$Vector3f();
            $Stack2.push$javax$vecmath$Quat4f();
            Vector3f tmp = $Stack.get$javax$vecmath$Vector3f();
            Vector3f tmp1 = $Stack.get$javax$vecmath$Vector3f();
            Vector3f tmp2 = $Stack.get$javax$vecmath$Vector3f();
            Transform tmpTrans = $Stack.get$com$bulletphysics$linearmath$Transform();
            this.appliedImpulse = 0.0f;
            this.swingCorrection = 0.0f;
            this.twistLimitSign = 0.0f;
            this.solveTwistLimit = false;
            this.solveSwingLimit = false;
            this.accTwistLimitImpulse = 0.0f;
            this.accSwingLimitImpulse = 0.0f;
            if (!this.angularOnly) {
                Vector3f pivotAInW = $Stack.get$javax$vecmath$Vector3f(this.rbAFrame.origin);
                this.rbA.getCenterOfMassTransform(tmpTrans).transform(pivotAInW);
                Vector3f pivotBInW = $Stack.get$javax$vecmath$Vector3f(this.rbBFrame.origin);
                this.rbB.getCenterOfMassTransform(tmpTrans).transform(pivotBInW);
                Vector3f relPos = $Stack.get$javax$vecmath$Vector3f();
                relPos.sub(pivotBInW, pivotAInW);
                Vector3f[] normal = new Vector3f[]{$Stack.get$javax$vecmath$Vector3f(), $Stack.get$javax$vecmath$Vector3f(), $Stack.get$javax$vecmath$Vector3f()};
                if (relPos.lengthSquared() > 1.1920929E-7f) {
                    normal[0].normalize(relPos);
                } else {
                    normal[0].set(1.0f, 0.0f, 0.0f);
                }
                TransformUtil.planeSpace1(normal[0], normal[1], normal[2]);
                for (int i = 0; i < 3; ++i) {
                    Matrix3f mat1 = this.rbA.getCenterOfMassTransform((Transform)$Stack.get$com$bulletphysics$linearmath$Transform()).basis;
                    mat1.transpose();
                    Matrix3f mat2 = this.rbB.getCenterOfMassTransform((Transform)$Stack.get$com$bulletphysics$linearmath$Transform()).basis;
                    mat2.transpose();
                    tmp1.sub(pivotAInW, this.rbA.getCenterOfMassPosition(tmp));
                    tmp2.sub(pivotBInW, this.rbB.getCenterOfMassPosition(tmp));
                    this.jac[i].init(mat1, mat2, tmp1, tmp2, normal[i], this.rbA.getInvInertiaDiagLocal($Stack.get$javax$vecmath$Vector3f()), this.rbA.getInvMass(), this.rbB.getInvInertiaDiagLocal($Stack.get$javax$vecmath$Vector3f()), this.rbB.getInvMass());
                }
            }
            Vector3f b1Axis1 = $Stack.get$javax$vecmath$Vector3f();
            Vector3f b1Axis2 = $Stack.get$javax$vecmath$Vector3f();
            Vector3f b1Axis3 = $Stack.get$javax$vecmath$Vector3f();
            Vector3f b2Axis1 = $Stack.get$javax$vecmath$Vector3f();
            Vector3f b2Axis2 = $Stack.get$javax$vecmath$Vector3f();
            this.rbAFrame.basis.getColumn(0, b1Axis1);
            this.getRigidBodyA().getCenterOfMassTransform((Transform)tmpTrans).basis.transform(b1Axis1);
            this.rbBFrame.basis.getColumn(0, b2Axis1);
            this.getRigidBodyB().getCenterOfMassTransform((Transform)tmpTrans).basis.transform(b2Axis1);
            float swing1 = 0.0f;
            float swing2 = 0.0f;
            float swx = 0.0f;
            float swy = 0.0f;
            float thresh = 10.0f;
            if (this.swingSpan1 >= 0.05f) {
                this.rbAFrame.basis.getColumn(1, b1Axis2);
                this.getRigidBodyA().getCenterOfMassTransform((Transform)tmpTrans).basis.transform(b1Axis2);
                swx = b2Axis1.dot(b1Axis1);
                swy = b2Axis1.dot(b1Axis2);
                swing1 = ScalarUtil.atan2Fast(swy, swx);
                fact = (swy * swy + swx * swx) * thresh * thresh;
                fact /= fact + 1.0f;
                swing1 *= fact;
            }
            if (this.swingSpan2 >= 0.05f) {
                this.rbAFrame.basis.getColumn(2, b1Axis3);
                this.getRigidBodyA().getCenterOfMassTransform((Transform)tmpTrans).basis.transform(b1Axis3);
                swx = b2Axis1.dot(b1Axis1);
                swy = b2Axis1.dot(b1Axis3);
                swing2 = ScalarUtil.atan2Fast(swy, swx);
                fact = (swy * swy + swx * swx) * thresh * thresh;
                fact /= fact + 1.0f;
                swing2 *= fact;
            }
            float RMaxAngle1Sq = 1.0f / (this.swingSpan1 * this.swingSpan1);
            float RMaxAngle2Sq = 1.0f / (this.swingSpan2 * this.swingSpan2);
            float EllipseAngle = Math.abs(swing1 * swing1) * RMaxAngle1Sq + Math.abs(swing2 * swing2) * RMaxAngle2Sq;
            if (EllipseAngle > 1.0f) {
                this.swingCorrection = EllipseAngle - 1.0f;
                this.solveSwingLimit = true;
                tmp1.scale(b2Axis1.dot(b1Axis2), b1Axis2);
                tmp2.scale(b2Axis1.dot(b1Axis3), b1Axis3);
                tmp.add(tmp1, tmp2);
                this.swingAxis.cross(b2Axis1, tmp);
                this.swingAxis.normalize();
                float swingAxisSign = b2Axis1.dot(b1Axis1) >= 0.0f ? 1.0f : -1.0f;
                this.swingAxis.scale(swingAxisSign);
                this.kSwing = 1.0f / (this.getRigidBodyA().computeAngularImpulseDenominator(this.swingAxis) + this.getRigidBodyB().computeAngularImpulseDenominator(this.swingAxis));
            }
            if (this.twistSpan >= 0.0f) {
                float lockedFreeFactor;
                this.rbBFrame.basis.getColumn(1, b2Axis2);
                this.getRigidBodyB().getCenterOfMassTransform((Transform)tmpTrans).basis.transform(b2Axis2);
                Quat4f rotationArc = QuaternionUtil.shortestArcQuat(b2Axis1, b1Axis1, $Stack.get$javax$vecmath$Quat4f());
                Vector3f TwistRef = QuaternionUtil.quatRotate(rotationArc, b2Axis2, $Stack.get$javax$vecmath$Vector3f());
                float twist = ScalarUtil.atan2Fast(TwistRef.dot(b1Axis3), TwistRef.dot(b1Axis2));
                float f = lockedFreeFactor = this.twistSpan > 0.05f ? this.limitSoftness : 0.0f;
                if (twist <= -this.twistSpan * lockedFreeFactor) {
                    this.twistCorrection = -(twist + this.twistSpan);
                    this.solveTwistLimit = true;
                    this.twistAxis.add(b2Axis1, b1Axis1);
                    this.twistAxis.scale(0.5f);
                    this.twistAxis.normalize();
                    this.twistAxis.scale(-1.0f);
                    this.kTwist = 1.0f / (this.getRigidBodyA().computeAngularImpulseDenominator(this.twistAxis) + this.getRigidBodyB().computeAngularImpulseDenominator(this.twistAxis));
                } else if (twist > this.twistSpan * lockedFreeFactor) {
                    this.twistCorrection = twist - this.twistSpan;
                    this.solveTwistLimit = true;
                    this.twistAxis.add(b2Axis1, b1Axis1);
                    this.twistAxis.scale(0.5f);
                    this.twistAxis.normalize();
                    this.kTwist = 1.0f / (this.getRigidBodyA().computeAngularImpulseDenominator(this.twistAxis) + this.getRigidBodyB().computeAngularImpulseDenominator(this.twistAxis));
                }
            }
            $Stack $Stack3 = $Stack;
            $Stack3.pop$com$bulletphysics$linearmath$Transform();
            $Stack3.pop$javax$vecmath$Vector3f();
            $Stack3.pop$javax$vecmath$Quat4f();
            return;
        }
        catch (Throwable throwable) {
            $Stack $Stack4 = $Stack;
            $Stack4.pop$com$bulletphysics$linearmath$Transform();
            $Stack4.pop$javax$vecmath$Vector3f();
            $Stack4.pop$javax$vecmath$Quat4f();
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
            void timeStep;
            $Stack $Stack2 = $Stack;
            $Stack2.push$com$bulletphysics$linearmath$Transform();
            $Stack2.push$javax$vecmath$Vector3f();
            Vector3f tmp = $Stack.get$javax$vecmath$Vector3f();
            Vector3f tmp2 = $Stack.get$javax$vecmath$Vector3f();
            Vector3f tmpVec = $Stack.get$javax$vecmath$Vector3f();
            Transform tmpTrans = $Stack.get$com$bulletphysics$linearmath$Transform();
            Vector3f pivotAInW = $Stack.get$javax$vecmath$Vector3f(this.rbAFrame.origin);
            this.rbA.getCenterOfMassTransform(tmpTrans).transform(pivotAInW);
            Vector3f pivotBInW = $Stack.get$javax$vecmath$Vector3f(this.rbBFrame.origin);
            this.rbB.getCenterOfMassTransform(tmpTrans).transform(pivotBInW);
            float tau = 0.3f;
            if (!this.angularOnly) {
                Vector3f rel_pos1 = $Stack.get$javax$vecmath$Vector3f();
                rel_pos1.sub(pivotAInW, this.rbA.getCenterOfMassPosition(tmpVec));
                Vector3f rel_pos2 = $Stack.get$javax$vecmath$Vector3f();
                rel_pos2.sub(pivotBInW, this.rbB.getCenterOfMassPosition(tmpVec));
                Vector3f vel1 = this.rbA.getVelocityInLocalPoint(rel_pos1, $Stack.get$javax$vecmath$Vector3f());
                Vector3f vel2 = this.rbB.getVelocityInLocalPoint(rel_pos2, $Stack.get$javax$vecmath$Vector3f());
                Vector3f vel = $Stack.get$javax$vecmath$Vector3f();
                vel.sub(vel1, vel2);
                for (int i = 0; i < 3; ++i) {
                    Vector3f normal = this.jac[i].linearJointAxis;
                    float jacDiagABInv = 1.0f / this.jac[i].getDiagonal();
                    float rel_vel = normal.dot(vel);
                    tmp.sub(pivotAInW, pivotBInW);
                    float depth = -tmp.dot(normal);
                    float impulse = depth * tau / timeStep * jacDiagABInv - rel_vel * jacDiagABInv;
                    this.appliedImpulse += impulse;
                    Vector3f impulse_vector = $Stack.get$javax$vecmath$Vector3f();
                    impulse_vector.scale(impulse, normal);
                    tmp.sub(pivotAInW, this.rbA.getCenterOfMassPosition(tmpVec));
                    this.rbA.applyImpulse(impulse_vector, tmp);
                    tmp.negate(impulse_vector);
                    tmp2.sub(pivotBInW, this.rbB.getCenterOfMassPosition(tmpVec));
                    this.rbB.applyImpulse(tmp, tmp2);
                }
            }
            Vector3f angVelA = this.getRigidBodyA().getAngularVelocity($Stack.get$javax$vecmath$Vector3f());
            Vector3f angVelB = this.getRigidBodyB().getAngularVelocity($Stack.get$javax$vecmath$Vector3f());
            if (this.solveSwingLimit) {
                tmp.sub(angVelB, angVelA);
                float amplitude = tmp.dot(this.swingAxis) * this.relaxationFactor * this.relaxationFactor + this.swingCorrection * (1.0f / timeStep) * this.biasFactor;
                float impulseMag = amplitude * this.kSwing;
                float temp = this.accSwingLimitImpulse;
                this.accSwingLimitImpulse = Math.max(this.accSwingLimitImpulse + impulseMag, 0.0f);
                impulseMag = this.accSwingLimitImpulse - temp;
                Vector3f impulse = $Stack.get$javax$vecmath$Vector3f();
                impulse.scale(impulseMag, this.swingAxis);
                this.rbA.applyTorqueImpulse(impulse);
                tmp.negate(impulse);
                this.rbB.applyTorqueImpulse(tmp);
            }
            if (this.solveTwistLimit) {
                tmp.sub(angVelB, angVelA);
                float amplitude = tmp.dot(this.twistAxis) * this.relaxationFactor * this.relaxationFactor + this.twistCorrection * (1.0f / timeStep) * this.biasFactor;
                float impulseMag = amplitude * this.kTwist;
                float temp = this.accTwistLimitImpulse;
                this.accTwistLimitImpulse = Math.max(this.accTwistLimitImpulse + impulseMag, 0.0f);
                impulseMag = this.accTwistLimitImpulse - temp;
                Vector3f impulse = $Stack.get$javax$vecmath$Vector3f();
                impulse.scale(impulseMag, this.twistAxis);
                this.rbA.applyTorqueImpulse(impulse);
                tmp.negate(impulse);
                this.rbB.applyTorqueImpulse(tmp);
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

    public void setAngularOnly(boolean angularOnly) {
        this.angularOnly = angularOnly;
    }

    public void setLimit(float _swingSpan1, float _swingSpan2, float _twistSpan) {
        this.setLimit(_swingSpan1, _swingSpan2, _twistSpan, 0.8f, 0.3f, 1.0f);
    }

    public void setLimit(float _swingSpan1, float _swingSpan2, float _twistSpan, float _softness, float _biasFactor, float _relaxationFactor) {
        this.swingSpan1 = _swingSpan1;
        this.swingSpan2 = _swingSpan2;
        this.twistSpan = _twistSpan;
        this.limitSoftness = _softness;
        this.biasFactor = _biasFactor;
        this.relaxationFactor = _relaxationFactor;
    }

    public Transform getAFrame(Transform out) {
        out.set(this.rbAFrame);
        return out;
    }

    public Transform getBFrame(Transform out) {
        out.set(this.rbBFrame);
        return out;
    }

    public boolean getSolveTwistLimit() {
        return this.solveTwistLimit;
    }

    public boolean getSolveSwingLimit() {
        return this.solveTwistLimit;
    }

    public float getTwistLimitSign() {
        return this.twistLimitSign;
    }
}

