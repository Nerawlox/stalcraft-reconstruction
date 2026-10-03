/*
 * Decompiled with CFR 0.152.
 */
package com.bulletphysics.collision.dispatch;

import com.bulletphysics.collision.broadphase.BroadphaseNativeType;
import com.bulletphysics.collision.dispatch.CollisionAlgorithmCreateFunc;

public abstract class CollisionConfiguration {
    public abstract CollisionAlgorithmCreateFunc getCollisionAlgorithmCreateFunc(BroadphaseNativeType var1, BroadphaseNativeType var2);
}

