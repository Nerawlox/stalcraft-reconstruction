/*
 * Decompiled with CFR 0.152.
 */
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={1, 1, 7}, bv={1, 0, 2}, k=1, d1={"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016\u00a8\u0006\t"}, d2={"Lgloomyfolken/mods/stalker/misc/loaders/ItemTypeContaminationWater;", "Lgloomyfolken/mods/core/configuration/ItemType;", "()V", "getName", "", "registerItem", "", "item", "Lgloomyfolken/mods/core/configuration/ItemToAdd;", "minecraft"})
public final class rpxp
extends mqrl {
    @Override
    @NotNull
    public String _a() {
        return "contamination_water";
    }

    @Override
    public void _b(@NotNull rpaa rpaa2) {
        Intrinsics.checkParameterIsNotNull(rpaa2, "item");
        pjqv.pidb pidb2 = teyk._a(rpaa2);
        String string = rpaa2._h("name");
        String string2 = pidb2._a()._b() + rpaa2._e;
        Fluid fluid = new Fluid(string2).setBlockID(rpaa2._e);
        FluidRegistry.registerFluid(fluid);
        int n = rpaa2._e;
        Fluid fluid2 = fluid;
        Intrinsics.checkExpressionValueIsNotNull(fluid2, "fluid");
        ndks ndks2 = new ndks(n, fluid2, pidb2);
        ndks2.func_71864_b(string2);
        GameRegistry.registerBlock((twgu)ndks2, string2);
        LanguageRegistry.addName(ndks2, string);
    }
}

