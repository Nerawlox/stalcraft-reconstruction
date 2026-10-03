/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.block;

import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityTNTPrimed;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.item.Item;
import net.minecraft.util.Icon;
import net.minecraft.world.Explosion;
import net.minecraft.world.World;

public class BlockTNT
extends Block {
    public Icon _a;
    public Icon _b;

    public BlockTNT(int n) {
        super(n, Material._u);
        this.setCreativeTab(CreativeTabs.tabRedstone);
    }

    @Override
    public Icon getIcon(int n, int n2) {
        if (n == 0) {
            return this._b;
        }
        if (n == 1) {
            return this._a;
        }
        return this.blockIcon;
    }

    @Override
    public void onBlockAdded(World world, int n, int n2, int n3) {
        super.onBlockAdded(world, n, n2, n3);
        if (world.isBlockIndirectlyGettingPowered(n, n2, n3)) {
            this.onBlockDestroyedByPlayer(world, n, n2, n3, 1);
            world.setBlockToAir(n, n2, n3);
        }
    }

    @Override
    public void onNeighborBlockChange(World world, int n, int n2, int n3, int n4) {
        if (world.isBlockIndirectlyGettingPowered(n, n2, n3)) {
            this.onBlockDestroyedByPlayer(world, n, n2, n3, 1);
            world.setBlockToAir(n, n2, n3);
        }
    }

    @Override
    public int quantityDropped(Random random) {
        return 1;
    }

    @Override
    public void onBlockDestroyedByExplosion(World world, int n, int n2, int n3, Explosion explosion) {
        if (world.isRemote) {
            return;
        }
        EntityTNTPrimed entityTNTPrimed = new EntityTNTPrimed(world, (float)n + 0.5f, (float)n2 + 0.5f, (float)n3 + 0.5f, explosion._c());
        entityTNTPrimed.fuse = world.rand.nextInt(entityTNTPrimed.fuse / 4) + entityTNTPrimed.fuse / 8;
        world.spawnEntityInWorld(entityTNTPrimed);
    }

    @Override
    public void onBlockDestroyedByPlayer(World world, int n, int n2, int n3, int n4) {
        this._a(world, n, n2, n3, n4, null);
    }

    public void _a(World world, int n, int n2, int n3, int n4, EntityLivingBase entityLivingBase) {
        if (world.isRemote) {
            return;
        }
        if ((n4 & 1) == 1) {
            EntityTNTPrimed entityTNTPrimed = new EntityTNTPrimed(world, (float)n + 0.5f, (float)n2 + 0.5f, (float)n3 + 0.5f, entityLivingBase);
            world.spawnEntityInWorld(entityTNTPrimed);
            world.playSoundAtEntity(entityTNTPrimed, "random.fuse", 1.0f, 1.0f);
        }
    }

    @Override
    public boolean onBlockActivated(World world, int n, int n2, int n3, EntityPlayer entityPlayer, int n4, float f, float f2, float f3) {
        if (entityPlayer.getCurrentEquippedItem() != null && entityPlayer.getCurrentEquippedItem()._d == Item.flintAndSteel.itemID) {
            this._a(world, n, n2, n3, 1, entityPlayer);
            world.setBlockToAir(n, n2, n3);
            entityPlayer.getCurrentEquippedItem()._a(1, (EntityLivingBase)entityPlayer);
            return true;
        }
        return super.onBlockActivated(world, n, n2, n3, entityPlayer, n4, f, f2, f3);
    }

    @Override
    public void onEntityCollidedWithBlock(World world, int n, int n2, int n3, Entity entity) {
        EntityArrow entityArrow;
        if (entity instanceof EntityArrow && !world.isRemote && (entityArrow = (EntityArrow)entity).isBurning()) {
            this._a(world, n, n2, n3, 1, entityArrow.shootingEntity instanceof EntityLivingBase ? (EntityLivingBase)entityArrow.shootingEntity : null);
            world.setBlockToAir(n, n2, n3);
        }
    }

    @Override
    public boolean canDropFromExplosion(Explosion explosion) {
        return false;
    }

    @Override
    public void registerIcons(IconRegister iconRegister) {
        this.blockIcon = iconRegister._b(this.getTextureName() + "_side");
        this._a = iconRegister._b(this.getTextureName() + "_top");
        this._b = iconRegister._b(this.getTextureName() + "_bottom");
    }
}

