/*
 * Decompiled with CFR 0.152.
 */
package com.bulletphysics.collision.narrowphase;

import com.bulletphysics.collision.narrowphase.ConvexCast;
import com.bulletphysics.collision.narrowphase.GjkEpaPenetrationDepthSolver;
import com.bulletphysics.collision.narrowphase.SubsimplexConvexCast;
import com.bulletphysics.collision.narrowphase.VoronoiSimplexSolver;
import com.bulletphysics.collision.shapes.ConvexShape;
import com.bulletphysics.collision.shapes.TriangleCallback;
import com.bulletphysics.collision.shapes.TriangleShape;
import com.bulletphysics.linearmath.Transform;
import javax.vecmath.Vector3f;

public abstract class TriangleConvexcastCallback
extends TriangleCallback {
    public ConvexShape convexShape;
    public final Transform convexShapeFrom = new Transform();
    public final Transform convexShapeTo = new Transform();
    public final Transform triangleToWorld = new Transform();
    public float hitFraction;
    public float triangleCollisionMargin;

    public TriangleConvexcastCallback(ConvexShape convexShape, Transform convexShapeFrom, Transform convexShapeTo, Transform triangleToWorld, float triangleCollisionMargin) {
        this.convexShape = convexShape;
        this.convexShapeFrom.set(convexShapeFrom);
        this.convexShapeTo.set(convexShapeTo);
        this.triangleToWorld.set(triangleToWorld);
        this.hitFraction = 1.0f;
        this.triangleCollisionMargin = triangleCollisionMargin;
    }

    @Override
    public void processTriangle(Vector3f[] triangle, int partId, int triangleIndex) {
        TriangleShape triangleShape = new TriangleShape(triangle[0], triangle[1], triangle[2]);
        triangleShape.setMargin(this.triangleCollisionMargin);
        VoronoiSimplexSolver simplexSolver = new VoronoiSimplexSolver();
        GjkEpaPenetrationDepthSolver gjkEpaPenetrationSolver = new GjkEpaPenetrationDepthSolver();
        SubsimplexConvexCast convexCaster = new SubsimplexConvexCast(this.convexShape, triangleShape, simplexSolver);
        ConvexCast.CastResult castResult = new ConvexCast.CastResult();
        castResult.fraction = 1.0f;
        if (convexCaster.calcTimeOfImpact(this.convexShapeFrom, this.convexShapeTo, this.triangleToWorld, this.triangleToWorld, castResult) && castResult.normal.lengthSquared() > 1.0E-4f && castResult.fraction < this.hitFraction) {
            castResult.normal.normalize();
            this.reportHit(castResult.normal, castResult.hitPoint, castResult.fraction, partId, triangleIndex);
        }
    }

    public abstract float reportHit(Vector3f var1, Vector3f var2, float var3, int var4, int var5);
}

