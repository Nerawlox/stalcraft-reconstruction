/*
 * Decompiled with CFR 0.152.
 */
package com.bulletphysics.collision.dispatch;

import com.bulletphysics.collision.broadphase.BroadphaseProxy;
import com.bulletphysics.collision.broadphase.Dispatcher;
import com.bulletphysics.collision.broadphase.HashedOverlappingPairCache;
import com.bulletphysics.collision.dispatch.CollisionObject;
import com.bulletphysics.collision.dispatch.GhostObject;

public class PairCachingGhostObject
extends GhostObject {
    HashedOverlappingPairCache hashPairCache = new HashedOverlappingPairCache();

    @Override
    public void addOverlappingObjectInternal(BroadphaseProxy otherProxy, BroadphaseProxy thisProxy) {
        BroadphaseProxy actualThisProxy;
        BroadphaseProxy broadphaseProxy = actualThisProxy = thisProxy != null ? thisProxy : this.getBroadphaseHandle();
        assert (actualThisProxy != null);
        CollisionObject otherObject = (CollisionObject)otherProxy.clientObject;
        assert (otherObject != null);
        int index = this.overlappingObjects.indexOf(otherObject);
        if (index == -1) {
            this.overlappingObjects.add(otherObject);
            this.hashPairCache.addOverlappingPair(actualThisProxy, otherProxy);
        }
    }

    @Override
    public void removeOverlappingObjectInternal(BroadphaseProxy otherProxy, Dispatcher dispatcher, BroadphaseProxy thisProxy1) {
        BroadphaseProxy actualThisProxy;
        CollisionObject otherObject = (CollisionObject)otherProxy.clientObject;
        BroadphaseProxy broadphaseProxy = actualThisProxy = thisProxy1 != null ? thisProxy1 : this.getBroadphaseHandle();
        assert (actualThisProxy != null);
        assert (otherObject != null);
        int index = this.overlappingObjects.indexOf(otherObject);
        if (index != -1) {
            this.overlappingObjects.setQuick(index, this.overlappingObjects.getQuick(this.overlappingObjects.size() - 1));
            this.overlappingObjects.removeQuick(this.overlappingObjects.size() - 1);
            this.hashPairCache.removeOverlappingPair(actualThisProxy, otherProxy, dispatcher);
        }
    }

    public HashedOverlappingPairCache getOverlappingPairCache() {
        return this.hashPairCache;
    }
}

