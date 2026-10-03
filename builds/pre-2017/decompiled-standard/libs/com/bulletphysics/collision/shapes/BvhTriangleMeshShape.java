/*
 * Decompiled with CFR 0.152.
 */
package com.bulletphysics.collision.shapes;

import com.bulletphysics.$Stack;
import com.bulletphysics.collision.broadphase.BroadphaseNativeType;
import com.bulletphysics.collision.shapes.NodeOverlapCallback;
import com.bulletphysics.collision.shapes.OptimizedBvh;
import com.bulletphysics.collision.shapes.StridingMeshInterface;
import com.bulletphysics.collision.shapes.TriangleCallback;
import com.bulletphysics.collision.shapes.TriangleMeshShape;
import com.bulletphysics.collision.shapes.VertexData;
import com.bulletphysics.linearmath.VectorUtil;
import com.bulletphysics.util.ObjectPool;
import javax.vecmath.Tuple3f;
import javax.vecmath.Vector3f;

public class BvhTriangleMeshShape
extends TriangleMeshShape {
    private OptimizedBvh bvh = null;
    private boolean useQuantizedAabbCompression;
    private boolean ownsBvh;
    private ObjectPool<MyNodeOverlapCallback> myNodeCallbacks = ObjectPool.get(MyNodeOverlapCallback.class);

    public BvhTriangleMeshShape() {
        super(null);
        this.ownsBvh = false;
    }

    public BvhTriangleMeshShape(StridingMeshInterface meshInterface, boolean useQuantizedAabbCompression) {
        this(meshInterface, useQuantizedAabbCompression, true);
    }

    public BvhTriangleMeshShape(StridingMeshInterface meshInterface, boolean useQuantizedAabbCompression, boolean buildBvh) {
        super(meshInterface);
        this.useQuantizedAabbCompression = useQuantizedAabbCompression;
        this.ownsBvh = false;
        Vector3f bvhAabbMin = new Vector3f();
        Vector3f bvhAabbMax = new Vector3f();
        meshInterface.calculateAabbBruteForce(bvhAabbMin, bvhAabbMax);
        if (buildBvh) {
            this.bvh = new OptimizedBvh();
            this.bvh.build(meshInterface, useQuantizedAabbCompression, bvhAabbMin, bvhAabbMax);
            this.ownsBvh = true;
            this.recalcLocalAabb();
        }
    }

    public BvhTriangleMeshShape(StridingMeshInterface meshInterface, boolean useQuantizedAabbCompression, Vector3f bvhAabbMin, Vector3f bvhAabbMax) {
        this(meshInterface, useQuantizedAabbCompression, bvhAabbMin, bvhAabbMax, true);
    }

    public BvhTriangleMeshShape(StridingMeshInterface meshInterface, boolean useQuantizedAabbCompression, Vector3f bvhAabbMin, Vector3f bvhAabbMax, boolean buildBvh) {
        super(meshInterface);
        this.useQuantizedAabbCompression = useQuantizedAabbCompression;
        this.ownsBvh = false;
        if (buildBvh) {
            this.bvh = new OptimizedBvh();
            this.bvh.build(meshInterface, useQuantizedAabbCompression, bvhAabbMin, bvhAabbMax);
            this.ownsBvh = true;
        }
        this.recalcLocalAabb();
    }

    public boolean getOwnsBvh() {
        return this.ownsBvh;
    }

    @Override
    public BroadphaseNativeType getShapeType() {
        return BroadphaseNativeType.TRIANGLE_MESH_SHAPE_PROXYTYPE;
    }

    public void performRaycast(TriangleCallback callback, Vector3f raySource, Vector3f rayTarget) {
        MyNodeOverlapCallback myNodeCallback = this.myNodeCallbacks.get();
        myNodeCallback.init(callback, this.meshInterface);
        this.bvh.reportRayOverlappingNodex(myNodeCallback, raySource, rayTarget);
        this.myNodeCallbacks.release(myNodeCallback);
    }

    public void performConvexcast(TriangleCallback callback, Vector3f raySource, Vector3f rayTarget, Vector3f aabbMin, Vector3f aabbMax) {
        MyNodeOverlapCallback myNodeCallback = this.myNodeCallbacks.get();
        myNodeCallback.init(callback, this.meshInterface);
        this.bvh.reportBoxCastOverlappingNodex(myNodeCallback, raySource, rayTarget, aabbMin, aabbMax);
        this.myNodeCallbacks.release(myNodeCallback);
    }

    @Override
    public void processAllTriangles(TriangleCallback callback, Vector3f aabbMin, Vector3f aabbMax) {
        MyNodeOverlapCallback myNodeCallback = this.myNodeCallbacks.get();
        myNodeCallback.init(callback, this.meshInterface);
        this.bvh.reportAabbOverlappingNodex(myNodeCallback, aabbMin, aabbMax);
        this.myNodeCallbacks.release(myNodeCallback);
    }

    public void refitTree(Vector3f aabbMin, Vector3f aabbMax) {
        this.bvh.refit(this.meshInterface);
        this.recalcLocalAabb();
    }

    public void partialRefitTree(Vector3f aabbMin, Vector3f aabbMax) {
        this.bvh.refitPartial(this.meshInterface, aabbMin, aabbMax);
        VectorUtil.setMin(this.localAabbMin, aabbMin);
        VectorUtil.setMax(this.localAabbMax, aabbMax);
    }

    @Override
    public String getName() {
        return "BVHTRIANGLEMESH";
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public void setLocalScaling(Vector3f vector3f) {
        $Stack $Stack = $Stack.get();
        try {
            void scaling;
            $Stack.push$javax$vecmath$Vector3f();
            Vector3f tmp = $Stack.get$javax$vecmath$Vector3f();
            tmp.sub(this.getLocalScaling($Stack.get$javax$vecmath$Vector3f()), (Tuple3f)scaling);
            if (tmp.lengthSquared() > 1.1920929E-7f) {
                super.setLocalScaling((Vector3f)scaling);
                this.bvh = new OptimizedBvh();
                this.bvh.build(this.meshInterface, this.useQuantizedAabbCompression, this.localAabbMin, this.localAabbMax);
                this.ownsBvh = true;
            }
            $Stack.pop$javax$vecmath$Vector3f();
            return;
        }
        catch (Throwable throwable) {
            $Stack.pop$javax$vecmath$Vector3f();
            throw throwable;
        }
    }

    public OptimizedBvh getOptimizedBvh() {
        return this.bvh;
    }

    /*
     * WARNING - void declaration
     */
    public void setOptimizedBvh(OptimizedBvh optimizedBvh) {
        $Stack $Stack = $Stack.get();
        try {
            void bvh;
            $Stack.push$javax$vecmath$Vector3f();
            Vector3f scaling = $Stack.get$javax$vecmath$Vector3f();
            scaling.set(1.0f, 1.0f, 1.0f);
            this.setOptimizedBvh((OptimizedBvh)bvh, scaling);
            $Stack.pop$javax$vecmath$Vector3f();
            return;
        }
        catch (Throwable throwable) {
            $Stack.pop$javax$vecmath$Vector3f();
            throw throwable;
        }
    }

    /*
     * WARNING - void declaration
     */
    public void setOptimizedBvh(OptimizedBvh optimizedBvh, Vector3f vector3f) {
        $Stack $Stack = $Stack.get();
        try {
            void scaling;
            void bvh;
            $Stack.push$javax$vecmath$Vector3f();
            assert (this.bvh == null);
            assert (!this.ownsBvh);
            this.bvh = bvh;
            this.ownsBvh = false;
            Vector3f tmp = $Stack.get$javax$vecmath$Vector3f();
            tmp.sub(this.getLocalScaling($Stack.get$javax$vecmath$Vector3f()), (Tuple3f)scaling);
            if (tmp.lengthSquared() > 1.1920929E-7f) {
                super.setLocalScaling((Vector3f)scaling);
            }
            $Stack.pop$javax$vecmath$Vector3f();
            return;
        }
        catch (Throwable throwable) {
            $Stack.pop$javax$vecmath$Vector3f();
            throw throwable;
        }
    }

    public boolean usesQuantizedAabbCompression() {
        return this.useQuantizedAabbCompression;
    }

    protected static class MyNodeOverlapCallback
    extends NodeOverlapCallback {
        public StridingMeshInterface meshInterface;
        public TriangleCallback callback;
        private Vector3f[] triangle = new Vector3f[]{new Vector3f(), new Vector3f(), new Vector3f()};

        public void init(TriangleCallback callback, StridingMeshInterface meshInterface) {
            this.meshInterface = meshInterface;
            this.callback = callback;
        }

        /*
         * WARNING - void declaration
         */
        @Override
        public void processNode(int n, int n2) {
            $Stack $Stack = $Stack.get();
            try {
                void nodeTriangleIndex;
                void nodeSubPart;
                $Stack.push$javax$vecmath$Vector3f();
                VertexData data2 = this.meshInterface.getLockedReadOnlyVertexIndexBase((int)nodeSubPart);
                Vector3f meshScaling = this.meshInterface.getScaling($Stack.get$javax$vecmath$Vector3f());
                data2.getTriangle((int)(nodeTriangleIndex * 3), meshScaling, this.triangle);
                this.callback.processTriangle(this.triangle, (int)nodeSubPart, (int)nodeTriangleIndex);
                this.meshInterface.unLockReadOnlyVertexBase((int)nodeSubPart);
                $Stack.pop$javax$vecmath$Vector3f();
                return;
            }
            catch (Throwable throwable) {
                $Stack.pop$javax$vecmath$Vector3f();
                throw throwable;
            }
        }
    }
}

