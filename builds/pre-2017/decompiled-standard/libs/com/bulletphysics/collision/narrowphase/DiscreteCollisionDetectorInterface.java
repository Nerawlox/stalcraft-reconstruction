/*
 * Decompiled with CFR 0.152.
 */
package com.bulletphysics.collision.narrowphase;

import com.bulletphysics.linearmath.IDebugDraw;
import com.bulletphysics.linearmath.Transform;
import javax.vecmath.Vector3f;

public abstract class DiscreteCollisionDetectorInterface {
    public final void getClosestPoints(ClosestPointInput input, Result output, IDebugDraw debugDraw) {
        this.getClosestPoints(input, output, debugDraw, false);
    }

    public abstract void getClosestPoints(ClosestPointInput var1, Result var2, IDebugDraw var3, boolean var4);

    public static class ClosestPointInput {
        public final Transform transformA = new Transform();
        public final Transform transformB = new Transform();
        public float maximumDistanceSquared;

        public ClosestPointInput() {
            this.init();
        }

        public void init() {
            this.maximumDistanceSquared = Float.MAX_VALUE;
        }
    }

    public static abstract class Result {
        public abstract void setShapeIdentifiers(int var1, int var2, int var3, int var4);

        public abstract void addContactPoint(Vector3f var1, Vector3f var2, float var3);
    }
}

