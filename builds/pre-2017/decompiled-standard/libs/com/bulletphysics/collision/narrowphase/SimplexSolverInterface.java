/*
 * Decompiled with CFR 0.152.
 */
package com.bulletphysics.collision.narrowphase;

import javax.vecmath.Vector3f;

public abstract class SimplexSolverInterface {
    public abstract void reset();

    public abstract void addVertex(Vector3f var1, Vector3f var2, Vector3f var3);

    public abstract boolean closest(Vector3f var1);

    public abstract float maxVertex();

    public abstract boolean fullSimplex();

    public abstract int getSimplex(Vector3f[] var1, Vector3f[] var2, Vector3f[] var3);

    public abstract boolean inSimplex(Vector3f var1);

    public abstract void backup_closest(Vector3f var1);

    public abstract boolean emptySimplex();

    public abstract void compute_points(Vector3f var1, Vector3f var2);

    public abstract int numVertices();
}

