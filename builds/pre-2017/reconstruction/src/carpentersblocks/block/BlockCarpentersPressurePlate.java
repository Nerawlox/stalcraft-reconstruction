/*
 * Decompiled with CFR 0.152.
 */
package carpentersblocks.block;

import carpentersblocks.CarpentersBlocks;
import carpentersblocks.block.BlockBase;
import carpentersblocks.data.PressurePlate;
import carpentersblocks.tileentity.TECarpentersBlock;
import carpentersblocks.util.BlockProperties;
import carpentersblocks.util.handler.BlockHandler;
import cpw.mods.fml.common.registry.LanguageRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.List;
import java.util.Random;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockCarpentersPressurePlate
extends BlockBase {
    public BlockCarpentersPressurePlate(int n) {
        super(n, Material._d);
        this.setHardness(0.2f);
        this.setUnlocalizedName("blockCarpentersPressurePlate");
        this.setCreativeTab(CarpentersBlocks.tabCarpentersBlocks);
        this.setTickRandomly(true);
        this.setTextureName("carpentersblocks:slope/slope");
    }

    @Override
    protected boolean onHammerLeftClick(TECarpentersBlock tECarpentersBlock, EntityPlayer entityPlayer) {
        int n;
        int n2 = BlockProperties.getData(tECarpentersBlock);
        int n3 = n = PressurePlate.getPolarity(n2) == 0 ? 1 : 0;
        if (!tECarpentersBlock.worldObj.isRemote) {
            PressurePlate.setPolarity(tECarpentersBlock, n);
            tECarpentersBlock.worldObj.notifyBlocksOfNeighborChange(tECarpentersBlock.xCoord, tECarpentersBlock.yCoord - 1, tECarpentersBlock.zCoord, this.blockID);
        } else {
            switch (n) {
                case 0: {
                    entityPlayer.addChatMessage(LanguageRegistry.instance().getStringLocalization("message.polarity_pos.name"));
                    break;
                }
                case 1: {
                    entityPlayer.addChatMessage(LanguageRegistry.instance().getStringLocalization("message.polarity_neg.name"));
                }
            }
        }
        return true;
    }

    @Override
    protected boolean onHammerRightClick(TECarpentersBlock tECarpentersBlock, EntityPlayer entityPlayer, int n) {
        int n2;
        int n3 = BlockProperties.getData(tECarpentersBlock);
        switch (PressurePlate.getTriggerEntity(n3)) {
            case 0: {
                n2 = 1;
                break;
            }
            case 1: {
                n2 = 2;
                break;
            }
            case 2: {
                n2 = 3;
                break;
            }
            default: {
                n2 = 0;
            }
        }
        if (!tECarpentersBlock.worldObj.isRemote) {
            PressurePlate.setTriggerEntity(tECarpentersBlock, n2);
        } else {
            switch (n2) {
                case 0: {
                    entityPlayer.addChatMessage(LanguageRegistry.instance().getStringLocalization("message.trigger_player.name"));
                    break;
                }
                case 1: {
                    entityPlayer.addChatMessage(LanguageRegistry.instance().getStringLocalization("message.trigger_monster.name"));
                    break;
                }
                case 2: {
                    entityPlayer.addChatMessage(LanguageRegistry.instance().getStringLocalization("message.trigger_animal.name"));
                    break;
                }
                case 3: {
                    entityPlayer.addChatMessage(LanguageRegistry.instance().getStringLocalization("message.trigger_all.name"));
                }
            }
        }
        return true;
    }

    @Override
    public void setBlockBoundsBasedOnState(IBlockAccess iBlockAccess, int n, int n2, int n3) {
        TECarpentersBlock tECarpentersBlock = (TECarpentersBlock)iBlockAccess.getBlockTileEntity(n, n2, n3);
        this.setBlockBounds(0.0625f, 0.0f, 0.0625f, 0.9375f, this.isDepressed(tECarpentersBlock) ? 0.03125f : 0.0625f, 0.9375f);
    }

    @Override
    public void auxiliaryOnBlockPlacedBy(TECarpentersBlock tECarpentersBlock, World world, int n, int n2, int n3, EntityLivingBase entityLivingBase, ItemStack itemStack) {
        PressurePlate.setType(tECarpentersBlock, world.getBlockMetadata(n, n2, n3));
    }

    @Override
    public int tickRate(World world) {
        return 20;
    }

    @Override
    public AxisAlignedBB getCollisionBoundingBoxFromPool(World world, int n, int n2, int n3) {
        return null;
    }

    @Override
    public boolean canPlaceBlockAt(World world, int n, int n2, int n3) {
        return world.doesBlockHaveSolidTopSurface(n, n2 - 1, n3) || world.getBlockId(n, n2 - 1, n3) == BlockHandler.blockCarpentersBarrierID;
    }

    @Override
    protected void auxiliaryOnNeighborBlockChange(TECarpentersBlock tECarpentersBlock, World world, int n, int n2, int n3, int n4) {
        boolean bl = false;
        if (!world.doesBlockHaveSolidTopSurface(n, n2 - 1, n3) && world.getBlockId(n, n2 - 1, n3) != BlockHandler.blockCarpentersBarrierID) {
            bl = true;
        }
        if (bl) {
            int n5 = BlockProperties.getData(tECarpentersBlock);
            int n6 = PressurePlate.getType(n5);
            world.setBlockToAir(n, n2, n3);
        }
    }

    @Override
    public void updateTick(World world, int n, int n2, int n3, Random random) {
        if (!world.isRemote) {
            TECarpentersBlock tECarpentersBlock = (TECarpentersBlock)world.getBlockTileEntity(n, n2, n3);
            List list = world.getEntitiesWithinAABB(Entity.class, this.getSensitiveAABB(n, n2, n3));
            if (!list.isEmpty()) {
                for (int i = 0; i < list.size(); ++i) {
                    this.setStateIfMobCollidesWithPlate(tECarpentersBlock, (Entity)list.get(i), world, n, n2, n3);
                }
            } else {
                this.setStateIfMobCollidesWithPlate(tECarpentersBlock, null, world, n, n2, n3);
            }
        }
    }

    @Override
    public void onEntityCollidedWithBlock(World world, int n, int n2, int n3, Entity entity) {
        TECarpentersBlock tECarpentersBlock;
        List list;
        if (!(world.isRemote || (list = world.getEntitiesWithinAABB(Entity.class, this.getSensitiveAABB(n, n2, n3))).isEmpty() || this.isDepressed(tECarpentersBlock = (TECarpentersBlock)world.getBlockTileEntity(n, n2, n3)))) {
            for (int i = 0; i < list.size(); ++i) {
                this.setStateIfMobCollidesWithPlate(tECarpentersBlock, (Entity)list.get(i), world, n, n2, n3);
            }
        }
    }

    private void setStateIfMobCollidesWithPlate(TECarpentersBlock tECarpentersBlock, Entity entity, World world, int n, int n2, int n3) {
        BlockProperties.getData(tECarpentersBlock);
        boolean bl = this.isDepressed(tECarpentersBlock);
        if (this.shouldTrigger(tECarpentersBlock, entity, world, n, n2, n3)) {
            PressurePlate.setState(tECarpentersBlock, 1, true);
            this.notifyNeighborsOfUpdate(world, n, n2, n3);
            world.scheduleBlockUpdate(n, n2, n3, this.blockID, this.tickRate(world));
        } else if (bl) {
            PressurePlate.setState(tECarpentersBlock, 0, true);
            this.notifyNeighborsOfUpdate(world, n, n2, n3);
        }
    }

    private AxisAlignedBB getSensitiveAABB(int n, int n2, int n3) {
        return AxisAlignedBB._a()._a((float)n + 0.125f, n2, (float)n3 + 0.125f, (float)n + 1.0f - 0.125f, (double)n2 + 0.25, (float)n3 + 1.0f - 0.125f);
    }

    private void notifyNeighborsOfUpdate(World world, int n, int n2, int n3) {
        world.notifyBlocksOfNeighborChange(n, n2, n3, this.blockID);
        world.notifyBlocksOfNeighborChange(n, n2 - 1, n3, this.blockID);
    }

    private boolean isDepressed(TECarpentersBlock tECarpentersBlock) {
        int n = BlockProperties.getData(tECarpentersBlock);
        return PressurePlate.getState(n) == 1;
    }

    @Override
    public int isProvidingWeakPower(IBlockAccess iBlockAccess, int n, int n2, int n3, int n4) {
        TECarpentersBlock tECarpentersBlock = (TECarpentersBlock)iBlockAccess.getBlockTileEntity(n, n2, n3);
        int n5 = BlockProperties.getData(tECarpentersBlock);
        return this.getPowerSupply(tECarpentersBlock, n5);
    }

    @Override
    public int isProvidingStrongPower(IBlockAccess iBlockAccess, int n, int n2, int n3, int n4) {
        TECarpentersBlock tECarpentersBlock = (TECarpentersBlock)iBlockAccess.getBlockTileEntity(n, n2, n3);
        int n5 = BlockProperties.getData(tECarpentersBlock);
        return n4 == 1 ? this.getPowerSupply(tECarpentersBlock, n5) : 0;
    }

    @Override
    public boolean canProvidePower() {
        return true;
    }

    private int getPowerSupply(TECarpentersBlock tECarpentersBlock, int n) {
        int n2 = PressurePlate.getPolarity(n);
        return this.isDepressed(tECarpentersBlock) ? (n2 == 0 ? 15 : 0) : (n2 == 1 ? 15 : 0);
    }

    private boolean shouldTrigger(TECarpentersBlock tECarpentersBlock, Entity entity, World world, int n, int n2, int n3) {
        if (entity == null) {
            return false;
        }
        int n4 = PressurePlate.getTriggerEntity(BlockProperties.getData(tECarpentersBlock));
        switch (n4) {
            case 0: {
                return entity instanceof EntityPlayer;
            }
            case 1: {
                return entity.isCreatureType(EnumCreatureType._a, false);
            }
            case 2: {
                return entity.isCreatureType(EnumCreatureType._b, false);
            }
        }
        return true;
    }

    @Override
    public void auxiliaryBreakBlock(TECarpentersBlock tECarpentersBlock, World world, int n, int n2, int n3, int n4, int n5) {
        if (this.isDepressed(tECarpentersBlock)) {
            this.notifyNeighborsOfUpdate(world, n, n2, n3);
        }
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public boolean shouldSideBeRendered(IBlockAccess iBlockAccess, int n, int n2, int n3, int n4) {
        return n4 != 0;
    }

    @Override
    public int getRenderType() {
        return BlockHandler.carpentersPressurePlateRenderID;
    }
}

