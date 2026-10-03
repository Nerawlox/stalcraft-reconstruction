/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.physics.ragdolls.client.ragdoll.test;

import com.bulletphysics.BulletStats;
import com.bulletphysics.collision.broadphase.DbvtBroadphase;
import com.bulletphysics.collision.dispatch.CollisionObject;
import com.bulletphysics.collision.dispatch.DefaultCollisionConfiguration;
import com.bulletphysics.collision.shapes.BoxShape;
import com.bulletphysics.demos.opengl.DemoApplication;
import com.bulletphysics.demos.opengl.FastFormat;
import com.bulletphysics.demos.opengl.GLDebugDrawer;
import com.bulletphysics.demos.opengl.IGL;
import com.bulletphysics.demos.opengl.LWJGL;
import com.bulletphysics.dynamics.DiscreteDynamicsWorld;
import com.bulletphysics.dynamics.RigidBody;
import com.bulletphysics.dynamics.constraintsolver.SequentialImpulseConstraintSolver;
import com.bulletphysics.dynamics.constraintsolver.TypedConstraint;
import com.bulletphysics.linearmath.Transform;
import com.bulletphysics.util.ObjectArrayList;
import gloomyfolken.mods.physics.core.client.world.DefaultCollisionManager;
import gloomyfolken.mods.physics.ragdolls.client.ragdoll.test.BipedRagdoll;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.Timer;
import javax.vecmath.Vector3f;
import org.lwjgl.LWJGLException;
import org.lwjgl.input.Keyboard;

public class TestPhysics
extends DemoApplication
implements ActionListener {
    private ObjectArrayList<BipedRagdoll> ragdolls = new ObjectArrayList();
    long lastStep = System.currentTimeMillis();
    private StringBuilder buf = new StringBuilder();
    public int CANCEL_DRAW = 210;

    public TestPhysics(IGL iGL) {
        super(iGL);
    }

    @Override
    public void initPhysics() {
        DefaultCollisionConfiguration defaultCollisionConfiguration = new DefaultCollisionConfiguration();
        DefaultCollisionManager defaultCollisionManager = new DefaultCollisionManager(defaultCollisionConfiguration);
        new Vector3f(-10000.0f, -10000.0f, -10000.0f);
        new Vector3f(10000.0f, 10000.0f, 10000.0f);
        DbvtBroadphase dbvtBroadphase = new DbvtBroadphase();
        SequentialImpulseConstraintSolver sequentialImpulseConstraintSolver = new SequentialImpulseConstraintSolver();
        this.dynamicsWorld = new DiscreteDynamicsWorld(defaultCollisionManager, dbvtBroadphase, sequentialImpulseConstraintSolver, defaultCollisionConfiguration);
        this.dynamicsWorld.setGravity(new Vector3f(0.0f, -30.0f, 0.0f));
        this.dynamicsWorld.setDebugDrawer(new GLDebugDrawer(this.gl));
        BoxShape boxShape = new BoxShape(new Vector3f(200.0f, 10.0f, 200.0f));
        Transform transform = new Transform();
        transform.setIdentity();
        transform.origin.set(0.0f, -15.0f, 0.0f);
        this.localCreateRigidBody(0.0f, transform, boxShape);
        this.spawnRagdoll();
        this.clientResetScene();
    }

    public void spawnRagdoll() {
        this.spawnRagdoll(false);
    }

    public void spawnRagdoll(boolean bl) {
        BipedRagdoll bipedRagdoll = new BipedRagdoll(this.dynamicsWorld, new Vector3f(new Random().nextFloat() * 60.0f, new Random().nextFloat() * 20.0f, new Random().nextFloat() * 60.0f), 5.0f);
        this.ragdolls.add(bipedRagdoll);
    }

    @Override
    public void clientMoveAndDisplay() {
        this.gl.glClear(16640);
        float f = this.getDeltaTimeMicroseconds();
        float f2 = 16666.666f;
        if (f > f2) {
            f = f2;
        }
        if (this.dynamicsWorld != null) {
            if (System.currentTimeMillis() > this.lastStep + 50L) {
                float f3 = (float)(System.currentTimeMillis() - this.lastStep) / 1000.0f;
                this.lastStep = System.currentTimeMillis();
            }
            this.dynamicsWorld.stepSimulation(111.0f, 1, 0.025000002f);
            for (int i = 0; i < this.dynamicsWorld.getNumCollisionObjects(); ++i) {
                CollisionObject collisionObject = this.dynamicsWorld.getCollisionObjectArray().getQuick(i);
                if (collisionObject.getActivationState() == 2) {
                    if (!(collisionObject.getUserPointer() instanceof Integer)) continue;
                    collisionObject.setUserPointer((Integer)collisionObject.getUserPointer() + 1);
                    if ((Integer)collisionObject.getUserPointer() <= 40) continue;
                    RigidBody rigidBody = RigidBody.upcast(collisionObject);
                    for (int j = 0; j < rigidBody.getNumConstraintRefs(); ++j) {
                        TypedConstraint typedConstraint = rigidBody.getConstraintRef(j);
                        this.dynamicsWorld.removeConstraint(typedConstraint);
                    }
                    rigidBody.setMassProps(0.0f, new Vector3f());
                    continue;
                }
                if (!(collisionObject.getUserPointer() instanceof Integer)) continue;
                collisionObject.setUserPointer(0);
            }
            if (!Keyboard.isKeyDown(this.CANCEL_DRAW)) {
                this.dynamicsWorld.debugDrawWorld();
            }
        }
        this.renderme();
    }

    @Override
    public void renderme() {
        if (!Keyboard.isKeyDown(this.CANCEL_DRAW)) {
            super.renderme();
        } else {
            float f = 10.0f;
            float f2 = 20.0f;
            float f3 = 20.0f;
            this.gl.glDisable(2896);
            this.gl.glColor3f(0.0f, 0.0f, 0.0f);
            if ((this.debugMode & 0x20) == 0) {
                this.setOrthographicProjection();
                f2 = this.showProfileInfo(f, f2, f3);
                String string = "mouse to interact";
                this.drawString(string, Math.round(f), Math.round(f2), this.TEXT_COLOR);
                string = "LMB=drag, RMB=shoot box, MIDDLE=apply impulse";
                this.drawString(string, Math.round(f), Math.round(f2 += f3), this.TEXT_COLOR);
                string = "space to reset";
                this.drawString(string, Math.round(f), Math.round(f2 += f3), this.TEXT_COLOR);
                string = "cursor keys and z,x to navigate";
                this.drawString(string, Math.round(f), Math.round(f2 += f3), this.TEXT_COLOR);
                string = "i to toggle simulation, s single step";
                this.drawString(string, Math.round(f), Math.round(f2 += f3), this.TEXT_COLOR);
                string = "q to quit";
                this.drawString(string, Math.round(f), Math.round(f2 += f3), this.TEXT_COLOR);
                string = ". to shoot box or trimesh (MovingConcaveDemo)";
                this.drawString(string, Math.round(f), Math.round(f2 += f3), this.TEXT_COLOR);
                string = "d to toggle deactivation";
                this.drawString(string, Math.round(f), Math.round(f2 += f3), this.TEXT_COLOR);
                string = "g to toggle mesh animation (ConcaveDemo)";
                this.drawString(string, Math.round(f), Math.round(f2 += f3), this.TEXT_COLOR);
                string = "e to spawn new body (GenericJointDemo)";
                this.drawString(string, Math.round(f), Math.round(f2 += f3), this.TEXT_COLOR);
                string = "h to toggle help text";
                this.drawString(string, Math.round(f), Math.round(f2 += f3), this.TEXT_COLOR);
                f2 += f3;
                this.buf.setLength(0);
                this.buf.append("+- shooting speed = ");
                FastFormat.append(this.buf, this.ShootBoxInitialSpeed);
                this.drawString(this.buf, Math.round(f), Math.round(f2 += f3), this.TEXT_COLOR);
                this.buf.setLength(0);
                this.buf.append("gNumDeepPenetrationChecks = ");
                FastFormat.append(this.buf, BulletStats.gNumDeepPenetrationChecks);
                this.drawString(this.buf, Math.round(f), Math.round(f2 += f3), this.TEXT_COLOR);
                this.buf.setLength(0);
                this.buf.append("gNumGjkChecks = ");
                FastFormat.append(this.buf, BulletStats.gNumGjkChecks);
                this.drawString(this.buf, Math.round(f), Math.round(f2 += f3), this.TEXT_COLOR);
                this.buf.setLength(0);
                this.buf.append("gNumSplitImpulseRecoveries = ");
                FastFormat.append(this.buf, BulletStats.gNumSplitImpulseRecoveries);
                this.drawString(this.buf, Math.round(f), Math.round(f2 += f3), this.TEXT_COLOR);
                f2 += f3;
                if (this.getDynamicsWorld() != null) {
                    this.buf.setLength(0);
                    this.buf.append("# objects = ");
                    FastFormat.append(this.buf, this.getDynamicsWorld().getNumCollisionObjects());
                    this.drawString(this.buf, Math.round(f), Math.round(f2), this.TEXT_COLOR);
                    this.buf.setLength(0);
                    this.buf.append("# pairs = ");
                    FastFormat.append(this.buf, this.getDynamicsWorld().getBroadphase().getOverlappingPairCache().getNumOverlappingPairs());
                    this.drawString(this.buf, Math.round(f), Math.round(f2 += f3), this.TEXT_COLOR);
                    f2 += f3;
                }
                int n = (int)Runtime.getRuntime().freeMemory();
                int n2 = (int)Runtime.getRuntime().totalMemory();
                this.buf.setLength(0);
                this.buf.append("heap = ");
                FastFormat.append(this.buf, (float)(n2 - n) / 1048576.0f);
                this.buf.append(" / ");
                FastFormat.append(this.buf, (float)n2 / 1048576.0f);
                this.buf.append(" MB");
                this.drawString(this.buf, Math.round(f), Math.round(f2), this.TEXT_COLOR);
                float f4 = f2 + f3;
                this.resetPerspectiveProjection();
            }
            this.gl.glEnable(2896);
        }
    }

    @Override
    public void displayCallback() {
        this.gl.glClear(16640);
        if (!Keyboard.isKeyDown(this.CANCEL_DRAW) && this.dynamicsWorld != null) {
            this.dynamicsWorld.debugDrawWorld();
        }
        this.renderme();
    }

    @Override
    public void keyboardCallback(char c, int n, int n2, int n3) {
        switch (c) {
            case 'e': {
                this.spawnRagdoll(true);
                break;
            }
            default: {
                super.keyboardCallback(c, n, n2, n3);
            }
        }
    }

    public static void main(String[] stringArray) throws LWJGLException {
        TestPhysics testPhysics = new TestPhysics(LWJGL.getGL());
        testPhysics.initPhysics();
        testPhysics.setCameraDistance(10.0f);
        new Timer(50, testPhysics).start();
        LWJGL.main(stringArray, 800, 600, "Joint 6DOF - Sequencial Impulse Solver", testPhysics);
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
    }
}

