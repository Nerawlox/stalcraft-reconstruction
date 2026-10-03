/*
 * Decompiled with CFR 0.152.
 */
package com.bulletphysics.demos.dynamiccontrol;

import com.bulletphysics.collision.shapes.CapsuleShape;
import com.bulletphysics.collision.shapes.CollisionShape;
import com.bulletphysics.demos.genericjoint.RagDoll;
import com.bulletphysics.dynamics.DynamicsWorld;
import com.bulletphysics.dynamics.RigidBody;
import com.bulletphysics.dynamics.RigidBodyConstructionInfo;
import com.bulletphysics.dynamics.constraintsolver.HingeConstraint;
import com.bulletphysics.dynamics.constraintsolver.TypedConstraint;
import com.bulletphysics.linearmath.DefaultMotionState;
import com.bulletphysics.linearmath.MatrixUtil;
import com.bulletphysics.linearmath.QuaternionUtil;
import com.bulletphysics.linearmath.Transform;
import javax.vecmath.Quat4f;
import javax.vecmath.Vector3f;

public class TestRig {
    public static final int NUM_LEGS = 6;
    private static final int BODYPART_COUNT = 13;
    private static final int JOINT_COUNT = 12;
    private DynamicsWorld ownerWorld;
    private CollisionShape[] shapes = new CollisionShape[13];
    private RigidBody[] bodies = new RigidBody[13];
    private TypedConstraint[] joints = new TypedConstraint[12];

    public TestRig(DynamicsWorld ownerWorld, Vector3f positionOffset, boolean fixed) {
        int i;
        this.ownerWorld = ownerWorld;
        Transform tmpTrans = new Transform();
        Vector3f up = new Vector3f();
        up.set(0.0f, 1.0f, 0.0f);
        float bodySize = 0.25f;
        float legLength = 0.45f;
        float foreLegLength = 0.75f;
        this.shapes[0] = new CapsuleShape(bodySize, 0.1f);
        for (i = 0; i < 6; ++i) {
            this.shapes[1 + 2 * i] = new CapsuleShape(0.1f, legLength);
            this.shapes[2 + 2 * i] = new CapsuleShape(0.08f, foreLegLength);
        }
        float height = 0.5f;
        Transform offset = new Transform();
        offset.setIdentity();
        offset.origin.set(positionOffset);
        Vector3f root = new Vector3f();
        root.set(0.0f, height, 0.0f);
        Transform transform = new Transform();
        transform.setIdentity();
        transform.origin.set(root);
        tmpTrans.mul(offset, transform);
        this.bodies[0] = fixed ? this.localCreateRigidBody(0.0f, tmpTrans, this.shapes[0]) : this.localCreateRigidBody(1.0f, tmpTrans, this.shapes[0]);
        for (i = 0; i < 6; ++i) {
            float angle = (float)Math.PI * 2 * (float)i / 6.0f;
            float sin = (float)Math.sin(angle);
            float cos = (float)Math.cos(angle);
            transform.setIdentity();
            Vector3f boneOrigin = new Vector3f();
            boneOrigin.set(cos * (bodySize + 0.5f * legLength), height, sin * (bodySize + 0.5f * legLength));
            transform.origin.set(boneOrigin);
            Vector3f toBone = new Vector3f(boneOrigin);
            toBone.sub(root);
            toBone.normalize();
            Vector3f axis = new Vector3f();
            axis.cross(toBone, up);
            Quat4f q = new Quat4f();
            QuaternionUtil.setRotation(q, axis, 1.5707964f);
            transform.setRotation(q);
            tmpTrans.mul(offset, transform);
            this.bodies[1 + 2 * i] = this.localCreateRigidBody(1.0f, tmpTrans, this.shapes[1 + 2 * i]);
            transform.setIdentity();
            transform.origin.set(cos * (bodySize + legLength), height - 0.5f * foreLegLength, sin * (bodySize + legLength));
            tmpTrans.mul(offset, transform);
            this.bodies[2 + 2 * i] = this.localCreateRigidBody(1.0f, tmpTrans, this.shapes[2 + 2 * i]);
        }
        for (i = 0; i < 13; ++i) {
            this.bodies[i].setDamping(0.05f, 0.85f);
            this.bodies[i].setDeactivationTime(0.8f);
            this.bodies[i].setSleepingThresholds(1.6f, 2.5f);
        }
        Transform localA = new Transform();
        Transform localB = new Transform();
        Transform localC = new Transform();
        for (i = 0; i < 6; ++i) {
            float angle = (float)Math.PI * 2 * (float)i / 6.0f;
            float sin = (float)Math.sin(angle);
            float cos = (float)Math.cos(angle);
            localA.setIdentity();
            localB.setIdentity();
            MatrixUtil.setEulerZYX(localA.basis, 0.0f, -angle, 0.0f);
            localA.origin.set(cos * bodySize, 0.0f, sin * bodySize);
            tmpTrans.inverse(this.bodies[1 + 2 * i].getWorldTransform(new Transform()));
            tmpTrans.mul(tmpTrans, this.bodies[0].getWorldTransform(new Transform()));
            localB.mul(tmpTrans, localA);
            HingeConstraint hingeC = new HingeConstraint(this.bodies[0], this.bodies[1 + 2 * i], localA, localB);
            hingeC.setLimit(-0.5890486f, 0.3926991f);
            this.joints[2 * i] = hingeC;
            ownerWorld.addConstraint(this.joints[2 * i], true);
            localA.setIdentity();
            localB.setIdentity();
            localC.setIdentity();
            MatrixUtil.setEulerZYX(localA.basis, 0.0f, -angle, 0.0f);
            localA.origin.set(cos * (bodySize + legLength), 0.0f, sin * (bodySize + legLength));
            tmpTrans.inverse(this.bodies[1 + 2 * i].getWorldTransform(new Transform()));
            tmpTrans.mul(tmpTrans, this.bodies[0].getWorldTransform(new Transform()));
            localB.mul(tmpTrans, localA);
            tmpTrans.inverse(this.bodies[2 + 2 * i].getWorldTransform(new Transform()));
            tmpTrans.mul(tmpTrans, this.bodies[0].getWorldTransform(new Transform()));
            localC.mul(tmpTrans, localA);
            hingeC = new HingeConstraint(this.bodies[1 + 2 * i], this.bodies[2 + 2 * i], localB, localC);
            hingeC.setLimit(-0.3926991f, 0.2f);
            this.joints[1 + 2 * i] = hingeC;
            ownerWorld.addConstraint(this.joints[1 + 2 * i], true);
        }
    }

    public void destroy() {
        int i;
        for (i = 0; i < 12; ++i) {
            this.ownerWorld.removeConstraint(this.joints[i]);
            this.joints[i] = null;
        }
        for (i = 0; i < RagDoll.BodyPart.BODYPART_COUNT.ordinal(); ++i) {
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
        RigidBody body = new RigidBody(rbInfo);
        this.ownerWorld.addRigidBody(body);
        return body;
    }

    public TypedConstraint[] getJoints() {
        return this.joints;
    }
}

