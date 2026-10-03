/*
 * Decompiled with CFR 0.152.
 */
package com.bulletphysics.collision.shapes;

import com.bulletphysics.collision.shapes.CollisionShape;
import com.bulletphysics.linearmath.Transform;
import javax.vecmath.Vector3f;

public abstract class ConvexShape
extends CollisionShape {
    public static final int MAX_PREFERRED_PENETRATION_DIRECTIONS = 10;

    public abstract Vector3f localGetSupportingVertex(Vector3f var1, Vector3f var2);

    public abstract Vector3f localGetSupportingVertexWithoutMargin(Vector3f var1, Vector3f var2);

    public abstract void batchedUnitVectorGetSupportingVertexWithoutMargin(Vector3f[] var1, Vector3f[] var2, int var3);

    public abstract void getAabbSlow(Transform var1, Vector3f var2, Vector3f var3);

    @Override
    public abstract void setLocalScaling(Vector3f var1);

    @Override
    public abstract Vector3f getLocalScaling(Vector3f var1);

    @Override
    public abstract void setMargin(float var1);

    @Override
    public abstract float getMargin();

    public abstract int getNumPreferredPenetrationDirections();

    public abstract void getPreferredPenetrationDirection(int var1, Vector3f var2);
}

