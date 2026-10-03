/*
 * Decompiled with CFR 0.152.
 */
package com.bulletphysics.dynamics.constraintsolver;

public class ContactSolverInfo {
    public float tau = 0.6f;
    public float damping = 1.0f;
    public float friction = 0.3f;
    public float timeStep;
    public float restitution = 0.0f;
    public int numIterations = 10;
    public float maxErrorReduction = 20.0f;
    public float sor = 1.3f;
    public float erp = 0.2f;
    public float erp2 = 0.1f;
    public boolean splitImpulse = false;
    public float splitImpulsePenetrationThreshold = -0.02f;
    public float linearSlop = 0.0f;
    public float warmstartingFactor = 0.85f;
    public int solverMode = 13;

    public ContactSolverInfo() {
    }

    public ContactSolverInfo(ContactSolverInfo g) {
        this.tau = g.tau;
        this.damping = g.damping;
        this.friction = g.friction;
        this.timeStep = g.timeStep;
        this.restitution = g.restitution;
        this.numIterations = g.numIterations;
        this.maxErrorReduction = g.maxErrorReduction;
        this.sor = g.sor;
        this.erp = g.erp;
    }
}

