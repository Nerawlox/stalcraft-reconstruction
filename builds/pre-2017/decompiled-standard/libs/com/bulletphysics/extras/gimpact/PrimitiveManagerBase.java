/*
 * Decompiled with CFR 0.152.
 */
package com.bulletphysics.extras.gimpact;

import com.bulletphysics.extras.gimpact.BoxCollision;
import com.bulletphysics.extras.gimpact.PrimitiveTriangle;

abstract class PrimitiveManagerBase {
    PrimitiveManagerBase() {
    }

    public abstract boolean is_trimesh();

    public abstract int get_primitive_count();

    public abstract void get_primitive_box(int var1, BoxCollision.AABB var2);

    public abstract void get_primitive_triangle(int var1, PrimitiveTriangle var2);
}

