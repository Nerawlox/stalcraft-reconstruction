/*
 * Decompiled with CFR 0.152.
 */
package com.bulletphysics.collision.broadphase;

import com.bulletphysics.collision.broadphase.BroadphasePair;
import com.bulletphysics.collision.broadphase.BroadphaseProxy;
import com.bulletphysics.collision.broadphase.Dispatcher;
import com.bulletphysics.collision.broadphase.OverlapCallback;
import com.bulletphysics.collision.broadphase.OverlapFilterCallback;
import com.bulletphysics.collision.broadphase.OverlappingPairCallback;
import com.bulletphysics.util.ObjectArrayList;

public abstract class OverlappingPairCache
extends OverlappingPairCallback {
    public abstract ObjectArrayList<BroadphasePair> getOverlappingPairArray();

    public abstract void cleanOverlappingPair(BroadphasePair var1, Dispatcher var2);

    public abstract int getNumOverlappingPairs();

    public abstract void cleanProxyFromPairs(BroadphaseProxy var1, Dispatcher var2);

    public abstract void setOverlapFilterCallback(OverlapFilterCallback var1);

    public abstract void processAllOverlappingPairs(OverlapCallback var1, Dispatcher var2);

    public abstract BroadphasePair findPair(BroadphaseProxy var1, BroadphaseProxy var2);

    public abstract boolean hasDeferredRemoval();

    public abstract void setInternalGhostPairCallback(OverlappingPairCallback var1);
}

