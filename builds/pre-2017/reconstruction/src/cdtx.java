/*
 * Decompiled with CFR 0.152.
 */
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityBeacon;
import net.minecraft.world.World;

public class cdtx
extends BlockContainer {
    public cdtx(int n) {
        super(n, Material._s);
        this.setHardness(3.0f);
        this.setCreativeTab(CreativeTabs.tabMisc);
    }

    @Override
    public TileEntity createNewTileEntity(World world) {
        return new TileEntityBeacon();
    }

    @Override
    public boolean onBlockActivated(World world, int n, int n2, int n3, EntityPlayer entityPlayer, int n4, float f, float f2, float f3) {
        if (world.isRemote) {
            return true;
        }
        TileEntityBeacon tileEntityBeacon = (TileEntityBeacon)world.getBlockTileEntity(n, n2, n3);
        if (tileEntityBeacon != null) {
            entityPlayer.displayGUIBeacon(tileEntityBeacon);
        }
        return true;
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
    public int getRenderType() {
        return 34;
    }

    @Override
    public void registerIcons(IconRegister iconRegister) {
        super.registerIcons(iconRegister);
    }

    @Override
    public void onBlockPlacedBy(World world, int n, int n2, int n3, EntityLivingBase entityLivingBase, ItemStack itemStack) {
        super.onBlockPlacedBy(world, n, n2, n3, entityLivingBase, itemStack);
        if (itemStack._u()) {
            ((TileEntityBeacon)world.getBlockTileEntity(n, n2, n3))._a(itemStack._s());
        }
    }
}

