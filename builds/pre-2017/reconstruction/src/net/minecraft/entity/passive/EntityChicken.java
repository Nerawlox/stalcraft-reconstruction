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

public class EntityChicken
extends EntityAnimal {
    public float field_70886_e;
    public float destPos;
    public float field_70884_g;
    public float field_70888_h;
    public float field_70889_i = 1.0f;
    public int timeUntilNextEgg;

    public EntityChicken(World world) {
        super(world);
        this.setSize(0.3f, 0.7f);
        this.timeUntilNextEgg = this.rand.nextInt(6000) + 6000;
        this.tasks._a(0, new tdpx(this));
        this.tasks._a(1, new kjwj(this, 1.4));
        this.tasks._a(2, new srli(this, 1.0));
        this.tasks._a(3, new ezhm(this, 1.0, Item.seeds.itemID, false));
        this.tasks._a(4, new ezfc(this, 1.1));
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
        this.getEntityAttribute(sajz._a)._a(4.0);
        this.getEntityAttribute(sajz._d)._a(0.25);
    }

    @Override
    public void onLivingUpdate() {
        super.onLivingUpdate();
        this.field_70888_h = this.field_70886_e;
        this.field_70884_g = this.destPos;
        this.destPos = (float)((double)this.destPos + (double)(this.onGround ? -1 : 4) * 0.3);
        if (this.destPos < 0.0f) {
            this.destPos = 0.0f;
        }
        if (this.destPos > 1.0f) {
            this.destPos = 1.0f;
        }
        if (!this.onGround && this.field_70889_i < 1.0f) {
            this.field_70889_i = 1.0f;
        }
        this.field_70889_i = (float)((double)this.field_70889_i * 0.9);
        if (!this.onGround && this.motionY < 0.0) {
            this.motionY *= 0.6;
        }
        this.field_70886_e += this.field_70889_i * 2.0f;
        if (!this.isChild() && !this.worldObj.isRemote && --this.timeUntilNextEgg <= 0) {
            this.playSound("mob.chicken.plop", 1.0f, (this.rand.nextFloat() - this.rand.nextFloat()) * 0.2f + 1.0f);
            this.dropItem(Item.egg.itemID, 1);
            this.timeUntilNextEgg = this.rand.nextInt(6000) + 6000;
        }
    }

    @Override
    public void fall(float f) {
    }

    @Override
    public String getLivingSound() {
        return "mob.chicken.say";
    }

    @Override
    public String getHurtSound() {
        return "mob.chicken.hurt";
    }

    @Override
    public String getDeathSound() {
        return "mob.chicken.hurt";
    }

    @Override
    public void playStepSound(int n, int n2, int n3, int n4) {
        this.playSound("mob.chicken.step", 0.15f, 1.0f);
    }

    @Override
    public int getDropItemId() {
        return Item.feather.itemID;
    }

    @Override
    public void dropFewItems(boolean bl, int n) {
        int n2 = this.rand.nextInt(3) + this.rand.nextInt(1 + n);
        for (int i = 0; i < n2; ++i) {
            this.dropItem(Item.feather.itemID, 1);
        }
        if (this.isBurning()) {
            this.dropItem(Item.chickenCooked.itemID, 1);
        } else {
            this.dropItem(Item.chickenRaw.itemID, 1);
        }
    }

    public EntityChicken spawnBabyAnimal(EntityAgeable entityAgeable) {
        return new EntityChicken(this.worldObj);
    }

    @Override
    public boolean isBreedingItem(ItemStack itemStack) {
        return itemStack != null && itemStack._a() instanceof dhyk;
    }

    @Override
    public /* synthetic */ EntityAgeable createChild(EntityAgeable entityAgeable) {
        return this.spawnBabyAnimal(entityAgeable);
    }
}

