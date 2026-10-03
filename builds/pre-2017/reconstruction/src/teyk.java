/*
 * Decompiled with CFR 0.152.
 */
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={1, 1, 7}, bv={1, 0, 2}, k=2, d1={"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0010\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0002\u00a8\u0006\u0004"}, d2={"readProps", "Lgloomyfolken/mods/stalker/misc/sickness/BlockContamination$Props;", "item", "Lgloomyfolken/mods/core/configuration/ItemToAdd;", "minecraft"})
public final class teyk {
    private static final pjqv.pidb _b(rpaa rpaa2) {
        String string = rpaa2._h("effect_id");
        float f = rpaa2._j("effect_power");
        float f2 = rpaa2._j("effect_radius");
        String string2 = string;
        Intrinsics.checkExpressionValueIsNotNull(string2, "effectId");
        return new pjqv.pidb(string2, f, f2);
    }

    @NotNull
    public static final /* synthetic */ pjqv.pidb _a(@NotNull rpaa rpaa2) {
        return teyk._b(rpaa2);
    }
}

