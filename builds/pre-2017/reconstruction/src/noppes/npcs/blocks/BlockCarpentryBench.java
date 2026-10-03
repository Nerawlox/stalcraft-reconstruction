/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.blocks;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.sajh;
import net.minecraft.world.World;
import noppes.npcs.CustomItems;
import noppes.npcs.CustomNpcs;
import noppes.npcs.blocks.TileBlockAnvil;
import noppes.npcs.constants.EnumGuiType;

public class BlockCarpentryBench
extends BlockContainer {
    public BlockCarpentryBench(int n) {
        super(n, Material._f);
        this.setCreativeTab(CustomItems.tab);
    }

    @Override
    public boolean onBlockActivated(World world, int n, int n2, int n3, EntityPlayer entityPlayer, int n4, float f, float f2, float f3) {
        if (!world.isRemote) {
            entityPlayer.openGui(CustomNpcs.instance, EnumGuiType.PlayerAnvil.ordinal(), world, n, n2, n3);
        }
        return true;
    }

    @Override
    public TileEntity createNewTileEntity(World world) {
        return new TileBlockAnvil();
    }

    @Override
    public boolean isOpaqueCube() {
        return false;
    }

    @Override
    public int getRenderType() {
        return -1;
    }

    @Override
    public boolean renderAsNormalBlock() {
        return false;
    }

    @Override
    public void onBlockPlacedBy(World world, int n, int n2, int n3, EntityLivingBase entityLivingBase, ItemStack itemStack) {
        int n4 = sajh._c((double)(entityLivingBase.rotationYaw / 90.0f) + 0.5) & 3;
        world.func_72921_c(n, n2, n3, n4, 2);
    }
}

