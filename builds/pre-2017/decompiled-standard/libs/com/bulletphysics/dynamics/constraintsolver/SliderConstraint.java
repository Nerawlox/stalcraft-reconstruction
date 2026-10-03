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
import javax.vecmath.Vector3f;

public class SliderConstraint
extends TypedConstraint {
    public static final float SLIDER_CONSTRAINT_DEF_SOFTNESS = 1.0f;
    public static final float SLIDER_CONSTRAINT_DEF_DAMPING = 1.0f;
    public static final float SLIDER_CONSTRAINT_DEF_RESTITUTION = 0.7f;
    protected final Transform frameInA = new Transform();
    protected final Transform frameInB = new Transform();
    protected boolean useLinearReferenceFrameA;
    protected float lowerLinLimit;
    protected float upperLinLimit;
    protected float lowerAngLimit;
    protected float upperAngLimit;
    protected float softnessDirLin;
    protected float restitutionDirLin;
    protected float dampingDirLin;
    protected float softnessDirAng;
    protected float restitutionDirAng;
    protected float dampingDirAng;
    protected float softnessLimLin;
    protected float restitutionLimLin;
    protected float dampingLimLin;
    protected float softnessLimAng;
    protected float restitutionLimAng;
    protected float dampingLimAng;
    protected float softnessOrthoLin;
    protected float restitutionOrthoLin;
    protected float dampingOrthoLin;
    protected float softnessOrthoAng;
    protected float restitutionOrthoAng;
    protected float dampingOrthoAng;
    protected boolean solveLinLim;
    protected boolean solveAngLim;
    protected JacobianEntry[] jacLin = new JacobianEntry[]{new JacobianEntry(), new JacobianEntry(), new JacobianEntry()};
    protected float[] jacLinDiagABInv = new float[3];
    protected JacobianEntry[] jacAng = new JacobianEntry[]{new JacobianEntry(), new JacobianEntry(), new JacobianEntry()};
    protected float timeStep;
    protected final Transform calculatedTransformA = new Transform();
    protected final Transform calculatedTransformB = new Transform();
    protected final Vector3f sliderAxis = new Vector3f();
    protected final Vector3f realPivotAInW = new Vector3f();
    protected final Vector3f realPivotBInW = new Vector3f();
    protected final Vector3f projPivotInW = new Vector3f();
    protected final Vector3f delta = new Vector3f();
    protected final Vector3f depth = new Vector3f();
    protected final Vector3f relPosA = new Vector3f();
    protected final Vector3f relPosB = new Vector3f();
    protected float linPos;
    protected float angDepth;
    protected float kAngle;
    protected boolean poweredLinMotor;
    protected float targetLinMotorVelocity;
    protected float maxLinMotorForce;
    protected float accumulatedLinMotorImpulse;
    protected boolean poweredAngMotor;
    protected float targetAngMotorVelocity;
    protected float maxAngMotorForce;
    protected float accumulatedAngMotorImpulse;

    public SliderConstraint() {
        super(TypedConstraintType.SLIDER_CONSTRAINT_TYPE);
        this.useLinearReferenceFrameA = true;
        this.initParams();
    }

    public SliderConstraint(RigidBody rbA, RigidBody rbB, Transform frameInA, Transform frameInB, boolean useLinearReferenceFrameA) {
        super(TypedConstraintType.SLIDER_CONSTRAINT_TYPE, rbA, rbB);
        this.frameInA.set(frameInA);
        this.frameInB.set(frameInB);
        this.useLinearReferenceFrameA = useLinearReferenceFrameA;
        this.initParams();
    }

    protected void initParams() {
        this.lowerLinLimit = 1.0f;
        this.upperLinLimit = -1.0f;
        this.lowerAngLimit = 0.0f;
        this.upperAngLimit = 0.0f;
        this.softnessDirLin = 1.0f;
        this.restitutionDirLin = 0.7f;
        this.dampingDirLin = 0.0f;
        this.softnessDirAng = 1.0f;
        this.restitutionDirAng = 0.7f;
        this.dampingDirAng = 0.0f;
        this.softnessOrthoLin = 1.0f;
        this.restitutionOrthoLin = 0.7f;
        this.dampingOrthoLin = 1.0f;
        this.softnessOrthoAng = 1.0f;
        this.restitutionOrthoAng = 0.7f;
        this.dampingOrthoAng = 1.0f;
        this.softnessLimLin = 1.0f;
        this.restitutionLimLin = 0.7f;
        this.dampingLimLin = 1.0f;
        this.softnessLimAng = 1.0f;
        this.restitutionLimAng = 0.7f;
        this.dampingLimAng = 1.0f;
        this.poweredLinMotor = false;
        this.targetLinMotorVelocity = 0.0f;
        this.maxLinMotorForce = 0.0f;
        this.accumulatedLinMotorImpulse = 0.0f;
        this.poweredAngMotor = false;
        this.targetAngMotorVelocity = 0.0f;
        this.maxAngMotorForce = 0.0f;
        this.accumulatedAngMotorImpulse = 0.0f;
    }

    @Override
    public void buildJacobian() {
        if (this.useLinearReferenceFrameA) {
            this.buildJacobianInt(this.rbA, this.rbB, this.frameInA, this.frameInB);
        } else {
            this.buildJacobianInt(this.rbB, this.rbA, this.frameInB, this.frameInA);
        }
    }

    @Override
    public void solveConstraint(float timeStep) {
        this.timeStep = timeStep;
        if (this.useLinearReferenceFrameA) {
            this.solveConstraintInt(this.rbA, this.rbB);
        } else {
            this.solveConstraintInt(this.rbB, this.rbA);
        }
    }

    public Transform getCalculatedTransformA(Transform out) {
        out.set(this.calculatedTransformA);
        return out;
    }

    public Transform getCalculatedTransformB(Transform out) {
        out.set(this.calculatedTransformB);
        return out;
    }

    public Transform getFrameOffsetA(Transform out) {
        out.set(this.frameInA);
        return out;
    }

    public Transform getFrameOffsetB(Transform out) {
        out.set(this.frameInB);
        return out;
    }

    public float getLowerLinLimit() {
        return this.lowerLinLimit;
    }

    public void setLowerLinLimit(float lowerLimit) {
        this.lowerLinLimit = lowerLimit;
    }

    public float getUpperLinLimit() {
        return this.upperLinLimit;
    }

    public void setUpperLinLimit(float upperLimit) {
        this.upperLinLimit = upperLimit;
    }

    public float getLowerAngLimit() {
        return this.lowerAngLimit;
    }

    public void setLowerAngLimit(float lowerLimit) {
        this.lowerAngLimit = lowerLimit;
    }

    public float getUpperAngLimit() {
        return this.upperAngLimit;
    }

    public void setUpperAngLimit(float upperLimit) {
        this.upperAngLimit = upperLimit;
    }

    public boolean getUseLinearReferenceFrameA() {
        return this.useLinearReferenceFrameA;
    }

    public float getSoftnessDirLin() {
        return this.softnessDirLin;
    }

    public float getRestitutionDirLin() {
        return this.restitutionDirLin;
    }

    public float getDampingDirLin() {
        return this.dampingDirLin;
    }

    public float getSoftnessDirAng() {
        return this.softnessDirAng;
    }

    public float getRestitutionDirAng() {
        return this.restitutionDirAng;
    }

    public float getDampingDirAng() {
        return this.dampingDirAng;
    }

    public float getSoftnessLimLin() {
        return this.softnessLimLin;
    }

    public float getRestitutionLimLin() {
        return this.restitutionLimLin;
    }

    public float getDampingLimLin() {
        return this.dampingLimLin;
    }

    public float getSoftnessLimAng() {
        return this.softnessLimAng;
    }

    public float getRestitutionLimAng() {
        return this.restitutionLimAng;
    }

    public float getDampingLimAng() {
        return this.dampingLimAng;
    }

    public float getSoftnessOrthoLin() {
        return this.softnessOrthoLin;
    }

    public float getRestitutionOrthoLin() {
        return this.restitutionOrthoLin;
    }

    public float getDampingOrthoLin() {
        return this.dampingOrthoLin;
    }

    public float getSoftnessOrthoAng() {
        return this.softnessOrthoAng;
    }

    public float getRestitutionOrthoAng() {
        return this.restitutionOrthoAng;
    }

    public float getDampingOrthoAng() {
        return this.dampingOrthoAng;
    }

    public void setSoftnessDirLin(float softnessDirLin) {
        this.softnessDirLin = softnessDirLin;
    }

    public void setRestitutionDirLin(float restitutionDirLin) {
        this.restitutionDirLin = restitutionDirLin;
    }

    public void setDampingDirLin(float dampingDirLin) {
        this.dampingDirLin = dampingDirLin;
    }

    public void setSoftnessDirAng(float softnessDirAng) {
        this.softnessDirAng = softnessDirAng;
    }

    public void setRestitutionDirAng(float restitutionDirAng) {
        this.restitutionDirAng = restitutionDirAng;
    }

    public void setDampingDirAng(float dampingDirAng) {
        this.dampingDirAng = dampingDirAng;
    }

    public void setSoftnessLimLin(float softnessLimLin) {
        this.softnessLimLin = softnessLimLin;
    }

    public void setRestitutionLimLin(float restitutionLimLin) {
        this.restitutionLimLin = restitutionLimLin;
    }

    public void setDampingLimLin(float dampingLimLin) {
        this.dampingLimLin = dampingLimLin;
    }

    public void setSoftnessLimAng(float softnessLimAng) {
        this.softnessLimAng = softnessLimAng;
    }

    public void setRestitutionLimAng(float restitutionLimAng) {
        this.restitutionLimAng = restitutionLimAng;
    }

    public void setDampingLimAng(float dampingLimAng) {
        this.dampingLimAng = dampingLimAng;
    }

    public void setSoftnessOrthoLin(float softnessOrthoLin) {
        this.softnessOrthoLin = softnessOrthoLin;
    }

    public void setRestitutionOrthoLin(float restitutionOrthoLin) {
        this.restitutionOrthoLin = restitutionOrthoLin;
    }

    public void setDampingOrthoLin(float dampingOrthoLin) {
        this.dampingOrthoLin = dampingOrthoLin;
    }

    public void setSoftnessOrthoAng(float softnessOrthoAng) {
        this.softnessOrthoAng = softnessOrthoAng;
    }

    public void setRestitutionOrthoAng(float restitutionOrthoAng) {
        this.restitutionOrthoAng = restitutionOrthoAng;
    }

    public void setDampingOrthoAng(float dampingOrthoAng) {
        this.dampingOrthoAng = dampingOrthoAng;
    }

    public void setPoweredLinMotor(boolean onOff) {
        this.poweredLinMotor = onOff;
    }

    public boolean getPoweredLinMotor() {
        return this.poweredLinMotor;
    }

    public void setTargetLinMotorVelocity(float targetLinMotorVelocity) {
        this.targetLinMotorVelocity = targetLinMotorVelocity;
    }

    public float getTargetLinMotorVelocity() {
        return this.targetLinMotorVelocity;
    }

    public void setMaxLinMotorForce(float maxLinMotorForce) {
        this.maxLinMotorForce = maxLinMotorForce;
    }

    public float getMaxLinMotorForce() {
        return this.maxLinMotorForce;
    }

    public void setPoweredAngMotor(boolean onOff) {
        this.poweredAngMotor = onOff;
    }

    public boolean getPoweredAngMotor() {
        return this.poweredAngMotor;
    }

    public void setTargetAngMotorVelocity(float targetAngMotorVelocity) {
        this.targetAngMotorVelocity = targetAngMotorVelocity;
    }

    public float getTargetAngMotorVelocity() {
        return this.targetAngMotorVelocity;
    }

    public void setMaxAngMotorForce(float maxAngMotorForce) {
        this.maxAngMotorForce = maxAngMotorForce;
    }

    public float getMaxAngMotorForce() {
        return this.maxAngMotorForce;
    }

    public float getLinearPos() {
        return this.linPos;
    }

    public boolean getSolveLinLimit() {
        return this.solveLinLim;
    }

    public float getLinDepth() {
        return this.depth.x;
    }

    public boolean getSolveAngLimit() {
        return this.solveAngLim;
    }

    public float getAngDepth() {
        return this.angDepth;
    }

    /*
     * WARNING - void declaration
     */
    public void buildJacobianInt(RigidBody rigidBody, RigidBody rigidBody2, Transform transform, Transform transform2) {
        $Stack $Stack = $Stack.get();
        try {
            Matrix3f mat2;
            Matrix3f mat1;
            int i;
            void frameInB;
            void rbB;
            void frameInA;
            void rbA;
            $Stack $Stack2 = $Stack;
            $Stack2.push$com$bulletphysics$linearmath$Transform();
            $Stack2.push$javax$vecmath$Vector3f();
            Transform tmpTrans = $Stack.get$com$bulletphysics$linearmath$Transform();
            Transform tmpTrans1 = $Stack.get$com$bulletphysics$linearmath$Transform();
            Transform tmpTrans2 = $Stack.get$com$bulletphysics$linearmath$Transform();
            Vector3f tmp = $Stack.get$javax$vecmath$Vector3f();
            Vector3f tmp2 = $Stack.get$javax$vecmath$Vector3f();
            this.calculatedTransformA.mul(rbA.getCenterOfMassTransform(tmpTrans), (Transform)frameInA);
            this.calculatedTransformB.mul(rbB.getCenterOfMassTransform(tmpTrans), (Transform)frameInB);
            this.realPivotAInW.set(this.calculatedTransformA.origin);
            this.realPivotBInW.set(this.calculatedTransformB.origin);
            this.calculatedTransformA.basis.getColumn(0, tmp);
            this.sliderAxis.set(tmp);
            this.delta.sub(this.realPivotBInW, this.realPivotAInW);
            this.projPivotInW.scaleAdd(this.sliderAxis.dot(this.delta), this.sliderAxis, this.realPivotAInW);
            this.relPosA.sub(this.projPivotInW, rbA.getCenterOfMassPosition(tmp));
            this.relPosB.sub(this.realPivotBInW, rbB.getCenterOfMassPosition(tmp));
            Vector3f normalWorld = $Stack.get$javax$vecmath$Vector3f();
            for (i = 0; i < 3; ++i) {
                this.calculatedTransformA.basis.getColumn(i, normalWorld);
                mat1 = rbA.getCenterOfMassTransform((Transform)tmpTrans1).basis;
                mat1.transpose();
                mat2 = rbB.getCenterOfMassTransform((Transform)tmpTrans2).basis;
                mat2.transpose();
                this.jacLin[i].init(mat1, mat2, this.relPosA, this.relPosB, normalWorld, rbA.getInvInertiaDiagLocal(tmp), rbA.getInvMass(), rbB.getInvInertiaDiagLocal(tmp2), rbB.getInvMass());
                this.jacLinDiagABInv[i] = 1.0f / this.jacLin[i].getDiagonal();
                VectorUtil.setCoord(this.depth, i, this.delta.dot(normalWorld));
            }
            this.testLinLimits();
            for (i = 0; i < 3; ++i) {
                this.calculatedTransformA.basis.getColumn(i, normalWorld);
                mat1 = rbA.getCenterOfMassTransform((Transform)tmpTrans1).basis;
                mat1.transpose();
                mat2 = rbB.getCenterOfMassTransform((Transform)tmpTrans2).basis;
                mat2.transpose();
                this.jacAng[i].init(normalWorld, mat1, mat2, rbA.getInvInertiaDiagLocal(tmp), rbB.getInvInertiaDiagLocal(tmp2));
            }
            this.testAngLimits();
            Vector3f axisA = $Stack.get$javax$vecmath$Vector3f();
            this.calculatedTransformA.basis.getColumn(0, axisA);
            this.kAngle = 1.0f / (rbA.computeAngularImpulseDenominator(axisA) + rbB.computeAngularImpulseDenominator(axisA));
            this.accumulatedLinMotorImpulse = 0.0f;
            this.accumulatedAngMotorImpulse = 0.0f;
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
    public void solveConstraintInt(RigidBody rigidBody, RigidBody rigidBody2) {
        $Stack $Stack = $Stack.get();
        try {
            float impulseMag;
            void rbB;
            void rbA;
            $Stack.push$javax$vecmath$Vector3f();
            Vector3f tmp = $Stack.get$javax$vecmath$Vector3f();
            Vector3f velA = rbA.getVelocityInLocalPoint(this.relPosA, $Stack.get$javax$vecmath$Vector3f());
            Vector3f velB = rbB.getVelocityInLocalPoint(this.relPosB, $Stack.get$javax$vecmath$Vector3f());
            Vector3f vel = $Stack.get$javax$vecmath$Vector3f();
            vel.sub(velA, velB);
            Vector3f impulse_vector = $Stack.get$javax$vecmath$Vector3f();
            for (int i = 0; i < 3; ++i) {
                float restitution;
                float softness;
                Vector3f normal = this.jacLin[i].linearJointAxis;
                float rel_vel = normal.dot(vel);
                float depth = VectorUtil.getCoord(this.depth, i);
                float f = i != 0 ? this.softnessOrthoLin : (softness = this.solveLinLim ? this.softnessLimLin : this.softnessDirLin);
                float f2 = i != 0 ? this.restitutionOrthoLin : (restitution = this.solveLinLim ? this.restitutionLimLin : this.restitutionDirLin);
                float damping = i != 0 ? this.dampingOrthoLin : (this.solveLinLim ? this.dampingLimLin : this.dampingDirLin);
                float normalImpulse = softness * (restitution * depth / this.timeStep - damping * rel_vel) * this.jacLinDiagABInv[i];
                impulse_vector.scale(normalImpulse, normal);
                rbA.applyImpulse(impulse_vector, this.relPosA);
                tmp.negate(impulse_vector);
                rbB.applyImpulse(tmp, this.relPosB);
                if (!this.poweredLinMotor || i != 0 || !(this.accumulatedLinMotorImpulse < this.maxLinMotorForce)) continue;
                float desiredMotorVel = this.targetLinMotorVelocity;
                float motor_relvel = desiredMotorVel + rel_vel;
                normalImpulse = -motor_relvel * this.jacLinDiagABInv[i];
                float new_acc = this.accumulatedLinMotorImpulse + Math.abs(normalImpulse);
                if (new_acc > this.maxLinMotorForce) {
                    new_acc = this.maxLinMotorForce;
                }
                float del = new_acc - this.accumulatedLinMotorImpulse;
                normalImpulse = normalImpulse < 0.0f ? -del : del;
                this.accumulatedLinMotorImpulse = new_acc;
                impulse_vector.scale(normalImpulse, normal);
                rbA.applyImpulse(impulse_vector, this.relPosA);
                tmp.negate(impulse_vector);
                rbB.applyImpulse(tmp, this.relPosB);
            }
            Vector3f axisA = $Stack.get$javax$vecmath$Vector3f();
            this.calculatedTransformA.basis.getColumn(0, axisA);
            Vector3f axisB = $Stack.get$javax$vecmath$Vector3f();
            this.calculatedTransformB.basis.getColumn(0, axisB);
            Vector3f angVelA = rbA.getAngularVelocity($Stack.get$javax$vecmath$Vector3f());
            Vector3f angVelB = rbB.getAngularVelocity($Stack.get$javax$vecmath$Vector3f());
            Vector3f angVelAroundAxisA = $Stack.get$javax$vecmath$Vector3f();
            angVelAroundAxisA.scale(axisA.dot(angVelA), axisA);
            Vector3f angVelAroundAxisB = $Stack.get$javax$vecmath$Vector3f();
            angVelAroundAxisB.scale(axisB.dot(angVelB), axisB);
            Vector3f angAorthog = $Stack.get$javax$vecmath$Vector3f();
            angAorthog.sub(angVelA, angVelAroundAxisA);
            Vector3f angBorthog = $Stack.get$javax$vecmath$Vector3f();
            angBorthog.sub(angVelB, angVelAroundAxisB);
            Vector3f velrelOrthog = $Stack.get$javax$vecmath$Vector3f();
            velrelOrthog.sub(angAorthog, angBorthog);
            float len = velrelOrthog.length();
            if (len > 1.0E-5f) {
                Vector3f normal = $Stack.get$javax$vecmath$Vector3f();
                normal.normalize(velrelOrthog);
                float denom = rbA.computeAngularImpulseDenominator(normal) + rbB.computeAngularImpulseDenominator(normal);
                velrelOrthog.scale(1.0f / denom * this.dampingOrthoAng * this.softnessOrthoAng);
            }
            Vector3f angularError = $Stack.get$javax$vecmath$Vector3f();
            angularError.cross(axisA, axisB);
            angularError.scale(1.0f / this.timeStep);
            float len2 = angularError.length();
            if (len2 > 1.0E-5f) {
                Vector3f normal2 = $Stack.get$javax$vecmath$Vector3f();
                normal2.normalize(angularError);
                float denom2 = rbA.computeAngularImpulseDenominator(normal2) + rbB.computeAngularImpulseDenominator(normal2);
                angularError.scale(1.0f / denom2 * this.restitutionOrthoAng * this.softnessOrthoAng);
            }
            tmp.negate(velrelOrthog);
            tmp.add(angularError);
            rbA.applyTorqueImpulse(tmp);
            tmp.sub(velrelOrthog, angularError);
            rbB.applyTorqueImpulse(tmp);
            if (this.solveAngLim) {
                tmp.sub(angVelB, angVelA);
                impulseMag = tmp.dot(axisA) * this.dampingLimAng + this.angDepth * this.restitutionLimAng / this.timeStep;
                impulseMag *= this.kAngle * this.softnessLimAng;
            } else {
                tmp.sub(angVelB, angVelA);
                impulseMag = tmp.dot(axisA) * this.dampingDirAng + this.angDepth * this.restitutionDirAng / this.timeStep;
                impulseMag *= this.kAngle * this.softnessDirAng;
            }
            Vector3f impulse = $Stack.get$javax$vecmath$Vector3f();
            impulse.scale(impulseMag, axisA);
            rbA.applyTorqueImpulse(impulse);
            tmp.negate(impulse);
            rbB.applyTorqueImpulse(tmp);
            if (this.poweredAngMotor && this.accumulatedAngMotorImpulse < this.maxAngMotorForce) {
                Vector3f velrel = $Stack.get$javax$vecmath$Vector3f();
                velrel.sub(angVelAroundAxisA, angVelAroundAxisB);
                float projRelVel = velrel.dot(axisA);
                float desiredMotorVel = this.targetAngMotorVelocity;
                float motor_relvel = desiredMotorVel - projRelVel;
                float angImpulse = this.kAngle * motor_relvel;
                float new_acc = this.accumulatedAngMotorImpulse + Math.abs(angImpulse);
                if (new_acc > this.maxAngMotorForce) {
                    new_acc = this.maxAngMotorForce;
                }
                float del = new_acc - this.accumulatedAngMotorImpulse;
                angImpulse = angImpulse < 0.0f ? -del : del;
                this.accumulatedAngMotorImpulse = new_acc;
                Vector3f motorImp = $Stack.get$javax$vecmath$Vector3f();
                motorImp.scale(angImpulse, axisA);
                rbA.applyTorqueImpulse(motorImp);
                tmp.negate(motorImp);
                rbB.applyTorqueImpulse(tmp);
            }
            $Stack.pop$javax$vecmath$Vector3f();
            return;
        }
        catch (Throwable throwable) {
            $Stack.pop$javax$vecmath$Vector3f();
            throw throwable;
        }
    }

    public void calculateTransforms() {
        $Stack $Stack = $Stack.get();
        try {
            $Stack $Stack2 = $Stack;
            $Stack2.push$com$bulletphysics$linearmath$Transform();
            $Stack2.push$javax$vecmath$Vector3f();
            Transform tmpTrans = $Stack.get$com$bulletphysics$linearmath$Transform();
            if (this.useLinearReferenceFrameA) {
                this.calculatedTransformA.mul(this.rbA.getCenterOfMassTransform(tmpTrans), this.frameInA);
                this.calculatedTransformB.mul(this.rbB.getCenterOfMassTransform(tmpTrans), this.frameInB);
            } else {
                this.calculatedTransformA.mul(this.rbB.getCenterOfMassTransform(tmpTrans), this.frameInB);
                this.calculatedTransformB.mul(this.rbA.getCenterOfMassTransform(tmpTrans), this.frameInA);
            }
            this.realPivotAInW.set(this.calculatedTransformA.origin);
            this.realPivotBInW.set(this.calculatedTransformB.origin);
            this.calculatedTransformA.basis.getColumn(0, this.sliderAxis);
            this.delta.sub(this.realPivotBInW, this.realPivotAInW);
            this.projPivotInW.scaleAdd(this.sliderAxis.dot(this.delta), this.sliderAxis, this.realPivotAInW);
            Vector3f normalWorld = $Stack.get$javax$vecmath$Vector3f();
            for (int i = 0; i < 3; ++i) {
                this.calculatedTransformA.basis.getColumn(i, normalWorld);
                VectorUtil.setCoord(this.depth, i, this.delta.dot(normalWorld));
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

    public void testLinLimits() {
        this.solveLinLim = false;
        this.linPos = this.depth.x;
        if (this.lowerLinLimit <= this.upperLinLimit) {
            if (this.depth.x > this.upperLinLimit) {
                this.depth.x -= this.upperLinLimit;
                this.solveLinLim = true;
            } else if (this.depth.x < this.lowerLinLimit) {
                this.depth.x -= this.lowerLinLimit;
                this.solveLinLim = true;
            } else {
                this.depth.x = 0.0f;
            }
        } else {
            this.depth.x = 0.0f;
        }
    }

    public void testAngLimits() {
        $Stack $Stack = $Stack.get();
        try {
            $Stack.push$javax$vecmath$Vector3f();
            this.angDepth = 0.0f;
            this.solveAngLim = false;
            if (this.lowerAngLimit <= this.upperAngLimit) {
                Vector3f axisA0 = $Stack.get$javax$vecmath$Vector3f();
                this.calculatedTransformA.basis.getColumn(1, axisA0);
                Vector3f axisA1 = $Stack.get$javax$vecmath$Vector3f();
                this.calculatedTransformA.basis.getColumn(2, axisA1);
                Vector3f axisB0 = $Stack.get$javax$vecmath$Vector3f();
                this.calculatedTransformB.basis.getColumn(1, axisB0);
                float rot = (float)Math.atan2(axisB0.dot(axisA1), axisB0.dot(axisA0));
                if (rot < this.lowerAngLimit) {
                    this.angDepth = rot - this.lowerAngLimit;
                    this.solveAngLim = true;
                } else if (rot > this.upperAngLimit) {
                    this.angDepth = rot - this.upperAngLimit;
                    this.solveAngLim = true;
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
    public Vector3f getAncorInA(Vector3f vector3f) {
        $Stack $Stack = $Stack.get();
        try {
            void out;
            $Stack.push$com$bulletphysics$linearmath$Transform();
            Transform tmpTrans = $Stack.get$com$bulletphysics$linearmath$Transform();
            void ancorInA = out;
            ancorInA.scaleAdd((this.lowerLinLimit + this.upperLinLimit) * 0.5f, this.sliderAxis, this.realPivotAInW);
            this.rbA.getCenterOfMassTransform(tmpTrans);
            tmpTrans.inverse();
            tmpTrans.transform((Vector3f)ancorInA);
            $Stack.pop$com$bulletphysics$linearmath$Transform();
            return ancorInA;
        }
        catch (Throwable throwable) {
            $Stack.pop$com$bulletphysics$linearmath$Transform();
            throw throwable;
        }
    }

    public Vector3f getAncorInB(Vector3f out) {
        Vector3f ancorInB = out;
        ancorInB.set(this.frameInB.origin);
        return ancorInB;
    }
}

