/*
 * Decompiled with CFR 0.152.
 */
package com.bulletphysics.extras.gimpact;

import com.bulletphysics.$Stack;
import com.bulletphysics.collision.shapes.StaticPlaneShape;
import com.bulletphysics.linearmath.Transform;
import com.bulletphysics.linearmath.VectorUtil;
import javax.vecmath.Vector3f;
import javax.vecmath.Vector4f;

class PlaneShape {
    PlaneShape() {
    }

    /*
     * WARNING - void declaration
     */
    public static void get_plane_equation(StaticPlaneShape staticPlaneShape, Vector4f vector4f) {
        $Stack $Stack = $Stack.get();
        try {
            StaticPlaneShape shape;
            void equation;
            $Stack.push$javax$vecmath$Vector3f();
            Vector3f tmp = $Stack.get$javax$vecmath$Vector3f();
            equation.set(shape.getPlaneNormal(tmp));
            equation.w = shape.getPlaneConstant();
            $Stack.pop$javax$vecmath$Vector3f();
            return;
        }
        catch (Throwable throwable) {
            $Stack.pop$javax$vecmath$Vector3f();
            throw throwable;
        }
    }

    /*
     * WARNING - void declaration
     */
    public static void get_plane_equation_transformed(StaticPlaneShape staticPlaneShape, Transform transform, Vector4f vector4f) {
        $Stack $Stack = $Stack.get();
        try {
            void trans;
            void equation;
            StaticPlaneShape shape;
            $Stack.push$javax$vecmath$Vector3f();
            PlaneShape.get_plane_equation(shape, (Vector4f)equation);
            Vector3f tmp = $Stack.get$javax$vecmath$Vector3f();
            trans.basis.getRow(0, tmp);
            float x = VectorUtil.dot3(tmp, (Vector4f)equation);
            trans.basis.getRow(1, tmp);
            float y = VectorUtil.dot3(tmp, (Vector4f)equation);
            trans.basis.getRow(2, tmp);
            float z = VectorUtil.dot3(tmp, (Vector4f)equation);
            float w = VectorUtil.dot3(trans.origin, (Vector4f)equation) + equation.w;
            equation.set(x, y, z, w);
            $Stack.pop$javax$vecmath$Vector3f();
            return;
        }
        catch (Throwable throwable) {
            $Stack.pop$javax$vecmath$Vector3f();
            throw throwable;
        }
    }
}

