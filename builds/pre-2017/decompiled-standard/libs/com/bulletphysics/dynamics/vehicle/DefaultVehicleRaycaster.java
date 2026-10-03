/*
 * Decompiled with CFR 0.152.
 */
package com.bulletphysics.dynamics.vehicle;

import com.bulletphysics.collision.dispatch.CollisionWorld;
import com.bulletphysics.dynamics.DynamicsWorld;
import com.bulletphysics.dynamics.RigidBody;
import com.bulletphysics.dynamics.vehicle.VehicleRaycaster;
import com.bulletphysics.dynamics.vehicle.VehicleRaycasterResult;
import javax.vecmath.Vector3f;

public class DefaultVehicleRaycaster
extends VehicleRaycaster {
    protected DynamicsWorld dynamicsWorld;

    public DefaultVehicleRaycaster(DynamicsWorld world) {
        this.dynamicsWorld = world;
    }

    @Override
    public Object castRay(Vector3f from, Vector3f to, VehicleRaycasterResult result2) {
        RigidBody body;
        CollisionWorld.ClosestRayResultCallback rayCallback = new CollisionWorld.ClosestRayResultCallback(from, to);
        this.dynamicsWorld.rayTest(from, to, rayCallback);
        if (rayCallback.hasHit() && (body = RigidBody.upcast(rayCallback.collisionObject)) != null && body.hasContactResponse()) {
            result2.hitPointInWorld.set(rayCallback.hitPointWorld);
            result2.hitNormalInWorld.set(rayCallback.hitNormalWorld);
            result2.hitNormalInWorld.normalize();
            result2.distFraction = rayCallback.closestHitFraction;
            return body;
        }
        return null;
    }
}

