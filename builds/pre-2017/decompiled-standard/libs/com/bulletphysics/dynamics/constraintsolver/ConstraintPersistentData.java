/*
 * Decompiled with CFR 0.152.
 */
package com.bulletphysics.dynamics.constraintsolver;

import com.bulletphysics.dynamics.constraintsolver.ContactSolverFunc;
import javax.vecmath.Vector3f;

public class ConstraintPersistentData {
    public float appliedImpulse = 0.0f;
    public float prevAppliedImpulse = 0.0f;
    public float accumulatedTangentImpulse0 = 0.0f;
    public float accumulatedTangentImpulse1 = 0.0f;
    public float jacDiagABInv = 0.0f;
    public float jacDiagABInvTangent0;
    public float jacDiagABInvTangent1;
    public int persistentLifeTime = 0;
    public float restitution = 0.0f;
    public float friction = 0.0f;
    public float penetration = 0.0f;
    public final Vector3f frictionWorldTangential0 = new Vector3f();
    public final Vector3f frictionWorldTangential1 = new Vector3f();
    public final Vector3f frictionAngularComponent0A = new Vector3f();
    public final Vector3f frictionAngularComponent0B = new Vector3f();
    public final Vector3f frictionAngularComponent1A = new Vector3f();
    public final Vector3f frictionAngularComponent1B = new Vector3f();
    public final Vector3f angularComponentA = new Vector3f();
    public final Vector3f angularComponentB = new Vector3f();
    public ContactSolverFunc contactSolverFunc = null;
    public ContactSolverFunc frictionSolverFunc = null;

    public void reset() {
        this.appliedImpulse = 0.0f;
        this.prevAppliedImpulse = 0.0f;
        this.accumulatedTangentImpulse0 = 0.0f;
        this.accumulatedTangentImpulse1 = 0.0f;
        this.jacDiagABInv = 0.0f;
        this.jacDiagABInvTangent0 = 0.0f;
        this.jacDiagABInvTangent1 = 0.0f;
        this.persistentLifeTime = 0;
        this.restitution = 0.0f;
        this.friction = 0.0f;
        this.penetration = 0.0f;
        this.frictionWorldTangential0.set(0.0f, 0.0f, 0.0f);
        this.frictionWorldTangential1.set(0.0f, 0.0f, 0.0f);
        this.frictionAngularComponent0A.set(0.0f, 0.0f, 0.0f);
        this.frictionAngularComponent0B.set(0.0f, 0.0f, 0.0f);
        this.frictionAngularComponent1A.set(0.0f, 0.0f, 0.0f);
        this.frictionAngularComponent1B.set(0.0f, 0.0f, 0.0f);
        this.angularComponentA.set(0.0f, 0.0f, 0.0f);
        this.angularComponentB.set(0.0f, 0.0f, 0.0f);
        this.contactSolverFunc = null;
        this.frictionSolverFunc = null;
    }
}

