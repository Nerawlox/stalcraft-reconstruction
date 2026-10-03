/*
 * Decompiled with CFR 0.152.
 */
package com.bulletphysics.collision.dispatch;

import com.bulletphysics.collision.broadphase.BroadphaseNativeType;
import com.bulletphysics.collision.dispatch.CollisionAlgorithmCreateFunc;
import com.bulletphysics.collision.dispatch.CollisionConfiguration;
import com.bulletphysics.collision.dispatch.CompoundCollisionAlgorithm;
import com.bulletphysics.collision.dispatch.ConvexConcaveCollisionAlgorithm;
import com.bulletphysics.collision.dispatch.ConvexConvexAlgorithm;
import com.bulletphysics.collision.dispatch.ConvexPlaneCollisionAlgorithm;
import com.bulletphysics.collision.dispatch.EmptyAlgorithm;
import com.bulletphysics.collision.dispatch.SphereSphereCollisionAlgorithm;
import com.bulletphysics.collision.narrowphase.ConvexPenetrationDepthSolver;
import com.bulletphysics.collision.narrowphase.GjkEpaPenetrationDepthSolver;
import com.bulletphysics.collision.narrowphase.VoronoiSimplexSolver;

public class DefaultCollisionConfiguration
extends CollisionConfiguration {
    protected VoronoiSimplexSolver simplexSolver = new VoronoiSimplexSolver();
    protected ConvexPenetrationDepthSolver pdSolver = new GjkEpaPenetrationDepthSolver();
    protected CollisionAlgorithmCreateFunc convexConvexCreateFunc = new ConvexConvexAlgorithm.CreateFunc(this.simplexSolver, this.pdSolver);
    protected CollisionAlgorithmCreateFunc convexConcaveCreateFunc = new ConvexConcaveCollisionAlgorithm.CreateFunc();
    protected CollisionAlgorithmCreateFunc swappedConvexConcaveCreateFunc = new ConvexConcaveCollisionAlgorithm.SwappedCreateFunc();
    protected CollisionAlgorithmCreateFunc compoundCreateFunc = new CompoundCollisionAlgorithm.CreateFunc();
    protected CollisionAlgorithmCreateFunc swappedCompoundCreateFunc = new CompoundCollisionAlgorithm.SwappedCreateFunc();
    protected CollisionAlgorithmCreateFunc emptyCreateFunc = new EmptyAlgorithm.CreateFunc();
    protected CollisionAlgorithmCreateFunc sphereSphereCF = new SphereSphereCollisionAlgorithm.CreateFunc();
    protected CollisionAlgorithmCreateFunc sphereBoxCF;
    protected CollisionAlgorithmCreateFunc boxSphereCF;
    protected CollisionAlgorithmCreateFunc boxBoxCF;
    protected CollisionAlgorithmCreateFunc sphereTriangleCF;
    protected CollisionAlgorithmCreateFunc triangleSphereCF;
    protected CollisionAlgorithmCreateFunc planeConvexCF;
    protected CollisionAlgorithmCreateFunc convexPlaneCF = new ConvexPlaneCollisionAlgorithm.CreateFunc();

    public DefaultCollisionConfiguration() {
        this.planeConvexCF = new ConvexPlaneCollisionAlgorithm.CreateFunc();
        this.planeConvexCF.swapped = true;
    }

    @Override
    public CollisionAlgorithmCreateFunc getCollisionAlgorithmCreateFunc(BroadphaseNativeType proxyType0, BroadphaseNativeType proxyType1) {
        if (proxyType0 == BroadphaseNativeType.SPHERE_SHAPE_PROXYTYPE && proxyType1 == BroadphaseNativeType.SPHERE_SHAPE_PROXYTYPE) {
            return this.sphereSphereCF;
        }
        if (proxyType0.isConvex() && proxyType1 == BroadphaseNativeType.STATIC_PLANE_PROXYTYPE) {
            return this.convexPlaneCF;
        }
        if (proxyType1.isConvex() && proxyType0 == BroadphaseNativeType.STATIC_PLANE_PROXYTYPE) {
            return this.planeConvexCF;
        }
        if (proxyType0.isConvex() && proxyType1.isConvex()) {
            return this.convexConvexCreateFunc;
        }
        if (proxyType0.isConvex() && proxyType1.isConcave()) {
            return this.convexConcaveCreateFunc;
        }
        if (proxyType1.isConvex() && proxyType0.isConcave()) {
            return this.swappedConvexConcaveCreateFunc;
        }
        if (proxyType0.isCompound()) {
            return this.compoundCreateFunc;
        }
        if (proxyType1.isCompound()) {
            return this.swappedCompoundCreateFunc;
        }
        return this.emptyCreateFunc;
    }
}

