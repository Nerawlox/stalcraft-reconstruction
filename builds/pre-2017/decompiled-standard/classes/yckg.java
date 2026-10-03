/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.mods.anomaly.qlgf;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={1, 1, 7}, bv={1, 0, 2}, k=1, d1={"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\b\u0010\u0007\u001a\u00020\u0003H\u0016J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016\u00a8\u0006\f"}, d2={"Lgloomyfolken/mods/anomaly/block/BlockTeleportSharedGlowing;", "Lgloomyfolken/mods/anomaly/block/BlockTeleportShared;", "par1", "", "drop", "Lgloomyfolken/mods/anomaly/RandomList;", "(ILgloomyfolken/mods/anomaly/RandomList;)V", "getRenderType", "registerIcons", "", "par1IconRegister", "Lnet/minecraft/client/renderer/texture/IconRegister;", "minecraft"})
public final class yckg
extends bqkn {
    @Override
    public void func_94332_a(@NotNull nege nege2) {
        Intrinsics.checkParameterIsNotNull(nege2, "par1IconRegister");
        this.field_94336_cN = nege2._b("anomalies:portal");
        this._b = nege2._b("anomalies:portal");
    }

    @Override
    public int func_71857_b() {
        return 0;
    }

    public yckg(int n, @NotNull qlgf qlgf2) {
        Intrinsics.checkParameterIsNotNull(qlgf2, "drop");
        super(n, qlgf2, "teleport_shared_glow");
    }
}

