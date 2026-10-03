/*
 * Decompiled with CFR 0.152.
 */
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.ItemStack;

public class hufu
extends focs {
    public static final Block[] _a = new Block[]{Block.cobblestone, Block.stoneDoubleSlab, Block.stoneSingleSlab, Block.stone, Block.sandStone, Block.cobblestoneMossy, Block.oreIron, Block.blockIron, Block.oreCoal, Block.blockGold, Block.oreGold, Block.oreDiamond, Block.blockDiamond, Block.ice, Block.netherrack, Block.oreLapis, Block.blockLapis, Block.oreRedstone, Block.oreRedstoneGlowing, Block.rail, Block.railDetector, Block.railPowered, Block.railActivator};

    public hufu(int n, txfz txfz2) {
        super(n, 2.0f, txfz2, _a);
    }

    @Override
    public boolean canHarvestBlock(Block block) {
        if (block == Block.obsidian) {
            return this._e._d() == 3;
        }
        if (block == Block.blockDiamond || block == Block.oreDiamond) {
            return this._e._d() >= 2;
        }
        if (block == Block.oreEmerald || block == Block.blockEmerald) {
            return this._e._d() >= 2;
        }
        if (block == Block.blockGold || block == Block.oreGold) {
            return this._e._d() >= 2;
        }
        if (block == Block.blockIron || block == Block.oreIron) {
            return this._e._d() >= 1;
        }
        if (block == Block.blockLapis || block == Block.oreLapis) {
            return this._e._d() >= 1;
        }
        if (block == Block.oreRedstone || block == Block.oreRedstoneGlowing) {
            return this._e._d() >= 2;
        }
        if (block.blockMaterial == Material._e) {
            return true;
        }
        if (block.blockMaterial == Material._f) {
            return true;
        }
        return block.blockMaterial == Material._g;
    }

    @Override
    public float getStrVsBlock(ItemStack itemStack, Block block) {
        if (block != null && (block.blockMaterial == Material._f || block.blockMaterial == Material._g || block.blockMaterial == Material._e)) {
            return this._c;
        }
        return super.getStrVsBlock(itemStack, block);
    }
}

