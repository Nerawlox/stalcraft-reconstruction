/*
 * Decompiled with CFR 0.152.
 */
package com.bulletphysics.collision.shapes;

import com.bulletphysics.$Stack;
import com.bulletphysics.collision.shapes.CylinderShape;
import javax.vecmath.Vector3f;

public class CylinderShapeX
extends CylinderShape {
    public CylinderShapeX(Vector3f halfExtents) {
        super(halfExtents, false);
        this.upAxis = 0;
        this.recalcLocalAabb();
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public Vector3f localGetSupportingVertexWithoutMargin(Vector3f vector3f, Vector3f vector3f2) {
        $Stack $Stack = $Stack.get();
        try {
            void out;
            void vec;
            $Stack.push$javax$vecmath$Vector3f();
            Vector3f vector3f3 = this.cylinderLocalSupportX(this.getHalfExtentsWithoutMargin($Stack.get$javax$vecmath$Vector3f()), (Vector3f)vec, (Vector3f)out);
            $Stack.pop$javax$vecmath$Vector3f();
            return vector3f3;
        }
        catch (Throwable throwable) {
            $Stack.pop$javax$vecmath$Vector3f();
            throw throwable;
        }
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public void batchedUnitVectorGetSupportingVertexWithoutMargin(Vector3f[] vector3fArray, Vector3f[] vector3fArray2, int n) {
        $Stack $Stack = $Stack.get();
        try {
            int numVectors;
            $Stack.push$javax$vecmath$Vector3f();
            for (int i = 0; i < numVectors; ++i) {
                void supportVerticesOut;
                void vectors;
                this.cylinderLocalSupportX(this.getHalfExtentsWithoutMargin($Stack.get$javax$vecmath$Vector3f()), (Vector3f)vectors[i], (Vector3f)supportVerticesOut[i]);
            }
            $Stack.pop$javax$vecmath$Vector3f();
            return;
        }
        catch (Throwable throwable) {
            $Stack.pop$javax$vecmath$Vector3f();
            throw throwable;
        }
    }

    @Override
    public float getRadius() {
        $Stack $Stack = $Stack.get();
        try {
            $Stack.push$javax$vecmath$Vector3f();
            float f = this.getHalfExtentsWithMargin((Vector3f)$Stack.get$javax$vecmath$Vector3f()).y;
            $Stack.pop$javax$vecmath$Vector3f();
            return f;
        }
        catch (Throwable throwable) {
            $Stack.pop$javax$vecmath$Vector3f();
            throw throwable;
        }
    }

    @Override
    public String getName() {
        return "CylinderX";
    }
}

