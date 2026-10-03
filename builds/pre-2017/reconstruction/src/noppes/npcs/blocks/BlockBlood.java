/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.blocks;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.Icon;
import net.minecraft.util.sajh;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import noppes.npcs.CustomItems;

public class BlockBlood
extends Block {
    @SideOnly(value=Side.CLIENT)
    private Icon furnaceIconTop;
    @SideOnly(value=Side.CLIENT)
    private Icon furnaceIconFront;

    public BlockBlood(int n) {
        super(n, Material._l);
        this.setBlockUnbreakable();
        this.setCreativeTab(CustomItems.tabMisc);
        this.setBlockBounds(0.01f, 0.01f, 0.01f, 0.99f, 0.99f, 0.99f);
        this.setLightValue(0.08f);
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public Icon getIcon(int n, int n2) {
        return n2 % 3 == 1 ? this.furnaceIconFront : (n2 % 3 == 2 ? this.furnaceIconTop : this.blockIcon);
    }

    @Override
    public AxisAlignedBB getCollisionBoundingBoxFromPool(World world, int n, int n2, int n3) {
        return null;
    }

    @Override
    public AxisAlignedBB getSelectedBoundingBoxFromPool(World world, int n, int n2, int n3) {
        return AxisAlignedBB._a()._a(n, n2, n3, n, n2, n3);
    }

    @Override
    public boolean renderAsNormalBlock() {
        return false;
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public void registerIcons(IconRegister iconRegister) {
        this.blockIcon = iconRegister._b(this.getTextureName());
        this.furnaceIconFront = iconRegister._b(this.getTextureName() + "2");
        this.furnaceIconTop = iconRegister._b(this.getTextureName() + "3");
    }

    @Override
    public boolean shouldSideBeRendered(IBlockAccess iBlockAccess, int n, int n2, int n3, int n4) {
        Block block = Block.blocksList[iBlockAccess.getBlockId(n, n2, n3)];
        return block != null && block.renderAsNormalBlock();
    }

    @Override
    public boolean isOpaqueCube() {
        return false;
    }

    @Override
    public int getRenderBlockPass() {
        return 1;
    }

    @Override
    public void onBlockPlacedBy(World world, int n, int n2, int n3, EntityLivingBase entityLivingBase, ItemStack itemStack) {
        int n4 = sajh._c((double)(entityLivingBase.rotationYaw / 90.0f) + 0.5) & 3;
        world.func_72921_c(n, n2, n3, n4, 2);
    }
}

