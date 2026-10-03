/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.item;

import java.util.List;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.jgro;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.zwaw;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumMovingObjectType;
import net.minecraft.util.Icon;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.owak;
import net.minecraft.util.sajh;
import net.minecraft.util.tdpx;
import net.minecraft.world.World;

public class ItemMonsterPlacer
extends Item {
    public Icon _a;

    public ItemMonsterPlacer(int n) {
        super(n);
        this.setHasSubtypes(true);
        this.setCreativeTab(CreativeTabs.tabMisc);
    }

    @Override
    public String getItemDisplayName(ItemStack itemStack) {
        String string = ("" + tdpx._a(this.getUnlocalizedName() + ".name")).trim();
        String string2 = jgro._b(itemStack._j());
        if (string2 != null) {
            string = string + " " + tdpx._a("entity." + string2 + ".name");
        }
        return string;
    }

    @Override
    public int getColorFromItemStack(ItemStack itemStack, int n) {
        zwaw zwaw2 = (zwaw)jgro._f.get(itemStack._j());
        if (zwaw2 != null) {
            if (n == 0) {
                return zwaw2._b;
            }
            return zwaw2._c;
        }
        return 0xFFFFFF;
    }

    @Override
    public boolean requiresMultipleRenderPasses() {
        return true;
    }

    @Override
    public Icon getIconFromDamageForRenderPass(int n, int n2) {
        if (n2 > 0) {
            return this._a;
        }
        return super.getIconFromDamageForRenderPass(n, n2);
    }

    @Override
    public boolean onItemUse(ItemStack itemStack, EntityPlayer entityPlayer, World world, int n, int n2, int n3, int n4, float f, float f2, float f3) {
        Entity entity;
        if (world.isRemote) {
            return true;
        }
        int n5 = world.getBlockId(n, n2, n3);
        n += owak._b[n4];
        n2 += owak._c[n4];
        n3 += owak._d[n4];
        double d = 0.0;
        if (n4 == 1 && Block.blocksList[n5] != null && Block.blocksList[n5].getRenderType() == 11) {
            d = 0.5;
        }
        if ((entity = ItemMonsterPlacer._a(world, itemStack._j(), (double)n + 0.5, (double)n2 + d, (double)n3 + 0.5)) != null) {
            if (entity instanceof EntityLivingBase && itemStack._u()) {
                ((EntityLiving)entity).setCustomNameTag(itemStack._s());
            }
            if (!entityPlayer.capabilities._d) {
                --itemStack._b;
            }
        }
        return true;
    }

    @Override
    public ItemStack onItemRightClick(ItemStack itemStack, World world, EntityPlayer entityPlayer) {
        if (world.isRemote) {
            return itemStack;
        }
        MovingObjectPosition movingObjectPosition = this.getMovingObjectPositionFromPlayer(world, entityPlayer, true);
        if (movingObjectPosition == null) {
            return itemStack;
        }
        if (movingObjectPosition._c == EnumMovingObjectType._a) {
            Entity entity;
            int n = movingObjectPosition._d;
            int n2 = movingObjectPosition._e;
            int n3 = movingObjectPosition._f;
            if (!world.canMineBlock(entityPlayer, n, n2, n3)) {
                return itemStack;
            }
            if (!entityPlayer.canPlayerEdit(n, n2, n3, movingObjectPosition._g, itemStack)) {
                return itemStack;
            }
            if (world.getBlockMaterial(n, n2, n3) == Material._h && (entity = ItemMonsterPlacer._a(world, itemStack._j(), n, n2, n3)) != null) {
                if (entity instanceof EntityLivingBase && itemStack._u()) {
                    ((EntityLiving)entity).setCustomNameTag(itemStack._s());
                }
                if (!entityPlayer.capabilities._d) {
                    --itemStack._b;
                }
            }
        }
        return itemStack;
    }

    public static Entity _a(World world, int n, double d, double d2, double d3) {
        if (!jgro._f.containsKey(n)) {
            return null;
        }
        Entity entity = null;
        for (int i = 0; i < 1; ++i) {
            entity = jgro._a(n, world);
            if (entity == null || !(entity instanceof EntityLivingBase)) continue;
            EntityLiving entityLiving = (EntityLiving)entity;
            entity.setLocationAndAngles(d, d2, d3, sajh._g(world.rand.nextFloat() * 360.0f), 0.0f);
            entityLiving.rotationYawHead = entityLiving.rotationYaw;
            entityLiving.renderYawOffset = entityLiving.rotationYaw;
            entityLiving.onSpawnWithEgg(null);
            world.spawnEntityInWorld(entity);
            entityLiving.playLivingSound();
        }
        return entity;
    }

    @Override
    public void getSubItems(int n, CreativeTabs creativeTabs, List list2) {
        for (zwaw zwaw2 : jgro._f.values()) {
            list2.add(new ItemStack(n, 1, zwaw2._a));
        }
    }

    @Override
    public void registerIcons(IconRegister iconRegister) {
        super.registerIcons(iconRegister);
        this._a = iconRegister._b(this.getIconString() + "_overlay");
    }
}

