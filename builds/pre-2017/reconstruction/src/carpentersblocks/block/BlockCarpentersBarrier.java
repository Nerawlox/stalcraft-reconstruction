/*
 * Decompiled with CFR 0.152.
 */
package carpentersblocks.block;

import carpentersblocks.CarpentersBlocks;
import carpentersblocks.block.BlockBase;
import carpentersblocks.data.Barrier;
import carpentersblocks.data.Gate;
import carpentersblocks.tileentity.TECarpentersBlock;
import carpentersblocks.util.BlockProperties;
import carpentersblocks.util.handler.BlockHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.List;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeDirection;

public class BlockCarpentersBarrier
extends BlockBase {
    public BlockCarpentersBarrier(int n) {
        super(n, Material._d);
        this.setHardness(0.2f);
        this.setUnlocalizedName("blockCarpentersBarrier");
        this.setCreativeTab(CarpentersBlocks.tabCarpentersBlocks);
        this.setTextureName("carpentersblocks:general/generic");
    }

    @Override
    protected boolean onHammerLeftClick(TECarpentersBlock tECarpentersBlock, EntityPlayer entityPlayer) {
        int n = BlockProperties.getData(tECarpentersBlock);
        Barrier.setPost(tECarpentersBlock, Barrier.getPost(n) == 1 ? 0 : 1);
        return true;
    }

    @Override
    protected boolean onHammerRightClick(TECarpentersBlock tECarpentersBlock, EntityPlayer entityPlayer, int n) {
        int n2 = BlockProperties.getData(tECarpentersBlock);
        int n3 = Barrier.getType(n2);
        if (entityPlayer.isSneaking()) {
            if (n3 <= 3 && ++n3 > 3) {
                n3 = 0;
            }
        } else if (n3 <= 3) {
            n3 = 4;
        } else if (++n3 > 6) {
            n3 = 0;
        }
        Barrier.setType(tECarpentersBlock, n3);
        return true;
    }

    @Override
    public void auxiliaryOnBlockPlacedBy(TECarpentersBlock tECarpentersBlock, World world, int n, int n2, int n3, EntityLivingBase entityLivingBase, ItemStack itemStack) {
        TECarpentersBlock tECarpentersBlock2;
        TECarpentersBlock tECarpentersBlock3 = world.getBlockId(n, n2 - 1, n3) != this.blockID && world.getBlockId(n, n2 - 1, n3) != BlockHandler.blockCarpentersGateID ? null : (TECarpentersBlock)world.getBlockTileEntity(n, n2 - 1, n3);
        TECarpentersBlock tECarpentersBlock4 = world.getBlockId(n, n2 + 1, n3) != this.blockID && world.getBlockId(n, n2 + 1, n3) != BlockHandler.blockCarpentersGateID ? null : (TECarpentersBlock)world.getBlockTileEntity(n, n2 + 1, n3);
        TECarpentersBlock tECarpentersBlock5 = world.getBlockId(n - 1, n2, n3) != this.blockID && world.getBlockId(n - 1, n2, n3) != BlockHandler.blockCarpentersGateID ? null : (TECarpentersBlock)world.getBlockTileEntity(n - 1, n2, n3);
        TECarpentersBlock tECarpentersBlock6 = world.getBlockId(n + 1, n2, n3) != this.blockID && world.getBlockId(n + 1, n2, n3) != BlockHandler.blockCarpentersGateID ? null : (TECarpentersBlock)world.getBlockTileEntity(n + 1, n2, n3);
        TECarpentersBlock tECarpentersBlock7 = world.getBlockId(n, n2, n3 - 1) != this.blockID && world.getBlockId(n, n2, n3 - 1) != BlockHandler.blockCarpentersGateID ? null : (TECarpentersBlock)world.getBlockTileEntity(n, n2, n3 - 1);
        TECarpentersBlock tECarpentersBlock8 = tECarpentersBlock2 = world.getBlockId(n, n2, n3 + 1) != this.blockID && world.getBlockId(n, n2, n3 + 1) != BlockHandler.blockCarpentersGateID ? null : (TECarpentersBlock)world.getBlockTileEntity(n, n2, n3 + 1);
        if (tECarpentersBlock3 != null) {
            int n4 = BlockProperties.getData(tECarpentersBlock3);
            Barrier.setType(tECarpentersBlock, world.getBlockId(n, n2 - 1, n3) == this.blockID ? Barrier.getType(n4) : Gate.getType(n4));
        } else if (tECarpentersBlock4 != null) {
            int n5 = BlockProperties.getData(tECarpentersBlock4);
            Barrier.setType(tECarpentersBlock, world.getBlockId(n, n2 + 1, n3) == this.blockID ? Barrier.getType(n5) : Gate.getType(n5));
        } else if (tECarpentersBlock5 != null) {
            int n6 = BlockProperties.getData(tECarpentersBlock5);
            Barrier.setType(tECarpentersBlock, world.getBlockId(n - 1, n2, n3) == this.blockID ? Barrier.getType(n6) : Gate.getType(n6));
        } else if (tECarpentersBlock6 != null) {
            int n7 = BlockProperties.getData(tECarpentersBlock6);
            Barrier.setType(tECarpentersBlock, world.getBlockId(n + 1, n2, n3) == this.blockID ? Barrier.getType(n7) : Gate.getType(n7));
        } else if (tECarpentersBlock7 != null) {
            int n8 = BlockProperties.getData(tECarpentersBlock7);
            Barrier.setType(tECarpentersBlock, world.getBlockId(n, n2, n3 - 1) == this.blockID ? Barrier.getType(n8) : Gate.getType(n8));
        } else if (tECarpentersBlock2 != null) {
            int n9 = BlockProperties.getData(tECarpentersBlock2);
            Barrier.setType(tECarpentersBlock, world.getBlockId(n, n2, n3 + 1) == this.blockID ? Barrier.getType(n9) : Gate.getType(n9));
        }
    }

    @Override
    public void addCollisionBoxesToList(World world, int n, int n2, int n3, AxisAlignedBB axisAlignedBB, List list2, Entity entity) {
        TECarpentersBlock tECarpentersBlock = (TECarpentersBlock)world.getBlockTileEntity(n, n2, n3);
        boolean bl = this.canConnectBarrierTo(tECarpentersBlock, world, n, n2, n3 - 1, ForgeDirection.SOUTH);
        boolean bl2 = this.canConnectBarrierTo(tECarpentersBlock, world, n, n2, n3 + 1, ForgeDirection.NORTH);
        boolean bl3 = this.canConnectBarrierTo(tECarpentersBlock, world, n - 1, n2, n3, ForgeDirection.EAST);
        boolean bl4 = this.canConnectBarrierTo(tECarpentersBlock, world, n + 1, n2, n3, ForgeDirection.WEST);
        float f = 0.375f;
        float f2 = 0.625f;
        float f3 = 0.375f;
        float f4 = 0.625f;
        if (bl) {
            f3 = 0.0f;
        }
        if (bl2) {
            f4 = 1.0f;
        }
        if (bl || bl2) {
            this.setBlockBounds(f, 0.0f, f3, f2, 1.5f, f4);
            super.addCollisionBoxesToList(world, n, n2, n3, axisAlignedBB, list2, entity);
        }
        f3 = 0.375f;
        f4 = 0.625f;
        if (bl3) {
            f = 0.0f;
        }
        if (bl4) {
            f2 = 1.0f;
        }
        if (bl3 || bl4 || !bl && !bl2) {
            this.setBlockBounds(f, 0.0f, f3, f2, 1.5f, f4);
            super.addCollisionBoxesToList(world, n, n2, n3, axisAlignedBB, list2, entity);
        }
        if (bl) {
            f3 = 0.0f;
        }
        if (bl2) {
            f4 = 1.0f;
        }
        this.setBlockBounds(f, 0.0f, f3, f2, 1.0f, f4);
    }

    @Override
    public void setBlockBoundsBasedOnState(IBlockAccess iBlockAccess, int n, int n2, int n3) {
        TECarpentersBlock tECarpentersBlock = (TECarpentersBlock)iBlockAccess.getBlockTileEntity(n, n2, n3);
        int n4 = Barrier.getType(BlockProperties.getData(tECarpentersBlock));
        boolean bl = this.canConnectBarrierTo(tECarpentersBlock, iBlockAccess, n, n2, n3 - 1, ForgeDirection.SOUTH);
        boolean bl2 = this.canConnectBarrierTo(tECarpentersBlock, iBlockAccess, n, n2, n3 + 1, ForgeDirection.NORTH);
        boolean bl3 = this.canConnectBarrierTo(tECarpentersBlock, iBlockAccess, n - 1, n2, n3, ForgeDirection.EAST);
        boolean bl4 = this.canConnectBarrierTo(tECarpentersBlock, iBlockAccess, n + 1, n2, n3, ForgeDirection.WEST);
        float f = 0.0f;
        float f2 = 1.0f;
        float f3 = 0.0f;
        float f4 = 1.0f;
        if (n4 <= 3) {
            f = 0.375f;
            f2 = 0.625f;
            f3 = 0.375f;
            f4 = 0.625f;
            if (bl) {
                f3 = 0.0f;
            }
            if (bl2) {
                f4 = 1.0f;
            }
            if (bl3) {
                f = 0.0f;
            }
            if (bl4) {
                f2 = 1.0f;
            }
        } else {
            f = 0.25f;
            f2 = 0.75f;
            f3 = 0.25f;
            f4 = 0.75f;
            if (bl) {
                f3 = 0.0f;
            }
            if (bl2) {
                f4 = 1.0f;
            }
            if (bl3) {
                f = 0.0f;
            }
            if (bl4) {
                f2 = 1.0f;
            }
            if (bl && bl2 && !bl3 && !bl4) {
                f = 0.3125f;
                f2 = 0.6875f;
            } else if (!bl && !bl2 && bl3 && bl4) {
                f3 = 0.3125f;
                f4 = 0.6875f;
            }
        }
        this.setBlockBounds(f, 0.0f, f3, f2, 1.0f, f4);
    }

    public boolean canConnectBarrierTo(TECarpentersBlock tECarpentersBlock, IBlockAccess iBlockAccess, int n, int n2, int n3, ForgeDirection forgeDirection) {
        int n4 = BlockProperties.getData(tECarpentersBlock);
        int n5 = iBlockAccess.getBlockId(n, n2, n3);
        if (n5 > 0) {
            Block block = Block.blocksList[iBlockAccess.getBlockId(n, n2, n3)];
            if (forgeDirection != ForgeDirection.UP) {
                if (iBlockAccess.getBlockId(n, n2, n3) != this.blockID && n5 != BlockHandler.blockCarpentersGateID) {
                    return block.isBlockSolidOnSide(tECarpentersBlock.worldObj, n, n2, n3, forgeDirection) && Barrier.getPost(n4) != 1;
                }
                return true;
            }
            if (block != null && block.blockMaterial == Material._q) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean canPlaceTorchOnTop(World world, int n, int n2, int n3) {
        return true;
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public boolean shouldSideBeRendered(IBlockAccess iBlockAccess, int n, int n2, int n3, int n4) {
        return true;
    }

    @Override
    public int getRenderType() {
        return BlockHandler.carpentersBarrierRenderID;
    }
}

