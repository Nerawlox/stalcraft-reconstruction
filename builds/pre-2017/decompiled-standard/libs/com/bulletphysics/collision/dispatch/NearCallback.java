/*
 * Decompiled with CFR 0.152.
 */
package com.bulletphysics.collision.dispatch;

import com.bulletphysics.collision.broadphase.BroadphasePair;
import com.bulletphysics.collision.broadphase.DispatcherInfo;
import com.bulletphysics.collision.dispatch.CollisionDispatcher;

public abstract class NearCallback {
    public abstract void handleCollision(BroadphasePair var1, CollisionDispatcher var2, DispatcherInfo var3);
}

