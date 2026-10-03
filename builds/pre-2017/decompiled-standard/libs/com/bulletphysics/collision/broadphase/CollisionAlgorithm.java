/*
 * Decompiled with CFR 0.152.
 */
package com.bulletphysics.collision.broadphase;

import com.bulletphysics.collision.broadphase.CollisionAlgorithmConstructionInfo;
import com.bulletphysics.collision.broadphase.Dispatcher;
import com.bulletphysics.collision.broadphase.DispatcherInfo;
import com.bulletphysics.collision.dispatch.CollisionAlgorithmCreateFunc;
import com.bulletphysics.collision.dispatch.CollisionObject;
import com.bulletphysics.collision.dispatch.ManifoldResult;
import com.bulletphysics.collision.narrowphase.PersistentManifold;
import com.bulletphysics.util.ObjectArrayList;

public abstract class CollisionAlgorithm {
    private CollisionAlgorithmCreateFunc createFunc;
    protected Dispatcher dispatcher;

    public void init() {
    }

    public void init(CollisionAlgorithmConstructionInfo ci) {
        this.dispatcher = ci.dispatcher1;
    }

    public abstract void destroy();

    public abstract void processCollision(CollisionObject var1, CollisionObject var2, DispatcherInfo var3, ManifoldResult var4);

    public abstract float calculateTimeOfImpact(CollisionObject var1, CollisionObject var2, DispatcherInfo var3, ManifoldResult var4);

    public abstract void getAllContactManifolds(ObjectArrayList<PersistentManifold> var1);

    public final void internalSetCreateFunc(CollisionAlgorithmCreateFunc func) {
        this.createFunc = func;
    }

    public final CollisionAlgorithmCreateFunc internalGetCreateFunc() {
        return this.createFunc;
    }
}

