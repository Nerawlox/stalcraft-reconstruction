/*
 * Decompiled with CFR 0.152.
 */
package com.bulletphysics.demos.forklift;

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
import com.bulletphysics.dynamics.constraintsolver.HingeConstraint;
import com.bulletphysics.dynamics.constraintsolver.SequentialImpulseConstraintSolver;
import com.bulletphysics.dynamics.constraintsolver.SliderConstraint;
import com.bulletphysics.dynamics.vehicle.DefaultVehicleRaycaster;
import com.bulletphysics.dynamics.vehicle.RaycastVehicle;
import com.bulletphysics.dynamics.vehicle.VehicleRaycaster;
import com.bulletphysics.dynamics.vehicle.VehicleTuning;
import com.bulletphysics.dynamics.vehicle.WheelInfo;
import com.bulletphysics.linearmath.MatrixUtil;
import com.bulletphysics.linearmath.Transform;
import com.bulletphysics.util.ObjectArrayList;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import javax.vecmath.Vector3f;
import org.lwjgl.LWJGLException;

public class ForkLiftDemo
extends DemoApplication {
    public static final float PI = (float)Math.PI;
    public static final float PI_2 = 1.5707964f;
    public static final float PI_4 = 0.7853982f;
    public static final float LIFT_EPS = 1.0E-7f;
    private int rightIndex = 0;
    private int upIndex = 1;
    private int forwardIndex = 2;
    private final Vector3f wheelDirectionCS0 = new Vector3f(0.0f, -1.0f, 0.0f);
    private final Vector3f wheelAxleCS = new Vector3f(-1.0f, 0.0f, 0.0f);
    private static final int maxProxies = 32766;
    private static final int maxOverlap = 65535;
    private float gEngineForce = 0.0f;
    private float defaultBreakingForce = 10.0f;
    private float gBreakingForce = 10.0f;
    private float maxEngineForce = 1000.0f;
    private float maxBreakingForce = 100.0f;
    private float gVehicleSteering = 0.0f;
    private float steeringIncrement = 0.04f;
    private float steeringClamp = 0.3f;
    private float wheelRadius = 0.5f;
    private float wheelWidth = 0.4f;
    private float wheelFriction = 1000.0f;
    private float suspensionStiffness = 20.0f;
    private float suspensionDamping = 2.3f;
    private float suspensionCompression = 4.4f;
    private float rollInfluence = 0.1f;
    private float suspensionRestLength = 0.6f;
    private static final float CUBE_HALF_EXTENTS = 1.0f;
    public RigidBody carChassis;
    public RigidBody liftBody;
    public final Vector3f liftStartPos = new Vector3f();
    public HingeConstraint liftHinge;
    public RigidBody forkBody;
    public Vector3f forkStartPos = new Vector3f();
    public SliderConstraint forkSlider;
    public RigidBody loadBody;
    public Vector3f loadStartPos = new Vector3f();
    public boolean useDefaultCamera;
    public ObjectArrayList<CollisionShape> collisionShapes = new ObjectArrayList();
    public BroadphaseInterface overlappingPairCache;
    public CollisionDispatcher dispatcher;
    public ConstraintSolver constraintSolver;
    public DefaultCollisionConfiguration collisionConfiguration;
    public TriangleIndexVertexArray indexVertexArrays;
    public ByteBuffer vertices;
    public VehicleTuning tuning = new VehicleTuning();
    public VehicleRaycaster vehicleRayCaster;
    public RaycastVehicle vehicle;
    public float cameraHeight = 4.0f;
    public float minCameraDistance = 3.0f;
    public float maxCameraDistance = 10.0f;

    public ForkLiftDemo(IGL gl) {
        super(gl);
        this.cameraPosition.set(30.0f, 30.0f, 30.0f);
        this.useDefaultCamera = false;
    }

    public void lockLiftHinge() {
        float hingeAngle = this.liftHinge.getHingeAngle();
        float lowLim = this.liftHinge.getLowerLimit();
        float hiLim = this.liftHinge.getUpperLimit();
        this.liftHinge.enableAngularMotor(false, 0.0f, 0.0f);
        if (hingeAngle < lowLim) {
            this.liftHinge.setLimit(lowLim, lowLim + 1.0E-7f);
        } else if (hingeAngle > hiLim) {
            this.liftHinge.setLimit(hiLim - 1.0E-7f, hiLim);
        } else {
            this.liftHinge.setLimit(hingeAngle - 1.0E-7f, hingeAngle + 1.0E-7f);
        }
    }

    public void lockForkSlider() {
        float linDepth = this.forkSlider.getLinearPos();
        float lowLim = this.forkSlider.getLowerLinLimit();
        float hiLim = this.forkSlider.getUpperLinLimit();
        this.forkSlider.setPoweredLinMotor(false);
        if (linDepth <= lowLim) {
            this.forkSlider.setLowerLinLimit(lowLim);
            this.forkSlider.setUpperLinLimit(lowLim);
        } else if (linDepth > hiLim) {
            this.forkSlider.setLowerLinLimit(hiLim);
            this.forkSlider.setUpperLinLimit(hiLim);
        } else {
            this.forkSlider.setLowerLinLimit(linDepth);
            this.forkSlider.setUpperLinLimit(linDepth);
        }
    }

    @Override
    public void clientMoveAndDisplay() {
        this.gl.glClear(0x4000 | 0x100);
        int wheelIndex = 2;
        this.vehicle.applyEngineForce(this.gEngineForce, wheelIndex);
        this.vehicle.setBrake(this.gBreakingForce, wheelIndex);
        wheelIndex = 3;
        this.vehicle.applyEngineForce(this.gEngineForce, wheelIndex);
        this.vehicle.setBrake(this.gBreakingForce, wheelIndex);
        wheelIndex = 0;
        this.vehicle.setSteeringValue(this.gVehicleSteering, wheelIndex);
        wheelIndex = 1;
        this.vehicle.setSteeringValue(this.gVehicleSteering, wheelIndex);
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
    public void clientResetScene() {
        this.gVehicleSteering = 0.0f;
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
        Transform liftTrans = new Transform();
        liftTrans.setIdentity();
        liftTrans.origin.set(this.liftStartPos);
        this.liftBody.activate();
        this.liftBody.setCenterOfMassTransform(liftTrans);
        this.liftBody.setLinearVelocity(new Vector3f(0.0f, 0.0f, 0.0f));
        this.liftBody.setAngularVelocity(new Vector3f(0.0f, 0.0f, 0.0f));
        Transform forkTrans = new Transform();
        forkTrans.setIdentity();
        forkTrans.origin.set(this.forkStartPos);
        this.forkBody.activate();
        this.forkBody.setCenterOfMassTransform(forkTrans);
        this.forkBody.setLinearVelocity(new Vector3f(0.0f, 0.0f, 0.0f));
        this.forkBody.setAngularVelocity(new Vector3f(0.0f, 0.0f, 0.0f));
        this.liftHinge.setLimit(-1.0E-7f, 1.0E-7f);
        this.liftHinge.enableAngularMotor(false, 0.0f, 0.0f);
        this.forkSlider.setLowerLinLimit(0.1f);
        this.forkSlider.setUpperLinLimit(0.1f);
        this.forkSlider.setPoweredLinMotor(false);
        Transform loadTrans = new Transform();
        loadTrans.setIdentity();
        loadTrans.origin.set(this.loadStartPos);
        this.loadBody.activate();
        this.loadBody.setCenterOfMassTransform(loadTrans);
        this.loadBody.setLinearVelocity(new Vector3f(0.0f, 0.0f, 0.0f));
        this.loadBody.setAngularVelocity(new Vector3f(0.0f, 0.0f, 0.0f));
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
    public void updateCamera() {
        if (this.useDefaultCamera) {
            super.updateCamera();
            return;
        }
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

    @Override
    public void specialKeyboard(int key, int x, int y, int modifiers) {
        if (key == 207) {
            return;
        }
        if ((modifiers & 0x40) != 0) {
            switch (key) {
                case 203: {
                    this.liftHinge.setLimit(-0.19634955f, 0.3926991f);
                    this.liftHinge.enableAngularMotor(true, -0.1f, 10.0f);
                    break;
                }
                case 205: {
                    this.liftHinge.setLimit(-0.19634955f, 0.3926991f);
                    this.liftHinge.enableAngularMotor(true, 0.1f, 10.0f);
                    break;
                }
                case 200: {
                    this.forkSlider.setLowerLinLimit(0.1f);
                    this.forkSlider.setUpperLinLimit(3.9f);
                    this.forkSlider.setPoweredLinMotor(true);
                    this.forkSlider.setMaxLinMotorForce(10.0f);
                    this.forkSlider.setTargetLinMotorVelocity(1.0f);
                    break;
                }
                case 208: {
                    this.forkSlider.setLowerLinLimit(0.1f);
                    this.forkSlider.setUpperLinLimit(3.9f);
                    this.forkSlider.setPoweredLinMotor(true);
                    this.forkSlider.setMaxLinMotorForce(10.0f);
                    this.forkSlider.setTargetLinMotorVelocity(-1.0f);
                    break;
                }
                default: {
                    super.specialKeyboard(key, x, y, modifiers);
                    break;
                }
            }
        } else {
            switch (key) {
                case 203: {
                    this.gVehicleSteering += this.steeringIncrement;
                    if (!(this.gVehicleSteering > this.steeringClamp)) break;
                    this.gVehicleSteering = this.steeringClamp;
                    break;
                }
                case 205: {
                    this.gVehicleSteering -= this.steeringIncrement;
                    if (!(this.gVehicleSteering < -this.steeringClamp)) break;
                    this.gVehicleSteering = -this.steeringClamp;
                    break;
                }
                case 200: {
                    this.gEngineForce = this.maxEngineForce;
                    this.gBreakingForce = 0.0f;
                    break;
                }
                case 208: {
                    this.gEngineForce = -this.maxEngineForce;
                    this.gBreakingForce = 0.0f;
                    break;
                }
                case 63: {
                    this.useDefaultCamera = !this.useDefaultCamera;
                    break;
                }
                default: {
                    super.specialKeyboard(key, x, y, modifiers);
                }
            }
        }
    }

    @Override
    public void specialKeyboardUp(int key, int x, int y, int modifiers) {
        switch (key) {
            case 200: {
                this.lockForkSlider();
                this.gEngineForce = 0.0f;
                this.gBreakingForce = this.defaultBreakingForce;
                break;
            }
            case 208: {
                this.lockForkSlider();
                this.gEngineForce = 0.0f;
                this.gBreakingForce = this.defaultBreakingForce;
                break;
            }
            case 203: 
            case 205: {
                this.lockLiftHinge();
                break;
            }
            default: {
                super.specialKeyboardUp(key, x, y, modifiers);
            }
        }
    }

    @Override
    public void renderme() {
        this.updateCamera();
        CylinderShapeX wheelShape = new CylinderShapeX(new Vector3f(this.wheelWidth, this.wheelRadius, this.wheelRadius));
        Vector3f wheelColor = new Vector3f(1.0f, 0.0f, 0.0f);
        Vector3f worldBoundsMin = new Vector3f();
        Vector3f worldBoundsMax = new Vector3f();
        this.getDynamicsWorld().getBroadphase().getBroadphaseAabb(worldBoundsMin, worldBoundsMax);
        for (int i = 0; i < this.vehicle.getNumWheels(); ++i) {
            this.vehicle.updateWheelTransform(i, true);
            Transform trans = this.vehicle.getWheelInfo((int)i).worldTransform;
            GLShapeDrawer.drawOpenGL(this.gl, trans, wheelShape, wheelColor, this.getDebugMode());
        }
        super.renderme();
        if ((this.getDebugMode() & 0x20) == 0) {
            this.setOrthographicProjection();
            this.gl.glDisable(2896);
            this.gl.glColor3f(0.0f, 0.0f, 0.0f);
            this.drawString("SHIFT+Cursor Left/Right - rotate lift", 350, 20, this.TEXT_COLOR);
            this.drawString("SHIFT+Cursor UP/Down - move fork up/down", 350, 40, this.TEXT_COLOR);
            this.drawString("F5 - toggle camera mode", 350, 60, this.TEXT_COLOR);
            this.resetPerspectiveProjection();
            this.gl.glEnable(2896);
        }
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
        float TRIANGLE_SIZE = 20.0f;
        int vertStride = 12;
        int indexStride = 12;
        int NUM_VERTS_X = 20;
        int NUM_VERTS_Y = 20;
        int totalVerts = 400;
        int totalTriangles = 722;
        this.vertices = ByteBuffer.allocateDirect(400 * vertStride).order(ByteOrder.nativeOrder());
        ByteBuffer gIndices = ByteBuffer.allocateDirect(8664).order(ByteOrder.nativeOrder());
        for (i = 0; i < 20; ++i) {
            for (j = 0; j < 20; ++j) {
                float wl = 0.2f;
                float height = 0.0f;
                int idx = (i + j * 20) * 3 * 4;
                this.vertices.putFloat(idx + 0, ((float)i - 10.0f) * 20.0f);
                this.vertices.putFloat(idx + 4, height);
                this.vertices.putFloat(idx + 8, ((float)j - 10.0f) * 20.0f);
            }
        }
        for (i = 0; i < 19; ++i) {
            for (j = 0; j < 19; ++j) {
                gIndices.putInt(j * 20 + i);
                gIndices.putInt(j * 20 + i + 1);
                gIndices.putInt((j + 1) * 20 + i + 1);
                gIndices.putInt(j * 20 + i);
                gIndices.putInt((j + 1) * 20 + i + 1);
                gIndices.putInt((j + 1) * 20 + i);
            }
        }
        gIndices.flip();
        this.indexVertexArrays = new TriangleIndexVertexArray(722, gIndices, indexStride, 400, this.vertices, vertStride);
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
        BoxShape suppShape = new BoxShape(new Vector3f(0.5f, 0.1f, 0.5f));
        this.collisionShapes.add(chassisShape);
        Transform suppLocalTrans = new Transform();
        suppLocalTrans.setIdentity();
        suppLocalTrans.origin.set(0.0f, 1.0f, 2.5f);
        compound.addChildShape(suppLocalTrans, suppShape);
        tr.origin.set(0.0f, 0.0f, 0.0f);
        this.carChassis = this.localCreateRigidBody(800.0f, tr, compound);
        BoxShape liftShape = new BoxShape(new Vector3f(0.5f, 2.0f, 0.05f));
        this.collisionShapes.add(liftShape);
        Transform liftTrans = new Transform();
        this.liftStartPos.set(0.0f, 2.5f, 3.05f);
        liftTrans.setIdentity();
        liftTrans.origin.set(this.liftStartPos);
        this.liftBody = this.localCreateRigidBody(10.0f, liftTrans, liftShape);
        Transform localA = new Transform();
        Transform localB = new Transform();
        localA.setIdentity();
        localB.setIdentity();
        MatrixUtil.setEulerZYX(localA.basis, 0.0f, 1.5707964f, 0.0f);
        localA.origin.set(0.0f, 1.0f, 3.05f);
        MatrixUtil.setEulerZYX(localB.basis, 0.0f, 1.5707964f, 0.0f);
        localB.origin.set(0.0f, -1.5f, -0.05f);
        this.liftHinge = new HingeConstraint(this.carChassis, this.liftBody, localA, localB);
        this.liftHinge.setLimit(-1.0E-7f, 1.0E-7f);
        this.dynamicsWorld.addConstraint(this.liftHinge, true);
        BoxShape forkShapeA = new BoxShape(new Vector3f(1.0f, 0.1f, 0.1f));
        this.collisionShapes.add(forkShapeA);
        CompoundShape forkCompound = new CompoundShape();
        this.collisionShapes.add(forkCompound);
        Transform forkLocalTrans = new Transform();
        forkLocalTrans.setIdentity();
        forkCompound.addChildShape(forkLocalTrans, forkShapeA);
        BoxShape forkShapeB = new BoxShape(new Vector3f(0.1f, 0.02f, 0.6f));
        this.collisionShapes.add(forkShapeB);
        forkLocalTrans.setIdentity();
        forkLocalTrans.origin.set(-0.9f, -0.08f, 0.7f);
        forkCompound.addChildShape(forkLocalTrans, forkShapeB);
        BoxShape forkShapeC = new BoxShape(new Vector3f(0.1f, 0.02f, 0.6f));
        this.collisionShapes.add(forkShapeC);
        forkLocalTrans.setIdentity();
        forkLocalTrans.origin.set(0.9f, -0.08f, 0.7f);
        forkCompound.addChildShape(forkLocalTrans, forkShapeC);
        Transform forkTrans = new Transform();
        this.forkStartPos.set(0.0f, 0.6f, 3.2f);
        forkTrans.setIdentity();
        forkTrans.origin.set(this.forkStartPos);
        this.forkBody = this.localCreateRigidBody(5.0f, forkTrans, forkCompound);
        localA.setIdentity();
        localB.setIdentity();
        MatrixUtil.setEulerZYX(localA.basis, 0.0f, 0.0f, 1.5707964f);
        localA.origin.set(0.0f, -1.9f, 0.05f);
        MatrixUtil.setEulerZYX(localB.basis, 0.0f, 0.0f, 1.5707964f);
        localB.origin.set(0.0f, 0.0f, -0.1f);
        this.forkSlider = new SliderConstraint(this.liftBody, this.forkBody, localA, localB, true);
        this.forkSlider.setLowerLinLimit(0.1f);
        this.forkSlider.setUpperLinLimit(0.1f);
        this.forkSlider.setLowerAngLimit(-1.0E-7f);
        this.forkSlider.setUpperAngLimit(1.0E-7f);
        this.dynamicsWorld.addConstraint(this.forkSlider, true);
        CompoundShape loadCompound = new CompoundShape();
        this.collisionShapes.add(loadCompound);
        BoxShape loadShapeA = new BoxShape(new Vector3f(2.0f, 0.5f, 0.5f));
        this.collisionShapes.add(loadShapeA);
        Transform loadTrans = new Transform();
        loadTrans.setIdentity();
        loadCompound.addChildShape(loadTrans, loadShapeA);
        BoxShape loadShapeB = new BoxShape(new Vector3f(0.1f, 1.0f, 1.0f));
        this.collisionShapes.add(loadShapeB);
        loadTrans.setIdentity();
        loadTrans.origin.set(2.1f, 0.0f, 0.0f);
        loadCompound.addChildShape(loadTrans, loadShapeB);
        BoxShape loadShapeC = new BoxShape(new Vector3f(0.1f, 1.0f, 1.0f));
        this.collisionShapes.add(loadShapeC);
        loadTrans.setIdentity();
        loadTrans.origin.set(-2.1f, 0.0f, 0.0f);
        loadCompound.addChildShape(loadTrans, loadShapeC);
        loadTrans.setIdentity();
        this.loadStartPos.set(0.0f, -3.5f, 7.0f);
        loadTrans.origin.set(this.loadStartPos);
        this.loadBody = this.localCreateRigidBody(4.0f, loadTrans, loadCompound);
        this.clientResetScene();
        this.vehicleRayCaster = new DefaultVehicleRaycaster(this.dynamicsWorld);
        this.vehicle = new RaycastVehicle(this.tuning, this.carChassis, this.vehicleRayCaster);
        this.carChassis.setActivationState(4);
        this.dynamicsWorld.addVehicle(this.vehicle);
        float connectionHeight = 1.2f;
        boolean isFrontWheel = true;
        this.vehicle.setCoordinateSystem(this.rightIndex, this.upIndex, this.forwardIndex);
        Vector3f connectionPointCS0 = new Vector3f(1.0f - 0.3f * this.wheelWidth, connectionHeight, 2.0f - this.wheelRadius);
        this.vehicle.addWheel(connectionPointCS0, this.wheelDirectionCS0, this.wheelAxleCS, this.suspensionRestLength, this.wheelRadius, this.tuning, isFrontWheel);
        connectionPointCS0 = new Vector3f(-1.0f + 0.3f * this.wheelWidth, connectionHeight, 2.0f - this.wheelRadius);
        this.vehicle.addWheel(connectionPointCS0, this.wheelDirectionCS0, this.wheelAxleCS, this.suspensionRestLength, this.wheelRadius, this.tuning, isFrontWheel);
        connectionPointCS0 = new Vector3f(-1.0f + 0.3f * this.wheelWidth, connectionHeight, -2.0f + this.wheelRadius);
        isFrontWheel = false;
        this.vehicle.addWheel(connectionPointCS0, this.wheelDirectionCS0, this.wheelAxleCS, this.suspensionRestLength, this.wheelRadius, this.tuning, isFrontWheel);
        connectionPointCS0 = new Vector3f(1.0f - 0.3f * this.wheelWidth, connectionHeight, -2.0f + this.wheelRadius);
        this.vehicle.addWheel(connectionPointCS0, this.wheelDirectionCS0, this.wheelAxleCS, this.suspensionRestLength, this.wheelRadius, this.tuning, isFrontWheel);
        for (int i2 = 0; i2 < this.vehicle.getNumWheels(); ++i2) {
            WheelInfo wheel = this.vehicle.getWheelInfo(i2);
            wheel.suspensionStiffness = this.suspensionStiffness;
            wheel.wheelsDampingRelaxation = this.suspensionDamping;
            wheel.wheelsDampingCompression = this.suspensionCompression;
            wheel.frictionSlip = this.wheelFriction;
            wheel.rollInfluence = this.rollInfluence;
        }
        this.setCameraDistance(26.0f);
    }

    public static void main(String[] args) throws LWJGLException {
        ForkLiftDemo forkLiftDemo = new ForkLiftDemo(LWJGL.getGL());
        forkLiftDemo.initPhysics();
        forkLiftDemo.getDynamicsWorld().setDebugDrawer(new GLDebugDrawer(LWJGL.getGL()));
        LWJGL.main(args, 800, 600, "Bullet ForkLift Demo", forkLiftDemo);
    }
}

