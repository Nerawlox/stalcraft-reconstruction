/*
 * Decompiled with CFR 0.152.
 */
package com.bulletphysics.demos.basic;

import com.bulletphysics.collision.broadphase.BroadphaseInterface;
import com.bulletphysics.collision.broadphase.DbvtBroadphase;
import com.bulletphysics.collision.dispatch.CollisionDispatcher;
import com.bulletphysics.collision.dispatch.DefaultCollisionConfiguration;
import com.bulletphysics.collision.shapes.BoxShape;
import com.bulletphysics.collision.shapes.CollisionShape;
import com.bulletphysics.demos.opengl.DemoApplication;
import com.bulletphysics.demos.opengl.GLDebugDrawer;
import com.bulletphysics.demos.opengl.IGL;
import com.bulletphysics.demos.opengl.LWJGL;
import com.bulletphysics.dynamics.DiscreteDynamicsWorld;
import com.bulletphysics.dynamics.RigidBody;
import com.bulletphysics.dynamics.RigidBodyConstructionInfo;
import com.bulletphysics.dynamics.constraintsolver.ConstraintSolver;
import com.bulletphysics.dynamics.constraintsolver.SequentialImpulseConstraintSolver;
import com.bulletphysics.linearmath.DefaultMotionState;
import com.bulletphysics.linearmath.Transform;
import com.bulletphysics.util.ObjectArrayList;
import javax.vecmath.Vector3f;
import org.lwjgl.LWJGLException;

public class BasicDemo
extends DemoApplication {
    private static final int ARRAY_SIZE_X = 5;
    private static final int ARRAY_SIZE_Y = 5;
    private static final int ARRAY_SIZE_Z = 5;
    private static final int MAX_PROXIES = 1149;
    private static final int START_POS_X = -5;
    private static final int START_POS_Y = -5;
    private static final int START_POS_Z = -3;
    private ObjectArrayList<CollisionShape> collisionShapes = new ObjectArrayList();
    private BroadphaseInterface broadphase;
    private CollisionDispatcher dispatcher;
    private ConstraintSolver solver;
    private DefaultCollisionConfiguration collisionConfiguration;

    public BasicDemo(IGL gl) {
        super(gl);
    }

    @Override
    public void clientMoveAndDisplay() {
        this.gl.glClear(16640);
        float ms = this.getDeltaTimeMicroseconds();
        if (this.dynamicsWorld != null) {
            this.dynamicsWorld.stepSimulation(ms / 1000000.0f);
            this.dynamicsWorld.debugDrawWorld();
        }
        this.renderme();
    }

    @Override
    public void displayCallback() {
        this.gl.glClear(16640);
        this.renderme();
        if (this.dynamicsWorld != null) {
            this.dynamicsWorld.debugDrawWorld();
        }
    }

    @Override
    public void initPhysics() {
        this.setCameraDistance(50.0f);
        this.collisionConfiguration = new DefaultCollisionConfiguration();
        this.dispatcher = new CollisionDispatcher(this.collisionConfiguration);
        this.broadphase = new DbvtBroadphase();
        SequentialImpulseConstraintSolver sol = new SequentialImpulseConstraintSolver();
        this.solver = sol;
        this.dynamicsWorld = new DiscreteDynamicsWorld(this.dispatcher, this.broadphase, this.solver, this.collisionConfiguration);
        this.dynamicsWorld.setGravity(new Vector3f(0.0f, -10.0f, 0.0f));
        BoxShape groundShape = new BoxShape(new Vector3f(50.0f, 50.0f, 50.0f));
        this.collisionShapes.add(groundShape);
        Transform groundTransform = new Transform();
        groundTransform.setIdentity();
        groundTransform.origin.set(0.0f, -56.0f, 0.0f);
        float mass = 0.0f;
        boolean isDynamic = mass != 0.0f;
        Vector3f localInertia = new Vector3f(0.0f, 0.0f, 0.0f);
        if (isDynamic) {
            ((CollisionShape)groundShape).calculateLocalInertia(mass, localInertia);
        }
        DefaultMotionState myMotionState = new DefaultMotionState(groundTransform);
        RigidBodyConstructionInfo rbInfo = new RigidBodyConstructionInfo(mass, myMotionState, groundShape, localInertia);
        RigidBody body = new RigidBody(rbInfo);
        this.dynamicsWorld.addRigidBody(body);
        BoxShape colShape = new BoxShape(new Vector3f(1.0f, 1.0f, 1.0f));
        this.collisionShapes.add(colShape);
        Transform startTransform = new Transform();
        startTransform.setIdentity();
        float mass2 = 1.0f;
        boolean isDynamic2 = mass2 != 0.0f;
        Vector3f localInertia2 = new Vector3f(0.0f, 0.0f, 0.0f);
        if (isDynamic2) {
            ((CollisionShape)colShape).calculateLocalInertia(mass2, localInertia2);
        }
        float start_x = -7.0f;
        float start_y = -5.0f;
        float start_z = -5.0f;
        for (int k = 0; k < 5; ++k) {
            for (int i = 0; i < 5; ++i) {
                for (int j = 0; j < 5; ++j) {
                    startTransform.origin.set(2.0f * (float)i + start_x, 10.0f + 2.0f * (float)k + start_y, 2.0f * (float)j + start_z);
                    DefaultMotionState myMotionState2 = new DefaultMotionState(startTransform);
                    RigidBodyConstructionInfo rbInfo2 = new RigidBodyConstructionInfo(mass2, myMotionState2, colShape, localInertia2);
                    RigidBody body2 = new RigidBody(rbInfo2);
                    body2.setActivationState(2);
                    this.dynamicsWorld.addRigidBody(body2);
                    body2.setActivationState(2);
                }
            }
        }
        this.clientResetScene();
    }

    public static void main(String[] args) throws LWJGLException {
        BasicDemo ccdDemo = new BasicDemo(LWJGL.getGL());
        ccdDemo.initPhysics();
        ccdDemo.getDynamicsWorld().setDebugDrawer(new GLDebugDrawer(LWJGL.getGL()));
        LWJGL.main(args, 800, 600, "Bullet Physics Demo. http://bullet.sf.net", ccdDemo);
    }
}

