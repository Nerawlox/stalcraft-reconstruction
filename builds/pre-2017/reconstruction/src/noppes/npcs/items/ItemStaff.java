/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.items;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.sajh;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;
import noppes.npcs.CustomItems;
import noppes.npcs.CustomNpcs;
import noppes.npcs.entity.EntityMagicProjectile;
import noppes.npcs.entity.EntityProjectile;
import noppes.npcs.items.EnumNpcToolMaterial;
import noppes.npcs.items.ItemNpcInterface;

public class ItemStaff
extends ItemNpcInterface {
    private EnumNpcToolMaterial material;

    public ItemStaff(int n, EnumNpcToolMaterial enumNpcToolMaterial) {
        super(n);
        this.material = enumNpcToolMaterial;
        this.setCreativeTab(CustomItems.tabWeapon);
    }

    @Override
    public void renderSpecial() {
    }

    @Override
    public void onPlayerStoppedUsing(ItemStack itemStack, World world, EntityPlayer entityPlayer, int n) {
        Entity entity;
        if (!world.isRemote && itemStack._e != null && (entity = ((WorldServer)entityPlayer.worldObj).getEntityByID(itemStack._e._f("MagicProjectile"))) != null && entity instanceof EntityProjectile) {
            EntityProjectile entityProjectile = (EntityProjectile)entity;
            entityProjectile.prevRotationYaw = entityProjectile.rotationYaw = entityPlayer.rotationYaw;
            entityProjectile.prevRotationPitch = entityProjectile.rotationPitch = entityPlayer.rotationPitch;
            entityProjectile.shoot(2.0f);
            entityPlayer.worldObj.playSoundAtEntity(entityPlayer, "customnpcs:magic.shot", 1.0f, 1.0f);
        }
    }

    @Override
    public void onUsingItemTick(ItemStack itemStack, EntityPlayer entityPlayer, int n) {
        int n2 = this.getMaxItemUseDuration(itemStack) - n;
        if (entityPlayer.worldObj.isRemote) {
            this.spawnParticle(itemStack, entityPlayer);
        } else {
            double d;
            double d2;
            EntityProjectile entityProjectile;
            int n3 = 20 + this.material.getHarvestLevel() * 8;
            if (n2 == n3) {
                if (!entityPlayer.capabilities._d) {
                    if (!entityPlayer.inventory._d(CustomItems.mana.itemID)) {
                        return;
                    }
                    entityPlayer.inventory._c(CustomItems.mana.itemID);
                }
                entityPlayer.worldObj.playSoundAtEntity(entityPlayer, "customnpcs:magic.charge", 1.0f, 1.0f);
                if (itemStack._e == null) {
                    itemStack._e = new NBTTagCompound();
                }
                int n4 = 6 + this.material.getDamageVsEntity() + entityPlayer.worldObj.rand.nextInt(4);
                entityProjectile = new EntityMagicProjectile(entityPlayer.worldObj, entityPlayer, this.getProjectile(itemStack), false);
                entityProjectile.damage = n4;
                entityProjectile.setSpeed(25);
                d2 = -sajh._a((float)((double)(entityPlayer.rotationYaw / 180.0f) * Math.PI)) * sajh._b((float)((double)(entityPlayer.rotationPitch / 180.0f) * Math.PI));
                d = sajh._b((float)((double)(entityPlayer.rotationYaw / 180.0f) * Math.PI)) * sajh._b((float)((double)(entityPlayer.rotationPitch / 180.0f) * Math.PI));
                entityProjectile.setPosition(entityPlayer.posX + d2 * 0.8, entityPlayer.posY + 1.5 - (double)(entityPlayer.rotationPitch / 40.0f), entityPlayer.posZ + d * 0.8);
                entityPlayer.worldObj.spawnEntityInWorld(entityProjectile);
                itemStack._e._a("MagicProjectile", entityProjectile.entityId);
            }
            if (n2 > n3 && itemStack._e != null) {
                Entity entity = ((WorldServer)entityPlayer.worldObj).getEntityByID(itemStack._e._f("MagicProjectile"));
                if (entity == null || !(entity instanceof EntityProjectile)) {
                    return;
                }
                entityProjectile = (EntityProjectile)entity;
                entityProjectile.ticksInAir = 0;
                d2 = -sajh._a((float)((double)(entityPlayer.rotationYaw / 180.0f) * Math.PI)) * sajh._b((float)((double)(entityPlayer.rotationPitch / 180.0f) * Math.PI));
                d = sajh._b((float)((double)(entityPlayer.rotationYaw / 180.0f) * Math.PI)) * sajh._b((float)((double)(entityPlayer.rotationPitch / 180.0f) * Math.PI));
                entityProjectile.setPosition(entityPlayer.posX + d2 * 0.8, entityPlayer.posY + 1.5 - (double)(entityPlayer.rotationPitch / 40.0f), entityPlayer.posZ + d * 0.8);
            }
        }
    }

    @Override
    public ItemStack onItemRightClick(ItemStack itemStack, World world, EntityPlayer entityPlayer) {
        entityPlayer.setItemInUse(itemStack, this.getMaxItemUseDuration(itemStack));
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

    public ItemStack getProjectile(ItemStack itemStack) {
        return itemStack._a() == CustomItems.staffWood ? new ItemStack(CustomItems.spellNature) : (itemStack._a() == CustomItems.staffStone ? new ItemStack(CustomItems.spellDark) : (itemStack._a() == CustomItems.staffIron ? new ItemStack(CustomItems.spellHoly) : (itemStack._a() == CustomItems.staffBronze ? new ItemStack(CustomItems.spellLightning) : (itemStack._a() == CustomItems.staffGold ? new ItemStack(CustomItems.spellFire) : (itemStack._a() == CustomItems.staffDiamond ? new ItemStack(CustomItems.spellIce) : (itemStack._a() == CustomItems.staffEmerald ? new ItemStack(CustomItems.spellArcane) : new ItemStack(CustomItems.orb, 1, itemStack._j())))))));
    }

    public void spawnParticle(ItemStack itemStack, EntityPlayer entityPlayer) {
        if (itemStack._a() == CustomItems.staffWood) {
            CustomNpcs.proxy.spawnParticle(entityPlayer, "Spell", 5, 2);
            CustomNpcs.proxy.spawnParticle(entityPlayer, "Spell", 12, 2);
        }
        if (itemStack._a() == CustomItems.staffStone) {
            CustomNpcs.proxy.spawnParticle(entityPlayer, "Spell", 5649239, 2);
            CustomNpcs.proxy.spawnParticle(entityPlayer, "Spell", 4400964, 2);
        }
        if (itemStack._a() == CustomItems.staffBronze) {
            CustomNpcs.proxy.spawnParticle(entityPlayer, "Spell", 8648694, 2);
            CustomNpcs.proxy.spawnParticle(entityPlayer, "Spell", 6091007, 2);
        }
        if (itemStack._a() == CustomItems.staffIron) {
            CustomNpcs.proxy.spawnParticle(entityPlayer, "Spell", 0xFCFFC9, 2);
            CustomNpcs.proxy.spawnParticle(entityPlayer, "Spell", 15728535, 2);
        }
        if (itemStack._a() == CustomItems.staffGold) {
            CustomNpcs.proxy.spawnParticle(entityPlayer, "Spell", 1, 2);
            CustomNpcs.proxy.spawnParticle(entityPlayer, "Spell", 14, 2);
        }
        if (itemStack._a() == CustomItems.staffDiamond) {
            CustomNpcs.proxy.spawnParticle(entityPlayer, "Spell", 9756653, 2);
            CustomNpcs.proxy.spawnParticle(entityPlayer, "Spell", 4503295, 2);
        }
        if (itemStack._a() == CustomItems.staffEmerald) {
            CustomNpcs.proxy.spawnParticle(entityPlayer, "Spell", 16761831, 2);
            CustomNpcs.proxy.spawnParticle(entityPlayer, "Spell", 16487167, 2);
        }
    }
}

