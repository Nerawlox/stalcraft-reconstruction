/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.physics.core.client.utils;

import com.bulletphysics.collision.shapes.CollisionShape;
import com.bulletphysics.dynamics.DynamicsWorld;
import com.bulletphysics.dynamics.RigidBody;
import com.bulletphysics.dynamics.RigidBodyConstructionInfo;
import com.bulletphysics.linearmath.DefaultMotionState;
import com.bulletphysics.linearmath.Transform;
import javax.vecmath.Vector3f;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={1, 1, 7}, bv={1, 0, 2}, k=1, d1={"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J&\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u0012\u0010\t\u001a\u00060\nj\u0002`\u000bX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0015"}, d2={"Lgloomyfolken/mods/physics/core/client/utils/BulletHelper;", "", "()V", "scale", "", "getScale", "()F", "setScale", "(F)V", "v", "Ljavax/vecmath/Vector3f;", "Lgloomyfolken/mods/physics/core/Vec3vm;", "createRigidBody", "Lcom/bulletphysics/dynamics/RigidBody;", "physicsWorld", "Lcom/bulletphysics/dynamics/DynamicsWorld;", "mass", "startTransform", "Lcom/bulletphysics/linearmath/Transform;", "shape", "Lcom/bulletphysics/collision/shapes/CollisionShape;", "minecraft"})
public final class BulletHelper {
    private final Vector3f v = new Vector3f();
    private float scale = 1.0f;

    public final float getScale() {
        return this.scale;
    }

    public final void setScale(float f) {
        this.scale = f;
    }

    @NotNull
    public final RigidBody createRigidBody(@NotNull DynamicsWorld dynamicsWorld, float f, @NotNull Transform transform, @NotNull CollisionShape collisionShape) {
        Intrinsics.checkParameterIsNotNull(dynamicsWorld, "physicsWorld");
        Intrinsics.checkParameterIsNotNull(transform, "startTransform");
        Intrinsics.checkParameterIsNotNull(collisionShape, "shape");
        boolean bl = f != 0.0f;
        this.v.set(0.0f, 0.0f, 0.0f);
        if (bl) {
            collisionShape.calculateLocalInertia(f, this.v);
        }
        DefaultMotionState defaultMotionState = new DefaultMotionState(transform);
        RigidBodyConstructionInfo rigidBodyConstructionInfo = new RigidBodyConstructionInfo(f, defaultMotionState, collisionShape, this.v);
        RigidBody rigidBody = new RigidBody(rigidBodyConstructionInfo);
        dynamicsWorld.addRigidBody(rigidBody);
        return rigidBody;
    }
}

