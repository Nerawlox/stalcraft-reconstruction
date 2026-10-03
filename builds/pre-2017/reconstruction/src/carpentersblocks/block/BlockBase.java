/*
 * Decompiled with CFR 0.152.
 */
package carpentersblocks.block;

import carpentersblocks.tileentity.TECarpentersBlock;
import carpentersblocks.util.BlockProperties;
import carpentersblocks.util.handler.EventHandler;
import carpentersblocks.util.handler.FeatureHandler;
import carpentersblocks.util.handler.ItemHandler;
import carpentersblocks.util.handler.PatternHandler;
import carpentersblocks.util.handler.PlantHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import gloomyfolken.mods.stalker.misc.StalkerMiscMod;
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.BlockDirectional;
import net.minecraft.block.BlockFlower;
import net.minecraft.block.material.Material;
import net.minecraft.client.particle.EffectRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.boss.EntityDragon;
import net.minecraft.entity.boss.EntityWither;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Icon;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;
import net.minecraft.util.sajh;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.client.ForgeHooksClient;
import net.minecraftforge.common.EnumPlantType;
import net.minecraftforge.common.ForgeDirection;
import net.minecraftforge.common.IPlantable;

public class BlockBase
extends BlockContainer {
    public BlockBase(int n, Material material) {
        super(n, material);
    }

    protected boolean willCoverRecurse(IBlockAccess iBlockAccess, int n, int n2, int n3) {
        TECarpentersBlock tECarpentersBlock = (TECarpentersBlock)iBlockAccess.getBlockTileEntity(n, n2, n3);
        return BlockProperties.getCoverBlock((TECarpentersBlock)tECarpentersBlock, (int)6).blockID == this.blockID;
    }

    protected boolean extendsBlockBase(IBlockAccess iBlockAccess, int n, int n2, int n3) {
        int n4 = iBlockAccess.getBlockId(n, n2, n3);
        return n4 > 0 && Block.blocksList[n4] instanceof BlockBase;
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public Icon getBlockTexture(IBlockAccess iBlockAccess, int n, int n2, int n3, int n4) {
        TECarpentersBlock tECarpentersBlock = (TECarpentersBlock)iBlockAccess.getBlockTileEntity(n, n2, n3);
        return BlockProperties.getCoverBlock(tECarpentersBlock, 6).getIcon(n4, BlockProperties.getCoverMetadata(tECarpentersBlock, 6));
    }

    @Override
    public void onBlockClicked(World world, int n, int n2, int n3, EntityPlayer entityPlayer) {
        TECarpentersBlock tECarpentersBlock = (TECarpentersBlock)world.getBlockTileEntity(n, n2, n3);
        ItemStack itemStack = entityPlayer.getCurrentEquippedItem();
        if (itemStack != null) {
            int n4 = EventHandler.eventFace;
            int n5 = BlockProperties.hasCover(tECarpentersBlock, n4) ? n4 : 6;
            Item item = itemStack._a();
            if (item.equals(ItemHandler.itemCarpentersHammer)) {
                boolean bl = false;
                if (entityPlayer.isSneaking()) {
                    if (!world.isRemote) {
                        if (BlockProperties.hasOverlay(tECarpentersBlock, n5)) {
                            bl = BlockProperties.setOverlay(tECarpentersBlock, n5, null);
                        } else if (BlockProperties.hasDyeColor(tECarpentersBlock, n5)) {
                            bl = BlockProperties.setDyeColor(tECarpentersBlock, n5, 0);
                        } else if (BlockProperties.hasCover(tECarpentersBlock, n5)) {
                            BlockProperties.setCover(tECarpentersBlock, n5, 0, null);
                            bl = BlockProperties.setPattern(tECarpentersBlock, n5, 0);
                        }
                    }
                } else {
                    bl = this.onHammerLeftClick(tECarpentersBlock, entityPlayer);
                }
                if (bl) {
                    if (!entityPlayer.capabilities._d) {
                        world.playSoundEffect((double)n + 0.5, (double)n2 + 0.5, (double)n3 + 0.5, "dig.wood", 4.0f, 1.0f);
                    }
                    this.onNeighborBlockChange(world, n, n2, n3, this.blockID);
                    world.notifyBlocksOfNeighborChange(n, n2, n3, this.blockID);
                }
            } else if (!world.isRemote && item.equals(ItemHandler.itemCarpentersChisel)) {
                if (entityPlayer.isSneaking()) {
                    if (BlockProperties.hasPattern(tECarpentersBlock, n5)) {
                        BlockProperties.setPattern(tECarpentersBlock, n5, 0);
                    }
                } else if (BlockProperties.hasCover(tECarpentersBlock, n5) && BlockProperties.getCoverBlock(tECarpentersBlock, n5).isOpaqueCube()) {
                    this.onChiselClick(tECarpentersBlock, n5, true);
                }
            }
        }
        this.auxiliaryOnBlockClicked(tECarpentersBlock, world, n, n2, n3, entityPlayer);
    }

    @Override
    public boolean onBlockActivated(World world, int n, int n2, int n3, EntityPlayer entityPlayer, int n4, float f, float f2, float f3) {
        TECarpentersBlock tECarpentersBlock = (TECarpentersBlock)world.getBlockTileEntity(n, n2, n3);
        ItemStack itemStack = entityPlayer.getCurrentEquippedItem();
        boolean bl = false;
        boolean bl2 = false;
        if (itemStack != null) {
            int n5;
            int n6 = n5 = BlockProperties.hasCover(tECarpentersBlock, n4) ? n4 : 6;
            if (itemStack._a() == ItemHandler.itemCarpentersHammer) {
                bl = this.onHammerRightClick(tECarpentersBlock, entityPlayer, n4);
            } else if (ItemHandler.enableChisel && itemStack._a() == ItemHandler.itemCarpentersChisel) {
                if (world.isRemote) {
                    return true;
                }
                if (BlockProperties.hasCover(tECarpentersBlock, n5) && BlockProperties.getCoverBlock(tECarpentersBlock, n5).isOpaqueCube()) {
                    bl = this.onChiselClick(tECarpentersBlock, n5, false);
                }
            } else if (FeatureHandler.enableCovers && BlockProperties.isCover(itemStack._a(), itemStack._j())) {
                int n7;
                Block block = Block.blocksList[itemStack._d];
                int n8 = n7 = block instanceof BlockDirectional ? sajh._c((double)(EventHandler.eventEntity.rotationYaw * 4.0f / 360.0f) + 2.5) & 3 : itemStack._j();
                if (!BlockProperties.hasCover(tECarpentersBlock, 6)) {
                    if (BlockProperties.blockRotates(world, block, n, n2, n3)) {
                        n7 = block.onBlockPlaced(world, n, n2, n3, n4, f, f2, f3, n7);
                    }
                    bl = bl2 = BlockProperties.setCover(tECarpentersBlock, 6, n7, itemStack);
                } else if (FeatureHandler.enableSideCovers && !BlockProperties.hasCover(tECarpentersBlock, n4) && this.canCoverSide(tECarpentersBlock, world, n, n2, n3, n4)) {
                    if (BlockProperties.blockRotates(world, block, n, n2, n3)) {
                        int n9 = sajh._c((double)(EventHandler.eventEntity.rotationYaw * 4.0f / 360.0f) + 2.5) & 3;
                        int n10 = entityPlayer.rotationPitch < -45.0f ? 0 : (entityPlayer.rotationPitch > 45.0f ? 1 : (n9 == 0 ? 3 : (n9 == 1 ? 4 : (n9 == 2 ? 2 : 5))));
                        n7 = block.onBlockPlaced(world, n, n2, n3, n10, f, f2, f3, n7);
                    }
                    bl = bl2 = BlockProperties.setCover(tECarpentersBlock, n4, n7, itemStack);
                }
            } else if (FeatureHandler.enableOverlays && BlockProperties.isOverlay(itemStack._d)) {
                if (world.isRemote) {
                    return true;
                }
                if (!BlockProperties.hasOverlay(tECarpentersBlock, n5) && (n5 < 6 && BlockProperties.hasCover(tECarpentersBlock, n5) || n5 == 6)) {
                    bl = bl2 = BlockProperties.setOverlay(tECarpentersBlock, n5, itemStack);
                }
            } else if (FeatureHandler.enableDyeColors && itemStack._a() == Item.dyePowder && itemStack._j() != 15) {
                if (world.isRemote) {
                    return true;
                }
                if (!BlockProperties.hasDyeColor(tECarpentersBlock, n5)) {
                    bl = bl2 = BlockProperties.setDyeColor(tECarpentersBlock, n5, 15 - itemStack._j());
                }
            }
        }
        if (!bl) {
            bl = this.auxiliaryOnBlockActivated(tECarpentersBlock, world, n, n2, n3, entityPlayer, n4, f, f2, f3);
        } else {
            itemStack._a(1, (EntityLivingBase)entityPlayer);
            if (!entityPlayer.capabilities._d) {
                world.playSoundEffect((double)n + 0.5, (double)n2 + 0.5, (double)n3 + 0.5, "dig.wood", 4.0f, 1.0f);
            }
            this.onNeighborBlockChange(world, n, n2, n3, this.blockID);
            world.notifyBlocksOfNeighborChange(n, n2, n3, this.blockID);
        }
        if (!world.isRemote && bl2 && !entityPlayer.capabilities._d && --itemStack._b <= 0) {
            entityPlayer.inventory.setInventorySlotContents(entityPlayer.inventory._c, null);
        }
        return bl;
    }

    public boolean onChiselClick(TECarpentersBlock tECarpentersBlock, int n, boolean bl) {
        int n2 = BlockProperties.getPattern(tECarpentersBlock, n);
        int n3 = 0;
        if (n2 == 0) {
            TECarpentersBlock tECarpentersBlock2;
            TECarpentersBlock tECarpentersBlock3 = this.extendsBlockBase(tECarpentersBlock.worldObj, tECarpentersBlock.xCoord - 1, tECarpentersBlock.yCoord, tECarpentersBlock.zCoord) ? (TECarpentersBlock)tECarpentersBlock.worldObj.getBlockTileEntity(tECarpentersBlock.xCoord - 1, tECarpentersBlock.yCoord, tECarpentersBlock.zCoord) : null;
            TECarpentersBlock tECarpentersBlock4 = this.extendsBlockBase(tECarpentersBlock.worldObj, tECarpentersBlock.xCoord + 1, tECarpentersBlock.yCoord, tECarpentersBlock.zCoord) ? (TECarpentersBlock)tECarpentersBlock.worldObj.getBlockTileEntity(tECarpentersBlock.xCoord + 1, tECarpentersBlock.yCoord, tECarpentersBlock.zCoord) : null;
            TECarpentersBlock tECarpentersBlock5 = this.extendsBlockBase(tECarpentersBlock.worldObj, tECarpentersBlock.xCoord, tECarpentersBlock.yCoord - 1, tECarpentersBlock.zCoord) ? (TECarpentersBlock)tECarpentersBlock.worldObj.getBlockTileEntity(tECarpentersBlock.xCoord, tECarpentersBlock.yCoord - 1, tECarpentersBlock.zCoord) : null;
            TECarpentersBlock tECarpentersBlock6 = this.extendsBlockBase(tECarpentersBlock.worldObj, tECarpentersBlock.xCoord, tECarpentersBlock.yCoord + 1, tECarpentersBlock.zCoord) ? (TECarpentersBlock)tECarpentersBlock.worldObj.getBlockTileEntity(tECarpentersBlock.xCoord, tECarpentersBlock.yCoord + 1, tECarpentersBlock.zCoord) : null;
            TECarpentersBlock tECarpentersBlock7 = this.extendsBlockBase(tECarpentersBlock.worldObj, tECarpentersBlock.xCoord, tECarpentersBlock.yCoord, tECarpentersBlock.zCoord - 1) ? (TECarpentersBlock)tECarpentersBlock.worldObj.getBlockTileEntity(tECarpentersBlock.xCoord, tECarpentersBlock.yCoord, tECarpentersBlock.zCoord - 1) : null;
            TECarpentersBlock tECarpentersBlock8 = tECarpentersBlock2 = this.extendsBlockBase(tECarpentersBlock.worldObj, tECarpentersBlock.xCoord, tECarpentersBlock.yCoord, tECarpentersBlock.zCoord + 1) ? (TECarpentersBlock)tECarpentersBlock.worldObj.getBlockTileEntity(tECarpentersBlock.xCoord, tECarpentersBlock.yCoord, tECarpentersBlock.zCoord + 1) : null;
            if (tECarpentersBlock3 != null && BlockProperties.hasPattern(tECarpentersBlock3, n)) {
                n3 = n2 = BlockProperties.getPattern(tECarpentersBlock3, n);
            } else if (tECarpentersBlock4 != null && BlockProperties.hasPattern(tECarpentersBlock4, n)) {
                n3 = n2 = BlockProperties.getPattern(tECarpentersBlock4, n);
            } else if (tECarpentersBlock5 != null && BlockProperties.hasPattern(tECarpentersBlock5, n)) {
                n3 = n2 = BlockProperties.getPattern(tECarpentersBlock5, n);
            } else if (tECarpentersBlock6 != null && BlockProperties.hasPattern(tECarpentersBlock6, n)) {
                n3 = n2 = BlockProperties.getPattern(tECarpentersBlock6, n);
            } else if (tECarpentersBlock7 != null && BlockProperties.hasPattern(tECarpentersBlock7, n)) {
                n3 = n2 = BlockProperties.getPattern(tECarpentersBlock7, n);
            } else if (tECarpentersBlock2 != null && BlockProperties.hasPattern(tECarpentersBlock2, n)) {
                n3 = n2 = BlockProperties.getPattern(tECarpentersBlock2, n);
            }
        }
        if (n3 == 0) {
            n2 = bl ? PatternHandler.getPrev(n2) : PatternHandler.getNext(n2);
        }
        BlockProperties.setPattern(tECarpentersBlock, n, n2);
        return true;
    }

    @Override
    public void onNeighborBlockChange(World world, int n, int n2, int n3, int n4) {
        TECarpentersBlock tECarpentersBlock = null;
        if (!world.isRemote && BlockProperties.hasSideCovers(tECarpentersBlock = (TECarpentersBlock)world.getBlockTileEntity(n, n2, n3))) {
            for (int i = 0; i < 6; ++i) {
                Block block;
                if (!BlockProperties.hasCover(tECarpentersBlock, i)) continue;
                if (!this.canCoverSide(tECarpentersBlock, world, n, n2, n3, i)) {
                    return;
                }
                ForgeDirection forgeDirection = ForgeDirection.getOrientation(i);
                int n5 = n + forgeDirection.offsetX;
                int n6 = n2 + forgeDirection.offsetY;
                int n7 = n3 + forgeDirection.offsetZ;
                if (world.getBlockId(n5, n6, n7) > 0 && !(block = Block.blocksList[world.getBlockId(n5, n6, n7)]).isBlockSolidOnSide(world, n5, n6, n7, ForgeDirection.getOrientation(ForgeDirection.OPPOSITES[i]))) continue;
            }
        }
        if (tECarpentersBlock != null) {
            this.auxiliaryOnNeighborBlockChange(tECarpentersBlock, world, n, n2, n3, n4);
        }
    }

    @Override
    public int isProvidingWeakPower(IBlockAccess iBlockAccess, int n, int n2, int n3, int n4) {
        if (!this.willCoverRecurse(iBlockAccess, n, n2, n3)) {
            TECarpentersBlock tECarpentersBlock = (TECarpentersBlock)iBlockAccess.getBlockTileEntity(n, n2, n3);
            int n5 = ForgeDirection.OPPOSITES[n4];
            int n6 = BlockProperties.getCoverBlock(iBlockAccess, 6, n, n2, n3).isProvidingWeakPower(iBlockAccess, n, n2, n3, n4);
            int n7 = BlockProperties.hasCover(tECarpentersBlock, n5) ? BlockProperties.getCoverBlock(tECarpentersBlock, n5).isProvidingWeakPower(iBlockAccess, n, n2, n3, n4) : 0;
            return n7 > n6 ? n7 : n6;
        }
        return 0;
    }

    @Override
    public int isProvidingStrongPower(IBlockAccess iBlockAccess, int n, int n2, int n3, int n4) {
        if (!this.willCoverRecurse(iBlockAccess, n, n2, n3)) {
            TECarpentersBlock tECarpentersBlock = (TECarpentersBlock)iBlockAccess.getBlockTileEntity(n, n2, n3);
            int n5 = ForgeDirection.OPPOSITES[n4];
            int n6 = BlockProperties.getCoverBlock(iBlockAccess, 6, n, n2, n3).isProvidingStrongPower(iBlockAccess, n, n2, n3, n4);
            int n7 = BlockProperties.hasCover(tECarpentersBlock, n5) ? BlockProperties.getCoverBlock(tECarpentersBlock, n5).isProvidingStrongPower(iBlockAccess, n, n2, n3, n4) : 0;
            return n7 > n6 ? n7 : n6;
        }
        return 0;
    }

    private boolean suppressDestroyBlock(EntityPlayer entityPlayer, ItemStack itemStack) {
        return entityPlayer.capabilities._d && itemStack != null && (itemStack._a() == ItemHandler.itemCarpentersHammer || itemStack._a() == ItemHandler.itemCarpentersChisel);
    }

    @Override
    public boolean removeBlockByPlayer(World world, EntityPlayer entityPlayer, int n, int n2, int n3) {
        if (!this.suppressDestroyBlock(entityPlayer, entityPlayer.getHeldItem())) {
            return world.setBlockToAir(n, n2, n3);
        }
        this.onBlockClicked(world, n, n2, n3, entityPlayer);
        return false;
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public boolean addBlockDestroyEffects(World world, int n, int n2, int n3, int n4, EffectRenderer effectRenderer) {
        EntityPlayer entityPlayer;
        if (world.getBlockId(n, n2, n3) == this.blockID && (entityPlayer = world.getClosestPlayer(n, n2, n3, 6.5)) != null) {
            return this.suppressDestroyBlock(entityPlayer, entityPlayer.getHeldItem());
        }
        return false;
    }

    @Override
    public int getLightValue(IBlockAccess iBlockAccess, int n, int n2, int n3) {
        Block block = Block.blocksList[iBlockAccess.getBlockId(n, n2, n3)];
        if (block != null && block.blockID == this.blockID) {
            TECarpentersBlock tECarpentersBlock = (TECarpentersBlock)iBlockAccess.getBlockTileEntity(n, n2, n3);
            int n4 = 0;
            for (int i = 0; i < 7; ++i) {
                int n5;
                if (!BlockProperties.hasCover(tECarpentersBlock, i) || (n5 = Block.lightValue[BlockProperties.getCoverID(tECarpentersBlock, i)]) <= n4) continue;
                n4 = n5;
            }
            return n4;
        }
        return Block.lightValue[this.blockID];
    }

    @Override
    public float getBlockHardness(World world, int n, int n2, int n3) {
        return world.getBlockId(n, n2, n3) == this.blockID && !this.willCoverRecurse(world, n, n2, n3) ? BlockProperties.getCoverBlock(world, 6, n, n2, n3).getBlockHardness(world, n, n2, n3) : this.blockHardness;
    }

    @Override
    public int getFlammability(IBlockAccess iBlockAccess, int n, int n2, int n3, int n4, ForgeDirection forgeDirection) {
        return Block.blockFlammability[BlockProperties.getCoverBlock((IBlockAccess)iBlockAccess, (int)6, (int)n, (int)n2, (int)n3).blockID];
    }

    @Override
    public int getFireSpreadSpeed(World world, int n, int n2, int n3, int n4, ForgeDirection forgeDirection) {
        return Block.blockFlammability[BlockProperties.getCoverBlock((IBlockAccess)world, (int)6, (int)n, (int)n2, (int)n3).blockID];
    }

    @Override
    public boolean isFireSource(World world, int n, int n2, int n3, int n4, ForgeDirection forgeDirection) {
        Block block;
        return !this.willCoverRecurse(world, n, n2, n3) && (block = BlockProperties.getCoverBlock(world, 6, n, n2, n3)).isBlockSolidOnSide(world, n, n2, n3, ForgeDirection.UP) && forgeDirection == ForgeDirection.UP && block.isFireSource(world, n, n2, n3, n4, forgeDirection);
    }

    @Override
    public float getExplosionResistance(Entity entity, World world, int n, int n2, int n3, double d, double d2, double d3) {
        return !this.willCoverRecurse(world, n, n2, n3) ? BlockProperties.getCoverBlock(world, 6, n, n2, n3).getExplosionResistance(entity) : this.getExplosionResistance(entity);
    }

    @Override
    public boolean isWood(World world, int n, int n2, int n3) {
        return !this.willCoverRecurse(world, n, n2, n3) ? BlockProperties.getCoverBlock(world, 6, n, n2, n3).isWood(world, n, n2, n3) : false;
    }

    @Override
    public boolean canEntityDestroy(World world, int n, int n2, int n3, Entity entity) {
        if (!this.willCoverRecurse(world, n, n2, n3)) {
            int n4 = BlockProperties.getCoverBlock((IBlockAccess)world, (int)6, (int)n, (int)n2, (int)n3).blockID;
            if (entity instanceof EntityWither) {
                return n4 != Block.bedrock.blockID && n4 != Block.endPortal.blockID && n4 != Block.endPortalFrame.blockID;
            }
            if (entity instanceof EntityDragon) {
                return this.canDragonDestroy(world, n, n2, n3);
            }
        }
        return true;
    }

    @Override
    public boolean canDragonDestroy(World world, int n, int n2, int n3) {
        return !this.willCoverRecurse(world, n, n2, n3) ? BlockProperties.getCoverBlock(world, 6, n, n2, n3).canDragonDestroy(world, n, n2, n3) : super.canDragonDestroy(world, n, n2, n3);
    }

    @Override
    public void breakBlock(World world, int n, int n2, int n3, int n4, int n5) {
        TECarpentersBlock tECarpentersBlock = (TECarpentersBlock)world.getBlockTileEntity(n, n2, n3);
        if (tECarpentersBlock != null) {
            for (int i = 0; i < 7; ++i) {
                BlockProperties.clearAttributes(tECarpentersBlock, i);
            }
            this.auxiliaryBreakBlock(tECarpentersBlock, world, n, n2, n3, n4, n5);
        }
        super.breakBlock(world, n, n2, n3, n4, n5);
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public void randomDisplayTick(World world, int n, int n2, int n3, Random random) {
        TECarpentersBlock tECarpentersBlock;
        if (!this.willCoverRecurse(world, n, n2, n3)) {
            BlockProperties.getCoverBlock(world, 6, n, n2, n3).randomDisplayTick(world, n, n2, n3, random);
        }
        if (world.getBlockId(n, n2, n3) == this.blockID && BlockProperties.getOverlay(tECarpentersBlock = (TECarpentersBlock)world.getBlockTileEntity(n, n2, n3), 6) == 6) {
            Block.mycelium.randomDisplayTick(world, n, n2, n3, random);
        }
    }

    @Override
    public boolean canSustainPlant(World world, int n, int n2, int n3, ForgeDirection forgeDirection, IPlantable iPlantable) {
        TECarpentersBlock tECarpentersBlock = (TECarpentersBlock)world.getBlockTileEntity(n, n2, n3);
        Block block = BlockProperties.getCoverBlock(tECarpentersBlock, 6);
        Block block2 = BlockProperties.getCoverBlock(tECarpentersBlock, 1);
        int n4 = BlockProperties.getOverlay(tECarpentersBlock, 6);
        int n5 = BlockProperties.getOverlay(tECarpentersBlock, 1);
        boolean bl = false;
        int n6 = this.blockID;
        for (int i = 0; i < 4; ++i) {
            switch (i) {
                case 0: {
                    n6 = block.blockID;
                    break;
                }
                case 1: {
                    n6 = block2.blockID;
                    break;
                }
                case 2: {
                    n6 = n4 != 1 && n5 != 1 ? this.blockID : Block.grass.blockID;
                    break;
                }
                case 3: {
                    int n7 = n6 = n4 != 6 && n5 != 6 ? this.blockID : Block.mycelium.blockID;
                }
            }
            if (!this.canSustainPlantWithBlockIdOverride(tECarpentersBlock, world, n, n2, n3, n6, forgeDirection, iPlantable)) continue;
            bl = true;
        }
        return bl && this.isBlockSolidOnSide(world, n, n2, n3, ForgeDirection.UP);
    }

    protected boolean canSustainPlantWithBlockIdOverride(TECarpentersBlock tECarpentersBlock, World world, int n, int n2, int n3, int n4, ForgeDirection forgeDirection, IPlantable iPlantable) {
        if (FeatureHandler.enablePlantSupport) {
            int n5 = iPlantable.getPlantID(world, n, n2 + 1, n3);
            EnumPlantType enumPlantType = iPlantable.getPlantType(world, n, n2 + 1, n3);
            if (n5 == Block.cactus.blockID && n4 == Block.cactus.blockID || n5 == Block.reed.blockID && n4 == Block.reed.blockID || iPlantable instanceof BlockFlower && PlantHandler.canThisPlantGrowOnThisBlockID(n4)) {
                return true;
            }
            switch (NamelessClass520750742.$SwitchMap$net$minecraftforge$common$EnumPlantType[enumPlantType.ordinal()]) {
                case 1: {
                    return n4 == Block.sand.blockID;
                }
                case 2: {
                    return n4 == Block.slowSand.blockID;
                }
                case 3: {
                    return n4 == Block.tilledField.blockID;
                }
                case 4: {
                    return true;
                }
                case 5: {
                    return n4 == Block.grass.blockID || n4 == Block.dirt.blockID;
                }
                case 6: {
                    return BlockProperties.getCoverBlock((TECarpentersBlock)tECarpentersBlock, (int)6).blockMaterial == Material._h && world.getBlockMetadata(n, n2, n3) == 0;
                }
                case 7: {
                    boolean bl = n4 == Block.grass.blockID || n4 == Block.dirt.blockID || n4 == Block.sand.blockID;
                    boolean bl2 = world.getBlockMaterial(n - 1, n2, n3) == Material._h || world.getBlockMaterial(n + 1, n2, n3) == Material._h || world.getBlockMaterial(n, n2, n3 - 1) == Material._h || world.getBlockMaterial(n, n2, n3 + 1) == Material._h;
                    return bl && bl2;
                }
            }
        }
        return super.canSustainPlant(world, n, n2, n3, forgeDirection, iPlantable);
    }

    protected boolean isBlockSolid(World world, int n, int n2, int n3) {
        TECarpentersBlock tECarpentersBlock = (TECarpentersBlock)world.getBlockTileEntity(n, n2, n3);
        return !BlockProperties.hasCover(tECarpentersBlock, 6) || BlockProperties.getCoverBlock(tECarpentersBlock, 6).isOpaqueCube();
    }

    @Override
    public void onBlockPlacedBy(World world, int n, int n2, int n3, EntityLivingBase entityLivingBase, ItemStack itemStack) {
        TECarpentersBlock tECarpentersBlock = (TECarpentersBlock)world.getBlockTileEntity(n, n2, n3);
        this.auxiliaryOnBlockPlacedBy(tECarpentersBlock, world, n, n2, n3, entityLivingBase, itemStack);
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public boolean shouldSideBeRendered(IBlockAccess iBlockAccess, int n, int n2, int n3, int n4) {
        World world = iBlockAccess instanceof zzie ? ((zzie)iBlockAccess)._e : (World)iBlockAccess;
        if (this.extendsBlockBase(world, n, n2, n3)) {
            ForgeDirection forgeDirection = ForgeDirection.getOrientation(n4);
            ForgeDirection forgeDirection2 = ForgeDirection.getOrientation(ForgeDirection.OPPOSITES[n4]);
            TECarpentersBlock tECarpentersBlock = TECarpentersBlock.get(world, n, n2, n3);
            TECarpentersBlock tECarpentersBlock2 = TECarpentersBlock.get(world, n + forgeDirection2.offsetX, n2 + forgeDirection2.offsetY, n3 + forgeDirection2.offsetZ);
            if (tECarpentersBlock != null && tECarpentersBlock2 != null && tECarpentersBlock.getBlockType().isBlockSolidOnSide(world, n, n2, n3, forgeDirection2) == tECarpentersBlock2.getBlockType().isBlockSolidOnSide(world, n + forgeDirection2.offsetX, n2 + forgeDirection2.offsetY, n3 + forgeDirection2.offsetZ, ForgeDirection.getOrientation(n4)) && this.shareFaces(tECarpentersBlock, tECarpentersBlock2, forgeDirection2, forgeDirection)) {
                return BlockProperties.shouldRenderSharedFaceBasedOnCovers(tECarpentersBlock, tECarpentersBlock2);
            }
        }
        return super.shouldSideBeRendered(iBlockAccess, n, n2, n3, n4);
    }

    protected boolean shareFaces(TECarpentersBlock tECarpentersBlock, TECarpentersBlock tECarpentersBlock2, ForgeDirection forgeDirection, ForgeDirection forgeDirection2) {
        return tECarpentersBlock.getBlockType().isBlockSolidOnSide(tECarpentersBlock.worldObj, tECarpentersBlock.xCoord, tECarpentersBlock.yCoord, tECarpentersBlock.zCoord, forgeDirection) && tECarpentersBlock2.getBlockType().isBlockSolidOnSide(tECarpentersBlock2.worldObj, tECarpentersBlock2.xCoord, tECarpentersBlock2.yCoord, tECarpentersBlock2.zCoord, forgeDirection2);
    }

    @Override
    public boolean canRenderInPass(int n) {
        ForgeHooksClient.setRenderPass(n);
        return true;
    }

    @Override
    public MovingObjectPosition collisionRayTrace(World world, int n, int n2, int n3, Vec3 vec3, Vec3 vec32) {
        MovingObjectPosition movingObjectPosition = super.collisionRayTrace(world, n, n2, n3, vec3, vec32);
        if (movingObjectPosition == null) {
            return null;
        }
        TECarpentersBlock tECarpentersBlock = (TECarpentersBlock)world.getBlockTileEntity(n, n2, n3);
        Block block = BlockProperties.getCoverBlock(tECarpentersBlock, 6);
        if (block == StalkerMiscMod.__ac && !StalkerMiscMod.__ac._a(world)) {
            int n4 = BlockProperties.getCoverID(tECarpentersBlock, movingObjectPosition._g);
            if (n4 > 0 && Block.blocksList[n4] != null && !yufe._a.contains(n4)) {
                return movingObjectPosition;
            }
            return null;
        }
        return movingObjectPosition;
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public int getRenderBlockPass() {
        return 1;
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
    public void onBlockAdded(World world, int n, int n2, int n3) {
        world.setBlockTileEntity(n, n2, n3, this.createNewTileEntity(world));
    }

    @Override
    public TileEntity createNewTileEntity(World world) {
        return new TECarpentersBlock();
    }

    @Override
    public boolean hasTileEntity(int n) {
        return true;
    }

    protected void auxiliaryOnBlockClicked(TECarpentersBlock tECarpentersBlock, World world, int n, int n2, int n3, EntityPlayer entityPlayer) {
    }

    protected void auxiliaryOnBlockPlacedBy(TECarpentersBlock tECarpentersBlock, World world, int n, int n2, int n3, EntityLivingBase entityLivingBase, ItemStack itemStack) {
    }

    protected boolean auxiliaryOnBlockActivated(TECarpentersBlock tECarpentersBlock, World world, int n, int n2, int n3, EntityPlayer entityPlayer, int n4, float f, float f2, float f3) {
        return false;
    }

    protected void auxiliaryBreakBlock(TECarpentersBlock tECarpentersBlock, World world, int n, int n2, int n3, int n4, int n5) {
    }

    protected boolean onHammerLeftClick(TECarpentersBlock tECarpentersBlock, EntityPlayer entityPlayer) {
        return false;
    }

    protected boolean onHammerRightClick(TECarpentersBlock tECarpentersBlock, EntityPlayer entityPlayer, int n) {
        return false;
    }

    protected boolean canCoverSide(TECarpentersBlock tECarpentersBlock, World world, int n, int n2, int n3, int n4) {
        return false;
    }

    protected void auxiliaryOnNeighborBlockChange(TECarpentersBlock tECarpentersBlock, World world, int n, int n2, int n3, int n4) {
    }

    static class NamelessClass520750742 {
        static final int[] $SwitchMap$net$minecraftforge$common$EnumPlantType = new int[EnumPlantType.values().length];

        NamelessClass520750742() {
        }

        static {
            try {
                NamelessClass520750742.$SwitchMap$net$minecraftforge$common$EnumPlantType[EnumPlantType.Desert.ordinal()] = 1;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            try {
                NamelessClass520750742.$SwitchMap$net$minecraftforge$common$EnumPlantType[EnumPlantType.Nether.ordinal()] = 2;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            try {
                NamelessClass520750742.$SwitchMap$net$minecraftforge$common$EnumPlantType[EnumPlantType.Crop.ordinal()] = 3;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            try {
                NamelessClass520750742.$SwitchMap$net$minecraftforge$common$EnumPlantType[EnumPlantType.Cave.ordinal()] = 4;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            try {
                NamelessClass520750742.$SwitchMap$net$minecraftforge$common$EnumPlantType[EnumPlantType.Plains.ordinal()] = 5;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            try {
                NamelessClass520750742.$SwitchMap$net$minecraftforge$common$EnumPlantType[EnumPlantType.Water.ordinal()] = 6;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            try {
                NamelessClass520750742.$SwitchMap$net$minecraftforge$common$EnumPlantType[EnumPlantType.Beach.ordinal()] = 7;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
        }
    }
}

