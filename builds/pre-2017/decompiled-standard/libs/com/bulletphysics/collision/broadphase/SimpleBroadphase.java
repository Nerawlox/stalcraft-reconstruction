/*
 * Decompiled with CFR 0.152.
 */
package com.bulletphysics.collision.broadphase;

import com.bulletphysics.collision.broadphase.BroadphaseInterface;
import com.bulletphysics.collision.broadphase.BroadphaseNativeType;
import com.bulletphysics.collision.broadphase.BroadphaseProxy;
import com.bulletphysics.collision.broadphase.Dispatcher;
import com.bulletphysics.collision.broadphase.HashedOverlappingPairCache;
import com.bulletphysics.collision.broadphase.OverlappingPairCache;
import com.bulletphysics.collision.broadphase.SimpleBroadphaseProxy;
import com.bulletphysics.util.ObjectArrayList;
import javax.vecmath.Vector3f;

public class SimpleBroadphase
extends BroadphaseInterface {
    private final ObjectArrayList<SimpleBroadphaseProxy> handles = new ObjectArrayList();
    private int maxHandles;
    private OverlappingPairCache pairCache;
    private boolean ownsPairCache;

    public SimpleBroadphase() {
        this(16384, null);
    }

    public SimpleBroadphase(int maxProxies) {
        this(maxProxies, null);
    }

    public SimpleBroadphase(int maxProxies, OverlappingPairCache overlappingPairCache) {
        this.pairCache = overlappingPairCache;
        if (overlappingPairCache == null) {
            this.pairCache = new HashedOverlappingPairCache();
            this.ownsPairCache = true;
        }
    }

    @Override
    public BroadphaseProxy createProxy(Vector3f aabbMin, Vector3f aabbMax, BroadphaseNativeType shapeType, Object userPtr, short collisionFilterGroup, short collisionFilterMask, Dispatcher dispatcher, Object multiSapProxy) {
        assert (aabbMin.x <= aabbMax.x && aabbMin.y <= aabbMax.y && aabbMin.z <= aabbMax.z);
        SimpleBroadphaseProxy proxy = new SimpleBroadphaseProxy(aabbMin, aabbMax, shapeType, userPtr, collisionFilterGroup, collisionFilterMask, multiSapProxy);
        proxy.uniqueId = this.handles.size();
        this.handles.add(proxy);
        return proxy;
    }

    @Override
    public void destroyProxy(BroadphaseProxy proxyOrg, Dispatcher dispatcher) {
        this.handles.remove(proxyOrg);
        this.pairCache.removeOverlappingPairsContainingProxy(proxyOrg, dispatcher);
    }

    @Override
    public void setAabb(BroadphaseProxy proxy, Vector3f aabbMin, Vector3f aabbMax, Dispatcher dispatcher) {
        SimpleBroadphaseProxy sbp = (SimpleBroadphaseProxy)proxy;
        sbp.min.set(aabbMin);
        sbp.max.set(aabbMax);
    }

    private static boolean aabbOverlap(SimpleBroadphaseProxy proxy0, SimpleBroadphaseProxy proxy1) {
        return proxy0.min.x <= proxy1.max.x && proxy1.min.x <= proxy0.max.x && proxy0.min.y <= proxy1.max.y && proxy1.min.y <= proxy0.max.y && proxy0.min.z <= proxy1.max.z && proxy1.min.z <= proxy0.max.z;
    }

    @Override
    public void calculateOverlappingPairs(Dispatcher dispatcher) {
        for (int i = 0; i < this.handles.size(); ++i) {
            SimpleBroadphaseProxy proxy0 = this.handles.getQuick(i);
            for (int j = 0; j < this.handles.size(); ++j) {
                SimpleBroadphaseProxy proxy1 = this.handles.getQuick(j);
                if (proxy0 == proxy1) continue;
                if (SimpleBroadphase.aabbOverlap(proxy0, proxy1)) {
                    if (this.pairCache.findPair(proxy0, proxy1) != null) continue;
                    this.pairCache.addOverlappingPair(proxy0, proxy1);
                    continue;
                }
                if (this.pairCache.hasDeferredRemoval() || this.pairCache.findPair(proxy0, proxy1) == null) continue;
                this.pairCache.removeOverlappingPair(proxy0, proxy1, dispatcher);
            }
        }
    }

    @Override
    public OverlappingPairCache getOverlappingPairCache() {
        return this.pairCache;
    }

    @Override
    public void getBroadphaseAabb(Vector3f aabbMin, Vector3f aabbMax) {
        aabbMin.set(-1.0E30f, -1.0E30f, -1.0E30f);
        aabbMax.set(1.0E30f, 1.0E30f, 1.0E30f);
    }

    @Override
    public void printStats() {
    }
}

