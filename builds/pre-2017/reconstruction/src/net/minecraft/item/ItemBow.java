/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.item;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.player.ArrowLooseEvent;
import net.minecraftforge.event.entity.player.ArrowNockEvent;

public class ItemBow
extends Item {
    public static final String[] _a = new String[]{"pulling_0", "pulling_1", "pulling_2"};
    @SideOnly(value=Side.CLIENT)
    public Icon[] _b;

    public ItemBow(int n) {
        super(n);
        this.maxStackSize = 1;
        this.setMaxDamage(384);
        this.setCreativeTab(CreativeTabs.tabCombat);
    }

    @Override
    public void onPlayerStoppedUsing(ItemStack itemStack, World world, EntityPlayer entityPlayer, int n) {
        boolean bl;
        int n2 = this.getMaxItemUseDuration(itemStack) - n;
        ArrowLooseEvent arrowLooseEvent = new ArrowLooseEvent(entityPlayer, itemStack, n2);
        MinecraftForge.EVENT_BUS.post(arrowLooseEvent);
        if (arrowLooseEvent.isCanceled()) {
            return;
        }
        n2 = arrowLooseEvent.charge;
        boolean bl2 = bl = entityPlayer.capabilities._d || zhty._a(Enchantment._x._y, itemStack) > 0;
        if (bl || entityPlayer.inventory._d(Item.arrow.itemID)) {
            int n3;
            int n4;
            float f = (float)n2 / 20.0f;
            if ((double)(f = (f * f + f * 2.0f) / 3.0f) < 0.1) {
                return;
            }
            if (f > 1.0f) {
                f = 1.0f;
            }
            EntityArrow entityArrow = new EntityArrow(world, entityPlayer, f * 2.0f);
            if (f == 1.0f) {
                entityArrow.setIsCritical(true);
            }
            if ((n4 = zhty._a(Enchantment._u._y, itemStack)) > 0) {
                entityArrow.setDamage(entityArrow.getDamage() + (double)n4 * 0.5 + 0.5);
            }
            if ((n3 = zhty._a(Enchantment._v._y, itemStack)) > 0) {
                entityArrow.setKnockbackStrength(n3);
            }
            if (zhty._a(Enchantment._w._y, itemStack) > 0) {
                entityArrow.setFire(100);
            }
            itemStack._a(1, (EntityLivingBase)entityPlayer);
            world.playSoundAtEntity(entityPlayer, "random.bow", 1.0f, 1.0f / (itemRand.nextFloat() * 0.4f + 1.2f) + f * 0.5f);
            if (bl) {
                entityArrow.canBePickedUp = 2;
            } else {
                entityPlayer.inventory._c(Item.arrow.itemID);
            }
            if (!world.isRemote) {
                world.spawnEntityInWorld(entityArrow);
            }
        }
    }

    @Override
    public ItemStack onEaten(ItemStack itemStack, World world, EntityPlayer entityPlayer) {
        return itemStack;
    }

    @Override
    public int getMaxItemUseDuration(ItemStack itemStack) {
        return 72000;
    }

    @Override
    public EnumAction getItemUseAction(ItemStack itemStack) {
        return EnumAction._e;
    }

    @Override
    public ItemStack onItemRightClick(ItemStack itemStack, World world, EntityPlayer entityPlayer) {
        ArrowNockEvent arrowNockEvent = new ArrowNockEvent(entityPlayer, itemStack);
        MinecraftForge.EVENT_BUS.post(arrowNockEvent);
        if (arrowNockEvent.isCanceled()) {
            return arrowNockEvent.result;
        }
        if (entityPlayer.capabilities._d || entityPlayer.inventory._d(Item.arrow.itemID)) {
            entityPlayer.setItemInUse(itemStack, this.getMaxItemUseDuration(itemStack));
        }
        return itemStack;
    }

    @Override
    public int getItemEnchantability() {
        return 1;
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public void registerIcons(IconRegister iconRegister) {
        this.itemIcon = iconRegister._b(this.getIconString() + "_standby");
        this._b = new Icon[_a.length];
        for (int i = 0; i < this._b.length; ++i) {
            this._b[i] = iconRegister._b(this.getIconString() + "_" + _a[i]);
        }
    }

    @SideOnly(value=Side.CLIENT)
    public Icon _a(int n) {
        return this._b[n];
    }
}

