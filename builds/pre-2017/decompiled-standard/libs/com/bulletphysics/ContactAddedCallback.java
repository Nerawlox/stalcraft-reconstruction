/*
 * Decompiled with CFR 0.152.
 */
package com.bulletphysics;

import com.bulletphysics.collision.dispatch.CollisionObject;
import com.bulletphysics.collision.narrowphase.ManifoldPoint;

public abstract class ContactAddedCallback {
    public abstract boolean contactAdded(ManifoldPoint var1, CollisionObject var2, int var3, int var4, CollisionObject var5, int var6, int var7);
}

