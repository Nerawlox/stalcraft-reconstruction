/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs;

import gloomyfolken.mods.stalker.player.eidj;
import gloomyfolken.mods.stalker.player.zwat;
import gloomyfolken.mods.weapon.trace.qlgf;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={1, 1, 7}, bv={1, 0, 2}, k=1, d1={"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\nH\u0014J\u000e\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0006R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000e"}, d2={"Lnoppes/npcs/AnimationEntryNpcServer;", "Lgloomyfolken/mods/stalker/player/AnimationEntryModel;", "type", "Lgloomyfolken/mods/effects/common/mcsa/animation/AnimationLayer;", "(Lgloomyfolken/mods/effects/common/mcsa/animation/AnimationLayer;)V", "shotTracer", "Lgloomyfolken/mods/weapon/trace/TraceMeshBuilderNpc;", "getRenderer", "Lgloomyfolken/mods/stalker/player/IMeshRotation;", "boneName", "", "setRotationsSource", "", "traceInfo", "minecraft"})
public final class AnimationEntryNpcServer
extends eidj {
    private qlgf shotTracer;

    public final void setRotationsSource(@NotNull qlgf qlgf2) {
        Intrinsics.checkParameterIsNotNull(qlgf2, "traceInfo");
        this.shotTracer = qlgf2;
    }

    @Override
    @Nullable
    protected zwat getRenderer(@NotNull String string) {
        Intrinsics.checkParameterIsNotNull(string, "boneName");
        qlgf qlgf2 = this.shotTracer;
        if (qlgf2 == null) {
            throw (Throwable)new IllegalStateException("No rotation data source was specified for tracing an npc entity!");
        }
        qlgf qlgf3 = qlgf2;
        int n = ArraysKt.indexOf((Object[])qlgf3._h(), string);
        if (n < 0) {
            return null;
        }
        return qlgf3._i()[n];
    }

    public AnimationEntryNpcServer(@NotNull nuco nuco2) {
        Intrinsics.checkParameterIsNotNull(nuco2, "type");
        super(nuco2);
    }
}

