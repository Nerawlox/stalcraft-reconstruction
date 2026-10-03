/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.weapon.trace;

import gloomyfolken.mods.weapon.trace.eidj;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.entity.Entity;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={1, 1, 7}, bv={1, 0, 2}, k=1, d1={"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u0000 '2\u00020\u0001:\u0001'B\u000f\b\u0012\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004B\u000f\b\u0012\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\u0002\u0010\u0007B\u000f\b\u0012\u0012\u0006\u0010\b\u001a\u00020\t\u00a2\u0006\u0002\u0010\nJ\u0016\u0010$\u001a\u00020\u00002\u0006\u0010%\u001a\u00020\u001a2\u0006\u0010&\u001a\u00020\u001aR(\u0010\f\u001a\u0004\u0018\u00010\t2\b\u0010\u000b\u001a\u0004\u0018\u00010\t@BX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\nR$\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u0003@BX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0004R(\u0010\u0015\u001a\u0004\u0018\u00010\u00142\b\u0010\u000b\u001a\u0004\u0018\u00010\u0014@BX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R(\u0010\u001b\u001a\u0004\u0018\u00010\u001a2\b\u0010\u000b\u001a\u0004\u0018\u00010\u001a@BX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR(\u0010 \u001a\u0004\u0018\u00010\u00062\b\u0010\u000b\u001a\u0004\u0018\u00010\u0006@BX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010\u0007\u00a8\u0006("}, d2={"Lgloomyfolken/mods/weapon/trace/TraceResult;", "", "collision", "", "(Z)V", "mesh", "Lgloomyfolken/mods/weapon/trace/TraceMesh;", "(Lgloomyfolken/mods/weapon/trace/TraceMesh;)V", "entity", "Lnet/minecraft/entity/Entity;", "(Lnet/minecraft/entity/Entity;)V", "<set-?>", "aabbEntity", "getAabbEntity", "()Lnet/minecraft/entity/Entity;", "setAabbEntity", "hit", "getHit", "()Z", "setHit", "", "hitPartName", "getHitPartName", "()Ljava/lang/String;", "setHitPartName", "(Ljava/lang/String;)V", "Lnet/minecraft/util/Vec3;", "hitVec", "getHitVec", "()Lnet/minecraft/util/Vec3;", "setHitVec", "(Lnet/minecraft/util/Vec3;)V", "traceMesh", "getTraceMesh", "()Lgloomyfolken/mods/weapon/trace/TraceMesh;", "setTraceMesh", "trace", "start", "end", "Companion", "minecraft"})
public final class ugqx {
    private boolean _b;
    @Nullable
    private Vec3 _c;
    @Nullable
    private String _d;
    @Nullable
    private eidj _e;
    @Nullable
    private Entity _f;
    @NotNull
    private static final ugqx _g;
    @NotNull
    private static final ugqx _h;
    public static final kjui _a;

    public final boolean _a() {
        return this._b;
    }

    private final void _a(boolean bl) {
        this._b = bl;
    }

    @Nullable
    public final Vec3 _b() {
        return this._c;
    }

    private final void _a(Vec3 vec3) {
        this._c = vec3;
    }

    @Nullable
    public final String _c() {
        return this._d;
    }

    private final void _a(String string) {
        this._d = string;
    }

    @Nullable
    public final eidj _d() {
        return this._e;
    }

    private final void _b(eidj eidj2) {
        this._e = eidj2;
    }

    @Nullable
    public final Entity _e() {
        return this._f;
    }

    private final void _b(Entity entity) {
        this._f = entity;
    }

    @NotNull
    public final ugqx _a(@NotNull Vec3 vec3, @NotNull Vec3 vec32) {
        Intrinsics.checkParameterIsNotNull(vec3, "start");
        Intrinsics.checkParameterIsNotNull(vec32, "end");
        if (this._f != null) {
            Entity entity = this._f;
            if (entity == null) {
                Intrinsics.throwNpe();
            }
            MovingObjectPosition movingObjectPosition = entity.boundingBox._a(vec3, vec32);
            this._c = movingObjectPosition != null ? movingObjectPosition._h : null;
            this._b = this._c != null;
            this._d = "body";
        } else if (this._e != null) {
            Pair<Vec3, String> pair;
            eidj eidj2 = this._e;
            if (eidj2 == null) {
                Intrinsics.throwNpe();
            }
            this._b = (pair = eidj2._a(vec3, vec32)) != null;
            Pair<Vec3, String> pair2 = pair;
            this._c = pair2 != null ? pair2.getFirst() : null;
            Pair<Vec3, String> pair3 = pair;
            this._d = pair3 != null ? pair3.getSecond() : null;
        }
        return this;
    }

    private ugqx(boolean bl) {
        this._b = bl;
        if (bl) {
            this._d = "BODY";
        }
    }

    private ugqx(eidj eidj2) {
        this._e = eidj2;
    }

    private ugqx(Entity entity) {
        this._f = entity;
    }

    static {
        _a = new kjui(null);
        _g = new ugqx(true);
        _h = new ugqx(false);
    }

    public /* synthetic */ ugqx(@NotNull eidj eidj2, DefaultConstructorMarker defaultConstructorMarker) {
        this(eidj2);
    }

    public /* synthetic */ ugqx(@NotNull Entity entity, DefaultConstructorMarker defaultConstructorMarker) {
        this(entity);
    }

    @NotNull
    public static final ugqx _h() {
        return _a._b();
    }

    @NotNull
    public static final ugqx _i() {
        return _a._d();
    }

    @JvmStatic
    @NotNull
    public static final ugqx _a(@NotNull eidj eidj2) {
        Intrinsics.checkParameterIsNotNull(eidj2, "mesh");
        return _a._a(eidj2);
    }

    @JvmStatic
    @NotNull
    public static final ugqx _a(@NotNull Entity entity) {
        Intrinsics.checkParameterIsNotNull(entity, "entity");
        return _a._a(entity);
    }

    @Metadata(mv={1, 1, 7}, bv={1, 0, 2}, k=1, d1={"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\rH\u0007J\u0010\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u0010H\u0007R\u001c\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004\u00a2\u0006\u000e\n\u0000\u0012\u0004\b\u0005\u0010\u0002\u001a\u0004\b\u0006\u0010\u0007R\u001c\u0010\b\u001a\u00020\u00048\u0006X\u0087\u0004\u00a2\u0006\u000e\n\u0000\u0012\u0004\b\t\u0010\u0002\u001a\u0004\b\n\u0010\u0007\u00a8\u0006\u0011"}, d2={"Lgloomyfolken/mods/weapon/trace/TraceResult$Companion;", "", "()V", "FALSE", "Lgloomyfolken/mods/weapon/trace/TraceResult;", "FALSE$annotations", "getFALSE", "()Lgloomyfolken/mods/weapon/trace/TraceResult;", "TRUE", "TRUE$annotations", "getTRUE", "ON_AABB_HIT", "entity", "Lnet/minecraft/entity/Entity;", "ON_MESH_HIT", "mesh", "Lgloomyfolken/mods/weapon/trace/TraceMesh;", "minecraft"})
    public static final class kjui {
        @JvmStatic
        public static /* synthetic */ void _a() {
        }

        @NotNull
        public final ugqx _b() {
            return _g;
        }

        @JvmStatic
        public static /* synthetic */ void _c() {
        }

        @NotNull
        public final ugqx _d() {
            return _h;
        }

        @JvmStatic
        @NotNull
        public final ugqx _a(@NotNull eidj eidj2) {
            Intrinsics.checkParameterIsNotNull(eidj2, "mesh");
            return new ugqx(eidj2, null);
        }

        @JvmStatic
        @NotNull
        public final ugqx _a(@NotNull Entity entity) {
            Intrinsics.checkParameterIsNotNull(entity, "entity");
            return new ugqx(entity, null);
        }

        private kjui() {
        }

        public /* synthetic */ kjui(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }
}

