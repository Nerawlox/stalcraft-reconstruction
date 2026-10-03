/*
 * Decompiled with CFR 0.152.
 */
package carpentersblocks.block;

import carpentersblocks.block.BlockBase;
import carpentersblocks.data.Door;
import carpentersblocks.tileentity.TECarpentersBlock;
import carpentersblocks.util.BlockProperties;
import carpentersblocks.util.handler.BlockHandler;
import carpentersblocks.util.handler.ItemHandler;
import cpw.mods.fml.common.registry.LanguageRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockCarpentersDoor
extends BlockBase {
    public BlockCarpentersDoor(int n) {
        super(n, Material._d);
        this.setHardness(0.2f);
        this.setUnlocalizedName("blockCarpentersDoor");
        this.setTextureName("carpentersblocks:general/generic");
    }

    @Override
    protected boolean onHammerLeftClick(TECarpentersBlock tECarpentersBlock, EntityPlayer entityPlayer) {
        int n = BlockProperties.getData(tECarpentersBlock);
        int n2 = Door.getHinge(n);
        this.setDoorHinge(tECarpentersBlock, n2 == 0 ? 1 : 0);
        return true;
    }

    @Override
    protected boolean onHammerRightClick(TECarpentersBlock tECarpentersBlock, EntityPlayer entityPlayer, int n) {
        int n2 = BlockProperties.getData(tECarpentersBlock);
        if (!entityPlayer.isSneaking()) {
            if (!tECarpentersBlock.worldObj.isRemote) {
                int n3 = Door.getType(n2);
                if (++n3 > 5) {
                    n3 = 0;
                }
                this.setDoorType(tECarpentersBlock, n3);
            }
        } else {
            int n4;
            int n5 = n4 = Door.getRigidity(n2) == 0 ? 1 : 0;
            if (!tECarpentersBlock.worldObj.isRemote) {
                this.setDoorRigidity(tECarpentersBlock, n4);
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
        if (!this.activationRequiresRedstone(tECarpentersBlock)) {
            this.setDoorState(tECarpentersBlock, Door.getState(n5) == 1 ? 0 : 1);
        }
        return true;
    }

    private boolean activationRequiresRedstone(TECarpentersBlock tECarpentersBlock) {
        return Door.getRigidity(BlockProperties.getData(tECarpentersBlock)) == 1;
    }

    private List getDoorPieces(TECarpentersBlock tECarpentersBlock) {
        ArrayList<TileEntity> arrayList = new ArrayList<TileEntity>();
        int n = BlockProperties.getData(tECarpentersBlock);
        int n2 = Door.getFacing(n);
        int n3 = Door.getHinge(n);
        int n4 = Door.getPiece(n);
        boolean bl = n4 == 1;
        arrayList.add(tECarpentersBlock);
        arrayList.add(tECarpentersBlock.worldObj.getBlockTileEntity(tECarpentersBlock.xCoord, tECarpentersBlock.yCoord - (bl ? 1 : -1), tECarpentersBlock.zCoord));
        TECarpentersBlock tECarpentersBlock2 = tECarpentersBlock.worldObj.getBlockId(tECarpentersBlock.xCoord, tECarpentersBlock.yCoord, tECarpentersBlock.zCoord - 1) == this.blockID ? (TECarpentersBlock)tECarpentersBlock.worldObj.getBlockTileEntity(tECarpentersBlock.xCoord, tECarpentersBlock.yCoord, tECarpentersBlock.zCoord - 1) : null;
        TECarpentersBlock tECarpentersBlock3 = tECarpentersBlock.worldObj.getBlockId(tECarpentersBlock.xCoord, tECarpentersBlock.yCoord, tECarpentersBlock.zCoord + 1) == this.blockID ? (TECarpentersBlock)tECarpentersBlock.worldObj.getBlockTileEntity(tECarpentersBlock.xCoord, tECarpentersBlock.yCoord, tECarpentersBlock.zCoord + 1) : null;
        TECarpentersBlock tECarpentersBlock4 = tECarpentersBlock.worldObj.getBlockId(tECarpentersBlock.xCoord - 1, tECarpentersBlock.yCoord, tECarpentersBlock.zCoord) == this.blockID ? (TECarpentersBlock)tECarpentersBlock.worldObj.getBlockTileEntity(tECarpentersBlock.xCoord - 1, tECarpentersBlock.yCoord, tECarpentersBlock.zCoord) : null;
        TECarpentersBlock tECarpentersBlock5 = tECarpentersBlock.worldObj.getBlockId(tECarpentersBlock.xCoord + 1, tECarpentersBlock.yCoord, tECarpentersBlock.zCoord) == this.blockID ? (TECarpentersBlock)tECarpentersBlock.worldObj.getBlockTileEntity(tECarpentersBlock.xCoord + 1, tECarpentersBlock.yCoord, tECarpentersBlock.zCoord) : null;
        switch (n2) {
            case 0: {
                int n5;
                if (tECarpentersBlock2 != null && n4 == Door.getPiece(n5 = BlockProperties.getData(tECarpentersBlock2)) && n2 == Door.getFacing(n5) && n3 == 1 && Door.getHinge(n5) == 0) {
                    arrayList.add(tECarpentersBlock2);
                    arrayList.add(tECarpentersBlock.worldObj.getBlockTileEntity(tECarpentersBlock.xCoord, tECarpentersBlock.yCoord - (bl ? 1 : -1), tECarpentersBlock.zCoord - 1));
                }
                if (tECarpentersBlock3 == null || n4 != Door.getPiece(n5 = BlockProperties.getData(tECarpentersBlock3)) || n2 != Door.getFacing(n5) || n3 != 0 || Door.getHinge(n5) != 1) break;
                arrayList.add(tECarpentersBlock3);
                arrayList.add(tECarpentersBlock.worldObj.getBlockTileEntity(tECarpentersBlock.xCoord, tECarpentersBlock.yCoord - (bl ? 1 : -1), tECarpentersBlock.zCoord + 1));
                break;
            }
            case 1: {
                int n6;
                if (tECarpentersBlock4 != null && n4 == Door.getPiece(n6 = BlockProperties.getData(tECarpentersBlock4)) && n2 == Door.getFacing(n6) && n3 == 0 && Door.getHinge(n6) == 1) {
                    arrayList.add(tECarpentersBlock4);
                    arrayList.add(tECarpentersBlock.worldObj.getBlockTileEntity(tECarpentersBlock.xCoord - 1, tECarpentersBlock.yCoord - (bl ? 1 : -1), tECarpentersBlock.zCoord));
                }
                if (tECarpentersBlock5 == null || n4 != Door.getPiece(n6 = BlockProperties.getData(tECarpentersBlock5)) || n2 != Door.getFacing(n6) || n3 != 1 || Door.getHinge(n6) != 0) break;
                arrayList.add(tECarpentersBlock5);
                arrayList.add(tECarpentersBlock.worldObj.getBlockTileEntity(tECarpentersBlock.xCoord + 1, tECarpentersBlock.yCoord - (bl ? 1 : -1), tECarpentersBlock.zCoord));
                break;
            }
            case 2: {
                int n7;
                if (tECarpentersBlock2 != null && n4 == Door.getPiece(n7 = BlockProperties.getData(tECarpentersBlock2)) && n2 == Door.getFacing(n7) && n3 == 0 && Door.getHinge(n7) == 1) {
                    arrayList.add(tECarpentersBlock2);
                    arrayList.add(tECarpentersBlock.worldObj.getBlockTileEntity(tECarpentersBlock.xCoord, tECarpentersBlock.yCoord - (bl ? 1 : -1), tECarpentersBlock.zCoord - 1));
                }
                if (tECarpentersBlock3 == null || n4 != Door.getPiece(n7 = BlockProperties.getData(tECarpentersBlock3)) || n2 != Door.getFacing(n7) || n3 != 1 || Door.getHinge(n7) != 0) break;
                arrayList.add(tECarpentersBlock3);
                arrayList.add(tECarpentersBlock.worldObj.getBlockTileEntity(tECarpentersBlock.xCoord, tECarpentersBlock.yCoord - (bl ? 1 : -1), tECarpentersBlock.zCoord + 1));
                break;
            }
            case 3: {
                int n8;
                if (tECarpentersBlock4 != null && n4 == Door.getPiece(n8 = BlockProperties.getData(tECarpentersBlock4)) && n2 == Door.getFacing(n8) && n3 == 1 && Door.getHinge(n8) == 0) {
                    arrayList.add(tECarpentersBlock4);
                    arrayList.add(tECarpentersBlock.worldObj.getBlockTileEntity(tECarpentersBlock.xCoord - 1, tECarpentersBlock.yCoord - (bl ? 1 : -1), tECarpentersBlock.zCoord));
                }
                if (tECarpentersBlock5 == null || n4 != Door.getPiece(n8 = BlockProperties.getData(tECarpentersBlock5)) || n2 != Door.getFacing(n8) || n3 != 0 || Door.getHinge(n8) != 1) break;
                arrayList.add(tECarpentersBlock5);
                arrayList.add(tECarpentersBlock.worldObj.getBlockTileEntity(tECarpentersBlock.xCoord + 1, tECarpentersBlock.yCoord - (bl ? 1 : -1), tECarpentersBlock.zCoord));
            }
        }
        return arrayList;
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public AxisAlignedBB getSelectedBoundingBoxFromPool(World world, int n, int n2, int n3) {
        TECarpentersBlock tECarpentersBlock;
        TECarpentersBlock tECarpentersBlock2 = tECarpentersBlock = world.getBlockId(n, n2, n3) == this.blockID ? (TECarpentersBlock)world.getBlockTileEntity(n, n2, n3) : null;
        if (tECarpentersBlock != null) {
            this.setBlockBoundsBasedOnState(world, n, n2, n3);
        }
        return super.getSelectedBoundingBoxFromPool(world, n, n2, n3);
    }

    @Override
    public AxisAlignedBB getCollisionBoundingBoxFromPool(World world, int n, int n2, int n3) {
        TECarpentersBlock tECarpentersBlock;
        TECarpentersBlock tECarpentersBlock2 = tECarpentersBlock = world.getBlockId(n, n2, n3) == this.blockID ? (TECarpentersBlock)world.getBlockTileEntity(n, n2, n3) : null;
        if (tECarpentersBlock != null) {
            this.setBlockBoundsBasedOnState(world, n, n2, n3);
        }
        return super.getCollisionBoundingBoxFromPool(world, n, n2, n3);
    }

    @Override
    public void setBlockBoundsBasedOnState(IBlockAccess iBlockAccess, int n, int n2, int n3) {
        TECarpentersBlock tECarpentersBlock = (TECarpentersBlock)iBlockAccess.getBlockTileEntity(n, n2, n3);
        int n4 = BlockProperties.getData(tECarpentersBlock);
        int n5 = Door.getFacing(n4);
        int n6 = Door.getHinge(n4);
        boolean bl = Door.getState(n4) == 1;
        float f = 0.0f;
        float f2 = 0.0f;
        float f3 = 1.0f;
        float f4 = 1.0f;
        switch (n5) {
            case 0: {
                if (!bl) {
                    f3 = 0.1875f;
                    break;
                }
                if (n6 == 1) {
                    f2 = 0.8125f;
                    break;
                }
                f4 = 0.1875f;
                break;
            }
            case 1: {
                if (!bl) {
                    f4 = 0.1875f;
                    break;
                }
                if (n6 == 1) {
                    f3 = 0.1875f;
                    break;
                }
                f = 0.8125f;
                break;
            }
            case 2: {
                if (!bl) {
                    f = 0.8125f;
                    break;
                }
                if (n6 == 1) {
                    f4 = 0.1875f;
                    break;
                }
                f2 = 0.8125f;
                break;
            }
            case 3: {
                if (!bl) {
                    f2 = 0.8125f;
                    break;
                }
                if (n6 == 1) {
                    f = 0.8125f;
                    break;
                }
                f3 = 0.1875f;
            }
        }
        this.setBlockBounds(f, 0.0f, f2, f3, 1.0f, f4);
    }

    public void setDoorState(TECarpentersBlock tECarpentersBlock, int n) {
        Iterator iterator2 = this.getDoorPieces(tECarpentersBlock).iterator();
        while (iterator2.hasNext()) {
            TECarpentersBlock tECarpentersBlock2;
            Door.setState(tECarpentersBlock2, n, (tECarpentersBlock2 = (TECarpentersBlock)iterator2.next()) == tECarpentersBlock);
        }
    }

    public void setDoorType(TECarpentersBlock tECarpentersBlock, int n) {
        Door.setType(tECarpentersBlock, n);
        this.updateAdjoiningDoorPiece(tECarpentersBlock);
    }

    public void setDoorRigidity(TECarpentersBlock tECarpentersBlock, int n) {
        for (TECarpentersBlock tECarpentersBlock2 : this.getDoorPieces(tECarpentersBlock)) {
            Door.setRigidity(tECarpentersBlock2, n);
        }
    }

    public void setDoorHinge(TECarpentersBlock tECarpentersBlock, int n) {
        Door.setHingeSide(tECarpentersBlock, n);
        this.updateAdjoiningDoorPiece(tECarpentersBlock);
    }

    @Override
    protected void auxiliaryOnNeighborBlockChange(TECarpentersBlock tECarpentersBlock, World world, int n, int n2, int n3, int n4) {
        boolean bl;
        int n5 = BlockProperties.getData(tECarpentersBlock);
        boolean bl2 = bl = Door.getState(n5) == 1;
        if (Door.getPiece(n5) == 0) {
            if (world.getBlockId(n, n2 + 1, n3) != this.blockID) {
                world.setBlockToAir(n, n2, n3);
                return;
            }
            if (!world.doesBlockHaveSolidTopSurface(n, n2 - 1, n3)) {
                world.setBlockToAir(n, n2 + 1, n3);
                return;
            }
        } else if (world.getBlockId(n, n2 - 1, n3) != this.blockID) {
            world.setBlockToAir(n, n2, n3);
            return;
        }
        boolean bl3 = false;
        for (TECarpentersBlock tECarpentersBlock2 : this.getDoorPieces(tECarpentersBlock)) {
            if (!world.isBlockIndirectlyGettingPowered(tECarpentersBlock2.xCoord, tECarpentersBlock2.yCoord, tECarpentersBlock2.zCoord)) continue;
            bl3 = true;
        }
        if (n4 > 0 && Block.blocksList[n4].canProvidePower() && bl3 != bl) {
            this.setDoorState(tECarpentersBlock, bl ? 0 : 1);
        }
    }

    @Override
    public int idDropped(int n, Random random, int n2) {
        return ItemHandler.itemCarpentersDoor.itemID;
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public int idPicked(World world, int n, int n2, int n3) {
        return ItemHandler.itemCarpentersDoor.itemID;
    }

    private void updateAdjoiningDoorPiece(TECarpentersBlock tECarpentersBlock) {
        int n = BlockProperties.getData(tECarpentersBlock);
        int n2 = Door.getState(n);
        int n3 = Door.getHinge(n);
        int n4 = Door.getType(n);
        int n5 = Door.getRigidity(n);
        boolean bl = Door.getPiece(n) == 1;
        TECarpentersBlock tECarpentersBlock2 = bl ? (TECarpentersBlock)tECarpentersBlock.worldObj.getBlockTileEntity(tECarpentersBlock.xCoord, tECarpentersBlock.yCoord - 1, tECarpentersBlock.zCoord) : (TECarpentersBlock)tECarpentersBlock.worldObj.getBlockTileEntity(tECarpentersBlock.xCoord, tECarpentersBlock.yCoord + 1, tECarpentersBlock.zCoord);
        Door.setState(tECarpentersBlock2, n2, false);
        Door.setHingeSide(tECarpentersBlock2, n3);
        Door.setType(tECarpentersBlock2, n4);
        Door.setRigidity(tECarpentersBlock2, n5);
    }

    @Override
    public boolean canPlaceBlockAt(World world, int n, int n2, int n3) {
        return n2 >= 255 ? false : world.doesBlockHaveSolidTopSurface(n, n2 - 1, n3) && super.canPlaceBlockAt(world, n, n2, n3) && super.canPlaceBlockAt(world, n, n2 + 1, n3);
    }

    @Override
    public int getRenderType() {
        return BlockHandler.carpentersDoorRenderID;
    }
}

