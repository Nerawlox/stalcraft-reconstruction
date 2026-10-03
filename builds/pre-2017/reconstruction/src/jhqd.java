/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.mods.ktcore.McExtensionsKt;
import gloomyfolken.mods.ktcore.VecExtensionsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityClientPlayerMP;
import net.minecraft.util.Vec3;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={1, 1, 7}, bv={1, 0, 2}, k=1, d1={"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0014R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u000e\u0010\u000b\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0010"}, d2={"Lgloomyfolken/mods/effects/client/postprocess/effect/DeafnessEffect;", "Lgloomyfolken/mods/effects/client/postprocess/effect/GameEffect;", "pos", "Lnet/minecraft/util/Vec3;", "effectRange", "", "modPower", "", "(Lnet/minecraft/util/Vec3;DF)V", "getPos", "()Lnet/minecraft/util/Vec3;", "power", "execute", "", "manager", "Lgloomyfolken/mods/effects/client/postprocess/effect/GameEffectManager;", "minecraft"})
public final class jhqd
extends bqzs {
    private final double _a;
    @NotNull
    private final Vec3 _b;

    @Override
    protected void execute(@NotNull jysc jysc2) {
        Intrinsics.checkParameterIsNotNull(jysc2, "manager");
        float f = (float)this._a;
        if (f > 0.0f) {
            pkix pkix2 = Minecraft._E()._r;
            if (pkix2 != null) {
                pkix2.playSound(VecExtensionsKt.getX(this._b), VecExtensionsKt.getY(this._b), VecExtensionsKt.getZ(this._b), "gloomycore:deaf", 1.0f, 1.0f, false);
            }
            pkix pkix3 = Minecraft._E()._r;
            if (pkix3 != null) {
                pkix3.playSound(VecExtensionsKt.getX(this._b), VecExtensionsKt.getY(this._b), VecExtensionsKt.getZ(this._b), "gloomycore:deaf", 1.0f, 1.0f, false);
            }
            jysc2._a(2);
            jysc2._x(f);
        }
    }

    @NotNull
    public final Vec3 _a() {
        return this._b;
    }

    public jhqd(@NotNull Vec3 vec3, double d, float f) {
        Intrinsics.checkParameterIsNotNull(vec3, "pos");
        super(null, 1, null);
        this._b = vec3;
        EntityClientPlayerMP entityClientPlayerMP = Minecraft._E()._t;
        this._a = d / (entityClientPlayerMP != null ? McExtensionsKt.getDistanceToVector(entityClientPlayerMP, this._b) : 1.0);
    }

    public /* synthetic */ jhqd(Vec3 vec3, double d, float f, int n, DefaultConstructorMarker defaultConstructorMarker) {
        if ((n & 4) != 0) {
            f = 1.0f;
        }
        this(vec3, d, f);
    }
}

