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

public class BlockFluidClassic
extends BlockFluidBase {
    protected boolean[] isOptimalFlowDirection = new boolean[4];
    protected int[] flowCost = new int[4];
    protected FluidStack stack;

    public BlockFluidClassic(int n, Fluid fluid, Material material) {
        super(n, fluid, material);
        this.stack = new FluidStack(fluid, 1000);
    }

    public BlockFluidClassic setFluidStack(FluidStack fluidStack) {
        this.stack = fluidStack;
        return this;
    }

    public BlockFluidClassic setFluidStackAmount(int n) {
        this.stack.amount = n;
        return this;
    }

    @Override
    public int getQuantaValue(IBlockAccess iBlockAccess, int n, int n2, int n3) {
        if (iBlockAccess.getBlockId(n, n2, n3) == 0) {
            return 0;
        }
        if (iBlockAccess.getBlockId(n, n2, n3) != this.blockID) {
            return -1;
        }
        int n4 = this.quantaPerBlock - iBlockAccess.getBlockMetadata(n, n2, n3);
        return n4;
    }

    @Override
    public boolean canCollideCheck(int n, boolean bl) {
        return bl && n == 0;
    }

    @Override
    public int getMaxRenderHeightMeta() {
        return 0;
    }

    @Override
    public int getLightValue(IBlockAccess iBlockAccess, int n, int n2, int n3) {
        if (this.maxScaledLight == 0) {
            return super.getLightValue(iBlockAccess, n, n2, n3);
        }
        int n4 = this.quantaPerBlock - iBlockAccess.getBlockMetadata(n, n2, n3) - 1;
        return (int)((float)n4 / this.quantaPerBlockFloat * (float)this.maxScaledLight);
    }

    @Override
    public void updateTick(World world, int n, int n2, int n3, Random random) {
        int n4;
        int n5 = this.quantaPerBlock - world.getBlockMetadata(n, n2, n3);
        int n6 = -101;
        if (n5 < this.quantaPerBlock) {
            n4 = n2 - this.densityDir;
            if (world.getBlockId(n, n4, n3) == this.blockID || world.getBlockId(n - 1, n4, n3) == this.blockID || world.getBlockId(n + 1, n4, n3) == this.blockID || world.getBlockId(n, n4, n3 - 1) == this.blockID || world.getBlockId(n, n4, n3 + 1) == this.blockID) {
                n6 = this.quantaPerBlock - 1;
            } else {
                int n7 = -100;
                n7 = this.getLargerQuanta(world, n - 1, n2, n3, n7);
                n7 = this.getLargerQuanta(world, n + 1, n2, n3, n7);
                n7 = this.getLargerQuanta(world, n, n2, n3 - 1, n7);
                n7 = this.getLargerQuanta(world, n, n2, n3 + 1, n7);
                n6 = n7 - 1;
            }
            if (n6 != n5) {
                n5 = n6;
                if (n6 <= 0) {
                    world.setBlockToAir(n, n2, n3);
                } else {
                    world.func_72921_c(n, n2, n3, this.quantaPerBlock - n6, 3);
                    world.scheduleBlockUpdate(n, n2, n3, this.blockID, this.tickRate);
                    world.notifyBlocksOfNeighborChange(n, n2, n3, this.blockID);
                }
            }
        } else if (n5 >= this.quantaPerBlock) {
            world.func_72921_c(n, n2, n3, 0, 2);
        }
        if (this.canDisplace(world, n, n2 + this.densityDir, n3)) {
            this.flowIntoBlock(world, n, n2 + this.densityDir, n3, 1);
            return;
        }
        n4 = this.quantaPerBlock - n5 + 1;
        if (n4 >= this.quantaPerBlock) {
            return;
        }
        if (this.isSourceBlock(world, n, n2, n3) || !this.isFlowingVertically(world, n, n2, n3)) {
            boolean[] blArray;
            if (world.getBlockId(n, n2 - this.densityDir, n3) == this.blockID) {
                n4 = 1;
            }
            if ((blArray = this.getOptimalFlowDirections(world, n, n2, n3))[0]) {
                this.flowIntoBlock(world, n - 1, n2, n3, n4);
            }
            if (blArray[1]) {
                this.flowIntoBlock(world, n + 1, n2, n3, n4);
            }
            if (blArray[2]) {
                this.flowIntoBlock(world, n, n2, n3 - 1, n4);
            }
            if (blArray[3]) {
                this.flowIntoBlock(world, n, n2, n3 + 1, n4);
            }
        }
    }

    public boolean isFlowingVertically(IBlockAccess iBlockAccess, int n, int n2, int n3) {
        return iBlockAccess.getBlockId(n, n2 + this.densityDir, n3) == this.blockID || iBlockAccess.getBlockId(n, n2, n3) == this.blockID && this.canFlowInto(iBlockAccess, n, n2 + this.densityDir, n3);
    }

    public boolean isSourceBlock(IBlockAccess iBlockAccess, int n, int n2, int n3) {
        return iBlockAccess.getBlockId(n, n2, n3) == this.blockID && iBlockAccess.getBlockMetadata(n, n2, n3) == 0;
    }

    protected boolean[] getOptimalFlowDirections(World world, int n, int n2, int n3) {
        int n4;
        int n5;
        for (n5 = 0; n5 < 4; ++n5) {
            this.flowCost[n5] = 1000;
            n4 = n;
            int n6 = n2;
            int n7 = n3;
            switch (n5) {
                case 0: {
                    --n4;
                    break;
                }
                case 1: {
                    ++n4;
                    break;
                }
                case 2: {
                    --n7;
                    break;
                }
                case 3: {
                    ++n7;
                }
            }
            if (!this.canFlowInto(world, n4, n6, n7) || this.isSourceBlock(world, n4, n6, n7)) continue;
            this.flowCost[n5] = this.canFlowInto(world, n4, n6 + this.densityDir, n7) ? 0 : this.calculateFlowCost(world, n4, n6, n7, 1, n5);
        }
        n5 = this.flowCost[0];
        for (n4 = 1; n4 < 4; ++n4) {
            if (this.flowCost[n4] >= n5) continue;
            n5 = this.flowCost[n4];
        }
        for (n4 = 0; n4 < 4; ++n4) {
            this.isOptimalFlowDirection[n4] = this.flowCost[n4] == n5;
        }
        return this.isOptimalFlowDirection;
    }

    protected int calculateFlowCost(World world, int n, int n2, int n3, int n4, int n5) {
        int n6 = 1000;
        for (int i = 0; i < 4; ++i) {
            int n7;
            if (i == 0 && n5 == 1 || i == 1 && n5 == 0 || i == 2 && n5 == 3 || i == 3 && n5 == 2) continue;
            int n8 = n;
            int n9 = n2;
            int n10 = n3;
            switch (i) {
                case 0: {
                    --n8;
                    break;
                }
                case 1: {
                    ++n8;
                    break;
                }
                case 2: {
                    --n10;
                    break;
                }
                case 3: {
                    ++n10;
                }
            }
            if (!this.canFlowInto(world, n8, n9, n10) || this.isSourceBlock(world, n8, n9, n10)) continue;
            if (this.canFlowInto(world, n8, n9 + this.densityDir, n10)) {
                return n4;
            }
            if (n4 >= 4 || (n7 = this.calculateFlowCost(world, n8, n9, n10, n4 + 1, i)) >= n6) continue;
            n6 = n7;
        }
        return n6;
    }

    protected void flowIntoBlock(World world, int n, int n2, int n3, int n4) {
        if (n4 < 0) {
            return;
        }
        if (this.displaceIfPossible(world, n, n2, n3)) {
            world.setBlock(n, n2, n3, this.blockID, n4, 3);
        }
    }

    protected boolean canFlowInto(IBlockAccess iBlockAccess, int n, int n2, int n3) {
        if (iBlockAccess.isAirBlock(n, n2, n3)) {
            return true;
        }
        int n4 = iBlockAccess.getBlockId(n, n2, n3);
        if (n4 == this.blockID) {
            return true;
        }
        if (this.displacementIds.containsKey(n4)) {
            return (Boolean)this.displacementIds.get(n4);
        }
        Material material = Block.blocksList[n4].blockMaterial;
        if (material._c() || material == Material._h || material == Material._i || material == Material._D) {
            return false;
        }
        int n5 = BlockFluidClassic.getDensity(iBlockAccess, n, n2, n3);
        if (n5 == Integer.MAX_VALUE) {
            return true;
        }
        return this.density > n5;
    }

    protected int getLargerQuanta(IBlockAccess iBlockAccess, int n, int n2, int n3, int n4) {
        int n5 = this.getQuantaValue(iBlockAccess, n, n2, n3);
        if (n5 <= 0) {
            return n4;
        }
        return n5 >= n4 ? n5 : n4;
    }

    @Override
    public FluidStack drain(World world, int n, int n2, int n3, boolean bl) {
        if (!this.isSourceBlock(world, n, n2, n3)) {
            return null;
        }
        if (bl) {
            world.setBlockToAir(n, n2, n3);
        }
        return this.stack.copy();
    }

    @Override
    public boolean canDrain(World world, int n, int n2, int n3) {
        return this.isSourceBlock(world, n, n2, n3);
    }
}

