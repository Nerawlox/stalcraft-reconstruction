/*
 * Decompiled with CFR 0.152.
 */
package com.bulletphysics.dynamics.constraintsolver;

import com.bulletphysics.$Stack;
import com.bulletphysics.dynamics.RigidBody;
import javax.vecmath.Tuple3f;
import javax.vecmath.Vector3f;

public class RotationalLimitMotor {
    public float loLimit;
    public float hiLimit;
    public float targetVelocity;
    public float maxMotorForce;
    public float maxLimitForce;
    public float damping;
    public float limitSoftness;
    public float ERP;
    public float bounce;
    public boolean enableMotor;
    public float currentLimitError;
    public int currentLimit;
    public float accumulatedImpulse;

    public RotationalLimitMotor() {
        this.accumulatedImpulse = 0.0f;
        this.targetVelocity = 0.0f;
        this.maxMotorForce = 0.1f;
        this.maxLimitForce = 300.0f;
        this.loLimit = -3.4028235E38f;
        this.hiLimit = Float.MAX_VALUE;
        this.ERP = 0.5f;
        this.bounce = 0.0f;
        this.damping = 1.0f;
        this.limitSoftness = 0.5f;
        this.currentLimit = 0;
        this.currentLimitError = 0.0f;
        this.enableMotor = false;
    }

    public RotationalLimitMotor(RotationalLimitMotor limot) {
        this.targetVelocity = limot.targetVelocity;
        this.maxMotorForce = limot.maxMotorForce;
        this.limitSoftness = limot.limitSoftness;
        this.loLimit = limot.loLimit;
        this.hiLimit = limot.hiLimit;
        this.ERP = limot.ERP;
        this.bounce = limot.bounce;
        this.currentLimit = limot.currentLimit;
        this.currentLimitError = limot.currentLimitError;
        this.enableMotor = limot.enableMotor;
    }

    public boolean isLimited() {
        return !(this.loLimit >= this.hiLimit);
    }

    public boolean needApplyTorques() {
        return this.currentLimit != 0 || this.enableMotor;
    }

    public int testLimitValue(float test_value) {
        if (this.loLimit > this.hiLimit) {
            this.currentLimit = 0;
            return 0;
        }
        if (test_value < this.loLimit) {
            this.currentLimit = 1;
            this.currentLimitError = test_value - this.loLimit;
            return 1;
        }
        if (test_value > this.hiLimit) {
            this.currentLimit = 2;
            this.currentLimitError = test_value - this.hiLimit;
            return 2;
        }
        this.currentLimit = 0;
        return 0;
    }

    /*
     * WARNING - void declaration
     */
    public float solveAngularLimits(float f, Vector3f vector3f, float f2, RigidBody rigidBody, RigidBody rigidBody2) {
        $Stack $Stack = $Stack.get();
        try {
            void jacDiagABInv;
            void axis;
            float rel_vel;
            float motor_relvel;
            void body1;
            void body0;
            void timeStep;
            $Stack.push$javax$vecmath$Vector3f();
            if (!this.needApplyTorques()) {
                $Stack.pop$javax$vecmath$Vector3f();
                return 0.0f;
            }
            float target_velocity = this.targetVelocity;
            float maxMotorForce = this.maxMotorForce;
            if (this.currentLimit != 0) {
                target_velocity = -this.ERP * this.currentLimitError / timeStep;
                maxMotorForce = this.maxLimitForce;
            }
            maxMotorForce *= timeStep;
            Vector3f vel_diff = body0.getAngularVelocity($Stack.get$javax$vecmath$Vector3f());
            if (body1 != null) {
                vel_diff.sub(body1.getAngularVelocity($Stack.get$javax$vecmath$Vector3f()));
            }
            if ((motor_relvel = this.limitSoftness * (target_velocity - this.damping * (rel_vel = axis.dot(vel_diff)))) < 1.1920929E-7f && motor_relvel > -1.1920929E-7f) {
                $Stack.pop$javax$vecmath$Vector3f();
                return 0.0f;
            }
            float unclippedMotorImpulse = (1.0f + this.bounce) * motor_relvel * jacDiagABInv;
            float clippedMotorImpulse = unclippedMotorImpulse > 0.0f ? (unclippedMotorImpulse > maxMotorForce ? maxMotorForce : unclippedMotorImpulse) : (unclippedMotorImpulse < -maxMotorForce ? -maxMotorForce : unclippedMotorImpulse);
            float lo = -1.0E30f;
            float hi = 1.0E30f;
            float oldaccumImpulse = this.accumulatedImpulse;
            float sum = oldaccumImpulse + clippedMotorImpulse;
            this.accumulatedImpulse = sum > hi ? 0.0f : (sum < lo ? 0.0f : sum);
            clippedMotorImpulse = this.accumulatedImpulse - oldaccumImpulse;
            Vector3f motorImp = $Stack.get$javax$vecmath$Vector3f();
            motorImp.scale(clippedMotorImpulse, (Tuple3f)axis);
            body0.applyTorqueImpulse(motorImp);
            if (body1 != null) {
                motorImp.negate();
                body1.applyTorqueImpulse(motorImp);
            }
            $Stack.pop$javax$vecmath$Vector3f();
            return clippedMotorImpulse;
        }
        catch (Throwable throwable) {
            $Stack.pop$javax$vecmath$Vector3f();
            throw throwable;
        }
    }
}

