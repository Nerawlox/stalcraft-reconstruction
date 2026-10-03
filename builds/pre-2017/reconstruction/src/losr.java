/*
 * Decompiled with CFR 0.152.
 */
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class losr
extends Block {
    public boolean _a;

    public losr(int n, boolean bl) {
        super(n, Material._e);
        if (bl) {
            this.setTickRandomly(true);
        }
        this._a = bl;
    }

    @Override
    public int tickRate(World world) {
        return 30;
    }

    @Override
    public void onBlockClicked(World world, int n, int n2, int n3, EntityPlayer entityPlayer) {
        this._a(world, n, n2, n3);
        super.onBlockClicked(world, n, n2, n3, entityPlayer);
    }

    @Override
    public void onEntityWalking(World world, int n, int n2, int n3, Entity entity) {
        this._a(world, n, n2, n3);
        super.onEntityWalking(world, n, n2, n3, entity);
    }

    @Override
    public boolean onBlockActivated(World world, int n, int n2, int n3, EntityPlayer entityPlayer, int n4, float f, float f2, float f3) {
        this._a(world, n, n2, n3);
        return super.onBlockActivated(world, n, n2, n3, entityPlayer, n4, f, f2, f3);
    }

    public void _a(World world, int n, int n2, int n3) {
        this._b(world, n, n2, n3);
        if (this.blockID == Block.oreRedstone.blockID) {
            world.setBlock(n, n2, n3, Block.oreRedstoneGlowing.blockID);
        }
    }

    @Override
    public void updateTick(World world, int n, int n2, int n3, Random random) {
        if (this.blockID == Block.oreRedstoneGlowing.blockID) {
            world.setBlock(n, n2, n3, Block.oreRedstone.blockID);
        }
    }

    @Override
    public int idDropped(int n, Random random, int n2) {
        return Item.redstone.itemID;
    }

    @Override
    public int quantityDroppedWithBonus(int n, Random random) {
        return this.quantityDropped(random) + random.nextInt(n + 1);
    }

    @Override
    public int quantityDropped(Random random) {
        return 4 + random.nextInt(2);
    }

    @Override
    public void dropBlockAsItemWithChance(World world, int n, int n2, int n3, int n4, float f, int n5) {
        super.dropBlockAsItemWithChance(world, n, n2, n3, n4, f, n5);
    }

    @Override
    public int getExpDrop(World world, int n, int n2) {
        if (this.idDropped(n, world.rand, n2) != this.blockID) {
            int n3 = 1 + world.rand.nextInt(5);
            return n3;
        }
        return 0;
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public void randomDisplayTick(World world, int n, int n2, int n3, Random random) {
        if (this._a) {
            this._b(world, n, n2, n3);
        }
    }

    public void _b(World world, int n, int n2, int n3) {
        Random random = world.rand;
        double d = 0.0625;
        for (int i = 0; i < 6; ++i) {
            double d2 = (float)n + random.nextFloat();
            double d3 = (float)n2 + random.nextFloat();
            double d4 = (float)n3 + random.nextFloat();
            if (i == 0 && !world.isBlockOpaqueCube(n, n2 + 1, n3)) {
                d3 = (double)(n2 + 1) + d;
            }
            if (i == 1 && !world.isBlockOpaqueCube(n, n2 - 1, n3)) {
                d3 = (double)(n2 + 0) - d;
            }
            if (i == 2 && !world.isBlockOpaqueCube(n, n2, n3 + 1)) {
                d4 = (double)(n3 + 1) + d;
            }
            if (i == 3 && !world.isBlockOpaqueCube(n, n2, n3 - 1)) {
                d4 = (double)(n3 + 0) - d;
            }
            if (i == 4 && !world.isBlockOpaqueCube(n + 1, n2, n3)) {
                d2 = (double)(n + 1) + d;
            }
            if (i == 5 && !world.isBlockOpaqueCube(n - 1, n2, n3)) {
                d2 = (double)(n + 0) - d;
            }
            if (!(d2 < (double)n || d2 > (double)(n + 1) || d3 < 0.0 || d3 > (double)(n2 + 1) || d4 < (double)n3) && !(d4 > (double)(n3 + 1))) continue;
            world.spawnParticle("reddust", d2, d3, d4, 0.0, 0.0, 0.0);
        }
    }

    @Override
    public ItemStack createStackedBlock(int n) {
        return new ItemStack(Block.oreRedstone);
    }
}

