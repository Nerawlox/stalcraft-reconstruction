/*
 * Decompiled with CFR 0.152.
 */
package com.bulletphysics.dynamics.vehicle;

import com.bulletphysics.$Stack;
import com.bulletphysics.dynamics.RigidBody;
import com.bulletphysics.dynamics.constraintsolver.ContactConstraint;
import com.bulletphysics.dynamics.constraintsolver.TypedConstraint;
import com.bulletphysics.dynamics.constraintsolver.TypedConstraintType;
import com.bulletphysics.dynamics.vehicle.VehicleRaycaster;
import com.bulletphysics.dynamics.vehicle.VehicleRaycasterResult;
import com.bulletphysics.dynamics.vehicle.VehicleTuning;
import com.bulletphysics.dynamics.vehicle.WheelInfo;
import com.bulletphysics.dynamics.vehicle.WheelInfoConstructionInfo;
import com.bulletphysics.linearmath.MatrixUtil;
import com.bulletphysics.linearmath.MiscUtil;
import com.bulletphysics.linearmath.QuaternionUtil;
import com.bulletphysics.linearmath.Transform;
import com.bulletphysics.util.ArrayPool;
import com.bulletphysics.util.FloatArrayList;
import com.bulletphysics.util.ObjectArrayList;
import javax.vecmath.Matrix3f;
import javax.vecmath.Quat4f;
import javax.vecmath.Vector3f;

public class RaycastVehicle
extends TypedConstraint {
    private final ArrayPool<float[]> floatArrays = ArrayPool.get(Float.TYPE);
    private static RigidBody s_fixedObject = new RigidBody(0.0f, null, null);
    private static final float sideFrictionStiffness2 = 1.0f;
    protected ObjectArrayList<Vector3f> forwardWS = new ObjectArrayList();
    protected ObjectArrayList<Vector3f> axle = new ObjectArrayList();
    protected FloatArrayList forwardImpulse = new FloatArrayList();
    protected FloatArrayList sideImpulse = new FloatArrayList();
    private float tau;
    private float damping;
    private VehicleRaycaster vehicleRaycaster;
    private float pitchControl = 0.0f;
    private float steeringValue;
    private float currentVehicleSpeedKmHour;
    private RigidBody chassisBody;
    private int indexRightAxis = 0;
    private int indexUpAxis = 2;
    private int indexForwardAxis = 1;
    public ObjectArrayList<WheelInfo> wheelInfo = new ObjectArrayList();

    public RaycastVehicle(VehicleTuning tuning, RigidBody chassis, VehicleRaycaster raycaster) {
        super(TypedConstraintType.VEHICLE_CONSTRAINT_TYPE);
        this.vehicleRaycaster = raycaster;
        this.chassisBody = chassis;
        this.defaultInit(tuning);
    }

    private void defaultInit(VehicleTuning tuning) {
        this.currentVehicleSpeedKmHour = 0.0f;
        this.steeringValue = 0.0f;
    }

    public WheelInfo addWheel(Vector3f connectionPointCS, Vector3f wheelDirectionCS0, Vector3f wheelAxleCS, float suspensionRestLength, float wheelRadius, VehicleTuning tuning, boolean isFrontWheel) {
        WheelInfoConstructionInfo ci = new WheelInfoConstructionInfo();
        ci.chassisConnectionCS.set(connectionPointCS);
        ci.wheelDirectionCS.set(wheelDirectionCS0);
        ci.wheelAxleCS.set(wheelAxleCS);
        ci.suspensionRestLength = suspensionRestLength;
        ci.wheelRadius = wheelRadius;
        ci.suspensionStiffness = tuning.suspensionStiffness;
        ci.wheelsDampingCompression = tuning.suspensionCompression;
        ci.wheelsDampingRelaxation = tuning.suspensionDamping;
        ci.frictionSlip = tuning.frictionSlip;
        ci.bIsFrontWheel = isFrontWheel;
        ci.maxSuspensionTravelCm = tuning.maxSuspensionTravelCm;
        this.wheelInfo.add(new WheelInfo(ci));
        WheelInfo wheel = this.wheelInfo.getQuick(this.getNumWheels() - 1);
        this.updateWheelTransformsWS(wheel, false);
        this.updateWheelTransform(this.getNumWheels() - 1, false);
        return wheel;
    }

    public Transform getWheelTransformWS(int wheelIndex, Transform out) {
        assert (wheelIndex < this.getNumWheels());
        WheelInfo wheel = this.wheelInfo.getQuick(wheelIndex);
        out.set(wheel.worldTransform);
        return out;
    }

    public void updateWheelTransform(int wheelIndex) {
        this.updateWheelTransform(wheelIndex, true);
    }

    /*
     * WARNING - void declaration
     */
    public void updateWheelTransform(int n, boolean bl) {
        $Stack $Stack = $Stack.get();
        try {
            void interpolatedTransform;
            void wheelIndex;
            $Stack $Stack2 = $Stack;
            $Stack2.push$javax$vecmath$Vector3f();
            $Stack2.push$javax$vecmath$Quat4f();
            $Stack2.push$javax$vecmath$Matrix3f();
            WheelInfo wheel = this.wheelInfo.getQuick((int)wheelIndex);
            this.updateWheelTransformsWS(wheel, (boolean)interpolatedTransform);
            Vector3f up = $Stack.get$javax$vecmath$Vector3f();
            up.negate(wheel.raycastInfo.wheelDirectionWS);
            Vector3f right = wheel.raycastInfo.wheelAxleWS;
            Vector3f fwd = $Stack.get$javax$vecmath$Vector3f();
            fwd.cross(up, right);
            fwd.normalize();
            float steering = wheel.steering;
            Quat4f steeringOrn = $Stack.get$javax$vecmath$Quat4f();
            QuaternionUtil.setRotation(steeringOrn, up, steering);
            Matrix3f steeringMat = $Stack.get$javax$vecmath$Matrix3f();
            MatrixUtil.setRotation(steeringMat, steeringOrn);
            Quat4f rotatingOrn = $Stack.get$javax$vecmath$Quat4f();
            QuaternionUtil.setRotation(rotatingOrn, right, -wheel.rotation);
            Matrix3f rotatingMat = $Stack.get$javax$vecmath$Matrix3f();
            MatrixUtil.setRotation(rotatingMat, rotatingOrn);
            Matrix3f basis2 = $Stack.get$javax$vecmath$Matrix3f();
            basis2.setRow(0, right.x, fwd.x, up.x);
            basis2.setRow(1, right.y, fwd.y, up.y);
            basis2.setRow(2, right.z, fwd.z, up.z);
            Matrix3f wheelBasis = wheel.worldTransform.basis;
            wheelBasis.mul(steeringMat, rotatingMat);
            wheelBasis.mul(basis2);
            wheel.worldTransform.origin.scaleAdd(wheel.raycastInfo.suspensionLength, wheel.raycastInfo.wheelDirectionWS, wheel.raycastInfo.hardPointWS);
            $Stack $Stack3 = $Stack;
            $Stack3.pop$javax$vecmath$Vector3f();
            $Stack3.pop$javax$vecmath$Quat4f();
            $Stack3.pop$javax$vecmath$Matrix3f();
            return;
        }
        catch (Throwable throwable) {
            $Stack $Stack4 = $Stack;
            $Stack4.pop$javax$vecmath$Vector3f();
            $Stack4.pop$javax$vecmath$Quat4f();
            $Stack4.pop$javax$vecmath$Matrix3f();
            throw throwable;
        }
    }

    public void resetSuspension() {
        for (int i = 0; i < this.wheelInfo.size(); ++i) {
            WheelInfo wheel = this.wheelInfo.getQuick(i);
            wheel.raycastInfo.suspensionLength = wheel.getSuspensionRestLength();
            wheel.suspensionRelativeVelocity = 0.0f;
            wheel.raycastInfo.contactNormalWS.negate(wheel.raycastInfo.wheelDirectionWS);
            wheel.clippedInvContactDotSuspension = 1.0f;
        }
    }

    public void updateWheelTransformsWS(WheelInfo wheel) {
        this.updateWheelTransformsWS(wheel, true);
    }

    /*
     * WARNING - void declaration
     */
    public void updateWheelTransformsWS(WheelInfo wheelInfo, boolean bl) {
        $Stack $Stack = $Stack.get();
        try {
            void wheel;
            void interpolatedTransform;
            $Stack.push$com$bulletphysics$linearmath$Transform();
            wheel.raycastInfo.isInContact = false;
            Transform chassisTrans = this.getChassisWorldTransform($Stack.get$com$bulletphysics$linearmath$Transform());
            if (interpolatedTransform != false && this.getRigidBody().getMotionState() != null) {
                this.getRigidBody().getMotionState().getWorldTransform(chassisTrans);
            }
            wheel.raycastInfo.hardPointWS.set(wheel.chassisConnectionPointCS);
            chassisTrans.transform(wheel.raycastInfo.hardPointWS);
            wheel.raycastInfo.wheelDirectionWS.set(wheel.wheelDirectionCS);
            chassisTrans.basis.transform(wheel.raycastInfo.wheelDirectionWS);
            wheel.raycastInfo.wheelAxleWS.set(wheel.wheelAxleCS);
            chassisTrans.basis.transform(wheel.raycastInfo.wheelAxleWS);
            $Stack.pop$com$bulletphysics$linearmath$Transform();
            return;
        }
        catch (Throwable throwable) {
            $Stack.pop$com$bulletphysics$linearmath$Transform();
            throw throwable;
        }
    }

    /*
     * WARNING - void declaration
     */
    public float rayCast(WheelInfo wheelInfo) {
        $Stack $Stack = $Stack.get();
        try {
            void wheel;
            $Stack.push$javax$vecmath$Vector3f();
            this.updateWheelTransformsWS((WheelInfo)wheel, false);
            float depth = -1.0f;
            float raylen = wheel.getSuspensionRestLength() + wheel.wheelsRadius;
            Vector3f rayvector = $Stack.get$javax$vecmath$Vector3f();
            rayvector.scale(raylen, wheel.raycastInfo.wheelDirectionWS);
            Vector3f source = wheel.raycastInfo.hardPointWS;
            wheel.raycastInfo.contactPointWS.add(source, rayvector);
            Vector3f target = wheel.raycastInfo.contactPointWS;
            float param = 0.0f;
            VehicleRaycasterResult rayResults = new VehicleRaycasterResult();
            assert (this.vehicleRaycaster != null);
            Object object = this.vehicleRaycaster.castRay(source, target, rayResults);
            wheel.raycastInfo.groundObject = null;
            if (object != null) {
                param = rayResults.distFraction;
                depth = raylen * rayResults.distFraction;
                wheel.raycastInfo.contactNormalWS.set(rayResults.hitNormalInWorld);
                wheel.raycastInfo.isInContact = true;
                wheel.raycastInfo.groundObject = s_fixedObject;
                float hitDistance = param * raylen;
                wheel.raycastInfo.suspensionLength = hitDistance - wheel.wheelsRadius;
                float minSuspensionLength = wheel.getSuspensionRestLength() - wheel.maxSuspensionTravelCm * 0.01f;
                float maxSuspensionLength = wheel.getSuspensionRestLength() + wheel.maxSuspensionTravelCm * 0.01f;
                if (wheel.raycastInfo.suspensionLength < minSuspensionLength) {
                    wheel.raycastInfo.suspensionLength = minSuspensionLength;
                }
                if (wheel.raycastInfo.suspensionLength > maxSuspensionLength) {
                    wheel.raycastInfo.suspensionLength = maxSuspensionLength;
                }
                wheel.raycastInfo.contactPointWS.set(rayResults.hitPointInWorld);
                float denominator = wheel.raycastInfo.contactNormalWS.dot(wheel.raycastInfo.wheelDirectionWS);
                Vector3f chassis_velocity_at_contactPoint = $Stack.get$javax$vecmath$Vector3f();
                Vector3f relpos = $Stack.get$javax$vecmath$Vector3f();
                relpos.sub(wheel.raycastInfo.contactPointWS, this.getRigidBody().getCenterOfMassPosition($Stack.get$javax$vecmath$Vector3f()));
                this.getRigidBody().getVelocityInLocalPoint(relpos, chassis_velocity_at_contactPoint);
                float projVel = wheel.raycastInfo.contactNormalWS.dot(chassis_velocity_at_contactPoint);
                if (denominator >= -0.1f) {
                    wheel.suspensionRelativeVelocity = 0.0f;
                    wheel.clippedInvContactDotSuspension = 10.0f;
                } else {
                    float inv = -1.0f / denominator;
                    wheel.suspensionRelativeVelocity = projVel * inv;
                    wheel.clippedInvContactDotSuspension = inv;
                }
            } else {
                wheel.raycastInfo.suspensionLength = wheel.getSuspensionRestLength();
                wheel.suspensionRelativeVelocity = 0.0f;
                wheel.raycastInfo.contactNormalWS.negate(wheel.raycastInfo.wheelDirectionWS);
                wheel.clippedInvContactDotSuspension = 1.0f;
            }
            $Stack.pop$javax$vecmath$Vector3f();
            return depth;
        }
        catch (Throwable throwable) {
            $Stack.pop$javax$vecmath$Vector3f();
            throw throwable;
        }
    }

    public Transform getChassisWorldTransform(Transform out) {
        return this.getRigidBody().getCenterOfMassTransform(out);
    }

    /*
     * WARNING - void declaration
     */
    public void updateVehicle(float f) {
        $Stack $Stack = $Stack.get();
        try {
            void step;
            $Stack $Stack2 = $Stack;
            $Stack2.push$com$bulletphysics$linearmath$Transform();
            $Stack2.push$javax$vecmath$Vector3f();
            for (int i = 0; i < this.getNumWheels(); ++i) {
                this.updateWheelTransform(i, false);
            }
            Vector3f tmp = $Stack.get$javax$vecmath$Vector3f();
            this.currentVehicleSpeedKmHour = 3.6f * this.getRigidBody().getLinearVelocity(tmp).length();
            Transform chassisTrans = this.getChassisWorldTransform($Stack.get$com$bulletphysics$linearmath$Transform());
            Vector3f forwardW = $Stack.get$javax$vecmath$Vector3f();
            forwardW.set(chassisTrans.basis.getElement(0, this.indexForwardAxis), chassisTrans.basis.getElement(1, this.indexForwardAxis), chassisTrans.basis.getElement(2, this.indexForwardAxis));
            if (forwardW.dot(this.getRigidBody().getLinearVelocity(tmp)) < 0.0f) {
                this.currentVehicleSpeedKmHour *= -1.0f;
            }
            int i = 0;
            for (i = 0; i < this.wheelInfo.size(); ++i) {
                float depth = this.rayCast(this.wheelInfo.getQuick(i));
            }
            this.updateSuspension((float)step);
            for (i = 0; i < this.wheelInfo.size(); ++i) {
                WheelInfo wheel = this.wheelInfo.getQuick(i);
                float suspensionForce = wheel.wheelsSuspensionForce;
                float gMaxSuspensionForce = 6000.0f;
                if (suspensionForce > gMaxSuspensionForce) {
                    suspensionForce = gMaxSuspensionForce;
                }
                Vector3f impulse = $Stack.get$javax$vecmath$Vector3f();
                impulse.scale(suspensionForce * step, wheel.raycastInfo.contactNormalWS);
                Vector3f relpos = $Stack.get$javax$vecmath$Vector3f();
                relpos.sub(wheel.raycastInfo.contactPointWS, this.getRigidBody().getCenterOfMassPosition(tmp));
                this.getRigidBody().applyImpulse(impulse, relpos);
            }
            this.updateFriction((float)step);
            for (i = 0; i < this.wheelInfo.size(); ++i) {
                WheelInfo wheel = this.wheelInfo.getQuick(i);
                Vector3f relpos = $Stack.get$javax$vecmath$Vector3f();
                relpos.sub(wheel.raycastInfo.hardPointWS, this.getRigidBody().getCenterOfMassPosition(tmp));
                Vector3f vel = this.getRigidBody().getVelocityInLocalPoint(relpos, $Stack.get$javax$vecmath$Vector3f());
                if (wheel.raycastInfo.isInContact) {
                    Transform chassisWorldTransform = this.getChassisWorldTransform($Stack.get$com$bulletphysics$linearmath$Transform());
                    Vector3f fwd = $Stack.get$javax$vecmath$Vector3f();
                    fwd.set(chassisWorldTransform.basis.getElement(0, this.indexForwardAxis), chassisWorldTransform.basis.getElement(1, this.indexForwardAxis), chassisWorldTransform.basis.getElement(2, this.indexForwardAxis));
                    float proj = fwd.dot(wheel.raycastInfo.contactNormalWS);
                    tmp.scale(proj, wheel.raycastInfo.contactNormalWS);
                    fwd.sub(tmp);
                    float proj2 = fwd.dot(vel);
                    wheel.deltaRotation = proj2 * step / wheel.wheelsRadius;
                    wheel.rotation += wheel.deltaRotation;
                } else {
                    wheel.rotation += wheel.deltaRotation;
                }
                wheel.deltaRotation *= 0.99f;
            }
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

    public void setSteeringValue(float steering, int wheel) {
        assert (wheel >= 0 && wheel < this.getNumWheels());
        WheelInfo wheel_info = this.getWheelInfo(wheel);
        wheel_info.steering = steering;
    }

    public float getSteeringValue(int wheel) {
        return this.getWheelInfo((int)wheel).steering;
    }

    public void applyEngineForce(float force, int wheel) {
        assert (wheel >= 0 && wheel < this.getNumWheels());
        WheelInfo wheel_info = this.getWheelInfo(wheel);
        wheel_info.engineForce = force;
    }

    public WheelInfo getWheelInfo(int index) {
        assert (index >= 0 && index < this.getNumWheels());
        return this.wheelInfo.getQuick(index);
    }

    public void setBrake(float brake, int wheelIndex) {
        assert (wheelIndex >= 0 && wheelIndex < this.getNumWheels());
        this.getWheelInfo((int)wheelIndex).brake = brake;
    }

    public void updateSuspension(float deltaTime) {
        float chassisMass = 1.0f / this.chassisBody.getInvMass();
        for (int w_it = 0; w_it < this.getNumWheels(); ++w_it) {
            WheelInfo wheel_info = this.wheelInfo.getQuick(w_it);
            if (wheel_info.raycastInfo.isInContact) {
                float susp_length = wheel_info.getSuspensionRestLength();
                float current_length = wheel_info.raycastInfo.suspensionLength;
                float length_diff = susp_length - current_length;
                float force = wheel_info.suspensionStiffness * length_diff * wheel_info.clippedInvContactDotSuspension;
                float projected_rel_vel = wheel_info.suspensionRelativeVelocity;
                float susp_damping = projected_rel_vel < 0.0f ? wheel_info.wheelsDampingCompression : wheel_info.wheelsDampingRelaxation;
                wheel_info.wheelsSuspensionForce = (force -= susp_damping * projected_rel_vel) * chassisMass;
                if (!(wheel_info.wheelsSuspensionForce < 0.0f)) continue;
                wheel_info.wheelsSuspensionForce = 0.0f;
                continue;
            }
            wheel_info.wheelsSuspensionForce = 0.0f;
        }
    }

    /*
     * WARNING - void declaration
     */
    private float calcRollingFriction(WheelContactPoint wheelContactPoint) {
        $Stack $Stack = $Stack.get();
        try {
            void contactPoint;
            $Stack.push$javax$vecmath$Vector3f();
            Vector3f tmp = $Stack.get$javax$vecmath$Vector3f();
            float j1 = 0.0f;
            Vector3f contactPosWorld = contactPoint.frictionPositionWorld;
            Vector3f rel_pos1 = $Stack.get$javax$vecmath$Vector3f();
            rel_pos1.sub(contactPosWorld, contactPoint.body0.getCenterOfMassPosition(tmp));
            Vector3f rel_pos2 = $Stack.get$javax$vecmath$Vector3f();
            rel_pos2.sub(contactPosWorld, contactPoint.body1.getCenterOfMassPosition(tmp));
            float maxImpulse = contactPoint.maxImpulse;
            Vector3f vel1 = contactPoint.body0.getVelocityInLocalPoint(rel_pos1, $Stack.get$javax$vecmath$Vector3f());
            Vector3f vel2 = contactPoint.body1.getVelocityInLocalPoint(rel_pos2, $Stack.get$javax$vecmath$Vector3f());
            Vector3f vel = $Stack.get$javax$vecmath$Vector3f();
            vel.sub(vel1, vel2);
            float vrel = contactPoint.frictionDirectionWorld.dot(vel);
            j1 = -vrel * contactPoint.jacDiagABInv;
            j1 = Math.min(j1, maxImpulse);
            j1 = Math.max(j1, -maxImpulse);
            $Stack.pop$javax$vecmath$Vector3f();
            return j1;
        }
        catch (Throwable throwable) {
            $Stack.pop$javax$vecmath$Vector3f();
            throw throwable;
        }
    }

    /*
     * WARNING - void declaration
     */
    public void updateFriction(float f) {
        $Stack $Stack = $Stack.get();
        try {
            WheelInfo wheel_info;
            int wheel;
            void timeStep;
            $Stack $Stack2 = $Stack;
            $Stack2.push$com$bulletphysics$linearmath$Transform();
            $Stack2.push$javax$vecmath$Vector3f();
            $Stack2.push$javax$vecmath$Matrix3f();
            int numWheel = this.getNumWheels();
            if (numWheel == 0) {
                $Stack $Stack3 = $Stack;
                $Stack3.pop$com$bulletphysics$linearmath$Transform();
                $Stack3.pop$javax$vecmath$Vector3f();
                $Stack3.pop$javax$vecmath$Matrix3f();
                return;
            }
            MiscUtil.resize(this.forwardWS, numWheel, Vector3f.class);
            MiscUtil.resize(this.axle, numWheel, Vector3f.class);
            MiscUtil.resize(this.forwardImpulse, numWheel, 0.0f);
            MiscUtil.resize(this.sideImpulse, numWheel, 0.0f);
            Vector3f tmp = $Stack.get$javax$vecmath$Vector3f();
            int numWheelsOnGround = 0;
            for (int i = 0; i < this.getNumWheels(); ++i) {
                WheelInfo wheel_info2 = this.wheelInfo.getQuick(i);
                RigidBody groundObject = (RigidBody)wheel_info2.raycastInfo.groundObject;
                if (groundObject != null) {
                    ++numWheelsOnGround;
                }
                this.sideImpulse.set(i, 0.0f);
                this.forwardImpulse.set(i, 0.0f);
            }
            Transform wheelTrans = $Stack.get$com$bulletphysics$linearmath$Transform();
            for (int i = 0; i < this.getNumWheels(); ++i) {
                WheelInfo wheel_info3 = this.wheelInfo.getQuick(i);
                RigidBody groundObject = (RigidBody)wheel_info3.raycastInfo.groundObject;
                if (groundObject == null) continue;
                this.getWheelTransformWS(i, wheelTrans);
                Matrix3f wheelBasis0 = $Stack.get$javax$vecmath$Matrix3f(wheelTrans.basis);
                this.axle.getQuick(i).set(wheelBasis0.getElement(0, this.indexRightAxis), wheelBasis0.getElement(1, this.indexRightAxis), wheelBasis0.getElement(2, this.indexRightAxis));
                Vector3f surfNormalWS = wheel_info3.raycastInfo.contactNormalWS;
                float proj = this.axle.getQuick(i).dot(surfNormalWS);
                tmp.scale(proj, surfNormalWS);
                this.axle.getQuick(i).sub(tmp);
                this.axle.getQuick(i).normalize();
                this.forwardWS.getQuick(i).cross(surfNormalWS, this.axle.getQuick(i));
                this.forwardWS.getQuick(i).normalize();
                float[] floatPtr = this.floatArrays.getFixed(1);
                ContactConstraint.resolveSingleBilateral(this.chassisBody, wheel_info3.raycastInfo.contactPointWS, groundObject, wheel_info3.raycastInfo.contactPointWS, 0.0f, this.axle.getQuick(i), floatPtr, (float)timeStep);
                this.sideImpulse.set(i, floatPtr[0]);
                this.floatArrays.release(floatPtr);
                this.sideImpulse.set(i, this.sideImpulse.get(i) * 1.0f);
            }
            float sideFactor = 1.0f;
            float fwdFactor = 0.5f;
            boolean sliding = false;
            for (wheel = 0; wheel < this.getNumWheels(); ++wheel) {
                float maximp;
                wheel_info = this.wheelInfo.getQuick(wheel);
                RigidBody groundObject = (RigidBody)wheel_info.raycastInfo.groundObject;
                float rollingFriction = 0.0f;
                if (groundObject != null) {
                    if (wheel_info.engineForce != 0.0f) {
                        rollingFriction = wheel_info.engineForce * timeStep;
                    } else {
                        float defaultRollingFrictionImpulse = 0.0f;
                        float maxImpulse = wheel_info.brake != 0.0f ? wheel_info.brake : defaultRollingFrictionImpulse;
                        WheelContactPoint contactPt = new WheelContactPoint(this.chassisBody, groundObject, wheel_info.raycastInfo.contactPointWS, this.forwardWS.getQuick(wheel), maxImpulse);
                        rollingFriction = this.calcRollingFriction(contactPt);
                    }
                }
                this.forwardImpulse.set(wheel, 0.0f);
                this.wheelInfo.getQuick((int)wheel).skidInfo = 1.0f;
                if (groundObject == null) continue;
                this.wheelInfo.getQuick((int)wheel).skidInfo = 1.0f;
                float maximpSide = maximp = wheel_info.wheelsSuspensionForce * timeStep * wheel_info.frictionSlip;
                float maximpSquared = maximp * maximpSide;
                this.forwardImpulse.set(wheel, rollingFriction);
                float x = this.forwardImpulse.get(wheel) * fwdFactor;
                float y = this.sideImpulse.get(wheel) * sideFactor;
                float impulseSquared = x * x + y * y;
                if (!(impulseSquared > maximpSquared)) continue;
                sliding = true;
                float factor = maximp / (float)Math.sqrt(impulseSquared);
                this.wheelInfo.getQuick((int)wheel).skidInfo *= factor;
            }
            if (sliding) {
                for (wheel = 0; wheel < this.getNumWheels(); ++wheel) {
                    if (this.sideImpulse.get(wheel) == 0.0f || !(this.wheelInfo.getQuick((int)wheel).skidInfo < 1.0f)) continue;
                    this.forwardImpulse.set(wheel, this.forwardImpulse.get(wheel) * this.wheelInfo.getQuick((int)wheel).skidInfo);
                    this.sideImpulse.set(wheel, this.sideImpulse.get(wheel) * this.wheelInfo.getQuick((int)wheel).skidInfo);
                }
            }
            for (wheel = 0; wheel < this.getNumWheels(); ++wheel) {
                wheel_info = this.wheelInfo.getQuick(wheel);
                Vector3f rel_pos = $Stack.get$javax$vecmath$Vector3f();
                rel_pos.sub(wheel_info.raycastInfo.contactPointWS, this.chassisBody.getCenterOfMassPosition(tmp));
                if (this.forwardImpulse.get(wheel) != 0.0f) {
                    tmp.scale(this.forwardImpulse.get(wheel), this.forwardWS.getQuick(wheel));
                    this.chassisBody.applyImpulse(tmp, rel_pos);
                }
                if (this.sideImpulse.get(wheel) == 0.0f) continue;
                RigidBody groundObject = (RigidBody)this.wheelInfo.getQuick((int)wheel).raycastInfo.groundObject;
                Vector3f rel_pos2 = $Stack.get$javax$vecmath$Vector3f();
                rel_pos2.sub(wheel_info.raycastInfo.contactPointWS, groundObject.getCenterOfMassPosition(tmp));
                Vector3f sideImp = $Stack.get$javax$vecmath$Vector3f();
                sideImp.scale(this.sideImpulse.get(wheel), this.axle.getQuick(wheel));
                rel_pos.z *= wheel_info.rollInfluence;
                this.chassisBody.applyImpulse(sideImp, rel_pos);
                tmp.negate(sideImp);
                groundObject.applyImpulse(tmp, rel_pos2);
            }
            $Stack $Stack4 = $Stack;
            $Stack4.pop$com$bulletphysics$linearmath$Transform();
            $Stack4.pop$javax$vecmath$Vector3f();
            $Stack4.pop$javax$vecmath$Matrix3f();
            return;
        }
        catch (Throwable throwable) {
            $Stack $Stack5 = $Stack;
            $Stack5.pop$com$bulletphysics$linearmath$Transform();
            $Stack5.pop$javax$vecmath$Vector3f();
            $Stack5.pop$javax$vecmath$Matrix3f();
            throw throwable;
        }
    }

    @Override
    public void buildJacobian() {
    }

    @Override
    public void solveConstraint(float timeStep) {
    }

    public int getNumWheels() {
        return this.wheelInfo.size();
    }

    public void setPitchControl(float pitch) {
        this.pitchControl = pitch;
    }

    public RigidBody getRigidBody() {
        return this.chassisBody;
    }

    public int getRightAxis() {
        return this.indexRightAxis;
    }

    public int getUpAxis() {
        return this.indexUpAxis;
    }

    public int getForwardAxis() {
        return this.indexForwardAxis;
    }

    /*
     * WARNING - void declaration
     */
    public Vector3f getForwardVector(Vector3f vector3f) {
        $Stack $Stack = $Stack.get();
        try {
            void out;
            $Stack.push$com$bulletphysics$linearmath$Transform();
            Transform chassisTrans = this.getChassisWorldTransform($Stack.get$com$bulletphysics$linearmath$Transform());
            out.set(chassisTrans.basis.getElement(0, this.indexForwardAxis), chassisTrans.basis.getElement(1, this.indexForwardAxis), chassisTrans.basis.getElement(2, this.indexForwardAxis));
            $Stack.pop$com$bulletphysics$linearmath$Transform();
            return out;
        }
        catch (Throwable throwable) {
            $Stack.pop$com$bulletphysics$linearmath$Transform();
            throw throwable;
        }
    }

    public float getCurrentSpeedKmHour() {
        return this.currentVehicleSpeedKmHour;
    }

    public void setCoordinateSystem(int rightIndex, int upIndex, int forwardIndex) {
        this.indexRightAxis = rightIndex;
        this.indexUpAxis = upIndex;
        this.indexForwardAxis = forwardIndex;
    }

    private static class WheelContactPoint {
        public RigidBody body0;
        public RigidBody body1;
        public final Vector3f frictionPositionWorld = new Vector3f();
        public final Vector3f frictionDirectionWorld = new Vector3f();
        public float jacDiagABInv;
        public float maxImpulse;

        public WheelContactPoint(RigidBody body0, RigidBody body1, Vector3f frictionPosWorld, Vector3f frictionDirectionWorld, float maxImpulse) {
            this.body0 = body0;
            this.body1 = body1;
            this.frictionPositionWorld.set(frictionPosWorld);
            this.frictionDirectionWorld.set(frictionDirectionWorld);
            this.maxImpulse = maxImpulse;
            float denom0 = body0.computeImpulseDenominator(frictionPosWorld, frictionDirectionWorld);
            float denom1 = body1.computeImpulseDenominator(frictionPosWorld, frictionDirectionWorld);
            float relaxation = 1.0f;
            this.jacDiagABInv = relaxation / (denom0 + denom1);
        }
    }
}

