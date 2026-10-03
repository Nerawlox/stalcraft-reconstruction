/*
 * Decompiled with CFR 0.152.
 */
import cpw.mods.fml.common.registry.GameRegistry;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={1, 1, 7}, bv={1, 0, 2}, k=1, d1={"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016\u00a8\u0006\t"}, d2={"Lgloomyfolken/mods/stalker/misc/loaders/ItemTypeContaminationBlock;", "Lgloomyfolken/mods/core/configuration/ItemType;", "()V", "getName", "", "registerItem", "", "item", "Lgloomyfolken/mods/core/configuration/ItemToAdd;", "minecraft"})
public final class gpya
extends mqrl {
    @Override
    @NotNull
    public String _a() {
        return "contamination";
    }

    @Override
    public void _b(@NotNull rpaa rpaa2) {
        Intrinsics.checkParameterIsNotNull(rpaa2, "item");
        pjqv.pidb pidb2 = teyk._a(rpaa2);
        String string = rpaa2._h("icon");
        String string2 = rpaa2._h("name");
        int n = rpaa2._e;
        String string3 = string;
        Intrinsics.checkExpressionValueIsNotNull(string3, "iconName");
        String string4 = string2;
        Intrinsics.checkExpressionValueIsNotNull(string4, "localizedName");
        pjqv pjqv2 = new pjqv(n, string3, string4, pidb2);
        GameRegistry.registerBlock((twgu)pjqv2, "contamination" + rpaa2._e);
    }
}

