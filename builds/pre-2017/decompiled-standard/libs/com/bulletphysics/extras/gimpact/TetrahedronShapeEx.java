/*
 * Decompiled with CFR 0.152.
 */
package com.bulletphysics.extras.gimpact;

import com.bulletphysics.collision.shapes.BU_Simplex1to4;
import javax.vecmath.Vector3f;

class TetrahedronShapeEx
extends BU_Simplex1to4 {
    public TetrahedronShapeEx() {
        this.numVertices = 4;
        for (int i = 0; i < this.numVertices; ++i) {
            this.vertices[i] = new Vector3f();
        }
    }

    public void setVertices(Vector3f v0, Vector3f v1, Vector3f v2, Vector3f v3) {
        this.vertices[0].set(v0);
        this.vertices[1].set(v1);
        this.vertices[2].set(v2);
        this.vertices[3].set(v3);
        this.recalcLocalAabb();
    }
}

