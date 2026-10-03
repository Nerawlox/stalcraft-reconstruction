/*
 * Decompiled with CFR 0.152.
 */
package com.bulletphysics.dynamics.vehicle;

import com.bulletphysics.dynamics.vehicle.VehicleRaycasterResult;
import javax.vecmath.Vector3f;

public abstract class VehicleRaycaster {
    public abstract Object castRay(Vector3f var1, Vector3f var2, VehicleRaycasterResult var3);
}

