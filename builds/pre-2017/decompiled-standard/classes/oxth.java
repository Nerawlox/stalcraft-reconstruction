/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.mods.effects.client.main.jxtc;
import gloomyfolken.mods.effects.client.main.zwaw;
import gloomyfolken.mods.ktcore.VecExtensionsKt;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import net.minecraft.util.ofbx;

@Metadata(mv={1, 1, 7}, bv={1, 0, 2}, k=1, d1={"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0007\u001a\u00020\bH\u0007R\u0016\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0006\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\t"}, d2={"Lgloomyfolken/mods/weapon/client/shader/ShaderNvdScope;", "Lgloomyfolken/mods/effects/client/main/Shader;", "()V", "nv_AddColor", "Lnet/minecraft/util/Vec3;", "kotlin.jvm.PlatformType", "nv_ScreenColor", "applyToScreen", "", "minecraft"})
public final class oxth
extends jxtc {
    private static final ofbx _d;
    private static final ofbx _e;
    public static final oxth _c;

    @JvmStatic
    public static final void _h() {
        if (zwaw._n()) {
            hsmn._e();
            zwaw._b(kjui._a);
            hsmn._f();
        }
    }

    private oxth() {
        super("weapons", "scope_nvd");
        _c = this;
        _d = VecExtensionsKt.vec3(0.025, 0.0875, 0.035);
        _e = VecExtensionsKt.vec3(0.44, 3.6, 0.72);
    }

    static {
        new oxth();
    }

    public static final /* synthetic */ ofbx _a(oxth oxth2) {
        oxth oxth3 = oxth2;
        return _d;
    }

    public static final /* synthetic */ ofbx _b(oxth oxth2) {
        oxth oxth3 = oxth2;
        return _e;
    }
}

