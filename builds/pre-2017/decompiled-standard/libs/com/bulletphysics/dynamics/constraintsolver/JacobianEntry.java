/*
 * Decompiled with CFR 0.152.
 */
package com.bulletphysics.dynamics.constraintsolver;

import com.bulletphysics.$Stack;
import com.bulletphysics.linearmath.VectorUtil;
import javax.vecmath.Matrix3f;
import javax.vecmath.Tuple3f;
import javax.vecmath.Vector3f;

public class JacobianEntry {
    public final Vector3f linearJointAxis = new Vector3f();
    public final Vector3f aJ = new Vector3f();
    public final Vector3f bJ = new Vector3f();
    public final Vector3f m_0MinvJt = new Vector3f();
    public final Vector3f m_1MinvJt = new Vector3f();
    public float Adiag;

    public void init(Matrix3f world2A, Matrix3f world2B, Vector3f rel_pos1, Vector3f rel_pos2, Vector3f jointAxis, Vector3f inertiaInvA, float massInvA, Vector3f inertiaInvB, float massInvB) {
        this.linearJointAxis.set(jointAxis);
        this.aJ.cross(rel_pos1, this.linearJointAxis);
        world2A.transform(this.aJ);
        this.bJ.set(this.linearJointAxis);
        this.bJ.negate();
        this.bJ.cross(rel_pos2, this.bJ);
        world2B.transform(this.bJ);
        VectorUtil.mul(this.m_0MinvJt, inertiaInvA, this.aJ);
        VectorUtil.mul(this.m_1MinvJt, inertiaInvB, this.bJ);
        this.Adiag = massInvA + this.m_0MinvJt.dot(this.aJ) + massInvB + this.m_1MinvJt.dot(this.bJ);
        assert (this.Adiag > 0.0f);
    }

    public void init(Vector3f jointAxis, Matrix3f world2A, Matrix3f world2B, Vector3f inertiaInvA, Vector3f inertiaInvB) {
        this.linearJointAxis.set(0.0f, 0.0f, 0.0f);
        this.aJ.set(jointAxis);
        world2A.transform(this.aJ);
        this.bJ.set(jointAxis);
        this.bJ.negate();
        world2B.transform(this.bJ);
        VectorUtil.mul(this.m_0MinvJt, inertiaInvA, this.aJ);
        VectorUtil.mul(this.m_1MinvJt, inertiaInvB, this.bJ);
        this.Adiag = this.m_0MinvJt.dot(this.aJ) + this.m_1MinvJt.dot(this.bJ);
        assert (this.Adiag > 0.0f);
    }

    public void init(Vector3f axisInA, Vector3f axisInB, Vector3f inertiaInvA, Vector3f inertiaInvB) {
        this.linearJointAxis.set(0.0f, 0.0f, 0.0f);
        this.aJ.set(axisInA);
        this.bJ.set(axisInB);
        this.bJ.negate();
        VectorUtil.mul(this.m_0MinvJt, inertiaInvA, this.aJ);
        VectorUtil.mul(this.m_1MinvJt, inertiaInvB, this.bJ);
        this.Adiag = this.m_0MinvJt.dot(this.aJ) + this.m_1MinvJt.dot(this.bJ);
        assert (this.Adiag > 0.0f);
    }

    public void init(Matrix3f world2A, Vector3f rel_pos1, Vector3f rel_pos2, Vector3f jointAxis, Vector3f inertiaInvA, float massInvA) {
        this.linearJointAxis.set(jointAxis);
        this.aJ.cross(rel_pos1, jointAxis);
        world2A.transform(this.aJ);
        this.bJ.set(jointAxis);
        this.bJ.negate();
        this.bJ.cross(rel_pos2, this.bJ);
        world2A.transform(this.bJ);
        VectorUtil.mul(this.m_0MinvJt, inertiaInvA, this.aJ);
        this.m_1MinvJt.set(0.0f, 0.0f, 0.0f);
        this.Adiag = massInvA + this.m_0MinvJt.dot(this.aJ);
        assert (this.Adiag > 0.0f);
    }

    public float getDiagonal() {
        return this.Adiag;
    }

    public float getNonDiagonal(JacobianEntry jacB, float massInvA) {
        JacobianEntry jacA = this;
        float lin = massInvA * jacA.linearJointAxis.dot(jacB.linearJointAxis);
        float ang = jacA.m_0MinvJt.dot(jacB.aJ);
        return lin + ang;
    }

    /*
     * WARNING - void declaration
     */
    public float getNonDiagonal(JacobianEntry jacobianEntry, float f, float f2) {
        $Stack $Stack = $Stack.get();
        try {
            void massInvB;
            void massInvA;
            void jacB;
            $Stack.push$javax$vecmath$Vector3f();
            JacobianEntry jacA = this;
            Vector3f lin = $Stack.get$javax$vecmath$Vector3f();
            VectorUtil.mul(lin, jacA.linearJointAxis, jacB.linearJointAxis);
            Vector3f ang0 = $Stack.get$javax$vecmath$Vector3f();
            VectorUtil.mul(ang0, jacA.m_0MinvJt, jacB.aJ);
            Vector3f ang1 = $Stack.get$javax$vecmath$Vector3f();
            VectorUtil.mul(ang1, jacA.m_1MinvJt, jacB.bJ);
            Vector3f lin0 = $Stack.get$javax$vecmath$Vector3f();
            lin0.scale((float)massInvA, lin);
            Vector3f lin1 = $Stack.get$javax$vecmath$Vector3f();
            lin1.scale((float)massInvB, lin);
            Vector3f sum = $Stack.get$javax$vecmath$Vector3f();
            VectorUtil.add(sum, ang0, ang1, lin0, lin1);
            float f3 = sum.x + sum.y + sum.z;
            $Stack.pop$javax$vecmath$Vector3f();
            return f3;
        }
        catch (Throwable throwable) {
            $Stack.pop$javax$vecmath$Vector3f();
            throw throwable;
        }
    }

    /*
     * WARNING - void declaration
     */
    public float getRelativeVelocity(Vector3f vector3f, Vector3f vector3f2, Vector3f vector3f3, Vector3f vector3f4) {
        $Stack $Stack = $Stack.get();
        try {
            void angvelB;
            void angvelA;
            void linvelB;
            void linvelA;
            $Stack.push$javax$vecmath$Vector3f();
            Vector3f linrel = $Stack.get$javax$vecmath$Vector3f();
            linrel.sub((Tuple3f)linvelA, (Tuple3f)linvelB);
            Vector3f angvela = $Stack.get$javax$vecmath$Vector3f();
            VectorUtil.mul(angvela, (Vector3f)angvelA, this.aJ);
            Vector3f angvelb = $Stack.get$javax$vecmath$Vector3f();
            VectorUtil.mul(angvelb, (Vector3f)angvelB, this.bJ);
            VectorUtil.mul(linrel, linrel, this.linearJointAxis);
            angvela.add(angvelb);
            angvela.add(linrel);
            float rel_vel2 = angvela.x + angvela.y + angvela.z;
            $Stack.pop$javax$vecmath$Vector3f();
            return rel_vel2 + 1.1920929E-7f;
        }
        catch (Throwable throwable) {
            $Stack.pop$javax$vecmath$Vector3f();
            throw throwable;
        }
    }
}

