/*
 * Decompiled with CFR 0.152.
 */
package com.bulletphysics.dynamics.constraintsolver;

import com.bulletphysics.$Stack;
import com.bulletphysics.dynamics.RigidBody;
import com.bulletphysics.dynamics.constraintsolver.JacobianEntry;
import com.bulletphysics.dynamics.constraintsolver.RotationalLimitMotor;
import com.bulletphysics.dynamics.constraintsolver.TranslationalLimitMotor;
import com.bulletphysics.dynamics.constraintsolver.TypedConstraint;
import com.bulletphysics.dynamics.constraintsolver.TypedConstraintType;
import com.bulletphysics.linearmath.MatrixUtil;
import com.bulletphysics.linearmath.Transform;
import com.bulletphysics.linearmath.VectorUtil;
import javax.vecmath.Matrix3f;
import javax.vecmath.Tuple3f;
import javax.vecmath.Vector3f;

public class Generic6DofConstraint
extends TypedConstraint {
    protected final Transform frameInA = new Transform();
    protected final Transform frameInB = new Transform();
    protected final JacobianEntry[] jacLinear = new JacobianEntry[]{new JacobianEntry(), new JacobianEntry(), new JacobianEntry()};
    protected final JacobianEntry[] jacAng = new JacobianEntry[]{new JacobianEntry(), new JacobianEntry(), new JacobianEntry()};
    protected final TranslationalLimitMotor linearLimits = new TranslationalLimitMotor();
    protected final RotationalLimitMotor[] angularLimits = new RotationalLimitMotor[]{new RotationalLimitMotor(), new RotationalLimitMotor(), new RotationalLimitMotor()};
    protected float timeStep;
    protected final Transform calculatedTransformA = new Transform();
    protected final Transform calculatedTransformB = new Transform();
    protected final Vector3f calculatedAxisAngleDiff = new Vector3f();
    protected final Vector3f[] calculatedAxis = new Vector3f[]{new Vector3f(), new Vector3f(), new Vector3f()};
    protected final Vector3f anchorPos = new Vector3f();
    protected boolean useLinearReferenceFrameA;

    public Generic6DofConstraint() {
        super(TypedConstraintType.D6_CONSTRAINT_TYPE);
        this.useLinearReferenceFrameA = true;
    }

    public Generic6DofConstraint(RigidBody rbA, RigidBody rbB, Transform frameInA, Transform frameInB, boolean useLinearReferenceFrameA) {
        super(TypedConstraintType.D6_CONSTRAINT_TYPE, rbA, rbB);
        this.frameInA.set(frameInA);
        this.frameInB.set(frameInB);
        this.useLinearReferenceFrameA = useLinearReferenceFrameA;
    }

    private static float getMatrixElem(Matrix3f mat, int index) {
        int i = index % 3;
        int j = index / 3;
        return mat.getElement(i, j);
    }

    private static boolean matrixToEulerXYZ(Matrix3f mat, Vector3f xyz) {
        if (Generic6DofConstraint.getMatrixElem(mat, 2) < 1.0f) {
            if (Generic6DofConstraint.getMatrixElem(mat, 2) > -1.0f) {
                xyz.x = (float)Math.atan2(-Generic6DofConstraint.getMatrixElem(mat, 5), Generic6DofConstraint.getMatrixElem(mat, 8));
                xyz.y = (float)Math.asin(Generic6DofConstraint.getMatrixElem(mat, 2));
                xyz.z = (float)Math.atan2(-Generic6DofConstraint.getMatrixElem(mat, 1), Generic6DofConstraint.getMatrixElem(mat, 0));
                return true;
            }
            xyz.x = -((float)Math.atan2(Generic6DofConstraint.getMatrixElem(mat, 3), Generic6DofConstraint.getMatrixElem(mat, 4)));
            xyz.y = -1.5707964f;
            xyz.z = 0.0f;
            return false;
        }
        xyz.x = (float)Math.atan2(Generic6DofConstraint.getMatrixElem(mat, 3), Generic6DofConstraint.getMatrixElem(mat, 4));
        xyz.y = 1.5707964f;
        xyz.z = 0.0f;
        return false;
    }

    protected void calculateAngleInfo() {
        $Stack $Stack = $Stack.get();
        try {
            $Stack $Stack2 = $Stack;
            $Stack2.push$javax$vecmath$Vector3f();
            $Stack2.push$javax$vecmath$Matrix3f();
            Matrix3f mat = $Stack.get$javax$vecmath$Matrix3f();
            Matrix3f relative_frame = $Stack.get$javax$vecmath$Matrix3f();
            mat.set(this.calculatedTransformA.basis);
            MatrixUtil.invert(mat);
            relative_frame.mul(mat, this.calculatedTransformB.basis);
            Generic6DofConstraint.matrixToEulerXYZ(relative_frame, this.calculatedAxisAngleDiff);
            Vector3f axis0 = $Stack.get$javax$vecmath$Vector3f();
            this.calculatedTransformB.basis.getColumn(0, axis0);
            Vector3f axis2 = $Stack.get$javax$vecmath$Vector3f();
            this.calculatedTransformA.basis.getColumn(2, axis2);
            this.calculatedAxis[1].cross(axis2, axis0);
            this.calculatedAxis[0].cross(this.calculatedAxis[1], axis2);
            this.calculatedAxis[2].cross(axis0, this.calculatedAxis[1]);
            $Stack $Stack3 = $Stack;
            $Stack3.pop$javax$vecmath$Vector3f();
            $Stack3.pop$javax$vecmath$Matrix3f();
            return;
        }
        catch (Throwable throwable) {
            $Stack $Stack4 = $Stack;
            $Stack4.pop$javax$vecmath$Vector3f();
            $Stack4.pop$javax$vecmath$Matrix3f();
            throw throwable;
        }
    }

    public void calculateTransforms() {
        this.rbA.getCenterOfMassTransform(this.calculatedTransformA);
        this.calculatedTransformA.mul(this.frameInA);
        this.rbB.getCenterOfMassTransform(this.calculatedTransformB);
        this.calculatedTransformB.mul(this.frameInB);
        this.calculateAngleInfo();
    }

    /*
     * WARNING - void declaration
     */
    protected void buildLinearJacobian(int n, Vector3f vector3f, Vector3f vector3f2, Vector3f vector3f3) {
        $Stack $Stack = $Stack.get();
        try {
            void normalWorld;
            void jacLinear_index;
            void pivotBInW;
            void pivotAInW;
            $Stack $Stack2 = $Stack;
            $Stack2.push$com$bulletphysics$linearmath$Transform();
            $Stack2.push$javax$vecmath$Vector3f();
            Matrix3f mat1 = this.rbA.getCenterOfMassTransform((Transform)$Stack.get$com$bulletphysics$linearmath$Transform()).basis;
            mat1.transpose();
            Matrix3f mat2 = this.rbB.getCenterOfMassTransform((Transform)$Stack.get$com$bulletphysics$linearmath$Transform()).basis;
            mat2.transpose();
            Vector3f tmpVec = $Stack.get$javax$vecmath$Vector3f();
            Vector3f tmp1 = $Stack.get$javax$vecmath$Vector3f();
            tmp1.sub((Tuple3f)pivotAInW, this.rbA.getCenterOfMassPosition(tmpVec));
            Vector3f tmp2 = $Stack.get$javax$vecmath$Vector3f();
            tmp2.sub((Tuple3f)pivotBInW, this.rbB.getCenterOfMassPosition(tmpVec));
            this.jacLinear[jacLinear_index].init(mat1, mat2, tmp1, tmp2, (Vector3f)normalWorld, this.rbA.getInvInertiaDiagLocal($Stack.get$javax$vecmath$Vector3f()), this.rbA.getInvMass(), this.rbB.getInvInertiaDiagLocal($Stack.get$javax$vecmath$Vector3f()), this.rbB.getInvMass());
            $Stack $Stack3 = $Stack;
            $Stack3.pop$com$bulletphysics$linearmath$Transform();
            $Stack3.pop$javax$vecmath$Vector3f();
            return;
        }
        catch (Throwable throwable) {
            $Stack $Stack4 = $Stack;
            $Stack4.pop$com$bulletphysics$linearmath$Transform();
            $Stack4.pop$javax$vecmath$Vector3f();
            throw throwable;
        }
    }

    /*
     * WARNING - void declaration
     */
    protected void buildAngularJacobian(int n, Vector3f vector3f) {
        $Stack $Stack = $Stack.get();
        try {
            void jointAxisW;
            void jacAngular_index;
            $Stack $Stack2 = $Stack;
            $Stack2.push$com$bulletphysics$linearmath$Transform();
            $Stack2.push$javax$vecmath$Vector3f();
            Matrix3f mat1 = this.rbA.getCenterOfMassTransform((Transform)$Stack.get$com$bulletphysics$linearmath$Transform()).basis;
            mat1.transpose();
            Matrix3f mat2 = this.rbB.getCenterOfMassTransform((Transform)$Stack.get$com$bulletphysics$linearmath$Transform()).basis;
            mat2.transpose();
            this.jacAng[jacAngular_index].init((Vector3f)jointAxisW, mat1, mat2, this.rbA.getInvInertiaDiagLocal($Stack.get$javax$vecmath$Vector3f()), this.rbB.getInvInertiaDiagLocal($Stack.get$javax$vecmath$Vector3f()));
            $Stack $Stack3 = $Stack;
            $Stack3.pop$com$bulletphysics$linearmath$Transform();
            $Stack3.pop$javax$vecmath$Vector3f();
            return;
        }
        catch (Throwable throwable) {
            $Stack $Stack4 = $Stack;
            $Stack4.pop$com$bulletphysics$linearmath$Transform();
            $Stack4.pop$javax$vecmath$Vector3f();
            throw throwable;
        }
    }

    public boolean testAngularLimitMotor(int axis_index) {
        float angle = VectorUtil.getCoord(this.calculatedAxisAngleDiff, axis_index);
        this.angularLimits[axis_index].testLimitValue(angle);
        return this.angularLimits[axis_index].needApplyTorques();
    }

    @Override
    public void buildJacobian() {
        $Stack $Stack = $Stack.get();
        try {
            int i;
            $Stack.push$javax$vecmath$Vector3f();
            this.linearLimits.accumulatedImpulse.set(0.0f, 0.0f, 0.0f);
            for (int i2 = 0; i2 < 3; ++i2) {
                this.angularLimits[i2].accumulatedImpulse = 0.0f;
            }
            this.calculateTransforms();
            Vector3f tmpVec = $Stack.get$javax$vecmath$Vector3f();
            this.calcAnchorPos();
            Vector3f pivotAInW = $Stack.get$javax$vecmath$Vector3f(this.anchorPos);
            Vector3f pivotBInW = $Stack.get$javax$vecmath$Vector3f(this.anchorPos);
            Vector3f normalWorld = $Stack.get$javax$vecmath$Vector3f();
            for (i = 0; i < 3; ++i) {
                if (!this.linearLimits.isLimited(i)) continue;
                if (this.useLinearReferenceFrameA) {
                    this.calculatedTransformA.basis.getColumn(i, normalWorld);
                } else {
                    this.calculatedTransformB.basis.getColumn(i, normalWorld);
                }
                this.buildLinearJacobian(i, normalWorld, pivotAInW, pivotBInW);
            }
            for (i = 0; i < 3; ++i) {
                if (!this.testAngularLimitMotor(i)) continue;
                this.getAxis(i, normalWorld);
                this.buildAngularJacobian(i, normalWorld);
            }
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
    @Override
    public void solveConstraint(float f) {
        $Stack $Stack = $Stack.get();
        try {
            int i;
            void timeStep;
            $Stack.push$javax$vecmath$Vector3f();
            this.timeStep = timeStep;
            Vector3f pointInA = $Stack.get$javax$vecmath$Vector3f(this.calculatedTransformA.origin);
            Vector3f pointInB = $Stack.get$javax$vecmath$Vector3f(this.calculatedTransformB.origin);
            Vector3f linear_axis = $Stack.get$javax$vecmath$Vector3f();
            for (i = 0; i < 3; ++i) {
                if (!this.linearLimits.isLimited(i)) continue;
                float jacDiagABInv = 1.0f / this.jacLinear[i].getDiagonal();
                if (this.useLinearReferenceFrameA) {
                    this.calculatedTransformA.basis.getColumn(i, linear_axis);
                } else {
                    this.calculatedTransformB.basis.getColumn(i, linear_axis);
                }
                this.linearLimits.solveLinearAxis(this.timeStep, jacDiagABInv, this.rbA, pointInA, this.rbB, pointInB, i, linear_axis, this.anchorPos);
            }
            Vector3f angular_axis = $Stack.get$javax$vecmath$Vector3f();
            for (i = 0; i < 3; ++i) {
                if (!this.angularLimits[i].needApplyTorques()) continue;
                this.getAxis(i, angular_axis);
                float angularJacDiagABInv = 1.0f / this.jacAng[i].getDiagonal();
                this.angularLimits[i].solveAngularLimits(this.timeStep, angular_axis, angularJacDiagABInv, this.rbA, this.rbB);
            }
            $Stack.pop$javax$vecmath$Vector3f();
            return;
        }
        catch (Throwable throwable) {
            $Stack.pop$javax$vecmath$Vector3f();
            throw throwable;
        }
    }

    public void updateRHS(float timeStep) {
    }

    public Vector3f getAxis(int axis_index, Vector3f out) {
        out.set(this.calculatedAxis[axis_index]);
        return out;
    }

    public float getAngle(int axis_index) {
        return VectorUtil.getCoord(this.calculatedAxisAngleDiff, axis_index);
    }

    public Transform getCalculatedTransformA(Transform out) {
        out.set(this.calculatedTransformA);
        return out;
    }

    public Transform getCalculatedTransformB(Transform out) {
        out.set(this.calculatedTransformB);
        return out;
    }

    public Transform getFrameOffsetA(Transform out) {
        out.set(this.frameInA);
        return out;
    }

    public Transform getFrameOffsetB(Transform out) {
        out.set(this.frameInB);
        return out;
    }

    public void setLinearLowerLimit(Vector3f linearLower) {
        this.linearLimits.lowerLimit.set(linearLower);
    }

    public void setLinearUpperLimit(Vector3f linearUpper) {
        this.linearLimits.upperLimit.set(linearUpper);
    }

    public void setAngularLowerLimit(Vector3f angularLower) {
        this.angularLimits[0].loLimit = angularLower.x;
        this.angularLimits[1].loLimit = angularLower.y;
        this.angularLimits[2].loLimit = angularLower.z;
    }

    public void setAngularUpperLimit(Vector3f angularUpper) {
        this.angularLimits[0].hiLimit = angularUpper.x;
        this.angularLimits[1].hiLimit = angularUpper.y;
        this.angularLimits[2].hiLimit = angularUpper.z;
    }

    public RotationalLimitMotor getRotationalLimitMotor(int index) {
        return this.angularLimits[index];
    }

    public TranslationalLimitMotor getTranslationalLimitMotor() {
        return this.linearLimits;
    }

    public void setLimit(int axis, float lo, float hi) {
        if (axis < 3) {
            VectorUtil.setCoord(this.linearLimits.lowerLimit, axis, lo);
            VectorUtil.setCoord(this.linearLimits.upperLimit, axis, hi);
        } else {
            this.angularLimits[axis - 3].loLimit = lo;
            this.angularLimits[axis - 3].hiLimit = hi;
        }
    }

    public boolean isLimited(int limitIndex) {
        if (limitIndex < 3) {
            return this.linearLimits.isLimited(limitIndex);
        }
        return this.angularLimits[limitIndex - 3].isLimited();
    }

    public void calcAnchorPos() {
        $Stack $Stack = $Stack.get();
        try {
            $Stack.push$javax$vecmath$Vector3f();
            float imA = this.rbA.getInvMass();
            float imB = this.rbB.getInvMass();
            float weight = imB == 0.0f ? 1.0f : imA / (imA + imB);
            Vector3f pA = this.calculatedTransformA.origin;
            Vector3f pB = this.calculatedTransformB.origin;
            Vector3f tmp1 = $Stack.get$javax$vecmath$Vector3f();
            Vector3f tmp2 = $Stack.get$javax$vecmath$Vector3f();
            tmp1.scale(weight, pA);
            tmp2.scale(1.0f - weight, pB);
            this.anchorPos.add(tmp1, tmp2);
            $Stack.pop$javax$vecmath$Vector3f();
            return;
        }
        catch (Throwable throwable) {
            $Stack.pop$javax$vecmath$Vector3f();
            throw throwable;
        }
    }
}

