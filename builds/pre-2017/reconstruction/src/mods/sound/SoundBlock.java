/*
 * Decompiled with CFR 0.152.
 */
package mods.sound;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import gloomyfolken.bundle.common.core.InvokeSideOnly;
import gloomyfolken.mods.core.main.GloomyCore;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityClientPlayerMP;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.Icon;
import net.minecraft.world.World;

public class SoundBlock
extends Block {
    private Icon visible;

    public SoundBlock(int n) {
        super(n, Material._c);
    }

    @Override
    public void onBlockPlacedBy(World world, int n, int n2, int n3, EntityLivingBase entityLivingBase, ItemStack itemStack) {
        super.onBlockPlacedBy(world, n, n2, n3, entityLivingBase, itemStack);
        if (entityLivingBase instanceof EntityPlayer) {
            InvokeSideOnly.frontend(!world.isRemote, () -> {});
        }
    }

    @Override
    public boolean onBlockActivated(World world, int n, int n2, int n3, EntityPlayer entityPlayer, int n4, float f, float f2, float f3) {
        InvokeSideOnly.frontend(!world.isRemote, () -> {});
        return super.onBlockActivated(world, n, n2, n3, entityPlayer, n4, f, f2, f3);
    }

    @Override
    public void onBlockPreDestroy(World world, int n, int n2, int n3, int n4) {
        super.onBlockPreDestroy(world, n, n2, n3, n4);
        InvokeSideOnly.frontend(!world.isRemote, () -> {});
    }

    @Override
    public void registerIcons(IconRegister iconRegister) {
        this.blockIcon = iconRegister._b("stalkersounds:soundblock_inv");
        this.visible = iconRegister._b("stalkersounds:soundblock_vis");
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public Icon getIcon(int n, int n2) {
        EntityClientPlayerMP entityClientPlayerMP = Minecraft._E()._t;
        if (entityClientPlayerMP == null || !entityClientPlayerMP.capabilities._d) {
            return this.blockIcon;
        }
        return this.visible;
    }

    @Override
    public AxisAlignedBB getCollisionBoundingBoxFromPool(World world, int n, int n2, int n3) {
        return null;
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
    @SideOnly(value=Side.CLIENT)
    public int getRenderBlockPass() {
        return 1;
    }

    @Override
    public int getRenderType() {
        return GloomyCore.transparentsRenderType;
    }
}

