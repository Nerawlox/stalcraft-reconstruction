/*
 * Decompiled with CFR 0.152.
 */
package com.bulletphysics.extras.gimpact;

import com.bulletphysics.$Stack;
import com.bulletphysics.collision.shapes.StridingMeshInterface;
import com.bulletphysics.collision.shapes.VertexData;
import com.bulletphysics.extras.gimpact.BoxCollision;
import com.bulletphysics.extras.gimpact.PrimitiveManagerBase;
import com.bulletphysics.extras.gimpact.PrimitiveTriangle;
import com.bulletphysics.extras.gimpact.TriangleShapeEx;
import com.bulletphysics.linearmath.VectorUtil;
import javax.vecmath.Vector3f;

class TrimeshPrimitiveManager
extends PrimitiveManagerBase {
    public float margin;
    public StridingMeshInterface meshInterface;
    public final Vector3f scale = new Vector3f();
    public int part;
    public int lock_count;
    private final int[] tmpIndices = new int[3];
    private VertexData vertexData;

    public TrimeshPrimitiveManager() {
        this.meshInterface = null;
        this.part = 0;
        this.margin = 0.01f;
        this.scale.set(1.0f, 1.0f, 1.0f);
        this.lock_count = 0;
    }

    public TrimeshPrimitiveManager(TrimeshPrimitiveManager manager) {
        this.meshInterface = manager.meshInterface;
        this.part = manager.part;
        this.margin = manager.margin;
        this.scale.set(manager.scale);
        this.lock_count = 0;
    }

    public TrimeshPrimitiveManager(StridingMeshInterface meshInterface, int part) {
        this.meshInterface = meshInterface;
        this.part = part;
        this.meshInterface.getScaling(this.scale);
        this.margin = 0.1f;
        this.lock_count = 0;
    }

    public void lock() {
        if (this.lock_count > 0) {
            ++this.lock_count;
            return;
        }
        this.vertexData = this.meshInterface.getLockedReadOnlyVertexIndexBase(this.part);
        this.lock_count = 1;
    }

    public void unlock() {
        if (this.lock_count == 0) {
            return;
        }
        if (this.lock_count > 1) {
            --this.lock_count;
            return;
        }
        this.meshInterface.unLockReadOnlyVertexBase(this.part);
        this.vertexData = null;
        this.lock_count = 0;
    }

    @Override
    public boolean is_trimesh() {
        return true;
    }

    @Override
    public int get_primitive_count() {
        return this.vertexData.getIndexCount() / 3;
    }

    public int get_vertex_count() {
        return this.vertexData.getVertexCount();
    }

    public void get_indices(int face_index, int[] out) {
        out[0] = this.vertexData.getIndex(face_index * 3 + 0);
        out[1] = this.vertexData.getIndex(face_index * 3 + 1);
        out[2] = this.vertexData.getIndex(face_index * 3 + 2);
    }

    public void get_vertex(int vertex_index, Vector3f vertex) {
        this.vertexData.getVertex(vertex_index, vertex);
        VectorUtil.mul(vertex, vertex, this.scale);
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public void get_primitive_box(int n, BoxCollision.AABB aABB) {
        $Stack $Stack = $Stack.get();
        try {
            void primbox;
            void prim_index;
            $Stack.push$com$bulletphysics$extras$gimpact$PrimitiveTriangle();
            PrimitiveTriangle triangle = $Stack.get$com$bulletphysics$extras$gimpact$PrimitiveTriangle();
            this.get_primitive_triangle((int)prim_index, triangle);
            primbox.calc_from_triangle_margin(triangle.vertices[0], triangle.vertices[1], triangle.vertices[2], triangle.margin);
            $Stack.pop$com$bulletphysics$extras$gimpact$PrimitiveTriangle();
            return;
        }
        catch (Throwable throwable) {
            $Stack.pop$com$bulletphysics$extras$gimpact$PrimitiveTriangle();
            throw throwable;
        }
    }

    @Override
    public void get_primitive_triangle(int prim_index, PrimitiveTriangle triangle) {
        this.get_indices(prim_index, this.tmpIndices);
        this.get_vertex(this.tmpIndices[0], triangle.vertices[0]);
        this.get_vertex(this.tmpIndices[1], triangle.vertices[1]);
        this.get_vertex(this.tmpIndices[2], triangle.vertices[2]);
        triangle.margin = this.margin;
    }

    public void get_bullet_triangle(int prim_index, TriangleShapeEx triangle) {
        this.get_indices(prim_index, this.tmpIndices);
        this.get_vertex(this.tmpIndices[0], triangle.vertices1[0]);
        this.get_vertex(this.tmpIndices[1], triangle.vertices1[1]);
        this.get_vertex(this.tmpIndices[2], triangle.vertices1[2]);
        triangle.setMargin(this.margin);
    }
}

