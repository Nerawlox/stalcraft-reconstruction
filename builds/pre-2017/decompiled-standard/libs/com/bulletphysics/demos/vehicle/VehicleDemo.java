/*
 * Decompiled with CFR 0.152.
 */
package com.bulletphysics.demos.vehicle;

import com.bulletphysics.collision.broadphase.BroadphaseInterface;
import com.bulletphysics.collision.broadphase.DbvtBroadphase;
import com.bulletphysics.collision.dispatch.CollisionDispatcher;
import com.bulletphysics.collision.dispatch.DefaultCollisionConfiguration;
import com.bulletphysics.collision.shapes.BoxShape;
import com.bulletphysics.collision.shapes.BvhTriangleMeshShape;
import com.bulletphysics.collision.shapes.CollisionShape;
import com.bulletphysics.collision.shapes.CompoundShape;
import com.bulletphysics.collision.shapes.CylinderShapeX;
import com.bulletphysics.collision.shapes.TriangleIndexVertexArray;
import com.bulletphysics.demos.opengl.DemoApplication;
import com.bulletphysics.demos.opengl.GLDebugDrawer;
import com.bulletphysics.demos.opengl.GLShapeDrawer;
import com.bulletphysics.demos.opengl.IGL;
import com.bulletphysics.demos.opengl.LWJGL;
import com.bulletphysics.dynamics.DiscreteDynamicsWorld;
import com.bulletphysics.dynamics.RigidBody;
import com.bulletphysics.dynamics.constraintsolver.ConstraintSolver;
import com.bulletphysics.dynamics.constraintsolver.SequentialImpulseConstraintSolver;
import com.bulletphysics.dynamics.vehicle.DefaultVehicleRaycaster;
import com.bulletphysics.dynamics.vehicle.RaycastVehicle;
import com.bulletphysics.dynamics.vehicle.VehicleRaycaster;
import com.bulletphysics.dynamics.vehicle.VehicleTuning;
import com.bulletphysics.dynamics.vehicle.WheelInfo;
import com.bulletphysics.linearmath.Transform;
import com.bulletphysics.util.ObjectArrayList;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import javax.vecmath.Vector3f;
import org.lwjgl.LWJGLException;

public class VehicleDemo
extends DemoApplication {
    private static final int rightIndex = 0;
    private static final int upIndex = 1;
    private static final int forwardIndex = 2;
    private static final Vector3f wheelDirectionCS0 = new Vector3f(0.0f, -1.0f, 0.0f);
    private static final Vector3f wheelAxleCS = new Vector3f(-1.0f, 0.0f, 0.0f);
    private static final int maxProxies = 32766;
    private static final int maxOverlap = 65535;
    private static float gEngineForce = 0.0f;
    private static float gBreakingForce = 0.0f;
    private static float maxEngineForce = 1000.0f;
    private static float maxBreakingForce = 100.0f;
    private static float gVehicleSteering = 0.0f;
    private static float steeringIncrement = 0.04f;
    private static float steeringClamp = 0.3f;
    private static float wheelRadius = 0.5f;
    private static float wheelWidth = 0.2f;
    private static float wheelFriction = 80.0f;
    private static float suspensionStiffness = 40.0f;
    private static float suspensionDamping = 2.3f;
    private static float suspensionCompression = 2.4f;
    private static float rollInfluence = 0.1f;
    private static final float suspensionRestLength = 0.15f;
    private static final int CUBE_HALF_EXTENTS = 1;
    public RigidBody carChassis = null;
    public ObjectArrayList<CollisionShape> collisionShapes = new ObjectArrayList();
    public BroadphaseInterface overlappingPairCache;
    public CollisionDispatcher dispatcher;
    public ConstraintSolver constraintSolver;
    public DefaultCollisionConfiguration collisionConfiguration;
    public TriangleIndexVertexArray indexVertexArrays = null;
    public ByteBuffer vertices = null;
    public VehicleTuning tuning = new VehicleTuning();
    public VehicleRaycaster vehicleRayCaster;
    public RaycastVehicle vehicle = null;
    public float cameraHeight = 4.0f;
    public float minCameraDistance = 3.0f;
    public float maxCameraDistance = 10.0f;

    public VehicleDemo(IGL gl) {
        super(gl);
        this.cameraPosition.set(30.0f, 30.0f, 30.0f);
    }

    @Override
    public void initPhysics() {
        int j;
        int i;
        CollisionShape groundShape = new BoxShape(new Vector3f(50.0f, 3.0f, 50.0f));
        this.collisionShapes.add(groundShape);
        this.collisionConfiguration = new DefaultCollisionConfiguration();
        this.dispatcher = new CollisionDispatcher(this.collisionConfiguration);
        Vector3f worldMin = new Vector3f(-1000.0f, -1000.0f, -1000.0f);
        Vector3f worldMax = new Vector3f(1000.0f, 1000.0f, 1000.0f);
        this.overlappingPairCache = new DbvtBroadphase();
        this.constraintSolver = new SequentialImpulseConstraintSolver();
        this.dynamicsWorld = new DiscreteDynamicsWorld(this.dispatcher, this.overlappingPairCache, this.constraintSolver, this.collisionConfiguration);
        Transform tr = new Transform();
        tr.setIdentity();
        float TRIANGLE_SIZE = 1.0f;
        int vertStride = 12;
        int indexStride = 12;
        int NUM_VERTS_X = 200;
        int NUM_VERTS_Y = 200;
        int totalVerts = 40000;
        int totalTriangles = 79202;
        this.vertices = ByteBuffer.allocateDirect(40000 * vertStride).order(ByteOrder.nativeOrder());
        ByteBuffer gIndices = ByteBuffer.allocateDirect(950424).order(ByteOrder.nativeOrder());
        Vector3f tmp = new Vector3f();
        for (i = 0; i < 200; ++i) {
            for (j = 0; j < 200; ++j) {
                float wl = 0.2f;
                float height = 2.0f * (float)Math.sin((float)i * wl) * (float)Math.cos((float)j * wl);
                height *= 10.0f;
                height = (int)height / 10;
                tmp.set(((float)i - 100.0f) * 1.0f, height /= 2.0f, ((float)j - 100.0f) * 1.0f);
                int index = i + j * 200;
                this.vertices.putFloat((index * 3 + 0) * 4, tmp.x);
                this.vertices.putFloat((index * 3 + 1) * 4, tmp.y);
                this.vertices.putFloat((index * 3 + 2) * 4, tmp.z);
            }
        }
        gIndices.clear();
        for (i = 0; i < 199; ++i) {
            for (j = 0; j < 199; ++j) {
                gIndices.putInt(j * 200 + i);
                gIndices.putInt(j * 200 + i + 1);
                gIndices.putInt((j + 1) * 200 + i + 1);
                gIndices.putInt(j * 200 + i);
                gIndices.putInt((j + 1) * 200 + i + 1);
                gIndices.putInt((j + 1) * 200 + i);
            }
        }
        gIndices.flip();
        this.indexVertexArrays = new TriangleIndexVertexArray(79202, gIndices, indexStride, 40000, this.vertices, vertStride);
        boolean useQuantizedAabbCompression = true;
        groundShape = new BvhTriangleMeshShape(this.indexVertexArrays, useQuantizedAabbCompression);
        tr.origin.set(0.0f, -4.5f, 0.0f);
        this.collisionShapes.add(groundShape);
        this.localCreateRigidBody(0.0f, tr, groundShape);
        BoxShape chassisShape = new BoxShape(new Vector3f(1.0f, 0.5f, 2.0f));
        this.collisionShapes.add(chassisShape);
        CompoundShape compound = new CompoundShape();
        this.collisionShapes.add(compound);
        Transform localTrans = new Transform();
        localTrans.setIdentity();
        localTrans.origin.set(0.0f, 1.0f, 0.0f);
        compound.addChildShape(localTrans, chassisShape);
        tr.origin.set(0.0f, 0.0f, 0.0f);
        this.carChassis = this.localCreateRigidBody(800.0f, tr, compound);
        this.clientResetScene();
        this.vehicleRayCaster = new DefaultVehicleRaycaster(this.dynamicsWorld);
        this.vehicle = new RaycastVehicle(this.tuning, this.carChassis, this.vehicleRayCaster);
        this.carChassis.setActivationState(4);
        this.dynamicsWorld.addVehicle(this.vehicle);
        float connectionHeight = 0.9f;
        boolean isFrontWheel = true;
        this.vehicle.setCoordinateSystem(0, 1, 2);
        Vector3f connectionPointCS0 = new Vector3f(1.0f - 0.3f * wheelWidth, connectionHeight, 2.0f - wheelRadius);
        this.vehicle.addWheel(connectionPointCS0, wheelDirectionCS0, wheelAxleCS, 0.15f, wheelRadius, this.tuning, isFrontWheel);
        connectionPointCS0.set(-1.0f + 0.3f * wheelWidth, connectionHeight, 2.0f - wheelRadius);
        this.vehicle.addWheel(connectionPointCS0, wheelDirectionCS0, wheelAxleCS, 0.15f, wheelRadius, this.tuning, isFrontWheel);
        isFrontWheel = false;
        connectionPointCS0.set(-1.0f + 0.3f * wheelWidth, connectionHeight, -2.0f + wheelRadius);
        this.vehicle.addWheel(connectionPointCS0, wheelDirectionCS0, wheelAxleCS, 0.15f, wheelRadius, this.tuning, isFrontWheel);
        connectionPointCS0.set(1.0f - 0.3f * wheelWidth, connectionHeight, -2.0f + wheelRadius);
        this.vehicle.addWheel(connectionPointCS0, wheelDirectionCS0, wheelAxleCS, 0.15f, wheelRadius, this.tuning, isFrontWheel);
        for (int i2 = 0; i2 < this.vehicle.getNumWheels(); ++i2) {
            WheelInfo wheel = this.vehicle.getWheelInfo(i2);
            wheel.suspensionStiffness = suspensionStiffness;
            wheel.wheelsDampingRelaxation = suspensionDamping;
            wheel.wheelsDampingCompression = suspensionCompression;
            wheel.frictionSlip = wheelFriction;
            wheel.rollInfluence = rollInfluence;
        }
        this.addBoxes();
        this.setCameraDistance(26.0f);
    }

    @Override
    public void renderme() {
        this.updateCamera();
        CylinderShapeX wheelShape = new CylinderShapeX(new Vector3f(wheelWidth, wheelRadius, wheelRadius));
        Vector3f wheelColor = new Vector3f(1.0f, 0.0f, 0.0f);
        for (int i = 0; i < this.vehicle.getNumWheels(); ++i) {
            this.vehicle.updateWheelTransform(i, true);
            Transform trans = this.vehicle.getWheelInfo((int)i).worldTransform;
            GLShapeDrawer.drawOpenGL(this.gl, trans, wheelShape, wheelColor, this.getDebugMode());
        }
        super.renderme();
    }

    private void addBoxes() {
        for (int x = 0; x < 10; ++x) {
            for (int y = 0; y < 10; ++y) {
                float mass = 1.0f;
                Transform startTransform = new Transform();
                startTransform.setIdentity();
                startTransform.origin.set(x, y - 5, 30.0f);
                if (this.shootBoxShape == null) {
                    this.shootBoxShape = new BoxShape(new Vector3f(0.5f, 0.5f, 0.5f));
                }
                RigidBody body = this.localCreateRigidBody(mass, startTransform, this.shootBoxShape);
            }
        }
    }

    @Override
    public void clientMoveAndDisplay() {
        this.gl.glClear(0x4000 | 0x100);
        int wheelIndex = 2;
        this.vehicle.applyEngineForce(gEngineForce, wheelIndex);
        this.vehicle.setBrake(gBreakingForce, wheelIndex);
        wheelIndex = 3;
        this.vehicle.applyEngineForce(gEngineForce, wheelIndex);
        this.vehicle.setBrake(gBreakingForce, wheelIndex);
        wheelIndex = 0;
        this.vehicle.setSteeringValue(gVehicleSteering, wheelIndex);
        wheelIndex = 1;
        this.vehicle.setSteeringValue(gVehicleSteering, wheelIndex);
        float dt = this.getDeltaTimeMicroseconds() * 1.0E-6f;
        if (this.dynamicsWorld != null) {
            int maxSimSubSteps;
            int n = maxSimSubSteps = this.idle ? 1 : 2;
            if (this.idle) {
                dt = 0.0023809525f;
            }
            int n2 = this.dynamicsWorld.stepSimulation(dt, maxSimSubSteps);
        }
        this.renderme();
        if (this.dynamicsWorld != null) {
            this.dynamicsWorld.debugDrawWorld();
        }
    }

    @Override
    public void displayCallback() {
        this.gl.glClear(0x4000 | 0x100);
        this.renderme();
        if (this.dynamicsWorld != null) {
            this.dynamicsWorld.debugDrawWorld();
        }
    }

    @Override
    public void clientResetScene() {
        gVehicleSteering = 0.0f;
        Transform tr = new Transform();
        tr.setIdentity();
        this.carChassis.setCenterOfMassTransform(tr);
        this.carChassis.setLinearVelocity(new Vector3f(0.0f, 0.0f, 0.0f));
        this.carChassis.setAngularVelocity(new Vector3f(0.0f, 0.0f, 0.0f));
        this.dynamicsWorld.getBroadphase().getOverlappingPairCache().cleanProxyFromPairs(this.carChassis.getBroadphaseHandle(), this.getDynamicsWorld().getDispatcher());
        if (this.vehicle != null) {
            this.vehicle.resetSuspension();
            for (int i = 0; i < this.vehicle.getNumWheels(); ++i) {
                this.vehicle.updateWheelTransform(i, true);
            }
        }
    }

    @Override
    public void specialKeyboardUp(int key, int x, int y, int modifiers) {
        switch (key) {
            case 200: {
                gEngineForce = 0.0f;
                break;
            }
            case 208: {
                gBreakingForce = 0.0f;
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
            case 203: {
                gVehicleSteering += steeringIncrement;
                if (!(gVehicleSteering > steeringClamp)) break;
                gVehicleSteering = steeringClamp;
                break;
            }
            case 205: {
                gVehicleSteering -= steeringIncrement;
                if (!(gVehicleSteering < -steeringClamp)) break;
                gVehicleSteering = -steeringClamp;
                break;
            }
            case 200: {
                gEngineForce = maxEngineForce;
                gBreakingForce = 0.0f;
                break;
            }
            case 208: {
                gBreakingForce = maxBreakingForce;
                gEngineForce = 0.0f;
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
        Transform chassisWorldTrans = new Transform();
        this.carChassis.getMotionState().getWorldTransform(chassisWorldTrans);
        this.cameraTargetPosition.set(chassisWorldTrans.origin);
        this.cameraPosition.y = (15.0f * this.cameraPosition.y + this.cameraTargetPosition.y + this.cameraHeight) / 16.0f;
        Vector3f camToObject = new Vector3f();
        camToObject.sub(this.cameraTargetPosition, this.cameraPosition);
        float cameraDistance = camToObject.length();
        float correctionFactor = 0.0f;
        if (cameraDistance < this.minCameraDistance) {
            correctionFactor = 0.15f * (this.minCameraDistance - cameraDistance) / cameraDistance;
        }
        if (cameraDistance > this.maxCameraDistance) {
            correctionFactor = 0.15f * (this.maxCameraDistance - cameraDistance) / cameraDistance;
        }
        Vector3f tmp = new Vector3f();
        tmp.scale(correctionFactor, camToObject);
        this.cameraPosition.sub(tmp);
        this.gl.glFrustum(-1.0, 1.0, -1.0, 1.0, 1.0, 10000.0);
        this.gl.glMatrixMode(5888);
        this.gl.glLoadIdentity();
        this.gl.gluLookAt(this.cameraPosition.x, this.cameraPosition.y, this.cameraPosition.z, this.cameraTargetPosition.x, this.cameraTargetPosition.y, this.cameraTargetPosition.z, this.cameraUp.x, this.cameraUp.y, this.cameraUp.z);
    }

    public static void main(String[] args) throws LWJGLException {
        VehicleDemo vehicleDemo = new VehicleDemo(LWJGL.getGL());
        vehicleDemo.initPhysics();
        vehicleDemo.getDynamicsWorld().setDebugDrawer(new GLDebugDrawer(LWJGL.getGL()));
        LWJGL.main(args, 1920, 1080, "Bullet Vehicle Demo", vehicleDemo);
    }
}

