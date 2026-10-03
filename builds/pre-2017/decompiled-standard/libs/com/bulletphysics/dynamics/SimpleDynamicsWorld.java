/*
 * Decompiled with CFR 0.152.
 */
package com.bulletphysics.dynamics;

import com.bulletphysics.$Stack;
import com.bulletphysics.collision.broadphase.BroadphaseInterface;
import com.bulletphysics.collision.broadphase.Dispatcher;
import com.bulletphysics.collision.broadphase.DispatcherInfo;
import com.bulletphysics.collision.dispatch.CollisionConfiguration;
import com.bulletphysics.collision.dispatch.CollisionDispatcher;
import com.bulletphysics.collision.dispatch.CollisionObject;
import com.bulletphysics.collision.narrowphase.PersistentManifold;
import com.bulletphysics.dynamics.DynamicsWorld;
import com.bulletphysics.dynamics.DynamicsWorldType;
import com.bulletphysics.dynamics.RigidBody;
import com.bulletphysics.dynamics.constraintsolver.ConstraintSolver;
import com.bulletphysics.dynamics.constraintsolver.ContactSolverInfo;
import com.bulletphysics.linearmath.Transform;
import com.bulletphysics.util.ObjectArrayList;
import javax.vecmath.Vector3f;

public class SimpleDynamicsWorld
extends DynamicsWorld {
    protected ConstraintSolver constraintSolver;
    protected boolean ownsConstraintSolver;
    protected final Vector3f gravity = new Vector3f(0.0f, 0.0f, -10.0f);

    public SimpleDynamicsWorld(Dispatcher dispatcher, BroadphaseInterface pairCache, ConstraintSolver constraintSolver, CollisionConfiguration collisionConfiguration) {
        super(dispatcher, pairCache, collisionConfiguration);
        this.constraintSolver = constraintSolver;
        this.ownsConstraintSolver = false;
    }

    /*
     * WARNING - void declaration
     */
    protected void predictUnconstraintMotion(float f) {
        $Stack $Stack = $Stack.get();
        try {
            $Stack.push$com$bulletphysics$linearmath$Transform();
            Transform tmpTrans = $Stack.get$com$bulletphysics$linearmath$Transform();
            for (int i = 0; i < this.collisionObjects.size(); ++i) {
                void timeStep;
                CollisionObject colObj = (CollisionObject)this.collisionObjects.getQuick(i);
                RigidBody body = RigidBody.upcast(colObj);
                if (body == null || body.isStaticObject() || !body.isActive()) continue;
                body.applyGravity();
                body.integrateVelocities((float)timeStep);
                body.applyDamping((float)timeStep);
                body.predictIntegratedTransform((float)timeStep, body.getInterpolationWorldTransform(tmpTrans));
            }
            $Stack.pop$com$bulletphysics$linearmath$Transform();
            return;
        }
        catch (Throwable throwable) {
            $Stack.pop$com$bulletphysics$linearmath$Transform();
            throw throwable;
        }
    }

    /*
     * WARNING - void declaration
     */
    protected void integrateTransforms(float f) {
        $Stack $Stack = $Stack.get();
        try {
            $Stack.push$com$bulletphysics$linearmath$Transform();
            Transform predictedTrans = $Stack.get$com$bulletphysics$linearmath$Transform();
            for (int i = 0; i < this.collisionObjects.size(); ++i) {
                void timeStep;
                CollisionObject colObj = (CollisionObject)this.collisionObjects.getQuick(i);
                RigidBody body = RigidBody.upcast(colObj);
                if (body == null || !body.isActive() || body.isStaticObject()) continue;
                body.predictIntegratedTransform((float)timeStep, predictedTrans);
                body.proceedToTransform(predictedTrans);
            }
            $Stack.pop$com$bulletphysics$linearmath$Transform();
            return;
        }
        catch (Throwable throwable) {
            $Stack.pop$com$bulletphysics$linearmath$Transform();
            throw throwable;
        }
    }

    @Override
    public int stepSimulation(float timeStep, int maxSubSteps, float fixedTimeStep) {
        this.predictUnconstraintMotion(timeStep);
        DispatcherInfo dispatchInfo = this.getDispatchInfo();
        dispatchInfo.timeStep = timeStep;
        dispatchInfo.stepCount = 0;
        dispatchInfo.debugDraw = this.getDebugDrawer();
        this.performDiscreteCollisionDetection();
        int numManifolds = this.dispatcher1.getNumManifolds();
        if (numManifolds != 0) {
            ObjectArrayList<PersistentManifold> manifoldPtr = ((CollisionDispatcher)this.dispatcher1).getInternalManifoldPointer();
            ContactSolverInfo infoGlobal = new ContactSolverInfo();
            infoGlobal.timeStep = timeStep;
            this.constraintSolver.prepareSolve(0, numManifolds);
            this.constraintSolver.solveGroup(null, 0, manifoldPtr, 0, numManifolds, null, 0, 0, infoGlobal, this.debugDrawer, this.dispatcher1);
            this.constraintSolver.allSolved(infoGlobal, this.debugDrawer);
        }
        this.integrateTransforms(timeStep);
        this.updateAabbs();
        this.synchronizeMotionStates();
        this.clearForces();
        return 1;
    }

    @Override
    public void clearForces() {
        for (int i = 0; i < this.collisionObjects.size(); ++i) {
            CollisionObject colObj = (CollisionObject)this.collisionObjects.getQuick(i);
            RigidBody body = RigidBody.upcast(colObj);
            if (body == null) continue;
            body.clearForces();
        }
    }

    @Override
    public void setGravity(Vector3f gravity) {
        this.gravity.set(gravity);
        for (int i = 0; i < this.collisionObjects.size(); ++i) {
            CollisionObject colObj = (CollisionObject)this.collisionObjects.getQuick(i);
            RigidBody body = RigidBody.upcast(colObj);
            if (body == null) continue;
            body.setGravity(gravity);
        }
    }

    @Override
    public Vector3f getGravity(Vector3f out) {
        out.set(this.gravity);
        return out;
    }

    @Override
    public void addRigidBody(RigidBody body) {
        body.setGravity(this.gravity);
        if (body.getCollisionShape() != null) {
            this.addCollisionObject(body);
        }
    }

    @Override
    public void removeRigidBody(RigidBody body) {
        this.removeCollisionObject(body);
    }

    @Override
    public void updateAabbs() {
        $Stack $Stack = $Stack.get();
        try {
            $Stack $Stack2 = $Stack;
            $Stack2.push$com$bulletphysics$linearmath$Transform();
            $Stack2.push$javax$vecmath$Vector3f();
            Transform tmpTrans = $Stack.get$com$bulletphysics$linearmath$Transform();
            Transform predictedTrans = $Stack.get$com$bulletphysics$linearmath$Transform();
            Vector3f minAabb = $Stack.get$javax$vecmath$Vector3f();
            Vector3f maxAabb = $Stack.get$javax$vecmath$Vector3f();
            for (int i = 0; i < this.collisionObjects.size(); ++i) {
                CollisionObject colObj = (CollisionObject)this.collisionObjects.getQuick(i);
                RigidBody body = RigidBody.upcast(colObj);
                if (body == null || !body.isActive() || body.isStaticObject()) continue;
                colObj.getCollisionShape().getAabb(colObj.getWorldTransform(tmpTrans), minAabb, maxAabb);
                BroadphaseInterface bp = this.getBroadphase();
                bp.setAabb(body.getBroadphaseHandle(), minAabb, maxAabb, this.dispatcher1);
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

    public void synchronizeMotionStates() {
        $Stack $Stack = $Stack.get();
        try {
            $Stack.push$com$bulletphysics$linearmath$Transform();
            Transform tmpTrans = $Stack.get$com$bulletphysics$linearmath$Transform();
            for (int i = 0; i < this.collisionObjects.size(); ++i) {
                CollisionObject colObj = (CollisionObject)this.collisionObjects.getQuick(i);
                RigidBody body = RigidBody.upcast(colObj);
                if (body == null || body.getMotionState() == null || body.getActivationState() == 2) continue;
                body.getMotionState().setWorldTransform(body.getWorldTransform(tmpTrans));
            }
            $Stack.pop$com$bulletphysics$linearmath$Transform();
            return;
        }
        catch (Throwable throwable) {
            $Stack.pop$com$bulletphysics$linearmath$Transform();
            throw throwable;
        }
    }

    @Override
    public void setConstraintSolver(ConstraintSolver solver) {
        if (this.ownsConstraintSolver) {
            // empty if block
        }
        this.ownsConstraintSolver = false;
        this.constraintSolver = solver;
    }

    @Override
    public ConstraintSolver getConstraintSolver() {
        return this.constraintSolver;
    }

    @Override
    public void debugDrawWorld() {
    }

    @Override
    public DynamicsWorldType getWorldType() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}

