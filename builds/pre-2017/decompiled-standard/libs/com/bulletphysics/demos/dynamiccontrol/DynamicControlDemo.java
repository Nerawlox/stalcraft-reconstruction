/*
 * Decompiled with CFR 0.152.
 */
package com.bulletphysics.demos.dynamiccontrol;

import com.bulletphysics.collision.broadphase.DbvtBroadphase;
import com.bulletphysics.collision.dispatch.CollisionDispatcher;
import com.bulletphysics.collision.dispatch.CollisionObject;
import com.bulletphysics.collision.dispatch.DefaultCollisionConfiguration;
import com.bulletphysics.collision.shapes.BoxShape;
import com.bulletphysics.demos.dynamiccontrol.TestRig;
import com.bulletphysics.demos.opengl.DemoApplication;
import com.bulletphysics.demos.opengl.IGL;
import com.bulletphysics.demos.opengl.LWJGL;
import com.bulletphysics.dynamics.DiscreteDynamicsWorld;
import com.bulletphysics.dynamics.RigidBody;
import com.bulletphysics.dynamics.constraintsolver.HingeConstraint;
import com.bulletphysics.dynamics.constraintsolver.SequentialImpulseConstraintSolver;
import com.bulletphysics.linearmath.Transform;
import com.bulletphysics.util.ObjectArrayList;
import javax.vecmath.Vector3f;
import org.lwjgl.LWJGLException;

public class DynamicControlDemo
extends DemoApplication {
    private float time;
    private float cyclePeriod;
    private float muscleStrength;
    private ObjectArrayList<TestRig> rigs = new ObjectArrayList();

    public DynamicControlDemo(IGL gl) {
        super(gl);
    }

    @Override
    public void initPhysics() {
        this.time = 0.0f;
        this.cyclePeriod = 2000.0f;
        this.muscleStrength = 0.05f;
        this.setCameraDistance(5.0f);
        DefaultCollisionConfiguration collision_config = new DefaultCollisionConfiguration();
        CollisionDispatcher dispatcher = new CollisionDispatcher(collision_config);
        Vector3f worldAabbMin = new Vector3f(-10000.0f, -10000.0f, -10000.0f);
        Vector3f worldAabbMax = new Vector3f(10000.0f, 10000.0f, 10000.0f);
        DbvtBroadphase overlappingPairCache = new DbvtBroadphase();
        SequentialImpulseConstraintSolver constraintSolver = new SequentialImpulseConstraintSolver();
        this.dynamicsWorld = new DiscreteDynamicsWorld(dispatcher, overlappingPairCache, constraintSolver, collision_config);
        BoxShape groundShape = new BoxShape(new Vector3f(200.0f, 10.0f, 200.0f));
        Transform groundTransform = new Transform();
        groundTransform.setIdentity();
        groundTransform.origin.set(0.0f, -10.0f, 0.0f);
        this.localCreateRigidBody(0.0f, groundTransform, groundShape);
        Vector3f startOffset = new Vector3f(1.0f, 0.5f, 0.0f);
        this.spawnTestRig(startOffset, false);
        startOffset.set(-2.0f, 0.5f, 0.0f);
        this.spawnTestRig(startOffset, true);
        this.clientResetScene();
    }

    public void spawnTestRig(Vector3f startOffset, boolean fixed) {
        TestRig rig = new TestRig(this.dynamicsWorld, startOffset, fixed);
        this.rigs.add(rig);
    }

    @Override
    public void clientMoveAndDisplay() {
        this.gl.glClear(16640);
        float ms = this.getDeltaTimeMicroseconds();
        float minFPS = 16666.666f;
        if (ms > minFPS) {
            ms = minFPS;
        }
        this.time += ms;
        for (int r = 0; r < this.rigs.size(); ++r) {
            for (int i = 0; i < 12; ++i) {
                HingeConstraint hingeC = (HingeConstraint)this.rigs.getQuick(r).getJoints()[i];
                float curAngle = hingeC.getHingeAngle();
                float targetPercent = (float)((int)(this.time / 1000.0f) % (int)this.cyclePeriod) / this.cyclePeriod;
                float targetAngle = 0.5f * (1.0f + (float)Math.sin((float)Math.PI * 2 * targetPercent));
                float targetLimitAngle = hingeC.getLowerLimit() + targetAngle * (hingeC.getUpperLimit() - hingeC.getLowerLimit());
                float angleError = targetLimitAngle - curAngle;
                float desiredAngularVel = 1000000.0f * angleError / ms;
                hingeC.enableAngularMotor(true, desiredAngularVel, this.muscleStrength);
            }
        }
        if (this.dynamicsWorld != null) {
            this.dynamicsWorld.stepSimulation(ms / 1000000.0f);
            this.dynamicsWorld.debugDrawWorld();
        }
        for (int i = 2; i >= 0; --i) {
            CollisionObject obj = this.dynamicsWorld.getCollisionObjectArray().getQuick(i);
            RigidBody body = RigidBody.upcast(obj);
            this.drawFrame(body.getWorldTransform(new Transform()));
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
            case '+': 
            case '=': {
                this.cyclePeriod /= 1.1f;
                if (!(this.cyclePeriod < 1.0f)) break;
                this.cyclePeriod = 1.0f;
                break;
            }
            case '-': 
            case '_': {
                this.cyclePeriod *= 1.1f;
                break;
            }
            case '[': {
                this.muscleStrength /= 1.1f;
                break;
            }
            case ']': {
                this.muscleStrength *= 1.1f;
                break;
            }
            default: {
                super.keyboardCallback(key, x, y, modifiers);
            }
        }
    }

    private void vertex(Vector3f v) {
        this.gl.glVertex3f(v.x, v.y, v.z);
    }

    private void drawFrame(Transform tr) {
        float size = 1.0f;
        this.gl.glBegin(1);
        this.gl.glColor3f(255.0f, 0.0f, 0.0f);
        Vector3f vX = new Vector3f();
        vX.set(1.0f, 0.0f, 0.0f);
        tr.transform(vX);
        this.vertex(tr.origin);
        this.vertex(vX);
        this.gl.glColor3f(0.0f, 255.0f, 0.0f);
        Vector3f vY = new Vector3f();
        vY.set(0.0f, 1.0f, 0.0f);
        tr.transform(vY);
        this.vertex(tr.origin);
        this.vertex(vY);
        this.gl.glColor3f(0.0f, 0.0f, 255.0f);
        Vector3f vZ = new Vector3f();
        vZ.set(0.0f, 0.0f, 1.0f);
        tr.transform(vZ);
        this.vertex(tr.origin);
        this.vertex(vZ);
        this.gl.glEnd();
    }

    public static void main(String[] args) throws LWJGLException {
        DynamicControlDemo demoApp = new DynamicControlDemo(LWJGL.getGL());
        demoApp.initPhysics();
        LWJGL.main(args, 800, 600, "Bullet Physics Demo. http://bullet.sf.net", demoApp);
    }
}

