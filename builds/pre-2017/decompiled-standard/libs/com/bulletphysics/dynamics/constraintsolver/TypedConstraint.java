/*
 * Decompiled with CFR 0.152.
 */
package com.bulletphysics.dynamics.constraintsolver;

import com.bulletphysics.dynamics.RigidBody;
import com.bulletphysics.dynamics.constraintsolver.TypedConstraintType;
import javax.vecmath.Vector3f;

public abstract class TypedConstraint {
    private static RigidBody s_fixed;
    private int userConstraintType = -1;
    private int userConstraintId = -1;
    private TypedConstraintType constraintType;
    protected RigidBody rbA;
    protected RigidBody rbB;
    protected float appliedImpulse = 0.0f;

    private static synchronized RigidBody getFixed() {
        if (s_fixed == null) {
            s_fixed = new RigidBody(0.0f, null, null);
        }
        return s_fixed;
    }

    public TypedConstraint(TypedConstraintType type2) {
        this(type2, TypedConstraint.getFixed(), TypedConstraint.getFixed());
    }

    public TypedConstraint(TypedConstraintType type2, RigidBody rbA) {
        this(type2, rbA, TypedConstraint.getFixed());
    }

    public TypedConstraint(TypedConstraintType type2, RigidBody rbA, RigidBody rbB) {
        this.constraintType = type2;
        this.rbA = rbA;
        this.rbB = rbB;
        TypedConstraint.getFixed().setMassProps(0.0f, new Vector3f(0.0f, 0.0f, 0.0f));
    }

    public abstract void buildJacobian();

    public abstract void solveConstraint(float var1);

    public RigidBody getRigidBodyA() {
        return this.rbA;
    }

    public RigidBody getRigidBodyB() {
        return this.rbB;
    }

    public int getUserConstraintType() {
        return this.userConstraintType;
    }

    public void setUserConstraintType(int userConstraintType) {
        this.userConstraintType = userConstraintType;
    }

    public int getUserConstraintId() {
        return this.userConstraintId;
    }

    public int getUid() {
        return this.userConstraintId;
    }

    public void setUserConstraintId(int userConstraintId) {
        this.userConstraintId = userConstraintId;
    }

    public float getAppliedImpulse() {
        return this.appliedImpulse;
    }

    public TypedConstraintType getConstraintType() {
        return this.constraintType;
    }
}

