/*
 * Decompiled with CFR 0.152.
 */
package com.bulletphysics.collision.shapes;

import com.bulletphysics.$Stack;
import com.bulletphysics.collision.shapes.InternalTriangleIndexCallback;
import com.bulletphysics.collision.shapes.VertexData;
import com.bulletphysics.linearmath.VectorUtil;
import javax.vecmath.Vector3f;

public abstract class StridingMeshInterface {
    protected final Vector3f scaling = new Vector3f(1.0f, 1.0f, 1.0f);

    /*
     * WARNING - void declaration
     */
    public void internalProcessAllTriangles(InternalTriangleIndexCallback internalTriangleIndexCallback, Vector3f vector3f, Vector3f vector3f2) {
        $Stack $Stack = $Stack.get();
        try {
            $Stack.push$javax$vecmath$Vector3f();
            int graphicssubparts = this.getNumSubParts();
            Vector3f[] triangle = new Vector3f[]{$Stack.get$javax$vecmath$Vector3f(), $Stack.get$javax$vecmath$Vector3f(), $Stack.get$javax$vecmath$Vector3f()};
            Vector3f meshScaling = this.getScaling($Stack.get$javax$vecmath$Vector3f());
            for (int part = 0; part < graphicssubparts; ++part) {
                VertexData data2 = this.getLockedReadOnlyVertexIndexBase(part);
                int cnt = data2.getIndexCount() / 3;
                for (int i = 0; i < cnt; ++i) {
                    void callback;
                    data2.getTriangle(i * 3, meshScaling, triangle);
                    callback.internalProcessTriangleIndex(triangle, part, i);
                }
                this.unLockReadOnlyVertexBase(part);
            }
            $Stack.pop$javax$vecmath$Vector3f();
            return;
        }
        catch (Throwable throwable) {
            $Stack.pop$javax$vecmath$Vector3f();
            throw throwable;
        }
    }

    public void calculateAabbBruteForce(Vector3f aabbMin, Vector3f aabbMax) {
        AabbCalculationCallback aabbCallback = new AabbCalculationCallback();
        aabbMin.set(-1.0E30f, -1.0E30f, -1.0E30f);
        aabbMax.set(1.0E30f, 1.0E30f, 1.0E30f);
        this.internalProcessAllTriangles(aabbCallback, aabbMin, aabbMax);
        aabbMin.set(aabbCallback.aabbMin);
        aabbMax.set(aabbCallback.aabbMax);
    }

    public abstract VertexData getLockedVertexIndexBase(int var1);

    public abstract VertexData getLockedReadOnlyVertexIndexBase(int var1);

    public abstract void unLockVertexBase(int var1);

    public abstract void unLockReadOnlyVertexBase(int var1);

    public abstract int getNumSubParts();

    public abstract void preallocateVertices(int var1);

    public abstract void preallocateIndices(int var1);

    public Vector3f getScaling(Vector3f out) {
        out.set(this.scaling);
        return out;
    }

    public void setScaling(Vector3f scaling) {
        this.scaling.set(scaling);
    }

    private static class AabbCalculationCallback
    extends InternalTriangleIndexCallback {
        public final Vector3f aabbMin = new Vector3f(1.0E30f, 1.0E30f, 1.0E30f);
        public final Vector3f aabbMax = new Vector3f(-1.0E30f, -1.0E30f, -1.0E30f);

        private AabbCalculationCallback() {
        }

        @Override
        public void internalProcessTriangleIndex(Vector3f[] triangle, int partId, int triangleIndex) {
            VectorUtil.setMin(this.aabbMin, triangle[0]);
            VectorUtil.setMax(this.aabbMax, triangle[0]);
            VectorUtil.setMin(this.aabbMin, triangle[1]);
            VectorUtil.setMax(this.aabbMax, triangle[1]);
            VectorUtil.setMin(this.aabbMin, triangle[2]);
            VectorUtil.setMax(this.aabbMax, triangle[2]);
        }
    }
}

