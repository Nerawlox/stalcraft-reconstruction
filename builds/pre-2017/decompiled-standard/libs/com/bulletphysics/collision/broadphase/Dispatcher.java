/*
 * Decompiled with CFR 0.152.
 */
package com.bulletphysics.collision.broadphase;

import com.bulletphysics.collision.broadphase.CollisionAlgorithm;
import com.bulletphysics.collision.broadphase.DispatcherInfo;
import com.bulletphysics.collision.broadphase.OverlappingPairCache;
import com.bulletphysics.collision.dispatch.CollisionObject;
import com.bulletphysics.collision.narrowphase.PersistentManifold;
import com.bulletphysics.util.ObjectArrayList;

public abstract class Dispatcher {
    public final CollisionAlgorithm findAlgorithm(CollisionObject body0, CollisionObject body1) {
        return this.findAlgorithm(body0, body1, null);
    }

    public abstract CollisionAlgorithm findAlgorithm(CollisionObject var1, CollisionObject var2, PersistentManifold var3);

    public abstract PersistentManifold getNewManifold(Object var1, Object var2);

    public abstract void releaseManifold(PersistentManifold var1);

    public abstract void clearManifold(PersistentManifold var1);

    public abstract boolean needsCollision(CollisionObject var1, CollisionObject var2);

    public abstract boolean needsResponse(CollisionObject var1, CollisionObject var2);

    public abstract void dispatchAllCollisionPairs(OverlappingPairCache var1, DispatcherInfo var2, Dispatcher var3);

    public abstract int getNumManifolds();

    public abstract PersistentManifold getManifoldByIndexInternal(int var1);

    public abstract ObjectArrayList<PersistentManifold> getInternalManifoldPointer();

    public abstract void freeCollisionAlgorithm(CollisionAlgorithm var1);
}

