/*
 * Decompiled with CFR 0.152.
 */
package com.bulletphysics.collision.broadphase;

import com.bulletphysics.collision.broadphase.BroadphasePair;
import com.bulletphysics.collision.broadphase.BroadphaseProxy;
import com.bulletphysics.collision.broadphase.Dispatcher;

public abstract class OverlappingPairCallback {
    public abstract BroadphasePair addOverlappingPair(BroadphaseProxy var1, BroadphaseProxy var2);

    public abstract Object removeOverlappingPair(BroadphaseProxy var1, BroadphaseProxy var2, Dispatcher var3);

    public abstract void removeOverlappingPairsContainingProxy(BroadphaseProxy var1, Dispatcher var2);
}

