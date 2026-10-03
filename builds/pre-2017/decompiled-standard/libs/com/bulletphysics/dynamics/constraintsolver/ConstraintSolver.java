/*
 * Decompiled with CFR 0.152.
 */
package com.bulletphysics.dynamics.constraintsolver;

import com.bulletphysics.collision.broadphase.Dispatcher;
import com.bulletphysics.collision.dispatch.CollisionObject;
import com.bulletphysics.collision.narrowphase.PersistentManifold;
import com.bulletphysics.dynamics.constraintsolver.ContactSolverInfo;
import com.bulletphysics.dynamics.constraintsolver.TypedConstraint;
import com.bulletphysics.linearmath.IDebugDraw;
import com.bulletphysics.util.ObjectArrayList;

public abstract class ConstraintSolver {
    public void prepareSolve(int numBodies, int numManifolds) {
    }

    public abstract float solveGroup(ObjectArrayList<CollisionObject> var1, int var2, ObjectArrayList<PersistentManifold> var3, int var4, int var5, ObjectArrayList<TypedConstraint> var6, int var7, int var8, ContactSolverInfo var9, IDebugDraw var10, Dispatcher var11);

    public void allSolved(ContactSolverInfo info, IDebugDraw debugDrawer) {
    }

    public abstract void reset();
}

