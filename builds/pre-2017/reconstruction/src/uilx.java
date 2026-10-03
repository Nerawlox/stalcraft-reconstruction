/*
 * Decompiled with CFR 0.152.
 */
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.item.EntityFallingSand;
import net.minecraft.world.World;

public class uilx
extends Block {
    public static boolean _e;

    public uilx(int n) {
        super(n, Material._p);
        this.setCreativeTab(CreativeTabs.tabBlock);
    }

    public uilx(int n, Material material) {
        super(n, material);
    }

    @Override
    public void onBlockAdded(World world, int n, int n2, int n3) {
        world.scheduleBlockUpdate(n, n2, n3, this.blockID, this.tickRate(world));
    }

    @Override
    public void onNeighborBlockChange(World world, int n, int n2, int n3, int n4) {
        world.scheduleBlockUpdate(n, n2, n3, this.blockID, this.tickRate(world));
    }

    @Override
    public void updateTick(World world, int n, int n2, int n3, Random random) {
        if (!world.isRemote) {
            this._a(world, n, n2, n3);
        }
    }

    public void _a(World world, int n, int n2, int n3) {
        if (uilx._b(world, n, n2 - 1, n3) && n2 >= 0) {
            int n4 = 32;
            if (!_e && world.checkChunksExist(n - n4, n2 - n4, n3 - n4, n + n4, n2 + n4, n3 + n4)) {
                if (!world.isRemote) {
                    EntityFallingSand entityFallingSand = new EntityFallingSand(world, (float)n + 0.5f, (float)n2 + 0.5f, (float)n3 + 0.5f, this.blockID, world.getBlockMetadata(n, n2, n3));
                    this._a(entityFallingSand);
                    world.spawnEntityInWorld(entityFallingSand);
                }
            } else {
                world.setBlockToAir(n, n2, n3);
                while (uilx._b(world, n, n2 - 1, n3) && n2 > 0) {
                    --n2;
                }
                if (n2 > 0) {
                    world.setBlock(n, n2, n3, this.blockID);
                }
            }
        }
    }

    public void _a(EntityFallingSand entityFallingSand) {
    }

    @Override
    public int tickRate(World world) {
        return 2;
    }

    public static boolean _b(World world, int n, int n2, int n3) {
        int n4 = world.getBlockId(n, n2, n3);
        if (world.isAirBlock(n, n2, n3)) {
            return true;
        }
        if (n4 == Block.fire.blockID) {
            return true;
        }
        Material material = Block.blocksList[n4].blockMaterial;
        return material == Material._h ? true : material == Material._i;
    }

    public void _a(World world, int n, int n2, int n3, int n4) {
    }
}

