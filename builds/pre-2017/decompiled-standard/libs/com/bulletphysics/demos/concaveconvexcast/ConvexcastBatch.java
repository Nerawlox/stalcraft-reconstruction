/*
 * Decompiled with CFR 0.152.
 */
package com.bulletphysics.demos.concaveconvexcast;

import com.bulletphysics.$Stack;
import com.bulletphysics.collision.dispatch.CollisionWorld;
import com.bulletphysics.collision.shapes.BoxShape;
import com.bulletphysics.demos.opengl.IGL;
import com.bulletphysics.linearmath.Clock;
import com.bulletphysics.linearmath.QuaternionUtil;
import com.bulletphysics.linearmath.Transform;
import com.bulletphysics.linearmath.TransformUtil;
import com.bulletphysics.linearmath.VectorUtil;
import javax.vecmath.Quat4f;
import javax.vecmath.Vector3f;

public class ConvexcastBatch {
    public static final int NUMRAYS_IN_BAR = 100;
    public Vector3f[] source = new Vector3f[100];
    public Vector3f[] dest = new Vector3f[100];
    public Vector3f[] direction = new Vector3f[100];
    public Vector3f[] hit_com = new Vector3f[100];
    public Vector3f[] hit_surface = new Vector3f[100];
    public float[] hit_fraction = new float[100];
    public Vector3f[] normal = new Vector3f[100];
    public int frame_counter;
    public int ms;
    public int sum_ms;
    public int sum_ms_samples;
    public int min_ms;
    public int max_ms;
    public Clock frame_timer;
    public float dx;
    public float min_x;
    public float max_x;
    public float min_y;
    public float max_y;
    public float sign;
    public final Vector3f boxShapeHalfExtents;
    public final BoxShape boxShape;

    public ConvexcastBatch() {
        for (int i = 0; i < 100; ++i) {
            this.source[i] = new Vector3f();
            this.dest[i] = new Vector3f();
            this.direction[i] = new Vector3f();
            this.hit_com[i] = new Vector3f();
            this.hit_surface[i] = new Vector3f();
            this.normal[i] = new Vector3f();
        }
        this.frame_timer = new Clock();
        this.boxShapeHalfExtents = new Vector3f();
        this.boxShape = new BoxShape(new Vector3f(0.0f, 0.0f, 0.0f));
        this.ms = 0;
        this.max_ms = 0;
        this.min_ms = 9999;
        this.sum_ms_samples = 0;
        this.sum_ms = 0;
    }

    public ConvexcastBatch(boolean unused, float ray_length, float min_z, float max_z) {
        this(unused, ray_length, min_z, max_z, -10.0f, 10.0f);
    }

    public ConvexcastBatch(boolean unused, float ray_length, float min_z, float max_z, float min_y, float max_y) {
        for (int i = 0; i < 100; ++i) {
            this.source[i] = new Vector3f();
            this.dest[i] = new Vector3f();
            this.direction[i] = new Vector3f();
            this.hit_com[i] = new Vector3f();
            this.hit_surface[i] = new Vector3f();
            this.normal[i] = new Vector3f();
        }
        this.frame_timer = new Clock();
        this.boxShapeHalfExtents = new Vector3f();
        this.boxShapeHalfExtents.set(1.0f, 1.0f, 1.0f);
        this.boxShape = new BoxShape(this.boxShapeHalfExtents);
        this.frame_counter = 0;
        this.ms = 0;
        this.max_ms = 0;
        this.min_ms = 9999;
        this.sum_ms_samples = 0;
        this.sum_ms = 0;
        this.dx = 10.0f;
        this.min_x = -40.0f;
        this.max_x = 20.0f;
        this.min_y = min_y;
        this.max_y = max_y;
        this.sign = 1.0f;
        float dalpha = 0.06283186f;
        for (int i = 0; i < 100; ++i) {
            float z = (max_z - min_z) / 100.0f * (float)i + min_z;
            this.source[i].set(this.min_x, max_y, z);
            this.dest[i].set(this.min_x + ray_length, min_y, z);
            this.normal[i].set(1.0f, 0.0f, 0.0f);
        }
    }

    public ConvexcastBatch(float ray_length, float z) {
        this(ray_length, z, -1000.0f, 10.0f);
    }

    public ConvexcastBatch(float ray_length, float z, float min_y, float max_y) {
        for (int i = 0; i < 100; ++i) {
            this.source[i] = new Vector3f();
            this.dest[i] = new Vector3f();
            this.direction[i] = new Vector3f();
            this.hit_com[i] = new Vector3f();
            this.hit_surface[i] = new Vector3f();
            this.normal[i] = new Vector3f();
        }
        this.frame_timer = new Clock();
        this.boxShapeHalfExtents = new Vector3f();
        this.boxShapeHalfExtents.set(1.0f, 1.0f, 1.0f);
        this.boxShape = new BoxShape(this.boxShapeHalfExtents);
        this.frame_counter = 0;
        this.ms = 0;
        this.max_ms = 0;
        this.min_ms = 9999;
        this.sum_ms_samples = 0;
        this.sum_ms = 0;
        this.dx = 10.0f;
        this.min_x = -40.0f;
        this.max_x = 20.0f;
        this.min_y = min_y;
        this.max_y = max_y;
        this.sign = 1.0f;
        float dalpha = 0.06283186f;
        for (int i = 0; i < 100; ++i) {
            float alpha = dalpha * (float)i;
            Quat4f q = new Quat4f(0.0f, 1.0f, 0.0f, alpha);
            this.direction[i].set(1.0f, 0.0f, 0.0f);
            Quat4f tmpQuat = new Quat4f(q);
            QuaternionUtil.mul(tmpQuat, this.direction[i]);
            this.direction[i].set(tmpQuat.x, tmpQuat.y, tmpQuat.z);
            this.source[i].set(this.min_x, max_y, z);
            this.dest[i].scaleAdd(ray_length, this.direction[i], this.source[i]);
            this.dest[i].y = min_y;
            this.normal[i].set(1.0f, 0.0f, 0.0f);
        }
    }

    public void move(float dt) {
        if (dt > 0.016666668f) {
            dt = 0.016666668f;
        }
        for (int i = 0; i < 100; ++i) {
            this.source[i].x += this.dx * dt * this.sign;
            this.dest[i].x += this.dx * dt * this.sign;
        }
        if (this.source[0].x < this.min_x) {
            this.sign = 1.0f;
        } else if (this.source[0].x > this.max_x) {
            this.sign = -1.0f;
        }
    }

    /*
     * WARNING - void declaration
     */
    public void cast(CollisionWorld collisionWorld) {
        $Stack $Stack = $Stack.get();
        try {
            $Stack $Stack2 = $Stack;
            $Stack2.push$com$bulletphysics$linearmath$Transform();
            $Stack2.push$javax$vecmath$Quat4f();
            this.frame_timer.reset();
            for (int i = 0; i < 100; ++i) {
                void cw;
                CollisionWorld.ClosestConvexResultCallback cb = new CollisionWorld.ClosestConvexResultCallback(this.source[i], this.dest[i]);
                Quat4f qFrom = $Stack.get$javax$vecmath$Quat4f();
                Quat4f qTo = $Stack.get$javax$vecmath$Quat4f();
                QuaternionUtil.setRotation(qFrom, new Vector3f(1.0f, 0.0f, 0.0f), 0.0f);
                QuaternionUtil.setRotation(qTo, new Vector3f(1.0f, 0.0f, 0.0f), 0.7f);
                Transform from = $Stack.get$com$bulletphysics$linearmath$Transform();
                Transform to = $Stack.get$com$bulletphysics$linearmath$Transform();
                from.basis.set(qFrom);
                from.origin.set(this.source[i]);
                to.basis.set(qTo);
                to.origin.set(this.dest[i]);
                cw.convexSweepTest(this.boxShape, from, to, cb);
                if (cb.hasHit()) {
                    this.hit_surface[i].set(cb.hitPointWorld);
                    VectorUtil.setInterpolate3(this.hit_com[i], this.source[i], this.dest[i], cb.closestHitFraction);
                    this.hit_fraction[i] = cb.closestHitFraction;
                    this.normal[i].set(cb.hitNormalWorld);
                    this.normal[i].normalize();
                    continue;
                }
                this.hit_com[i].set(this.dest[i]);
                this.hit_surface[i].set(this.dest[i]);
                this.hit_fraction[i] = 1.0f;
                this.normal[i].set(1.0f, 0.0f, 0.0f);
            }
            this.ms = (int)((long)this.ms + this.frame_timer.getTimeMilliseconds());
            ++this.frame_counter;
            if (this.frame_counter > 50) {
                this.min_ms = this.ms < this.min_ms ? this.ms : this.min_ms;
                this.max_ms = this.ms > this.max_ms ? this.ms : this.max_ms;
                this.sum_ms += this.ms;
                ++this.sum_ms_samples;
                float mean_ms = (float)this.sum_ms / (float)this.sum_ms_samples;
                System.out.printf("%d rays in %d ms %d %d %f\n", 100 * this.frame_counter, this.ms, this.min_ms, this.max_ms, Float.valueOf(mean_ms));
                this.ms = 0;
                this.frame_counter = 0;
            }
            $Stack $Stack3 = $Stack;
            $Stack3.pop$com$bulletphysics$linearmath$Transform();
            $Stack3.pop$javax$vecmath$Quat4f();
            return;
        }
        catch (Throwable throwable) {
            $Stack $Stack4 = $Stack;
            $Stack4.pop$com$bulletphysics$linearmath$Transform();
            $Stack4.pop$javax$vecmath$Quat4f();
            throw throwable;
        }
    }

    public void drawCube(IGL gl, Transform T) {
        float[] m = new float[16];
        T.getOpenGLMatrix(m);
        gl.glPushMatrix();
        gl.glMultMatrix(m);
        gl.glScalef(2.0f * this.boxShapeHalfExtents.x, 2.0f * this.boxShapeHalfExtents.y, 2.0f * this.boxShapeHalfExtents.z);
        gl.drawCube(1.0f);
        gl.glPopMatrix();
    }

    /*
     * WARNING - void declaration
     */
    public void draw(IGL iGL) {
        $Stack $Stack = $Stack.get();
        try {
            void gl;
            $Stack $Stack2 = $Stack;
            $Stack2.push$com$bulletphysics$linearmath$Transform();
            $Stack2.push$javax$vecmath$Vector3f();
            $Stack2.push$javax$vecmath$Quat4f();
            gl.glDisable(2896);
            gl.glColor3f(0.0f, 1.0f, 0.0f);
            gl.glBegin(1);
            for (int i = 0; i < 100; ++i) {
                gl.glVertex3f(this.source[i].x, this.source[i].y, this.source[i].z);
                gl.glVertex3f(this.hit_com[i].x, this.hit_com[i].y, this.hit_com[i].z);
            }
            gl.glColor3f(1.0f, 1.0f, 1.0f);
            float normal_scale = 10.0f;
            for (int i = 0; i < 100; ++i) {
                gl.glVertex3f(this.hit_surface[i].x, this.hit_surface[i].y, this.hit_surface[i].z);
                gl.glVertex3f(this.hit_surface[i].x + normal_scale * this.normal[i].x, this.hit_surface[i].y + normal_scale * this.normal[i].y, this.hit_surface[i].z + normal_scale * this.normal[i].z);
            }
            gl.glEnd();
            gl.glColor3f(0.0f, 1.0f, 1.0f);
            Quat4f qFrom = $Stack.get$javax$vecmath$Quat4f();
            Quat4f qTo = $Stack.get$javax$vecmath$Quat4f();
            QuaternionUtil.setRotation(qFrom, new Vector3f(1.0f, 0.0f, 0.0f), 0.0f);
            QuaternionUtil.setRotation(qTo, new Vector3f(1.0f, 0.0f, 0.0f), 0.7f);
            for (int i = 0; i < 100; ++i) {
                Transform from = $Stack.get$com$bulletphysics$linearmath$Transform();
                from.basis.set(qFrom);
                from.origin.set(this.source[i]);
                Transform to = $Stack.get$com$bulletphysics$linearmath$Transform();
                to.basis.set(qTo);
                to.origin.set(this.dest[i]);
                Vector3f linVel = $Stack.get$javax$vecmath$Vector3f();
                Vector3f angVel = $Stack.get$javax$vecmath$Vector3f();
                TransformUtil.calculateVelocity(from, to, 1.0f, linVel, angVel);
                Transform T = $Stack.get$com$bulletphysics$linearmath$Transform();
                TransformUtil.integrateTransform(from, linVel, angVel, this.hit_fraction[i], T);
                this.drawCube((IGL)gl, T);
            }
            gl.glEnable(2896);
            $Stack $Stack3 = $Stack;
            $Stack3.pop$com$bulletphysics$linearmath$Transform();
            $Stack3.pop$javax$vecmath$Vector3f();
            $Stack3.pop$javax$vecmath$Quat4f();
            return;
        }
        catch (Throwable throwable) {
            $Stack $Stack4 = $Stack;
            $Stack4.pop$com$bulletphysics$linearmath$Transform();
            $Stack4.pop$javax$vecmath$Vector3f();
            $Stack4.pop$javax$vecmath$Quat4f();
            throw throwable;
        }
    }
}

