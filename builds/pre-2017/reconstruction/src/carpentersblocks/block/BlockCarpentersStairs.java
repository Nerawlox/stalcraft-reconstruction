/*
 * Decompiled with CFR 0.152.
 */
package carpentersblocks.block;

import carpentersblocks.CarpentersBlocks;
import carpentersblocks.block.BlockBase;
import carpentersblocks.block.BlockCarpentersSlope;
import carpentersblocks.data.Stairs;
import carpentersblocks.tileentity.TECarpentersBlock;
import carpentersblocks.util.BlockProperties;
import carpentersblocks.util.handler.BlockHandler;
import java.util.List;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;
import net.minecraft.util.sajh;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeDirection;

public class BlockCarpentersStairs
extends BlockBase {
    public BlockCarpentersStairs(int n) {
        super(n, Material._d);
        this.setHardness(0.2f);
        this.setUnlocalizedName("blockCarpentersStairs");
        this.setCreativeTab(CarpentersBlocks.tabCarpentersBlocks);
        this.setTextureName("carpentersblocks:stairs/stairs");
    }

    @Override
    protected boolean onHammerLeftClick(TECarpentersBlock tECarpentersBlock, EntityPlayer entityPlayer) {
        int n = BlockProperties.getData(tECarpentersBlock);
        Stairs stairs = Stairs.stairsList[n];
        switch (NamelessClass1094083828.$SwitchMap$carpentersblocks$data$Stairs$StairsType[stairs.stairsType.ordinal()]) {
            case 1: {
                if (++n <= 3) break;
                n = 0;
                break;
            }
            case 2: {
                if (stairs.arePositive) {
                    if (++n <= 11) break;
                    n = 8;
                    break;
                }
                if (++n <= 7) break;
                n = 4;
                break;
            }
            case 3: {
                if (stairs.arePositive) {
                    if ((n += 2) <= 18) break;
                    n = 12;
                    break;
                }
                if ((n += 2) <= 19) break;
                n = 13;
                break;
            }
            case 4: {
                if (stairs.arePositive) {
                    if ((n += 2) <= 26) break;
                    n = 20;
                    break;
                }
                if ((n += 2) <= 27) break;
                n = 21;
            }
        }
        BlockProperties.setData(tECarpentersBlock, n);
        return true;
    }

    @Override
    protected boolean onHammerRightClick(TECarpentersBlock tECarpentersBlock, EntityPlayer entityPlayer, int n) {
        int n2 = BlockProperties.getData(tECarpentersBlock);
        Stairs stairs = Stairs.stairsList[n2];
        switch (NamelessClass1094083828.$SwitchMap$carpentersblocks$data$Stairs$StairsType[stairs.stairsType.ordinal()]) {
            case 1: {
                n2 = 8;
                break;
            }
            case 2: {
                if (stairs.arePositive) {
                    n2 -= 4;
                    break;
                }
                n2 = 12;
                break;
            }
            case 3: {
                if (stairs.arePositive) {
                    ++n2;
                    break;
                }
                if (n2 != 13 && n2 != 15) {
                    n2 += 3;
                    break;
                }
                n2 += 11;
                break;
            }
            case 4: {
                if (stairs.arePositive) {
                    ++n2;
                    break;
                }
                n2 = 0;
            }
        }
        BlockProperties.setData(tECarpentersBlock, n2);
        return true;
    }

    public float[] genBounds(int n, Stairs stairs) {
        ++n;
        switch (stairs.stairsID) {
            case 0: {
                switch (n) {
                    case 1: {
                        return BlockCarpentersSlope.getTempBounds(0.0f, 0.0f, 0.0f, 0.5f, 1.0f, 1.0f);
                    }
                    case 2: {
                        return BlockCarpentersSlope.getTempBounds(0.5f, 0.0f, 0.0f, 1.0f, 1.0f, 0.5f);
                    }
                }
                return null;
            }
            case 1: {
                switch (n) {
                    case 1: {
                        return BlockCarpentersSlope.getTempBounds(0.5f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f);
                    }
                    case 2: {
                        return BlockCarpentersSlope.getTempBounds(0.0f, 0.0f, 0.5f, 0.5f, 1.0f, 1.0f);
                    }
                }
                return null;
            }
            case 2: {
                switch (n) {
                    case 1: {
                        return BlockCarpentersSlope.getTempBounds(0.0f, 0.0f, 0.0f, 0.5f, 1.0f, 1.0f);
                    }
                    case 2: {
                        return BlockCarpentersSlope.getTempBounds(0.5f, 0.0f, 0.5f, 1.0f, 1.0f, 1.0f);
                    }
                }
                return null;
            }
            case 3: {
                switch (n) {
                    case 1: {
                        return BlockCarpentersSlope.getTempBounds(0.5f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f);
                    }
                    case 2: {
                        return BlockCarpentersSlope.getTempBounds(0.0f, 0.0f, 0.0f, 0.5f, 1.0f, 0.5f);
                    }
                }
                return null;
            }
            case 4: {
                switch (n) {
                    case 1: {
                        return BlockCarpentersSlope.getTempBounds(0.0f, 0.0f, 0.5f, 1.0f, 1.0f, 1.0f);
                    }
                    case 2: {
                        return BlockCarpentersSlope.getTempBounds(0.0f, 0.5f, 0.0f, 1.0f, 1.0f, 0.5f);
                    }
                }
                return null;
            }
            case 5: {
                switch (n) {
                    case 1: {
                        return BlockCarpentersSlope.getTempBounds(0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 0.5f);
                    }
                    case 2: {
                        return BlockCarpentersSlope.getTempBounds(0.0f, 0.5f, 0.5f, 1.0f, 1.0f, 1.0f);
                    }
                }
                return null;
            }
            case 6: {
                switch (n) {
                    case 1: {
                        return BlockCarpentersSlope.getTempBounds(0.5f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f);
                    }
                    case 2: {
                        return BlockCarpentersSlope.getTempBounds(0.0f, 0.5f, 0.0f, 0.5f, 1.0f, 1.0f);
                    }
                }
                return null;
            }
            case 7: {
                switch (n) {
                    case 1: {
                        return BlockCarpentersSlope.getTempBounds(0.0f, 0.0f, 0.0f, 0.5f, 1.0f, 1.0f);
                    }
                    case 2: {
                        return BlockCarpentersSlope.getTempBounds(0.5f, 0.5f, 0.0f, 1.0f, 1.0f, 1.0f);
                    }
                }
                return null;
            }
            case 8: {
                switch (n) {
                    case 1: {
                        return BlockCarpentersSlope.getTempBounds(0.0f, 0.0f, 0.5f, 1.0f, 1.0f, 1.0f);
                    }
                    case 2: {
                        return BlockCarpentersSlope.getTempBounds(0.0f, 0.0f, 0.0f, 1.0f, 0.5f, 0.5f);
                    }
                }
                return null;
            }
            case 9: {
                switch (n) {
                    case 1: {
                        return BlockCarpentersSlope.getTempBounds(0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 0.5f);
                    }
                    case 2: {
                        return BlockCarpentersSlope.getTempBounds(0.0f, 0.0f, 0.5f, 1.0f, 0.5f, 1.0f);
                    }
                }
                return null;
            }
            case 10: {
                switch (n) {
                    case 1: {
                        return BlockCarpentersSlope.getTempBounds(0.5f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f);
                    }
                    case 2: {
                        return BlockCarpentersSlope.getTempBounds(0.0f, 0.0f, 0.0f, 0.5f, 0.5f, 1.0f);
                    }
                }
                return null;
            }
            case 11: {
                switch (n) {
                    case 1: {
                        return BlockCarpentersSlope.getTempBounds(0.0f, 0.0f, 0.0f, 0.5f, 1.0f, 1.0f);
                    }
                    case 2: {
                        return BlockCarpentersSlope.getTempBounds(0.5f, 0.0f, 0.0f, 1.0f, 0.5f, 1.0f);
                    }
                }
                return null;
            }
            case 12: {
                switch (n) {
                    case 1: {
                        return BlockCarpentersSlope.getTempBounds(0.0f, 0.0f, 0.0f, 0.5f, 1.0f, 1.0f);
                    }
                    case 2: {
                        return BlockCarpentersSlope.getTempBounds(0.5f, 0.0f, 0.5f, 1.0f, 1.0f, 1.0f);
                    }
                    case 3: {
                        return BlockCarpentersSlope.getTempBounds(0.5f, 0.0f, 0.0f, 1.0f, 0.5f, 0.5f);
                    }
                }
                return null;
            }
            case 13: {
                switch (n) {
                    case 1: {
                        return BlockCarpentersSlope.getTempBounds(0.0f, 0.0f, 0.0f, 0.5f, 1.0f, 1.0f);
                    }
                    case 2: {
                        return BlockCarpentersSlope.getTempBounds(0.5f, 0.0f, 0.5f, 1.0f, 1.0f, 1.0f);
                    }
                    case 3: {
                        return BlockCarpentersSlope.getTempBounds(0.5f, 0.5f, 0.0f, 1.0f, 1.0f, 0.5f);
                    }
                }
                return null;
            }
            case 14: {
                switch (n) {
                    case 1: {
                        return BlockCarpentersSlope.getTempBounds(0.5f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f);
                    }
                    case 2: {
                        return BlockCarpentersSlope.getTempBounds(0.0f, 0.0f, 0.5f, 0.5f, 1.0f, 1.0f);
                    }
                    case 3: {
                        return BlockCarpentersSlope.getTempBounds(0.0f, 0.0f, 0.0f, 0.5f, 0.5f, 0.5f);
                    }
                }
                return null;
            }
            case 15: {
                switch (n) {
                    case 1: {
                        return BlockCarpentersSlope.getTempBounds(0.5f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f);
                    }
                    case 2: {
                        return BlockCarpentersSlope.getTempBounds(0.0f, 0.0f, 0.5f, 0.5f, 1.0f, 1.0f);
                    }
                    case 3: {
                        return BlockCarpentersSlope.getTempBounds(0.0f, 0.5f, 0.0f, 0.5f, 1.0f, 0.5f);
                    }
                }
                return null;
            }
            case 16: {
                switch (n) {
                    case 1: {
                        return BlockCarpentersSlope.getTempBounds(0.5f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f);
                    }
                    case 2: {
                        return BlockCarpentersSlope.getTempBounds(0.0f, 0.0f, 0.0f, 0.5f, 1.0f, 0.5f);
                    }
                    case 3: {
                        return BlockCarpentersSlope.getTempBounds(0.0f, 0.0f, 0.5f, 0.5f, 0.5f, 1.0f);
                    }
                }
                return null;
            }
            case 17: {
                switch (n) {
                    case 1: {
                        return BlockCarpentersSlope.getTempBounds(0.5f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f);
                    }
                    case 2: {
                        return BlockCarpentersSlope.getTempBounds(0.0f, 0.0f, 0.0f, 0.5f, 1.0f, 0.5f);
                    }
                    case 3: {
                        return BlockCarpentersSlope.getTempBounds(0.0f, 0.5f, 0.5f, 0.5f, 1.0f, 1.0f);
                    }
                }
                return null;
            }
            case 18: {
                switch (n) {
                    case 1: {
                        return BlockCarpentersSlope.getTempBounds(0.0f, 0.0f, 0.0f, 0.5f, 1.0f, 1.0f);
                    }
                    case 2: {
                        return BlockCarpentersSlope.getTempBounds(0.5f, 0.0f, 0.0f, 1.0f, 1.0f, 0.5f);
                    }
                    case 3: {
                        return BlockCarpentersSlope.getTempBounds(0.5f, 0.0f, 0.5f, 1.0f, 0.5f, 1.0f);
                    }
                }
                return null;
            }
            case 19: {
                switch (n) {
                    case 1: {
                        return BlockCarpentersSlope.getTempBounds(0.0f, 0.0f, 0.0f, 0.5f, 1.0f, 1.0f);
                    }
                    case 2: {
                        return BlockCarpentersSlope.getTempBounds(0.5f, 0.0f, 0.0f, 1.0f, 1.0f, 0.5f);
                    }
                    case 3: {
                        return BlockCarpentersSlope.getTempBounds(0.5f, 0.5f, 0.5f, 1.0f, 1.0f, 1.0f);
                    }
                }
                return null;
            }
            case 20: {
                switch (n) {
                    case 1: {
                        return BlockCarpentersSlope.getTempBounds(0.5f, 0.0f, 0.0f, 1.0f, 1.0f, 0.5f);
                    }
                    case 2: {
                        return BlockCarpentersSlope.getTempBounds(0.0f, 0.0f, 0.0f, 0.5f, 0.5f, 1.0f);
                    }
                    case 3: {
                        return BlockCarpentersSlope.getTempBounds(0.5f, 0.0f, 0.5f, 1.0f, 0.5f, 1.0f);
                    }
                }
                return null;
            }
            case 21: {
                switch (n) {
                    case 1: {
                        return BlockCarpentersSlope.getTempBounds(0.5f, 0.0f, 0.0f, 1.0f, 1.0f, 0.5f);
                    }
                    case 2: {
                        return BlockCarpentersSlope.getTempBounds(0.0f, 0.5f, 0.0f, 0.5f, 1.0f, 1.0f);
                    }
                    case 3: {
                        return BlockCarpentersSlope.getTempBounds(0.5f, 0.5f, 0.5f, 1.0f, 1.0f, 1.0f);
                    }
                }
                return null;
            }
            case 22: {
                switch (n) {
                    case 1: {
                        return BlockCarpentersSlope.getTempBounds(0.0f, 0.0f, 0.0f, 0.5f, 1.0f, 0.5f);
                    }
                    case 2: {
                        return BlockCarpentersSlope.getTempBounds(0.5f, 0.0f, 0.0f, 1.0f, 0.5f, 1.0f);
                    }
                    case 3: {
                        return BlockCarpentersSlope.getTempBounds(0.0f, 0.0f, 0.5f, 0.5f, 0.5f, 1.0f);
                    }
                }
                return null;
            }
            case 23: {
                switch (n) {
                    case 1: {
                        return BlockCarpentersSlope.getTempBounds(0.0f, 0.0f, 0.0f, 0.5f, 1.0f, 0.5f);
                    }
                    case 2: {
                        return BlockCarpentersSlope.getTempBounds(0.5f, 0.5f, 0.0f, 1.0f, 1.0f, 1.0f);
                    }
                    case 3: {
                        return BlockCarpentersSlope.getTempBounds(0.0f, 0.5f, 0.5f, 0.5f, 1.0f, 1.0f);
                    }
                }
                return null;
            }
            case 24: {
                switch (n) {
                    case 1: {
                        return BlockCarpentersSlope.getTempBounds(0.0f, 0.0f, 0.5f, 0.5f, 1.0f, 1.0f);
                    }
                    case 2: {
                        return BlockCarpentersSlope.getTempBounds(0.5f, 0.0f, 0.0f, 1.0f, 0.5f, 1.0f);
                    }
                    case 3: {
                        return BlockCarpentersSlope.getTempBounds(0.0f, 0.0f, 0.0f, 0.5f, 0.5f, 0.5f);
                    }
                }
                return null;
            }
            case 25: {
                switch (n) {
                    case 1: {
                        return BlockCarpentersSlope.getTempBounds(0.0f, 0.0f, 0.5f, 0.5f, 1.0f, 1.0f);
                    }
                    case 2: {
                        return BlockCarpentersSlope.getTempBounds(0.5f, 0.5f, 0.0f, 1.0f, 1.0f, 1.0f);
                    }
                    case 3: {
                        return BlockCarpentersSlope.getTempBounds(0.0f, 0.5f, 0.0f, 0.5f, 1.0f, 0.5f);
                    }
                }
                return null;
            }
            case 26: {
                switch (n) {
                    case 1: {
                        return BlockCarpentersSlope.getTempBounds(0.5f, 0.0f, 0.5f, 1.0f, 1.0f, 1.0f);
                    }
                    case 2: {
                        return BlockCarpentersSlope.getTempBounds(0.0f, 0.0f, 0.0f, 0.5f, 0.5f, 1.0f);
                    }
                    case 3: {
                        return BlockCarpentersSlope.getTempBounds(0.5f, 0.0f, 0.0f, 1.0f, 0.5f, 0.5f);
                    }
                }
                return null;
            }
            case 27: {
                switch (n) {
                    case 1: {
                        return BlockCarpentersSlope.getTempBounds(0.5f, 0.0f, 0.5f, 1.0f, 1.0f, 1.0f);
                    }
                    case 2: {
                        return BlockCarpentersSlope.getTempBounds(0.0f, 0.5f, 0.0f, 0.5f, 1.0f, 1.0f);
                    }
                    case 3: {
                        return BlockCarpentersSlope.getTempBounds(0.5f, 0.5f, 0.0f, 1.0f, 1.0f, 0.5f);
                    }
                }
            }
        }
        return null;
    }

    @Override
    public MovingObjectPosition collisionRayTrace(World world, int n, int n2, int n3, Vec3 vec3, Vec3 vec32) {
        TECarpentersBlock tECarpentersBlock = (TECarpentersBlock)world.getBlockTileEntity(n, n2, n3);
        MovingObjectPosition movingObjectPosition = null;
        int n4 = BlockProperties.getData(tECarpentersBlock);
        Stairs stairs = Stairs.stairsList[n4];
        double d = 0.0;
        double d2 = 0.0;
        for (int i = 0; i < 3; ++i) {
            float[] fArray = this.genBounds(i, stairs);
            if (fArray == null) continue;
            this.setBlockBounds(fArray[0], fArray[1], fArray[2], fArray[3], fArray[4], fArray[5]);
            MovingObjectPosition movingObjectPosition2 = super.collisionRayTrace(world, n, n2, n3, vec3, vec32);
            if (movingObjectPosition2 == null || !((d = movingObjectPosition2._h._e(vec32)) > d2)) continue;
            movingObjectPosition = movingObjectPosition2;
            d2 = d;
        }
        this.setBlockBounds(0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f);
        return movingObjectPosition;
    }

    @Override
    public void addCollisionBoxesToList(World world, int n, int n2, int n3, AxisAlignedBB axisAlignedBB, List list, Entity entity) {
        AxisAlignedBB axisAlignedBB2 = null;
        TECarpentersBlock tECarpentersBlock = (TECarpentersBlock)world.getBlockTileEntity(n, n2, n3);
        int n4 = BlockProperties.getData(tECarpentersBlock);
        Stairs stairs = Stairs.stairsList[n4];
        for (int i = 0; i < 3; ++i) {
            float[] fArray = this.genBounds(i, stairs);
            if (fArray != null) {
                axisAlignedBB2 = AxisAlignedBB._a()._a((float)n + fArray[0], (float)n2 + fArray[1], (float)n3 + fArray[2], (float)n + fArray[3], (float)n2 + fArray[4], (float)n3 + fArray[5]);
            }
            if (axisAlignedBB2 == null || !axisAlignedBB._b(axisAlignedBB2)) continue;
            list.add(axisAlignedBB2);
        }
    }

    @Override
    public boolean isBlockSolidOnSide(World world, int n, int n2, int n3, ForgeDirection forgeDirection) {
        TECarpentersBlock tECarpentersBlock = TECarpentersBlock.get(world, n, n2, n3);
        if (tECarpentersBlock == null) {
            return false;
        }
        return this.isBlockSolid(world, n, n2, n3) ? Stairs.stairsList[BlockProperties.getData(tECarpentersBlock)].isFaceFull(forgeDirection) : false;
    }

    @Override
    public int onBlockPlaced(World world, int n, int n2, int n3, int n4, float f, float f2, float f3, int n5) {
        switch (n4) {
            case 2: {
                f = 1.0f - f;
            }
            default: {
                break;
            }
            case 4: {
                f = f3;
                break;
            }
            case 5: {
                f = 1.0f - f3;
            }
        }
        return n4 > 1 ? (f2 > 0.5f && f > 1.0f - f2 && f < f2 ? n4 + 2 : (f2 < 0.5f && f < 1.0f - f2 && f > f2 ? n4 + 6 : (f < 0.2f ? (n4 == 2 ? 1 : (n4 == 3 ? 0 : (n4 == 4 ? 3 : 2))) : (f > 0.8f ? (n4 == 2 ? 2 : (n4 == 3 ? 3 : (n4 == 4 ? 1 : 0))) : (f2 > 0.5f ? n4 + 2 : n4 + 6))))) : n4 + 12;
    }

    @Override
    public void auxiliaryOnBlockPlacedBy(TECarpentersBlock tECarpentersBlock, World world, int n, int n2, int n3, EntityLivingBase entityLivingBase, ItemStack itemStack) {
        int n4 = sajh._c((double)(entityLivingBase.rotationYaw * 4.0f / 360.0f) + 0.5) & 3;
        BlockProperties.setData(tECarpentersBlock, world.getBlockMetadata(n, n2, n3));
        int n5 = BlockProperties.getData(tECarpentersBlock);
        if (n5 > 11) {
            switch (n4) {
                case 0: {
                    n5 = n5 == 12 ? 4 : 8;
                    break;
                }
                case 1: {
                    n5 = n5 == 12 ? 7 : 11;
                    break;
                }
                case 2: {
                    n5 = n5 == 12 ? 5 : 9;
                    break;
                }
                case 3: {
                    int n6 = n5 = n5 == 12 ? 6 : 10;
                }
            }
        }
        if (!entityLivingBase.isSneaking()) {
            Stairs stairs;
            Stairs stairs2 = Stairs.stairsList[n5];
            TECarpentersBlock tECarpentersBlock2 = world.getBlockId(n - 1, n2, n3) == this.blockID ? (TECarpentersBlock)world.getBlockTileEntity(n - 1, n2, n3) : null;
            TECarpentersBlock tECarpentersBlock3 = world.getBlockId(n + 1, n2, n3) == this.blockID ? (TECarpentersBlock)world.getBlockTileEntity(n + 1, n2, n3) : null;
            TECarpentersBlock tECarpentersBlock4 = world.getBlockId(n, n2 + 1, n3) == this.blockID ? (TECarpentersBlock)world.getBlockTileEntity(n, n2 + 1, n3) : null;
            TECarpentersBlock tECarpentersBlock5 = world.getBlockId(n, n2 - 1, n3) == this.blockID ? (TECarpentersBlock)world.getBlockTileEntity(n, n2 - 1, n3) : null;
            TECarpentersBlock tECarpentersBlock6 = world.getBlockId(n, n2, n3 - 1) == this.blockID ? (TECarpentersBlock)world.getBlockTileEntity(n, n2, n3 - 1) : null;
            TECarpentersBlock tECarpentersBlock7 = world.getBlockId(n, n2, n3 + 1) == this.blockID ? (TECarpentersBlock)world.getBlockTileEntity(n, n2, n3 + 1) : null;
            Stairs stairs3 = tECarpentersBlock2 != null ? Stairs.stairsList[BlockProperties.getData(tECarpentersBlock2)] : (Stairs)null;
            Stairs stairs4 = tECarpentersBlock3 != null ? Stairs.stairsList[BlockProperties.getData(tECarpentersBlock3)] : (Stairs)null;
            Stairs stairs5 = tECarpentersBlock6 != null ? Stairs.stairsList[BlockProperties.getData(tECarpentersBlock6)] : (Stairs)null;
            Stairs stairs6 = tECarpentersBlock7 != null ? Stairs.stairsList[BlockProperties.getData(tECarpentersBlock7)] : (Stairs)null;
            Stairs stairs7 = tECarpentersBlock4 != null ? Stairs.stairsList[BlockProperties.getData(tECarpentersBlock4)] : (Stairs)null;
            Stairs stairs8 = tECarpentersBlock5 != null ? Stairs.stairsList[BlockProperties.getData(tECarpentersBlock5)] : (Stairs)null;
            Stairs stairs9 = tECarpentersBlock2 != null ? stairs3 : (Stairs)null;
            Stairs stairs10 = tECarpentersBlock3 != null ? stairs4 : (Stairs)null;
            Stairs stairs11 = tECarpentersBlock4 != null ? stairs7 : (Stairs)null;
            Stairs stairs12 = tECarpentersBlock5 != null ? stairs8 : (Stairs)null;
            Stairs stairs13 = tECarpentersBlock6 != null ? stairs5 : (Stairs)null;
            Stairs stairs14 = stairs = tECarpentersBlock7 != null ? stairs6 : (Stairs)null;
            if (stairs2.stairsType.equals((Object)Stairs.StairsType.NORMAL_Y)) {
                if (tECarpentersBlock2 != null) {
                    if (stairs2.facings.contains((Object)ForgeDirection.WEST)) {
                        if (stairs3.facings.contains((Object)ForgeDirection.SOUTH) && !stairs3.facings.contains((Object)ForgeDirection.EAST)) {
                            int n7 = n5 = stairs3.arePositive ? 16 : 17;
                        }
                        if (stairs3.facings.contains((Object)ForgeDirection.NORTH) && !stairs3.facings.contains((Object)ForgeDirection.EAST)) {
                            int n8 = n5 = stairs3.arePositive ? 14 : 15;
                        }
                    }
                    if (stairs2.facings.contains((Object)ForgeDirection.EAST)) {
                        if (stairs3.facings.contains((Object)ForgeDirection.SOUTH) && !stairs3.facings.contains((Object)ForgeDirection.EAST)) {
                            int n9 = n5 = stairs3.arePositive ? 22 : 23;
                        }
                        if (stairs3.facings.contains((Object)ForgeDirection.NORTH) && !stairs3.facings.contains((Object)ForgeDirection.EAST)) {
                            int n10 = n5 = stairs3.arePositive ? 24 : 25;
                        }
                    }
                }
                if (tECarpentersBlock3 != null) {
                    if (stairs2.facings.contains((Object)ForgeDirection.WEST)) {
                        if (stairs4.facings.contains((Object)ForgeDirection.SOUTH) && !stairs4.facings.contains((Object)ForgeDirection.WEST)) {
                            int n11 = n5 = stairs4.arePositive ? 20 : 21;
                        }
                        if (stairs4.facings.contains((Object)ForgeDirection.NORTH) && !stairs4.facings.contains((Object)ForgeDirection.WEST)) {
                            int n12 = n5 = stairs4.arePositive ? 26 : 27;
                        }
                    }
                    if (stairs2.facings.contains((Object)ForgeDirection.EAST)) {
                        if (stairs4.facings.contains((Object)ForgeDirection.SOUTH) && !stairs4.facings.contains((Object)ForgeDirection.WEST)) {
                            int n13 = n5 = stairs4.arePositive ? 18 : 19;
                        }
                        if (stairs4.facings.contains((Object)ForgeDirection.NORTH) && !stairs4.facings.contains((Object)ForgeDirection.WEST)) {
                            int n14 = n5 = stairs4.arePositive ? 12 : 13;
                        }
                    }
                }
                if (tECarpentersBlock6 != null) {
                    if (stairs2.facings.contains((Object)ForgeDirection.NORTH)) {
                        if (stairs5.facings.contains((Object)ForgeDirection.EAST) && !stairs5.facings.contains((Object)ForgeDirection.SOUTH)) {
                            int n15 = n5 = stairs5.arePositive ? 12 : 13;
                        }
                        if (stairs5.facings.contains((Object)ForgeDirection.WEST) && !stairs5.facings.contains((Object)ForgeDirection.SOUTH)) {
                            int n16 = n5 = stairs5.arePositive ? 14 : 15;
                        }
                    }
                    if (stairs2.facings.contains((Object)ForgeDirection.SOUTH)) {
                        if (stairs5.facings.contains((Object)ForgeDirection.EAST) && !stairs5.facings.contains((Object)ForgeDirection.SOUTH)) {
                            int n17 = n5 = stairs5.arePositive ? 22 : 23;
                        }
                        if (stairs5.facings.contains((Object)ForgeDirection.WEST) && !stairs5.facings.contains((Object)ForgeDirection.SOUTH)) {
                            int n18 = n5 = stairs5.arePositive ? 20 : 21;
                        }
                    }
                }
                if (tECarpentersBlock7 != null) {
                    if (stairs2.facings.contains((Object)ForgeDirection.NORTH)) {
                        if (stairs6.facings.contains((Object)ForgeDirection.EAST) && !stairs6.facings.contains((Object)ForgeDirection.NORTH)) {
                            int n19 = n5 = stairs6.arePositive ? 24 : 25;
                        }
                        if (stairs6.facings.contains((Object)ForgeDirection.WEST) && !stairs6.facings.contains((Object)ForgeDirection.NORTH)) {
                            int n20 = n5 = stairs6.arePositive ? 26 : 27;
                        }
                    }
                    if (stairs2.facings.contains((Object)ForgeDirection.SOUTH)) {
                        if (stairs6.facings.contains((Object)ForgeDirection.EAST) && !stairs6.facings.contains((Object)ForgeDirection.NORTH)) {
                            int n21 = n5 = stairs6.arePositive ? 18 : 19;
                        }
                        if (stairs6.facings.contains((Object)ForgeDirection.WEST) && !stairs6.facings.contains((Object)ForgeDirection.NORTH)) {
                            int n22 = n5 = stairs6.arePositive ? 16 : 17;
                        }
                    }
                }
            }
            if (tECarpentersBlock6 != null) {
                if (tECarpentersBlock3 != null) {
                    if (stairs5.facings.contains((Object)ForgeDirection.EAST) && stairs4.facings.contains((Object)ForgeDirection.NORTH)) {
                        int n23 = n5 = stairs4.arePositive && stairs5.arePositive ? 12 : 13;
                    }
                    if (stairs5.facings.contains((Object)ForgeDirection.WEST) && stairs4.facings.contains((Object)ForgeDirection.SOUTH)) {
                        int n24 = n5 = stairs4.arePositive && stairs5.arePositive ? 20 : 21;
                    }
                }
                if (tECarpentersBlock2 != null) {
                    if (stairs5.facings.contains((Object)ForgeDirection.WEST) && stairs3.facings.contains((Object)ForgeDirection.NORTH)) {
                        int n25 = n5 = stairs3.arePositive && stairs5.arePositive ? 14 : 15;
                    }
                    if (stairs5.facings.contains((Object)ForgeDirection.EAST) && stairs3.facings.contains((Object)ForgeDirection.SOUTH)) {
                        int n26 = n5 = stairs3.arePositive && stairs5.arePositive ? 22 : 23;
                    }
                }
            }
            if (tECarpentersBlock7 != null) {
                if (tECarpentersBlock2 != null) {
                    if (stairs6.facings.contains((Object)ForgeDirection.WEST) && stairs3.facings.contains((Object)ForgeDirection.SOUTH)) {
                        int n27 = n5 = stairs3.arePositive && stairs6.arePositive ? 16 : 17;
                    }
                    if (stairs6.facings.contains((Object)ForgeDirection.EAST) && stairs3.facings.contains((Object)ForgeDirection.NORTH)) {
                        int n28 = n5 = stairs3.arePositive && stairs6.arePositive ? 24 : 25;
                    }
                }
                if (tECarpentersBlock3 != null) {
                    if (stairs6.facings.contains((Object)ForgeDirection.EAST) && stairs4.facings.contains((Object)ForgeDirection.SOUTH)) {
                        int n29 = n5 = stairs4.arePositive && stairs6.arePositive ? 18 : 19;
                    }
                    if (stairs6.facings.contains((Object)ForgeDirection.WEST) && stairs4.facings.contains((Object)ForgeDirection.NORTH)) {
                        int n30 = n5 = stairs4.arePositive && stairs6.arePositive ? 26 : 27;
                    }
                }
            }
            if (stairs2.facings.contains((Object)ForgeDirection.WEST)) {
                if (tECarpentersBlock6 != null && stairs2.arePositive == stairs5.arePositive) {
                    if (stairs5.facings.contains((Object)ForgeDirection.NORTH)) {
                        BlockProperties.setData(tECarpentersBlock6, stairs2.arePositive ? 26 : 27);
                    }
                    if (stairs5.facings.contains((Object)ForgeDirection.SOUTH)) {
                        BlockProperties.setData(tECarpentersBlock6, stairs2.arePositive ? 16 : 17);
                    }
                }
                if (tECarpentersBlock7 != null && stairs2.arePositive == stairs6.arePositive) {
                    if (stairs6.facings.contains((Object)ForgeDirection.SOUTH)) {
                        BlockProperties.setData(tECarpentersBlock7, stairs2.arePositive ? 20 : 21);
                    }
                    if (stairs6.facings.contains((Object)ForgeDirection.NORTH)) {
                        BlockProperties.setData(tECarpentersBlock7, stairs2.arePositive ? 14 : 15);
                    }
                }
            }
            if (stairs2.facings.contains((Object)ForgeDirection.EAST)) {
                if (tECarpentersBlock6 != null && stairs2.arePositive && stairs5.arePositive) {
                    if (stairs5.facings.contains((Object)ForgeDirection.NORTH)) {
                        BlockProperties.setData(tECarpentersBlock6, stairs2.arePositive ? 24 : 25);
                    }
                    if (stairs5.facings.contains((Object)ForgeDirection.SOUTH)) {
                        BlockProperties.setData(tECarpentersBlock6, stairs2.arePositive ? 18 : 19);
                    }
                }
                if (tECarpentersBlock7 != null && stairs2.arePositive && stairs6.arePositive) {
                    if (stairs6.facings.contains((Object)ForgeDirection.SOUTH)) {
                        BlockProperties.setData(tECarpentersBlock7, stairs2.arePositive ? 22 : 23);
                    }
                    if (stairs6.facings.contains((Object)ForgeDirection.NORTH)) {
                        BlockProperties.setData(tECarpentersBlock7, stairs2.arePositive ? 12 : 13);
                    }
                }
            }
            if (stairs2.facings.contains((Object)ForgeDirection.NORTH)) {
                if (tECarpentersBlock2 != null && stairs2.arePositive && stairs3.arePositive) {
                    if (stairs3.facings.contains((Object)ForgeDirection.WEST)) {
                        BlockProperties.setData(tECarpentersBlock2, stairs2.arePositive ? 26 : 27);
                    }
                    if (stairs3.facings.contains((Object)ForgeDirection.EAST)) {
                        BlockProperties.setData(tECarpentersBlock2, stairs2.arePositive ? 12 : 13);
                    }
                }
                if (tECarpentersBlock3 != null && stairs2.arePositive && stairs4.arePositive) {
                    if (stairs4.facings.contains((Object)ForgeDirection.EAST)) {
                        BlockProperties.setData(tECarpentersBlock3, stairs2.arePositive ? 24 : 25);
                    }
                    if (stairs4.facings.contains((Object)ForgeDirection.WEST)) {
                        BlockProperties.setData(tECarpentersBlock3, stairs2.arePositive ? 14 : 15);
                    }
                }
            }
            if (stairs2.facings.contains((Object)ForgeDirection.SOUTH)) {
                if (tECarpentersBlock2 != null && stairs2.arePositive && stairs3.arePositive) {
                    if (stairs3.facings.contains((Object)ForgeDirection.WEST)) {
                        BlockProperties.setData(tECarpentersBlock2, stairs2.arePositive ? 20 : 21);
                    }
                    if (stairs3.facings.contains((Object)ForgeDirection.EAST)) {
                        BlockProperties.setData(tECarpentersBlock2, stairs2.arePositive ? 18 : 19);
                    }
                }
                if (tECarpentersBlock3 != null && stairs2.arePositive && stairs4.arePositive) {
                    if (stairs4.facings.contains((Object)ForgeDirection.EAST)) {
                        BlockProperties.setData(tECarpentersBlock3, stairs2.arePositive ? 22 : 23);
                    }
                    if (stairs4.facings.contains((Object)ForgeDirection.WEST)) {
                        BlockProperties.setData(tECarpentersBlock3, stairs2.arePositive ? 16 : 17);
                    }
                }
            }
            if (tECarpentersBlock4 != null && stairs7.stairsType.equals((Object)Stairs.StairsType.NORMAL_XZ)) {
                n5 = stairs7.stairsID;
            }
            if (tECarpentersBlock5 != null && stairs8.stairsType.equals((Object)Stairs.StairsType.NORMAL_XZ)) {
                n5 = stairs8.stairsID;
            }
            if (!world.isRemote) {
                if (tECarpentersBlock2 != null && stairs3 != stairs9) {
                    BlockProperties.setData(tECarpentersBlock2, stairs3.stairsID);
                }
                if (tECarpentersBlock3 != null && stairs4 != stairs10) {
                    BlockProperties.setData(tECarpentersBlock3, stairs4.stairsID);
                }
                if (tECarpentersBlock6 != null && stairs5 != stairs13) {
                    BlockProperties.setData(tECarpentersBlock6, stairs5.stairsID);
                }
                if (tECarpentersBlock7 != null && stairs6 != stairs) {
                    BlockProperties.setData(tECarpentersBlock7, stairs6.stairsID);
                }
                if (tECarpentersBlock5 != null && stairs8 != stairs12) {
                    BlockProperties.setData(tECarpentersBlock5, stairs8.stairsID);
                }
                if (tECarpentersBlock4 != null && stairs7 != stairs11) {
                    BlockProperties.setData(tECarpentersBlock4, stairs7.stairsID);
                }
            }
        }
        BlockProperties.setData(tECarpentersBlock, n5);
    }

    @Override
    public boolean canCoverSide(TECarpentersBlock tECarpentersBlock, World world, int n, int n2, int n3, int n4) {
        return true;
    }

    @Override
    public int getRenderType() {
        return BlockHandler.carpentersStairsRenderID;
    }

    static class NamelessClass1094083828 {
        static final int[] $SwitchMap$carpentersblocks$data$Stairs$StairsType = new int[Stairs.StairsType.values().length];

        NamelessClass1094083828() {
        }

        static {
            try {
                NamelessClass1094083828.$SwitchMap$carpentersblocks$data$Stairs$StairsType[Stairs.StairsType.NORMAL_XZ.ordinal()] = 1;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            try {
                NamelessClass1094083828.$SwitchMap$carpentersblocks$data$Stairs$StairsType[Stairs.StairsType.NORMAL_Y.ordinal()] = 2;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            try {
                NamelessClass1094083828.$SwitchMap$carpentersblocks$data$Stairs$StairsType[Stairs.StairsType.NORMAL_INT.ordinal()] = 3;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            try {
                NamelessClass1094083828.$SwitchMap$carpentersblocks$data$Stairs$StairsType[Stairs.StairsType.NORMAL_EXT.ordinal()] = 4;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
        }
    }
}

