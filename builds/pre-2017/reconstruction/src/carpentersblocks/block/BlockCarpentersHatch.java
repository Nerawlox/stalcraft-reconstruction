/*
 * Decompiled with CFR 0.152.
 */
package carpentersblocks.block;

import carpentersblocks.CarpentersBlocks;
import carpentersblocks.block.BlockBase;
import carpentersblocks.block.BlockCarpentersBlock;
import carpentersblocks.block.BlockCarpentersStairs;
import carpentersblocks.data.Hatch;
import carpentersblocks.tileentity.TECarpentersBlock;
import carpentersblocks.util.BlockProperties;
import carpentersblocks.util.handler.BlockHandler;
import cpw.mods.fml.common.registry.LanguageRegistry;
import java.util.List;
import net.minecraft.block.Block;
import net.minecraft.block.BlockHalfSlab;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeDirection;

public class BlockCarpentersHatch
extends BlockBase {
    public BlockCarpentersHatch(int n) {
        super(n, Material._d);
        this.setHardness(0.2f);
        this.setUnlocalizedName("blockCarpentersHatch");
        this.setCreativeTab(CarpentersBlocks.tabCarpentersBlocks);
        this.setTextureName("carpentersblocks:general/generic");
    }

    @Override
    protected boolean onHammerLeftClick(TECarpentersBlock tECarpentersBlock, EntityPlayer entityPlayer) {
        BlockProperties.getData(tECarpentersBlock);
        if (!tECarpentersBlock.worldObj.isRemote) {
            this.findNextSideSupportBlock(tECarpentersBlock, tECarpentersBlock.worldObj, tECarpentersBlock.xCoord, tECarpentersBlock.yCoord, tECarpentersBlock.zCoord);
        }
        return true;
    }

    @Override
    protected boolean onHammerRightClick(TECarpentersBlock tECarpentersBlock, EntityPlayer entityPlayer, int n) {
        int n2 = BlockProperties.getData(tECarpentersBlock);
        if (!entityPlayer.isSneaking()) {
            if (!tECarpentersBlock.worldObj.isRemote) {
                int n3 = Hatch.getType(n2);
                if (++n3 > 4) {
                    n3 = 0;
                }
                Hatch.setType(tECarpentersBlock, n3);
            }
        } else {
            int n4;
            int n5 = n4 = Hatch.getRigidity(n2) == 0 ? 1 : 0;
            if (!tECarpentersBlock.worldObj.isRemote) {
                Hatch.setRigidity(tECarpentersBlock, n4);
            } else {
                switch (n4) {
                    case 0: {
                        entityPlayer.addChatMessage(LanguageRegistry.instance().getStringLocalization("message.activation_wood.name"));
                        break;
                    }
                    case 1: {
                        entityPlayer.addChatMessage(LanguageRegistry.instance().getStringLocalization("message.activation_iron.name"));
                    }
                }
            }
        }
        return true;
    }

    @Override
    public boolean auxiliaryOnBlockActivated(TECarpentersBlock tECarpentersBlock, World world, int n, int n2, int n3, EntityPlayer entityPlayer, int n4, float f, float f2, float f3) {
        int n5 = BlockProperties.getData(tECarpentersBlock);
        if (!this.activationRequiresRedstone(tECarpentersBlock, n5)) {
            Hatch.setState(tECarpentersBlock, Hatch.getState(n5) == 0 ? 1 : 0);
        }
        return true;
    }

    private boolean activationRequiresRedstone(TECarpentersBlock tECarpentersBlock, int n) {
        return Hatch.getRigidity(n) == 1;
    }

    @Override
    public void setBlockBoundsBasedOnState(IBlockAccess iBlockAccess, int n, int n2, int n3) {
        TECarpentersBlock tECarpentersBlock = (TECarpentersBlock)iBlockAccess.getBlockTileEntity(n, n2, n3);
        int n4 = BlockProperties.getData(tECarpentersBlock);
        boolean bl = Hatch.getPos(n4) == 1;
        boolean bl2 = Hatch.getState(n4) == 1;
        int n5 = Hatch.getDir(n4);
        if (bl) {
            this.setBlockBounds(0.0f, 0.8125f, 0.0f, 1.0f, 1.0f, 1.0f);
        } else {
            this.setBlockBounds(0.0f, 0.0f, 0.0f, 1.0f, 0.1875f, 1.0f);
        }
        if (bl2) {
            switch (n5) {
                case 0: {
                    this.setBlockBounds(0.0f, 0.0f, 0.8125f, 1.0f, 1.0f, 1.0f);
                    break;
                }
                case 1: {
                    this.setBlockBounds(0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 0.1875f);
                    break;
                }
                case 2: {
                    this.setBlockBounds(0.8125f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f);
                    break;
                }
                case 3: {
                    this.setBlockBounds(0.0f, 0.0f, 0.0f, 0.1875f, 1.0f, 1.0f);
                }
            }
        }
    }

    @Override
    public void addCollisionBoxesToList(World world, int n, int n2, int n3, AxisAlignedBB axisAlignedBB, List list2, Entity entity) {
        this.setBlockBoundsBasedOnState(world, n, n2, n3);
        super.addCollisionBoxesToList(world, n, n2, n3, axisAlignedBB, list2, entity);
    }

    @Override
    protected void auxiliaryOnNeighborBlockChange(TECarpentersBlock tECarpentersBlock, World world, int n, int n2, int n3, int n4) {
        boolean bl;
        int n5 = BlockProperties.getData(tECarpentersBlock);
        int n6 = Hatch.getDir(n5);
        int n7 = Hatch.getState(n5);
        int n8 = n;
        int n9 = n3;
        switch (n6) {
            case 0: {
                n9 = n3 + 1;
                break;
            }
            case 1: {
                n9 = n3 - 1;
                break;
            }
            case 2: {
                n8 = n + 1;
                break;
            }
            case 3: {
                n8 = n - 1;
            }
        }
        if (!this.isValidSupportBlock(world, n, n2, n3, world.getBlockId(n8, n2, n9), n6 + 2) && !world.isBlockSolidOnSide(n8, n2, n9, ForgeDirection.getOrientation(n6 + 2))) {
            this.findNextSideSupportBlock(tECarpentersBlock, world, n, n2, n3);
        }
        boolean bl2 = world.isBlockIndirectlyGettingPowered(n, n2, n3);
        boolean bl3 = bl = n7 == 1;
        if (n4 > 0 && Block.blocksList[n4].canProvidePower() && bl2 != bl) {
            Hatch.setState(tECarpentersBlock, n7 == 1 ? 0 : 1);
        }
    }

    @Override
    public MovingObjectPosition collisionRayTrace(World world, int n, int n2, int n3, Vec3 vec3, Vec3 vec32) {
        this.setBlockBoundsBasedOnState(world, n, n2, n3);
        return super.collisionRayTrace(world, n, n2, n3, vec3, vec32);
    }

    @Override
    public int onBlockPlaced(World world, int n, int n2, int n3, int n4, float f, float f2, float f3, int n5) {
        int n6 = 0;
        if (n4 > 1) {
            n6 = n4 - 2;
        }
        if (n4 != 1 && n4 != 0 && f2 > 0.5f) {
            n6 |= 8;
        }
        return n6;
    }

    @Override
    public void auxiliaryOnBlockPlacedBy(TECarpentersBlock tECarpentersBlock, World world, int n, int n2, int n3, EntityLivingBase entityLivingBase, ItemStack itemStack) {
        boolean bl;
        int n4 = world.getBlockMetadata(n, n2, n3);
        Hatch.setDir(tECarpentersBlock, n4 & 3);
        boolean bl2 = bl = (n4 & 8) > 0;
        if (bl) {
            Hatch.setPos(tECarpentersBlock, 1);
        }
    }

    @Override
    public boolean canPlaceBlockOnSide(World world, int n, int n2, int n3, int n4) {
        switch (n4) {
            case 2: {
                return this.isValidSupportBlock(world, n, n2, n3, world.getBlockId(n, n2, n3 + 1), 3) || world.isBlockSolidOnSide(n, n2, n3 + 1, ForgeDirection.getOrientation(ForgeDirection.OPPOSITES[3]));
            }
            case 3: {
                return this.isValidSupportBlock(world, n, n2, n3, world.getBlockId(n, n2, n3 - 1), 2) || world.isBlockSolidOnSide(n, n2, n3 - 1, ForgeDirection.getOrientation(ForgeDirection.OPPOSITES[2]));
            }
            case 4: {
                return this.isValidSupportBlock(world, n, n2, n3, world.getBlockId(n + 1, n2, n3), 5) || world.isBlockSolidOnSide(n + 1, n2, n3, ForgeDirection.getOrientation(ForgeDirection.OPPOSITES[5]));
            }
            case 5: {
                return this.isValidSupportBlock(world, n, n2, n3, world.getBlockId(n - 1, n2, n3), 4) || world.isBlockSolidOnSide(n - 1, n2, n3, ForgeDirection.getOrientation(ForgeDirection.OPPOSITES[4]));
            }
        }
        return false;
    }

    private void findNextSideSupportBlock(TECarpentersBlock tECarpentersBlock, World world, int n, int n2, int n3) {
        int n4;
        int n5 = BlockProperties.getData(tECarpentersBlock);
        int n6 = Hatch.getDir(n5);
        if (++n6 > 3) {
            n6 = 0;
        }
        for (n4 = 0; !this.canPlaceBlockOnSide(world, n, n2, n3, n6 + 2) && n4 < 4; ++n4) {
            if (++n6 <= 3) continue;
            n6 = 0;
        }
        if (n4 == 4) {
            world.setBlockToAir(n, n2, n3);
        } else {
            Hatch.setDir(tECarpentersBlock, n6);
        }
    }

    private boolean isValidSupportBlock(World world, int n, int n2, int n3, int n4, int n5) {
        Block block = Block.blocksList[n4];
        return block == Block.glowStone || block instanceof BlockCarpentersStairs || block instanceof BlockCarpentersBlock || block instanceof BlockHalfSlab || block instanceof yuxu;
    }

    @Override
    public int getRenderType() {
        return BlockHandler.carpentersHatchRenderID;
    }
}

