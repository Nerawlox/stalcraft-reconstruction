/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.physics.ragdolls.client.ragdoll;

import gloomyfolken.mods.ktcore.VecExtensionsKt;
import gloomyfolken.mods.physics.ragdolls.client.ragdoll.RagdollBoneInfo;
import gloomyfolken.mods.physics.ragdolls.client.ragdoll.SkeletonPresetMesh;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.util.ResourceLocation;
import org.jetbrains.annotations.NotNull;
import org.lwjgl.util.vector.Vector3f;

@Metadata(mv={1, 1, 7}, bv={1, 0, 2}, k=1, d1={"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0006\u0010\u0013\u001a\u00020\u0014J\u0006\u0010\u0015\u001a\u00020\u0000J\b\u0010\u0016\u001a\u00020\u0014H\u0016R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e0\fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0011\u0010\u000f\u001a\u00020\u0010\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012\u00a8\u0006\u0017"}, d2={"Lgloomyfolken/mods/physics/ragdolls/client/ragdoll/CollisionModel;", "Lgloomyfolken/mods/effects/common/mcsa/data/McsaModelData;", "location", "Lnet/minecraft/util/ResourceLocation;", "(Lnet/minecraft/util/ResourceLocation;)V", "initialized", "", "getInitialized", "()Z", "setInitialized", "(Z)V", "namedMeshes", "Ljava/util/HashMap;", "", "Lgloomyfolken/mods/effects/common/mcsa/data/McsaMeshData;", "skeletonPreset", "Lgloomyfolken/mods/physics/ragdolls/client/ragdoll/SkeletonPresetMesh;", "getSkeletonPreset", "()Lgloomyfolken/mods/physics/ragdolls/client/ragdoll/SkeletonPresetMesh;", "createRagdollInfo", "", "init", "release", "minecraft"})
public final class CollisionModel
extends rpms {
    private final HashMap<String, zxep> namedMeshes;
    @NotNull
    private final SkeletonPresetMesh skeletonPreset;
    private boolean initialized;

    @NotNull
    public final SkeletonPresetMesh getSkeletonPreset() {
        return this.skeletonPreset;
    }

    public final boolean getInitialized() {
        return this.initialized;
    }

    public final void setInitialized(boolean bl) {
        this.initialized = bl;
    }

    @NotNull
    public final CollisionModel init() {
        if (!this.initialized) {
            this.namedMeshes.clear();
            this.skeletonPreset.clearSkeleton();
            Iterable iterable = this.meshes;
            for (Object t : iterable) {
                zxep zxep2 = (zxep)t;
                this.namedMeshes.put(zxep2._l, zxep2);
            }
            this.createRagdollInfo();
            this.initialized = true;
        }
        return this;
    }

    @Override
    public void release() {
        super.release();
        this.namedMeshes.clear();
        this.skeletonPreset.clearSkeleton();
        this.initialized = false;
    }

    public final void createRagdollInfo() {
        Object object;
        jywl.kjui kjui2;
        HashMap<Integer, Object> hashMap;
        block12: {
            List list2 = CollectionsKt.emptyList();
            Vector3f vector3f = new Vector3f();
            Vector3f vector3f2 = new Vector3f();
            hashMap = new HashMap<Integer, Object>();
            int n = 0;
            int n2 = this.skeleton._a - 1;
            if (n > n2) break block12;
            while (true) {
                block14: {
                    Object object2;
                    boolean bl;
                    block13: {
                        kjui2 = this.skeleton._a(n);
                        object = this.namedMeshes.get(kjui2._d);
                        boolean bl2 = bl = object != null;
                        if (bl) break block13;
                        object2 = kjui2._a;
                        while (object2 != null && this.namedMeshes.get(((jywl.kjui)object2)._d) == null) {
                            object2 = ((jywl.kjui)object2)._a;
                        }
                        if (object2 == null) break block14;
                    }
                    if (object != null) {
                        Object object3 = object2 = (Object[])((zxep)object)._b;
                        Collection collection = new ArrayList(((Object[])object2).length);
                        for (int i = 0; i < ((Object[])object3).length; ++i) {
                            Object object4 = object3[i];
                            zxep.kjui kjui3 = (zxep.kjui)object4;
                            Collection collection2 = collection;
                            Vector3f vector3f3 = new Vector3f(kjui3._a);
                            collection2.add(vector3f3);
                        }
                        list2 = (List)collection;
                        VecExtensionsKt.resetl(vector3f2);
                        object2 = list2;
                        object3 = object2.iterator();
                        while (object3.hasNext()) {
                            collection = object3.next();
                            Vector3f vector3f4 = (Vector3f)((Object)collection);
                            Vector3f.add(vector3f2, vector3f4, vector3f2);
                        }
                        vector3f2.set(vector3f2.x / owkq._n(list2.size()), vector3f2.y / owkq._n(list2.size()), vector3f2.z / owkq._n(list2.size()));
                        Vector3f.sub(vector3f2, kjui2._e, vector3f);
                        object2 = list2;
                        object3 = object2.iterator();
                        while (object3.hasNext()) {
                            collection = object3.next();
                            Vector3f vector3f5 = (Vector3f)((Object)collection);
                            Vector3f.sub(vector3f5, vector3f2, vector3f5);
                        }
                    }
                    Vector3f vector3f6 = new Vector3f(vector3f);
                    Vector3f vector3f7 = new Vector3f(vector3f2);
                    int n3 = kjui2._c;
                    String string = kjui2._d;
                    Intrinsics.checkExpressionValueIsNotNull(string, "bone.boneName");
                    object2 = new RagdollBoneInfo(list2, vector3f6, vector3f7, n3, bl, string);
                    jywl.kjui kjui4 = kjui2._a;
                    ((RagdollBoneInfo)object2).setParentBoneIdx(kjui4 != null ? kjui4._c : -1);
                    hashMap.put(kjui2._c, object2);
                }
                if (n == n2) break;
                ++n;
            }
        }
        block5: for (RagdollBoneInfo ragdollBoneInfo : hashMap.values()) {
            kjui2 = this.skeleton._a(ragdollBoneInfo.getBoneIdx());
            object = kjui2._a;
            while (object != null) {
                RagdollBoneInfo ragdollBoneInfo2 = (RagdollBoneInfo)hashMap.get(((jywl.kjui)object)._c);
                if (ragdollBoneInfo2 != null ? ragdollBoneInfo2.getHasBody() : false) {
                    ragdollBoneInfo.setPhysicalParentBoneIdx(((jywl.kjui)object)._c);
                    continue block5;
                }
                object = ((jywl.kjui)object)._a;
            }
        }
        this.skeletonPreset.setFromSkeleton((Map<Integer, RagdollBoneInfo>)hashMap);
    }

    public CollisionModel(@NotNull ResourceLocation resourceLocation) {
        Intrinsics.checkParameterIsNotNull(resourceLocation, "location");
        super(resourceLocation);
        this.namedMeshes = new HashMap();
        this.skeletonPreset = new SkeletonPresetMesh();
    }
}

