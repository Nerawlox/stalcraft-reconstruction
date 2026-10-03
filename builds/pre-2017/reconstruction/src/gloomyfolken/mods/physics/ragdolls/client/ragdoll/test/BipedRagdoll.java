/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.physics.ragdolls.client.ragdoll.test;

import com.bulletphysics.collision.shapes.CollisionShape;
import com.bulletphysics.collision.shapes.ConvexHullShape;
import com.bulletphysics.collision.shapes.ConvexInternalShape;
import com.bulletphysics.dynamics.DynamicsWorld;
import com.bulletphysics.dynamics.RigidBody;
import com.bulletphysics.dynamics.RigidBodyConstructionInfo;
import com.bulletphysics.dynamics.constraintsolver.Generic6DofConstraint;
import com.bulletphysics.dynamics.constraintsolver.TypedConstraint;
import com.bulletphysics.linearmath.DefaultMotionState;
import com.bulletphysics.linearmath.MatrixUtil;
import com.bulletphysics.linearmath.Transform;
import com.bulletphysics.util.ObjectArrayList;
import javax.vecmath.Vector3f;

public class BipedRagdoll {
    private DynamicsWorld ownerWorld;
    private CollisionShape[] shapes = new CollisionShape[BodyPart.BODYPART_COUNT.ordinal()];
    private RigidBody[] bodies = new RigidBody[BodyPart.BODYPART_COUNT.ordinal()];
    private TypedConstraint[] joints = new TypedConstraint[JointType.JOINT_COUNT.ordinal()];

    public BipedRagdoll(DynamicsWorld dynamicsWorld, Vector3f vector3f) {
        this(dynamicsWorld, vector3f, 1.0f);
    }

    private ConvexInternalShape HullShape(float f, float f2) {
        ObjectArrayList<Vector3f> objectArrayList = new ObjectArrayList<Vector3f>();
        for (int i = 0; i < 8; ++i) {
            Vector3f vector3f = new Vector3f();
            float f3 = i % 4 < 2 ? -f : f;
            float f4 = i % 2 == 0 ? -f : f;
            float f5 = i > 3 ? 0.5f * f2 : -0.5f * f2;
            vector3f.set(f3, f5, f4);
            objectArrayList.add(vector3f);
        }
        return new ConvexHullShape(objectArrayList);
    }

    public BipedRagdoll(DynamicsWorld dynamicsWorld, Vector3f vector3f, float f) {
        this.ownerWorld = dynamicsWorld;
        Transform transform = new Transform();
        Vector3f vector3f2 = new Vector3f();
        this.shapes[BodyPart.BODYPART_PELVIS.ordinal()] = this.HullShape(f * 0.15f, f * 0.2f);
        this.shapes[BodyPart.BODYPART_SPINE.ordinal()] = this.HullShape(f * 0.15f, f * 0.38f);
        this.shapes[BodyPart.BODYPART_HEAD.ordinal()] = this.HullShape(f * 0.15f, f * 0.3f);
        this.shapes[BodyPart.BODYPART_LEFT_UPPER_LEG.ordinal()] = this.HullShape(f * 0.15f, f * 0.82f);
        this.shapes[BodyPart.BODYPART_RIGHT_UPPER_LEG.ordinal()] = this.HullShape(f * 0.15f, f * 0.82f);
        this.shapes[BodyPart.BODYPART_LEFT_UPPER_ARM.ordinal()] = this.HullShape(f * 0.15f, f * 0.58f);
        this.shapes[BodyPart.BODYPART_RIGHT_UPPER_ARM.ordinal()] = this.HullShape(f * 0.15f, f * 0.58f);
        Transform transform2 = new Transform();
        transform2.setIdentity();
        transform2.origin.set(vector3f);
        Transform transform3 = new Transform();
        transform3.setIdentity();
        transform3.origin.set(0.0f, f * 1.0f, 0.0f);
        transform.mul(transform2, transform3);
        this.bodies[BodyPart.BODYPART_PELVIS.ordinal()] = this.localCreateRigidBody(1.0f, transform, this.shapes[BodyPart.BODYPART_PELVIS.ordinal()]);
        transform3.setIdentity();
        transform3.origin.set(0.0f, f * 1.2f, 0.0f);
        transform.mul(transform2, transform3);
        this.bodies[BodyPart.BODYPART_SPINE.ordinal()] = this.localCreateRigidBody(1.0f, transform, this.shapes[BodyPart.BODYPART_SPINE.ordinal()]);
        transform3.setIdentity();
        transform3.origin.set(0.0f, f * 1.6f, 0.0f);
        transform.mul(transform2, transform3);
        this.bodies[BodyPart.BODYPART_HEAD.ordinal()] = this.localCreateRigidBody(1.0f, transform, this.shapes[BodyPart.BODYPART_HEAD.ordinal()]);
        transform3.setIdentity();
        transform3.origin.set(-0.18f * f, 0.65f * f, 0.0f);
        transform.mul(transform2, transform3);
        this.bodies[BodyPart.BODYPART_LEFT_UPPER_LEG.ordinal()] = this.localCreateRigidBody(1.0f, transform, this.shapes[BodyPart.BODYPART_LEFT_UPPER_LEG.ordinal()]);
        transform3.setIdentity();
        transform3.origin.set(0.18f * f, 0.65f * f, 0.0f);
        transform.mul(transform2, transform3);
        this.bodies[BodyPart.BODYPART_RIGHT_UPPER_LEG.ordinal()] = this.localCreateRigidBody(1.0f, transform, this.shapes[BodyPart.BODYPART_RIGHT_UPPER_LEG.ordinal()]);
        transform3.setIdentity();
        transform3.origin.set(-0.35f * f, 1.45f * f, 0.0f);
        MatrixUtil.setEulerZYX(transform3.basis, 0.0f, 0.0f, 1.5707964f);
        transform.mul(transform2, transform3);
        this.bodies[BodyPart.BODYPART_LEFT_UPPER_ARM.ordinal()] = this.localCreateRigidBody(1.0f, transform, this.shapes[BodyPart.BODYPART_LEFT_UPPER_ARM.ordinal()]);
        transform3.origin.set(0.35f * f, 1.45f * f, 0.0f);
        MatrixUtil.setEulerZYX(transform3.basis, 0.0f, 0.0f, -1.5707964f);
        transform.mul(transform2, transform3);
        this.bodies[BodyPart.BODYPART_RIGHT_UPPER_ARM.ordinal()] = this.localCreateRigidBody(1.0f, transform, this.shapes[BodyPart.BODYPART_RIGHT_UPPER_ARM.ordinal()]);
        for (int i = 0; i < BodyPart.BODYPART_COUNT.ordinal(); ++i) {
            this.bodies[i].setDamping(0.05f, 0.95f);
            this.bodies[i].setDeactivationTime(0.2f);
            this.bodies[i].setSleepingThresholds(3.1f, 5.1f);
            this.bodies[i].setUserPointer(new Integer(0));
        }
        Transform transform4 = new Transform();
        Transform transform5 = new Transform();
        boolean bl = true;
        transform4.setIdentity();
        transform5.setIdentity();
        transform4.origin.set(0.0f, 0.3f * f, 0.0f);
        transform5.origin.set(0.0f, -0.14f * f, 0.0f);
        Generic6DofConstraint generic6DofConstraint = new Generic6DofConstraint(this.bodies[BodyPart.BODYPART_SPINE.ordinal()], this.bodies[BodyPart.BODYPART_HEAD.ordinal()], transform4, transform5, bl);
        vector3f2.set(-0.9424779f, -1.1920929E-7f, -0.9424779f);
        generic6DofConstraint.setAngularLowerLimit(vector3f2);
        vector3f2.set(1.5707964f, 1.1920929E-7f, 0.9424779f);
        generic6DofConstraint.setAngularUpperLimit(vector3f2);
        this.joints[JointType.JOINT_SPINE_HEAD.ordinal()] = generic6DofConstraint;
        dynamicsWorld.addConstraint(this.joints[JointType.JOINT_SPINE_HEAD.ordinal()], true);
        transform4.setIdentity();
        transform5.setIdentity();
        transform4.origin.set(-0.2f * f, 0.15f * f, 0.0f);
        MatrixUtil.setEulerZYX(transform5.basis, 1.5707964f, 0.0f, -1.5707964f);
        transform5.origin.set(0.0f, -0.18f * f, 0.0f);
        generic6DofConstraint = new Generic6DofConstraint(this.bodies[BodyPart.BODYPART_SPINE.ordinal()], this.bodies[BodyPart.BODYPART_LEFT_UPPER_ARM.ordinal()], transform4, transform5, bl);
        vector3f2.set(-2.5132742f, -1.0f, -1.5707964f);
        generic6DofConstraint.setAngularLowerLimit(vector3f2);
        vector3f2.set(2.5132742f, 1.0f, 1.5707964f);
        generic6DofConstraint.setAngularUpperLimit(vector3f2);
        this.joints[JointType.JOINT_LEFT_SHOULDER.ordinal()] = generic6DofConstraint;
        dynamicsWorld.addConstraint(this.joints[JointType.JOINT_LEFT_SHOULDER.ordinal()], true);
        transform4.setIdentity();
        transform5.setIdentity();
        transform4.origin.set(0.2f * f, 0.15f * f, 0.0f);
        MatrixUtil.setEulerZYX(transform5.basis, 0.0f, 0.0f, 1.5707964f);
        transform5.origin.set(0.0f, -0.18f * f, 0.0f);
        generic6DofConstraint = new Generic6DofConstraint(this.bodies[BodyPart.BODYPART_SPINE.ordinal()], this.bodies[BodyPart.BODYPART_RIGHT_UPPER_ARM.ordinal()], transform4, transform5, bl);
        vector3f2.set(-2.5132742f, -1.0f, -1.5707964f);
        generic6DofConstraint.setAngularLowerLimit(vector3f2);
        vector3f2.set(2.5132742f, 1.0f, 1.5707964f);
        generic6DofConstraint.setAngularUpperLimit(vector3f2);
        this.joints[JointType.JOINT_RIGHT_SHOULDER.ordinal()] = generic6DofConstraint;
        dynamicsWorld.addConstraint(this.joints[JointType.JOINT_RIGHT_SHOULDER.ordinal()], true);
        transform4.setIdentity();
        transform5.setIdentity();
        MatrixUtil.setEulerZYX(transform4.basis, 0.0f, 1.5707964f, 0.0f);
        transform4.origin.set(0.0f, 0.15f * f, 0.0f);
        MatrixUtil.setEulerZYX(transform5.basis, 0.0f, 1.5707964f, 0.0f);
        transform5.origin.set(0.0f, -0.15f * f, 0.0f);
        generic6DofConstraint = new Generic6DofConstraint(this.bodies[BodyPart.BODYPART_PELVIS.ordinal()], this.bodies[BodyPart.BODYPART_SPINE.ordinal()], transform4, transform5, bl);
        vector3f2.set(-1.1920929E-7f, -1.1920929E-7f, -1.1920929E-7f);
        generic6DofConstraint.setAngularLowerLimit(vector3f2);
        vector3f2.set(1.1920929E-7f, 1.1920929E-7f, 1.1920929E-7f);
        generic6DofConstraint.setAngularUpperLimit(vector3f2);
        this.joints[JointType.JOINT_PELVIS_SPINE.ordinal()] = generic6DofConstraint;
        dynamicsWorld.addConstraint(this.joints[JointType.JOINT_PELVIS_SPINE.ordinal()], true);
        transform4.setIdentity();
        transform5.setIdentity();
        transform4.origin.set(-0.18f * f, -0.1f * f, 0.0f);
        transform5.origin.set(0.0f, 0.225f * f, 0.0f);
        generic6DofConstraint = new Generic6DofConstraint(this.bodies[BodyPart.BODYPART_PELVIS.ordinal()], this.bodies[BodyPart.BODYPART_LEFT_UPPER_LEG.ordinal()], transform4, transform5, bl);
        vector3f2.set(-0.2853982f, -1.1920929E-7f, -1.1920929E-7f);
        generic6DofConstraint.setAngularLowerLimit(vector3f2);
        vector3f2.set(1.2566371f, 1.1920929E-7f, 0.9424779f);
        generic6DofConstraint.setAngularUpperLimit(vector3f2);
        this.joints[JointType.JOINT_LEFT_HIP.ordinal()] = generic6DofConstraint;
        dynamicsWorld.addConstraint(this.joints[JointType.JOINT_LEFT_HIP.ordinal()], true);
        transform4.setIdentity();
        transform5.setIdentity();
        transform4.origin.set(0.18f * f, -0.1f * f, 0.0f);
        transform5.origin.set(0.0f, 0.225f * f, 0.0f);
        generic6DofConstraint = new Generic6DofConstraint(this.bodies[BodyPart.BODYPART_PELVIS.ordinal()], this.bodies[BodyPart.BODYPART_RIGHT_UPPER_LEG.ordinal()], transform4, transform5, bl);
        vector3f2.set(-0.2853982f, -1.1920929E-7f, -0.9424779f);
        generic6DofConstraint.setAngularLowerLimit(vector3f2);
        vector3f2.set(1.2566371f, 1.1920929E-7f, 1.1920929E-7f);
        generic6DofConstraint.setAngularUpperLimit(vector3f2);
        this.joints[JointType.JOINT_RIGHT_HIP.ordinal()] = generic6DofConstraint;
        dynamicsWorld.addConstraint(this.joints[JointType.JOINT_RIGHT_HIP.ordinal()], true);
    }

    public void destroy() {
        int n;
        for (n = 0; n < JointType.JOINT_COUNT.ordinal(); ++n) {
            this.ownerWorld.removeConstraint(this.joints[n]);
            this.joints[n] = null;
        }
        for (n = 0; n < BodyPart.BODYPART_COUNT.ordinal(); ++n) {
            this.ownerWorld.removeRigidBody(this.bodies[n]);
            this.bodies[n].destroy();
            this.bodies[n] = null;
            this.shapes[n] = null;
        }
    }

    private RigidBody localCreateRigidBody(float f, Transform transform, CollisionShape collisionShape) {
        boolean bl = f != 0.0f;
        Vector3f vector3f = new Vector3f();
        vector3f.set(0.0f, 0.0f, 0.0f);
        if (bl) {
            collisionShape.calculateLocalInertia(f, vector3f);
        }
        DefaultMotionState defaultMotionState = new DefaultMotionState(transform);
        RigidBodyConstructionInfo rigidBodyConstructionInfo = new RigidBodyConstructionInfo(f, defaultMotionState, collisionShape, vector3f);
        rigidBodyConstructionInfo.additionalDamping = true;
        RigidBody rigidBody = new RigidBody(rigidBodyConstructionInfo);
        this.ownerWorld.addRigidBody(rigidBody);
        return rigidBody;
    }

    public static enum BodyPart {
        BODYPART_PELVIS,
        BODYPART_SPINE,
        BODYPART_HEAD,
        BODYPART_LEFT_UPPER_LEG,
        BODYPART_RIGHT_UPPER_LEG,
        BODYPART_LEFT_UPPER_ARM,
        BODYPART_RIGHT_UPPER_ARM,
        BODYPART_COUNT;

    }

    public static enum JointType {
        JOINT_PELVIS_SPINE,
        JOINT_SPINE_HEAD,
        JOINT_LEFT_HIP,
        JOINT_RIGHT_HIP,
        JOINT_LEFT_SHOULDER,
        JOINT_RIGHT_SHOULDER,
        JOINT_COUNT;

    }
}

