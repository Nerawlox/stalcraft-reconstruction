/*
 * Decompiled with CFR 0.152.
 */
package com.bulletphysics.extras.gimpact;

import com.bulletphysics.$Stack;
import com.bulletphysics.collision.dispatch.CollisionWorld;
import com.bulletphysics.collision.shapes.CollisionShape;
import com.bulletphysics.collision.shapes.StridingMeshInterface;
import com.bulletphysics.collision.shapes.TriangleCallback;
import com.bulletphysics.extras.gimpact.BoxCollision;
import com.bulletphysics.extras.gimpact.GImpactMeshShapePart;
import com.bulletphysics.extras.gimpact.GImpactShapeInterface;
import com.bulletphysics.extras.gimpact.PrimitiveManagerBase;
import com.bulletphysics.extras.gimpact.ShapeType;
import com.bulletphysics.extras.gimpact.TetrahedronShapeEx;
import com.bulletphysics.extras.gimpact.TriangleShapeEx;
import com.bulletphysics.linearmath.Transform;
import com.bulletphysics.util.ObjectArrayList;
import javax.vecmath.Vector3f;

public class GImpactMeshShape
extends GImpactShapeInterface {
    protected ObjectArrayList<GImpactMeshShapePart> mesh_parts = new ObjectArrayList();

    public GImpactMeshShape(StridingMeshInterface meshInterface) {
        this.buildMeshParts(meshInterface);
    }

    public int getMeshPartCount() {
        return this.mesh_parts.size();
    }

    public GImpactMeshShapePart getMeshPart(int index) {
        return this.mesh_parts.getQuick(index);
    }

    @Override
    public void setLocalScaling(Vector3f scaling) {
        this.localScaling.set(scaling);
        int i = this.mesh_parts.size();
        while (i-- != 0) {
            GImpactMeshShapePart part = this.mesh_parts.getQuick(i);
            part.setLocalScaling(scaling);
        }
        this.needs_update = true;
    }

    @Override
    public void setMargin(float margin) {
        this.collisionMargin = margin;
        int i = this.mesh_parts.size();
        while (i-- != 0) {
            GImpactMeshShapePart part = this.mesh_parts.getQuick(i);
            part.setMargin(margin);
        }
        this.needs_update = true;
    }

    @Override
    public void postUpdate() {
        int i = this.mesh_parts.size();
        while (i-- != 0) {
            GImpactMeshShapePart part = this.mesh_parts.getQuick(i);
            part.postUpdate();
        }
        this.needs_update = true;
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
            inertia.set(0.0f, 0.0f, 0.0f);
            int i = this.getMeshPartCount();
            void partmass = mass / (float)i;
            Vector3f partinertia = $Stack.get$javax$vecmath$Vector3f();
            while (i-- != 0) {
                this.getMeshPart(i).calculateLocalInertia((float)partmass, partinertia);
                inertia.add(partinertia);
            }
            $Stack.pop$javax$vecmath$Vector3f();
            return;
        }
        catch (Throwable throwable) {
            $Stack.pop$javax$vecmath$Vector3f();
            throw throwable;
        }
    }

    @Override
    PrimitiveManagerBase getPrimitiveManager() {
        assert (false);
        return null;
    }

    @Override
    public int getNumChildShapes() {
        assert (false);
        return 0;
    }

    @Override
    public boolean childrenHasTransform() {
        assert (false);
        return false;
    }

    @Override
    public boolean needsRetrieveTriangles() {
        assert (false);
        return false;
    }

    @Override
    public boolean needsRetrieveTetrahedrons() {
        assert (false);
        return false;
    }

    @Override
    public void getBulletTriangle(int prim_index, TriangleShapeEx triangle) {
        assert (false);
    }

    @Override
    void getBulletTetrahedron(int prim_index, TetrahedronShapeEx tetrahedron) {
        assert (false);
    }

    @Override
    public void lockChildShapes() {
        assert (false);
    }

    @Override
    public void unlockChildShapes() {
        assert (false);
    }

    @Override
    public void getChildAabb(int child_index, Transform t, Vector3f aabbMin, Vector3f aabbMax) {
        assert (false);
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
    ShapeType getGImpactShapeType() {
        return ShapeType.TRIMESH_SHAPE;
    }

    @Override
    public String getName() {
        return "GImpactMesh";
    }

    @Override
    public void rayTest(Vector3f rayFrom, Vector3f rayTo, CollisionWorld.RayResultCallback resultCallback) {
    }

    @Override
    public void processAllTriangles(TriangleCallback callback, Vector3f aabbMin, Vector3f aabbMax) {
        int i = this.mesh_parts.size();
        while (i-- != 0) {
            this.mesh_parts.getQuick(i).processAllTriangles(callback, aabbMin, aabbMax);
        }
    }

    protected void buildMeshParts(StridingMeshInterface meshInterface) {
        for (int i = 0; i < meshInterface.getNumSubParts(); ++i) {
            GImpactMeshShapePart newpart = new GImpactMeshShapePart(meshInterface, i);
            this.mesh_parts.add(newpart);
        }
    }

    @Override
    protected void calcLocalAABB() {
        $Stack $Stack = $Stack.get();
        try {
            $Stack.push$com$bulletphysics$extras$gimpact$BoxCollision$AABB();
            BoxCollision.AABB tmpAABB = $Stack.get$com$bulletphysics$extras$gimpact$BoxCollision$AABB();
            this.localAABB.invalidate();
            int i = this.mesh_parts.size();
            while (i-- != 0) {
                this.mesh_parts.getQuick(i).updateBound();
                this.localAABB.merge(this.mesh_parts.getQuick(i).getLocalBox(tmpAABB));
            }
            $Stack.pop$com$bulletphysics$extras$gimpact$BoxCollision$AABB();
            return;
        }
        catch (Throwable throwable) {
            $Stack.pop$com$bulletphysics$extras$gimpact$BoxCollision$AABB();
            throw throwable;
        }
    }
}

