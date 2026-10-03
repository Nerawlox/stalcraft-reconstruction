/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.blocks;

import net.minecraft.block.material.Material;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import noppes.npcs.CustomItems;
import noppes.npcs.CustomNpcs;
import noppes.npcs.NoppesUtilServer;
import noppes.npcs.blocks.BlockTransparentContainer;
import noppes.npcs.blocks.TileRedstoneBlock;
import noppes.npcs.constants.EnumGuiType;
import noppes.npcs.constants.EnumPacketType;

public class BlockNpcRedstone
extends BlockTransparentContainer {
    public BlockNpcRedstone(int n) {
        super(n, Material._q);
        this.setCreativeTab(CustomItems.tab);
    }

    @Override
    public boolean onBlockActivated(World world, int n, int n2, int n3, EntityPlayer entityPlayer, int n4, float f, float f2, float f3) {
        if (world.isRemote) {
            return false;
        }
        if (entityPlayer.capabilities._d) {
            TileEntity tileEntity = world.getBlockTileEntity(n, n2, n3);
            NBTTagCompound nBTTagCompound = new NBTTagCompound();
            tileEntity.writeToNBT(nBTTagCompound);
            NoppesUtilServer.sendData(entityPlayer, EnumPacketType.RedstoneBlockSave, nBTTagCompound);
            return true;
        }
        return false;
    }

    @Override
    public void onBlockAdded(World world, int n, int n2, int n3) {
        world.notifyBlocksOfNeighborChange(n, n2, n3, this.blockID);
        world.notifyBlocksOfNeighborChange(n, n2 - 1, n3, this.blockID);
        world.notifyBlocksOfNeighborChange(n, n2 + 1, n3, this.blockID);
        world.notifyBlocksOfNeighborChange(n - 1, n2, n3, this.blockID);
        world.notifyBlocksOfNeighborChange(n + 1, n2, n3, this.blockID);
        world.notifyBlocksOfNeighborChange(n, n2, n3 - 1, this.blockID);
        world.notifyBlocksOfNeighborChange(n, n2, n3 + 1, this.blockID);
    }

    @Override
    public void onBlockPlacedBy(World world, int n, int n2, int n3, EntityLivingBase entityLivingBase, ItemStack itemStack) {
        if (entityLivingBase instanceof EntityPlayer && world.isRemote) {
            CustomNpcs.proxy.openGui(n, n2, n3, EnumGuiType.RedstoneBlock, (EntityPlayer)entityLivingBase);
        }
    }

    @Override
    public void onBlockDestroyedByPlayer(World world, int n, int n2, int n3, int n4) {
        this.onBlockAdded(world, n, n2, n3);
    }

    @Override
    public int colorMultiplier(IBlockAccess iBlockAccess, int n, int n2, int n3) {
        return this.isActivated(iBlockAccess, n, n2, n3) > 0 ? 16739176 : super.colorMultiplier(iBlockAccess, n, n2, n3);
    }

    @Override
    public int isProvidingStrongPower(IBlockAccess iBlockAccess, int n, int n2, int n3, int n4) {
        return this.isActivated(iBlockAccess, n, n2, n3);
    }

    @Override
    public int isProvidingWeakPower(IBlockAccess iBlockAccess, int n, int n2, int n3, int n4) {
        return this.isActivated(iBlockAccess, n, n2, n3);
    }

    @Override
    public boolean canProvidePower() {
        return true;
    }

    @Override
    public TileEntity createNewTileEntity(World world) {
        return new TileRedstoneBlock();
    }

    public int isActivated(IBlockAccess iBlockAccess, int n, int n2, int n3) {
        return iBlockAccess.getBlockMetadata(n, n2, n3) == 1 ? 15 : 0;
    }
}

