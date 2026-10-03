/*
 * Decompiled with CFR 0.152.
 */
package com.bulletphysics.collision.narrowphase;

import javax.vecmath.Vector3f;

public class ManifoldPoint {
    public final Vector3f localPointA = new Vector3f();
    public final Vector3f localPointB = new Vector3f();
    public final Vector3f positionWorldOnB = new Vector3f();
    public final Vector3f positionWorldOnA = new Vector3f();
    public final Vector3f normalWorldOnB = new Vector3f();
    public float distance1;
    public float combinedFriction;
    public float combinedRestitution;
    public int partId0;
    public int partId1;
    public int index0;
    public int index1;
    public Object userPersistentData;
    public float appliedImpulse;
    public boolean lateralFrictionInitialized;
    public float appliedImpulseLateral1;
    public float appliedImpulseLateral2;
    public int lifeTime;
    public final Vector3f lateralFrictionDir1 = new Vector3f();
    public final Vector3f lateralFrictionDir2 = new Vector3f();

    public ManifoldPoint() {
        this.userPersistentData = null;
        this.appliedImpulse = 0.0f;
        this.lateralFrictionInitialized = false;
        this.lifeTime = 0;
    }

    public ManifoldPoint(Vector3f pointA, Vector3f pointB, Vector3f normal, float distance) {
        this.init(pointA, pointB, normal, distance);
    }

    public void init(Vector3f pointA, Vector3f pointB, Vector3f normal, float distance) {
        this.localPointA.set(pointA);
        this.localPointB.set(pointB);
        this.normalWorldOnB.set(normal);
        this.distance1 = distance;
        this.combinedFriction = 0.0f;
        this.combinedRestitution = 0.0f;
        this.userPersistentData = null;
        this.appliedImpulse = 0.0f;
        this.lateralFrictionInitialized = false;
        this.appliedImpulseLateral1 = 0.0f;
        this.appliedImpulseLateral2 = 0.0f;
        this.lifeTime = 0;
    }

    public float getDistance() {
        return this.distance1;
    }

    public int getLifeTime() {
        return this.lifeTime;
    }

    public void set(ManifoldPoint p) {
        this.localPointA.set(p.localPointA);
        this.localPointB.set(p.localPointB);
        this.positionWorldOnA.set(p.positionWorldOnA);
        this.positionWorldOnB.set(p.positionWorldOnB);
        this.normalWorldOnB.set(p.normalWorldOnB);
        this.distance1 = p.distance1;
        this.combinedFriction = p.combinedFriction;
        this.combinedRestitution = p.combinedRestitution;
        this.partId0 = p.partId0;
        this.partId1 = p.partId1;
        this.index0 = p.index0;
        this.index1 = p.index1;
        this.userPersistentData = p.userPersistentData;
        this.appliedImpulse = p.appliedImpulse;
        this.lateralFrictionInitialized = p.lateralFrictionInitialized;
        this.appliedImpulseLateral1 = p.appliedImpulseLateral1;
        this.appliedImpulseLateral2 = p.appliedImpulseLateral2;
        this.lifeTime = p.lifeTime;
        this.lateralFrictionDir1.set(p.lateralFrictionDir1);
        this.lateralFrictionDir2.set(p.lateralFrictionDir2);
    }

    public Vector3f getPositionWorldOnA(Vector3f out) {
        out.set(this.positionWorldOnA);
        return out;
    }

    public Vector3f getPositionWorldOnB(Vector3f out) {
        out.set(this.positionWorldOnB);
        return out;
    }

    public void setDistance(float dist) {
        this.distance1 = dist;
    }
}

