/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.items;

import net.minecraft.block.Block;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import noppes.npcs.CustomItems;
import noppes.npcs.constants.EnumParticleType;
import noppes.npcs.entity.EntityProjectile;
import noppes.npcs.items.ItemNpcInterface;
import org.lwjgl.opengl.GL11;

public class ItemSlingshot
extends ItemNpcInterface {
    public ItemSlingshot(int n) {
        super(n);
        this.maxStackSize = 1;
        this.setMaxDamage(384);
        this.setCreativeTab(CustomItems.tabWeapon);
    }

    @Override
    public void onPlayerStoppedUsing(ItemStack itemStack, World world, EntityPlayer entityPlayer, int n) {
        int n2;
        if (!world.isRemote && (n2 = this.getMaxItemUseDuration(itemStack) - n) >= 6 && (entityPlayer.capabilities._d || entityPlayer.inventory._c(Block.cobblestone.blockID))) {
            itemStack._a(1, (EntityLivingBase)entityPlayer);
            EntityProjectile entityProjectile = new EntityProjectile(world, entityPlayer, new ItemStack(Block.cobblestone), false);
            entityProjectile.damage = 3.0f;
            entityProjectile.punch = 1;
            entityProjectile.setRotating(true);
            if (n2 > 24) {
                entityProjectile.setParticleEffect(EnumParticleType.Crit);
                entityProjectile.punch = 2;
            }
            entityProjectile.setHasGravity(true);
            entityProjectile.setSpeed(14);
            entityProjectile.shoot(1.0f);
            world.playSoundAtEntity(entityPlayer, "random.bow", 1.0f, Item.itemRand.nextFloat() * 0.3f + 0.8f);
            world.spawnEntityInWorld(entityProjectile);
        }
    }

    @Override
    public void renderSpecial() {
        GL11.glRotatef(90.0f, 0.0f, 1.0f, 0.0f);
        GL11.glScalef(0.5f, 0.5f, 0.5f);
        GL11.glTranslatef(0.0f, 0.3f, 0.0f);
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
}

