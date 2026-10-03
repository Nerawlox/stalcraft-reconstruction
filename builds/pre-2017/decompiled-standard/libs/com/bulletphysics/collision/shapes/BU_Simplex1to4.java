/*
 * Decompiled with CFR 0.152.
 */
package com.bulletphysics.collision.shapes;

import com.bulletphysics.collision.broadphase.BroadphaseNativeType;
import com.bulletphysics.collision.shapes.PolyhedralConvexShape;
import javax.vecmath.Vector3f;

public class BU_Simplex1to4
extends PolyhedralConvexShape {
    protected int numVertices = 0;
    protected Vector3f[] vertices = new Vector3f[4];

    public BU_Simplex1to4() {
    }

    public BU_Simplex1to4(Vector3f pt0) {
        this.addVertex(pt0);
    }

    public BU_Simplex1to4(Vector3f pt0, Vector3f pt1) {
        this.addVertex(pt0);
        this.addVertex(pt1);
    }

    public BU_Simplex1to4(Vector3f pt0, Vector3f pt1, Vector3f pt2) {
        this.addVertex(pt0);
        this.addVertex(pt1);
        this.addVertex(pt2);
    }

    public BU_Simplex1to4(Vector3f pt0, Vector3f pt1, Vector3f pt2, Vector3f pt3) {
        this.addVertex(pt0);
        this.addVertex(pt1);
        this.addVertex(pt2);
        this.addVertex(pt3);
    }

    public void reset() {
        this.numVertices = 0;
    }

    @Override
    public BroadphaseNativeType getShapeType() {
        return BroadphaseNativeType.TETRAHEDRAL_SHAPE_PROXYTYPE;
    }

    public void addVertex(Vector3f pt) {
        if (this.vertices[this.numVertices] == null) {
            this.vertices[this.numVertices] = new Vector3f();
        }
        this.vertices[this.numVertices++] = pt;
        this.recalcLocalAabb();
    }

    @Override
    public int getNumVertices() {
        return this.numVertices;
    }

    @Override
    public int getNumEdges() {
        switch (this.numVertices) {
            case 0: {
                return 0;
            }
            case 1: {
                return 0;
            }
            case 2: {
                return 1;
            }
            case 3: {
                return 3;
            }
            case 4: {
                return 6;
            }
        }
        return 0;
    }

    @Override
    public void getEdge(int i, Vector3f pa, Vector3f pb) {
        block0 : switch (this.numVertices) {
            case 2: {
                pa.set(this.vertices[0]);
                pb.set(this.vertices[1]);
                break;
            }
            case 3: {
                switch (i) {
                    case 0: {
                        pa.set(this.vertices[0]);
                        pb.set(this.vertices[1]);
                        break;
                    }
                    case 1: {
                        pa.set(this.vertices[1]);
                        pb.set(this.vertices[2]);
                        break;
                    }
                    case 2: {
                        pa.set(this.vertices[2]);
                        pb.set(this.vertices[0]);
                    }
                }
                break;
            }
            case 4: {
                switch (i) {
                    case 0: {
                        pa.set(this.vertices[0]);
                        pb.set(this.vertices[1]);
                        break block0;
                    }
                    case 1: {
                        pa.set(this.vertices[1]);
                        pb.set(this.vertices[2]);
                        break block0;
                    }
                    case 2: {
                        pa.set(this.vertices[2]);
                        pb.set(this.vertices[0]);
                        break block0;
                    }
                    case 3: {
                        pa.set(this.vertices[0]);
                        pb.set(this.vertices[3]);
                        break block0;
                    }
                    case 4: {
                        pa.set(this.vertices[1]);
                        pb.set(this.vertices[3]);
                        break block0;
                    }
                    case 5: {
                        pa.set(this.vertices[2]);
                        pb.set(this.vertices[3]);
                    }
                }
            }
        }
    }

    @Override
    public void getVertex(int i, Vector3f vtx) {
        vtx.set(this.vertices[i]);
    }

    @Override
    public int getNumPlanes() {
        switch (this.numVertices) {
            case 0: {
                return 0;
            }
            case 1: {
                return 0;
            }
            case 2: {
                return 0;
            }
            case 3: {
                return 2;
            }
            case 4: {
                return 4;
            }
        }
        return 0;
    }

    @Override
    public void getPlane(Vector3f planeNormal, Vector3f planeSupport, int i) {
    }

    public int getIndex(int i) {
        return 0;
    }

    @Override
    public boolean isInside(Vector3f pt, float tolerance) {
        return false;
    }

    @Override
    public String getName() {
        return "BU_Simplex1to4";
    }
}

