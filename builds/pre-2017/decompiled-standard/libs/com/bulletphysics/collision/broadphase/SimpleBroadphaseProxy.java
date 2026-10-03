/*
 * Decompiled with CFR 0.152.
 */
package com.bulletphysics.collision.broadphase;

import com.bulletphysics.collision.broadphase.BroadphaseNativeType;
import com.bulletphysics.collision.broadphase.BroadphaseProxy;
import javax.vecmath.Vector3f;

class SimpleBroadphaseProxy
extends BroadphaseProxy {
    protected final Vector3f min = new Vector3f();
    protected final Vector3f max = new Vector3f();

    public SimpleBroadphaseProxy() {
    }

    public SimpleBroadphaseProxy(Vector3f minpt, Vector3f maxpt, BroadphaseNativeType shapeType, Object userPtr, short collisionFilterGroup, short collisionFilterMask, Object multiSapProxy) {
        super(userPtr, collisionFilterGroup, collisionFilterMask, multiSapProxy);
        this.min.set(minpt);
        this.max.set(maxpt);
    }
}

