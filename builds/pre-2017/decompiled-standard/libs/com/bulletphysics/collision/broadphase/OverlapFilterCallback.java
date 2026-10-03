/*
 * Decompiled with CFR 0.152.
 */
package com.bulletphysics.collision.broadphase;

import com.bulletphysics.collision.broadphase.BroadphaseProxy;

public abstract class OverlapFilterCallback {
    public abstract boolean needBroadphaseCollision(BroadphaseProxy var1, BroadphaseProxy var2);
}

