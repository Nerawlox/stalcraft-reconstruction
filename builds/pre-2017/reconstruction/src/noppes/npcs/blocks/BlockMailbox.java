/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.blocks;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import gloomyfolken.bundle.common.core.InvokeSideOnly;
import java.util.ArrayList;
import java.util.List;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Icon;
import net.minecraft.util.sajh;
import net.minecraft.world.World;
import noppes.npcs.CustomItems;
import noppes.npcs.blocks.TileMailbox;

public class BlockMailbox
extends BlockContainer {
    public int renderId = -1;

    public BlockMailbox(int n) {
        super(n, Material._e);
        this.setCreativeTab(CustomItems.tab);
    }

    @Override
    public void getSubBlocks(int n, CreativeTabs creativeTabs, List list2) {
        list2.add(new ItemStack(n, 1, 0));
        list2.add(new ItemStack(n, 1, 1));
    }

    @Override
    public boolean onBlockActivated(World world, int n, int n2, int n3, EntityPlayer entityPlayer, int n4, float f, float f2, float f3) {
        if (!world.isRemote) {
            InvokeSideOnly.frontend(() -> {});
        }
        return true;
    }

    @Override
    public TileEntity createNewTileEntity(World world) {
        return new TileMailbox();
    }

    public ArrayList getBlockDropped(World world, int n, int n2, int n3, int n4, int n5) {
        ArrayList<ItemStack> arrayList = new ArrayList<ItemStack>();
        arrayList.add(new ItemStack(this, 1, this.getDamageValue(world, n, n2, n3)));
        return arrayList;
    }

    @Override
    public int damageDropped(int n) {
        return n >> 2;
    }

    @Override
    public void onBlockPlacedBy(World world, int n, int n2, int n3, EntityLivingBase entityLivingBase, ItemStack itemStack) {
        int n4 = sajh._c((double)(entityLivingBase.rotationYaw * 4.0f / 360.0f) + 0.5) & 3;
        world.func_72921_c(n, n2, n3, (n4 %= 4) | itemStack._j() << 2, 2);
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
        return this.renderId;
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public Icon getIcon(int n, int n2) {
        return Block.slowSand.getBlockTextureFromSide(n);
    }
}

