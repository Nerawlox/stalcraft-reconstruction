/*
 * Decompiled with CFR 0.152.
 */
package com.bulletphysics.collision.narrowphase;

import com.bulletphysics.collision.narrowphase.SimplexSolverInterface;
import com.bulletphysics.collision.shapes.ConvexShape;
import com.bulletphysics.linearmath.IDebugDraw;
import com.bulletphysics.linearmath.Transform;
import javax.vecmath.Vector3f;

public abstract class ConvexPenetrationDepthSolver {
    public abstract boolean calcPenDepth(SimplexSolverInterface var1, ConvexShape var2, ConvexShape var3, Transform var4, Transform var5, Vector3f var6, Vector3f var7, Vector3f var8, IDebugDraw var9);
}

