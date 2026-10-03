/*
 * Decompiled with CFR 0.152.
 */
package com.bulletphysics.collision.narrowphase;

import com.bulletphysics.$Stack;
import com.bulletphysics.BulletGlobals;
import com.bulletphysics.collision.narrowphase.ManifoldPoint;
import com.bulletphysics.linearmath.Transform;
import com.bulletphysics.linearmath.VectorUtil;
import javax.vecmath.Vector3f;
import javax.vecmath.Vector4f;

public class PersistentManifold {
    public static final int MANIFOLD_CACHE_SIZE = 4;
    private final ManifoldPoint[] pointCache = new ManifoldPoint[4];
    private Object body0;
    private Object body1;
    private int cachedPoints;
    public int index1a;

    public PersistentManifold() {
        for (int i = 0; i < this.pointCache.length; ++i) {
            this.pointCache[i] = new ManifoldPoint();
        }
    }

    public PersistentManifold(Object body0, Object body1, int bla) {
        for (int i = 0; i < this.pointCache.length; ++i) {
            this.pointCache[i] = new ManifoldPoint();
        }
        this.init(body0, body1, bla);
    }

    public void init(Object body0, Object body1, int bla) {
        this.body0 = body0;
        this.body1 = body1;
        this.cachedPoints = 0;
        this.index1a = 0;
    }

    /*
     * WARNING - void declaration
     */
    private int sortCachedPoints(ManifoldPoint manifoldPoint) {
        $Stack $Stack = $Stack.get();
        try {
            Vector3f cross;
            void pt;
            $Stack $Stack2 = $Stack;
            $Stack2.push$javax$vecmath$Vector3f();
            $Stack2.push$javax$vecmath$Vector4f();
            int maxPenetrationIndex = -1;
            float maxPenetration = pt.getDistance();
            for (int i = 0; i < 4; ++i) {
                if (!(this.pointCache[i].getDistance() < maxPenetration)) continue;
                maxPenetrationIndex = i;
                maxPenetration = this.pointCache[i].getDistance();
            }
            float res0 = 0.0f;
            float res1 = 0.0f;
            float res2 = 0.0f;
            float res3 = 0.0f;
            if (maxPenetrationIndex != 0) {
                Vector3f a0 = $Stack.get$javax$vecmath$Vector3f(pt.localPointA);
                a0.sub(this.pointCache[1].localPointA);
                Vector3f b0 = $Stack.get$javax$vecmath$Vector3f(this.pointCache[3].localPointA);
                b0.sub(this.pointCache[2].localPointA);
                cross = $Stack.get$javax$vecmath$Vector3f();
                cross.cross(a0, b0);
                res0 = cross.lengthSquared();
            }
            if (maxPenetrationIndex != 1) {
                Vector3f a1 = $Stack.get$javax$vecmath$Vector3f(pt.localPointA);
                a1.sub(this.pointCache[0].localPointA);
                Vector3f b1 = $Stack.get$javax$vecmath$Vector3f(this.pointCache[3].localPointA);
                b1.sub(this.pointCache[2].localPointA);
                cross = $Stack.get$javax$vecmath$Vector3f();
                cross.cross(a1, b1);
                res1 = cross.lengthSquared();
            }
            if (maxPenetrationIndex != 2) {
                Vector3f a2 = $Stack.get$javax$vecmath$Vector3f(pt.localPointA);
                a2.sub(this.pointCache[0].localPointA);
                Vector3f b2 = $Stack.get$javax$vecmath$Vector3f(this.pointCache[3].localPointA);
                b2.sub(this.pointCache[1].localPointA);
                cross = $Stack.get$javax$vecmath$Vector3f();
                cross.cross(a2, b2);
                res2 = cross.lengthSquared();
            }
            if (maxPenetrationIndex != 3) {
                Vector3f a3 = $Stack.get$javax$vecmath$Vector3f(pt.localPointA);
                a3.sub(this.pointCache[0].localPointA);
                Vector3f b3 = $Stack.get$javax$vecmath$Vector3f(this.pointCache[2].localPointA);
                b3.sub(this.pointCache[1].localPointA);
                cross = $Stack.get$javax$vecmath$Vector3f();
                cross.cross(a3, b3);
                res3 = cross.lengthSquared();
            }
            Vector4f maxvec = $Stack.get$javax$vecmath$Vector4f();
            maxvec.set(res0, res1, res2, res3);
            int biggestarea = VectorUtil.closestAxis4(maxvec);
            $Stack $Stack3 = $Stack;
            $Stack3.pop$javax$vecmath$Vector3f();
            $Stack3.pop$javax$vecmath$Vector4f();
            return biggestarea;
        }
        catch (Throwable throwable) {
            $Stack $Stack4 = $Stack;
            $Stack4.pop$javax$vecmath$Vector3f();
            $Stack4.pop$javax$vecmath$Vector4f();
            throw throwable;
        }
    }

    public Object getBody0() {
        return this.body0;
    }

    public Object getBody1() {
        return this.body1;
    }

    public void setBodies(Object body0, Object body1) {
        this.body0 = body0;
        this.body1 = body1;
    }

    public void clearUserCache(ManifoldPoint pt) {
        Object oldPtr = pt.userPersistentData;
        if (oldPtr != null && pt.userPersistentData != null && BulletGlobals.getContactDestroyedCallback() != null) {
            BulletGlobals.getContactDestroyedCallback().contactDestroyed(pt.userPersistentData);
            pt.userPersistentData = null;
        }
    }

    public int getNumContacts() {
        return this.cachedPoints;
    }

    public ManifoldPoint getContactPoint(int index) {
        return this.pointCache[index];
    }

    public float getContactBreakingThreshold() {
        return BulletGlobals.getContactBreakingThreshold();
    }

    /*
     * WARNING - void declaration
     */
    public int getCacheEntry(ManifoldPoint manifoldPoint) {
        $Stack $Stack = $Stack.get();
        try {
            $Stack.push$javax$vecmath$Vector3f();
            float shortestDist = this.getContactBreakingThreshold() * this.getContactBreakingThreshold();
            int size = this.getNumContacts();
            int nearestPoint = -1;
            Vector3f diffA = $Stack.get$javax$vecmath$Vector3f();
            for (int i = 0; i < size; ++i) {
                void newPoint;
                ManifoldPoint mp = this.pointCache[i];
                diffA.sub(mp.localPointA, newPoint.localPointA);
                float distToManiPoint = diffA.dot(diffA);
                if (!(distToManiPoint < shortestDist)) continue;
                shortestDist = distToManiPoint;
                nearestPoint = i;
            }
            $Stack.pop$javax$vecmath$Vector3f();
            return nearestPoint;
        }
        catch (Throwable throwable) {
            $Stack.pop$javax$vecmath$Vector3f();
            throw throwable;
        }
    }

    public int addManifoldPoint(ManifoldPoint newPoint) {
        assert (this.validContactDistance(newPoint));
        int insertIndex = this.getNumContacts();
        if (insertIndex == 4) {
            insertIndex = this.sortCachedPoints(newPoint);
            this.clearUserCache(this.pointCache[insertIndex]);
        } else {
            ++this.cachedPoints;
        }
        assert (this.pointCache[insertIndex].userPersistentData == null);
        this.pointCache[insertIndex].set(newPoint);
        return insertIndex;
    }

    public void removeContactPoint(int index) {
        this.clearUserCache(this.pointCache[index]);
        int lastUsedIndex = this.getNumContacts() - 1;
        if (index != lastUsedIndex) {
            this.pointCache[index].set(this.pointCache[lastUsedIndex]);
            this.pointCache[lastUsedIndex].userPersistentData = null;
            this.pointCache[lastUsedIndex].appliedImpulse = 0.0f;
            this.pointCache[lastUsedIndex].lateralFrictionInitialized = false;
            this.pointCache[lastUsedIndex].appliedImpulseLateral1 = 0.0f;
            this.pointCache[lastUsedIndex].appliedImpulseLateral2 = 0.0f;
            this.pointCache[lastUsedIndex].lifeTime = 0;
        }
        assert (this.pointCache[lastUsedIndex].userPersistentData == null);
        --this.cachedPoints;
    }

    public void replaceContactPoint(ManifoldPoint newPoint, int insertIndex) {
        assert (this.validContactDistance(newPoint));
        int lifeTime = this.pointCache[insertIndex].getLifeTime();
        float appliedImpulse = this.pointCache[insertIndex].appliedImpulse;
        float appliedLateralImpulse1 = this.pointCache[insertIndex].appliedImpulseLateral1;
        float appliedLateralImpulse2 = this.pointCache[insertIndex].appliedImpulseLateral2;
        assert (lifeTime >= 0);
        Object cache = this.pointCache[insertIndex].userPersistentData;
        this.pointCache[insertIndex].set(newPoint);
        this.pointCache[insertIndex].userPersistentData = cache;
        this.pointCache[insertIndex].appliedImpulse = appliedImpulse;
        this.pointCache[insertIndex].appliedImpulseLateral1 = appliedLateralImpulse1;
        this.pointCache[insertIndex].appliedImpulseLateral2 = appliedLateralImpulse2;
        this.pointCache[insertIndex].lifeTime = lifeTime;
    }

    private boolean validContactDistance(ManifoldPoint pt) {
        return pt.distance1 <= this.getContactBreakingThreshold();
    }

    /*
     * WARNING - void declaration
     */
    public void refreshContactPoints(Transform transform, Transform transform2) {
        $Stack $Stack = $Stack.get();
        try {
            int i;
            $Stack.push$javax$vecmath$Vector3f();
            Vector3f tmp = $Stack.get$javax$vecmath$Vector3f();
            for (i = this.getNumContacts() - 1; i >= 0; --i) {
                void trB;
                void trA;
                ManifoldPoint manifoldPoint = this.pointCache[i];
                manifoldPoint.positionWorldOnA.set(manifoldPoint.localPointA);
                trA.transform(manifoldPoint.positionWorldOnA);
                manifoldPoint.positionWorldOnB.set(manifoldPoint.localPointB);
                trB.transform(manifoldPoint.positionWorldOnB);
                tmp.set(manifoldPoint.positionWorldOnA);
                tmp.sub(manifoldPoint.positionWorldOnB);
                manifoldPoint.distance1 = tmp.dot(manifoldPoint.normalWorldOnB);
                ++manifoldPoint.lifeTime;
            }
            Vector3f projectedDifference = $Stack.get$javax$vecmath$Vector3f();
            Vector3f projectedPoint = $Stack.get$javax$vecmath$Vector3f();
            for (i = this.getNumContacts() - 1; i >= 0; --i) {
                ManifoldPoint manifoldPoint = this.pointCache[i];
                if (!this.validContactDistance(manifoldPoint)) {
                    this.removeContactPoint(i);
                    continue;
                }
                tmp.scale(manifoldPoint.distance1, manifoldPoint.normalWorldOnB);
                projectedPoint.sub(manifoldPoint.positionWorldOnA, tmp);
                projectedDifference.sub(manifoldPoint.positionWorldOnB, projectedPoint);
                float distance2d = projectedDifference.dot(projectedDifference);
                if (distance2d > this.getContactBreakingThreshold() * this.getContactBreakingThreshold()) {
                    this.removeContactPoint(i);
                    continue;
                }
                if (BulletGlobals.getContactProcessedCallback() == null) continue;
                BulletGlobals.getContactProcessedCallback().contactProcessed(manifoldPoint, this.body0, this.body1);
            }
            $Stack.pop$javax$vecmath$Vector3f();
            return;
        }
        catch (Throwable throwable) {
            $Stack.pop$javax$vecmath$Vector3f();
            throw throwable;
        }
    }

    public void clearManifold() {
        for (int i = 0; i < this.cachedPoints; ++i) {
            this.clearUserCache(this.pointCache[i]);
        }
        this.cachedPoints = 0;
    }
}

