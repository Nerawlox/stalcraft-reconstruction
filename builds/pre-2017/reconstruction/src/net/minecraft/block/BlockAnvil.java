/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.block;

import gloomyfolken.mods.stalker.misc.qlgf;
import java.util.List;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityFallingSand;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import net.minecraft.util.sajh;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockAnvil
extends uilx {
    public static final String[] _a = new String[]{"intact", "slightlyDamaged", "veryDamaged"};
    public static final String[] _b = new String[]{"anvil_top_damaged_0", "anvil_top_damaged_1", "anvil_top_damaged_2"};
    public int _c;
    public Icon[] _d;

    public BlockAnvil(int n) {
        super(n, Material._g);
        this.setLightOpacity(0);
        this.setCreativeTab(CreativeTabs.tabDecorations);
    }

    @Override
    public boolean renderAsNormalBlock() {
        return false;
    }

    @Override
    public boolean isOpaqueCube() {
        return false;
    }

    @Override
    public Icon getIcon(int n, int n2) {
        if (this._c == 3 && n == 1) {
            int n3 = (n2 >> 2) % this._d.length;
            return this._d[n3];
        }
        return this.blockIcon;
    }

    @Override
    public void registerIcons(IconRegister iconRegister) {
        this.blockIcon = iconRegister._b("anvil_base");
        this._d = new Icon[_b.length];
        for (int i = 0; i < this._d.length; ++i) {
            this._d[i] = iconRegister._b(_b[i]);
        }
    }

    @Override
    public void onBlockPlacedBy(World world, int n, int n2, int n3, EntityLivingBase entityLivingBase, ItemStack itemStack) {
        int n4 = sajh._c((double)(entityLivingBase.rotationYaw * 4.0f / 360.0f) + 0.5) & 3;
        int n5 = world.getBlockMetadata(n, n2, n3) >> 2;
        ++n4;
        if ((n4 %= 4) == 0) {
            world.func_72921_c(n, n2, n3, 2 | n5 << 2, 2);
        }
        if (n4 == 1) {
            world.func_72921_c(n, n2, n3, 3 | n5 << 2, 2);
        }
        if (n4 == 2) {
            world.func_72921_c(n, n2, n3, 0 | n5 << 2, 2);
        }
        if (n4 == 3) {
            world.func_72921_c(n, n2, n3, 1 | n5 << 2, 2);
        }
    }

    @Override
    public boolean onBlockActivated(World world, int n, int n2, int n3, EntityPlayer entityPlayer, int n4, float f, float f2, float f3) {
        qlgf._a(this, world, n, n2, n3, entityPlayer, n4, f, f2, f3);
        return false;
    }

    @Override
    public int getRenderType() {
        return 35;
    }

    @Override
    public int damageDropped(int n) {
        return n >> 2;
    }

    @Override
    public void setBlockBoundsBasedOnState(IBlockAccess iBlockAccess, int n, int n2, int n3) {
        int n4 = iBlockAccess.getBlockMetadata(n, n2, n3) & 3;
        if (n4 == 3 || n4 == 1) {
            this.setBlockBounds(0.0f, 0.0f, 0.125f, 1.0f, 1.0f, 0.875f);
        } else {
            this.setBlockBounds(0.125f, 0.0f, 0.0f, 0.875f, 1.0f, 1.0f);
        }
    }

    @Override
    public void getSubBlocks(int n, CreativeTabs creativeTabs, List list2) {
        list2.add(new ItemStack(n, 1, 0));
        list2.add(new ItemStack(n, 1, 1));
        list2.add(new ItemStack(n, 1, 2));
    }

    @Override
    public void _a(EntityFallingSand entityFallingSand) {
        entityFallingSand.setIsAnvil(true);
    }

    @Override
    public void _a(World world, int n, int n2, int n3, int n4) {
        world.playAuxSFX(1022, n, n2, n3, 0);
    }

    @Override
    public boolean shouldSideBeRendered(IBlockAccess iBlockAccess, int n, int n2, int n3, int n4) {
        return true;
    }
}

