/*
 * Decompiled with CFR 0.152.
 */
package com.bulletphysics.extras.gimpact;

import com.bulletphysics.$Stack;
import com.bulletphysics.collision.shapes.CollisionShape;
import com.bulletphysics.collision.shapes.StridingMeshInterface;
import com.bulletphysics.collision.shapes.TriangleCallback;
import com.bulletphysics.extras.gimpact.BoxCollision;
import com.bulletphysics.extras.gimpact.GImpactMassUtil;
import com.bulletphysics.extras.gimpact.GImpactShapeInterface;
import com.bulletphysics.extras.gimpact.PrimitiveManagerBase;
import com.bulletphysics.extras.gimpact.PrimitiveTriangle;
import com.bulletphysics.extras.gimpact.ShapeType;
import com.bulletphysics.extras.gimpact.TetrahedronShapeEx;
import com.bulletphysics.extras.gimpact.TriangleShapeEx;
import com.bulletphysics.extras.gimpact.TrimeshPrimitiveManager;
import com.bulletphysics.linearmath.Transform;
import com.bulletphysics.util.IntArrayList;
import javax.vecmath.Tuple3f;
import javax.vecmath.Vector3f;

public class GImpactMeshShapePart
extends GImpactShapeInterface {
    TrimeshPrimitiveManager primitive_manager = new TrimeshPrimitiveManager();
    private final IntArrayList collided = new IntArrayList();

    public GImpactMeshShapePart() {
        this.box_set.setPrimitiveManager(this.primitive_manager);
    }

    public GImpactMeshShapePart(StridingMeshInterface meshInterface, int part) {
        this.primitive_manager.meshInterface = meshInterface;
        this.primitive_manager.part = part;
        this.box_set.setPrimitiveManager(this.primitive_manager);
    }

    @Override
    public boolean childrenHasTransform() {
        return false;
    }

    @Override
    public void lockChildShapes() {
        TrimeshPrimitiveManager dummymanager = (TrimeshPrimitiveManager)this.box_set.getPrimitiveManager();
        dummymanager.lock();
    }

    @Override
    public void unlockChildShapes() {
        TrimeshPrimitiveManager dummymanager = (TrimeshPrimitiveManager)this.box_set.getPrimitiveManager();
        dummymanager.unlock();
    }

    @Override
    public int getNumChildShapes() {
        return this.primitive_manager.get_primitive_count();
    }

    @Override
    public CollisionShape getChildShape(int index) {
        assert (false);
        return null;
    }

    @Override
    public Transform getChildTransform(int index) {
        assert (false);
        return null;
    }

    @Override
    public void setChildTransform(int index, Transform transform) {
        assert (false);
    }

    @Override
    PrimitiveManagerBase getPrimitiveManager() {
        return this.primitive_manager;
    }

    TrimeshPrimitiveManager getTrimeshPrimitiveManager() {
        return this.primitive_manager;
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public void calculateLocalInertia(float f, Vector3f vector3f) {
        $Stack $Stack = $Stack.get();
        try {
            void mass;
            void inertia;
            $Stack.push$javax$vecmath$Vector3f();
            this.lockChildShapes();
            inertia.set(0.0f, 0.0f, 0.0f);
            int i = this.getVertexCount();
            void pointmass = mass / (float)i;
            Vector3f pointintertia = $Stack.get$javax$vecmath$Vector3f();
            while (i-- != 0) {
                this.getVertex(i, pointintertia);
                GImpactMassUtil.get_point_inertia(pointintertia, (float)pointmass, pointintertia);
                inertia.add(pointintertia);
            }
            this.unlockChildShapes();
            $Stack.pop$javax$vecmath$Vector3f();
            return;
        }
        catch (Throwable throwable) {
            $Stack.pop$javax$vecmath$Vector3f();
            throw throwable;
        }
    }

    @Override
    public String getName() {
        return "GImpactMeshShapePart";
    }

    @Override
    ShapeType getGImpactShapeType() {
        return ShapeType.TRIMESH_SHAPE_PART;
    }

    @Override
    public boolean needsRetrieveTriangles() {
        return true;
    }

    @Override
    public boolean needsRetrieveTetrahedrons() {
        return false;
    }

    @Override
    public void getBulletTriangle(int prim_index, TriangleShapeEx triangle) {
        this.primitive_manager.get_bullet_triangle(prim_index, triangle);
    }

    @Override
    void getBulletTetrahedron(int prim_index, TetrahedronShapeEx tetrahedron) {
        assert (false);
    }

    public int getVertexCount() {
        return this.primitive_manager.get_vertex_count();
    }

    public void getVertex(int vertex_index, Vector3f vertex) {
        this.primitive_manager.get_vertex(vertex_index, vertex);
    }

    @Override
    public void setMargin(float margin) {
        this.primitive_manager.margin = margin;
        this.postUpdate();
    }

    @Override
    public float getMargin() {
        return this.primitive_manager.margin;
    }

    @Override
    public void setLocalScaling(Vector3f scaling) {
        this.primitive_manager.scale.set(scaling);
        this.postUpdate();
    }

    @Override
    public Vector3f getLocalScaling(Vector3f out) {
        out.set(this.primitive_manager.scale);
        return out;
    }

    public int getPart() {
        return this.primitive_manager.part;
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public void processAllTriangles(TriangleCallback triangleCallback, Vector3f vector3f, Vector3f vector3f2) {
        $Stack $Stack = $Stack.get();
        try {
            void aabbMax;
            void aabbMin;
            $Stack $Stack2 = $Stack;
            $Stack2.push$com$bulletphysics$extras$gimpact$BoxCollision$AABB();
            $Stack2.push$com$bulletphysics$extras$gimpact$PrimitiveTriangle();
            this.lockChildShapes();
            BoxCollision.AABB box = $Stack.get$com$bulletphysics$extras$gimpact$BoxCollision$AABB();
            box.min.set((Tuple3f)aabbMin);
            box.max.set((Tuple3f)aabbMax);
            this.collided.clear();
            this.box_set.boxQuery(box, this.collided);
            if (this.collided.size() == 0) {
                this.unlockChildShapes();
                $Stack $Stack3 = $Stack;
                $Stack3.pop$com$bulletphysics$extras$gimpact$BoxCollision$AABB();
                $Stack3.pop$com$bulletphysics$extras$gimpact$PrimitiveTriangle();
                return;
            }
            int part = this.getPart();
            PrimitiveTriangle triangle = $Stack.get$com$bulletphysics$extras$gimpact$PrimitiveTriangle();
            int i = this.collided.size();
            while (i-- != 0) {
                void callback;
                this.getPrimitiveTriangle(this.collided.get(i), triangle);
                callback.processTriangle(triangle.vertices, part, this.collided.get(i));
            }
            this.unlockChildShapes();
            $Stack $Stack4 = $Stack;
            $Stack4.pop$com$bulletphysics$extras$gimpact$BoxCollision$AABB();
            $Stack4.pop$com$bulletphysics$extras$gimpact$PrimitiveTriangle();
            return;
        }
        catch (Throwable throwable) {
            $Stack $Stack5 = $Stack;
            $Stack5.pop$com$bulletphysics$extras$gimpact$BoxCollision$AABB();
            $Stack5.pop$com$bulletphysics$extras$gimpact$PrimitiveTriangle();
            throw throwable;
        }
    }
}

