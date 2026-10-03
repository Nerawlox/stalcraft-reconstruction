/*
 * Decompiled with CFR 0.152.
 */
package com.bulletphysics.collision.shapes;

import com.bulletphysics.$Stack;
import com.bulletphysics.collision.shapes.ConvexShape;
import com.bulletphysics.linearmath.MiscUtil;
import com.bulletphysics.linearmath.convexhull.HullDesc;
import com.bulletphysics.linearmath.convexhull.HullFlags;
import com.bulletphysics.linearmath.convexhull.HullLibrary;
import com.bulletphysics.linearmath.convexhull.HullResult;
import com.bulletphysics.util.IntArrayList;
import com.bulletphysics.util.ObjectArrayList;
import javax.vecmath.Vector3f;

public class ShapeHull {
    protected ObjectArrayList<Vector3f> vertices = new ObjectArrayList();
    protected IntArrayList indices = new IntArrayList();
    protected int numIndices;
    protected ConvexShape shape;
    protected ObjectArrayList<Vector3f> unitSpherePoints = new ObjectArrayList();
    private static int NUM_UNITSPHERE_POINTS = 42;
    private static ObjectArrayList<Vector3f> constUnitSpherePoints = new ObjectArrayList();

    public ShapeHull(ConvexShape shape) {
        this.shape = shape;
        this.vertices.clear();
        this.indices.clear();
        this.numIndices = 0;
        MiscUtil.resize(this.unitSpherePoints, NUM_UNITSPHERE_POINTS + 20, Vector3f.class);
        for (int i = 0; i < constUnitSpherePoints.size(); ++i) {
            this.unitSpherePoints.getQuick(i).set(constUnitSpherePoints.getQuick(i));
        }
    }

    public boolean buildHull(float f) {
        $Stack $Stack = $Stack.get();
        try {
            int i;
            int i2;
            $Stack.push$javax$vecmath$Vector3f();
            Vector3f norm = $Stack.get$javax$vecmath$Vector3f();
            int numSampleDirections = NUM_UNITSPHERE_POINTS;
            int numPDA = this.shape.getNumPreferredPenetrationDirections();
            if (numPDA != 0) {
                for (i2 = 0; i2 < numPDA; ++i2) {
                    this.shape.getPreferredPenetrationDirection(i2, norm);
                    this.unitSpherePoints.getQuick(numSampleDirections).set(norm);
                    ++numSampleDirections;
                }
            }
            ObjectArrayList supportPoints = new ObjectArrayList();
            MiscUtil.resize(supportPoints, NUM_UNITSPHERE_POINTS + 20, Vector3f.class);
            for (i2 = 0; i2 < numSampleDirections; ++i2) {
                this.shape.localGetSupportingVertex(this.unitSpherePoints.getQuick(i2), (Vector3f)supportPoints.getQuick(i2));
            }
            HullDesc hd = new HullDesc();
            hd.flags = HullFlags.TRIANGLES;
            hd.vcount = numSampleDirections;
            hd.vertices = supportPoints;
            HullLibrary hl = new HullLibrary();
            HullResult hr = new HullResult();
            if (!hl.createConvexHull(hd, hr)) {
                $Stack.pop$javax$vecmath$Vector3f();
                return false;
            }
            MiscUtil.resize(this.vertices, hr.numOutputVertices, Vector3f.class);
            for (i = 0; i < hr.numOutputVertices; ++i) {
                this.vertices.getQuick(i).set(hr.outputVertices.getQuick(i));
            }
            this.numIndices = hr.numIndices;
            MiscUtil.resize(this.indices, this.numIndices, 0);
            for (i = 0; i < this.numIndices; ++i) {
                this.indices.set(i, hr.indices.get(i));
            }
            hl.releaseResult(hr);
            $Stack.pop$javax$vecmath$Vector3f();
            return true;
        }
        catch (Throwable throwable) {
            $Stack.pop$javax$vecmath$Vector3f();
            throw throwable;
        }
    }

    public int numTriangles() {
        return this.numIndices / 3;
    }

    public int numVertices() {
        return this.vertices.size();
    }

    public int numIndices() {
        return this.numIndices;
    }

    public ObjectArrayList<Vector3f> getVertexPointer() {
        return this.vertices;
    }

    public IntArrayList getIndexPointer() {
        return this.indices;
    }

    static {
        constUnitSpherePoints.add(new Vector3f(0.0f, -0.0f, -1.0f));
        constUnitSpherePoints.add(new Vector3f(0.723608f, -0.525725f, -0.447219f));
        constUnitSpherePoints.add(new Vector3f(-0.276388f, -0.850649f, -0.447219f));
        constUnitSpherePoints.add(new Vector3f(-0.894426f, -0.0f, -0.447216f));
        constUnitSpherePoints.add(new Vector3f(-0.276388f, 0.850649f, -0.44722f));
        constUnitSpherePoints.add(new Vector3f(0.723608f, 0.525725f, -0.447219f));
        constUnitSpherePoints.add(new Vector3f(0.276388f, -0.850649f, 0.44722f));
        constUnitSpherePoints.add(new Vector3f(-0.723608f, -0.525725f, 0.447219f));
        constUnitSpherePoints.add(new Vector3f(-0.723608f, 0.525725f, 0.447219f));
        constUnitSpherePoints.add(new Vector3f(0.276388f, 0.850649f, 0.447219f));
        constUnitSpherePoints.add(new Vector3f(0.894426f, 0.0f, 0.447216f));
        constUnitSpherePoints.add(new Vector3f(-0.0f, 0.0f, 1.0f));
        constUnitSpherePoints.add(new Vector3f(0.425323f, -0.309011f, -0.850654f));
        constUnitSpherePoints.add(new Vector3f(-0.162456f, -0.499995f, -0.850654f));
        constUnitSpherePoints.add(new Vector3f(0.262869f, -0.809012f, -0.525738f));
        constUnitSpherePoints.add(new Vector3f(0.425323f, 0.309011f, -0.850654f));
        constUnitSpherePoints.add(new Vector3f(0.850648f, -0.0f, -0.525736f));
        constUnitSpherePoints.add(new Vector3f(-0.52573f, -0.0f, -0.850652f));
        constUnitSpherePoints.add(new Vector3f(-0.68819f, -0.499997f, -0.525736f));
        constUnitSpherePoints.add(new Vector3f(-0.162456f, 0.499995f, -0.850654f));
        constUnitSpherePoints.add(new Vector3f(-0.68819f, 0.499997f, -0.525736f));
        constUnitSpherePoints.add(new Vector3f(0.262869f, 0.809012f, -0.525738f));
        constUnitSpherePoints.add(new Vector3f(0.951058f, 0.309013f, 0.0f));
        constUnitSpherePoints.add(new Vector3f(0.951058f, -0.309013f, 0.0f));
        constUnitSpherePoints.add(new Vector3f(0.587786f, -0.809017f, 0.0f));
        constUnitSpherePoints.add(new Vector3f(0.0f, -1.0f, 0.0f));
        constUnitSpherePoints.add(new Vector3f(-0.587786f, -0.809017f, 0.0f));
        constUnitSpherePoints.add(new Vector3f(-0.951058f, -0.309013f, -0.0f));
        constUnitSpherePoints.add(new Vector3f(-0.951058f, 0.309013f, -0.0f));
        constUnitSpherePoints.add(new Vector3f(-0.587786f, 0.809017f, -0.0f));
        constUnitSpherePoints.add(new Vector3f(-0.0f, 1.0f, -0.0f));
        constUnitSpherePoints.add(new Vector3f(0.587786f, 0.809017f, -0.0f));
        constUnitSpherePoints.add(new Vector3f(0.68819f, -0.499997f, 0.525736f));
        constUnitSpherePoints.add(new Vector3f(-0.262869f, -0.809012f, 0.525738f));
        constUnitSpherePoints.add(new Vector3f(-0.850648f, 0.0f, 0.525736f));
        constUnitSpherePoints.add(new Vector3f(-0.262869f, 0.809012f, 0.525738f));
        constUnitSpherePoints.add(new Vector3f(0.68819f, 0.499997f, 0.525736f));
        constUnitSpherePoints.add(new Vector3f(0.52573f, 0.0f, 0.850652f));
        constUnitSpherePoints.add(new Vector3f(0.162456f, -0.499995f, 0.850654f));
        constUnitSpherePoints.add(new Vector3f(-0.425323f, -0.309011f, 0.850654f));
        constUnitSpherePoints.add(new Vector3f(-0.425323f, 0.309011f, 0.850654f));
        constUnitSpherePoints.add(new Vector3f(0.162456f, 0.499995f, 0.850654f));
    }
}

