/*
 * Decompiled with CFR 0.152.
 */
package com.bulletphysics.dynamics.constraintsolver;

import com.bulletphysics.dynamics.constraintsolver.SolverConstraintType;
import javax.vecmath.Vector3f;

public class SolverConstraint {
    public final Vector3f relpos1CrossNormal = new Vector3f();
    public final Vector3f contactNormal = new Vector3f();
    public final Vector3f relpos2CrossNormal = new Vector3f();
    public final Vector3f angularComponentA = new Vector3f();
    public final Vector3f angularComponentB = new Vector3f();
    public float appliedPushImpulse;
    public float appliedImpulse;
    public int solverBodyIdA;
    public int solverBodyIdB;
    public float friction;
    public float restitution;
    public float jacDiagABInv;
    public float penetration;
    public SolverConstraintType constraintType;
    public int frictionIndex;
    public Object originalContactPoint;
}

