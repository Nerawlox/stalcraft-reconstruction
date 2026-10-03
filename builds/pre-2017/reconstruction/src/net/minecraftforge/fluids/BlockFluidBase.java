/*
 * Decompiled with CFR 0.152.
 */
package net.minecraftforge.fluids;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.Vec3;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.IFluidBlock;

public abstract class BlockFluidBase
extends Block
implements IFluidBlock {
    protected static final Map<Integer, Boolean> defaultDisplacementIds = new HashMap<Integer, Boolean>();
    protected Map<Integer, Boolean> displacementIds = new HashMap<Integer, Boolean>();
    protected int quantaPerBlock = 8;
    protected float quantaPerBlockFloat = 8.0f;
    protected int density = 1;
    protected int densityDir = -1;
    protected int temperature = 295;
    protected int tickRate = 20;
    protected int renderPass = 1;
    protected int maxScaledLight = 0;
    protected final String fluidName;

    public BlockFluidBase(int n, Fluid fluid, Material material) {
        super(n, material);
        this.setBlockBounds(0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f);
        this.setTickRandomly(true);
        this.disableStats();
        this.fluidName = fluid.getName();
        this.density = fluid.density;
        this.temperature = fluid.temperature;
        this.maxScaledLight = fluid.luminosity;
        this.tickRate = fluid.viscosity / 200;
        this.densityDir = fluid.density > 0 ? -1 : 1;
        fluid.setBlockID(n);
        this.displacementIds.putAll(defaultDisplacementIds);
    }

    public BlockFluidBase setQuantaPerBlock(int n) {
        if (n > 16 || n < 1) {
            n = 8;
        }
        this.quantaPerBlock = n;
        this.quantaPerBlockFloat = n;
        return this;
    }

    public BlockFluidBase setDensity(int n) {
        if (n == 0) {
            n = 1;
        }
        this.density = n;
        this.densityDir = n > 0 ? -1 : 1;
        return this;
    }

    public BlockFluidBase setTemperature(int n) {
        this.temperature = n;
        return this;
    }

    public BlockFluidBase setTickRate(int n) {
        if (n <= 0) {
            n = 20;
        }
        this.tickRate = n;
        return this;
    }

    public BlockFluidBase setRenderPass(int n) {
        this.renderPass = n;
        return this;
    }

    public BlockFluidBase setMaxScaledLight(int n) {
        this.maxScaledLight = n;
        return this;
    }

    public boolean canDisplace(IBlockAccess iBlockAccess, int n, int n2, int n3) {
        if (iBlockAccess.isAirBlock(n, n2, n3)) {
            return true;
        }
        int n4 = iBlockAccess.getBlockId(n, n2, n3);
        if (n4 == this.blockID) {
            return false;
        }
        if (this.displacementIds.containsKey(n4)) {
            return this.displacementIds.get(n4);
        }
        Material material = Block.blocksList[n4].blockMaterial;
        if (material._c() || material == Material._D) {
            return false;
        }
        int n5 = BlockFluidBase.getDensity(iBlockAccess, n, n2, n3);
        if (n5 == Integer.MAX_VALUE) {
            return true;
        }
        return this.density > n5;
    }

    public boolean displaceIfPossible(World world, int n, int n2, int n3) {
        if (world.isAirBlock(n, n2, n3)) {
            return true;
        }
        int n4 = world.getBlockId(n, n2, n3);
        if (n4 == this.blockID) {
            return false;
        }
        if (this.displacementIds.containsKey(n4)) {
            if (this.displacementIds.get(n4).booleanValue()) {
                Block.blocksList[n4].dropBlockAsItem(world, n, n2, n3, world.getBlockMetadata(n, n2, n3), 0);
                return true;
            }
            return false;
        }
        Material material = Block.blocksList[n4].blockMaterial;
        if (material._c() || material == Material._D) {
            return false;
        }
        int n5 = BlockFluidBase.getDensity(world, n, n2, n3);
        if (n5 == Integer.MAX_VALUE) {
            Block.blocksList[n4].dropBlockAsItem(world, n, n2, n3, world.getBlockMetadata(n, n2, n3), 0);
            return true;
        }
        return this.density > n5;
    }

    public abstract int getQuantaValue(IBlockAccess var1, int var2, int var3, int var4);

    @Override
    public abstract boolean canCollideCheck(int var1, boolean var2);

    public abstract int getMaxRenderHeightMeta();

    @Override
    public void onBlockAdded(World world, int n, int n2, int n3) {
        world.scheduleBlockUpdate(n, n2, n3, this.blockID, this.tickRate);
    }

    @Override
    public void onNeighborBlockChange(World world, int n, int n2, int n3, int n4) {
        world.scheduleBlockUpdate(n, n2, n3, this.blockID, this.tickRate);
    }

    @Override
    public boolean func_82506_l() {
        return false;
    }

    @Override
    public boolean getBlocksMovement(IBlockAccess iBlockAccess, int n, int n2, int n3) {
        return true;
    }

    @Override
    public AxisAlignedBB getCollisionBoundingBoxFromPool(World world, int n, int n2, int n3) {
        return null;
    }

    @Override
    public int idDropped(int n, Random random, int n2) {
        return 0;
    }

    @Override
    public int quantityDropped(Random random) {
        return 0;
    }

    @Override
    public int tickRate(World world) {
        return this.tickRate;
    }

    @Override
    public void velocityToAddToEntity(World world, int n, int n2, int n3, Entity entity, Vec3 vec3) {
        if (this.densityDir > 0) {
            return;
        }
        Vec3 vec32 = this.getFlowVector(world, n, n2, n3);
        vec3._c += vec32._c * (double)(this.quantaPerBlock * 4);
        vec3._d += vec32._d * (double)(this.quantaPerBlock * 4);
        vec3._e += vec32._e * (double)(this.quantaPerBlock * 4);
    }

    @Override
    public int getLightValue(IBlockAccess iBlockAccess, int n, int n2, int n3) {
        if (this.maxScaledLight == 0) {
            return super.getLightValue(iBlockAccess, n, n2, n3);
        }
        int n4 = iBlockAccess.getBlockMetadata(n, n2, n3);
        return (int)((float)n4 / this.quantaPerBlockFloat * (float)this.maxScaledLight);
    }

    @Override
    public int getRenderType() {
        return FluidRegistry.renderIdFluid;
    }

    @Override
    public boolean isOpaqueCube() {
        return false;
    }

    @Override
    public boolean renderAsNormalBlock() {
        return false;
    }

    @Override
    public float getBlockBrightness(IBlockAccess iBlockAccess, int n, int n2, int n3) {
        float f;
        float f2 = iBlockAccess.getLightBrightness(n, n2, n3);
        return f2 > (f = iBlockAccess.getLightBrightness(n, n2 + 1, n3)) ? f2 : f;
    }

    @Override
    public int getMixedBrightnessForBlock(IBlockAccess iBlockAccess, int n, int n2, int n3) {
        int n4 = iBlockAccess.getLightBrightnessForSkyBlocks(n, n2, n3, 0);
        int n5 = iBlockAccess.getLightBrightnessForSkyBlocks(n, n2 + 1, n3, 0);
        int n6 = n4 & 0xFF;
        int n7 = n5 & 0xFF;
        int n8 = n4 >> 16 & 0xFF;
        int n9 = n5 >> 16 & 0xFF;
        return (n6 > n7 ? n6 : n7) | (n8 > n9 ? n8 : n9) << 16;
    }

    @Override
    public int getRenderBlockPass() {
        return this.renderPass;
    }

    @Override
    public boolean shouldSideBeRendered(IBlockAccess iBlockAccess, int n, int n2, int n3, int n4) {
        if (iBlockAccess.getBlockId(n, n2, n3) != this.blockID) {
            return !iBlockAccess.isBlockOpaqueCube(n, n2, n3);
        }
        Material material = iBlockAccess.getBlockMaterial(n, n2, n3);
        return material == this.blockMaterial ? false : super.shouldSideBeRendered(iBlockAccess, n, n2, n3, n4);
    }

    public static final int getDensity(IBlockAccess iBlockAccess, int n, int n2, int n3) {
        Block block = Block.blocksList[iBlockAccess.getBlockId(n, n2, n3)];
        if (!(block instanceof BlockFluidBase)) {
            return Integer.MAX_VALUE;
        }
        return ((BlockFluidBase)block).density;
    }

    public static final int getTemperature(IBlockAccess iBlockAccess, int n, int n2, int n3) {
        Block block = Block.blocksList[iBlockAccess.getBlockId(n, n2, n3)];
        if (!(block instanceof BlockFluidBase)) {
            return Integer.MAX_VALUE;
        }
        return ((BlockFluidBase)block).temperature;
    }

    public static double getFlowDirection(IBlockAccess iBlockAccess, int n, int n2, int n3) {
        Block block = Block.blocksList[iBlockAccess.getBlockId(n, n2, n3)];
        if (!iBlockAccess.getBlockMaterial(n, n2, n3)._d()) {
            return -1000.0;
        }
        Vec3 vec3 = ((BlockFluidBase)block).getFlowVector(iBlockAccess, n, n2, n3);
        return vec3._c == 0.0 && vec3._e == 0.0 ? -1000.0 : Math.atan2(vec3._e, vec3._c) - 1.5707963267948966;
    }

    public final int getQuantaValueBelow(IBlockAccess iBlockAccess, int n, int n2, int n3, int n4) {
        int n5 = this.getQuantaValue(iBlockAccess, n, n2, n3);
        if (n5 >= n4) {
            return -1;
        }
        return n5;
    }

    public final int getQuantaValueAbove(IBlockAccess iBlockAccess, int n, int n2, int n3, int n4) {
        int n5 = this.getQuantaValue(iBlockAccess, n, n2, n3);
        if (n5 <= n4) {
            return -1;
        }
        return n5;
    }

    public final float getQuantaPercentage(IBlockAccess iBlockAccess, int n, int n2, int n3) {
        int n4 = this.getQuantaValue(iBlockAccess, n, n2, n3);
        return (float)n4 / this.quantaPerBlockFloat;
    }

    public Vec3 getFlowVector(IBlockAccess iBlockAccess, int n, int n2, int n3) {
        int n4;
        Vec3 vec3 = iBlockAccess.getWorldVec3Pool()._a(0.0, 0.0, 0.0);
        int n5 = this.quantaPerBlock - this.getQuantaValue(iBlockAccess, n, n2, n3);
        for (n4 = 0; n4 < 4; ++n4) {
            int n6;
            int n7 = n;
            int n8 = n3;
            switch (n4) {
                case 0: {
                    --n7;
                    break;
                }
                case 1: {
                    --n8;
                    break;
                }
                case 2: {
                    ++n7;
                    break;
                }
                case 3: {
                    ++n8;
                }
            }
            int n9 = this.quantaPerBlock - this.getQuantaValue(iBlockAccess, n7, n2, n8);
            if (n9 >= this.quantaPerBlock) {
                if (iBlockAccess.getBlockMaterial(n7, n2, n8)._c() || (n9 = this.quantaPerBlock - this.getQuantaValue(iBlockAccess, n7, n2 - 1, n8)) < 0) continue;
                n6 = n9 - (n5 - this.quantaPerBlock);
                vec3 = vec3._c((n7 - n) * n6, (n2 - n2) * n6, (n8 - n3) * n6);
                continue;
            }
            if (n9 < 0) continue;
            n6 = n9 - n5;
            vec3 = vec3._c((n7 - n) * n6, (n2 - n2) * n6, (n8 - n3) * n6);
        }
        if (iBlockAccess.getBlockId(n, n2 + 1, n3) == this.blockID) {
            int n10 = n4 = this.isBlockSolid(iBlockAccess, n, n2, n3 - 1, 2) || this.isBlockSolid(iBlockAccess, n, n2, n3 + 1, 3) || this.isBlockSolid(iBlockAccess, n - 1, n2, n3, 4) || this.isBlockSolid(iBlockAccess, n + 1, n2, n3, 5) || this.isBlockSolid(iBlockAccess, n, n2 + 1, n3 - 1, 2) || this.isBlockSolid(iBlockAccess, n, n2 + 1, n3 + 1, 3) || this.isBlockSolid(iBlockAccess, n - 1, n2 + 1, n3, 4) || this.isBlockSolid(iBlockAccess, n + 1, n2 + 1, n3, 5) ? 1 : 0;
            if (n4 != 0) {
                vec3 = vec3._a()._c(0.0, -6.0, 0.0);
            }
        }
        vec3 = vec3._a();
        return vec3;
    }

    @Override
    public Fluid getFluid() {
        return FluidRegistry.getFluid(this.fluidName);
    }

    @Override
    public float getFilledPercentage(World world, int n, int n2, int n3) {
        int n4 = this.getQuantaValue(world, n, n2, n3) + 1;
        float f = (float)n4 / this.quantaPerBlockFloat;
        if (f > 1.0f) {
            f = 1.0f;
        }
        return f * (float)(this.density > 0 ? 1 : -1);
    }

    static {
        defaultDisplacementIds.put(Block.doorWood.blockID, false);
        defaultDisplacementIds.put(Block.doorIron.blockID, false);
        defaultDisplacementIds.put(Block.signPost.blockID, false);
        defaultDisplacementIds.put(Block.signWall.blockID, false);
        defaultDisplacementIds.put(Block.reed.blockID, false);
    }
}

