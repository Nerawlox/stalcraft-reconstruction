/*
 * Decompiled with CFR 0.152.
 */
package com.bulletphysics.demos.genericjoint;

import com.bulletphysics.collision.broadphase.DbvtBroadphase;
import com.bulletphysics.collision.dispatch.CollisionDispatcher;
import com.bulletphysics.collision.dispatch.DefaultCollisionConfiguration;
import com.bulletphysics.collision.shapes.BoxShape;
import com.bulletphysics.demos.genericjoint.RagDoll;
import com.bulletphysics.demos.opengl.DemoApplication;
import com.bulletphysics.demos.opengl.GLDebugDrawer;
import com.bulletphysics.demos.opengl.IGL;
import com.bulletphysics.demos.opengl.LWJGL;
import com.bulletphysics.dynamics.DiscreteDynamicsWorld;
import com.bulletphysics.dynamics.constraintsolver.SequentialImpulseConstraintSolver;
import com.bulletphysics.linearmath.Transform;
import com.bulletphysics.util.ObjectArrayList;
import javax.vecmath.Vector3f;
import org.lwjgl.LWJGLException;

public class GenericJointDemo
extends DemoApplication {
    private ObjectArrayList<RagDoll> ragdolls = new ObjectArrayList();

    public GenericJointDemo(IGL gl) {
        super(gl);
    }

    @Override
    public void initPhysics() {
        DefaultCollisionConfiguration collision_config = new DefaultCollisionConfiguration();
        CollisionDispatcher dispatcher = new CollisionDispatcher(collision_config);
        Vector3f worldAabbMin = new Vector3f(-10000.0f, -10000.0f, -10000.0f);
        Vector3f worldAabbMax = new Vector3f(10000.0f, 10000.0f, 10000.0f);
        DbvtBroadphase overlappingPairCache = new DbvtBroadphase();
        SequentialImpulseConstraintSolver constraintSolver = new SequentialImpulseConstraintSolver();
        this.dynamicsWorld = new DiscreteDynamicsWorld(dispatcher, overlappingPairCache, constraintSolver, collision_config);
        this.dynamicsWorld.setGravity(new Vector3f(0.0f, -30.0f, 0.0f));
        this.dynamicsWorld.setDebugDrawer(new GLDebugDrawer(this.gl));
        BoxShape groundShape = new BoxShape(new Vector3f(200.0f, 10.0f, 200.0f));
        Transform groundTransform = new Transform();
        groundTransform.setIdentity();
        groundTransform.origin.set(0.0f, -15.0f, 0.0f);
        this.localCreateRigidBody(0.0f, groundTransform, groundShape);
        this.spawnRagdoll();
        this.clientResetScene();
    }

    public void spawnRagdoll() {
        this.spawnRagdoll(false);
    }

    public void spawnRagdoll(boolean random) {
        RagDoll ragDoll = new RagDoll(this.dynamicsWorld, new Vector3f(0.0f, 0.0f, 10.0f), 5.0f);
        this.ragdolls.add(ragDoll);
    }

    @Override
    public void clientMoveAndDisplay() {
        this.gl.glClear(16640);
        float ms = this.getDeltaTimeMicroseconds();
        float minFPS = 16666.666f;
        if (ms > minFPS) {
            ms = minFPS;
        }
        if (this.dynamicsWorld != null) {
            this.dynamicsWorld.stepSimulation(ms / 1000000.0f);
            this.dynamicsWorld.debugDrawWorld();
        }
        this.renderme();
    }

    @Override
    public void displayCallback() {
        this.gl.glClear(16640);
        if (this.dynamicsWorld != null) {
            this.dynamicsWorld.debugDrawWorld();
        }
        this.renderme();
    }

    @Override
    public void keyboardCallback(char key, int x, int y, int modifiers) {
        switch (key) {
            case 'e': {
                this.spawnRagdoll(true);
                break;
            }
            default: {
                super.keyboardCallback(key, x, y, modifiers);
            }
        }
    }

    public static void main(String[] args) throws LWJGLException {
        GenericJointDemo demoApp = new GenericJointDemo(LWJGL.getGL());
        demoApp.initPhysics();
        demoApp.setCameraDistance(10.0f);
        LWJGL.main(args, 800, 600, "Joint 6DOF - Sequencial Impulse Solver", demoApp);
    }
}

