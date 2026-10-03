/*
 * Decompiled with CFR 0.152.
 */
package com.bulletphysics.collision.broadphase;

import com.bulletphysics.collision.broadphase.DispatchFunc;
import com.bulletphysics.linearmath.IDebugDraw;

public class DispatcherInfo {
    public float timeStep;
    public int stepCount;
    public DispatchFunc dispatchFunc = DispatchFunc.DISPATCH_DISCRETE;
    public float timeOfImpact = 1.0f;
    public boolean useContinuous;
    public IDebugDraw debugDraw;
    public boolean enableSatConvex;
    public boolean enableSPU = true;
    public boolean useEpa = true;
    public float allowedCcdPenetration = 0.04f;
}

