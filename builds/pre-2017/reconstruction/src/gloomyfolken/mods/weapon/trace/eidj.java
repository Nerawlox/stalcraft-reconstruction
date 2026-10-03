/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.weapon.trace;

import gloomyfolken.mods.core.misc.RayTriangleIntersection;
import gloomyfolken.mods.ktcore.McExtensionsKt;
import gloomyfolken.mods.ktcore.VecExtensionsKt;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.TypeCastException;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.FloatCompanionObject;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.Vec3;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.lwjgl.util.vector.Quaternion;
import org.lwjgl.util.vector.ReadableVector3f;
import org.lwjgl.util.vector.Vector3f;

@Metadata(mv={1, 1, 7}, bv={1, 0, 2}, k=1, d1={"\u0000d\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\b&\u0018\u00002\u00020\u0001:\u00017B\u0005\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"J\b\u0010#\u001a\u00020 H\u0002J0\u0010$\u001a\u00020 2\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020&2\u0006\u0010(\u001a\u00020&2\u0006\u0010)\u001a\u00020&2\u0006\u0010*\u001a\u00020&H\u0002J\b\u0010+\u001a\u00020\u000eH&J.\u0010,\u001a\u00020 2\u0006\u0010-\u001a\u00020&2\u0006\u0010.\u001a\u00020&2\u0006\u0010/\u001a\u00020&2\u0006\u00100\u001a\u00020&2\u0006\u0010*\u001a\u00020&J$\u00101\u001a\u0010\u0012\u0004\u0012\u000203\u0012\u0004\u0012\u000204\u0018\u0001022\u0006\u00105\u001a\u0002032\u0006\u00106\u001a\u000203R\u001b\u0010\u0003\u001a\u00020\u00048BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R\u0011\u0010\t\u001a\u00020\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u001b\u0010\r\u001a\u00020\u000e8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0011\u0010\b\u001a\u0004\b\u000f\u0010\u0010R\u001b\u0010\u0012\u001a\u00020\u00138BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0016\u0010\b\u001a\u0004\b\u0014\u0010\u0015R/\u0010\u0017\u001a\u0016\u0012\f\u0012\n \u001a*\u0004\u0018\u00010\u00190\u0019\u0012\u0004\u0012\u00020\u001b0\u00188FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001e\u0010\b\u001a\u0004\b\u001c\u0010\u001d\u00a8\u00068"}, d2={"Lgloomyfolken/mods/weapon/trace/TraceMesh;", "", "()V", "animationContext", "Lgloomyfolken/mods/effects/common/mcsa/animation/AnimationContext;", "getAnimationContext", "()Lgloomyfolken/mods/effects/common/mcsa/animation/AnimationContext;", "animationContext$delegate", "Lkotlin/Lazy;", "animationLayer", "Lgloomyfolken/mods/effects/common/mcsa/animation/AnimationLayer;", "getAnimationLayer", "()Lgloomyfolken/mods/effects/common/mcsa/animation/AnimationLayer;", "model", "Lgloomyfolken/mods/effects/common/mcsa/data/McsaModelData;", "getModel", "()Lgloomyfolken/mods/effects/common/mcsa/data/McsaModelData;", "model$delegate", "skeletonState", "Lgloomyfolken/mods/effects/common/mcsa/data/McsaSkeletonState;", "getSkeletonState", "()Lgloomyfolken/mods/effects/common/mcsa/data/McsaSkeletonState;", "skeletonState$delegate", "skinnedMeshParts", "", "Lgloomyfolken/mods/effects/common/mcsa/data/McsaMeshData;", "kotlin.jvm.PlatformType", "Lgloomyfolken/mods/weapon/trace/TraceMesh$TraceMeshPart;", "getSkinnedMeshParts", "()Ljava/util/Map;", "skinnedMeshParts$delegate", "applyAnimation", "", "animationEntry", "Lgloomyfolken/mods/effects/common/mcsa/animation/AnimationEntry;", "applySkinning", "applyWorldTransform", "x", "", "y", "z", "yawDegrees", "scale", "createModel", "skinAndTransform", "translateX", "translateY", "translateZ", "yaw", "trace", "Lkotlin/Pair;", "Lnet/minecraft/util/Vec3;", "", "start", "end", "TraceMeshPart", "minecraft"})
public abstract class eidj {
    @NotNull
    private final nuco _b = new nuco();
    private final Lazy _c = LazyKt.lazy((Function0)new Function0<rpms>(){

        @Override
        public /* synthetic */ Object invoke() {
            return this._a();
        }

        public final rpms _a() {
            return this._c().loadSync();
        }
    });
    private final Lazy _d = LazyKt.lazy((Function0)new Function0<ivtm>(){

        @Override
        public /* synthetic */ Object invoke() {
            return this._a();
        }

        @NotNull
        public final ivtm _a() {
            return new ivtm(((eidj)this)._d().getSkeleton()._e);
        }
    });
    private final Lazy _e = LazyKt.lazy((Function0)new Function0<zxbe>(){

        @Override
        public /* synthetic */ Object invoke() {
            return this._a();
        }

        @NotNull
        public final zxbe _a() {
            return new zxbe((jhuw)this._d(), new iest[0]);
        }
    });
    @NotNull
    private final Lazy _f = LazyKt.lazy((Function0)new Function0<Map<zxep, ? extends kjui>>(){

        @Override
        public /* synthetic */ Object invoke() {
            return this._a();
        }

        @NotNull
        public final Map<zxep, kjui> _a() {
            zxep zxep2;
            Iterable iterable;
            Iterable iterable2 = iterable = (Iterable)this._d().getMeshes();
            Collection collection = new ArrayList();
            for (Object t : iterable2) {
                zxep2 = (zxep)t;
                if (!(this._d().getSkeleton()._a().get(zxep2._l) != null)) continue;
                collection.add(t);
            }
            iterable = (List)collection;
            iterable2 = iterable;
            collection = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
            for (Object t : iterable2) {
                short[] sArray;
                int n;
                jywl.kjui kjui2;
                zxep2 = (zxep)t;
                Collection collection2 = collection;
                jywl.kjui kjui3 = kjui2 = this._d().getSkeleton()._a().get(zxep2._l);
                if (kjui3 == null) {
                    throw (Throwable)new IllegalStateException("wtf");
                }
                int n2 = kjui3._c;
                Object[] objectArray = zxep2._b;
                for (int i = 0; i < objectArray.length; ++i) {
                    byte[] byArray;
                    int n3;
                    int n4;
                    Object object = objectArray[i];
                    zxep.kjui kjui4 = (zxep.kjui)object;
                    n = 1;
                    zxep.kjui kjui5 = kjui4;
                    Object[] objectArray2 = new byte[n];
                    int n5 = 0;
                    int n6 = n - 1;
                    if (n5 <= n6) {
                        do {
                            byte by;
                            n4 = ++n5;
                            n3 = n5;
                            byArray = objectArray2;
                            byArray[n3] = by = (byte)n2;
                        } while (n5 != n6);
                    }
                    byArray = objectArray2;
                    kjui5._g = byArray;
                    n = 1;
                    kjui5 = kjui4;
                    objectArray2 = new float[n];
                    n5 = 0;
                    n6 = n - 1;
                    if (n5 <= n6) {
                        do {
                            n4 = ++n5;
                            n3 = n5;
                            byArray = objectArray2;
                            float f = 1.0f;
                            byArray[n3] = (byte)f;
                        } while (n5 != n6);
                    }
                    byArray = objectArray2;
                    kjui5._f = byArray;
                }
                int n7 = n2 + 1;
                zxep zxep3 = zxep2;
                short[] sArray2 = new short[n7];
                int n8 = 0;
                int n9 = n7 - 1;
                if (n8 <= n9) {
                    do {
                        short s;
                        n = ++n8;
                        int n10 = n8;
                        sArray = sArray2;
                        sArray[n10] = s = (short)n2;
                    } while (n8 != n9);
                }
                sArray = sArray2;
                zxep3._t = sArray;
                zxep zxep4 = zxep2._b();
                Intrinsics.checkExpressionValueIsNotNull(zxep4, "srcMesh.createSkinningTarget()");
                Pair<zxep, kjui> pair = TuplesKt.to(zxep2, new kjui(zxep4));
                collection2.add(pair);
            }
            return MapsKt.toMap((List)collection);
        }
    });
    static final /* synthetic */ KProperty[] _a;

    @NotNull
    public final nuco _a() {
        return this._b;
    }

    private final rpms _d() {
        Lazy lazy = this._c;
        eidj eidj2 = this;
        KProperty kProperty = _a[0];
        return (rpms)lazy.getValue();
    }

    private final ivtm _e() {
        Lazy lazy = this._d;
        eidj eidj2 = this;
        KProperty kProperty = _a[1];
        return (ivtm)lazy.getValue();
    }

    private final zxbe _f() {
        Lazy lazy = this._e;
        eidj eidj2 = this;
        KProperty kProperty = _a[2];
        return (zxbe)lazy.getValue();
    }

    @NotNull
    public final Map<zxep, kjui> _b() {
        Lazy lazy = this._f;
        eidj eidj2 = this;
        KProperty kProperty = _a[3];
        return (Map)lazy.getValue();
    }

    @NotNull
    public abstract rpms _c();

    private final void _g() {
        Iterable iterable = this._d().getMeshes();
        for (Object t : iterable) {
            zxep zxep2 = (zxep)t;
            kjui kjui2 = this._b().get(zxep2);
            if (kjui2 == null) continue;
            zxep zxep3 = zxep2;
            Intrinsics.checkExpressionValueIsNotNull(zxep3, "mesh");
            kjui2._a(zxep3, this._e());
        }
    }

    private final void _b(float f, float f2, float f3, float f4, float f5) {
        Quaternion quaternion = new Quaternion().setIdentity();
        jywc._a(new Vector3f(0.0f, -f4 * (float)Math.PI / 180.0f, 0.0f), quaternion);
        Iterable iterable = this._b().values();
        for (Object t : iterable) {
            kjui kjui2 = (kjui)t;
            Object[] objectArray = kjui2._e()._b;
            for (int i = 0; i < objectArray.length; ++i) {
                Object object = objectArray[i];
                zxep.kjui kjui3 = (zxep.kjui)object;
                kjui3._a.scale(f5);
                jywc._a(quaternion, kjui3._a, kjui3._a);
                VecExtensionsKt.addl(kjui3._a, f, f2, f3);
            }
        }
    }

    public final void _a(@NotNull uhrn uhrn2) {
        Intrinsics.checkParameterIsNotNull(uhrn2, "animationEntry");
        this._f()._b(uhrn2);
        this._f()._a(this._e(), 0.0f);
    }

    public final void _a(float f, float f2, float f3, float f4, float f5) {
        this._g();
        this._b(f, f2, f3, f4, f5);
        Iterable iterable = this._b().values();
        for (Object t : iterable) {
            kjui kjui2 = (kjui)t;
            kjui2._d();
        }
    }

    @Nullable
    public final Pair<Vec3, String> _a(@NotNull Vec3 vec3, @NotNull Vec3 vec32) {
        Intrinsics.checkParameterIsNotNull(vec3, "start");
        Intrinsics.checkParameterIsNotNull(vec32, "end");
        Vector3f vector3f = VecExtensionsKt.toGl(vec3);
        Vector3f vector3f2 = VecExtensionsKt.toGl(vec32);
        Vector3f vector3f3 = VecExtensionsKt.normalized(VecExtensionsKt.minus(vector3f2, vector3f));
        Vector3f vector3f4 = VecExtensionsKt.toGl(VecExtensionsKt.vec3());
        String string = null;
        float f = FloatCompanionObject.INSTANCE.getMAX_VALUE();
        Iterable iterable = this._b().values();
        block0: for (Object t : iterable) {
            boolean bl;
            kjui kjui2 = (kjui)t;
            boolean bl2 = bl = kjui2._a()._a(vec3, vec32) != null;
            if (!bl) continue;
            zxep zxep2 = kjui2._e();
            int n = 0;
            int n2 = zxep2._c.length / 3 - 1;
            if (n > n2) continue;
            while (true) {
                Vector3f vector3f5 = zxep2._a((int)(n * 3))._a;
                Intrinsics.checkExpressionValueIsNotNull(vector3f5, "mesh.getVertex(i*3).position");
                Vector3f vector3f6 = zxep2._a((int)(n * 3 + 1))._a;
                Intrinsics.checkExpressionValueIsNotNull(vector3f6, "mesh.getVertex(i*3+1).position");
                Vector3f vector3f7 = zxep2._a((int)(n * 3 + 2))._a;
                Intrinsics.checkExpressionValueIsNotNull(vector3f7, "mesh.getVertex(i*3+2).position");
                if (RayTriangleIntersection._a._a(vector3f, vector3f3, vector3f5, vector3f6, vector3f7) >= 0.0f) {
                    zxep.kjui[] kjuiArray = (zxep.kjui[])CollectionsKt.listOf(new zxep.kjui[]{zxep2._a(n * 3), zxep2._a(n * 3 + 1), zxep2._a(n * 3 + 2)});
                    if (kjuiArray == null) {
                        throw new TypeCastException("null cannot be cast to non-null type java.util.Collection<T>");
                    }
                    Object object = kjuiArray;
                    zxep.kjui[] kjuiArray2 = object.toArray(new zxep.kjui[object.size()]);
                    if (kjuiArray2 == null) {
                        throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
                    }
                    kjuiArray = kjuiArray2;
                    object = new Vector3f();
                    for (int i = 0; i < kjuiArray.length; ++i) {
                        Vector3f vector3f8;
                        zxep.kjui kjui3;
                        zxep.kjui kjui4 = kjui3 = kjuiArray[i];
                        Object object2 = object;
                        Intrinsics.checkExpressionValueIsNotNull(kjui4._a, "it.position");
                        VecExtensionsKt.plusAssign((Vector3f)object2, vector3f8);
                    }
                    VecExtensionsKt.divAssign((Vector3f)object, (float)kjuiArray.length);
                    Object object3 = object;
                    float f2 = VecExtensionsKt.distance((Vector3f)object3, vector3f);
                    if (!(f2 < f)) continue block0;
                    f = f2;
                    vector3f4.set((ReadableVector3f)object3);
                    string = zxep2._l;
                    continue block0;
                }
                if (n == n2) continue block0;
                ++n;
            }
        }
        if (string != null) {
            Vec3 vec33 = VecExtensionsKt.toMc(vector3f4);
            String string2 = string;
            if (string2 == null) {
                Intrinsics.throwNpe();
            }
            return TuplesKt.to(vec33, string2);
        }
        return null;
    }

    static {
        _a = new KProperty[]{Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(eidj.class), "model", "getModel()Lgloomyfolken/mods/effects/common/mcsa/data/McsaModelData;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(eidj.class), "skeletonState", "getSkeletonState()Lgloomyfolken/mods/effects/common/mcsa/data/McsaSkeletonState;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(eidj.class), "animationContext", "getAnimationContext()Lgloomyfolken/mods/effects/common/mcsa/animation/AnimationContext;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(eidj.class), "skinnedMeshParts", "getSkinnedMeshParts()Ljava/util/Map;"))};
    }

    @Metadata(mv={1, 1, 7}, bv={1, 0, 2}, k=1, d1={"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0016\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u0016J\u0006\u0010\u0017\u001a\u00020\u0013R\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\t\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\bR\u0019\u0010\u000b\u001a\n \r*\u0004\u0018\u00010\f0\f\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011\u00a8\u0006\u0018"}, d2={"Lgloomyfolken/mods/weapon/trace/TraceMesh$TraceMeshPart;", "", "skinTarget", "Lgloomyfolken/mods/effects/common/mcsa/data/McsaMeshData;", "(Lgloomyfolken/mods/effects/common/mcsa/data/McsaMeshData;)V", "aabbMax", "Lorg/lwjgl/util/vector/Vector3f;", "getAabbMax", "()Lorg/lwjgl/util/vector/Vector3f;", "aabbMin", "getAabbMin", "bounds", "Lnet/minecraft/util/AxisAlignedBB;", "kotlin.jvm.PlatformType", "getBounds", "()Lnet/minecraft/util/AxisAlignedBB;", "getSkinTarget", "()Lgloomyfolken/mods/effects/common/mcsa/data/McsaMeshData;", "applySkinning", "", "mesh", "state", "Lgloomyfolken/mods/effects/common/mcsa/data/McsaSkeletonState;", "updateBounds", "minecraft"})
    public static final class kjui {
        private final AxisAlignedBB _a;
        @NotNull
        private final Vector3f _b;
        @NotNull
        private final Vector3f _c;
        @NotNull
        private final zxep _d;

        public final AxisAlignedBB _a() {
            return this._a;
        }

        @NotNull
        public final Vector3f _b() {
            return this._b;
        }

        @NotNull
        public final Vector3f _c() {
            return this._c;
        }

        public final void _a(@NotNull zxep zxep2, @NotNull ivtm ivtm2) {
            Intrinsics.checkParameterIsNotNull(zxep2, "mesh");
            Intrinsics.checkParameterIsNotNull(ivtm2, "state");
            zxep2._a(ivtm2, this._d);
        }

        public final void _d() {
            this._b.set(FloatCompanionObject.INSTANCE.getPOSITIVE_INFINITY(), FloatCompanionObject.INSTANCE.getPOSITIVE_INFINITY(), FloatCompanionObject.INSTANCE.getPOSITIVE_INFINITY());
            this._c.set(FloatCompanionObject.INSTANCE.getNEGATIVE_INFINITY(), FloatCompanionObject.INSTANCE.getNEGATIVE_INFINITY(), FloatCompanionObject.INSTANCE.getNEGATIVE_INFINITY());
            Object[] objectArray = this._d._b;
            for (int i = 0; i < objectArray.length; ++i) {
                Object object = objectArray[i];
                zxep.kjui kjui2 = (zxep.kjui)object;
                this._b.x = owkq._c(kjui2._a.x, this._b.x);
                this._b.y = owkq._c(kjui2._a.y, this._b.y);
                this._b.z = owkq._c(kjui2._a.z, this._b.z);
                this._c.x = owkq._d(kjui2._a.x, this._c.x);
                this._c.y = owkq._d(kjui2._a.y, this._c.y);
                this._c.z = owkq._d(kjui2._a.z, this._c.z);
            }
            McExtensionsKt.setMin(this._a, this._b);
            McExtensionsKt.setMax(this._a, this._c);
        }

        @NotNull
        public final zxep _e() {
            return this._d;
        }

        public kjui(@NotNull zxep zxep2) {
            Intrinsics.checkParameterIsNotNull(zxep2, "skinTarget");
            this._d = zxep2;
            this._a = McExtensionsKt.AxisAlignedBB();
            this._b = new Vector3f(FloatCompanionObject.INSTANCE.getPOSITIVE_INFINITY(), FloatCompanionObject.INSTANCE.getPOSITIVE_INFINITY(), FloatCompanionObject.INSTANCE.getPOSITIVE_INFINITY());
            this._c = new Vector3f(FloatCompanionObject.INSTANCE.getNEGATIVE_INFINITY(), FloatCompanionObject.INSTANCE.getNEGATIVE_INFINITY(), FloatCompanionObject.INSTANCE.getNEGATIVE_INFINITY());
        }
    }
}

