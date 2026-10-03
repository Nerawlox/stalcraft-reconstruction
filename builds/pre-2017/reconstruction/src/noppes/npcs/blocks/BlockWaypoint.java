/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.blocks;

import gloomyfolken.mods.core.main.GloomyCore;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import noppes.npcs.CustomNpcs;
import noppes.npcs.NoppesUtilServer;
import noppes.npcs.blocks.BlockTransparentContainer;
import noppes.npcs.blocks.TileWaypoint;
import noppes.npcs.constants.EnumGuiType;
import noppes.npcs.constants.EnumPacketType;

public class BlockWaypoint
extends BlockTransparentContainer {
    public BlockWaypoint(int n) {
        super(n, GloomyCore.fakeAir);
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
            NoppesUtilServer.sendData(entityPlayer, EnumPacketType.WaypointSave, nBTTagCompound);
            return true;
        }
        return false;
    }

    @Override
    public void onBlockPlacedBy(World world, int n, int n2, int n3, EntityLivingBase entityLivingBase, ItemStack itemStack) {
        if (entityLivingBase instanceof EntityPlayer && world.isRemote) {
            CustomNpcs.proxy.openGui(n, n2, n3, EnumGuiType.Waypoint, (EntityPlayer)entityLivingBase);
        }
    }

    @Override
    public TileEntity createNewTileEntity(World world) {
        return new TileWaypoint();
    }
}

