/*
 * Decompiled with CFR 0.152.
 */
package com.bulletphysics.dynamics.vehicle;

import com.bulletphysics.$Stack;
import com.bulletphysics.dynamics.RigidBody;
import com.bulletphysics.dynamics.vehicle.WheelInfoConstructionInfo;
import com.bulletphysics.linearmath.Transform;
import javax.vecmath.Vector3f;

public class WheelInfo {
    public final RaycastInfo raycastInfo = new RaycastInfo();
    public final Transform worldTransform = new Transform();
    public final Vector3f chassisConnectionPointCS = new Vector3f();
    public final Vector3f wheelDirectionCS = new Vector3f();
    public final Vector3f wheelAxleCS = new Vector3f();
    public float suspensionRestLength1;
    public float maxSuspensionTravelCm;
    public float wheelsRadius;
    public float suspensionStiffness;
    public float wheelsDampingCompression;
    public float wheelsDampingRelaxation;
    public float frictionSlip;
    public float steering;
    public float rotation;
    public float deltaRotation;
    public float rollInfluence;
    public float engineForce;
    public float brake;
    public boolean bIsFrontWheel;
    public Object clientInfo;
    public float clippedInvContactDotSuspension;
    public float suspensionRelativeVelocity;
    public float wheelsSuspensionForce;
    public float skidInfo;

    public WheelInfo(WheelInfoConstructionInfo ci) {
        this.suspensionRestLength1 = ci.suspensionRestLength;
        this.maxSuspensionTravelCm = ci.maxSuspensionTravelCm;
        this.wheelsRadius = ci.wheelRadius;
        this.suspensionStiffness = ci.suspensionStiffness;
        this.wheelsDampingCompression = ci.wheelsDampingCompression;
        this.wheelsDampingRelaxation = ci.wheelsDampingRelaxation;
        this.chassisConnectionPointCS.set(ci.chassisConnectionCS);
        this.wheelDirectionCS.set(ci.wheelDirectionCS);
        this.wheelAxleCS.set(ci.wheelAxleCS);
        this.frictionSlip = ci.frictionSlip;
        this.steering = 0.0f;
        this.engineForce = 0.0f;
        this.rotation = 0.0f;
        this.deltaRotation = 0.0f;
        this.brake = 0.0f;
        this.rollInfluence = 0.1f;
        this.bIsFrontWheel = ci.bIsFrontWheel;
    }

    public float getSuspensionRestLength() {
        return this.suspensionRestLength1;
    }

    /*
     * WARNING - void declaration
     */
    public void updateWheel(RigidBody rigidBody, RaycastInfo raycastInfo) {
        $Stack $Stack = $Stack.get();
        try {
            void raycastInfo2;
            $Stack.push$javax$vecmath$Vector3f();
            if (raycastInfo2.isInContact) {
                void chassis;
                float project = raycastInfo2.contactNormalWS.dot(raycastInfo2.wheelDirectionWS);
                Vector3f chassis_velocity_at_contactPoint = $Stack.get$javax$vecmath$Vector3f();
                Vector3f relpos = $Stack.get$javax$vecmath$Vector3f();
                relpos.sub(raycastInfo2.contactPointWS, chassis.getCenterOfMassPosition($Stack.get$javax$vecmath$Vector3f()));
                chassis.getVelocityInLocalPoint(relpos, chassis_velocity_at_contactPoint);
                float projVel = raycastInfo2.contactNormalWS.dot(chassis_velocity_at_contactPoint);
                if (project >= -0.1f) {
                    this.suspensionRelativeVelocity = 0.0f;
                    this.clippedInvContactDotSuspension = 10.0f;
                } else {
                    float inv = -1.0f / project;
                    this.suspensionRelativeVelocity = projVel * inv;
                    this.clippedInvContactDotSuspension = inv;
                }
            } else {
                raycastInfo2.suspensionLength = this.getSuspensionRestLength();
                this.suspensionRelativeVelocity = 0.0f;
                raycastInfo2.contactNormalWS.negate(raycastInfo2.wheelDirectionWS);
                this.clippedInvContactDotSuspension = 1.0f;
            }
            $Stack.pop$javax$vecmath$Vector3f();
            return;
        }
        catch (Throwable throwable) {
            $Stack.pop$javax$vecmath$Vector3f();
            throw throwable;
        }
    }

    public static class RaycastInfo {
        public final Vector3f contactNormalWS = new Vector3f();
        public final Vector3f contactPointWS = new Vector3f();
        public float suspensionLength;
        public final Vector3f hardPointWS = new Vector3f();
        public final Vector3f wheelDirectionWS = new Vector3f();
        public final Vector3f wheelAxleWS = new Vector3f();
        public boolean isInContact;
        public Object groundObject;
    }
}

