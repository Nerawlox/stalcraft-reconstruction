/*
 * Decompiled with CFR 0.152.
 */
package com.bulletphysics.collision.dispatch;

import com.bulletphysics.collision.broadphase.CollisionAlgorithm;
import com.bulletphysics.collision.broadphase.CollisionAlgorithmConstructionInfo;
import com.bulletphysics.collision.dispatch.CollisionObject;

public abstract class CollisionAlgorithmCreateFunc {
    public boolean swapped;

    public abstract CollisionAlgorithm createCollisionAlgorithm(CollisionAlgorithmConstructionInfo var1, CollisionObject var2, CollisionObject var3);

    public abstract void releaseCollisionAlgorithm(CollisionAlgorithm var1);
}

