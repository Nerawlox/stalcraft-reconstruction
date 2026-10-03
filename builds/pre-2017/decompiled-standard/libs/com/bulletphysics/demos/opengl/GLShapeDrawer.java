/*
 * Decompiled with CFR 0.152.
 */
package com.bulletphysics.demos.opengl;

import com.bulletphysics.collision.broadphase.BroadphaseNativeType;
import com.bulletphysics.collision.shapes.BoxShape;
import com.bulletphysics.collision.shapes.CollisionShape;
import com.bulletphysics.collision.shapes.CompoundShape;
import com.bulletphysics.collision.shapes.ConcaveShape;
import com.bulletphysics.collision.shapes.ConvexShape;
import com.bulletphysics.collision.shapes.CylinderShape;
import com.bulletphysics.collision.shapes.InternalTriangleIndexCallback;
import com.bulletphysics.collision.shapes.PolyhedralConvexShape;
import com.bulletphysics.collision.shapes.ShapeHull;
import com.bulletphysics.collision.shapes.SphereShape;
import com.bulletphysics.collision.shapes.StaticPlaneShape;
import com.bulletphysics.collision.shapes.TriangleCallback;
import com.bulletphysics.demos.opengl.IGL;
import com.bulletphysics.linearmath.Transform;
import com.bulletphysics.linearmath.TransformUtil;
import com.bulletphysics.linearmath.VectorUtil;
import com.bulletphysics.util.IntArrayList;
import com.bulletphysics.util.ObjectArrayList;
import com.bulletphysics.util.ObjectPool;
import javax.vecmath.Vector3f;

public class GLShapeDrawer {
    private static float[] glMat = new float[16];

    public static void drawCoordSystem(IGL gl) {
        gl.glBegin(1);
        gl.glColor3f(1.0f, 0.0f, 0.0f);
        gl.glVertex3f(0.0f, 0.0f, 0.0f);
        gl.glVertex3f(1.0f, 0.0f, 0.0f);
        gl.glColor3f(0.0f, 1.0f, 0.0f);
        gl.glVertex3f(0.0f, 0.0f, 0.0f);
        gl.glVertex3f(0.0f, 1.0f, 0.0f);
        gl.glColor3f(0.0f, 0.0f, 1.0f);
        gl.glVertex3f(0.0f, 0.0f, 0.0f);
        gl.glVertex3f(0.0f, 0.0f, 1.0f);
        gl.glEnd();
    }

    public static void drawOpenGL(IGL gl, Transform trans, CollisionShape shape, Vector3f color, int debugMode) {
        ObjectPool<Transform> transformsPool = ObjectPool.get(Transform.class);
        ObjectPool<Vector3f> vectorsPool = ObjectPool.get(Vector3f.class);
        gl.glPushMatrix();
        trans.getOpenGLMatrix(glMat);
        gl.glMultMatrix(glMat);
        if (shape.getShapeType() == BroadphaseNativeType.COMPOUND_SHAPE_PROXYTYPE) {
            CompoundShape compoundShape = (CompoundShape)shape;
            Transform childTrans = transformsPool.get();
            for (int i = compoundShape.getNumChildShapes() - 1; i >= 0; --i) {
                compoundShape.getChildTransform(i, childTrans);
                CollisionShape colShape = compoundShape.getChildShape(i);
                GLShapeDrawer.drawOpenGL(gl, childTrans, colShape, color, debugMode);
            }
            transformsPool.release(childTrans);
        } else {
            gl.glEnable(2903);
            gl.glColor3f(color.x, color.y, color.z);
            boolean useWireframeFallback = true;
            if ((debugMode & 1) == 0) {
                switch (shape.getShapeType()) {
                    case BOX_SHAPE_PROXYTYPE: {
                        BoxShape boxShape = (BoxShape)shape;
                        Vector3f halfExtent = boxShape.getHalfExtentsWithMargin(vectorsPool.get());
                        gl.glScalef(2.0f * halfExtent.x, 2.0f * halfExtent.y, 2.0f * halfExtent.z);
                        gl.drawCube(1.0f);
                        vectorsPool.release(halfExtent);
                        useWireframeFallback = false;
                        break;
                    }
                    case SPHERE_SHAPE_PROXYTYPE: {
                        SphereShape sphereShape = (SphereShape)shape;
                        float radius = sphereShape.getMargin();
                        gl.drawSphere(radius, 10, 10);
                        useWireframeFallback = false;
                        break;
                    }
                    case STATIC_PLANE_PROXYTYPE: {
                        StaticPlaneShape staticPlaneShape = (StaticPlaneShape)shape;
                        float planeConst = staticPlaneShape.getPlaneConstant();
                        Vector3f planeNormal = staticPlaneShape.getPlaneNormal(vectorsPool.get());
                        Vector3f planeOrigin = vectorsPool.get();
                        planeOrigin.scale(planeConst, planeNormal);
                        Vector3f vec0 = vectorsPool.get();
                        Vector3f vec1 = vectorsPool.get();
                        TransformUtil.planeSpace1(planeNormal, vec0, vec1);
                        float vecLen = 100.0f;
                        Vector3f pt0 = vectorsPool.get();
                        pt0.scaleAdd(vecLen, vec0, planeOrigin);
                        Vector3f pt1 = vectorsPool.get();
                        pt1.scale(vecLen, vec0);
                        pt1.sub(planeOrigin, pt1);
                        Vector3f pt2 = vectorsPool.get();
                        pt2.scaleAdd(vecLen, vec1, planeOrigin);
                        Vector3f pt3 = vectorsPool.get();
                        pt3.scale(vecLen, vec1);
                        pt3.sub(planeOrigin, pt3);
                        gl.glBegin(1);
                        gl.glVertex3f(pt0.x, pt0.y, pt0.z);
                        gl.glVertex3f(pt1.x, pt1.y, pt1.z);
                        gl.glVertex3f(pt2.x, pt2.y, pt2.z);
                        gl.glVertex3f(pt3.x, pt3.y, pt3.z);
                        gl.glEnd();
                        vectorsPool.release(planeNormal);
                        vectorsPool.release(planeOrigin);
                        vectorsPool.release(vec0);
                        vectorsPool.release(vec1);
                        vectorsPool.release(pt0);
                        vectorsPool.release(pt1);
                        vectorsPool.release(pt2);
                        vectorsPool.release(pt3);
                        break;
                    }
                    case CYLINDER_SHAPE_PROXYTYPE: {
                        CylinderShape cylinder = (CylinderShape)shape;
                        int upAxis = cylinder.getUpAxis();
                        float radius = cylinder.getRadius();
                        Vector3f halfVec = vectorsPool.get();
                        float halfHeight = VectorUtil.getCoord(cylinder.getHalfExtentsWithMargin(halfVec), upAxis);
                        gl.drawCylinder(radius, halfHeight, upAxis);
                        vectorsPool.release(halfVec);
                        break;
                    }
                    default: {
                        ShapeHull hull;
                        if (!shape.isConvex()) break;
                        ConvexShape convexShape = (ConvexShape)shape;
                        if (shape.getUserPointer() == null) {
                            hull = new ShapeHull(convexShape);
                            float margin = shape.getMargin();
                            hull.buildHull(margin);
                            convexShape.setUserPointer(hull);
                        }
                        if (shape.getUserPointer() == null) break;
                        hull = (ShapeHull)shape.getUserPointer();
                        Vector3f normal = vectorsPool.get();
                        Vector3f tmp1 = vectorsPool.get();
                        Vector3f tmp2 = vectorsPool.get();
                        if (hull.numTriangles() > 0) {
                            int index = 0;
                            IntArrayList idx = hull.getIndexPointer();
                            ObjectArrayList<Vector3f> vtx = hull.getVertexPointer();
                            gl.glBegin(4);
                            for (int i = 0; i < hull.numTriangles(); ++i) {
                                int i1 = index++;
                                int i2 = index++;
                                int i3 = index++;
                                assert (i1 < hull.numIndices() && i2 < hull.numIndices() && i3 < hull.numIndices());
                                int index1 = idx.get(i1);
                                int index2 = idx.get(i2);
                                int index3 = idx.get(i3);
                                assert (index1 < hull.numVertices() && index2 < hull.numVertices() && index3 < hull.numVertices());
                                Vector3f v1 = vtx.getQuick(index1);
                                Vector3f v2 = vtx.getQuick(index2);
                                Vector3f v3 = vtx.getQuick(index3);
                                tmp1.sub(v3, v1);
                                tmp2.sub(v2, v1);
                                normal.cross(tmp1, tmp2);
                                normal.normalize();
                                gl.glNormal3f(normal.x, normal.y, normal.z);
                                gl.glVertex3f(v1.x, v1.y, v1.z);
                                gl.glVertex3f(v2.x, v2.y, v2.z);
                                gl.glVertex3f(v3.x, v3.y, v3.z);
                            }
                            gl.glEnd();
                        }
                        vectorsPool.release(normal);
                        vectorsPool.release(tmp1);
                        vectorsPool.release(tmp2);
                    }
                }
            }
            if (useWireframeFallback && shape.isPolyhedral()) {
                PolyhedralConvexShape polyshape = (PolyhedralConvexShape)shape;
                gl.glBegin(1);
                Vector3f a = vectorsPool.get();
                Vector3f b = vectorsPool.get();
                for (int i = 0; i < polyshape.getNumEdges(); ++i) {
                    polyshape.getEdge(i, a, b);
                    gl.glVertex3f(a.x, a.y, a.z);
                    gl.glVertex3f(b.x, b.y, b.z);
                }
                gl.glEnd();
                vectorsPool.release(a);
                vectorsPool.release(b);
            }
            if (shape.isConcave()) {
                ConcaveShape concaveMesh = (ConcaveShape)shape;
                Vector3f aabbMax = vectorsPool.get();
                aabbMax.set(1.0E30f, 1.0E30f, 1.0E30f);
                Vector3f aabbMin = vectorsPool.get();
                aabbMin.set(-1.0E30f, -1.0E30f, -1.0E30f);
                GlDrawcallback drawCallback = new GlDrawcallback(gl);
                drawCallback.wireframe = (debugMode & 1) != 0;
                concaveMesh.processAllTriangles(drawCallback, aabbMin, aabbMax);
                vectorsPool.release(aabbMax);
                vectorsPool.release(aabbMin);
            }
            if ((debugMode & 0x40) != 0) {
                // empty if block
            }
            if ((debugMode & 4) != 0) {
                // empty if block
            }
        }
        gl.glPopMatrix();
    }

    private static class TriangleGlDrawcallback
    extends InternalTriangleIndexCallback {
        private IGL gl;

        public TriangleGlDrawcallback(IGL gl) {
            this.gl = gl;
        }

        @Override
        public void internalProcessTriangleIndex(Vector3f[] triangle, int partId, int triangleIndex) {
            this.gl.glBegin(4);
            this.gl.glColor3f(1.0f, 0.0f, 0.0f);
            this.gl.glVertex3f(triangle[0].x, triangle[0].y, triangle[0].z);
            this.gl.glVertex3f(triangle[1].x, triangle[1].y, triangle[1].z);
            this.gl.glColor3f(0.0f, 1.0f, 0.0f);
            this.gl.glVertex3f(triangle[2].x, triangle[2].y, triangle[2].z);
            this.gl.glVertex3f(triangle[1].x, triangle[1].y, triangle[1].z);
            this.gl.glColor3f(0.0f, 0.0f, 1.0f);
            this.gl.glVertex3f(triangle[2].x, triangle[2].y, triangle[2].z);
            this.gl.glVertex3f(triangle[0].x, triangle[0].y, triangle[0].z);
            this.gl.glEnd();
        }
    }

    private static class GlDrawcallback
    extends TriangleCallback {
        private IGL gl;
        public boolean wireframe = false;

        public GlDrawcallback(IGL gl) {
            this.gl = gl;
        }

        @Override
        public void processTriangle(Vector3f[] triangle, int partId, int triangleIndex) {
            if (this.wireframe) {
                this.gl.glBegin(1);
                this.gl.glColor3f(1.0f, 0.0f, 0.0f);
                this.gl.glVertex3f(triangle[0].x, triangle[0].y, triangle[0].z);
                this.gl.glVertex3f(triangle[1].x, triangle[1].y, triangle[1].z);
                this.gl.glColor3f(0.0f, 1.0f, 0.0f);
                this.gl.glVertex3f(triangle[2].x, triangle[2].y, triangle[2].z);
                this.gl.glVertex3f(triangle[1].x, triangle[1].y, triangle[1].z);
                this.gl.glColor3f(0.0f, 0.0f, 1.0f);
                this.gl.glVertex3f(triangle[2].x, triangle[2].y, triangle[2].z);
                this.gl.glVertex3f(triangle[0].x, triangle[0].y, triangle[0].z);
                this.gl.glEnd();
            } else {
                this.gl.glBegin(4);
                this.gl.glColor3f(1.0f, 0.0f, 0.0f);
                this.gl.glVertex3f(triangle[0].x, triangle[0].y, triangle[0].z);
                this.gl.glColor3f(0.0f, 1.0f, 0.0f);
                this.gl.glVertex3f(triangle[1].x, triangle[1].y, triangle[1].z);
                this.gl.glColor3f(0.0f, 0.0f, 1.0f);
                this.gl.glVertex3f(triangle[2].x, triangle[2].y, triangle[2].z);
                this.gl.glEnd();
            }
        }
    }

    private static class GlDisplaylistDrawcallback
    extends TriangleCallback {
        private IGL gl;
        private final Vector3f diff1 = new Vector3f();
        private final Vector3f diff2 = new Vector3f();
        private final Vector3f normal = new Vector3f();

        public GlDisplaylistDrawcallback(IGL gl) {
            this.gl = gl;
        }

        @Override
        public void processTriangle(Vector3f[] triangle, int partId, int triangleIndex) {
            this.diff1.sub(triangle[1], triangle[0]);
            this.diff2.sub(triangle[2], triangle[0]);
            this.normal.cross(this.diff1, this.diff2);
            this.normal.normalize();
            this.gl.glBegin(4);
            this.gl.glColor3f(0.0f, 1.0f, 0.0f);
            this.gl.glNormal3f(this.normal.x, this.normal.y, this.normal.z);
            this.gl.glVertex3f(triangle[0].x, triangle[0].y, triangle[0].z);
            this.gl.glColor3f(0.0f, 1.0f, 0.0f);
            this.gl.glNormal3f(this.normal.x, this.normal.y, this.normal.z);
            this.gl.glVertex3f(triangle[1].x, triangle[1].y, triangle[1].z);
            this.gl.glColor3f(0.0f, 1.0f, 0.0f);
            this.gl.glNormal3f(this.normal.x, this.normal.y, this.normal.z);
            this.gl.glVertex3f(triangle[2].x, triangle[2].y, triangle[2].z);
            this.gl.glEnd();
        }
    }

    private static class TriMeshKey {
        public CollisionShape shape;
        public int dlist;

        private TriMeshKey() {
        }
    }
}

