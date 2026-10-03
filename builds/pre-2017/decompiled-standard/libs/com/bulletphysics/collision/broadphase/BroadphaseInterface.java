/*
 * Decompiled with CFR 0.152.
 */
package com.bulletphysics.collision.broadphase;

import com.bulletphysics.collision.broadphase.BroadphaseNativeType;
import com.bulletphysics.collision.broadphase.BroadphaseProxy;
import com.bulletphysics.collision.broadphase.Dispatcher;
import com.bulletphysics.collision.broadphase.OverlappingPairCache;
import javax.vecmath.Vector3f;

public abstract class BroadphaseInterface {
    public abstract BroadphaseProxy createProxy(Vector3f var1, Vector3f var2, BroadphaseNativeType var3, Object var4, short var5, short var6, Dispatcher var7, Object var8);

    public abstract void destroyProxy(BroadphaseProxy var1, Dispatcher var2);

    public abstract void setAabb(BroadphaseProxy var1, Vector3f var2, Vector3f var3, Dispatcher var4);

    public abstract void calculateOverlappingPairs(Dispatcher var1);

    public abstract OverlappingPairCache getOverlappingPairCache();

    public abstract void getBroadphaseAabb(Vector3f var1, Vector3f var2);

    public abstract void printStats();
}

