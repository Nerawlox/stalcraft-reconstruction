/*
 * Decompiled with CFR 0.152.
 */
package com.bulletphysics.demos.character;

import com.bulletphysics.collision.broadphase.AxisSweep3;
import com.bulletphysics.collision.broadphase.BroadphaseInterface;
import com.bulletphysics.collision.dispatch.CollisionDispatcher;
import com.bulletphysics.collision.dispatch.DefaultCollisionConfiguration;
import com.bulletphysics.collision.dispatch.GhostPairCallback;
import com.bulletphysics.collision.dispatch.PairCachingGhostObject;
import com.bulletphysics.collision.shapes.BoxShape;
import com.bulletphysics.collision.shapes.CapsuleShape;
import com.bulletphysics.collision.shapes.CollisionShape;
import com.bulletphysics.collision.shapes.ConvexHullShape;
import com.bulletphysics.demos.bsp.BspConverter;
import com.bulletphysics.demos.opengl.DemoApplication;
import com.bulletphysics.demos.opengl.GLDebugDrawer;
import com.bulletphysics.demos.opengl.IGL;
import com.bulletphysics.demos.opengl.LWJGL;
import com.bulletphysics.dynamics.DiscreteDynamicsWorld;
import com.bulletphysics.dynamics.character.KinematicCharacterController;
import com.bulletphysics.dynamics.constraintsolver.ConstraintSolver;
import com.bulletphysics.dynamics.constraintsolver.SequentialImpulseConstraintSolver;
import com.bulletphysics.linearmath.Transform;
import com.bulletphysics.util.ObjectArrayList;
import javax.vecmath.Vector3f;

public class CharacterDemo
extends DemoApplication {
    private final int maxProxies = 32766;
    private final int maxOverlap = 65535;
    private static int gForward = 0;
    private static int gBackward = 0;
    private static int gLeft = 0;
    private static int gRight = 0;
    private static int gJump = 0;
    public KinematicCharacterController character;
    public PairCachingGhostObject ghostObject;
    public float cameraHeight = 4.0f;
    public float minCameraDistance = 3.0f;
    public float maxCameraDistance = 10.0f;
    private float characterScale = 2.0f;
    public ObjectArrayList<CollisionShape> collisionShapes = new ObjectArrayList();
    public BroadphaseInterface overlappingPairCache;
    public CollisionDispatcher dispatcher;
    public ConstraintSolver constraintSolver;
    public DefaultCollisionConfiguration collisionConfiguration;

    public CharacterDemo(IGL gl) {
        super(gl);
    }

    @Override
    public void initPhysics() throws Exception {
        BoxShape groundShape = new BoxShape(new Vector3f(50.0f, 3.0f, 50.0f));
        this.collisionShapes.add(groundShape);
        this.collisionConfiguration = new DefaultCollisionConfiguration();
        this.dispatcher = new CollisionDispatcher(this.collisionConfiguration);
        Vector3f worldMin = new Vector3f(-1000.0f, -1000.0f, -1000.0f);
        Vector3f worldMax = new Vector3f(1000.0f, 1000.0f, 1000.0f);
        AxisSweep3 sweepBP = new AxisSweep3(worldMin, worldMax);
        this.overlappingPairCache = sweepBP;
        this.constraintSolver = new SequentialImpulseConstraintSolver();
        this.dynamicsWorld = new DiscreteDynamicsWorld(this.dispatcher, this.overlappingPairCache, this.constraintSolver, this.collisionConfiguration);
        Transform startTransform = new Transform();
        startTransform.setIdentity();
        startTransform.origin.set(0.0f, 4.0f, 0.0f);
        this.ghostObject = new PairCachingGhostObject();
        this.ghostObject.setWorldTransform(startTransform);
        sweepBP.getOverlappingPairCache().setInternalGhostPairCallback(new GhostPairCallback());
        float characterHeight = 1.75f * this.characterScale;
        float characterWidth = 1.75f * this.characterScale;
        CapsuleShape capsule = new CapsuleShape(characterWidth, characterHeight);
        this.ghostObject.setCollisionShape(capsule);
        this.ghostObject.setCollisionFlags(16);
        float stepHeight = 0.35f * this.characterScale;
        this.character = new KinematicCharacterController(this.ghostObject, capsule, stepHeight);
        new BspToBulletConverter().convertBsp(this.getClass().getResourceAsStream("/com/bulletphysics/demos/bsp/exported.bsp.txt"));
        this.dynamicsWorld.addCollisionObject(this.ghostObject, (short)32, (short)3);
        this.dynamicsWorld.addAction(this.character);
        this.clientResetScene();
        this.setCameraDistance(56.0f);
    }

    @Override
    public void clientMoveAndDisplay() {
        this.gl.glClear(16640);
        float dt = this.getDeltaTimeMicroseconds() * 1.0E-6f;
        if (this.dynamicsWorld != null) {
            int maxSimSubSteps;
            int n = maxSimSubSteps = this.idle ? 1 : 2;
            if (this.idle) {
                dt = 0.0023809525f;
            }
            Transform xform = this.ghostObject.getWorldTransform(new Transform());
            Vector3f forwardDir = new Vector3f();
            xform.basis.getRow(2, forwardDir);
            Vector3f upDir = new Vector3f();
            xform.basis.getRow(1, upDir);
            Vector3f strafeDir = new Vector3f();
            xform.basis.getRow(0, strafeDir);
            forwardDir.normalize();
            upDir.normalize();
            strafeDir.normalize();
            Vector3f walkDirection = new Vector3f(0.0f, 0.0f, 0.0f);
            float walkVelocity = 4.4f;
            float walkSpeed = walkVelocity * dt * this.characterScale;
            if (gLeft != 0) {
                walkDirection.add(strafeDir);
            }
            if (gRight != 0) {
                walkDirection.sub(strafeDir);
            }
            if (gForward != 0) {
                walkDirection.add(forwardDir);
            }
            if (gBackward != 0) {
                walkDirection.sub(forwardDir);
            }
            walkDirection.scale(walkSpeed);
            this.character.setWalkDirection(walkDirection);
            int numSimSteps = this.dynamicsWorld.stepSimulation(dt, maxSimSubSteps);
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
    public void clientResetScene() {
        this.dynamicsWorld.getBroadphase().getOverlappingPairCache().cleanProxyFromPairs(this.ghostObject.getBroadphaseHandle(), this.getDynamicsWorld().getDispatcher());
        this.character.reset();
        this.character.warp(new Vector3f(0.0f, -2.0f, 0.0f));
    }

    @Override
    public void specialKeyboardUp(int key, int x, int y, int modifiers) {
        switch (key) {
            case 200: {
                gForward = 0;
                break;
            }
            case 208: {
                gBackward = 0;
                break;
            }
            case 203: {
                gLeft = 0;
                break;
            }
            case 205: {
                gRight = 0;
                break;
            }
            default: {
                super.specialKeyboardUp(key, x, y, modifiers);
            }
        }
    }

    @Override
    public void specialKeyboard(int key, int x, int y, int modifiers) {
        switch (key) {
            case 200: {
                gForward = 1;
                break;
            }
            case 208: {
                gBackward = 1;
                break;
            }
            case 203: {
                gLeft = 1;
                break;
            }
            case 205: {
                gRight = 1;
                break;
            }
            case 59: {
                if (this.character == null || !this.character.canJump()) break;
                gJump = 1;
                break;
            }
            default: {
                super.specialKeyboard(key, x, y, modifiers);
            }
        }
    }

    @Override
    public void updateCamera() {
        this.gl.glMatrixMode(5889);
        this.gl.glLoadIdentity();
        Transform characterWorldTrans = this.ghostObject.getWorldTransform(new Transform());
        Vector3f up = new Vector3f();
        characterWorldTrans.basis.getRow(1, up);
        Vector3f backward = new Vector3f();
        characterWorldTrans.basis.getRow(2, backward);
        backward.scale(-1.0f);
        up.normalize();
        backward.normalize();
        this.cameraTargetPosition.set(characterWorldTrans.origin);
        Vector3f cameraPosition = new Vector3f();
        cameraPosition.scale(2.0f, up);
        cameraPosition.add(this.cameraTargetPosition);
        backward.scale(12.0f);
        cameraPosition.add(backward);
        this.gl.glFrustum(-1.0, 1.0, -1.0, 1.0, 1.0, 10000.0);
        this.gl.glMatrixMode(5888);
        this.gl.glLoadIdentity();
        this.gl.gluLookAt(cameraPosition.x, cameraPosition.y, cameraPosition.z, this.cameraTargetPosition.x, this.cameraTargetPosition.y, this.cameraTargetPosition.z, this.cameraUp.x, this.cameraUp.y, this.cameraUp.z);
    }

    public static void main(String[] args) throws Exception {
        CharacterDemo demo = new CharacterDemo(LWJGL.getGL());
        demo.initPhysics();
        demo.getDynamicsWorld().setDebugDrawer(new GLDebugDrawer(LWJGL.getGL()));
        LWJGL.main(args, 800, 600, "Bullet Character Demo. http://bullet.sf.net", demo);
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
                startTransform.basis.rotX(-1.5707964f);
                startTransform.origin.set(0.0f, -10.0f, 0.0f);
                ConvexHullShape shape = new ConvexHullShape(vertices);
                CharacterDemo.this.collisionShapes.add(shape);
                CharacterDemo.this.localCreateRigidBody(mass, startTransform, shape);
            }
        }
    }
}

