/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.physics.ragdolls.client.ragdoll;

import com.bulletphysics.collision.broadphase.BroadphaseProxy;
import com.bulletphysics.collision.dispatch.CollisionObject;
import com.bulletphysics.collision.dispatch.CollisionWorld;
import com.bulletphysics.collision.narrowphase.PersistentManifold;
import com.bulletphysics.collision.shapes.CollisionShape;
import com.bulletphysics.collision.shapes.ConvexHullShape;
import com.bulletphysics.collision.shapes.PolyhedralConvexShape;
import com.bulletphysics.dynamics.DynamicsWorld;
import com.bulletphysics.dynamics.RigidBody;
import com.bulletphysics.dynamics.RigidBodyConstructionInfo;
import com.bulletphysics.dynamics.constraintsolver.Generic6DofConstraint;
import com.bulletphysics.linearmath.DefaultMotionState;
import com.bulletphysics.linearmath.MotionState;
import com.bulletphysics.linearmath.Transform;
import com.bulletphysics.util.ObjectArrayList;
import gloomyfolken.mods.ktcore.VecExtensionsKt;
import gloomyfolken.mods.physics.core.client.SkeletonBody;
import gloomyfolken.mods.physics.core.client.SkeletonSegment;
import gloomyfolken.mods.physics.ragdolls.client.ragdoll.CorpseConstructionInfo;
import gloomyfolken.mods.physics.ragdolls.client.ragdoll.CorpseRagdollContext;
import gloomyfolken.mods.physics.ragdolls.client.ragdoll.RagdollBoneInfo;
import gloomyfolken.mods.physics.ragdolls.client.ragdoll.RagdollCorpse;
import gloomyfolken.mods.physics.ragdolls.client.ragdoll.world.RagdollWorldContext;
import gloomyfolken.mods.physics.ragdolls.entity.EntityCorpseBiped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.TypeCastException;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.jvm.internal.FloatCompanionObject;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.lwjgl.util.vector.Quaternion;
import org.lwjgl.util.vector.ReadableVector3f;
import org.lwjgl.util.vector.Vector;
import org.lwjgl.util.vector.Vector3f;

@Metadata(mv={1, 1, 7}, bv={1, 0, 2}, k=1, d1={"\u0000\u0090\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0004\b&\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010+\u001a\u00020,J\u0014\u0010-\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020.0\u001fH\u0004J,\u0010/\u001a\u0002002\u0006\u0010\u0014\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u00062\u0006\u0010(\u001a\u00020\u00102\f\u00101\u001a\b\u0012\u0004\u0012\u00020302J(\u00104\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u0002050\u001f2\u0012\u00106\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020.0\u001fH\u0014JF\u00107\u001a\u00020.2\u0010\u00108\u001a\f\u0012\b\u0012\u00060\u0018j\u0002`\u0019022\n\u00109\u001a\u00060\u0018j\u0002`\u00192\u0006\u0010:\u001a\u00020;2\u0006\u0010<\u001a\u00020\u00042\u0006\u0010=\u001a\u00020#2\u0006\u0010>\u001a\u00020#H\u0004J,\u0010?\u001a\u0016\u0012\b\u0012\u00060\u0018j\u0002`\u0019\u0012\b\u0012\u00060\u0018j\u0002`\u00190\u001b2\u0006\u0010@\u001a\u00020\u001c2\u0006\u0010A\u001a\u00020\u001cH\u0004J<\u0010B\u001a\u00020,2\u0006\u0010C\u001a\u00020;2\u0006\u0010D\u001a\u00020.2\u0006\u0010E\u001a\u00020.2\n\u0010F\u001a\u00060\u0018j\u0002`\u00192\u0006\u0010G\u001a\u00020H2\u0006\u0010I\u001a\u00020#H\u0014J\u001e\u0010J\u001a\u00020,2\u0006\u0010K\u001a\u0002002\f\u00101\u001a\b\u0012\u0004\u0012\u00020302H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082D\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R0\u0010\t\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u000b0\nj\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u000b`\fX\u0084\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\u00020\u00068BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0014\u001a\u00020\b8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016R\u0012\u0010\u0017\u001a\u00060\u0018j\u0002`\u0019X\u0082\u0004\u00a2\u0006\u0002\n\u0000Rp\u0010\u001a\u001a^\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u001c0\u001b\u0012\u0018\u0012\u0016\u0012\b\u0012\u00060\u0018j\u0002`\u0019\u0012\b\u0012\u00060\u0018j\u0002`\u00190\u001b0\nj.\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u001c0\u001b\u0012\u0018\u0012\u0016\u0012\b\u0012\u00060\u0018j\u0002`\u0019\u0012\b\u0012\u00060\u0018j\u0002`\u00190\u001b`\fX\u0084\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u000eR \u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u000b0\u001f8DX\u0084\u0004\u00a2\u0006\u0006\u001a\u0004\b \u0010!R\u001a\u0010\"\u001a\u00020#X\u0084\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\u0014\u0010(\u001a\u00020\u00108BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b)\u0010*\u00a8\u0006L"}, d2={"Lgloomyfolken/mods/physics/ragdolls/client/ragdoll/SkeletonPreset;", "", "()V", "MAX_COLLISION_RESOLVE_TRIES", "", "_constructionInfo", "Lgloomyfolken/mods/physics/ragdolls/client/ragdoll/CorpseConstructionInfo;", "_ctx", "Lgloomyfolken/mods/physics/ragdolls/client/ragdoll/CorpseRagdollContext;", "_ragdollBones", "Ljava/util/HashMap;", "Lgloomyfolken/mods/physics/ragdolls/client/ragdoll/RagdollBoneInfo;", "Lkotlin/collections/HashMap;", "get_ragdollBones", "()Ljava/util/HashMap;", "_restState", "Lgloomyfolken/mods/effects/common/mcsa/data/McsaSkeletonState;", "constructionInfo", "getConstructionInfo", "()Lgloomyfolken/mods/physics/ragdolls/client/ragdoll/CorpseConstructionInfo;", "ctx", "getCtx", "()Lgloomyfolken/mods/physics/ragdolls/client/ragdoll/CorpseRagdollContext;", "heightOffset", "Lorg/lwjgl/util/vector/Vector3f;", "Lgloomyfolken/mods/physics/core/Vec3gl;", "jointLimits", "Lkotlin/Pair;", "", "getJointLimits", "ragdollBones", "", "getRagdollBones", "()Ljava/util/Map;", "ragdollScale", "", "getRagdollScale", "()F", "setRagdollScale", "(F)V", "restState", "getRestState", "()Lgloomyfolken/mods/effects/common/mcsa/data/McsaSkeletonState;", "clearSkeleton", "", "createBodies", "Lgloomyfolken/mods/physics/core/client/SkeletonBody;", "createCorpse", "Lgloomyfolken/mods/physics/ragdolls/client/ragdoll/RagdollCorpse;", "groundBodies", "", "Lcom/bulletphysics/dynamics/RigidBody;", "createJointsAndSegments", "Lgloomyfolken/mods/physics/core/client/SkeletonSegment;", "bodies", "createOrientLocateBody", "rawVertices", "bodyOrigin", "world", "Lcom/bulletphysics/dynamics/DynamicsWorld;", "boneIndex", "ccdMotionThr", "ccdSweptSr", "getJointLimitsForPair", "bone", "parentBone", "localCreateJoint", "physicsWorld", "body", "body1", "jointOrigin", "rotation", "Lorg/lwjgl/util/vector/Quaternion;", "yaw", "setupCorpse", "corpse", "minecraft"})
public abstract class SkeletonPreset {
    private final int MAX_COLLISION_RESOLVE_TRIES = 5;
    private float ragdollScale = 1.0f;
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

    protected final void setRagdollScale(float f) {
        this.ragdollScale = f;
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
        ivtm ivtm2 = this._restState;
        if (ivtm2 == null) {
            Intrinsics.throwNpe();
        }
        return ivtm2;
    }

    private final CorpseConstructionInfo getConstructionInfo() {
        CorpseConstructionInfo corpseConstructionInfo = this._constructionInfo;
        if (corpseConstructionInfo == null) {
            Intrinsics.throwNpe();
        }
        return corpseConstructionInfo;
    }

    private final CorpseRagdollContext getCtx() {
        CorpseRagdollContext corpseRagdollContext = this._ctx;
        if (corpseRagdollContext == null) {
            Intrinsics.throwNpe();
        }
        return corpseRagdollContext;
    }

    @NotNull
    protected final HashMap<Pair<String, String>, Pair<Vector3f, Vector3f>> getJointLimits() {
        return this.jointLimits;
    }

    @NotNull
    public final RagdollCorpse createCorpse(@NotNull CorpseRagdollContext corpseRagdollContext, @NotNull CorpseConstructionInfo corpseConstructionInfo, @NotNull ivtm ivtm2, @NotNull List<? extends RigidBody> list2) {
        Object object;
        Pair<Vector3f, Vector3f> pair;
        Pair<String, String> pair2;
        Object object2;
        Intrinsics.checkParameterIsNotNull(corpseRagdollContext, "ctx");
        Intrinsics.checkParameterIsNotNull(corpseConstructionInfo, "constructionInfo");
        Intrinsics.checkParameterIsNotNull(ivtm2, "restState");
        Intrinsics.checkParameterIsNotNull(list2, "groundBodies");
        this._ctx = corpseRagdollContext;
        this._constructionInfo = corpseConstructionInfo;
        this._restState = ivtm2;
        this.ragdollScale = corpseConstructionInfo.getScale();
        this.ragdollScale *= 0.99f;
        if (corpseRagdollContext.getState().getOwnerEntity() instanceof EntityCorpseBiped) {
            this.ragdollScale *= 0.9375f;
            object2 = this.jointLimits;
            pair2 = TuplesKt.to("right_arm", "body");
            pair = TuplesKt.to(new Vector3f(FloatCompanionObject.INSTANCE.getNEGATIVE_INFINITY(), -6.0f, -90.0f), new Vector3f(FloatCompanionObject.INSTANCE.getPOSITIVE_INFINITY(), 6.0f, 0.05f));
            object2.put(pair2, pair);
            object2 = this.jointLimits;
            pair2 = TuplesKt.to("left_arm", "body");
            pair = TuplesKt.to(new Vector3f(FloatCompanionObject.INSTANCE.getNEGATIVE_INFINITY(), -6.0f, -0.05f), new Vector3f(FloatCompanionObject.INSTANCE.getPOSITIVE_INFINITY(), 6.0f, 90.0f));
            object2.put(pair2, pair);
            object2 = this.jointLimits;
            pair2 = TuplesKt.to("right_leg", "body");
            pair = TuplesKt.to(new Vector3f(-75.0f, -12.0f, -25.0f), new Vector3f(65.0f, 12.0f, 0.05f));
            object2.put(pair2, pair);
            object2 = this.jointLimits;
            pair2 = TuplesKt.to("left_leg", "body");
            pair = TuplesKt.to(new Vector3f(-85.0f, -12.0f, -0.05f), new Vector3f(65.0f, 12.0f, 25.0f));
            object2.put(pair2, pair);
            object2 = this.jointLimits;
            pair2 = TuplesKt.to("head", "body");
            pair = TuplesKt.to(new Vector3f(-15.0f, -45.0f, -35.0f), new Vector3f(35.0f, 45.0f, 35.0f));
            object2.put(pair2, pair);
        } else {
            Object object3;
            Object object4;
            object2 = this.getRagdollBones().values();
            pair2 = object2;
            pair = new ArrayList();
            object = pair2.iterator();
            while (object.hasNext()) {
                object4 = object.next();
                object3 = (RagdollBoneInfo)object4;
                if (!(((RagdollBoneInfo)object3).getHasBody() && ((RagdollBoneInfo)object3).getHasPhysicalParent())) continue;
                pair.add(object4);
            }
            object2 = (List)((Object)pair);
            pair2 = object2.iterator();
            while (pair2.hasNext()) {
                pair = pair2.next();
                object = (RagdollBoneInfo)((Object)pair);
                object4 = this.jointLimits;
                String string = ((RagdollBoneInfo)object).getBoneName();
                RagdollBoneInfo ragdollBoneInfo = this.getRagdollBones().get(((RagdollBoneInfo)object).getPhysicalParentBoneIdx());
                if (ragdollBoneInfo == null) {
                    Intrinsics.throwNpe();
                }
                object3 = TuplesKt.to(string, ragdollBoneInfo.getBoneName());
                Pair<Vector3f, Vector3f> pair3 = TuplesKt.to(new Vector3f(-12.0f, -12.0f, -12.0f), new Vector3f(12.0f, 12.0f, 12.0f));
                object4.put((Object)object3, pair3);
            }
        }
        object2 = this.jointLimits.values();
        pair2 = object2.iterator();
        while (pair2.hasNext()) {
            pair = pair2.next();
            object = pair;
            ((Vector3f)((Pair)object).getFirst()).x /= 180.0f / owkq._a();
            ((Vector3f)((Pair)object).getFirst()).y /= 180.0f / owkq._a();
            ((Vector3f)((Pair)object).getFirst()).z /= 180.0f / owkq._a();
            ((Vector3f)((Pair)object).getSecond()).x /= 180.0f / owkq._a();
            ((Vector3f)((Pair)object).getSecond()).y /= 180.0f / owkq._a();
            ((Vector3f)((Pair)object).getSecond()).z /= 180.0f / owkq._a();
        }
        object2 = new RagdollCorpse(corpseRagdollContext);
        this.setupCorpse((RagdollCorpse)object2, list2);
        this._restState = null;
        this._constructionInfo = null;
        this._ctx = null;
        return object2;
    }

    /*
     * Could not resolve type clashes
     * Unable to fully structure code
     */
    public void setupCorpse(@NotNull RagdollCorpse var1_1, @NotNull List<? extends RigidBody> var2_2) {
        block20: {
            block18: {
                Intrinsics.checkParameterIsNotNull(var1_1, "corpse");
                Intrinsics.checkParameterIsNotNull(var2_2, "groundBodies");
                v0 = this.getCtx().getWorldContext();
                if (v0 == null || (v0 = v0.getWorldRef()) == null) {
                    throw (Throwable)new IllegalStateException("Tried to initialize ragdoll corpse without physics world!");
                }
                var3_3 = v0;
                if (this.getCtx().getState().getOwnerEntity() instanceof EntityCorpseBiped) {
                    var5_5 = var4_4 = this.getRagdollBones();
                    var6_6 = new LinkedHashMap<K, V>();
                    var7_7 = var5_5;
                    for (Object var9_9 : var7_7.entrySet()) {
                        var10_10 = var9_9;
                        if (!StringsKt.contains$default((CharSequence)((RagdollBoneInfo)var10_10.getValue()).getBoneName(), "leg", false, 2, null)) continue;
                        var6_6.put(var9_9.getKey(), var9_9.getValue());
                    }
                    var4_4 = var6_6;
                    var5_5 = var4_4;
                    for (Map.Entry<K, V> var7_7 : var5_5.entrySet()) {
                        var8_8 = var7_7;
                        ((RagdollBoneInfo)var8_8.getValue()).setPhysicalParentBoneIdx(2);
                    }
                }
                var4_4 = this.createBodies();
                var5_5 = this.createJointsAndSegments((Map<Integer, SkeletonBody>)var4_4);
                var6_6 = this.getConstructionInfo().getState();
                var7_7 = this.getCtx().getCorpseEntity();
                var8_8 = null;
                var10_10 = var5_5.values();
                var11_11 = var10_10.iterator();
                while (var11_11.hasNext()) {
                    var12_12 = var11_11.next();
                    var13_13 = (SkeletonSegment)var12_12;
                    if (!(var13_13.getParent() == null)) continue;
                    break block18;
                }
                throw (Throwable)new NoSuchElementException("Collection contains no element matching the predicate.");
            }
            v1 = ((SkeletonSegment)var12_12).getBody();
            if (v1 == null) {
                Intrinsics.throwNpe();
            }
            var9_9 = v1;
            var10_10 = var4_4.values();
            var11_11 = var10_10.iterator();
            while (var11_11.hasNext()) {
                var12_12 = var11_11.next();
                var13_13 = (SkeletonBody)var12_12;
                var14_14 = new Transform();
                var14_14.setIdentity();
                var13_13.getBltBody().getWorldTransform(var14_14);
                var15_15 = new Quaternion();
                var16_16 = new Quaternion();
                VecExtensionsKt.setFromEuler(var15_15, 0.0f, this.getConstructionInfo().getRotationYaw(), 0.0f);
                var16_16.set(var6_6._b[var13_13.getBoneIdx()]);
                var17_17 = VecExtensionsKt.toGl(var14_14.origin);
                var18_18 = VecExtensionsKt.toGl(var14_14.origin);
                var17_17.set(var6_6._a[var13_13.getBoneIdx()]);
                v2 = this.getRagdollBones().get(var13_13.getBoneIdx());
                if (v2 == null) {
                    Intrinsics.throwNpe();
                }
                var18_18.set(v2.getBoneOffset());
                jywc._a(var16_16, var18_18, var18_18);
                Vector3f.add(var17_17, var18_18, var17_17);
                jywc._a(var15_15, var17_17, var17_17);
                var17_17.scale(this.ragdollScale);
                var17_17.setY(owkq._d(var17_17.y, 0.1f));
                Quaternion.mul(var15_15, var16_16, var15_15);
                var19_19 = new Vector3f();
                VecExtensionsKt.set(var19_19, VecExtensionsKt.mul(var7_7.getOwnerMotion(), 20.0));
                var20_20 = var13_13;
                var22_22 = new Vector3f(var17_17);
                var23_23 = new javax.vecmath.Vector3f();
                var24_24 = this.MAX_COLLISION_RESOLVE_TRIES;
                for (var21_21 = 0; var21_21 < var24_24; ++var21_21) {
                    block19: {
                        v3 = var8_8;
                        if (v3 == null) {
                            v3 = var9_9.getBltBody();
                        }
                        var25_25 = v3;
                        var3_3.getDynamicsWorld().performDiscreteCollisionDetection();
                        var26_26 = new CollisionWorld.ClosestRayResultCallback(var22_22, (RigidBody)var25_25, var23_23, VecExtensionsKt.toVm(var22_22), var25_25.getCenterOfMassPosition(var23_23)){
                            final /* synthetic */ Vector3f $offsetedToRootOrigin;
                            final /* synthetic */ RigidBody $parentBody;
                            final /* synthetic */ javax.vecmath.Vector3f $com;

                            public float addSingleResult(@NotNull CollisionWorld.LocalRayResult localRayResult, boolean bl) {
                                Intrinsics.checkParameterIsNotNull(localRayResult, "rayResult");
                                return localRayResult.collisionObject.getUserPointer() instanceof SkeletonBody ? 1.0f : super.addSingleResult(localRayResult, bl);
                            }

                            public boolean needsCollision(@NotNull BroadphaseProxy broadphaseProxy) {
                                Intrinsics.checkParameterIsNotNull(broadphaseProxy, "proxy0");
                                Object object = broadphaseProxy.clientObject;
                                if (!(object instanceof CollisionObject)) {
                                    object = null;
                                }
                                CollisionObject collisionObject = (CollisionObject)object;
                                if ((collisionObject != null ? collisionObject.getUserPointer() : null) instanceof SkeletonBody) {
                                    return false;
                                }
                                return super.needsCollision(broadphaseProxy);
                            }
                            {
                                this.$offsetedToRootOrigin = vector3f;
                                this.$parentBody = rigidBody;
                                this.$com = vector3f2;
                                super(vector3f3, vector3f4);
                            }
                        };
                        var3_3.getDynamicsWorld().rayTest(VecExtensionsKt.toVm(var22_22), var25_25.getCenterOfMassPosition(var23_23), var26_26);
                        if (var26_26.hasHit() && var26_26.closestHitFraction < 1.0f) ** GOTO lbl-1000
                        var27_28 = 0;
                        var27_27 = new IntRange(var27_28, var3_3.getDynamicsWorld().getDispatcher().getNumManifolds() - 1);
                        var28_29 = var27_27;
                        var29_30 /* !! */  = new ArrayList<E>(CollectionsKt.collectionSizeOrDefault(var27_27, 10));
                        var30_31 = var28_29.iterator();
                        while (var30_31.hasNext()) {
                            var32_34 = var31_32 = ((IntIterator)var30_31).nextInt();
                            var33_36 = var29_30 /* !! */ ;
                            var34_37 = var3_3.getDynamicsWorld().getDispatcher().getManifoldByIndexInternal(var32_34);
                            var33_36.add(var34_37);
                        }
                        var27_27 = (List)var29_30 /* !! */ ;
                        var28_29 = var27_27;
                        var29_30 /* !! */  = new ArrayList<E>();
                        var30_31 = var28_29.iterator();
                        while (var30_31.hasNext()) {
                            var31_33 = var30_31.next();
                            var32_35 = (PersistentManifold)var31_33;
                            if (!(var32_35.getNumContacts() > 0)) continue;
                            var29_30 /* !! */ .add(var31_33);
                        }
                        var27_27 = (List)var29_30 /* !! */ ;
                        for (Collection var29_30 : var27_27) {
                            var30_31 = (PersistentManifold)var29_30 /* !! */ ;
                            if (!(Intrinsics.areEqual(var30_31.getBody0(), var20_20.getBltBody()) != false && CollectionsKt.contains((Iterable)var2_2, var30_31.getBody1()) != false || Intrinsics.areEqual(var30_31.getBody1(), var20_20.getBltBody()) != false && CollectionsKt.contains((Iterable)var2_2, var30_31.getBody0()) != false)) continue;
                            v4 = true;
                            break block19;
                        }
                        v4 = false;
                    }
                    if (v4) lbl-1000:
                    // 2 sources

                    {
                        v5 = true;
                    } else {
                        v5 = var35_38 = false;
                    }
                    if (var35_38) {
                        if (var21_21 <= 0) continue;
                        jywc._a(var17_17, VecExtensionsKt.toGl(var25_25.getCenterOfMassPosition(var23_23)), var22_22, owkq._n(var21_21 + 1) / (float)var24_24);
                        var14_14.setIdentity();
                        VecExtensionsKt.set(var14_14.origin, var22_22);
                        var14_14.setRotation(VecExtensionsKt.bltQuat(var15_15));
                        var13_13.getBltBody().setWorldTransform(var14_14);
                        var13_13.getBltBody().getMotionState().setWorldTransform(var14_14);
                        var13_13.getBltBody().setLinearVelocity(VecExtensionsKt.toVm(var19_19));
                        continue;
                    }
                    if (var8_8 == null) {
                        var8_8 = var20_20.getBltBody();
                    }
                    if (var21_21 > 0) break;
                }
                VecExtensionsKt.set(var14_14.origin, var22_22);
                var14_14.setRotation(VecExtensionsKt.bltQuat(var15_15));
                var13_13.getBltBody().setWorldTransform(var14_14);
                var13_13.getBltBody().getMotionState().setWorldTransform(var14_14);
                var13_13.getBltBody().setLinearVelocity(VecExtensionsKt.toVm(var19_19));
            }
            var1_1.setBodies((Map<Integer, SkeletonBody>)var4_4);
            var10_10 = var5_5.values();
            var36_39 = var5_5;
            var37_40 = var1_1;
            var11_11 = var10_10.iterator();
            while (var11_11.hasNext()) {
                var12_12 = var11_11.next();
                var13_13 = (SkeletonSegment)var12_12;
                if (!(var13_13.getParent() == null)) continue;
                break block20;
            }
            throw (Throwable)new NoSuchElementException("Collection contains no element matching the predicate.");
        }
        var38_41 = var12_12;
        var37_40.setSegments((Map<Integer, SkeletonSegment>)var36_39, (SkeletonSegment)var38_41);
    }

    @NotNull
    protected final Pair<Vector3f, Vector3f> getJointLimitsForPair(@NotNull String string, @NotNull String string2) {
        Intrinsics.checkParameterIsNotNull(string, "bone");
        Intrinsics.checkParameterIsNotNull(string2, "parentBone");
        Pair<Vector3f, Vector3f> pair = this.jointLimits.get(TuplesKt.to(string, string2));
        if (pair == null) {
            Intrinsics.throwNpe();
        }
        return pair;
    }

    @NotNull
    protected Map<Integer, SkeletonSegment> createJointsAndSegments(@NotNull Map<Integer, SkeletonBody> map) {
        Vector3f vector3f;
        Object object;
        Intrinsics.checkParameterIsNotNull(map, "bodies");
        RagdollWorldContext ragdollWorldContext = this.getCtx().getWorldContext();
        if (ragdollWorldContext == null) {
            Intrinsics.throwNpe();
        }
        DynamicsWorld dynamicsWorld = ragdollWorldContext.getWorldRef().getDynamicsWorld();
        HashMap<Integer, Object> hashMap = new HashMap<Integer, Object>();
        for (RagdollBoneInfo ragdollBoneInfo : this.getRagdollBones().values()) {
            if (ragdollBoneInfo.getHasBody() && ragdollBoneInfo.getHasPhysicalParent()) {
                SkeletonBody skeletonBody = map.get(ragdollBoneInfo.getBoneIdx());
                if (skeletonBody == null) {
                    Intrinsics.throwNpe();
                }
                object = skeletonBody;
                if (map.get(ragdollBoneInfo.getPhysicalParentBoneIdx()) == null) {
                    Intrinsics.throwNpe();
                }
                Vector3f vector3f2 = new Vector3f();
                Quaternion quaternion = new Quaternion();
                vector3f2.set(this.getRestState()._a[ragdollBoneInfo.getBoneIdx()]);
                vector3f2.scale(this.ragdollScale);
                this.localCreateJoint(dynamicsWorld, (SkeletonBody)object, (SkeletonBody)((Object)vector3f), vector3f2, quaternion, this.getConstructionInfo().getRotationYaw());
            }
            object = new SkeletonSegment(map.get(ragdollBoneInfo.getBoneIdx()));
            if (ragdollBoneInfo.getParentBoneIdx() >= 0) {
                Vector3f.sub(this.getRestState()._a[ragdollBoneInfo.getBoneIdx()], this.getRestState()._a[ragdollBoneInfo.getParentBoneIdx()], ((SkeletonSegment)object).getBoneTranslation());
                ((SkeletonSegment)object).getBoneTranslation().scale(this.ragdollScale);
            }
            if (ragdollBoneInfo.getHasBody()) {
                vector3f = new Vector3f();
                vector3f.set(this.getRestState()._a[ragdollBoneInfo.getBoneIdx()]);
                vector3f.scale(this.ragdollScale);
                Vector3f vector3f3 = ((SkeletonSegment)object).getHeadTranslation();
                SkeletonBody skeletonBody = ((SkeletonSegment)object).getBody();
                if (skeletonBody == null) {
                    Intrinsics.throwNpe();
                }
                vector3f3.set(Vector3f.sub(vector3f, VecExtensionsKt.toGl(skeletonBody.getBltBody().getCenterOfMassPosition(new javax.vecmath.Vector3f())), null));
            }
            hashMap.put(ragdollBoneInfo.getBoneIdx(), object);
        }
        for (RagdollBoneInfo ragdollBoneInfo : this.getRagdollBones().values()) {
            Object v = hashMap.get(ragdollBoneInfo.getBoneIdx());
            if (v == null) {
                Intrinsics.throwNpe();
            }
            object = (SkeletonSegment)v;
            ((SkeletonSegment)object).setParent((SkeletonSegment)hashMap.get(ragdollBoneInfo.getParentBoneIdx()));
            if (!ragdollBoneInfo.getHasBody()) continue;
            if (map.get(ragdollBoneInfo.getBoneIdx()) == null) {
                Intrinsics.throwNpe();
            }
            ((SkeletonBody)((Object)vector3f)).setParent(map.get(ragdollBoneInfo.getPhysicalParentBoneIdx()));
        }
        return hashMap;
    }

    protected void localCreateJoint(@NotNull DynamicsWorld dynamicsWorld, @NotNull SkeletonBody skeletonBody, @NotNull SkeletonBody skeletonBody2, @NotNull Vector3f vector3f, @NotNull Quaternion quaternion, float f) {
        Intrinsics.checkParameterIsNotNull(dynamicsWorld, "physicsWorld");
        Intrinsics.checkParameterIsNotNull(skeletonBody, "body");
        Intrinsics.checkParameterIsNotNull(skeletonBody2, "body1");
        Intrinsics.checkParameterIsNotNull(vector3f, "jointOrigin");
        Intrinsics.checkParameterIsNotNull(quaternion, "rotation");
        Transform transform = new Transform();
        Transform transform2 = new Transform();
        transform.setIdentity();
        transform2.setIdentity();
        Vector3f vector3f2 = new Vector3f();
        Vector3f vector3f3 = new Vector3f();
        MotionState motionState = skeletonBody.getBltBody().getMotionState();
        if (motionState == null) {
            throw new TypeCastException("null cannot be cast to non-null type com.bulletphysics.linearmath.DefaultMotionState");
        }
        javax.vecmath.Vector3f vector3f4 = ((DefaultMotionState)motionState).startWorldTrans.origin;
        Intrinsics.checkExpressionValueIsNotNull(vector3f4, "(body.bltBody.motionStat\u2026e).startWorldTrans.origin");
        VecExtensionsKt.set(vector3f2, vector3f4);
        MotionState motionState2 = skeletonBody2.getBltBody().getMotionState();
        if (motionState2 == null) {
            throw new TypeCastException("null cannot be cast to non-null type com.bulletphysics.linearmath.DefaultMotionState");
        }
        javax.vecmath.Vector3f vector3f5 = ((DefaultMotionState)motionState2).startWorldTrans.origin;
        Intrinsics.checkExpressionValueIsNotNull(vector3f5, "(body1.bltBody.motionSta\u2026e).startWorldTrans.origin");
        VecExtensionsKt.set(vector3f3, vector3f5);
        Vector3f.sub(vector3f, vector3f2, vector3f2);
        Vector3f.sub(vector3f, vector3f3, vector3f3);
        VecExtensionsKt.set(transform.origin, vector3f2);
        VecExtensionsKt.set(transform2.origin, vector3f3);
        Generic6DofConstraint generic6DofConstraint = new Generic6DofConstraint(skeletonBody.getBltBody(), skeletonBody2.getBltBody(), transform, transform2, false);
        Transform transform3 = new Transform();
        transform3.setIdentity();
        VecExtensionsKt.set(transform3.origin, vector3f);
        RagdollBoneInfo ragdollBoneInfo = this.getRagdollBones().get(skeletonBody.getBoneIdx());
        if (ragdollBoneInfo == null) {
            Intrinsics.throwNpe();
        }
        String string = ragdollBoneInfo.getBoneName();
        RagdollBoneInfo ragdollBoneInfo2 = this.getRagdollBones().get(skeletonBody2.getBoneIdx());
        if (ragdollBoneInfo2 == null) {
            Intrinsics.throwNpe();
        }
        Pair<Vector3f, Vector3f> pair = this.getJointLimitsForPair(string, ragdollBoneInfo2.getBoneName());
        generic6DofConstraint.setAngularLowerLimit(VecExtensionsKt.toVm(pair.getFirst()));
        generic6DofConstraint.setAngularUpperLimit(VecExtensionsKt.toVm(pair.getSecond()));
        dynamicsWorld.addConstraint(generic6DofConstraint);
    }

    public final void clearSkeleton() {
        this._ragdollBones.clear();
    }

    @NotNull
    protected final Map<Integer, SkeletonBody> createBodies() {
        RagdollWorldContext ragdollWorldContext = this.getCtx().getWorldContext();
        if (ragdollWorldContext == null) {
            Intrinsics.throwNpe();
        }
        DynamicsWorld dynamicsWorld = ragdollWorldContext.getWorldRef().getDynamicsWorld();
        HashMap<Integer, SkeletonBody> hashMap = new HashMap<Integer, SkeletonBody>();
        for (RagdollBoneInfo ragdollBoneInfo : this.getRagdollBones().values()) {
            Object object;
            Object object2;
            Object object3;
            Object v1;
            Vector3f vector3f = new Vector3f();
            if (!ragdollBoneInfo.getHasBody()) continue;
            vector3f.set(ragdollBoneInfo.getCom());
            Iterable iterable = ragdollBoneInfo.getRawVertices();
            Object object4 = iterable.iterator();
            if (!object4.hasNext()) {
                v1 = null;
            } else {
                object3 = object4.next();
                object2 = (Vector3f)object3;
                float f = ((Vector)object2).length();
                while (object4.hasNext()) {
                    object = object4.next();
                    Vector3f vector3f2 = (Vector3f)object;
                    float f2 = vector3f2.length();
                    if (Float.compare(f, f2) <= 0) continue;
                    object3 = object;
                    f = f2;
                }
                v1 = object3;
            }
            Vector3f vector3f3 = v1;
            float f = vector3f3 != null ? vector3f3.length() : 0.0f;
            object3 = object4 = (Iterable)ragdollBoneInfo.getRawVertices();
            object2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(object4, 10));
            object = object3.iterator();
            while (object.hasNext()) {
                Object e = object.next();
                Vector3f vector3f4 = (Vector3f)e;
                Object object5 = object2;
                Float f3 = Float.valueOf(vector3f4.length());
                object5.add(f3);
            }
            float f4 = CollectionsKt.sumOfFloat((List)object2) / (float)ragdollBoneInfo.getRawVertices().size();
            hashMap.put(ragdollBoneInfo.getBoneIdx(), this.createOrientLocateBody(ragdollBoneInfo.getRawVertices(), vector3f, dynamicsWorld, ragdollBoneInfo.getBoneIdx(), f, f4));
        }
        return hashMap;
    }

    @NotNull
    protected final SkeletonBody createOrientLocateBody(@NotNull List<? extends Vector3f> list2, @NotNull Vector3f vector3f, @NotNull DynamicsWorld dynamicsWorld, int n, float f, float f2) {
        Serializable serializable;
        Intrinsics.checkParameterIsNotNull(list2, "rawVertices");
        Intrinsics.checkParameterIsNotNull(vector3f, "bodyOrigin");
        Intrinsics.checkParameterIsNotNull(dynamicsWorld, "world");
        ObjectArrayList<javax.vecmath.Vector3f> objectArrayList = new ObjectArrayList<javax.vecmath.Vector3f>(list2.size());
        Vector3f vector3f2 = new Vector3f();
        Object object = list2;
        Object object2 = object.iterator();
        while (object2.hasNext()) {
            Object t = object2.next();
            serializable = (Vector3f)t;
            vector3f2.set((ReadableVector3f)((Object)serializable));
            vector3f2.scale(this.ragdollScale);
            objectArrayList.add(VecExtensionsKt.toVm(vector3f2));
        }
        vector3f.scale(this.ragdollScale);
        object = new ConvexHullShape(objectArrayList);
        object2 = new Transform();
        ((Transform)object2).setIdentity();
        javax.vecmath.Vector3f vector3f3 = ((Transform)object2).origin;
        Vector3f vector3f4 = Vector3f.add(vector3f, this.heightOffset, null);
        Intrinsics.checkExpressionValueIsNotNull(vector3f4, "Vec3gl.add(bodyOrigin, heightOffset, null)");
        VecExtensionsKt.set(vector3f3, vector3f4);
        float f3 = this.getCtx().getState().getOwnerEntity() instanceof EntityCorpseBiped ? 18.68f : 5.5f;
        serializable = new javax.vecmath.Vector3f();
        ((PolyhedralConvexShape)object).calculateLocalInertia(f3, (javax.vecmath.Vector3f)serializable);
        DefaultMotionState defaultMotionState = new DefaultMotionState((Transform)object2);
        RigidBodyConstructionInfo rigidBodyConstructionInfo = new RigidBodyConstructionInfo(f3, defaultMotionState, (CollisionShape)object, (javax.vecmath.Vector3f)serializable);
        rigidBodyConstructionInfo.friction = 0.5f;
        RigidBody rigidBody = new RigidBody(rigidBodyConstructionInfo);
        SkeletonBody skeletonBody = new SkeletonBody(rigidBody, n, null);
        rigidBody.setUserPointer(skeletonBody);
        rigidBody.setCcdMotionThreshold(f);
        rigidBody.setCcdSweptSphereRadius(f2);
        rigidBody.setDamping(0.1f, 0.2f);
        rigidBody.setDeactivationTime(0.2f);
        rigidBody.setSleepingThresholds(1.8f, 2.1f);
        skeletonBody.setClampVel(true);
        dynamicsWorld.addRigidBody(rigidBody);
        return skeletonBody;
    }

    public SkeletonPreset() {
        SkeletonPreset skeletonPreset = this;
        HashMap hashMap = new HashMap();
        skeletonPreset._ragdollBones = hashMap;
        skeletonPreset = this;
        hashMap = new HashMap();
        skeletonPreset.jointLimits = hashMap;
        this.heightOffset = new Vector3f(0.0f, 0.035f, 0.0f);
    }
}

