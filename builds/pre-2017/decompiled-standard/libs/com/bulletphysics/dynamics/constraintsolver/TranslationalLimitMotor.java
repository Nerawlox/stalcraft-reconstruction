/*
 * Decompiled with CFR 0.152.
 */
package com.bulletphysics.dynamics.constraintsolver;

import com.bulletphysics.$Stack;
import com.bulletphysics.dynamics.RigidBody;
import com.bulletphysics.linearmath.VectorUtil;
import javax.vecmath.Tuple3f;
import javax.vecmath.Vector3f;

public class TranslationalLimitMotor {
    public final Vector3f lowerLimit = new Vector3f();
    public final Vector3f upperLimit = new Vector3f();
    public final Vector3f accumulatedImpulse = new Vector3f();
    public float limitSoftness;
    public float damping;
    public float restitution;

    public TranslationalLimitMotor() {
        this.lowerLimit.set(0.0f, 0.0f, 0.0f);
        this.upperLimit.set(0.0f, 0.0f, 0.0f);
        this.accumulatedImpulse.set(0.0f, 0.0f, 0.0f);
        this.limitSoftness = 0.7f;
        this.damping = 1.0f;
        this.restitution = 0.5f;
    }

    public TranslationalLimitMotor(TranslationalLimitMotor other) {
        this.lowerLimit.set(other.lowerLimit);
        this.upperLimit.set(other.upperLimit);
        this.accumulatedImpulse.set(other.accumulatedImpulse);
        this.limitSoftness = other.limitSoftness;
        this.damping = other.damping;
        this.restitution = other.restitution;
    }

    public boolean isLimited(int limitIndex) {
        return VectorUtil.getCoord(this.upperLimit, limitIndex) >= VectorUtil.getCoord(this.lowerLimit, limitIndex);
    }

    /*
     * WARNING - void declaration
     */
    public float solveLinearAxis(float f, float f2, RigidBody rigidBody, Vector3f vector3f, RigidBody rigidBody2, Vector3f vector3f2, int n, Vector3f vector3f3, Vector3f vector3f4) {
        $Stack $Stack = $Stack.get();
        try {
            void jacDiagABInv;
            void timeStep;
            void limit_index;
            void pointInB;
            void pointInA;
            void axis_normal_on_a;
            void body2;
            void body1;
            void anchorPos;
            $Stack.push$javax$vecmath$Vector3f();
            Vector3f tmp = $Stack.get$javax$vecmath$Vector3f();
            Vector3f tmpVec = $Stack.get$javax$vecmath$Vector3f();
            Vector3f rel_pos1 = $Stack.get$javax$vecmath$Vector3f();
            rel_pos1.sub((Tuple3f)anchorPos, body1.getCenterOfMassPosition(tmpVec));
            Vector3f rel_pos2 = $Stack.get$javax$vecmath$Vector3f();
            rel_pos2.sub((Tuple3f)anchorPos, body2.getCenterOfMassPosition(tmpVec));
            Vector3f vel1 = body1.getVelocityInLocalPoint(rel_pos1, $Stack.get$javax$vecmath$Vector3f());
            Vector3f vel2 = body2.getVelocityInLocalPoint(rel_pos2, $Stack.get$javax$vecmath$Vector3f());
            Vector3f vel = $Stack.get$javax$vecmath$Vector3f();
            vel.sub(vel1, vel2);
            float rel_vel = axis_normal_on_a.dot(vel);
            tmp.sub((Tuple3f)pointInA, (Tuple3f)pointInB);
            float depth = -tmp.dot((Vector3f)axis_normal_on_a);
            float lo = -1.0E30f;
            float hi = 1.0E30f;
            float minLimit = VectorUtil.getCoord(this.lowerLimit, (int)limit_index);
            float maxLimit = VectorUtil.getCoord(this.upperLimit, (int)limit_index);
            if (minLimit < maxLimit) {
                if (depth > maxLimit) {
                    depth -= maxLimit;
                    lo = 0.0f;
                } else if (depth < minLimit) {
                    depth -= minLimit;
                    hi = 0.0f;
                } else {
                    $Stack.pop$javax$vecmath$Vector3f();
                    return 0.0f;
                }
            }
            float normalImpulse = this.limitSoftness * (this.restitution * depth / timeStep - this.damping * rel_vel) * jacDiagABInv;
            float oldNormalImpulse = VectorUtil.getCoord(this.accumulatedImpulse, (int)limit_index);
            float sum = oldNormalImpulse + normalImpulse;
            VectorUtil.setCoord(this.accumulatedImpulse, (int)limit_index, sum > hi ? 0.0f : (sum < lo ? 0.0f : sum));
            normalImpulse = VectorUtil.getCoord(this.accumulatedImpulse, (int)limit_index) - oldNormalImpulse;
            Vector3f impulse_vector = $Stack.get$javax$vecmath$Vector3f();
            impulse_vector.scale(normalImpulse, (Tuple3f)axis_normal_on_a);
            body1.applyImpulse(impulse_vector, rel_pos1);
            tmp.negate(impulse_vector);
            body2.applyImpulse(tmp, rel_pos2);
            $Stack.pop$javax$vecmath$Vector3f();
            return normalImpulse;
        }
        catch (Throwable throwable) {
            $Stack.pop$javax$vecmath$Vector3f();
            throw throwable;
        }
    }
}

