/*
 * Decompiled with CFR 0.152.
 */
package com.bulletphysics.demos.bsp;

import com.bulletphysics.collision.broadphase.BroadphaseInterface;
import com.bulletphysics.collision.broadphase.DbvtBroadphase;
import com.bulletphysics.collision.dispatch.CollisionDispatcher;
import com.bulletphysics.collision.dispatch.DefaultCollisionConfiguration;
import com.bulletphysics.collision.shapes.CollisionShape;
import com.bulletphysics.collision.shapes.ConvexHullShape;
import com.bulletphysics.demos.bsp.BspConverter;
import com.bulletphysics.demos.opengl.DemoApplication;
import com.bulletphysics.demos.opengl.GLDebugDrawer;
import com.bulletphysics.demos.opengl.IGL;
import com.bulletphysics.demos.opengl.LWJGL;
import com.bulletphysics.dynamics.DiscreteDynamicsWorld;
import com.bulletphysics.dynamics.constraintsolver.ConstraintSolver;
import com.bulletphysics.dynamics.constraintsolver.SequentialImpulseConstraintSolver;
import com.bulletphysics.linearmath.Transform;
import com.bulletphysics.util.ObjectArrayList;
import javax.vecmath.Vector3f;

public class BspDemo
extends DemoApplication {
    private static final float CUBE_HALF_EXTENTS = 1.0f;
    private static final float EXTRA_HEIGHT = -20.0f;
    public ObjectArrayList<CollisionShape> collisionShapes = new ObjectArrayList();
    public BroadphaseInterface broadphase;
    public CollisionDispatcher dispatcher;
    public ConstraintSolver solver;
    public DefaultCollisionConfiguration collisionConfiguration;

    public BspDemo(IGL gl) {
        super(gl);
    }

    @Override
    public void initPhysics() throws Exception {
        this.cameraUp.set(0.0f, 0.0f, 1.0f);
        this.forwardAxis = 1;
        this.setCameraDistance(22.0f);
        this.collisionConfiguration = new DefaultCollisionConfiguration();
        this.dispatcher = new CollisionDispatcher(this.collisionConfiguration);
        Vector3f worldMin = new Vector3f(-1000.0f, -1000.0f, -1000.0f);
        Vector3f worldMax = new Vector3f(1000.0f, 1000.0f, 1000.0f);
        this.broadphase = new DbvtBroadphase();
        this.solver = new SequentialImpulseConstraintSolver();
        this.dynamicsWorld = new DiscreteDynamicsWorld(this.dispatcher, this.broadphase, this.solver, this.collisionConfiguration);
        Vector3f gravity = new Vector3f();
        gravity.negate(this.cameraUp);
        gravity.scale(10.0f);
        this.dynamicsWorld.setGravity(gravity);
        new BspToBulletConverter().convertBsp(this.getClass().getResourceAsStream("exported.bsp.txt"));
        this.clientResetScene();
    }

    @Override
    public void clientMoveAndDisplay() {
        this.gl.glClear(16640);
        float dt = this.getDeltaTimeMicroseconds() * 1.0E-6f;
        this.dynamicsWorld.stepSimulation(dt);
        this.dynamicsWorld.debugDrawWorld();
        this.renderme();
    }

    @Override
    public void displayCallback() {
        this.gl.glClear(16640);
        this.renderme();
    }

    public static void main(String[] args) throws Exception {
        BspDemo demo = new BspDemo(LWJGL.getGL());
        demo.initPhysics();
        demo.getDynamicsWorld().setDebugDrawer(new GLDebugDrawer(LWJGL.getGL()));
        LWJGL.main(args, 800, 600, "Bullet Physics Demo. http://bullet.sf.net", demo);
    }

    private class BspToBulletConverter
    extends BspConverter {
        private BspToBulletConverter() {
        }

        @Override
        public void addConvexVerticesCollider(ObjectArrayList<Vector3f> vertices) {
            if (vertices.size() > 0) {
                float mass = 0.0f;
                Transform startTransform = new Transform();
                startTransform.setIdentity();
                startTransform.origin.set(0.0f, 0.0f, -10.0f);
                ConvexHullShape shape = new ConvexHullShape(vertices);
                BspDemo.this.collisionShapes.add(shape);
                BspDemo.this.localCreateRigidBody(mass, startTransform, shape);
            }
        }
    }
}

