/*
 * Decompiled with CFR 0.152.
 */
package com.bulletphysics.linearmath;

import com.bulletphysics.linearmath.Transform;

public abstract class MotionState {
    public abstract Transform getWorldTransform(Transform var1);

    public abstract void setWorldTransform(Transform var1);
}

