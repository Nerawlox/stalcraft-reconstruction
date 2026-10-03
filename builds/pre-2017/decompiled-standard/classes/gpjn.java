/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.mods.ktcore.McExtensionsKt;
import gloomyfolken.mods.ktcore.VecExtensionsKt;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.client.xpzm;
import net.minecraft.entity.Entity;
import net.minecraft.util.ofbx;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={1, 1, 7}, bv={1, 0, 2}, k=1, d1={"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001dB\u0005\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\nJ\u0006\u0010\u001c\u001a\u00020\u001aR\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u0019\u0010\t\u001a\n \u000b*\u0004\u0018\u00010\n0\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0016\u0010\u000e\u001a\n \u000b*\u0004\u0018\u00010\u000f0\u000fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0010\u001a\u00020\u0011X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0016\u001a\u00020\u0011X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0013\"\u0004\b\u0018\u0010\u0015\u00a8\u0006\u001e"}, d2={"Lgloomyfolken/mods/effects/client/postprocess/effect/CameraHelper;", "", "()V", "cameraLockEntity", "Lnet/minecraft/entity/Entity;", "getCameraLockEntity", "()Lnet/minecraft/entity/Entity;", "setCameraLockEntity", "(Lnet/minecraft/entity/Entity;)V", "cameraLockOffset", "Lnet/minecraft/util/Vec3;", "kotlin.jvm.PlatformType", "getCameraLockOffset", "()Lnet/minecraft/util/Vec3;", "mc", "Lnet/minecraft/client/Minecraft;", "shouldDisableMouse", "", "getShouldDisableMouse", "()Z", "setShouldDisableMouse", "(Z)V", "shouldDisableMovement", "getShouldDisableMovement", "setShouldDisableMovement", "makePlayerLookAt", "", "pos", "update", "Companion", "minecraft"})
public final class gpjn {
    private final xpzm _b = xpzm._E();
    private boolean _c;
    private boolean _d;
    @Nullable
    private Entity _e;
    private final ofbx _f = ofbx._a(0.0, 0.0, 0.0);
    public static final kjui _a = new kjui(null);

    public final boolean _a() {
        return this._c;
    }

    public final void _a(boolean bl) {
        this._c = bl;
    }

    public final boolean _b() {
        return this._d;
    }

    public final void _b(boolean bl) {
        this._d = bl;
    }

    @Nullable
    public final Entity _c() {
        return this._e;
    }

    public final void _a(@Nullable Entity entity) {
        this._e = entity;
    }

    public final ofbx _d() {
        return this._f;
    }

    public final void _e() {
        Entity entity = this._e;
        if (entity == null) {
            return;
        }
        Entity entity2 = entity;
        ofbx ofbx2 = McExtensionsKt.getPos(entity2);
        ofbx ofbx3 = this._f;
        Intrinsics.checkExpressionValueIsNotNull(ofbx3, "cameraLockOffset");
        this._a(VecExtensionsKt.addVector(ofbx2, ofbx3));
    }

    public final void _a(@NotNull ofbx ofbx2) {
        Intrinsics.checkParameterIsNotNull(ofbx2, "pos");
        if (this._b._t != null) {
            ofbx ofbx3 = McExtensionsKt.getPos(this._b._t);
            ofbx ofbx4 = VecExtensionsKt.subVector(ofbx2, ofbx3);
            ofbx ofbx5 = ofbx4._a();
            Intrinsics.checkExpressionValueIsNotNull(ofbx5, "direction.normalize()");
            ofbx4 = ofbx5;
            this._b._t.field_70126_B = this._b._t.field_70177_z;
            float f = ((float)Math.toDegrees(Math.atan2(ofbx4._e, ofbx4._c)) - 90.0f) % 360.0f;
            float f2 = (float)(-Math.toDegrees(Math.sin(ofbx4._d))) % 360.0f;
            double d = this._b._t.field_70177_z - f;
            double d2 = this._b._t.field_70125_A - f2;
            if (d < -180.0) {
                this._b._t.field_70126_B += 360.0f;
                this._b._t.field_71163_h += 360.0f;
                this._b._t.field_71154_f += 360.0f;
            }
            if (d >= 180.0) {
                this._b._t.field_70126_B -= 360.0f;
                this._b._t.field_71163_h -= 360.0f;
                this._b._t.field_71154_f -= 360.0f;
            }
            wnja._a(this._b._t);
            this._b._t.field_70177_z -= (float)d;
            this._b._t.field_70125_A -= (float)d2;
            wnja._b(this._b._t);
        }
    }

    @Nullable
    public static final gpjn _f() {
        return _a._b();
    }

    @Metadata(mv={1, 1, 7}, bv={1, 0, 2}, k=1, d1={"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00048FX\u0087\u0004\u00a2\u0006\f\u0012\u0004\b\u0005\u0010\u0002\u001a\u0004\b\u0006\u0010\u0007\u00a8\u0006\b"}, d2={"Lgloomyfolken/mods/effects/client/postprocess/effect/CameraHelper$Companion;", "", "()V", "instance", "Lgloomyfolken/mods/effects/client/postprocess/effect/CameraHelper;", "instance$annotations", "getInstance", "()Lgloomyfolken/mods/effects/client/postprocess/effect/CameraHelper;", "minecraft"})
    public static final class kjui {
        @JvmStatic
        public static /* synthetic */ void _a() {
        }

        @Nullable
        public final gpjn _b() {
            jysc jysc2 = jysc._b._a();
            return jysc2 != null ? jysc2._C() : null;
        }

        private kjui() {
        }

        public /* synthetic */ kjui(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }
}

