/*
 * Decompiled with CFR 0.152.
 */
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.BlockFluid;
import net.minecraft.block.material.Material;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class jznr
extends BlockFluid {
    public jznr(int n, Material material) {
        super(n, material);
        this.setTickRandomly(false);
        if (material == Material._i) {
            this.setTickRandomly(true);
        }
    }

    @Override
    public boolean getBlocksMovement(IBlockAccess iBlockAccess, int n, int n2, int n3) {
        return this.blockMaterial != Material._i;
    }

    @Override
    public void onNeighborBlockChange(World world, int n, int n2, int n3, int n4) {
        super.onNeighborBlockChange(world, n, n2, n3, n4);
        if (world.getBlockId(n, n2, n3) == this.blockID) {
            this._a(world, n, n2, n3);
        }
    }

    public void _a(World world, int n, int n2, int n3) {
        int n4 = world.getBlockMetadata(n, n2, n3);
        world.setBlock(n, n2, n3, this.blockID - 1, n4, 2);
        world.scheduleBlockUpdate(n, n2, n3, this.blockID - 1, this.tickRate(world));
    }

    @Override
    public void updateTick(World world, int n, int n2, int n3, Random random) {
        if (this.blockMaterial == Material._i) {
            int n4;
            int n5;
            int n6 = random.nextInt(3);
            for (n5 = 0; n5 < n6; ++n5) {
                n4 = world.getBlockId(n += random.nextInt(3) - 1, ++n2, n3 += random.nextInt(3) - 1);
                if (n4 == 0) {
                    if (!this._b(world, n - 1, n2, n3) && !this._b(world, n + 1, n2, n3) && !this._b(world, n, n2, n3 - 1) && !this._b(world, n, n2, n3 + 1) && !this._b(world, n, n2 - 1, n3) && !this._b(world, n, n2 + 1, n3)) continue;
                    world.setBlock(n, n2, n3, Block.fire.blockID);
                    return;
                }
                if (!Block.blocksList[n4].blockMaterial._c()) continue;
                return;
            }
            if (n6 == 0) {
                n5 = n;
                n4 = n3;
                for (int i = 0; i < 3; ++i) {
                    n = n5 + random.nextInt(3) - 1;
                    if (!world.isAirBlock(n, n2 + 1, n3 = n4 + random.nextInt(3) - 1) || !this._b(world, n, n2, n3)) continue;
                    world.setBlock(n, n2 + 1, n3, Block.fire.blockID);
                }
            }
        }
    }

    public boolean _b(World world, int n, int n2, int n3) {
        return world.getBlockMaterial(n, n2, n3)._h();
    }
}

