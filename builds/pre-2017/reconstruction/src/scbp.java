/*
 * Decompiled with CFR 0.152.
 */
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.BlockFlower;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class scbp
extends BlockFlower {
    public scbp(int n) {
        super(n, Material._l);
        float f = 0.4f;
        this.setBlockBounds(0.5f - f, 0.0f, 0.5f - f, 0.5f + f, 0.8f, 0.5f + f);
    }

    @Override
    public boolean _a(int n) {
        return n == Block.sand.blockID;
    }

    @Override
    public int idDropped(int n, Random random, int n2) {
        return -1;
    }

    @Override
    public void harvestBlock(World world, EntityPlayer entityPlayer, int n, int n2, int n3, int n4) {
        if (!world.isRemote && entityPlayer.getCurrentEquippedItem() != null && entityPlayer.getCurrentEquippedItem()._d == Item.shears.itemID) {
            entityPlayer.addStat(dzif._C[this.blockID], 1);
            this.dropBlockAsItem_do(world, n, n2, n3, new ItemStack(Block.deadBush, 1, n4));
        } else {
            super.harvestBlock(world, entityPlayer, n, n2, n3, n4);
        }
    }
}

