/*
 * Decompiled with CFR 0.152.
 */
package com.bulletphysics.collision.dispatch;

import com.bulletphysics.collision.broadphase.BroadphasePair;
import com.bulletphysics.collision.broadphase.DispatchFunc;
import com.bulletphysics.collision.broadphase.DispatcherInfo;
import com.bulletphysics.collision.dispatch.CollisionDispatcher;
import com.bulletphysics.collision.dispatch.CollisionObject;
import com.bulletphysics.collision.dispatch.ManifoldResult;
import com.bulletphysics.collision.dispatch.NearCallback;

public class DefaultNearCallback
extends NearCallback {
    private final ManifoldResult contactPointResult = new ManifoldResult();

    @Override
    public void handleCollision(BroadphasePair collisionPair, CollisionDispatcher dispatcher, DispatcherInfo dispatchInfo) {
        CollisionObject colObj0 = (CollisionObject)collisionPair.pProxy0.clientObject;
        CollisionObject colObj1 = (CollisionObject)collisionPair.pProxy1.clientObject;
        if (dispatcher.needsCollision(colObj0, colObj1)) {
            if (collisionPair.algorithm == null) {
                collisionPair.algorithm = dispatcher.findAlgorithm(colObj0, colObj1);
            }
            if (collisionPair.algorithm != null) {
                this.contactPointResult.init(colObj0, colObj1);
                if (dispatchInfo.dispatchFunc == DispatchFunc.DISPATCH_DISCRETE) {
                    collisionPair.algorithm.processCollision(colObj0, colObj1, dispatchInfo, this.contactPointResult);
                } else {
                    float toi = collisionPair.algorithm.calculateTimeOfImpact(colObj0, colObj1, dispatchInfo, this.contactPointResult);
                    if (dispatchInfo.timeOfImpact > toi) {
                        dispatchInfo.timeOfImpact = toi;
                    }
                }
            }
        }
    }
}

