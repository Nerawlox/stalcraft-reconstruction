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
import javax.vecmath.Tuple3f;
import javax.vecmath.Vector3f;

public class HingeConstraint
extends TypedConstraint {
    private JacobianEntry[] jac;
    private JacobianEntry[] jacAng;
    private final Transform rbAFrame;
    private final Transform rbBFrame;
    private float motorTargetVelocity;
    private float maxMotorImpulse;
    private float limitSoftness;
    private float biasFactor;
    private float relaxationFactor;
    private float lowerLimit;
    private float upperLimit;
    private float kHinge;
    private float limitSign;
    private float correction;
    private float accLimitImpulse;
    private boolean angularOnly;
    private boolean enableAngularMotor;
    private boolean solveLimit;

    public HingeConstraint() {
        super(TypedConstraintType.HINGE_CONSTRAINT_TYPE);
        this.jac = new JacobianEntry[]{new JacobianEntry(), new JacobianEntry(), new JacobianEntry()};
        this.jacAng = new JacobianEntry[]{new JacobianEntry(), new JacobianEntry(), new JacobianEntry()};
        this.rbAFrame = new Transform();
        this.rbBFrame = new Transform();
        this.enableAngularMotor = false;
    }

    /*
     * WARNING - void declaration
     */
    public HingeConstraint(RigidBody rigidBody, RigidBody rigidBody2, Vector3f vector3f, Vector3f vector3f2, Vector3f vector3f3, Vector3f vector3f4) {
        $Stack $Stack = $Stack.get();
        try {
            void pivotInB;
            void axisInB;
            void axisInA;
            void pivotInA;
            void rbB;
            void rbA;
            $Stack $Stack2 = $Stack;
            $Stack2.push$com$bulletphysics$linearmath$Transform();
            $Stack2.push$javax$vecmath$Vector3f();
            $Stack2.push$javax$vecmath$Quat4f();
            super(TypedConstraintType.HINGE_CONSTRAINT_TYPE, (RigidBody)rbA, (RigidBody)rbB);
            this.jac = new JacobianEntry[]{new JacobianEntry(), new JacobianEntry(), new JacobianEntry()};
            this.jacAng = new JacobianEntry[]{new JacobianEntry(), new JacobianEntry(), new JacobianEntry()};
            this.rbAFrame = new Transform();
            this.rbBFrame = new Transform();
            this.angularOnly = false;
            this.enableAngularMotor = false;
            this.rbAFrame.origin.set((Tuple3f)pivotInA);
            Vector3f rbAxisA1 = $Stack.get$javax$vecmath$Vector3f();
            Vector3f rbAxisA2 = $Stack.get$javax$vecmath$Vector3f();
            Transform centerOfMassA = rbA.getCenterOfMassTransform($Stack.get$com$bulletphysics$linearmath$Transform());
            centerOfMassA.basis.getColumn(0, rbAxisA1);
            float projection = axisInA.dot(rbAxisA1);
            if (projection >= 0.9999999f) {
                centerOfMassA.basis.getColumn(2, rbAxisA1);
                rbAxisA1.negate();
                centerOfMassA.basis.getColumn(1, rbAxisA2);
            } else if (projection <= -0.9999999f) {
                centerOfMassA.basis.getColumn(2, rbAxisA1);
                centerOfMassA.basis.getColumn(1, rbAxisA2);
            } else {
                rbAxisA2.cross((Vector3f)axisInA, rbAxisA1);
                rbAxisA1.cross(rbAxisA2, (Vector3f)axisInA);
            }
            this.rbAFrame.basis.setRow(0, rbAxisA1.x, rbAxisA2.x, axisInA.x);
            this.rbAFrame.basis.setRow(1, rbAxisA1.y, rbAxisA2.y, axisInA.y);
            this.rbAFrame.basis.setRow(2, rbAxisA1.z, rbAxisA2.z, axisInA.z);
            Quat4f rotationArc = QuaternionUtil.shortestArcQuat((Vector3f)axisInA, (Vector3f)axisInB, $Stack.get$javax$vecmath$Quat4f());
            Vector3f rbAxisB1 = QuaternionUtil.quatRotate(rotationArc, rbAxisA1, $Stack.get$javax$vecmath$Vector3f());
            Vector3f rbAxisB2 = $Stack.get$javax$vecmath$Vector3f();
            rbAxisB2.cross((Vector3f)axisInB, rbAxisB1);
            this.rbBFrame.origin.set((Tuple3f)pivotInB);
            this.rbBFrame.basis.setRow(0, rbAxisB1.x, rbAxisB2.x, -axisInB.x);
            this.rbBFrame.basis.setRow(1, rbAxisB1.y, rbAxisB2.y, -axisInB.y);
            this.rbBFrame.basis.setRow(2, rbAxisB1.z, rbAxisB2.z, -axisInB.z);
            this.lowerLimit = 1.0E30f;
            this.upperLimit = -1.0E30f;
            this.biasFactor = 0.3f;
            this.relaxationFactor = 1.0f;
            this.limitSoftness = 0.9f;
            this.solveLimit = false;
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
    public HingeConstraint(RigidBody rigidBody, Vector3f vector3f, Vector3f vector3f2) {
        $Stack $Stack = $Stack.get();
        try {
            void pivotInA;
            void axisInA;
            void rbA;
            $Stack $Stack2 = $Stack;
            $Stack2.push$com$bulletphysics$linearmath$Transform();
            $Stack2.push$javax$vecmath$Vector3f();
            $Stack2.push$javax$vecmath$Quat4f();
            super(TypedConstraintType.HINGE_CONSTRAINT_TYPE, (RigidBody)rbA);
            this.jac = new JacobianEntry[]{new JacobianEntry(), new JacobianEntry(), new JacobianEntry()};
            this.jacAng = new JacobianEntry[]{new JacobianEntry(), new JacobianEntry(), new JacobianEntry()};
            this.rbAFrame = new Transform();
            this.rbBFrame = new Transform();
            this.angularOnly = false;
            this.enableAngularMotor = false;
            Vector3f rbAxisA1 = $Stack.get$javax$vecmath$Vector3f();
            Transform centerOfMassA = rbA.getCenterOfMassTransform($Stack.get$com$bulletphysics$linearmath$Transform());
            centerOfMassA.basis.getColumn(0, rbAxisA1);
            float projection = rbAxisA1.dot((Vector3f)axisInA);
            if (projection > 1.1920929E-7f) {
                rbAxisA1.scale(projection);
                rbAxisA1.sub((Tuple3f)axisInA);
            } else {
                centerOfMassA.basis.getColumn(1, rbAxisA1);
            }
            Vector3f rbAxisA2 = $Stack.get$javax$vecmath$Vector3f();
            rbAxisA2.cross((Vector3f)axisInA, rbAxisA1);
            this.rbAFrame.origin.set((Tuple3f)pivotInA);
            this.rbAFrame.basis.setRow(0, rbAxisA1.x, rbAxisA2.x, axisInA.x);
            this.rbAFrame.basis.setRow(1, rbAxisA1.y, rbAxisA2.y, axisInA.y);
            this.rbAFrame.basis.setRow(2, rbAxisA1.z, rbAxisA2.z, axisInA.z);
            Vector3f axisInB = $Stack.get$javax$vecmath$Vector3f();
            axisInB.negate((Tuple3f)axisInA);
            centerOfMassA.basis.transform(axisInB);
            Quat4f rotationArc = QuaternionUtil.shortestArcQuat((Vector3f)axisInA, axisInB, $Stack.get$javax$vecmath$Quat4f());
            Vector3f rbAxisB1 = QuaternionUtil.quatRotate(rotationArc, rbAxisA1, $Stack.get$javax$vecmath$Vector3f());
            Vector3f rbAxisB2 = $Stack.get$javax$vecmath$Vector3f();
            rbAxisB2.cross(axisInB, rbAxisB1);
            this.rbBFrame.origin.set((Tuple3f)pivotInA);
            centerOfMassA.transform(this.rbBFrame.origin);
            this.rbBFrame.basis.setRow(0, rbAxisB1.x, rbAxisB2.x, axisInB.x);
            this.rbBFrame.basis.setRow(1, rbAxisB1.y, rbAxisB2.y, axisInB.y);
            this.rbBFrame.basis.setRow(2, rbAxisB1.z, rbAxisB2.z, axisInB.z);
            this.lowerLimit = 1.0E30f;
            this.upperLimit = -1.0E30f;
            this.biasFactor = 0.3f;
            this.relaxationFactor = 1.0f;
            this.limitSoftness = 0.9f;
            this.solveLimit = false;
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

    public HingeConstraint(RigidBody rbA, RigidBody rbB, Transform rbAFrame, Transform rbBFrame) {
        super(TypedConstraintType.HINGE_CONSTRAINT_TYPE, rbA, rbB);
        this.jac = new JacobianEntry[]{new JacobianEntry(), new JacobianEntry(), new JacobianEntry()};
        this.jacAng = new JacobianEntry[]{new JacobianEntry(), new JacobianEntry(), new JacobianEntry()};
        this.rbAFrame = new Transform();
        this.rbBFrame = new Transform();
        this.rbAFrame.set(rbAFrame);
        this.rbBFrame.set(rbBFrame);
        this.angularOnly = false;
        this.enableAngularMotor = false;
        this.rbBFrame.basis.m02 *= -1.0f;
        this.rbBFrame.basis.m12 *= -1.0f;
        this.rbBFrame.basis.m22 *= -1.0f;
        this.lowerLimit = 1.0E30f;
        this.upperLimit = -1.0E30f;
        this.biasFactor = 0.3f;
        this.relaxationFactor = 1.0f;
        this.limitSoftness = 0.9f;
        this.solveLimit = false;
    }

    /*
     * WARNING - void declaration
     */
    public HingeConstraint(RigidBody rigidBody, Transform transform) {
        $Stack $Stack = $Stack.get();
        try {
            void rbAFrame;
            void rbA;
            $Stack.push$com$bulletphysics$linearmath$Transform();
            super(TypedConstraintType.HINGE_CONSTRAINT_TYPE, (RigidBody)rbA);
            this.jac = new JacobianEntry[]{new JacobianEntry(), new JacobianEntry(), new JacobianEntry()};
            this.jacAng = new JacobianEntry[]{new JacobianEntry(), new JacobianEntry(), new JacobianEntry()};
            this.rbAFrame = new Transform();
            this.rbBFrame = new Transform();
            this.rbAFrame.set((Transform)rbAFrame);
            this.rbBFrame.set((Transform)rbAFrame);
            this.angularOnly = false;
            this.enableAngularMotor = false;
            this.rbBFrame.basis.m02 *= -1.0f;
            this.rbBFrame.basis.m12 *= -1.0f;
            this.rbBFrame.basis.m22 *= -1.0f;
            this.rbBFrame.origin.set(this.rbAFrame.origin);
            rbA.getCenterOfMassTransform($Stack.get$com$bulletphysics$linearmath$Transform()).transform(this.rbBFrame.origin);
            this.lowerLimit = 1.0E30f;
            this.upperLimit = -1.0E30f;
            this.biasFactor = 0.3f;
            this.relaxationFactor = 1.0f;
            this.limitSoftness = 0.9f;
            this.solveLimit = false;
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
            Vector3f tmp = $Stack.get$javax$vecmath$Vector3f();
            Vector3f tmp1 = $Stack.get$javax$vecmath$Vector3f();
            Vector3f tmp2 = $Stack.get$javax$vecmath$Vector3f();
            Vector3f tmpVec = $Stack.get$javax$vecmath$Vector3f();
            Matrix3f mat1 = $Stack.get$javax$vecmath$Matrix3f();
            Matrix3f mat2 = $Stack.get$javax$vecmath$Matrix3f();
            Transform centerOfMassA = this.rbA.getCenterOfMassTransform($Stack.get$com$bulletphysics$linearmath$Transform());
            Transform centerOfMassB = this.rbB.getCenterOfMassTransform($Stack.get$com$bulletphysics$linearmath$Transform());
            this.appliedImpulse = 0.0f;
            if (!this.angularOnly) {
                Vector3f pivotAInW = $Stack.get$javax$vecmath$Vector3f(this.rbAFrame.origin);
                centerOfMassA.transform(pivotAInW);
                Vector3f pivotBInW = $Stack.get$javax$vecmath$Vector3f(this.rbBFrame.origin);
                centerOfMassB.transform(pivotBInW);
                Vector3f relPos = $Stack.get$javax$vecmath$Vector3f();
                relPos.sub(pivotBInW, pivotAInW);
                Vector3f[] normal = new Vector3f[]{$Stack.get$javax$vecmath$Vector3f(), $Stack.get$javax$vecmath$Vector3f(), $Stack.get$javax$vecmath$Vector3f()};
                if (relPos.lengthSquared() > 1.1920929E-7f) {
                    normal[0].set(relPos);
                    normal[0].normalize();
                } else {
                    normal[0].set(1.0f, 0.0f, 0.0f);
                }
                TransformUtil.planeSpace1(normal[0], normal[1], normal[2]);
                for (int i = 0; i < 3; ++i) {
                    mat1.transpose(centerOfMassA.basis);
                    mat2.transpose(centerOfMassB.basis);
                    tmp1.sub(pivotAInW, this.rbA.getCenterOfMassPosition(tmpVec));
                    tmp2.sub(pivotBInW, this.rbB.getCenterOfMassPosition(tmpVec));
                    this.jac[i].init(mat1, mat2, tmp1, tmp2, normal[i], this.rbA.getInvInertiaDiagLocal($Stack.get$javax$vecmath$Vector3f()), this.rbA.getInvMass(), this.rbB.getInvInertiaDiagLocal($Stack.get$javax$vecmath$Vector3f()), this.rbB.getInvMass());
                }
            }
            Vector3f jointAxis0local = $Stack.get$javax$vecmath$Vector3f();
            Vector3f jointAxis1local = $Stack.get$javax$vecmath$Vector3f();
            this.rbAFrame.basis.getColumn(2, tmp);
            TransformUtil.planeSpace1(tmp, jointAxis0local, jointAxis1local);
            Vector3f jointAxis0 = $Stack.get$javax$vecmath$Vector3f(jointAxis0local);
            centerOfMassA.basis.transform(jointAxis0);
            Vector3f jointAxis1 = $Stack.get$javax$vecmath$Vector3f(jointAxis1local);
            centerOfMassA.basis.transform(jointAxis1);
            Vector3f hingeAxisWorld = $Stack.get$javax$vecmath$Vector3f();
            this.rbAFrame.basis.getColumn(2, hingeAxisWorld);
            centerOfMassA.basis.transform(hingeAxisWorld);
            mat1.transpose(centerOfMassA.basis);
            mat2.transpose(centerOfMassB.basis);
            this.jacAng[0].init(jointAxis0, mat1, mat2, this.rbA.getInvInertiaDiagLocal($Stack.get$javax$vecmath$Vector3f()), this.rbB.getInvInertiaDiagLocal($Stack.get$javax$vecmath$Vector3f()));
            this.jacAng[1].init(jointAxis1, mat1, mat2, this.rbA.getInvInertiaDiagLocal($Stack.get$javax$vecmath$Vector3f()), this.rbB.getInvInertiaDiagLocal($Stack.get$javax$vecmath$Vector3f()));
            this.jacAng[2].init(hingeAxisWorld, mat1, mat2, this.rbA.getInvInertiaDiagLocal($Stack.get$javax$vecmath$Vector3f()), this.rbB.getInvInertiaDiagLocal($Stack.get$javax$vecmath$Vector3f()));
            float hingeAngle = this.getHingeAngle();
            this.correction = 0.0f;
            this.limitSign = 0.0f;
            this.solveLimit = false;
            this.accLimitImpulse = 0.0f;
            if (this.lowerLimit < this.upperLimit) {
                if (hingeAngle <= this.lowerLimit * this.limitSoftness) {
                    this.correction = this.lowerLimit - hingeAngle;
                    this.limitSign = 1.0f;
                    this.solveLimit = true;
                } else if (hingeAngle >= this.upperLimit * this.limitSoftness) {
                    this.correction = this.upperLimit - hingeAngle;
                    this.limitSign = -1.0f;
                    this.solveLimit = true;
                }
            }
            Vector3f axisA = $Stack.get$javax$vecmath$Vector3f();
            this.rbAFrame.basis.getColumn(2, axisA);
            centerOfMassA.basis.transform(axisA);
            this.kHinge = 1.0f / (this.getRigidBodyA().computeAngularImpulseDenominator(axisA) + this.getRigidBodyB().computeAngularImpulseDenominator(axisA));
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
            void timeStep;
            $Stack $Stack2 = $Stack;
            $Stack2.push$com$bulletphysics$linearmath$Transform();
            $Stack2.push$javax$vecmath$Vector3f();
            Vector3f tmp = $Stack.get$javax$vecmath$Vector3f();
            Vector3f tmp2 = $Stack.get$javax$vecmath$Vector3f();
            Vector3f tmpVec = $Stack.get$javax$vecmath$Vector3f();
            Transform centerOfMassA = this.rbA.getCenterOfMassTransform($Stack.get$com$bulletphysics$linearmath$Transform());
            Transform centerOfMassB = this.rbB.getCenterOfMassTransform($Stack.get$com$bulletphysics$linearmath$Transform());
            Vector3f pivotAInW = $Stack.get$javax$vecmath$Vector3f(this.rbAFrame.origin);
            centerOfMassA.transform(pivotAInW);
            Vector3f pivotBInW = $Stack.get$javax$vecmath$Vector3f(this.rbBFrame.origin);
            centerOfMassB.transform(pivotBInW);
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
            Vector3f axisA = $Stack.get$javax$vecmath$Vector3f();
            this.rbAFrame.basis.getColumn(2, axisA);
            centerOfMassA.basis.transform(axisA);
            Vector3f axisB = $Stack.get$javax$vecmath$Vector3f();
            this.rbBFrame.basis.getColumn(2, axisB);
            centerOfMassB.basis.transform(axisB);
            Vector3f angVelA = this.getRigidBodyA().getAngularVelocity($Stack.get$javax$vecmath$Vector3f());
            Vector3f angVelB = this.getRigidBodyB().getAngularVelocity($Stack.get$javax$vecmath$Vector3f());
            Vector3f angVelAroundHingeAxisA = $Stack.get$javax$vecmath$Vector3f();
            angVelAroundHingeAxisA.scale(axisA.dot(angVelA), axisA);
            Vector3f angVelAroundHingeAxisB = $Stack.get$javax$vecmath$Vector3f();
            angVelAroundHingeAxisB.scale(axisB.dot(angVelB), axisB);
            Vector3f angAorthog = $Stack.get$javax$vecmath$Vector3f();
            angAorthog.sub(angVelA, angVelAroundHingeAxisA);
            Vector3f angBorthog = $Stack.get$javax$vecmath$Vector3f();
            angBorthog.sub(angVelB, angVelAroundHingeAxisB);
            Vector3f velrelOrthog = $Stack.get$javax$vecmath$Vector3f();
            velrelOrthog.sub(angAorthog, angBorthog);
            float relaxation = 1.0f;
            float len = velrelOrthog.length();
            if (len > 1.0E-5f) {
                Vector3f normal = $Stack.get$javax$vecmath$Vector3f();
                normal.normalize(velrelOrthog);
                float denom = this.getRigidBodyA().computeAngularImpulseDenominator(normal) + this.getRigidBodyB().computeAngularImpulseDenominator(normal);
                velrelOrthog.scale(1.0f / denom * this.relaxationFactor);
            }
            Vector3f angularError = $Stack.get$javax$vecmath$Vector3f();
            angularError.cross(axisA, axisB);
            angularError.negate();
            angularError.scale(1.0f / timeStep);
            float len2 = angularError.length();
            if (len2 > 1.0E-5f) {
                Vector3f normal2 = $Stack.get$javax$vecmath$Vector3f();
                normal2.normalize(angularError);
                float denom2 = this.getRigidBodyA().computeAngularImpulseDenominator(normal2) + this.getRigidBodyB().computeAngularImpulseDenominator(normal2);
                angularError.scale(1.0f / denom2 * relaxation);
            }
            tmp.negate(velrelOrthog);
            tmp.add(angularError);
            this.rbA.applyTorqueImpulse(tmp);
            tmp.sub(velrelOrthog, angularError);
            this.rbB.applyTorqueImpulse(tmp);
            if (this.solveLimit) {
                tmp.sub(angVelB, angVelA);
                float amplitude = (tmp.dot(axisA) * this.relaxationFactor + this.correction * (1.0f / timeStep) * this.biasFactor) * this.limitSign;
                float impulseMag = amplitude * this.kHinge;
                float temp = this.accLimitImpulse;
                this.accLimitImpulse = Math.max(this.accLimitImpulse + impulseMag, 0.0f);
                impulseMag = this.accLimitImpulse - temp;
                Vector3f impulse = $Stack.get$javax$vecmath$Vector3f();
                impulse.scale(impulseMag * this.limitSign, axisA);
                this.rbA.applyTorqueImpulse(impulse);
                tmp.negate(impulse);
                this.rbB.applyTorqueImpulse(tmp);
            }
            if (this.enableAngularMotor) {
                Vector3f angularLimit = $Stack.get$javax$vecmath$Vector3f();
                angularLimit.set(0.0f, 0.0f, 0.0f);
                Vector3f velrel = $Stack.get$javax$vecmath$Vector3f();
                velrel.sub(angVelAroundHingeAxisA, angVelAroundHingeAxisB);
                float projRelVel = velrel.dot(axisA);
                float desiredMotorVel = this.motorTargetVelocity;
                float motor_relvel = desiredMotorVel - projRelVel;
                float unclippedMotorImpulse = this.kHinge * motor_relvel;
                float clippedMotorImpulse = unclippedMotorImpulse > this.maxMotorImpulse ? this.maxMotorImpulse : unclippedMotorImpulse;
                clippedMotorImpulse = clippedMotorImpulse < -this.maxMotorImpulse ? -this.maxMotorImpulse : clippedMotorImpulse;
                Vector3f motorImp = $Stack.get$javax$vecmath$Vector3f();
                motorImp.scale(clippedMotorImpulse, axisA);
                tmp.add(motorImp, angularLimit);
                this.rbA.applyTorqueImpulse(tmp);
                tmp.negate(motorImp);
                tmp.sub(angularLimit);
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

    public float getHingeAngle() {
        $Stack $Stack = $Stack.get();
        try {
            $Stack $Stack2 = $Stack;
            $Stack2.push$com$bulletphysics$linearmath$Transform();
            $Stack2.push$javax$vecmath$Vector3f();
            Transform centerOfMassA = this.rbA.getCenterOfMassTransform($Stack.get$com$bulletphysics$linearmath$Transform());
            Transform centerOfMassB = this.rbB.getCenterOfMassTransform($Stack.get$com$bulletphysics$linearmath$Transform());
            Vector3f refAxis0 = $Stack.get$javax$vecmath$Vector3f();
            this.rbAFrame.basis.getColumn(0, refAxis0);
            centerOfMassA.basis.transform(refAxis0);
            Vector3f refAxis1 = $Stack.get$javax$vecmath$Vector3f();
            this.rbAFrame.basis.getColumn(1, refAxis1);
            centerOfMassA.basis.transform(refAxis1);
            Vector3f swingAxis = $Stack.get$javax$vecmath$Vector3f();
            this.rbBFrame.basis.getColumn(1, swingAxis);
            centerOfMassB.basis.transform(swingAxis);
            float f = ScalarUtil.atan2Fast(swingAxis.dot(refAxis0), swingAxis.dot(refAxis1));
            $Stack $Stack3 = $Stack;
            $Stack3.pop$com$bulletphysics$linearmath$Transform();
            $Stack3.pop$javax$vecmath$Vector3f();
            return f;
        }
        catch (Throwable throwable) {
            $Stack $Stack4 = $Stack;
            $Stack4.pop$com$bulletphysics$linearmath$Transform();
            $Stack4.pop$javax$vecmath$Vector3f();
            throw throwable;
        }
    }

    public void setAngularOnly(boolean angularOnly) {
        this.angularOnly = angularOnly;
    }

    public void enableAngularMotor(boolean enableMotor, float targetVelocity, float maxMotorImpulse) {
        this.enableAngularMotor = enableMotor;
        this.motorTargetVelocity = targetVelocity;
        this.maxMotorImpulse = maxMotorImpulse;
    }

    public void setLimit(float low, float high) {
        this.setLimit(low, high, 0.9f, 0.3f, 1.0f);
    }

    public void setLimit(float low, float high, float _softness, float _biasFactor, float _relaxationFactor) {
        this.lowerLimit = low;
        this.upperLimit = high;
        this.limitSoftness = _softness;
        this.biasFactor = _biasFactor;
        this.relaxationFactor = _relaxationFactor;
    }

    public float getLowerLimit() {
        return this.lowerLimit;
    }

    public float getUpperLimit() {
        return this.upperLimit;
    }

    public Transform getAFrame(Transform out) {
        out.set(this.rbAFrame);
        return out;
    }

    public Transform getBFrame(Transform out) {
        out.set(this.rbBFrame);
        return out;
    }

    public boolean getSolveLimit() {
        return this.solveLimit;
    }

    public float getLimitSign() {
        return this.limitSign;
    }

    public boolean getAngularOnly() {
        return this.angularOnly;
    }

    public boolean getEnableAngularMotor() {
        return this.enableAngularMotor;
    }

    public float getMotorTargetVelosity() {
        return this.motorTargetVelocity;
    }

    public float getMaxMotorImpulse() {
        return this.maxMotorImpulse;
    }
}

