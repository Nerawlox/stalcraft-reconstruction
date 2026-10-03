/*
 * Decompiled with CFR 0.152.
 */
package com.bulletphysics.collision.broadphase;

import com.bulletphysics.BulletStats;
import com.bulletphysics.collision.broadphase.BroadphasePair;
import com.bulletphysics.collision.broadphase.BroadphaseProxy;
import com.bulletphysics.collision.broadphase.Dispatcher;
import com.bulletphysics.collision.broadphase.OverlapCallback;
import com.bulletphysics.collision.broadphase.OverlapFilterCallback;
import com.bulletphysics.collision.broadphase.OverlappingPairCache;
import com.bulletphysics.collision.broadphase.OverlappingPairCallback;
import com.bulletphysics.linearmath.MiscUtil;
import com.bulletphysics.util.IntArrayList;
import com.bulletphysics.util.ObjectArrayList;
import com.bulletphysics.util.ObjectPool;

public class HashedOverlappingPairCache
extends OverlappingPairCache {
    private final ObjectPool<BroadphasePair> pairsPool = ObjectPool.get(BroadphasePair.class);
    private static final int NULL_PAIR = -1;
    private ObjectArrayList<BroadphasePair> overlappingPairArray = new ObjectArrayList();
    private OverlapFilterCallback overlapFilterCallback;
    private boolean blockedForChanges = false;
    private IntArrayList hashTable = new IntArrayList();
    private IntArrayList next = new IntArrayList();
    protected OverlappingPairCallback ghostPairCallback;

    public HashedOverlappingPairCache() {
        int initialAllocatedSize = 2;
        this.growTables();
    }

    @Override
    public BroadphasePair addOverlappingPair(BroadphaseProxy proxy0, BroadphaseProxy proxy1) {
        ++BulletStats.gAddedPairs;
        if (!this.needsBroadphaseCollision(proxy0, proxy1)) {
            return null;
        }
        return this.internalAddPair(proxy0, proxy1);
    }

    @Override
    public Object removeOverlappingPair(BroadphaseProxy proxy0, BroadphaseProxy proxy1, Dispatcher dispatcher) {
        int proxyId2;
        int proxyId1;
        int hash;
        BroadphasePair pair;
        ++BulletStats.gRemovePairs;
        if (proxy0.getUid() > proxy1.getUid()) {
            BroadphaseProxy tmp = proxy0;
            proxy0 = proxy1;
            proxy1 = tmp;
        }
        if ((pair = this.internalFindPair(proxy0, proxy1, hash = this.getHash(proxyId1 = proxy0.getUid(), proxyId2 = proxy1.getUid()) & this.overlappingPairArray.capacity() - 1)) == null) {
            return null;
        }
        this.cleanOverlappingPair(pair, dispatcher);
        Object userData = pair.userInfo;
        assert (pair.pProxy0.getUid() == proxyId1);
        assert (pair.pProxy1.getUid() == proxyId2);
        int pairIndex = this.overlappingPairArray.indexOf(pair);
        assert (pairIndex != -1);
        assert (pairIndex < this.overlappingPairArray.size());
        int index = this.hashTable.get(hash);
        assert (index != -1);
        int previous = -1;
        while (index != pairIndex) {
            previous = index;
            index = this.next.get(index);
        }
        if (previous != -1) {
            assert (this.next.get(previous) == pairIndex);
            this.next.set(previous, this.next.get(pairIndex));
        } else {
            this.hashTable.set(hash, this.next.get(pairIndex));
        }
        int lastPairIndex = this.overlappingPairArray.size() - 1;
        if (this.ghostPairCallback != null) {
            this.ghostPairCallback.removeOverlappingPair(proxy0, proxy1, dispatcher);
        }
        if (lastPairIndex == pairIndex) {
            this.overlappingPairArray.removeQuick(this.overlappingPairArray.size() - 1);
            return userData;
        }
        BroadphasePair last = this.overlappingPairArray.getQuick(lastPairIndex);
        int lastHash = this.getHash(last.pProxy0.getUid(), last.pProxy1.getUid()) & this.overlappingPairArray.capacity() - 1;
        index = this.hashTable.get(lastHash);
        assert (index != -1);
        previous = -1;
        while (index != lastPairIndex) {
            previous = index;
            index = this.next.get(index);
        }
        if (previous != -1) {
            assert (this.next.get(previous) == lastPairIndex);
            this.next.set(previous, this.next.get(lastPairIndex));
        } else {
            this.hashTable.set(lastHash, this.next.get(lastPairIndex));
        }
        this.overlappingPairArray.getQuick(pairIndex).set(this.overlappingPairArray.getQuick(lastPairIndex));
        this.next.set(pairIndex, this.hashTable.get(lastHash));
        this.hashTable.set(lastHash, pairIndex);
        this.overlappingPairArray.removeQuick(this.overlappingPairArray.size() - 1);
        return userData;
    }

    public boolean needsBroadphaseCollision(BroadphaseProxy proxy0, BroadphaseProxy proxy1) {
        if (this.overlapFilterCallback != null) {
            return this.overlapFilterCallback.needBroadphaseCollision(proxy0, proxy1);
        }
        boolean collides = (proxy0.collisionFilterGroup & proxy1.collisionFilterMask) != 0;
        collides = collides && (proxy1.collisionFilterGroup & proxy0.collisionFilterMask) != 0;
        return collides;
    }

    @Override
    public void processAllOverlappingPairs(OverlapCallback callback, Dispatcher dispatcher) {
        int i = 0;
        while (i < this.overlappingPairArray.size()) {
            BroadphasePair pair = this.overlappingPairArray.getQuick(i);
            if (callback.processOverlap(pair)) {
                this.removeOverlappingPair(pair.pProxy0, pair.pProxy1, dispatcher);
                --BulletStats.gOverlappingPairs;
                continue;
            }
            ++i;
        }
    }

    @Override
    public void removeOverlappingPairsContainingProxy(BroadphaseProxy proxy, Dispatcher dispatcher) {
        this.processAllOverlappingPairs(new RemovePairCallback(proxy), dispatcher);
    }

    @Override
    public void cleanProxyFromPairs(BroadphaseProxy proxy, Dispatcher dispatcher) {
        this.processAllOverlappingPairs(new CleanPairCallback(proxy, this, dispatcher), dispatcher);
    }

    @Override
    public ObjectArrayList<BroadphasePair> getOverlappingPairArray() {
        return this.overlappingPairArray;
    }

    @Override
    public void cleanOverlappingPair(BroadphasePair pair, Dispatcher dispatcher) {
        if (pair.algorithm != null) {
            dispatcher.freeCollisionAlgorithm(pair.algorithm);
            pair.algorithm = null;
        }
    }

    @Override
    public BroadphasePair findPair(BroadphaseProxy proxy0, BroadphaseProxy proxy1) {
        int proxyId2;
        int proxyId1;
        int hash;
        ++BulletStats.gFindPairs;
        if (proxy0.getUid() > proxy1.getUid()) {
            BroadphaseProxy tmp = proxy0;
            proxy1 = proxy0 = proxy1;
        }
        if ((hash = this.getHash(proxyId1 = proxy0.getUid(), proxyId2 = proxy1.getUid()) & this.overlappingPairArray.capacity() - 1) >= this.hashTable.size()) {
            return null;
        }
        int index = this.hashTable.get(hash);
        while (index != -1 && !this.equalsPair(this.overlappingPairArray.getQuick(index), proxyId1, proxyId2)) {
            index = this.next.get(index);
        }
        if (index == -1) {
            return null;
        }
        assert (index < this.overlappingPairArray.size());
        return this.overlappingPairArray.getQuick(index);
    }

    public int getCount() {
        return this.overlappingPairArray.size();
    }

    public OverlapFilterCallback getOverlapFilterCallback() {
        return this.overlapFilterCallback;
    }

    @Override
    public void setOverlapFilterCallback(OverlapFilterCallback overlapFilterCallback) {
        this.overlapFilterCallback = overlapFilterCallback;
    }

    @Override
    public int getNumOverlappingPairs() {
        return this.overlappingPairArray.size();
    }

    @Override
    public boolean hasDeferredRemoval() {
        return false;
    }

    private BroadphasePair internalAddPair(BroadphaseProxy proxy0, BroadphaseProxy proxy1) {
        int newCapacity;
        int proxyId2;
        int proxyId1;
        int hash;
        BroadphasePair pair;
        if (proxy0.getUid() > proxy1.getUid()) {
            BroadphaseProxy tmp = proxy0;
            proxy0 = proxy1;
            proxy1 = tmp;
        }
        if ((pair = this.internalFindPair(proxy0, proxy1, hash = this.getHash(proxyId1 = proxy0.getUid(), proxyId2 = proxy1.getUid()) & this.overlappingPairArray.capacity() - 1)) != null) {
            return pair;
        }
        int count = this.overlappingPairArray.size();
        int oldCapacity = this.overlappingPairArray.capacity();
        this.overlappingPairArray.add(null);
        if (this.ghostPairCallback != null) {
            this.ghostPairCallback.addOverlappingPair(proxy0, proxy1);
        }
        if (oldCapacity < (newCapacity = this.overlappingPairArray.capacity())) {
            this.growTables();
            hash = this.getHash(proxyId1, proxyId2) & this.overlappingPairArray.capacity() - 1;
        }
        pair = new BroadphasePair(proxy0, proxy1);
        pair.algorithm = null;
        pair.userInfo = null;
        this.overlappingPairArray.setQuick(this.overlappingPairArray.size() - 1, pair);
        this.next.set(count, this.hashTable.get(hash));
        this.hashTable.set(hash, count);
        return pair;
    }

    private void growTables() {
        int newCapacity = this.overlappingPairArray.capacity();
        if (this.hashTable.size() < newCapacity) {
            int i;
            int curHashtableSize = this.hashTable.size();
            MiscUtil.resize(this.hashTable, newCapacity, 0);
            MiscUtil.resize(this.next, newCapacity, 0);
            for (i = 0; i < newCapacity; ++i) {
                this.hashTable.set(i, -1);
            }
            for (i = 0; i < newCapacity; ++i) {
                this.next.set(i, -1);
            }
            for (i = 0; i < curHashtableSize; ++i) {
                BroadphasePair pair = this.overlappingPairArray.getQuick(i);
                int proxyId1 = pair.pProxy0.getUid();
                int proxyId2 = pair.pProxy1.getUid();
                int hashValue = this.getHash(proxyId1, proxyId2) & this.overlappingPairArray.capacity() - 1;
                this.next.set(i, this.hashTable.get(hashValue));
                this.hashTable.set(hashValue, i);
            }
        }
    }

    private boolean equalsPair(BroadphasePair pair, int proxyId1, int proxyId2) {
        return pair.pProxy0.getUid() == proxyId1 && pair.pProxy1.getUid() == proxyId2;
    }

    private int getHash(int proxyId1, int proxyId2) {
        int key = proxyId1 | proxyId2 << 16;
        key += ~(key << 15);
        key ^= key >>> 10;
        key += key << 3;
        key ^= key >>> 6;
        key += ~(key << 11);
        key ^= key >>> 16;
        return key;
    }

    private BroadphasePair internalFindPair(BroadphaseProxy proxy0, BroadphaseProxy proxy1, int hash) {
        int proxyId1 = proxy0.getUid();
        int proxyId2 = proxy1.getUid();
        int index = this.hashTable.get(hash);
        while (index != -1 && !this.equalsPair(this.overlappingPairArray.getQuick(index), proxyId1, proxyId2)) {
            index = this.next.get(index);
        }
        if (index == -1) {
            return null;
        }
        assert (index < this.overlappingPairArray.size());
        return this.overlappingPairArray.getQuick(index);
    }

    @Override
    public void setInternalGhostPairCallback(OverlappingPairCallback ghostPairCallback) {
        this.ghostPairCallback = ghostPairCallback;
    }

    private static class CleanPairCallback
    extends OverlapCallback {
        private BroadphaseProxy cleanProxy;
        private OverlappingPairCache pairCache;
        private Dispatcher dispatcher;

        public CleanPairCallback(BroadphaseProxy cleanProxy, OverlappingPairCache pairCache, Dispatcher dispatcher) {
            this.cleanProxy = cleanProxy;
            this.pairCache = pairCache;
            this.dispatcher = dispatcher;
        }

        @Override
        public boolean processOverlap(BroadphasePair pair) {
            if (pair.pProxy0 == this.cleanProxy || pair.pProxy1 == this.cleanProxy) {
                this.pairCache.cleanOverlappingPair(pair, this.dispatcher);
            }
            return false;
        }
    }

    private static class RemovePairCallback
    extends OverlapCallback {
        private BroadphaseProxy obsoleteProxy;

        public RemovePairCallback(BroadphaseProxy obsoleteProxy) {
            this.obsoleteProxy = obsoleteProxy;
        }

        @Override
        public boolean processOverlap(BroadphasePair pair) {
            return pair.pProxy0 == this.obsoleteProxy || pair.pProxy1 == this.obsoleteProxy;
        }
    }
}

