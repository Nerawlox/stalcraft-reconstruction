/*
 * Decompiled with CFR 0.152.
 */
package com.bulletphysics.dynamics;

import com.bulletphysics.collision.shapes.CollisionShape;
import com.bulletphysics.linearmath.MotionState;
import com.bulletphysics.linearmath.Transform;
import javax.vecmath.Vector3f;

public class RigidBodyConstructionInfo {
    public float mass;
    public MotionState motionState;
    public final Transform startWorldTransform = new Transform();
    public CollisionShape collisionShape;
    public final Vector3f localInertia = new Vector3f();
    public float linearDamping = 0.0f;
    public float angularDamping = 0.0f;
    public float friction = 0.5f;
    public float restitution = 0.0f;
    public float linearSleepingThreshold = 0.8f;
    public float angularSleepingThreshold = 1.0f;
    public boolean additionalDamping = false;
    public float additionalDampingFactor = 0.005f;
    public float additionalLinearDampingThresholdSqr = 0.01f;
    public float additionalAngularDampingThresholdSqr = 0.01f;
    public float additionalAngularDampingFactor = 0.01f;

    public RigidBodyConstructionInfo(float mass, MotionState motionState, CollisionShape collisionShape) {
        this(mass, motionState, collisionShape, new Vector3f(0.0f, 0.0f, 0.0f));
    }

    public RigidBodyConstructionInfo(float mass, MotionState motionState, CollisionShape collisionShape, Vector3f localInertia) {
        this.mass = mass;
        this.motionState = motionState;
        this.collisionShape = collisionShape;
        this.localInertia.set(localInertia);
        this.startWorldTransform.setIdentity();
    }
}

