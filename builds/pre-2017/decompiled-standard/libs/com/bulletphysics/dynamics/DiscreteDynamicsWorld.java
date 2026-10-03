/*
 * Decompiled with CFR 0.152.
 */
package com.bulletphysics.dynamics;

import com.bulletphysics.$Stack;
import com.bulletphysics.BulletGlobals;
import com.bulletphysics.BulletStats;
import com.bulletphysics.collision.broadphase.BroadphaseInterface;
import com.bulletphysics.collision.broadphase.BroadphasePair;
import com.bulletphysics.collision.broadphase.BroadphaseProxy;
import com.bulletphysics.collision.broadphase.Dispatcher;
import com.bulletphysics.collision.broadphase.DispatcherInfo;
import com.bulletphysics.collision.broadphase.OverlappingPairCache;
import com.bulletphysics.collision.dispatch.CollisionConfiguration;
import com.bulletphysics.collision.dispatch.CollisionObject;
import com.bulletphysics.collision.dispatch.CollisionWorld;
import com.bulletphysics.collision.dispatch.SimulationIslandManager;
import com.bulletphysics.collision.narrowphase.ManifoldPoint;
import com.bulletphysics.collision.narrowphase.PersistentManifold;
import com.bulletphysics.collision.shapes.CollisionShape;
import com.bulletphysics.collision.shapes.SphereShape;
import com.bulletphysics.dynamics.ActionInterface;
import com.bulletphysics.dynamics.DynamicsWorld;
import com.bulletphysics.dynamics.DynamicsWorldType;
import com.bulletphysics.dynamics.RigidBody;
import com.bulletphysics.dynamics.constraintsolver.ConstraintSolver;
import com.bulletphysics.dynamics.constraintsolver.ContactSolverInfo;
import com.bulletphysics.dynamics.constraintsolver.SequentialImpulseConstraintSolver;
import com.bulletphysics.dynamics.constraintsolver.TypedConstraint;
import com.bulletphysics.dynamics.vehicle.RaycastVehicle;
import com.bulletphysics.linearmath.CProfileManager;
import com.bulletphysics.linearmath.IDebugDraw;
import com.bulletphysics.linearmath.MiscUtil;
import com.bulletphysics.linearmath.ScalarUtil;
import com.bulletphysics.linearmath.Transform;
import com.bulletphysics.linearmath.TransformUtil;
import com.bulletphysics.util.ObjectArrayList;
import java.util.Comparator;
import javax.vecmath.Vector3f;

public class DiscreteDynamicsWorld
extends DynamicsWorld {
    protected ConstraintSolver constraintSolver;
    protected SimulationIslandManager islandManager;
    protected final ObjectArrayList<TypedConstraint> constraints = new ObjectArrayList();
    protected final Vector3f gravity = new Vector3f(0.0f, -10.0f, 0.0f);
    protected float localTime = 0.016666668f;
    protected boolean ownsIslandManager;
    protected boolean ownsConstraintSolver;
    protected ObjectArrayList<RaycastVehicle> vehicles = new ObjectArrayList();
    protected ObjectArrayList<ActionInterface> actions = new ObjectArrayList();
    protected int profileTimings = 0;
    private ObjectArrayList<TypedConstraint> sortedConstraints = new ObjectArrayList();
    private InplaceSolverIslandCallback solverCallback = new InplaceSolverIslandCallback();
    private static final Comparator<TypedConstraint> sortConstraintOnIslandPredicate = new Comparator<TypedConstraint>(){

        @Override
        public int compare(TypedConstraint lhs, TypedConstraint rhs) {
            int rIslandId0 = DiscreteDynamicsWorld.getConstraintIslandId(rhs);
            int lIslandId0 = DiscreteDynamicsWorld.getConstraintIslandId(lhs);
            return lIslandId0 < rIslandId0 ? -1 : 1;
        }
    };

    public DiscreteDynamicsWorld(Dispatcher dispatcher, BroadphaseInterface pairCache, ConstraintSolver constraintSolver, CollisionConfiguration collisionConfiguration) {
        super(dispatcher, pairCache, collisionConfiguration);
        this.constraintSolver = constraintSolver;
        if (this.constraintSolver == null) {
            this.constraintSolver = new SequentialImpulseConstraintSolver();
            this.ownsConstraintSolver = true;
        } else {
            this.ownsConstraintSolver = false;
        }
        this.islandManager = new SimulationIslandManager();
        this.ownsIslandManager = true;
    }

    protected void saveKinematicState(float timeStep) {
        for (int i = 0; i < this.collisionObjects.size(); ++i) {
            CollisionObject colObj = (CollisionObject)this.collisionObjects.getQuick(i);
            RigidBody body = RigidBody.upcast(colObj);
            if (body == null || body.getActivationState() == 2 || !body.isKinematicObject()) continue;
            body.saveKinematicState(timeStep);
        }
    }

    @Override
    public void debugDrawWorld() {
        $Stack $Stack = $Stack.get();
        try {
            $Stack $Stack2 = $Stack;
            $Stack2.push$com$bulletphysics$linearmath$Transform();
            $Stack2.push$javax$vecmath$Vector3f();
            if (this.getDebugDrawer() != null && (this.getDebugDrawer().getDebugMode() & 8) != 0) {
                int numManifolds = this.getDispatcher().getNumManifolds();
                Vector3f color = $Stack.get$javax$vecmath$Vector3f();
                color.set(0.0f, 0.0f, 0.0f);
                for (int i = 0; i < numManifolds; ++i) {
                    PersistentManifold contactManifold = this.getDispatcher().getManifoldByIndexInternal(i);
                    int numContacts = contactManifold.getNumContacts();
                    for (int j = 0; j < numContacts; ++j) {
                        ManifoldPoint cp = contactManifold.getContactPoint(j);
                        this.getDebugDrawer().drawContactPoint(cp.positionWorldOnB, cp.normalWorldOnB, cp.getDistance(), cp.getLifeTime(), color);
                    }
                }
            }
            if (this.getDebugDrawer() != null && (this.getDebugDrawer().getDebugMode() & 3) != 0) {
                int i;
                Transform tmpTrans = $Stack.get$com$bulletphysics$linearmath$Transform();
                Vector3f minAabb = $Stack.get$javax$vecmath$Vector3f();
                Vector3f maxAabb = $Stack.get$javax$vecmath$Vector3f();
                Vector3f colorvec = $Stack.get$javax$vecmath$Vector3f();
                for (i = 0; i < this.collisionObjects.size(); ++i) {
                    CollisionObject colObj = (CollisionObject)this.collisionObjects.getQuick(i);
                    if (this.getDebugDrawer() != null && (this.getDebugDrawer().getDebugMode() & 1) != 0) {
                        Vector3f color = $Stack.get$javax$vecmath$Vector3f();
                        color.set(255.0f, 255.0f, 255.0f);
                        switch (colObj.getActivationState()) {
                            case 1: {
                                color.set(255.0f, 255.0f, 255.0f);
                                break;
                            }
                            case 2: {
                                color.set(0.0f, 255.0f, 0.0f);
                                break;
                            }
                            case 3: {
                                color.set(0.0f, 255.0f, 255.0f);
                                break;
                            }
                            case 4: {
                                color.set(255.0f, 0.0f, 0.0f);
                                break;
                            }
                            case 5: {
                                color.set(255.0f, 255.0f, 0.0f);
                                break;
                            }
                            default: {
                                color.set(255.0f, 0.0f, 0.0f);
                            }
                        }
                        this.debugDrawObject(colObj.getWorldTransform(tmpTrans), colObj.getCollisionShape(), color);
                    }
                    if (this.debugDrawer == null || (this.debugDrawer.getDebugMode() & 2) == 0) continue;
                    colorvec.set(1.0f, 0.0f, 0.0f);
                    colObj.getCollisionShape().getAabb(colObj.getWorldTransform(tmpTrans), minAabb, maxAabb);
                    this.debugDrawer.drawAabb(minAabb, maxAabb, colorvec);
                }
                Vector3f wheelColor = $Stack.get$javax$vecmath$Vector3f();
                Vector3f wheelPosWS = $Stack.get$javax$vecmath$Vector3f();
                Vector3f axle = $Stack.get$javax$vecmath$Vector3f();
                Vector3f tmp = $Stack.get$javax$vecmath$Vector3f();
                for (i = 0; i < this.vehicles.size(); ++i) {
                    for (int v = 0; v < this.vehicles.getQuick(i).getNumWheels(); ++v) {
                        wheelColor.set(0.0f, 255.0f, 255.0f);
                        if (this.vehicles.getQuick((int)i).getWheelInfo((int)v).raycastInfo.isInContact) {
                            wheelColor.set(0.0f, 0.0f, 255.0f);
                        } else {
                            wheelColor.set(255.0f, 0.0f, 255.0f);
                        }
                        wheelPosWS.set(this.vehicles.getQuick((int)i).getWheelInfo((int)v).worldTransform.origin);
                        axle.set(this.vehicles.getQuick((int)i).getWheelInfo((int)v).worldTransform.basis.getElement(0, this.vehicles.getQuick(i).getRightAxis()), this.vehicles.getQuick((int)i).getWheelInfo((int)v).worldTransform.basis.getElement(1, this.vehicles.getQuick(i).getRightAxis()), this.vehicles.getQuick((int)i).getWheelInfo((int)v).worldTransform.basis.getElement(2, this.vehicles.getQuick(i).getRightAxis()));
                        tmp.add(wheelPosWS, axle);
                        this.debugDrawer.drawLine(wheelPosWS, tmp, wheelColor);
                        this.debugDrawer.drawLine(wheelPosWS, this.vehicles.getQuick((int)i).getWheelInfo((int)v).raycastInfo.contactPointWS, wheelColor);
                    }
                }
                if (this.getDebugDrawer() != null && this.getDebugDrawer().getDebugMode() != 0) {
                    for (i = 0; i < this.actions.size(); ++i) {
                        this.actions.getQuick(i).debugDraw(this.debugDrawer);
                    }
                }
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

    @Override
    public void clearForces() {
        for (int i = 0; i < this.collisionObjects.size(); ++i) {
            CollisionObject colObj = (CollisionObject)this.collisionObjects.getQuick(i);
            RigidBody body = RigidBody.upcast(colObj);
            if (body == null) continue;
            body.clearForces();
        }
    }

    public void applyGravity() {
        for (int i = 0; i < this.collisionObjects.size(); ++i) {
            CollisionObject colObj = (CollisionObject)this.collisionObjects.getQuick(i);
            RigidBody body = RigidBody.upcast(colObj);
            if (body == null || !body.isActive()) continue;
            body.applyGravity();
        }
    }

    protected void synchronizeMotionStates() {
        $Stack $Stack = $Stack.get();
        try {
            int i;
            $Stack $Stack2 = $Stack;
            $Stack2.push$com$bulletphysics$linearmath$Transform();
            $Stack2.push$javax$vecmath$Vector3f();
            Transform interpolatedTransform = $Stack.get$com$bulletphysics$linearmath$Transform();
            Transform tmpTrans = $Stack.get$com$bulletphysics$linearmath$Transform();
            Vector3f tmpLinVel = $Stack.get$javax$vecmath$Vector3f();
            Vector3f tmpAngVel = $Stack.get$javax$vecmath$Vector3f();
            for (i = 0; i < this.collisionObjects.size(); ++i) {
                CollisionObject colObj = (CollisionObject)this.collisionObjects.getQuick(i);
                RigidBody body = RigidBody.upcast(colObj);
                if (body == null || body.getMotionState() == null || body.isStaticOrKinematicObject()) continue;
                TransformUtil.integrateTransform(body.getInterpolationWorldTransform(tmpTrans), body.getInterpolationLinearVelocity(tmpLinVel), body.getInterpolationAngularVelocity(tmpAngVel), this.localTime * body.getHitFraction(), interpolatedTransform);
                body.getMotionState().setWorldTransform(interpolatedTransform);
            }
            if (this.getDebugDrawer() != null && (this.getDebugDrawer().getDebugMode() & 1) != 0) {
                for (i = 0; i < this.vehicles.size(); ++i) {
                    for (int v = 0; v < this.vehicles.getQuick(i).getNumWheels(); ++v) {
                        this.vehicles.getQuick(i).updateWheelTransform(v, true);
                    }
                }
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

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public int stepSimulation(float timeStep, int maxSubSteps, float fixedTimeStep) {
        this.startProfiling(timeStep);
        long t0 = System.nanoTime();
        BulletStats.pushProfile("stepSimulation");
        try {
            int numSimulationSubSteps = 0;
            if (maxSubSteps != 0) {
                this.localTime += timeStep;
                if (this.localTime >= fixedTimeStep) {
                    numSimulationSubSteps = (int)(this.localTime / fixedTimeStep);
                    this.localTime -= (float)numSimulationSubSteps * fixedTimeStep;
                }
            } else {
                fixedTimeStep = timeStep;
                this.localTime = timeStep;
                if (ScalarUtil.fuzzyZero(timeStep)) {
                    numSimulationSubSteps = 0;
                    maxSubSteps = 0;
                } else {
                    numSimulationSubSteps = 1;
                    maxSubSteps = 1;
                }
            }
            if (this.getDebugDrawer() != null) {
                BulletGlobals.setDeactivationDisabled((this.getDebugDrawer().getDebugMode() & 0x10) != 0);
            }
            if (numSimulationSubSteps != 0) {
                this.saveKinematicState(fixedTimeStep);
                this.applyGravity();
                int clampedSimulationSteps = numSimulationSubSteps > maxSubSteps ? maxSubSteps : numSimulationSubSteps;
                for (int i = 0; i < clampedSimulationSteps; ++i) {
                    this.internalSingleStepSimulation(fixedTimeStep);
                    this.synchronizeMotionStates();
                }
            }
            this.synchronizeMotionStates();
            this.clearForces();
            CProfileManager.incrementFrameCounter();
            int n = numSimulationSubSteps;
            return n;
        }
        finally {
            BulletStats.popProfile();
            BulletStats.stepSimulationTime = (System.nanoTime() - t0) / 1000000L;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    protected void internalSingleStepSimulation(float timeStep) {
        BulletStats.pushProfile("internalSingleStepSimulation");
        try {
            this.predictUnconstraintMotion(timeStep);
            DispatcherInfo dispatchInfo = this.getDispatchInfo();
            dispatchInfo.timeStep = timeStep;
            dispatchInfo.stepCount = 0;
            dispatchInfo.debugDraw = this.getDebugDrawer();
            this.performDiscreteCollisionDetection();
            this.calculateSimulationIslands();
            this.getSolverInfo().timeStep = timeStep;
            this.solveConstraints(this.getSolverInfo());
            this.integrateTransforms(timeStep);
            this.updateActions(timeStep);
            this.updateVehicles(timeStep);
            this.updateActivationState(timeStep);
            if (this.internalTickCallback != null) {
                this.internalTickCallback.internalTick(this, timeStep);
            }
        }
        finally {
            BulletStats.popProfile();
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
    public void removeRigidBody(RigidBody body) {
        this.removeCollisionObject(body);
    }

    @Override
    public void addRigidBody(RigidBody body) {
        if (!body.isStaticOrKinematicObject()) {
            body.setGravity(this.gravity);
        }
        if (body.getCollisionShape() != null) {
            boolean isDynamic = !body.isStaticObject() && !body.isKinematicObject();
            short collisionFilterGroup = isDynamic ? (short)1 : 2;
            short collisionFilterMask = isDynamic ? (short)-1 : -3;
            this.addCollisionObject(body, collisionFilterGroup, collisionFilterMask);
        }
    }

    public void addRigidBody(RigidBody body, short group, short mask) {
        if (!body.isStaticOrKinematicObject()) {
            body.setGravity(this.gravity);
        }
        if (body.getCollisionShape() != null) {
            this.addCollisionObject(body, group, mask);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void updateActions(float timeStep) {
        BulletStats.pushProfile("updateActions");
        try {
            for (int i = 0; i < this.actions.size(); ++i) {
                this.actions.getQuick(i).updateAction(this, timeStep);
            }
        }
        finally {
            BulletStats.popProfile();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    protected void updateVehicles(float timeStep) {
        BulletStats.pushProfile("updateVehicles");
        try {
            for (int i = 0; i < this.vehicles.size(); ++i) {
                RaycastVehicle vehicle = this.vehicles.getQuick(i);
                vehicle.updateVehicle(timeStep);
            }
        }
        finally {
            BulletStats.popProfile();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     * WARNING - void declaration
     */
    protected void updateActivationState(float f) {
        $Stack $Stack = $Stack.get();
        try {
            $Stack.push$javax$vecmath$Vector3f();
            BulletStats.pushProfile("updateActivationState");
            try {
                Vector3f tmp = $Stack.get$javax$vecmath$Vector3f();
                for (int i = 0; i < this.collisionObjects.size(); ++i) {
                    void timeStep;
                    CollisionObject colObj = (CollisionObject)this.collisionObjects.getQuick(i);
                    RigidBody body = RigidBody.upcast(colObj);
                    if (body == null) continue;
                    body.updateDeactivation((float)timeStep);
                    if (body.wantsSleeping()) {
                        if (body.isStaticOrKinematicObject()) {
                            body.setActivationState(2);
                            continue;
                        }
                        if (body.getActivationState() == 1) {
                            body.setActivationState(3);
                        }
                        if (body.getActivationState() != 2) continue;
                        tmp.set(0.0f, 0.0f, 0.0f);
                        body.setAngularVelocity(tmp);
                        body.setLinearVelocity(tmp);
                        continue;
                    }
                    if (body.getActivationState() == 4) continue;
                    body.setActivationState(1);
                }
            }
            finally {
                BulletStats.popProfile();
            }
            $Stack.pop$javax$vecmath$Vector3f();
            return;
        }
        catch (Throwable throwable) {
            $Stack.pop$javax$vecmath$Vector3f();
            throw throwable;
        }
    }

    @Override
    public void addConstraint(TypedConstraint constraint, boolean disableCollisionsBetweenLinkedBodies) {
        this.constraints.add(constraint);
        if (disableCollisionsBetweenLinkedBodies) {
            constraint.getRigidBodyA().addConstraintRef(constraint);
            constraint.getRigidBodyB().addConstraintRef(constraint);
        }
    }

    @Override
    public void removeConstraint(TypedConstraint constraint) {
        this.constraints.remove(constraint);
        constraint.getRigidBodyA().removeConstraintRef(constraint);
        constraint.getRigidBodyB().removeConstraintRef(constraint);
    }

    @Override
    public void addAction(ActionInterface action) {
        this.actions.add(action);
    }

    @Override
    public void removeAction(ActionInterface action) {
        this.actions.remove(action);
    }

    @Override
    public void addVehicle(RaycastVehicle vehicle) {
        this.vehicles.add(vehicle);
    }

    @Override
    public void removeVehicle(RaycastVehicle vehicle) {
        this.vehicles.remove(vehicle);
    }

    private static int getConstraintIslandId(TypedConstraint lhs) {
        RigidBody rcolObj0 = lhs.getRigidBodyA();
        RigidBody rcolObj1 = lhs.getRigidBodyB();
        int islandId = rcolObj0.getIslandTag() >= 0 ? rcolObj0.getIslandTag() : rcolObj1.getIslandTag();
        return islandId;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    protected void solveConstraints(ContactSolverInfo solverInfo) {
        BulletStats.pushProfile("solveConstraints");
        try {
            this.sortedConstraints.clear();
            for (int i = 0; i < this.constraints.size(); ++i) {
                this.sortedConstraints.add(this.constraints.getQuick(i));
            }
            MiscUtil.quickSort(this.sortedConstraints, sortConstraintOnIslandPredicate);
            ObjectArrayList<TypedConstraint> constraintsPtr = this.getNumConstraints() != 0 ? this.sortedConstraints : null;
            this.solverCallback.init(solverInfo, this.constraintSolver, constraintsPtr, this.sortedConstraints.size(), this.debugDrawer, this.dispatcher1);
            this.constraintSolver.prepareSolve(this.getCollisionWorld().getNumCollisionObjects(), this.getCollisionWorld().getDispatcher().getNumManifolds());
            this.islandManager.buildAndProcessIslands(this.getCollisionWorld().getDispatcher(), this.getCollisionWorld().getCollisionObjectArray(), this.solverCallback);
            this.constraintSolver.allSolved(solverInfo, this.debugDrawer);
        }
        finally {
            BulletStats.popProfile();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    protected void calculateSimulationIslands() {
        BulletStats.pushProfile("calculateSimulationIslands");
        try {
            this.getSimulationIslandManager().updateActivationState(this.getCollisionWorld(), this.getCollisionWorld().getDispatcher());
            int numConstraints = this.constraints.size();
            for (int i = 0; i < numConstraints; ++i) {
                TypedConstraint constraint = this.constraints.getQuick(i);
                RigidBody colObj0 = constraint.getRigidBodyA();
                RigidBody colObj1 = constraint.getRigidBodyB();
                if (colObj0 == null || colObj0.isStaticOrKinematicObject() || colObj1 == null || colObj1.isStaticOrKinematicObject() || !colObj0.isActive() && !colObj1.isActive()) continue;
                this.getSimulationIslandManager().getUnionFind().unite(colObj0.getIslandTag(), colObj1.getIslandTag());
            }
            this.getSimulationIslandManager().storeIslandActivationState(this.getCollisionWorld());
        }
        finally {
            BulletStats.popProfile();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     * WARNING - void declaration
     */
    protected void integrateTransforms(float f) {
        $Stack $Stack = $Stack.get();
        try {
            $Stack $Stack2 = $Stack;
            $Stack2.push$com$bulletphysics$linearmath$Transform();
            $Stack2.push$javax$vecmath$Vector3f();
            BulletStats.pushProfile("integrateTransforms");
            try {
                Vector3f tmp = $Stack.get$javax$vecmath$Vector3f();
                Transform tmpTrans = $Stack.get$com$bulletphysics$linearmath$Transform();
                Transform predictedTrans = $Stack.get$com$bulletphysics$linearmath$Transform();
                for (int i = 0; i < this.collisionObjects.size(); ++i) {
                    void timeStep;
                    CollisionObject colObj = (CollisionObject)this.collisionObjects.getQuick(i);
                    RigidBody body = RigidBody.upcast(colObj);
                    if (body == null) continue;
                    body.setHitFraction(1.0f);
                    if (!body.isActive() || body.isStaticOrKinematicObject()) continue;
                    body.predictIntegratedTransform((float)timeStep, predictedTrans);
                    tmp.sub(predictedTrans.origin, body.getWorldTransform((Transform)tmpTrans).origin);
                    float squareMotion = tmp.lengthSquared();
                    if (body.getCcdSquareMotionThreshold() != 0.0f && body.getCcdSquareMotionThreshold() < squareMotion) {
                        BulletStats.pushProfile("CCD motion clamping");
                        try {
                            if (body.getCollisionShape().isConvex()) {
                                ++BulletStats.gNumClampedCcdMotions;
                                ClosestNotMeConvexResultCallback sweepResults = new ClosestNotMeConvexResultCallback(body, body.getWorldTransform((Transform)tmpTrans).origin, predictedTrans.origin, this.getBroadphase().getOverlappingPairCache(), this.getDispatcher());
                                SphereShape tmpSphere = new SphereShape(body.getCcdSweptSphereRadius());
                                sweepResults.collisionFilterGroup = body.getBroadphaseProxy().collisionFilterGroup;
                                sweepResults.collisionFilterMask = body.getBroadphaseProxy().collisionFilterMask;
                                this.convexSweepTest(tmpSphere, body.getWorldTransform(tmpTrans), predictedTrans, sweepResults);
                                if (sweepResults.hasHit() && sweepResults.closestHitFraction > 1.0E-4f) {
                                    body.setHitFraction(sweepResults.closestHitFraction);
                                    body.predictIntegratedTransform((float)(timeStep * body.getHitFraction()), predictedTrans);
                                    body.setHitFraction(0.0f);
                                }
                            }
                        }
                        finally {
                            BulletStats.popProfile();
                        }
                    }
                    body.proceedToTransform(predictedTrans);
                }
            }
            finally {
                BulletStats.popProfile();
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

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     * WARNING - void declaration
     */
    protected void predictUnconstraintMotion(float f) {
        $Stack $Stack = $Stack.get();
        try {
            $Stack.push$com$bulletphysics$linearmath$Transform();
            BulletStats.pushProfile("predictUnconstraintMotion");
            try {
                Transform tmpTrans = $Stack.get$com$bulletphysics$linearmath$Transform();
                for (int i = 0; i < this.collisionObjects.size(); ++i) {
                    void timeStep;
                    CollisionObject colObj = (CollisionObject)this.collisionObjects.getQuick(i);
                    RigidBody body = RigidBody.upcast(colObj);
                    if (body == null || body.isStaticOrKinematicObject() || !body.isActive()) continue;
                    body.integrateVelocities((float)timeStep);
                    body.applyDamping((float)timeStep);
                    body.predictIntegratedTransform((float)timeStep, body.getInterpolationWorldTransform(tmpTrans));
                }
            }
            finally {
                BulletStats.popProfile();
            }
            $Stack.pop$com$bulletphysics$linearmath$Transform();
            return;
        }
        catch (Throwable throwable) {
            $Stack.pop$com$bulletphysics$linearmath$Transform();
            throw throwable;
        }
    }

    protected void startProfiling(float timeStep) {
        CProfileManager.reset();
    }

    /*
     * WARNING - void declaration
     */
    protected void debugDrawSphere(float f, Transform transform, Vector3f vector3f) {
        $Stack $Stack = $Stack.get();
        try {
            void color;
            void radius;
            void transform2;
            $Stack.push$javax$vecmath$Vector3f();
            Vector3f start = $Stack.get$javax$vecmath$Vector3f(transform2.origin);
            Vector3f xoffs = $Stack.get$javax$vecmath$Vector3f();
            xoffs.set((float)radius, 0.0f, 0.0f);
            transform2.basis.transform(xoffs);
            Vector3f yoffs = $Stack.get$javax$vecmath$Vector3f();
            yoffs.set(0.0f, (float)radius, 0.0f);
            transform2.basis.transform(yoffs);
            Vector3f zoffs = $Stack.get$javax$vecmath$Vector3f();
            zoffs.set(0.0f, 0.0f, (float)radius);
            transform2.basis.transform(zoffs);
            Vector3f tmp1 = $Stack.get$javax$vecmath$Vector3f();
            Vector3f tmp2 = $Stack.get$javax$vecmath$Vector3f();
            tmp1.sub(start, xoffs);
            tmp2.add(start, yoffs);
            this.getDebugDrawer().drawLine(tmp1, tmp2, (Vector3f)color);
            tmp1.add(start, yoffs);
            tmp2.add(start, xoffs);
            this.getDebugDrawer().drawLine(tmp1, tmp2, (Vector3f)color);
            tmp1.add(start, xoffs);
            tmp2.sub(start, yoffs);
            this.getDebugDrawer().drawLine(tmp1, tmp2, (Vector3f)color);
            tmp1.sub(start, yoffs);
            tmp2.sub(start, xoffs);
            this.getDebugDrawer().drawLine(tmp1, tmp2, (Vector3f)color);
            tmp1.sub(start, xoffs);
            tmp2.add(start, zoffs);
            this.getDebugDrawer().drawLine(tmp1, tmp2, (Vector3f)color);
            tmp1.add(start, zoffs);
            tmp2.add(start, xoffs);
            this.getDebugDrawer().drawLine(tmp1, tmp2, (Vector3f)color);
            tmp1.add(start, xoffs);
            tmp2.sub(start, zoffs);
            this.getDebugDrawer().drawLine(tmp1, tmp2, (Vector3f)color);
            tmp1.sub(start, zoffs);
            tmp2.sub(start, xoffs);
            this.getDebugDrawer().drawLine(tmp1, tmp2, (Vector3f)color);
            tmp1.sub(start, yoffs);
            tmp2.add(start, zoffs);
            this.getDebugDrawer().drawLine(tmp1, tmp2, (Vector3f)color);
            tmp1.add(start, zoffs);
            tmp2.add(start, yoffs);
            this.getDebugDrawer().drawLine(tmp1, tmp2, (Vector3f)color);
            tmp1.add(start, yoffs);
            tmp2.sub(start, zoffs);
            this.getDebugDrawer().drawLine(tmp1, tmp2, (Vector3f)color);
            tmp1.sub(start, zoffs);
            tmp2.sub(start, yoffs);
            this.getDebugDrawer().drawLine(tmp1, tmp2, (Vector3f)color);
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
    public void debugDrawObject(Transform transform, CollisionShape collisionShape, Vector3f vector3f) {
        $Stack $Stack = $Stack.get();
        try {
            void worldTransform;
            $Stack.push$javax$vecmath$Vector3f();
            Vector3f tmp = $Stack.get$javax$vecmath$Vector3f();
            Vector3f tmp2 = $Stack.get$javax$vecmath$Vector3f();
            Vector3f start = $Stack.get$javax$vecmath$Vector3f(worldTransform.origin);
            tmp.set(1.0f, 0.0f, 0.0f);
            worldTransform.basis.transform(tmp);
            tmp.add(start);
            tmp2.set(1.0f, 0.0f, 0.0f);
            this.getDebugDrawer().drawLine(start, tmp, tmp2);
            tmp.set(0.0f, 1.0f, 0.0f);
            worldTransform.basis.transform(tmp);
            tmp.add(start);
            tmp2.set(0.0f, 1.0f, 0.0f);
            this.getDebugDrawer().drawLine(start, tmp, tmp2);
            tmp.set(0.0f, 0.0f, 1.0f);
            worldTransform.basis.transform(tmp);
            tmp.add(start);
            tmp2.set(0.0f, 0.0f, 1.0f);
            this.getDebugDrawer().drawLine(start, tmp, tmp2);
            $Stack.pop$javax$vecmath$Vector3f();
            return;
        }
        catch (Throwable throwable) {
            $Stack.pop$javax$vecmath$Vector3f();
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
    public int getNumConstraints() {
        return this.constraints.size();
    }

    @Override
    public TypedConstraint getConstraint(int index) {
        return this.constraints.getQuick(index);
    }

    @Override
    public int getNumActions() {
        return this.actions.size();
    }

    @Override
    public ActionInterface getAction(int index) {
        return this.actions.getQuick(index);
    }

    public SimulationIslandManager getSimulationIslandManager() {
        return this.islandManager;
    }

    public CollisionWorld getCollisionWorld() {
        return this;
    }

    @Override
    public DynamicsWorldType getWorldType() {
        return DynamicsWorldType.DISCRETE_DYNAMICS_WORLD;
    }

    public void setNumTasks(int numTasks) {
    }

    private static class ClosestNotMeConvexResultCallback
    extends CollisionWorld.ClosestConvexResultCallback {
        private CollisionObject me;
        private float allowedPenetration = 0.0f;
        private OverlappingPairCache pairCache;
        private Dispatcher dispatcher;

        public ClosestNotMeConvexResultCallback(CollisionObject me, Vector3f fromA, Vector3f toA, OverlappingPairCache pairCache, Dispatcher dispatcher) {
            super(fromA, toA);
            this.me = me;
            this.pairCache = pairCache;
            this.dispatcher = dispatcher;
        }

        /*
         * WARNING - void declaration
         */
        @Override
        public float addSingleResult(CollisionWorld.LocalConvexResult localConvexResult, boolean bl) {
            $Stack $Stack = $Stack.get();
            try {
                void normalInWorldSpace;
                void convexResult;
                $Stack.push$javax$vecmath$Vector3f();
                if (convexResult.hitCollisionObject == this.me) {
                    $Stack.pop$javax$vecmath$Vector3f();
                    return 1.0f;
                }
                Vector3f linVelA = $Stack.get$javax$vecmath$Vector3f();
                Vector3f linVelB = $Stack.get$javax$vecmath$Vector3f();
                linVelA.sub(this.convexToWorld, this.convexFromWorld);
                linVelB.set(0.0f, 0.0f, 0.0f);
                Vector3f relativeVelocity = $Stack.get$javax$vecmath$Vector3f();
                relativeVelocity.sub(linVelA, linVelB);
                if (convexResult.hitNormalLocal.dot(relativeVelocity) >= -this.allowedPenetration) {
                    $Stack.pop$javax$vecmath$Vector3f();
                    return 1.0f;
                }
                float f = super.addSingleResult((CollisionWorld.LocalConvexResult)convexResult, (boolean)normalInWorldSpace);
                $Stack.pop$javax$vecmath$Vector3f();
                return f;
            }
            catch (Throwable throwable) {
                $Stack.pop$javax$vecmath$Vector3f();
                throw throwable;
            }
        }

        @Override
        public boolean needsCollision(BroadphaseProxy proxy0) {
            if (proxy0.clientObject == this.me) {
                return false;
            }
            if (!super.needsCollision(proxy0)) {
                return false;
            }
            CollisionObject otherObj = (CollisionObject)proxy0.clientObject;
            if (this.dispatcher.needsResponse(this.me, otherObj)) {
                ObjectArrayList<PersistentManifold> manifoldArray = new ObjectArrayList<PersistentManifold>();
                BroadphasePair collisionPair = this.pairCache.findPair(this.me.getBroadphaseHandle(), proxy0);
                if (collisionPair != null && collisionPair.algorithm != null) {
                    collisionPair.algorithm.getAllContactManifolds(manifoldArray);
                    for (int j = 0; j < manifoldArray.size(); ++j) {
                        PersistentManifold manifold = manifoldArray.getQuick(j);
                        if (manifold.getNumContacts() <= 0) continue;
                        return false;
                    }
                }
            }
            return true;
        }
    }

    private static class InplaceSolverIslandCallback
    extends SimulationIslandManager.IslandCallback {
        public ContactSolverInfo solverInfo;
        public ConstraintSolver solver;
        public ObjectArrayList<TypedConstraint> sortedConstraints;
        public int numConstraints;
        public IDebugDraw debugDrawer;
        public Dispatcher dispatcher;

        private InplaceSolverIslandCallback() {
        }

        public void init(ContactSolverInfo solverInfo, ConstraintSolver solver, ObjectArrayList<TypedConstraint> sortedConstraints, int numConstraints, IDebugDraw debugDrawer, Dispatcher dispatcher) {
            this.solverInfo = solverInfo;
            this.solver = solver;
            this.sortedConstraints = sortedConstraints;
            this.numConstraints = numConstraints;
            this.debugDrawer = debugDrawer;
            this.dispatcher = dispatcher;
        }

        @Override
        public void processIsland(ObjectArrayList<CollisionObject> bodies, int numBodies, ObjectArrayList<PersistentManifold> manifolds, int manifolds_offset, int numManifolds, int islandId) {
            if (islandId < 0) {
                this.solver.solveGroup(bodies, numBodies, manifolds, manifolds_offset, numManifolds, this.sortedConstraints, 0, this.numConstraints, this.solverInfo, this.debugDrawer, this.dispatcher);
            } else {
                int i;
                int startConstraint_idx = -1;
                int numCurConstraints = 0;
                for (i = 0; i < this.numConstraints; ++i) {
                    if (DiscreteDynamicsWorld.getConstraintIslandId(this.sortedConstraints.getQuick(i)) != islandId) continue;
                    startConstraint_idx = i;
                    break;
                }
                while (i < this.numConstraints) {
                    if (DiscreteDynamicsWorld.getConstraintIslandId(this.sortedConstraints.getQuick(i)) == islandId) {
                        ++numCurConstraints;
                    }
                    ++i;
                }
                if (numManifolds + numCurConstraints > 0) {
                    this.solver.solveGroup(bodies, numBodies, manifolds, manifolds_offset, numManifolds, this.sortedConstraints, startConstraint_idx, numCurConstraints, this.solverInfo, this.debugDrawer, this.dispatcher);
                }
            }
        }
    }
}

