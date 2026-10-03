/*
 * Decompiled with CFR 0.152.
 */
package com.bulletphysics.collision.dispatch;

import com.bulletphysics.$Stack;
import com.bulletphysics.collision.broadphase.CollisionAlgorithm;
import com.bulletphysics.collision.broadphase.CollisionAlgorithmConstructionInfo;
import com.bulletphysics.collision.broadphase.Dispatcher;
import com.bulletphysics.collision.broadphase.DispatcherInfo;
import com.bulletphysics.collision.dispatch.CollisionObject;
import com.bulletphysics.collision.dispatch.ManifoldResult;
import com.bulletphysics.collision.narrowphase.PersistentManifold;
import com.bulletphysics.collision.shapes.CollisionShape;
import com.bulletphysics.collision.shapes.TriangleCallback;
import com.bulletphysics.collision.shapes.TriangleShape;
import com.bulletphysics.linearmath.Transform;
import javax.vecmath.Tuple3f;
import javax.vecmath.Vector3f;

class ConvexTriangleCallback
extends TriangleCallback {
    private CollisionObject convexBody;
    private CollisionObject triBody;
    private final Vector3f aabbMin = new Vector3f();
    private final Vector3f aabbMax = new Vector3f();
    private ManifoldResult resultOut;
    private Dispatcher dispatcher;
    private DispatcherInfo dispatchInfoPtr;
    private float collisionMarginTriangle;
    public int triangleCount;
    public PersistentManifold manifoldPtr;
    private CollisionAlgorithmConstructionInfo ci = new CollisionAlgorithmConstructionInfo();
    private TriangleShape tm = new TriangleShape();

    public ConvexTriangleCallback(Dispatcher dispatcher, CollisionObject body0, CollisionObject body1, boolean isSwapped) {
        this.dispatcher = dispatcher;
        this.dispatchInfoPtr = null;
        this.convexBody = isSwapped ? body1 : body0;
        this.triBody = isSwapped ? body0 : body1;
        this.manifoldPtr = dispatcher.getNewManifold(this.convexBody, this.triBody);
        this.clearCache();
    }

    public void destroy() {
        this.clearCache();
        this.dispatcher.releaseManifold(this.manifoldPtr);
    }

    /*
     * WARNING - void declaration
     */
    public void setTimeStepAndCounters(float f, DispatcherInfo dispatcherInfo, ManifoldResult manifoldResult) {
        $Stack $Stack = $Stack.get();
        try {
            void resultOut;
            void collisionMarginTriangle;
            void dispatchInfo;
            $Stack $Stack2 = $Stack;
            $Stack2.push$com$bulletphysics$linearmath$Transform();
            $Stack2.push$javax$vecmath$Vector3f();
            this.dispatchInfoPtr = dispatchInfo;
            this.collisionMarginTriangle = collisionMarginTriangle;
            this.resultOut = resultOut;
            Transform convexInTriangleSpace = $Stack.get$com$bulletphysics$linearmath$Transform();
            this.triBody.getWorldTransform(convexInTriangleSpace);
            convexInTriangleSpace.inverse();
            convexInTriangleSpace.mul(this.convexBody.getWorldTransform($Stack.get$com$bulletphysics$linearmath$Transform()));
            CollisionShape convexShape = this.convexBody.getCollisionShape();
            convexShape.getAabb(convexInTriangleSpace, this.aabbMin, this.aabbMax);
            void extraMargin = collisionMarginTriangle;
            Vector3f extra = $Stack.get$javax$vecmath$Vector3f();
            extra.set((float)extraMargin, (float)extraMargin, (float)extraMargin);
            this.aabbMax.add(extra);
            this.aabbMin.sub(extra);
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
    @Override
    public void processTriangle(Vector3f[] vector3fArray, int n, int n2) {
        $Stack $Stack = $Stack.get();
        try {
            void triangle;
            $Stack $Stack2 = $Stack;
            $Stack2.push$com$bulletphysics$linearmath$Transform();
            $Stack2.push$javax$vecmath$Vector3f();
            this.ci.dispatcher1 = this.dispatcher;
            CollisionObject ob = this.triBody;
            if (this.dispatchInfoPtr != null && this.dispatchInfoPtr.debugDraw != null && this.dispatchInfoPtr.debugDraw.getDebugMode() > 0) {
                Vector3f color = $Stack.get$javax$vecmath$Vector3f();
                color.set(255.0f, 255.0f, 0.0f);
                Transform tr = ob.getWorldTransform($Stack.get$com$bulletphysics$linearmath$Transform());
                Vector3f tmp1 = $Stack.get$javax$vecmath$Vector3f();
                Vector3f tmp2 = $Stack.get$javax$vecmath$Vector3f();
                tmp1.set((Tuple3f)triangle[0]);
                tr.transform(tmp1);
                tmp2.set((Tuple3f)triangle[1]);
                tr.transform(tmp2);
                this.dispatchInfoPtr.debugDraw.drawLine(tmp1, tmp2, color);
                tmp1.set((Tuple3f)triangle[1]);
                tr.transform(tmp1);
                tmp2.set((Tuple3f)triangle[2]);
                tr.transform(tmp2);
                this.dispatchInfoPtr.debugDraw.drawLine(tmp1, tmp2, color);
                tmp1.set((Tuple3f)triangle[2]);
                tr.transform(tmp1);
                tmp2.set((Tuple3f)triangle[0]);
                tr.transform(tmp2);
                this.dispatchInfoPtr.debugDraw.drawLine(tmp1, tmp2, color);
            }
            if (this.convexBody.getCollisionShape().isConvex()) {
                void triangleIndex;
                void partId;
                this.tm.init((Vector3f)triangle[0], (Vector3f)triangle[1], (Vector3f)triangle[2]);
                this.tm.setMargin(this.collisionMarginTriangle);
                CollisionShape tmpShape = ob.getCollisionShape();
                ob.internalSetTemporaryCollisionShape(this.tm);
                CollisionAlgorithm colAlgo = this.ci.dispatcher1.findAlgorithm(this.convexBody, this.triBody, this.manifoldPtr);
                this.resultOut.setShapeIdentifiers(-1, -1, (int)partId, (int)triangleIndex);
                colAlgo.processCollision(this.convexBody, this.triBody, this.dispatchInfoPtr, this.resultOut);
                this.ci.dispatcher1.freeCollisionAlgorithm(colAlgo);
                ob.internalSetTemporaryCollisionShape(tmpShape);
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

    public void clearCache() {
        this.dispatcher.clearManifold(this.manifoldPtr);
    }

    public Vector3f getAabbMin(Vector3f out) {
        out.set(this.aabbMin);
        return out;
    }

    public Vector3f getAabbMax(Vector3f out) {
        out.set(this.aabbMax);
        return out;
    }
}

