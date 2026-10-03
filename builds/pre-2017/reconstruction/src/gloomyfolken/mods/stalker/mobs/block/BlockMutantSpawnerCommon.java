/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.stalker.mobs.block;

import gloomyfolken.mods.stalker.mobs.client.gui.GuiMutantSpawnerSettings;
import gloomyfolken.mods.stalker.mobs.tile.TileEntityMutantSpawner;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockMutantSpawnerCommon
extends ieal {
    public BlockMutantSpawnerCommon(int n) {
        super(n);
    }

    @Override
    protected bqyt createSpawnerTileEntity() {
        return new TileEntityMutantSpawner();
    }

    @Override
    protected void openEditGui(World world, int n, int n2, int n3) {
        Minecraft._E()._a(new GuiMutantSpawnerSettings(world, n, n2, n3));
    }

    @Override
    public void registerIcons(IconRegister iconRegister) {
        this.blockIcon = iconRegister._b("stalker:transparent");
        this.setCreativeIcon(iconRegister._b("stalkermobs:spawner"));
    }

    @Override
    public void onBlockPlacedBy(World world, int n, int n2, int n3, EntityLivingBase entityLivingBase, ItemStack itemStack) {
        TileEntity tileEntity = world.getBlockTileEntity(n, n2, n3);
        if (tileEntity instanceof TileEntityMutantSpawner && entityLivingBase instanceof EntityPlayerMP) {
            ((TileEntityMutantSpawner)tileEntity).placeTile(n, n2, n3);
            if (((TileEntityMutantSpawner)tileEntity).getAuthor() == null) {
                ((TileEntityMutantSpawner)tileEntity).setAuthor(((EntityPlayerMP)entityLivingBase).getCommandSenderName());
            }
        }
    }
}

