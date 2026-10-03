/*
 * Decompiled with CFR 0.152.
 */
import net.minecraftforge.fluids.BlockFluidBase;
import net.minecraftforge.fluids.RenderBlockFluidHook;

public class bqmn
extends RenderBlockFluidHook {
    public static bqmn _a = new bqmn();

    @Override
    public float getFluidHeightForRender(sdrg sdrg2, int n, int n2, int n3, BlockFluidBase blockFluidBase) {
        return sdrg2.func_72798_a(n, n2 + 1, n3) == blockFluidBase.field_71990_ca ? 1.0f : 0.1f;
    }

    @Override
    public int getRenderId() {
        return 264;
    }
}

