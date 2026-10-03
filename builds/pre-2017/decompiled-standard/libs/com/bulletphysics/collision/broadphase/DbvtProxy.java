/*
 * Decompiled with CFR 0.152.
 */
package com.bulletphysics.collision.broadphase;

import com.bulletphysics.collision.broadphase.BroadphaseProxy;
import com.bulletphysics.collision.broadphase.Dbvt;
import com.bulletphysics.collision.broadphase.DbvtAabbMm;

public class DbvtProxy
extends BroadphaseProxy {
    public final DbvtAabbMm aabb = new DbvtAabbMm();
    public Dbvt.Node leaf;
    public final DbvtProxy[] links = new DbvtProxy[2];
    public int stage;

    public DbvtProxy(Object userPtr, short collisionFilterGroup, short collisionFilterMask) {
        super(userPtr, collisionFilterGroup, collisionFilterMask);
    }
}

