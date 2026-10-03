/*
 * Decompiled with CFR 0.152.
 */
package com.bulletphysics.collision.broadphase;

import com.bulletphysics.$Stack;
import com.bulletphysics.BulletStats;
import com.bulletphysics.collision.broadphase.BroadphaseInterface;
import com.bulletphysics.collision.broadphase.BroadphaseNativeType;
import com.bulletphysics.collision.broadphase.BroadphasePair;
import com.bulletphysics.collision.broadphase.BroadphaseProxy;
import com.bulletphysics.collision.broadphase.Dispatcher;
import com.bulletphysics.collision.broadphase.HashedOverlappingPairCache;
import com.bulletphysics.collision.broadphase.OverlappingPairCache;
import com.bulletphysics.collision.broadphase.OverlappingPairCallback;
import com.bulletphysics.linearmath.MiscUtil;
import com.bulletphysics.linearmath.VectorUtil;
import com.bulletphysics.util.ObjectArrayList;
import javax.vecmath.Tuple3f;
import javax.vecmath.Vector3f;

public abstract class AxisSweep3Internal
extends BroadphaseInterface {
    protected int bpHandleMask;
    protected int handleSentinel;
    protected final Vector3f worldAabbMin;
    protected final Vector3f worldAabbMax;
    protected final Vector3f quantize;
    protected int numHandles;
    protected int maxHandles;
    protected Handle[] pHandles;
    protected int firstFreeHandle;
    protected EdgeArray[] pEdges;
    protected OverlappingPairCache pairCache;
    protected OverlappingPairCallback userPairCallback;
    protected boolean ownsPairCache;
    protected int invalidPair;
    protected int mask;

    /*
     * WARNING - void declaration
     */
    AxisSweep3Internal(Vector3f vector3f, Vector3f vector3f2, int n, int n2, int n3, OverlappingPairCache overlappingPairCache) {
        $Stack $Stack = $Stack.get();
        try {
            int i;
            void worldAabbMax;
            void worldAabbMin;
            void userMaxHandles;
            void pairCache;
            void handleSentinel;
            void handleMask;
            $Stack.push$javax$vecmath$Vector3f();
            this.worldAabbMin = new Vector3f();
            this.worldAabbMax = new Vector3f();
            this.quantize = new Vector3f();
            this.pEdges = new EdgeArray[3];
            this.userPairCallback = null;
            this.ownsPairCache = false;
            this.invalidPair = 0;
            this.bpHandleMask = handleMask;
            this.handleSentinel = handleSentinel;
            this.pairCache = pairCache;
            int maxHandles = userMaxHandles + true;
            if (this.pairCache == null) {
                this.pairCache = new HashedOverlappingPairCache();
                this.ownsPairCache = true;
            }
            this.worldAabbMin.set((Tuple3f)worldAabbMin);
            this.worldAabbMax.set((Tuple3f)worldAabbMax);
            Vector3f aabbSize = $Stack.get$javax$vecmath$Vector3f();
            aabbSize.sub(this.worldAabbMax, this.worldAabbMin);
            int maxInt = this.handleSentinel;
            this.quantize.set((float)maxInt / aabbSize.x, (float)maxInt / aabbSize.y, (float)maxInt / aabbSize.z);
            this.pHandles = new Handle[maxHandles];
            for (i = 0; i < maxHandles; ++i) {
                this.pHandles[i] = this.createHandle();
            }
            this.maxHandles = maxHandles;
            this.numHandles = 0;
            for (i = this.firstFreeHandle = 1; i < maxHandles; ++i) {
                this.pHandles[i].setNextFree(i + 1);
            }
            this.pHandles[maxHandles - true].setNextFree(0);
            for (i = 0; i < 3; ++i) {
                this.pEdges[i] = this.createEdgeArray((int)(maxHandles * 2));
            }
            this.pHandles[0].clientObject = null;
            for (int axis = 0; axis < 3; ++axis) {
                this.pHandles[0].setMinEdges(axis, 0);
                this.pHandles[0].setMaxEdges(axis, 1);
                this.pEdges[axis].setPos(0, 0);
                this.pEdges[axis].setHandle(0, 0);
                this.pEdges[axis].setPos(1, (int)handleSentinel);
                this.pEdges[axis].setHandle(1, 0);
            }
            this.mask = this.getMask();
            $Stack.pop$javax$vecmath$Vector3f();
            return;
        }
        catch (Throwable throwable) {
            $Stack.pop$javax$vecmath$Vector3f();
            throw throwable;
        }
    }

    protected int allocHandle() {
        assert (this.firstFreeHandle != 0);
        int handle = this.firstFreeHandle;
        this.firstFreeHandle = this.getHandle(handle).getNextFree();
        ++this.numHandles;
        return handle;
    }

    protected void freeHandle(int handle) {
        assert (handle > 0 && handle < this.maxHandles);
        this.getHandle(handle).setNextFree(this.firstFreeHandle);
        this.firstFreeHandle = handle;
        --this.numHandles;
    }

    protected boolean testOverlap(int ignoreAxis, Handle pHandleA, Handle pHandleB) {
        for (int axis = 0; axis < 3; ++axis) {
            if (axis == ignoreAxis || pHandleA.getMaxEdges(axis) >= pHandleB.getMinEdges(axis) && pHandleB.getMaxEdges(axis) >= pHandleA.getMinEdges(axis)) continue;
            return false;
        }
        return true;
    }

    /*
     * WARNING - void declaration
     */
    protected void quantize(int[] nArray, Vector3f vector3f, int n) {
        $Stack $Stack = $Stack.get();
        try {
            void isMax;
            void point;
            $Stack.push$javax$vecmath$Vector3f();
            Vector3f clampedPoint = $Stack.get$javax$vecmath$Vector3f((Vector3f)point);
            VectorUtil.setMax(clampedPoint, this.worldAabbMin);
            VectorUtil.setMin(clampedPoint, this.worldAabbMax);
            Vector3f v = $Stack.get$javax$vecmath$Vector3f();
            v.sub(clampedPoint, this.worldAabbMin);
            VectorUtil.mul(v, v, this.quantize);
            out[0] = ((int)v.x & this.bpHandleMask | isMax) & this.mask;
            out[1] = ((int)v.y & this.bpHandleMask | isMax) & this.mask;
            out[2] = ((int)v.z & this.bpHandleMask | isMax) & this.mask;
            $Stack.pop$javax$vecmath$Vector3f();
            return;
        }
        catch (Throwable throwable) {
            $Stack.pop$javax$vecmath$Vector3f();
            throw throwable;
        }
    }

    protected void sortMinDown(int axis, int edge, Dispatcher dispatcher, boolean updateOverlaps) {
        EdgeArray edgeArray = this.pEdges[axis];
        int pEdge_idx = edge;
        int pPrev_idx = pEdge_idx - 1;
        Handle pHandleEdge = this.getHandle(edgeArray.getHandle(pEdge_idx));
        while (edgeArray.getPos(pEdge_idx) < edgeArray.getPos(pPrev_idx)) {
            Handle pHandlePrev = this.getHandle(edgeArray.getHandle(pPrev_idx));
            if (edgeArray.isMax(pPrev_idx) != 0) {
                if (updateOverlaps && this.testOverlap(axis, pHandleEdge, pHandlePrev)) {
                    this.pairCache.addOverlappingPair(pHandleEdge, pHandlePrev);
                    if (this.userPairCallback != null) {
                        this.userPairCallback.addOverlappingPair(pHandleEdge, pHandlePrev);
                    }
                }
                pHandlePrev.incMaxEdges(axis);
            } else {
                pHandlePrev.incMinEdges(axis);
            }
            pHandleEdge.decMinEdges(axis);
            edgeArray.swap(pEdge_idx, pPrev_idx);
            --pEdge_idx;
            --pPrev_idx;
        }
    }

    protected void sortMinUp(int axis, int edge, Dispatcher dispatcher, boolean updateOverlaps) {
        EdgeArray edgeArray = this.pEdges[axis];
        int pEdge_idx = edge;
        int pNext_idx = pEdge_idx + 1;
        Handle pHandleEdge = this.getHandle(edgeArray.getHandle(pEdge_idx));
        while (edgeArray.getHandle(pNext_idx) != 0 && edgeArray.getPos(pEdge_idx) >= edgeArray.getPos(pNext_idx)) {
            Handle pHandleNext = this.getHandle(edgeArray.getHandle(pNext_idx));
            if (edgeArray.isMax(pNext_idx) != 0) {
                if (updateOverlaps) {
                    Handle handle0 = this.getHandle(edgeArray.getHandle(pEdge_idx));
                    Handle handle1 = this.getHandle(edgeArray.getHandle(pNext_idx));
                    this.pairCache.removeOverlappingPair(handle0, handle1, dispatcher);
                    if (this.userPairCallback != null) {
                        this.userPairCallback.removeOverlappingPair(handle0, handle1, dispatcher);
                    }
                }
                pHandleNext.decMaxEdges(axis);
            } else {
                pHandleNext.decMinEdges(axis);
            }
            pHandleEdge.incMinEdges(axis);
            edgeArray.swap(pEdge_idx, pNext_idx);
            ++pEdge_idx;
            ++pNext_idx;
        }
    }

    protected void sortMaxDown(int axis, int edge, Dispatcher dispatcher, boolean updateOverlaps) {
        EdgeArray edgeArray = this.pEdges[axis];
        int pEdge_idx = edge;
        int pPrev_idx = pEdge_idx - 1;
        Handle pHandleEdge = this.getHandle(edgeArray.getHandle(pEdge_idx));
        while (edgeArray.getPos(pEdge_idx) < edgeArray.getPos(pPrev_idx)) {
            Handle pHandlePrev = this.getHandle(edgeArray.getHandle(pPrev_idx));
            if (edgeArray.isMax(pPrev_idx) == 0) {
                if (updateOverlaps) {
                    Handle handle0 = this.getHandle(edgeArray.getHandle(pEdge_idx));
                    Handle handle1 = this.getHandle(edgeArray.getHandle(pPrev_idx));
                    this.pairCache.removeOverlappingPair(handle0, handle1, dispatcher);
                    if (this.userPairCallback != null) {
                        this.userPairCallback.removeOverlappingPair(handle0, handle1, dispatcher);
                    }
                }
                pHandlePrev.incMinEdges(axis);
            } else {
                pHandlePrev.incMaxEdges(axis);
            }
            pHandleEdge.decMaxEdges(axis);
            edgeArray.swap(pEdge_idx, pPrev_idx);
            --pEdge_idx;
            --pPrev_idx;
        }
    }

    protected void sortMaxUp(int axis, int edge, Dispatcher dispatcher, boolean updateOverlaps) {
        EdgeArray edgeArray = this.pEdges[axis];
        int pEdge_idx = edge;
        int pNext_idx = pEdge_idx + 1;
        Handle pHandleEdge = this.getHandle(edgeArray.getHandle(pEdge_idx));
        while (edgeArray.getHandle(pNext_idx) != 0 && edgeArray.getPos(pEdge_idx) >= edgeArray.getPos(pNext_idx)) {
            Handle pHandleNext = this.getHandle(edgeArray.getHandle(pNext_idx));
            if (edgeArray.isMax(pNext_idx) == 0) {
                if (updateOverlaps && this.testOverlap(axis, pHandleEdge, pHandleNext)) {
                    Handle handle0 = this.getHandle(edgeArray.getHandle(pEdge_idx));
                    Handle handle1 = this.getHandle(edgeArray.getHandle(pNext_idx));
                    this.pairCache.addOverlappingPair(handle0, handle1);
                    if (this.userPairCallback != null) {
                        this.userPairCallback.addOverlappingPair(handle0, handle1);
                    }
                }
                pHandleNext.decMinEdges(axis);
            } else {
                pHandleNext.decMaxEdges(axis);
            }
            pHandleEdge.incMaxEdges(axis);
            edgeArray.swap(pEdge_idx, pNext_idx);
            ++pEdge_idx;
            ++pNext_idx;
        }
    }

    public int getNumHandles() {
        return this.numHandles;
    }

    @Override
    public void calculateOverlappingPairs(Dispatcher dispatcher) {
        if (this.pairCache.hasDeferredRemoval()) {
            ObjectArrayList<BroadphasePair> overlappingPairArray = this.pairCache.getOverlappingPairArray();
            MiscUtil.quickSort(overlappingPairArray, BroadphasePair.broadphasePairSortPredicate);
            MiscUtil.resize(overlappingPairArray, overlappingPairArray.size() - this.invalidPair, BroadphasePair.class);
            this.invalidPair = 0;
            BroadphasePair previousPair = new BroadphasePair();
            previousPair.pProxy0 = null;
            previousPair.pProxy1 = null;
            previousPair.algorithm = null;
            for (int i = 0; i < overlappingPairArray.size(); ++i) {
                BroadphasePair pair = overlappingPairArray.getQuick(i);
                boolean isDuplicate = pair.equals(previousPair);
                previousPair.set(pair);
                boolean needsRemoval = false;
                if (!isDuplicate) {
                    boolean hasOverlap = this.testAabbOverlap(pair.pProxy0, pair.pProxy1);
                    needsRemoval = !hasOverlap;
                } else {
                    needsRemoval = true;
                    assert (pair.algorithm == null);
                }
                if (!needsRemoval) continue;
                this.pairCache.cleanOverlappingPair(pair, dispatcher);
                pair.pProxy0 = null;
                pair.pProxy1 = null;
                ++this.invalidPair;
                --BulletStats.gOverlappingPairs;
            }
            MiscUtil.quickSort(overlappingPairArray, BroadphasePair.broadphasePairSortPredicate);
            MiscUtil.resize(overlappingPairArray, overlappingPairArray.size() - this.invalidPair, BroadphasePair.class);
            this.invalidPair = 0;
        }
    }

    public int addHandle(Vector3f aabbMin, Vector3f aabbMax, Object pOwner, short collisionFilterGroup, short collisionFilterMask, Dispatcher dispatcher, Object multiSapProxy) {
        int[] min = new int[3];
        int[] max = new int[3];
        this.quantize(min, aabbMin, 0);
        this.quantize(max, aabbMax, 1);
        int handle = this.allocHandle();
        Handle pHandle = this.getHandle(handle);
        pHandle.uniqueId = handle;
        pHandle.clientObject = pOwner;
        pHandle.collisionFilterGroup = collisionFilterGroup;
        pHandle.collisionFilterMask = collisionFilterMask;
        pHandle.multiSapParentProxy = multiSapProxy;
        int limit = this.numHandles * 2;
        for (int axis = 0; axis < 3; ++axis) {
            this.pHandles[0].setMaxEdges(axis, this.pHandles[0].getMaxEdges(axis) + 2);
            this.pEdges[axis].set(limit + 1, limit - 1);
            this.pEdges[axis].setPos(limit - 1, min[axis]);
            this.pEdges[axis].setHandle(limit - 1, handle);
            this.pEdges[axis].setPos(limit, max[axis]);
            this.pEdges[axis].setHandle(limit, handle);
            pHandle.setMinEdges(axis, limit - 1);
            pHandle.setMaxEdges(axis, limit);
        }
        this.sortMinDown(0, pHandle.getMinEdges(0), dispatcher, false);
        this.sortMaxDown(0, pHandle.getMaxEdges(0), dispatcher, false);
        this.sortMinDown(1, pHandle.getMinEdges(1), dispatcher, false);
        this.sortMaxDown(1, pHandle.getMaxEdges(1), dispatcher, false);
        this.sortMinDown(2, pHandle.getMinEdges(2), dispatcher, true);
        this.sortMaxDown(2, pHandle.getMaxEdges(2), dispatcher, true);
        return handle;
    }

    public void removeHandle(int handle, Dispatcher dispatcher) {
        int axis;
        Handle pHandle = this.getHandle(handle);
        if (!this.pairCache.hasDeferredRemoval()) {
            this.pairCache.removeOverlappingPairsContainingProxy(pHandle, dispatcher);
        }
        int limit = this.numHandles * 2;
        for (axis = 0; axis < 3; ++axis) {
            this.pHandles[0].setMaxEdges(axis, this.pHandles[0].getMaxEdges(axis) - 2);
        }
        for (axis = 0; axis < 3; ++axis) {
            EdgeArray pEdges = this.pEdges[axis];
            int max = pHandle.getMaxEdges(axis);
            pEdges.setPos(max, this.handleSentinel);
            this.sortMaxUp(axis, max, dispatcher, false);
            int i = pHandle.getMinEdges(axis);
            pEdges.setPos(i, this.handleSentinel);
            this.sortMinUp(axis, i, dispatcher, false);
            pEdges.setHandle(limit - 1, 0);
            pEdges.setPos(limit - 1, this.handleSentinel);
        }
        this.freeHandle(handle);
    }

    public void updateHandle(int handle, Vector3f aabbMin, Vector3f aabbMax, Dispatcher dispatcher) {
        Handle pHandle = this.getHandle(handle);
        int[] min = new int[3];
        int[] max = new int[3];
        this.quantize(min, aabbMin, 0);
        this.quantize(max, aabbMax, 1);
        for (int axis = 0; axis < 3; ++axis) {
            int emin = pHandle.getMinEdges(axis);
            int emax = pHandle.getMaxEdges(axis);
            int dmin = min[axis] - this.pEdges[axis].getPos(emin);
            int dmax = max[axis] - this.pEdges[axis].getPos(emax);
            this.pEdges[axis].setPos(emin, min[axis]);
            this.pEdges[axis].setPos(emax, max[axis]);
            if (dmin < 0) {
                this.sortMinDown(axis, emin, dispatcher, true);
            }
            if (dmax > 0) {
                this.sortMaxUp(axis, emax, dispatcher, true);
            }
            if (dmin > 0) {
                this.sortMinUp(axis, emin, dispatcher, true);
            }
            if (dmax >= 0) continue;
            this.sortMaxDown(axis, emax, dispatcher, true);
        }
    }

    public Handle getHandle(int index) {
        return this.pHandles[index];
    }

    @Override
    public BroadphaseProxy createProxy(Vector3f aabbMin, Vector3f aabbMax, BroadphaseNativeType shapeType, Object userPtr, short collisionFilterGroup, short collisionFilterMask, Dispatcher dispatcher, Object multiSapProxy) {
        int handleId = this.addHandle(aabbMin, aabbMax, userPtr, collisionFilterGroup, collisionFilterMask, dispatcher, multiSapProxy);
        Handle handle = this.getHandle(handleId);
        return handle;
    }

    @Override
    public void destroyProxy(BroadphaseProxy proxy, Dispatcher dispatcher) {
        Handle handle = (Handle)proxy;
        this.removeHandle(handle.uniqueId, dispatcher);
    }

    @Override
    public void setAabb(BroadphaseProxy proxy, Vector3f aabbMin, Vector3f aabbMax, Dispatcher dispatcher) {
        Handle handle = (Handle)proxy;
        this.updateHandle(handle.uniqueId, aabbMin, aabbMax, dispatcher);
    }

    public boolean testAabbOverlap(BroadphaseProxy proxy0, BroadphaseProxy proxy1) {
        Handle pHandleA = (Handle)proxy0;
        Handle pHandleB = (Handle)proxy1;
        for (int axis = 0; axis < 3; ++axis) {
            if (pHandleA.getMaxEdges(axis) >= pHandleB.getMinEdges(axis) && pHandleB.getMaxEdges(axis) >= pHandleA.getMinEdges(axis)) continue;
            return false;
        }
        return true;
    }

    @Override
    public OverlappingPairCache getOverlappingPairCache() {
        return this.pairCache;
    }

    public void setOverlappingPairUserCallback(OverlappingPairCallback pairCallback) {
        this.userPairCallback = pairCallback;
    }

    public OverlappingPairCallback getOverlappingPairUserCallback() {
        return this.userPairCallback;
    }

    @Override
    public void getBroadphaseAabb(Vector3f aabbMin, Vector3f aabbMax) {
        aabbMin.set(this.worldAabbMin);
        aabbMax.set(this.worldAabbMax);
    }

    @Override
    public void printStats() {
    }

    protected abstract EdgeArray createEdgeArray(int var1);

    protected abstract Handle createHandle();

    protected abstract int getMask();

    protected static abstract class Handle
    extends BroadphaseProxy {
        protected Handle() {
        }

        public abstract int getMinEdges(int var1);

        public abstract void setMinEdges(int var1, int var2);

        public abstract int getMaxEdges(int var1);

        public abstract void setMaxEdges(int var1, int var2);

        public void incMinEdges(int edgeIndex) {
            this.setMinEdges(edgeIndex, this.getMinEdges(edgeIndex) + 1);
        }

        public void incMaxEdges(int edgeIndex) {
            this.setMaxEdges(edgeIndex, this.getMaxEdges(edgeIndex) + 1);
        }

        public void decMinEdges(int edgeIndex) {
            this.setMinEdges(edgeIndex, this.getMinEdges(edgeIndex) - 1);
        }

        public void decMaxEdges(int edgeIndex) {
            this.setMaxEdges(edgeIndex, this.getMaxEdges(edgeIndex) - 1);
        }

        public void setNextFree(int next) {
            this.setMinEdges(0, next);
        }

        public int getNextFree() {
            return this.getMinEdges(0);
        }
    }

    protected static abstract class EdgeArray {
        protected EdgeArray() {
        }

        public abstract void swap(int var1, int var2);

        public abstract void set(int var1, int var2);

        public abstract int getPos(int var1);

        public abstract void setPos(int var1, int var2);

        public abstract int getHandle(int var1);

        public abstract void setHandle(int var1, int var2);

        public int isMax(int offset) {
            return this.getPos(offset) & 1;
        }
    }
}

