/*
 * Decompiled with CFR 0.152.
 */
package com.bulletphysics.demos.movingconcave;

import com.bulletphysics.collision.broadphase.BroadphaseInterface;
import com.bulletphysics.collision.broadphase.DbvtBroadphase;
import com.bulletphysics.collision.dispatch.CollisionDispatcher;
import com.bulletphysics.collision.dispatch.DefaultCollisionConfiguration;
import com.bulletphysics.collision.shapes.BoxShape;
import com.bulletphysics.collision.shapes.CollisionShape;
import com.bulletphysics.collision.shapes.CompoundShape;
import com.bulletphysics.collision.shapes.StaticPlaneShape;
import com.bulletphysics.collision.shapes.TriangleIndexVertexArray;
import com.bulletphysics.demos.movingconcave.Bunny;
import com.bulletphysics.demos.opengl.DemoApplication;
import com.bulletphysics.demos.opengl.GLDebugDrawer;
import com.bulletphysics.demos.opengl.IGL;
import com.bulletphysics.demos.opengl.LWJGL;
import com.bulletphysics.dynamics.DiscreteDynamicsWorld;
import com.bulletphysics.dynamics.RigidBody;
import com.bulletphysics.dynamics.constraintsolver.ConstraintSolver;
import com.bulletphysics.dynamics.constraintsolver.SequentialImpulseConstraintSolver;
import com.bulletphysics.extras.gimpact.GImpactCollisionAlgorithm;
import com.bulletphysics.extras.gimpact.GImpactMeshShape;
import com.bulletphysics.linearmath.Transform;
import javax.vecmath.Quat4f;
import javax.vecmath.Vector3f;
import org.lwjgl.LWJGLException;

public class MovingConcaveDemo
extends DemoApplication {
    private BroadphaseInterface overlappingPairCache;
    private CollisionDispatcher dispatcher;
    private ConstraintSolver solver;
    private DefaultCollisionConfiguration collisionConfiguration;
    private CollisionShape trimeshShape;

    public MovingConcaveDemo(IGL gl) {
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

    public void initGImpactCollision() {
        TriangleIndexVertexArray indexVertexArrays = new TriangleIndexVertexArray(902, Bunny.getIndexBuffer(), 12, 453, Bunny.getVertexBuffer(), 12);
        GImpactMeshShape trimesh = new GImpactMeshShape(indexVertexArrays);
        trimesh.setLocalScaling(new Vector3f(4.0f, 4.0f, 4.0f));
        trimesh.updateBound();
        this.trimeshShape = trimesh;
        GImpactCollisionAlgorithm.registerAlgorithm(this.dispatcher);
    }

    @Override
    public void initPhysics() {
        this.setCameraDistance(30.0f);
        this.collisionConfiguration = new DefaultCollisionConfiguration();
        this.dispatcher = new CollisionDispatcher(this.collisionConfiguration);
        this.overlappingPairCache = new DbvtBroadphase();
        SequentialImpulseConstraintSolver sol = new SequentialImpulseConstraintSolver();
        this.solver = sol;
        this.dynamicsWorld = new DiscreteDynamicsWorld(this.dispatcher, this.overlappingPairCache, this.solver, this.collisionConfiguration);
        this.dynamicsWorld.setGravity(new Vector3f(0.0f, -10.0f, 0.0f));
        this.initGImpactCollision();
        float mass = 0.0f;
        Transform startTransform = new Transform();
        startTransform.setIdentity();
        BoxShape staticboxShape1 = new BoxShape(new Vector3f(200.0f, 1.0f, 200.0f));
        BoxShape staticboxShape2 = new BoxShape(new Vector3f(1.0f, 50.0f, 200.0f));
        BoxShape staticboxShape3 = new BoxShape(new Vector3f(1.0f, 50.0f, 200.0f));
        BoxShape staticboxShape4 = new BoxShape(new Vector3f(200.0f, 50.0f, 1.0f));
        BoxShape staticboxShape5 = new BoxShape(new Vector3f(200.0f, 50.0f, 1.0f));
        CompoundShape staticScenario = new CompoundShape();
        startTransform.origin.set(0.0f, 0.0f, 0.0f);
        staticScenario.addChildShape(startTransform, staticboxShape1);
        startTransform.origin.set(-200.0f, 25.0f, 0.0f);
        staticScenario.addChildShape(startTransform, staticboxShape2);
        startTransform.origin.set(200.0f, 25.0f, 0.0f);
        staticScenario.addChildShape(startTransform, staticboxShape3);
        startTransform.origin.set(0.0f, 25.0f, 200.0f);
        staticScenario.addChildShape(startTransform, staticboxShape4);
        startTransform.origin.set(0.0f, 25.0f, -200.0f);
        staticScenario.addChildShape(startTransform, staticboxShape5);
        startTransform.origin.set(0.0f, 0.0f, 0.0f);
        RigidBody staticBody = this.localCreateRigidBody(mass, startTransform, staticScenario);
        staticBody.setCollisionFlags(staticBody.getCollisionFlags() | 1);
        Vector3f normal = new Vector3f(0.4f, 1.5f, -0.4f);
        normal.normalize();
        StaticPlaneShape staticplaneShape6 = new StaticPlaneShape(normal, 0.0f);
        startTransform.origin.set(0.0f, 0.0f, 0.0f);
        RigidBody staticBody2 = this.localCreateRigidBody(mass, startTransform, staticplaneShape6);
        staticBody2.setCollisionFlags(staticBody2.getCollisionFlags() | 1);
        for (int i = 0; i < 9; ++i) {
            BoxShape boxShape = new BoxShape(new Vector3f(1.0f, 1.0f, 1.0f));
            startTransform.origin.set(2.0f * (float)i - 5.0f, 2.0f, -3.0f);
            this.localCreateRigidBody(1.0f, startTransform, boxShape);
        }
    }

    public void shootTrimesh(Vector3f destination) {
        if (this.dynamicsWorld != null) {
            float mass = 4.0f;
            Transform startTransform = new Transform();
            startTransform.setIdentity();
            Vector3f camPos = this.getCameraPosition();
            startTransform.origin.set(camPos);
            RigidBody body = this.localCreateRigidBody(mass, startTransform, this.trimeshShape);
            Vector3f linVel = new Vector3f(destination.x - camPos.x, destination.y - camPos.y, destination.z - camPos.z);
            linVel.normalize();
            linVel.scale(this.ShootBoxInitialSpeed * 0.25f);
            Transform tr = new Transform();
            tr.origin.set(camPos);
            tr.setRotation(new Quat4f(0.0f, 0.0f, 0.0f, 1.0f));
            body.setWorldTransform(tr);
            body.setLinearVelocity(linVel);
            body.setAngularVelocity(new Vector3f(0.0f, 0.0f, 0.0f));
        }
    }

    @Override
    public void keyboardCallback(char key, int x, int y, int modifiers) {
        switch (key) {
            case '.': {
                this.shootTrimesh(this.getCameraTargetPosition());
                break;
            }
            default: {
                super.keyboardCallback(key, x, y, modifiers);
            }
        }
    }

    public static void main(String[] args) throws LWJGLException {
        MovingConcaveDemo concaveDemo = new MovingConcaveDemo(LWJGL.getGL());
        concaveDemo.initPhysics();
        concaveDemo.getDynamicsWorld().setDebugDrawer(new GLDebugDrawer(LWJGL.getGL()));
        LWJGL.main(args, 800, 600, "Moving Concave Mesh Demo", concaveDemo);
    }
}

