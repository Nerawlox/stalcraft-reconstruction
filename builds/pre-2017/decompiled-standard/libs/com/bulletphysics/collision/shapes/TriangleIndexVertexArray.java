/*
 * Decompiled with CFR 0.152.
 */
package com.bulletphysics.collision.shapes;

import com.bulletphysics.collision.shapes.ByteBufferVertexData;
import com.bulletphysics.collision.shapes.IndexedMesh;
import com.bulletphysics.collision.shapes.ScalarType;
import com.bulletphysics.collision.shapes.StridingMeshInterface;
import com.bulletphysics.collision.shapes.VertexData;
import com.bulletphysics.util.ObjectArrayList;
import java.nio.ByteBuffer;

public class TriangleIndexVertexArray
extends StridingMeshInterface {
    protected ObjectArrayList<IndexedMesh> indexedMeshes = new ObjectArrayList();
    private ByteBufferVertexData data = new ByteBufferVertexData();

    public TriangleIndexVertexArray() {
    }

    public TriangleIndexVertexArray(int numTriangles, ByteBuffer triangleIndexBase, int triangleIndexStride, int numVertices, ByteBuffer vertexBase, int vertexStride) {
        IndexedMesh mesh = new IndexedMesh();
        mesh.numTriangles = numTriangles;
        mesh.triangleIndexBase = triangleIndexBase;
        mesh.triangleIndexStride = triangleIndexStride;
        mesh.numVertices = numVertices;
        mesh.vertexBase = vertexBase;
        mesh.vertexStride = vertexStride;
        this.addIndexedMesh(mesh);
    }

    public void addIndexedMesh(IndexedMesh mesh) {
        this.addIndexedMesh(mesh, ScalarType.INTEGER);
    }

    public void addIndexedMesh(IndexedMesh mesh, ScalarType indexType) {
        this.indexedMeshes.add(mesh);
        this.indexedMeshes.getQuick((int)(this.indexedMeshes.size() - 1)).indexType = indexType;
    }

    @Override
    public VertexData getLockedVertexIndexBase(int subpart) {
        assert (subpart < this.getNumSubParts());
        IndexedMesh mesh = this.indexedMeshes.getQuick(subpart);
        this.data.vertexCount = mesh.numVertices;
        this.data.vertexData = mesh.vertexBase;
        this.data.vertexType = ScalarType.FLOAT;
        this.data.vertexStride = mesh.vertexStride;
        this.data.indexCount = mesh.numTriangles * 3;
        this.data.indexData = mesh.triangleIndexBase;
        this.data.indexStride = mesh.triangleIndexStride / 3;
        this.data.indexType = mesh.indexType;
        return this.data;
    }

    @Override
    public VertexData getLockedReadOnlyVertexIndexBase(int subpart) {
        return this.getLockedVertexIndexBase(subpart);
    }

    @Override
    public void unLockVertexBase(int subpart) {
        this.data.vertexData = null;
        this.data.indexData = null;
    }

    @Override
    public void unLockReadOnlyVertexBase(int subpart) {
        this.unLockVertexBase(subpart);
    }

    @Override
    public int getNumSubParts() {
        return this.indexedMeshes.size();
    }

    public ObjectArrayList<IndexedMesh> getIndexedMeshArray() {
        return this.indexedMeshes;
    }

    @Override
    public void preallocateVertices(int numverts) {
    }

    @Override
    public void preallocateIndices(int numindices) {
    }
}

