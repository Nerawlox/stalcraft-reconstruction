/*
 * Decompiled with CFR 0.152.
 */
package com.bulletphysics.dynamics.constraintsolver;

import com.bulletphysics.$Stack;
import com.bulletphysics.dynamics.RigidBody;
import com.bulletphysics.linearmath.Transform;
import com.bulletphysics.linearmath.TransformUtil;
import javax.vecmath.Vector3f;

public class SolverBody {
    public final Vector3f angularVelocity = new Vector3f();
    public float angularFactor;
    public float invMass;
    public float friction;
    public RigidBody originalBody;
    public final Vector3f linearVelocity = new Vector3f();
    public final Vector3f centerOfMassPosition = new Vector3f();
    public final Vector3f pushVelocity = new Vector3f();
    public final Vector3f turnVelocity = new Vector3f();

    /*
     * WARNING - void declaration
     */
    public void getVelocityInLocalPoint(Vector3f vector3f, Vector3f vector3f2) {
        $Stack $Stack = $Stack.get();
        try {
            void velocity;
            void rel_pos;
            $Stack.push$javax$vecmath$Vector3f();
            Vector3f tmp = $Stack.get$javax$vecmath$Vector3f();
            tmp.cross(this.angularVelocity, (Vector3f)rel_pos);
            velocity.add(this.linearVelocity, tmp);
            $Stack.pop$javax$vecmath$Vector3f();
            return;
        }
        catch (Throwable throwable) {
            $Stack.pop$javax$vecmath$Vector3f();
            throw throwable;
        }
    }

    public void internalApplyImpulse(Vector3f linearComponent, Vector3f angularComponent, float impulseMagnitude) {
        if (this.invMass != 0.0f) {
            this.linearVelocity.scaleAdd(impulseMagnitude, linearComponent, this.linearVelocity);
            this.angularVelocity.scaleAdd(impulseMagnitude * this.angularFactor, angularComponent, this.angularVelocity);
        }
    }

    public void internalApplyPushImpulse(Vector3f linearComponent, Vector3f angularComponent, float impulseMagnitude) {
        if (this.invMass != 0.0f) {
            this.pushVelocity.scaleAdd(impulseMagnitude, linearComponent, this.pushVelocity);
            this.turnVelocity.scaleAdd(impulseMagnitude * this.angularFactor, angularComponent, this.turnVelocity);
        }
    }

    public void writebackVelocity() {
        if (this.invMass != 0.0f) {
            this.originalBody.setLinearVelocity(this.linearVelocity);
            this.originalBody.setAngularVelocity(this.angularVelocity);
        }
    }

    /*
     * WARNING - void declaration
     */
    public void writebackVelocity(float f) {
        $Stack $Stack = $Stack.get();
        try {
            $Stack.push$com$bulletphysics$linearmath$Transform();
            if (this.invMass != 0.0f) {
                void timeStep;
                this.originalBody.setLinearVelocity(this.linearVelocity);
                this.originalBody.setAngularVelocity(this.angularVelocity);
                Transform newTransform = $Stack.get$com$bulletphysics$linearmath$Transform();
                Transform curTrans = this.originalBody.getWorldTransform($Stack.get$com$bulletphysics$linearmath$Transform());
                TransformUtil.integrateTransform(curTrans, this.pushVelocity, this.turnVelocity, (float)timeStep, newTransform);
                this.originalBody.setWorldTransform(newTransform);
            }
            $Stack.pop$com$bulletphysics$linearmath$Transform();
            return;
        }
        catch (Throwable throwable) {
            $Stack.pop$com$bulletphysics$linearmath$Transform();
            throw throwable;
        }
    }

    public void readVelocity() {
        if (this.invMass != 0.0f) {
            this.originalBody.getLinearVelocity(this.linearVelocity);
            this.originalBody.getAngularVelocity(this.angularVelocity);
        }
    }
}

