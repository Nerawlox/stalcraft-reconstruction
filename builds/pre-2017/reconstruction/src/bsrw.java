/*
 * Decompiled with CFR 0.152.
 */
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.ItemStack;

public class bsrw
extends focs {
    public static final Block[] _a = new Block[]{Block.planks, Block.bookShelf, Block.wood, Block.chest, Block.stoneDoubleSlab, Block.stoneSingleSlab, Block.pumpkin, Block.pumpkinLantern};

    public bsrw(int n, txfz txfz2) {
        super(n, 3.0f, txfz2, _a);
    }

    @Override
    public float getStrVsBlock(ItemStack itemStack, Block block) {
        if (block != null && (block.blockMaterial == Material._d || block.blockMaterial == Material._k || block.blockMaterial == Material._l)) {
            return this._c;
        }
        return super.getStrVsBlock(itemStack, block);
    }
}

