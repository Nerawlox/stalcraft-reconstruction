/*
 * Decompiled with CFR 0.152.
 */
package com.bulletphysics.demos.opengl;

import com.bulletphysics.BulletGlobals;
import com.bulletphysics.BulletStats;
import com.bulletphysics.collision.dispatch.CollisionObject;
import com.bulletphysics.collision.dispatch.CollisionWorld;
import com.bulletphysics.collision.shapes.BoxShape;
import com.bulletphysics.collision.shapes.CollisionShape;
import com.bulletphysics.demos.opengl.FastFormat;
import com.bulletphysics.demos.opengl.GLShapeDrawer;
import com.bulletphysics.demos.opengl.IGL;
import com.bulletphysics.dynamics.DynamicsWorld;
import com.bulletphysics.dynamics.RigidBody;
import com.bulletphysics.dynamics.RigidBodyConstructionInfo;
import com.bulletphysics.dynamics.constraintsolver.Point2PointConstraint;
import com.bulletphysics.dynamics.constraintsolver.TypedConstraint;
import com.bulletphysics.linearmath.CProfileIterator;
import com.bulletphysics.linearmath.CProfileManager;
import com.bulletphysics.linearmath.Clock;
import com.bulletphysics.linearmath.DefaultMotionState;
import com.bulletphysics.linearmath.QuaternionUtil;
import com.bulletphysics.linearmath.Transform;
import com.bulletphysics.linearmath.VectorUtil;
import javax.vecmath.Color3f;
import javax.vecmath.Matrix3f;
import javax.vecmath.Quat4f;
import javax.vecmath.Vector3f;

public abstract class DemoApplication {
    private static final float STEPSIZE = 5.0f;
    public static int numObjects = 0;
    public static final int maxNumObjects = 16384;
    public static Transform[] startTransforms = new Transform[16384];
    public static CollisionShape[] gShapePtr = new CollisionShape[16384];
    public static RigidBody pickedBody = null;
    private static float mousePickClamping = 3.0f;
    protected IGL gl;
    protected Clock clock = new Clock();
    protected DynamicsWorld dynamicsWorld = null;
    protected TypedConstraint pickConstraint = null;
    protected CollisionShape shootBoxShape = null;
    protected float cameraDistance = 15.0f;
    protected int debugMode = 0;
    protected float ele = 20.0f;
    protected float azi = 0.0f;
    protected final Vector3f cameraPosition = new Vector3f(0.0f, 0.0f, 0.0f);
    protected final Vector3f cameraTargetPosition = new Vector3f(0.0f, 0.0f, 0.0f);
    protected float scaleBottom = 0.5f;
    protected float scaleFactor = 2.0f;
    protected final Vector3f cameraUp = new Vector3f(0.0f, 1.0f, 0.0f);
    protected int forwardAxis = 2;
    protected int glutScreenWidth = 0;
    protected int glutScreenHeight = 0;
    protected float ShootBoxInitialSpeed = 40.0f;
    protected boolean stepping = true;
    protected boolean singleStep = false;
    protected boolean idle = false;
    protected int lastKey;
    private CProfileIterator profileIterator;
    private static double time_since_reset;
    private final Transform m = new Transform();
    private Vector3f wireColor = new Vector3f();
    protected Color3f TEXT_COLOR = new Color3f(0.0f, 0.0f, 0.0f);
    private StringBuilder buf = new StringBuilder();

    public DemoApplication(IGL gl) {
        this.gl = gl;
        BulletStats.setProfileEnabled(true);
        this.profileIterator = CProfileManager.getIterator();
    }

    public abstract void initPhysics() throws Exception;

    public void destroy() {
    }

    public void myinit() {
        float[] light_ambient = new float[]{0.2f, 0.2f, 0.2f, 1.0f};
        float[] light_diffuse = new float[]{1.0f, 1.0f, 1.0f, 1.0f};
        float[] light_specular = new float[]{1.0f, 1.0f, 1.0f, 1.0f};
        float[] light_position0 = new float[]{1.0f, 10.0f, 1.0f, 0.0f};
        float[] light_position1 = new float[]{-1.0f, -10.0f, -1.0f, 0.0f};
        this.gl.glLight(16384, 4608, light_ambient);
        this.gl.glLight(16384, 4609, light_diffuse);
        this.gl.glLight(16384, 4610, light_specular);
        this.gl.glLight(16384, 4611, light_position0);
        this.gl.glLight(16385, 4608, light_ambient);
        this.gl.glLight(16385, 4609, light_diffuse);
        this.gl.glLight(16385, 4610, light_specular);
        this.gl.glLight(16385, 4611, light_position1);
        this.gl.glEnable(2896);
        this.gl.glEnable(16384);
        this.gl.glEnable(16385);
        this.gl.glShadeModel(7425);
        this.gl.glEnable(2929);
        this.gl.glDepthFunc(513);
        this.gl.glClearColor(0.7f, 0.7f, 0.7f, 0.0f);
    }

    public void setCameraDistance(float dist) {
        this.cameraDistance = dist;
    }

    public float getCameraDistance() {
        return this.cameraDistance;
    }

    public void toggleIdle() {
        this.idle = !this.idle;
    }

    public void updateCamera() {
        this.gl.glMatrixMode(5889);
        this.gl.glLoadIdentity();
        float rele = this.ele * ((float)Math.PI / 180);
        float razi = this.azi * ((float)Math.PI / 180);
        Quat4f rot = new Quat4f();
        QuaternionUtil.setRotation(rot, this.cameraUp, razi);
        Vector3f eyePos = new Vector3f();
        eyePos.set(0.0f, 0.0f, 0.0f);
        VectorUtil.setCoord(eyePos, this.forwardAxis, -this.cameraDistance);
        Vector3f forward = new Vector3f();
        forward.set(eyePos.x, eyePos.y, eyePos.z);
        if (forward.lengthSquared() < 1.1920929E-7f) {
            forward.set(1.0f, 0.0f, 0.0f);
        }
        Vector3f right = new Vector3f();
        right.cross(this.cameraUp, forward);
        Quat4f roll = new Quat4f();
        QuaternionUtil.setRotation(roll, right, -rele);
        Matrix3f tmpMat1 = new Matrix3f();
        Matrix3f tmpMat2 = new Matrix3f();
        tmpMat1.set(rot);
        tmpMat2.set(roll);
        tmpMat1.mul(tmpMat2);
        tmpMat1.transform(eyePos);
        this.cameraPosition.set(eyePos);
        if (this.glutScreenWidth > this.glutScreenHeight) {
            float aspect = (float)this.glutScreenWidth / (float)this.glutScreenHeight;
            this.gl.glFrustum(-aspect, aspect, -1.0, 1.0, 1.0, 10000.0);
        } else {
            float aspect = (float)this.glutScreenHeight / (float)this.glutScreenWidth;
            this.gl.glFrustum(-1.0, 1.0, -aspect, aspect, 1.0, 10000.0);
        }
        this.gl.glMatrixMode(5888);
        this.gl.glLoadIdentity();
        this.gl.gluLookAt(this.cameraPosition.x, this.cameraPosition.y, this.cameraPosition.z, this.cameraTargetPosition.x, this.cameraTargetPosition.y, this.cameraTargetPosition.z, this.cameraUp.x, this.cameraUp.y, this.cameraUp.z);
    }

    public void stepLeft() {
        this.azi -= 5.0f;
        if (this.azi < 0.0f) {
            this.azi += 360.0f;
        }
        this.updateCamera();
    }

    public void stepRight() {
        this.azi += 5.0f;
        if (this.azi >= 360.0f) {
            this.azi -= 360.0f;
        }
        this.updateCamera();
    }

    public void stepFront() {
        this.ele += 5.0f;
        if (this.ele >= 360.0f) {
            this.ele -= 360.0f;
        }
        this.updateCamera();
    }

    public void stepBack() {
        this.ele -= 5.0f;
        if (this.ele < 0.0f) {
            this.ele += 360.0f;
        }
        this.updateCamera();
    }

    public void zoomIn() {
        this.cameraDistance -= 0.4f;
        this.updateCamera();
        if (this.cameraDistance < 0.1f) {
            this.cameraDistance = 0.1f;
        }
    }

    public void zoomOut() {
        this.cameraDistance += 0.4f;
        this.updateCamera();
    }

    public void reshape(int w, int h) {
        this.glutScreenWidth = w;
        this.glutScreenHeight = h;
        this.gl.glViewport(0, 0, w, h);
        this.updateCamera();
    }

    public void keyboardCallback(char key, int x, int y, int modifiers) {
        this.lastKey = 0;
        if (key >= '1' && key < '7') {
            int child = key - 49;
            this.profileIterator.enterChild(child);
        }
        if (key == '0') {
            this.profileIterator.enterParent();
        }
        switch (key) {
            case 'l': {
                this.stepLeft();
                break;
            }
            case 'r': {
                this.stepRight();
                break;
            }
            case 'f': {
                this.stepFront();
                break;
            }
            case 'b': {
                this.stepBack();
                break;
            }
            case 'z': {
                this.zoomIn();
                break;
            }
            case 'x': {
                this.zoomOut();
                break;
            }
            case 'i': {
                this.toggleIdle();
                break;
            }
            case 'h': {
                if ((this.debugMode & 0x20) != 0) {
                    this.debugMode &= 0xFFFFFFDF;
                    break;
                }
                this.debugMode |= 0x20;
                break;
            }
            case 'w': {
                if ((this.debugMode & 1) != 0) {
                    this.debugMode &= 0xFFFFFFFE;
                    break;
                }
                this.debugMode |= 1;
                break;
            }
            case 'p': {
                if ((this.debugMode & 0x80) != 0) {
                    this.debugMode &= 0xFFFFFF7F;
                    break;
                }
                this.debugMode |= 0x80;
                break;
            }
            case 'm': {
                if ((this.debugMode & 0x100) != 0) {
                    this.debugMode &= 0xFFFFFEFF;
                    break;
                }
                this.debugMode |= 0x100;
                break;
            }
            case 'n': {
                if ((this.debugMode & 0x200) != 0) {
                    this.debugMode &= 0xFFFFFDFF;
                    break;
                }
                this.debugMode |= 0x200;
                break;
            }
            case 't': {
                if ((this.debugMode & 0x40) != 0) {
                    this.debugMode &= 0xFFFFFFBF;
                    break;
                }
                this.debugMode |= 0x40;
                break;
            }
            case 'y': {
                if ((this.debugMode & 4) != 0) {
                    this.debugMode &= 0xFFFFFFFB;
                    break;
                }
                this.debugMode |= 4;
                break;
            }
            case 'a': {
                if ((this.debugMode & 2) != 0) {
                    this.debugMode &= 0xFFFFFFFD;
                    break;
                }
                this.debugMode |= 2;
                break;
            }
            case 'c': {
                if ((this.debugMode & 8) != 0) {
                    this.debugMode &= 0xFFFFFFF7;
                    break;
                }
                this.debugMode |= 8;
                break;
            }
            case 'd': {
                this.debugMode = (this.debugMode & 0x10) != 0 ? (this.debugMode &= 0xFFFFFFEF) : (this.debugMode |= 0x10);
                if ((this.debugMode & 0x10) != 0) {
                    BulletGlobals.setDeactivationDisabled(true);
                    break;
                }
                BulletGlobals.setDeactivationDisabled(false);
                break;
            }
            case 'o': {
                this.stepping = !this.stepping;
                break;
            }
            case 's': {
                this.clientMoveAndDisplay();
                break;
            }
            case ' ': {
                this.clientResetScene();
                break;
            }
            case '1': {
                if ((this.debugMode & 0x400) != 0) {
                    this.debugMode &= 0xFFFFFBFF;
                    break;
                }
                this.debugMode |= 0x400;
                break;
            }
            case '.': {
                this.shootBox(this.getCameraTargetPosition());
                break;
            }
            case '+': {
                this.ShootBoxInitialSpeed += 10.0f;
                break;
            }
            case '-': {
                this.ShootBoxInitialSpeed -= 10.0f;
                break;
            }
        }
        if (this.getDynamicsWorld() != null && this.getDynamicsWorld().getDebugDrawer() != null) {
            this.getDynamicsWorld().getDebugDrawer().setDebugMode(this.debugMode);
        }
    }

    public int getDebugMode() {
        return this.debugMode;
    }

    public void setDebugMode(int mode) {
        this.debugMode = mode;
        if (this.getDynamicsWorld() != null && this.getDynamicsWorld().getDebugDrawer() != null) {
            this.getDynamicsWorld().getDebugDrawer().setDebugMode(mode);
        }
    }

    public void specialKeyboardUp(int key, int x, int y, int modifiers) {
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public void specialKeyboard(int key, int x, int y, int modifiers) {
        switch (key) {
            case 59: {
                return;
            }
            case 60: {
                return;
            }
            case 207: {
                int numObj = this.getDynamicsWorld().getNumCollisionObjects();
                if (numObj == 0) return;
                CollisionObject obj = this.getDynamicsWorld().getCollisionObjectArray().getQuick(numObj - 1);
                this.getDynamicsWorld().removeCollisionObject(obj);
                RigidBody body = RigidBody.upcast(obj);
                if (body != null && body.getMotionState() == null) return;
            }
            case 203: {
                this.stepLeft();
                return;
            }
            case 205: {
                this.stepRight();
                return;
            }
            case 200: {
                this.stepFront();
                return;
            }
            case 208: {
                this.stepBack();
                return;
            }
            case 201: {
                this.zoomIn();
                return;
            }
            case 209: {
                this.zoomOut();
                return;
            }
            case 199: {
                this.toggleIdle();
                return;
            }
        }
    }

    public void moveAndDisplay() {
        if (!this.idle) {
            this.clientMoveAndDisplay();
        }
    }

    public void displayCallback() {
    }

    public void shootBox(Vector3f destination) {
        if (this.dynamicsWorld != null) {
            float mass = 10.0f;
            Transform startTransform = new Transform();
            startTransform.setIdentity();
            Vector3f camPos = new Vector3f(this.getCameraPosition());
            startTransform.origin.set(camPos);
            if (this.shootBoxShape == null) {
                this.shootBoxShape = new BoxShape(new Vector3f(1.0f, 1.0f, 1.0f));
            }
            RigidBody body = this.localCreateRigidBody(mass, startTransform, this.shootBoxShape);
            Vector3f linVel = new Vector3f(destination.x - camPos.x, destination.y - camPos.y, destination.z - camPos.z);
            linVel.normalize();
            linVel.scale(this.ShootBoxInitialSpeed);
            Transform worldTrans = body.getWorldTransform(new Transform());
            worldTrans.origin.set(camPos);
            worldTrans.setRotation(new Quat4f(0.0f, 0.0f, 0.0f, 1.0f));
            body.setWorldTransform(worldTrans);
            body.setLinearVelocity(linVel);
            body.setAngularVelocity(new Vector3f(0.0f, 0.0f, 0.0f));
            body.setCcdMotionThreshold(1.0f);
            body.setCcdSweptSphereRadius(0.2f);
        }
    }

    public Vector3f getRayTo(int x, int y) {
        float top = 1.0f;
        float bottom = -1.0f;
        float nearPlane = 1.0f;
        float tanFov = (top - bottom) * 0.5f / nearPlane;
        float fov = 2.0f * (float)Math.atan(tanFov);
        Vector3f rayFrom = new Vector3f(this.getCameraPosition());
        Vector3f rayForward = new Vector3f();
        rayForward.sub(this.getCameraTargetPosition(), this.getCameraPosition());
        rayForward.normalize();
        float farPlane = 10000.0f;
        rayForward.scale(farPlane);
        Vector3f rightOffset = new Vector3f();
        Vector3f vertical = new Vector3f(this.cameraUp);
        Vector3f hor = new Vector3f();
        hor.cross(rayForward, vertical);
        hor.normalize();
        vertical.cross(hor, rayForward);
        vertical.normalize();
        float tanfov = (float)Math.tan(0.5f * fov);
        float aspect = (float)this.glutScreenHeight / (float)this.glutScreenWidth;
        hor.scale(2.0f * farPlane * tanfov);
        vertical.scale(2.0f * farPlane * tanfov);
        if (aspect < 1.0f) {
            hor.scale(1.0f / aspect);
        } else {
            vertical.scale(aspect);
        }
        Vector3f rayToCenter = new Vector3f();
        rayToCenter.add(rayFrom, rayForward);
        Vector3f dHor = new Vector3f(hor);
        dHor.scale(1.0f / (float)this.glutScreenWidth);
        Vector3f dVert = new Vector3f(vertical);
        dVert.scale(1.0f / (float)this.glutScreenHeight);
        Vector3f tmp1 = new Vector3f();
        Vector3f tmp2 = new Vector3f();
        tmp1.scale(0.5f, hor);
        tmp2.scale(0.5f, vertical);
        Vector3f rayTo = new Vector3f();
        rayTo.sub(rayToCenter, tmp1);
        rayTo.add(tmp2);
        tmp1.scale(x, dHor);
        tmp2.scale(y, dVert);
        rayTo.add(tmp1);
        rayTo.sub(tmp2);
        return rayTo;
    }

    public void mouseFunc(int button, int state, int x, int y) {
        Vector3f rayTo = new Vector3f(this.getRayTo(x, y));
        switch (button) {
            case 2: {
                if (state != 0) break;
                this.shootBox(rayTo);
                break;
            }
            case 1: {
                RigidBody body;
                if (state != 0 || this.dynamicsWorld == null) break;
                CollisionWorld.ClosestRayResultCallback rayCallback = new CollisionWorld.ClosestRayResultCallback(this.cameraPosition, rayTo);
                this.dynamicsWorld.rayTest(this.cameraPosition, rayTo, rayCallback);
                if (!rayCallback.hasHit() || (body = RigidBody.upcast(rayCallback.collisionObject)) == null) break;
                body.setActivationState(1);
                Vector3f impulse = new Vector3f(rayTo);
                impulse.normalize();
                float impulseStrength = 10.0f;
                impulse.scale(impulseStrength);
                Vector3f relPos = new Vector3f();
                relPos.sub(rayCallback.hitPointWorld, body.getCenterOfMassPosition(new Vector3f()));
                body.applyImpulse(impulse, relPos);
                break;
            }
            case 0: {
                if (state == 0) {
                    RigidBody body;
                    if (this.dynamicsWorld == null) break;
                    CollisionWorld.ClosestRayResultCallback rayCallback = new CollisionWorld.ClosestRayResultCallback(this.cameraPosition, rayTo);
                    this.dynamicsWorld.rayTest(this.cameraPosition, rayTo, rayCallback);
                    if (!rayCallback.hasHit() || (body = RigidBody.upcast(rayCallback.collisionObject)) == null || body.isStaticObject() || body.isKinematicObject()) break;
                    pickedBody = body;
                    pickedBody.setActivationState(4);
                    Vector3f pickPos = new Vector3f(rayCallback.hitPointWorld);
                    Transform tmpTrans = body.getCenterOfMassTransform(new Transform());
                    tmpTrans.inverse();
                    Vector3f localPivot = new Vector3f(pickPos);
                    tmpTrans.transform(localPivot);
                    Point2PointConstraint p2p = new Point2PointConstraint(body, localPivot);
                    p2p.setting.impulseClamp = mousePickClamping;
                    this.dynamicsWorld.addConstraint(p2p);
                    this.pickConstraint = p2p;
                    BulletStats.gOldPickingPos.set(rayTo);
                    Vector3f eyePos = new Vector3f(this.cameraPosition);
                    Vector3f tmp = new Vector3f();
                    tmp.sub(pickPos, eyePos);
                    BulletStats.gOldPickingDist = tmp.length();
                    p2p.setting.tau = 0.1f;
                    break;
                }
                if (this.pickConstraint == null || this.dynamicsWorld == null) break;
                this.dynamicsWorld.removeConstraint(this.pickConstraint);
                this.pickConstraint = null;
                pickedBody.forceActivationState(1);
                pickedBody.setDeactivationTime(0.0f);
                pickedBody = null;
                break;
            }
        }
    }

    public void mouseMotionFunc(int x, int y) {
        Point2PointConstraint p2p;
        if (this.pickConstraint != null && (p2p = (Point2PointConstraint)this.pickConstraint) != null) {
            Vector3f newRayTo = new Vector3f(this.getRayTo(x, y));
            Vector3f eyePos = new Vector3f(this.cameraPosition);
            Vector3f dir = new Vector3f();
            dir.sub(newRayTo, eyePos);
            dir.normalize();
            dir.scale(BulletStats.gOldPickingDist);
            Vector3f newPos = new Vector3f();
            newPos.add(eyePos, dir);
            p2p.setPivotB(newPos);
        }
    }

    public RigidBody localCreateRigidBody(float mass, Transform startTransform, CollisionShape shape) {
        boolean isDynamic = mass != 0.0f;
        Vector3f localInertia = new Vector3f(0.0f, 0.0f, 0.0f);
        if (isDynamic) {
            shape.calculateLocalInertia(mass, localInertia);
        }
        DefaultMotionState myMotionState = new DefaultMotionState(startTransform);
        RigidBodyConstructionInfo cInfo = new RigidBodyConstructionInfo(mass, myMotionState, shape, localInertia);
        RigidBody body = new RigidBody(cInfo);
        this.dynamicsWorld.addRigidBody(body);
        return body;
    }

    public void setOrthographicProjection() {
        this.gl.glMatrixMode(5889);
        this.gl.glPushMatrix();
        this.gl.glLoadIdentity();
        this.gl.gluOrtho2D(0.0f, this.glutScreenWidth, 0.0f, this.glutScreenHeight);
        this.gl.glMatrixMode(5888);
        this.gl.glLoadIdentity();
        this.gl.glScalef(1.0f, -1.0f, 1.0f);
        this.gl.glTranslatef(0.0f, -this.glutScreenHeight, 0.0f);
    }

    public void resetPerspectiveProjection() {
        this.gl.glMatrixMode(5889);
        this.gl.glPopMatrix();
        this.gl.glMatrixMode(5888);
        this.updateCamera();
    }

    private void displayProfileString(float xOffset, float yStart, CharSequence message) {
        this.drawString(message, Math.round(xOffset), Math.round(yStart), this.TEXT_COLOR);
    }

    protected float showProfileInfo(float xOffset, float yStart, float yIncr) {
        if (!this.idle) {
            time_since_reset = CProfileManager.getTimeSinceReset();
        }
        double totalTime = 0.0;
        int frames_since_reset = CProfileManager.getFrameCountSinceReset();
        this.profileIterator.first();
        double parent_time = this.profileIterator.isRoot() ? time_since_reset : (double)this.profileIterator.getCurrentParentTotalTime();
        this.buf.setLength(0);
        this.buf.append("--- Profiling: ");
        this.buf.append(this.profileIterator.getCurrentParentName());
        this.buf.append(" (total running time: ");
        FastFormat.append(this.buf, (float)parent_time, 3);
        this.buf.append(" ms) ---");
        this.displayProfileString(xOffset, yStart, this.buf);
        String s = "press number (1,2...) to display child timings, or 0 to go up to parent";
        this.displayProfileString(xOffset, yStart += yIncr, s);
        yStart += yIncr;
        double accumulated_time = 0.0;
        int i = 0;
        while (!this.profileIterator.isDone()) {
            double current_total_time = this.profileIterator.getCurrentTotalTime();
            accumulated_time += current_total_time;
            double fraction = parent_time > 1.1920928955078125E-7 ? current_total_time / parent_time * 100.0 : 0.0;
            this.buf.setLength(0);
            FastFormat.append(this.buf, ++i);
            this.buf.append(" -- ");
            this.buf.append(this.profileIterator.getCurrentName());
            this.buf.append(" (");
            FastFormat.append(this.buf, (float)fraction, 2);
            this.buf.append(" %) :: ");
            FastFormat.append(this.buf, (float)(current_total_time / (double)frames_since_reset), 3);
            this.buf.append(" ms / frame (");
            FastFormat.append(this.buf, this.profileIterator.getCurrentTotalCalls());
            this.buf.append(" calls)");
            this.displayProfileString(xOffset, yStart, this.buf);
            yStart += yIncr;
            totalTime += current_total_time;
            this.profileIterator.next();
        }
        this.buf.setLength(0);
        this.buf.append("Unaccounted (");
        FastFormat.append(this.buf, (float)(parent_time > 1.1920928955078125E-7 ? (parent_time - accumulated_time) / parent_time * 100.0 : 0.0), 3);
        this.buf.append(" %) :: ");
        FastFormat.append(this.buf, (float)(parent_time - accumulated_time), 3);
        this.buf.append(" ms");
        this.displayProfileString(xOffset, yStart, this.buf);
        String s2 = "-------------------------------------------------";
        this.displayProfileString(xOffset, yStart += yIncr, s2);
        return yStart += yIncr;
    }

    public void renderme() {
        this.updateCamera();
        if (this.dynamicsWorld != null) {
            int numObjects = this.dynamicsWorld.getNumCollisionObjects();
            this.wireColor.set(1.0f, 0.0f, 0.0f);
            for (int i = 0; i < numObjects; ++i) {
                CollisionObject colObj = this.dynamicsWorld.getCollisionObjectArray().getQuick(i);
                RigidBody body = RigidBody.upcast(colObj);
                if (body != null && body.getMotionState() != null) {
                    DefaultMotionState myMotionState = (DefaultMotionState)body.getMotionState();
                    this.m.set(myMotionState.graphicsWorldTrans);
                } else {
                    colObj.getWorldTransform(this.m);
                }
                this.wireColor.set(1.0f, 1.0f, 0.5f);
                if ((i & 1) != 0) {
                    this.wireColor.set(0.0f, 0.0f, 1.0f);
                }
                if (colObj.getActivationState() == 1) {
                    this.wireColor.x = (i & 1) != 0 ? (this.wireColor.x += 1.0f) : (this.wireColor.x += 0.5f);
                }
                if (colObj.getActivationState() == 2) {
                    this.wireColor.y = (i & 1) != 0 ? (this.wireColor.y += 1.0f) : (this.wireColor.y += 0.5f);
                }
                GLShapeDrawer.drawOpenGL(this.gl, this.m, colObj.getCollisionShape(), this.wireColor, this.getDebugMode());
            }
            float xOffset = 10.0f;
            float yStart = 20.0f;
            float yIncr = 20.0f;
            this.gl.glDisable(2896);
            this.gl.glColor3f(0.0f, 0.0f, 0.0f);
            if ((this.debugMode & 0x20) == 0) {
                this.setOrthographicProjection();
                yStart = this.showProfileInfo(xOffset, yStart, yIncr);
                String s = "mouse to interact";
                this.drawString(s, Math.round(xOffset), Math.round(yStart), this.TEXT_COLOR);
                s = "LMB=drag, RMB=shoot box, MIDDLE=apply impulse";
                this.drawString(s, Math.round(xOffset), Math.round(yStart += yIncr), this.TEXT_COLOR);
                s = "space to reset";
                this.drawString(s, Math.round(xOffset), Math.round(yStart += yIncr), this.TEXT_COLOR);
                s = "cursor keys and z,x to navigate";
                this.drawString(s, Math.round(xOffset), Math.round(yStart += yIncr), this.TEXT_COLOR);
                s = "i to toggle simulation, s single step";
                this.drawString(s, Math.round(xOffset), Math.round(yStart += yIncr), this.TEXT_COLOR);
                s = "q to quit";
                this.drawString(s, Math.round(xOffset), Math.round(yStart += yIncr), this.TEXT_COLOR);
                s = ". to shoot box or trimesh (MovingConcaveDemo)";
                this.drawString(s, Math.round(xOffset), Math.round(yStart += yIncr), this.TEXT_COLOR);
                s = "d to toggle deactivation";
                this.drawString(s, Math.round(xOffset), Math.round(yStart += yIncr), this.TEXT_COLOR);
                s = "g to toggle mesh animation (ConcaveDemo)";
                this.drawString(s, Math.round(xOffset), Math.round(yStart += yIncr), this.TEXT_COLOR);
                s = "e to spawn new body (GenericJointDemo)";
                this.drawString(s, Math.round(xOffset), Math.round(yStart += yIncr), this.TEXT_COLOR);
                s = "h to toggle help text";
                this.drawString(s, Math.round(xOffset), Math.round(yStart += yIncr), this.TEXT_COLOR);
                yStart += yIncr;
                this.buf.setLength(0);
                this.buf.append("+- shooting speed = ");
                FastFormat.append(this.buf, this.ShootBoxInitialSpeed);
                this.drawString(this.buf, Math.round(xOffset), Math.round(yStart += yIncr), this.TEXT_COLOR);
                this.buf.setLength(0);
                this.buf.append("gNumDeepPenetrationChecks = ");
                FastFormat.append(this.buf, BulletStats.gNumDeepPenetrationChecks);
                this.drawString(this.buf, Math.round(xOffset), Math.round(yStart += yIncr), this.TEXT_COLOR);
                this.buf.setLength(0);
                this.buf.append("gNumGjkChecks = ");
                FastFormat.append(this.buf, BulletStats.gNumGjkChecks);
                this.drawString(this.buf, Math.round(xOffset), Math.round(yStart += yIncr), this.TEXT_COLOR);
                this.buf.setLength(0);
                this.buf.append("gNumSplitImpulseRecoveries = ");
                FastFormat.append(this.buf, BulletStats.gNumSplitImpulseRecoveries);
                this.drawString(this.buf, Math.round(xOffset), Math.round(yStart += yIncr), this.TEXT_COLOR);
                yStart += yIncr;
                if (this.getDynamicsWorld() != null) {
                    this.buf.setLength(0);
                    this.buf.append("# objects = ");
                    FastFormat.append(this.buf, this.getDynamicsWorld().getNumCollisionObjects());
                    this.drawString(this.buf, Math.round(xOffset), Math.round(yStart), this.TEXT_COLOR);
                    this.buf.setLength(0);
                    this.buf.append("# pairs = ");
                    FastFormat.append(this.buf, this.getDynamicsWorld().getBroadphase().getOverlappingPairCache().getNumOverlappingPairs());
                    this.drawString(this.buf, Math.round(xOffset), Math.round(yStart += yIncr), this.TEXT_COLOR);
                    yStart += yIncr;
                }
                int free = (int)Runtime.getRuntime().freeMemory();
                int total = (int)Runtime.getRuntime().totalMemory();
                this.buf.setLength(0);
                this.buf.append("heap = ");
                FastFormat.append(this.buf, (float)(total - free) / 1048576.0f);
                this.buf.append(" / ");
                FastFormat.append(this.buf, (float)total / 1048576.0f);
                this.buf.append(" MB");
                this.drawString(this.buf, Math.round(xOffset), Math.round(yStart), this.TEXT_COLOR);
                yStart += yIncr;
                this.resetPerspectiveProjection();
            }
            this.gl.glEnable(2896);
        }
        this.updateCamera();
    }

    public void clientResetScene() {
        BulletStats.gNumDeepPenetrationChecks = 0;
        BulletStats.gNumGjkChecks = 0;
        int numObjects = 0;
        if (this.dynamicsWorld != null) {
            this.dynamicsWorld.stepSimulation(0.016666668f, 0);
            numObjects = this.dynamicsWorld.getNumCollisionObjects();
        }
        for (int i = 0; i < numObjects; ++i) {
            CollisionObject colObj = this.dynamicsWorld.getCollisionObjectArray().getQuick(i);
            RigidBody body = RigidBody.upcast(colObj);
            if (body == null) continue;
            if (body.getMotionState() != null) {
                DefaultMotionState myMotionState = (DefaultMotionState)body.getMotionState();
                myMotionState.graphicsWorldTrans.set(myMotionState.startWorldTrans);
                colObj.setWorldTransform(myMotionState.graphicsWorldTrans);
                colObj.setInterpolationWorldTransform(myMotionState.startWorldTrans);
                colObj.activate();
            }
            this.dynamicsWorld.getBroadphase().getOverlappingPairCache().cleanProxyFromPairs(colObj.getBroadphaseHandle(), this.getDynamicsWorld().getDispatcher());
            body = RigidBody.upcast(colObj);
            if (body == null || body.isStaticObject()) continue;
            RigidBody.upcast(colObj).setLinearVelocity(new Vector3f(0.0f, 0.0f, 0.0f));
            RigidBody.upcast(colObj).setAngularVelocity(new Vector3f(0.0f, 0.0f, 0.0f));
        }
    }

    public DynamicsWorld getDynamicsWorld() {
        return this.dynamicsWorld;
    }

    public void setCameraUp(Vector3f camUp) {
        this.cameraUp.set(camUp);
    }

    public void setCameraForwardAxis(int axis) {
        this.forwardAxis = axis;
    }

    public Vector3f getCameraPosition() {
        return this.cameraPosition;
    }

    public Vector3f getCameraTargetPosition() {
        return this.cameraTargetPosition;
    }

    public float getDeltaTimeMicroseconds() {
        float dt = this.clock.getTimeMicroseconds();
        this.clock.reset();
        return dt;
    }

    public abstract void clientMoveAndDisplay();

    public boolean isIdle() {
        return this.idle;
    }

    public void setIdle(boolean idle) {
        this.idle = idle;
    }

    public void drawString(CharSequence s, int x, int y, Color3f color) {
        this.gl.drawString(s, x, y, color.x, color.y, color.z);
    }

    static {
        for (int i = 0; i < startTransforms.length; ++i) {
            DemoApplication.startTransforms[i] = new Transform();
        }
        time_since_reset = 0.0;
    }
}

