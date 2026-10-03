/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.physics.ragdolls.client.ragdoll;

import com.bulletphysics.dynamics.RigidBody;
import gloomyfolken.mods.ktcore.VecExtensionsKt;
import gloomyfolken.mods.physics.core.client.SkeletonBody;
import gloomyfolken.mods.physics.core.client.SkeletonSegment;
import gloomyfolken.mods.physics.ragdolls.client.ragdoll.CorpseRagdollContext;
import gloomyfolken.mods.physics.ragdolls.client.ragdoll.world.RagdollWorldContext;
import java.util.HashMap;
import java.util.Map;
import javax.vecmath.Vector3f;
import kotlin.Metadata;
import kotlin.jvm.internal.FloatCompanionObject;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.util.AxisAlignedBB;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={1, 1, 7}, bv={1, 0, 2}, k=1, d1={"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0006\u0010.\u001a\u00020/J\u0012\u0010\"\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u001700J\u001a\u00101\u001a\u0002022\u0012\u00103\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u001400J\"\u00104\u001a\u0002022\u0012\u00105\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u0017002\u0006\u0010\u0016\u001a\u00020\u0017J\u000e\u00106\u001a\u0002022\u0006\u00107\u001a\u00020\u0006J\u0006\u00108\u001a\u000202J\u0010\u00109\u001a\u0002022\b\b\u0002\u0010:\u001a\u00020;R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082D\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\u00020\bX\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0015\u0010\u000b\u001a\u00060\fj\u0002`\r\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0015\u0010\u0010\u001a\u00060\fj\u0002`\r\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000fR*\u0010\u0012\u001a\u001e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00140\u0013j\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u0014`\u0015X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001c\u0010\u001c\u001a\u0004\u0018\u00010\u0014X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R-\u0010!\u001a\u001e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00170\u0013j\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u0017`\u0015\u00a2\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u001a\u0010$\u001a\u00020\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\u001a\u0010)\u001a\u00020\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b*\u0010&\"\u0004\b+\u0010(R\u0012\u0010,\u001a\u00060\fj\u0002`\rX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0012\u0010-\u001a\u00060\fj\u0002`\rX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006<"}, d2={"Lgloomyfolken/mods/physics/ragdolls/client/ragdoll/RagdollCorpse;", "", "ctx", "Lgloomyfolken/mods/physics/ragdolls/client/ragdoll/CorpseRagdollContext;", "(Lgloomyfolken/mods/physics/ragdolls/client/ragdoll/CorpseRagdollContext;)V", "AABB_EXPAND_FACTOR", "", "MAX_ACTIVE_TIME_SEC", "", "getMAX_ACTIVE_TIME_SEC", "()I", "aabbMax", "Ljavax/vecmath/Vector3f;", "Lgloomyfolken/mods/physics/core/Vec3vm;", "getAabbMax", "()Ljavax/vecmath/Vector3f;", "aabbMin", "getAabbMin", "bodies", "Ljava/util/HashMap;", "Lgloomyfolken/mods/physics/core/client/SkeletonBody;", "Lkotlin/collections/HashMap;", "root", "Lgloomyfolken/mods/physics/core/client/SkeletonSegment;", "getRoot", "()Lgloomyfolken/mods/physics/core/client/SkeletonSegment;", "setRoot", "(Lgloomyfolken/mods/physics/core/client/SkeletonSegment;)V", "rootBody", "getRootBody", "()Lgloomyfolken/mods/physics/core/client/SkeletonBody;", "setRootBody", "(Lgloomyfolken/mods/physics/core/client/SkeletonBody;)V", "segments", "getSegments", "()Ljava/util/HashMap;", "sleptTime", "getSleptTime", "()F", "setSleptTime", "(F)V", "timeExisted", "getTimeExisted", "setTimeExisted", "tmp", "tmp1", "getAabbForCamera", "Lnet/minecraft/util/AxisAlignedBB;", "", "setBodies", "", "newBodies", "setSegments", "newSegments", "update", "dt", "updateInternalAabb", "updateWorldTransform", "initial", "", "minecraft"})
public final class RagdollCorpse {
    @NotNull
    private final HashMap<Integer, SkeletonSegment> segments;
    private final HashMap<Integer, SkeletonBody> bodies;
    @Nullable
    private SkeletonBody rootBody;
    @Nullable
    private SkeletonSegment root;
    private float sleptTime;
    private float timeExisted;
    private final int MAX_ACTIVE_TIME_SEC = 18;
    @NotNull
    private final Vector3f aabbMin;
    @NotNull
    private final Vector3f aabbMax;
    private final Vector3f tmp;
    private final Vector3f tmp1;
    private final float AABB_EXPAND_FACTOR = 0.1f;
    private final CorpseRagdollContext ctx;

    @NotNull
    public final HashMap<Integer, SkeletonSegment> getSegments() {
        return this.segments;
    }

    @Nullable
    public final SkeletonBody getRootBody() {
        return this.rootBody;
    }

    public final void setRootBody(@Nullable SkeletonBody skeletonBody) {
        this.rootBody = skeletonBody;
    }

    @Nullable
    public final SkeletonSegment getRoot() {
        return this.root;
    }

    public final void setRoot(@Nullable SkeletonSegment skeletonSegment) {
        this.root = skeletonSegment;
    }

    public final float getSleptTime() {
        return this.sleptTime;
    }

    public final void setSleptTime(float f) {
        this.sleptTime = f;
    }

    public final float getTimeExisted() {
        return this.timeExisted;
    }

    public final void setTimeExisted(float f) {
        this.timeExisted = f;
    }

    public final int getMAX_ACTIVE_TIME_SEC() {
        return this.MAX_ACTIVE_TIME_SEC;
    }

    @NotNull
    public final Vector3f getAabbMin() {
        return this.aabbMin;
    }

    @NotNull
    public final Vector3f getAabbMax() {
        return this.aabbMax;
    }

    public final void setBodies(@NotNull Map<Integer, SkeletonBody> map) {
        Intrinsics.checkParameterIsNotNull(map, "newBodies");
        this.bodies.clear();
        this.bodies.putAll(map);
    }

    public final void setSegments(@NotNull Map<Integer, SkeletonSegment> map, @NotNull SkeletonSegment skeletonSegment) {
        Intrinsics.checkParameterIsNotNull(map, "newSegments");
        Intrinsics.checkParameterIsNotNull(skeletonSegment, "root");
        this.segments.clear();
        this.segments.putAll(map);
        this.root = skeletonSegment;
        SkeletonBody skeletonBody = skeletonSegment.getBody();
        if (skeletonBody == null) {
            Intrinsics.throwNpe();
        }
        this.rootBody = skeletonBody;
    }

    @NotNull
    public final Map<Integer, SkeletonSegment> getSegments() {
        return this.segments;
    }

    public final void updateInternalAabb() {
        this.aabbMin.set(FloatCompanionObject.INSTANCE.getPOSITIVE_INFINITY(), FloatCompanionObject.INSTANCE.getPOSITIVE_INFINITY(), FloatCompanionObject.INSTANCE.getPOSITIVE_INFINITY());
        this.aabbMax.set(FloatCompanionObject.INSTANCE.getNEGATIVE_INFINITY(), FloatCompanionObject.INSTANCE.getNEGATIVE_INFINITY(), FloatCompanionObject.INSTANCE.getNEGATIVE_INFINITY());
        float f = this.AABB_EXPAND_FACTOR;
        this.tmp.set(this.aabbMin);
        this.tmp1.set(this.aabbMax);
        Iterable iterable = this.bodies.values();
        for (Object t : iterable) {
            RigidBody rigidBody;
            SkeletonBody skeletonBody = (SkeletonBody)t;
            RigidBody rigidBody2 = rigidBody = skeletonBody.getBltBody();
            rigidBody2.getAabb(this.tmp, this.tmp1);
            this.aabbMin.x = owkq._c(this.tmp.x, this.aabbMin.x);
            this.aabbMin.y = owkq._c(this.tmp.y, this.aabbMin.y);
            this.aabbMin.z = owkq._c(this.tmp.z, this.aabbMin.z);
            this.aabbMax.x = owkq._d(this.tmp1.x, this.aabbMax.x);
            this.aabbMax.y = owkq._d(this.tmp1.y, this.aabbMax.y);
            this.aabbMax.z = owkq._d(this.tmp1.z, this.aabbMax.z);
        }
        VecExtensionsKt.minusAssign(this.aabbMin, f);
        VecExtensionsKt.plusAssign(this.aabbMax, f);
        this.aabbMin.y -= 0.5f;
    }

    @NotNull
    public final AxisAlignedBB getAabbForCamera() {
        this.aabbMin.set(FloatCompanionObject.INSTANCE.getPOSITIVE_INFINITY(), FloatCompanionObject.INSTANCE.getPOSITIVE_INFINITY(), FloatCompanionObject.INSTANCE.getPOSITIVE_INFINITY());
        this.aabbMax.set(FloatCompanionObject.INSTANCE.getNEGATIVE_INFINITY(), FloatCompanionObject.INSTANCE.getNEGATIVE_INFINITY(), FloatCompanionObject.INSTANCE.getNEGATIVE_INFINITY());
        this.tmp.set(this.aabbMin);
        this.tmp1.set(this.aabbMax);
        Iterable iterable = this.bodies.values();
        for (Object t : iterable) {
            RigidBody rigidBody;
            SkeletonBody skeletonBody = (SkeletonBody)t;
            RigidBody rigidBody2 = rigidBody = skeletonBody.getBltBody();
            rigidBody2.getAabb(this.tmp, this.tmp1);
            this.aabbMin.x = owkq._c(this.tmp.x, this.aabbMin.x);
            this.aabbMin.y = owkq._c(this.tmp.y, this.aabbMin.y);
            this.aabbMin.z = owkq._c(this.tmp.z, this.aabbMin.z);
            this.aabbMax.x = owkq._d(this.tmp1.x, this.aabbMax.x);
            this.aabbMax.y = owkq._d(this.tmp1.y, this.aabbMax.y);
            this.aabbMax.z = owkq._d(this.tmp1.z, this.aabbMax.z);
        }
        AxisAlignedBB axisAlignedBB = AxisAlignedBB._a(owkq._r(this.aabbMin.x), owkq._r(this.aabbMin.y), owkq._r(this.aabbMin.z), owkq._r(this.aabbMax.x), owkq._r(this.aabbMax.y), owkq._r(this.aabbMax.z));
        Intrinsics.checkExpressionValueIsNotNull(axisAlignedBB, "AxisAlignedBB.getBoundin\u2026aabbMax.y.d, aabbMax.z.d)");
        return axisAlignedBB;
    }

    public final void updateWorldTransform(boolean bl) {
        for (SkeletonBody skeletonBody : this.bodies.values()) {
            skeletonBody.updateWorldTransform();
            if (!bl) continue;
            skeletonBody.renderUpdate(1.0f);
        }
    }

    public static /* synthetic */ void updateWorldTransform$default(RagdollCorpse ragdollCorpse, boolean bl, int n, Object object) {
        if ((n & 1) != 0) {
            bl = false;
        }
        ragdollCorpse.updateWorldTransform(bl);
    }

    public final void update(float f) {
        boolean bl = true;
        for (SkeletonBody skeletonBody : this.bodies.values()) {
            skeletonBody.updatePhysics();
            if (!skeletonBody.getBltBody().isActive()) continue;
            bl = false;
        }
        this.sleptTime = bl ? (this.sleptTime += f) : 0.0f;
        this.timeExisted += f;
        if (this.timeExisted >= (float)this.MAX_ACTIVE_TIME_SEC || this.sleptTime >= 3.2f || this.sleptTime > 0.016f && !this.ctx.getInitialDeath()) {
            RagdollWorldContext ragdollWorldContext = this.ctx.getWorldContext();
            if (ragdollWorldContext != null) {
                ragdollWorldContext.setShouldSimulationStop(true);
            }
        }
        this.updateInternalAabb();
    }

    public RagdollCorpse(@NotNull CorpseRagdollContext corpseRagdollContext) {
        Intrinsics.checkParameterIsNotNull(corpseRagdollContext, "ctx");
        this.ctx = corpseRagdollContext;
        RagdollCorpse ragdollCorpse = this;
        HashMap hashMap = new HashMap();
        ragdollCorpse.segments = hashMap;
        ragdollCorpse = this;
        hashMap = new HashMap();
        ragdollCorpse.bodies = hashMap;
        this.MAX_ACTIVE_TIME_SEC = 18;
        this.aabbMin = new Vector3f(FloatCompanionObject.INSTANCE.getPOSITIVE_INFINITY(), FloatCompanionObject.INSTANCE.getPOSITIVE_INFINITY(), FloatCompanionObject.INSTANCE.getPOSITIVE_INFINITY());
        this.aabbMax = new Vector3f(FloatCompanionObject.INSTANCE.getNEGATIVE_INFINITY(), FloatCompanionObject.INSTANCE.getNEGATIVE_INFINITY(), FloatCompanionObject.INSTANCE.getNEGATIVE_INFINITY());
        this.tmp = new Vector3f();
        this.tmp1 = new Vector3f();
        this.AABB_EXPAND_FACTOR = 0.1f;
    }
}

