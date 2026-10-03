/*
 * Decompiled with CFR 0.152.
 */
package com.bulletphysics.demos.helloworld;

import com.bulletphysics.collision.broadphase.AxisSweep3;
import com.bulletphysics.collision.dispatch.CollisionDispatcher;
import com.bulletphysics.collision.dispatch.CollisionObject;
import com.bulletphysics.collision.dispatch.DefaultCollisionConfiguration;
import com.bulletphysics.collision.shapes.BoxShape;
import com.bulletphysics.collision.shapes.CollisionShape;
import com.bulletphysics.collision.shapes.ConvexInternalShape;
import com.bulletphysics.collision.shapes.SphereShape;
import com.bulletphysics.dynamics.DiscreteDynamicsWorld;
import com.bulletphysics.dynamics.RigidBody;
import com.bulletphysics.dynamics.RigidBodyConstructionInfo;
import com.bulletphysics.dynamics.constraintsolver.SequentialImpulseConstraintSolver;
import com.bulletphysics.linearmath.DefaultMotionState;
import com.bulletphysics.linearmath.Transform;
import com.bulletphysics.util.ObjectArrayList;
import javax.vecmath.Vector3f;

public class HelloWorld {
    public static void main(String[] args) {
        DefaultCollisionConfiguration collisionConfiguration = new DefaultCollisionConfiguration();
        CollisionDispatcher dispatcher = new CollisionDispatcher(collisionConfiguration);
        Vector3f worldAabbMin = new Vector3f(-10000.0f, -10000.0f, -10000.0f);
        Vector3f worldAabbMax = new Vector3f(10000.0f, 10000.0f, 10000.0f);
        int maxProxies = 1024;
        AxisSweep3 overlappingPairCache = new AxisSweep3(worldAabbMin, worldAabbMax, maxProxies);
        SequentialImpulseConstraintSolver solver = new SequentialImpulseConstraintSolver();
        DiscreteDynamicsWorld dynamicsWorld = new DiscreteDynamicsWorld(dispatcher, overlappingPairCache, solver, collisionConfiguration);
        dynamicsWorld.setGravity(new Vector3f(0.0f, -10.0f, 0.0f));
        BoxShape groundShape = new BoxShape(new Vector3f(50.0f, 50.0f, 50.0f));
        ObjectArrayList<ConvexInternalShape> collisionShapes = new ObjectArrayList<ConvexInternalShape>();
        collisionShapes.add(groundShape);
        Transform groundTransform = new Transform();
        groundTransform.setIdentity();
        groundTransform.origin.set(new Vector3f(0.0f, -56.0f, 0.0f));
        float mass = 0.0f;
        boolean isDynamic = mass != 0.0f;
        Vector3f localInertia = new Vector3f(0.0f, 0.0f, 0.0f);
        if (isDynamic) {
            ((CollisionShape)groundShape).calculateLocalInertia(mass, localInertia);
        }
        DefaultMotionState myMotionState = new DefaultMotionState(groundTransform);
        RigidBodyConstructionInfo rbInfo = new RigidBodyConstructionInfo(mass, myMotionState, groundShape, localInertia);
        RigidBody body = new RigidBody(rbInfo);
        dynamicsWorld.addRigidBody(body);
        SphereShape colShape = new SphereShape(1.0f);
        collisionShapes.add(colShape);
        Transform startTransform = new Transform();
        startTransform.setIdentity();
        float mass2 = 1.0f;
        boolean isDynamic2 = mass2 != 0.0f;
        Vector3f localInertia2 = new Vector3f(0.0f, 0.0f, 0.0f);
        if (isDynamic2) {
            ((CollisionShape)colShape).calculateLocalInertia(mass2, localInertia2);
        }
        startTransform.origin.set(new Vector3f(2.0f, 10.0f, 0.0f));
        DefaultMotionState myMotionState2 = new DefaultMotionState(startTransform);
        RigidBodyConstructionInfo rbInfo2 = new RigidBodyConstructionInfo(mass2, myMotionState2, colShape, localInertia2);
        RigidBody body2 = new RigidBody(rbInfo2);
        dynamicsWorld.addRigidBody(body2);
        for (int i = 0; i < 100; ++i) {
            dynamicsWorld.stepSimulation(0.016666668f, 10);
            for (int j = dynamicsWorld.getNumCollisionObjects() - 1; j >= 0; --j) {
                CollisionObject obj = dynamicsWorld.getCollisionObjectArray().getQuick(j);
                RigidBody body3 = RigidBody.upcast(obj);
                if (body3 == null || body3.getMotionState() == null) continue;
                Transform trans = new Transform();
                body3.getMotionState().getWorldTransform(trans);
                System.out.printf("world pos = %f,%f,%f\n", Float.valueOf(trans.origin.x), Float.valueOf(trans.origin.y), Float.valueOf(trans.origin.z));
            }
        }
    }
}

