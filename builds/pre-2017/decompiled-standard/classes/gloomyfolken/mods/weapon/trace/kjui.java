/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.weapon.trace;

import gloomyfolken.mods.stalker.smplayer.eidj;
import gloomyfolken.mods.weapon.trace.jxtc;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={1, 1, 7}, bv={1, 0, 2}, k=1, d1={"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\nH\u0014J\u000e\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0006R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000e"}, d2={"Lgloomyfolken/mods/weapon/trace/AnimationEntrySmartmovingServer;", "Lgloomyfolken/mods/stalker/smplayer/AnimationEntrySmartmovingBase;", "type", "Lgloomyfolken/mods/effects/common/mcsa/animation/AnimationLayer;", "(Lgloomyfolken/mods/effects/common/mcsa/animation/AnimationLayer;)V", "shotTracer", "Lgloomyfolken/mods/weapon/trace/TraceMeshBuilderPlayer;", "getSmartRotation", "Lgloomyfolken/mods/stalker/smplayer/ISmartMeshRotation;", "boneName", "", "setRotationsSource", "", "traceInfo", "minecraft"})
public final class kjui
extends gloomyfolken.mods.stalker.smplayer.kjui {
    private jxtc _b;

    public final void _a(@NotNull jxtc jxtc2) {
        Intrinsics.checkParameterIsNotNull(jxtc2, "traceInfo");
        this._b = jxtc2;
    }

    @Override
    @Nullable
    protected eidj _a(@NotNull String string) {
        Intrinsics.checkParameterIsNotNull(string, "boneName");
        jxtc jxtc2 = this._b;
        if (jxtc2 == null) {
            throw (Throwable)new IllegalStateException("No rotation data source was specified for tracing a player entity!");
        }
        jxtc jxtc3 = jxtc2;
        int n = ArraysKt.indexOf((Object[])jxtc3._h(), string);
        if (n < 0) {
            return null;
        }
        return jxtc3._i()[n];
    }

    public kjui(@NotNull nuco nuco2) {
        Intrinsics.checkParameterIsNotNull(nuco2, "type");
        super(nuco2);
    }
}

