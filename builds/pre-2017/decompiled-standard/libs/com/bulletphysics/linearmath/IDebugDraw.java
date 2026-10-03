/*
 * Decompiled with CFR 0.152.
 */
package com.bulletphysics.linearmath;

import com.bulletphysics.$Stack;
import com.bulletphysics.linearmath.VectorUtil;
import javax.vecmath.Tuple3f;
import javax.vecmath.Vector3f;

public abstract class IDebugDraw {
    public abstract void drawLine(Vector3f var1, Vector3f var2, Vector3f var3);

    public void drawTriangle(Vector3f v0, Vector3f v1, Vector3f v2, Vector3f n0, Vector3f n1, Vector3f n2, Vector3f color, float alpha) {
        this.drawTriangle(v0, v1, v2, color, alpha);
    }

    public void drawTriangle(Vector3f v0, Vector3f v1, Vector3f v2, Vector3f color, float alpha) {
        this.drawLine(v0, v1, color);
        this.drawLine(v1, v2, color);
        this.drawLine(v2, v0, color);
    }

    public abstract void drawContactPoint(Vector3f var1, Vector3f var2, float var3, int var4, Vector3f var5);

    public abstract void reportErrorWarning(String var1);

    public abstract void draw3dText(Vector3f var1, String var2);

    public abstract void setDebugMode(int var1);

    public abstract int getDebugMode();

    /*
     * WARNING - void declaration
     */
    public void drawAabb(Vector3f vector3f, Vector3f vector3f2, Vector3f vector3f3) {
        $Stack $Stack = $Stack.get();
        try {
            void from;
            void to;
            $Stack.push$javax$vecmath$Vector3f();
            Vector3f halfExtents = $Stack.get$javax$vecmath$Vector3f((Vector3f)to);
            halfExtents.sub((Tuple3f)from);
            halfExtents.scale(0.5f);
            Vector3f center = $Stack.get$javax$vecmath$Vector3f((Vector3f)to);
            center.add((Tuple3f)from);
            center.scale(0.5f);
            Vector3f edgecoord = $Stack.get$javax$vecmath$Vector3f();
            edgecoord.set(1.0f, 1.0f, 1.0f);
            Vector3f pa = $Stack.get$javax$vecmath$Vector3f();
            Vector3f pb = $Stack.get$javax$vecmath$Vector3f();
            for (int i = 0; i < 4; ++i) {
                for (int j = 0; j < 3; ++j) {
                    void color;
                    pa.set(edgecoord.x * halfExtents.x, edgecoord.y * halfExtents.y, edgecoord.z * halfExtents.z);
                    pa.add(center);
                    int othercoord = j % 3;
                    VectorUtil.mulCoord(edgecoord, othercoord, -1.0f);
                    pb.set(edgecoord.x * halfExtents.x, edgecoord.y * halfExtents.y, edgecoord.z * halfExtents.z);
                    pb.add(center);
                    this.drawLine(pa, pb, (Vector3f)color);
                }
                edgecoord.set(-1.0f, -1.0f, -1.0f);
                if (i >= 3) continue;
                VectorUtil.mulCoord(edgecoord, i, -1.0f);
            }
            $Stack.pop$javax$vecmath$Vector3f();
            return;
        }
        catch (Throwable throwable) {
            $Stack.pop$javax$vecmath$Vector3f();
            throw throwable;
        }
    }
}

