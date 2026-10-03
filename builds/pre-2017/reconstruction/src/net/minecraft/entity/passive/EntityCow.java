/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.entity.passive;

import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.ai.ezfc;
import net.minecraft.entity.ai.ezhm;
import net.minecraft.entity.ai.iurn;
import net.minecraft.entity.ai.iurq;
import net.minecraft.entity.ai.kjwj;
import net.minecraft.entity.ai.srli;
import net.minecraft.entity.ai.tdmn;
import net.minecraft.entity.ai.tdpx;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.sajz;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class EntityCow
extends EntityAnimal {
    public EntityCow(World world) {
        super(world);
        this.setSize(0.9f, 1.3f);
        this.getNavigator()._a(true);
        this.tasks._a(0, new tdpx(this));
        this.tasks._a(1, new kjwj(this, 2.0));
        this.tasks._a(2, new srli(this, 1.0));
        this.tasks._a(3, new ezhm(this, 1.25, Item.wheat.itemID, false));
        this.tasks._a(4, new ezfc(this, 1.25));
        this.tasks._a(5, new iurn(this, 1.0));
        this.tasks._a(6, new iurq(this, EntityPlayer.class, 6.0f));
        this.tasks._a(7, new tdmn(this));
    }

    @Override
    public boolean isAIEnabled() {
        return true;
    }

    @Override
    public void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(sajz._a)._a(10.0);
        this.getEntityAttribute(sajz._d)._a(0.2f);
    }

    @Override
    public String getLivingSound() {
        return "mob.cow.say";
    }

    @Override
    public String getHurtSound() {
        return "mob.cow.hurt";
    }

    @Override
    public String getDeathSound() {
        return "mob.cow.hurt";
    }

    @Override
    public void playStepSound(int n, int n2, int n3, int n4) {
        this.playSound("mob.cow.step", 0.15f, 1.0f);
    }

    @Override
    public float getSoundVolume() {
        return 0.4f;
    }

    @Override
    public int getDropItemId() {
        return Item.leather.itemID;
    }

    @Override
    public void dropFewItems(boolean bl, int n) {
        int n2;
        int n3 = this.rand.nextInt(3) + this.rand.nextInt(1 + n);
        for (n2 = 0; n2 < n3; ++n2) {
            this.dropItem(Item.leather.itemID, 1);
        }
        n3 = this.rand.nextInt(3) + 1 + this.rand.nextInt(1 + n);
        for (n2 = 0; n2 < n3; ++n2) {
            if (this.isBurning()) {
                this.dropItem(Item.beefCooked.itemID, 1);
                continue;
            }
            this.dropItem(Item.beefRaw.itemID, 1);
        }
    }

    @Override
    public boolean interact(EntityPlayer entityPlayer) {
        ItemStack itemStack = entityPlayer.inventory._a();
        if (itemStack != null && itemStack._d == Item.bucketEmpty.itemID && !entityPlayer.capabilities._d) {
            if (itemStack._b-- == 1) {
                entityPlayer.inventory.setInventorySlotContents(entityPlayer.inventory._c, new ItemStack(Item.bucketMilk));
            } else if (!entityPlayer.inventory._c(new ItemStack(Item.bucketMilk))) {
                entityPlayer.dropPlayerItem(new ItemStack(Item.bucketMilk.itemID, 1, 0));
            }
            return true;
        }
        return super.interact(entityPlayer);
    }

    public EntityCow spawnBabyAnimal(EntityAgeable entityAgeable) {
        return new EntityCow(this.worldObj);
    }

    @Override
    public /* synthetic */ EntityAgeable createChild(EntityAgeable entityAgeable) {
        return this.spawnBabyAnimal(entityAgeable);
    }
}

