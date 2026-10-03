/*
 * Decompiled with CFR 0.152.
 */
package net.minecraftforge.fluids;

import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fluids.BlockFluidBase;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidStack;

public class BlockFluidFinite
extends BlockFluidBase {
    public BlockFluidFinite(int n, Fluid fluid, Material material) {
        super(n, fluid, material);
    }

    @Override
    public int getQuantaValue(IBlockAccess iBlockAccess, int n, int n2, int n3) {
        if (iBlockAccess.isAirBlock(n, n2, n3)) {
            return 0;
        }
        if (iBlockAccess.getBlockId(n, n2, n3) != this.blockID) {
            return -1;
        }
        int n4 = iBlockAccess.getBlockMetadata(n, n2, n3) + 1;
        return n4;
    }

    @Override
    public boolean canCollideCheck(int n, boolean bl) {
        return bl && n == this.quantaPerBlock - 1;
    }

    @Override
    public int getMaxRenderHeightMeta() {
        return this.quantaPerBlock - 1;
    }

    @Override
    public void updateTick(World world, int n, int n2, int n3, Random random) {
        int n4;
        int n5;
        boolean bl = false;
        int n6 = n5 = world.getBlockMetadata(n, n2, n3) + 1;
        if ((n5 = this.tryToFlowVerticallyInto(world, n, n2, n3, n5)) < 1) {
            return;
        }
        if (n5 != n6) {
            bl = true;
            if (n5 == 1) {
                world.func_72921_c(n, n2, n3, n5 - 1, 2);
                return;
            }
        } else if (n5 == 1) {
            return;
        }
        int n7 = n5 - 1;
        if (this.displaceIfPossible(world, n, n2, n3 - 1)) {
            world.setBlock(n, n2, n3 - 1, 0);
        }
        if (this.displaceIfPossible(world, n, n2, n3 + 1)) {
            world.setBlock(n, n2, n3 + 1, 0);
        }
        if (this.displaceIfPossible(world, n - 1, n2, n3)) {
            world.setBlock(n - 1, n2, n3, 0);
        }
        if (this.displaceIfPossible(world, n + 1, n2, n3)) {
            world.setBlock(n + 1, n2, n3, 0);
        }
        int n8 = this.getQuantaValueBelow(world, n, n2, n3 - 1, n7);
        int n9 = this.getQuantaValueBelow(world, n, n2, n3 + 1, n7);
        int n10 = this.getQuantaValueBelow(world, n - 1, n2, n3, n7);
        int n11 = this.getQuantaValueBelow(world, n + 1, n2, n3, n7);
        int n12 = n5;
        int n13 = 1;
        if (n8 >= 0) {
            ++n13;
            n12 += n8;
        }
        if (n9 >= 0) {
            ++n13;
            n12 += n9;
        }
        if (n10 >= 0) {
            ++n13;
            n12 += n10;
        }
        if (n11 >= 0) {
            ++n13;
            n12 += n11;
        }
        if (n13 == 1) {
            if (bl) {
                world.func_72921_c(n, n2, n3, n5 - 1, 2);
            }
            return;
        }
        int n14 = n12 / n13;
        int n15 = n12 % n13;
        if (n8 >= 0) {
            n4 = n14;
            if (n15 == n13 || n15 > 1 && random.nextInt(n13 - n15) != 0) {
                ++n4;
                --n15;
            }
            if (n4 != n8) {
                if (n4 == 0) {
                    world.setBlock(n, n2, n3 - 1, 0);
                } else {
                    world.setBlock(n, n2, n3 - 1, this.blockID, n4 - 1, 2);
                }
                world.scheduleBlockUpdate(n, n2, n3 - 1, this.blockID, this.tickRate);
            }
            --n13;
        }
        if (n9 >= 0) {
            n4 = n14;
            if (n15 == n13 || n15 > 1 && random.nextInt(n13 - n15) != 0) {
                ++n4;
                --n15;
            }
            if (n4 != n9) {
                if (n4 == 0) {
                    world.setBlock(n, n2, n3 + 1, 0);
                } else {
                    world.setBlock(n, n2, n3 + 1, this.blockID, n4 - 1, 2);
                }
                world.scheduleBlockUpdate(n, n2, n3 + 1, this.blockID, this.tickRate);
            }
            --n13;
        }
        if (n10 >= 0) {
            n4 = n14;
            if (n15 == n13 || n15 > 1 && random.nextInt(n13 - n15) != 0) {
                ++n4;
                --n15;
            }
            if (n4 != n10) {
                if (n4 == 0) {
                    world.setBlock(n - 1, n2, n3, 0);
                } else {
                    world.setBlock(n - 1, n2, n3, this.blockID, n4 - 1, 2);
                }
                world.scheduleBlockUpdate(n - 1, n2, n3, this.blockID, this.tickRate);
            }
            --n13;
        }
        if (n11 >= 0) {
            n4 = n14;
            if (n15 == n13 || n15 > 1 && random.nextInt(n13 - n15) != 0) {
                ++n4;
                --n15;
            }
            if (n4 != n11) {
                if (n4 == 0) {
                    world.setBlock(n + 1, n2, n3, 0);
                } else {
                    world.setBlock(n + 1, n2, n3, this.blockID, n4 - 1, 2);
                }
                world.scheduleBlockUpdate(n + 1, n2, n3, this.blockID, this.tickRate);
            }
            --n13;
        }
        if (n15 > 0) {
            ++n14;
        }
        world.func_72921_c(n, n2, n3, n14 - 1, 2);
    }

    public int tryToFlowVerticallyInto(World world, int n, int n2, int n3, int n4) {
        int n5 = n2 + this.densityDir;
        if (n5 < 0 || n5 >= world.getHeight()) {
            world.setBlockToAir(n, n2, n3);
            return 0;
        }
        int n6 = this.getQuantaValueBelow(world, n, n5, n3, this.quantaPerBlock);
        if (n6 >= 0) {
            if ((n6 += n4) > this.quantaPerBlock) {
                world.setBlock(n, n5, n3, this.blockID, this.quantaPerBlock - 1, 3);
                world.scheduleBlockUpdate(n, n5, n3, this.blockID, this.tickRate);
                return n6 - this.quantaPerBlock;
            }
            if (n6 > 0) {
                world.setBlock(n, n5, n3, this.blockID, n6 - 1, 3);
                world.scheduleBlockUpdate(n, n5, n3, this.blockID, this.tickRate);
                world.setBlockToAir(n, n2, n3);
                return 0;
            }
            return n4;
        }
        int n7 = BlockFluidFinite.getDensity(world, n, n5, n3);
        if (n7 == Integer.MAX_VALUE) {
            if (this.displaceIfPossible(world, n, n5, n3)) {
                world.setBlock(n, n5, n3, this.blockID, n4 - 1, 3);
                world.scheduleBlockUpdate(n, n5, n3, this.blockID, this.tickRate);
                world.setBlockToAir(n, n2, n3);
                return 0;
            }
            return n4;
        }
        if (this.densityDir < 0) {
            if (n7 < this.density) {
                int n8 = world.getBlockId(n, n5, n3);
                BlockFluidBase blockFluidBase = (BlockFluidBase)Block.blocksList[n8];
                int n9 = world.getBlockMetadata(n, n5, n3);
                world.setBlock(n, n5, n3, this.blockID, n4 - 1, 3);
                world.setBlock(n, n2, n3, n8, n9, 3);
                world.scheduleBlockUpdate(n, n5, n3, this.blockID, this.tickRate);
                world.scheduleBlockUpdate(n, n2, n3, n8, blockFluidBase.tickRate(world));
                return 0;
            }
        } else if (n7 > this.density) {
            int n10 = world.getBlockId(n, n5, n3);
            BlockFluidBase blockFluidBase = (BlockFluidBase)Block.blocksList[n10];
            int n11 = world.getBlockMetadata(n, n5, n3);
            world.setBlock(n, n5, n3, this.blockID, n4 - 1, 3);
            world.setBlock(n, n2, n3, n10, n11, 3);
            world.scheduleBlockUpdate(n, n5, n3, this.blockID, this.tickRate);
            world.scheduleBlockUpdate(n, n2, n3, n10, blockFluidBase.tickRate(world));
            return 0;
        }
        return n4;
    }

    @Override
    public FluidStack drain(World world, int n, int n2, int n3, boolean bl) {
        return null;
    }

    @Override
    public boolean canDrain(World world, int n, int n2, int n3) {
        return false;
    }
}

