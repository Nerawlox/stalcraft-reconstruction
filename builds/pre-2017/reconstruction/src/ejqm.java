/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.bundle.common.core.eidj;
import gloomyfolken.bundle.common.core.ezey;
import gloomyfolken.mods.stalker.misc.tupg;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import net.minecraft.entity.player.EntityPlayer;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={1, 1, 7}, bv={1, 0, 2}, k=1, d1={"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u00012B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u000e\u0010(\u001a\u00020)2\u0006\u0010\t\u001a\u00020\bJ\u000e\u0010*\u001a\u00020)2\u0006\u0010\u001d\u001a\u00020\bJ\b\u0010+\u001a\u00020\bH\u0002J\u0010\u0010,\u001a\u00020)2\u0006\u0010-\u001a\u00020.H\u0007J\u0018\u0010/\u001a\u00020)2\u0006\u0010\u001d\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bH\u0007J\b\u00100\u001a\u00020)H\u0007J\u0010\u00101\u001a\u00020)2\u0006\u0010-\u001a\u00020.H\u0007R$\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\b@BX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u0011\u0010\u000e\u001a\u00020\u000f8F\u00a2\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0011\u0010\u0014\u001a\u00020\u00138F\u00a2\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0017\u001a\u00020\u00188F\u00a2\u0006\u0006\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR$\u0010\u001d\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\b@BX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u000b\"\u0004\b\u001f\u0010\rR\u000e\u0010 \u001a\u00020\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0011\u0010!\u001a\u00020\"8F\u00a2\u0006\u0006\u001a\u0004\b#\u0010$R\u000e\u0010%\u001a\u00020\u0013X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b&\u0010'\u00a8\u00063"}, d2={"Lgloomyfolken/mods/stalker/misc/sickness/Sickness;", "", "type", "Lgloomyfolken/mods/stalker/misc/sickness/SicknessType;", "player", "Lnet/minecraft/entity/player/EntityPlayer;", "(Lgloomyfolken/mods/stalker/misc/sickness/SicknessType;Lnet/minecraft/entity/player/EntityPlayer;)V", "<set-?>", "", "addedPower", "getAddedPower", "()F", "setAddedPower", "(F)V", "artefaktProps", "Lgloomyfolken/mods/stalker/misc/item/ArtefaktProperties;", "getArtefaktProps", "()Lgloomyfolken/mods/stalker/misc/item/ArtefaktProperties;", "damageCooldown", "", "damageLevel", "getDamageLevel", "()I", "name", "", "getName", "()Ljava/lang/String;", "getPlayer", "()Lnet/minecraft/entity/player/EntityPlayer;", "power", "getPower", "setPower", "powerToAdd", "props", "Lgloomyfolken/mods/stalker/misc/sickness/Sickness$Props;", "getProps", "()Lgloomyfolken/mods/stalker/misc/sickness/Sickness$Props;", "timer", "getType", "()Lgloomyfolken/mods/stalker/misc/sickness/SicknessType;", "addPower", "", "addPowerDirectly", "getDamage", "readNBT", "tag", "Lnet/minecraft/nbt/NBTTagCompound;", "setPowerClient", "tick", "writeNBT", "Props", "minecraft"})
public final class ejqm {
    private float _a;
    private float _b;
    private int _c;
    private float _d;
    private int _e;
    @NotNull
    private final klcb _f;
    @NotNull
    private final EntityPlayer _g;

    @NotNull
    public final kjui _a() {
        return this._f._a();
    }

    @NotNull
    public final String _b() {
        return this._a()._a();
    }

    public final float _c() {
        return this._a;
    }

    private final void _c(float f) {
        this._a = f;
    }

    public final float _d() {
        return this._b;
    }

    private final void _d(float f) {
        this._b = f;
    }

    public final int _e() {
        Object v0;
        block1: {
            Iterable iterable = RangesKt.downTo(this._a()._b().length, 1);
            for (Object t : iterable) {
                int n = ((Number)t).intValue();
                if (!(this._a > this._a()._b()[n - 1])) continue;
                v0 = t;
                break block1;
            }
            v0 = null;
        }
        Integer n = v0;
        return n != null ? n : 0;
    }

    @NotNull
    public final xafi _f() {
        xafi xafi2 = tupg._a((EntityPlayer)this._g)._d;
        Intrinsics.checkExpressionValueIsNotNull(xafi2, "StalkerHandler.getHandle\u2026layer).artefaktProperties");
        return xafi2;
    }

    public final void _a(float f) {
        float f2 = 1.0f - ((Number)this._f._d().invoke(this._f())).floatValue() / 100.0f;
        this._d = Math.max(f * f2, this._d);
        if (this._d > 0.0f) {
            this._e = this._a()._h();
        }
    }

    public final void _b(float f) {
        this._a += f;
    }

    private final float _i() {
        return this._a()._c()[this._e()];
    }

    @ezey(_a={eidj.CLIENT})
    public final void _a(float f, float f2) {
        this._a = f;
        this._b = f2;
    }

    @NotNull
    public final klcb _g() {
        return this._f;
    }

    @NotNull
    public final EntityPlayer _h() {
        return this._g;
    }

    public ejqm(@NotNull klcb klcb2, @NotNull EntityPlayer entityPlayer) {
        Intrinsics.checkParameterIsNotNull((Object)klcb2, "type");
        Intrinsics.checkParameterIsNotNull(entityPlayer, "player");
        this._f = klcb2;
        this._g = entityPlayer;
        this._c = this._a()._g();
    }

    @Metadata(mv={1, 1, 7}, bv={1, 0, 2}, k=1, d1={"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0014\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u000f\u0018\u00002\u00020\u0001BE\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\n\u001a\u00020\b\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\f\u00a2\u0006\u0002\u0010\u000eR\u0011\u0010\u000b\u001a\u00020\f\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\t\u001a\u00020\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0007\u001a\u00020\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0006\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0015R\u0011\u0010\n\u001a\u00020\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0012R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\r\u001a\u00020\f\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0010\u00a8\u0006\u001b"}, d2={"Lgloomyfolken/mods/stalker/misc/sickness/Sickness$Props;", "", "name", "", "levelBounds", "", "levelDamage", "decreaseSpeed", "", "decreaseFactor", "maxPower", "damageCooldown", "", "resetTicks", "(Ljava/lang/String;[F[FFFFII)V", "getDamageCooldown", "()I", "getDecreaseFactor", "()F", "getDecreaseSpeed", "getLevelBounds", "()[F", "getLevelDamage", "getMaxPower", "getName", "()Ljava/lang/String;", "getResetTicks", "minecraft"})
    public static final class kjui {
        @NotNull
        private final String _a;
        @NotNull
        private final float[] _b;
        @NotNull
        private final float[] _c;
        private final float _d;
        private final float _e;
        private final float _f;
        private final int _g;
        private final int _h;

        @NotNull
        public final String _a() {
            return this._a;
        }

        @NotNull
        public final float[] _b() {
            return this._b;
        }

        @NotNull
        public final float[] _c() {
            return this._c;
        }

        public final float _d() {
            return this._d;
        }

        public final float _e() {
            return this._e;
        }

        public final float _f() {
            return this._f;
        }

        public final int _g() {
            return this._g;
        }

        public final int _h() {
            return this._h;
        }

        public kjui(@NotNull String string, @NotNull float[] fArray, @NotNull float[] fArray2, float f, float f2, float f3, int n, int n2) {
            Intrinsics.checkParameterIsNotNull(string, "name");
            Intrinsics.checkParameterIsNotNull(fArray, "levelBounds");
            Intrinsics.checkParameterIsNotNull(fArray2, "levelDamage");
            this._a = string;
            this._b = fArray;
            this._c = fArray2;
            this._d = f;
            this._e = f2;
            this._f = f3;
            this._g = n;
            this._h = n2;
            if (this._b.length + 1 != this._c.length) {
                throw (Throwable)new IllegalArgumentException();
            }
        }
    }
}

