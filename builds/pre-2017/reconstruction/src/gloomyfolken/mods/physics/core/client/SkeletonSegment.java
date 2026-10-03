/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.physics.core.client;

import gloomyfolken.mods.ktcore.VecExtensionsKt;
import gloomyfolken.mods.physics.core.client.SkeletonBody;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.lwjgl.util.vector.Quaternion;
import org.lwjgl.util.vector.Vector3f;

@Metadata(mv={1, 1, 7}, bv={1, 0, 2}, k=1, d1={"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\u0002\u0010\u0004J\u0006\u0010\u0018\u001a\u00020\u0014J\n\u0010\u0019\u001a\u00060\bj\u0002`\tR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0015\u0010\u0007\u001a\u00060\bj\u0002`\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0015\u0010\f\u001a\u00060\bj\u0002`\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u0000X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0014X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0012\u0010\u0016\u001a\u00060\bj\u0002`\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0012\u0010\u0017\u001a\u00060\bj\u0002`\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001a"}, d2={"Lgloomyfolken/mods/physics/core/client/SkeletonSegment;", "", "body", "Lgloomyfolken/mods/physics/core/client/SkeletonBody;", "(Lgloomyfolken/mods/physics/core/client/SkeletonBody;)V", "getBody", "()Lgloomyfolken/mods/physics/core/client/SkeletonBody;", "boneTranslation", "Lorg/lwjgl/util/vector/Vector3f;", "Lgloomyfolken/mods/physics/core/Vec3gl;", "getBoneTranslation", "()Lorg/lwjgl/util/vector/Vector3f;", "headTranslation", "getHeadTranslation", "parent", "getParent", "()Lgloomyfolken/mods/physics/core/client/SkeletonSegment;", "setParent", "(Lgloomyfolken/mods/physics/core/client/SkeletonSegment;)V", "q", "Lorg/lwjgl/util/vector/Quaternion;", "q1", "v", "v1", "getBoneRotation", "getWorldPosition", "minecraft"})
public final class SkeletonSegment {
    private final Quaternion q;
    private final Quaternion q1;
    private final Vector3f v;
    private final Vector3f v1;
    @Nullable
    private SkeletonSegment parent;
    @NotNull
    private final Vector3f boneTranslation;
    @NotNull
    private final Vector3f headTranslation;
    @Nullable
    private final SkeletonBody body;

    @Nullable
    public final SkeletonSegment getParent() {
        return this.parent;
    }

    public final void setParent(@Nullable SkeletonSegment skeletonSegment) {
        this.parent = skeletonSegment;
    }

    @NotNull
    public final Vector3f getBoneTranslation() {
        return this.boneTranslation;
    }

    @NotNull
    public final Vector3f getHeadTranslation() {
        return this.headTranslation;
    }

    @NotNull
    public final Vector3f getWorldPosition() {
        if (this.body != null) {
            Quaternion quaternion = this.body.getRenderRotation();
            jywc._a(quaternion, this.headTranslation, this.v);
            Vector3f.add(this.body.getRenderPos(), this.v, this.v1);
            return this.v1;
        }
        VecExtensionsKt.resetl(this.v1);
        if (this.parent != null) {
            SkeletonSegment skeletonSegment = this.parent;
            if (skeletonSegment == null) {
                Intrinsics.throwNpe();
            }
            this.v1.set(skeletonSegment.getWorldPosition());
            this.q.set(this.getBoneRotation());
            jywc._a(this.q, this.boneTranslation, this.v);
            Vector3f.add(this.v1, this.v, this.v1);
        }
        return this.v1;
    }

    @NotNull
    public final Quaternion getBoneRotation() {
        SkeletonSegment skeletonSegment = this.parent;
        while (skeletonSegment != null && skeletonSegment.body == null) {
            skeletonSegment = skeletonSegment.parent;
        }
        this.q1.setIdentity();
        if (this.body != null) {
            Quaternion.mulInverse(this.body.getRenderRotation(), this.body.getStartRotation(), this.q);
            Quaternion.mul(this.q, this.q1, this.q1);
        } else if (skeletonSegment != null) {
            SkeletonBody skeletonBody = skeletonSegment.body;
            if (skeletonBody == null) {
                Intrinsics.throwNpe();
            }
            Quaternion quaternion = skeletonBody.getRenderRotation();
            SkeletonBody skeletonBody2 = skeletonSegment.body;
            if (skeletonBody2 == null) {
                Intrinsics.throwNpe();
            }
            Quaternion.mulInverse(quaternion, skeletonBody2.getStartRotation(), this.q);
            Quaternion.mul(this.q, this.q1, this.q1);
        }
        return this.q1;
    }

    @Nullable
    public final SkeletonBody getBody() {
        return this.body;
    }

    public SkeletonSegment(@Nullable SkeletonBody skeletonBody) {
        this.body = skeletonBody;
        this.q = new Quaternion();
        this.q1 = new Quaternion();
        this.v = new Vector3f();
        this.v1 = new Vector3f();
        this.boneTranslation = new Vector3f();
        this.headTranslation = new Vector3f();
    }
}

