/*
 * Decompiled with CFR 0.152.
 */
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.util.Icon;
import net.minecraft.world.IBlockAccess;
import net.minecraftforge.fluids.BlockFluidClassic;
import net.minecraftforge.fluids.Fluid;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={1, 1, 7}, bv={1, 0, 2}, k=1, d1={"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ(\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u0003H\u0017J\b\u0010\u000f\u001a\u00020\u0003H\u0017J \u0010\u0010\u001a\n \u0012*\u0004\u0018\u00010\u00110\u00112\u0006\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u0003H\u0016\u00a8\u0006\u0015"}, d2={"Lgloomyfolken/mods/stalker/misc/sickness/BlockContaminationWater;", "Lnet/minecraftforge/fluids/BlockFluidClassic;", "id", "", "fluid", "Lnet/minecraftforge/fluids/Fluid;", "props", "Lgloomyfolken/mods/stalker/misc/sickness/BlockContamination$Props;", "(ILnet/minecraftforge/fluids/Fluid;Lgloomyfolken/mods/stalker/misc/sickness/BlockContamination$Props;)V", "colorMultiplier", "world", "Lnet/minecraft/world/IBlockAccess;", "x", "y", "z", "getBlockColor", "getIcon", "Lnet/minecraft/util/Icon;", "kotlin.jvm.PlatformType", "side", "meta", "minecraft"})
public final class ndks
extends BlockFluidClassic {
    @Override
    public Icon getIcon(int n, int n2) {
        return Block.waterStill.getIcon(n, n2);
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public int getBlockColor() {
        return Block.waterStill.getBlockColor();
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public int colorMultiplier(@NotNull IBlockAccess iBlockAccess, int n, int n2, int n3) {
        Intrinsics.checkParameterIsNotNull(iBlockAccess, "world");
        return Block.waterStill.colorMultiplier(iBlockAccess, n, n2, n3);
    }

    public ndks(int n, @NotNull Fluid fluid, @NotNull pjqv.pidb pidb2) {
        Intrinsics.checkParameterIsNotNull(fluid, "fluid");
        Intrinsics.checkParameterIsNotNull(pidb2, "props");
        super(n, fluid, Material._h);
        this.setLightOpacity(3);
        this.setHardness(100.0f);
        pjqv._a._a(this.blockID, pidb2);
    }
}

