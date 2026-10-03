/*
 * Decompiled with CFR 0.152.
 */
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.Collection;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={1, 1, 7}, bv={1, 0, 2}, k=1, d1={"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0016\u00a2\u0006\u0002\u0010\u0002B\u001b\b\u0016\u0012\u0012\u0010\u0003\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00050\u0004\"\u00020\u0005\u00a2\u0006\u0002\u0010\u0006R&\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\u00050\bj\b\u0012\u0004\u0012\u00020\u0005`\t8\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b\u00a8\u0006\f"}, d2={"Lgloomyfolken/mods/stalker/misc/client/particle/artefacts/ArtefaktEffectPreset;", "", "()V", "emitterSettings", "", "Lgloomyfolken/mods/stalker/misc/client/particle/artefacts/ArtefaktEmitterSettings;", "([Lgloomyfolken/mods/stalker/misc/client/particle/artefacts/ArtefaktEmitterSettings;)V", "emitterList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getEmitterList", "()Ljava/util/ArrayList;", "minecraft"})
public final class zgiu {
    @SerializedName(value="emitters")
    @NotNull
    private final ArrayList<ogjh> _a;

    @NotNull
    public final ArrayList<ogjh> _a() {
        return this._a;
    }

    public zgiu() {
        zgiu zgiu2 = this;
        ArrayList arrayList = new ArrayList();
        zgiu2._a = arrayList;
    }

    public zgiu(ogjh ... ogjhArray) {
        Intrinsics.checkParameterIsNotNull(ogjhArray, "emitterSettings");
        zgiu zgiu2 = this;
        ArrayList arrayList = new ArrayList();
        zgiu2._a = arrayList;
        CollectionsKt.addAll((Collection)this._a, (Object[])ogjhArray);
    }
}

