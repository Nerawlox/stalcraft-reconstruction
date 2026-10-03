/*
 * Decompiled with CFR 0.152.
 */
import net.minecraft.world.IBlockAccess;
import net.minecraftforge.fluids.BlockFluidBase;
import net.minecraftforge.fluids.RenderBlockFluidHook;

public class bqmn
extends RenderBlockFluidHook {
    public static bqmn _a = new bqmn();

    @Override
    public float getFluidHeightForRender(IBlockAccess iBlockAccess, int n, int n2, int n3, BlockFluidBase blockFluidBase) {
        return iBlockAccess.getBlockId(n, n2 + 1, n3) == blockFluidBase.blockID ? 1.0f : 0.1f;
    }

    @Override
    public int getRenderId() {
        return 264;
    }
}

