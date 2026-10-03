/*
 * Decompiled with CFR 0.152.
 */
package com.bulletphysics.extras.gimpact;

import com.bulletphysics.$Stack;
import com.bulletphysics.collision.broadphase.BroadphaseNativeType;
import com.bulletphysics.collision.broadphase.CollisionAlgorithm;
import com.bulletphysics.collision.broadphase.CollisionAlgorithmConstructionInfo;
import com.bulletphysics.collision.broadphase.DispatcherInfo;
import com.bulletphysics.collision.dispatch.CollisionAlgorithmCreateFunc;
import com.bulletphysics.collision.dispatch.CollisionDispatcher;
import com.bulletphysics.collision.dispatch.CollisionObject;
import com.bulletphysics.collision.dispatch.ManifoldResult;
import com.bulletphysics.collision.narrowphase.PersistentManifold;
import com.bulletphysics.collision.shapes.CollisionShape;
import com.bulletphysics.collision.shapes.CompoundShape;
import com.bulletphysics.collision.shapes.ConcaveShape;
import com.bulletphysics.collision.shapes.StaticPlaneShape;
import com.bulletphysics.extras.gimpact.BoxCollision;
import com.bulletphysics.extras.gimpact.GIM_ShapeRetriever;
import com.bulletphysics.extras.gimpact.GImpactBvh;
import com.bulletphysics.extras.gimpact.GImpactMeshShape;
import com.bulletphysics.extras.gimpact.GImpactMeshShapePart;
import com.bulletphysics.extras.gimpact.GImpactShapeInterface;
import com.bulletphysics.extras.gimpact.GImpactTriangleCallback;
import com.bulletphysics.extras.gimpact.Pair;
import com.bulletphysics.extras.gimpact.PairSet;
import com.bulletphysics.extras.gimpact.PlaneIntersectionType;
import com.bulletphysics.extras.gimpact.PlaneShape;
import com.bulletphysics.extras.gimpact.PrimitiveTriangle;
import com.bulletphysics.extras.gimpact.ShapeType;
import com.bulletphysics.extras.gimpact.TriangleContact;
import com.bulletphysics.linearmath.Transform;
import com.bulletphysics.linearmath.VectorUtil;
import com.bulletphysics.util.IntArrayList;
import com.bulletphysics.util.ObjectArrayList;
import com.bulletphysics.util.ObjectPool;
import javax.vecmath.Vector3f;
import javax.vecmath.Vector4f;

public class GImpactCollisionAlgorithm
extends CollisionAlgorithm {
    protected CollisionAlgorithm convex_algorithm;
    protected PersistentManifold manifoldPtr;
    protected ManifoldResult resultOut;
    protected DispatcherInfo dispatchInfo;
    protected int triface0;
    protected int part0;
    protected int triface1;
    protected int part1;
    private PairSet tmpPairset = new PairSet();

    public void init(CollisionAlgorithmConstructionInfo ci, CollisionObject body0, CollisionObject body1) {
        super.init(ci);
        this.manifoldPtr = null;
        this.convex_algorithm = null;
    }

    @Override
    public void destroy() {
        this.clearCache();
    }

    @Override
    public void processCollision(CollisionObject body0, CollisionObject body1, DispatcherInfo dispatchInfo, ManifoldResult resultOut) {
        this.clearCache();
        this.resultOut = resultOut;
        this.dispatchInfo = dispatchInfo;
        if (body0.getCollisionShape().getShapeType() == BroadphaseNativeType.GIMPACT_SHAPE_PROXYTYPE) {
            GImpactShapeInterface gimpactshape0 = (GImpactShapeInterface)body0.getCollisionShape();
            if (body1.getCollisionShape().getShapeType() == BroadphaseNativeType.GIMPACT_SHAPE_PROXYTYPE) {
                GImpactShapeInterface gimpactshape1 = (GImpactShapeInterface)body1.getCollisionShape();
                this.gimpact_vs_gimpact(body0, body1, gimpactshape0, gimpactshape1);
            } else {
                this.gimpact_vs_shape(body0, body1, gimpactshape0, body1.getCollisionShape(), false);
            }
        } else if (body1.getCollisionShape().getShapeType() == BroadphaseNativeType.GIMPACT_SHAPE_PROXYTYPE) {
            GImpactShapeInterface gimpactshape1 = (GImpactShapeInterface)body1.getCollisionShape();
            this.gimpact_vs_shape(body1, body0, gimpactshape1, body0.getCollisionShape(), true);
        }
    }

    /*
     * WARNING - void declaration
     */
    public void gimpact_vs_gimpact(CollisionObject collisionObject, CollisionObject collisionObject2, GImpactShapeInterface gImpactShapeInterface, GImpactShapeInterface gImpactShapeInterface2) {
        $Stack $Stack = $Stack.get();
        try {
            void shape1;
            void body1;
            void body0;
            void shape0;
            $Stack.push$com$bulletphysics$linearmath$Transform();
            if (shape0.getGImpactShapeType() == ShapeType.TRIMESH_SHAPE) {
                GImpactMeshShape meshshape0 = (GImpactMeshShape)shape0;
                this.part0 = meshshape0.getMeshPartCount();
                while (this.part0-- != 0) {
                    this.gimpact_vs_gimpact((CollisionObject)body0, (CollisionObject)body1, meshshape0.getMeshPart(this.part0), (GImpactShapeInterface)shape1);
                }
                $Stack.pop$com$bulletphysics$linearmath$Transform();
                return;
            }
            if (shape1.getGImpactShapeType() == ShapeType.TRIMESH_SHAPE) {
                GImpactMeshShape meshshape1 = (GImpactMeshShape)shape1;
                this.part1 = meshshape1.getMeshPartCount();
                while (this.part1-- != 0) {
                    this.gimpact_vs_gimpact((CollisionObject)body0, (CollisionObject)body1, (GImpactShapeInterface)shape0, meshshape1.getMeshPart(this.part1));
                }
                $Stack.pop$com$bulletphysics$linearmath$Transform();
                return;
            }
            Transform orgtrans0 = body0.getWorldTransform($Stack.get$com$bulletphysics$linearmath$Transform());
            Transform orgtrans1 = body1.getWorldTransform($Stack.get$com$bulletphysics$linearmath$Transform());
            PairSet pairset = this.tmpPairset;
            pairset.clear();
            this.gimpact_vs_gimpact_find_pairs(orgtrans0, orgtrans1, (GImpactShapeInterface)shape0, (GImpactShapeInterface)shape1, pairset);
            if (pairset.size() == 0) {
                $Stack.pop$com$bulletphysics$linearmath$Transform();
                return;
            }
            if (shape0.getGImpactShapeType() == ShapeType.TRIMESH_SHAPE_PART && shape1.getGImpactShapeType() == ShapeType.TRIMESH_SHAPE_PART) {
                GImpactMeshShapePart shapepart0 = (GImpactMeshShapePart)shape0;
                GImpactMeshShapePart shapepart1 = (GImpactMeshShapePart)shape1;
                this.collide_sat_triangles((CollisionObject)body0, (CollisionObject)body1, shapepart0, shapepart1, pairset, pairset.size());
                $Stack.pop$com$bulletphysics$linearmath$Transform();
                return;
            }
            shape0.lockChildShapes();
            shape1.lockChildShapes();
            GIM_ShapeRetriever retriever0 = new GIM_ShapeRetriever((GImpactShapeInterface)shape0);
            GIM_ShapeRetriever retriever1 = new GIM_ShapeRetriever((GImpactShapeInterface)shape1);
            boolean child_has_transform0 = shape0.childrenHasTransform();
            boolean child_has_transform1 = shape1.childrenHasTransform();
            Transform tmpTrans = $Stack.get$com$bulletphysics$linearmath$Transform();
            int i = pairset.size();
            while (i-- != 0) {
                Pair pair = pairset.get(i);
                this.triface0 = pair.index1;
                this.triface1 = pair.index2;
                CollisionShape colshape0 = retriever0.getChildShape(this.triface0);
                CollisionShape colshape1 = retriever1.getChildShape(this.triface1);
                if (child_has_transform0) {
                    tmpTrans.mul(orgtrans0, shape0.getChildTransform(this.triface0));
                    body0.setWorldTransform(tmpTrans);
                }
                if (child_has_transform1) {
                    tmpTrans.mul(orgtrans1, shape1.getChildTransform(this.triface1));
                    body1.setWorldTransform(tmpTrans);
                }
                this.convex_vs_convex_collision((CollisionObject)body0, (CollisionObject)body1, colshape0, colshape1);
                if (child_has_transform0) {
                    body0.setWorldTransform(orgtrans0);
                }
                if (!child_has_transform1) continue;
                body1.setWorldTransform(orgtrans1);
            }
            shape0.unlockChildShapes();
            shape1.unlockChildShapes();
            $Stack.pop$com$bulletphysics$linearmath$Transform();
            return;
        }
        catch (Throwable throwable) {
            $Stack.pop$com$bulletphysics$linearmath$Transform();
            throw throwable;
        }
    }

    /*
     * WARNING - void declaration
     */
    public void gimpact_vs_shape(CollisionObject collisionObject, CollisionObject collisionObject2, GImpactShapeInterface gImpactShapeInterface, CollisionShape collisionShape, boolean bl) {
        $Stack $Stack = $Stack.get();
        try {
            void swapped;
            void shape1;
            void body1;
            void body0;
            void shape0;
            $Stack.push$com$bulletphysics$linearmath$Transform();
            if (shape0.getGImpactShapeType() == ShapeType.TRIMESH_SHAPE) {
                GImpactMeshShape meshshape0 = (GImpactMeshShape)shape0;
                this.part0 = meshshape0.getMeshPartCount();
                while (this.part0-- != 0) {
                    this.gimpact_vs_shape((CollisionObject)body0, (CollisionObject)body1, meshshape0.getMeshPart(this.part0), (CollisionShape)shape1, (boolean)swapped);
                }
                $Stack.pop$com$bulletphysics$linearmath$Transform();
                return;
            }
            if (shape0.getGImpactShapeType() == ShapeType.TRIMESH_SHAPE_PART && shape1.getShapeType() == BroadphaseNativeType.STATIC_PLANE_PROXYTYPE) {
                GImpactMeshShapePart shapepart = (GImpactMeshShapePart)shape0;
                StaticPlaneShape planeshape = (StaticPlaneShape)shape1;
                this.gimpacttrimeshpart_vs_plane_collision((CollisionObject)body0, (CollisionObject)body1, shapepart, planeshape, (boolean)swapped);
                $Stack.pop$com$bulletphysics$linearmath$Transform();
                return;
            }
            if (shape1.isCompound()) {
                CompoundShape compoundshape = (CompoundShape)shape1;
                this.gimpact_vs_compoundshape((CollisionObject)body0, (CollisionObject)body1, (GImpactShapeInterface)shape0, compoundshape, (boolean)swapped);
                $Stack.pop$com$bulletphysics$linearmath$Transform();
                return;
            }
            if (shape1.isConcave()) {
                ConcaveShape concaveshape = (ConcaveShape)shape1;
                this.gimpact_vs_concave((CollisionObject)body0, (CollisionObject)body1, (GImpactShapeInterface)shape0, concaveshape, (boolean)swapped);
                $Stack.pop$com$bulletphysics$linearmath$Transform();
                return;
            }
            Transform orgtrans0 = body0.getWorldTransform($Stack.get$com$bulletphysics$linearmath$Transform());
            Transform orgtrans1 = body1.getWorldTransform($Stack.get$com$bulletphysics$linearmath$Transform());
            IntArrayList collided_results = new IntArrayList();
            this.gimpact_vs_shape_find_pairs(orgtrans0, orgtrans1, (GImpactShapeInterface)shape0, (CollisionShape)shape1, collided_results);
            if (collided_results.size() == 0) {
                $Stack.pop$com$bulletphysics$linearmath$Transform();
                return;
            }
            shape0.lockChildShapes();
            GIM_ShapeRetriever retriever0 = new GIM_ShapeRetriever((GImpactShapeInterface)shape0);
            boolean child_has_transform0 = shape0.childrenHasTransform();
            Transform tmpTrans = $Stack.get$com$bulletphysics$linearmath$Transform();
            int i = collided_results.size();
            while (i-- != 0) {
                int child_index = collided_results.get(i);
                if (swapped != false) {
                    this.triface1 = child_index;
                } else {
                    this.triface0 = child_index;
                }
                CollisionShape colshape0 = retriever0.getChildShape(child_index);
                if (child_has_transform0) {
                    tmpTrans.mul(orgtrans0, shape0.getChildTransform(child_index));
                    body0.setWorldTransform(tmpTrans);
                }
                if (swapped != false) {
                    this.shape_vs_shape_collision((CollisionObject)body1, (CollisionObject)body0, (CollisionShape)shape1, colshape0);
                } else {
                    this.shape_vs_shape_collision((CollisionObject)body0, (CollisionObject)body1, colshape0, (CollisionShape)shape1);
                }
                if (!child_has_transform0) continue;
                body0.setWorldTransform(orgtrans0);
            }
            shape0.unlockChildShapes();
            $Stack.pop$com$bulletphysics$linearmath$Transform();
            return;
        }
        catch (Throwable throwable) {
            $Stack.pop$com$bulletphysics$linearmath$Transform();
            throw throwable;
        }
    }

    /*
     * WARNING - void declaration
     */
    public void gimpact_vs_compoundshape(CollisionObject collisionObject, CollisionObject collisionObject2, GImpactShapeInterface gImpactShapeInterface, CompoundShape compoundShape, boolean bl) {
        $Stack $Stack = $Stack.get();
        try {
            void shape1;
            void body1;
            $Stack.push$com$bulletphysics$linearmath$Transform();
            Transform orgtrans1 = body1.getWorldTransform($Stack.get$com$bulletphysics$linearmath$Transform());
            Transform childtrans1 = $Stack.get$com$bulletphysics$linearmath$Transform();
            Transform tmpTrans = $Stack.get$com$bulletphysics$linearmath$Transform();
            int i = shape1.getNumChildShapes();
            while (i-- != 0) {
                void swapped;
                void shape0;
                void body0;
                CollisionShape colshape1 = shape1.getChildShape(i);
                childtrans1.mul(orgtrans1, shape1.getChildTransform(i, tmpTrans));
                body1.setWorldTransform(childtrans1);
                this.gimpact_vs_shape((CollisionObject)body0, (CollisionObject)body1, (GImpactShapeInterface)shape0, colshape1, (boolean)swapped);
                body1.setWorldTransform(orgtrans1);
            }
            $Stack.pop$com$bulletphysics$linearmath$Transform();
            return;
        }
        catch (Throwable throwable) {
            $Stack.pop$com$bulletphysics$linearmath$Transform();
            throw throwable;
        }
    }

    /*
     * WARNING - void declaration
     */
    public void gimpact_vs_concave(CollisionObject collisionObject, CollisionObject collisionObject2, GImpactShapeInterface gImpactShapeInterface, ConcaveShape concaveShape, boolean bl) {
        $Stack $Stack = $Stack.get();
        try {
            void shape1;
            void swapped;
            void shape0;
            void body1;
            void body0;
            $Stack $Stack2 = $Stack;
            $Stack2.push$com$bulletphysics$linearmath$Transform();
            $Stack2.push$javax$vecmath$Vector3f();
            GImpactTriangleCallback tricallback = new GImpactTriangleCallback();
            tricallback.algorithm = this;
            tricallback.body0 = body0;
            tricallback.body1 = body1;
            tricallback.gimpactshape0 = shape0;
            tricallback.swapped = swapped;
            tricallback.margin = shape1.getMargin();
            Transform gimpactInConcaveSpace = $Stack.get$com$bulletphysics$linearmath$Transform();
            body1.getWorldTransform(gimpactInConcaveSpace);
            gimpactInConcaveSpace.inverse();
            gimpactInConcaveSpace.mul(body0.getWorldTransform($Stack.get$com$bulletphysics$linearmath$Transform()));
            Vector3f minAABB = $Stack.get$javax$vecmath$Vector3f();
            Vector3f maxAABB = $Stack.get$javax$vecmath$Vector3f();
            shape0.getAabb(gimpactInConcaveSpace, minAABB, maxAABB);
            shape1.processAllTriangles(tricallback, minAABB, maxAABB);
            $Stack $Stack3 = $Stack;
            $Stack3.pop$com$bulletphysics$linearmath$Transform();
            $Stack3.pop$javax$vecmath$Vector3f();
            return;
        }
        catch (Throwable throwable) {
            $Stack $Stack4 = $Stack;
            $Stack4.pop$com$bulletphysics$linearmath$Transform();
            $Stack4.pop$javax$vecmath$Vector3f();
            throw throwable;
        }
    }

    protected PersistentManifold newContactManifold(CollisionObject body0, CollisionObject body1) {
        this.manifoldPtr = this.dispatcher.getNewManifold(body0, body1);
        return this.manifoldPtr;
    }

    protected void destroyConvexAlgorithm() {
        if (this.convex_algorithm != null) {
            this.dispatcher.freeCollisionAlgorithm(this.convex_algorithm);
            this.convex_algorithm = null;
        }
    }

    protected void destroyContactManifolds() {
        if (this.manifoldPtr == null) {
            return;
        }
        this.dispatcher.releaseManifold(this.manifoldPtr);
        this.manifoldPtr = null;
    }

    protected void clearCache() {
        this.destroyContactManifolds();
        this.destroyConvexAlgorithm();
        this.triface0 = -1;
        this.part0 = -1;
        this.triface1 = -1;
        this.part1 = -1;
    }

    protected PersistentManifold getLastManifold() {
        return this.manifoldPtr;
    }

    protected void checkManifold(CollisionObject body0, CollisionObject body1) {
        if (this.getLastManifold() == null) {
            this.newContactManifold(body0, body1);
        }
        this.resultOut.setPersistentManifold(this.getLastManifold());
    }

    protected CollisionAlgorithm newAlgorithm(CollisionObject body0, CollisionObject body1) {
        this.checkManifold(body0, body1);
        CollisionAlgorithm convex_algorithm = this.dispatcher.findAlgorithm(body0, body1, this.getLastManifold());
        return convex_algorithm;
    }

    protected void checkConvexAlgorithm(CollisionObject body0, CollisionObject body1) {
        if (this.convex_algorithm != null) {
            return;
        }
        this.convex_algorithm = this.newAlgorithm(body0, body1);
    }

    protected void addContactPoint(CollisionObject body0, CollisionObject body1, Vector3f point, Vector3f normal, float distance) {
        this.resultOut.setShapeIdentifiers(this.part0, this.triface0, this.part1, this.triface1);
        this.checkManifold(body0, body1);
        this.resultOut.addContactPoint(normal, point, distance);
    }

    /*
     * WARNING - void declaration
     */
    void collide_sat_triangles(CollisionObject collisionObject, CollisionObject collisionObject2, GImpactMeshShapePart gImpactMeshShapePart, GImpactMeshShapePart gImpactMeshShapePart2, PairSet pairSet, int n) {
        $Stack $Stack = $Stack.get();
        try {
            void pair_count;
            void shape1;
            void shape0;
            void body1;
            void body0;
            $Stack $Stack2 = $Stack;
            $Stack2.push$com$bulletphysics$linearmath$Transform();
            $Stack2.push$com$bulletphysics$extras$gimpact$PrimitiveTriangle();
            $Stack2.push$javax$vecmath$Vector3f();
            $Stack2.push$com$bulletphysics$extras$gimpact$TriangleContact();
            Vector3f tmp = $Stack.get$javax$vecmath$Vector3f();
            Transform orgtrans0 = body0.getWorldTransform($Stack.get$com$bulletphysics$linearmath$Transform());
            Transform orgtrans1 = body1.getWorldTransform($Stack.get$com$bulletphysics$linearmath$Transform());
            PrimitiveTriangle ptri0 = $Stack.get$com$bulletphysics$extras$gimpact$PrimitiveTriangle();
            PrimitiveTriangle ptri1 = $Stack.get$com$bulletphysics$extras$gimpact$PrimitiveTriangle();
            TriangleContact contact_data = $Stack.get$com$bulletphysics$extras$gimpact$TriangleContact();
            shape0.lockChildShapes();
            shape1.lockChildShapes();
            int pair_pointer = 0;
            while (--pair_count != false) {
                void pairs;
                Pair pair = pairs.get(pair_pointer++);
                this.triface0 = pair.index1;
                this.triface1 = pair.index2;
                shape0.getPrimitiveTriangle(this.triface0, ptri0);
                shape1.getPrimitiveTriangle(this.triface1, ptri1);
                ptri0.applyTransform(orgtrans0);
                ptri1.applyTransform(orgtrans1);
                ptri0.buildTriPlane();
                ptri1.buildTriPlane();
                if (!ptri0.overlap_test_conservative(ptri1) || !ptri0.find_triangle_collision_clip_method(ptri1, contact_data)) continue;
                int j = contact_data.point_count;
                while (j-- != 0) {
                    tmp.x = contact_data.separating_normal.x;
                    tmp.y = contact_data.separating_normal.y;
                    tmp.z = contact_data.separating_normal.z;
                    this.addContactPoint((CollisionObject)body0, (CollisionObject)body1, contact_data.points[j], tmp, -contact_data.penetration_depth);
                }
            }
            shape0.unlockChildShapes();
            shape1.unlockChildShapes();
            $Stack $Stack3 = $Stack;
            $Stack3.pop$com$bulletphysics$linearmath$Transform();
            $Stack3.pop$com$bulletphysics$extras$gimpact$PrimitiveTriangle();
            $Stack3.pop$javax$vecmath$Vector3f();
            $Stack3.pop$com$bulletphysics$extras$gimpact$TriangleContact();
            return;
        }
        catch (Throwable throwable) {
            $Stack $Stack4 = $Stack;
            $Stack4.pop$com$bulletphysics$linearmath$Transform();
            $Stack4.pop$com$bulletphysics$extras$gimpact$PrimitiveTriangle();
            $Stack4.pop$javax$vecmath$Vector3f();
            $Stack4.pop$com$bulletphysics$extras$gimpact$TriangleContact();
            throw throwable;
        }
    }

    protected void shape_vs_shape_collision(CollisionObject body0, CollisionObject body1, CollisionShape shape0, CollisionShape shape1) {
        CollisionShape tmpShape0 = body0.getCollisionShape();
        CollisionShape tmpShape1 = body1.getCollisionShape();
        body0.internalSetTemporaryCollisionShape(shape0);
        body1.internalSetTemporaryCollisionShape(shape1);
        CollisionAlgorithm algor = this.newAlgorithm(body0, body1);
        this.resultOut.setShapeIdentifiers(this.part0, this.triface0, this.part1, this.triface1);
        algor.processCollision(body0, body1, this.dispatchInfo, this.resultOut);
        this.dispatcher.freeCollisionAlgorithm(algor);
        body0.internalSetTemporaryCollisionShape(tmpShape0);
        body1.internalSetTemporaryCollisionShape(tmpShape1);
    }

    protected void convex_vs_convex_collision(CollisionObject body0, CollisionObject body1, CollisionShape shape0, CollisionShape shape1) {
        CollisionShape tmpShape0 = body0.getCollisionShape();
        CollisionShape tmpShape1 = body1.getCollisionShape();
        body0.internalSetTemporaryCollisionShape(shape0);
        body1.internalSetTemporaryCollisionShape(shape1);
        this.resultOut.setShapeIdentifiers(this.part0, this.triface0, this.part1, this.triface1);
        this.checkConvexAlgorithm(body0, body1);
        this.convex_algorithm.processCollision(body0, body1, this.dispatchInfo, this.resultOut);
        body0.internalSetTemporaryCollisionShape(tmpShape0);
        body1.internalSetTemporaryCollisionShape(tmpShape1);
    }

    /*
     * WARNING - void declaration
     */
    void gimpact_vs_gimpact_find_pairs(Transform transform, Transform transform2, GImpactShapeInterface gImpactShapeInterface, GImpactShapeInterface gImpactShapeInterface2, PairSet pairSet) {
        $Stack $Stack = $Stack.get();
        try {
            void pairset;
            void trans1;
            void trans0;
            void shape1;
            void shape0;
            $Stack.push$com$bulletphysics$extras$gimpact$BoxCollision$AABB();
            if (shape0.hasBoxSet() && shape1.hasBoxSet()) {
                GImpactBvh.find_collision(shape0.getBoxSet(), (Transform)trans0, shape1.getBoxSet(), (Transform)trans1, (PairSet)pairset);
            } else {
                BoxCollision.AABB boxshape0 = $Stack.get$com$bulletphysics$extras$gimpact$BoxCollision$AABB();
                BoxCollision.AABB boxshape1 = $Stack.get$com$bulletphysics$extras$gimpact$BoxCollision$AABB();
                int i = shape0.getNumChildShapes();
                while (i-- != 0) {
                    shape0.getChildAabb(i, (Transform)trans0, boxshape0.min, boxshape0.max);
                    int j = shape1.getNumChildShapes();
                    while (j-- != 0) {
                        shape1.getChildAabb(i, (Transform)trans1, boxshape1.min, boxshape1.max);
                        if (!boxshape1.has_collision(boxshape0)) continue;
                        pairset.push_pair(i, j);
                    }
                }
            }
            $Stack.pop$com$bulletphysics$extras$gimpact$BoxCollision$AABB();
            return;
        }
        catch (Throwable throwable) {
            $Stack.pop$com$bulletphysics$extras$gimpact$BoxCollision$AABB();
            throw throwable;
        }
    }

    /*
     * WARNING - void declaration
     */
    protected void gimpact_vs_shape_find_pairs(Transform transform, Transform transform2, GImpactShapeInterface gImpactShapeInterface, CollisionShape collisionShape, IntArrayList intArrayList) {
        $Stack $Stack = $Stack.get();
        try {
            void collided_primitives;
            void shape1;
            void trans1;
            void trans0;
            void shape0;
            $Stack $Stack2 = $Stack;
            $Stack2.push$com$bulletphysics$linearmath$Transform();
            $Stack2.push$com$bulletphysics$extras$gimpact$BoxCollision$AABB();
            BoxCollision.AABB boxshape = $Stack.get$com$bulletphysics$extras$gimpact$BoxCollision$AABB();
            if (shape0.hasBoxSet()) {
                Transform trans1to0 = $Stack.get$com$bulletphysics$linearmath$Transform();
                trans1to0.inverse((Transform)trans0);
                trans1to0.mul((Transform)trans1);
                shape1.getAabb(trans1to0, boxshape.min, boxshape.max);
                shape0.getBoxSet().boxQuery(boxshape, (IntArrayList)collided_primitives);
            } else {
                shape1.getAabb((Transform)trans1, boxshape.min, boxshape.max);
                BoxCollision.AABB boxshape0 = $Stack.get$com$bulletphysics$extras$gimpact$BoxCollision$AABB();
                int i = shape0.getNumChildShapes();
                while (i-- != 0) {
                    shape0.getChildAabb(i, (Transform)trans0, boxshape0.min, boxshape0.max);
                    if (!boxshape.has_collision(boxshape0)) continue;
                    collided_primitives.add(i);
                }
            }
            $Stack $Stack3 = $Stack;
            $Stack3.pop$com$bulletphysics$linearmath$Transform();
            $Stack3.pop$com$bulletphysics$extras$gimpact$BoxCollision$AABB();
            return;
        }
        catch (Throwable throwable) {
            $Stack $Stack4 = $Stack;
            $Stack4.pop$com$bulletphysics$linearmath$Transform();
            $Stack4.pop$com$bulletphysics$extras$gimpact$BoxCollision$AABB();
            throw throwable;
        }
    }

    /*
     * WARNING - void declaration
     */
    protected void gimpacttrimeshpart_vs_plane_collision(CollisionObject collisionObject, CollisionObject collisionObject2, GImpactMeshShapePart gImpactMeshShapePart, StaticPlaneShape staticPlaneShape, boolean bl) {
        $Stack $Stack = $Stack.get();
        try {
            void shape0;
            void shape1;
            void body1;
            void body0;
            $Stack $Stack2 = $Stack;
            $Stack2.push$com$bulletphysics$linearmath$Transform();
            $Stack2.push$com$bulletphysics$extras$gimpact$BoxCollision$AABB();
            $Stack2.push$javax$vecmath$Vector3f();
            $Stack2.push$javax$vecmath$Vector4f();
            Transform orgtrans0 = body0.getWorldTransform($Stack.get$com$bulletphysics$linearmath$Transform());
            Transform orgtrans1 = body1.getWorldTransform($Stack.get$com$bulletphysics$linearmath$Transform());
            void planeshape = shape1;
            Vector4f plane = $Stack.get$javax$vecmath$Vector4f();
            PlaneShape.get_plane_equation_transformed((StaticPlaneShape)planeshape, orgtrans1, plane);
            BoxCollision.AABB tribox = $Stack.get$com$bulletphysics$extras$gimpact$BoxCollision$AABB();
            shape0.getAabb(orgtrans0, tribox.min, tribox.max);
            tribox.increment_margin(planeshape.getMargin());
            if (tribox.plane_classify(plane) != PlaneIntersectionType.COLLIDE_PLANE) {
                $Stack $Stack3 = $Stack;
                $Stack3.pop$com$bulletphysics$linearmath$Transform();
                $Stack3.pop$com$bulletphysics$extras$gimpact$BoxCollision$AABB();
                $Stack3.pop$javax$vecmath$Vector3f();
                $Stack3.pop$javax$vecmath$Vector4f();
                return;
            }
            shape0.lockChildShapes();
            float margin = shape0.getMargin() + planeshape.getMargin();
            Vector3f vertex = $Stack.get$javax$vecmath$Vector3f();
            Vector3f tmp = $Stack.get$javax$vecmath$Vector3f();
            int vi = shape0.getVertexCount();
            while (vi-- != 0) {
                void swapped;
                shape0.getVertex(vi, vertex);
                orgtrans0.transform(vertex);
                float distance = VectorUtil.dot3(vertex, plane) - plane.w - margin;
                if (!(distance < 0.0f)) continue;
                if (swapped != false) {
                    tmp.set(-plane.x, -plane.y, -plane.z);
                    this.addContactPoint((CollisionObject)body1, (CollisionObject)body0, vertex, tmp, distance);
                    continue;
                }
                tmp.set(plane.x, plane.y, plane.z);
                this.addContactPoint((CollisionObject)body0, (CollisionObject)body1, vertex, tmp, distance);
            }
            shape0.unlockChildShapes();
            $Stack $Stack4 = $Stack;
            $Stack4.pop$com$bulletphysics$linearmath$Transform();
            $Stack4.pop$com$bulletphysics$extras$gimpact$BoxCollision$AABB();
            $Stack4.pop$javax$vecmath$Vector3f();
            $Stack4.pop$javax$vecmath$Vector4f();
            return;
        }
        catch (Throwable throwable) {
            $Stack $Stack5 = $Stack;
            $Stack5.pop$com$bulletphysics$linearmath$Transform();
            $Stack5.pop$com$bulletphysics$extras$gimpact$BoxCollision$AABB();
            $Stack5.pop$javax$vecmath$Vector3f();
            $Stack5.pop$javax$vecmath$Vector4f();
            throw throwable;
        }
    }

    public void setFace0(int value) {
        this.triface0 = value;
    }

    public int getFace0() {
        return this.triface0;
    }

    public void setFace1(int value) {
        this.triface1 = value;
    }

    public int getFace1() {
        return this.triface1;
    }

    public void setPart0(int value) {
        this.part0 = value;
    }

    public int getPart0() {
        return this.part0;
    }

    public void setPart1(int value) {
        this.part1 = value;
    }

    public int getPart1() {
        return this.part1;
    }

    @Override
    public float calculateTimeOfImpact(CollisionObject body0, CollisionObject body1, DispatcherInfo dispatchInfo, ManifoldResult resultOut) {
        return 1.0f;
    }

    @Override
    public void getAllContactManifolds(ObjectArrayList<PersistentManifold> manifoldArray) {
        if (this.manifoldPtr != null) {
            manifoldArray.add(this.manifoldPtr);
        }
    }

    public static void registerAlgorithm(CollisionDispatcher dispatcher) {
        int i;
        CreateFunc createFunc = new CreateFunc();
        for (i = 0; i < BroadphaseNativeType.MAX_BROADPHASE_COLLISION_TYPES.ordinal(); ++i) {
            dispatcher.registerCollisionCreateFunc(BroadphaseNativeType.GIMPACT_SHAPE_PROXYTYPE.ordinal(), i, createFunc);
        }
        for (i = 0; i < BroadphaseNativeType.MAX_BROADPHASE_COLLISION_TYPES.ordinal(); ++i) {
            dispatcher.registerCollisionCreateFunc(i, BroadphaseNativeType.GIMPACT_SHAPE_PROXYTYPE.ordinal(), createFunc);
        }
    }

    public static class CreateFunc
    extends CollisionAlgorithmCreateFunc {
        private final ObjectPool<GImpactCollisionAlgorithm> pool = ObjectPool.get(GImpactCollisionAlgorithm.class);

        @Override
        public CollisionAlgorithm createCollisionAlgorithm(CollisionAlgorithmConstructionInfo ci, CollisionObject body0, CollisionObject body1) {
            GImpactCollisionAlgorithm algo = this.pool.get();
            algo.init(ci, body0, body1);
            return algo;
        }

        @Override
        public void releaseCollisionAlgorithm(CollisionAlgorithm algo) {
            this.pool.release((GImpactCollisionAlgorithm)algo);
        }
    }
}

