/*
 * Decompiled with CFR 0.152.
 */
package com.bulletphysics.collision.narrowphase;

import com.bulletphysics.linearmath.IDebugDraw;
import com.bulletphysics.linearmath.Transform;
import javax.vecmath.Vector3f;

public abstract class ConvexCast {
    public abstract boolean calcTimeOfImpact(Transform var1, Transform var2, Transform var3, Transform var4, CastResult var5);

    public static class CastResult {
        public final Transform hitTransformA = new Transform();
        public final Transform hitTransformB = new Transform();
        public final Vector3f normal = new Vector3f();
        public final Vector3f hitPoint = new Vector3f();
        public float fraction = 1.0E30f;
        public float allowedPenetration = 0.0f;
        public IDebugDraw debugDrawer;

        public void debugDraw(float fraction) {
        }

        public void drawCoordSystem(Transform trans) {
        }
    }
}

