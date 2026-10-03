/*
 * Decompiled with CFR 0.152.
 */
package com.bulletphysics.dynamics.constraintsolver;

import com.bulletphysics.collision.narrowphase.ManifoldPoint;
import com.bulletphysics.dynamics.RigidBody;
import com.bulletphysics.dynamics.constraintsolver.ContactSolverInfo;

public abstract class ContactSolverFunc {
    public abstract float resolveContact(RigidBody var1, RigidBody var2, ManifoldPoint var3, ContactSolverInfo var4);
}

