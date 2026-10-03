/*
 * Decompiled with CFR 0.152.
 */
package com.bulletphysics.extras.gimpact;

import com.bulletphysics.collision.shapes.CollisionShape;
import com.bulletphysics.extras.gimpact.GImpactShapeInterface;
import com.bulletphysics.extras.gimpact.TetrahedronShapeEx;
import com.bulletphysics.extras.gimpact.TriangleShapeEx;

class GIM_ShapeRetriever {
    public GImpactShapeInterface gim_shape;
    public TriangleShapeEx trishape = new TriangleShapeEx();
    public TetrahedronShapeEx tetrashape = new TetrahedronShapeEx();
    public ChildShapeRetriever child_retriever = new ChildShapeRetriever();
    public TriangleShapeRetriever tri_retriever = new TriangleShapeRetriever();
    public TetraShapeRetriever tetra_retriever = new TetraShapeRetriever();
    public ChildShapeRetriever current_retriever;

    public GIM_ShapeRetriever(GImpactShapeInterface gim_shape) {
        this.gim_shape = gim_shape;
        this.current_retriever = gim_shape.needsRetrieveTriangles() ? this.tri_retriever : (gim_shape.needsRetrieveTetrahedrons() ? this.tetra_retriever : this.child_retriever);
        this.current_retriever.parent = this;
    }

    public CollisionShape getChildShape(int index) {
        return this.current_retriever.getChildShape(index);
    }

    public static class TetraShapeRetriever
    extends ChildShapeRetriever {
        @Override
        public CollisionShape getChildShape(int index) {
            this.parent.gim_shape.getBulletTetrahedron(index, this.parent.tetrashape);
            return this.parent.tetrashape;
        }
    }

    public static class TriangleShapeRetriever
    extends ChildShapeRetriever {
        @Override
        public CollisionShape getChildShape(int index) {
            this.parent.gim_shape.getBulletTriangle(index, this.parent.trishape);
            return this.parent.trishape;
        }
    }

    public static class ChildShapeRetriever {
        public GIM_ShapeRetriever parent;

        public CollisionShape getChildShape(int index) {
            return this.parent.gim_shape.getChildShape(index);
        }
    }
}

