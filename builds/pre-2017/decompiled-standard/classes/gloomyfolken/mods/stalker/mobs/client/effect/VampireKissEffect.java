/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.stalker.mobs.client.effect;

import gloomyfolken.mods.ktcore.VecExtensionsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.util.ofbx;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={1, 1, 7}, bv={1, 0, 2}, k=1, d1={"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0016\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0014J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\bH\u0014J\u0010\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0002J\u0010\u0010\f\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0014\u00a8\u0006\r"}, d2={"Lgloomyfolken/mods/stalker/mobs/client/effect/VampireKissEffect;", "Lgloomyfolken/mods/effects/client/postprocess/effect/GameEffect;", "id", "", "(Ljava/lang/String;)V", "execute", "", "manager", "Lgloomyfolken/mods/effects/client/postprocess/effect/GameEffectManager;", "shouldEffectStop", "", "simulateBloodsuckEffect", "update", "minecraft"})
public class VampireKissEffect
extends bqzs {
    @Override
    protected void execute(@NotNull jysc jysc2) {
        Intrinsics.checkParameterIsNotNull(jysc2, "manager");
        jysc jysc3 = jysc2;
        jysc3._c(owkq._d(jysc3._c(), 128.0));
        jysc3._b(owkq._d(jysc3._b(), 128.0));
        this.simulateBloodsuckEffect(jysc2);
    }

    @Override
    protected void update(@NotNull jysc jysc2) {
        Intrinsics.checkParameterIsNotNull(jysc2, "manager");
        this.simulateBloodsuckEffect(jysc2);
    }

    private final void simulateBloodsuckEffect(jysc jysc2) {
        ofbx ofbx2 = jysc._a(jysc2, 0.0, 1, null);
        jysc jysc3 = jysc2;
        VecExtensionsKt.set(jysc3._C()._d(), 0.0, 1.85, 0.0);
        jysc jysc4 = jysc3;
        jysc4._c(jysc4._c() - 128.0 * VecExtensionsKt.getX(ofbx2));
        jysc jysc5 = jysc3;
        jysc5._b(jysc5._b() - 128.0 * VecExtensionsKt.getY(ofbx2));
        jysc3._x(owkq._d(jysc3._A(), 0.15));
        jysc3._e(owkq._d(jysc3._e(), 4.5));
        jysc3._f(owkq._d(jysc3._f(), 0.195));
        jysc3._d(owkq._d(jysc3._d(), 1.8));
        jysc3._l(owkq._d(jysc3._n(), 0.8));
        jysc3._h(owkq._d(jysc3._h(), 0.1));
    }

    @Override
    protected boolean shouldEffectStop(@NotNull jysc jysc2) {
        Intrinsics.checkParameterIsNotNull(jysc2, "manager");
        return false;
    }

    public VampireKissEffect(@Nullable String string) {
        super(string);
    }
}

