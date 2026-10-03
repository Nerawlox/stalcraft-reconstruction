/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.physics.core.client.bulletoverride;

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
import javax.vecmath.Vector3f;

public abstract class JAxisSweep3Internal
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
    protected OverlappingPairCallback userPairCallback = null;
    protected boolean ownsPairCache = false;
    protected int invalidPair = 0;
    protected int mask;
    private Vector3f vec0 = new Vector3f();
    private Vector3f vec1 = new Vector3f();

    JAxisSweep3Internal(Vector3f vector3f, Vector3f vector3f2, int n, int n2, int n3, OverlappingPairCache overlappingPairCache) {
        int n4;
        this.worldAabbMin = new Vector3f();
        this.worldAabbMax = new Vector3f();
        this.quantize = new Vector3f();
        this.pEdges = new EdgeArray[3];
        this.bpHandleMask = n;
        this.handleSentinel = n2;
        this.pairCache = overlappingPairCache;
        int n5 = n3 + 1;
        if (this.pairCache == null) {
            this.pairCache = new HashedOverlappingPairCache();
            this.ownsPairCache = true;
        }
        this.worldAabbMin.set(vector3f);
        this.worldAabbMax.set(vector3f2);
        Vector3f vector3f3 = new Vector3f();
        vector3f3.sub(this.worldAabbMax, this.worldAabbMin);
        int n6 = this.handleSentinel;
        this.quantize.set((float)n6 / vector3f3.x, (float)n6 / vector3f3.y, (float)n6 / vector3f3.z);
        this.pHandles = new Handle[n5];
        for (n4 = 0; n4 < n5; ++n4) {
            this.pHandles[n4] = this.createHandle();
        }
        this.maxHandles = n5;
        this.numHandles = 0;
        for (n4 = this.firstFreeHandle = 1; n4 < n5; ++n4) {
            this.pHandles[n4].setNextFree(n4 + 1);
        }
        this.pHandles[n5 - 1].setNextFree(0);
        for (n4 = 0; n4 < 3; ++n4) {
            this.pEdges[n4] = this.createEdgeArray(n5 * 2);
        }
        this.pHandles[0].clientObject = null;
        for (n4 = 0; n4 < 3; ++n4) {
            this.pHandles[0].setMinEdges(n4, 0);
            this.pHandles[0].setMaxEdges(n4, 1);
            this.pEdges[n4].setPos(0, 0);
            this.pEdges[n4].setHandle(0, 0);
            this.pEdges[n4].setPos(1, n2);
            this.pEdges[n4].setHandle(1, 0);
        }
        this.mask = this.getMask();
    }

    protected int allocHandle() {
        assert (this.firstFreeHandle != 0);
        int n = this.firstFreeHandle;
        this.firstFreeHandle = this.getHandle(n).getNextFree();
        ++this.numHandles;
        return n;
    }

    protected void freeHandle(int n) {
        assert (n > 0 && n < this.maxHandles);
        this.getHandle(n).setNextFree(this.firstFreeHandle);
        this.firstFreeHandle = n;
        --this.numHandles;
    }

    protected boolean testOverlap(int n, Handle handle, Handle handle2) {
        for (int i = 0; i < 3; ++i) {
            if (i == n || handle.getMaxEdges(i) >= handle2.getMinEdges(i) && handle2.getMaxEdges(i) >= handle.getMinEdges(i)) continue;
            return false;
        }
        return true;
    }

    protected void quantize(int[] nArray, Vector3f vector3f, int n) {
        Vector3f vector3f2 = this.vec0;
        this.vec0.set(vector3f);
        VectorUtil.setMax(vector3f2, this.worldAabbMin);
        VectorUtil.setMin(vector3f2, this.worldAabbMax);
        Vector3f vector3f3 = this.vec1;
        vector3f3.sub(vector3f2, this.worldAabbMin);
        VectorUtil.mul(vector3f3, vector3f3, this.quantize);
        nArray[0] = ((int)vector3f3.x & this.bpHandleMask | n) & this.mask;
        nArray[1] = ((int)vector3f3.y & this.bpHandleMask | n) & this.mask;
        nArray[2] = ((int)vector3f3.z & this.bpHandleMask | n) & this.mask;
    }

    protected void sortMinDown(int n, int n2, Dispatcher dispatcher, boolean bl) {
        EdgeArray edgeArray = this.pEdges[n];
        int n3 = n2;
        int n4 = n2 - 1;
        Handle handle = this.getHandle(edgeArray.getHandle(n2));
        while (edgeArray.getPos(n3) < edgeArray.getPos(n4)) {
            Handle handle2 = this.getHandle(edgeArray.getHandle(n4));
            if (edgeArray.isMax(n4) != 0) {
                if (bl && this.testOverlap(n, handle, handle2)) {
                    this.pairCache.addOverlappingPair(handle, handle2);
                    if (this.userPairCallback != null) {
                        this.userPairCallback.addOverlappingPair(handle, handle2);
                    }
                }
                handle2.incMaxEdges(n);
            } else {
                handle2.incMinEdges(n);
            }
            handle.decMinEdges(n);
            edgeArray.swap(n3, n4);
            --n3;
            --n4;
        }
    }

    protected void sortMinUp(int n, int n2, Dispatcher dispatcher, boolean bl) {
        EdgeArray edgeArray = this.pEdges[n];
        int n3 = n2;
        int n4 = n2 + 1;
        Handle handle = this.getHandle(edgeArray.getHandle(n2));
        while (edgeArray.getHandle(n4) != 0 && edgeArray.getPos(n3) >= edgeArray.getPos(n4)) {
            Handle handle2 = this.getHandle(edgeArray.getHandle(n4));
            if (edgeArray.isMax(n4) != 0) {
                if (bl) {
                    Handle handle3 = this.getHandle(edgeArray.getHandle(n3));
                    Handle handle4 = this.getHandle(edgeArray.getHandle(n4));
                    this.pairCache.removeOverlappingPair(handle3, handle4, dispatcher);
                    if (this.userPairCallback != null) {
                        this.userPairCallback.removeOverlappingPair(handle3, handle4, dispatcher);
                    }
                }
                handle2.decMaxEdges(n);
            } else {
                handle2.decMinEdges(n);
            }
            handle.incMinEdges(n);
            edgeArray.swap(n3, n4);
            ++n3;
            ++n4;
        }
    }

    protected void sortMaxDown(int n, int n2, Dispatcher dispatcher, boolean bl) {
        EdgeArray edgeArray = this.pEdges[n];
        int n3 = n2;
        int n4 = n2 - 1;
        Handle handle = this.getHandle(edgeArray.getHandle(n2));
        while (edgeArray.getPos(n3) < edgeArray.getPos(n4)) {
            Handle handle2 = this.getHandle(edgeArray.getHandle(n4));
            if (edgeArray.isMax(n4) == 0) {
                if (bl) {
                    Handle handle3 = this.getHandle(edgeArray.getHandle(n3));
                    Handle handle4 = this.getHandle(edgeArray.getHandle(n4));
                    this.pairCache.removeOverlappingPair(handle3, handle4, dispatcher);
                    if (this.userPairCallback != null) {
                        this.userPairCallback.removeOverlappingPair(handle3, handle4, dispatcher);
                    }
                }
                handle2.incMinEdges(n);
            } else {
                handle2.incMaxEdges(n);
            }
            handle.decMaxEdges(n);
            edgeArray.swap(n3, n4);
            --n3;
            --n4;
        }
    }

    protected void sortMaxUp(int n, int n2, Dispatcher dispatcher, boolean bl) {
        EdgeArray edgeArray = this.pEdges[n];
        int n3 = n2;
        int n4 = n2 + 1;
        Handle handle = this.getHandle(edgeArray.getHandle(n2));
        while (edgeArray.getHandle(n4) != 0 && edgeArray.getPos(n3) >= edgeArray.getPos(n4)) {
            Handle handle2 = this.getHandle(edgeArray.getHandle(n4));
            if (edgeArray.isMax(n4) == 0) {
                if (bl && this.testOverlap(n, handle, handle2)) {
                    Handle handle3 = this.getHandle(edgeArray.getHandle(n3));
                    Handle handle4 = this.getHandle(edgeArray.getHandle(n4));
                    this.pairCache.addOverlappingPair(handle3, handle4);
                    if (this.userPairCallback != null) {
                        this.userPairCallback.addOverlappingPair(handle3, handle4);
                    }
                }
                handle2.decMinEdges(n);
            } else {
                handle2.decMaxEdges(n);
            }
            handle.incMaxEdges(n);
            edgeArray.swap(n3, n4);
            ++n3;
            ++n4;
        }
    }

    public int getNumHandles() {
        return this.numHandles;
    }

    @Override
    public void calculateOverlappingPairs(Dispatcher dispatcher) {
        if (this.pairCache.hasDeferredRemoval()) {
            ObjectArrayList<BroadphasePair> objectArrayList = this.pairCache.getOverlappingPairArray();
            MiscUtil.quickSort(objectArrayList, BroadphasePair.broadphasePairSortPredicate);
            MiscUtil.resize(objectArrayList, objectArrayList.size() - this.invalidPair, BroadphasePair.class);
            this.invalidPair = 0;
            BroadphasePair broadphasePair = new BroadphasePair();
            broadphasePair.pProxy0 = null;
            broadphasePair.pProxy1 = null;
            broadphasePair.algorithm = null;
            for (int i = 0; i < objectArrayList.size(); ++i) {
                BroadphasePair broadphasePair2 = objectArrayList.getQuick(i);
                boolean bl = broadphasePair2.equals(broadphasePair);
                broadphasePair.set(broadphasePair2);
                boolean bl2 = false;
                if (!bl) {
                    boolean bl3 = this.testAabbOverlap(broadphasePair2.pProxy0, broadphasePair2.pProxy1);
                    bl2 = !bl3;
                } else {
                    bl2 = true;
                    assert (broadphasePair2.algorithm == null);
                }
                if (!bl2) continue;
                this.pairCache.cleanOverlappingPair(broadphasePair2, dispatcher);
                broadphasePair2.pProxy0 = null;
                broadphasePair2.pProxy1 = null;
                ++this.invalidPair;
                --BulletStats.gOverlappingPairs;
            }
            MiscUtil.quickSort(objectArrayList, BroadphasePair.broadphasePairSortPredicate);
            MiscUtil.resize(objectArrayList, objectArrayList.size() - this.invalidPair, BroadphasePair.class);
            this.invalidPair = 0;
        }
    }

    public int addHandle(Vector3f vector3f, Vector3f vector3f2, Object object, short s, short s2, Dispatcher dispatcher, Object object2) {
        int[] nArray = new int[3];
        int[] nArray2 = new int[3];
        this.quantize(nArray, vector3f, 0);
        this.quantize(nArray2, vector3f2, 1);
        int n = this.allocHandle();
        Handle handle = this.getHandle(n);
        handle.uniqueId = n;
        handle.clientObject = object;
        handle.collisionFilterGroup = s;
        handle.collisionFilterMask = s2;
        handle.multiSapParentProxy = object2;
        int n2 = this.numHandles * 2;
        for (int i = 0; i < 3; ++i) {
            this.pHandles[0].setMaxEdges(i, this.pHandles[0].getMaxEdges(i) + 2);
            this.pEdges[i].set(n2 + 1, n2 - 1);
            this.pEdges[i].setPos(n2 - 1, nArray[i]);
            this.pEdges[i].setHandle(n2 - 1, n);
            this.pEdges[i].setPos(n2, nArray2[i]);
            this.pEdges[i].setHandle(n2, n);
            handle.setMinEdges(i, n2 - 1);
            handle.setMaxEdges(i, n2);
        }
        this.sortMinDown(0, handle.getMinEdges(0), dispatcher, false);
        this.sortMaxDown(0, handle.getMaxEdges(0), dispatcher, false);
        this.sortMinDown(1, handle.getMinEdges(1), dispatcher, false);
        this.sortMaxDown(1, handle.getMaxEdges(1), dispatcher, false);
        this.sortMinDown(2, handle.getMinEdges(2), dispatcher, true);
        this.sortMaxDown(2, handle.getMaxEdges(2), dispatcher, true);
        return n;
    }

    public void removeHandle(int n, Dispatcher dispatcher) {
        int n2;
        Handle handle = this.getHandle(n);
        if (!this.pairCache.hasDeferredRemoval()) {
            this.pairCache.removeOverlappingPairsContainingProxy(handle, dispatcher);
        }
        int n3 = this.numHandles * 2;
        for (n2 = 0; n2 < 3; ++n2) {
            this.pHandles[0].setMaxEdges(n2, this.pHandles[0].getMaxEdges(n2) - 2);
        }
        for (n2 = 0; n2 < 3; ++n2) {
            EdgeArray edgeArray = this.pEdges[n2];
            int n4 = handle.getMaxEdges(n2);
            edgeArray.setPos(n4, this.handleSentinel);
            this.sortMaxUp(n2, n4, dispatcher, false);
            int n5 = handle.getMinEdges(n2);
            edgeArray.setPos(n5, this.handleSentinel);
            this.sortMinUp(n2, n5, dispatcher, false);
            edgeArray.setHandle(n3 - 1, 0);
            edgeArray.setPos(n3 - 1, this.handleSentinel);
        }
        this.freeHandle(n);
    }

    public void updateHandle(int n, Vector3f vector3f, Vector3f vector3f2, Dispatcher dispatcher) {
        Handle handle = this.getHandle(n);
        int[] nArray = new int[3];
        int[] nArray2 = new int[3];
        this.quantize(nArray, vector3f, 0);
        this.quantize(nArray2, vector3f2, 1);
        for (int i = 0; i < 3; ++i) {
            int n2 = handle.getMinEdges(i);
            int n3 = handle.getMaxEdges(i);
            int n4 = nArray[i] - this.pEdges[i].getPos(n2);
            int n5 = nArray2[i] - this.pEdges[i].getPos(n3);
            this.pEdges[i].setPos(n2, nArray[i]);
            this.pEdges[i].setPos(n3, nArray2[i]);
            if (n4 < 0) {
                this.sortMinDown(i, n2, dispatcher, true);
            }
            if (n5 > 0) {
                this.sortMaxUp(i, n3, dispatcher, true);
            }
            if (n4 > 0) {
                this.sortMinUp(i, n2, dispatcher, true);
            }
            if (n5 >= 0) continue;
            this.sortMaxDown(i, n3, dispatcher, true);
        }
    }

    public Handle getHandle(int n) {
        return this.pHandles[n];
    }

    @Override
    public BroadphaseProxy createProxy(Vector3f vector3f, Vector3f vector3f2, BroadphaseNativeType broadphaseNativeType, Object object, short s, short s2, Dispatcher dispatcher, Object object2) {
        int n = this.addHandle(vector3f, vector3f2, object, s, s2, dispatcher, object2);
        Handle handle = this.getHandle(n);
        return handle;
    }

    @Override
    public void destroyProxy(BroadphaseProxy broadphaseProxy, Dispatcher dispatcher) {
        Handle handle = (Handle)broadphaseProxy;
        this.removeHandle(handle.uniqueId, dispatcher);
    }

    @Override
    public void setAabb(BroadphaseProxy broadphaseProxy, Vector3f vector3f, Vector3f vector3f2, Dispatcher dispatcher) {
        Handle handle = (Handle)broadphaseProxy;
        this.updateHandle(handle.uniqueId, vector3f, vector3f2, dispatcher);
    }

    public boolean testAabbOverlap(BroadphaseProxy broadphaseProxy, BroadphaseProxy broadphaseProxy2) {
        Handle handle = (Handle)broadphaseProxy;
        Handle handle2 = (Handle)broadphaseProxy2;
        for (int i = 0; i < 3; ++i) {
            if (handle.getMaxEdges(i) >= handle2.getMinEdges(i) && handle2.getMaxEdges(i) >= handle.getMinEdges(i)) continue;
            return false;
        }
        return true;
    }

    @Override
    public OverlappingPairCache getOverlappingPairCache() {
        return this.pairCache;
    }

    public void setOverlappingPairUserCallback(OverlappingPairCallback overlappingPairCallback) {
        this.userPairCallback = overlappingPairCallback;
    }

    public OverlappingPairCallback getOverlappingPairUserCallback() {
        return this.userPairCallback;
    }

    @Override
    public void getBroadphaseAabb(Vector3f vector3f, Vector3f vector3f2) {
        vector3f.set(this.worldAabbMin);
        vector3f2.set(this.worldAabbMax);
    }

    @Override
    public void printStats() {
    }

    protected abstract EdgeArray createEdgeArray(int var1);

    protected abstract Handle createHandle();

    protected abstract int getMask();

    protected static abstract class EdgeArray {
        protected EdgeArray() {
        }

        public abstract void swap(int var1, int var2);

        public abstract void set(int var1, int var2);

        public abstract int getPos(int var1);

        public abstract void setPos(int var1, int var2);

        public abstract int getHandle(int var1);

        public abstract void setHandle(int var1, int var2);

        public int isMax(int n) {
            return this.getPos(n) & 1;
        }
    }

    protected static abstract class Handle
    extends BroadphaseProxy {
        protected Handle() {
        }

        public abstract int getMinEdges(int var1);

        public abstract void setMinEdges(int var1, int var2);

        public abstract int getMaxEdges(int var1);

        public abstract void setMaxEdges(int var1, int var2);

        public void incMinEdges(int n) {
            this.setMinEdges(n, this.getMinEdges(n) + 1);
        }

        public void incMaxEdges(int n) {
            this.setMaxEdges(n, this.getMaxEdges(n) + 1);
        }

        public void decMinEdges(int n) {
            this.setMinEdges(n, this.getMinEdges(n) - 1);
        }

        public void decMaxEdges(int n) {
            this.setMaxEdges(n, this.getMaxEdges(n) - 1);
        }

        public void setNextFree(int n) {
            this.setMinEdges(0, n);
        }

        public int getNextFree() {
            return this.getMinEdges(0);
        }
    }
}

