/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.entity.monster;

import net.minecraft.entity.monster.EntitySlime;
import net.minecraft.entity.sajz;
import net.minecraft.item.Item;
import net.minecraft.world.World;

public class EntityMagmaCube
extends EntitySlime {
    public EntityMagmaCube(World world) {
        super(world);
        this.isImmuneToFire = true;
    }

    @Override
    public void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(sajz._d)._a(0.2f);
    }

    @Override
    public boolean getCanSpawnHere() {
        return this.worldObj.difficultySetting > 0 && this.worldObj.checkNoEntityCollision(this.boundingBox) && this.worldObj.getCollidingBoundingBoxes(this, this.boundingBox).isEmpty() && !this.worldObj.isAnyLiquid(this.boundingBox);
    }

    @Override
    public int getTotalArmorValue() {
        return this.getSlimeSize() * 3;
    }

    @Override
    public int getBrightnessForRender(float f) {
        return 0xF000F0;
    }

    @Override
    public float getBrightness(float f) {
        return 1.0f;
    }

    @Override
    public String getSlimeParticle() {
        return "flame";
    }

    @Override
    public EntitySlime createInstance() {
        return new EntityMagmaCube(this.worldObj);
    }

    @Override
    public int getDropItemId() {
        return Item.magmaCream.itemID;
    }

    @Override
    public void dropFewItems(boolean bl, int n) {
        int n2 = this.getDropItemId();
        if (n2 > 0 && this.getSlimeSize() > 1) {
            int n3 = this.rand.nextInt(4) - 2;
            if (n > 0) {
                n3 += this.rand.nextInt(n + 1);
            }
            for (int i = 0; i < n3; ++i) {
                this.dropItem(n2, 1);
            }
        }
    }

    @Override
    public boolean isBurning() {
        return false;
    }

    @Override
    public int getJumpDelay() {
        return super.getJumpDelay() * 4;
    }

    @Override
    public void alterSquishAmount() {
        this.squishAmount *= 0.9f;
    }

    @Override
    public void jump() {
        this.motionY = 0.42f + (float)this.getSlimeSize() * 0.1f;
        this.isAirBorne = true;
    }

    @Override
    public void fall(float f) {
    }

    @Override
    public boolean canDamagePlayer() {
        return true;
    }

    @Override
    public int getAttackStrength() {
        return super.getAttackStrength() + 2;
    }

    @Override
    public String getHurtSound() {
        return "mob.slime." + (this.getSlimeSize() > 1 ? "big" : "small");
    }

    @Override
    public String getDeathSound() {
        return "mob.slime." + (this.getSlimeSize() > 1 ? "big" : "small");
    }

    @Override
    public String getJumpSound() {
        if (this.getSlimeSize() > 1) {
            return "mob.magmacube.big";
        }
        return "mob.magmacube.small";
    }

    @Override
    public boolean handleLavaMovement() {
        return false;
    }

    @Override
    public boolean makesSoundOnLand() {
        return true;
    }
}

