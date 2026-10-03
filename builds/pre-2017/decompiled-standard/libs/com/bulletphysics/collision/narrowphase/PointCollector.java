/*
 * Decompiled with CFR 0.152.
 */
package com.bulletphysics.collision.narrowphase;

import com.bulletphysics.collision.narrowphase.DiscreteCollisionDetectorInterface;
import javax.vecmath.Vector3f;

public class PointCollector
extends DiscreteCollisionDetectorInterface.Result {
    public final Vector3f normalOnBInWorld = new Vector3f();
    public final Vector3f pointInWorld = new Vector3f();
    public float distance = 1.0E30f;
    public boolean hasResult = false;

    @Override
    public void setShapeIdentifiers(int partId0, int index0, int partId1, int index1) {
    }

    @Override
    public void addContactPoint(Vector3f normalOnBInWorld, Vector3f pointInWorld, float depth) {
        if (depth < this.distance) {
            this.hasResult = true;
            this.normalOnBInWorld.set(normalOnBInWorld);
            this.pointInWorld.set(pointInWorld);
            this.distance = depth;
        }
    }
}

