/*
 * Decompiled with CFR 0.152.
 */
package com.bulletphysics.demos.genericjoint;

import com.bulletphysics.collision.shapes.CapsuleShape;
import com.bulletphysics.collision.shapes.CollisionShape;
import com.bulletphysics.dynamics.DynamicsWorld;
import com.bulletphysics.dynamics.RigidBody;
import com.bulletphysics.dynamics.RigidBodyConstructionInfo;
import com.bulletphysics.dynamics.constraintsolver.Generic6DofConstraint;
import com.bulletphysics.dynamics.constraintsolver.TypedConstraint;
import com.bulletphysics.linearmath.DefaultMotionState;
import com.bulletphysics.linearmath.MatrixUtil;
import com.bulletphysics.linearmath.Transform;
import javax.vecmath.Vector3f;

public class RagDoll {
    private DynamicsWorld ownerWorld;
    private CollisionShape[] shapes = new CollisionShape[BodyPart.BODYPART_COUNT.ordinal()];
    private RigidBody[] bodies = new RigidBody[BodyPart.BODYPART_COUNT.ordinal()];
    private TypedConstraint[] joints = new TypedConstraint[JointType.JOINT_COUNT.ordinal()];

    public RagDoll(DynamicsWorld ownerWorld, Vector3f positionOffset) {
        this(ownerWorld, positionOffset, 1.0f);
    }

    public RagDoll(DynamicsWorld ownerWorld, Vector3f positionOffset, float scale_ragdoll) {
        this.ownerWorld = ownerWorld;
        Transform tmpTrans = new Transform();
        Vector3f tmp = new Vector3f();
        this.shapes[BodyPart.BODYPART_PELVIS.ordinal()] = new CapsuleShape(scale_ragdoll * 0.15f, scale_ragdoll * 0.2f);
        this.shapes[BodyPart.BODYPART_SPINE.ordinal()] = new CapsuleShape(scale_ragdoll * 0.15f, scale_ragdoll * 0.28f);
        this.shapes[BodyPart.BODYPART_HEAD.ordinal()] = new CapsuleShape(scale_ragdoll * 0.1f, scale_ragdoll * 0.05f);
        this.shapes[BodyPart.BODYPART_LEFT_UPPER_LEG.ordinal()] = new CapsuleShape(scale_ragdoll * 0.07f, scale_ragdoll * 0.45f);
        this.shapes[BodyPart.BODYPART_LEFT_LOWER_LEG.ordinal()] = new CapsuleShape(scale_ragdoll * 0.05f, scale_ragdoll * 0.37f);
        this.shapes[BodyPart.BODYPART_RIGHT_UPPER_LEG.ordinal()] = new CapsuleShape(scale_ragdoll * 0.07f, scale_ragdoll * 0.45f);
        this.shapes[BodyPart.BODYPART_RIGHT_LOWER_LEG.ordinal()] = new CapsuleShape(scale_ragdoll * 0.05f, scale_ragdoll * 0.37f);
        this.shapes[BodyPart.BODYPART_LEFT_UPPER_ARM.ordinal()] = new CapsuleShape(scale_ragdoll * 0.05f, scale_ragdoll * 0.33f);
        this.shapes[BodyPart.BODYPART_LEFT_LOWER_ARM.ordinal()] = new CapsuleShape(scale_ragdoll * 0.04f, scale_ragdoll * 0.25f);
        this.shapes[BodyPart.BODYPART_RIGHT_UPPER_ARM.ordinal()] = new CapsuleShape(scale_ragdoll * 0.05f, scale_ragdoll * 0.33f);
        this.shapes[BodyPart.BODYPART_RIGHT_LOWER_ARM.ordinal()] = new CapsuleShape(scale_ragdoll * 0.04f, scale_ragdoll * 0.25f);
        Transform offset = new Transform();
        offset.setIdentity();
        offset.origin.set(positionOffset);
        Transform transform = new Transform();
        transform.setIdentity();
        transform.origin.set(0.0f, scale_ragdoll * 1.0f, 0.0f);
        tmpTrans.mul(offset, transform);
        this.bodies[BodyPart.BODYPART_PELVIS.ordinal()] = this.localCreateRigidBody(1.0f, tmpTrans, this.shapes[BodyPart.BODYPART_PELVIS.ordinal()]);
        transform.setIdentity();
        transform.origin.set(0.0f, scale_ragdoll * 1.2f, 0.0f);
        tmpTrans.mul(offset, transform);
        this.bodies[BodyPart.BODYPART_SPINE.ordinal()] = this.localCreateRigidBody(1.0f, tmpTrans, this.shapes[BodyPart.BODYPART_SPINE.ordinal()]);
        transform.setIdentity();
        transform.origin.set(0.0f, scale_ragdoll * 1.6f, 0.0f);
        tmpTrans.mul(offset, transform);
        this.bodies[BodyPart.BODYPART_HEAD.ordinal()] = this.localCreateRigidBody(1.0f, tmpTrans, this.shapes[BodyPart.BODYPART_HEAD.ordinal()]);
        transform.setIdentity();
        transform.origin.set(-0.18f * scale_ragdoll, 0.65f * scale_ragdoll, 0.0f);
        tmpTrans.mul(offset, transform);
        this.bodies[BodyPart.BODYPART_LEFT_UPPER_LEG.ordinal()] = this.localCreateRigidBody(1.0f, tmpTrans, this.shapes[BodyPart.BODYPART_LEFT_UPPER_LEG.ordinal()]);
        transform.setIdentity();
        transform.origin.set(-0.18f * scale_ragdoll, 0.2f * scale_ragdoll, 0.0f);
        tmpTrans.mul(offset, transform);
        this.bodies[BodyPart.BODYPART_LEFT_LOWER_LEG.ordinal()] = this.localCreateRigidBody(1.0f, tmpTrans, this.shapes[BodyPart.BODYPART_LEFT_LOWER_LEG.ordinal()]);
        transform.setIdentity();
        transform.origin.set(0.18f * scale_ragdoll, 0.65f * scale_ragdoll, 0.0f);
        tmpTrans.mul(offset, transform);
        this.bodies[BodyPart.BODYPART_RIGHT_UPPER_LEG.ordinal()] = this.localCreateRigidBody(1.0f, tmpTrans, this.shapes[BodyPart.BODYPART_RIGHT_UPPER_LEG.ordinal()]);
        transform.setIdentity();
        transform.origin.set(0.18f * scale_ragdoll, 0.2f * scale_ragdoll, 0.0f);
        tmpTrans.mul(offset, transform);
        this.bodies[BodyPart.BODYPART_RIGHT_LOWER_LEG.ordinal()] = this.localCreateRigidBody(1.0f, tmpTrans, this.shapes[BodyPart.BODYPART_RIGHT_LOWER_LEG.ordinal()]);
        transform.setIdentity();
        transform.origin.set(-0.35f * scale_ragdoll, 1.45f * scale_ragdoll, 0.0f);
        MatrixUtil.setEulerZYX(transform.basis, 0.0f, 0.0f, 1.5707964f);
        tmpTrans.mul(offset, transform);
        this.bodies[BodyPart.BODYPART_LEFT_UPPER_ARM.ordinal()] = this.localCreateRigidBody(1.0f, tmpTrans, this.shapes[BodyPart.BODYPART_LEFT_UPPER_ARM.ordinal()]);
        transform.setIdentity();
        transform.origin.set(-0.7f * scale_ragdoll, 1.45f * scale_ragdoll, 0.0f);
        MatrixUtil.setEulerZYX(transform.basis, 0.0f, 0.0f, 1.5707964f);
        tmpTrans.mul(offset, transform);
        this.bodies[BodyPart.BODYPART_LEFT_LOWER_ARM.ordinal()] = this.localCreateRigidBody(1.0f, tmpTrans, this.shapes[BodyPart.BODYPART_LEFT_LOWER_ARM.ordinal()]);
        transform.setIdentity();
        transform.origin.set(0.35f * scale_ragdoll, 1.45f * scale_ragdoll, 0.0f);
        MatrixUtil.setEulerZYX(transform.basis, 0.0f, 0.0f, -1.5707964f);
        tmpTrans.mul(offset, transform);
        this.bodies[BodyPart.BODYPART_RIGHT_UPPER_ARM.ordinal()] = this.localCreateRigidBody(1.0f, tmpTrans, this.shapes[BodyPart.BODYPART_RIGHT_UPPER_ARM.ordinal()]);
        transform.setIdentity();
        transform.origin.set(0.7f * scale_ragdoll, 1.45f * scale_ragdoll, 0.0f);
        MatrixUtil.setEulerZYX(transform.basis, 0.0f, 0.0f, -1.5707964f);
        tmpTrans.mul(offset, transform);
        this.bodies[BodyPart.BODYPART_RIGHT_LOWER_ARM.ordinal()] = this.localCreateRigidBody(1.0f, tmpTrans, this.shapes[BodyPart.BODYPART_RIGHT_LOWER_ARM.ordinal()]);
        for (int i = 0; i < BodyPart.BODYPART_COUNT.ordinal(); ++i) {
            this.bodies[i].setDamping(0.05f, 0.85f);
            this.bodies[i].setDeactivationTime(0.8f);
            this.bodies[i].setSleepingThresholds(1.6f, 2.5f);
        }
        Transform localA = new Transform();
        Transform localB = new Transform();
        boolean useLinearReferenceFrameA = true;
        localA.setIdentity();
        localB.setIdentity();
        localA.origin.set(0.0f, 0.3f * scale_ragdoll, 0.0f);
        localB.origin.set(0.0f, -0.14f * scale_ragdoll, 0.0f);
        Generic6DofConstraint joint6DOF = new Generic6DofConstraint(this.bodies[BodyPart.BODYPART_SPINE.ordinal()], this.bodies[BodyPart.BODYPART_HEAD.ordinal()], localA, localB, useLinearReferenceFrameA);
        tmp.set(-0.9424779f, -1.1920929E-7f, -0.9424779f);
        joint6DOF.setAngularLowerLimit(tmp);
        tmp.set(1.5707964f, 1.1920929E-7f, 0.9424779f);
        joint6DOF.setAngularUpperLimit(tmp);
        this.joints[JointType.JOINT_SPINE_HEAD.ordinal()] = joint6DOF;
        ownerWorld.addConstraint(this.joints[JointType.JOINT_SPINE_HEAD.ordinal()], true);
        localA.setIdentity();
        localB.setIdentity();
        localA.origin.set(-0.2f * scale_ragdoll, 0.15f * scale_ragdoll, 0.0f);
        MatrixUtil.setEulerZYX(localB.basis, 1.5707964f, 0.0f, -1.5707964f);
        localB.origin.set(0.0f, -0.18f * scale_ragdoll, 0.0f);
        joint6DOF = new Generic6DofConstraint(this.bodies[BodyPart.BODYPART_SPINE.ordinal()], this.bodies[BodyPart.BODYPART_LEFT_UPPER_ARM.ordinal()], localA, localB, useLinearReferenceFrameA);
        tmp.set(-2.5132742f, -1.1920929E-7f, -1.5707964f);
        joint6DOF.setAngularLowerLimit(tmp);
        tmp.set(2.5132742f, 1.1920929E-7f, 1.5707964f);
        joint6DOF.setAngularUpperLimit(tmp);
        this.joints[JointType.JOINT_LEFT_SHOULDER.ordinal()] = joint6DOF;
        ownerWorld.addConstraint(this.joints[JointType.JOINT_LEFT_SHOULDER.ordinal()], true);
        localA.setIdentity();
        localB.setIdentity();
        localA.origin.set(0.2f * scale_ragdoll, 0.15f * scale_ragdoll, 0.0f);
        MatrixUtil.setEulerZYX(localB.basis, 0.0f, 0.0f, 1.5707964f);
        localB.origin.set(0.0f, -0.18f * scale_ragdoll, 0.0f);
        joint6DOF = new Generic6DofConstraint(this.bodies[BodyPart.BODYPART_SPINE.ordinal()], this.bodies[BodyPart.BODYPART_RIGHT_UPPER_ARM.ordinal()], localA, localB, useLinearReferenceFrameA);
        tmp.set(-2.5132742f, -1.1920929E-7f, -1.5707964f);
        joint6DOF.setAngularLowerLimit(tmp);
        tmp.set(2.5132742f, 1.1920929E-7f, 1.5707964f);
        joint6DOF.setAngularUpperLimit(tmp);
        this.joints[JointType.JOINT_RIGHT_SHOULDER.ordinal()] = joint6DOF;
        ownerWorld.addConstraint(this.joints[JointType.JOINT_RIGHT_SHOULDER.ordinal()], true);
        localA.setIdentity();
        localB.setIdentity();
        localA.origin.set(0.0f, 0.18f * scale_ragdoll, 0.0f);
        localB.origin.set(0.0f, -0.14f * scale_ragdoll, 0.0f);
        joint6DOF = new Generic6DofConstraint(this.bodies[BodyPart.BODYPART_LEFT_UPPER_ARM.ordinal()], this.bodies[BodyPart.BODYPART_LEFT_LOWER_ARM.ordinal()], localA, localB, useLinearReferenceFrameA);
        tmp.set(-1.1920929E-7f, -1.1920929E-7f, -1.1920929E-7f);
        joint6DOF.setAngularLowerLimit(tmp);
        tmp.set(2.1991148f, 1.1920929E-7f, 1.1920929E-7f);
        joint6DOF.setAngularUpperLimit(tmp);
        this.joints[JointType.JOINT_LEFT_ELBOW.ordinal()] = joint6DOF;
        ownerWorld.addConstraint(this.joints[JointType.JOINT_LEFT_ELBOW.ordinal()], true);
        localA.setIdentity();
        localB.setIdentity();
        localA.origin.set(0.0f, 0.18f * scale_ragdoll, 0.0f);
        localB.origin.set(0.0f, -0.14f * scale_ragdoll, 0.0f);
        joint6DOF = new Generic6DofConstraint(this.bodies[BodyPart.BODYPART_RIGHT_UPPER_ARM.ordinal()], this.bodies[BodyPart.BODYPART_RIGHT_LOWER_ARM.ordinal()], localA, localB, useLinearReferenceFrameA);
        tmp.set(-1.1920929E-7f, -1.1920929E-7f, -1.1920929E-7f);
        joint6DOF.setAngularLowerLimit(tmp);
        tmp.set(2.1991148f, 1.1920929E-7f, 1.1920929E-7f);
        joint6DOF.setAngularUpperLimit(tmp);
        this.joints[JointType.JOINT_RIGHT_ELBOW.ordinal()] = joint6DOF;
        ownerWorld.addConstraint(this.joints[JointType.JOINT_RIGHT_ELBOW.ordinal()], true);
        localA.setIdentity();
        localB.setIdentity();
        MatrixUtil.setEulerZYX(localA.basis, 0.0f, 1.5707964f, 0.0f);
        localA.origin.set(0.0f, 0.15f * scale_ragdoll, 0.0f);
        MatrixUtil.setEulerZYX(localB.basis, 0.0f, 1.5707964f, 0.0f);
        localB.origin.set(0.0f, -0.15f * scale_ragdoll, 0.0f);
        joint6DOF = new Generic6DofConstraint(this.bodies[BodyPart.BODYPART_PELVIS.ordinal()], this.bodies[BodyPart.BODYPART_SPINE.ordinal()], localA, localB, useLinearReferenceFrameA);
        tmp.set(-0.62831855f, -1.1920929E-7f, -0.9424779f);
        joint6DOF.setAngularLowerLimit(tmp);
        tmp.set(0.62831855f, 1.1920929E-7f, 1.8849558f);
        joint6DOF.setAngularUpperLimit(tmp);
        this.joints[JointType.JOINT_PELVIS_SPINE.ordinal()] = joint6DOF;
        ownerWorld.addConstraint(this.joints[JointType.JOINT_PELVIS_SPINE.ordinal()], true);
        localA.setIdentity();
        localB.setIdentity();
        localA.origin.set(-0.18f * scale_ragdoll, -0.1f * scale_ragdoll, 0.0f);
        localB.origin.set(0.0f, 0.225f * scale_ragdoll, 0.0f);
        joint6DOF = new Generic6DofConstraint(this.bodies[BodyPart.BODYPART_PELVIS.ordinal()], this.bodies[BodyPart.BODYPART_LEFT_UPPER_LEG.ordinal()], localA, localB, useLinearReferenceFrameA);
        tmp.set(-0.7853982f, -1.1920929E-7f, -1.1920929E-7f);
        joint6DOF.setAngularLowerLimit(tmp);
        tmp.set(1.2566371f, 1.1920929E-7f, 0.9424779f);
        joint6DOF.setAngularUpperLimit(tmp);
        this.joints[JointType.JOINT_LEFT_HIP.ordinal()] = joint6DOF;
        ownerWorld.addConstraint(this.joints[JointType.JOINT_LEFT_HIP.ordinal()], true);
        localA.setIdentity();
        localB.setIdentity();
        localA.origin.set(0.18f * scale_ragdoll, -0.1f * scale_ragdoll, 0.0f);
        localB.origin.set(0.0f, 0.225f * scale_ragdoll, 0.0f);
        joint6DOF = new Generic6DofConstraint(this.bodies[BodyPart.BODYPART_PELVIS.ordinal()], this.bodies[BodyPart.BODYPART_RIGHT_UPPER_LEG.ordinal()], localA, localB, useLinearReferenceFrameA);
        tmp.set(-0.7853982f, -1.1920929E-7f, -0.9424779f);
        joint6DOF.setAngularLowerLimit(tmp);
        tmp.set(1.2566371f, 1.1920929E-7f, 1.1920929E-7f);
        joint6DOF.setAngularUpperLimit(tmp);
        this.joints[JointType.JOINT_RIGHT_HIP.ordinal()] = joint6DOF;
        ownerWorld.addConstraint(this.joints[JointType.JOINT_RIGHT_HIP.ordinal()], true);
        localA.setIdentity();
        localB.setIdentity();
        localA.origin.set(0.0f, -0.225f * scale_ragdoll, 0.0f);
        localB.origin.set(0.0f, 0.185f * scale_ragdoll, 0.0f);
        joint6DOF = new Generic6DofConstraint(this.bodies[BodyPart.BODYPART_LEFT_UPPER_LEG.ordinal()], this.bodies[BodyPart.BODYPART_LEFT_LOWER_LEG.ordinal()], localA, localB, useLinearReferenceFrameA);
        tmp.set(-1.1920929E-7f, -1.1920929E-7f, -1.1920929E-7f);
        joint6DOF.setAngularLowerLimit(tmp);
        tmp.set(2.1991148f, 1.1920929E-7f, 1.1920929E-7f);
        joint6DOF.setAngularUpperLimit(tmp);
        this.joints[JointType.JOINT_LEFT_KNEE.ordinal()] = joint6DOF;
        ownerWorld.addConstraint(this.joints[JointType.JOINT_LEFT_KNEE.ordinal()], true);
        localA.setIdentity();
        localB.setIdentity();
        localA.origin.set(0.0f, -0.225f * scale_ragdoll, 0.0f);
        localB.origin.set(0.0f, 0.185f * scale_ragdoll, 0.0f);
        joint6DOF = new Generic6DofConstraint(this.bodies[BodyPart.BODYPART_RIGHT_UPPER_LEG.ordinal()], this.bodies[BodyPart.BODYPART_RIGHT_LOWER_LEG.ordinal()], localA, localB, useLinearReferenceFrameA);
        tmp.set(-1.1920929E-7f, -1.1920929E-7f, -1.1920929E-7f);
        joint6DOF.setAngularLowerLimit(tmp);
        tmp.set(2.1991148f, 1.1920929E-7f, 1.1920929E-7f);
        joint6DOF.setAngularUpperLimit(tmp);
        this.joints[JointType.JOINT_RIGHT_KNEE.ordinal()] = joint6DOF;
        ownerWorld.addConstraint(this.joints[JointType.JOINT_RIGHT_KNEE.ordinal()], true);
    }

    public void destroy() {
        int i;
        for (i = 0; i < JointType.JOINT_COUNT.ordinal(); ++i) {
            this.ownerWorld.removeConstraint(this.joints[i]);
            this.joints[i] = null;
        }
        for (i = 0; i < BodyPart.BODYPART_COUNT.ordinal(); ++i) {
            this.ownerWorld.removeRigidBody(this.bodies[i]);
            this.bodies[i].destroy();
            this.bodies[i] = null;
            this.shapes[i] = null;
        }
    }

    private RigidBody localCreateRigidBody(float mass, Transform startTransform, CollisionShape shape) {
        boolean isDynamic = mass != 0.0f;
        Vector3f localInertia = new Vector3f();
        localInertia.set(0.0f, 0.0f, 0.0f);
        if (isDynamic) {
            shape.calculateLocalInertia(mass, localInertia);
        }
        DefaultMotionState myMotionState = new DefaultMotionState(startTransform);
        RigidBodyConstructionInfo rbInfo = new RigidBodyConstructionInfo(mass, myMotionState, shape, localInertia);
        rbInfo.additionalDamping = true;
        RigidBody body = new RigidBody(rbInfo);
        this.ownerWorld.addRigidBody(body);
        return body;
    }

    public static enum JointType {
        JOINT_PELVIS_SPINE,
        JOINT_SPINE_HEAD,
        JOINT_LEFT_HIP,
        JOINT_LEFT_KNEE,
        JOINT_RIGHT_HIP,
        JOINT_RIGHT_KNEE,
        JOINT_LEFT_SHOULDER,
        JOINT_LEFT_ELBOW,
        JOINT_RIGHT_SHOULDER,
        JOINT_RIGHT_ELBOW,
        JOINT_COUNT;

    }

    public static enum BodyPart {
        BODYPART_PELVIS,
        BODYPART_SPINE,
        BODYPART_HEAD,
        BODYPART_LEFT_UPPER_LEG,
        BODYPART_LEFT_LOWER_LEG,
        BODYPART_RIGHT_UPPER_LEG,
        BODYPART_RIGHT_LOWER_LEG,
        BODYPART_LEFT_UPPER_ARM,
        BODYPART_LEFT_LOWER_ARM,
        BODYPART_RIGHT_UPPER_ARM,
        BODYPART_RIGHT_LOWER_ARM,
        BODYPART_COUNT;

    }
}

