// 
// Decompiled by Procyon v0.6.0
// 

package gloomyfolken.mods.physics.ragdolls.client.ragdoll;

import com.bulletphysics.dynamics.RigidBodyConstructionInfo;
import com.bulletphysics.collision.shapes.CollisionShape;
import com.bulletphysics.collision.shapes.ConvexHullShape;
import com.bulletphysics.util.ObjectArrayList;
import com.bulletphysics.linearmath.MotionState;
import com.bulletphysics.dynamics.constraintsolver.TypedConstraint;
import com.bulletphysics.dynamics.constraintsolver.Generic6DofConstraint;
import com.bulletphysics.linearmath.DefaultMotionState;
import kotlin.TypeCastException;
import com.bulletphysics.dynamics.DynamicsWorld;
import gloomyfolken.mods.physics.ragdolls.entity.EntityRagdollCorpse;
import gloomyfolken.mods.physics.core.client.world.DynamicsWorldRef;
import gloomyfolken.mods.physics.ragdolls.client.ragdoll.world.RagdollWorldContext;
import java.util.NoSuchElementException;
import com.bulletphysics.collision.narrowphase.PersistentManifold;
import kotlin.collections.IntIterator;
import kotlin.collections.CollectionsKt;
import kotlin.ranges.IntRange;
import com.bulletphysics.collision.dispatch.CollisionWorld$RayResultCallback;
import com.bulletphysics.collision.dispatch.CollisionObject;
import com.bulletphysics.collision.broadphase.BroadphaseProxy;
import com.bulletphysics.collision.dispatch.CollisionWorld$LocalRayResult;
import com.bulletphysics.collision.dispatch.CollisionWorld$ClosestRayResultCallback;
import org.lwjgl.util.vector.ReadableVector3f;
import org.lwjgl.util.vector.ReadableVector4f;
import gloomyfolken.mods.ktcore.VecExtensionsKt;
import org.lwjgl.util.vector.Quaternion;
import com.bulletphysics.linearmath.Transform;
import gloomyfolken.mods.physics.core.client.SkeletonBody;
import gloomyfolken.mods.physics.core.client.SkeletonSegment;
import kotlin.text.StringsKt;
import java.util.LinkedHashMap;
import java.util.Iterator;
import java.util.ArrayList;
import java.util.Collection;
import kotlin.jvm.internal.FloatCompanionObject;
import kotlin.TuplesKt;
import gloomyfolken.mods.physics.ragdolls.entity.EntityCorpseBiped;
import com.bulletphysics.dynamics.RigidBody;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import java.util.Map;
import org.lwjgl.util.vector.Vector3f;
import kotlin.Pair;
import org.jetbrains.annotations.NotNull;
import java.util.HashMap;
import kotlin.Metadata;

@Metadata(mv = { 1, 1, 7 }, bv = { 1, 0, 2 }, k = 1, d1 = { "\u0000\u0090\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0004\b&\u0018\u00002\u00020\u0001B\u0005?\u0006\u0002\u0010\u0002J\u0006\u0010+\u001a\u00020,J\u0014\u0010-\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020.0\u001fH\u0004J,\u0010/\u001a\u0002002\u0006\u0010\u0014\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u00062\u0006\u0010(\u001a\u00020\u00102\f\u00101\u001a\b\u0012\u0004\u0012\u00020302J(\u00104\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u0002050\u001f2\u0012\u00106\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020.0\u001fH\u0014JF\u00107\u001a\u00020.2\u0010\u00108\u001a\f\u0012\b\u0012\u00060\u0018j\u0002`\u0019022\n\u00109\u001a\u00060\u0018j\u0002`\u00192\u0006\u0010:\u001a\u00020;2\u0006\u0010<\u001a\u00020\u00042\u0006\u0010=\u001a\u00020#2\u0006\u0010>\u001a\u00020#H\u0004J,\u0010?\u001a\u0016\u0012\b\u0012\u00060\u0018j\u0002`\u0019\u0012\b\u0012\u00060\u0018j\u0002`\u00190\u001b2\u0006\u0010@\u001a\u00020\u001c2\u0006\u0010A\u001a\u00020\u001cH\u0004J<\u0010B\u001a\u00020,2\u0006\u0010C\u001a\u00020;2\u0006\u0010D\u001a\u00020.2\u0006\u0010E\u001a\u00020.2\n\u0010F\u001a\u00060\u0018j\u0002`\u00192\u0006\u0010G\u001a\u00020H2\u0006\u0010I\u001a\u00020#H\u0014J\u001e\u0010J\u001a\u00020,2\u0006\u0010K\u001a\u0002002\f\u00101\u001a\b\u0012\u0004\u0012\u00020302H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082D?\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e?\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e?\u0006\u0002\n\u0000R0\u0010\t\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u000b0\nj\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u000b`\fX\u0084\u0004?\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e?\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\u00020\u00068BX\u0082\u0004?\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0014\u001a\u00020\b8BX\u0082\u0004?\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016R\u0012\u0010\u0017\u001a\u00060\u0018j\u0002`\u0019X\u0082\u0004?\u0006\u0002\n\u0000Rp\u0010\u001a\u001a^\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u001c0\u001b\u0012\u0018\u0012\u0016\u0012\b\u0012\u00060\u0018j\u0002`\u0019\u0012\b\u0012\u00060\u0018j\u0002`\u00190\u001b0\nj.\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u001c0\u001b\u0012\u0018\u0012\u0016\u0012\b\u0012\u00060\u0018j\u0002`\u0019\u0012\b\u0012\u00060\u0018j\u0002`\u00190\u001b`\fX\u0084\u0004?\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u000eR \u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u000b0\u001f8DX\u0084\u0004?\u0006\u0006\u001a\u0004\b \u0010!R\u001a\u0010\"\u001a\u00020#X\u0084\u000e?\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\u0014\u0010(\u001a\u00020\u00108BX\u0082\u0004?\u0006\u0006\u001a\u0004\b)\u0010*?\u0006L" }, d2 = { "Lgloomyfolken/mods/physics/ragdolls/client/ragdoll/SkeletonPreset;", "", "()V", "MAX_COLLISION_RESOLVE_TRIES", "", "_constructionInfo", "Lgloomyfolken/mods/physics/ragdolls/client/ragdoll/CorpseConstructionInfo;", "_ctx", "Lgloomyfolken/mods/physics/ragdolls/client/ragdoll/CorpseRagdollContext;", "_ragdollBones", "Ljava/util/HashMap;", "Lgloomyfolken/mods/physics/ragdolls/client/ragdoll/RagdollBoneInfo;", "Lkotlin/collections/HashMap;", "get_ragdollBones", "()Ljava/util/HashMap;", "_restState", "Lgloomyfolken/mods/effects/common/mcsa/data/McsaSkeletonState;", "constructionInfo", "getConstructionInfo", "()Lgloomyfolken/mods/physics/ragdolls/client/ragdoll/CorpseConstructionInfo;", "ctx", "getCtx", "()Lgloomyfolken/mods/physics/ragdolls/client/ragdoll/CorpseRagdollContext;", "heightOffset", "Lorg/lwjgl/util/vector/Vector3f;", "Lgloomyfolken/mods/physics/core/Vec3gl;", "jointLimits", "Lkotlin/Pair;", "", "getJointLimits", "ragdollBones", "", "getRagdollBones", "()Ljava/util/Map;", "ragdollScale", "", "getRagdollScale", "()F", "setRagdollScale", "(F)V", "restState", "getRestState", "()Lgloomyfolken/mods/effects/common/mcsa/data/McsaSkeletonState;", "clearSkeleton", "", "createBodies", "Lgloomyfolken/mods/physics/core/client/SkeletonBody;", "createCorpse", "Lgloomyfolken/mods/physics/ragdolls/client/ragdoll/RagdollCorpse;", "groundBodies", "", "Lcom/bulletphysics/dynamics/RigidBody;", "createJointsAndSegments", "Lgloomyfolken/mods/physics/core/client/SkeletonSegment;", "bodies", "createOrientLocateBody", "rawVertices", "bodyOrigin", "world", "Lcom/bulletphysics/dynamics/DynamicsWorld;", "boneIndex", "ccdMotionThr", "ccdSweptSr", "getJointLimitsForPair", "bone", "parentBone", "localCreateJoint", "physicsWorld", "body", "body1", "jointOrigin", "rotation", "Lorg/lwjgl/util/vector/Quaternion;", "yaw", "setupCorpse", "corpse", "minecraft" })
public abstract class SkeletonPreset
{
    private final int MAX_COLLISION_RESOLVE_TRIES = 5;
    private float ragdollScale;
    @NotNull
    private final HashMap<Integer, RagdollBoneInfo> _ragdollBones;
    private ivtm _restState;
    private CorpseConstructionInfo _constructionInfo;
    private CorpseRagdollContext _ctx;
    @NotNull
    private final HashMap<Pair<String, String>, Pair<Vector3f, Vector3f>> jointLimits;
    private final Vector3f heightOffset;
    
    protected final float getRagdollScale() {
        return this.ragdollScale;
    }
    
    protected final void setRagdollScale(final float ragdollScale) {
        this.ragdollScale = ragdollScale;
    }
    
    @NotNull
    protected final HashMap<Integer, RagdollBoneInfo> get_ragdollBones() {
        return this._ragdollBones;
    }
    
    @NotNull
    protected final Map<Integer, RagdollBoneInfo> getRagdollBones() {
        return this._ragdollBones;
    }
    
    private final ivtm getRestState() {
        final ivtm restState = this._restState;
        if (restState == null) {
            Intrinsics.throwNpe();
        }
        return restState;
    }
    
    private final CorpseConstructionInfo getConstructionInfo() {
        final CorpseConstructionInfo constructionInfo = this._constructionInfo;
        if (constructionInfo == null) {
            Intrinsics.throwNpe();
        }
        return constructionInfo;
    }
    
    private final CorpseRagdollContext getCtx() {
        final CorpseRagdollContext ctx = this._ctx;
        if (ctx == null) {
            Intrinsics.throwNpe();
        }
        return ctx;
    }
    
    @NotNull
    protected final HashMap<Pair<String, String>, Pair<Vector3f, Vector3f>> getJointLimits() {
        return this.jointLimits;
    }
    
    @NotNull
    public final RagdollCorpse createCorpse(@NotNull final CorpseRagdollContext ctx, @NotNull final CorpseConstructionInfo constructionInfo, @NotNull final ivtm restState, @NotNull final List<? extends RigidBody> list) {
        Intrinsics.checkParameterIsNotNull((Object)ctx, "ctx");
        Intrinsics.checkParameterIsNotNull((Object)constructionInfo, "constructionInfo");
        Intrinsics.checkParameterIsNotNull((Object)restState, "restState");
        Intrinsics.checkParameterIsNotNull((Object)list, "groundBodies");
        this._ctx = ctx;
        this._constructionInfo = constructionInfo;
        this._restState = restState;
        this.ragdollScale = constructionInfo.getScale();
        this.ragdollScale *= 0.99f;
        if (ctx.getState().getOwnerEntity() instanceof EntityCorpseBiped) {
            this.ragdollScale *= 0.9375f;
            this.jointLimits.put(TuplesKt.to((Object)"right_arm", (Object)"body"), TuplesKt.to((Object)new Vector3f(FloatCompanionObject.INSTANCE.getNEGATIVE_INFINITY(), -6.0f, -90.0f), (Object)new Vector3f(FloatCompanionObject.INSTANCE.getPOSITIVE_INFINITY(), 6.0f, 0.05f)));
            this.jointLimits.put(TuplesKt.to((Object)"left_arm", (Object)"body"), TuplesKt.to((Object)new Vector3f(FloatCompanionObject.INSTANCE.getNEGATIVE_INFINITY(), -6.0f, -0.05f), (Object)new Vector3f(FloatCompanionObject.INSTANCE.getPOSITIVE_INFINITY(), 6.0f, 90.0f)));
            this.jointLimits.put(TuplesKt.to((Object)"right_leg", (Object)"body"), TuplesKt.to((Object)new Vector3f(-75.0f, -12.0f, -25.0f), (Object)new Vector3f(65.0f, 12.0f, 0.05f)));
            this.jointLimits.put(TuplesKt.to((Object)"left_leg", (Object)"body"), TuplesKt.to((Object)new Vector3f(-85.0f, -12.0f, -0.05f), (Object)new Vector3f(65.0f, 12.0f, 25.0f)));
            this.jointLimits.put(TuplesKt.to((Object)"head", (Object)"body"), TuplesKt.to((Object)new Vector3f(-15.0f, -45.0f, -35.0f), (Object)new Vector3f(35.0f, 45.0f, 35.0f)));
        }
        else {
            final Iterable iterable = this.getRagdollBones().values();
            final Collection collection = new ArrayList();
            for (final Object next : iterable) {
                final RagdollBoneInfo ragdollBoneInfo = (RagdollBoneInfo)next;
                if (ragdollBoneInfo.getHasBody() && ragdollBoneInfo.getHasPhysicalParent()) {
                    collection.add(next);
                }
            }
            for (final RagdollBoneInfo ragdollBoneInfo2 : collection) {
                final Map map = this.jointLimits;
                final String boneName = ragdollBoneInfo2.getBoneName();
                final RagdollBoneInfo value = this.getRagdollBones().get(ragdollBoneInfo2.getPhysicalParentBoneIdx());
                if (value == null) {
                    Intrinsics.throwNpe();
                }
                map.put(TuplesKt.to((Object)boneName, (Object)value.getBoneName()), TuplesKt.to((Object)new Vector3f(-12.0f, -12.0f, -12.0f), (Object)new Vector3f(12.0f, 12.0f, 12.0f)));
            }
        }
        for (final Pair pair : this.jointLimits.values()) {
            final Vector3f vector3f = (Vector3f)pair.getFirst();
            vector3f.x /= 180.0f / owkq._a();
            final Vector3f vector3f2 = (Vector3f)pair.getFirst();
            vector3f2.y /= 180.0f / owkq._a();
            final Vector3f vector3f3 = (Vector3f)pair.getFirst();
            vector3f3.z /= 180.0f / owkq._a();
            final Vector3f vector3f4 = (Vector3f)pair.getSecond();
            vector3f4.x /= 180.0f / owkq._a();
            final Vector3f vector3f5 = (Vector3f)pair.getSecond();
            vector3f5.y /= 180.0f / owkq._a();
            final Vector3f vector3f6 = (Vector3f)pair.getSecond();
            vector3f6.z /= 180.0f / owkq._a();
        }
        final RagdollCorpse ragdollCorpse = new RagdollCorpse(ctx);
        this.setupCorpse(ragdollCorpse, list);
        this._restState = null;
        this._constructionInfo = null;
        this._ctx = null;
        return ragdollCorpse;
    }
    
    public void setupCorpse(@NotNull final RagdollCorpse ragdollCorpse, @NotNull final List<? extends RigidBody> list) {
        Intrinsics.checkParameterIsNotNull((Object)ragdollCorpse, "corpse");
        Intrinsics.checkParameterIsNotNull((Object)list, "groundBodies");
        final RagdollWorldContext worldContext = this.getCtx().getWorldContext();
        if (worldContext != null) {
            final DynamicsWorldRef worldRef = worldContext.getWorldRef();
            if (worldRef != null) {
                final DynamicsWorldRef dynamicsWorldRef = worldRef;
                if (this.getCtx().getState().getOwnerEntity() instanceof EntityCorpseBiped) {
                    final Map<Integer, RagdollBoneInfo> ragdollBones = this.getRagdollBones();
                    final Map map = new LinkedHashMap();
                    for (final Map.Entry<K, RagdollBoneInfo> entry : ragdollBones.entrySet()) {
                        if (StringsKt.contains$default((CharSequence)entry.getValue().getBoneName(), (CharSequence)"leg", false, 2, (Object)null)) {
                            map.put(entry.getKey(), entry.getValue());
                        }
                    }
                    final Iterator iterator2 = map.entrySet().iterator();
                    while (iterator2.hasNext()) {
                        ((Map.Entry<K, RagdollBoneInfo>)iterator2.next()).getValue().setPhysicalParentBoneIdx(2);
                    }
                }
                final Map<Integer, SkeletonBody> bodies = this.createBodies();
                final Map<Integer, SkeletonSegment> jointsAndSegments = this.createJointsAndSegments(bodies);
                final ivtm state = this.getConstructionInfo().getState();
                final EntityRagdollCorpse corpseEntity = this.getCtx().getCorpseEntity();
                RigidBody bltBody = null;
                for (final Object next : jointsAndSegments.values()) {
                    if (((SkeletonSegment)next).getParent() == null) {
                        final SkeletonBody body = ((SkeletonSegment)next).getBody();
                        if (body == null) {
                            Intrinsics.throwNpe();
                        }
                        final SkeletonBody skeletonBody = body;
                        for (final SkeletonBody skeletonBody2 : bodies.values()) {
                            final Transform transform = new Transform();
                            transform.setIdentity();
                            skeletonBody2.getBltBody().getWorldTransform(transform);
                            final Quaternion quaternion = new Quaternion();
                            final Quaternion quaternion2 = new Quaternion();
                            VecExtensionsKt.setFromEuler(quaternion, 0.0f, this.getConstructionInfo().getRotationYaw(), 0.0f);
                            quaternion2.set((ReadableVector4f)state._b[skeletonBody2.getBoneIdx()]);
                            final Vector3f gl = VecExtensionsKt.toGl(transform.origin);
                            final Vector3f gl2 = VecExtensionsKt.toGl(transform.origin);
                            gl.set((ReadableVector3f)state._a[skeletonBody2.getBoneIdx()]);
                            final Vector3f vector3f = gl2;
                            final RagdollBoneInfo value = this.getRagdollBones().get(skeletonBody2.getBoneIdx());
                            if (value == null) {
                                Intrinsics.throwNpe();
                            }
                            vector3f.set((ReadableVector3f)value.getBoneOffset());
                            jywc._a(quaternion2, gl2, gl2);
                            Vector3f.add(gl, gl2, gl);
                            jywc._a(quaternion, gl, gl);
                            gl.scale(this.ragdollScale);
                            gl.setY(owkq._d(gl.y, 0.1f));
                            Quaternion.mul(quaternion, quaternion2, quaternion);
                            final Vector3f vector3f2 = new Vector3f();
                            VecExtensionsKt.set(vector3f2, VecExtensionsKt.mul(corpseEntity.getOwnerMotion(), 20.0));
                            final SkeletonBody skeletonBody3 = skeletonBody2;
                            int i = 0;
                            final Vector3f vector3f3 = new Vector3f((ReadableVector3f)gl);
                            final javax.vecmath.Vector3f vector3f4 = new javax.vecmath.Vector3f();
                            for (int max_COLLISION_RESOLVE_TRIES = this.MAX_COLLISION_RESOLVE_TRIES; i < max_COLLISION_RESOLVE_TRIES; ++i) {
                                RigidBody bltBody2;
                                if ((bltBody2 = bltBody) == null) {
                                    bltBody2 = skeletonBody.getBltBody();
                                }
                                final RigidBody rigidBody = bltBody2;
                                dynamicsWorldRef.getDynamicsWorld().performDiscreteCollisionDetection();
                                final CollisionWorld$ClosestRayResultCallback collisionWorld$ClosestRayResultCallback = new CollisionWorld$ClosestRayResultCallback(vector3f3, rigidBody, vector3f4, VecExtensionsKt.toVm(vector3f3), rigidBody.getCenterOfMassPosition(vector3f4)) {
                                    public float addSingleResult(@NotNull final CollisionWorld$LocalRayResult collisionWorld$LocalRayResult, final boolean b) {
                                        Intrinsics.checkParameterIsNotNull((Object)collisionWorld$LocalRayResult, "rayResult");
                                        return (collisionWorld$LocalRayResult.collisionObject.getUserPointer() instanceof SkeletonBody) ? 1.0f : super.addSingleResult(collisionWorld$LocalRayResult, b);
                                    }
                                    
                                    public boolean needsCollision(@NotNull final BroadphaseProxy broadphaseProxy) {
                                        Intrinsics.checkParameterIsNotNull((Object)broadphaseProxy, "proxy0");
                                        Object clientObject;
                                        if (!((clientObject = broadphaseProxy.clientObject) instanceof CollisionObject)) {
                                            clientObject = null;
                                        }
                                        final CollisionObject collisionObject = (CollisionObject)clientObject;
                                        return !(((collisionObject != null) ? collisionObject.getUserPointer() : null) instanceof SkeletonBody) && super.needsCollision(broadphaseProxy);
                                    }
                                };
                                dynamicsWorldRef.getDynamicsWorld().rayTest(VecExtensionsKt.toVm(vector3f3), rigidBody.getCenterOfMassPosition(vector3f4), (CollisionWorld$RayResultCallback)collisionWorld$ClosestRayResultCallback);
                                boolean b2 = false;
                                Label_1165: {
                                    Label_1160: {
                                        if (!collisionWorld$ClosestRayResultCallback.hasHit() || collisionWorld$ClosestRayResultCallback.closestHitFraction >= 1.0f) {
                                            final Iterable iterable;
                                            final Collection collection = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable = (Iterable)new IntRange(0, dynamicsWorldRef.getDynamicsWorld().getDispatcher().getNumManifolds() - 1), 10));
                                            final Iterator iterator5 = iterable.iterator();
                                            while (iterator5.hasNext()) {
                                                collection.add(dynamicsWorldRef.getDynamicsWorld().getDispatcher().getManifoldByIndexInternal(((IntIterator)iterator5).nextInt()));
                                            }
                                            final Iterable iterable2 = collection;
                                            final Collection collection2 = new ArrayList();
                                            for (final Object next2 : iterable2) {
                                                if (((PersistentManifold)next2).getNumContacts() > 0) {
                                                    collection2.add(next2);
                                                }
                                            }
                                            while (true) {
                                                for (final PersistentManifold persistentManifold : collection2) {
                                                    if ((Intrinsics.areEqual(persistentManifold.getBody0(), (Object)skeletonBody3.getBltBody()) && CollectionsKt.contains((Iterable)list, persistentManifold.getBody1())) || (Intrinsics.areEqual(persistentManifold.getBody1(), (Object)skeletonBody3.getBltBody()) && CollectionsKt.contains((Iterable)list, persistentManifold.getBody0()))) {
                                                        final boolean b = true;
                                                        if (b) {
                                                            break Label_1160;
                                                        }
                                                        b2 = false;
                                                        break Label_1165;
                                                    }
                                                }
                                                final boolean b = false;
                                                continue;
                                            }
                                        }
                                    }
                                    b2 = true;
                                }
                                if (b2) {
                                    if (i > 0) {
                                        jywc._a(gl, VecExtensionsKt.toGl(rigidBody.getCenterOfMassPosition(vector3f4)), vector3f3, owkq._n(i + 1) / max_COLLISION_RESOLVE_TRIES);
                                        transform.setIdentity();
                                        VecExtensionsKt.set(transform.origin, vector3f3);
                                        transform.setRotation(VecExtensionsKt.bltQuat(quaternion));
                                        skeletonBody2.getBltBody().setWorldTransform(transform);
                                        skeletonBody2.getBltBody().getMotionState().setWorldTransform(transform);
                                        skeletonBody2.getBltBody().setLinearVelocity(VecExtensionsKt.toVm(vector3f2));
                                    }
                                }
                                else {
                                    if (bltBody == null) {
                                        bltBody = skeletonBody3.getBltBody();
                                    }
                                    if (i > 0) {
                                        break;
                                    }
                                }
                            }
                            VecExtensionsKt.set(transform.origin, vector3f3);
                            transform.setRotation(VecExtensionsKt.bltQuat(quaternion));
                            skeletonBody2.getBltBody().setWorldTransform(transform);
                            skeletonBody2.getBltBody().getMotionState().setWorldTransform(transform);
                            skeletonBody2.getBltBody().setLinearVelocity(VecExtensionsKt.toVm(vector3f2));
                        }
                        ragdollCorpse.setBodies((Map)bodies);
                        final Map<Integer, SkeletonSegment> map2 = jointsAndSegments;
                        final Iterable iterable3 = jointsAndSegments.values();
                        final Map<Integer, SkeletonSegment> map3 = map2;
                        for (final Object next3 : iterable3) {
                            if (((SkeletonSegment)next3).getParent() == null) {
                                ragdollCorpse.setSegments((Map)map3, (SkeletonSegment)next3);
                                return;
                            }
                        }
                        throw new NoSuchElementException("Collection contains no element matching the predicate.");
                    }
                }
                throw new NoSuchElementException("Collection contains no element matching the predicate.");
            }
        }
        throw new IllegalStateException("Tried to initialize ragdoll corpse without physics world!");
    }
    
    @NotNull
    protected final Pair<Vector3f, Vector3f> getJointLimitsForPair(@NotNull final String s, @NotNull final String s2) {
        Intrinsics.checkParameterIsNotNull((Object)s, "bone");
        Intrinsics.checkParameterIsNotNull((Object)s2, "parentBone");
        final Pair<Vector3f, Vector3f> value = this.jointLimits.get(TuplesKt.to((Object)s, (Object)s2));
        if (value == null) {
            Intrinsics.throwNpe();
        }
        return value;
    }
    
    @NotNull
    protected Map<Integer, SkeletonSegment> createJointsAndSegments(@NotNull final Map<Integer, SkeletonBody> map) {
        Intrinsics.checkParameterIsNotNull((Object)map, "bodies");
        final RagdollWorldContext worldContext = this.getCtx().getWorldContext();
        if (worldContext == null) {
            Intrinsics.throwNpe();
        }
        final DynamicsWorld dynamicsWorld = worldContext.getWorldRef().getDynamicsWorld();
        final HashMap hashMap = new HashMap();
        for (final RagdollBoneInfo ragdollBoneInfo : this.getRagdollBones().values()) {
            if (ragdollBoneInfo.getHasBody() && ragdollBoneInfo.getHasPhysicalParent()) {
                final SkeletonBody value = map.get(ragdollBoneInfo.getBoneIdx());
                if (value == null) {
                    Intrinsics.throwNpe();
                }
                final SkeletonBody skeletonBody = value;
                final SkeletonBody value2 = map.get(ragdollBoneInfo.getPhysicalParentBoneIdx());
                if (value2 == null) {
                    Intrinsics.throwNpe();
                }
                final SkeletonBody skeletonBody2 = value2;
                final Vector3f vector3f = new Vector3f();
                final Quaternion quaternion = new Quaternion();
                vector3f.set((ReadableVector3f)this.getRestState()._a[ragdollBoneInfo.getBoneIdx()]);
                vector3f.scale(this.ragdollScale);
                this.localCreateJoint(dynamicsWorld, skeletonBody, skeletonBody2, vector3f, quaternion, this.getConstructionInfo().getRotationYaw());
            }
            final SkeletonSegment skeletonSegment = new SkeletonSegment((SkeletonBody)map.get(ragdollBoneInfo.getBoneIdx()));
            if (ragdollBoneInfo.getParentBoneIdx() >= 0) {
                Vector3f.sub(this.getRestState()._a[ragdollBoneInfo.getBoneIdx()], this.getRestState()._a[ragdollBoneInfo.getParentBoneIdx()], skeletonSegment.getBoneTranslation());
                skeletonSegment.getBoneTranslation().scale(this.ragdollScale);
            }
            if (ragdollBoneInfo.getHasBody()) {
                final Vector3f vector3f2 = new Vector3f();
                vector3f2.set((ReadableVector3f)this.getRestState()._a[ragdollBoneInfo.getBoneIdx()]);
                vector3f2.scale(this.ragdollScale);
                final Vector3f headTranslation = skeletonSegment.getHeadTranslation();
                final Vector3f vector3f3 = vector3f2;
                final SkeletonBody body = skeletonSegment.getBody();
                if (body == null) {
                    Intrinsics.throwNpe();
                }
                headTranslation.set((ReadableVector3f)Vector3f.sub(vector3f3, VecExtensionsKt.toGl(body.getBltBody().getCenterOfMassPosition(new javax.vecmath.Vector3f())), (Vector3f)null));
            }
            hashMap.put(ragdollBoneInfo.getBoneIdx(), skeletonSegment);
        }
        for (final RagdollBoneInfo ragdollBoneInfo2 : this.getRagdollBones().values()) {
            final Object value3 = hashMap.get(ragdollBoneInfo2.getBoneIdx());
            if (value3 == null) {
                Intrinsics.throwNpe();
            }
            ((SkeletonSegment)value3).setParent((SkeletonSegment)hashMap.get(ragdollBoneInfo2.getParentBoneIdx()));
            if (ragdollBoneInfo2.getHasBody()) {
                final SkeletonBody value4 = map.get(ragdollBoneInfo2.getBoneIdx());
                if (value4 == null) {
                    Intrinsics.throwNpe();
                }
                value4.setParent((SkeletonBody)map.get(ragdollBoneInfo2.getPhysicalParentBoneIdx()));
            }
        }
        return hashMap;
    }
    
    protected void localCreateJoint(@NotNull final DynamicsWorld dynamicsWorld, @NotNull final SkeletonBody skeletonBody, @NotNull final SkeletonBody skeletonBody2, @NotNull final Vector3f vector3f, @NotNull final Quaternion quaternion, final float n) {
        Intrinsics.checkParameterIsNotNull((Object)dynamicsWorld, "physicsWorld");
        Intrinsics.checkParameterIsNotNull((Object)skeletonBody, "body");
        Intrinsics.checkParameterIsNotNull((Object)skeletonBody2, "body1");
        Intrinsics.checkParameterIsNotNull((Object)vector3f, "jointOrigin");
        Intrinsics.checkParameterIsNotNull((Object)quaternion, "rotation");
        final Transform transform = new Transform();
        final Transform transform2 = new Transform();
        transform.setIdentity();
        transform2.setIdentity();
        final Vector3f vector3f2 = new Vector3f();
        final Vector3f vector3f3 = new Vector3f();
        final Vector3f vector3f4 = vector3f2;
        final MotionState motionState = skeletonBody.getBltBody().getMotionState();
        if (motionState == null) {
            throw new TypeCastException("null cannot be cast to non-null type com.bulletphysics.linearmath.DefaultMotionState");
        }
        final javax.vecmath.Vector3f origin = ((DefaultMotionState)motionState).startWorldTrans.origin;
        Intrinsics.checkExpressionValueIsNotNull((Object)origin, "(body.bltBody.motionStat\u2026e).startWorldTrans.origin");
        VecExtensionsKt.set(vector3f4, origin);
        final Vector3f vector3f5 = vector3f3;
        final MotionState motionState2 = skeletonBody2.getBltBody().getMotionState();
        if (motionState2 == null) {
            throw new TypeCastException("null cannot be cast to non-null type com.bulletphysics.linearmath.DefaultMotionState");
        }
        final javax.vecmath.Vector3f origin2 = ((DefaultMotionState)motionState2).startWorldTrans.origin;
        Intrinsics.checkExpressionValueIsNotNull((Object)origin2, "(body1.bltBody.motionSta\u2026e).startWorldTrans.origin");
        VecExtensionsKt.set(vector3f5, origin2);
        Vector3f.sub(vector3f, vector3f2, vector3f2);
        Vector3f.sub(vector3f, vector3f3, vector3f3);
        VecExtensionsKt.set(transform.origin, vector3f2);
        VecExtensionsKt.set(transform2.origin, vector3f3);
        final Generic6DofConstraint generic6DofConstraint = new Generic6DofConstraint(skeletonBody.getBltBody(), skeletonBody2.getBltBody(), transform, transform2, false);
        final Transform transform3 = new Transform();
        transform3.setIdentity();
        VecExtensionsKt.set(transform3.origin, vector3f);
        final RagdollBoneInfo value = this.getRagdollBones().get(skeletonBody.getBoneIdx());
        if (value == null) {
            Intrinsics.throwNpe();
        }
        final String boneName = value.getBoneName();
        final RagdollBoneInfo value2 = this.getRagdollBones().get(skeletonBody2.getBoneIdx());
        if (value2 == null) {
            Intrinsics.throwNpe();
        }
        final Pair<Vector3f, Vector3f> jointLimitsForPair = this.getJointLimitsForPair(boneName, value2.getBoneName());
        generic6DofConstraint.setAngularLowerLimit(VecExtensionsKt.toVm((Vector3f)jointLimitsForPair.getFirst()));
        generic6DofConstraint.setAngularUpperLimit(VecExtensionsKt.toVm((Vector3f)jointLimitsForPair.getSecond()));
        dynamicsWorld.addConstraint((TypedConstraint)generic6DofConstraint);
    }
    
    public final void clearSkeleton() {
        this._ragdollBones.clear();
    }
    
    @NotNull
    protected final Map<Integer, SkeletonBody> createBodies() {
        final RagdollWorldContext worldContext = this.getCtx().getWorldContext();
        if (worldContext == null) {
            Intrinsics.throwNpe();
        }
        final DynamicsWorld dynamicsWorld = worldContext.getWorldRef().getDynamicsWorld();
        final HashMap hashMap = new HashMap();
        for (final RagdollBoneInfo ragdollBoneInfo : this.getRagdollBones().values()) {
            final Vector3f vector3f = new Vector3f();
            if (!ragdollBoneInfo.getHasBody()) {
                continue;
            }
            vector3f.set((ReadableVector3f)ragdollBoneInfo.getCom());
            final Iterator iterator2 = ragdollBoneInfo.getRawVertices().iterator();
            Vector3f vector3f2;
            if (!iterator2.hasNext()) {
                vector3f2 = null;
            }
            else {
                Object next = iterator2.next();
                float length = ((Vector3f)next).length();
                while (iterator2.hasNext()) {
                    final Object next2 = iterator2.next();
                    final float length2 = ((Vector3f)next2).length();
                    if (Float.compare(length, length2) > 0) {
                        next = next2;
                        length = length2;
                    }
                }
                vector3f2 = (Vector3f)next;
            }
            final Vector3f vector3f3 = vector3f2;
            final float n = (vector3f3 != null) ? vector3f3.length() : 0.0f;
            final Iterable iterable;
            final Collection collection = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable = ragdollBoneInfo.getRawVertices(), 10));
            final Iterator iterator3 = iterable.iterator();
            while (iterator3.hasNext()) {
                collection.add(((Vector3f)iterator3.next()).length());
            }
            hashMap.put(ragdollBoneInfo.getBoneIdx(), this.createOrientLocateBody(ragdollBoneInfo.getRawVertices(), vector3f, dynamicsWorld, ragdollBoneInfo.getBoneIdx(), n, CollectionsKt.sumOfFloat((Iterable)collection) / ragdollBoneInfo.getRawVertices().size()));
        }
        return hashMap;
    }
    
    @NotNull
    protected final SkeletonBody createOrientLocateBody(@NotNull final List<? extends Vector3f> list, @NotNull final Vector3f vector3f, @NotNull final DynamicsWorld dynamicsWorld, final int n, final float ccdMotionThreshold, final float ccdSweptSphereRadius) {
        Intrinsics.checkParameterIsNotNull((Object)list, "rawVertices");
        Intrinsics.checkParameterIsNotNull((Object)vector3f, "bodyOrigin");
        Intrinsics.checkParameterIsNotNull((Object)dynamicsWorld, "world");
        final ObjectArrayList list2 = new ObjectArrayList(list.size());
        final Vector3f vector3f2 = new Vector3f();
        final Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            vector3f2.set((ReadableVector3f)iterator.next());
            vector3f2.scale(this.ragdollScale);
            list2.add((Object)VecExtensionsKt.toVm(vector3f2));
        }
        vector3f.scale(this.ragdollScale);
        final ConvexHullShape convexHullShape = new ConvexHullShape(list2);
        final Transform transform = new Transform();
        transform.setIdentity();
        final javax.vecmath.Vector3f origin = transform.origin;
        final Vector3f add = Vector3f.add(vector3f, this.heightOffset, (Vector3f)null);
        Intrinsics.checkExpressionValueIsNotNull((Object)add, "Vec3gl.add(bodyOrigin, heightOffset, null)");
        VecExtensionsKt.set(origin, add);
        final float n2 = (this.getCtx().getState().getOwnerEntity() instanceof EntityCorpseBiped) ? 18.68f : 5.5f;
        final javax.vecmath.Vector3f vector3f3 = new javax.vecmath.Vector3f();
        convexHullShape.calculateLocalInertia(n2, vector3f3);
        final RigidBodyConstructionInfo rigidBodyConstructionInfo = new RigidBodyConstructionInfo(n2, (MotionState)new DefaultMotionState(transform), (CollisionShape)convexHullShape, vector3f3);
        rigidBodyConstructionInfo.friction = 0.5f;
        final RigidBody rigidBody = new RigidBody(rigidBodyConstructionInfo);
        final SkeletonBody userPointer = new SkeletonBody(rigidBody, n, (SkeletonBody)null);
        rigidBody.setUserPointer((Object)userPointer);
        rigidBody.setCcdMotionThreshold(ccdMotionThreshold);
        rigidBody.setCcdSweptSphereRadius(ccdSweptSphereRadius);
        rigidBody.setDamping(0.1f, 0.2f);
        rigidBody.setDeactivationTime(0.2f);
        rigidBody.setSleepingThresholds(1.8f, 2.1f);
        userPointer.setClampVel(true);
        dynamicsWorld.addRigidBody(rigidBody);
        return userPointer;
    }
    
    public SkeletonPreset() {
        this.ragdollScale = 1.0f;
        this._ragdollBones = new HashMap<Integer, RagdollBoneInfo>();
        this.jointLimits = new HashMap<Pair<String, String>, Pair<Vector3f, Vector3f>>();
        this.heightOffset = new Vector3f(0.0f, 0.035f, 0.0f);
    }
}
