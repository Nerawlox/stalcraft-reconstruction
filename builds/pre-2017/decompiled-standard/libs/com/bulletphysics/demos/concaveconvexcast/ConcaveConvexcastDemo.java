/*
 * Decompiled with CFR 0.152.
 */
package com.bulletphysics.demos.concaveconvexcast;

import com.bulletphysics.BulletStats;
import com.bulletphysics.collision.broadphase.BroadphaseInterface;
import com.bulletphysics.collision.broadphase.DbvtBroadphase;
import com.bulletphysics.collision.dispatch.CollisionDispatcher;
import com.bulletphysics.collision.dispatch.DefaultCollisionConfiguration;
import com.bulletphysics.collision.shapes.BoxShape;
import com.bulletphysics.collision.shapes.BvhTriangleMeshShape;
import com.bulletphysics.collision.shapes.CollisionShape;
import com.bulletphysics.collision.shapes.TriangleIndexVertexArray;
import com.bulletphysics.demos.concaveconvexcast.ConvexcastBatch;
import com.bulletphysics.demos.opengl.DemoApplication;
import com.bulletphysics.demos.opengl.GLDebugDrawer;
import com.bulletphysics.demos.opengl.IGL;
import com.bulletphysics.demos.opengl.LWJGL;
import com.bulletphysics.dynamics.DiscreteDynamicsWorld;
import com.bulletphysics.dynamics.RigidBody;
import com.bulletphysics.dynamics.constraintsolver.ConstraintSolver;
import com.bulletphysics.dynamics.constraintsolver.SequentialImpulseConstraintSolver;
import com.bulletphysics.linearmath.Transform;
import com.bulletphysics.util.ObjectArrayList;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import javax.vecmath.Vector3f;
import org.lwjgl.LWJGLException;

public class ConcaveConvexcastDemo
extends DemoApplication {
    private ObjectArrayList<CollisionShape> collisionShapes = new ObjectArrayList();
    private TriangleIndexVertexArray indexVertexArrays;
    private BroadphaseInterface broadphase;
    private CollisionDispatcher dispatcher;
    private ConstraintSolver solver;
    private DefaultCollisionConfiguration collisionConfiguration;
    private boolean animatedMesh = false;
    private static ByteBuffer gVertices;
    private static ByteBuffer gIndices;
    private static BvhTriangleMeshShape trimeshShape;
    private static RigidBody staticBody;
    private static float waveheight;
    private static final float TRIANGLE_SIZE = 8.0f;
    private static int NUM_VERTS_X;
    private static int NUM_VERTS_Y;
    private static int totalVerts;
    private ConvexcastBatch convexcastBatch;
    private static float offset;

    public ConcaveConvexcastDemo(IGL gl) {
        super(gl);
    }

    public void setVertexPositions(float waveheight, float offset) {
        Vector3f tmp = new Vector3f();
        for (int i = 0; i < NUM_VERTS_X; ++i) {
            for (int j = 0; j < NUM_VERTS_Y; ++j) {
                tmp.set(((float)i - (float)NUM_VERTS_X * 0.5f) * 8.0f, waveheight * (float)Math.sin((float)i + offset) * (float)Math.cos((float)j + offset), ((float)j - (float)NUM_VERTS_Y * 0.5f) * 8.0f);
                int index = i + j * NUM_VERTS_X;
                gVertices.putFloat((index * 3 + 0) * 4, tmp.x);
                gVertices.putFloat((index * 3 + 1) * 4, tmp.y);
                gVertices.putFloat((index * 3 + 2) * 4, tmp.z);
            }
        }
    }

    @Override
    public void keyboardCallback(char key, int x, int y, int modifiers) {
        if (key == 'g') {
            boolean bl = this.animatedMesh = !this.animatedMesh;
            if (this.animatedMesh) {
                staticBody.setCollisionFlags(staticBody.getCollisionFlags() | 2);
                staticBody.setActivationState(4);
            } else {
                staticBody.setCollisionFlags(staticBody.getCollisionFlags() & 0xFFFFFFFD);
                staticBody.forceActivationState(1);
            }
        }
        super.keyboardCallback(key, x, y, modifiers);
    }

    @Override
    public void initPhysics() {
        int i;
        float TRISIZE = 10.0f;
        int vertStride = 12;
        int indexStride = 12;
        int totalTriangles = 2 * (NUM_VERTS_X - 1) * (NUM_VERTS_Y - 1);
        gVertices = ByteBuffer.allocateDirect(totalVerts * 3 * 4).order(ByteOrder.nativeOrder());
        gIndices = ByteBuffer.allocateDirect(totalTriangles * 3 * 4).order(ByteOrder.nativeOrder());
        this.setVertexPositions(waveheight, 0.0f);
        gIndices.clear();
        for (i = 0; i < NUM_VERTS_X - 1; ++i) {
            for (int j = 0; j < NUM_VERTS_Y - 1; ++j) {
                gIndices.putInt(j * NUM_VERTS_X + i);
                gIndices.putInt(j * NUM_VERTS_X + i + 1);
                gIndices.putInt((j + 1) * NUM_VERTS_X + i + 1);
                gIndices.putInt(j * NUM_VERTS_X + i);
                gIndices.putInt((j + 1) * NUM_VERTS_X + i + 1);
                gIndices.putInt((j + 1) * NUM_VERTS_X + i);
            }
        }
        gIndices.flip();
        this.indexVertexArrays = new TriangleIndexVertexArray(totalTriangles, gIndices, indexStride, totalVerts, gVertices, vertStride);
        boolean useQuantizedAabbCompression = true;
        trimeshShape = new BvhTriangleMeshShape(this.indexVertexArrays, useQuantizedAabbCompression);
        this.collisionShapes.add(trimeshShape);
        BvhTriangleMeshShape groundShape = trimeshShape;
        this.collisionConfiguration = new DefaultCollisionConfiguration();
        this.dispatcher = new CollisionDispatcher(this.collisionConfiguration);
        Vector3f worldMin = new Vector3f(-1000.0f, -1000.0f, -1000.0f);
        Vector3f worldMax = new Vector3f(1000.0f, 1000.0f, 1000.0f);
        this.broadphase = new DbvtBroadphase();
        this.solver = new SequentialImpulseConstraintSolver();
        this.dynamicsWorld = new DiscreteDynamicsWorld(this.dispatcher, this.broadphase, this.solver, this.collisionConfiguration);
        this.dynamicsWorld.setDebugDrawer(new GLDebugDrawer(this.gl));
        float mass = 0.0f;
        Transform startTransform = new Transform();
        startTransform.setIdentity();
        startTransform.origin.set(0.0f, -2.0f, 0.0f);
        BoxShape colShape = new BoxShape(new Vector3f(1.0f, 1.0f, 1.0f));
        this.collisionShapes.add(colShape);
        for (i = 0; i < 10; ++i) {
            startTransform.origin.set(2.0f * (float)i, 10.0f, 1.0f);
            this.localCreateRigidBody(1.0f, startTransform, colShape);
        }
        startTransform.setIdentity();
        staticBody = this.localCreateRigidBody(mass, startTransform, groundShape);
        staticBody.setCollisionFlags(staticBody.getCollisionFlags() | 1);
        staticBody.setCollisionFlags(staticBody.getCollisionFlags() | 8);
        this.convexcastBatch = new ConvexcastBatch(40.0f, 0.0f, -10.0f, 10.0f);
    }

    @Override
    public void clientMoveAndDisplay() {
        this.gl.glClear(16640);
        float dt = this.getDeltaTimeMicroseconds() * 1.0E-6f;
        if (this.animatedMesh) {
            long t0 = System.nanoTime();
            this.setVertexPositions(waveheight, offset += 0.01f);
            trimeshShape.refitTree(null, null);
            this.dynamicsWorld.getBroadphase().getOverlappingPairCache().cleanProxyFromPairs(staticBody.getBroadphaseHandle(), this.getDynamicsWorld().getDispatcher());
            BulletStats.updateTime = (System.nanoTime() - t0) / 1000000L;
        }
        this.dynamicsWorld.stepSimulation(dt);
        this.dynamicsWorld.debugDrawWorld();
        this.convexcastBatch.move(dt);
        this.convexcastBatch.cast(this.dynamicsWorld);
        this.renderme();
        this.convexcastBatch.draw(this.gl);
    }

    @Override
    public void displayCallback() {
        this.gl.glClear(16640);
        this.renderme();
        this.convexcastBatch.draw(this.gl);
        if (this.dynamicsWorld != null) {
            this.dynamicsWorld.debugDrawWorld();
        }
    }

    public static void main(String[] args) throws LWJGLException {
        ConcaveConvexcastDemo concaveConvexcastDemo = new ConcaveConvexcastDemo(LWJGL.getGL());
        concaveConvexcastDemo.initPhysics();
        concaveConvexcastDemo.setCameraDistance(30.0f);
        LWJGL.main(args, 800, 600, "Concave Convexcast Demo", concaveConvexcastDemo);
    }

    static {
        waveheight = 5.0f;
        NUM_VERTS_X = 30;
        NUM_VERTS_Y = 30;
        totalVerts = NUM_VERTS_X * NUM_VERTS_Y;
        offset = 0.0f;
    }
}

