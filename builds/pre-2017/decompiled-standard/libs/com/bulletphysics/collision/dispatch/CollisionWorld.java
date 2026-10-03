/*
 * Decompiled with CFR 0.152.
 */
package com.bulletphysics.collision.dispatch;

import com.bulletphysics.$Stack;
import com.bulletphysics.BulletGlobals;
import com.bulletphysics.BulletStats;
import com.bulletphysics.collision.broadphase.BroadphaseInterface;
import com.bulletphysics.collision.broadphase.BroadphaseNativeType;
import com.bulletphysics.collision.broadphase.BroadphaseProxy;
import com.bulletphysics.collision.broadphase.Dispatcher;
import com.bulletphysics.collision.broadphase.DispatcherInfo;
import com.bulletphysics.collision.broadphase.OverlappingPairCache;
import com.bulletphysics.collision.dispatch.CollisionConfiguration;
import com.bulletphysics.collision.dispatch.CollisionObject;
import com.bulletphysics.collision.narrowphase.ConvexCast;
import com.bulletphysics.collision.narrowphase.GjkConvexCast;
import com.bulletphysics.collision.narrowphase.GjkEpaPenetrationDepthSolver;
import com.bulletphysics.collision.narrowphase.SubsimplexConvexCast;
import com.bulletphysics.collision.narrowphase.TriangleConvexcastCallback;
import com.bulletphysics.collision.narrowphase.TriangleRaycastCallback;
import com.bulletphysics.collision.narrowphase.VoronoiSimplexSolver;
import com.bulletphysics.collision.shapes.BvhTriangleMeshShape;
import com.bulletphysics.collision.shapes.CollisionShape;
import com.bulletphysics.collision.shapes.CompoundShape;
import com.bulletphysics.collision.shapes.ConcaveShape;
import com.bulletphysics.collision.shapes.ConvexShape;
import com.bulletphysics.collision.shapes.SphereShape;
import com.bulletphysics.collision.shapes.TriangleMeshShape;
import com.bulletphysics.linearmath.AabbUtil2;
import com.bulletphysics.linearmath.IDebugDraw;
import com.bulletphysics.linearmath.Transform;
import com.bulletphysics.linearmath.TransformUtil;
import com.bulletphysics.linearmath.VectorUtil;
import com.bulletphysics.util.ObjectArrayList;
import javax.vecmath.Matrix3f;
import javax.vecmath.Tuple3f;
import javax.vecmath.Vector3f;

public class CollisionWorld {
    protected ObjectArrayList<CollisionObject> collisionObjects = new ObjectArrayList();
    protected Dispatcher dispatcher1;
    protected DispatcherInfo dispatchInfo = new DispatcherInfo();
    protected BroadphaseInterface broadphasePairCache;
    protected IDebugDraw debugDrawer;
    private static boolean updateAabbs_reportMe = true;

    public CollisionWorld(Dispatcher dispatcher, BroadphaseInterface broadphasePairCache, CollisionConfiguration collisionConfiguration) {
        this.dispatcher1 = dispatcher;
        this.broadphasePairCache = broadphasePairCache;
    }

    public void destroy() {
        for (int i = 0; i < this.collisionObjects.size(); ++i) {
            CollisionObject collisionObject = this.collisionObjects.getQuick(i);
            BroadphaseProxy bp = collisionObject.getBroadphaseHandle();
            if (bp == null) continue;
            this.getBroadphase().getOverlappingPairCache().cleanProxyFromPairs(bp, this.dispatcher1);
            this.getBroadphase().destroyProxy(bp, this.dispatcher1);
        }
    }

    public void addCollisionObject(CollisionObject collisionObject) {
        this.addCollisionObject(collisionObject, (short)1, (short)-1);
    }

    /*
     * WARNING - void declaration
     */
    public void addCollisionObject(CollisionObject collisionObject, short s, short s2) {
        $Stack $Stack = $Stack.get();
        try {
            void collisionFilterMask;
            void collisionFilterGroup;
            void collisionObject2;
            $Stack $Stack2 = $Stack;
            $Stack2.push$com$bulletphysics$linearmath$Transform();
            $Stack2.push$javax$vecmath$Vector3f();
            assert (!this.collisionObjects.contains(collisionObject2));
            this.collisionObjects.add((CollisionObject)collisionObject2);
            Transform trans = collisionObject2.getWorldTransform($Stack.get$com$bulletphysics$linearmath$Transform());
            Vector3f minAabb = $Stack.get$javax$vecmath$Vector3f();
            Vector3f maxAabb = $Stack.get$javax$vecmath$Vector3f();
            collisionObject2.getCollisionShape().getAabb(trans, minAabb, maxAabb);
            BroadphaseNativeType type2 = collisionObject2.getCollisionShape().getShapeType();
            collisionObject2.setBroadphaseHandle(this.getBroadphase().createProxy(minAabb, maxAabb, type2, collisionObject2, (short)collisionFilterGroup, (short)collisionFilterMask, this.dispatcher1, null));
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

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void performDiscreteCollisionDetection() {
        BulletStats.pushProfile("performDiscreteCollisionDetection");
        try {
            this.updateAabbs();
            BulletStats.pushProfile("calculateOverlappingPairs");
            try {
                this.broadphasePairCache.calculateOverlappingPairs(this.dispatcher1);
            }
            finally {
                BulletStats.popProfile();
            }
            Dispatcher dispatcher = this.getDispatcher();
            BulletStats.pushProfile("dispatchAllCollisionPairs");
            try {
                if (dispatcher != null) {
                    dispatcher.dispatchAllCollisionPairs(this.broadphasePairCache.getOverlappingPairCache(), this.dispatchInfo, this.dispatcher1);
                }
            }
            finally {
                BulletStats.popProfile();
            }
        }
        finally {
            BulletStats.popProfile();
        }
    }

    public void removeCollisionObject(CollisionObject collisionObject) {
        BroadphaseProxy bp = collisionObject.getBroadphaseHandle();
        if (bp != null) {
            this.getBroadphase().getOverlappingPairCache().cleanProxyFromPairs(bp, this.dispatcher1);
            this.getBroadphase().destroyProxy(bp, this.dispatcher1);
            collisionObject.setBroadphaseHandle(null);
        }
        this.collisionObjects.remove(collisionObject);
    }

    public void setBroadphase(BroadphaseInterface pairCache) {
        this.broadphasePairCache = pairCache;
    }

    public BroadphaseInterface getBroadphase() {
        return this.broadphasePairCache;
    }

    public OverlappingPairCache getPairCache() {
        return this.broadphasePairCache.getOverlappingPairCache();
    }

    public Dispatcher getDispatcher() {
        return this.dispatcher1;
    }

    public DispatcherInfo getDispatchInfo() {
        return this.dispatchInfo;
    }

    /*
     * WARNING - void declaration
     */
    public void updateSingleAabb(CollisionObject collisionObject) {
        $Stack $Stack = $Stack.get();
        try {
            void colObj;
            $Stack $Stack2 = $Stack;
            $Stack2.push$com$bulletphysics$linearmath$Transform();
            $Stack2.push$javax$vecmath$Vector3f();
            Vector3f minAabb = $Stack.get$javax$vecmath$Vector3f();
            Vector3f maxAabb = $Stack.get$javax$vecmath$Vector3f();
            Vector3f tmp = $Stack.get$javax$vecmath$Vector3f();
            Transform tmpTrans = $Stack.get$com$bulletphysics$linearmath$Transform();
            colObj.getCollisionShape().getAabb(colObj.getWorldTransform(tmpTrans), minAabb, maxAabb);
            Vector3f contactThreshold = $Stack.get$javax$vecmath$Vector3f();
            contactThreshold.set(BulletGlobals.getContactBreakingThreshold(), BulletGlobals.getContactBreakingThreshold(), BulletGlobals.getContactBreakingThreshold());
            minAabb.sub(contactThreshold);
            maxAabb.add(contactThreshold);
            BroadphaseInterface bp = this.broadphasePairCache;
            tmp.sub(maxAabb, minAabb);
            if (colObj.isStaticObject() || tmp.lengthSquared() < 1.0E12f) {
                bp.setAabb(colObj.getBroadphaseHandle(), minAabb, maxAabb, this.dispatcher1);
            } else {
                colObj.setActivationState(5);
                if (updateAabbs_reportMe && this.debugDrawer != null) {
                    updateAabbs_reportMe = false;
                    this.debugDrawer.reportErrorWarning("Overflow in AABB, object removed from simulation");
                    this.debugDrawer.reportErrorWarning("If you can reproduce this, please email bugs@continuousphysics.com\n");
                    this.debugDrawer.reportErrorWarning("Please include above information, your Platform, version of OS.\n");
                    this.debugDrawer.reportErrorWarning("Thanks.\n");
                }
            }
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

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void updateAabbs() {
        BulletStats.pushProfile("updateAabbs");
        try {
            for (int i = 0; i < this.collisionObjects.size(); ++i) {
                CollisionObject colObj = this.collisionObjects.getQuick(i);
                if (!colObj.isActive()) continue;
                this.updateSingleAabb(colObj);
            }
        }
        finally {
            BulletStats.popProfile();
        }
    }

    public IDebugDraw getDebugDrawer() {
        return this.debugDrawer;
    }

    public void setDebugDrawer(IDebugDraw debugDrawer) {
        this.debugDrawer = debugDrawer;
    }

    public int getNumCollisionObjects() {
        return this.collisionObjects.size();
    }

    /*
     * WARNING - void declaration
     */
    public static void rayTestSingle(Transform transform, Transform transform2, CollisionObject collisionObject, CollisionShape collisionShape, Transform transform3, RayResultCallback rayResultCallback) {
        $Stack $Stack = $Stack.get();
        try {
            void collisionObject2;
            void colObjWorldTransform;
            void rayToTrans;
            Transform rayFromTrans;
            void resultCallback;
            void collisionShape2;
            $Stack $Stack2 = $Stack;
            $Stack2.push$com$bulletphysics$linearmath$Transform();
            $Stack2.push$javax$vecmath$Vector3f();
            SphereShape pointShape = new SphereShape(0.0f);
            pointShape.setMargin(0.0f);
            SphereShape castShape = pointShape;
            if (collisionShape2.isConvex()) {
                ConvexCast.CastResult castResult = new ConvexCast.CastResult();
                castResult.fraction = resultCallback.closestHitFraction;
                ConvexShape convexShape = (ConvexShape)collisionShape2;
                VoronoiSimplexSolver simplexSolver = new VoronoiSimplexSolver();
                SubsimplexConvexCast convexCaster = new SubsimplexConvexCast(castShape, convexShape, simplexSolver);
                if (convexCaster.calcTimeOfImpact(rayFromTrans, (Transform)rayToTrans, (Transform)colObjWorldTransform, (Transform)colObjWorldTransform, castResult) && castResult.normal.lengthSquared() > 1.0E-4f && castResult.fraction < resultCallback.closestHitFraction) {
                    rayFromTrans.basis.transform(castResult.normal);
                    castResult.normal.normalize();
                    LocalRayResult localRayResult = new LocalRayResult((CollisionObject)collisionObject2, null, castResult.normal, castResult.fraction);
                    boolean normalInWorldSpace = true;
                    resultCallback.addSingleResult(localRayResult, normalInWorldSpace);
                }
            } else if (collisionShape2.isConcave()) {
                if (collisionShape2.getShapeType() == BroadphaseNativeType.TRIANGLE_MESH_SHAPE_PROXYTYPE) {
                    BvhTriangleMeshShape triangleMesh = (BvhTriangleMeshShape)collisionShape2;
                    Transform worldTocollisionObject = $Stack.get$com$bulletphysics$linearmath$Transform();
                    worldTocollisionObject.inverse((Transform)colObjWorldTransform);
                    Vector3f rayFromLocal = $Stack.get$javax$vecmath$Vector3f(rayFromTrans.origin);
                    worldTocollisionObject.transform(rayFromLocal);
                    Vector3f rayToLocal = $Stack.get$javax$vecmath$Vector3f(rayToTrans.origin);
                    worldTocollisionObject.transform(rayToLocal);
                    BridgeTriangleRaycastCallback rcb = new BridgeTriangleRaycastCallback(rayFromLocal, rayToLocal, (RayResultCallback)resultCallback, (CollisionObject)collisionObject2, triangleMesh);
                    rcb.hitFraction = resultCallback.closestHitFraction;
                    triangleMesh.performRaycast(rcb, rayFromLocal, rayToLocal);
                } else {
                    ConcaveShape triangleMesh = (ConcaveShape)collisionShape2;
                    Transform worldTocollisionObject = $Stack.get$com$bulletphysics$linearmath$Transform();
                    worldTocollisionObject.inverse((Transform)colObjWorldTransform);
                    Vector3f rayFromLocal = $Stack.get$javax$vecmath$Vector3f(rayFromTrans.origin);
                    worldTocollisionObject.transform(rayFromLocal);
                    Vector3f rayToLocal = $Stack.get$javax$vecmath$Vector3f(rayToTrans.origin);
                    worldTocollisionObject.transform(rayToLocal);
                    BridgeTriangleRaycastCallback rcb = new BridgeTriangleRaycastCallback(rayFromLocal, rayToLocal, (RayResultCallback)resultCallback, (CollisionObject)collisionObject2, triangleMesh);
                    rcb.hitFraction = resultCallback.closestHitFraction;
                    Vector3f rayAabbMinLocal = $Stack.get$javax$vecmath$Vector3f(rayFromLocal);
                    VectorUtil.setMin(rayAabbMinLocal, rayToLocal);
                    Vector3f rayAabbMaxLocal = $Stack.get$javax$vecmath$Vector3f(rayFromLocal);
                    VectorUtil.setMax(rayAabbMaxLocal, rayToLocal);
                    triangleMesh.processAllTriangles(rcb, rayAabbMinLocal, rayAabbMaxLocal);
                }
            } else if (collisionShape2.isCompound()) {
                CompoundShape compoundShape = (CompoundShape)collisionShape2;
                int i = 0;
                Transform childTrans = $Stack.get$com$bulletphysics$linearmath$Transform();
                for (i = 0; i < compoundShape.getNumChildShapes(); ++i) {
                    compoundShape.getChildTransform(i, childTrans);
                    CollisionShape childCollisionShape = compoundShape.getChildShape(i);
                    Transform childWorldTrans = $Stack.get$com$bulletphysics$linearmath$Transform((Transform)colObjWorldTransform);
                    childWorldTrans.mul(childTrans);
                    CollisionShape saveCollisionShape = collisionObject2.getCollisionShape();
                    collisionObject2.internalSetTemporaryCollisionShape(childCollisionShape);
                    CollisionWorld.rayTestSingle(rayFromTrans, (Transform)rayToTrans, (CollisionObject)collisionObject2, childCollisionShape, childWorldTrans, (RayResultCallback)resultCallback);
                    collisionObject2.internalSetTemporaryCollisionShape(saveCollisionShape);
                }
            }
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

    /*
     * WARNING - void declaration
     */
    public static void objectQuerySingle(ConvexShape convexShape, Transform transform, Transform transform2, CollisionObject collisionObject, CollisionShape collisionShape, Transform transform3, ConvexResultCallback convexResultCallback, float f) {
        $Stack $Stack = $Stack.get();
        try {
            void collisionObject2;
            void resultCallback;
            void colObjWorldTransform;
            void convexToTrans;
            void convexFromTrans;
            ConvexShape castShape;
            void allowedPenetration;
            void collisionShape2;
            $Stack $Stack2 = $Stack;
            $Stack2.push$com$bulletphysics$linearmath$Transform();
            $Stack2.push$javax$vecmath$Vector3f();
            $Stack2.push$javax$vecmath$Matrix3f();
            if (collisionShape2.isConvex()) {
                ConvexCast.CastResult castResult = new ConvexCast.CastResult();
                castResult.allowedPenetration = allowedPenetration;
                castResult.fraction = 1.0f;
                ConvexShape convexShape2 = (ConvexShape)collisionShape2;
                VoronoiSimplexSolver simplexSolver = new VoronoiSimplexSolver();
                GjkEpaPenetrationDepthSolver gjkEpaPenetrationSolver = new GjkEpaPenetrationDepthSolver();
                GjkConvexCast convexCaster2 = new GjkConvexCast(castShape, convexShape2, simplexSolver);
                GjkConvexCast castPtr = convexCaster2;
                if (((ConvexCast)castPtr).calcTimeOfImpact((Transform)convexFromTrans, (Transform)convexToTrans, (Transform)colObjWorldTransform, (Transform)colObjWorldTransform, castResult) && castResult.normal.lengthSquared() > 1.0E-4f && castResult.fraction < resultCallback.closestHitFraction) {
                    castResult.normal.normalize();
                    LocalConvexResult localConvexResult = new LocalConvexResult((CollisionObject)collisionObject2, null, castResult.normal, castResult.hitPoint, castResult.fraction);
                    boolean normalInWorldSpace = true;
                    resultCallback.addSingleResult(localConvexResult, normalInWorldSpace);
                }
            } else if (collisionShape2.isConcave()) {
                if (collisionShape2.getShapeType() == BroadphaseNativeType.TRIANGLE_MESH_SHAPE_PROXYTYPE) {
                    BvhTriangleMeshShape triangleMesh = (BvhTriangleMeshShape)collisionShape2;
                    Transform worldTocollisionObject = $Stack.get$com$bulletphysics$linearmath$Transform();
                    worldTocollisionObject.inverse((Transform)colObjWorldTransform);
                    Vector3f convexFromLocal = $Stack.get$javax$vecmath$Vector3f();
                    convexFromLocal.set(convexFromTrans.origin);
                    worldTocollisionObject.transform(convexFromLocal);
                    Vector3f convexToLocal = $Stack.get$javax$vecmath$Vector3f();
                    convexToLocal.set(convexToTrans.origin);
                    worldTocollisionObject.transform(convexToLocal);
                    Transform rotationXform = $Stack.get$com$bulletphysics$linearmath$Transform();
                    Matrix3f tmpMat = $Stack.get$javax$vecmath$Matrix3f();
                    tmpMat.mul(worldTocollisionObject.basis, convexToTrans.basis);
                    rotationXform.set(tmpMat);
                    BridgeTriangleConvexcastCallback tccb = new BridgeTriangleConvexcastCallback(castShape, (Transform)convexFromTrans, (Transform)convexToTrans, (ConvexResultCallback)resultCallback, (CollisionObject)collisionObject2, triangleMesh, (Transform)colObjWorldTransform);
                    tccb.hitFraction = resultCallback.closestHitFraction;
                    tccb.normalInWorldSpace = true;
                    Vector3f boxMinLocal = $Stack.get$javax$vecmath$Vector3f();
                    Vector3f boxMaxLocal = $Stack.get$javax$vecmath$Vector3f();
                    castShape.getAabb(rotationXform, boxMinLocal, boxMaxLocal);
                    triangleMesh.performConvexcast(tccb, convexFromLocal, convexToLocal, boxMinLocal, boxMaxLocal);
                } else {
                    BvhTriangleMeshShape triangleMesh = (BvhTriangleMeshShape)collisionShape2;
                    Transform worldTocollisionObject = $Stack.get$com$bulletphysics$linearmath$Transform();
                    worldTocollisionObject.inverse((Transform)colObjWorldTransform);
                    Vector3f convexFromLocal = $Stack.get$javax$vecmath$Vector3f();
                    convexFromLocal.set(convexFromTrans.origin);
                    worldTocollisionObject.transform(convexFromLocal);
                    Vector3f convexToLocal = $Stack.get$javax$vecmath$Vector3f();
                    convexToLocal.set(convexToTrans.origin);
                    worldTocollisionObject.transform(convexToLocal);
                    Transform rotationXform = $Stack.get$com$bulletphysics$linearmath$Transform();
                    Matrix3f tmpMat = $Stack.get$javax$vecmath$Matrix3f();
                    tmpMat.mul(worldTocollisionObject.basis, convexToTrans.basis);
                    rotationXform.set(tmpMat);
                    BridgeTriangleConvexcastCallback tccb = new BridgeTriangleConvexcastCallback(castShape, (Transform)convexFromTrans, (Transform)convexToTrans, (ConvexResultCallback)resultCallback, (CollisionObject)collisionObject2, triangleMesh, (Transform)colObjWorldTransform);
                    tccb.hitFraction = resultCallback.closestHitFraction;
                    tccb.normalInWorldSpace = false;
                    Vector3f boxMinLocal = $Stack.get$javax$vecmath$Vector3f();
                    Vector3f boxMaxLocal = $Stack.get$javax$vecmath$Vector3f();
                    castShape.getAabb(rotationXform, boxMinLocal, boxMaxLocal);
                    Vector3f rayAabbMinLocal = $Stack.get$javax$vecmath$Vector3f(convexFromLocal);
                    VectorUtil.setMin(rayAabbMinLocal, convexToLocal);
                    Vector3f rayAabbMaxLocal = $Stack.get$javax$vecmath$Vector3f(convexFromLocal);
                    VectorUtil.setMax(rayAabbMaxLocal, convexToLocal);
                    rayAabbMinLocal.add(boxMinLocal);
                    rayAabbMaxLocal.add(boxMaxLocal);
                    triangleMesh.processAllTriangles(tccb, rayAabbMinLocal, rayAabbMaxLocal);
                }
            } else if (collisionShape2.isCompound()) {
                CompoundShape compoundShape = (CompoundShape)collisionShape2;
                for (int i = 0; i < compoundShape.getNumChildShapes(); ++i) {
                    Transform childTrans = compoundShape.getChildTransform(i, $Stack.get$com$bulletphysics$linearmath$Transform());
                    CollisionShape childCollisionShape = compoundShape.getChildShape(i);
                    Transform childWorldTrans = $Stack.get$com$bulletphysics$linearmath$Transform();
                    childWorldTrans.mul((Transform)colObjWorldTransform, childTrans);
                    CollisionShape saveCollisionShape = collisionObject2.getCollisionShape();
                    collisionObject2.internalSetTemporaryCollisionShape(childCollisionShape);
                    CollisionWorld.objectQuerySingle(castShape, (Transform)convexFromTrans, (Transform)convexToTrans, (CollisionObject)collisionObject2, childCollisionShape, childWorldTrans, (ConvexResultCallback)resultCallback, (float)allowedPenetration);
                    collisionObject2.internalSetTemporaryCollisionShape(saveCollisionShape);
                }
            }
            $Stack $Stack3 = $Stack;
            $Stack3.pop$com$bulletphysics$linearmath$Transform();
            $Stack3.pop$javax$vecmath$Vector3f();
            $Stack3.pop$javax$vecmath$Matrix3f();
            return;
        }
        catch (Throwable throwable) {
            $Stack $Stack4 = $Stack;
            $Stack4.pop$com$bulletphysics$linearmath$Transform();
            $Stack4.pop$javax$vecmath$Vector3f();
            $Stack4.pop$javax$vecmath$Matrix3f();
            throw throwable;
        }
    }

    /*
     * WARNING - void declaration
     */
    public void rayTest(Vector3f vector3f, Vector3f vector3f2, RayResultCallback rayResultCallback) {
        $Stack $Stack = $Stack.get();
        try {
            void resultCallback;
            void rayToWorld;
            void rayFromWorld;
            $Stack $Stack2 = $Stack;
            $Stack2.push$com$bulletphysics$linearmath$Transform();
            $Stack2.push$javax$vecmath$Vector3f();
            Transform rayFromTrans = $Stack.get$com$bulletphysics$linearmath$Transform();
            Transform rayToTrans = $Stack.get$com$bulletphysics$linearmath$Transform();
            rayFromTrans.setIdentity();
            rayFromTrans.origin.set((Tuple3f)rayFromWorld);
            rayToTrans.setIdentity();
            rayToTrans.origin.set((Tuple3f)rayToWorld);
            Vector3f collisionObjectAabbMin = $Stack.get$javax$vecmath$Vector3f();
            Vector3f collisionObjectAabbMax = $Stack.get$javax$vecmath$Vector3f();
            float[] hitLambda = new float[1];
            Transform tmpTrans = $Stack.get$com$bulletphysics$linearmath$Transform();
            for (int i = 0; i < this.collisionObjects.size() && resultCallback.closestHitFraction != 0.0f; ++i) {
                CollisionObject collisionObject = this.collisionObjects.getQuick(i);
                if (!resultCallback.needsCollision(collisionObject.getBroadphaseHandle())) continue;
                collisionObject.getCollisionShape().getAabb(collisionObject.getWorldTransform(tmpTrans), collisionObjectAabbMin, collisionObjectAabbMax);
                hitLambda[0] = resultCallback.closestHitFraction;
                Vector3f hitNormal = $Stack.get$javax$vecmath$Vector3f();
                if (!AabbUtil2.rayAabb((Vector3f)rayFromWorld, (Vector3f)rayToWorld, collisionObjectAabbMin, collisionObjectAabbMax, hitLambda, hitNormal)) continue;
                CollisionWorld.rayTestSingle(rayFromTrans, rayToTrans, collisionObject, collisionObject.getCollisionShape(), collisionObject.getWorldTransform(tmpTrans), (RayResultCallback)resultCallback);
            }
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

    /*
     * WARNING - void declaration
     */
    public void convexSweepTest(ConvexShape convexShape, Transform transform, Transform transform2, ConvexResultCallback convexResultCallback) {
        $Stack $Stack = $Stack.get();
        try {
            void castShape;
            void convexToWorld;
            void convexFromWorld;
            $Stack $Stack2 = $Stack;
            $Stack2.push$com$bulletphysics$linearmath$Transform();
            $Stack2.push$javax$vecmath$Vector3f();
            $Stack2.push$javax$vecmath$Quat4f();
            Transform convexFromTrans = $Stack.get$com$bulletphysics$linearmath$Transform();
            Transform convexToTrans = $Stack.get$com$bulletphysics$linearmath$Transform();
            convexFromTrans.set((Transform)convexFromWorld);
            convexToTrans.set((Transform)convexToWorld);
            Vector3f castShapeAabbMin = $Stack.get$javax$vecmath$Vector3f();
            Vector3f castShapeAabbMax = $Stack.get$javax$vecmath$Vector3f();
            Vector3f linVel = $Stack.get$javax$vecmath$Vector3f();
            Vector3f angVel = $Stack.get$javax$vecmath$Vector3f();
            TransformUtil.calculateVelocity(convexFromTrans, convexToTrans, 1.0f, linVel, angVel);
            Transform R = $Stack.get$com$bulletphysics$linearmath$Transform();
            R.setIdentity();
            R.setRotation(convexFromTrans.getRotation($Stack.get$javax$vecmath$Quat4f()));
            castShape.calculateTemporalAabb(R, linVel, angVel, 1.0f, castShapeAabbMin, castShapeAabbMax);
            Transform tmpTrans = $Stack.get$com$bulletphysics$linearmath$Transform();
            Vector3f collisionObjectAabbMin = $Stack.get$javax$vecmath$Vector3f();
            Vector3f collisionObjectAabbMax = $Stack.get$javax$vecmath$Vector3f();
            float[] hitLambda = new float[1];
            for (int i = 0; i < this.collisionObjects.size(); ++i) {
                void resultCallback;
                CollisionObject collisionObject = this.collisionObjects.getQuick(i);
                if (!resultCallback.needsCollision(collisionObject.getBroadphaseHandle())) continue;
                collisionObject.getWorldTransform(tmpTrans);
                collisionObject.getCollisionShape().getAabb(tmpTrans, collisionObjectAabbMin, collisionObjectAabbMax);
                AabbUtil2.aabbExpand(collisionObjectAabbMin, collisionObjectAabbMax, castShapeAabbMin, castShapeAabbMax);
                hitLambda[0] = 1.0f;
                Vector3f hitNormal = $Stack.get$javax$vecmath$Vector3f();
                if (!AabbUtil2.rayAabb(convexFromWorld.origin, convexToWorld.origin, collisionObjectAabbMin, collisionObjectAabbMax, hitLambda, hitNormal)) continue;
                CollisionWorld.objectQuerySingle((ConvexShape)castShape, convexFromTrans, convexToTrans, collisionObject, collisionObject.getCollisionShape(), tmpTrans, (ConvexResultCallback)resultCallback, this.getDispatchInfo().allowedCcdPenetration);
            }
            $Stack $Stack3 = $Stack;
            $Stack3.pop$com$bulletphysics$linearmath$Transform();
            $Stack3.pop$javax$vecmath$Vector3f();
            $Stack3.pop$javax$vecmath$Quat4f();
            return;
        }
        catch (Throwable throwable) {
            $Stack $Stack4 = $Stack;
            $Stack4.pop$com$bulletphysics$linearmath$Transform();
            $Stack4.pop$javax$vecmath$Vector3f();
            $Stack4.pop$javax$vecmath$Quat4f();
            throw throwable;
        }
    }

    public ObjectArrayList<CollisionObject> getCollisionObjectArray() {
        return this.collisionObjects;
    }

    private static class BridgeTriangleRaycastCallback
    extends TriangleRaycastCallback {
        public RayResultCallback resultCallback;
        public CollisionObject collisionObject;
        public ConcaveShape triangleMesh;

        public BridgeTriangleRaycastCallback(Vector3f from, Vector3f to, RayResultCallback resultCallback, CollisionObject collisionObject, ConcaveShape triangleMesh) {
            super(from, to);
            this.resultCallback = resultCallback;
            this.collisionObject = collisionObject;
            this.triangleMesh = triangleMesh;
        }

        @Override
        public float reportHit(Vector3f hitNormalLocal, float hitFraction, int partId, int triangleIndex) {
            LocalShapeInfo shapeInfo = new LocalShapeInfo();
            shapeInfo.shapePart = partId;
            shapeInfo.triangleIndex = triangleIndex;
            LocalRayResult rayResult = new LocalRayResult(this.collisionObject, shapeInfo, hitNormalLocal, hitFraction);
            boolean normalInWorldSpace = false;
            return this.resultCallback.addSingleResult(rayResult, normalInWorldSpace);
        }
    }

    public static class ClosestConvexResultCallback
    extends ConvexResultCallback {
        public final Vector3f convexFromWorld = new Vector3f();
        public final Vector3f convexToWorld = new Vector3f();
        public final Vector3f hitNormalWorld = new Vector3f();
        public final Vector3f hitPointWorld = new Vector3f();
        public CollisionObject hitCollisionObject;

        public ClosestConvexResultCallback(Vector3f convexFromWorld, Vector3f convexToWorld) {
            this.convexFromWorld.set(convexFromWorld);
            this.convexToWorld.set(convexToWorld);
            this.hitCollisionObject = null;
        }

        /*
         * WARNING - void declaration
         */
        @Override
        public float addSingleResult(LocalConvexResult localConvexResult, boolean bl) {
            $Stack $Stack = $Stack.get();
            try {
                void normalInWorldSpace;
                void convexResult;
                $Stack.push$com$bulletphysics$linearmath$Transform();
                assert (convexResult.hitFraction <= this.closestHitFraction);
                this.closestHitFraction = convexResult.hitFraction;
                this.hitCollisionObject = convexResult.hitCollisionObject;
                if (normalInWorldSpace != false) {
                    this.hitNormalWorld.set(convexResult.hitNormalLocal);
                    if (this.hitNormalWorld.length() > 2.0f) {
                        System.out.println("CollisionWorld.addSingleResult world " + this.hitNormalWorld);
                    }
                } else {
                    this.hitNormalWorld.set(convexResult.hitNormalLocal);
                    this.hitCollisionObject.getWorldTransform((Transform)$Stack.get$com$bulletphysics$linearmath$Transform()).basis.transform(this.hitNormalWorld);
                    if (this.hitNormalWorld.length() > 2.0f) {
                        System.out.println("CollisionWorld.addSingleResult world " + this.hitNormalWorld);
                    }
                }
                this.hitPointWorld.set(convexResult.hitPointLocal);
                float f = convexResult.hitFraction;
                $Stack.pop$com$bulletphysics$linearmath$Transform();
                return f;
            }
            catch (Throwable throwable) {
                $Stack.pop$com$bulletphysics$linearmath$Transform();
                throw throwable;
            }
        }
    }

    public static abstract class ConvexResultCallback {
        public float closestHitFraction = 1.0f;
        public short collisionFilterGroup = 1;
        public short collisionFilterMask = (short)-1;

        public boolean hasHit() {
            return this.closestHitFraction < 1.0f;
        }

        public boolean needsCollision(BroadphaseProxy proxy0) {
            boolean collides = (proxy0.collisionFilterGroup & this.collisionFilterMask & 0xFFFF) != 0;
            collides = collides && (this.collisionFilterGroup & proxy0.collisionFilterMask & 0xFFFF) != 0;
            return collides;
        }

        public abstract float addSingleResult(LocalConvexResult var1, boolean var2);
    }

    public static class LocalConvexResult {
        public CollisionObject hitCollisionObject;
        public LocalShapeInfo localShapeInfo;
        public final Vector3f hitNormalLocal = new Vector3f();
        public final Vector3f hitPointLocal = new Vector3f();
        public float hitFraction;

        public LocalConvexResult(CollisionObject hitCollisionObject, LocalShapeInfo localShapeInfo, Vector3f hitNormalLocal, Vector3f hitPointLocal, float hitFraction) {
            this.hitCollisionObject = hitCollisionObject;
            this.localShapeInfo = localShapeInfo;
            this.hitNormalLocal.set(hitNormalLocal);
            this.hitPointLocal.set(hitPointLocal);
            this.hitFraction = hitFraction;
        }
    }

    public static class ClosestRayResultCallback
    extends RayResultCallback {
        public final Vector3f rayFromWorld = new Vector3f();
        public final Vector3f rayToWorld = new Vector3f();
        public final Vector3f hitNormalWorld = new Vector3f();
        public final Vector3f hitPointWorld = new Vector3f();

        public ClosestRayResultCallback(Vector3f rayFromWorld, Vector3f rayToWorld) {
            this.rayFromWorld.set(rayFromWorld);
            this.rayToWorld.set(rayToWorld);
        }

        /*
         * WARNING - void declaration
         */
        @Override
        public float addSingleResult(LocalRayResult localRayResult, boolean bl) {
            $Stack $Stack = $Stack.get();
            try {
                void normalInWorldSpace;
                void rayResult;
                $Stack.push$com$bulletphysics$linearmath$Transform();
                assert (rayResult.hitFraction <= this.closestHitFraction);
                this.closestHitFraction = rayResult.hitFraction;
                this.collisionObject = rayResult.collisionObject;
                if (normalInWorldSpace != false) {
                    this.hitNormalWorld.set(rayResult.hitNormalLocal);
                } else {
                    this.hitNormalWorld.set(rayResult.hitNormalLocal);
                    this.collisionObject.getWorldTransform((Transform)$Stack.get$com$bulletphysics$linearmath$Transform()).basis.transform(this.hitNormalWorld);
                }
                VectorUtil.setInterpolate3(this.hitPointWorld, this.rayFromWorld, this.rayToWorld, rayResult.hitFraction);
                float f = rayResult.hitFraction;
                $Stack.pop$com$bulletphysics$linearmath$Transform();
                return f;
            }
            catch (Throwable throwable) {
                $Stack.pop$com$bulletphysics$linearmath$Transform();
                throw throwable;
            }
        }
    }

    public static abstract class RayResultCallback {
        public float closestHitFraction = 1.0f;
        public CollisionObject collisionObject;
        public short collisionFilterGroup = 1;
        public short collisionFilterMask = (short)-1;

        public boolean hasHit() {
            return this.collisionObject != null;
        }

        public boolean needsCollision(BroadphaseProxy proxy0) {
            boolean collides = (proxy0.collisionFilterGroup & this.collisionFilterMask & 0xFFFF) != 0;
            collides = collides && (this.collisionFilterGroup & proxy0.collisionFilterMask & 0xFFFF) != 0;
            return collides;
        }

        public abstract float addSingleResult(LocalRayResult var1, boolean var2);
    }

    public static class LocalRayResult {
        public CollisionObject collisionObject;
        public LocalShapeInfo localShapeInfo;
        public final Vector3f hitNormalLocal = new Vector3f();
        public float hitFraction;

        public LocalRayResult(CollisionObject collisionObject, LocalShapeInfo localShapeInfo, Vector3f hitNormalLocal, float hitFraction) {
            this.collisionObject = collisionObject;
            this.localShapeInfo = localShapeInfo;
            this.hitNormalLocal.set(hitNormalLocal);
            this.hitFraction = hitFraction;
        }
    }

    public static class LocalShapeInfo {
        public int shapePart;
        public int triangleIndex;
    }

    private static class BridgeTriangleConvexcastCallback
    extends TriangleConvexcastCallback {
        public ConvexResultCallback resultCallback;
        public CollisionObject collisionObject;
        public TriangleMeshShape triangleMesh;
        public boolean normalInWorldSpace;

        public BridgeTriangleConvexcastCallback(ConvexShape castShape, Transform from, Transform to, ConvexResultCallback resultCallback, CollisionObject collisionObject, TriangleMeshShape triangleMesh, Transform triangleToWorld) {
            super(castShape, from, to, triangleToWorld, triangleMesh.getMargin());
            this.resultCallback = resultCallback;
            this.collisionObject = collisionObject;
            this.triangleMesh = triangleMesh;
        }

        @Override
        public float reportHit(Vector3f hitNormalLocal, Vector3f hitPointLocal, float hitFraction, int partId, int triangleIndex) {
            LocalShapeInfo shapeInfo = new LocalShapeInfo();
            shapeInfo.shapePart = partId;
            shapeInfo.triangleIndex = triangleIndex;
            if (hitFraction <= this.resultCallback.closestHitFraction) {
                LocalConvexResult convexResult = new LocalConvexResult(this.collisionObject, shapeInfo, hitNormalLocal, hitPointLocal, hitFraction);
                return this.resultCallback.addSingleResult(convexResult, this.normalInWorldSpace);
            }
            return hitFraction;
        }
    }
}

