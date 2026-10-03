/*
 * Decompiled with CFR 0.152.
 */
package com.bulletphysics.collision.dispatch;

import com.bulletphysics.collision.broadphase.BroadphasePair;
import com.bulletphysics.collision.broadphase.BroadphaseProxy;
import com.bulletphysics.collision.broadphase.Dispatcher;
import com.bulletphysics.collision.broadphase.OverlappingPairCallback;
import com.bulletphysics.collision.dispatch.CollisionObject;
import com.bulletphysics.collision.dispatch.GhostObject;

public class GhostPairCallback
extends OverlappingPairCallback {
    @Override
    public BroadphasePair addOverlappingPair(BroadphaseProxy proxy0, BroadphaseProxy proxy1) {
        CollisionObject colObj0 = (CollisionObject)proxy0.clientObject;
        CollisionObject colObj1 = (CollisionObject)proxy1.clientObject;
        GhostObject ghost0 = GhostObject.upcast(colObj0);
        GhostObject ghost1 = GhostObject.upcast(colObj1);
        if (ghost0 != null) {
            ghost0.addOverlappingObjectInternal(proxy1, proxy0);
        }
        if (ghost1 != null) {
            ghost1.addOverlappingObjectInternal(proxy0, proxy1);
        }
        return null;
    }

    @Override
    public Object removeOverlappingPair(BroadphaseProxy proxy0, BroadphaseProxy proxy1, Dispatcher dispatcher) {
        CollisionObject colObj0 = (CollisionObject)proxy0.clientObject;
        CollisionObject colObj1 = (CollisionObject)proxy1.clientObject;
        GhostObject ghost0 = GhostObject.upcast(colObj0);
        GhostObject ghost1 = GhostObject.upcast(colObj1);
        if (ghost0 != null) {
            ghost0.removeOverlappingObjectInternal(proxy1, dispatcher, proxy0);
        }
        if (ghost1 != null) {
            ghost1.removeOverlappingObjectInternal(proxy0, dispatcher, proxy1);
        }
        return null;
    }

    @Override
    public void removeOverlappingPairsContainingProxy(BroadphaseProxy proxy0, Dispatcher dispatcher) {
        assert (false);
    }
}

