/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.physics.core.client;

import com.bulletphysics.dynamics.RigidBody;
import gloomyfolken.mods.ktcore.VecExtensionsKt;
import gloomyfolken.mods.physics.ragdolls.client.ragdoll.world.RagdollWorldContext;
import javax.vecmath.Quat4f;
import javax.vecmath.Vector3f;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.lwjgl.util.vector.Quaternion;

@Metadata(mv={1, 1, 7}, bv={1, 0, 2}, k=1, d1={"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0000\u00a2\u0006\u0002\u0010\u0007J\u000e\u00108\u001a\u0002092\u0006\u0010:\u001a\u00020;J\u0006\u0010<\u001a\u000209J\b\u0010=\u001a\u000209H\u0002J\b\u0010>\u001a\u000209H\u0002J\u0006\u0010?\u001a\u000209R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0012\u0010\n\u001a\u00060\u000bj\u0002`\fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\u0012X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0017\u001a\u00020\u0012X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0014\"\u0004\b\u0019\u0010\u0016R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0000X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u0015\u0010\u001e\u001a\u00060\u001fj\u0002` \u00a2\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u0015\u0010#\u001a\u00060\u001fj\u0002` \u00a2\u0006\b\n\u0000\u001a\u0004\b$\u0010\"R\u0011\u0010%\u001a\u00020&\u00a2\u0006\b\n\u0000\u001a\u0004\b'\u0010(R\u0015\u0010)\u001a\u00060\u001fj\u0002` \u00a2\u0006\b\n\u0000\u001a\u0004\b*\u0010\"R\u0011\u0010+\u001a\u00020&\u00a2\u0006\b\n\u0000\u001a\u0004\b,\u0010(R\u0011\u0010-\u001a\u00020&\u00a2\u0006\b\n\u0000\u001a\u0004\b.\u0010(R\u0015\u0010/\u001a\u00060\u000bj\u0002`\f\u00a2\u0006\b\n\u0000\u001a\u0004\b0\u00101R\u0015\u00102\u001a\u00060\u000bj\u0002`\f\u00a2\u0006\b\n\u0000\u001a\u0004\b3\u00101R\u0015\u00104\u001a\u00060\u000bj\u0002`\f\u00a2\u0006\b\n\u0000\u001a\u0004\b5\u00101R\u0011\u00106\u001a\u00020&\u00a2\u0006\b\n\u0000\u001a\u0004\b7\u0010(\u00a8\u0006@"}, d2={"Lgloomyfolken/mods/physics/core/client/SkeletonBody;", "", "bltBody", "Lcom/bulletphysics/dynamics/RigidBody;", "boneIdx", "", "parent", "(Lcom/bulletphysics/dynamics/RigidBody;ILgloomyfolken/mods/physics/core/client/SkeletonBody;)V", "_q", "Ljavax/vecmath/Quat4f;", "_v", "Ljavax/vecmath/Vector3f;", "Lgloomyfolken/mods/physics/core/Vec3vm;", "getBltBody", "()Lcom/bulletphysics/dynamics/RigidBody;", "getBoneIdx", "()I", "clampVel", "", "getClampVel", "()Z", "setClampVel", "(Z)V", "disableCollision", "getDisableCollision", "setDisableCollision", "getParent", "()Lgloomyfolken/mods/physics/core/client/SkeletonBody;", "setParent", "(Lgloomyfolken/mods/physics/core/client/SkeletonBody;)V", "pos", "Lorg/lwjgl/util/vector/Vector3f;", "Lgloomyfolken/mods/physics/core/Vec3gl;", "getPos", "()Lorg/lwjgl/util/vector/Vector3f;", "prevPos", "getPrevPos", "prevRotation", "Lorg/lwjgl/util/vector/Quaternion;", "getPrevRotation", "()Lorg/lwjgl/util/vector/Quaternion;", "renderPos", "getRenderPos", "renderRotation", "getRenderRotation", "startRotation", "getStartRotation", "unclampedVel", "getUnclampedVel", "()Ljavax/vecmath/Vector3f;", "v", "getV", "vel", "getVel", "worldRotation", "getWorldRotation", "renderUpdate", "", "partialTickTime", "", "updatePhysics", "updateWorldPosition", "updateWorldRotation", "updateWorldTransform", "minecraft"})
public final class SkeletonBody {
    private final Quat4f _q;
    private final Vector3f _v;
    @NotNull
    private final Quaternion startRotation;
    @NotNull
    private final Quaternion renderRotation;
    @NotNull
    private final org.lwjgl.util.vector.Vector3f renderPos;
    @NotNull
    private final Quaternion worldRotation;
    @NotNull
    private final org.lwjgl.util.vector.Vector3f pos;
    @NotNull
    private final Quaternion prevRotation;
    @NotNull
    private final org.lwjgl.util.vector.Vector3f prevPos;
    @NotNull
    private final Vector3f vel;
    @NotNull
    private final Vector3f v;
    @NotNull
    private final Vector3f unclampedVel;
    private boolean clampVel;
    private boolean disableCollision;
    @NotNull
    private final RigidBody bltBody;
    private final int boneIdx;
    @Nullable
    private SkeletonBody parent;

    @NotNull
    public final Quaternion getStartRotation() {
        return this.startRotation;
    }

    @NotNull
    public final Quaternion getRenderRotation() {
        return this.renderRotation;
    }

    @NotNull
    public final org.lwjgl.util.vector.Vector3f getRenderPos() {
        return this.renderPos;
    }

    @NotNull
    public final Quaternion getWorldRotation() {
        return this.worldRotation;
    }

    @NotNull
    public final org.lwjgl.util.vector.Vector3f getPos() {
        return this.pos;
    }

    @NotNull
    public final Quaternion getPrevRotation() {
        return this.prevRotation;
    }

    @NotNull
    public final org.lwjgl.util.vector.Vector3f getPrevPos() {
        return this.prevPos;
    }

    @NotNull
    public final Vector3f getVel() {
        return this.vel;
    }

    @NotNull
    public final Vector3f getV() {
        return this.v;
    }

    @NotNull
    public final Vector3f getUnclampedVel() {
        return this.unclampedVel;
    }

    public final boolean getClampVel() {
        return this.clampVel;
    }

    public final void setClampVel(boolean bl) {
        this.clampVel = bl;
    }

    public final boolean getDisableCollision() {
        return this.disableCollision;
    }

    public final void setDisableCollision(boolean bl) {
        this.disableCollision = bl;
    }

    public final void updatePhysics() {
        this.bltBody.getLinearVelocity(this.vel);
        if (this.clampVel) {
            if (this.vel.length() > RagdollWorldContext.Companion.getMAX_BODY_VEL()) {
                this.vel.normalize();
                this.vel.scale(RagdollWorldContext.Companion.getMAX_BODY_VEL());
                if (this.unclampedVel.length() < RagdollWorldContext.Companion.getMAX_BODY_VEL()) {
                    this.unclampedVel.set(this.vel);
                } else {
                    this.bltBody.getLinearVelocity(this.v);
                    this.v.sub(this.vel);
                    this.unclampedVel.add(this.v);
                }
                this.bltBody.setLinearVelocity(this.vel);
            } else {
                this.bltBody.getLinearVelocity(this.unclampedVel);
            }
        }
    }

    public final void updateWorldTransform() {
        this.updateWorldPosition();
        this.updateWorldRotation();
    }

    public final void renderUpdate(float f) {
        jywc._a(this.prevPos, this.pos, this.renderPos, f);
        jywc._b(this.prevRotation, this.worldRotation, this.renderRotation, f);
    }

    private final void updateWorldPosition() {
        this.prevPos.set(this.pos);
        this.bltBody.getCenterOfMassPosition(this._v);
        VecExtensionsKt.set(this.pos, this._v);
    }

    private final void updateWorldRotation() {
        this.prevRotation.set(this.worldRotation);
        this.bltBody.getOrientation(this._q);
        VecExtensionsKt.set(this.worldRotation, this._q);
    }

    @NotNull
    public final RigidBody getBltBody() {
        return this.bltBody;
    }

    public final int getBoneIdx() {
        return this.boneIdx;
    }

    @Nullable
    public final SkeletonBody getParent() {
        return this.parent;
    }

    public final void setParent(@Nullable SkeletonBody skeletonBody) {
        this.parent = skeletonBody;
    }

    public SkeletonBody(@NotNull RigidBody rigidBody, int n, @Nullable SkeletonBody skeletonBody) {
        Intrinsics.checkParameterIsNotNull(rigidBody, "bltBody");
        this.bltBody = rigidBody;
        this.boneIdx = n;
        this.parent = skeletonBody;
        this._q = new Quat4f();
        this._v = new Vector3f();
        this.startRotation = new Quaternion();
        this.renderRotation = new Quaternion();
        this.renderPos = new org.lwjgl.util.vector.Vector3f();
        this.worldRotation = new Quaternion();
        this.pos = new org.lwjgl.util.vector.Vector3f();
        this.prevRotation = new Quaternion();
        this.prevPos = new org.lwjgl.util.vector.Vector3f();
        this.vel = new Vector3f();
        this.v = new Vector3f();
        this.unclampedVel = new Vector3f();
    }
}

