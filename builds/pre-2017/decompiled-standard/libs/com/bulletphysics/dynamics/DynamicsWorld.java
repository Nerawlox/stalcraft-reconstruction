/*
 * Decompiled with CFR 0.152.
 */
package com.bulletphysics.dynamics;

import com.bulletphysics.collision.broadphase.BroadphaseInterface;
import com.bulletphysics.collision.broadphase.Dispatcher;
import com.bulletphysics.collision.dispatch.CollisionConfiguration;
import com.bulletphysics.collision.dispatch.CollisionWorld;
import com.bulletphysics.dynamics.ActionInterface;
import com.bulletphysics.dynamics.DynamicsWorldType;
import com.bulletphysics.dynamics.InternalTickCallback;
import com.bulletphysics.dynamics.RigidBody;
import com.bulletphysics.dynamics.constraintsolver.ConstraintSolver;
import com.bulletphysics.dynamics.constraintsolver.ContactSolverInfo;
import com.bulletphysics.dynamics.constraintsolver.TypedConstraint;
import com.bulletphysics.dynamics.vehicle.RaycastVehicle;
import javax.vecmath.Vector3f;

public abstract class DynamicsWorld
extends CollisionWorld {
    protected InternalTickCallback internalTickCallback;
    protected Object worldUserInfo;
    protected final ContactSolverInfo solverInfo = new ContactSolverInfo();

    public DynamicsWorld(Dispatcher dispatcher, BroadphaseInterface broadphasePairCache, CollisionConfiguration collisionConfiguration) {
        super(dispatcher, broadphasePairCache, collisionConfiguration);
    }

    public final int stepSimulation(float timeStep) {
        return this.stepSimulation(timeStep, 1, 0.016666668f);
    }

    public final int stepSimulation(float timeStep, int maxSubSteps) {
        return this.stepSimulation(timeStep, maxSubSteps, 0.016666668f);
    }

    public abstract int stepSimulation(float var1, int var2, float var3);

    public abstract void debugDrawWorld();

    public final void addConstraint(TypedConstraint constraint) {
        this.addConstraint(constraint, false);
    }

    public void addConstraint(TypedConstraint constraint, boolean disableCollisionsBetweenLinkedBodies) {
    }

    public void removeConstraint(TypedConstraint constraint) {
    }

    public void addAction(ActionInterface action) {
    }

    public void removeAction(ActionInterface action) {
    }

    public void addVehicle(RaycastVehicle vehicle) {
    }

    public void removeVehicle(RaycastVehicle vehicle) {
    }

    public abstract void setGravity(Vector3f var1);

    public abstract Vector3f getGravity(Vector3f var1);

    public abstract void addRigidBody(RigidBody var1);

    public abstract void removeRigidBody(RigidBody var1);

    public abstract void setConstraintSolver(ConstraintSolver var1);

    public abstract ConstraintSolver getConstraintSolver();

    public int getNumConstraints() {
        return 0;
    }

    public TypedConstraint getConstraint(int index) {
        return null;
    }

    public int getNumActions() {
        return 0;
    }

    public ActionInterface getAction(int index) {
        return null;
    }

    public abstract DynamicsWorldType getWorldType();

    public abstract void clearForces();

    public void setInternalTickCallback(InternalTickCallback cb, Object worldUserInfo) {
        this.internalTickCallback = cb;
        this.worldUserInfo = worldUserInfo;
    }

    public void setWorldUserInfo(Object worldUserInfo) {
        this.worldUserInfo = worldUserInfo;
    }

    public Object getWorldUserInfo() {
        return this.worldUserInfo;
    }

    public ContactSolverInfo getSolverInfo() {
        return this.solverInfo;
    }
}

