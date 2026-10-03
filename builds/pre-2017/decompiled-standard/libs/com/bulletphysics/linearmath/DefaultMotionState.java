/*
 * Decompiled with CFR 0.152.
 */
package com.bulletphysics.linearmath;

import com.bulletphysics.linearmath.MotionState;
import com.bulletphysics.linearmath.Transform;

public class DefaultMotionState
extends MotionState {
    public final Transform graphicsWorldTrans = new Transform();
    public final Transform centerOfMassOffset = new Transform();
    public final Transform startWorldTrans = new Transform();

    public DefaultMotionState() {
        this.graphicsWorldTrans.setIdentity();
        this.centerOfMassOffset.setIdentity();
        this.startWorldTrans.setIdentity();
    }

    public DefaultMotionState(Transform startTrans) {
        this.graphicsWorldTrans.set(startTrans);
        this.centerOfMassOffset.setIdentity();
        this.startWorldTrans.set(startTrans);
    }

    public DefaultMotionState(Transform startTrans, Transform centerOfMassOffset) {
        this.graphicsWorldTrans.set(startTrans);
        this.centerOfMassOffset.set(centerOfMassOffset);
        this.startWorldTrans.set(startTrans);
    }

    @Override
    public Transform getWorldTransform(Transform out) {
        out.inverse(this.centerOfMassOffset);
        out.mul(this.graphicsWorldTrans);
        return out;
    }

    @Override
    public void setWorldTransform(Transform centerOfMassWorldTrans) {
        this.graphicsWorldTrans.set(centerOfMassWorldTrans);
        this.graphicsWorldTrans.mul(this.centerOfMassOffset);
    }
}

