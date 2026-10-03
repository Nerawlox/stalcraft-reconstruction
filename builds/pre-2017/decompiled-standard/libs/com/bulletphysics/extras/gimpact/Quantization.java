/*
 * Decompiled with CFR 0.152.
 */
package com.bulletphysics.extras.gimpact;

import com.bulletphysics.$Stack;
import com.bulletphysics.linearmath.VectorUtil;
import javax.vecmath.Tuple3f;
import javax.vecmath.Vector3f;

class Quantization {
    Quantization() {
    }

    /*
     * WARNING - void declaration
     */
    public static void bt_calc_quantization_parameters(Vector3f vector3f, Vector3f vector3f2, Vector3f vector3f3, Vector3f vector3f4, Vector3f vector3f5, float f) {
        $Stack $Stack = $Stack.get();
        try {
            void bvhQuantization;
            void srcMaxBound;
            void outMaxBound;
            void srcMinBound;
            Vector3f outMinBound;
            void quantizationMargin;
            $Stack.push$javax$vecmath$Vector3f();
            Vector3f clampValue = $Stack.get$javax$vecmath$Vector3f();
            clampValue.set((float)quantizationMargin, (float)quantizationMargin, (float)quantizationMargin);
            outMinBound.sub((Tuple3f)srcMinBound, clampValue);
            outMaxBound.add((Tuple3f)srcMaxBound, clampValue);
            Vector3f aabbSize = $Stack.get$javax$vecmath$Vector3f();
            aabbSize.sub((Tuple3f)outMaxBound, outMinBound);
            bvhQuantization.set(65535.0f, 65535.0f, 65535.0f);
            VectorUtil.div((Vector3f)bvhQuantization, (Vector3f)bvhQuantization, aabbSize);
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
    public static void bt_quantize_clamp(short[] sArray, Vector3f vector3f, Vector3f vector3f2, Vector3f vector3f3, Vector3f vector3f4) {
        $Stack $Stack = $Stack.get();
        try {
            void bvhQuantization;
            void max_bound;
            void min_bound;
            void point;
            $Stack.push$javax$vecmath$Vector3f();
            Vector3f clampedPoint = $Stack.get$javax$vecmath$Vector3f((Vector3f)point);
            VectorUtil.setMax(clampedPoint, (Vector3f)min_bound);
            VectorUtil.setMin(clampedPoint, (Vector3f)max_bound);
            Vector3f v = $Stack.get$javax$vecmath$Vector3f();
            v.sub(clampedPoint, (Tuple3f)min_bound);
            VectorUtil.mul(v, v, (Vector3f)bvhQuantization);
            out[0] = (short)(v.x + 0.5f);
            out[1] = (short)(v.y + 0.5f);
            out[2] = (short)(v.z + 0.5f);
            $Stack.pop$javax$vecmath$Vector3f();
            return;
        }
        catch (Throwable throwable) {
            $Stack.pop$javax$vecmath$Vector3f();
            throw throwable;
        }
    }

    public static Vector3f bt_unquantize(short[] vecIn, Vector3f offset, Vector3f bvhQuantization, Vector3f out) {
        out.set((float)(vecIn[0] & 0xFFFF) / bvhQuantization.x, (float)(vecIn[1] & 0xFFFF) / bvhQuantization.y, (float)(vecIn[2] & 0xFFFF) / bvhQuantization.z);
        out.add(offset);
        return out;
    }
}

