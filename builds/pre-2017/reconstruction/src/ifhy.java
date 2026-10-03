/*
 * Decompiled with CFR 0.152.
 */
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.EnumSkyBlock;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class ifhy
extends dgwv {
    public ifhy(int n) {
        super(n, "ice", Material._w, false);
        this.slipperiness = 0.98f;
        this.setTickRandomly(true);
        this.setCreativeTab(CreativeTabs.tabBlock);
    }

    @Override
    public int getRenderBlockPass() {
        return 1;
    }

    @Override
    public boolean shouldSideBeRendered(IBlockAccess iBlockAccess, int n, int n2, int n3, int n4) {
        return super.shouldSideBeRendered(iBlockAccess, n, n2, n3, 1 - n4);
    }

    @Override
    public void harvestBlock(World world, EntityPlayer entityPlayer, int n, int n2, int n3, int n4) {
        entityPlayer.addStat(dzif._C[this.blockID], 1);
        entityPlayer.addExhaustion(0.025f);
        if (this.canSilkHarvest() && zhty._d(entityPlayer)) {
            ItemStack itemStack = this.createStackedBlock(n4);
            if (itemStack != null) {
                this.dropBlockAsItem_do(world, n, n2, n3, itemStack);
            }
        } else {
            if (world.provider._f) {
                world.setBlockToAir(n, n2, n3);
                return;
            }
            int n5 = zhty._e(entityPlayer);
            this.dropBlockAsItem(world, n, n2, n3, n4, n5);
            Material material = world.getBlockMaterial(n, n2 - 1, n3);
            if (material._c() || material._d()) {
                world.setBlock(n, n2, n3, Block.waterMoving.blockID);
            }
        }
    }

    @Override
    public int quantityDropped(Random random) {
        return 0;
    }

    @Override
    public void updateTick(World world, int n, int n2, int n3, Random random) {
        if (world.getSavedLightValue(EnumSkyBlock._b, n, n2, n3) > 11 - Block.lightOpacity[this.blockID]) {
            if (world.provider._f) {
                world.setBlockToAir(n, n2, n3);
                return;
            }
            this.dropBlockAsItem(world, n, n2, n3, world.getBlockMetadata(n, n2, n3), 0);
            world.setBlock(n, n2, n3, Block.waterStill.blockID);
        }
    }

    @Override
    public int getMobilityFlag() {
        return 0;
    }
}

