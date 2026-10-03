/*
 * Decompiled with CFR 0.152.
 */
package com.bulletphysics.extras.gimpact;

import javax.vecmath.Vector3f;

class GImpactMassUtil {
    GImpactMassUtil() {
    }

    public static Vector3f get_point_inertia(Vector3f point, float mass, Vector3f out) {
        float x2 = point.x * point.x;
        float y2 = point.y * point.y;
        float z2 = point.z * point.z;
        out.set(mass * (y2 + z2), mass * (x2 + z2), mass * (x2 + y2));
        return out;
    }
}

