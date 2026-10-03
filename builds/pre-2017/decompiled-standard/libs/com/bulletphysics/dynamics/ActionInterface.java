/*
 * Decompiled with CFR 0.152.
 */
package com.bulletphysics.dynamics;

import com.bulletphysics.collision.dispatch.CollisionWorld;
import com.bulletphysics.linearmath.IDebugDraw;

public abstract class ActionInterface {
    public abstract void updateAction(CollisionWorld var1, float var2);

    public abstract void debugDraw(IDebugDraw var1);
}

